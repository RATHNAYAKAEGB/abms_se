package lk.abms.se.abms_se_pro.util;

public class ValidationNumbers {

    public static boolean isFloat(String number){
        try {
            Float.parseFloat(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public static boolean isInt(String number){
        try {
            Integer.parseInt(number);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
