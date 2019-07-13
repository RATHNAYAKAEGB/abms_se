package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
public class Worker implements SuperEntity {
    @Id
    private String workerId;
    private String nic;
    private String firstName;
    private String fullName;
    private String address;
    @Lob
    private byte[] img;
    private String mobile;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(referencedColumnName = "catId", name = "wc_Id")
    private WorkerCategory wc_Id;
    @Temporal(TemporalType.DATE)
    private Date regDate;
    public Worker() {
    }

    public Worker(String workerId, String nic, String firstName, String fullName, String address, byte[] img, String mobile, WorkerCategory wc_Id, Date regDate) {
        this.workerId = workerId;
        this.nic = nic;
        this.firstName = firstName;
        this.fullName = fullName;
        this.address = address;
        this.img = img;
        this.mobile = mobile;
        this.setWc_Id(wc_Id);
        this.setRegDate(regDate);
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public WorkerCategory getWc_Id() {
        return wc_Id;
    }

    public void setWc_Id(WorkerCategory wc_Id) {
        this.wc_Id = wc_Id;
    }


    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId='" + workerId + '\'' +
                ", nic='" + nic + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", img=" + Arrays.toString(img) +
                ", mobile='" + mobile + '\'' +
                ", wc_Id=" + wc_Id +
                ", regDate=" + regDate +
                '}';
    }
}
