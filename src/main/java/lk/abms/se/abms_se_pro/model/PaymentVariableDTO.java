package lk.abms.se.abms_se_pro.model;

public class PaymentVariableDTO implements SuperDTO {


    private String svID;
    private String name;
    private float nomalRate;
    private float otReate;
    private float bonuseReate;
    private String description;
    private String workerCateNo;
    private String catName;

    public PaymentVariableDTO() {
    }

    public PaymentVariableDTO(String svID, String name, float nomalRate, float otReate, float bonuseReate, String description, String workerCateNo, String catName) {
        this.svID = svID;
        this.name = name;
        this.nomalRate = nomalRate;
        this.otReate = otReate;
        this.bonuseReate = bonuseReate;
        this.description = description;
        this.workerCateNo = workerCateNo;
        this.catName = catName;
    }

    public String getSvID() {
        return svID;
    }

    public void setSvID(String svID) {
        this.svID = svID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNomalRate() {
        return nomalRate;
    }

    public void setNomalRate(float nomalRate) {
        this.nomalRate = nomalRate;
    }

    public float getOtReate() {
        return otReate;
    }

    public void setOtReate(float otReate) {
        this.otReate = otReate;
    }

    public float getBonuseReate() {
        return bonuseReate;
    }

    public void setBonuseReate(float bonuseReate) {
        this.bonuseReate = bonuseReate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkerCateNo() {
        return workerCateNo;
    }

    public void setWorkerCateNo(String workerCateNo) {
        this.workerCateNo = workerCateNo;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "PaymentVariableDTO{" +
                "svID='" + svID + '\'' +
                ", name='" + name + '\'' +
                ", nomalRate=" + nomalRate +
                ", otReate=" + otReate +
                ", bonuseReate=" + bonuseReate +
                ", description='" + description + '\'' +
                ", workerCateNo='" + workerCateNo + '\'' +
                ", catName='" + catName + '\'' +
                '}';
    }
}
