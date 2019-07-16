package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.Main_AccountRepository;
import lk.abms.se.abms_se_pro.dao.Sub_AccountsRepository;
import lk.abms.se.abms_se_pro.entity.Sub_Account;
import lk.abms.se.abms_se_pro.model.Sub_AccountsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class SubAccountManageService {
    @Autowired
    private Sub_AccountsRepository sub_accountsRepository;
    @Autowired
    private Main_AccountRepository main_accountRepository;


    public void saveSubAccount(Sub_AccountsDTO dto)throws Exception {
        Sub_Account entity = ConverterDTO_ENTITY.getEntity(dto);
        entity.setMain_accountId(main_accountRepository.findByAt_Id(dto.getSubAccountId()));
        sub_accountsRepository.save(entity);
    }

    public void updateSubAccount(Sub_AccountsDTO dto)throws Exception  {
        Sub_Account subAccounts = sub_accountsRepository.findBySubAccountId(dto.getSubAccountId());
        subAccounts.setDescription(dto.getDescription());
        subAccounts.setName(dto.getName());
        subAccounts.setMain_accountId(main_accountRepository.findByAt_Id(dto.getMain_accountId()));
    }

    public Sub_AccountsDTO findSubAccount(String id)throws Exception {
        return ConverterDTO_ENTITY.getDTO(sub_accountsRepository.findBySubAccountId(id));
    }

    public List<Sub_AccountsDTO> findAllAccounts()throws Exception {

        return ConverterDTO_ENTITY.getDTOList(sub_accountsRepository.findAll());
    }

}
