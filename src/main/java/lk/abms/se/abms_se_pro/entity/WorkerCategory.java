package lk.abms.se.abms_se_pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkerCategory implements SuperEntity {
    @Id
    private String catId;
    @Column(length = 40,unique = true)
    private String cat_Name;
    @Column(length = 20)
    private String salaryType;
    @Column(length = 100)
    private String description;
    private boolean isACtive;
    private String createdBy;

    public WorkerCategory() {
    }

    public WorkerCategory(String cat_Id, String cat_Name, String salaryType, String description, boolean isACtive, String createdBy) {
        this.setCatId(cat_Id);
        this.setCat_Name(cat_Name);
        this.setSalaryType(salaryType);
        this.setDescription(description);
        this.setACtive(isACtive);
        this.setCreatedBy(createdBy);
    }


    public String getCatId() {
        return catId;
    }

    public void setCatId(String cat_Id) {
        this.catId = cat_Id;
    }

    public String getCat_Name() {
        return cat_Name;
    }

    public void setCat_Name(String cat_Name) {
        this.cat_Name = cat_Name;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isACtive() {
        return isACtive;
    }

    public void setACtive(boolean ACtive) {
        isACtive = ACtive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "WorkerCategory{" +
                "cat_Id='" + catId + '\'' +
                ", cat_Name='" + cat_Name + '\'' +
                ", salaryType='" + salaryType + '\'' +
                ", description='" + description + '\'' +
                ", isACtive=" + isACtive +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
