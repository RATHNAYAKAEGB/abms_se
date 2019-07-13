package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.EmployeeCatagoryRepository;
import lk.abms.se.abms_se_pro.dao.WorkerRepository;
import lk.abms.se.abms_se_pro.entity.WorkerCategory;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkerCategoryManagementService {
    @Autowired
    private EmployeeCatagoryRepository employeeCatagoryRepository;

    @Autowired
    private WorkerRepository workerRepository;

    public WorkerCategoryManagementService() {
        System.out.println("------------------WorkerCategoryManagementService-----------------------");
    }

    public void CreateNewEmpCategory(WorkerCategoryDTO category) throws Exception{
        employeeCatagoryRepository.save(ConverterDTO_ENTITY.getEntity(category));
    }

    public void UpdateEmpCategory(WorkerCategoryDTO category) throws Exception{
        WorkerCategory cat = employeeCatagoryRepository.findByCatId(category.getCat_Id());
        cat.setCreatedBy(category.getCreatedBy());
        cat.setCat_Name(category.getCat_Name());
        cat.setACtive(category.isACtive());
        cat.setSalaryType(category.getSalaryType());
    }
    public List<WorkerCategoryDTO> findAllEmpCategory() throws Exception{
        return ConverterDTO_ENTITY.getDTOList( employeeCatagoryRepository.findAll());
    }

    public void deleteCategory(String catId) throws Exception{
        employeeCatagoryRepository.delete(employeeCatagoryRepository.findByCatId(catId.trim()));
    }

}
