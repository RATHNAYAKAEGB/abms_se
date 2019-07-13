package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.*;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.abms.se.abms_se_pro.AbmsSeProApplication;
import lk.abms.se.abms_se_pro.bussiness.SiteManagementService;
import lk.abms.se.abms_se_pro.bussiness.WorkerCategoryManagementService;
import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.model.SiteDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Construction_SiteController<T> {
    @FXML
    private JFXComboBox cmbSupervisors;
    @FXML
    private JFXTextField txtSupPhone;
    @FXML
    private JFXTextField txtSuperName;
    @FXML
    private JFXButton btnSave;
    @FXML
    private TableView<SiteDTO> tblSite;
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
    private ImageView img_supervior;
    @FXML
    private ImageView img_Back;


    private WorkerManageService workerManageService = AbmsSeProApplication.ctx.getBean(WorkerManageService.class);
    private SiteManagementService siteManagementService = AbmsSeProApplication.ctx.getBean(SiteManagementService.class);
    private List<WorkerDTO> workerDTOList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(WorkersController.class);

    public void initialize() {
        loadAllSite();
        setWorkerGroups();
        setSiteId();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        tblSite.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("siteId"));
        tblSite.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("regDate"));
        tblSite.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sitName"));
        tblSite.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSite.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("isActive"));
        tblSite.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("supName"));
        tblSite.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("supMobile"));


        tblSite.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SiteDTO>() {
            @Override
            public void changed(ObservableValue<? extends SiteDTO> observable, SiteDTO oldValue, SiteDTO c) {
                if (c == null) {
                    return;
                }
                btnSave.setDisable(true);
                btnDelete.setDisable(true);
                btnUpdate.setDisable(false);
                txtAddress.setText(c.getAddress());
                txtName.setText(c.getSitName());
                cmbSupervisors.setValue(c.getSupId());
                txtSiteId.setText(c.getSiteId());
                LocalDate date = LocalDate.parse(c.getRegDate().toString());
                txtRegDate.setValue(date);
                rbIsActive.setSelected(c.getIsActive().equals("IsActive"));

            }
        });


    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtSiteId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Site Id Is Empty !", ButtonType.OK).showAndWait();
            txtSiteId.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Site Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }
        if (txtAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Full Name Is Empty !", ButtonType.OK).showAndWait();
            txtAddress.requestFocus();
            return;
        }

        if (null == cmbSupervisors.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Supervisor !", ButtonType.OK).showAndWait();
            cmbSupervisors.requestFocus();
            return;
        }

        if(!rbIsActive.isSelected()){
            new Alert(Alert.AlertType.ERROR, "  Please Select Is Active !", ButtonType.OK).showAndWait();
            rbIsActive.requestFocus();
            return;
        }

        String sitId = txtSiteId.getText().trim();
        String name = txtName.getText().trim();
        String address = txtAddress.getText().trim();
        System.out.println("................");
        String supId =cmbSupervisors.getValue().toString().trim();
        String supName=txtSuperName.getText().trim();
        String supPhone =txtSupPhone.getText().trim();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date regDate = null;
        try {
            logger.info("........................");
            regDate = simpleDateFormat.parse(txtRegDate.getValue().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            siteManagementService.createSite(new SiteDTO(sitId,regDate,name,address,"IsActive",supId,supName,supPhone));
            new Alert(Alert.AlertType.CONFIRMATION, " Site Created Successfully  !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
        reSet();
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {

        if (txtSiteId.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Site Id Is Empty !", ButtonType.OK).showAndWait();
            txtSiteId.requestFocus();
            return;
        }

        if (txtName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Site Name Is Empty !", ButtonType.OK).showAndWait();
            txtName.requestFocus();
            return;
        }
        if (txtAddress.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Full Name Is Empty !", ButtonType.OK).showAndWait();
            txtAddress.requestFocus();
            return;
        }

        if (null == cmbSupervisors.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Supervisor !", ButtonType.OK).showAndWait();
            cmbSupervisors.requestFocus();
            return;
        }

//        if(!rbIsActive.isSelected()){
//            new Alert(Alert.AlertType.ERROR, "  Please Select Is Active !", ButtonType.OK).showAndWait();
//            rbIsActive.requestFocus();
//            return;
//        }

        String sitId = txtSiteId.getText().trim();
        String name = txtName.getText().trim();
        String address = txtAddress.getText().trim();
        System.out.println("................");
        String supId =cmbSupervisors.getValue().toString().trim();
        String supName=txtSuperName.getText().trim();
        String supPhone =txtSupPhone.getText().trim();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date regDate = null;
        String isActive =(rbIsActive.isSelected())? "IsActive":"InActive";
        try {
            logger.info("........................");
            regDate = simpleDateFormat.parse(txtRegDate.getValue().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            siteManagementService.updateSite(new SiteDTO(sitId,regDate,name,address,isActive,supId,supName,supPhone));
            new Alert(Alert.AlertType.CONFIRMATION, " Site Updated Successfully  !", ButtonType.OK).showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
        reSet();
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbSupervisors_OnAction(ActionEvent actionEvent) {

        String groupId = cmbSupervisors.getValue().toString();
        for (WorkerDTO c : workerDTOList) {
            if (c.getWorkerId().equals(groupId)) {
                txtSuperName.setText(c.getFullName());
                txtSupPhone.setText(c.getMobile());
                img_supervior.setImage(new Image(new ByteArrayInputStream(c.getImg())));//Byte Array to Image View
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
            List<WorkerDTO> cg = workerManageService.findAllWorkers();
            workerDTOList = cg;
            for (WorkerDTO c : cg) {
                if (!c.getCatType().equals("Managerial")) {
                    continue;
                }
                list.add(c.getWorkerId());
            }
            cmbSupervisors.setItems(FXCollections.observableArrayList(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WorkerDTO findWorkerGroups(String id) {
        for (WorkerDTO c : workerDTOList) {
            if (c.getWorkerId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private void setSiteId() {
        ObservableList<SiteDTO> items = tblSite.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtSiteId.setText("SNO0" + 1);
            return;
        }
        for (SiteDTO c : items) {
            String subCId = c.getSiteId();
            int i = Integer.parseInt(subCId.substring(4));
            if (max < i) {
                max = i;
            }
            txtSiteId.setText("SNO0" + (++max));

        }

    }
    private void loadAllSite() {

        try {
            List<SiteDTO> temp = siteManagementService.findAllSite();
            if (null == temp) {
                return;
            }
            logger.info("................" + temp);
            tblSite.setItems(FXCollections.observableArrayList(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void reSet() {
        txtAddress.clear();
        txtSiteId.clear();
        txtRegDate.setValue(null);
        txtSupPhone.clear();
        txtName.clear();
        txtSiteId.setText("");
        txtSuperName.clear();
        img_supervior.setImage(null);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        loadAllSite();
        setSiteId();

    }

}
