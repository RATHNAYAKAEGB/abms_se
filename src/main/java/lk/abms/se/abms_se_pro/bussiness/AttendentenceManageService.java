package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.controller.FixVariableController;
import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.dao.AttendenceRepository;
import lk.abms.se.abms_se_pro.dao.SiteRepository;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.model.AttendenceDTO;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class AttendentenceManageService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private AttendenceRepository attendenceRepository;

    private static final Logger logger = LogManager.getLogger(FixVariableController.class);

    public AttendentenceManageService() {
        logger.info("--- AttendentenceManageService ----");
    }

    public void createAttendence(List<AttendenceDTO> dtos) throws Exception {

        for (AttendenceDTO dto:dtos) {
            Attendence entity = ConverterDTO_ENTITY.getEntity(dto);
            entity.setWorkerId(workerRepository.findByWorkerId(dto.getWorkerId()));
            entity.setSiteId(siteRepository.findAllBySiteId(dto.getSiteNumber()));
            attendenceRepository.save(entity);
        }
    }

    public void updateAttendence(AttendenceDTO dto) throws Exception {
        Attendence a = attendenceRepository.findAllByWorkerIdAndADate(dto.getWorkerId(), DateForMatter.getFortmatteredDate( dto.getAtDate()));
        a.setSiteId(siteRepository.findAllBySiteId(dto.getSiteNumber()));
        a.setSiteId(siteRepository.findAllBySiteId(dto.getSiteNumber()));
        a.setInTime(dto.getInTime());
        a.setOutTime(dto.getOutTime());
        a.setAdvanceAmount(dto.getAdvanceAmount());
        a.setNofHours(a.getNofHours());

    }

    public List<AttendenceDTO> findAllAttendence() throws Exception {
        return ConverterDTO_ENTITY.getDTOList(workerRepository.findAll());
    }

    public List<AttendenceDTO> findAllMonthlyOneEmpAttendence(String workerId, Date s, Date e) throws Exception {
        return ConverterDTO_ENTITY.getDTOList(attendenceRepository.findAllByWorkerIdAndADateBetween(workerRepository.findByWorkerId(workerId),s,e));
    }


    public void deleteAttendence(String catId, Date s) throws Exception {
        attendenceRepository.delete(attendenceRepository.findAllByWorkerIdAndADate(catId,s));
    }

}
