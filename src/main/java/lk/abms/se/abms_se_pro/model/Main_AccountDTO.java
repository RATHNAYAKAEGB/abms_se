package lk.abms.se.abms_se_pro.model;

import lk.abms.se.abms_se_pro.entity.SuperEntity;
import lk.abms.se.abms_se_pro.model.SuperDTO;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Main_AccountDTO implements SuperDTO {

    private String at_Id;
    private String accountName;
    private String description;

    public Main_AccountDTO() {
    }

    public Main_AccountDTO(String at_Id, String accountName, String description) {
        this.setAt_Id(at_Id);
        this.setAccountName(accountName);
        this.setDescription(description);
    }


    public String getAt_Id() {
        return at_Id;
    }

    public void setAt_Id(String at_Id) {
        this.at_Id = at_Id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Main_Account{" +
                "at_Id='" + at_Id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
