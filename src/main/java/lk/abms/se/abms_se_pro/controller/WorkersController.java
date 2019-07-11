package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.AbmsSeProApplication;
import lk.abms.se.abms_se_pro.bussiness.PaymentVariableManagementService;
import lk.abms.se.abms_se_pro.bussiness.WorkerCategoryManagementService;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WorkersController {
    @FXML
    private JFXTextField txtWorkerType;
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
    private TableView tblWorkers;
    @FXML
    private JFXTextField txtSearch;

    private PaymentVariableManagementService paymentVariableManagementService = AbmsSeProApplication.ctx.getBean(PaymentVariableManagementService.class);
    private WorkerCategoryManagementService workerCategoryManagementService = AbmsSeProApplication.ctx.getBean(WorkerCategoryManagementService.class);
    private List<WorkerCategoryDTO> categoryDTOList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(WorkersController.class);
    private String img_url = " ";

    public void initialize() {
        setWorkerGroups();
    }


    @FXML
    private void txtSearch_OnKeyPress(KeyEvent keyEvent) {

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

        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Image image1 = new Image(file.toURI().toString());
            this.img_url = file.getAbsolutePath();
            ImageView ip = new ImageView(image1);
            BackgroundSize backgroundSize = new BackgroundSize(200, 222, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            img_PP.setImage(image1);
        } else {
            new Alert(Alert.AlertType.ERROR, "No Iamage Found ", ButtonType.OK).showAndWait();
        }

    }

    @FXML
    private void cmbWorkerCategory_OnAction(ActionEvent actionEvent) {

        if(null==cmbWorkerCategory.getValue()){return;}

        String groupId = cmbWorkerCategory.getValue().toString();
        for (WorkerCategoryDTO c : categoryDTOList) {
            if (c.getCat_Id().equals(groupId)) {
                txtWcatName.setText(c.getCat_Name());
                if(c.isACtive()){
                    txtWorkerType.setText("Manager Level Employee");
                }else {txtWorkerType.setText("Non Manager Level Employee");}
            }
        }

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


    public void setWorkerGroups() {
        ArrayList<String> list = new ArrayList<>();
        try {
            List<WorkerCategoryDTO> cg = workerCategoryManagementService.findAllEmpCategory();
            categoryDTOList = cg;
            for (WorkerCategoryDTO c : cg) {
                list.add(c.getCat_Id());
            }
            cmbWorkerCategory.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WorkerCategoryDTO findWorkerGroups(String id) {
        for (WorkerCategoryDTO c : categoryDTOList) {
            if (c.getCat_Id().equals(id)) {
                return c;
            }
        }
        return null;

    }
}
