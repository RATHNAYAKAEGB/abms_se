package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.AbmsSeProApplication;
import lk.abms.se.abms_se_pro.bussiness.MainAccountMangeService;
import lk.abms.se.abms_se_pro.bussiness.SiteManagementService;
import lk.abms.se.abms_se_pro.bussiness.SubAccountManageService;
import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.model.Main_AccountDTO;
import lk.abms.se.abms_se_pro.model.SiteDTO;
import lk.abms.se.abms_se_pro.model.Sub_AccountsDTO;
import lk.abms.se.abms_se_pro.model.WorkerDTO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeController<T> {
    @FXML
    private JFXComboBox cmbSubTypes;
    @FXML
    private JFXTextField txtMAccountId;
    @FXML
    private JFXTextField txtAccountName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private TableView<Main_AccountDTO> tblMainAccount;
    @FXML
    private JFXComboBox cmbAccountType;
    @FXML
    private JFXTextField txtSubDescription;
    @FXML
    private JFXButton btnSave;
    @FXML
    private ImageView img_Back;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnSaveSub;
    @FXML
    private JFXButton btnUpdateSub;
    @FXML
    private JFXTextField txtSubAid;
    @FXML
    private JFXTextField txtSubAName;
    @FXML
    private JFXTextField txtMainAccountName;
    @FXML
    private TableView<Sub_AccountsDTO> tblSubAccount;

    private MainAccountMangeService mainAccountMangeService = AbmsSeProApplication.ctx.getBean(MainAccountMangeService.class);
    private SubAccountManageService subAccountManageService = AbmsSeProApplication.ctx.getBean(SubAccountManageService.class);

    List<Main_AccountDTO> mainAccountDTOList = new ArrayList<>();

    public void initialize() {
        loadAllMAccounts();
        loadAllSubAccounts();
        setMainAccoutnId();
        setSubAccoutnId();
        setMainAccountNumbers();

        List<String> list = new ArrayList<>();
        list.add("CURRENT ACCOUNT");
        list.add("NON CURRENT ACCOUNT");
        list.add("Other");
        cmbSubTypes.setItems(FXCollections.observableArrayList(list));

        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        btnSaveSub.setDisable(false);
        btnUpdateSub.setDisable(true);

        tblMainAccount.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("at_Id"));
        tblMainAccount.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("accountName"));
        tblMainAccount.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));

        tblMainAccount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Main_AccountDTO>() {
            @Override
            public void changed(ObservableValue<? extends Main_AccountDTO> observable, Main_AccountDTO oldValue, Main_AccountDTO c) {

                if (c == null) {
                    return;
                }


                txtMAccountId.setText(c.getAt_Id());
                txtAccountName.setText(c.getAccountName());
                txtDescription.setText(c.getDescription());
                btnUpdate.setDisable(false);
                btnSave.setDisable(true);
            }
        });


        tblSubAccount.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("subAccountId"));
        tblSubAccount.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblSubAccount.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblSubAccount.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("main_accountId"));
        tblSubAccount.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("main_A_Name"));
        tblSubAccount.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("currentOrNon"));

        tblSubAccount.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sub_AccountsDTO>() {
            @Override
            public void changed(ObservableValue<? extends Sub_AccountsDTO> observable, Sub_AccountsDTO oldValue, Sub_AccountsDTO c) {

                if (c == null) {
                    return;
                }

                txtAccountName.setText(c.getMain_A_Name());
                txtSubAid.setText(c.getSubAccountId());
                txtSubDescription.setText(c.getDescription());
                txtSubAName.setText(c.getName());
                cmbAccountType.setValue(c.getMain_accountId());
                cmbSubTypes.setValue(c.getCurrentOrNon());
                btnSaveSub.setDisable(true);
                btnUpdateSub.setDisable(false);
            }
        });

    }


    @FXML
    private void cmbAccountType_OnAction(ActionEvent actionEvent) {

        if(null==cmbAccountType.getValue().toString()){return;}
        String groupId = cmbAccountType.getValue().toString();
        for (Main_AccountDTO c : mainAccountDTOList) {
            if (c.getAt_Id().equals(groupId)) {
                txtMainAccountName.setText(c.getAccountName());

            }
        }

    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtMAccountId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Account Id Is Empty!", ButtonType.OK).showAndWait();
            txtMAccountId.requestFocus();
            return;
        }
        if (txtAccountName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Main Account Name Is Empty !", ButtonType.OK).showAndWait();
            txtAccountName.requestFocus();
            return;
        }

        if (tblMainAccount.getItems().size() >= 5) {
            new Alert(Alert.AlertType.ERROR, "There Are 5 Main Type Account Only You Can't Create !", ButtonType.OK).showAndWait();
            return;
        }

        String name = txtAccountName.getText().trim();
        String accountId = txtMAccountId.getText().trim();
        String description = txtDescription.getText().trim();
        Main_AccountDTO mainAccountDTO = new Main_AccountDTO(accountId, name, description);

        try {
            mainAccountMangeService.saveMainAccount(mainAccountDTO);
            new Alert(Alert.AlertType.CONFIRMATION, " Main Account Succesfully Created  !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error !", ButtonType.OK).showAndWait();

        }

        reset1();

    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {


        if (txtMAccountId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Account Id Is Empty!", ButtonType.OK).showAndWait();
            txtMAccountId.requestFocus();
            return;
        }
        if (txtAccountName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Account Main Account Name Is Empty !", ButtonType.OK).showAndWait();
            txtAccountName.requestFocus();
            return;
        }

        String name = txtAccountName.getText().trim();
        String accountId = txtMAccountId.getText().trim();
        String description = txtDescription.getText().trim();

        Main_AccountDTO mainAccountDTO = new Main_AccountDTO(accountId, name, description);

        try {
            mainAccountMangeService.saveMainAccount(mainAccountDTO);
            new Alert(Alert.AlertType.CONFIRMATION, " Main Account Succesfully Updated  !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error !", ButtonType.OK).showAndWait();

        }

        reset1();
    }

    @FXML
    private void btnUpdateSub_OnAction(ActionEvent actionEvent) {

        if (txtSubAid.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Sub Account Id Is Empty!", ButtonType.OK).showAndWait();
            txtSubAid.requestFocus();
            return;
        }
        if (txtSubAName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Sub Account Main Account Name Is Empty !", ButtonType.OK).showAndWait();
            txtSubAName.requestFocus();
            return;
        }

        if (null == cmbAccountType.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Main Account Types !", ButtonType.OK).showAndWait();
            cmbAccountType.requestFocus();
            return;
        }

        if (null == cmbSubTypes.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Select Current Or Non Current !", ButtonType.OK).showAndWait();
            cmbAccountType.requestFocus();
            return;
        }

        String name = txtSubAName.getText().trim();
        String accountId = txtSubAid.getText().trim();
        String description = txtSubDescription.getText().trim();
        String mainAccoutType = cmbAccountType.getValue().toString();
        String mainAName = txtMainAccountName.getText().trim();
        String currntORnon = cmbSubTypes.getValue().toString();

        Sub_AccountsDTO sub_accountsDTO = new Sub_AccountsDTO(accountId, name, description, accountId, mainAName, currntORnon);

        try {
            subAccountManageService.updateSubAccount(sub_accountsDTO);
            new Alert(Alert.AlertType.CONFIRMATION, " Sub Account Update Successfully !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

        }
        reset2();
    }

    @FXML
    private void btnSaveSub_OnAction(ActionEvent actionEvent) {
        if (txtSubAid.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Sub Account Id Is Empty!", ButtonType.OK).showAndWait();
            txtSubAid.requestFocus();
            return;
        }
        if (txtSubAName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Sub Account Main Account Name Is Empty !", ButtonType.OK).showAndWait();
            txtSubAName.requestFocus();
            return;
        }

        if (null == cmbAccountType.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Main Account Types !", ButtonType.OK).showAndWait();
            cmbAccountType.requestFocus();
            return;
        }


        String name = txtSubAName.getText().trim();
        String accountId = txtSubAid.getText().trim();
        String description = txtSubDescription.getText().trim();
        String mainAccoutType = cmbAccountType.getValue().toString().trim();
        String mainAName = txtMainAccountName.getText().trim();
        String currntORnon = cmbSubTypes.getValue().toString();
        Sub_AccountsDTO sub_accountsDTO = new Sub_AccountsDTO(accountId, name, description, mainAccoutType, mainAName, currntORnon);

        try {
            subAccountManageService.saveSubAccount(sub_accountsDTO);
            new Alert(Alert.AlertType.CONFIRMATION, " Sub Account Created Successfully !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

        }
        reset2();

    }

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Main_Page.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) btnSave.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();

    }


    private void setMainAccoutnId() {

        ObservableList<Main_AccountDTO> items = tblMainAccount.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtMAccountId.setText("MANO01");
            return;
        }
        for (Main_AccountDTO c : items) {
            String subCId = c.getAt_Id();
            int i = Integer.parseInt(subCId.substring(5));
            if (max < i) {
                max = i;
            }
            txtMAccountId.setText("MANO0" + (++max));

        }
    }


    private void setSubAccoutnId() {
        ObservableList<Sub_AccountsDTO> items = tblSubAccount.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtSubAid.setText("SANO01");
            return;
        }
        for (Sub_AccountsDTO c : items) {
            String subCId = c.getSubAccountId();
            int i = Integer.parseInt(subCId.substring(5));
            if (max < i) {
                max = i;
            }
            txtSubAid.setText("SANO0" + (++max));

        }
    }

    private void loadAllMAccounts() {

        try {
            List<Main_AccountDTO> temp = mainAccountMangeService.findAllMainAccounts();
            mainAccountDTOList = temp;
            if (null == temp) {
                return;
            }
            tblMainAccount.setItems(FXCollections.observableArrayList(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadAllSubAccounts() {

        try {
            List<Sub_AccountsDTO> temp = subAccountManageService.findAllAccounts();
            if (null == temp) {
                return;
            }
            tblSubAccount.setItems(FXCollections.observableArrayList(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void reset1() {
        txtMAccountId.clear();
        txtDescription.clear();
        txtAccountName.clear();
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        loadAllMAccounts();
        setMainAccoutnId();

    }

    private void reset2() {
        txtSubDescription.clear();
        txtSubAid.clear();
        txtAccountName.clear();
        txtMainAccountName.clear();
        cmbAccountType.setValue(null);
        btnUpdateSub.setDisable(true);
        btnSaveSub.setDisable(false);
        cmbSubTypes.setValue(null);
        loadAllSubAccounts();
        setSubAccoutnId();
    }


    public void setMainAccountNumbers() {
        ArrayList<String> list = new ArrayList<>();
        try {
            for (Main_AccountDTO c : mainAccountDTOList) {

                list.add(c.getAt_Id());
            }
            cmbAccountType.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
