package lk.abms.se.abms_se_pro.model;

public class WorkerCategoryDTO implements SuperDTO {

    private String cat_Id;
    private String cat_Name;
    private String salaryType;
    private String description;
    private boolean isACtive;
    private String createdBy;

    public WorkerCategoryDTO() {
    }

    public WorkerCategoryDTO(String cat_Id, String cat_Name, String salaryType, String description, boolean isACtive, String createdBy) {
        this.setCat_Id(cat_Id);
        this.setCat_Name(cat_Name);
        this.setSalaryType(salaryType);
        this.setDescription(description);
        this.setACtive(isACtive);
        this.setCreatedBy(createdBy);
    }


    public String getCat_Id() {
        return cat_Id;
    }

    public void setCat_Id(String cat_Id) {
        this.cat_Id = cat_Id;
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
                "cat_Id='" + cat_Id + '\'' +
                ", cat_Name='" + cat_Name + '\'' +
                ", salaryType='" + salaryType + '\'' +
                ", description='" + description + '\'' +
                ", isACtive=" + isACtive +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
