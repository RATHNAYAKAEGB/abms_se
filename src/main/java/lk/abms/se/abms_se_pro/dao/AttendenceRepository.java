package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament;
import lk.abms.se.abms_se_pro.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AttendenceRepository extends JpaRepository<Attendence,String> {
    List<Attendence> findAllByWorkerIdAndADateBetween(Worker worker, Date s, Date e);
    Attendence findAllByWorkerIdAndADate(String eId, Date s);
    Attendence findAllByWorkerId(String eId);

    @Query("SELECT  new lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament (w.workerId,w.fullName,c.cat_Name,s.sitName,a.aDate,a.inTime,a.outTime,a.nofHours,a.advanceAmount,v.nomalHours,v.nomalRate,v.otReate,v.bonuseReate,v.name ) FROM  Attendence a " +
            " LEFT JOIN Worker as w on w.workerId =a.workerId" +
            " left join WorkerCategory as c on c.catId =w.wc_Id " +
            "left join PaymentVariable as v on v.categoryId =w.wc_Id " +
            "left join  Site as s on s.siteId =a.siteId" +
            " where a.isPaid =false and a.aDate between ?1 and ?2")
    List<CustomEntityPayament> searchAllAttendece(Date s , Date e);


    @Query("SELECT  new lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament (w.workerId,w.fullName,c.cat_Name,s.sitName,a.aDate,a.inTime,a.outTime,a.nofHours,a.advanceAmount,v.nomalHours,v.nomalRate,v.otReate,v.bonuseReate,v.name ) FROM  Attendence a " +
            " LEFT JOIN Worker as w on w.workerId =a.workerId" +
            " left join WorkerCategory as c on c.catId =w.wc_Id " +
            "left join PaymentVariable as v on v.categoryId =w.wc_Id " +
            "left join  Site as s on s.siteId =a.siteId" +
            " where a.isPaid =false and a.aDate between ?1 and ?2 and w.workerId=?3")
    List<CustomEntityPayament> searchAllAttendece(Date s , Date e,String workerId);


    @Query("SELECT  new lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament (w.workerId,w.fullName,c.cat_Name,s.sitName,a.aDate,a.inTime,a.outTime,a.nofHours,a.advanceAmount,v.nomalHours,v.nomalRate,v.otReate,v.bonuseReate,v.name ) FROM  Attendence a " +
            " LEFT JOIN Worker as w on w.workerId =a.workerId" +
            " left join WorkerCategory as c on c.catId =w.wc_Id " +
            "left join PaymentVariable as v on v.categoryId =w.wc_Id " +
            "left join  Site as s on s.siteId =a.siteId" +
            " where a.isPaid =true and a.aDate between ?1 and ?2 and w.workerId=?3")
    List<CustomEntityPayament> searchAllAttendeceOld(Date s , Date e,String workerId);


    @Query("SELECT  new lk.abms.se.abms_se_pro.entity.custom.CustomEntityPayament (w.workerId,w.fullName,c.cat_Name,s.sitName,a.aDate,a.inTime,a.outTime,a.nofHours,a.advanceAmount,v.nomalHours,v.nomalRate,v.otReate,v.bonuseReate,v.name ) FROM  Attendence a " +
            " LEFT JOIN Worker as w on w.workerId =a.workerId" +
            " left join WorkerCategory as c on c.catId =w.wc_Id " +
            "left join PaymentVariable as v on v.categoryId =w.wc_Id " +
            "left join  Site as s on s.siteId =a.siteId" +
            " where a.isPaid =true and a.aDate between ?1 and ?2")
    List<CustomEntityPayament> searchAllAttendeceOld(Date s , Date e);

}


