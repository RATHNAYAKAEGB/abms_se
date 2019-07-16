package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Main_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Main_AccountRepository extends JpaRepository<Main_Account,String> {
    Main_Account findByAt_Id(String id);
}
