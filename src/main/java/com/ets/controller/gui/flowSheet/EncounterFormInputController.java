package com.ets.controller.gui.flowSheet;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyProtocol.CompanyProtocolEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.entity.flowsheet.FlowsheetSpecialOrderEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;

import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;

import com.ets.controller.entity.patientVisit.PatientVisitEntityController;

import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolViewController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
//import com.ets.controller.gui.userDefinedForm.String;
import com.ets.controller.gui.userDefinedForm.UserDefineFormInputController;
import com.ets.controller.gui.userDefinedForm.UserDefinedFormViewController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.controller.main.MyMain;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.FlowsheetSpecialOrder;
import com.ets.model.MedicalActivity;
import com.ets.model.PatientVisit;
import com.ets.model.UserDefinedForm;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class EncounterFormInputController implements Initializable {

	@FXML
	private Button selectAllActivitiesBtn;

	@FXML
	private Button viewThisProtocolBtn;

	@FXML
	private Button changeProtocolBtn;

	@FXML
	private Button deleteSpecialActivityBtn;

	@FXML
	private TextField searchTextField;
	@FXML
	private Button printRelatedFormBtn;
	@FXML
	private TableView<CompanyStandardProtocolActivity> standardProtocolTable;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, String> standardProtocolCodeCollumn;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, String> standardProtocolDescriptionCollumn;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, Boolean> standardProtocolCheckCollumn;

	@FXML
	private TableView<CompanyOptionalProtocolActivity> optionalProtocolTable;

	@FXML
	private TableColumn<CompanyOptionalProtocolActivity, String> optionalProtocolCodeCollumn;

	@FXML
	private TableColumn<CompanyOptionalProtocolActivity, String> optionalProtocolDescriptionCollumn;

	@FXML
	private TableView<FlowsheetSpecialOrder> flowsheetOrderTable;

	@FXML
	private TableColumn<FlowsheetSpecialOrder, String> flowsheetOrderCodeCollumn;

	@FXML
	private TableColumn<FlowsheetSpecialOrder, String> flowsheetOrderDescriptionCollumn;

	@FXML
	private TableView<MedicalActivity> medicalActivityTableByActivityCode;

	@FXML
	private TableColumn<MedicalActivity, String> activityCodeCollumnByMedicalActivity;

	@FXML
	private TableColumn<MedicalActivity, String> activityDescriptionCollumnByMedicalActivity;

	@FXML
	private TableView<MedicalActivity> activityTableByCPTCode;

	@FXML
	private TableColumn<MedicalActivity, String> activityCPYCodeCollumnByCPTCode;

	@FXML
	private TableColumn<MedicalActivity, String> activityCPTDescriptionCollumnByCPTDescription;
	@FXML
	private TableView<UserDefinedForm> relateFormTable;

	@FXML
	private TableColumn<UserDefinedForm, String> formNameCol;

	@FXML
	private TableColumn<String, String> protocolCol;

	@FXML
	private TableColumn<String, String> isSeletected;

	@FXML
	private Button deleteRelatedFormBtn;

	@FXML
	private Button changeRelatedFormBtn;

	@FXML
	private Button addRelatedFormBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button printEncounterFormBtn;

	private PatientVisit patientVisit;

	private VisitLogInputController visitLogInputController;

	public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
	}

	public void setVisitLogInputController(VisitLogInputController visitLogInputController, PatientVisit patientVisit) {
		this.visitLogInputController = visitLogInputController;
		this.patientVisit = patientVisit;
	}

	private ObservableList<MedicalActivity> medicalActivityMasterData = FXCollections.observableArrayList();

	public void setMedicalActivityCodeTableByActivityCode() {

		medicalActivityMasterData = new MedicalActivityEntityController().viewMedicalActivity();

		activityCodeCollumnByMedicalActivity.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		activityDescriptionCollumnByMedicalActivity
				.setCellValueFactory(cellData -> cellData.getValue().descripProperty());

		FilteredList<MedicalActivity> filteredData = new FilteredList<MedicalActivity>(medicalActivityMasterData,
				p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicalActivity -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicalActivity.getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				if (medicalActivity.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<MedicalActivity> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(medicalActivityTableByActivityCode.comparatorProperty());

		medicalActivityTableByActivityCode.setItems(sortedData);

	}

	public void setMedicalActivityCodeByCPTCode() {

		activityCPYCodeCollumnByCPTCode
				.setCellValueFactory(cellData -> cellData.getValue().getCptCode4Hcpcs().codeProperty());
		activityCPTDescriptionCollumnByCPTDescription
				.setCellValueFactory(cellData -> cellData.getValue().getCptCode4Hcpcs().descrpProperty());

		FilteredList<MedicalActivity> filteredData = new FilteredList<MedicalActivity>(medicalActivityMasterData,
				p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicalActivity -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicalActivity.getCptCode4Hcpcs().getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				if (medicalActivity.getCptCode4Hcpcs().getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<MedicalActivity> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(activityTableByCPTCode.comparatorProperty());
		activityTableByCPTCode.setItems(sortedData);

	}

	private ObservableList<FlowsheetSpecialOrder> flowsheetSpecialOrderMasterData = FXCollections.observableArrayList();

	public void viewFlowsheetOrder() {

		flowsheetSpecialOrderMasterData = new FlowsheetSpecialOrderEntityController()
				.viewByPatientVisitId(Global.patientVisitObj.getId());

		flowsheetOrderCodeCollumn
				.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().codeProperty());
		flowsheetOrderDescriptionCollumn
				.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().descripProperty());
		flowsheetOrderTable.setItems(flowsheetSpecialOrderMasterData);

	}

	CompanyProtocol companyProtocol = null;

	public void getCompanyProtocolId() {

		if (Global.patientVisitObj.getCompanyProtocol() != null) {

			companyProtocol = Global.patientVisitObj.getCompanyProtocol();

		} else {
			if (Global.patient.getCompany() != null && Global.patientVisitObj.getVisitCategory() != null) {
				companyProtocol = new CompanyProtocolEntityController().viewByCompanyIdAndVisitCategoryId(
						Global.patientVisitObj.getPatient().getCompany().getId(),
						Global.patientVisitObj.getVisitCategory().getId());
				// companyProtocol = (CompanyProtocol) new
				// CompanyProtocolEntityController().viewByCompanyIdAndDescription(Global.patientVisitObj.getPatient().getCompany().getId(),
				// Global.patientVisitObj.getPurpose());
				System.out.println("RUN FROM COMPANY ID " + Global.patientVisitObj.getPatient().getCompany().getId());
				System.out.println("RUN FROM VISIT CATEGORY ID	 " + Global.patientVisitObj.getVisitCategory().getId());
			} else {
				System.out.println("company not exists");
			}
		}

	}

	private ObservableList<CompanyStandardProtocolActivity> companyStandardProtocolActivityMasterData = FXCollections
			.observableArrayList();

	public void viewStandardProtocolActivity() {

		// CompanyProtocol companyProtocol = (CompanyProtocol) new
		// CompanyProtocolEntityController().viewByCompanyIdAndDescription(Global.patientVisitObj.getPatient().getCompany().getId(),
		// Global.patientVisitObj.getPurpose());
		// CompanyProtocol companyProtocol = (CompanyProtocol) new
		// CompanyProtocolEntityController().viewByCompanyIdAndDescription(56,
		// "test4455");
		// System.out.println("Company Protocol Id is ----"
		// +companyProtocol.getId());

		if (companyProtocol != null) {
			companyStandardProtocolActivityMasterData = new CompanyStandardProtocolActivityEntityController()
					.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
		}
		if (Global.patientVisitObj != null
				? Global.patientVisitObj.getVisitCategory() != null
						? companyProtocol != null ? companyProtocol.getVisitCategory() != null : false : false
				: false) {

			if (!Global.patientVisitObj.getVisitCategory().getCode()
					.equals(companyProtocol.getVisitCategory().getCode())) {

				companyStandardProtocolActivityMasterData = FXCollections.observableArrayList();
			}
		}

		// companyStandardProtocolActivityMasterData = new
		// CompanyStandardProtocolActivityEntityController().viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());

		standardProtocolCodeCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		standardProtocolDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());
		standardProtocolCheckCollumn.setCellValueFactory(cellValue -> cellValue.getValue().inactiveProperty());

		standardProtocolTable.setItems(companyStandardProtocolActivityMasterData);

	}

	private ObservableList<CompanyOptionalProtocolActivity> companyOptionalProtocolActivityMasterData = FXCollections
			.observableArrayList();

	public void viewOptionalProtocolActivity() {

		if (companyProtocol != null) {
			companyOptionalProtocolActivityMasterData = new CompanyOptionalProtocolActivityEntityController()
					.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());
		}
		if (Global.patientVisitObj != null
				? Global.patientVisitObj.getVisitCategory() != null
						? companyProtocol != null ? companyProtocol.getVisitCategory() != null : false : false
				: false) {

			if (!Global.patientVisitObj.getVisitCategory().getCode()
					.equals(companyProtocol.getVisitCategory().getCode())) {

				companyOptionalProtocolActivityMasterData = FXCollections.observableArrayList();
			}
		}
		optionalProtocolCodeCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		optionalProtocolDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());

		optionalProtocolTable.setItems(companyOptionalProtocolActivityMasterData);

	}

	@FXML
	void doubleClickOnActivityTable(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {

				MedicalActivity medicalActivity = medicalActivityTableByActivityCode.getSelectionModel()
						.getSelectedItem();
				FlowsheetSpecialOrder flowsheetSpecialOrder = new FlowsheetSpecialOrder();
				flowsheetSpecialOrder.setMedicalActivity(medicalActivity);
				flowsheetSpecialOrder.setPatientVisit(Global.patientVisitObj);
				new FlowsheetSpecialOrderEntityController().saveFlowsheetSpecialOrder(flowsheetSpecialOrder);
				viewFlowsheetOrder();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void onClickRelatedTable(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				int ind = relateFormTable.getSelectionModel().getSelectedIndex();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void doubleOnCptCodeTable(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				MedicalActivity medicalActivity = activityTableByCPTCode.getSelectionModel().getSelectedItem();
				FlowsheetSpecialOrder flowsheetSpecialOrder = new FlowsheetSpecialOrder();
				flowsheetSpecialOrder.setMedicalActivity(medicalActivity);
				new FlowsheetSpecialOrderEntityController().saveFlowsheetSpecialOrder(flowsheetSpecialOrder);
				viewFlowsheetOrder();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void doubleClickOnStdActivity(MouseEvent event) {
		if (event.getClickCount() == 1) {

		}
	}

	public static List<UserDefinedForm> userDefinedFormList = new ArrayList<UserDefinedForm>();

	public void setRelatedForm(UserDefinedForm userDefinedForm) {

		userDefinedFormList.add(userDefinedForm);
		viewRelatedForms();
	}

	public void viewRelatedForms() {

		ObservableList<UserDefinedForm> userDefinedFormObserv = FXCollections.observableArrayList();
		userDefinedFormObserv.addAll(userDefinedFormList);
		formNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormName()));
		protocolCol.setCellValueFactory(cellData -> new SimpleStringProperty("Selected"));
		isSeletected.setCellValueFactory(cellData -> new SimpleStringProperty("?"));

		relateFormTable.setItems(userDefinedFormObserv);

	}
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getCompanyProtocolId();
		// viewStandardProtocolActivity();
		viewOptionalProtocolActivity();
		viewStandardProtocolActivity();
		setMedicalActivityCodeTableByActivityCode();
		setMedicalActivityCodeByCPTCode();
		viewFlowsheetOrder();

		viewThisProtocolBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EditProtocol", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditProtocol", null, Locale.US);
				formPath.closeApplicationContext();

				CompanyProtocolEditController companyProtocolEditController = (CompanyProtocolEditController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyProtocolEditController.setEncounterFormInputController(this, companyProtocol);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeProtocolBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProtocol", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProtocol", null, Locale.US);
				formPath.closeApplicationContext();

				CompanyProtocolViewController companyProtocolViewController = (CompanyProtocolViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyProtocolViewController.setEncounterFormInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		selectAllActivitiesBtn.setOnAction((event) -> {
			try {
				for (CompanyStandardProtocolActivity companyStandardProtocolActivity : standardProtocolTable
						.getItems()) {

					companyStandardProtocolActivity.setInactive(true);
					new CompanyStandardProtocolActivityEntityController()
							.saveCompanyStandardProtocolActivity(companyStandardProtocolActivity);
					viewStandardProtocolActivity();
				}

				/*
				 * for(DrugScreenTestResult drugScreenTestresultName :
				 * drugScreenDrugNameTable.getItems()){
				 * 
				 * DrugScreenTestResult drugScreenTestResult = new
				 * DrugScreenTestResult();
				 * 
				 * //String drugTestName =
				 * drugTestNameCollumn.getCellObservableValue(drugName).getValue
				 * ();
				 * drugScreenTestresultName.setDrugTestName(drugTestNameCollumn.
				 * getCellObservableValue(drugScreenTestresultName).getValue());
				 * 
				 * String finalResult =
				 * finalCollumn.getCellObservableValue(drugScreenTestresultName)
				 * .getValue();
				 * drugScreenTestresultName.setFinalResult(finalResult);
				 * 
				 * drugScreenTestresultName.setMedicalActivityCode(
				 * MedicalActivityChargeEditController.activityCodeName);
				 * drugScreenTestresultName.setPatient(Global.patient);
				 * drugScreenTestresultName.setPatientVisit(Global.
				 * patientVisitObj);
				 * 
				 * new DrugScreenTestResultEntityController().saveOrUpdate(
				 * drugScreenTestresultName);
				 * 
				 * }
				 */

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		printEncounterFormBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.EncounterForm", null, Locale.US);
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

								String printPatientVisit = formPath.context.getMessage("Print.EncounterForm", null,
										Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printDrugTestScreen));
								InputStream is = this.getClass().getResourceAsStream(printPatientVisit);

								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								String currentPath= new File(MyMain.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
								// patientVisitList = new
								// PatientVisitEntityController().viewByPat(Global.patient.getId());
								patientVisitList = new PatientVisitEntityController().viewBypatIdAndVDate(
										Global.patientVisitObj.getPatient().getId(),
										Global.patientVisitObj.getVisitDate());
								Contact mainContact = new Contact();
								if (Global.patientVisitObj.getPatient().getCompany().getMainContact() != null) {
									mainContact = new ContactEntityController().viewByCompanyMainContact(
											Global.patientVisitObj.getPatient().getCompany().getMainContact());
								}
								JasperDesign jasperDesignSRSPA = JRXmlLoader.load(getClass().getResourceAsStream("/report/standardProtocolActivity.jrxml"));
								JasperDesign jasperDesignSOF = JRXmlLoader.load(getClass().getResourceAsStream("/report/SpecialOrderFlow.jrxml"));
								JasperDesign jasperDesignCF = JRXmlLoader.load(getClass().getResourceAsStream("/report/ContactFlow.jrxml"));
								JasperDesign jasperDesignOP = JRXmlLoader.load(getClass().getResourceAsStream("/report/optionalProtocol.jrxml"));
								JasperReport jasperReportSR = JasperCompileManager.compileReport(jasperDesignSRSPA);
								JasperReport jasperReportSOF = JasperCompileManager.compileReport(jasperDesignSOF);
								JasperReport jasperReportCF = JasperCompileManager.compileReport(jasperDesignCF);
								JasperReport jasperReportOP = JasperCompileManager.compileReport(jasperDesignOP);
								ObservableList<CompanyStandardProtocolActivity> companyStandardProtocolActivity = new CompanyStandardProtocolActivityEntityController()
										.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
								ObservableList<CompanyOptionalProtocolActivity> companyOptionalProtocolActivity = new CompanyOptionalProtocolActivityEntityController()
										.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());
								ObservableList<FlowsheetSpecialOrder> flowsheetSpecialOrderList = new FlowsheetSpecialOrderEntityController()
										.viewByPatientVisitId(Global.patientVisitObj.getId());
								ObservableList<Contact> CompanyscontactList = new ContactEntityController()
										.viewByCompId(Global.patientVisitObj.getPatient().getCompany().getId());
								System.out.println("OOOOOOOOOOOOO"+currentPath);
								//JasperReport sub = (JasperReport)JRLoader.loadObject(this.getClass().getResource("standardProtocolActivity.jasper"));
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientVisitList);
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("mainContact", mainContact);
								map.put("companyProtocol", companyProtocol);
								map.put("StandardProtocol", companyStandardProtocolActivity);
								map.put("specialOrder", flowsheetSpecialOrderList);
								map.put("contact", CompanyscontactList);
								map.put("optionalProtocol", companyOptionalProtocolActivity);
								map.put("sbReprtStandardProtocolActivity", jasperReportSR);
								map.put("subReportSpecialOrderFlow", jasperReportSOF);
								map.put("subReportContactFlow", jasperReportCF);
								map.put("subReportOptionalProtocol", jasperReportOP);
								if (Global.patientVisitObj.getCompanyProtocol() != null) {
									map.put("protocolName",
											Global.patientVisitObj.getCompanyProtocol().getDescription());
								} else {
									map.put("protocolName", null);
								}
								System.out.println("Patient Visit List is :------" + patientVisitList.size());
								// map.put("drugTestProfile",
								// MedicalActivityChargeViewController.drugTestProfile);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

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

		deleteSpecialActivityBtn.setOnAction(event -> {
			FlowsheetSpecialOrder flowsheetSpecialOrder = flowsheetOrderTable.getSelectionModel().getSelectedItem();
			new FlowsheetSpecialOrderEntityController().delete(flowsheetSpecialOrder);

			viewFlowsheetOrder();
		});
		addRelatedFormBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("UserDefinedPDFForms", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.UserDefinedPDFForms", null, Locale.US);
				formPath.closeApplicationContext();

				UserDefinedFormViewController defineFormViewController = (UserDefinedFormViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				defineFormViewController.setEncounterFormInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		changeRelatedFormBtn.setOnAction(event -> {
			try {
				UserDefinedForm userDefinedForm = relateFormTable.getSelectionModel().getSelectedItem();
				if (userDefinedForm != null) {
					int ind = relateFormTable.getSelectionModel().getSelectedIndex();
					String formName = formPath.context.getMessage("UserDefinedPDFForms", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.UserDefinedPDFForms", null, Locale.US);
					formPath.closeApplicationContext();

					UserDefinedFormViewController defineFormViewController = (UserDefinedFormViewController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					defineFormViewController.setEncounterFormInputController(this, ind);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select a record!");

					alert.showAndWait();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		deleteRelatedFormBtn.setOnAction(event -> {
			int ind = relateFormTable.getSelectionModel().getSelectedIndex();
			if (relateFormTable.getSelectionModel().getSelectedIndex() != -1) {
				userDefinedFormList.remove(ind);
				viewRelatedForms();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please select a record!");

				alert.showAndWait();
			}
		});

		printRelatedFormBtn.setOnAction(event -> {

			UserDefinedForm userDefinedForm = relateFormTable.getSelectionModel().getSelectedItem();
			if (userDefinedForm != null) {
				File file = new File(userDefinedForm.getFormPath() + "/" + userDefinedForm.getFormName());
				Stage primaryStage = (Stage) relateFormTable.getScene().getWindow();
				DirectoryChooser directoryChooser = new DirectoryChooser();
				File selectedDirectory = directoryChooser.showDialog(primaryStage);

				if (selectedDirectory == null) {

					// no directory choosen
				} else {

					Path copy_from_1 = Paths.get(file.getAbsolutePath());

					Path copy_to_1 = Paths.get(selectedDirectory.getAbsolutePath(), file.getName());
					try {
						Files.copy(copy_from_1, copy_to_1);
					} catch (FileAlreadyExistsException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText(null);
						alert.setContentText("File Already exists!");

						alert.showAndWait();

					} catch (IOException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText(null);
						alert.setContentText("import unsuccessful!");
						alert.showAndWait();

					}

				}

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please select a record!");

				alert.showAndWait();

			}
		});

		cancelBtn.setOnAction((event) -> {
			try {
				userDefinedFormList = new ArrayList<UserDefinedForm>();
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
