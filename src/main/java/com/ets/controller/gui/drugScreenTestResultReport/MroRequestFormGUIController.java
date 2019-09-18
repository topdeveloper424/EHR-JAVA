package com.ets.controller.gui.drugScreenTestResultReport;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MroRequestFormGUIController implements Initializable {
	
	 @FXML
	    private Button printBtn;

	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private TextField reportTitleText;

	    @FXML
	    private TextField contactName;

	    @FXML
	    private TextField reportDateText;
	    
	    public String setDate(){
	    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    	Date d=new Date();
	    	String currDate= df.format(d);
	    	return currDate;
	    }
	    
	    private DrugScreenTestResultEntityController drugScreenTestResultEntityController; 
	    private ObservableList<DrugScreenTestResult> drugScreenTestResult;
	    public void setDrugScreenTestResult(ObservableList<DrugScreenTestResult> drugScreenTestResult) {
		
			this.drugScreenTestResult = drugScreenTestResult;
			
			//contactNameText.setText(value);
			reportTitleText.setText("MEDICAL REVIEW OFFICER REQUEST FORM");
			reportDateText.setText(setDate());
			contactName.setText(Global.patientVisitObj.getPatient().getCompany().getMainContact());
			
			//contactNameText.setText(drugScreenTestResult.patientProperty().getValue().companyProperty().getValue().contactProperty().getValue().getFirstName());
			/*String testValue = drugScreenTestResult.patientProperty().getValue().getCompany().getContact().getCity();*/
			/*if(testValue != null){
			reportAddressTextArea.setText(testValue);
			}*/
			
		}
	FXMLFormPath formPath = new FXMLFormPath();
	    
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
						protected ObservableList<DrugScreenTestResult> call() throws JRException {

							ObservableList<DrugScreenTestResult> drugScreenTestResultList = FXCollections.observableArrayList();

							try {

								System.out.println("Generating PDF...");

								String printDrugTestScreen= formPath.context.getMessage("Print.DrugScreenMroReport", null, Locale.US);

								formPath.closeApplicationContext();
								System.out.println("Hello !!!!!");
								//InputStream is = new FileInputStream(new File(printDrugTestScreen));
								InputStream is = this.getClass().getResourceAsStream(printDrugTestScreen);

								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								
								//drugScreenTestResultList =new DrugScreenTestResultEntityController().viewDrugScreenTestResultByPatientId(drugScreenTestResult.getPatientVisit().getPatient().getId());
								
								System.out.println(drugScreenTestResultList.size()+"ddddddddddddddddddddPPPPP");
								DrugScreenResult drugScreenResult = new DrugScreenResultEntityController().viewDrugScreenResult(Global.patientVisitObj.getId());
								//ObservableList<DrugScreenResult> jrdatalist = FXCollections.observableArrayList();
								drugScreenTestResultList =new DrugScreenTestResultEntityController().viewDrugScreenByPatientVisitId(Global.patientVisitObj.getId(),MedicalActivityChargeEditController.activityCodeName, drugScreenResult.getId());
								ObservableList<DrugScreenTestResult> drugScreenTestList = new DrugScreenTestResultEntityController().viewDrugScreenByPatientVisitId(Global.patientVisitObj.getId(),MedicalActivityChargeEditController.activityCodeName, drugScreenResult.getId());
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(drugScreenTestResultList); //drugScreenResult

								Map<String, Object> map = new HashMap<String, Object>();
								map.put("drug", drugScreenResult);
								/*map.put("drugScreenTest", drugScreenTestList);*/
								map.put("drugTestProfile", MedicalActivityChargeViewController.drugTestProfile);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);
								//byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

								
								System.out.println("FirstReport.pdf has been generated!");

							}/*catch (Exception ex) {
								ex.printStackTrace();
							}*/
							 catch ( JRException ex) {
								    //xLogger.severe("Failed to generate PDF ");
								    throw ex;
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
				
				new FXFormCommonUtilities().closeForm( cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
