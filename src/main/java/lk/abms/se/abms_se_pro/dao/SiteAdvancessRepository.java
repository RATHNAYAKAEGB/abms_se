package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Site;
import lk.abms.se.abms_se_pro.entity.SiteAdvances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SiteAdvancessRepository extends JpaRepository<SiteAdvances,String> {

    SiteAdvances findByPaymentId(String paymentId);
    List<SiteAdvances> findAllByIssueDateBetween(LocalDate s,LocalDate e);
//    List<SiteAdvances>findAllBySite_IdAndIssueDateBetween(String id, LocalDate s, LocalDate e);

}
