package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.AbmsSeProApplication;
import lk.abms.se.abms_se_pro.bussiness.WorkerCategoryManagementService;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Workers_Category_ManagementController<T> {
    @FXML
    private JFXTextField txtCatID;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private TableView<WorkerCategoryDTO> tblWorkerCategory;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXComboBox cmbSalaryType;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXRadioButton rbIsActive;


    private WorkerCategoryManagementService workerCategoryManagementService = AbmsSeProApplication.ctx.getBean(WorkerCategoryManagementService.class);


    public void initialize() {

        loadAllWorkerCategory();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        rbIsActive.setSelected(true);
        setId();
        ArrayList<String> types = new ArrayList<>();
        types.add("Fix");
        types.add("Dynamic");
        cmbSalaryType.setItems(FXCollections.observableArrayList(types));

        tblWorkerCategory.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cat_Id"));
        tblWorkerCategory.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cat_Name"));
        tblWorkerCategory.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("salaryType"));
        tblWorkerCategory.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblWorkerCategory.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("isACtive"));


        tblWorkerCategory.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WorkerCategoryDTO>() {
            @Override
            public void changed(ObservableValue<? extends WorkerCategoryDTO> observable, WorkerCategoryDTO oldValue, WorkerCategoryDTO c) {
                if (c == null) {
                    return;
                }
                btnSave.setDisable(true);
                btnDelete.setDisable(false);
                btnUpdate.setDisable(false);
                txtCatID.setText(c.getCat_Id());
                txtDescription.setText(c.getDescription());
                txtName.setText(c.getCat_Name());
                cmbSalaryType.setValue(c.getSalaryType());
                rbIsActive.setSelected(c.isACtive());


            }
        });


    }


    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtCatID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Worker Category Id Is Empty !", ButtonType.OK).showAndWait();
            txtCatID.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Category Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }

        if (null == cmbSalaryType.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Salary Type!", ButtonType.OK).showAndWait();
            cmbSalaryType.requestFocus();
            return;
        }

        String catId = txtCatID.getText().trim();
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        String salaryType = cmbSalaryType.getValue().toString();
        boolean isActive = rbIsActive.isSelected();

        WorkerCategoryDTO dto = new WorkerCategoryDTO(catId, name, salaryType, description, isActive, null);
        try {
            workerCategoryManagementService.CreateNewEmpCategory(dto);
            new Alert(Alert.AlertType.CONFIRMATION, " Worker Group Created  !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

            e.printStackTrace();
        }

        reSet();
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {

        if (txtCatID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Worker Category Id Is Empty !", ButtonType.OK).showAndWait();
            txtCatID.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Category Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }

        if (null == cmbSalaryType.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Salary Type!", ButtonType.OK).showAndWait();
            cmbSalaryType.requestFocus();
            return;
        }

        String catId = txtCatID.getText().trim();
        String name = txtName.getText().trim();
        String description = txtDescription.getText().trim();
        String salaryType = cmbSalaryType.getValue().toString();
        boolean isActive = rbIsActive.isSelected();

        WorkerCategoryDTO dto = new WorkerCategoryDTO(catId, name, salaryType, description, isActive, null);
        try {
            workerCategoryManagementService.UpdateEmpCategory(dto);
            new Alert(Alert.AlertType.CONFIRMATION, " Worker Group Updated !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();

            e.printStackTrace();
        }

        reSet();
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {

        try {
            workerCategoryManagementService.deleteCategory(txtCatID.getText().trim());
            new Alert(Alert.AlertType.CONFIRMATION, " Worker Group Delete !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error!", ButtonType.OK).showAndWait();
            e.printStackTrace();
        }
        reSet();
    }

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

    private void setId() {
        ObservableList<WorkerCategoryDTO> list = tblWorkerCategory.getItems();
        if (list.size() == 0) {
            txtCatID.setText("WGO01");
            return;
        }
        int max = 0;
        for (WorkerCategoryDTO c : list) {
            if (max < Integer.parseInt(c.getCat_Id().substring(4))) {
                max = Integer.parseInt(c.getCat_Id().substring(4));
            }
            txtCatID.setText("WGO0" + (++max));
        }
    }


    private void loadAllWorkerCategory() {

        try {
            List<WorkerCategoryDTO> allEmpCategory = workerCategoryManagementService.findAllEmpCategory();
            tblWorkerCategory.setItems(FXCollections.observableArrayList(allEmpCategory));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reSet() {
        txtCatID.clear();
        txtName.clear();
        txtDescription.clear();
        rbIsActive.setSelected(true);
        cmbSalaryType.setValue(null);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        loadAllWorkerCategory();
        setId();

    }

}
