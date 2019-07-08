package lk.abms.se.abms_se_pro.dao;


import lk.abms.se.abms_se_pro.entity.WorkersAttendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkersAttendenceRepository extends JpaRepository<WorkersAttendence,String> {
    WorkersAttendence findByWorkerId(String nic);
    List<WorkersAttendence>findByWorkerIdAndWorikingDayBetween(String nic, Date sDate, Date eDate);
}
