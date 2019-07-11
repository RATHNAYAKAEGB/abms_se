package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.WorkerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCatagoryRepository extends JpaRepository<WorkerCategory,String> {

    WorkerCategory findByCatId(String catId);
}
