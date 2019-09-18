package com.ets.controller.gui.medicalActivity;

import java.io.InputStream;
/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectMedicalActivityController Class
 *Description: SelectMedicalActivity.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;
import org.jfree.date.EasterSundayRule;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.control.Alert.AlertType;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.companyProtocol.CompanyOptionalProtocolActivityEditController;
import com.ets.controller.gui.companyProtocol.CompanyOptionalProtocolActivityInputController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.companyProtocol.CompanyStandardProtocolActivityEditController;
import com.ets.controller.gui.companyProtocol.CompanyStandardProtocolActivityInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.ImmunizationInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.MMRVaccineInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.VaricellaVaccineInputController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeInputController;
import com.ets.controller.gui.medicalCondition.MedicalConditionCodeEditController;
import com.ets.controller.gui.medicalCondition.MedicalConditionCodeInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Contact;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.MedicalActivity;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.fxml.Initializable;

public class MedicalActivityViewController implements Initializable {

	@FXML
	private TableView<MedicalActivity> medicalActivityTable; // Medical Activity
																// Table View

	@FXML
	private TableColumn<MedicalActivity, String> descriptionColumn; // Medical
																	// Activity
																	// Table
																	// Column

	@FXML
	private TableColumn<MedicalActivity, String> codeColumn; // Medical Activity
																// Table Column

	@FXML
	//private TableColumn<MedicalActivity, SimpleObjectProperty<CptCode4Hcpcs>> cptCodeColumn; // Medical
																// Activity
																// Table Column
	private TableColumn<MedicalActivity, String> cptCodeColumn;
	@FXML
	private TableColumn<MedicalActivity, String> typeColumn; // Medical Activity
																// Table Column

	@FXML
	private TableColumn<MedicalActivity, String> resultColumn; // Medical
																// Activity
																// Table Column

	@FXML
	private TableColumn<MedicalActivity, String> serviceColumn; // Medical
																// Activity
																// Table Column

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button printButton;

	@FXML
	private Button selectButton;
	
	public Button button;
	
	private MMRVaccineInputController mmrVaccineInputController;


	public void setMmrVaccineInputController(MMRVaccineInputController mmrVaccineInputController) {
		
		this.mmrVaccineInputController = mmrVaccineInputController;
	
	
	}

	private MedicalConditionCodeEditController medicalConditionCodeEditController;
		
	public void setMedicalConditionCodeEditController(
			MedicalConditionCodeEditController medicalConditionCodeEditController ) {
		this.medicalConditionCodeEditController = medicalConditionCodeEditController;
		
	}
	
	public void setMedicalConditionCodeEditController(
			MedicalConditionCodeEditController medicalConditionCodeEditController , Button button) {
		this.medicalConditionCodeEditController = medicalConditionCodeEditController;
		this.button = button;
	}

	private MedicalConditionCodeInputController medicalConditionCodeInputController;
		
	public void setMedicalConditionCodeInputController(MedicalConditionCodeInputController medicalConditionCodeInputController
			) {
		this.medicalConditionCodeInputController = medicalConditionCodeInputController;
	}
	
	public void setMedicalConditionCodeInputController(MedicalConditionCodeInputController medicalConditionCodeInputController,
			Button button ) {
		this.medicalConditionCodeInputController = medicalConditionCodeInputController;
		this.button = button;
	}
	
	private MedicalActivityChargeInputController medicalActivityChargeInputController;
	
	/* public void setMedicalActivityChargeInputController(
			MedicalActivityChargeInputController medicalActivityChargeInputController) {
		this.medicalActivityChargeInputController = medicalActivityChargeInputController;
	}*/
	 
	 public void setMedicalActivityChargeInputController(
				MedicalActivityChargeInputController medicalActivityChargeInputController,Button button) {
			this.medicalActivityChargeInputController = medicalActivityChargeInputController;
			this.button = button;
		}
	 
	 private MedicalActivityChargeEditController medicalActivityChargeEditController;
	 
	public void setMedicalActivityChargeEditController(
			MedicalActivityChargeEditController medicalActivityChargeEditController) {
		this.medicalActivityChargeEditController = medicalActivityChargeEditController;
	}
	
	public void setMedicalActivityChargeEditController(
			MedicalActivityChargeEditController medicalActivityChargeEditController ,Button button) {
		this.medicalActivityChargeEditController = medicalActivityChargeEditController;
		this.button = button;
	}

	private ImmunizationInputController immunizationInputController;

	public void setImmunizationInputController(ImmunizationInputController immunizationInputController) {
		this.immunizationInputController = immunizationInputController;
	}

	private VaricellaVaccineInputController varicellaVaccineInputController;
	

	public void setVaricellaVaccineInputController(VaricellaVaccineInputController varicellaVaccineInputController) {
		this.varicellaVaccineInputController = varicellaVaccineInputController;
	}
	
	
	public CompanyProtocolInputController companyProtocolInputController;

	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController ,Button button) {
		this.companyProtocolInputController = companyProtocolInputController;
		this.button = button;
	}
	
	public CompanyProtocolEditController companyProtocolEditController;
	
	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController ,Button button) {
		this.companyProtocolEditController = companyProtocolEditController;
		this.button = button;
	}
	
	public CompanyStandardProtocolActivityInputController companyStandardProtocolActivityInputController;

	public void setCompanyStandardProtocolActivityInputController(
			CompanyStandardProtocolActivityInputController companyStandardProtocolActivityInputController) {
		this.companyStandardProtocolActivityInputController = companyStandardProtocolActivityInputController;
	}
	
	public CompanyStandardProtocolActivityEditController companyStandardProtocolActivityEditController;

	public void setCompanyStandardProtocolActivityEditController(
			CompanyStandardProtocolActivityEditController companyStandardProtocolActivityEditController) {
		this.companyStandardProtocolActivityEditController = companyStandardProtocolActivityEditController;
	} 
	
	public CompanyOptionalProtocolActivityInputController companyOptionalProtocolActivityInputController;

	public void setCompanyOptionalProtocolActivityInputController(
			CompanyOptionalProtocolActivityInputController companyOptionalProtocolActivityInputController) {
		this.companyOptionalProtocolActivityInputController = companyOptionalProtocolActivityInputController;
	}
	
	public CompanyOptionalProtocolActivityEditController companyOptionalProtocolActivityEditController;

	public void setCompanyOptionalProtocolActivityEditController(
			CompanyOptionalProtocolActivityEditController companyOptionalProtocolActivityEditController) {
		this.companyOptionalProtocolActivityEditController = companyOptionalProtocolActivityEditController;
	}
		
	

	private ObservableList<MedicalActivity> medicalActivityMasterData = FXCollections.observableArrayList();
	 
	public void viewMedicalActivity() {
		
		medicalActivityMasterData = new MedicalActivityEntityController().viewMedicalActivity();
				
		codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());

		
		cptCodeColumn.setCellValueFactory( data -> 
	    EasyBind.select(data.getValue().cptCode4HcpcsProperty())
	        .selectObject(CptCode4Hcpcs::codeProperty));
		
		typeColumn.setCellValueFactory(cellData -> cellData.getValue().activityTypeProperty());
		
		FilteredList<MedicalActivity> filteredData = new FilteredList<MedicalActivity>(medicalActivityMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicalActivity -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicalActivity.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(medicalActivity -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return medicalActivity.getInactive();
					
				}

				return true;
			});

		});

		SortedList<MedicalActivity> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(medicalActivityTable.comparatorProperty());

		medicalActivityTable.setItems(sortedData);
		
		//medicalActivityTable.setItems(new MedicalActivityEntityController().viewMedicalActivity());

	}
	
	 @FXML
	    void doubleClick(MouseEvent event) {
		 
		 if (event.getClickCount() == 2) {
				try {
					MedicalActivity medicalActivity = medicalActivityTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EditMedicalActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditMedicalActivity", null, Locale.US);

					formPath.closeApplicationContext();

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					MedicalActivityCodeEditController editController = fxmlLoader.getController();
					editController.setMedicalActivity(medicalActivity);
					editController.setMedicalActivityViewController(this);
					stage.show();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

	    }
	 
	
	FXMLFormPath formPath = new FXMLFormPath();
	
	
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		viewMedicalActivity();
				
		addButton.setOnAction((event) -> {
			try {
				// Load and Display - Enter_medical_Activity_code.fxml Form
				String formName = formPath.context.getMessage("AddMedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityCodeInputController medicalActivityCodeInputController =
				(MedicalActivityCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				medicalActivityCodeInputController.setMedicalActivityViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		changeButton.setOnAction((event) -> {
			try {
				
				MedicalActivity medicalActivity = medicalActivityTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditMedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicalActivity", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (medicalActivity != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					MedicalActivityCodeEditController editController = fxmlLoader.getController();
					editController.setMedicalActivity(medicalActivity);
					editController.setMedicalActivityViewController(this);
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
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.MedicalActivity", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<MedicalActivity>> task =

					new Task<ObservableList<MedicalActivity>>() {

						@Override
						protected ObservableList<MedicalActivity> call() throws Exception {

							ObservableList<MedicalActivity> medicalActivityList = null;

							try {

								System.out.println("Generating PDF...");

								String printMedicalActivity= formPath.context.getMessage("Print.MedicalActivity", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printMedicalActivity));
								InputStream is = this.getClass().getResourceAsStream(printMedicalActivity);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								medicalActivityList =new MedicalActivityEntityController().viewMedicalActivity();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalActivityList);
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
							return medicalActivityList;

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


		deleteButton.setOnAction((event) -> {

			// Delete MedcalActivity Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer medicalActivityIndex = medicalActivityTable.getSelectionModel().getSelectedIndex();

				if (medicalActivityIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						MedicalActivity medicalActivity = new MedicalActivityEntityController().viewMedicalActivity().get(medicalActivityIndex);	
						new MedicalActivityEntityController().removeMedicalActivity(medicalActivity.getId());
						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewMedicalActivity();

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

		
		selectButton.setOnAction((event) -> {
			
			//System.out.println("%%%%%%%%%%%%%%%"+button.getId());
			
			
			MedicalActivity selectedMedicalActivity = this.medicalActivityTable.getSelectionModel().getSelectedItem();
				
			if(mmrVaccineInputController != null){
				mmrVaccineInputController.setMedication(medicalActivityTable.getSelectionModel().getSelectedItem().getDescrip());
				
			}
			if(varicellaVaccineInputController != null){
				
				varicellaVaccineInputController.setMedication(medicalActivityTable.getSelectionModel().getSelectedItem().getDescrip());
					
				
			}
			if(immunizationInputController !=null){
				
				immunizationInputController.setMedication(medicalActivityTable.getSelectionModel().getSelectedItem().getDescrip());
				
			}
			
			if(medicalConditionCodeEditController != null){
				
			if(button.getId().equals("vaccineButton") ){
				if(medicalConditionCodeInputController != null){
					
					this.medicalConditionCodeInputController.setVaccine(selectedMedicalActivity.getCode());
					
				}else if (medicalConditionCodeEditController != null) {
					
					this.medicalConditionCodeEditController.setVaccine(selectedMedicalActivity.getCode());
					
				}
				//this.medicalConditionCodeInputController.setVaccine(selectedMedicalActivity.getCode());
				//this.medicalConditionCodeEditController.setVaccine(selectedMedicalActivity.getCode());
				
			}else if(button.getId().equals("vaccine2Button")){
				if(medicalConditionCodeInputController != null){
					
					this.medicalConditionCodeInputController.setSecondVaccine(selectedMedicalActivity.getCode());
					
				}else if (medicalConditionCodeEditController != null) {
					
					this.medicalConditionCodeEditController.setSecondVaccine(selectedMedicalActivity.getCode());
				}			
				
			}
			else if(button.getId().equals("immuneTestButton")){
				
				if(medicalConditionCodeInputController != null){
					
					this.medicalConditionCodeInputController.setImmuneTest(selectedMedicalActivity.getCode());
					
				}else if (medicalConditionCodeEditController != null) {
					
					this.medicalConditionCodeEditController.setImmuneTest(selectedMedicalActivity.getCode());
					
				}
								
			}
			else if(button.getId().equals("diagTestButton")){
				
				if(medicalConditionCodeInputController != null){
					
					this.medicalConditionCodeInputController.setDiagTest(selectedMedicalActivity.getCode());
					
				}else if (medicalConditionCodeEditController != null) {
					
					this.medicalConditionCodeEditController.setDiagTest(selectedMedicalActivity.getCode());
					
				}
							
			}
			}else if(medicalActivityChargeInputController != null){
				
				if (button.getId().equals("medicalActivityButton")) {
					if(medicalActivityChargeInputController!=null){
						
						medicalActivityChargeInputController.setActivityCode(selectedMedicalActivity);
					}
									
				}
				
			}else if(medicalActivityChargeEditController != null){
				
				if (button.getId().equals("medicalActivityButton")) {
					
					medicalActivityChargeEditController.setActivityCode(selectedMedicalActivity);
					
					
					//System.out.println("RUN ########################" +selectedMedicalActivity.getCptCode4Hcpcs().getCode());
					/*String cptCode = selectedMedicalActivity.getCptCode4Hcpcs().getCode();
					if(cptCode != null){
						medicalActivityChargeInputController.setCPTCode(cptCode);
					}*/
					
				}
			}
			
			else if(companyProtocolInputController != null){
				
				if(button.getId().equals("standardAddBtn")){
					
					//companyProtocolInputController.setMedicalStandardCode(selectedMedicalActivity);
					
					String formName = formPath.context.getMessage("AddCompanyStandardProtocolActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddCompanyStandardProtocolActivity", null, Locale.US);
					formPath.closeApplicationContext();
					CompanyStandardProtocolActivityInputController companyStandardProtocolActivityInputController =
					(CompanyStandardProtocolActivityInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					companyStandardProtocolActivityInputController.setMedicalActivityViewController(this);
					companyStandardProtocolActivityInputController.setMedicalActivityObject(selectedMedicalActivity);
					
					
				}else if (button.getId().equals("optionalAddBtn")) {	
					
					//companyProtocolInputController.setMedicalOptionalCode(selectedMedicalActivity);
					
					String formName = formPath.context.getMessage("AddCompanyOptionalProtocolActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddCompanyOptionalProtocolActivity", null, Locale.US);
					formPath.closeApplicationContext();
					CompanyOptionalProtocolActivityInputController optionalProtocolActivityInputController =
					(CompanyOptionalProtocolActivityInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					optionalProtocolActivityInputController.setMedicalActivityViewController(this);
					optionalProtocolActivityInputController.setMedicalActivityObject(selectedMedicalActivity);
					
				}
				
			}else if(companyProtocolEditController != null){
				
				if(button.getId().equals("standardAddBtn")){
					System.out.println("****************  semi 1");
					//companyProtocolInputController.setMedicalStandardCode(selectedMedicalActivity);
					
					String formName = formPath.context.getMessage("AddCompanyStandardProtocolActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddCompanyStandardProtocolActivity", null, Locale.US);
					formPath.closeApplicationContext();
					CompanyStandardProtocolActivityInputController companyStandardProtocolActivityInputController =
					(CompanyStandardProtocolActivityInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					companyStandardProtocolActivityInputController.setMedicalActivityViewController(this);
					companyStandardProtocolActivityInputController.setMedicalActivityObject(selectedMedicalActivity);
					
					
				}else if (button.getId().equals("optionalAddBtn")) {	
					
					//companyProtocolInputController.setMedicalOptionalCode(selectedMedicalActivity);
					
					String formName = formPath.context.getMessage("AddCompanyOptionalProtocolActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddCompanyOptionalProtocolActivity", null, Locale.US);
					formPath.closeApplicationContext();
					CompanyOptionalProtocolActivityInputController optionalProtocolActivityInputController =
					(CompanyOptionalProtocolActivityInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					optionalProtocolActivityInputController.setMedicalActivityViewController(this);
					optionalProtocolActivityInputController.setMedicalActivityObject(selectedMedicalActivity);
					
				}
				
			}
			else if(companyStandardProtocolActivityEditController != null){
				
				companyStandardProtocolActivityEditController.setMedicalActivityObject(selectedMedicalActivity);
				
			}
			else if(companyOptionalProtocolActivityEditController != null){
				
				companyOptionalProtocolActivityEditController.setMedicalActivityObject(selectedMedicalActivity);
				
			}
				
				new FXFormCommonUtilities().closeForm(selectButton);
			 
		});
		
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