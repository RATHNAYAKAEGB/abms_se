package lk.abms.se.abms_se_pro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sub_Account implements SuperEntity {

    @Id
    private
    String subAccountId;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(referencedColumnName = "at_Id", name = "at_Id")
    private Main_Account main_accountId;

    public Sub_Account() {
    }

    public Sub_Account(String subAccountId, String name, String description, Main_Account main_accountId) {
        this.setSubAccountId(subAccountId);
        this.setName(name);
        this.setDescription(description);
        this.setMain_accountId(main_accountId);
    }


    public String getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(String subAccountId) {
        this.subAccountId = subAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Main_Account getMain_accountId() {
        return main_accountId;
    }

    public void setMain_accountId(Main_Account main_accountId) {
        this.main_accountId = main_accountId;
    }

    @Override
    public String toString() {
        return "Sub_Account{" +
                "subAccountId='" + subAccountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", main_accountId=" + main_accountId +
                '}';
    }
}
