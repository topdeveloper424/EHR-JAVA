package com.ets.controller.gui.drugScreenTestResultReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.gui.contact.ContactViewController;
import com.ets.controller.gui.drugScreen.DrugScreenResultEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Carrier;
import com.ets.model.Contact;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class EmployerReportGUIController implements Initializable {
	
		@FXML
	    private Button printBtn;

		@FXML
	    private Button contactSearchButton;
	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private TextField reportTitleText;

	    @FXML
	    private TextField contactNameText;

	    @FXML
	    private TextArea reportAddressTextArea;

	    @FXML
	    private TextField dateTextField;
	    
	    private DrugScreenResultEditController drugScreenResultEditController;
	    private DrugScreenResult drugScreenId;
	   	public void setDrugScreenResultEditController(DrugScreenResultEditController drugScreenResultEditController, DrugScreenResult drugScreenId) {
			this.drugScreenResultEditController = drugScreenResultEditController;
			this.drugScreenId = drugScreenId;
		}
	    
	    public String setDate(){
	    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    	Date d=new Date();
	    	String currDate= df.format(d);
	    	return currDate;
	    }
	    
	   

		private ObservableList<DrugScreenTestResult> drugScreenTestResult;
	    
	    public void setDrugScreenTestResult(ObservableList<DrugScreenTestResult> drugScreenTestResult) {
		
			
			this.drugScreenTestResult = drugScreenTestResult;
			//contactNameText.setText(value);
			reportTitleText.setText("Employer Drug Testing Report Summary");
			dateTextField.setText(setDate());
			contactNameText.setText(Global.patientVisitObj.getPatient().getCompany().getMainContact());
			reportAddressTextArea.setText(Global.patientVisitObj.getPatient().getCompany().getMainContact()+ "\n" +Global.patientVisitObj.getPatient().getCompany().getName()
					+ "\n" +Global.patientVisitObj.getPatient().getCompany().getAddress().getLocalAddress()+"\n"
					+Global.patientVisitObj.getPatient().getCompany().getAddress().getCity() + " "+Global.patientVisitObj.getPatient().getCompany().getAddress().getState()
					+ " " +Global.patientVisitObj.getPatient().getCompany().getAddress().getZip());
			//contactNameText.setText(drugScreenTestResult.patientProperty().getValue().companyProperty().getValue().contactProperty().getValue().getFirstName());
			/*String testValue = drugScreenTestResult.patientProperty().getValue().getCompany().getContact().getCity();*/
			/*if(testValue != null){
			reportAddressTextArea.setText(testValue);
			}*/
			
		}
	FXMLFormPath formPath = new FXMLFormPath();
     public void setContact(Contact contact){
    	 contactNameText.setText(contact.getFullName());
     }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		contactSearchButton.setOnAction((event) -> {
			
				try {
					String formName = formPath.context.getMessage("ViewContact", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ViewContact", null, Locale.US);
					formPath.closeApplicationContext();
					ContactViewController contactViewController =
					 (ContactViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					contactViewController.setEmployerReportGUIController(this);
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		
		
		setDate();
		printBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DrugTestScreen", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DrugScreenTestResult>> task =

					new Task<ObservableList<DrugScreenTestResult>>() {

						@Override
						protected ObservableList<DrugScreenTestResult> call() throws Exception {

							ObservableList<DrugScreenTestResult> drugScreenTestResultList = FXCollections.observableArrayList();

							try {

								System.out.println("Generating PDF...");

								String printDrugTestScreen= formPath.context.getMessage("Print.DrugTestScreen", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printDrugTestScreen));
								InputStream is = this.getClass().getResourceAsStream(printDrugTestScreen);

								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								
								//drugScreenTestResultList =new DrugScreenTestResultEntityController().viewDrugScreenTestResultByPatientId(drugScreenTestResult.getPatientVisit().getPatient().getId());
								
								System.out.println("sssssss$$$$$$$$$$$$$$$$$$$$$$ "+drugScreenTestResultList.size());
								DrugScreenResult drugScreenResult = new DrugScreenResultEntityController().viewDrugScreenResult(Global.patientVisitObj.getId());
								drugScreenTestResultList =new DrugScreenTestResultEntityController().viewDrugScreenByPatientVisitId(Global.patientVisitObj.getId(),MedicalActivityChargeEditController.activityCodeName, drugScreenResult.getId());
								//System.out.println("CCf_NO is ---- " +drugScreenResult.getCcfNo());
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(drugScreenTestResultList);
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("drug", drugScreenResult);
								map.put("drugTestProfile", MedicalActivityChargeViewController.drugTestProfile);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							}catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return drugScreenTestResultList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		cancelBtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
