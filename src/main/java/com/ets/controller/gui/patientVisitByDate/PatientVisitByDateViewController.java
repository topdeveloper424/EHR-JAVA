package com.ets.controller.gui.patientVisitByDate;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientAnalysis.PatientAnalysisEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.complex.ComplexInputController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.model.Clinic;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.Patient;
import com.ets.model.PatientName;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class PatientVisitByDateViewController implements Initializable {
	
   	
    @FXML
    private Button bttn;

	@FXML
    private TableView<PatientVisit> patientVisitTable;

    @FXML
    private TableColumn<PatientVisit, String> dateCollumn;

    @FXML
    private TableColumn<PatientVisit, String> arriveCollumn;

    @FXML
    private TableColumn<PatientVisit, String> patientCollumn;

    @FXML
    private TableColumn<PatientVisit, String> purposeCollumn;

    @FXML
    private TableColumn<PatientVisit, String> typeCollumn;

    @FXML
    private TableColumn<String, String> statusCollumn;
    
    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;
	
    @FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button closeButton;
	
	
	
	private Clinic clinic;
	public void setClinic(Integer Id) {
        System.out.println("ghfhhgh"+clinic);
       
		}
	
	
	
	
	public ClinicViewController clinicViewController;
   // private Button button;
	/*public void setClinicViewController(ClinicViewController clinicViewController,Button button) {
		this.clinicViewController = clinicViewController;
		this.button=button;
		
	}*/
	
	public void setPatientVisit(PatientVisit patientVisit) {

		Global.patientVisitObj = patientVisit;

	}
	
	public void setPatient(Patient patient) {

		Global.patient = patient;

	}
	
	
	public static ObservableList<Patient> patientList=FXCollections.observableArrayList();
	
    public static Button button= null;
	public static ObservableList<PatientVisit> patientVisitList =FXCollections.observableArrayList();
	
	
	  @FXML
	    void enterKeyPressedFoClinicButton(KeyEvent event) {

	    }
	  
	  private ObservableList<PatientVisit> patientVisitMasterData = FXCollections.observableArrayList();
	    
	    public void viewPatientVisit(){
	    	
	    	Date date1= null;
			LocalDate localDate1 = fromDate.getValue();
			if(localDate1 != null){
				 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
									
			}else{
				
				date1 = new Date();
				System.out.println("Date1 is  " +date1);
			}
			
			Date date2= null;
			LocalDate localDate2 = toDate.getValue();
			if(localDate2 != null){
				date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
									
			}else{
				
				date2 = new Date();
				System.out.println("Date2 is  " +date2);
			}
	    	
	    	patientVisitMasterData = new PatientVisitEntityController().viewByDate(date1, date2);
	    
	    	
	    	dateCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("visitDate"));
	    	arriveCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("arrivalTime"));
	    	
	    	patientCollumn.setCellValueFactory( data -> 
		    EasyBind.select(data.getValue().getPatient().patientNameProperty()).selectObject(PatientName::firstNameProperty));
	    	
	    	purposeCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("purpose"));
	    	
	    	typeCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("visitType"));
	    	
	    	statusCollumn.setCellValueFactory(new PropertyValueFactory<String, String>("visitStatus"));
	    	
	    	patientVisitTable.setItems(patientVisitMasterData);
	    	
	    } 

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		/*private PatientViewController patientViewController;
		
		 public void setPatientViewController(PatientViewController patientViewController) {
				this.patientViewController = patientViewController;
			}*/
		
		
				

		viewPatientVisit();
		
		addButton.setOnAction((event) -> {
			try {
				// Load Patient Details Entry form .

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				
				SearchPatientController searchPatientController =
				(SearchPatientController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				searchPatientController.setPatientVisitByDateViewController(this, addButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		/*clncBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				Date date1 = null;
				LocalDate localDate1 = fromDate.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				
				Date date2 = null;
				LocalDate localDate2 = toDate.getValue();
				if(localDate2 != null){
					 date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				
				//patientVisitList = new PatientVisitEntityController().searchPatient(date1, date2, Global.clinic.getId());				
				ClinicViewController clinicViewController = (ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                clinicViewController.setPatientVisitByDateViewController(this, date1, date2);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		
		/*
		bttn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				Date date1 = null;
				LocalDate localDate1 = fromDate.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				
				Date date2 = null;
				LocalDate localDate2 = toDate.getValue();
				if(localDate2 != null){
					 date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				}
				
				
				patientList = new PatientEntityController().search(date1, date2);
						 new PharmacyEntityController().searchPharmacy(
						pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());
				PatientViewController patientViewController = (PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				//patientViewController.setSearch(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
			
		/*bttn.setOnAction((event) -> {
	    try {
	    	
	    	
	    	Patient selectedPatient = this.patientTable.getSelectionModel().getSelectedItem();
			
			setPatient(selectedPatient);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
	    	
	    	
	    	
	    	
		if (SearchPatientController.button.getId().equals("chartByPatientBtn")) {
			
			String formName = "/view/code/appointmentSetup/patient/VisitByPatient.fxml";
		String formTitle1 = "Select Patient";
			//String formTitle2 = selectedPatient.getPatientName().getFirstName();
			//String formTitle = formTitle1+"/"+formTitle2;
			formPath.closeApplicationContext();
			//new FXFormCommonUtilities().displayForm(formName, formTitle);
		}} catch (Exception ex) {
			ex.printStackTrace();
		}
	});*/
				
				
		/*bttn.setOnAction((event) -> {
			try {
				
				

				PatientVisit patientVisit = this.patientVisitTable.getSelectionModel().getSelectedItem();
				setPatientVisit(patientVisit);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
				
				
				
				Date date1 = null;
				LocalDate localDate1 = fromDate.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					// date1 =  Calendar.getInstance().getTime();
					// Global.patientVisitObj.setVisitDate(date1);
				}
				
				Date date2 = null;
				LocalDate localDate2 = toDate.getValue();
				if(localDate2 != null){
					 date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					//date2 =  Calendar.getInstance().getTime();
					//Global.patientVisitObj.setVisitDate(date2);
				}
				
				
				if(date1 != null && date2 != null){
					//  if (PatientVisitByDateViewController.button.getId().equals("visitByDateBtn")) {
						
						String formName = formPath.context.getMessage("visitByDate", null, Locale.US);
						String formTitle1 = formPath.context.getMessage("Title.visitByDate", null, Locale.US);
						String formTitle2 = patientVisit.getArrivalTime();
						String formTitle = formTitle1+"/"+formTitle2;
						formPath.closeApplicationContext();
						
						new FXFormCommonUtilities().displayForm(formName, formTitle);
		      }
             //   }
			      }catch (Exception ex) {
					ex.printStackTrace();
				}
			});*/

		
		bttn.setOnAction((event) -> {
		    try {
		
		    	viewPatientVisit();
	      }catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		
		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
