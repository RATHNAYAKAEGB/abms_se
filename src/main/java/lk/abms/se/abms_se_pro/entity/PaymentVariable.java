package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;

@Entity
public class PaymentVariable implements SuperEntity {

    @Id
    private String svID;
    @Column(length = 40,unique = true)
    private String name;
    private float nomalRate;
    private float otReate;
    private float bonuseReate;
    private String description;
    @OneToOne
    @JoinColumn(referencedColumnName = "catId",name = "wCId")
    private WorkerCategory categoryId;
    private int nomalHours;

    public PaymentVariable() {
    }

    public PaymentVariable(String svID, String name, float nomalRate, float otReate, float bonuseReate, String description, WorkerCategory categoryId, int nomalHours) {
        this.setSvID(svID);
        this.setName(name);
        this.setNomalRate(nomalRate);
        this.setOtReate(otReate);
        this.setBonuseReate(bonuseReate);
        this.setDescription(description);
        this.setCategoryId(categoryId);
        this.setNomalHours(nomalHours);
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

    public WorkerCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(WorkerCategory categoryId) {
        this.categoryId = categoryId;
    }

    public int getNomalHours() {
        return nomalHours;
    }

    public void setNomalHours(int nomalHours) {
        this.nomalHours = nomalHours;
    }

    @Override
    public String toString() {
        return "PaymentVariable{" +
                "svID='" + svID + '\'' +
                ", name='" + name + '\'' +
                ", nomalRate=" + nomalRate +
                ", otReate=" + otReate +
                ", bonuseReate=" + bonuseReate +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", nomalHours=" + nomalHours +
                '}';
    }
}
