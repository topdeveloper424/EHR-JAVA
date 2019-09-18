package com.ets.controller.gui.billingPanel;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.ets.model.Patient;
import com.ets.model.PatientBillingInvoice;
import com.ets.utils.FXFormCommonUtilities;

import groovy.servlet.ServletCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReviewChargesByDateViewController implements Initializable{
	
	@FXML
    private DatePicker viewFromDate;

    @FXML
    private DatePicker thruDate;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<PatientBillingInvoice>patientBillingInvoiceTable;

    @FXML
    private TableColumn<PatientBillingInvoice, Date> dateColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> patientColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> accountColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> typeColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> chargesColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> paidColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> statusColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButon;

    @FXML
    private Button closeButton;
    
    private SelectChargesByDateInputController selectChargesByDateInputController;
    
    public void setSelectChargesByDateInputController(
			SelectChargesByDateInputController selectChargesByDateInputController) {
		this.selectChargesByDateInputController = selectChargesByDateInputController;
	}

    private ObservableList<PatientBillingInvoice> patientBillingInvoiceMasterData = FXCollections.observableArrayList();
    
	public void viewPatientBillinInvoice(){
		
		patientBillingInvoiceMasterData = (ObservableList<PatientBillingInvoice>) SelectChargesByDateInputController.patientBillingInvoiceList;
				
		dateColumn.setCellValueFactory(cellData -> cellData.getValue().invoiceDateProperty());
		patientColumn.setCellValueFactory(cellData -> cellData.getValue().getPatientVisit().getPatient().getPatientName().firstNameProperty());
		//accountColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().invoiceTypeProperty());
		chargesColumn.setCellValueFactory(cellData -> cellData.getValue().totalProperty());
		//paidColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
				
		patientBillingInvoiceTable.setItems(patientBillingInvoiceMasterData);
  
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewPatientBillinInvoice();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
