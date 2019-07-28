package lk.abms.se.abms_se_pro.bussiness.logic;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class LabourSalaryCalculator {

    public double findNomalHoursPayment(int minits,double nomalHoursRate,int systemNomalHours){

        int hours =minits/60;
        int remainMinits =minits%60;
        double hoursPayment=0;
        double mintsPayment =0;

        if(hours<systemNomalHours){
           hoursPayment =hours*nomalHoursRate;
           mintsPayment =remainMinits* (nomalHoursRate/60);
           return hoursPayment+mintsPayment;
        }

        return systemNomalHours*nomalHoursRate;

    }

    public double findWorkerOTPayment(int minits,double otRate,int systemNomalHours){

        int hours =minits/60;
        int remainMinits =minits%60;
        int otHours=0;
        double otHoursPayment=0;
        double otMinitsPayment =0;

        if(hours<systemNomalHours){
         return 0;
        }
        if(hours==systemNomalHours && remainMinits>0){
            return (int) remainMinits*(otRate/60);
        }

        otHours =hours-systemNomalHours;

        otHoursPayment =otHours*otRate;
       int mintsPayment = (int) (remainMinits*(otRate/60));

        return (int) otHoursPayment+mintsPayment;

    }

}
