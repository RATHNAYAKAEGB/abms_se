package lk.abms.se.abms_se_pro.model;

import lk.abms.se.abms_se_pro.entity.SuperEntity;

import java.time.LocalTime;
import java.util.Date;

public class CustomEntityPayamentDTO implements SuperDTO {

    private String worker_Id;
    private String fullName;
    private String catName;
    private String siteName;
    private Date atDate;
    private LocalTime inTime;
    private LocalTime outTime;
    private float numberOfHours;
    private float advanceAmmount;
    private int nomalHours;
    private float nomalHoursRate;
    private float OtRate;
    private float bonusRate;
    private String varibleListName;
    private double nolaHoursPayment;
    private double otPayment;
    private double grossPayment;
    private double netPayment;
    private double openBlance;

    public CustomEntityPayamentDTO() {
    }

    public CustomEntityPayamentDTO(String worker_Id, String fullName, String catName, String siteName, Date atDate, LocalTime inTime, LocalTime outTime, float numberOfHours, float advanceAmmount, int nomalHours, float nomalHoursRate, float otRate, float bonusRate, String varibleListName, double nolaHoursPayment, double otPayment, double grossPayment, double netPayment, double openBlance) {
        this.worker_Id = worker_Id;
        this.fullName = fullName;
        this.catName = catName;
        this.siteName = siteName;
        this.atDate = atDate;
        this.inTime = inTime;
        this.outTime = outTime;
        this.numberOfHours = numberOfHours;
        this.advanceAmmount = advanceAmmount;
        this.nomalHours = nomalHours;
        this.nomalHoursRate = nomalHoursRate;
        OtRate = otRate;
        this.bonusRate = bonusRate;
        this.varibleListName = varibleListName;
        this.nolaHoursPayment = nolaHoursPayment;
        this.otPayment = otPayment;
        this.grossPayment = grossPayment;
        this.netPayment = netPayment;
        this.openBlance = openBlance;
    }

    public String getWorker_Id() {
        return worker_Id;
    }

    public void setWorker_Id(String worker_Id) {
        this.worker_Id = worker_Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Date getAtDate() {
        return atDate;
    }

    public void setAtDate(Date atDate) {
        this.atDate = atDate;
    }

    public LocalTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalTime inTime) {
        this.inTime = inTime;
    }

    public LocalTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalTime outTime) {
        this.outTime = outTime;
    }

    public float getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(float numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public float getAdvanceAmmount() {
        return advanceAmmount;
    }

    public void setAdvanceAmmount(float advanceAmmount) {
        this.advanceAmmount = advanceAmmount;
    }

    public int getNomalHours() {
        return nomalHours;
    }

    public void setNomalHours(int nomalHours) {
        this.nomalHours = nomalHours;
    }

    public float getNomalHoursRate() {
        return nomalHoursRate;
    }

    public void setNomalHoursRate(float nomalHoursRate) {
        this.nomalHoursRate = nomalHoursRate;
    }

    public float getOtRate() {
        return OtRate;
    }

    public void setOtRate(float otRate) {
        OtRate = otRate;
    }

    public float getBonusRate() {
        return bonusRate;
    }

    public void setBonusRate(float bonusRate) {
        this.bonusRate = bonusRate;
    }

    public String getVaribleListName() {
        return varibleListName;
    }

    public void setVaribleListName(String varibleListName) {
        this.varibleListName = varibleListName;
    }

    public double getNolaHoursPayment() {
        return nolaHoursPayment;
    }

    public void setNolaHoursPayment(double nolaHoursPayment) {
        this.nolaHoursPayment = nolaHoursPayment;
    }

    public double getOtPayment() {
        return otPayment;
    }

    public void setOtPayment(double otPayment) {
        this.otPayment = otPayment;
    }

    public double getGrossPayment() {
        return grossPayment;
    }

    public void setGrossPayment(double grossPayment) {
        this.grossPayment = grossPayment;
    }

    public double getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(double netPayment) {
        this.netPayment = netPayment;
    }

    public double getOpenBlance() {
        return openBlance;
    }

    public void setOpenBlance(double openBlance) {
        this.openBlance = openBlance;
    }

    @Override
    public String toString() {
        return "CustomEntityPayamentDTO{" +
                "worker_Id='" + worker_Id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", catName='" + catName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", atDate=" + atDate +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", numberOfHours=" + numberOfHours +
                ", advanceAmmount=" + advanceAmmount +
                ", nomalHours=" + nomalHours +
                ", nomalHoursRate=" + nomalHoursRate +
                ", OtRate=" + OtRate +
                ", bonusRate=" + bonusRate +
                ", varibleListName='" + varibleListName + '\'' +
                ", nolaHoursPayment=" + nolaHoursPayment +
                ", otPayment=" + otPayment +
                ", grossPayment=" + grossPayment +
                ", netPayment=" + netPayment +
                ", openBlance=" + openBlance +
                '}';
    }
}
