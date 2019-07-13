package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class WorkersAttendenceController {
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
    private  JFXTextField txtWorkerId;
    @FXML
    private  JFXTextField txtNic;
    @FXML
    private  JFXTextField txtWorkerName;
    @FXML
    private  JFXDatePicker txtAttendenceDate;
    @FXML
    private  JFXTimePicker txtInTime;
    @FXML
    private  JFXTimePicker txtOutTime;
    @FXML
    private  JFXTextField txtAdvancePayment;
    @FXML
    private  JFXComboBox cmbSiteNumber;
    @FXML
    private  JFXTextField txtSiteName;
    @FXML
    private  JFXTextField txtSupervisor;
    @FXML
    private  JFXButton btnAdd;
    @FXML
    private  JFXButton btnRemove;
    @FXML
    private  TableView tblAttendence;
    @FXML
    private  JFXButton btnInSert;
    @FXML
    private  ImageView img_SuperVisor;

    @FXML
    private  void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {
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
    private  void cmbSiteNumber_OnAction(ActionEvent actionEvent) {


    }

    @FXML
    private  void btnAdd_OnAction(ActionEvent actionEvent) {
        System.out.println(txtInTime.getValue());
    }

    @FXML
    private  void btnRemove_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private  void btnInSert_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnPrint_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnFind_OnAction(ActionEvent actionEvent) {
    }
}
