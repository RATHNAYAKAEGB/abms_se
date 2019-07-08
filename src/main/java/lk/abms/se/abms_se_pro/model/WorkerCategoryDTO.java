package lk.abms.se.abms_se_pro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkerCategoryDTO implements SuperDTO{
    @Id
    private String empCatId;
    private String name;
    private String createBy;

    public WorkerCategoryDTO() {
    }

    public WorkerCategoryDTO(String empCatId, String name, String createBy) {
        setEmpCatId(empCatId);
        this.setName(name);
        this.setCreateBy(createBy);
    }


    public String getEmpCatId() {
        return empCatId;
    }

    public void setEmpCatId(String empCatId) {
        this.empCatId = empCatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "WorkerCategory{" +
                "empCatId='" + empCatId + '\'' +
                ", name='" + name + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
