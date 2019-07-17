package lk.abms.se.abms_se_pro.entity;

import javax.persistence.*;

@Entity
public class Main_Account implements SuperEntity {
    @Id
    private String atId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;
    private String accountName;
    private String description;

    public Main_Account() {
    }

    public Main_Account(String at_Id, String accountName, String description) {
        this.setAtId(at_Id);
        this.setAccountName(accountName);
        this.setDescription(description);
    }


    public String getAtId() {
        return atId;
    }

    public void setAtId(String at_Id) {
        this.atId = at_Id;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Main_Account{" +
                "at_Id='" + atId + '\'' +
                ", ano=" + ano +
                ", accountName='" + accountName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
