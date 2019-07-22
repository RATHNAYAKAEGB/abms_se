package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Site implements SuperEntity {
    @Id
    private String siteId;
    @Temporal(TemporalType.DATE)
    private Date regDate;
    private String sitName;
    private String address;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "workerID", referencedColumnName = "workerId")
    private
    Worker workerID;

    public Site() {
    }

    public Site(String siteId, Date regDate, String sitName, String address, boolean isActive, Worker workerID) {
        this.setSiteId(siteId);
        this.setRegDate(regDate);
        this.setSitName(sitName);
        this.setAddress(address);
        this.setActive(isActive);
        this.setWorkerID(workerID);
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Worker getWorkerID() {
        return workerID;
    }

    public void setWorkerID(Worker workerID) {
        this.workerID = workerID;
    }

    @Override
    public String toString() {
        return "Site{" +
                "siteId='" + siteId + '\'' +
                ", regDate=" + regDate +
                ", sitName='" + sitName + '\'' +
                ", address='" + address + '\'' +
                ", isActive=" + isActive +
                ", workerID=" + workerID +
                '}';
    }
}
