package lk.abms.se.abms_se_pro.entity.custom;

import lk.abms.se.abms_se_pro.entity.SuperEntity;

import java.time.LocalTime;
import java.util.Date;

public class CustomEntityPayament implements SuperEntity {

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
    private double openBlance;
    private int workedMinits;


    public CustomEntityPayament() {
    }

    public CustomEntityPayament(String worker_Id, String fullName, String catName, String siteName, Date atDate, LocalTime inTime, LocalTime outTime, float numberOfHours, float advanceAmmount, int nomalHours, float nomalHoursRate, float otRate, float bonusRate, String varibleListName, double openBlance, int workedMinits) {
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
        this.openBlance = openBlance;
        this.workedMinits = workedMinits;
    }

    public CustomEntityPayament(String worker_Id, String fullName, String catName, String siteName, Date atDate, LocalTime inTime, LocalTime outTime, float numberOfHours, float advanceAmmount, int nomalHours, float nomalHoursRate, float otRate, float bonusRate, String varibleListName, double openBlance) {
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
        this.openBlance = openBlance;
    }

    public int getWorkedMinits() {
        return workedMinits;
    }

    public void setWorkedMinits(int workedMinits) {
        this.workedMinits = workedMinits;
    }

    public double getOpenBlance() {
        return openBlance;
    }

    public void setOpenBlance(double openBlance) {
        this.openBlance = openBlance;
    }

    public CustomEntityPayament(String worker_Id) {
        this.worker_Id = worker_Id;
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

    @Override
    public String toString() {
        return "CustomEntityPayament{" +
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
                ", openBlance=" + openBlance +
                ", workedMinits=" + workedMinits +
                '}';
    }
}
