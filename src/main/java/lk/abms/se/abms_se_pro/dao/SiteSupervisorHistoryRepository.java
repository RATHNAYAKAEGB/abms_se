package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.SiteSupervisorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteSupervisorHistoryRepository extends JpaRepository<SiteSupervisorHistory,String> {

    SiteSupervisorHistory findAllBySiteIdAndStatus(String id,boolean v);
}
