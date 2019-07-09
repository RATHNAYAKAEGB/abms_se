package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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

public class SiteMonthlyAdvanceContorller {
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
    private TableView tblAdvancePayment;

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
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbPaymentType_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void CheckNumber(ActionEvent actionEvent) {
    }
}
