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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class FixVariableController {

    @FXML
    private TableView tblFixVariable;
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

    @FXML
    private void CmbGroupNumber_OnAction(ActionEvent actionEvent) {
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
