package com.ets.controller.gui.billingPanel;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
/*import java.util.HashMap;*/
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
/*import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;*/
import com.ets.controller.entity.patientAnalysis.PatientAnalysisEntityController;
/*import com.ets.controller.gui.billingServiceType.BillingServiceTypeInputController;*/
import com.ets.controller.gui.billingServiceType.BillingServiceTypeViewController;
import com.ets.controller.gui.clinic.ClinicViewController;
/*import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.company.CompanyEditController;*/
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
/*import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeViewController;*/
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeViewController;
import com.ets.controller.navpanel.BillingAndInvoicingGUIController;
import com.ets.model.BillingServiceType;
import com.ets.model.Clinic;
import com.ets.model.Clinician;
import com.ets.model.Company;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientAnalysis;
import com.ets.model.VisitCategory;
import com.ets.service.patientAnalysis.PatientAnalysisService;
import com.ets.service.patientAnalysis.PatientAnalysisServiceImpl;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class PatientAnalysisController implements Initializable{


    @FXML
    private DatePicker thuDatetext;

    @FXML
    private RadioButton summaryRadio;

    @FXML
    private RadioButton detailRadio;

    @FXML
    private ChoiceBox<String> reportBy1text;

    @FXML
    private ChoiceBox<String> reportBy2text;

    @FXML
    private ChoiceBox<String> selecting2;

    @FXML
    private ChoiceBox<String> select1text;

    @FXML
    private Button select1button;

    @FXML
    private Button search2button;

    @FXML
    private Button printbutton;

    @FXML
    private Button cancelbtn;

    @FXML
    private CheckBox companyChkBox;

    @FXML
    private CheckBox clinicChkBox;

    @FXML
    private Button clinicBtn;

    @FXML
    private Button cmpnyBtn;
    
    @FXML
    private TextField textarea1;

    @FXML
    private TextField textarea2;
    

    @FXML
    private Button memorizeBtn;
    
    @FXML
    private Label lone;

    @FXML
    private Label ltwo;
    
    @FXML
    private DatePicker fromDatetext;
    
    
    public static String patient = null;
    public void setActivityCode(PatientAnalysis patientAnalysis){
    textarea1.setText(patientAnalysis.getDetail());
    patient = textarea1.getText();
    	
    }
    
        
    public BillingAndInvoicingGUIController billingAndInvoicingGUIController;
    
   	public void setBillingAndInvoicingGUIController(BillingAndInvoicingGUIController billingAndInvoicingGUIController) {
   		
   	this.billingAndInvoicingGUIController = billingAndInvoicingGUIController;
   }

   	FXMLFormPath formPath = new FXMLFormPath();
   	
  
   	
   	private Company company;
   	
   	public void setCompany(Company company) {
   		this.company = company;
   		ltwo.setText(company.getName());
   		
   	}
   	
   	private Clinic clinic;
	public void setClinic(Clinic clinic) {
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"+clinic);
        this.clinic = clinic;
		lone.setText(clinic.getName());
		}
	
		
	private VisitCategory visitCategory;
	public void setVisitCategory(VisitCategory visitCategory) {
		this.visitCategory = visitCategory;
		textarea1.setText(visitCategory.getCode());
		
	}
	
	private BillingServiceType billingServiceType;
	
	
/*
	private BillingServiceTypeViewController billingServiceTypeViewController;
	public void setBillingServiceTypeViewController(BillingServiceTypeViewController billingServiceTypeViewController) {
		this.billingServiceTypeViewController = billingServiceTypeViewController;
		textarea1.setText(billingServiceTypeViewController.getBilling_type());
		
	}*/
	
	
	private VisitCategory visitCategry;
	public void setVisitCategry(VisitCategory visitCategry) {
		this.visitCategry = visitCategry;
		textarea2.setText(visitCategry.getCode());
		
	}
	
	
	private PatientAnalysisEntityController patientAnalysisEntityController;
	public PatientAnalysis patientAnalysis;
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	/*	textarea1.setVisible(false);
		select1button.setVisible(false);
		textarea2.setVisible(false);
		search2button.setVisible(false);*/
		
				
		List<String> list1 = new ArrayList<String>();
		list1.add("Visit Category");
		list1.add("Employer Group");
		list1.add("Service Type");
		list1.add("Visit Type");
		list1.add("Insurance Type");
		list1.add("Nature of Incident");
		ObservableList patientList1 =  FXCollections.observableList(list1);
		reportBy1text.getItems().clear();
		reportBy1text.setItems(patientList1);
		
		
		List<String> list3 = new ArrayList<String>();
		list3.add("Visit Category");
		list3.add("Employer Group");
		list3.add("Service Type");
		list3.add("Visit Type");
		list3.add("Insurance Type");
		list3.add("Nature of Incident");
		ObservableList patientList3 =  FXCollections.observableList(list3);
		reportBy2text.getItems().clear();
		reportBy2text.setItems(patientList3);
		
		
			clinicBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				ClinicViewController clinicViewController = (ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                clinicViewController.setPatientAnalysisController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
					
	
		   	
		
	    cmpnyBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				CompanyViewController companyViewController = (CompanyViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                companyViewController.setPatientAnalysisController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	
		
	    	    
	    select1button.setOnAction((event) -> {
	    	if(reportBy1text.getSelectionModel().getSelectedItem().equals("Visit Category")) {

			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				VisitCategoryCodeViewController visitCategoryCodeViewController = (VisitCategoryCodeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                visitCategoryCodeViewController.setPatientAnalysisController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    	}
	    	
	    		    	
	    	else if(reportBy1text.getSelectionModel().getSelectedItem().equals("Service Type")) {
				try {
					String formName = formPath.context.getMessage("BillingService", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);
					BillingServiceTypeViewController billingServiceTypeViewController = (BillingServiceTypeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					billingServiceTypeViewController.setPatientAnalysisController(this);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    	}
			});
	    
	       
	    
	    search2button.setOnAction((event) -> {
	    	if(reportBy2text.getSelectionModel().getSelectedItem().equals("Visit Category")) {

			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				VisitCategoryCodeViewController visitCategoryCodeViewController1 = (VisitCategoryCodeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				visitCategoryCodeViewController1.setPatientAnalysisController1(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    	}
	    	
	    	
	    		    	else if(reportBy2text.getSelectionModel().getSelectedItem().equals("Service Type")) {
				try {
					String formName = formPath.context.getMessage("BillingService", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    	}
			});
	    
	    	    	
	    		
		if(reportBy1text.getSelectionModel().getSelectedItem()!=null)
		{
		if(reportBy1text.getSelectionModel().getSelectedItem().equals("Employer Group")||reportBy1text.getSelectionModel().getSelectedItem().equals("Nature of Incident")||reportBy1text.getSelectionModel().getSelectedItem().equals("Visit Category")||reportBy1text.getSelectionModel().getSelectedItem().equals("Service Type")||reportBy1text.getSelectionModel().getSelectedItem().equals("Employer Group")) {
			textarea1.setVisible(true);
		    select1button.setVisible(true);
	    }else{
		textarea1.setVisible(false);
		select1button.setVisible(false);
	}	
		
		
		
		
		if(reportBy2text.getSelectionModel().getSelectedItem().equals("Employer Group")||reportBy2text.getSelectionModel().getSelectedItem().equals("Nature of Incident")||reportBy2text.getSelectionModel().getSelectedItem().equals("Visit Category")||reportBy2text.getSelectionModel().getSelectedItem().equals("Service Type")||reportBy1text.getSelectionModel().getSelectedItem().equals("Employer Group")) {
			textarea2.setVisible(true);
			search2button.setVisible(true);
	    }else{
		textarea2.setVisible(false);
		search2button.setVisible(false);
	}	
		
		}
		
		
		memorizeBtn.setOnAction((event) -> {
			try {					
					
				PatientAnalysis patAna = new PatientAnalysis();
				
				LocalDate localDate = thuDatetext.getValue();
				if(localDate!=null) 
				{
				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				patAna.setThruDate(date);
				}
					
								
				LocalDate localDates = fromDatetext.getValue();
				if(localDates!=null)
				{
				Date dates = Date.from(localDates.atStartOfDay(ZoneId.systemDefault()).toInstant());
				patAna.setFromDate(dates);
				}
				
				patAna.setDetail(reportBy1text.getSelectionModel().getSelectedItem());
				patAna.setDetails(reportBy2text.getSelectionModel().getSelectedItem());
				patAna.setInformation(textarea1.getText());
				patAna.setInformations(textarea2.getText());
				patAna.setCom(company);
				patAna.setVisitCat(visitCategory);
				patAna.setServiceType(billingServiceType);
			    patAna.setClinic(clinic);
					
		    	new	PatientAnalysisEntityController().add(patAna) ;
			//	new FXFormCommonUtilities().closeForm(memorizeBtn );
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
				
		printbutton.setOnAction((event) -> {
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.PatientAnalysis", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			System.out.println("tyryty");
			Task<ObservableList<PatientAnalysis>> task =

					new Task<ObservableList<PatientAnalysis>>() {

						@Override
						protected ObservableList<PatientAnalysis> call()throws Exception {

							ObservableList<PatientAnalysis> patientAnalysisList = null;

							try {
								System.out.println("snsnnnsnsn");
								System.out.println("Generating PDF...");

								String printPatientAnalysis= formPath.context.getMessage("Print.PatientAnalysis", null, Locale.US);

								formPath.closeApplicationContext();
								InputStream is = this.getClass().getResourceAsStream(printPatientAnalysis);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								System.out.println("dffdgdg"+printPatientAnalysis);
							    PatientAnalysis patientAnalysis = new PatientAnalysisEntityController().viewCompany(company.getId());
								//patientAnalysisList = new PatientAnalysisEntityController().viewPatientId(Global.patient_analysis.getId());
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientAnalysisList);
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("Analysis", patientAnalysis);
							    //map.put("patient", PatientAnalysisController.patient);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
								JasperViewer.viewReport(jasperPrint, false);
								System.out.println("FirstReport.pdf has been generated!");

							}catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return patientAnalysisList;

					}
				
			};
			
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
		
		
		cancelbtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelbtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
	
	