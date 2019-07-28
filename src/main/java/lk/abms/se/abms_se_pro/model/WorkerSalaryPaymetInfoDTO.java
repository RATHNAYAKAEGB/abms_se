package lk.abms.se.abms_se_pro.model;

import lk.abms.se.abms_se_pro.entity.Attendence;
import lk.abms.se.abms_se_pro.entity.SuperEntity;

import javax.persistence.*;
import java.util.Date;


public class WorkerSalaryPaymetInfoDTO implements SuperDTO {


    private int id;
    private double nomalRate;
    private double otRate;
    private double nomalPayment;
    private double otPayemt;
    private double openBlance;
    private double grossPay;
    private double netPay;
    private String workerId;
    private Date atDate;
    private Attendence attendenceId;

    public WorkerSalaryPaymetInfoDTO() {
    }

    public WorkerSalaryPaymetInfoDTO(double nomalRate, double otRate, double nomalPayment, double otPayemt, double openBlance, double grossPay, double netPay, String workerId, Date atDate, Attendence attendenceId) {
        this.nomalRate = nomalRate;
        this.otRate = otRate;
        this.nomalPayment = nomalPayment;
        this.otPayemt = otPayemt;
        this.openBlance = openBlance;
        this.grossPay = grossPay;
        this.netPay = netPay;
        this.workerId = workerId;
        this.atDate = atDate;
        this.attendenceId = attendenceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNomalRate() {
        return nomalRate;
    }

    public void setNomalRate(double nomalRate) {
        this.nomalRate = nomalRate;
    }

    public double getOtRate() {
        return otRate;
    }

    public void setOtRate(double otRate) {
        this.otRate = otRate;
    }

    public double getNomalPayment() {
        return nomalPayment;
    }

    public void setNomalPayment(double nomalPayment) {
        this.nomalPayment = nomalPayment;
    }

    public double getOtPayemt() {
        return otPayemt;
    }

    public void setOtPayemt(double otPayemt) {
        this.otPayemt = otPayemt;
    }

    public double getOpenBlance() {
        return openBlance;
    }

    public void setOpenBlance(double openBlance) {
        this.openBlance = openBlance;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public Date getAtDate() {
        return atDate;
    }

    public void setAtDate(Date atDate) {
        this.atDate = atDate;
    }

    public Attendence getAttendenceId() {
        return attendenceId;
    }

    public void setAttendenceId(Attendence attendenceId) {
        this.attendenceId = attendenceId;
    }

    @Override
    public String toString() {
        return "WorkerSalaryPaymetInfo{" +
                "id=" + id +
                ", nomalRate=" + nomalRate +
                ", otRate=" + otRate +
                ", nomalPayment=" + nomalPayment +
                ", otPayemt=" + otPayemt +
                ", openBlance=" + openBlance +
                ", grossPay=" + grossPay +
                ", netPay=" + netPay +
                ", workerId='" + workerId + '\'' +
                ", atDate=" + atDate +
                ", attendenceId=" + attendenceId +
                '}';
    }
}
