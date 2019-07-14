package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence,String> {
    List<Attendence> findAllByWorkerIdAndADateBetween(Worker worker, Date s, Date e);
    Attendence findAllByWorkerIdAndADate(String eId, Date s);
}
