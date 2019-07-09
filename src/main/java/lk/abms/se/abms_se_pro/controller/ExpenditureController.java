package lk.abms.se.abms_se_pro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ExpenditureController {
    @FXML
    private ImageView img_Back;
    @FXML
    private ImageView img_Workers;
    @FXML
    private JFXTextField txtExpenditureId;
    @FXML
    private JFXComboBox txtExpenditureType;
    @FXML
    private JFXTextField txtSiteName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXComboBox cmbSiteId;
    @FXML
    private TableView tblExpenditure;
    @FXML
    private JFXComboBox cmbRecievedType;
    @FXML
    private JFXTextField txtCheckNumber;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXDatePicker txtDate;

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) {
    }

    @FXML
    private void txtExpenditureType_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbSiteId_Onaction(ActionEvent actionEvent) {
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
}
