package lk.abms.se.abms_se_pro.bussiness;

import lk.abms.se.abms_se_pro.converter.ConverterDTO_ENTITY;
import lk.abms.se.abms_se_pro.dao.EmployeeCatagoryRepository;
import lk.abms.se.abms_se_pro.entity.WorkerCategory;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerCategoryManagementService {
    @Autowired
    EmployeeCatagoryRepository employeeCatagoryRepository;



    public void CreateNewEmpCategory(WorkerCategoryDTO category) throws Exception{
        employeeCatagoryRepository.save(ConverterDTO_ENTITY.getEntity(category));
    }

    public void UpdateEmpCategory(WorkerCategory category) throws Exception{
        WorkerCategory cat = employeeCatagoryRepository.findByEmpCatId(category.getEmpCatId());
        cat.setCreateBy(category.getCreateBy());
        cat.setName(category.getName());
    }
    public List<WorkerCategory> findAllEmpCategory() throws Exception{
        return employeeCatagoryRepository.findAll();
    }

    public void deleteCategory(String catId) throws Exception{
        employeeCatagoryRepository.delete(employeeCatagoryRepository.findByEmpCatId(catId));
    }

}
