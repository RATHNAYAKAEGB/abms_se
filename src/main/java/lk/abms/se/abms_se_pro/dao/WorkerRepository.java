package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Worker ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,String> {
    Worker findByWorkerId(String id);
    Worker findByNic(String nic);
}
