package lk.abms.se.abms_se_pro.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class AttendenceDTO implements SuperDTO {
    private String siteNumber;
    private String siteName;
    private String supervisor;
    private String workerId;
    private String nic;
    private String workerName;
    private LocalDate atDate;
    private LocalTime inTime;
    private LocalTime outTime;
    private boolean isPaid;
    private float advanceAmount;
    private float nofHours;
    private int workedMinits;
    private int duratioDays ;



    public AttendenceDTO() {
    }

    public AttendenceDTO(String siteNumber, String siteName, String supervisor, String workerId, String nic, String workerName, LocalDate atDate, LocalTime inTime, LocalTime outTime, boolean isPaid, float advanceAmount, float nofHours, int workedMinits, int duratioDays) {
        this.siteNumber = siteNumber;
        this.siteName = siteName;
        this.supervisor = supervisor;
        this.workerId = workerId;
        this.nic = nic;
        this.workerName = workerName;
        this.atDate = atDate;
        this.inTime = inTime;
        this.outTime = outTime;
        this.isPaid = isPaid;
        this.advanceAmount = advanceAmount;
        this.nofHours = nofHours;
        this.workedMinits = workedMinits;
        this.duratioDays = duratioDays;
    }

    public String getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(String siteNumber) {
        this.siteNumber = siteNumber;
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

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public LocalDate getAtDate() {
        return atDate;
    }

    public void setAtDate(LocalDate atDate) {
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public float getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(float advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public float getNofHours() {
        return nofHours;
    }

    public void setNofHours(float nofHours) {
        this.nofHours = nofHours;
    }


    public int getWorkedMinits() {
        return workedMinits;
    }

    public void setWorkedMinits(int workedMinits) {
        this.workedMinits = workedMinits;
    }

    public int getDuratioDays() {
        return duratioDays;
    }

    public void setDuratioDays(int duratioDays) {
        this.duratioDays = duratioDays;
    }

    @Override
    public String toString() {
        return "AttendenceDTO{" +
                "siteNumber='" + siteNumber + '\'' +
                ", siteName='" + siteName + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", workerId='" + workerId + '\'' +
                ", nic='" + nic + '\'' +
                ", workerName='" + workerName + '\'' +
                ", atDate=" + atDate +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", isPaid=" + isPaid +
                ", advanceAmount=" + advanceAmount +
                ", nofHours=" + nofHours +
                ", workedMinits=" + workedMinits +
                ", duratioDays=" + duratioDays +
                '}';
    }
}
