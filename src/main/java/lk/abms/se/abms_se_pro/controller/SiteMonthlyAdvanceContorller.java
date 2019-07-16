package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import lk.abms.se.abms_se_pro.bussiness.*;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.model.PaymentVariableDTO;
import lk.abms.se.abms_se_pro.model.SiteAdvancesDTO;
import lk.abms.se.abms_se_pro.model.SiteDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import lk.abms.se.abms_se_pro.util.ValidationNumbers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SiteMonthlyAdvanceContorller < T>{
    @FXML
    private ImageView img_Back;
    @FXML
    private ImageView img_SuperVisor;
    @FXML
    private JFXTextField txtSiteName;
    @FXML
    private JFXComboBox cmbSiteId;
    @FXML
    private JFXTextField txtSupervisor;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXDatePicker txtIssueDate;
    @FXML
    private JFXTextField txtApId;
    @FXML
    private JFXComboBox cmbPaymentType;
    @FXML
    private JFXTextField txtcheckNumber;
    @FXML
    private TableView<SiteAdvancesDTO> tblAdvancePayment;

    private SiteManagementService siteManagementService = AbmsSeProApplication.ctx.getBean(SiteManagementService.class);
    private List<SiteDTO> siteDTOS = new ArrayList<>();
    private SiteAdvancesManageService siteAdvancesManageService = AbmsSeProApplication.ctx.getBean(SiteAdvancesManageService.class);

    public void initialize() {
        setSitNumbers();
        loadAllPaymentVariables();
        ArrayList<String> types = new ArrayList<>();
        types.add("CASH");
        types.add("CHECK");
        cmbPaymentType.setItems(FXCollections.observableArrayList(types));
        setPayId();

        tblAdvancePayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        tblAdvancePayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("payamentType"));
        tblAdvancePayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("checkNumber"));
        tblAdvancePayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("sit_Id"));
        tblAdvancePayment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("siteName"));
        tblAdvancePayment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("supervisor"));
        tblAdvancePayment.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        tblAdvancePayment.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblAdvancePayment.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("description"));


        tblAdvancePayment.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SiteAdvancesDTO>() {
            @Override
            public void changed(ObservableValue<? extends SiteAdvancesDTO> observable, SiteAdvancesDTO oldValue, SiteAdvancesDTO c) {
                if (c == null) {
                    return;
                }
                btnSave.setDisable(true);
                btnDelete.setDisable(true);
                btnUpdate.setDisable(false);
                txtDescription.setText(c.getDescription());
                txtApId.setText(c.getPaymentId());
                txtAmount.setText(c.getAmount()+"");
                txtDescription.setText(c.getDescription());
                cmbPaymentType.setValue(c.getPayamentType());
                cmbSiteId.setValue(c.getSit_Id());
                txtSupervisor.setText(c.getSupervisor());
                txtSiteName.setText(c.getSiteName());
                txtcheckNumber.setText(c.getCheckNumber());
                txtIssueDate.setValue(DateForMatter.getLocalDate(c.getIssueDate()));

            }
        });





    }

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Main_Page.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) btnDelete.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();
    }

    @FXML
    private void cmbSiteId_OnAction(ActionEvent actionEvent) {

        if(null==cmbSiteId.getValue()){return;}
        String sitno = cmbSiteId.getValue().toString();
        for (SiteDTO d : siteDTOS) {
            if (d.getSiteId().equals(sitno)) {
                txtSiteName.setText(d.getSitName());
                System.out.printf("");
                txtSupervisor.setText(d.getSupName());
            }
        }
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtApId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Id Is Empty !", ButtonType.OK).showAndWait();
            txtApId.requestFocus();
            return;
        }

        if (cmbPaymentType.getValue().toString().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Select Payment Type !", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }

        if (null == cmbPaymentType.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Payment Type !", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }
        if (null == cmbSiteId.getValue()) {
            new Alert(Alert.AlertType.ERROR, " select Site Id!", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }

        if (txtAmount.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Amount !", ButtonType.OK).showAndWait();
            txtAmount.requestFocus();
            return;
        }

        if (null==txtIssueDate.getValue()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Payment Issue Date !", ButtonType.OK).showAndWait();
            txtIssueDate.requestFocus();
            return;
        }

        if(!ValidationNumbers.isFloat(txtAmount.getText().trim())){
            new Alert(Alert.AlertType.ERROR, "Amount Should be Number!", ButtonType.OK).showAndWait();
            txtAmount.requestFocus();
            return;
        }

        if(LocalDate.now().isBefore(txtIssueDate.getValue())){
            new Alert(Alert.AlertType.ERROR, "You Can't Enter Upcoming Date", ButtonType.OK).showAndWait();
            txtIssueDate.requestFocus();
            return;
        }



        String paymentId = txtApId.getText().trim();
        String paymentType = cmbPaymentType.getValue().toString();
        String checkNumber = txtcheckNumber.getText().trim()+" ";
        String site_Id =cmbSiteId.getValue().toString().trim();
        double amout = Double.parseDouble(txtAmount.getText().trim());
        String description =txtDescription.getText().trim();
        LocalDate day = txtIssueDate.getValue();
        SiteAdvancesDTO siteAdvancesDTO = new SiteAdvancesDTO(paymentId, paymentType, checkNumber, DateForMatter.getFortmatteredDate(day), amout, description, site_Id, null, null);

        try {
            siteAdvancesManageService.saveSiteAdvances(siteAdvancesDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Information Saved !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error !", ButtonType.OK).showAndWait();

        }
        reset();
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {
        if (txtApId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Id Is Empty !", ButtonType.OK).showAndWait();
            txtApId.requestFocus();
            return;
        }

        if (cmbPaymentType.getValue().toString().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Select Payment Type !", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }

        if (null == cmbPaymentType.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Payment Type !", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }
        if (null == cmbSiteId.getValue()) {
            new Alert(Alert.AlertType.ERROR, " select Site Id!", ButtonType.OK).showAndWait();
            cmbPaymentType.requestFocus();
            return;
        }

        if (txtAmount.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Payment Amount !", ButtonType.OK).showAndWait();
            txtAmount.requestFocus();
            return;
        }

        if (null==txtIssueDate.getValue()) {
            new Alert(Alert.AlertType.ERROR, "Please Select Payment Issue Date !", ButtonType.OK).showAndWait();
            txtIssueDate.requestFocus();
            return;
        }

        if(!ValidationNumbers.isFloat(txtAmount.getText().trim())){
            new Alert(Alert.AlertType.ERROR, "Amount Should be Number!", ButtonType.OK).showAndWait();
            txtAmount.requestFocus();
            return;
        }

        if(LocalDate.now().isBefore(txtIssueDate.getValue())){
            new Alert(Alert.AlertType.ERROR, "You Can't Enter Upcoming Date", ButtonType.OK).showAndWait();
            txtIssueDate.requestFocus();
            return;
        }



        String paymentId = txtApId.getText().trim();
        String paymentType = cmbPaymentType.getValue().toString();
        String checkNumber = txtcheckNumber.getText().trim()+" ";
        String site_Id =cmbSiteId.getValue().toString().trim();
        double amout = Double.parseDouble(txtAmount.getText().trim());
        String description =txtDescription.getText().trim();
        LocalDate day = txtIssueDate.getValue();
        SiteAdvancesDTO siteAdvancesDTO = new SiteAdvancesDTO(paymentId, paymentType, checkNumber, DateForMatter.getFortmatteredDate(day), amout, description, site_Id, null, null);

        try {
            siteAdvancesManageService.updateSiteAdvances(siteAdvancesDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Information Update !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error !", ButtonType.OK).showAndWait();

        }

        reset();
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbPaymentType_OnAction(ActionEvent actionEvent) {

        if(null==cmbPaymentType.getValue()){
            return;
        }

        if(cmbPaymentType.getValue().toString().equals("CASH")){
            txtcheckNumber.setDisable(true);
            cmbSiteId.requestFocus();
        }else {
            txtcheckNumber.requestFocus();
            txtcheckNumber.setDisable(false);
        }

    }

    @FXML
    private void CheckNumber(ActionEvent actionEvent) {
    }



    public void setSitNumbers() {
        ArrayList<String> list = new ArrayList<>();
        try {
            List<SiteDTO> cg = siteManagementService.findAllSite();
            siteDTOS = cg;
            for (SiteDTO c : cg) {
                if (!c.getIsActive().equals("IsActive")) {
                    continue;
                }
                list.add(c.getSiteId());
            }
            cmbSiteId.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllPaymentVariables() {
        List<SiteAdvancesDTO> temp = null;
        try {
            temp = siteAdvancesManageService.findAllSiteAdvances();
            if (null == temp) {
                return;
            }
            tblAdvancePayment.setItems((FXCollections.observableArrayList(temp)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setPayId() {
        ObservableList<SiteAdvancesDTO> items = tblAdvancePayment.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtApId.setText("PNO0" + 1);
            return;
        }
        for (SiteAdvancesDTO c : items) {
            String subCId = c.getPaymentId();
            int i = Integer.parseInt(subCId.substring(4));
            if (max < i) {
                max = i;
            }
            txtApId.setText("PNO0" + (++max));

        }

    }

    private void reset(){

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        txtApId.clear();
        txtAmount.clear();
        txtIssueDate.setValue(null);
        txtcheckNumber.clear();
        txtDescription.clear();
        txtSiteName.clear();
        txtSupervisor.clear();
        cmbPaymentType.setValue(null);
        cmbSiteId.setValue("");
        loadAllPaymentVariables();
        setPayId();
    }
}
