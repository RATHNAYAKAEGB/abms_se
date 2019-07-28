package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;

@Entity
public class OpeningBlanceWorker implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double openBalance;
    private String workerId;
    @OneToOne
    @JoinColumn(referencedColumnName = "workerId", name = "worker_Idx",unique = true)
    private Worker worker_Idx;

    public OpeningBlanceWorker() {
    }

    public OpeningBlanceWorker(double openBalance, String workerId, Worker worker_Idx) {
        this.setOpenBalance(openBalance);
        this.setWorkerId(workerId);
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

    public Worker getWorker_Idx() {
        return worker_Idx;
    }

    public void setWorker_Idx(Worker worker_Id) {
        this.worker_Idx = worker_Id;
    }

    @Override
    public String toString() {
        return "OpeningBlanceWorker{" +
                "id=" + id +
                ", openBalance=" + openBalance +
                ", workerId='" + workerId + '\'' +
                ", worker_Id=" + worker_Idx +
                '}';
    }
}
