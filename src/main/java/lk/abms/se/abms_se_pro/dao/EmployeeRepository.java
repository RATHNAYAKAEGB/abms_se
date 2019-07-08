package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Worker,String> {
    Worker findByNic(String nic) throws Exception;
}
