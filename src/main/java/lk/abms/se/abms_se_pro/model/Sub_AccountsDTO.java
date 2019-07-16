package lk.abms.se.abms_se_pro.model;


public class Sub_AccountsDTO implements SuperDTO {

    private String subAccountId;
    private String name;
    private String description;
    private String  main_accountId;
    private String main_A_Name;

    public Sub_AccountsDTO() {
    }

    public Sub_AccountsDTO(String subAccountId, String name, String description, String main_accountId, String main_A_Name) {
        this.setSubAccountId(subAccountId);
        this.setName(name);
        this.setDescription(description);
        this.setMain_accountId(main_accountId);
        this.setMain_A_Name(main_A_Name);
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

    public String getMain_accountId() {
        return main_accountId;
    }

    public void setMain_accountId(String main_accountId) {
        this.main_accountId = main_accountId;
    }

    public String getMain_A_Name() {
        return main_A_Name;
    }

    public void setMain_A_Name(String main_A_Name) {
        this.main_A_Name = main_A_Name;
    }

    @Override
    public String toString() {
        return "Sub_AccountsDTO{" +
                "subAccountId='" + subAccountId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", main_accountId='" + main_accountId + '\'' +
                ", main_A_Name='" + main_A_Name + '\'' +
                '}';
    }
}
