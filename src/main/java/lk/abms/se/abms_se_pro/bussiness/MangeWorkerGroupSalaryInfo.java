package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.dao.WorkerGroupSalaryInfoRopository;
import lk.abms.se.abms_se_pro.entity.WorkerGroupSalaryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MangeWorkerGroupSalaryInfo {

    @Autowired
    WorkerGroupSalaryInfoRopository workerGroupSalaryInfoRopository;

    public void CreateWorkerGroupSalary(WorkerGroupSalaryInfo info) throws Exception {
        workerGroupSalaryInfoRopository.save(info);
    }

    public void UpdateEmployee(WorkerGroupSalaryInfo info) throws Exception {
        WorkerGroupSalaryInfo w = workerGroupSalaryInfoRopository.findById(info.getId()).get();
        w.setBonuse(info.getBonuse());
        w.setCreateBy(info.getCreateBy());
        w.setName(info.getName());
        w.setNomarHoursPayment(info.getNomarHoursPayment());
        w.setOtyPayment(info.getOtyPayment());

    }

    public List<WorkerGroupSalaryInfo> findAll() throws Exception {
        return workerGroupSalaryInfoRopository.findAll();
    }

    public void deleteCategory(String nic) throws Exception {
        workerGroupSalaryInfoRopository.delete(workerGroupSalaryInfoRopository.findById(nic).get());
    }

//    public void deActiveAcccoutnt(String nic) throws Exception {
//        Worker worker = workerGroupSalaryInfoRopository.findByNic(nic);
//        worker.setActive(false);
//    }
//    public void ActiveAcccoutnt(String nic) throws Exception {
//        Worker worker = workerGroupSalaryInfoRopository.findByNic(nic);
//        worker.setActive(true);
//    }


}
