package com.ets.controller.navpanel;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.billingPanel.PatientAnalysisController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class BillingAndInvoicingGUIController  implements Initializable  {
	 @FXML
	    private AnchorPane billingAndInvoicingPannel;

    @FXML
    private Button reviewChargesButton;

    @FXML
    private Button closeBtn;
    
    @FXML
    private Button processChargesButton;
    
    @FXML
    private Button createInvoicesButton;
    
    @FXML
    private Button reviewChargesByDateButton;
    @FXML
    private Button reviewChargesByCompanyButton;
    @FXML
    private Button reviewChargesByAccountButton;
    @FXML
    private Button  reviewChargesByPatientButton;

    @FXML
    private Button addMedActCharg;
    
    @FXML
    private Button reportButton;
    
    @FXML
    private Button invoiceBatchesButton;
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		/*reviewChargesButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				billingAndInvoicingPannel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("ReviewCharges", null, Locale.US);
				formPath.closeApplicationContext();
				billingAndInvoicingPannel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		
	/*	reviewChargesButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				billingAndInvoicingPannel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("ReviewCharges", null, Locale.US);
				formPath.closeApplicationContext();
				billingAndInvoicingPannel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
*/
		
		
		reviewChargesByDateButton.setOnAction((event) -> {
		try {
			
			String formName = formPath.context.getMessage("SelectChargesByDate", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.SelectChargesByDate", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});	
		
		addMedActCharg.setOnAction((event) -> {
			
			if(Global.patientVisitObj !=null && Global.patient != null){
			try {
				
				//setPatientVisitObj();
				//System.out.println("New Patient Visit Id is : " + Global.patientVisitObj.getId());

				String formName = formPath.context.getMessage("ViewMedicalActivityCharge", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicalActivityCharge", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1+ "/" + formTitle2;

				formPath.closeApplicationContext();
				MedicalActivityChargeViewController medicalActivityChargeViewController = (MedicalActivityChargeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicalActivityChargeViewController.setBillingAndInvoicingGUIController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			}else{
				//System.out.println("InElseBlock");
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(infoDialogBoxTitle);
				alert.setHeaderText(null);
				alert.setContentText("Please Select a patient visit");
				alert.showAndWait();
			}
		

	});
		
		
		
		reportButton.setOnAction((event) -> {
			//if(PatientAnalysisController. !=null){
			try {
				
				String formName = formPath.context.getMessage("PatientVisitAnalysisReport", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PatientVisitAnalysisReport", null, Locale.US);
				formPath.closeApplicationContext();
				//new FXFormCommonUtilities().displayForm(formName, formTitle);
				PatientAnalysisController patientAnalysisController = (PatientAnalysisController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				//if(patientAnalysisController. != null) {
				patientAnalysisController.setBillingAndInvoicingGUIController(this);
				//billingAndInvoicingPannel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

				//}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
		processChargesButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ProcessCharge", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ProcessCharge", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*invoiceBatchesButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				//setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("InvoiceBatches", null, Locale.US);
				formPath.closeApplicationContext();
				billingAndInvoicingPannel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		invoiceBatchesButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("InvoiceBatches", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InvoiceBatches", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	
		createInvoicesButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				
				String formName = formPath.context.getMessage("CreateInvoice", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CreateInvoice", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		invoiceBatchesButton.setOnAction((event) -> {
			try {
								
				String formName = formPath.context.getMessage("ManageInvoices", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ManageInvoices", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		
		closeBtn.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				billingAndInvoicingPannel.getChildren().clear();
				// Display SetupAdmin Navigation Panel
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				billingAndInvoicingPannel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
