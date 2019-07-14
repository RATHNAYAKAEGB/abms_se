package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
import lk.abms.se.abms_se_pro.bussiness.WorkerManageService;
import lk.abms.se.abms_se_pro.entity.Worker;
import lk.abms.se.abms_se_pro.model.PaymentVariableDTO;
import lk.abms.se.abms_se_pro.model.WorkerCategoryDTO;
import lk.abms.se.abms_se_pro.model.WorkerDTO;
import lk.abms.se.abms_se_pro.util.ValidationNumbers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WorkersController<T> {
    @FXML
    private JFXDatePicker txtDate;
    @FXML
    private JFXTextField txtFirstName;
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
    private TableView<WorkerDTO> tblWorkers;
    @FXML
    private JFXTextField txtSearch;

    private WorkerCategoryManagementService workerCategoryManagementService = AbmsSeProApplication.ctx.getBean(WorkerCategoryManagementService.class);
    private WorkerManageService workerManageService = AbmsSeProApplication.ctx.getBean(WorkerManageService.class);
    private List<WorkerCategoryDTO> categoryDTOList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(WorkersController.class);
    private String img_url = " ";

    public void initialize() {
        loadAllWorkers();
        setWorkerGroups();
        setWorkerNumber();
        btnSave.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        tblWorkers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("workerId"));
        tblWorkers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblWorkers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblWorkers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tblWorkers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblWorkers.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("mobile"));
        tblWorkers.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("catName"));
        tblWorkers.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("catType"));
        tblWorkers.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("regDate"));


        tblWorkers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WorkerDTO>() {
            @Override
            public void changed(ObservableValue<? extends WorkerDTO> observable, WorkerDTO oldValue, WorkerDTO c) {
                if (c == null) {
                    return;
                }
                btnSave.setDisable(true);
                btnDelete.setDisable(false);
                btnUpdate.setDisable(false);
                txtAddress.setText(c.getAddress());
                txtNice.setText(c.getNic() + "");
                txtFirstName.setText(c.getFirstName());
                txtFullName.setText(c.getFullName());
                cmbWorkerCategory.setValue(c.getCat_Id());
                LocalDate date = LocalDate.parse(c.getRegDate().toString());
                txtDate.setValue(date);
                txtPhone.setText(c.getMobile());
                txtWorkerID.setText(c.getWorkerId());
                img_PP.setImage(new Image(new ByteArrayInputStream(c.getImg())));//Byte Array to Image View
                txtWorkerID.setText(c.getWorkerId());

            }
        });


    }


    @FXML
    private void txtSearch_OnKeyPress(KeyEvent keyEvent) {

    }

    @FXML
    private void btnDelete_OnAction(ActionEvent actionEvent) {

        if (!btnDelete.isDisable()) {
            try {
                workerManageService.deleteWorker(txtWorkerID.getText().trim());
                new Alert(Alert.AlertType.INFORMATION, "Worker Deleted Successfully !", ButtonType.OK).showAndWait();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Error!", ButtonType.OK).showAndWait();
                e.printStackTrace();
            }


        }
        reSet();
    }

    @FXML
    private void btnUpdate_OnAction(ActionEvent actionEvent) {
        if (txtWorkerID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Worker Id Is Empty !", ButtonType.OK).showAndWait();
            txtWorkerID.requestFocus();
            return;
        }

        if (txtFirstName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " First Name Is Empty !", ButtonType.OK).showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        if (txtFullName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Full Name Is Empty !", ButtonType.OK).showAndWait();
            txtFullName.requestFocus();
            return;
        }

        if (null == cmbWorkerCategory.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Group Type!", ButtonType.OK).showAndWait();
            cmbWorkerCategory.requestFocus();
            return;
        }


        String workerId = txtWorkerID.getText().trim();
        String fName = txtFirstName.getText().trim();
        String fullName = txtFullName.getText().trim();
        String catId = cmbWorkerCategory.getValue().toString();
        String nic = txtNice.getText().trim();
        String mobile = txtPhone.getText().trim();
        String address = txtAddress.getText().trim();
        byte[] pp = new byte[0];
        try {
            BufferedImage bImage = SwingFXUtils.fromFXImage(img_PP.getImage(), null);
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", s);
            byte[] res = s.toByteArray();
            System.out.println("Byte Array ----" + res);
            pp = res;
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date regDate = null;
        try {
            logger.info("........................");
            regDate = simpleDateFormat.parse(txtDate.getValue().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        WorkerDTO dto = new WorkerDTO(workerId, nic, fName, fullName, address, pp, mobile, catId, null, null, regDate);

        try {
            workerManageService.updateWorker(dto);
            new Alert(Alert.AlertType.CONFIRMATION, " Worker Updated Successfully  !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();
            e.printStackTrace();
            logger.debug(e);
        }

        reSet();
    }

    @FXML
    private void btnSave_OnAction(ActionEvent actionEvent) {

        if (txtWorkerID.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Worker Id Is Empty !", ButtonType.OK).showAndWait();
            txtWorkerID.requestFocus();
            return;
        }

        if (txtFirstName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " First Name Is Empty !", ButtonType.OK).showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        if (txtFullName.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, " Full Name Is Empty !", ButtonType.OK).showAndWait();
            txtFullName.requestFocus();
            return;
        }

        if (null == cmbWorkerCategory.getValue()) {
            new Alert(Alert.AlertType.ERROR, "  Select Worker Group Type!", ButtonType.OK).showAndWait();
            cmbWorkerCategory.requestFocus();
            return;
        }


        String workerId = txtWorkerID.getText().trim();
        String fName = txtFirstName.getText().trim();
        String fullName = txtFullName.getText().trim();
        String catId = cmbWorkerCategory.getValue().toString();
        String nic = txtNice.getText().trim();
        String mobile = txtPhone.getText().trim();
        String address = txtAddress.getText().trim();
        byte[] pp = new byte[0];
        try {
            BufferedImage bImage = SwingFXUtils.fromFXImage(img_PP.getImage(), null);
            ByteArrayOutputStream s = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", s);
            byte[] res = s.toByteArray();
            System.out.println("Byte Array ----" + res);
            pp = res;
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date regDate = null;
        try {
            regDate = simpleDateFormat.parse(txtDate.getValue().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        WorkerDTO dto = new WorkerDTO(workerId, nic, fName, fullName, address, pp, mobile, catId, null, null, regDate);

        try {
            workerManageService.createWorker(dto);
            new Alert(Alert.AlertType.CONFIRMATION, " Worker Registered Successfully  !", ButtonType.OK).showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, " Error !", ButtonType.OK).showAndWait();
            e.printStackTrace();
            logger.debug(e);
        }

        reSet();


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

        if (null == cmbWorkerCategory.getValue()) {
            return;
        }

        String groupId = cmbWorkerCategory.getValue().toString();
        for (WorkerCategoryDTO c : categoryDTOList) {
            if (c.getCat_Id().equals(groupId)) {
                txtWcatName.setText(c.getCat_Name());
                if (c.isACtive()) {
                    txtWorkerType.setText("Manager Level Employee");
                } else {
                    txtWorkerType.setText("Non Manager Level Employee");
                }
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


    private void loadAllWorkers() {

        try {
            List<WorkerDTO> temp = workerManageService.findAllWorkers();
            if (null == temp) {
                return;
            }
            logger.info("................" + temp);
            tblWorkers.setItems(FXCollections.observableArrayList(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setWorkerNumber() {
        ObservableList<WorkerDTO> items = tblWorkers.getItems();
        int max = 0;
        if (items == null || items.size() == 0) {
            txtWorkerID.setText("WRNO0" + 1);
            return;
        }
        for (WorkerDTO c : items) {
            String subCId = c.getWorkerId();
            int i = Integer.parseInt(subCId.substring(5));
            if (max < i) {
                max = i;
            }
            txtWorkerID.setText("WRNO0" + (++max));

        }

    }

    private void reSet() {
        txtAddress.clear();
        txtFirstName.clear();
        txtFullName.clear();
        txtPhone.clear();
        txtNice.clear();
        txtDate.setValue(null);
        txtPhone.clear();
        cmbWorkerCategory.setValue(null);
        txtWcatName.clear();
        txtWorkerType.clear();
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
        setWorkerNumber();
        loadAllWorkers();

    }
}
