package com.ets.controller.gui.company;

/*
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 21-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllCompanyController Class
 *Description: ViewAllCompany.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification: Neha Sahadev
 *Owner:
 *Date:
 *Version:
 *Description: Select Button Functionality Added
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.billingPanel.PatientAnalysisController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.drugScreenTestResultReport.EmployerReportGUIController;
import com.ets.controller.gui.icd10Diagonosis.ICD10DiagonosisInputController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.patientVisitByDate.PatientVisitByDateViewController;
import com.ets.controller.gui.representRelation.PatientRepRelationViewController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.BodyZone;
import com.ets.model.Carrier;
import com.ets.model.Clinic;
import com.ets.model.Company;
import com.ets.model.Complex;
import com.ets.model.IllnessCode;
import com.ets.model.Patient;
import com.ets.model.PatientVisit;
import com.ets.model.Pharmacy;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CompanyViewController implements Initializable {
	@FXML
	private Button addBtn;

	@FXML
	private Button closeBtn;

	@FXML
	private Button changeButton;

	@FXML
	private Button printBtn;

	@FXML
	private Button deleteButton;

	@FXML
	private Button privatePracticeButton;

	@FXML
	private TableView<Company> companyTableView;

	@FXML
	private TableColumn<Company, String> companyNameCollumn;

	@FXML
	private TableColumn<Company, String> codeCollumn;

	@FXML
	private TableColumn<Company, String> cityCol;

	@FXML
	private TableColumn<Company, String> stateCol;

	@FXML
	private TableColumn<Company, String> telephoneCol;

	@FXML
	private TableColumn<Company, String> faxCol;

	@FXML
	private TableColumn<Company, String> aliasCollumn;

	@FXML
	private TextField searchText;

	@FXML
	private Button SelectButtonCompany;

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				Company company = companyTableView.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCompany", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCompany", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				CompanyEditController editController = fxmlLoader.getController();
				editController.setCompany(company);
				editController.setCompanyViewController(this);
				stage.show();
			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	private VisitLogInputController visitLogInputController;

	public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
	}

	private ObservableList<Company> companyMasterData = FXCollections.observableArrayList();

	public void refreshCompany() {

		/*
		 * idCol.setCellValueFactory(new PropertyValueFactory<Company, String>("id"));
		 * addressCol.setCellValueFactory(new PropertyValueFactory<Company,
		 * String>("address")); aliasNameCol.setCellValueFactory(new
		 * PropertyValueFactory<Company, String>("aliasName"));
		 * cityCol.setCellValueFactory(new PropertyValueFactory<Company,
		 * String>("city")); countryCol.setCellValueFactory(new
		 * PropertyValueFactory<Company, String>("country"));
		 * countyCol.setCellValueFactory(new PropertyValueFactory<Company,
		 * String>("county")); emailCol.setCellValueFactory(new
		 * PropertyValueFactory<Company, String>("email"));
		 * faxCol.setCellValueFactory(new PropertyValueFactory<Company, String>("fax"));
		 * nameCol.setCellValueFactory(new PropertyValueFactory<Company,
		 * String>("name")); stateCol.setCellValueFactory(new
		 * PropertyValueFactory<Company, String>("state"));
		 * telephoneCol.setCellValueFactory(new PropertyValueFactory<Company,
		 * String>("telephone"));
		 * 
		 * zipCol.setCellValueFactory(new PropertyValueFactory<Company, String>("zip"));
		 */

		companyMasterData = new CompanyEntityController().getCompanyList();

		companyNameCollumn.setCellValueFactory(new PropertyValueFactory<Company, String>("name"));
		codeCollumn.setCellValueFactory(new PropertyValueFactory<Company, String>("code"));

		cityCol.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());

		stateCol.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
		telephoneCol.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
		faxCol.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());
		aliasCollumn.setCellValueFactory(cellData -> cellData.getValue().aliasNameProperty());

		FilteredList<Company> filteredData = new FilteredList<Company>(companyMasterData, p -> true);
		searchText.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(company -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (company.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<Company> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(companyTableView.comparatorProperty());

		companyTableView.setItems(sortedData);

	}

	public void populateCompanyTable(ObservableList<Company> companyList) {

		FilteredList<Company> filteredData = new FilteredList<Company>(companyList, p -> true);
		searchText.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(company -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (company.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<Company> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(companyTableView.comparatorProperty());

		companyTableView.setItems(sortedData);

		// companyTableView.setItems(companyList);
	}

	public void setCompany(Company company) {

		Global.company = company;
	}

	private PatientInputController patientInputController;

	public void setPatientInputController(PatientInputController patientInputController) {
		this.patientInputController = patientInputController;
	}

	private PatientEditController patientEditController;

	public void setPatientEditController(PatientEditController patientEditController) {
		this.patientEditController = patientEditController;
	}

	private PatientAnalysisController patientAnalysisController;

	public void setPatientAnalysisController(PatientAnalysisController patientAnalysisController) {
		this.patientAnalysisController = patientAnalysisController;

	}

	FXMLFormPath formPath = new FXMLFormPath();

	// FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshCompany();

		addBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddCompany", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				CompanyInputController companyInputController = (CompanyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyInputController.setCompanyViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Complex Details Edit form .

				Company company = companyTableView.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCompany", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCompany", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (company != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					CompanyEditController editController = fxmlLoader.getController();
					editController.setCompany(company);
					editController.setCompanyViewController(this);
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

				Company company = companyTableView.getSelectionModel().getSelectedItem();

				if (company != null) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						// Company company = new
						// CompanyEntityController().getCompanyList().get(companyIndex);

						new CompanyEntityController().removeCompany(company.getId());

						// new
						// BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						refreshCompany();

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

		/*
		 * printBtn.setOnAction((event) -> { try {
		 * 
		 * System.out.println("Generating PDF...");
		 * 
		 * String str = "target/classes/report/CompanyReport.jrxml";
		 * 
		 * InputStream is = new FileInputStream(new File(str));
		 * 
		 * JasperReport jasperReport = JasperCompileManager.compileReport(is);
		 * 
		 * List<Company> companyList = new CompanyEntityController().getCompanyList();
		 * JRDataSource JRdataSource = new JRBeanCollectionDataSource(companyList);
		 * Map<String, Object> map = new HashMap<String, Object>(); JasperPrint
		 * jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
		 * 
		 * JasperViewer.viewReport(jasperPrint, false);
		 * 
		 * System.out.println("Compant Details pdf has been generated!");
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); }
		 * 
		 * });
		 * 
		 */
		SelectButtonCompany.setOnAction((event) -> {
			try {
				Company selectCompany = this.companyTableView.getSelectionModel().getSelectedItem();

				if (patientInputController != null) {

					// this.userAddController.setdClinicRestrictTextField(selectedClinic.getName());
					this.patientInputController.setCompany(selectCompany);

				}
				if (patientEditController != null) {

					// this.userAddController.setdClinicRestrictTextField(selectedClinic.getName());
					this.patientEditController.setCompany(selectCompany);

				}

				if (patientAnalysisController != null) {
					System.out.println("ftrfyrftyrfy" + selectCompany);
					this.patientAnalysisController.setCompany(selectCompany);
				}

				if (visitLogInputController != null) {
					visitLogInputController.getCompany(selectCompany);
					System.out.println("visit log controller in company+++++++++++");

				}
				setCompany(selectCompany);

				new FXFormCommonUtilities().closeForm(SelectButtonCompany);
			} catch (Exception ex) {
				ex.printStackTrace();
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

		/*privatePracticeButton.setOnAction((event) -> {
			String formName = formPath.context.getMessage("ViewMedicalActivityCharge", null, Locale.US);
			String formTitle1 = formPath.context.getMessage("Title.ViewMedicalActivityCharge", null, Locale.US);
			// String formTitle2 = Global.patient.getPatientName().getFirstName();
			String formTitle = formTitle1;
			MedicalActivityChargeViewController medicalActivityChargeViewController = (MedicalActivityChargeViewController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			medicalActivityChargeViewController.setCompanyViewController(this);
			formPath.closeApplicationContext();
		});*/

	}

}
