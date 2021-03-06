package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Attendence implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @Temporal(TemporalType.DATE)
    private Date aDate;
//    @Temporal(TemporalType.TIME)
    private LocalTime inTime;
//    @Temporal(TemporalType.TIME)
    private LocalTime outTime;
    private float nofHours;
    private boolean isPaid;
    private float advanceAmount;
    @ManyToOne
    @JoinColumn(referencedColumnName = "workerId", name = "workerId")
    private Worker workerId;
    @ManyToOne
    @JoinColumn(referencedColumnName = "siteId", name = "siteId")
    private Site siteId;
    private int numberOfminits ;
    private int duratioDays ;

    public Attendence() {
    }

    public Attendence(Date aDate, LocalTime inTime, LocalTime outTime, float nofHours, boolean isPaid, float advanceAmount, Worker workerId, Site siteId, int numberOfminits, int duratioDays) {
        this.aDate = aDate;
        this.inTime = inTime;
        this.outTime = outTime;
        this.nofHours = nofHours;
        this.isPaid = isPaid;
        this.advanceAmount = advanceAmount;
        this.workerId = workerId;
        this.siteId = siteId;
        this.numberOfminits = numberOfminits;
        this.duratioDays = duratioDays;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
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

    public float getNofHours() {
        return nofHours;
    }

    public void setNofHours(float nofHours) {
        this.nofHours = nofHours;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }

    public Site getSiteId() {
        return siteId;
    }

    public void setSiteId(Site siteId) {
        this.siteId = siteId;
    }


    public float getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(float advanceAmount) {
        this.advanceAmount = advanceAmount;
    }


    public int getNumberOfminits() {
        return numberOfminits;
    }

    public void setNumberOfminits(int numberOfminits) {
        this.numberOfminits = numberOfminits;
    }

    public int getDuratioDays() {
        return duratioDays;
    }

    public void setDuratioDays(int duratioDays) {
        this.duratioDays = duratioDays;
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "aid=" + aid +
                ", aDate=" + aDate +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", nofHours=" + nofHours +
                ", isPaid=" + isPaid +
                ", advanceAmount=" + advanceAmount +
                ", workerId=" + workerId +
                ", siteId=" + siteId +
                ", numberOfminits=" + numberOfminits +
                ", duratioDays=" + duratioDays +
                '}';
    }
}
