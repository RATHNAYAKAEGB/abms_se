package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WorkersAttendence implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int attendenceId;
    @Temporal(TemporalType.TIME)
    private
    Date onTime;
    @Temporal(TemporalType.TIME)
    private
    Date offTime;
    @Temporal(TemporalType.DATE)
    private
    Date worikingDay;
    @ManyToOne
    @JoinColumn(referencedColumnName = "nic", name = "nic")
    private
    Worker workerId;

    public WorkersAttendence() {
    }

    public WorkersAttendence(Date onTime, Date offTime, Date worikingDay, Worker workerId) {
        this.setOnTime(onTime);
        this.setOffTime(offTime);
        this.setWorikingDay(worikingDay);
        this.setWorkerId(workerId);
    }


    public int getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(int attendenceId) {
        this.attendenceId = attendenceId;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }

    public Date getWorikingDay() {
        return worikingDay;
    }

    public void setWorikingDay(Date worikingDay) {
        this.worikingDay = worikingDay;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "WorkersAttendence{" +
                "attendenceId=" + attendenceId +
                ", onTime=" + onTime +
                ", offTime=" + offTime +
                ", worikingDay=" + worikingDay +
                ", workerId=" + workerId +
                '}';
    }
}
