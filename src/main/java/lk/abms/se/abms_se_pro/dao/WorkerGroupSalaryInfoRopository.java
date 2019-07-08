package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.WorkerGroupSalaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerGroupSalaryInfoRopository extends JpaRepository<WorkerGroupSalaryInfo,String> {
    Optional<WorkerGroupSalaryInfo> findById(String id);
}
