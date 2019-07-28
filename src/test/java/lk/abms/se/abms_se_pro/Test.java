package lk.abms.se.abms_se_pro;

import java.time.LocalTime;

public class Test {

    public static void main(String[] args) {


        String intime = "06:00";
        String outTime = "07:30";
        String[] h = intime.split(":");
        String[] h2 = outTime.split(":");

        int inTimehours = Integer.parseInt(h[0]);
        int inTimesminits = Integer.parseInt(h[1]);

        int outTimesminits = Integer.parseInt(h2[1]);
        int outTimehours = Integer.parseInt(h2[0]);

        double hoursRate =200;
        double otrate =200;
        double nomalHours =8;

        int noWorkDay = 1;

        if (inTimehours < outTimehours  && noWorkDay == 1) {

            float workedHours = ((outTimehours + (outTimesminits / 100)) - (inTimehours + (inTimesminits / 100)));
            String sprintHours = workedHours + "";
            String[] split = sprintHours.split("\\.");

            int hours = Integer.parseInt(split[0]);
            if (split[1].length() <= 1) {
            split[1] =split[1]+"0";
            }
            int minits = Integer.parseInt(split[1]);

            double nomalHoursPayment =0;
            double otHoursPayment =0;

            System.out.println("Hors : "+hours+ "Minits : "+minits);

            if(hours>nomalHours){
                nomalHoursPayment =nomalHours*hoursRate;
                otHoursPayment=(hours-nomalHours-1)*otrate;
                System.out.println("OT H"+(hours-nomalHours-1));
                int minitsPaymet =0;
                if(minits>0){
//                    minitsPaymet= (float) ((float) minits*(otrate/60
                }
                nomalHoursPayment=nomalHoursPayment+minitsPaymet;

            }else {
                nomalHoursPayment =hours*hoursRate;
                int minitsPaymet =0;
                if(minits>0){
                    minitsPaymet= (int) (minits*hoursRate);
                }
                System.out.println("Minits :: "+minitsPaymet+"  minits :: "+minits);
                nomalHoursPayment=nomalHoursPayment+minitsPaymet;
            }

            System.out.println("nomal hours : "+nomalHoursPayment);
            System.out.println("OT hours : "+otHoursPayment);

        }else {




        }


    }
}
