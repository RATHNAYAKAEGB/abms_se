package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site,String> {
    Site findAllBySiteId(String id);
}
