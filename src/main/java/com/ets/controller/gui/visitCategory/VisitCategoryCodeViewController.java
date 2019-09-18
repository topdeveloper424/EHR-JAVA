package com.ets.controller.gui.visitCategory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectVisitCategoryCodeController Class
 *Description: SelectVisitCategoryCode.fxml Controller class
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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryEditController;
import com.ets.controller.gui.appointment.PatientAppointmentEditController;
import com.ets.controller.gui.appointment.PatientAppointmentInputController;
import com.ets.controller.gui.billingPanel.PatientAnalysisController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Laboratory;
import com.ets.model.MedicalActivity;
import com.ets.model.Provider;
import com.ets.model.ReferalProvider;
import com.ets.model.VisitCategory;
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

/**

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 23-12-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Visit category Class
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

public class VisitCategoryCodeViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private ChoiceBox visitTypeChoiceBox;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private TableView<VisitCategory> visitCategoryTable;

	@FXML
	private TableColumn<VisitCategory, String> descriptionCollumn;

	@FXML
	private TableColumn<VisitCategory, String> codeCollumn;

	@FXML
	private TableColumn<VisitCategory, String> entryTypeCollumn;

	@FXML
	private TableColumn<VisitCategory, String> visitTypeCollumn;

	@FXML
	private TableColumn<VisitCategory, String> serviceCollumn;

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button selectButton;

	@FXML
	private Button printButton;

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				VisitCategory visitCategory = visitCategoryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditVisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditVisitCategory", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				VisitCategoryCodeEditController editController = fxmlLoader.getController();
				editController.setVisitCategory(visitCategory);
				editController.setVisitCategoryCodeViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private ObservableList<VisitCategory> visitCategoryMasterData = FXCollections.observableArrayList();

	public void viewVisitCategory() {

		visitCategoryMasterData = new VisitCategoryEntityController().view();

		descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());
		entryTypeCollumn.setCellValueFactory(cellData -> cellData.getValue().entryTypeProperty());
		visitTypeCollumn.setCellValueFactory(cellData -> cellData.getValue().visitTypeProperty());
		codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		// serviceCollumn.setCellValueFactory(cellData -> cellData.getValue());

		FilteredList<VisitCategory> filteredData = new FilteredList<VisitCategory>(visitCategoryMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(visitCategory -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (visitCategory.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		/*
		 * includeInactiveCheckBox.setOnAction((event) -> {
		 * 
		 * filteredData.setPredicate(visitCategory -> {
		 * 
		 * if (includeInactiveCheckBox.isSelected()) {
		 * 
		 * return visitCategory.getInactive();
		 * 
		 * }
		 * 
		 * return true; });
		 * 
		 * });
		 */

		SortedList<VisitCategory> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(visitCategoryTable.comparatorProperty());

		visitCategoryTable.setItems(sortedData);

		// visitCategoryTable.setItems(new
		// VisitCategoryEntityController().view());

	}

	private PatientAppointmentInputController patientAppointmentInputController;

	public void setPatientAppointmentInputController(
			PatientAppointmentInputController patientAppointmentInputController) {
		this.patientAppointmentInputController = patientAppointmentInputController;
	}

	private PatientAppointmentEditController patientAppointmentEditController;

	public void setPatientAppointmentEditController(PatientAppointmentEditController patientAppointmentEditController) {
		this.patientAppointmentEditController = patientAppointmentEditController;
	}
	
	
	
	private PatientAnalysisController patientAnalysisController;
	public void setPatientAnalysisController(PatientAnalysisController patientAnalysisController) {
		this.patientAnalysisController = patientAnalysisController;
		
	}
		
	
	private PatientAnalysisController patientAnalysisController1;
	public void setPatientAnalysisController1(PatientAnalysisController patientAnalysisController1) {
		this.patientAnalysisController1 = patientAnalysisController1;
		
	}

	private VisitLogInputController visitLogInputController;

	public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
	}

	private CompanyProtocolInputController companyProtocolInputController;

	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
		this.companyProtocolInputController = companyProtocolInputController;
	}

	
	
/*private PatientAnalysisController patientAnalysisController;
	
    public void setPatientAnalysisController(PatientAnalysisController patientAnalysisController) {
	this.patientAnalysisController = patientAnalysisController;
	
	}*/
	
	
	
	
	private CompanyProtocolEditController companyProtocolEditController;

	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewVisitCategory();// initial view

		selectButton.setOnAction((event) -> {

			VisitCategory selectedVisitCategory = this.visitCategoryTable.getSelectionModel().getSelectedItem();

			if (patientAppointmentInputController != null) {//choose  visit cat from patient appointment add ctrl

				patientAppointmentInputController.setVisitCategory(selectedVisitCategory.getCode());
				patientAppointmentInputController.setPurpose(selectedVisitCategory.getDescrip());

			} else if (patientAppointmentEditController != null) {//choose  visit cat from patient appointment edit ctrl

				patientAppointmentEditController.setVisitCategory(selectedVisitCategory);
				
				
			} else if (patientAnalysisController != null) {
					System.out.println("ftrfyrftyrfy"+ selectedVisitCategory);
					patientAnalysisController.setVisitCategory(selectedVisitCategory);
					}
			
			
			
			 else if (patientAnalysisController != null) {
					System.out.println("ftrfyrftyrfy"+ selectedVisitCategory);
					patientAnalysisController.setVisitCategory(selectedVisitCategory);
					}
			
			
			
			
			
			 else if (patientAnalysisController1 != null) {
					System.out.println("ftrfyrftyrfy"+ selectedVisitCategory);
					patientAnalysisController1.setVisitCategry(selectedVisitCategory);
					}
			
			
			
			
			

			 else if (visitLogInputController != null) {//choose  visit cat from visit log  ctrl

				visitLogInputController.setVisitCategory(selectedVisitCategory);
				visitLogInputController.setPurpose(selectedVisitCategory.getDescrip());

			} else if (companyProtocolInputController != null) {//choose  visit cat from company protocol input ctrl

				companyProtocolInputController.setVisitCategoryCode(selectedVisitCategory);

			} else if (companyProtocolEditController != null) {//choose  visit cat from company protocol edit ctrl


				companyProtocolEditController.setVisitCategoryCode(selectedVisitCategory);

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

		addButton.setOnAction((event) -> {
			try {
				// Load and Display - Enter_Visit_Category_Code(New).fxml Form
				String formName = formPath.context.getMessage("AddVisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddVisitCategory", null, Locale.US);
				formPath.closeApplicationContext();
				VisitCategoryCodeInputController visitCategoryCodeInputController = (VisitCategoryCodeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visitCategoryCodeInputController.setVisitCategoryCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.VisitCategory", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<VisitCategory>> task =

					new Task<ObservableList<VisitCategory>>() {

						@Override
						protected ObservableList<VisitCategory> call() throws Exception {

							ObservableList<VisitCategory> visitCategoryList = null;

							try {

								System.out.println("Generating PDF...");

								String printMedicalActivity = formPath.context.getMessage("Print.VisitCategory", null,
										Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printMedicalActivity));
								InputStream is = this.getClass().getResourceAsStream(printMedicalActivity);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								visitCategoryList = new VisitCategoryEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(visitCategoryList);
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
							return visitCategoryList;

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

		changeButton.setOnAction((event) -> {
			try {
				// Load Region Details Edit form .

				VisitCategory visitCategory = visitCategoryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditVisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditVisitCategory", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (visitCategory != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					VisitCategoryCodeEditController editController = fxmlLoader.getController();
					editController.setVisitCategory(visitCategory);
					editController.setVisitCategoryCodeViewController(this);
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

				Integer visitCategoryIndex = visitCategoryTable.getSelectionModel().getSelectedIndex();

				if (visitCategoryIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						VisitCategory visitCategory = new VisitCategoryEntityController().view()
								.get(visitCategoryIndex);

						new VisitCategoryEntityController().delete(visitCategory.getId());

						// new
						// BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewVisitCategory();

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
