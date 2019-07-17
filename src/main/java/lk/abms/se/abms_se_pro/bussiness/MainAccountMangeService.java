package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.Main_AccountRepository;
import lk.abms.se.abms_se_pro.entity.Main_Account;
import lk.abms.se.abms_se_pro.entity.Sub_Account;
import lk.abms.se.abms_se_pro.model.Main_AccountDTO;
import lk.abms.se.abms_se_pro.model.Sub_AccountsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MainAccountMangeService {
    @Autowired
    private Main_AccountRepository main_accountRepository;


    public void saveMainAccount(Main_AccountDTO dto)throws Exception {
        main_accountRepository.save(ConverterDTO_ENTITY.getEntity(dto));
    }

    public void updateMainAccount(Main_AccountDTO dto)throws Exception  {
        Main_Account ma= main_accountRepository.findByAtId(dto.getAt_Id());
        ma.setAccountName(dto.getAccountName());
        ma.setDescription(ma.getDescription());
    }

    public Main_AccountDTO findMainAccount(String id)throws Exception {
        return ConverterDTO_ENTITY.getDTO(main_accountRepository.findByAtId(id));
    }

    public List<Main_AccountDTO> findAllMainAccounts()throws Exception {

        return ConverterDTO_ENTITY.getDTOList(main_accountRepository.findAll());
    }
}
