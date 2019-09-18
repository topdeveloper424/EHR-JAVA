package com.ets.controller.gui.referalProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 10-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllReferalProvider Class
 *Description: SelectReferalProvider.fxml Controller class
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
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.controller.gui.appointment.PatientAppointmentEditController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.provider.ProviderEditController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Carrier;
import com.ets.model.Provider;
import com.ets.model.ReferalProvider;
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
import javafx.scene.control.Alert.AlertType;
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

public class ReferalProviderViewController implements Initializable {
	
	 @FXML
	    private TextField searchTextField;

	    @FXML
	    private CheckBox includeInactive;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button changeButton;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button closeButton;

	    @FXML
	    private Button topButton;

	    @FXML
	    private Button upButton;

	    @FXML
	    private Button downButton;

	    @FXML
	    private Button buttomButton;
	    
	    @FXML
	    private Button selectBtn;

	    @FXML
	    private TableView<ReferalProvider> referalProviderTable;

	    @FXML
	    private TableColumn<ReferalProvider, String> nameCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> specialityCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> credencialCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> codeCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> classCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> cityCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> stateCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> telephoneCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> faxCollumn;

	    @FXML
	    private TableColumn<ReferalProvider, String> typeCollumn;

	    @FXML
	    private Button printButton;
	    
	    private VisitLogInputController visitLogInputController;
	    	    
	    public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
			this.visitLogInputController = visitLogInputController;
		}

	    private PatientAppointmentInputController patientAppointmentInputController;
	    
	    public void setPatientAppointmentInputController(PatientAppointmentInputController patientAppointmentInputController) {
			this.patientAppointmentInputController = patientAppointmentInputController;
		}
        private PatientAppointmentEditController patientAppointmentEditController;
       		public void setPatientAppointmentEditController(PatientAppointmentEditController patientAppointmentEditController) {
			this.patientAppointmentEditController = patientAppointmentEditController;
		}

		@FXML
	    void enterKeyPressedForAddButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
               try {
				
				// Load Referal Provider Details Entry form .
				
				String formName = formPath.context.getMessage("AddReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddReferalProvider", null, Locale.US);
				formPath.closeApplicationContext();
				ReferalProviderInputController referalProviderInputController =
				(ReferalProviderInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				referalProviderInputController.setReferalProviderViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    	}

	    }

	    @FXML
	    void enterKeyPressedForChangeButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    	try {
				// Load Region Details Edit form .

				ReferalProvider referalProvider = referalProviderTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditReferalProvider", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (referalProvider != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ReferalProviderEditController editController = fxmlLoader.getController();
					editController.setReferalProvider(referalProvider);
					editController.setReferalProviderViewController(this);
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

				Integer referalProviderIndex = referalProviderTable.getSelectionModel().getSelectedIndex();

				if (referalProviderIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						ReferalProvider referalProvider = new ReferalProviderEntityController().view().get(referalProviderIndex);
						
						new ReferalProviderEntityController().delete(referalProvider.getId());
						
						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewReferalProvider();

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
	    void doubleClick(MouseEvent event) {
	    	
	    	if (event.getClickCount() == 2) {
				try {
					ReferalProvider referalProvider = referalProviderTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EditReferalProvider", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditReferalProvider", null, Locale.US);

					formPath.closeApplicationContext();

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ReferalProviderEditController editController = fxmlLoader.getController();
					editController.setReferalProvider(referalProvider);
					editController.setReferalProviderViewController(this);
					stage.show();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

	    }

	    private ObservableList<ReferalProvider> referalProviderMasterData = FXCollections.observableArrayList();
	    
    public void viewReferalProvider(){
    	
    	referalProviderMasterData = new ReferalProviderEntityController().view();
    	
    	nameCollumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	specialityCollumn.setCellValueFactory(cellData -> cellData.getValue().specialityProperty());
    	credencialCollumn.setCellValueFactory(cellData -> cellData.getValue().credentialProperty());
    	codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    	cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
    	classCollumn.setCellValueFactory(cellData -> cellData.getValue().classCodeProperty());
    	stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
    	telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
    	faxCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());
    	typeCollumn.setCellValueFactory(cellData -> cellData.getValue().refProviderTypeProperty());
		
    	
FilteredList<ReferalProvider> filteredData = new FilteredList<ReferalProvider>(referalProviderMasterData, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(referalProvider -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (referalProvider.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		includeInactive.setOnAction((event) -> {

			filteredData.setPredicate(referalProvider -> {
				
				if (includeInactive.isSelected()) {
					
					return referalProvider.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<ReferalProvider> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(referalProviderTable.comparatorProperty());
				
		referalProviderTable.setItems(sortedData);
		
    	//referalProviderTable.setItems(new ReferalProviderEntityController().view());
		
    }
    
   
	FXMLFormPath formPath = new FXMLFormPath();

	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		viewReferalProvider();
		
		selectBtn.setOnAction((event) -> {
			try {
				
				ReferalProvider referalProvider = referalProviderTable.getSelectionModel().getSelectedItem();
				if(visitLogInputController!=null){
				    visitLogInputController.setReferralProvider(referalProvider);
				}
				if(patientAppointmentInputController!=null){
					
					patientAppointmentInputController.setReferredByName(referalProvider);
					
				}
				if(patientAppointmentEditController!=null){
					
					patientAppointmentEditController.setRefferedById(referalProvider);
				}
				new FXFormCommonUtilities().closeForm( closeButton );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		addButton.setOnAction((event) -> {
			try {
				
				// Load Referal Provider Details Entry form .
				
				String formName = formPath.context.getMessage("AddReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddReferalProvider", null, Locale.US);
				formPath.closeApplicationContext();
				ReferalProviderInputController referalProviderInputController =
				(ReferalProviderInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				referalProviderInputController.setReferalProviderViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				// Load Region Details Edit form .

				ReferalProvider referalProvider = referalProviderTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditReferalProvider", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (referalProvider != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ReferalProviderEditController editController = fxmlLoader.getController();
					editController.setReferalProvider(referalProvider);
					editController.setReferalProviderViewController(this);
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

			// Delete Carrier Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer referalProviderIndex = referalProviderTable.getSelectionModel().getSelectedIndex();

				if (referalProviderIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						ReferalProvider referalProvider = new ReferalProviderEntityController().view().get(referalProviderIndex);
						
						new ReferalProviderEntityController().delete(referalProvider.getId());
						
						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewReferalProvider();

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

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ReferalProvider", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<ReferalProvider>> task =

					new Task<ObservableList<ReferalProvider>>() {

						@Override
						protected ObservableList<ReferalProvider> call() throws Exception {

							ObservableList<ReferalProvider> referalProviderList = null;

							try {

								System.out.println("Generating PDF...");

								String printReferalProvider = formPath.context.getMessage("Print.ReferalProvider", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printReferalProvider));
								InputStream is = this.getClass().getResourceAsStream(printReferalProvider);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								

								referalProviderList = new ReferalProviderEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(referalProviderList);
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
							return referalProviderList;

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
