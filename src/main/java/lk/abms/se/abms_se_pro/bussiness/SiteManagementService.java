package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.SiteRepository;
import lk.abms.se.abms_se_pro.dao.SiteSupervisorHistoryRepository;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.entity.Site;
import lk.abms.se.abms_se_pro.entity.SiteSupervisorHistory;
import lk.abms.se.abms_se_pro.model.SiteDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class SiteManagementService {

    private static final Logger logger = LogManager.getLogger(SiteManagementService.class);
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private SiteSupervisorHistoryRepository siteSupervisorHistoryRepository;

    public SiteManagementService() {
        logger.info("SiteManagementService.....................");
    }

    public void createSite(SiteDTO dto) throws Exception {
        Site entity = ConverterDTO_ENTITY.getEntity(dto);
        entity.setWorkerID(workerRepository.findAllByWorkerId(dto.getSupId()));
        siteRepository.save(entity);

        siteSupervisorHistoryRepository.save(new SiteSupervisorHistory(dto.getRegDate(),null,dto.getSupId(),dto.getSupName(),dto.getSiteId(),dto.getSitName(),true));

    }

    public void updateSite(SiteDTO dto) throws Exception {
        Site s = siteRepository.findAllBySiteId(dto.getSiteId());
        boolean isActive =(dto.getIsActive().equals("IsActive"))? true:false;
        if(!dto.getSupId().equals(s.getWorkerID().getWorkerId())&& isActive){
            SiteSupervisorHistory sh = siteSupervisorHistoryRepository.findAllBySiteIdAndStatus(dto.getSiteId(), true);
            sh.setEndDate(new Date());
            sh.setStatus(false);
            siteSupervisorHistoryRepository.save(new SiteSupervisorHistory(dto.getRegDate(),null,dto.getSupId(),dto.getSupName(),dto.getSiteId(),dto.getSitName(),true));
        }
        if(!isActive){
            SiteSupervisorHistory sh = siteSupervisorHistoryRepository.findAllBySiteIdAndStatus(dto.getSiteId(), true);
            if(null!=sh){
                System.out.println(sh);
                sh.setEndDate(new Date());
                sh.setStatus(false);
            }

        }

        s.setAddress(dto.getAddress());
        s.setRegDate(dto.getRegDate());
        s.setSiteId(dto.getSiteId());
        s.setActive(isActive);
        s.setAddress(dto.getAddress());
        s.setWorkerID(workerRepository.findAllByWorkerId(dto.getSupId()));


    }

    public List<SiteDTO> findAllSite() throws Exception {
        System.out.println("Lala "+siteRepository.findAll());
        return ConverterDTO_ENTITY.getDTOList(siteRepository.findAll());
    }

    public void deleteSite(String catId) throws Exception {
        siteRepository.delete(siteRepository.findAllBySiteId(catId.trim()));
    }

}
