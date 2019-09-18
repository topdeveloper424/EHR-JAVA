package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
import com.ets.controller.gui.contact.ContactEditController;
import com.ets.controller.gui.contact.ContactInputController;
import com.ets.controller.gui.departmentUnit.DepartmentUnitViewController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.controller.gui.jobClass.JobClassViewController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeViewController;
import com.ets.controller.gui.whiteBoardController.PatientWhiteBoardController;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyProtocol;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javassist.expr.NewArray;

public class CompanyProtocolEditController implements Initializable {

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

	private JobClass jobClass;

	public void setjobClass(JobClass jobclass) {
		this.jobClass = jobclass;
		jobClassText.setText(jobclass.getClassOfJob());
	}

	private DepartmentUnit departmentUnit;

	public void setDepartmentUnitCode(DepartmentUnit departmentUnit) {
		this.departmentUnit = departmentUnit;
		deptUnitText.setText(departmentUnit.getCode());
	}

	public void refreshContactFromProtocolEdit(Integer selectedContectIndex, Contact contact) {
		contactTable.getItems().set(selectedContectIndex, contact);

	}

	public EncounterFormInputController encounterFormInputController;
	public CompanyProtocol companyProtocolFromEncounter;

	public void setEncounterFormInputController(EncounterFormInputController encounterFormInputController,
			CompanyProtocol companyProtocol) {
		this.companyProtocol = companyProtocol;
		this.encounterFormInputController = encounterFormInputController;
		this.companyProtocolFromEncounter = companyProtocol;
		// getCompanyProtocolId();

		if ("Survillance".equals(companyProtocolFromEncounter.getProtocolType())) {

			survillanceRadio.setSelected(true);

		} else if ("Worker's Comp".equals(companyProtocolFromEncounter.getProtocolType())) {

			workersRadio.setSelected(true);

		}

		descriptionText.setText(companyProtocolFromEncounter.getDescription());

		if (companyProtocolFromEncounter.getVisitCategory() != null) {
			categoryText.setText(companyProtocolFromEncounter.getVisitCategory().getCode());
		}

		if (companyProtocolFromEncounter.getJobClass() != null) {

			jobClassText.setText(companyProtocolFromEncounter.getJobClass().getClassOfJob());

		}
		if (companyProtocolFromEncounter.getDepartmentUnit() != null) {

			deptUnitText.setText(companyProtocolFromEncounter.getDepartmentUnit().getCode());

		}

		userFormText.setText(companyProtocolFromEncounter.getUserFormName());
		// overrideMinSpinnerValue.setValueFactory(companyProtocol.getOverrideminute());
		// value set not done

		amountText.setText(companyProtocolFromEncounter.getAboveAmount());
		phoneNumberText.setText(companyProtocolFromEncounter.getPhoneNumber());
		deptText.setText(companyProtocolFromEncounter.getNameOrDepartment());
		ptotText.setText(companyProtocolFromEncounter.getPtOt());
		referralsText.setText(companyProtocolFromEncounter.getReferrals());

		reportResultText.setText(companyProtocolFromEncounter.getReportResult());
		mailAddress.setText(companyProtocolFromEncounter.getMailAddress());
		city.setText(companyProtocolFromEncounter.getCity());
		state.setText(companyProtocolFromEncounter.getState());
		zip.setText(companyProtocolFromEncounter.getZip());
		phone.setText(companyProtocolFromEncounter.getPhone());
		faxResult.setText(companyProtocolFromEncounter.getFaxResult());
		emailResult.setText(companyProtocolFromEncounter.getEmailResult());

		instructionTextArea.setText(companyProtocolFromEncounter.getInstruction());

		observableListStd = new CompanyStandardProtocolActivityEntityController()
				.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
		viewCompanyStandardProtocolActivity();

		observableListOpt = new CompanyOptionalProtocolActivityEntityController()
				.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());
		viewCompanyOptionalProtocolActivity();

		viewContact();

		setConpanyProtocolInitialData();
	}
	
	
	public void getCompanyProtocolId() {

		if(Global.patientVisitObj.getPatient().getCompany()!=null){
		if (Global.patientVisitObj.getCompanyProtocol() != null) {

			companyProtocol = Global.patientVisitObj.getCompanyProtocol();

		} else {
			if (Global.patient.getCompany() != null) {
				companyProtocol = new CompanyProtocolEntityController().viewByCompanyIdAndVisitCategoryId(
						Global.patientVisitObj.getPatient().getCompany().getId(),
						Global.patientVisitObj.getVisitCategory().getId());
				
			} else {
				System.out.println("company not exists");
			}
		}
		
		}else{
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("No company found for this patient!");

			alert.showAndWait();
			
		}

	}
	
	
	
	
	

	private PatientWhiteBoardController patientWhiteBoardController;

	public void setPatientWhiteBoardController(PatientWhiteBoardController patientWhiteBoardController) {
		this.patientWhiteBoardController = patientWhiteBoardController;
		 getCompanyProtocolId();
		
	if ("Survillance".equals(companyProtocol.getProtocolType())) {

			survillanceRadio.setSelected(true);

		} else if ("Worker's Comp".equals(companyProtocol.getProtocolType())) {

			workersRadio.setSelected(true);

		}

		descriptionText.setText(companyProtocol.getDescription());

		if (companyProtocol.getVisitCategory() != null) {
			categoryText.setText(companyProtocol.getVisitCategory().getCode());
		}

		if (companyProtocol.getJobClass() != null) {

			jobClassText.setText(companyProtocol.getJobClass().getClassOfJob());

		}
		if (companyProtocol.getDepartmentUnit() != null) {

			deptUnitText.setText(companyProtocol.getDepartmentUnit().getCode());

		}

		userFormText.setText(companyProtocol.getUserFormName());
		// overrideMinSpinnerValue.setValueFactory(companyProtocol.getOverrideminute());
		// value set not done

		amountText.setText(companyProtocol.getAboveAmount());
		phoneNumberText.setText(companyProtocol.getPhoneNumber());
		deptText.setText(companyProtocol.getNameOrDepartment());
		ptotText.setText(companyProtocol.getPtOt());
		referralsText.setText(companyProtocol.getReferrals());

		reportResultText.setText(companyProtocol.getReportResult());
		mailAddress.setText(companyProtocol.getMailAddress());
		city.setText(companyProtocol.getCity());
		state.setText(companyProtocol.getState());
		zip.setText(companyProtocol.getZip());
		phone.setText(companyProtocol.getPhone());
		faxResult.setText(companyProtocol.getFaxResult());
		emailResult.setText(companyProtocol.getEmailResult());

		instructionTextArea.setText(companyProtocol.getInstruction());

		observableListStd = new CompanyStandardProtocolActivityEntityController()
				.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
		viewCompanyStandardProtocolActivity();

		observableListOpt = new CompanyOptionalProtocolActivityEntityController()
				.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());
		viewCompanyOptionalProtocolActivity();

		viewContact();
		setConpanyProtocolInitialData();
		
	}

	private CompanyProtocol companyProtocol1;

	public void setCompanyProtocol1(CompanyProtocol companyProtocol1) {
		this.companyProtocol1 = companyProtocol1;
	}

	public void setConpanyProtocolInitialData() {

		if (companyProtocol1 != null) {

			if ("Survillance".equals(companyProtocol1.getProtocolType())) {

				survillanceRadio.setSelected(true);

			} else if ("Worker's Comp".equals(companyProtocol1.getProtocolType())) {

				workersRadio.setSelected(true);

			}

			descriptionText.setText(companyProtocol1.getDescription());

			if (companyProtocol1.getVisitCategory() != null) {
				categoryText.setText(companyProtocol1.getVisitCategory().getCode());
			}

			if (companyProtocol1.getJobClass() != null) {

				jobClassText.setText(companyProtocol1.getJobClass().getClassOfJob());
			}
			if (companyProtocol1.getDepartmentUnit() != null) {

				deptText.setText(companyProtocol1.getDepartmentUnit().getCode());

			}

			userFormText.setText(companyProtocol1.getUserFormName());
			// overrideMinSpinnerValue.setValueFactory(companyProtocol.getOverrideminute());
			// value set not done

			amountText.setText(companyProtocol1.getAboveAmount());
			phoneNumberText.setText(companyProtocol1.getPhoneNumber());
			deptText.setText(companyProtocol1.getNameOrDepartment());
			ptotText.setText(companyProtocol1.getPtOt());
			referralsText.setText(companyProtocol1.getReferrals());

			reportResultText.setText(companyProtocol1.getReportResult());
			mailAddress.setText(companyProtocol1.getMailAddress());
			city.setText(companyProtocol1.getCity());
			state.setText(companyProtocol1.getState());
			zip.setText(companyProtocol1.getZip());
			phone.setText(companyProtocol1.getPhone());
			faxResult.setText(companyProtocol1.getFaxResult());
			emailResult.setText(companyProtocol1.getEmailResult());

			instructionTextArea.setText(companyProtocol1.getInstruction());

		}
	}

	/*
	 * public void getCompanyProtocolId(){
	 * 
	 * companyProtocol1 = (CompanyProtocol) new
	 * CompanyProtocolEntityController().viewByCompanyIdAndDescription(Global.
	 * patientVisitObj.getPatient().getCompany().getId(),
	 * Global.patientVisitObj.getPurpose());
	 * 
	 * 
	 * }
	 */

	public void viewFromStdProtocolEdit(CompanyStandardProtocolActivity companyStandardProtocolActivity,
			Integer standardIndex) {

		standardActivityTable.getItems().set(standardIndex, companyStandardProtocolActivity);

	}

	public void viewFromOptProtocolEdit(CompanyOptionalProtocolActivity companyOptionalProtocolActivity,
			Integer optIndex) {

		optionalActivityTable.getItems().set(optIndex, companyOptionalProtocolActivity);

	}

	// List<CompanyStandardProtocolActivity> compStdRefreshList=new
	// ArrayList<CompanyStandardProtocolActivity>();
	/*
	 * public void viewStdByProtocolId(){
	 * 
	 * if(companyProtocol!=null){ compStdRefreshList = new
	 * CompanyStandardProtocolActivityEntityController().
	 * viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
	 * System.out.println("********* run from fun ref"
	 * +compStdRefreshList.size()); } for (CompanyStandardProtocolActivity
	 * companyStandardProtocolActivity :
	 * CompanyStandardProtocolActivityInputController.
	 * companyStandardProtocolActivityList) {
	 * if(companyStandardProtocolActivity.getId()==null||
	 * companyStandardProtocolActivity.getId()==0){
	 * compStdRefreshList.add(companyStandardProtocolActivity); } }
	 * 
	 * viewCompanyStandardProtocolActivity(); }
	 */
	public ObservableList observableListStd = FXCollections.observableArrayList();

	public void viewCompanyStandardProtocolActivity() {

		standardActivityCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		standardDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());
		standardInactiveCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().inactiveProperty());

		standardActivityTable.setItems(observableListStd);

	}/*
		 * if(companyProtocolViewController != null){
		 * 
		 * if(CompanyProtocolViewController.button!=null?
		 * CompanyProtocolViewController.button.getId().equals(
		 * "compantProtocolBtn"):false){
		 * 
		 * if(CompanyStandardProtocolActivityInputController.
		 * companyStandardProtocolActivityList != null){ System.out.println(
		 * "##############1 "); for (CompanyStandardProtocolActivity
		 * standardProtocolActivityList :
		 * CompanyStandardProtocolActivityInputController.
		 * companyStandardProtocolActivityList) {
		 * observableListStd.add(standardProtocolActivityList); }
		 * 
		 * if(compStdRefreshList.size()>0){
		 * 
		 * observableListStd=FXCollections.observableArrayList();
		 * observableListStd.addAll(compStdRefreshList); compStdRefreshList =new
		 * ArrayList<CompanyStandardProtocolActivity>(); }
		 * standardActivityTable.setItems(observableListStd); }
		 * 
		 * }else if(CompanyProtocolViewController.button!=null?
		 * CompanyProtocolViewController.button.getId().equals(
		 * "compantProtocolEditBtn"):false){ System.out.println(
		 * "##############12 "); if(companyProtocol.getCompany()!=null){
		 * observableListStd = new
		 * CompanyStandardProtocolActivityEntityController().
		 * viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId
		 * ());
		 * 
		 * }
		 * 
		 * 
		 * 
		 * standardActivityTable.setItems(observableListStd);
		 * 
		 * }else
		 * if(companyProtocolViewController.encounterFormInputController!=null){
		 * ObservableList<CompanyStandardProtocolActivity>
		 * companyStandardProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocolViewController
		 * != null){ companyStandardProtocolActivityMasterData = new
		 * CompanyStandardProtocolActivityEntityController().
		 * viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId
		 * ()); standardActivityTable.setItems(
		 * companyStandardProtocolActivityMasterData); System.out.println(
		 * "################# 1111"
		 * +CompanyStandardProtocolActivityInputController.
		 * companyStandardProtocolActivityList.size()+"     "
		 * +companyStandardProtocolActivityMasterData.size()); }
		 * 
		 * } }else if(patientWhiteBoardController != null){
		 * 
		 * ObservableList<CompanyStandardProtocolActivity>
		 * companyStandardProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocol1 != null){
		 * companyStandardProtocolActivityMasterData = new
		 * CompanyStandardProtocolActivityEntityController().
		 * viewCompanyStandardProtocolActivityByProtocolId(companyProtocol1.
		 * getId());
		 * 
		 * }
		 * 
		 * standardActivityTable.setItems(
		 * companyStandardProtocolActivityMasterData); }else
		 * if(encounterFormInputController != null){
		 * 
		 * ObservableList<CompanyStandardProtocolActivity>
		 * companyStandardProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocolFromEncounter
		 * != null){ companyStandardProtocolActivityMasterData = new
		 * CompanyStandardProtocolActivityEntityController().
		 * viewCompanyStandardProtocolActivityByProtocolId(
		 * companyProtocolFromEncounter.getId());
		 * 
		 * }
		 * 
		 * standardActivityTable.setItems(
		 * companyStandardProtocolActivityMasterData);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * List<CompanyOptionalProtocolActivity> compOptRefreshList=new
		 * ArrayList<CompanyOptionalProtocolActivity>(); public void
		 * viewOptByProtocolId(){
		 * 
		 * if(companyProtocol!=null){ compOptRefreshList = new
		 * CompanyOptionalProtocolActivityEntityController().
		 * viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId
		 * ()); System.out.println("********* run from fun ref"
		 * +compStdRefreshList.size()); } for (CompanyOptionalProtocolActivity
		 * companyOptionalProtocolActivity :
		 * CompanyOptionalProtocolActivityInputController.
		 * companyOptionalProtocolActivityList) {
		 * if(companyOptionalProtocolActivity.getId()==null||
		 * companyOptionalProtocolActivity.getId()==0){
		 * compOptRefreshList.add(companyOptionalProtocolActivity); } }
		 * 
		 * viewCompanyOptionalProtocolActivity(); }
		 */

	public ObservableList observableListOpt = FXCollections.observableArrayList();

	public void viewCompanyOptionalProtocolActivity() {

		optionalActivityCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().codeProperty());
		optionalDescriptionCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().descripProperty());
		optionalInactiveCollumn
				.setCellValueFactory(cellValue -> cellValue.getValue().getMedicalActivity().inactiveProperty());

		optionalActivityTable.setItems(observableListOpt);

		/*
		 * if(companyProtocolViewController != null){
		 * if(CompanyProtocolViewController.button!=null?
		 * CompanyProtocolViewController.button.getId().equals(
		 * "compantProtocolBtn"):false){
		 * 
		 * if(CompanyOptionalProtocolActivityInputController.
		 * companyOptionalProtocolActivityList != null){
		 * 
		 * for (CompanyOptionalProtocolActivity optionalProtocolActivityList :
		 * CompanyOptionalProtocolActivityInputController.
		 * companyOptionalProtocolActivityList) {
		 * 
		 * observableList.add(optionalProtocolActivityList);
		 * 
		 * }if(compOptRefreshList.size()>0){
		 * 
		 * observableList=FXCollections.observableArrayList();
		 * observableList.addAll(compOptRefreshList); compOptRefreshList =new
		 * ArrayList<CompanyOptionalProtocolActivity>(); }
		 * 
		 * optionalActivityTable.setItems(observableList);
		 * 
		 * }
		 * 
		 * }else if(CompanyProtocolViewController.button!=null?
		 * CompanyProtocolViewController.button.getId().equals(
		 * "compantProtocolEditBtn"):false){
		 * 
		 * observableList = new
		 * CompanyOptionalProtocolActivityEntityController().
		 * viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId
		 * ()); optionalActivityTable.setItems(observableList);
		 * System.out.println("Protocol Size is :-----" +observableList.size());
		 * 
		 * }else
		 * if(companyProtocolViewController.encounterFormInputController!=null){
		 * ObservableList<CompanyOptionalProtocolActivity>
		 * companyOptionalProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocolViewController
		 * != null){ companyOptionalProtocolActivityMasterData = new
		 * CompanyOptionalProtocolActivityEntityController().
		 * viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId
		 * ()); optionalActivityTable.setItems(
		 * companyOptionalProtocolActivityMasterData); }
		 * 
		 * }
		 * 
		 * }else if(patientWhiteBoardController != null){
		 * ObservableList<CompanyOptionalProtocolActivity>
		 * companyOptionalProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocol1 != null){
		 * companyOptionalProtocolActivityMasterData = new
		 * CompanyOptionalProtocolActivityEntityController().
		 * viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol1.
		 * getId()); }
		 * 
		 * optionalActivityTable.setItems(
		 * companyOptionalProtocolActivityMasterData);
		 * 
		 * }else if(encounterFormInputController != null){
		 * ObservableList<CompanyOptionalProtocolActivity>
		 * companyOptionalProtocolActivityMasterData =
		 * FXCollections.observableArrayList(); if(companyProtocolFromEncounter
		 * != null){ companyOptionalProtocolActivityMasterData = new
		 * CompanyOptionalProtocolActivityEntityController().
		 * viewCompanyOptionalProtocolActivityByProtocolId(
		 * companyProtocolFromEncounter.getId()); }
		 * 
		 * optionalActivityTable.setItems(
		 * companyOptionalProtocolActivityMasterData); }else{
		 * System.out.println("RUN@@@@@@@@@@@@ OPTIONAL PROTOCOL ELSE "); }
		 */
	}

	List<Contact> contactAfterDelt = null;

	public void refContactAfterDelete() {
		contactAfterDelt = new ArrayList<Contact>();
		contactAfterDelt = ContactInputController.contactList;
		// ContactInputController.contactList=
		viewContact();

	}

	public void viewContact() {
		System.out.println("RUN CONTACT !!!!!!!!!!!!!!!!");
		contactFullnameCollumn.setCellValueFactory(cellValue -> cellValue.getValue().fullNameProperty());
		contactTypeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().contactTypeProperty());
		// ContactInactiveCollumn.setCellValueFactory(cellValue ->
		// cellValue.getValue());
		ObservableList observableList1 = FXCollections.observableArrayList();

		if (contactAfterDelt != null) {
			observableList1.addAll(contactAfterDelt);
			contactAfterDelt = null;
			contactTable.setItems(observableList1);
		} else {

			if (companyProtocolViewController != null) {
				if (companyProtocolViewController.companyEditController != null) {

					ContactInputController.contactList = new ContactEntityController()
							.viewByCompId(CompanyEditController.company.getId());

				} else if (companyProtocolViewController.encounterFormInputController != null) {
					observableList1 = new ContactEntityController().viewByCompId(Global.patient.getCompany().getId());
					contactTable.setItems(observableList1);
				}
			}
			if (ContactInputController.contactList.size() > 0) {

				/*
				 * for (Contact contact : ContactInputController.contactList) {
				 * 
				 * observableList.add(contact); }
				 */

				observableList1.addAll(ContactInputController.contactList);
				contactTable.setItems(observableList1);

			}

			else if (patientWhiteBoardController != null) {

				ObservableList<Contact> contactMasterData = FXCollections.observableArrayList();
				contactMasterData = new ContactEntityController()
						.viewByCompId(Global.patientVisitObj.getPatient().getCompany().getId());
				contactTable.setItems(contactMasterData);

			} else if (encounterFormInputController != null) {

				ObservableList<Contact> contactMasterData = FXCollections.observableArrayList();
				contactMasterData = new ContactEntityController()
						.viewByCompId(Global.patientVisitObj.getPatient().getCompany().getId());
				contactTable.setItems(contactMasterData);

			} else {

			}
		}
	}

	public CompanyProtocolViewController companyProtocolViewController;
	private Integer selectedIndexOfProtocolTable;

	public void setCompanyProtocolViewController(CompanyProtocolViewController companyProtocolViewController,
			Integer selectedIndexOfProtocolTable) {
		this.companyProtocolViewController = companyProtocolViewController;
		this.selectedIndexOfProtocolTable = selectedIndexOfProtocolTable;
		viewContact();
		viewCompanyStandardProtocolActivity();

		viewCompanyOptionalProtocolActivity();

	}

	public static CompanyProtocol companyProtocol;

	public void setCompanyProtocol(CompanyProtocol companyProtocol) {

		this.companyProtocol = companyProtocol;

		if ("Survillance".equals(companyProtocol.getProtocolType())) {

			survillanceRadio.setSelected(true);

		} else if ("Worker's Comp".equals(companyProtocol.getProtocolType())) {

			workersRadio.setSelected(true);

		}
		descriptionText.setText(companyProtocol.getDescription());

		if (companyProtocol.getVisitCategory() != null) {
			categoryText.setText(companyProtocol.getVisitCategory().getCode());
		}

		if (companyProtocol.getJobClass() != null) {

			jobClassText.setText(companyProtocol.getJobClass().getClassOfJob());
		}
		if (companyProtocol.getDepartmentUnit() != null) {

			deptUnitText.setText(companyProtocol.getDepartmentUnit().getCode());

		}

		userFormText.setText(companyProtocol.getUserFormName());
		// overrideMinSpinnerValue.setValueFactory(companyProtocol.getOverrideminute());
		// value set not done

		amountText.setText(companyProtocol.getAboveAmount());
		phoneNumberText.setText(companyProtocol.getPhoneNumber());
		deptText.setText(companyProtocol.getNameOrDepartment());
		ptotText.setText(companyProtocol.getPtOt());
		referralsText.setText(companyProtocol.getReferrals());

		reportResultText.setText(companyProtocol.getReportResult());
		mailAddress.setText(companyProtocol.getMailAddress());
		city.setText(companyProtocol.getCity());
		state.setText(companyProtocol.getState());
		zip.setText(companyProtocol.getZip());
		phone.setText(companyProtocol.getPhone());
		faxResult.setText(companyProtocol.getFaxResult());
		emailResult.setText(companyProtocol.getEmailResult());

		instructionTextArea.setText(companyProtocol.getInstruction());

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewCompanyStandardProtocolActivity();

		viewCompanyOptionalProtocolActivity();

		viewContact();

		categoryBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				VisitCategoryCodeViewController visitCategoryCodeViewController = (VisitCategoryCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visitCategoryCodeViewController.setCompanyProtocolEditController(this);

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
				jobClassViewController.setCompanyProtocolEditController(this);

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
				departmentUnitViewController.setCompanyProtocolEditController(this);

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
				medicalActivityViewController.setCompanyProtocolEditController(this, standardAddBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standardChangeBtn.setOnAction((event) -> {
			try {
				CompanyStandardProtocolActivity companyStandardProtocolActivity = standardActivityTable
						.getSelectionModel().getSelectedItem();
				Integer standardProtocolTableIndex = standardActivityTable.getSelectionModel().getSelectedIndex();
				// Integer indexofstaticList =
				// CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.indexOf(standardActivityTable.getSelectionModel().getSelectedIndex());

				if (companyStandardProtocolActivity != null) {
					String formName = formPath.context.getMessage("EditCompanyStandardProtocolActivity", null,
							Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditCompanyStandardProtocolActivity", null,
							Locale.US);
					CompanyStandardProtocolActivityEditController editController = (CompanyStandardProtocolActivityEditController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					editController.setCompanyStandardProtocolActivity(companyStandardProtocolActivity,
							standardProtocolTableIndex);
					editController.setCompanyProtocolEditController(this);

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select a record to edit!");

					alert.showAndWait();

				}

				/*
				 * Integer standardProtocolListIndex =
				 * standardActivityTable.getSelectionModel().getSelectedIndex();
				 * Integer indexofstaticList =
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.indexOf(
				 * standardActivityTable.getSelectionModel().getSelectedIndex())
				 * ; CompanyStandardProtocolActivity
				 * companyStandardProtocolActivity =
				 * standardActivityTable.getSelectionModel().getSelectedItem();
				 * 
				 * if(companyStandardProtocolActivity!=null?
				 * companyStandardProtocolActivity.getId()!=null:false){ String
				 * formName = formPath.context.getMessage(
				 * "AddCompanyStandardProtocolActivity", null, Locale.US);
				 * String formTitle = formPath.context.getMessage(
				 * "Title.AddCompanyStandardProtocolActivity", null, Locale.US);
				 * CompanyStandardProtocolActivityInputController editController
				 * = (CompanyStandardProtocolActivityInputController) new
				 * FXFormCommonUtilities().displayForm(formName, formTitle);
				 * editController.setCompanyStandardProtocolActivity(
				 * companyStandardProtocolActivity,standardProtocolListIndex,
				 * indexofstaticList);
				 * editController.setCompanyProtocolEditController(this); } else
				 * { Alert alert = new Alert(AlertType.INFORMATION);
				 * alert.setTitle("Information Dialog");
				 * alert.setHeaderText(null); alert.setContentText(
				 * "Please select a record to edit!");
				 * 
				 * alert.showAndWait();
				 * 
				 * }
				 */

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standardDeleteBtn.setOnAction((event) -> {
			try {
				CompanyStandardProtocolActivity companyStandardProtocolActivity = standardActivityTable
						.getSelectionModel().getSelectedItem();
				if (companyStandardProtocolActivity != null) {
					if (companyStandardProtocolActivity.getId() != 0
							&& companyStandardProtocolActivity.getId() != null) {
						// Integer indexOfStaticStdList =
						// standardActivityTable.getSelectionModel().getSelectedIndex();
						// System.out.println("delete id no
						// "+companyStandardProtocolActivity.getId());

						new CompanyStandardProtocolActivityEntityController()
								.delete(companyStandardProtocolActivity.getId());
						CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList
								.remove(standardActivityTable.getSelectionModel().getSelectedItem());
						observableListStd = new CompanyStandardProtocolActivityEntityController()
								.viewCompanyStandardProtocolActivityByProtocolId(companyProtocol.getId());
						viewCompanyStandardProtocolActivity();

						/*
						 * }if(companyProtocolViewController.
						 * encounterFormInputController!=null){
						 * 
						 * CompanyStandardProtocolActivityInputController.
						 * companyStandardProtocolActivityList=new
						 * CompanyStandardProtocolActivityEntityController().
						 * viewCompanyStandardProtocolActivityByProtocolId(
						 * companyProtocol.getId());
						 * 
						 * 
						 * }
						 */

						// viewStdByProtocolId();

					} else {
						Integer standardProtocolTableIndex = standardActivityTable.getSelectionModel()
								.getSelectedIndex();

						if (standardProtocolTableIndex != -1) {

							CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList
									.remove(standardActivityTable.getSelectionModel().getSelectedItem());
							observableListStd = FXCollections.observableArrayList();
							observableListStd.addAll(
									CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);
							viewCompanyStandardProtocolActivity();
						}

					}

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
				medicalActivityViewController.setCompanyProtocolEditController(this, optionalAddBtn);

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

				if (companyOptionalProtocolActivity != null) {
					String formName = formPath.context.getMessage("EditCompanyOptionalProtocolActivity", null,
							Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditCompanyOptionalProtocolActivity", null,
							Locale.US);
					CompanyOptionalProtocolActivityEditController editController = (CompanyOptionalProtocolActivityEditController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					editController.setCompanyOptionalProtocolActivity(companyOptionalProtocolActivity,
							optionalProtocolTableIndex);
					editController.setCompanyProtocolEditController(this);

				} else {
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
				if (companyOptionalProtocolActivity != null) {
					if (companyOptionalProtocolActivity.getId() != 0
							&& companyOptionalProtocolActivity.getId() != null) {
						// Integer indexOfStaticStdList =
						// standardActivityTable.getSelectionModel().getSelectedIndex();
						// System.out.println("delete id no
						// "+companyStandardProtocolActivity.getId());

						new CompanyOptionalProtocolActivityEntityController()
								.delete(companyOptionalProtocolActivity.getId());
						CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList
								.remove(optionalActivityTable.getSelectionModel().getSelectedItem());
						observableListOpt = new CompanyOptionalProtocolActivityEntityController()
								.viewCompanyOptionalProtocolActivityByProtocolId(companyProtocol.getId());
						viewCompanyOptionalProtocolActivity();

						/*
						 * }if(companyProtocolViewController.
						 * encounterFormInputController!=null){
						 * 
						 * CompanyStandardProtocolActivityInputController.
						 * companyStandardProtocolActivityList=new
						 * CompanyStandardProtocolActivityEntityController().
						 * viewCompanyStandardProtocolActivityByProtocolId(
						 * companyProtocol.getId());
						 * 
						 * 
						 * }
						 */

						// viewStdByProtocolId();

					} else {
						Integer optionalProtocolTableIndex = optionalActivityTable.getSelectionModel()
								.getSelectedIndex();

						if (optionalProtocolTableIndex != -1) {

							CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList
									.remove(optionalActivityTable.getSelectionModel().getSelectedItem());
							observableListOpt = FXCollections.observableArrayList();
							observableListOpt.addAll(
									CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);
							viewCompanyOptionalProtocolActivity();
						}

					}

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*
		 * contactAddBtn.setOnAction((event) -> { try {
		 * 
		 * String formName = formPath.context.getMessage("AddContact", null,
		 * Locale.US); String formTitle =
		 * formPath.context.getMessage("Title.AddContact", null, Locale.US);
		 * formPath.closeApplicationContext(); ContactInputController
		 * contactInputController = (ContactInputController) new
		 * FXFormCommonUtilities().displayForm(formName, formTitle);
		 * contactInputController.setCompanyProtocolEditController(this);
		 * 
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } });
		 * 
		 * contactChangeBtn.setOnAction((event) -> { try { Contact contact =
		 * contactTable.getSelectionModel().getSelectedItem(); Integer
		 * selectedContectIndex =
		 * contactTable.getSelectionModel().getSelectedIndex(); String formName
		 * = formPath.context.getMessage("AddContact", null, Locale.US); String
		 * formTitle = formPath.context.getMessage("Title.AddContact", null,
		 * Locale.US); formPath.closeApplicationContext();
		 * ContactInputController contactInputController =
		 * (ContactInputController) new
		 * FXFormCommonUtilities().displayForm(formName, formTitle);
		 * contactInputController.setCompanyProtocolEditController(this,contact,
		 * selectedContectIndex);
		 * 
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } });
		 */

		contactAddBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactInputController contactInputController = (ContactInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				contactInputController.setCompanyProtocolEditController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		contactChangeBtn.setOnAction((event) -> {
			try {

				// System.out.println("sixe of contact1
				// "+ContactInputController.contactList.size());
				Integer indexOfstaticContactList = ContactInputController.contactList
						.indexOf(contactTable.getSelectionModel().getSelectedItem());
				Integer selectedContectIndex = contactTable.getSelectionModel().getSelectedIndex();

				Contact contact = contactTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditContact", null, Locale.US);
				formPath.closeApplicationContext();
				ContactEditController contactEditController = (ContactEditController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				contactEditController.setCompanyProtocolEditController(this, contact, selectedContectIndex,
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

			if (companyProtocolViewController != null ? companyProtocolViewController.companyEditController != null
					: false) {
				new ContactEntityController().delete(contact.getId());

				// ContactInputController.contactList = new
				// ContactEntityController().viewByCompId(contact.getCompany().getId());
				if (indexOfstaticContactList != -1) {
					ContactInputController.contactList.remove(contactTable.getSelectionModel().getSelectedItem());
					refContactAfterDelete();
				}

			} else if (companyProtocolViewController != null
					? companyProtocolViewController.companyInputController != null : false) {
				Integer indexOfStaticContact = ContactInputController.contactList
						.indexOf(contactTable.getSelectionModel().getSelectedItem());
				if (indexOfStaticContact != -1) {
					ContactInputController.contactList.remove(contactTable.getSelectionModel().getSelectedItem());
					refContactAfterDelete();
				}
			} else if (encounterFormInputController != null) {
				Contact contactEn = contactTable.getSelectionModel().getSelectedItem();
				new ContactEntityController().delete(contactEn.getId());
				viewContact();

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

				CompanyProtocol companyProtocol2 = new CompanyProtocol();
				if (companyProtocol != null) {
					companyProtocol2 = companyProtocol;
				}
				if (companyProtocolFromEncounter != null) {
					companyProtocol2 = companyProtocolFromEncounter;
				}
				companyProtocol2.setProtocolType(protocolType);
				companyProtocol2.setDescription(descriptionText.getText());

				if (categoryText.getText().length() > 0) {
					// VisitCategory visitCategory = new
					// VisitCategoryEntityController().viewByCode(categoryText.getText());
					if (visitCategory != null) {
						companyProtocol2.setVisitCategory(visitCategory);
					} else if (companyProtocol1 != null) {

						companyProtocol2.setVisitCategory(companyProtocol1.getVisitCategory());
					} else if (companyProtocol != null) {
						companyProtocol2.setVisitCategory(companyProtocol.getVisitCategory());

					}
				}

				if (jobClass != null) {

					// JobClass jobClass = new
					// JobClassEntityController().viewByCode(jobClassText.getText());

					companyProtocol2.setJobClass(jobClass);
				}

				if (departmentUnit != null) {

					// DepartmentUnit departmentUnit = new
					// DepartmentUnitEntityController().viewByCode(deptUnitText.getText());
					companyProtocol2.setDepartmentUnit(departmentUnit);
				}

				companyProtocol2.setUserFormName(userFormText.getText());
				companyProtocol2.setOverrideminute(overrideMinSpinnerValue.getValue());

				companyProtocol2.setAboveAmount(amountText.getText());
				companyProtocol2.setPhoneNumber(phoneNumberText.getText());
				companyProtocol2.setNameOrDepartment(deptText.getText());
				companyProtocol2.setPtOt(ptotText.getText());
				companyProtocol2.setReferrals(referralsText.getText());

				companyProtocol2.setReportResult(reportResultText.getText());
				companyProtocol2.setMailAddress(mailAddress.getText());
				companyProtocol2.setCity(city.getText());
				companyProtocol2.setState(state.getText());
				companyProtocol2.setZip(zip.getText());
				companyProtocol2.setPhone(phone.getText());
				companyProtocol2.setFaxResult(faxResult.getText());
				companyProtocol2.setEmailResult(emailResult.getText());

				companyProtocol2.setInstruction(instructionTextArea.getText());

				/*
				 * companyProtocol2.setStandardProtocolActivity(
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList);
				 * companyProtocol2.setOptionalProtocolActivity(
				 * CompanyOptionalProtocolActivityInputController.
				 * companyOptionalProtocolActivityList);
				 */// companyProtocol.setStandardProtocolActivity(standardProtocolActivity);

				// CompanyProtocolInputController.companyProtocolList.add(companyProtocol);
				// **CompanyProtocolInputController.companyProtocolList.set(CompanyProtocolViewController.companyProtocolListIndex,
				// companyProtocol2);

				if (companyProtocol != null) {
					if (companyProtocol.getId() != null && companyProtocol.getId() != 0) {
						companyProtocol2.setId(companyProtocol.getId());
						companyProtocol2.setCompany(companyProtocol.getCompany());
						new CompanyProtocolEntityController().saveCompanyProtocol(companyProtocol2);

						for (CompanyStandardProtocolActivity companyStandardProtocolActivity : CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList) {
							companyStandardProtocolActivity.setCompanyProtocol(companyProtocol2);

							new CompanyStandardProtocolActivityEntityController()
									.saveCompanyStandardProtocolActivity(companyStandardProtocolActivity);
						}

						for (CompanyOptionalProtocolActivity companyOptionalProtocolActivity : CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList) {

							companyOptionalProtocolActivity.setCompanyProtocol(companyProtocol2);

							new CompanyOptionalProtocolActivityEntityController()
									.saveCompanyOptionalProtocolActivity(companyOptionalProtocolActivity);
						}

					} else {

						CompanyProtocolInputController.companyProtocolListIndexing.set(selectedIndexOfProtocolTable,
								companyProtocol2);
						CompanyProtocolViewController.listOfcompanyStandardProtocolActivityList.set(
								selectedIndexOfProtocolTable,
								CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);
						CompanyProtocolViewController.listOfCompanyOptionalProtocolActivityList.set(
								selectedIndexOfProtocolTable,
								CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);
					}

					if (encounterFormInputController == null&& patientWhiteBoardController==null) {
						companyProtocolViewController.viewCompanyProtocol();
						CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList = new ArrayList<CompanyStandardProtocolActivity>();
						CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList = new ArrayList<CompanyOptionalProtocolActivity>();
					}

				}

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
