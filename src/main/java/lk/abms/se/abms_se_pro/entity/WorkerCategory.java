package lk.abms.se.abms_se_pro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkerCategory implements SuperEntity{
    @Id
    private String empCatId;
    private String name;
    private String createBy;

    public WorkerCategory() {
    }

    public WorkerCategory(String empCatId, String name, String createBy) {
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
