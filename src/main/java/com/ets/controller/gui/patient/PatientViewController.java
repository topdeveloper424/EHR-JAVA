package com.ets.controller.gui.patient;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientViewController Class
 *Description: view.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

**Modification: Neha Sahadev
 *Owner:
 *Date:
 *Version:
 *Description: set PatientName in Title  for CheckInButton.
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.


*/

import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.laboratory.LaboratoryEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.appointment.PatientAppointmentViewController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.demographicsSearch.PatientDemographicsSearchController;
import com.ets.controller.gui.inventory.outGo.InventoryOutGoInputController;
import com.ets.controller.gui.patientVisitByDate.PatientVisitByDateViewController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.controller.gui.visitLog.VisitLogSelectController;
import com.ets.model.Clinic;
import com.ets.model.Laboratory;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PatientViewController implements Initializable {

    @FXML
    private Button alllPatients;

    @FXML
    private Button aPatients;

    @FXML
    private Button bPatients;

    @FXML
    private Button cPatients;

    @FXML
    private Button dPatients;

    @FXML
    private Button ePatients;

    @FXML
    private Button fPatients;

    @FXML
    private Button gPatients;

    @FXML
    private Button hPatients;

    @FXML
    private Button iPatients;
    
    @FXML
    private Button jPatients;

    @FXML
    private Button kPatients;

    @FXML
    private Button lPatients;

    @FXML
    private Button mPatients;

    @FXML
    private Button nPatients;

    @FXML
    private Button oPatients;

    @FXML
    private Button pPatients;

    @FXML
    private Button qPatients;

    @FXML
    private Button rPatients;

    @FXML
    private Button sPatients;

    @FXML
    private Button tPatients;

    @FXML
    private Button uPatients;

    @FXML
    private Button vPatients;

    @FXML
    private Button wPatients;

    @FXML
    private Button xPatients;

    @FXML
    private Button yPatients;

    @FXML
    private Button zPatients;

	
	@FXML
	private TableView<Patient> patientTable;

	@FXML
	private TableColumn<Patient, String> patientNameCollumn;

	@FXML
	private TableColumn<Patient, String> patientIdNumberCollumn;

	@FXML
	private TableColumn<Patient, Date> patientDOBCollumn;
	
	@FXML
	private TableView<Patient> currentCompany;
	
	@FXML
    private TableColumn<Patient, String> companyName;
	
	@FXML
    private TableColumn<Patient, String> companyStatus;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button clearBtn;

	@FXML
	private Button addButton;

	@FXML
	private Button viewPatientBtn;

	@FXML
	private Button selectButton;

	@FXML
	private Button addNewOrgBtn;
	
	@FXML
	private Button closeButton;
	
	@FXML
    void mouseClickEvent(MouseEvent event) {
		 patientCompanyList = FXCollections.observableArrayList();
		System.out.println("CLICK Event is Fired");
		viewCurrentCompany();
    }
	
	public ObservableList<Patient> patientCompanyList = FXCollections.observableArrayList();
	
	private Button button;

	public Integer flag = 0;

	public void setPatient(Patient patient) {

		Global.patient = patient;

	}
	
	
    public PatientDemographicsSearchController patientDemographicsSearchController;
   
	public void setPatientDemographicsSearchController(
			PatientDemographicsSearchController patientDemographicsSearchController) {
		this.patientDemographicsSearchController = patientDemographicsSearchController;
		
		patientMasterData = FXCollections.observableArrayList();
		patientMasterData.addAll(PatientDemographicsSearchController.patientList);
		viewPatient();
		
		PatientDemographicsSearchController.patientList=null;
	     selectButton.setVisible(false);
	}


	public SearchPatientController searchPatientController;


	public void setSearchPatientController(SearchPatientController searchPatientController) {
		this.searchPatientController = searchPatientController;
	}
	
	
	public PatientVisitByDateViewController patientVisitByDateViewController;
	public void setSearch(PatientVisitByDateViewController patientVisitByDateViewController) {
		this.patientVisitByDateViewController = patientVisitByDateViewController;
	}

	
	
	
	

	public ObservableList<Patient> patientMasterData = FXCollections.observableArrayList();
	
	public void viewPatient(){
		
		/*System.out.println("SIZE OF PATLIST "+SearchPatientController.patientList);
		if(SearchPatientController.patientList.size()!=0){*/
		//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		if(patientDemographicsSearchController==null){
		
		if(flag==0){
			
			patientMasterData = SearchPatientController.patientList;
			
		}
		else{
			patientMasterData=PatientInputController.patListInput;
		}
		}
			
		/*}else{
			System.out.println(" ELSE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			patientMasterData = new PatientEntityController().view(Global.clinic.getId());	
			
		}*/
			
		
		
		patientNameCollumn.setCellValueFactory(cellData -> cellData.getValue().getPatientName().firstNameProperty());
		    	
		patientIdNumberCollumn.setCellValueFactory(cellData -> cellData.getValue().socialSecurityNoProperty());
		patientDOBCollumn.setCellValueFactory(cellData -> cellData.getValue().getPatientStatistic().dobProperty());
		
		FilteredList<Patient> filteredData = new FilteredList<Patient>(patientMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(patient -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (patient.getPatientName().getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				if (patient.getPatientName().getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		SortedList<Patient> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(patientTable.comparatorProperty());
		
		//patientTable.setItems(patientMasterData);
	
		patientTable.setItems(sortedData);
		//patientTable.setItems(patientMasterData);
		
	}
	
	private InventoryOutGoInputController inventoryOutGoInputController;
	
	public void setInventoryOutGoInputController(InventoryOutGoInputController inventoryOutGoInputController , Button button) {
		this.inventoryOutGoInputController = inventoryOutGoInputController;
		this.button = button;
	}
	
	/*******To show Company names*/
	 List<String> stringValues = Arrays.asList("Active");
	 public void viewCurrentCompany()
	{
		Patient patCompany = patientTable.getSelectionModel().getSelectedItem();
		patientCompanyList.add(patCompany);
		companyName.setCellValueFactory(cellData -> cellData.getValue().getCompany().nameProperty());
		//TableColumn<ObservableList<Patient>, String> Status = new TableColumn<>("Concatentated Values");
		//companyStatus.setCellValueFactory(cellData -> cellData.getValue().);
		companyStatus.setCellValueFactory(cellData -> {
			return new ReadOnlyStringWrapper(stringValues.get(0));
		});
		currentCompany.setItems(patientCompanyList);
		
	}

	 ObservableList<Patient> sortedPatients =  FXCollections.observableArrayList();

	public static List<PatientAppointment> patientAppointmentList = null;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewPatient();
		
		alllPatients.setOnAction((event)->{
			
			viewPatient();		
			
		});
		
		aPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("A");
			patientTable.setItems(sortedPatients);
		});
		
		
		bPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("B");
			patientTable.setItems(sortedPatients);
		});
		cPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("C");
			patientTable.setItems(sortedPatients);
		});
		dPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("D");
			patientTable.setItems(sortedPatients);
		});
		ePatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("E");
			patientTable.setItems(sortedPatients);
		});
		fPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("F");
			patientTable.setItems(sortedPatients);
		});
		gPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("G");
			patientTable.setItems(sortedPatients);
		});
		hPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("H");
			patientTable.setItems(sortedPatients);
		});
		iPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("I");
			patientTable.setItems(sortedPatients);
		});
		jPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("J");
			patientTable.setItems(sortedPatients);
		});
		kPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("K");
			patientTable.setItems(sortedPatients);
		});
		lPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("L");
			patientTable.setItems(sortedPatients);
		});
		mPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("M");
			patientTable.setItems(sortedPatients);
		});
		nPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("N");
			patientTable.setItems(sortedPatients);
		});
		oPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("O");
			patientTable.setItems(sortedPatients);
		});
		pPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("P");
			patientTable.setItems(sortedPatients);
		});
		qPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("Q");
			patientTable.setItems(sortedPatients);
		});
		rPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("R");
			patientTable.setItems(sortedPatients);
		});
		sPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("S");
			patientTable.setItems(sortedPatients);
		});
		tPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("T");
			patientTable.setItems(sortedPatients);
		});
		uPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("U");
			patientTable.setItems(sortedPatients);
		});
		vPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("V");
			patientTable.setItems(sortedPatients);
		});
		wPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("W");
			patientTable.setItems(sortedPatients);
		});
		xPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("X");
			patientTable.setItems(sortedPatients);
		});
		yPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("Y");
			patientTable.setItems(sortedPatients);
		});
		zPatients.setOnAction((event)->{
			
			sortedPatients = new PatientEntityController().viewSortedPatients("Z");
			patientTable.setItems(sortedPatients);
		});
		
		
		
		
		clearBtn.setOnAction((event)->{
			
			searchTextField.setText(null);
		});
		
		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddPatient", null, Locale.US);
				formPath.closeApplicationContext();
				searchPatientController = null;
				PatientInputController patientInputController = 
				(PatientInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				patientInputController.setPatientViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		viewPatientBtn.setOnAction((event) -> {
			try {
				
				Patient patient = patientTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditPatient", null, Locale.US);
				
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
				formPath.closeApplicationContext();
				//searchPatientController = null;
				
				if (patient != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					PatientEditController editController = fxmlLoader.getController();
					editController.setPatient(patient);
					editController.setPatientViewController(this);
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Patient");
					alert.showAndWait();

				}
			/*PatientEditController patientEditController = 
				(PatientEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				patientEditController.setPatientViewController(this);*/

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		addNewOrgBtn.setOnAction((event)->{
			try {
				
				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			try {
				
				Patient selectedPatient = this.patientTable.getSelectionModel().getSelectedItem();
				
				setPatient(selectedPatient);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
			//	formPath.closeApplicationContext();
				
				if(selectedPatient != null){
					
					if(SearchPatientController.button==null){
						
						
						PatientAppointmentInputController patientAppointmentInputController = new PatientAppointmentInputController();
						String formName = formPath.context.getMessage("PatientAppointment", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.PatientAppointment", null, Locale.US);
						formPath.closeApplicationContext();
						
						patientAppointmentInputController =(PatientAppointmentInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						patientAppointmentInputController.setPatientViewController(this,selectedPatient);
						
						
					}
					else{
						if(SearchPatientController.button.getId().equals("scheduleNewAppointmentBtn")){
							
						PatientAppointmentInputController patientAppointmentInputController = new PatientAppointmentInputController();
						//patientAppointmentInputController.setVisitType(selectedPatient.getSocialSecurityNo());
																
						String formName = formPath.context.getMessage("PatientAppointment", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.PatientAppointment", null, Locale.US);
						formPath.closeApplicationContext();
						
						patientAppointmentInputController =(PatientAppointmentInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						
						//patientAppointmentInputController.setVisitType(selectedPatient.get);
						//patientAppointmentInputController.setClinicianId(selectedPatient.get);
						if(selectedPatient.getPcp() != null){
							patientAppointmentInputController.setProviderName(selectedPatient.getPcp().getSuffix()+" "+selectedPatient.getPcp().getFirstName() +" "+selectedPatient.getPcp().getMiddleName()+" "+selectedPatient.getPcp().getLastName());
							patientAppointmentInputController.setProviderCode(selectedPatient.getPcp().getCode());
						}
										
						patientAppointmentInputController.setPatientViewController(this,selectedPatient);
						
					}else if (SearchPatientController.button.getId().equals("changeAppointment")) {
						
						String formName = formPath.context.getMessage("ViewPatientAppointment", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.ViewPatientAppointment", null, Locale.US);
						formPath.closeApplicationContext();
						
						patientAppointmentList = new PatientAppointmentEntityController().viewById(selectedPatient.getId());
					    PatientAppointmentViewController patientAppointmentViewController =	(PatientAppointmentViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					    patientAppointmentViewController.setPatientViewController(this, SearchPatientController.button);
						
						
					}else if (SearchPatientController.button.getId().equals("checkInBtn")) {
						
						String formName = formPath.context.getMessage("VisitType", null, Locale.US);
						String formTitle1 = formPath.context.getMessage("Title.VisitType", null, Locale.US);
						String formTitle2 = selectedPatient.getPatientName().getFirstName();
						String formTitle = formTitle1+"/"+formTitle2;
						formPath.closeApplicationContext();
						
						VisitLogSelectController visitLogInputController  = (VisitLogSelectController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						visitLogInputController.setPatientViewController(this);
						
					}else if (SearchPatientController.button.getId().equals("visitByPatientBtn")) {
						
						String formName = formPath.context.getMessage("VisitByPatient", null, Locale.US);
						String formTitle1 = formPath.context.getMessage("Title.VisitByPatient", null, Locale.US);
						String formTitle2 = selectedPatient.getPatientName().getFirstName();
						String formTitle = formTitle1+"/"+formTitle2;
						formPath.closeApplicationContext();
						
						new FXFormCommonUtilities().displayForm(formName, formTitle);
						
					}else if (SearchPatientController.button.getId().equals("chartByPatientBtn")) {
						
						//String formName = formPath.context.getMessage("VisitByPatient", null, Locale.US);
						String formName = "/view/code/appointmentSetup/patient/VisitByPatient.fxml";
						//String formTitle1 = formPath.context.getMessage("VisitByPatient", null, Locale.US);
						String formTitle1 = "Select Patient";
						String formTitle2 = selectedPatient.getPatientName().getFirstName();
						String formTitle = formTitle1+"/"+formTitle2;
						formPath.closeApplicationContext();
						
						new FXFormCommonUtilities().displayForm(formName, formTitle);
						
					}else if (SearchPatientController.button.getId().equals("addButton")) {
						
						String formName = formPath.context.getMessage("VisitType", null, Locale.US);
						String formTitle1 = formPath.context.getMessage("Title.VisitType", null, Locale.US);
						String formTitle2 = selectedPatient.getPatientName().getFirstName();
						String formTitle = formTitle1+"/"+formTitle2;
						formPath.closeApplicationContext();
						
						new FXFormCommonUtilities().displayForm(formName, formTitle);
						
					}/*else if (button.getId().equals("patientBtn")) {
						
						inventoryOutGoInputController.setPatient(selectedPatient.getPatientName().getFirstName());
						
					}	*/		
					
						
					}					
						
					new FXFormCommonUtilities().closeForm(selectButton);
					
					
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Patient");
					alert.showAndWait();
					
				}
								
				
				
			} catch (Exception ex) {
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
