package com.ets.controller.gui.clinic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.gui.adminSecurity.UserAddController;
import com.ets.controller.gui.adminSecurity.UserEditController;
import com.ets.controller.gui.adminSecurity.UserViewController;
import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.appointment.PatientAppointmentViewController;
import com.ets.controller.gui.billingPanel.PatientAnalysisController;
import com.ets.controller.gui.clinicSchedule.ClinicScheduleSetUpController;
import com.ets.controller.gui.clinicSchedule.ClinicScheduleViewController;
import com.ets.controller.gui.clinician.ClinicianEditController;
import com.ets.controller.gui.clinician.ClinicianInputController;
import com.ets.controller.gui.icd10Diagonosis.ICD10DiagonosisInputController;
import com.ets.controller.gui.inventory.outGo.InventoryOutGoInputController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.controller.gui.patientVisitByDate.PatientVisitByDateViewController;
import com.ets.controller.gui.staffSchedule.StaffScheduleSetUpController;
import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.controller.gui.visitLog.VisitLogSelectController;
import com.ets.controller.mainWindowGUIController.MainWindowGUIController;
import com.ets.model.Clinic;
import com.ets.model.ClinicSchedule;
import com.ets.model.Division;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.utils.UIRecordNavigation;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-06-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicViewController Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:Neha Sahadev
 *Owner:
 *Date:21/11/2017
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class ClinicViewController implements Initializable {

	@FXML
	private TextField searchTextBox;
	
	
	@FXML
	private TableView<Patient> patientTable;

	@FXML
	private TableView<Clinic> clinicTable;

	@FXML
	private TableColumn<Clinic, String> clinicNameCollumn;

	@FXML
	private TableColumn<Clinic, String> clinicCodeCollumn;

	@FXML
	private TableColumn<Clinic, String> clinicCityCollumn;

	@FXML
	private TableColumn<Clinic, String> clinicStateCollumn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button printButton;
	
	@FXML
    private Button selectButton;

	@FXML
	private CheckBox includeCheckBox;

	
	public void setPatient(Patient patient) {

		Global.patient = patient;

	}
	Date frmdate;
	Date todate;
	
	    @FXML
	    void enterKeyPressedForChangeButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		try {
	    			
	    			Clinic clinic = clinicTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EditClinic", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditClinic", null, Locale.US);
					
					String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
					String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

					formPath.closeApplicationContext();
					
					if(clinic != null){
						
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.setTitle(formTitle);
						stage.setScene(new Scene(root1));
						ClinicEditController editController = fxmlLoader.getController();
						editController.setClinicViewController(this);
						editController.setClinic(clinic);

						stage.show();
						
					}else{
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(editInfo);
						alert.showAndWait();
						
					}
						
	    			
	    	} catch (Exception ex) {
				ex.printStackTrace();
	    	}
	    	}
	    }
	    
	    
	    public static List<Clinic> clinicList = null;
	    
	    
		public static List<PatientVisit> patientVisitList = null;
	    

	    @FXML
	    void enterKeyPressedForCloseButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		 try {
	    			// cancel centralized form
	 				new FXFormCommonUtilities().closeForm(closeButton);
   		 
	    		 } catch (Exception ex) {
			ex.printStackTrace();
		} 
		 }
	    }
	    @FXML
	    void enterKeyPressedForDeleteButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		 try {
	   

	 				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
	 				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
	 				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
	 				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

	 				formPath.closeApplicationContext();
	 				
	 				Integer cli = clinicTable.getSelectionModel().getSelectedIndex();
	 				if(cli > -1){
	 					Alert alert = new Alert(AlertType.CONFIRMATION);
	 					alert.setTitle(conformDialogBoxTitle);
	 					alert.setHeaderText(conformDelete);
	 					alert.setContentText(null);

	 					Optional<ButtonType> result = alert.showAndWait();
	 					if(result.get() == ButtonType.OK){
	 						
	 						Clinic clinic = new ClinicEntityController().viewClinic().get(cli);
	 						new ClinicEntityController().removeClinic(clinic.getId());
	 						clinicView();
	 						
	 					}else{
	 						
	 					}
	 					
	 				}else{
	 					
	 					Alert alert = new Alert(AlertType.INFORMATION);
	 					alert.setTitle(infoDialogBoxTitle);
	 					alert.setHeaderText(null);
	 					alert.setContentText(deleteInfo);

	 					alert.showAndWait();
	 					
	 				}
	 				
	    		 
	    		 } catch (Exception ex) {
			ex.printStackTrace();
		} 
		 }

	    }

	    @FXML
	    void enterKeyPressedForPrintButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		 try {
	   
	    				String str = "target/classes/report/ClinicReport.jrxml";

	    				InputStream is = new FileInputStream(new File(str));

	    				JasperReport jasperReport = JasperCompileManager.compileReport(is);

	    				List<Clinic> clinicList = new ClinicEntityController().viewClinic();
	    				JRDataSource JRdataSource = new JRBeanCollectionDataSource(clinicList);
	    				Map<String, Object> map = new HashMap<String, Object>();
	    				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

	    				JasperViewer.viewReport(jasperPrint, false);


	    		 
	    		 } catch (Exception ex) {
			ex.printStackTrace();
		} 
		 }

	    }

	    @FXML
	    void enterKeyPressedForSelectButton(KeyEvent event) {

	    	if(event.getCode() == KeyCode.ENTER){
	    		 try {
	   
	    			 Clinic selectedClinic = this.clinicTable.getSelectionModel().getSelectedItem();
	    				
	    				if(userAddController != null){
	    					
	    					this.userAddController.setdClinicRestrictTextField(selectedClinic.getName());
	    					
	    				}else if (clinicianInputController != null) {
	    					
	    					clinicianInputController.setClinic(selectedClinic.getName());
	    					
	    				}else if (clinicianEditController != null) {
	    					
	    					clinicianEditController.setClinic(selectedClinic.getName());
	    					
	    				}else {
	    					
	    					setClinic(selectedClinic);
	    					//userLoginGUIController.initRootLayout();
	    					
	    					
	    				}			
	    					new FXFormCommonUtilities().closeForm(selectButton);
	    								
	    		 
	    		 } catch (Exception ex) {
			ex.printStackTrace();
		} 
		 }
	    }
	
	 @FXML
	    void doubleClicked(MouseEvent event) {
		 
		 if(event.getClickCount() == 2){
			 
			 try {

					Clinic clinic = clinicTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EditClinic", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditClinic", null, Locale.US);

					formPath.closeApplicationContext();

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ClinicEditController editController = fxmlLoader.getController();
					editController.setClinicViewController(this);
					editController.setClinic(clinic);

					stage.show();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 
		 }

	    }
	 
	 @FXML
	    void enterKeyPressedForAddButton(KeyEvent event) {
	 if(event.getCode() == KeyCode.ENTER){
		 try{
			 

				String formName = formPath.context.getMessage("AddClinic", null, Locale.US);
				
				String formTitle = formPath.context.getMessage("Title.AddClinic", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicInputController clinicInputController = 
				(ClinicInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				clinicInputController.setClinicViewController(this); 
			 
		 } catch (Exception ex) {
				ex.printStackTrace();
			} 
		 }
	 }

	FXMLFormPath formPath = new FXMLFormPath();
	
	private UserAddController userAddController;
		
	public void setUserAddController(UserAddController userAddController) {
		this.userAddController = userAddController;
	}
	
	private UserEditController userEditController;

	public void setUserEditController(UserEditController userEditController) {
		this.userEditController = userEditController;
	}
	
	private PatientAnalysisController patientAnalysisController;
	
    public void setPatientAnalysisController(PatientAnalysisController patientAnalysisController) {
	this.patientAnalysisController = patientAnalysisController;
	
	}
    
    
    
  
private PatientVisitByDateViewController patientVisitByDateViewController;
	
    public void setPatientVisitByDateViewController(PatientVisitByDateViewController patientVisitByDateViewController, Date date1, Date date2) {
	this.patientVisitByDateViewController = patientVisitByDateViewController;
	this.frmdate = date1;
	this.todate = date2;
	
	}
    
    
    
    
    
	private ClinicianInputController clinicianInputController;
	
	public void setClinicianInputController(ClinicianInputController clinicianInputController) {
		this.clinicianInputController = clinicianInputController;
	}
	
	private ClinicianEditController clinicianEditController;
	
	public void setClinicianEditController(ClinicianEditController clinicianEditController) {
		this.clinicianEditController = clinicianEditController;
	}
	
	private InventoryOutGoInputController inventoryOutGoInputController;
		
	public void setInventoryOutGoInputController(InventoryOutGoInputController inventoryOutGoInputController) {
		this.inventoryOutGoInputController = inventoryOutGoInputController;
	}

	private ClinicScheduleSetUpController clinicScheduleSetUpController;
    public void setClinicScheduleSetUpController(ClinicScheduleSetUpController clinicScheduleSetUpController) {
		this.clinicScheduleSetUpController = clinicScheduleSetUpController;
		
	
		}
    
    
    


	private static UserLoginGUIController userLoginGUIController;
	
	
	
	public static void setUserLoginGUIController(UserLoginGUIController userLoginGUIController) {
		ClinicViewController.userLoginGUIController = userLoginGUIController;
	}
	
	
    private AppointmentController appointmentController;

	public void setAppointmentController(AppointmentController appointmentController) {
		this.appointmentController = appointmentController;
		
		
	}

	public void showSelectButton(){
		selectButton.setVisible(true);
	}
	
	public void hideSelectButton(){
		selectButton.setVisible(false);
	}
	
	private ObservableList<Clinic> clinicMasterData = FXCollections.observableArrayList();
	 List<ClinicSchedule> anotherClinicScheduleTimeList=null;
	public void clinicView() {
		
		clinicMasterData = new ClinicEntityController().viewClinic();
		
		clinicCodeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		clinicNameCollumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		clinicCityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
		clinicStateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
		
		FilteredList<Clinic> filteredData = new FilteredList<Clinic>(clinicMasterData, p -> true);
		
		
		/*searchTextBox.setOnKeyPressed((event) -> {
			
			
			filteredData.setPredicate(clinic -> {
				String lowerCaseFilter = searchTextBox.getText().toLowerCase();		
				
				if (lowerCaseFilter.isEmpty() || lowerCaseFilter == null) {
										
					return true;
					
				}else{
					//String lowerCaseFilter = searchTextBox.getText().toLowerCase();
										
					if (clinic.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					} 

					return false;
				}
				
				
			});

		});*/
				
		searchTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(clinic -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (clinic.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
	
		SortedList<Clinic> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(clinicTable.comparatorProperty());
				
		clinicTable.setItems(sortedData);
					
	}
	
	private static MainWindowGUIController mainWindowGUIController;
		
	public void setMainWindowGUIController(MainWindowGUIController mainWindowGUIController) {
		this.mainWindowGUIController = mainWindowGUIController;
	}

	public void setClinic(Clinic clinic){
			
		Global.clinic = clinic;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//hideSelectButton();
		
		clinicView();
		
		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddClinic", null, Locale.US);
				
				String formTitle = formPath.context.getMessage("Title.AddClinic", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicInputController clinicInputController = 
				(ClinicInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				clinicInputController.setClinicViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		changeButton.setOnAction((event) -> {
			try {

				Clinic clinic = clinicTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditClinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditClinic", null, Locale.US);
				
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				if(clinic != null){
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ClinicEditController editController = fxmlLoader.getController();
					editController.setClinicViewController(this);
					editController.setClinic(clinic);

					stage.show();
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
					
				}
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		deleteButton.setOnAction((event) -> {
			// Delete Complex Details
			
			try {
				
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				Integer cli = clinicTable.getSelectionModel().getSelectedIndex();
				if(cli > -1){
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if(result.get() == ButtonType.OK){
						
						Clinic clinic = new ClinicEntityController().viewClinic().get(cli);
						new ClinicEntityController().removeClinic(clinic.getId());
						clinicView();
						
					}else{
						
					}
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);

					alert.showAndWait();
					
				}
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		 
		selectButton.setOnAction((event) -> {
			
			
			
			/*Patient selectedPatient = this.patientTable.getSelectionModel().getSelectedItem();
			
			setPatient(selectedPatient);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			
			formPath.closeApplicationContext();*/
			
			
			
			
			Clinic selectedClinic = this.clinicTable.getSelectionModel().getSelectedItem();
			
			
			if(userAddController != null){
				
				this.userAddController.setdClinicRestrictTextField(selectedClinic.getName());
				
			}else if (userEditController != null) {
				
				//userEditController.setClinic(selectedClinic.getName());
				userEditController.setdClinicRestrictTextField(selectedClinic.getName());
				
			}
			
			
			
			
			
			else if (patientAnalysisController != null) {
				System.out.println("ftrfyrftyrfy"+ selectedClinic);
				patientAnalysisController.setClinic(selectedClinic);
				}
			
			
			
			
		/*	else if (patientVisitByDateViewController != null ) {
				System.out.println("guyghuyghu"+ selectedClinic);
				patientVisitByDateViewController.setClinic(selectedClinic.getId());
				}
			
			*/
			
			
			
			
			else if (clinicianInputController != null) {
				
				clinicianInputController.setClinic(selectedClinic.getName());
				
			}else if (clinicianEditController != null) {
				
				clinicianEditController.setClinic(selectedClinic.getName());
				
			}else if (inventoryOutGoInputController != null) {
				
				inventoryOutGoInputController.setClinic(selectedClinic.getName());
				
			}else if(clinicScheduleSetUpController!=null){
				Global.clinic = selectedClinic;
				
				anotherClinicScheduleTimeList = clinicScheduleSetUpController.clinicScheduleViewController.clinicView();
				
				String formName = formPath.context.getMessage("ClinicScheduleExceptionButton", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicScheduleExceptionButton", null, Locale.US);
				
				formPath.closeApplicationContext();
				
				clinicScheduleSetUpController.closeForm();
			    ClinicScheduleSetUpController clinicScheduleSetUpController =  
						(ClinicScheduleSetUpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			     clinicScheduleSetUpController.setClinicScheduleViewController(clinicScheduleSetUpController.clinicScheduleViewController, anotherClinicScheduleTimeList);
				
				/*clinicScheduleSetUpController.refresh();
				clinicScheduleSetUpController.setClinicScheduleViewController(clinicScheduleSetUpController.clinicScheduleViewController, anotherClinicScheduleTimeList);
			*/
			     
			     
		/*	} else if (patientVisitByDateViewController != null) {{
						//Global.patientVisitObj.setIcd10Codes(ICD10DiagonosisInputController.icd10CodesList);
					}
					Global.patientVisitObj.setVisitType(visitTypeChoiceBox.getSelectionModel().getSelectedItem());
					Global.patientVisitObj.setCompletionTime(complectionTimeText.getText());
					Global.patientVisitObj.setArrivalTime(arrivalTimeText.getText());
					Global.patientVisitObj.setStartTime(startTimeText.getText());
					Global.patientVisitObj.setPurpose(purposeText.getText());
					Global.patientVisitObj.setProviderTimeIn(providerInTimeText.getText());
					Global.patientVisitObj.setProviderTimeOut(providerOutTime.getText());
					if (visitCat != null) {
						Global.patientVisitObj.setVisitCategory(visitCat);
					}
					Global.patientVisitObj.setPurpose(purposeText.getText());*/
			     
			     
			/*} else if (patientVisitByDateViewController != null) {
				
				String formName = formPath.context.getMessage("VisitByDate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitByDate", null, Locale.US);
				formPath.closeApplicationContext();
				
				
				patientVisitList = new PatientVisitEntityController().viewById(selectedClinic.getId(), frmdate, todate);
				PatientVisitByDateViewController patientVisitByDateViewController =	(PatientVisitByDateViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			    patientVisitByDateViewController.setClinicViewController(this, PatientVisitByDateViewController.button);*/
			     
			     
			     
			/*}else if (patientVisitByDateViewController != null && (PatientVisitByDateViewController.button.getId().equals("visitByDateBtn"))) {
							
				String formName = formPath.context.getMessage("VisitByDate", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.VisitByDate", null, Locale.US);
				String formTitle2 = selectedClinic.getPatientName().getFirstName();
				String formTitle = formTitle1+"/"+formTitle2;
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			*/
				
				/*PatientVisitByDateViewController patientVisitByDateViewController  = (PatientVisitByDateViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				patientVisitByDateViewController.setPatientViewController(this);
				*/
				
			     
			     
			     
			     
			//}else if (patientVisitByDateViewController != null && (PatientVisitByDateViewController.button.getId().equals("visitByDateBtn"))) {
				
				
			}else if (patientVisitByDateViewController != null) {
				
				
		
				
				patientVisitList = new PatientVisitEntityController().searchPatient(frmdate, todate, Global.clinic.getId());
				
				System.out.println("dsfasdasdsda");
				
				
			}
			
			
			
			
			
			
			
			else if(appointmentController!=null){
				Global.clinic=selectedClinic;
				System.out.println("####################################### "+Global.clinic.getId());
				
				try {
					// Load Appointments Details .

					String formName = formPath.context.getMessage("Appointment", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.Appointment", null, Locale.US);
					
					//String formTitle2= Global.clinic.getName();
					String formTitle2 = null;
					if(Global.clinic == null){
						 formTitle2 = "";
					}else{
						 formTitle2 = Global.clinic.getName();
					}
					String formTitle = formTitle1+"/"+formTitle2;
					
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

				
				
				}
			
			else {
			
				
				setClinic(selectedClinic);
				//userLoginGUIController.initRootLayout();
				
				
			}			
				new FXFormCommonUtilities().closeForm(selectButton);
							

		});

		printButton.setOnAction((event) -> {
			// Print Clinic Details
			try {

				String str = "target/classes/report/ClinicReport.jrxml";

				InputStream is = new FileInputStream(new File(str));

				JasperReport jasperReport = JasperCompileManager.compileReport(is);

				List<Clinic> clinicList = new ClinicEntityController().viewClinic();
				JRDataSource JRdataSource = new JRBeanCollectionDataSource(clinicList);
				Map<String, Object> map = new HashMap<String, Object>();
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

				JasperViewer.viewReport(jasperPrint, false);


			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(clinicTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = clinicTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(clinicTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = clinicTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(clinicTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = clinicTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(clinicTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		*/
		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}
}
