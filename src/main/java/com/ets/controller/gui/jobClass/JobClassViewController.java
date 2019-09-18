package com.ets.controller.gui.jobClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 15-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllJobClassGUIController Class
 *Description: ViewAllJobClassCode.fxml Controller class
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
import com.ets.controller.entity.jobClass.JobClassEntityController;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.departmentUnit.DepartmentUnitEditController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Carrier;
import com.ets.model.Clinician;
import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;
import com.ets.model.Laboratory;
import com.ets.model.MedicalCondition;
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

public class JobClassViewController implements Initializable {

	@FXML
    private TextField searchTextField;

    @FXML
    private CheckBox inactiveCheckBox;

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
    private Button selectButton;

    @FXML
    private TableView<JobClass> jobClassTable;

    @FXML
    private TableColumn<JobClass, String> descriptionCollumn;

    @FXML
    private TableColumn<JobClass, String> jobClassCollumn;

    @FXML
    private Button printButton;

    @FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		try {
				// Load job Class Details Entry form .

				String formName = formPath.context.getMessage("AddJobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddJobClass", null, Locale.US);
				formPath.closeApplicationContext();
				JobClassInputController jobClassInputController = 
				 (JobClassInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				jobClassInputController.setJobClassViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
    	}
    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    		try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditJobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditJobClass", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				JobClass jobClass = jobClassTable.getSelectionModel().getSelectedItem();

				if (jobClass != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					JobClassEditController editController = fxmlLoader.getController();
					editController.setJobClass(jobClass);
					editController.setJobClassViewController(this);
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

				Integer jobClassIndex = jobClassTable.getSelectionModel().getSelectedIndex();

				if (jobClassIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						JobClass jobClass = new JobClassEntityController().view().get(jobClassIndex);

						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewJobClass();

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
        	
    	}
    }
    
    @FXML
	void doubleClicked(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Job Class Details Edit form .

				String formName = formPath.context.getMessage("EditJobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditJobClass", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				JobClass jobClass = jobClassTable.getSelectionModel().getSelectedItem();

				if (jobClass != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					JobClassEditController editController = fxmlLoader.getController();
					editController.setJobClass(jobClass);
					editController.setJobClassViewController(this);
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();

				}

			} 
			catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

    private ObservableList<JobClass> jobClassMasterData = FXCollections.observableArrayList();
    
	public void viewJobClass(){
		
		jobClassMasterData = new JobClassEntityController().view();
		
		jobClassCollumn.setCellValueFactory(cellData -> cellData.getValue().classOfJobProperty());
		descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descrpProperty());
		
		FilteredList<JobClass> filteredData = new FilteredList<JobClass>(jobClassMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(jobClass -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (jobClass.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(jobClass -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return jobClass.getInactive();
					
				}

				return true;
			});

		});

		SortedList<JobClass> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(jobClassTable.comparatorProperty());

		jobClassTable.setItems(sortedData);
		
		//jobClassTable.setItems(new JobClassEntityController().view());
	}
	
	
	FXMLFormPath formPath = new FXMLFormPath();
	
	private CompanyProtocolInputController companyProtocolInputController;

	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
		this.companyProtocolInputController = companyProtocolInputController;
	}
	
	private CompanyProtocolEditController companyProtocolEditController;
	
	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		viewJobClass();
				
		selectButton.setOnAction((event) -> {
			
			JobClass jobClass = jobClassTable.getSelectionModel().getSelectedItem();
			if(companyProtocolInputController != null){
				
				companyProtocolInputController.setjobClass(jobClass.getClassOfJob());
				
			}else if(companyProtocolEditController != null){
				
				companyProtocolEditController.setjobClass(jobClass);
			}
			
			
			new FXFormCommonUtilities().closeForm(selectButton);
		
	});
		
		
		
		addButton.setOnAction((event) -> {
			try {
				// Load job Class Details Entry form .

				String formName = formPath.context.getMessage("AddJobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddJobClass", null, Locale.US);
				formPath.closeApplicationContext();
				JobClassInputController jobClassInputController = 
				 (JobClassInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				jobClassInputController.setJobClassViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditJobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditJobClass", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				JobClass jobClass = jobClassTable.getSelectionModel().getSelectedItem();

				if (jobClass != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					JobClassEditController editController = fxmlLoader.getController();
					editController.setJobClass(jobClass);
					editController.setJobClassViewController(this);
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

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.JobClass", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<JobClass>> task =

					new Task<ObservableList<JobClass>>() {

						@Override
						protected ObservableList<JobClass> call() throws Exception {

							ObservableList<JobClass> jobClassList = null;

							try {

							

								String printJobClass = formPath.context.getMessage("Print.JobClass", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printJobClass));
								InputStream is = this.getClass().getResourceAsStream(printJobClass);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								jobClassList =new JobClassEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(jobClassList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return jobClassList;

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

			// Delete Carrier Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer jobClassIndex = jobClassTable.getSelectionModel().getSelectedIndex();

				if (jobClassIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						JobClass jobClass = new JobClassEntityController().view().get(jobClassIndex);
						new JobClassEntityController().delete(jobClass.getId());

						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewJobClass();

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
