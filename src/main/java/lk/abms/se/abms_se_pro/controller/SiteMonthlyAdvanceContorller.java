package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
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
    public ImageView img_Back;
    public ImageView img_SuperVisor;
    public JFXTextField txtSiteName;
    public JFXComboBox cmbSiteId;
    public JFXTextField txtSupervisor;
    public JFXTextField txtAmount;
    public JFXTextField txtDescription;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXDatePicker txtIssueDate;
    public JFXTextField txtApId;
    public JFXComboBox cmbPaymentType;
    public JFXTextField txtcheckNumber;
    public TableView tblAdvancePayment;

    public void img_Back_OnMosueClicked(MouseEvent mouseEvent) throws IOException {
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

    public void cmbSiteId_OnAction(ActionEvent actionEvent) {
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
    }

    public void btnUpdate_OnAction(ActionEvent actionEvent) {
    }

    public void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    public void cmbPaymentType_OnAction(ActionEvent actionEvent) {
    }

    public void CheckNumber(ActionEvent actionEvent) {
    }
}
