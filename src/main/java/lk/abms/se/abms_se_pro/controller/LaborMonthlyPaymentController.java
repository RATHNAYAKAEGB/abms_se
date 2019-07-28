package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
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
import lk.abms.se.abms_se_pro.bussiness.LaborPayementManegeService;
import lk.abms.se.abms_se_pro.bussiness.MainAccountMangeService;
import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.bussiness.WorkerSalaryPaymetInfoService;
import lk.abms.se.abms_se_pro.converter.DateForMatter;
import lk.abms.se.abms_se_pro.entity.WorkerSalaryPaymetInfo;
import lk.abms.se.abms_se_pro.model.CustomEntityPayamentDTO;
import lk.abms.se.abms_se_pro.model.WorkerSalaryPaymetInfoDTO;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaborMonthlyPaymentController <T>{
    @FXML
    private ImageView img_Back;
    @FXML
    private JFXTextField txtLaborIdFFL;
    @FXML
    private JFXDatePicker txtStartDateFFL;
    @FXML
    private JFXDatePicker txtEndDateFFL;
    @FXML
    private JFXButton btnFindForLabour;
    @FXML
    private JFXDatePicker txtStartDateFFAL;
    @FXML
    private JFXDatePicker txtEndDateFFAL;
    @FXML
    private JFXButton btnFind_For_All_Labor;
    @FXML
    private JFXButton btnPay;
    @FXML
    private JFXButton btnClear;
    @FXML
    private JFXDatePicker txtStartDateAllFHOM;
    @FXML
    private JFXDatePicker txtEndDateAllFHOM;
    @FXML
    private JFXButton btnFind_History_Of_Month;
    @FXML
    private JFXTextField txtFHOLaborId;
    @FXML
    private JFXDatePicker txtStartDateFHOL;
    @FXML
    private JFXDatePicker txtEndDateFHOL;
    @FXML
    private JFXButton btnFindHistoryOfLabour;
    @FXML
    private TableView<CustomEntityPayamentDTO> tblLaborPayment;

   private LaborPayementManegeService laborPayementManegeService =AbmsSeProApplication.ctx.getBean(LaborPayementManegeService .class);

    private WorkerSalaryPaymetInfoService workerSalaryPaymetInfoService = AbmsSeProApplication.ctx.getBean(WorkerSalaryPaymetInfoService.class);

    public void initialize() {

        tblLaborPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("worker_Id"));
        tblLaborPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullName"));
//        tblLaborPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("catName"));
        tblLaborPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("siteName"));
        tblLaborPayment.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("atDate"));
        tblLaborPayment.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("inTime"));
        tblLaborPayment.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("outTime"));
        tblLaborPayment.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("numberOfHours"));
        tblLaborPayment.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("advanceAmmount"));
        tblLaborPayment.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("nomalHoursRate"));
        tblLaborPayment.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("OtRate"));
        tblLaborPayment.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("nolaHoursPayment"));
        tblLaborPayment.getColumns().get(11).setCellValueFactory(new PropertyValueFactory<>("otPayment"));
//        tblLaborPayment.getColumns().get(12).setCellValueFactory(new PropertyValueFactory<>("openBlance"));
        tblLaborPayment.getColumns().get(12).setCellValueFactory(new PropertyValueFactory<>("grossPayment"));
        tblLaborPayment.getColumns().get(13).setCellValueFactory(new PropertyValueFactory<>("netPayment"));





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

    @FXML
    private void btnFindForLabour_OnAction(ActionEvent actionEvent) {

        if ( txtLaborIdFFL.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtLaborIdFFL.requestFocus();
            return;
        }

        if (null == txtStartDateFFL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtStartDateFFL.requestFocus();
            return;
        }
        if (null == txtEndDateFFL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtEndDateFFL.requestFocus();
            return;
        }


        LocalDate dayEnd = txtEndDateFFL.getValue();
        LocalDate dayStart = txtStartDateFFL.getValue();
        String empId =txtLaborIdFFL.getText().trim().toUpperCase();
        List<CustomEntityPayamentDTO> list = laborPayementManegeService.getAllAttendenceForWorkerId(dayStart, dayEnd,empId);
        System.out.println(list);
        tblLaborPayment.setItems(FXCollections.observableArrayList(list));


    }

    @FXML
    private void btnFind_For_All_Labor_onAction(ActionEvent actionEvent) {

        if (null == txtStartDateFFAL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtStartDateFFAL.requestFocus();
            return;
        }
        if (null == txtEndDateFFAL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select End Date!", ButtonType.OK).showAndWait();
            txtEndDateFFAL.requestFocus();
            return;
        }

        LocalDate dayEnd = txtEndDateFFAL.getValue();
        LocalDate dayStart = txtStartDateFFAL.getValue();
        List<CustomEntityPayamentDTO> list = laborPayementManegeService.getAllAttendenceForMonth(dayStart, dayEnd);
        System.out.println(list);
        tblLaborPayment.setItems(FXCollections.observableArrayList(list));






    }

    @FXML
    private void btnPay_OnAction(ActionEvent actionEvent) {

        if(tblLaborPayment.getItems().size()>0){

            List<CustomEntityPayamentDTO> items = tblLaborPayment.getItems();
            List<WorkerSalaryPaymetInfoDTO> listDto = new ArrayList<>();

            for (CustomEntityPayamentDTO c :items){
                WorkerSalaryPaymetInfoDTO x = new WorkerSalaryPaymetInfoDTO(c.getNomalHoursRate(), c.getOtRate(), c.getNolaHoursPayment(), c.getOtPayment(), c.getOpenBlance(), c.getGrossPayment(), c.getNetPayment(), c.getWorker_Id(), c.getAtDate(), null);
                listDto.add( new WorkerSalaryPaymetInfoDTO(c.getNomalHoursRate(),c.getOtRate(),c.getNolaHoursPayment(),c.getOtPayment(),0,c.getGrossPayment(),c.getNetPayment(),c.getWorker_Id(),c.getAtDate(),null));

                System.out.println("ccccccc"+c);
                System.out.println("xxxxxxxxxxx "+x);

            }

//            workerSalaryPaymetInfoService.save(listDto);
            new Alert(Alert.AlertType.CONFIRMATION, "Payemt Successfully Recorded Now you can get Payment Details", ButtonType.OK).showAndWait();
            tblLaborPayment.setItems(null);
            tblLaborPayment.refresh();
        }
    }

    @FXML
    private void btnClear_OnAction(ActionEvent actionEvent) {

        btnPay.setDisable(false);


    }

    @FXML
    private void btnFindHistoryOfLabour_OnAction(ActionEvent actionEvent) {

        btnPay.setDisable(true);

        if ( txtFHOLaborId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtFHOLaborId.requestFocus();
            return;
        }

        if (null == txtStartDateFHOL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtStartDateFHOL.requestFocus();
            return;
        }
        if (null == txtEndDateFHOL.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtEndDateFHOL.requestFocus();
            return;
        }

        LocalDate dayEnd = txtEndDateFHOL.getValue();
        LocalDate dayStart = txtStartDateFHOL.getValue();
        String workerId =txtFHOLaborId.getText().trim();
        List<CustomEntityPayamentDTO> list = laborPayementManegeService.getAllAttendenceForWorkerIdOld(dayStart, dayEnd,workerId);
        System.out.println(list);
        tblLaborPayment.setItems(FXCollections.observableArrayList(list));




    }

    public void btnFind_History_Of_Month_OnAction(ActionEvent actionEvent) {


        if (null == txtEndDateAllFHOM.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtStartDateFHOL.requestFocus();
            return;
        }
        if (null == txtEndDateAllFHOM.getValue()) {
            new Alert(Alert.AlertType.ERROR, " Select Start Date!", ButtonType.OK).showAndWait();
            txtEndDateAllFHOM.requestFocus();
            return;
        }

        LocalDate dayEnd = txtEndDateAllFHOM.getValue();
        LocalDate dayStart = txtStartDateAllFHOM.getValue();
        List<CustomEntityPayamentDTO> list = laborPayementManegeService.getAllAttendenceForMonthOLD(dayStart, dayEnd);
        System.out.println(list);
        tblLaborPayment.setItems(FXCollections.observableArrayList(list));
    }
}
