package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.bussiness.logic.LabourSalaryCalculator;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.dao.AttendenceRepository;
import lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament;
import lk.abms.se.abms_se_pro.model.CustomEntityPayamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LaborPayementManegeService {

    @Autowired
    private AttendenceRepository attendenceRepository;
    @Autowired
    private LabourSalaryCalculator salaryCalculator;

    public LaborPayementManegeService() {

    }

    public List<CustomEntityPayamentDTO> getAllAttendenceForMonth(LocalDate s, LocalDate e) {
        List<CustomEntityPayament> list = attendenceRepository.searchAllAttendece(DateForMatter.getFortmatteredDate(s), DateForMatter.getFortmatteredDate(e));
        return getList(list);
    }


    public List<CustomEntityPayamentDTO> getAllAttendenceForWorkerId(LocalDate s, LocalDate e,String id) {
        List<CustomEntityPayament> list = attendenceRepository.searchAllAttendece(DateForMatter.getFortmatteredDate(s), DateForMatter.getFortmatteredDate(e),id);
        return getList(list);
    }

    public List<CustomEntityPayamentDTO> getAllAttendenceForWorkerIdOld(LocalDate s, LocalDate e,String id) {
        List<CustomEntityPayament> list = attendenceRepository.searchAllAttendeceOld(DateForMatter.getFortmatteredDate(s), DateForMatter.getFortmatteredDate(e),id);
        return getList(list);
    }


    public List<CustomEntityPayamentDTO> getAllAttendenceForMonthOLD(LocalDate s, LocalDate e) {
        List<CustomEntityPayament> list = attendenceRepository.searchAllAttendeceOld(DateForMatter.getFortmatteredDate(s), DateForMatter.getFortmatteredDate(e));
        return getList(list);
    }

    private List<CustomEntityPayamentDTO> getList(List<CustomEntityPayament> list ){
        List<CustomEntityPayamentDTO> listItems = new ArrayList<>();
        for (CustomEntityPayament c : list) {
            double nomalHoursPayment = salaryCalculator.findNomalHoursPayment(c.getWorkedMinits(),c.getNomalHoursRate(),c.getNomalHours());
            double workerOTPayment = salaryCalculator.findWorkerOTPayment(c.getWorkedMinits(),c.getOtRate(),c.getNomalHours());
            double gross = nomalHoursPayment + workerOTPayment;
            listItems.add(new CustomEntityPayamentDTO(c.getWorker_Id(), c.getFullName(), c.getCatName(), c.getSiteName(), c.getAtDate(), c.getInTime(), c.getOutTime(), c.getNumberOfHours(), c.getAdvanceAmmount(), c.getNomalHours(), c.getNomalHoursRate(), c.getOtRate(), c.getBonusRate(), c.getVaribleListName(), nomalHoursPayment, workerOTPayment, gross, gross - c.getAdvanceAmmount(),0));
        }
        return listItems;
    }

}
