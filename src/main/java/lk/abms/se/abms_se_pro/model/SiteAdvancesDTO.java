package lk.abms.se.abms_se_pro.model;

import java.util.Date;

public class SiteAdvancesDTO implements SuperDTO {


    private String paymentId;
    private String payamentType;
    private String checkNumber;
    private Date issueDate;
    private double amount;
    private String description;
    private String sit_Id;
    private String siteName;
    private String supervisor;


    public SiteAdvancesDTO() {
    }

    public SiteAdvancesDTO(String paymentId, String payamentType, String checkNumber, Date issueDate, double amount, String description, String sit_Id, String siteName, String supervisor) {
        this.setPaymentId(paymentId);
        this.setPayamentType(payamentType);
        this.setCheckNumber(checkNumber);
        this.setIssueDate(issueDate);
        this.setAmount(amount);
        this.setDescription(description);
        this.setSit_Id(sit_Id);
        this.setSiteName(siteName);
        this.setSupervisor(supervisor);
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

    public String getSit_Id() {
        return sit_Id;
    }

    public void setSit_Id(String sit_Id) {
        this.sit_Id = sit_Id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "SiteAdvancesDTO{" +
                "paymentId='" + paymentId + '\'' +
                ", payamentType='" + payamentType + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", issueDate=" + issueDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", sit_Id='" + sit_Id + '\'' +
                ", siteName='" + siteName + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }
}
