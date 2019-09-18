package com.ets.controller.gui.billingPanel;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Clinician;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientBillingInvoice;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class CreateInvoiceController implements Initializable {
	
	@FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TextField invoiceDateText;

    @FXML
    private TitledPane invoicesTypesTitle;

    @FXML
    private CheckBox employerPaidServicesCheck;

    @FXML
    private CheckBox employerWorkersCompCheck;

    @FXML
    private CheckBox carrierPaidWorkersCompCheck;

    @FXML
    private CheckBox carrierPaidPrivatePracriceCheck;

    @FXML
    private CheckBox patientPaidPrivatePracticeCheck;

    @FXML
    private CheckBox generateAllClinicsCheck;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button printButton;
  
    public String overrideStr = null;
    
    FXMLFormPath formPath = new FXMLFormPath();
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		okButton.setOnAction((event) -> {
			try {
				
				Date date1= null;
				Date date2=null;
				LocalDate localDate1 = fromDate.getValue();
				LocalDate  localDate2= toDate.getValue();
				if(localDate1 != null&& localDate2!=null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					 date2= Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());				
				}
				
				if(employerPaidServicesCheck.isSelected()){
					overrideStr = "Employer";
					
					
				}
				else if(carrierPaidWorkersCompCheck.isSelected()){
					overrideStr = "Carrier";
					
					
				}else{
					overrideStr="XXX";
					
					// Put Dialog Box Here
				}
				ObservableList<PatientBillingInvoice> patientBillingInvoiceList = null;
				patientBillingInvoiceList = new  PatientBillingInvoiceEntityController().viewPatientBillingInvoiceByDateAndOverride(date1, date2, overrideStr);
				
				if(patientBillingInvoiceList.size() > 0){
					
				for(PatientBillingInvoice patientBillingInvoice: patientBillingInvoiceList){
					
					PatientBillingInvoice patientBillingInvoice2 = new PatientBillingInvoice();
					patientBillingInvoice2.setId(patientBillingInvoice.getId());
					patientBillingInvoice2.setInvoiceDate(patientBillingInvoice.getInvoiceDate());
					patientBillingInvoice2.setInvoiceType(patientBillingInvoice.getInvoiceType());
					patientBillingInvoice2.setPatientVisit(patientBillingInvoice.getPatientVisit());
					//patientBillingInvoice2.setReferance(referance);
					patientBillingInvoice2.setStatus(patientBillingInvoice.getStatus());
					patientBillingInvoice2.setTotal(patientBillingInvoice.getTotal());
					patientBillingInvoice2.setInvoiceBatches(true);
					
					new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice2);
					
				}
				}
				new FXFormCommonUtilities().closeForm(okButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.CreateInvoice", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<MedicalActivityCharge>> task =

					new Task<ObservableList<MedicalActivityCharge>>() {

						@Override
						protected ObservableList<MedicalActivityCharge> call() throws Exception {

							ObservableList<MedicalActivityCharge> medicalActivityChargeList = null;

							try {

								System.out.println("Generating PDF...");

								String printMedicalActivityCharge = formPath.context.getMessage("Print.CreateInvoice", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printClinician));
								InputStream is = this.getClass().getResourceAsStream(printMedicalActivityCharge);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								Date date1= null;
								Date date2=null;
								LocalDate localDate1 = fromDate.getValue();
								LocalDate  localDate2= toDate.getValue();
								if(localDate1 != null&& localDate2!=null){
									 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
									 date2= Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());				
								}
								//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId());
								if(employerPaidServicesCheck.isSelected()){
									overrideStr = "Employer";
									//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
									
								}
								else if(carrierPaidWorkersCompCheck.isSelected()){
									overrideStr = "carrier";
									//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
									
								}else{
									// Put Dialog Box Here
								}
								MedicalActivityCharge medicalActivityCharge2 = new MedicalActivityCharge();
								medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(date1, date2, overrideStr);
								//new MedicalActivityChargeViewController().viewChargeAfterBilling(medicalActivityChargeList.);
								for (MedicalActivityCharge medicalActivityCharge : medicalActivityChargeList) {
									
									medicalActivityCharge2.setId(medicalActivityCharge.getId());
									medicalActivityCharge2.setCheckBillingStatus(true);
									medicalActivityCharge2.setActivityCost(medicalActivityCharge.getActivityCost());
									medicalActivityCharge2.setActivityDate(medicalActivityCharge.getActivityDate());
									medicalActivityCharge2.setBillingComment(medicalActivityCharge.getBillingComment());
									
									medicalActivityCharge2.setBillingModifier(medicalActivityCharge.getBillingModifier());
									medicalActivityCharge2.setBillingQty(medicalActivityCharge.getBillingQty());
									medicalActivityCharge2.setClinician(medicalActivityCharge.getClinician());
									medicalActivityCharge2.setLabOrderNo(medicalActivityCharge.getLabOrderNo());
									medicalActivityCharge2.setLabSampleId(medicalActivityCharge.getLabSampleId());
									medicalActivityCharge2.setNdcCode(medicalActivityCharge.getNdcCode());
									medicalActivityCharge2.setResultCode(medicalActivityCharge.getResultCode());
									medicalActivityCharge2.setPatient(Global.patient);
									medicalActivityCharge2.setOverridePayer(medicalActivityCharge.getOverridePayer());
									
									medicalActivityCharge2.setMedicalActivity(medicalActivityCharge.getMedicalActivity());
									medicalActivityCharge2.setNextDueDate(medicalActivityCharge.getNextDueDate());
									medicalActivityCharge2.setNoCost(medicalActivityCharge.getNoCost());
									medicalActivityCharge2.setOverrideFee(medicalActivityCharge.getOverrideFee());
									
									new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge2);
								}
								//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge();
								//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId());
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalActivityChargeList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return medicalActivityChargeList;

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

		
	}

}
