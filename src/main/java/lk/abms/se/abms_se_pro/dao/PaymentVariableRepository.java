package lk.abms.se.abms_se_pro.dao;

import lk.abms.se.abms_se_pro.entity.PaymentVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentVariableRepository extends JpaRepository<PaymentVariable,String> {

    PaymentVariable findBySvID(String sv);
}
