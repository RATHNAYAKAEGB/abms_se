package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WorkersController {
    @FXML
    private ImageView img_Back;
    @FXML
    private JFXTextField txtWorkerID;
    @FXML
    private JFXTextField txtNice;
    @FXML
    private JFXTextField txtFullName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtPhone;
    @FXML
    private JFXComboBox cmbWorkerCategory;
    @FXML
    private JFXTextField txtWcatName;
    @FXML
    private JFXButton btnBrows;
    @FXML
    private ImageView img_PP;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXComboBox cmbSiteName;
    @FXML
    private JFXTextField txtSiteName;
    @FXML
    private TableView tblWorkers;
    @FXML
    private JFXTextField txtSearch;

    @FXML
    private void txtSearch_OnKeyPress(KeyEvent keyEvent) {
    }

    @FXML
    private void cmbSiteName_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnBrows_OnAcion(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbWorkerCategory_OnAction(ActionEvent actionEvent) {
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
