package com.ets.controller.gui.patientVisitByPatient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Clinician;
import com.ets.model.DepartmentUnit;
import com.ets.model.District;
import com.ets.model.Icd10Codes;
import com.ets.model.PatientVisit;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class VisitByPatientViewController implements Initializable {
	
	@FXML
    private TableView<PatientVisit> patientVisitTable;

    @FXML
    private TableColumn<PatientVisit, String> dateCollumn;

    @FXML
    private TableColumn<PatientVisit, String> arriveCollumn;

    @FXML
    private TableColumn<PatientVisit, String> patientCollumn;

    @FXML
    private TableColumn<PatientVisit, String> purposeOfVisitCollumn;

    @FXML
    private TableColumn<PatientVisit, String> typeCollumn;

    @FXML
    private TableColumn<PatientVisit, String> statusCollumn;
    
	@FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    /*@FXML
    private Button deleteButton;*/

    @FXML
    private Button closeButton;
    

    @FXML
    private Button chartVisitBtn;

    @FXML
    private Button printButton;
    
    private ObservableList<PatientVisit> patientVisitMasterData = FXCollections.observableArrayList();
    
    public void viewPatientVisit(){
    	
    	System.out.println("### pat visit size is "+patientVisitMasterData.size());
    	patientVisitMasterData = new PatientVisitEntityController().viewByPat(Global.patient.getId());
    	for (PatientVisit patientVisit : patientVisitMasterData) {
		    System.out.println("id "+patientVisit.getId());	
		  //  System.out.println("name "+patientVisit.getArrivalTime());
		}
    	dateCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("visitDate"));
    	arriveCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("arrivalTime"));
    	patientCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getPatient().getPatientName().firstNameProperty());
    	purposeOfVisitCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("purpose"));
    	typeCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("type"));
    	statusCollumn.setCellValueFactory(new PropertyValueFactory<PatientVisit, String>("visitStatus"));
    	
    	patientVisitTable.setItems(patientVisitMasterData);
    	
    }
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewPatientVisit();
		
		
		/*deleteButton.setOnAction((event) -> {
			try {
			   PatientVisit patientVisit = patientVisitTable.getSelectionModel().getSelectedItem();
			   
			   if(patientVisit!=null){
				   
			   new PatientVisitEntityController().delete(patientVisit.getId());
			   }
				
				viewPatientVisit();
				new FXFormCommonUtilities().closeForm( deleteButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		addButton.setOnAction((event) -> {
			try {
				
             /* String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
				PatientVisit patientVisit = patientVisitTable.getSelectionModel().getSelectedItem();
				
				if(patientVisit==null){

						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText("Please Select a patient visit");
						alert.showAndWait();
				
				}else{
				Global.patientVisitObj=patientVisit;
				}*/
				
				
				String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);
				
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient == null){
					 formTitle2 = "";
					 formTitle4 = "";
				}else{
					 formTitle2= Global.patient.getPatientName().getFirstName();
					 if(Global.company!=null){
					 formTitle4= Global.patient.getCompany().getName();
					 }else{
						 formTitle4 = ""; 
						 
					 }
				}
				
				if(Global.clinic == null){
					
					formTitle3 = "";
					
				}else{
					
					formTitle3= Global.clinic.getName();
					
				}
				
				/*String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle3= Global.clinic.getName();
				String formTitle4= Global.patient.getCompany().getName();*/
			     
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3+"/"+formTitle4;
				
				formPath.closeApplicationContext();
				VisitLogInputController visitLogInputController =  
				(VisitLogInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				visitLogInputController.addNewVisit(this);
				//visitLogInputController.setVisitByPatientViewController(this, addButton);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {

				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
				PatientVisit patientVisit = patientVisitTable.getSelectionModel().getSelectedItem();
				
				if(patientVisit==null){

						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText("Please Select a patient visit");
						alert.showAndWait();
				
				}else{
				Global.patientVisitObj = patientVisit;
				System.out.println("Patient Visit Id is : " +Global.patientVisitObj.getId());
				System.out.println("Patient Visit ICD10 Size is  : " +Global.patientVisitObj.getIcd10Codes().size());
				
				String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);
				//String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle3= Global.clinic.getName();
				//String formTitle4= Global.patient.getCompany().getName();
				
				String formTitle2 = null;
				if(Global.patient == null){
					formTitle2 = "";
				}else{
					formTitle2=  Global.patient.getPatientName().getFirstName();
				}
				
				String formTitle4 = null;
				if(Global.company == null){
					formTitle4 = "";
				}else{
					 formTitle4= Global.patient.getCompany().getName();
				}
			     
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3+"/"+formTitle4;
				
				formPath.closeApplicationContext();
				VisitLogInputController visitLogInputController =  
						(VisitLogInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						
				visitLogInputController.setPatientVisit2(patientVisit);
						visitLogInputController.setVisitByPatientViewController(this);
				
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		closeButton.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		chartVisitBtn.setOnAction((event) -> {
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			
			PatientVisit patientVisit = patientVisitTable.getSelectionModel().getSelectedItem();
			
			
			
			if(patientVisit==null){

					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText("Please Select a patient visit");
					alert.showAndWait();
			
			}else{
			Global.patientVisitObj=patientVisit;
			String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);
			formPath.closeApplicationContext();
			
			VisitLogInputController visitLogInputController = 
			(VisitLogInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			visitLogInputController.setVisitByPatientViewController(this,patientVisit);
			visitLogInputController.showEMRchartingButton();
			Global.patientVisitObj.setWaitingRoom(true);
			Global.patientVisitObj.setExamRoom1(false);
			Global.patientVisitObj.setExamRoom2(false);
			Global.patientVisitObj.setCheckOut(false);
			Global.patientVisitObj.setExamRoom7(false);
			Global.patientVisitObj.setEyeRoom(false);
			Global.patientVisitObj.setHcg(false);
			Global.patientVisitObj.setLab(false);
			Global.patientVisitObj.setXRay(false);
			Global.patientVisitObj.setPhysicalRoom(false);
			Global.patientVisitObj.setLacerationRoom(false);
			//new VisitLogInputController().showEMRchartingButton();
			
			}
		});
		
		printButton.setOnAction((event) -> {
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.PatientVisit", null, Locale.US);
			formPath.closeApplicationContext();

		// Need the ProgressBar controller to access the progress bar in
		// this method
		ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
				.displayFormAndGetController(formName1, formTitle1);
		ProgressBar progressBar = progressBarGUIController.getProgressBar();

		/********************************
		 * Start of Task definition
		 *****************************************************************/
		Task<ObservableList<PatientVisit>> task =

				new Task<ObservableList<PatientVisit>>() {

					@Override
					protected ObservableList<PatientVisit> call() throws Exception {

						ObservableList<PatientVisit> patientVisitList = null;

						try {
							System.out.println("Generating PDF...");
							String printPatientVisit = formPath.context.getMessage("Print.PatientVisit", null, Locale.US);
							formPath.closeApplicationContext();
							InputStream is = this.getClass().getResourceAsStream(printPatientVisit);
							JasperReport jasperReport = JasperCompileManager.compileReport(is);
							patientVisitList = new PatientVisitEntityController().viewByPat(Global.patient.getId());
							JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientVisitList);
							Map<String, Object> map = new HashMap<String, Object>();
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
							JasperViewer.viewReport(jasperPrint, false);
							System.out.println("FirstReport.pdf has been generatedd!");

						} catch (Exception ex) {
							ex.printStackTrace();
						}

						if (isCancelled()) {
							return null;
						}
						return patientVisitList;

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
