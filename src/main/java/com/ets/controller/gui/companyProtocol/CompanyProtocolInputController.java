package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyProtocol.CompanyProtocolEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.entity.contact.ContactEntityController;
import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.jobClass.JobClassEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.contact.ContactEditController;
import com.ets.controller.gui.contact.ContactInputController;
import com.ets.controller.gui.departmentUnit.DepartmentUnitViewController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.controller.gui.jobClass.JobClassViewController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeViewController;
import com.ets.model.Company;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;
import com.ets.model.MedicalActivity;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.utils.InitSpinner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CompanyProtocolInputController implements Initializable {

	@FXML
	private RadioButton survillanceRadio;

	@FXML
	private ToggleGroup type;

	@FXML
	private RadioButton workersRadio;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField categoryText;

	@FXML
	private TextField jobClassText;

	@FXML
	private TextField deptUnitText;

	@FXML
	private TextField userFormText;

	@FXML
	private Spinner<String> overrideMinSpinnerValue;

	@FXML
	private Button categoryBtn;

	@FXML
	private Button jobClassbtn;

	@FXML
	private Button deptUnitBtn;

	@FXML
	private Button standardAddBtn;

	@FXML
	private Button standardChangeBtn;

	@FXML
	private Button standardDeleteBtn;

	@FXML
	private Button optionalAddBtn;

	@FXML
	private Button optionalChangeBtn;

	@FXML
	private Button optionalDeleteBtn;

	@FXML
	private Button contactAddBtn;

	@FXML
	private Button contactChangeBtn;

	@FXML
	private Button contactDeleteBtn;

	@FXML
	private TextField amountText;

	@FXML
	private TextField phoneNumberText;

	@FXML
	private TextField deptText;

	@FXML
	private TextField ptotText;

	@FXML
	private TextField referralsText;

	@FXML
	private TextField reportResultText;

	@FXML
	private TextField mailAddress;

	@FXML
	private TextField city;

	@FXML
	private TextField state;

	@FXML
	private TextField zip;

	@FXML
	private TextField phone;

	@FXML
	private TextField faxResult;

	@FXML
	private TextField emailResult;

	@FXML
	private TextArea instructionTextArea;

	@FXML
	private TableView<CompanyStandardProtocolActivity> standardActivityTable;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, String> standardActivityCollumn;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, String> standardDescriptionCollumn;

	@FXML
	private TableColumn<CompanyStandardProtocolActivity, Boolean> standardInactiveCollumn;

	@FXML
	private TableView<CompanyOptionalProtocolActivity> optionalActivityTable;

	@FXML
	private TableColumn<CompanyOptionalProtocolActivity, String> optionalActivityCollumn;

	@FXML
	private TableColumn<CompanyOptionalProtocolActivity, String> optionalDescriptionCollumn;

	@FXML
	private TableColumn<CompanyOptionalProtocolActivity, Boolean> optionalInactiveCollumn;

	@FXML
	private TableView<Contact> contactTable;

	@FXML
	private TableColumn<Contact, String> contactFullnameCollumn;

	@FXML
	private TableColumn<Contact, String> contactTypeCollumn;

	@FXML
	private TableColumn<Contact, Boolean> ContactInactiveCollumn;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button okBtn;

	@FXML
	private Button printBtn;

	FXMLFormPath formPath = new FXMLFormPath();
	private VisitCategory visitCategory;

	public void setVisitCategoryCode(VisitCategory visitCategory) {
		this.visitCategory = visitCategory;
		categoryText.setText(visitCategory.getCode());
	}

	public void setjobClass(String code) {

		jobClassText.setText(code);
	}

	public void setDepartmentUnitCode(String code) {

		deptUnitText.setText(code);
	}

	private EncounterFormInputController encounterFormInputController;

	public void setEncounterFormInputController(EncounterFormInputController encounterFormInputController) {
		this.encounterFormInputController = encounterFormInputController;
	}

	public CompanyProtocolViewController companyProtocolViewController;

	public void setCompanyProtocolViewController(CompanyProtocolViewController companyProtocolViewController) {
		this.companyProtocolViewController = companyProtocolViewController;
		viewContact();
	}

	public void viewFromOptProtocolEdit(CompanyOptionalProtocolActivity companyOptionalProtocolActivity,
			Integer optIndex) {

		optionalActivityTable.getItems().set(optIndex, companyOptionalProtocolActivity);

	}

	public void viewFromStdProtocolEdit(CompanyStandardProtocolActivity companyStandardProtocolActivity,
			Integer standardIndex) {

		standardActivityTable.getItems().set(standardIndex, companyStandardProtocolActivity);

	}

	public void viewCompanyStandardProtocolActivity() {

		standardActivityCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		standardDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());
		standardInactiveCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().inactiveProperty());

		ObservableList observableList = FXCollections.observableArrayList();

		if (CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList != null) {

			for (CompanyStandardProtocolActivity standardProtocolActivityList : CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList) {

				observableList.add(standardProtocolActivityList);
			}

			standardActivityTable.setItems(observableList);

		}
	}

	public void viewCompanyOptionalProtocolActivity() {

		optionalActivityCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		optionalDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());
		optionalInactiveCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().inactiveProperty());

		ObservableList observableList = FXCollections.observableArrayList();
		if (CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList != null) {

			for (CompanyOptionalProtocolActivity optionalProtocolActivityList : CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList) {

				observableList.add(optionalProtocolActivityList);
			}

			optionalActivityTable.setItems(observableList);

		}

	}

	public void refreshContactFromProtocolEdit(Integer selectedContectIndex, Contact contact) {
		contactTable.getItems().set(selectedContectIndex, contact);

	}

	List<Contact> contactAfterDelt = null;

	public void refContactAfterDelete() {
		contactAfterDelt = new ArrayList<Contact>();
		contactAfterDelt = ContactInputController.contactList;
		// ContactInputController.contactList=
		viewContact();

	}

	public void viewContact() {

		contactFullnameCollumn.setCellValueFactory(cellValue -> cellValue.getValue().fullNameProperty());
		contactTypeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().contactTypeProperty());
		// ContactInactiveCollumn.setCellValueFactory(cellValue ->
		// cellValue.getValue());
		ObservableList observableList = FXCollections.observableArrayList();
		if (contactAfterDelt != null) {
			observableList.addAll(contactAfterDelt);
			contactAfterDelt = null;
		} else {
			if (companyProtocolViewController != null) {
				if (companyProtocolViewController.companyEditController != null) {

					ContactInputController.contactList = new ContactEntityController()
							.viewByCompId(CompanyEditController.company.getId());

				}
			}

			if (ContactInputController.contactList.size() > 0) {

				/*
				 * for (Contact contact : ContactInputController.contactList) {
				 * 
				 * observableList.add(contact); }
				 */

				observableList.addAll(ContactInputController.contactList);

			}
			if (companyProtocolViewController != null
					? companyProtocolViewController.encounterFormInputController != null : false) {
				observableList = new ContactEntityController().viewByCompId(Global.patient.getCompany().getId());

			}

		}

		contactTable.setItems(observableList);
	}

	public static List<CompanyProtocol> companyProtocolList = new ArrayList<CompanyProtocol>();
	public static List<CompanyProtocol> companyProtocolListIndexing = new ArrayList<CompanyProtocol>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*
		 * viewCompanyStandardProtocolActivity();
		 * viewCompanyOptionalProtocolActivity();
		 */
		viewContact();

		categoryBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				VisitCategoryCodeViewController visitCategoryCodeViewController = (VisitCategoryCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visitCategoryCodeViewController.setCompanyProtocolInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		jobClassbtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("JobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobClass", null, Locale.US);
				formPath.closeApplicationContext();

				JobClassViewController jobClassViewController = (JobClassViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				jobClassViewController.setCompanyProtocolInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deptUnitBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("DepartmentUnitView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DepartmentUnitView", null, Locale.US);
				formPath.closeApplicationContext();

				DepartmentUnitViewController departmentUnitViewController = (DepartmentUnitViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				departmentUnitViewController.setCompanyProtocolInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standardAddBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController medicalActivityViewController = (MedicalActivityViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicalActivityViewController.setCompanyProtocolInputController(this, standardAddBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standardChangeBtn.setOnAction((event) -> {
			try {
				// Integer standardProtocolListIndex =
				// standardActivityTable.getSelectionModel().getSelectedIndex();
				CompanyStandardProtocolActivity companyStandardProtocolActivity = standardActivityTable
						.getSelectionModel().getSelectedItem();
				Integer standardProtocolTableIndex = standardActivityTable.getSelectionModel().getSelectedIndex();
				// Integer indexofstaticList =
				// CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.indexOf(standardActivityTable.getSelectionModel().getSelectedIndex());

				if (companyStandardProtocolActivity.getId() != null) {
					String formName = formPath.context.getMessage("EditCompanyStandardProtocolActivity", null,
							Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditCompanyStandardProtocolActivity", null,
							Locale.US);
					CompanyStandardProtocolActivityEditController editController = (CompanyStandardProtocolActivityEditController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					editController.setCompanyStandardProtocolActivity(companyStandardProtocolActivity,
							standardProtocolTableIndex);
					editController.setCompanyProtocolInputController(this);

				}
				/*
				 * 
				 * 
				 * 
				 * String formName = formPath.context.getMessage(
				 * "AddCompanyStandardProtocolActivity", null, Locale.US);
				 * String formTitle = formPath.context.getMessage(
				 * "Title.AddCompanyStandardProtocolActivity", null, Locale.US);
				 * String editInfo = formPath.context.getMessage("EditInfo",
				 * null, Locale.US); String infoDialogBoxTitle =
				 * formPath.context.getMessage("Title.InfoDialogBox", null,
				 * Locale.US);
				 * 
				 * formPath.closeApplicationContext();
				 * 
				 * 
				 * if (companyStandardProtocolActivity != null) {
				 * 
				 * FXMLLoader fxmlLoader = new
				 * FXMLLoader(getClass().getResource(formName)); Parent root1 =
				 * (Parent) fxmlLoader.load(); Stage stage = new Stage();
				 * stage.initModality(Modality.APPLICATION_MODAL);
				 * stage.setTitle(formTitle); stage.setScene(new Scene(root1));
				 * CompanyStandardProtocolActivityInputController editController
				 * = fxmlLoader.getController();
				 * editController.setCompanyStandardProtocolActivity(
				 * companyStandardProtocolActivity, standardChangeBtn,
				 * standardProtocolListIndex);
				 * editController.setCompanyProtocolInputController(this);
				 * stage.show();
				 * 
				 * }
				 */ else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select a record to edit!");

					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standardDeleteBtn.setOnAction((event) -> {
			try {
				CompanyStandardProtocolActivity companyStandardProtocolActivity = standardActivityTable
						.getSelectionModel().getSelectedItem();

				Integer indexOfStdTable = standardActivityTable.getSelectionModel().getSelectedIndex();

				if (indexOfStdTable != -1) {

					CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList
							.remove(standardActivityTable.getSelectionModel().getSelectedItem());
					viewCompanyStandardProtocolActivity();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		optionalAddBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController medicalActivityViewController = (MedicalActivityViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicalActivityViewController.setCompanyProtocolInputController(this, optionalAddBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		optionalChangeBtn.setOnAction((event) -> {
			try {

				CompanyOptionalProtocolActivity companyOptionalProtocolActivity = optionalActivityTable
						.getSelectionModel().getSelectedItem();
				Integer optionalProtocolTableIndex = optionalActivityTable.getSelectionModel().getSelectedIndex();
				// Integer indexofstaticList =
				// CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.indexOf(standardActivityTable.getSelectionModel().getSelectedIndex());

				if (companyOptionalProtocolActivity.getId() != null) {
					String formName = formPath.context.getMessage("EditCompanyOptionalProtocolActivity", null,
							Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditCompanyOptionalProtocolActivity", null,
							Locale.US);
					CompanyOptionalProtocolActivityEditController editController = (CompanyOptionalProtocolActivityEditController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					editController.setCompanyOptionalProtocolActivity(companyOptionalProtocolActivity,
							optionalProtocolTableIndex);
					editController.setCompanyProtocolInputController(this);

				}

				else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select a record to edit!");

					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		optionalDeleteBtn.setOnAction((event) -> {
			try {
				CompanyOptionalProtocolActivity companyOptionalProtocolActivity = optionalActivityTable
						.getSelectionModel().getSelectedItem();

				Integer indexOfOptTable = optionalActivityTable.getSelectionModel().getSelectedIndex();

				if (indexOfOptTable != -1) {

					CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList
							.remove(optionalActivityTable.getSelectionModel().getSelectedItem());
					viewCompanyOptionalProtocolActivity();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		contactAddBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactInputController contactInputController = (ContactInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				contactInputController.setCompanyProtocolInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		contactChangeBtn.setOnAction((event) -> {
			try {

				Integer indexOfstaticContactList = ContactInputController.contactList
						.indexOf(contactTable.getSelectionModel().getSelectedItem());
				Integer selectedContectIndex = contactTable.getSelectionModel().getSelectedIndex();

				Contact contact = contactTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactEditController contactEditController = (ContactEditController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				contactEditController.setCompanyProtocolInputController(this, contact, selectedContectIndex,
						indexOfstaticContactList);
				// System.out.println("fro chng btn index
				// "+indexOfstaticContactList);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		contactDeleteBtn.setOnAction(event -> {
			Contact contact = contactTable.getSelectionModel().getSelectedItem();
			Integer indexOfstaticContactList = ContactInputController.contactList
					.indexOf(contactTable.getSelectionModel().getSelectedItem());

			if (companyProtocolViewController.companyEditController != null) {
				new ContactEntityController().delete(contact.getId());

				// ContactInputController.contactList = new
				// ContactEntityController().viewByCompId(contact.getCompany().getId());
				if (indexOfstaticContactList != -1) {
					ContactInputController.contactList.remove(contactTable.getSelectionModel().getSelectedItem());
					refContactAfterDelete();
				}

			} else if (companyProtocolViewController.companyInputController != null) {
				Integer indexOfStaticContact = ContactInputController.contactList
						.indexOf(contactTable.getSelectionModel().getSelectedItem());
				if (indexOfStaticContact != -1) {
					ContactInputController.contactList.remove(contactTable.getSelectionModel().getSelectedItem());
					refContactAfterDelete();
				}
			}
		});

		okBtn.setOnAction((event) -> {
			try {

				List<String> spinerValue = new ArrayList<String>();
				spinerValue.add("");
				spinerValue.add("");
				spinerValue.add("");
				spinerValue.add("");
				spinerValue.add("");

				ObservableList<String> overrideMinuteList = FXCollections.observableList(spinerValue);
				SpinnerValueFactory factory1 = new SpinnerValueFactory.ListSpinnerValueFactory(overrideMinuteList);
				overrideMinSpinnerValue.setValueFactory(factory1);

				String protocolType = null;

				if (survillanceRadio.isSelected()) {
					protocolType = "Survillance";
				} else if (workersRadio.isSelected()) {
					protocolType = "Worker's Comp";
				}

				CompanyProtocol companyProtocol = new CompanyProtocol();

				companyProtocol.setProtocolType(protocolType);
				companyProtocol.setDescription(descriptionText.getText());

				if (categoryText.getText().length() > 0) {
					// VisitCategory visitCategory = new
					// VisitCategoryEntityController().viewByCode(categoryText.getText());
					if (visitCategory != null) {
						companyProtocol.setVisitCategory(visitCategory);
					}
				}

				if (jobClassText.getText().length() > 0) {

					JobClass jobClass = new JobClassEntityController().viewByCode(jobClassText.getText());

					companyProtocol.setJobClass(jobClass);
				}

				if (deptUnitText.getText().length() > 0) {

					DepartmentUnit departmentUnit = new DepartmentUnitEntityController()
							.viewByCode(deptUnitText.getText());
					companyProtocol.setDepartmentUnit(departmentUnit);
				}

				companyProtocol.setUserFormName(userFormText.getText());
				companyProtocol.setOverrideminute(overrideMinSpinnerValue.getValue());

				companyProtocol.setAboveAmount(amountText.getText());
				companyProtocol.setPhoneNumber(phoneNumberText.getText());
				companyProtocol.setNameOrDepartment(deptText.getText());
				companyProtocol.setPtOt(ptotText.getText());
				companyProtocol.setReferrals(referralsText.getText());

				companyProtocol.setReportResult(reportResultText.getText());
				companyProtocol.setMailAddress(mailAddress.getText());
				companyProtocol.setCity(city.getText());
				companyProtocol.setState(state.getText());
				companyProtocol.setZip(zip.getText());
				companyProtocol.setPhone(phone.getText());
				companyProtocol.setFaxResult(faxResult.getText());
				companyProtocol.setEmailResult(emailResult.getText());

				companyProtocol.setInstruction(instructionTextArea.getText());

				companyProtocolList.add(companyProtocol);
				// new

				companyProtocolListIndexing.add(companyProtocol);

				companyProtocolViewController.getUnsavedData();

				if (CompanyProtocolViewController.company.getId() == null
						|| CompanyProtocolViewController.company.getId() == 0) {

					companyProtocolViewController.viewProtocolObservableList.add(companyProtocol);

				} else {

					int sizeOfAll = CompanyProtocolInputController.companyProtocolListIndexing.size();

					for (int i = 0; i < sizeOfAll; i++) {
						CompanyProtocol companyProtocol1 = CompanyProtocolInputController.companyProtocolListIndexing
								.get(i);
						companyProtocol1.setCompany(CompanyProtocolViewController.company);
						new CompanyProtocolEntityController().saveCompanyProtocol(companyProtocol1);

						List<CompanyStandardProtocolActivity> companyStdProtocolList = CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList
								.get(i);
						for (CompanyStandardProtocolActivity stdProto : companyStdProtocolList) {
							stdProto.setCompanyProtocol(companyProtocol1);
							new CompanyStandardProtocolActivityEntityController()
									.saveCompanyStandardProtocolActivity(stdProto);
						}
						List<CompanyOptionalProtocolActivity> companyOptProtocolList = CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList
								.get(i);
						for (CompanyOptionalProtocolActivity optProto : companyOptProtocolList) {
							optProto.setCompanyProtocol(companyProtocol1);
							new CompanyOptionalProtocolActivityEntityController()
									.saveCompanyOptionalProtocolActivity(optProto);
						}
					}

					companyProtocolViewController.viewProtocolObservableList = new CompanyProtocolEntityController()
							.viewCompanyProtocolByCompanyId(CompanyProtocolViewController.company.getId());

				}

				companyProtocolViewController.viewCompanyProtocol();

				// companyProtocol.setStandardProtocolActivity(CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);
				// companyProtocol.setOptionalProtocolActivity(CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);

				// companyProtocol.setCompany(companyProtocolViewController.companyObj);

				/*
				 * if(companyProtocolViewController!=null?
				 * companyProtocolViewController.encounterFormInputController!=
				 * null:false){
				 * companyProtocol.setCompany(Global.patient.getCompany()); new
				 * CompanyProtocolEntityController().saveCompanyProtocol(
				 * companyProtocol);
				 * 
				 * 
				 * for(CompanyStandardProtocolActivity standardProtocolActivity
				 * :CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList){
				 * 
				 * standardProtocolActivity.setCompanyProtocol(companyProtocol);
				 * new CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ;
				 * 
				 * }
				 * 
				 * for(CompanyOptionalProtocolActivity cop
				 * :CompanyOptionalProtocolActivityInputController.
				 * companyOptionalProtocolActivityList){ System.out.println(
				 * "^^^^^^^^^^CompanyOptionalProtocolActivity^^^^^^"+cop.
				 * getMedicalActivity().getDescrip());
				 * cop.setCompanyProtocol(companyProtocol); new
				 * CompanyOptionalProtocolActivityEntityController().
				 * saveCompanyOptionalProtocolActivity(cop); }
				 */

				/*
				 * 
				 * 
				 * 
				 * 
				 * companyProtocolViewController.viewCompanyProtocol();
				 * System.out.println("############## saved from encounter");
				 * 
				 * }else{ companyProtocolList.add(companyProtocol); // new
				 * 
				 * companyProtocolListIndexing.add(companyProtocol);
				 * 
				 * companyProtocolViewController.getUnsavedData();
				 * //companyProtocolList.set(index, companyProtocol);
				 * 
				 * 
				 * /* for(CompanyStandardProtocolActivity
				 * standardProtocolActivity
				 * :CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList){
				 * System.out.println("^^^^^^^^^^standardProtocolActivity^^^^^^"
				 * +standardProtocolActivity.getMedicalActivity().getDescrip());
				 * //standardProtocolActivity.setCompanyProtocol(companyProtocol
				 * ); //CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.add(
				 * standardProtocolActivity);
				 * 
				 * } System.out.println("companyOptionalProtocolActivityList&&"+
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.size());
				 * System.out.println("companyOptionalProtocolActivityList&&"+
				 * CompanyOptionalProtocolActivityInputController.
				 * companyOptionalProtocolActivityList.size());
				 * 
				 * for(CompanyOptionalProtocolActivity cop
				 * :CompanyOptionalProtocolActivityInputController.
				 * companyOptionalProtocolActivityList){ System.out.println(
				 * "^^^^^^^^^^CompanyOptionalProtocolActivity^^^^^^"+cop.
				 * getMedicalActivity().getDescrip());
				 * //standardProtocolActivity.setCompanyProtocol(companyProtocol
				 * ); //CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.add(
				 * standardProtocolActivity); }
				 * 
				 * //new CompanyProtocolEntityController().saveCompanyProtocol(
				 * companyProtocol);
				 * 
				 * 
				 * companyProtocolViewController.viewCompanyProtocol(); }
				 */
				CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList = new ArrayList<CompanyStandardProtocolActivity>();
				CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList = new ArrayList<CompanyOptionalProtocolActivity>();

				new FXFormCommonUtilities().closeForm(okBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelBtn.setOnAction((event) -> {
			try {
				CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList = new ArrayList<CompanyStandardProtocolActivity>();
				CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList = new ArrayList<CompanyOptionalProtocolActivity>();
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
