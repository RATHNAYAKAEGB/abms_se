package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Worker implements SuperEntity {
    @Id
    private String nic;
    private String name;
    private String address;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date regDate;
    private String ctratedBy;
    @ManyToOne
    @JoinColumn(referencedColumnName = "EmpCatId", name = "EmpCatId")
    private WorkerCategory empCateId;
    private boolean isActive;

    public Worker() {
    }


    public Worker(String nic, String name, String address, String phone, Date regDate, String ctratedBy, WorkerCategory empCateId, boolean isActive) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.regDate = regDate;
        this.ctratedBy = ctratedBy;
        this.empCateId = empCateId;
        this.isActive = isActive;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getCtratedBy() {
        return ctratedBy;
    }

    public void setCtratedBy(String ctratedBy) {
        this.ctratedBy = ctratedBy;
    }

    public WorkerCategory getEmpCateId() {
        return empCateId;
    }

    public void setEmpCateId(WorkerCategory empCateId) {
        this.empCateId = empCateId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", regDate=" + regDate +
                ", ctratedBy='" + ctratedBy + '\'' +
                ", empCateId=" + empCateId +
                ", isActive=" + isActive +
                '}';
    }
}
