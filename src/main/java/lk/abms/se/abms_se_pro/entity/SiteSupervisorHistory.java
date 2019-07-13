package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SiteSupervisorHistory implements SuperEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Temporal(TemporalType.DATE)
    private
    Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String supvisorId;
    private String supName;
    private String siteId;
    private String sitName;
    private boolean status;

    public SiteSupervisorHistory() {
    }

    public SiteSupervisorHistory(Date startDate, Date endDate, String supvisorId, String supName, String siteId, String sitName, boolean status) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setSupvisorId(supvisorId);
        this.setSupName(supName);
        this.setSiteId(siteId);
        this.setSitName(sitName);
        this.setStatus(status);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSupvisorId() {
        return supvisorId;
    }

    public void setSupvisorId(String supvisorId) {
        this.supvisorId = supvisorId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSitName() {
        return sitName;
    }

    public void setSitName(String sitName) {
        this.sitName = sitName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SiteSupervisorHistory{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", supvisorId='" + supvisorId + '\'' +
                ", supName='" + supName + '\'' +
                ", siteId='" + siteId + '\'' +
                ", sitName='" + sitName + '\'' +
                ", status=" + status +
                '}';
    }
}
