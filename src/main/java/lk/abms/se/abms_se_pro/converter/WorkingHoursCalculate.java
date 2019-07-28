package lk.abms.se.abms_se_pro.converter;

import java.time.LocalTime;

public class WorkingHoursCalculate {

    public static float findNumOfHours(LocalTime in,LocalTime out){
        java.time.Duration diff = java.time.Duration.between(in, out);
        float Hours = diff.toHours() ;
        float l = diff.toMinutes();
        l=(l%60)/100;
        return Hours+l;
    }

    public static int findNumOfMinist(LocalTime in,LocalTime out){
        java.time.Duration diff = java.time.Duration.between(in, out);

        return (int) diff.toMinutes();
    }
}
