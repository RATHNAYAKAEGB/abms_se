package lk.abms.se.abms_se_pro.bussiness.logic;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class LabourSalaryCalculator {

    public double findNomalHoursPayment(int nomalHoursInMaster,Float workerNomalHours,double nomalHoursRate){

        double payAmout =0;
        if(nomalHoursInMaster>=workerNomalHours){
            return workerNomalHours*nomalHoursRate;
        }
        return nomalHoursInMaster*nomalHoursRate;
    }

    public double findWorkerOTPayment(LocalTime inTime,LocalTime outTime,int nomalHours,float  otRate,float workedHours){

        if(workedHours<nomalHours){return 0;}

        java.time.Duration diff = java.time.Duration.between(inTime, outTime);
        int hours = (int) diff.toHours();
        int minits = (int) diff.toMinutes();

        double hoursPayment =0;
        double minitsPayment=0;

        if(0==hours){
            return minits*(otRate/60);
        }
//        System.out.println("Hours: "+hours);
//        System.out.println("Minits :"+minits);
        hoursPayment=(hours-nomalHours)*otRate;
        minitsPayment=((minits%60)*(otRate/60));
//
//        System.out.println("Hours Payment: "+hoursPayment);
//        System.out.println("Minits payemt :"+minitsPayment);

        return hoursPayment+minitsPayment;

    }

}
