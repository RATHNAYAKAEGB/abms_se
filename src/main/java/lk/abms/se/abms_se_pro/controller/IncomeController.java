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

public class IncomeController {
    @FXML
    private JFXTextField txtIncomeId;
    @FXML
    private ImageView img_Back;
    @FXML
    private JFXTextField txtCheckNumber;
    @FXML
    private JFXDatePicker txtDate;
    @FXML
    private JFXComboBox cmbIncomeType;
    @FXML
    private JFXComboBox txtRecieveType;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXComboBox cmbSite;
    @FXML
    private JFXTextField txtSiteName;
    @FXML
    private JFXTextField txtAmount;
    @FXML
    private TableView tblIncomes;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private ImageView img_Workers;
    @FXML
    private JFXButton btnDelete;

    @FXML
    private void img_Back_OnMosueClicked(MouseEvent mouseEvent) {
    }

    @FXML
    private void cmbIncomeType_OnAction(ActionEvent actionEvent) {
    }

    @FXML
    private void cmbSite_OnAction(ActionEvent actionEvent) {
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
