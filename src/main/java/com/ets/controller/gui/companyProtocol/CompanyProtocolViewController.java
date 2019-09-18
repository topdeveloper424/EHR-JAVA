package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.format.datetime.joda.LocalDateParser;

import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyProtocol.CompanyProtocolEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.contact.ContactInputController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.Company;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CompanyProtocolViewController implements Initializable {

	@FXML
	private TextField searchText;

	@FXML
	private TableView<CompanyProtocol> companyProtocolTable;

	@FXML
	private TableColumn<CompanyProtocol, String> descriptionCollumn;

	@FXML
	private TableColumn<CompanyProtocol, String> visitCategoryCollumn;

	@FXML
	private TableColumn<CompanyProtocol, String> jobClassCollumn;

	@FXML
	private TableColumn<CompanyProtocol, String> deptCollumn;

	@FXML
	private TableColumn<CompanyProtocol, String> typeCollumn;

	@FXML
	private Button addBtn;

	@FXML
	private Button changeBtn;

	@FXML
	private Button deleteBtn;

	@FXML
	private Button selectBtn;

	@FXML
	private Button closeBtn;

	FXMLFormPath formPath = new FXMLFormPath();

	public static Button button;

	public static Company company;

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyInputController companyInputController;

	public void setCompanyInputController(CompanyInputController companyInputController, Company company,
			Button button) {
		this.companyInputController = companyInputController;
		this.company = company;
		this.button = button;
		viewProtocolObservableList.addAll(CompanyProtocolInputController.companyProtocolListIndexing);
		viewCompanyProtocol();
	}

	public static List<List<CompanyStandardProtocolActivity>> listOfcompanyStandardProtocolActivityList = new ArrayList<List<CompanyStandardProtocolActivity>>();
	public static List<List<CompanyOptionalProtocolActivity>> listOfCompanyOptionalProtocolActivityList = new ArrayList<List<CompanyOptionalProtocolActivity>>();

	public void getUnsavedData() {

		listOfcompanyStandardProtocolActivityList
				.add(CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);

		listOfCompanyOptionalProtocolActivityList
				.add(CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);

	}

	public CompanyEditController companyEditController;

	public void setCompanyEditController(CompanyEditController companyEditController, Company company, Button button) {
		this.companyEditController = companyEditController;
		this.company = company;
		this.button = button;

		viewProtocolObservableList = new CompanyProtocolEntityController()
				.viewCompanyProtocolByCompanyId(company.getId());
		viewCompanyProtocol();
	}

	public EncounterFormInputController encounterFormInputController;

	public void setEncounterFormInputController(EncounterFormInputController encounterFormInputController) {
		this.encounterFormInputController = encounterFormInputController;
		if (Global.patient.getCompany() != null) {
			company = Global.patient.getCompany();
		}
		viewProtocolObservableList = new CompanyProtocolEntityController()
				.viewCompanyProtocolByCompanyId(company.getId());
		viewCompanyProtocol();
		selectBtn.setVisible(true);
	}

	public ObservableList viewProtocolObservableList = FXCollections.observableArrayList();

	public void viewCompanyProtocol() {

		descriptionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().descriptionProperty());
		visitCategoryCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getVisitCategory() != null
				? cellValue.getValue().getVisitCategory().codeProperty() : null);
		jobClassCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getJobClass() != null
				? cellValue.getValue().getJobClass().classOfJobProperty() : null);

		deptCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getDepartmentUnit() != null
				? cellValue.getValue().getDepartmentUnit().codeProperty() : null);

		typeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().protocolTypeProperty());

		companyProtocolTable.setItems(viewProtocolObservableList);

		/*
		 * if(companyInputController != null){
		 * 
		 * if(CompanyProtocolInputController.companyProtocolList != null){
		 * observableList.addAll(CompanyProtocolInputController.
		 * companyProtocolList); companyProtocolTable.setItems(observableList);
		 * } } else if(companyEditController != null){
		 * 
		 * observableList = new
		 * CompanyProtocolEntityController().viewCompanyProtocolByCompanyId(
		 * company.getId());
		 * if(CompanyProtocolInputController.companyProtocolList.size()>0){
		 * observableList.addAll(CompanyProtocolInputController.
		 * companyProtocolList); }
		 * companyProtocolTable.setItems(observableList); }else
		 * if(encounterFormInputController != null){
		 * 
		 * observableList = new
		 * CompanyProtocolEntityController().viewCompanyProtocolByCompanyId(
		 * Global.patientVisitObj.getPatient().getCompany().getId());
		 * 
		 * companyProtocolTable.setItems(observableList); }
		 */

	}

	public static Integer companyProtocolListIndex = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectBtn.setVisible(false);
		viewCompanyProtocol();

		deleteBtn.setOnAction((event) -> {

			try {
				CompanyProtocol companyProtocol = companyProtocolTable.getSelectionModel().getSelectedItem();
				if (company != null ? (company.getId() != null && company.getId() != 0) : false) {
					List<PatientVisit> list = new ArrayList<PatientVisit>();
					list = new PatientVisitEntityController().viewByProtocolId(companyProtocol.getId());

					if (list.size() > 0) {
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Dialog");
						alert.setHeaderText("");
						alert.setContentText("This protocol is linked with some patients.Are you Sure?");

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							new PatientVisitEntityController().setProtocolId(companyProtocol.getId());
							new CompanyStandardProtocolActivityEntityController()
									.deleteByProtocolId(companyProtocol.getId());
							new CompanyOptionalProtocolActivityEntityController()
									.deleteByProtocolId(companyProtocol.getId());
							new CompanyProtocolEntityController().delete(companyProtocol.getId());
							viewProtocolObservableList = FXCollections.observableArrayList();
							viewProtocolObservableList = new CompanyProtocolEntityController()
									.viewCompanyProtocolByCompanyId(company.getId());
							viewCompanyProtocol();
						} else {

						}

					} else {
						new CompanyStandardProtocolActivityEntityController()
								.deleteByProtocolId(companyProtocol.getId());
						new CompanyOptionalProtocolActivityEntityController()
								.deleteByProtocolId(companyProtocol.getId());
						new CompanyProtocolEntityController().delete(companyProtocol.getId());
						viewProtocolObservableList = FXCollections.observableArrayList();
						viewProtocolObservableList = new CompanyProtocolEntityController()
								.viewCompanyProtocolByCompanyId(company.getId());
						viewCompanyProtocol();
					}

					// ContactInputController.contactList = new
					// ContactEntityController().viewByCompId(CompanyEditController.company.getId());

				} else {

					int selectedCompanyIndex = companyProtocolTable.getSelectionModel().getSelectedIndex();
					// int ind2 =
					// companyProtocolTable.getSelectionModel().getSelectedIndex();

					if (selectedCompanyIndex != -1) {
						listOfcompanyStandardProtocolActivityList.remove(selectedCompanyIndex);
						listOfCompanyOptionalProtocolActivityList.remove(selectedCompanyIndex);
						CompanyProtocolInputController.companyProtocolListIndexing.remove(selectedCompanyIndex);
						CompanyProtocolInputController.companyProtocolList.remove(selectedCompanyIndex);

						/*
						 * CompanyStandardProtocolActivityInputController.
						 * companyStandardProtocolActivityList= new
						 * ArrayList<CompanyStandardProtocolActivity>();
						 * CompanyOptionalProtocolActivityInputController.
						 * companyOptionalProtocolActivityList=new
						 * ArrayList<CompanyOptionalProtocolActivity>();
						 */
						viewProtocolObservableList = FXCollections.observableArrayList();
						viewProtocolObservableList.addAll(CompanyProtocolInputController.companyProtocolListIndexing);
						viewCompanyProtocol();

					}

				}
				// new CompanyProtocolEntityController().dele

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		addBtn.setOnAction((event) -> {

			try {

				String formName = formPath.context.getMessage("AddProtocol", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddProtocol", null, Locale.US);
				formPath.closeApplicationContext();

				CompanyProtocolInputController companyProtocolInputController = (CompanyProtocolInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyProtocolInputController.setCompanyProtocolViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeBtn.setOnAction((event) -> {
			try {

				CompanyProtocol companyProtocol = companyProtocolTable.getSelectionModel().getSelectedItem();
				Integer selectedIndexOfProtocolTable = companyProtocolTable.getSelectionModel().getSelectedIndex();
				String formName = formPath.context.getMessage("EditProtocol", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditProtocol", null, Locale.US);

				formPath.closeApplicationContext();
				CompanyProtocolEditController editController = (CompanyProtocolEditController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				if (companyProtocol != null) {
					if (CompanyProtocolViewController.company.getId() == null
							|| CompanyProtocolViewController.company.getId() == 0) {

						editController.observableListStd
								.addAll(listOfcompanyStandardProtocolActivityList.get(selectedIndexOfProtocolTable));
						CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList = listOfcompanyStandardProtocolActivityList
								.get(selectedIndexOfProtocolTable);

						editController.observableListOpt
								.addAll(listOfCompanyOptionalProtocolActivityList.get(selectedIndexOfProtocolTable));
						CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList = listOfCompanyOptionalProtocolActivityList
								.get(selectedIndexOfProtocolTable);

					} else {
						editController.observableListStd = new CompanyStandardProtocolActivityEntityController()
								.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());

						editController.observableListOpt = new CompanyOptionalProtocolActivityEntityController()
								.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());

					}
					editController.setCompanyProtocolViewController(this, selectedIndexOfProtocolTable);
					editController.setCompanyProtocol(companyProtocol);

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select or add protocol!");

					alert.showAndWait();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		selectBtn.setOnAction((event) -> {
			try {
				CompanyProtocol companyProtocol = companyProtocolTable.getSelectionModel().getSelectedItem();

				Global.patientVisitObj.setCompanyProtocol(companyProtocol);
				if (encounterFormInputController != null) {
					encounterFormInputController.getCompanyProtocolId();

					encounterFormInputController.viewStandardProtocolActivity();
					encounterFormInputController.viewOptionalProtocolActivity();

				}
				new FXFormCommonUtilities().closeForm(selectBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
