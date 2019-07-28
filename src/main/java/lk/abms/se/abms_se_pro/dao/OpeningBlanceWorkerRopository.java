package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.OpeningBlanceWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningBlanceWorkerRopository extends JpaRepository<OpeningBlanceWorker,String> {
    OpeningBlanceWorker findByWorkerId(String workerId);

}
