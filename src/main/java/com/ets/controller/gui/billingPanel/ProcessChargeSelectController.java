package com.ets.controller.gui.billingPanel;

import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.dialect.function.StandardAnsiSqlAggregationFunctions.SumFunction;
import org.hibernate.jpa.criteria.expression.function.AggregationFunction.SUM;
import org.springframework.util.SystemPropertyUtils;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Clinician;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientBillingInvoice;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ProcessChargeSelectController implements Initializable {
	
	@FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker thruDate;

    @FXML
    private Button searchButton;

    @FXML
    private CheckBox employersPaidServiceChargesCheck;

    @FXML
    private CheckBox employersWorkersCompChargesCheck;

    @FXML
    private CheckBox carrierWorkersCompChargesCheck;

    @FXML
    private CheckBox carrierPrivatePracticeChargesCheck;

    @FXML
    private CheckBox CarrierPatientPracticeChargesCheck;

    @FXML
    private CheckBox WarnForNonBillableVisitCheck;

    @FXML
    private CheckBox warnForCancelableActivitiesCheck;

    @FXML
    private CheckBox processChargesForAllClinicCheck;

    @FXML
    private CheckBox printPreviewCheck;

    @FXML
    private Button printButton;

    @FXML
    private Button cancelButton;
    
    public String overrideStr = null;
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		printButton.setOnAction((event) -> {
			
			if(employersPaidServiceChargesCheck.isSelected()){
				overrideStr = "Employer";
				
				System.out.println("###############" +overrideStr);
				//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
				
			}
			else if(carrierWorkersCompChargesCheck.isSelected()){
				overrideStr = "Carrier";
				System.out.println("###############" +overrideStr);
				//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
				
			}else{
				// Put Dialog Box Here
				overrideStr="xxxx";
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText("");
				alert.setContentText("not matching report criteria!");

				alert.showAndWait();
			}
			
		
			//if(Global.patientVisitObj.getVisitType().equals("Employer Services") && overrideStr.equals("Employer")||Global.patientVisitObj.getVisitType().equals("Worker's Comp") && overrideStr.equals("carrier")){
				
		
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ProcessCharges", null, Locale.US);
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
						//MedicalActivityCharge medicalActivityChargeList = null;
							try {

								System.out.println("Generating PDF...");

								String printMedicalActivityCharge= formPath.context.getMessage("Print.ProcessCharges", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printClinician));
								InputStream is = this.getClass().getResourceAsStream(printMedicalActivityCharge);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								Date date1= null;
								Date date2=null;
								LocalDate localDate1 = fromDate.getValue();
								LocalDate  localDate2= thruDate.getValue();
								 
								if(localDate1 != null&& localDate2!=null){
	
									date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
								 date2= Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());				
								
								   
								}
								//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId());
								
							      
								MedicalActivityCharge medicalActivityCharge2 = new MedicalActivityCharge();
								
								medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(date1, date2, overrideStr);
								System.out.println("from medical activity "+medicalActivityChargeList.size());
								
								
								//new MedicalActivityChargeViewController().viewChargeAfterBilling(medicalActivityChargeList.);
								Integer cost = 0;
								for (MedicalActivityCharge medicalActivityCharge : medicalActivityChargeList) {
									
									String str = medicalActivityCharge.getOverrideFee();
									
									System.out.println("str "+str);

										cost = (cost + (Integer.parseInt(str)*Integer.parseInt(medicalActivityCharge.getBillingQty())));

										System.out.println("Sum is ------------" +cost);
									
									medicalActivityCharge2.setId(medicalActivityCharge.getId());
									medicalActivityCharge2.setCheckBillingStatus(true);
									medicalActivityCharge2.setActivityCost(medicalActivityCharge.getActivityCost());
									medicalActivityCharge2.setActivityDate(medicalActivityCharge.getActivityDate());
									medicalActivityCharge2.setBillingComment(medicalActivityCharge.getBillingComment());
									medicalActivityCharge2.setBillingStatus("Billed");
									medicalActivityCharge2.setBillingModifier(medicalActivityCharge.getBillingModifier());
									medicalActivityCharge2.setBillingQty(medicalActivityCharge.getBillingQty());
									medicalActivityCharge2.setClinician(medicalActivityCharge.getClinician());
									medicalActivityCharge2.setLabOrderNo(medicalActivityCharge.getLabOrderNo());
									medicalActivityCharge2.setLabSampleId(medicalActivityCharge.getLabSampleId());
									medicalActivityCharge2.setNdcCode(medicalActivityCharge.getNdcCode());
									medicalActivityCharge2.setResultCode(medicalActivityCharge.getResultCode());
									medicalActivityCharge2.setPatient(medicalActivityCharge.getPatient());
									medicalActivityCharge2.setOverridePayer(medicalActivityCharge.getOverridePayer());
									medicalActivityCharge2.setNdcCode(medicalActivityCharge.getNdcCode());
									medicalActivityCharge2.setMedicalActivity(medicalActivityCharge.getMedicalActivity());
									medicalActivityCharge2.setNextDueDate(medicalActivityCharge.getNextDueDate());
									medicalActivityCharge2.setNoCost(medicalActivityCharge.getNoCost());
									medicalActivityCharge2.setOverrideFee(medicalActivityCharge.getOverrideFee());
									medicalActivityCharge2.setPatientVisit(medicalActivityCharge.getPatientVisit());
									medicalActivityCharge2.setDrugQuant(medicalActivityCharge.getDrugQuant());
									medicalActivityCharge2.setUom(medicalActivityCharge.getUom());
									medicalActivityCharge2.setLocationGiven(medicalActivityCharge.getLocationGiven());
								
									
									new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge2);
									
									
								}
								
								Set<Integer> patIdUniq = new HashSet<Integer>();// object cannot be unique..so id is taken as list of int
								
								
								for (MedicalActivityCharge medicalActivityCharge : medicalActivityChargeList) {
									patIdUniq.add(medicalActivityCharge.getPatientVisit().getId());
									
								}
								
								for (Integer patVi :patIdUniq) {
									
									Double totalCost = new MedicalActivityChargeEntityController().getTotalChargeForPatVisit(patVi);
									
									PatientBillingInvoice patientBillingInvoice = new PatientBillingInvoice();
									patientBillingInvoice.setInvoiceDate(new Date());
									patientBillingInvoice.setInvoiceType(overrideStr);
									PatientVisit patVisit = new PatientVisit();
									patVisit.setId(patVi);
									patientBillingInvoice.setPatientVisit(patVisit);
									//patientBillingInvoice.setReferance(referance);
									patientBillingInvoice.setStatus("Open");
									patientBillingInvoice.setTotal(totalCost.toString());
									patientBillingInvoice.setInvoiceBatches(false);
									
									new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);
									
								}
								
								
								//*************************************************
								
								System.out.println("########### "+medicalActivityChargeList.size());
								/*int sizeMed = medicalActivityChargeList.size();
								MedicalActivityCharge mednext=null;
								for(int i=0;i<sizeMed;i++){
									
									MedicalActivityCharge med = medicalActivityChargeList.get(i);
									if(i+1<=sizeMed||sizeMed==1){
									if(i+1<=sizeMed){	
									 mednext = medicalActivityChargeList.get(i+1);
									} if(sizeMed==1){
										PatientBillingInvoice patientBillingInvoice = new PatientBillingInvoice();
										patientBillingInvoice.setInvoiceDate(new Date());
										patientBillingInvoice.setInvoiceType(med.getOverridePayer());
										patientBillingInvoice.setPatientVisit(med.getPatientVisit());
										//patientBillingInvoice.setReferance(referance);
										patientBillingInvoice.setStatus("Open");
										patientBillingInvoice.setTotal(Integer.toString(cost));
										patientBillingInvoice.setInvoiceBatches(false);
										
										new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);
									}else if(mednext!=null){
								
									if(med.getPatientVisit().getId()==mednext.getPatientVisit().getId()){
										System.out.println("########### from if "+med.getPatientVisit().getId()+" "+mednext.getPatientVisit().getId());
									}else{
										System.out.println("#################### from else"+med.getPatientVisit().getId()+" "+mednext.getPatientVisit().getId());
										PatientBillingInvoice patientBillingInvoice = new PatientBillingInvoice();
										patientBillingInvoice.setInvoiceDate(new Date());
										patientBillingInvoice.setInvoiceType(med.getOverridePayer());
										patientBillingInvoice.setPatientVisit(med.getPatientVisit());
										//patientBillingInvoice.setReferance(referance);
										patientBillingInvoice.setStatus("Open");
										patientBillingInvoice.setTotal(Integer.toString(cost));
										patientBillingInvoice.setInvoiceBatches(false);
										
										new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);
										
									}
									}
									}
								}*///*****************************
								
								
								/*PatientBillingInvoice patientBillingInvoice = new PatientBillingInvoice();
								patientBillingInvoice.setInvoiceDate(new Date());
								patientBillingInvoice.setInvoiceType(medicalActivityCharge2.getOverridePayer());
								patientBillingInvoice.setPatientVisit(Global.patientVisitObj);
								//patientBillingInvoice.setReferance(referance);
								patientBillingInvoice.setStatus("Open");
								patientBillingInvoice.setTotal(Integer.toString(cost));
								patientBillingInvoice.setInvoiceBatches(false);
								System.out.println("Invoice Type :------ " +patientBillingInvoice.getInvoiceType());
								System.out.println("Total :------- " +patientBillingInvoice.getTotal());
								
								new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);*/
							   /* Set<PatientVisit> patVisitlist = new HashSet<PatientVisit>();
						        ListIterator<MedicalActivityCharge> medActivity = medicalActivityChargeList.listIterator();
					    		
						        while(medActivity.hasNext()){
					    			MedicalActivityCharge medicalActivityChargeOb = medActivity.next();
					    			MedicalActivityCharge medicalActivityChargePrevOb = medActivity.previous();
						        	
					    			if(medicalActivityChargeOb.getPatientVisit().getId().equals(medicalActivityChargePrevOb.getPatientVisit().getId())||medicalActivityChargePrevOb.getPatientVisit().getId()==null){
					    				
					                 
					    				
					    			}else{
					    				patVisitlist.add(medicalActivityChargeOb.getPatientVisit());
					    			}
								
						        }*/
						        
						        
						      
						       // JasperReport report = (JasperReport) JRLoader.loadObject("src/test/ireport/ShowPerson.jasper");
						       
						      
						        
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalActivityChargeList);
								
								Map<String, Object> map =new HashMap<String,Object>();
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
			}/*else{
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Selected Visit type for this patient is "+Global.patientVisitObj.getVisitStatus());
               
				alert.showAndWait();
			}*/
			

		});

		
	}

}
