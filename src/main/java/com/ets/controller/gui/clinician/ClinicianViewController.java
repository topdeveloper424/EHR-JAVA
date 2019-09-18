package com.ets.controller.gui.clinician;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

*Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
*File Creation Date: 10-02-2016
*Initial Version: 0.01
*Module Name:
*Parameter Definition: Type object of ViewAllProviderController Class
*Description: SelectProvider.fxml Controller class
*Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*Modification:
*Owner:
*Date:
*Version:
*Description:
*Backup Location for Previous Version:
*
*Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
*/

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.appointment.PatientAppointmentEditController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.carriers.CarrierEditController;
import com.ets.controller.gui.clinicianSchedule.ClinicianSelectController;
import com.ets.controller.gui.genericVisitProtocal.EnterVitalSignGUIController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Carrier;
import com.ets.model.Clinician;
import com.ets.model.Pharmacy;
import com.ets.model.Provider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
import javafx.scene.control.Alert.AlertType;

public class ClinicianViewController implements Initializable {

    @FXML
    private TextField SearchFxText;
   
    @FXML
    private Button deleteFxClinician;

    @FXML
    private CheckBox IncludeInactivecheck;

    @FXML
    private Button addBtn;
    
    @FXML
    private Button changeButton;
    

    @FXML
    private Button printButton;
    @FXML
    private Button selectButton;

    @FXML
    private Button closeBtn;

    @FXML
    private TableView<Clinician> clinicianTable;

    @FXML
    private TableColumn<Clinician, String> ClinicianNameFXCol;

    @FXML
    private TableColumn<Clinician, String> CodeFxCol;

    @FXML
    private TableColumn<Clinician, String> TypeFxCol;

    @FXML
    private TableColumn<Clinician, Boolean> InacfxCol;
    
    private EnterVitalSignGUIController enterVitalSignGUIController;
  
	public void setEnterVitalSignGUIController(EnterVitalSignGUIController enterVitalSignGUIController) {
		this.enterVitalSignGUIController = enterVitalSignGUIController;
	}

	@FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {

			String formName = formPath.context.getMessage("AddClinician", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddClinician", null, Locale.US);
			formPath.closeApplicationContext();
			
			
        ClinicianInputController clinicianInputController=(ClinicianInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
             clinicianInputController.setClinicianViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}}

    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			
			// Load Clinician Details Edit form .

			Clinician clinician = clinicianTable.getSelectionModel().getSelectedItem();
			
		

			String formName = formPath.context.getMessage("EditClinician", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditClinician", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			formPath.closeApplicationContext();

			if (clinician != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicianEditController editController = fxmlLoader.getController();
				editController.setClinician(clinician);
				editController.setClinicianViewController(this);
				stage.show();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(infoDialogBoxTitle);
				alert.setHeaderText(null);
				alert.setContentText(editInfo);
				alert.showAndWait();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }}

    @FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			new FXFormCommonUtilities().closeForm(closeBtn);
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

			Integer clinicianIndex =  clinicianTable.getSelectionModel().getSelectedIndex();

			if (clinicianIndex > -1) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				
				if (result.get() == ButtonType.OK) {
					
					Clinician clinician = new ClinicianEntityController().view().get(clinicianIndex);
					
					new ClinicianEntityController().delete(clinician.getId());
					
					viewClinician();

					
				} else {

				}

			} else {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(infoDialogBoxTitle);
				alert.setHeaderText(null);
				alert.setContentText(deleteInfo);

				alert.showAndWait();

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}}

    }

    @FXML
    void enterKeyPressedForPrintButton(KeyEvent event) {

    }

    @FXML
    void enterKeyPressedForSelectButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	Clinician selectClinician = clinicianTable.getSelectionModel().getSelectedItem();
		if(clinicianSelectController != null){
			
			clinicianSelectController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
			clinicianSelectController.setClinicianType(selectClinician.getType());
			clinicianSelectController.setClinicianId(selectClinician.getId());
			
		}else if (patientAppointmentInputController != null) {
			
			patientAppointmentInputController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
			patientAppointmentInputController.setClinicianCode(selectClinician.getCode());
		
		}
    	
		new FXFormCommonUtilities().closeForm(selectButton);
    	}

    }
    
    @FXML
    void doubleClick(MouseEvent event) {
    	
    	if (event.getClickCount() == 2) {
			try {
				Clinician clinician = clinicianTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditClinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditClinician", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicianEditController editController = fxmlLoader.getController();
				editController.setClinician(clinician);
				editController.setClinicianViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

    }
    
	
	 private ObservableList<Clinician> clinicianMasterData = FXCollections.observableArrayList();
	 
	public void viewClinician(){
		
		clinicianMasterData = new ClinicianEntityController().view();
		
		ClinicianNameFXCol.setCellValueFactory(cellValue -> cellValue.getValue().firstNameProperty());
		CodeFxCol.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		TypeFxCol.setCellValueFactory(cellValue->cellValue.getValue().typeProperty());
		InacfxCol.setCellValueFactory(cellValue->cellValue.getValue().inactiveProperty());
		
		
FilteredList<Clinician> filteredData = new FilteredList<Clinician>(clinicianMasterData, p -> true);
		
SearchFxText.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(clinician -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (clinician.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		IncludeInactivecheck.setOnAction((event) -> {

			filteredData.setPredicate(clinician -> {
				
				if (IncludeInactivecheck.isSelected()) {
					
					return clinician.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Clinician> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(clinicianTable.comparatorProperty());
				
		clinicianTable.setItems(sortedData);
		
		//clinicianTable.setItems(new ClinicianEntityController().view());
		
	}
	
	 private ClinicianSelectController clinicianSelectController;
	    
		public void setClinicianSelectController(ClinicianSelectController clinicianSelectController) {
			this.clinicianSelectController = clinicianSelectController;
		}
		
		private PatientAppointmentInputController patientAppointmentInputController;
				
		public void setPatientAppointmentInputController(PatientAppointmentInputController patientAppointmentInputController) {
			this.patientAppointmentInputController = patientAppointmentInputController;
		}
		
		private PatientAppointmentEditController patientAppointmentEditController;
		
		public void setPatientAppointmentEditController(PatientAppointmentEditController patientAppointmentEditController) {
			this.patientAppointmentEditController = patientAppointmentEditController;
		}
		
		private MedicalActivityChargeInputController medicalActivityChargeInputController;
		
		public void setMedicalActivityChargeInputController(
				MedicalActivityChargeInputController medicalActivityChargeInputController) {
			this.medicalActivityChargeInputController = medicalActivityChargeInputController;
		}
		
		private MedicalActivityChargeEditController medicalActivityChargeEditController;
				
		public void setMedicalActivityChargeEditController(
				MedicalActivityChargeEditController medicalActivityChargeEditController) {
			this.medicalActivityChargeEditController = medicalActivityChargeEditController;
		}


		private VisitLogInputController visitLogInputController;
		
		public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
			this.visitLogInputController = visitLogInputController;
		}

		FXMLFormPath formPath = new FXMLFormPath();
		

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
          viewClinician();
          
		addBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddClinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddClinician", null, Locale.US);
				formPath.closeApplicationContext();
								
	ClinicianInputController clinicianInputController=(ClinicianInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
                 clinicianInputController.setClinicianViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				// Load Clinician Details Edit form .

				Clinician clinician = clinicianTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditClinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditClinician", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (clinician != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ClinicianEditController editController = fxmlLoader.getController();
					editController.setClinician(clinician);
					editController.setClinicianViewController(this);
					stage.show();

				} else {
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
		
		selectButton.setOnAction((event) -> {
			
				Clinician selectClinician = clinicianTable.getSelectionModel().getSelectedItem();
				if(clinicianSelectController != null){
					clinicianSelectController.setClinician(selectClinician);
					clinicianSelectController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
					clinicianSelectController.setClinicianType(selectClinician.getType());
					//clinicianSelectController.setClinicianId(selectClinician.getId());
					
				}else if (patientAppointmentInputController != null) {
					
					patientAppointmentInputController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
					patientAppointmentInputController.setClinicianCode(selectClinician.getCode());
				
					
				}else if (patientAppointmentEditController != null) {
					
					//patientAppointmentEditController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
					patientAppointmentEditController.setClinicianName(selectClinician);
				
				}else if (medicalActivityChargeInputController != null) {
					
					/*medicalActivityChargeInputController.setClinicianId(Integer.toString(selectClinician.getId()));
					medicalActivityChargeInputController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());*/
					medicalActivityChargeInputController.setClinician(selectClinician);
					
				}else if (medicalActivityChargeEditController != null) {
					
					//medicalActivityChargeEditController.setClinicianId(Integer.toString(selectClinician.getId()));
					//medicalActivityChargeEditController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
					medicalActivityChargeEditController.setClinician(selectClinician);
					
				}else if (visitLogInputController != null) {
					
					visitLogInputController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
					visitLogInputController.setClinician(selectClinician);
					
				}else if (enterVitalSignGUIController != null) {
					
					enterVitalSignGUIController.setClinician(selectClinician);
					
					
				}
				
				new FXFormCommonUtilities().closeForm(selectButton);
			
		});
		
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Clinician", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Clinician>> task =

					new Task<ObservableList<Clinician>>() {

						@Override
						protected ObservableList<Clinician> call() throws Exception {

							ObservableList<Clinician> clinicianList = null;

							try {

								System.out.println("Generating PDF...");

								String printClinician = formPath.context.getMessage("Print.Clinician", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printClinician));
								InputStream is = this.getClass().getResourceAsStream(printClinician);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								clinicianList = new  ClinicianEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(clinicianList);
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
							return clinicianList;

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
		// Centralised Form cancel
		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		deleteFxClinician.setOnAction((event) -> {
						
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer clinicianIndex =  clinicianTable.getSelectionModel().getSelectedIndex();

				if (clinicianIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					
					if (result.get() == ButtonType.OK) {
						
						Clinician clinician = new ClinicianEntityController().view().get(clinicianIndex);
						
						new ClinicianEntityController().delete(clinician.getId());
						
						viewClinician();

						
					} else {

					}

				} else {

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
		
	}

}
