package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.*;
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
import lk.abms.se.abms_se_pro.bussiness.AttendentenceManageService;
import lk.abms.se.abms_se_pro.bussiness.SiteManagementService;
import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.converter.WorkingHoursCalculate;
import lk.abms.se.abms_se_pro.model.AttendenceDTO;
import lk.abms.se.abms_se_pro.model.SiteDTO;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import lk.abms.se.abms_se_pro.util.ValidationNumbers;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkersAttendenceController<T> {
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXButton btnPrint;
    @FXML
    private JFXTextField txtEmpId;
    @FXML
    private JFXDatePicker txtStartDate;
    @FXML
    private JFXDatePicker txtEndDate;
    @FXML
    private JFXButton btnFind;
    @FXML
    private ImageView img_Back;
    @FXML
    private JFXTextField txtWorkerId;
    @FXML
    private JFXTextField txtNic;
    @FXML
    private JFXTextField txtWorkerName;
    @FXML
    private JFXDatePicker txtAttendenceDate;
    @FXML
    private JFXTimePicker txtInTime;
    @FXML
    private JFXTimePicker txtOutTime;
    @FXML
    private JFXTextField txtAdvancePayment;
    @FXML
    private JFXComboBox cmbSiteNumber;
    @FXML
    private JFXTextField txtSiteName;
    @FXML
    private JFXTextField txtSupervisor;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private TableView<AttendenceDTO> tblAttendence;
    @FXML
    private JFXButton btnInSert;
    @FXML
    private ImageView img_SuperVisor;

    private WorkerManageService workerManageService = AbmsSeProApplication.ctx.getBean(WorkerManageService.class);
    private SiteManagementService siteManagementService = AbmsSeProApplication.ctx.getBean(SiteManagementService.class);
    private AttendentenceManageService attendentenceManageService =AbmsSeProApplication.ctx.getBean(AttendentenceManageService.class);
    private List<SiteDTO> siteDTOS = new ArrayList<>();

    public void initialize() {
        setSitNumbers();
        btnRemove.setDisable(true);
        tblAttendence.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("siteNumber"));
        tblAttendence.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("siteName"));
        tblAttendence.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("supervisor"));
        tblAttendence.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("workerId"));
        tblAttendence.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblAttendence.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("workerName"));
        tblAttendence.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("atDate"));
        tblAttendence.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("inTime"));
        tblAttendence.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("outTime"));
        tblAttendence.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("advanceAmount"));
        tblAttendence.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("nofHours"));

        tblAttendence.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AttendenceDTO>() {
            @Override
            public void changed(ObservableValue<? extends AttendenceDTO> observable, AttendenceDTO oldValue, AttendenceDTO c) {
                if (c == null) {
                    return;
                }
                btnRemove.setDisable(false);
                btnAdd.setText("Update");
                cmbSiteNumber.setValue(c.getSiteNumber());
                txtSiteName.setText(c.getSiteName());
                txtSupervisor.setText(c.getSupervisor());
                txtEmpId.setText(c.getWorkerId());
                txtWorkerId.setText(c.getWorkerId());
                txtWorkerName.setText(c.getWorkerName());
                txtAttendenceDate.setValue(LocalDate.parse(c.getAtDate().toString()));
                txtInTime.setValue(LocalTime.parse(c.getInTime().toString()));
                txtInTime.setValue(LocalTime.parse(c.getInTime().toString()));
                txtAdvancePayment.setText(c.getAdvanceAmount() + "");
                txtNic.setText(c.getNic());
                txtWorkerId.setEditable(false);
            }
        });

    }

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Main_Page.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) btnAdd.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();
    }

    @FXML
    private void cmbSiteNumber_OnAction(ActionEvent actionEvent) {
        if(null==cmbSiteNumber.getValue()){return;}
        String sitNo = cmbSiteNumber.getValue().toString();
        for (SiteDTO d : siteDTOS) {
            if (d.getSiteId().equals(sitNo)) {
                txtSiteName.setText(d.getSitName());
                txtSupervisor.setText(d.getSupName());
            }
        }
    }

    @FXML
    private void btnAdd_OnAction(ActionEvent actionEvent) {

        if (null == cmbSiteNumber.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Site Number!", ButtonType.OK).showAndWait();
            cmbSiteNumber.requestFocus();
            return;
        }

        if (txtWorkerId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Please Enter Worker number And Hit Enter !", ButtonType.OK).showAndWait();
            txtWorkerId.requestFocus();
            return;
        }

        if (txtNic.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Please Enter Worker number And Hit Enter !", ButtonType.OK).showAndWait();
            txtNic.requestFocus();
            return;
        }

        if (null == txtAttendenceDate.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Attendence Date !", ButtonType.OK).showAndWait();
            txtAttendenceDate.requestFocus();
            return;
        }

        if (null == txtInTime.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select In Time !", ButtonType.OK).showAndWait();
            txtInTime.requestFocus();
            return;
        }

        if (null == txtOutTime.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select In Time !", ButtonType.OK).showAndWait();
            txtOutTime.requestFocus();
            return;
        }

        if (txtAdvancePayment.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Enter Advance Payment Details !", ButtonType.OK).showAndWait();
            txtAdvancePayment.requestFocus();
            return;
        }
        if (!ValidationNumbers.isFloat(txtAdvancePayment.getText().trim())) {
            new Alert(Alert.AlertType.ERROR, " Advance Payment Enter Number !", ButtonType.OK).showAndWait();
            txtAdvancePayment.requestFocus();
            return;
        }

        String sitName = txtSiteName.getText().trim();
        String sitId = cmbSiteNumber.getValue().toString();
        String supervisor = txtSupervisor.getText().trim();
        String workerId = txtWorkerId.getText().trim().toUpperCase();
        String nic = txtNic.getText().trim();
        String workerName = txtWorkerName.getText().trim();
        LocalDate atDate = txtAttendenceDate.getValue();
        LocalTime inTime = txtInTime.getValue();
        LocalTime outTime = txtOutTime.getValue();
        float numOfHours = WorkingHoursCalculate.findNumOfHours(inTime, outTime);

        if(numOfHours<0){
            new Alert(Alert.AlertType.ERROR, " Working Hours Is Less Than Zero Please Check Hours He Worked  !", ButtonType.OK).showAndWait();
            txtOutTime.requestFocus();
            return;
        }

        if(LocalDate.now().isBefore(atDate)){
            new Alert(Alert.AlertType.ERROR, "You Can't Enter Upcoming Date", ButtonType.OK).showAndWait();
            txtAttendenceDate.requestFocus();
            return;
        }

        float addvanceAmout = Float.parseFloat(txtAdvancePayment.getText().trim());
        AttendenceDTO dto = new AttendenceDTO(sitId, sitName, supervisor, workerId, nic, workerName, atDate, inTime, outTime, false, addvanceAmout,numOfHours);

        if (btnAdd.getText().trim().equals("Update")) {

            ObservableList<AttendenceDTO> items = tblAttendence.getItems();
            for (AttendenceDTO d : items) {
                if (d.getWorkerId().equals(txtEmpId.getText().trim())) {
                    tblAttendence.getItems().remove(d);
                    tblAttendence.getItems().add(dto);
                    tblAttendence.refresh();
                    break;
                }
            }

        } else {
            ObservableList<AttendenceDTO> items = tblAttendence.getItems();
            for (AttendenceDTO d : items) {
                if (d.getWorkerId().equals(txtWorkerId.getText().trim())&& d.getAtDate().equals(atDate)) {
                    new Alert(Alert.AlertType.ERROR, " Already Attendence for Selected Date Worker : "+d.getWorkerName(), ButtonType.OK).showAndWait();
                    return;
                }
            }
            tblAttendence.getItems().add(dto);
        }

        reSet1();
    }

    @FXML
    private void btnRemove_onAction(ActionEvent actionEvent) {

        if(!txtNic.getText().trim().isEmpty()&& !cmbSiteNumber.getValue().toString().isEmpty()){
            ObservableList<AttendenceDTO> items = tblAttendence.getItems();
            for (AttendenceDTO d : items) {
                if (d.getWorkerId().equals(txtEmpId.getText().trim())) {
                    tblAttendence.getItems().remove(d);
                    new Alert(Alert.AlertType.CONFIRMATION, " Attendence Record Removed !", ButtonType.OK).showAndWait();
                    tblAttendence.refresh();
                    return;
                }
            }
        }

    }

    @FXML
    private void btnInSert_onAction(ActionEvent actionEvent) {

        if(tblAttendence.getItems().size()>0){
            List<AttendenceDTO> items = tblAttendence.getItems();
            try {
                attendentenceManageService.createAttendence(items);
                new Alert(Alert.AlertType.CONFIRMATION, " Attendence Recorded Successfully !", ButtonType.OK).showAndWait();

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

            }


        }
        reSet2();

    }

    @FXML
    private void btnPrint_OnAction(ActionEvent actionEvent) throws ParseException {

    }

    @FXML
    private void btnFind_OnAction(ActionEvent actionEvent) {

        btnInSert.setDisable(true);

        if(txtEmpId.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR, " Enter Attendence Date!", ButtonType.OK).showAndWait();

        }
        if (null == txtStartDate.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date !", ButtonType.OK).showAndWait();
            txtAttendenceDate.requestFocus();
            return;
        }
        if (null == txtEndDate.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select End Date !", ButtonType.OK).showAndWait();
            txtAttendenceDate.requestFocus();
            return;
        }

        String emp = txtEmpId.getText().trim();
        Date e =DateForMatter.getFortmatteredDate(txtEndDate.getValue());
        Date s =DateForMatter.getFortmatteredDate(txtStartDate.getValue());

        try {
            List<AttendenceDTO> list = attendentenceManageService.findAllMonthlyOneEmpAttendence(emp, s, e);
            tblAttendence.getItems().removeAll();
            tblAttendence.setItems(FXCollections.observableArrayList(list));
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @FXML
    private void txtWorkerId_OnAction(ActionEvent actionEvent) {
        if (txtWorkerId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Enter WorkerId", ButtonType.OK).showAndWait();
        }
        try {
            WorkerDTO workerDTO = workerManageService.findByWorkerId(txtWorkerId.getText().trim().toUpperCase());
            if (null == workerDTO) {
                return;
            }
            txtNic.setText(workerDTO.getNic());
            txtWorkerName.setText(workerDTO.getFullName());
            if(null==workerDTO){return;}
            img_SuperVisor.setImage(new Image(new ByteArrayInputStream(workerDTO.getImg())));//Byte Array to Image View
            txtWorkerId.setText(workerDTO.getWorkerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void txtNic_OnAction(ActionEvent actionEvent) {
        if (txtNic.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please Nic WorkerId", ButtonType.OK).showAndWait();
        }
        try {
            WorkerDTO workerDTO = workerManageService.findByWorkerId(txtNic.getText().trim());
            if (null == workerDTO) {
                return;
            }
//            txtNic.setText(workerDTO.getNic());
            txtWorkerId.setText(workerDTO.getWorkerId());
            txtWorkerName.setText(workerDTO.getFullName());
            img_SuperVisor.setImage(new Image(new ByteArrayInputStream(workerDTO.getImg())));//Byte Array to Image View

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            cmbSiteNumber.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void txtOutTime(ActionEvent actionEvent) {
    }

    private void reSet1() {
        txtSiteName.setText("");
        txtSupervisor.clear();
        txtEmpId.clear();
        txtWorkerId.clear();
        txtWorkerName.clear();
        btnAdd.setText("Add");
        txtNic.clear();
        cmbSiteNumber.setValue(null);
        txtWorkerId.setEditable(true);
    }

    private void reSet2() {
        txtSiteName.setText("");
        txtSupervisor.clear();
        txtEmpId.clear();
        txtWorkerId.clear();
        txtWorkerName.clear();
        btnAdd.setText("Add");
        txtNic.clear();
        cmbSiteNumber.setValue(null);
        txtWorkerId.setEditable(true);
        tblAttendence.getItems().removeAll();
        tblAttendence.refresh();
        txtAttendenceDate.setValue(null);
        txtInTime.setValue(null);
        txtOutTime.setValue(null);
        txtAdvancePayment.clear();
        btnInSert.setDisable(false);
        tblAttendence.setItems(null);
    }

    @FXML
    private void btnClear_OnAction(ActionEvent actionEvent) {
        reSet2();
    }
}
