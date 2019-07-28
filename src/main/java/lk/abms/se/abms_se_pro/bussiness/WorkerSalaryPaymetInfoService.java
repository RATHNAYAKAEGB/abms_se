package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.AttendenceRepository;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.dao.WorkerSalaryPaymetInfoRepository;
import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.SuperEntity;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.entity.WorkerSalaryPaymetInfo;
import lk.abms.se.abms_se_pro.model.WorkerSalaryPaymetInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkerSalaryPaymetInfoService {
    @Autowired
    private WorkerSalaryPaymetInfoRepository workerSalaryPaymetInfoRepository;

    @Autowired
    private AttendenceRepository attendenceRepository;
    @Autowired
    WorkerRepository workerRepository;


    public void save(List<WorkerSalaryPaymetInfoDTO> listDto) {

        for (WorkerSalaryPaymetInfoDTO dto:listDto) {
            Attendence attendence = attendenceRepository.findByWorkerIdAndADate(workerRepository.findByWorkerId(dto.getWorkerId()), dto.getAtDate());
            WorkerSalaryPaymetInfo entity = ConverterDTO_ENTITY.getEntity(dto);
            entity.setAttendenceId(attendence);
            if(dto.getNetPay()<0){
                Worker worker = workerRepository.findByWorkerId(dto.getWorkerId());
                worker.setOpenBlance(dto.getOpenBlance());
            }
            attendence.setPaid(true);
            workerSalaryPaymetInfoRepository.save(entity);
        }


    }

}
