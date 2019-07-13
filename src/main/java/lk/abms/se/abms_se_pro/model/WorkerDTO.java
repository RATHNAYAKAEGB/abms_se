package lk.abms.se.abms_se_pro.model;

import java.util.Arrays;
import java.util.Date;


public class WorkerDTO implements SuperDTO {

    private String workerId;
    private String nic;
    private String firstName;
    private String fullName;
    private String address;
    private byte[] img;
    private String mobile;
    private String cat_Id;
    private String catName;
    private String catType;
    private Date regDate;

    public WorkerDTO() {
    }

    public WorkerDTO(String workerId, String nic, String firstName, String fullName, String address, byte[] img, String mobile, String cat_Id, String catName, String catType, Date regDate) {
        this.workerId = workerId;
        this.nic = nic;
        this.firstName = firstName;
        this.fullName = fullName;
        this.address = address;
        this.img = img;
        this.mobile = mobile;
        this.cat_Id = cat_Id;
        this.catName = catName;
        this.catType = catType;
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


    public void setCat_Id(String cat_Id) {
        this.cat_Id = cat_Id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatType() {
        return catType;
    }

    public void setCatType(String catType) {
        this.catType = catType;
    }

    public String getCat_Id() {
        return cat_Id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" +
                "workerId='" + workerId + '\'' +
                ", nic='" + nic + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", img=" + Arrays.toString(img) +
                ", mobile='" + mobile + '\'' +
                ", cat_Id='" + cat_Id + '\'' +
                ", catName='" + catName + '\'' +
                ", catType='" + catType + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
