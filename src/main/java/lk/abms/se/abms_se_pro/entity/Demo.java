package lk.abms.se.abms_se_pro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalTime;

//@Entity
public class Demo {
    @Id
    int id;
    @Temporal(TemporalType.TIME)
    LocalTime inTime;
}
