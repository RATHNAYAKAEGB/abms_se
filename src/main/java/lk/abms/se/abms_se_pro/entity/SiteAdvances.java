package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SiteAdvances implements SuperEntity {

    @Id
    private
    String paymentId;
    private String payamentType;
    private String checkNumber;
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    private double amount;
    private String description;
    @JoinColumn(name = "site_Id", referencedColumnName = "siteId")
    @ManyToOne
    private
    Site site_Id;

    public SiteAdvances() {
    }

    public SiteAdvances(String paymentId, String payamentType, String checkNumber, Date issueDate, double amount, String description, Site site_Id) {
        this.setPaymentId(paymentId);
        this.setPayamentType(payamentType);
        this.setCheckNumber(checkNumber);
        this.setIssueDate(issueDate);
        this.setAmount(amount);
        this.setDescription(description);
        this.setSite_Id(site_Id);
    }


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayamentType() {
        return payamentType;
    }

    public void setPayamentType(String payamentType) {
        this.payamentType = payamentType;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Site getSite_Id() {
        return site_Id;
    }

    public void setSite_Id(Site site_Id) {
        this.site_Id = site_Id;
    }

    @Override
    public String toString() {
        return "SiteAdvances{" +
                "paymentId='" + paymentId + '\'' +
                ", payamentType='" + payamentType + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", issueDate=" + issueDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", site_Id=" + site_Id +
                '}';
    }
}
