package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.EmployeeCatagoryRepository;
import lk.abms.se.abms_se_pro.dao.PaymentVariableRepository;
import lk.abms.se.abms_se_pro.entity.PaymentVariable;
import lk.abms.se.abms_se_pro.model.PaymentVariableDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PaymentVariableManagementService {
    @Autowired
    private PaymentVariableRepository paymentVariableRepository;
    @Autowired
    private EmployeeCatagoryRepository employeeCatagoryRepository;

    private static final Logger logger = LogManager.getLogger(PaymentVariableManagementService.class);


    public PaymentVariableManagementService() {
        logger.info(" PaymentVariableManagementService +__+-------------------------");
    }

    public void CreatePaymentVariable(PaymentVariableDTO dto) throws Exception {
        PaymentVariable entity = ConverterDTO_ENTITY.getEntity(dto);
        entity.setCategoryId(employeeCatagoryRepository.findByCatId(dto.getWorkerCateNo()));
        paymentVariableRepository.save(entity);
    }

    public void UpdatePaymentVariable(PaymentVariableDTO dto) throws Exception {
        PaymentVariable pv = paymentVariableRepository.findBySvID(dto.getSvID());
        pv.setBonuseReate(dto.getBonuseReate());
        pv.setCategoryId(employeeCatagoryRepository.findByCatId(dto.getWorkerCateNo()));
        pv.setName(dto.getName());
        pv.setBonuseReate(dto.getBonuseReate());
        pv.setNomalRate(dto.getNomalRate());
        pv.setOtReate(pv.getOtReate());
        pv.setDescription(dto.getDescription());
    }

    public List<PaymentVariableDTO> findAllPaymentVariable() throws Exception {
        System.out.println(paymentVariableRepository.findAll());
        return ConverterDTO_ENTITY.getDTOList(paymentVariableRepository.findAll());
    }

    public void deletePaymentVariable(String catId) throws Exception {
        paymentVariableRepository.delete(paymentVariableRepository.findBySvID(catId.trim()));
    }


}
