package com.ets.controller.gui.provider;

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
import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.gui.appointment.PatientAppointmentEditController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.genericVisitProtocal.EnterVitalSignGUIController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.region.RegionEditController;
import com.ets.controller.gui.staffSchedule.StaffScheduleViewController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Carrier;
import com.ets.model.Clinic;
import com.ets.model.Division;
import com.ets.model.Pharmacy;
import com.ets.model.Provider;
import com.ets.model.Region;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ProviderViewController implements Initializable {
	
	@FXML
    private TextField searchTextField;

    @FXML
    private CheckBox includeInactiveCheckBox;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;
    
    @FXML
    private Button selectButton;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button buttomButton;

    @FXML
    private TableView<Provider> providerTable;

    @FXML
    private TableColumn<Provider, String> providerNameCollumn;

    @FXML
    private TableColumn<Provider, String> specialityCollumn;

    @FXML
    private TableColumn<Provider, String> credencialCollumn;

    @FXML
    private TableColumn<Provider, String> codeCollumn;

    @FXML
    private TableColumn<Provider, String> cityCollumn;

    @FXML
    private TableColumn<Provider, String> stateCollumn;

    @FXML
    private TableColumn<Provider, String> telephoneCollumn;

    @FXML
    private TableColumn<Provider, String> faxCollumn;

    @FXML
    
    private TableColumn<Provider, String> typeCollumn;

    @FXML
    private Button printButton;
    
    
    private EnterVitalSignGUIController enterVitalSignGUIController;
    
     
	public void setEnterVitalSignGUIController(EnterVitalSignGUIController enterVitalSignGUIController,Button button) {
		this.enterVitalSignGUIController = enterVitalSignGUIController;
		this.button = button;
	}


	@FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Provider Details Entry form .
			try{
			String formName = formPath.context.getMessage("AddViewProvider", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddViewProvider", null, Locale.US);
			formPath.closeApplicationContext();
			ProviderInputController providerInputController =
			(ProviderInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
			
			providerInputController.setProviderViewController(this);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    	
    }}
    

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			// Load Region Details Edit form .

			Provider provider = providerTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditProvider", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditProvider", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			formPath.closeApplicationContext();

			if (provider != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ProviderEditController editController = fxmlLoader.getController();
				editController.setProvider(provider);
				editController.setProviderViewController(this);
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

    }
    }
    @FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		try {
				new FXFormCommonUtilities().closeForm( closeButton );
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

			Integer providerIndex = providerTable.getSelectionModel().getSelectedIndex();

			if (providerIndex > -1) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					
					Provider provider = new ProviderEntityController().view().get(providerIndex);
					
					new ProviderEntityController().delete(provider.getId());
					
					viewProvider();

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
    	}
    }

    @FXML
    void enterKeyPressedForPrintButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){

    		
    		
    		
    }}

    @FXML
    void enterKeyPressedForSelectButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	Provider selectedProvider = this.providerTable.getSelectionModel().getSelectedItem();
		
		if(staffScheduleViewController != null){
			
			//this.staffScheduleViewController.setdDeptUnitTextBox(selectedDivision.getCode());
			staffScheduleViewController.setProviderName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName() +" "+selectedProvider.getMiddleName() +" "+selectedProvider.getLastName());
			staffScheduleViewController.setType(selectedProvider.getProviderType());
			staffScheduleViewController.setProvider(selectedProvider);
			
		}else if(button.getId().equals("providerButton")){
			
			enterVitalSignGUIController.setProvider(selectedProvider);
			
		}
		
		else if(button.getId().equals("PrefferedProiderButton")){
			if(patientInputController != null){
				
				
				this.patientInputController.setPreferedProvider(selectedProvider);
			
				
			}else if (patientEditController != null) {
				
				this.patientEditController.setPreferedProvider(selectedProvider);
			}			
			
		}else if(button.getId().equals("PrimaryCareButton")){
			if(patientInputController != null){
									
				this.patientInputController.setPrimaryPhysicians(selectedProvider);
				
				
			}
			
			else if (patientEditController != null) {
				
				this.patientEditController.setPrimaryPhysicians(selectedProvider);
			}			
			
		}else if (button.getId().equals("providerButton")) {
			
			if(patientAppointmentInputController != null){
				
				this.patientAppointmentInputController.setProviderName(selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
				this.patientAppointmentInputController.setProviderCode(selectedProvider.getCode());
				
			}
			
          
			
		}/*else if (button.getId().equals("refferedByButton")) {
			
			if(patientAppointmentInputController != null){
				
				this.patientAppointmentInputController.setReferredByName(selectedProvider.getCode());
				//this.patientAppointmentInputController.setReferredByName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
				this.patientAppointmentInputController.setRefferedByCode(selectedProvider.getCode());
				
			}
			
		}						
		*/	new FXFormCommonUtilities().closeForm(selectButton);
		

    	}

     
    }
    
    @FXML
    void doubleClick(MouseEvent event) {
    	
    	if (event.getClickCount() == 2) {
			try {
				Provider provider = providerTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditProvider", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ProviderEditController editController = fxmlLoader.getController();
				editController.setProvider(provider);
				editController.setProviderViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

    }
    
    private ObservableList<Provider> providerMasterData = FXCollections.observableArrayList();
    
    public void viewProvider(){
    	
    	providerMasterData = new ProviderEntityController().view();
    	
    	providerNameCollumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	specialityCollumn.setCellValueFactory(cellData -> cellData.getValue().specialityProperty());
    	credencialCollumn.setCellValueFactory(cellData -> cellData.getValue().credentialProperty());
    	codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    	cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
    	stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
    	telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
    	faxCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());
    	typeCollumn.setCellValueFactory(cellData -> cellData.getValue().providerTypeProperty());
		//providerTable.setItems(new ProviderEntityController().view());
		
		
		FilteredList<Provider> filteredData = new FilteredList<Provider>(providerMasterData, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(provider -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (provider.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(provider -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return provider.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Provider> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(providerTable.comparatorProperty());
				
		providerTable.setItems(sortedData);
		    	
    }
    
    private Button button;
    
    private PatientInputController patientInputController;
    
    
    public void setPatientInputController(PatientInputController patientInputController) {
		this.patientInputController = patientInputController;
	}
    
    public void setPatientInputController(PatientInputController patientInputController , Button button) {
		this.patientInputController = patientInputController;
		this.button = button;
	}
    
    private PatientEditController patientEditController;
	
	public void setPatientEditController(PatientEditController patientEditController) {
		this.patientEditController = patientEditController;
	}
	
	public void setPatientEditController(PatientEditController patientEditController, Button button) {
		this.patientEditController = patientEditController;
		this.button = button;
	}
    
    
    
    
    private PatientAppointmentInputController patientAppointmentInputController;
    
	public void setPatientAppointmentInputController(PatientAppointmentInputController patientAppointmentInputController) {
		this.patientAppointmentInputController = patientAppointmentInputController;
	}
	
	public void setPatientAppointmentInputController(PatientAppointmentInputController patientAppointmentInputController, Button button) {
		this.patientAppointmentInputController = patientAppointmentInputController;
		this.button = button;
	}
	
	private PatientAppointmentEditController patientAppointmentEditController;
	
	public void setPatientAppointmentEditController(PatientAppointmentEditController patientAppointmentEditController) {
		this.patientAppointmentEditController = patientAppointmentEditController;
	}
	
	public void setPatientAppointmentEditController(PatientAppointmentEditController patientAppointmentEditController, Button button) {
		this.patientAppointmentEditController = patientAppointmentEditController;
		this.button = button;
	}
	
	 private VisitLogInputController visitLogInputController;
	    
		public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
			this.visitLogInputController = visitLogInputController;
		}
		
		public void setVisitLogInputController(VisitLogInputController visitLogInputController, Button button) {
			this.visitLogInputController = visitLogInputController;
			this.button = button;
		}

	private StaffScheduleViewController staffScheduleViewController;
        
    public void setStaffScheduleViewController(StaffScheduleViewController staffScheduleViewController) {
		this.staffScheduleViewController = staffScheduleViewController;
	}
    
  public static Provider selectedProvider;

	FXMLFormPath formPath = new FXMLFormPath();
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		viewProvider();
		
		selectButton.setOnAction((event) -> {
			
			 selectedProvider = this.providerTable.getSelectionModel().getSelectedItem();
			
			if(staffScheduleViewController != null){
				
				//this.staffScheduleViewController.setdDeptUnitTextBox(selectedDivision.getCode());
				staffScheduleViewController.setProviderName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName() +" "+selectedProvider.getMiddleName() +" "+selectedProvider.getLastName());
				staffScheduleViewController.setType(selectedProvider.getProviderType());
				staffScheduleViewController.setProvider(selectedProvider);
				
			}
	        else if(enterVitalSignGUIController != null){
				
				enterVitalSignGUIController.setProvider(selectedProvider);
			
				
			}	
			
			else if(button.getId().equals("PrefferedProiderButton")){
				if(patientInputController != null){
					
					
					this.patientInputController.setPreferedProvider(selectedProvider);
					
					
				}else if (patientEditController != null) {
					
					this.patientEditController.setPreferedProvider(selectedProvider);
				}			
				
			}else if(button.getId().equals("PrimaryCareButton")){
				if(patientInputController != null){
										
					this.patientInputController.setPrimaryPhysicians(selectedProvider);
					
					
				}else if (patientEditController != null) {
					
					this.patientEditController.setPrimaryPhysicians(selectedProvider);
				}			
				
			}else if (button.getId().equals("providerButton")) {
				
				if(patientAppointmentInputController != null){
					
					this.patientAppointmentInputController.setProviderName(selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
					
					this.patientAppointmentInputController.setProviderCode(selectedProvider.getCode());
					
				}else if (patientAppointmentEditController != null) {
					this.patientAppointmentEditController.setProviderCode(selectedProvider);
				}
				
			}/*else if (button.getId().equals("refferedByButton")) {
				
				if(patientAppointmentInputController != null){
					
					this.patientAppointmentInputController.setReferredByName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
					this.patientAppointmentInputController.setRefferedByCode(selectedProvider.getCode());
					
				}else if (patientAppointmentEditController != null) {
					
					
					this.patientAppointmentEditController.setRefferedById(selectedProvider);
					
				}
				}
			*/else if (button.getId().equals("providerBtn")) {
				
				if(visitLogInputController != null){
					
					visitLogInputController.setProviderName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
					visitLogInputController.setProvider(selectedProvider);
					
				}else{
					
				}
				
			}else if (button.getId().equals("billingPhysiciansBtn")) {
				
				if(visitLogInputController != null){
					
					//visitLogInputController.setProviderName(selectedProvider.getSuffix()+" "+selectedProvider.getFirstName()+" "+selectedProvider.getMiddleName()+" "+selectedProvider.getLastName());
					visitLogInputController.setBillingPhysicians(selectedProvider);
					
				}
				
				
				else{
					
				}
				
			}				
				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
		
		addButton.setOnAction((event) -> {
			try {
				// Load Provider Details Entry form .
				
				String formName = formPath.context.getMessage("AddViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				ProviderInputController providerInputController =
				(ProviderInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				
				providerInputController.setProviderViewController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				// Load Region Details Edit form .

				Provider provider = providerTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditProvider", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (provider != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ProviderEditController editController = fxmlLoader.getController();
					editController.setProvider(provider);
					editController.setProviderViewController(this);
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
		
		deleteButton.setOnAction((event) -> {

			

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer providerIndex = providerTable.getSelectionModel().getSelectedIndex();

				if (providerIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						Provider provider = new ProviderEntityController().view().get(providerIndex);
						
						new ProviderEntityController().delete(provider.getId());
						
						viewProvider();

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
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Provider", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Provider>> task =

					new Task<ObservableList<Provider>>() {

						@Override
						protected ObservableList<Provider> call() throws Exception {

							ObservableList<Provider> providerList = null;

							try {

								System.out.println("Generating PDF...");

								String printProvider = formPath.context.getMessage("Print.Provider", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printProvider));
								InputStream is = this.getClass().getResourceAsStream(printProvider);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								providerList = new ProviderEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(providerList);
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
							return providerList;

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
				closeButton.setOnAction((event) -> {
								try {
									new FXFormCommonUtilities().closeForm( closeButton );
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							});
					}
}
