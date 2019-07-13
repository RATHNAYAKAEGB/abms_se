package lk.abms.se.abms_se_pro.model;

import java.util.Date;


public class SiteDTO implements SuperDTO {
    private String siteId;
    private Date regDate;
    private String sitName;
    private String address;
    private String isActive;
    private String supId;
    private String supName;
    private String supMobile;

    public SiteDTO() {
    }

    public SiteDTO(String siteId, Date regDate, String sitName, String address, String isActive, String supId, String supName, String supMobile) {
        this.siteId = siteId;
        this.regDate = regDate;
        this.sitName = sitName;
        this.address = address;
        this.setIsActive(isActive);
        this.setSupId(supId);
        this.setSupName(supName);
        this.setSupMobile(supMobile);
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getSitName() {
        return sitName;
    }

    public void setSitName(String sitName) {
        this.sitName = sitName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupMobile() {
        return supMobile;
    }

    public void setSupMobile(String supMobile) {
        this.supMobile = supMobile;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    @Override
    public String toString() {
        return "SiteDTO{" +
                "siteId='" + siteId + '\'' +
                ", regDate=" + regDate +
                ", sitName='" + sitName + '\'' +
                ", address='" + address + '\'' +
                ", isActive='" + isActive + '\'' +
                ", supId='" + supId + '\'' +
                ", supName='" + supName + '\'' +
                ", supMobile='" + supMobile + '\'' +
                '}';
    }
}
