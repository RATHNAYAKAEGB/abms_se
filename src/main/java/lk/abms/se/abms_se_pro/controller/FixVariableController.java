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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.AbmsSeProApplication;
import lk.abms.se.abms_se_pro.bussiness.PaymentVariableManagementService;
import lk.abms.se.abms_se_pro.bussiness.WorkerCategoryManagementService;
import lk.abms.se.abms_se_pro.model.PaymentVariableDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import lk.abms.se.abms_se_pro.util.ValidationNumbers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FixVariableController<T> {

    @FXML
    private JFXTextField txtNomalHours;
    @FXML
    private TableView<PaymentVariableDTO> tblFixVariable;
    @FXML
    private JFXTextField txtFixId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtNomalRate;
    @FXML
    private JFXComboBox CmbGroupNumber;
    @FXML
    private JFXTextField txtGroupName;
    @FXML
    private JFXTextField txtOtRate;
    @FXML
    private JFXTextField txtBonus;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private ImageView img_Back;


    public void initialize() {

        loadAllPaymentVariables();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        setWorkerGroups();
        setPayVId();
        tblFixVariable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("svID"));
        tblFixVariable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblFixVariable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nomalRate"));
        tblFixVariable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("otReate"));
        tblFixVariable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("bonuseReate"));
        tblFixVariable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblFixVariable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("catName"));
        tblFixVariable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("nomalHours"));


        tblFixVariable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PaymentVariableDTO>() {
            @Override
            public void changed(ObservableValue<? extends PaymentVariableDTO> observable, PaymentVariableDTO oldValue, PaymentVariableDTO c) {
                if (c == null) {
                    return;
                }
                btnSave.setDisable(true);
                btnDelete.setDisable(false);
                btnUpdate.setDisable(false);
                txtDescription.setText(c.getDescription());
                txtBonus.setText(c.getBonuseReate() + "");
                txtFixId.setText(c.getSvID());
                txtGroupName.setText(c.getCatName());
                CmbGroupNumber.setValue(c.getWorkerCateNo());
                txtName.setText(c.getName());
                txtNomalRate.setText(c.getNomalRate() + "");
                txtOtRate.setText(c.getOtReate() + "");
                txtNomalHours.setText(c.getNomalHours()+"");

            }
        });


    }


    private PaymentVariableManagementService paymentVariableManagementService = AbmsSeProApplication.ctx.getBean(PaymentVariableManagementService.class);
    private WorkerCategoryManagementService workerCategoryManagementService = AbmsSeProApplication.ctx.getBean(WorkerCategoryManagementService.class);
    private List<WorkerCategoryDTO> categoryDTOList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(FixVariableController.class);


    @FXML
    private void CmbGroupNumber_OnAction(ActionEvent actionEvent) {

        if (null == CmbGroupNumber.getValue()) {
            return;
        }

        String groupId = CmbGroupNumber.getValue().toString();
        for (WorkerCategoryDTO c : categoryDTOList) {
            if (c.getCat_Id().equals(groupId)) {

                if (c.getSalaryType().equals("Fix")) {
                    txtNomalRate.setPromptText("Basic Salary (Rs.)");
                } else {
                    txtNomalRate.setPromptText("Nomal Rate For Hour (Rs.)");
                }
                txtGroupName.setText(c.getCat_Name());
                return;
            }
        }

    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtFixId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Variable Id Is Empty !", ButtonType.OK).showAndWait();
            txtFixId.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Payment Variable Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }

        if (null == CmbGroupNumber.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Group Type!", ButtonType.OK).showAndWait();
            CmbGroupNumber.requestFocus();
            return;
        }

        if (txtNomalRate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Is Empty !", ButtonType.OK).showAndWait();
            txtNomalRate.requestFocus();
            return;
        }

        if (txtOtRate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " OT Rate Is Empty !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }
        if (txtNomalHours.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Enter Nomal Hours !", ButtonType.OK).showAndWait();
            txtNomalHours.requestFocus();
            return;
        }

        if (txtBonus.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Bonuse Rate Is Empty !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }


        if (!ValidationNumbers.isFloat(txtNomalRate.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Should be Number !", ButtonType.OK).showAndWait();
            txtNomalRate.requestFocus();
            return;
        }

        if (!ValidationNumbers.isFloat(txtOtRate.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " OT Rate Should be Number !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }
        if (!ValidationNumbers.isFloat(txtBonus.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Bonus Rate Should be Number !", ButtonType.OK).showAndWait();
            txtBonus.requestFocus();
            return;
        }

        if (!ValidationNumbers.isInt(txtNomalHours.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Should Be Number !", ButtonType.OK).showAndWait();
            txtNomalHours.requestFocus();
            return;
        }



        String fvId = txtFixId.getText().trim();
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        String catId = CmbGroupNumber.getValue().toString();
        float nomalRate = Float.parseFloat(txtNomalRate.getText().trim());
        float bonus = Float.parseFloat(txtBonus.getText().trim());
        float otRate = Float.parseFloat(txtOtRate.getText().trim());
        WorkerCategoryDTO group = findWorkerGroups(catId);
        int nomalHours =Integer.parseInt(txtNomalHours.getText().trim());


        try {
            paymentVariableManagementService.CreatePaymentVariable(new PaymentVariableDTO(fvId, name, nomalRate, otRate, bonus, description, group.getCat_Id(), group.getCat_Name(),nomalHours));

            new Alert(Alert.AlertType.CONFIRMATION, " Payment Variable Created  !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

            logger.debug(e);
        }

        reSet();

    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {

        if (txtFixId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Variable Id Is Empty !", ButtonType.OK).showAndWait();
            txtFixId.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Payment Variable Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }

        if (null == CmbGroupNumber.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Group Type!", ButtonType.OK).showAndWait();
            CmbGroupNumber.requestFocus();
            return;
        }

        if (txtNomalRate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Is Empty !", ButtonType.OK).showAndWait();
            txtNomalRate.requestFocus();
            return;
        }

        if (txtOtRate.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " OT Rate Is Empty !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }

        if (txtNomalHours.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Enter Nomal Hours !", ButtonType.OK).showAndWait();
            txtNomalHours.requestFocus();
            return;
        }

        if (txtBonus.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Bonuse Rate Is Empty !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }


        if (!ValidationNumbers.isFloat(txtNomalRate.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Should be Number !", ButtonType.OK).showAndWait();
            txtNomalRate.requestFocus();
            return;
        }

        if (!ValidationNumbers.isFloat(txtOtRate.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " OT Rate Should be Number !", ButtonType.OK).showAndWait();
            txtOtRate.requestFocus();
            return;
        }
        if (!ValidationNumbers.isFloat(txtBonus.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Bonus Rate Should be Number !", ButtonType.OK).showAndWait();
            txtBonus.requestFocus();
            return;
        }

        if (!ValidationNumbers.isInt(txtNomalHours.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Nomal Rate Should Be Number !", ButtonType.OK).showAndWait();
            txtNomalHours.requestFocus();
            return;
        }

        String fvId = txtFixId.getText().trim();
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        String catId = CmbGroupNumber.getValue().toString();
        float nomalRate = Float.parseFloat(txtNomalRate.getText().trim());
        float bonus = Float.parseFloat(txtBonus.getText().trim());
        float otRate = Float.parseFloat(txtOtRate.getText().trim());
        WorkerCategoryDTO group = findWorkerGroups(catId);
        int nomalHours =Integer.parseInt(txtNomalHours.getText().trim());

        try {
            paymentVariableManagementService.UpdatePaymentVariable(new PaymentVariableDTO(fvId, name, nomalRate, otRate, bonus, description, group.getCat_Id(), group.getCat_Name(),nomalHours));

            new Alert(Alert.AlertType.CONFIRMATION, " Payment Variable Updated  !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();
            e.printStackTrace();
            logger.debug(e);
        }

        reSet();

    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
        try {
            paymentVariableManagementService.deletePaymentVariable(txtFixId.getText().trim());
            new Alert(Alert.AlertType.CONFIRMATION, " Payment Variable Deleted !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error!", ButtonType.OK).showAndWait();
            e.printStackTrace();
        }
        reSet();

    }

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Main_Page.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) img_Back.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();
    }


    public void setWorkerGroups() {
        ArrayList<String> list = new ArrayList<>();
        try {
            List<WorkerCategoryDTO> cg = workerCategoryManagementService.findAllEmpCategory();
            categoryDTOList = cg;
            for (WorkerCategoryDTO c : cg) {
                list.add(c.getCat_Id());
            }
            CmbGroupNumber.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WorkerCategoryDTO findWorkerGroups(String id) {
        for (WorkerCategoryDTO c : categoryDTOList) {
            if (c.getCat_Id().equals(id)) {
                return c;
            }
        }
        return null;

    }

    private void loadAllPaymentVariables() {
        List<PaymentVariableDTO> temp = null;
        try {
            temp = paymentVariableManagementService.findAllPaymentVariable();
            if (null == temp) {
                return;
            }
            logger.info("................" + temp);
            tblFixVariable.setItems(FXCollections.observableArrayList(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setPayVId() {
        ObservableList<PaymentVariableDTO> items = tblFixVariable.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtFixId.setText("PVNO" + 1);
            return;
        }
        for (PaymentVariableDTO c : items) {
            String subCId = c.getSvID();
            int i = Integer.parseInt(subCId.substring(4));
            if (max < i) {
                max = i;
            }
            txtFixId.setText("PVNO" + (++max));

        }

    }

    private void reSet() {
        txtFixId.clear();
        txtName.clear();
        txtDescription.clear();
        txtOtRate.clear();
        txtNomalRate.clear();
        txtBonus.clear();
        txtGroupName.clear();
        CmbGroupNumber.setValue(null);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        txtNomalHours.clear();
        txtNomalRate.setPromptText("Nomal Rate For Hour (Rs .)");
        loadAllPaymentVariables();
        setPayVId();

    }

}
