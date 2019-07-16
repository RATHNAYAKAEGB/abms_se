package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.Sub_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sub_AccountsRepository extends JpaRepository<Sub_Account,String> {

    Sub_Account findBySubAccountId(String subid);
}
