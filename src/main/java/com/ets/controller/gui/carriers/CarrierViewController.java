package com.ets.controller.gui.carriers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllInsuranceCarrierController Class
 *Description: SelectInsuranceCarrier.fxml Controller class
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

import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.patientInsuranceCarrier.PatientInsuranceCarrierInputController;
import com.ets.controller.gui.patientInsuranceCarrier.PatientInsuranceCarrierViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.provider.ProviderEditController;
import com.ets.model.BodyZone;
import com.ets.model.Carrier;
import com.ets.model.Contact;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.CheckBox;

public class CarrierViewController implements Initializable {

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
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;

    @FXML
    private TableColumn<Carrier, String> carrierNameCollumn;

    @FXML
    private TableColumn<Carrier, String> streetCollumn;

    @FXML
    private TableColumn<Carrier, String> codeCollumn;

    @FXML
    private TableColumn<Carrier, String> cityCollumn;

    @FXML
    private TableColumn<Carrier, String> stateCollumn;

    @FXML
    private TableColumn<Carrier, String> telephoneCollumn;

    @FXML
    private TableColumn<Carrier, String> faxCollumn;

    @FXML
    private TableColumn<Carrier, String> typeCollumn;
    
    @FXML
    private TableView<Carrier> carrierTable;

    @FXML
    private ChoiceBox<String> selectChoiceBox;
    
    @FXML
    private Button seletButton;

    @FXML
    private Button printButton;

    @FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {

			String formName = formPath.context.getMessage("AddCarrier", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddCarrier", null, Locale.US);
			formPath.closeApplicationContext();
			
			CarrierInputController carrierInputController =
			(CarrierInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			carrierInputController.setCarrierViewController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			
			
			Carrier carrier = carrierTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditCarrier", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditCarrier", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			formPath.closeApplicationContext();

			if (carrier != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				CarrierEditController editController = fxmlLoader.getController();
				editController.setCarrier(carrier);
				editController.setCarrierViewController(this);
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
		}}

    }

    @FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
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

			Integer carrierIndex = carrierTable.getSelectionModel().getSelectedIndex();

			if (carrierIndex > -1) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				
				if (result.get() == ButtonType.OK) {
					
					Carrier carrier = new CarrierEntityController().view().get(carrierIndex);
					
					new CarrierEntityController().delete(carrier.getId());
					
					viewCarrier();

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

    }

    @FXML
    void enterKeyPressedForSelectButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	Carrier carrier = this.carrierTable.getSelectionModel().getSelectedItem();

		if (companyInputController != null) {
			
			this.companyInputController.setCarrier(carrier.getCode());
			
		} else if (companyEditController != null) {
			
			companyEditController.setCarrier(carrier.getCode());
			
		}else if (patientInsuranceCarrierInputController != null) {
			
			patientInsuranceCarrierInputController.setCarrier(carrier.getCode());
			
		}
				
			new FXFormCommonUtilities().closeForm(seletButton);
		
    }}

    
    @FXML
    void doubleClick(MouseEvent event) {

    	if (event.getClickCount() == 2) {
			try {
				Carrier carrier = carrierTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCarrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCarrier", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				CarrierEditController editController = fxmlLoader.getController();
				editController.setCarrier(carrier);
				editController.setCarrierViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
    }
    
    private PatientInsuranceCarrierInputController patientInsuranceCarrierInputController;
    
	public void setPatientInsuranceCarrierInputController(
			PatientInsuranceCarrierInputController patientInsuranceCarrierInputController) {
		this.patientInsuranceCarrierInputController = patientInsuranceCarrierInputController;
	}

	private CompanyInputController companyInputController;
        
    public void setCompanyInputController(CompanyInputController companyInputController) {
		this.companyInputController = companyInputController;
	}
    
    private CompanyEditController companyEditController;
	
	public void setCompanyEditController(CompanyEditController companyEditController) {
		this.companyEditController = companyEditController;
	}

	private ObservableList<Carrier> carrierMasterData = FXCollections.observableArrayList();
	
	public void viewCarrier(){
		
		carrierMasterData = new CarrierEntityController().view();
		
		carrierNameCollumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		streetCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().streetProperty());
    	
    	codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    	cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
    	
    	stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
    	telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
    	faxCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());
    	typeCollumn.setCellValueFactory(cellData -> cellData.getValue().planTypeProperty());
    		
		//carrierTable.setItems(new CarrierEntityController().view());
    	
    	FilteredList<Carrier> filteredData = new FilteredList<Carrier>(carrierMasterData, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(carrier -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (carrier.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(carrier -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return carrier.getInactive();
					
				}

				return true;
			});

		});
		
	
		SortedList<Carrier> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(carrierTable.comparatorProperty());
				
		carrierTable.setItems(sortedData);
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		
		viewCarrier();
		
		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddCarrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddCarrier", null, Locale.US);
				formPath.closeApplicationContext();
				
				CarrierInputController carrierInputController =
				(CarrierInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				carrierInputController.setCarrierViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		seletButton.setOnAction((event) -> {
			   
			Carrier carrier = this.carrierTable.getSelectionModel().getSelectedItem();

			if (companyInputController != null) {
				
				this.companyInputController.setCarrier(carrier.getCode());
				
			} else if (companyEditController != null) {
				
				companyEditController.setCarrier(carrier.getCode());
				
			}else if (patientInsuranceCarrierInputController != null) {
				
				patientInsuranceCarrierInputController.setCarrier(carrier.getCode());
				
			}
					
				new FXFormCommonUtilities().closeForm(seletButton);
			

		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				// Load Region Details Edit form .

				Carrier carrier = carrierTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCarrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCarrier", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (carrier != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					CarrierEditController editController = fxmlLoader.getController();
					editController.setCarrier(carrier);
					editController.setCarrierViewController(this);
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

				Integer carrierIndex = carrierTable.getSelectionModel().getSelectedIndex();

				if (carrierIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					
					if (result.get() == ButtonType.OK) {
						
						Carrier carrier = new CarrierEntityController().view().get(carrierIndex);
						
						new CarrierEntityController().delete(carrier.getId());
						
						viewCarrier();

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

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Carrier", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Carrier>> task =

					new Task<ObservableList<Carrier>>() {

						@Override
						protected ObservableList<Carrier> call() throws Exception {

							ObservableList<Carrier> carrierList = null;

							try {

								System.out.println("Generating PDF...");

								String printCarrier= formPath.context.getMessage("Print.Carrier", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printCarrier));
								InputStream is = this.getClass().getResourceAsStream(printCarrier);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								carrierList =new CarrierEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(carrierList);
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
							return carrierList;

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
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
