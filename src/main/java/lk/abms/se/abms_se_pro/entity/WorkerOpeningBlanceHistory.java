package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WorkerOpeningBlanceHistory implements SuperEntity {

    @Id
    private
    int id;
    private double openBalance;
    private String workerId;
    @Temporal(TemporalType.DATE)
    private Date dateOfOb;
    @ManyToOne
    @JoinColumn(referencedColumnName = "workerId", name = "worker_Idx")
    private Worker worker_Idx;

    public WorkerOpeningBlanceHistory() {
    }

    public WorkerOpeningBlanceHistory(int id, double openBalance, String workerId, Date dateOfOb, Worker worker_Idx) {
        this.setId(id);
        this.setOpenBalance(openBalance);
        this.setWorkerId(workerId);
        this.setDateOfOb(dateOfOb);
        this.setWorker_Idx(worker_Idx);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(double openBalance) {
        this.openBalance = openBalance;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Date getDateOfOb() {
        return dateOfOb;
    }

    public void setDateOfOb(Date dateOfOB) {
        this.dateOfOb = dateOfOB;
    }

    public Worker getWorker_Idx() {
        return worker_Idx;
    }

    public void setWorker_Idx(Worker worker_Id) {
        this.worker_Idx = worker_Id;
    }

    @Override
    public String toString() {
        return "WorkerOpeningBlanceHistory{" +
                "id=" + id +
                ", openBalance=" + openBalance +
                ", workerId='" + workerId + '\'' +
                ", dateOfOB=" + dateOfOb +
                ", worker_Id=" + worker_Idx +
                '}';
    }
}
