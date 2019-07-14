package lk.abms.se.abms_se_pro.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateForMatter {

    public static Date getFortmatteredDate(LocalDate date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static LocalDate getLocalDate(Date date){
        return LocalDate.parse(date.toString());
    }

}
