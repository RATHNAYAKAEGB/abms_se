package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;

@Entity
public class WorkerSalaryVariable implements SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    double nomalRate;
    double otRate;
    double nomalPayment;
    double otPayemt;
    float allHoursWorked;
    @OneToOne
    @JoinColumn(name = "attendenceId", referencedColumnName = "aid")
    Attendence attendenceId;
    @OneToOne
    @JoinColumn(name = "svID", referencedColumnName = "svID")
    WorkerSalaryVariable svID;

    public WorkerSalaryVariable() {
    }

    public WorkerSalaryVariable(double nomalRate, double otRate, double nomalPayment, double otPayemt, float allHoursWorked, Attendence attendenceId, WorkerSalaryVariable svID) {
        this.nomalRate = nomalRate;
        this.otRate = otRate;
        this.nomalPayment = nomalPayment;
        this.otPayemt = otPayemt;
        this.allHoursWorked = allHoursWorked;
        this.attendenceId = attendenceId;
        this.svID = svID;
    }


}
