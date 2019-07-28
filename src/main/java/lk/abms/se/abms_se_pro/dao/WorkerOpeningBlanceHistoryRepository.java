package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.WorkerOpeningBlanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WorkerOpeningBlanceHistoryRepository extends JpaRepository<WorkerOpeningBlanceHistory,String> {

    WorkerOpeningBlanceHistory findByWorkerId(String id);
    WorkerOpeningBlanceHistory findByWorkerIdAndAndDateOfObBetween(String id,Date s, Date e);
    WorkerOpeningBlanceHistory findByWorkerIdAndDateOfOb(SiteRepository id,Date s);
}
