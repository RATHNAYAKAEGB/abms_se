package lk.abms.se.abms_se_pro.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.bussiness.WorkerCategoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainController {


    public ImageView img_LaborPayemnt;
    @FXML
    private ImageView img_Accounts;
    @FXML
    private ImageView img_income;
    @FXML
    private ImageView img_Expenditure;
    @FXML
    private ImageView img_ManageSalary;
    @FXML
    private ImageView img_Payment_Advance;
    @FXML
    private ImageView img_Attendence;
    @FXML
    private ImageView img_Back;
    @FXML
    private Button btnTest;
    @FXML
    private ImageView img_WorkerType;
    @FXML
    private ImageView img_Workers;
    @FXML
    private ImageView img_ConstructionSite;

    @Autowired
    WorkerCategoryManagementService workerCategoryManagementService;


    @FXML
    private void img_ConstructionSite_OnClicled(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Construction_Site.fxml"));
        travalingView(root);
    }

    @FXML
    private void img_WorkerType_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Workers_Category_Management.fxml"));
        travalingView(root);
    }

    @FXML
    private void img_Workers_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Workers.fxml"));
        travalingView(root);

    }

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) {
    }

    @FXML
    private void img_ManageSalary_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/SalaryFixVariable.fxml"));
        travalingView(root);
    }

    @FXML
    private void img_Attendence_MouseClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/WorkersAttendence.fxml"));
        travalingView(root);
    }

    @FXML
    private void img_Payment_Advance_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Monthly_Site_Pyment.fxml"));
        travalingView(root);

    }

    @FXML
    private void img_income_OnClicked(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/income.fxml"));
        travalingView(root);

    }

    @FXML
    private void img_Expenditure_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Expenditure.fxml"));
        travalingView(root);
    }


    @FXML
    private void img_Accounts_OnAction(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/AccountTypes.fxml"));
        travalingView(root);
    }


    public void img_LaborPayemnt_OnClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/labor_Monthly_Payment.fxml"));
        travalingView(root);
    }


    private void travalingView(Parent root){

        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) img_Accounts.getScene().getWindow();
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
        TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
        tt.setFromX(-subScene.getWidth());
        tt.setToX(0);
        tt.play();
    }
}
