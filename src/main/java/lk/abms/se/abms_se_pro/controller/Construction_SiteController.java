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

public class Construction_SiteController {
    @FXML
    private JFXButton btnSave;
    @FXML
    private TableView tblSite;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXDatePicker txtRegDate;
    @FXML
    private JFXRadioButton rbIsActive;
    @FXML
    private JFXTextField txtSiteId;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXComboBox txtSupervisor;
    @FXML
    private ImageView img_supervior;
    @FXML
    private ImageView img_Back;

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
    private void txtSupervisor_OnAction(ActionEvent actionEvent) {
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
}
