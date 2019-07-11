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

    public PaymentVariable() {
    }

    public PaymentVariable(String svID, String name, float nomalRate, float otReate, float bonuseReate, String description, WorkerCategory categoryId) {
        this.svID = svID;
        this.name = name;
        this.nomalRate = nomalRate;
        this.otReate = otReate;
        this.bonuseReate = bonuseReate;
        this.description = description;
        this.categoryId = categoryId;
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
                '}';
    }
}
