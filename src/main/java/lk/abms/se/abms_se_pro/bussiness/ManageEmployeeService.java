package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.dao.EmployeeRepository;
import lk.abms.se.abms_se_pro.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManageEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void CreateNewEmployee(Worker worker) throws Exception{
        employeeRepository.save(worker);
    }

    public void UpdateEmployee(Worker worker) throws Exception{
        Worker w = employeeRepository.findByNic(worker.getNic());
        w.setAddress(worker.getAddress());
        w.setCtratedBy(worker.getCtratedBy());
        w.setName(worker.getName());
        w.setRegDate(worker.getRegDate());
        w.setNic(worker.getNic());
        w.setPhone(worker.getPhone());
        w.setEmpCateId(w.getEmpCateId());
    }
    public List<Worker> findAll() throws Exception{
        return employeeRepository.findAll();
    }

    public void deleteCategory(String nic) throws Exception{
        employeeRepository.delete(employeeRepository.findByNic(nic));
    }

    public void deActiveAcccoutnt(String nic) throws Exception {
        Worker worker = employeeRepository.findByNic(nic);
        worker.setActive(false);
    }
    public void ActiveAcccoutnt(String nic) throws Exception {
        Worker worker = employeeRepository.findByNic(nic);
        worker.setActive(true);
    }

}
