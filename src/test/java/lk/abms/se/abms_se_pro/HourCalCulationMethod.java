package lk.abms.se.abms_se_pro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HourCalCulationMethod {

    @Test
    public void testHours(){
        String intime  ="06:30";
        String outTime  ="10:30";
        String[] h = intime.split(":");
        String[] h2 = outTime.split(":");

        float inTimehours = Float.parseFloat(h[0]);
        float inTimesminits = Float.parseFloat(h[1]);

        float outTimehours = Float.parseFloat(h[0]);
        float outTimesminits = Float.parseFloat(h[1]);

        int noWorkDay =1;

        if(inTimehours<outTimehours && outTimehours>12 && outTimehours<=24){

            float workedHours =outTimehours-inTimehours;
            System.out.println(workedHours);

        }

    }


}
