package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.controller.FixVariableController;
import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.EmployeeCatagoryRepository;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class WorkerManageService {

    @Autowired
    private EmployeeCatagoryRepository employeeCatagoryRepository;
    @Autowired
    private WorkerRepository workerRepository;

    private static final Logger logger = LogManager.getLogger(FixVariableController.class);

    public WorkerManageService() {
        logger.info("--- WorkerManageService ----");
    }

    public void createWorker(WorkerDTO dto) throws Exception {
        Worker entity = ConverterDTO_ENTITY.getEntity(dto);
        entity.setWc_Id(employeeCatagoryRepository.findByCatId(dto.getCat_Id()));
        workerRepository.save(entity);
    }

    public void updateWorker(WorkerDTO dto) throws Exception {
        Worker w = workerRepository.findAllByWorkerId(dto.getWorkerId());
        w.setWc_Id(employeeCatagoryRepository.findByCatId(dto.getCat_Id()));
        w.setAddress(dto.getAddress());
        w.setFirstName(dto.getFirstName());
        w.setFullName(dto.getFullName());
        w.setImg(dto.getImg());w.setNic(dto.getNic());w.setMobile(dto.getMobile());w.setWorkerId(dto.getWorkerId());
    }

    public List<WorkerDTO> findAllWorkers() throws Exception {
        return ConverterDTO_ENTITY.getDTOList(workerRepository.findAll());
    }

    public void deleteWorker(String catId) throws Exception {
        workerRepository.delete(workerRepository.findAllByWorkerId(catId.trim()));
    }
}
