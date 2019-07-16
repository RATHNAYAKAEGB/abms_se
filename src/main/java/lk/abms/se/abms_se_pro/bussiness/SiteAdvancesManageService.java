package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.controller.FixVariableController;
import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.dao.AttendenceRepository;
import lk.abms.se.abms_se_pro.dao.SiteAdvancessRepository;
import lk.abms.se.abms_se_pro.dao.SiteRepository;
import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.SiteAdvances;
import lk.abms.se.abms_se_pro.entity.SuperEntity;
import lk.abms.se.abms_se_pro.model.AttendenceDTO;
import lk.abms.se.abms_se_pro.model.SiteAdvancesDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Component
public class SiteAdvancesManageService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private AttendenceRepository attendenceRepository;
    @Autowired
    private SiteAdvancessRepository siteAdvancessRepository;

    private static final Logger logger = LogManager.getLogger(FixVariableController.class);

    public SiteAdvancesManageService() {
        logger.info("--- SiteAdvancesManageService ----");
    }

    public void saveSiteAdvances(SiteAdvancesDTO dto) throws Exception {
        SiteAdvances entity = ConverterDTO_ENTITY.getEntity(dto);
        entity.setSite_Id(siteRepository.findAllBySiteId(dto.getSit_Id()));
        siteAdvancessRepository.save(entity);
    }

    public void updateSiteAdvances(SiteAdvancesDTO dto) throws Exception {
        SiteAdvances pay = siteAdvancessRepository.findByPaymentId(dto.getPaymentId());
        pay.setSite_Id(siteRepository.findAllBySiteId(dto.getSit_Id()));
        pay.setAmount(dto.getAmount());
        pay.setIssueDate(dto.getIssueDate());
        pay.setDescription(dto.getDescription());
        pay.setCheckNumber(dto.getCheckNumber());
        pay.setPayamentType(dto.getPayamentType());

    }

    public List<SiteAdvancesDTO> findAllSiteAdvances() throws Exception {
        return ConverterDTO_ENTITY.getDTOList(siteAdvancessRepository.findAll());
    }

//    public List<SiteAdvancesDTO> findAllMonthlySiteAdvances(LocalDate s, LocalDate e) throws Exception {
//        return ConverterDTO_ENTITY.getDTOList(siteAdvancessRepository.findAllByIssueDateBetween(s,e));
//    }
//
//    public List<SiteAdvancesDTO> findAllSite_forSpecificSit(String id, LocalDate s, LocalDate e) throws Exception {
//        return ConverterDTO_ENTITY.getDTOList(siteAdvancessRepository.findAllBySite_IdAndIssueDateBetween(id,s,e));
//    }


    public void deleteSiteAdvance(String siteId) throws Exception {
        siteAdvancessRepository.delete((siteAdvancessRepository.findByPaymentId(siteId)));
    }

}
