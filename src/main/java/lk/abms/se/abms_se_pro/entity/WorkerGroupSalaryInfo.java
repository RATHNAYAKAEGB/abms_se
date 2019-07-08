package lk.abms.se.abms_se_pro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class WorkerGroupSalaryInfo implements SuperEntity {

    @Id
    private String id;
    private String name;
    private double nomarHoursPayment;
    private double otyPayment;
    private double bonuse;
    private String createBy;
    @OneToOne
    @JoinColumn(name = "EmpCatId", referencedColumnName = "EmpCatId")
    private
    WorkerCategory workerCategory;

    public WorkerGroupSalaryInfo() {
    }

    public WorkerGroupSalaryInfo(String id, String name, double nomarHoursPayment, double otyPayment, double bonuse, String createBy, WorkerCategory workerCategory) {
        this.setId(id);
        this.setName(name);
        this.setNomarHoursPayment(nomarHoursPayment);
        this.setOtyPayment(otyPayment);
        this.setBonuse(bonuse);
        this.setCreateBy(createBy);
        this.setWorkerCategory(workerCategory);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNomarHoursPayment() {
        return nomarHoursPayment;
    }

    public void setNomarHoursPayment(double nomarHoursPayment) {
        this.nomarHoursPayment = nomarHoursPayment;
    }

    public double getOtyPayment() {
        return otyPayment;
    }

    public void setOtyPayment(double otyPayment) {
        this.otyPayment = otyPayment;
    }

    public double getBonuse() {
        return bonuse;
    }

    public void setBonuse(double bonuse) {
        this.bonuse = bonuse;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public WorkerCategory getWorkerCategory() {
        return workerCategory;
    }

    public void setWorkerCategory(WorkerCategory workerCategory) {
        this.workerCategory = workerCategory;
    }

    @Override
    public String toString() {
        return "WorkerGroupSalaryInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nomarHoursPayment=" + nomarHoursPayment +
                ", otyPayment=" + otyPayment +
                ", bonuse=" + bonuse +
                ", createBy='" + createBy + '\'' +
                ", workerCategory=" + workerCategory +
                '}';
    }
}
