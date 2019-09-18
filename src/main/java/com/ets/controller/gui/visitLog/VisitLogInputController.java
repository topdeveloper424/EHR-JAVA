package com.ets.controller.gui.visitLog;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 29-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitLogInputController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
*/

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.format.datetime.joda.LocalDateParser;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;

import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.appointment.PatientAppointmentViewController;

import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.controller.gui.icd10Diagonosis.ICD10DiagonosisInputController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.billingAccounts.BillingAccountViewController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.controller.gui.patientVisitByPatient.VisitByPatientViewController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.controller.gui.referalProvider.ReferalProviderViewController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeViewController;
import com.ets.controller.gui.whiteBoardController.PatientWhiteBoardController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.model.Clinician;
import com.ets.model.Company;
import com.ets.model.Icd10Codes;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;
import com.ets.model.Provider;
import com.ets.model.ReferalProvider;
import com.ets.model.VisitCategory;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.FilterDuplicatesObjectProperty;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VisitLogInputController implements Initializable {

	@FXML
	private ChoiceBox<String> visitTypeChoiceBox;

	@FXML
	private DatePicker visitDate;

	@FXML
	private TextField categoryText;

	@FXML
	private TextField purposeText;

	@FXML
	private ChoiceBox<String> typeChoiceBox;

	@FXML
	private ChoiceBox<String> meansOfArrivalChoiceBox;

	@FXML
	private TextField providerText;

	@FXML
	private TextField clinicianText;

	@FXML
	private TextArea summaryText;

	@FXML
	private RadioButton pendingResultRadioBtn;

	@FXML
	private ToggleGroup visitStatus;

	@FXML
	private RadioButton completedRadioBtn;

	@FXML
	private RadioButton walkOutRadioBtn;

	@FXML
	private TextField arrivalTimeText;

	@FXML
	private TextField startTimeText;

	@FXML
	private TextField complectionTimeText;

	@FXML
	private TextField providerInTimeText;

	@FXML
	private TextField providerOutTime;

	@FXML
	private TextField billingPhysiciansText;

	@FXML
	private TextField referredByText;

	@FXML
	private Button visitCategoryBtn;

	@FXML
	private Button providerBtn;

	@FXML
	private Button clinicianBtn;

	@FXML
	private TextArea alertNoteText;

	@FXML
	private Label clinicianLabelText;

	@FXML
	private Label providerNameLabel;

	@FXML
	private Button billingPhysiciansBtn;

	@FXML
	private Button referredByBtn;

	@FXML
	private Tab billingTabId;

	@FXML
	private Tab medicalTabId;

	@FXML
	private Button chargesBtn;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button emrChartingBtn;

	@FXML
	private Button companyBtn;

	@FXML
	private Button assignedDiagonosisBtn;

	@FXML
	private Button noAssignedBtn;
	/*
	 * @FXML private TextField icd10Text;
	 */
	@FXML
	private TextField payerAccountText;

	/*
	 * @FXML private Button icd10Btn;
	 */

	@FXML
	private Button startTimeBtn;

	@FXML
	private Button arrivalTimeBtn;

	@FXML
	private Button completionTimeBtn;

	@FXML
	private Button providerInTimeBtn;

	@FXML
	private Button providerOutTimeBtn;

	@FXML
	private Button demographicsBtn;

	@FXML
	private Button encounterBtn;

	@FXML
	private Button payerAccountBtn;

	@FXML
	private TableView<Icd10Codes> icd10Table;

	@FXML
	private TableColumn<Icd10Codes, String> MedicalICDColCode;

	@FXML
	private TableColumn<Icd10Codes, String> MedicalICDColDescrip;

	private Company selectedCompany;

	public void getCompany(Company company) {
		this.selectedCompany = company;

	}

	/*
	 * this.icd10CodesList = ICD10DiagonosisInputController.icd10CodesList;
	 */
	private VisitByPatientViewController visitByPatientViewControllerAdd;
	private PatientVisit holdPatientVisit;

	public void addNewVisit(VisitByPatientViewController visitByPatientViewController) {
		this.visitByPatientViewControllerAdd = visitByPatientViewController;
		holdPatientVisit = Global.patientVisitObj;
		Global.patientVisitObj = null;
		Global.patientVisitObj = new PatientVisit();

		ICD10DiagonosisInputController.icd10CodesList = null;
		ICD10DiagonosisInputController.icd10CodesList = new ArrayList<Icd10Codes>();
		System.out.println("after " + ICD10DiagonosisInputController.icd10CodesList.size());
	}

	private PatientAppointmentViewController patientAppointmentViewController;

	public void setPatientAppointmentViewController(PatientAppointmentViewController patientAppointmentViewController) {
		this.patientAppointmentViewController = patientAppointmentViewController;
	}

	private PatientAppointment patientAppointment;

	public void setPatientAppointment(PatientAppointment patientAppointment) {
		this.patientAppointment = patientAppointment;

		visitTypeChoiceBox.setValue(patientAppointment.getType());
		Global.patientVisitObj = new PatientVisit();

		if (patientAppointment.getVisitCatId() != null) {
			categoryText.setText(patientAppointment.getVisitCatId().getCode());
			Global.patientVisitObj.setVisitCategory(patientAppointment.getVisitCatId());
		}
		purposeText.setText(patientAppointment.getPurpose());

		if (patientAppointment.getProvider() != null) {
			providerText.setText(patientAppointment.getProvider().getCode());
			Global.patientVisitObj.setProvider(patientAppointment.getProvider());
		}
		if (patientAppointment.getClinician() != null) {
			clinicianText.setText(patientAppointment.getClinician().getCode());
			Global.patientVisitObj.setClinician(patientAppointment.getClinician());
		}
		if (patientAppointment.getReferredBy() != null) {
			referredByText.setText(patientAppointment.getReferredBy().getCode());
			Global.patientVisitObj.setReferredBy(patientAppointment.getReferredBy());
		}
		LocalDate dt = new DateConvert().dateToLocalDate(patientAppointment.getApptDate());
		visitDate.setValue(dt);

	}

	public MedicalActivityChargeViewController medicalActivityChargeViewController;

	public void setMedicalActivityChargeViewController(
			MedicalActivityChargeViewController medicalActivityChargeViewController) {
		this.medicalActivityChargeViewController = medicalActivityChargeViewController;
	}

	public String visitType = null;

	private AppointmentController appointmentController;
	private ObservableList<PatientAppointment> appointmentList;

	private Patient patientFromApp = null;

	ObservableList<Icd10Codes> icd10CodesListVisit = FXCollections.observableArrayList();

	public void populateTableICD10Table() {

		if (Global.patientVisitObj != null ? Global.patientVisitObj.getIcd10Codes() != null : false) {

			icd10CodesListVisit = FXCollections.observableArrayList();
			icd10CodesListVisit.addAll(Global.patientVisitObj.getIcd10Codes());
		}
		if (ICD10DiagonosisInputController.icd10CodesList != null) {
			if (ICD10DiagonosisInputController.icd10CodesList.size() > 0) {
				System.out.println("##########2 " + ICD10DiagonosisInputController.icd10CodesList.size());
				// handle error bcoz of same icd adding
				// int icdId =-1;//0 may be primary key
				// int sizeIcd =
				// ICD10DiagonosisInputController.icd10CodesList.size();
				List<Icd10Codes> uniqueIcdList = null;
				uniqueIcdList = ICD10DiagonosisInputController.icd10CodesList.stream()
						.filter(FilterDuplicatesObjectProperty.distinctByKey(p -> p.getId()))
						.collect(Collectors.toList());
				ICD10DiagonosisInputController.icd10CodesList = uniqueIcdList;

				/*
				 * for(int i=0;i<sizeIcd;i++){
				 * 
				 * for(int j=1;j<sizeIcd;j++){
				 * 
				 * if(ICD10DiagonosisInputController.icd10CodesList.get(j).getId
				 * ()==ICD10DiagonosisInputController.icd10CodesList.get(i).
				 * getId()&i!=j){
				 * ICD10DiagonosisInputController.icd10CodesList.remove(i);
				 * sizeIcd =
				 * ICD10DiagonosisInputController.icd10CodesList.size();
				 * System.out.println("removed _____ "
				 * +ICD10DiagonosisInputController.icd10CodesList.get(i).getId()
				 * +"## "+i); } }
				 * 
				 * 
				 * }
				 */

				icd10CodesListVisit = FXCollections.observableArrayList();
				icd10CodesListVisit.addAll(ICD10DiagonosisInputController.icd10CodesList);

			}
		}
		// icd10CodesListVisit.add(ICD10DiagonosisInputController.icd10CodesList);

		if (icd10CodesListVisit.size() > 0) {
			MedicalICDColCode.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
			MedicalICDColDescrip.setCellValueFactory(cellData -> cellData.getValue().descripProperty());

			icd10Table.setItems(icd10CodesListVisit);
		}

		// MedicalICDColCode.setCellValueFactory(cellData ->
		// cellData.getValue().codeProperty());
		// MedicalICDColDescrip.setCellValueFactory(cellData ->
		// cellData.getValue().descripProperty());
		//
		// icd10Table.setItems(Global.patientVisitObj);

	}

	public void setAppointmentController(AppointmentController appointmentController,
			ObservableList<PatientAppointment> appointmentList) {

		this.appointmentController = appointmentController;
		this.appointmentList = appointmentList;

		for (PatientAppointment patientAppointment : appointmentList) {
			patientFromApp = patientAppointment.getPatient();
			System.out.println("from visitLog object" + patientAppointment.getApptTime() + " "
					+ patientAppointment.getProvider().getFirstName());
			if (patientAppointment.getVisitCatId() != null) {
				categoryText.setText(patientAppointment.getVisitCatId().getCode());

			}
			purposeText.setText(patientAppointment.getPurpose());
			visitTypeChoiceBox.setValue(patientAppointment.getType());

			if (patientAppointment.getProvider() != null) {
				providerText.setText(patientAppointment.getProvider().getCode());
				if (patientAppointment.getProvider() != null) {
					providerText.setText(patientAppointment.getProvider().getCode());
					providerNameLabel.setText(patientAppointment.getProvider().getFirstName() + " "
							+ patientAppointment.getProvider().getLastName());

				}

				if (patientAppointment.getClinician() != null) {
					clinicianText.setText(patientAppointment.getClinician().getCode());
					clinicianLabelText.setText(patientAppointment.getClinician().getFirstName() + " "
							+ patientAppointment.getClinician().getLastName());
				}

				if (patientAppointment.getReferredBy() != null) {
					referredByText.setText(patientAppointment.getReferredBy().getCode());
				}

				DateConvert dateConvert = new DateConvert();
				LocalDate localDate = dateConvert.dateToLocalDate(patientAppointment.getApptDate());
				visitDate.setValue(localDate);

			}
		}

	}

	private PatientViewController patientViewController;
	private VisitCategory visitCat;

	public void setPatientViewController(PatientViewController patientViewController) {
		this.patientViewController = patientViewController;
	}

	public void setVisitCategory(VisitCategory visitCategory) {

		categoryText.setText(visitCategory.getCode());
		this.visitCat = visitCategory;
	}

	public void setPurpose(String purpose) {

		purposeText.setText(purpose);
	}

	private Provider providerSelected;

	public void setProvider(Provider provider) {

		providerText.setText(provider.getCode());
		this.providerSelected = provider;
	}

	public void setProviderName(String name) {

		providerNameLabel.setText(name);

	}

	private Provider billProvider;

	public void setBillingPhysicians(Provider billProvider) {
		this.billProvider = billProvider;
		billingPhysiciansText.setText(billProvider.getCode());

	}

	private ReferalProvider refProvider;

	public void setReferralProvider(ReferalProvider referalProvider) {
		this.refProvider = referalProvider;

		referredByText.setText(refProvider.getCode());

	}

	private Clinician clinician;

	public void setClinician(Clinician clinician) {
		this.clinician = clinician;
		clinicianText.setText(clinician.getCode());
	}

	public void setClinicianName(String name) {

		clinicianLabelText.setText(name);
	}

	public void setPatientWhiteBoardController() {

		if (Global.patientVisitObj.getIcd10Codes().size() > 0) {

			populateTableICD10Table();
		}
		visitTypeChoiceBox.setValue(Global.patientVisitObj.getVisitType());
		typeChoiceBox.setValue(Global.patientVisitObj.getType());
		complectionTimeText.setText(Global.patientVisitObj.getCompletionTime());
		arrivalTimeText.setText(Global.patientVisitObj.getArrivalTime());
		startTimeText.setText(Global.patientVisitObj.getStartTime());

		providerInTimeText.setText(Global.patientVisitObj.getProviderTimeIn());
		providerOutTime.setText(Global.patientVisitObj.getProviderTimeOut());

		if (Global.patientVisitObj.getVisitCategory() != null) {
			categoryText.setText(Global.patientVisitObj.getVisitCategory().getCode());
		}

		purposeText.setText(Global.patientVisitObj.getPurpose());
		if (Global.patientVisitObj.getProvider() != null) {
			providerText.setText(Global.patientVisitObj.getProvider().getCode());
		}
		meansOfArrivalChoiceBox.setValue(Global.patientVisitObj.getMeansOfArrival());
		// typeChoiceBox.setValue(patientVisitObj.getT);
		if (Global.patientVisitObj.getBillingPsysician() != null) {
			billingPhysiciansText.setText(Global.patientVisitObj.getBillingPsysician().getCode());
		}
		if (Global.patientVisitObj.getClinician() != null) {
			clinicianText.setText(Global.patientVisitObj.getClinician().getCode());
		}
		if (Global.patientVisitObj.getReferredBy() != null) {
			referredByText.setText(Global.patientVisitObj.getReferredBy().getCode());
		}

		if (Global.patientVisitObj.getVisitStatus() != null) {
			if (Global.patientVisitObj.getVisitStatus().equals("Pending Results")) {
				pendingResultRadioBtn.setSelected(true);
				System.out.println("9999999999999999999999999999999999999999");
			} else if (Global.patientVisitObj.getVisitStatus().equals("Completed")) {
				completedRadioBtn.setSelected(true);
			} else if (Global.patientVisitObj.getVisitStatus().equals("Walk-out")) {
				walkOutRadioBtn.setSelected(true);
			}
		}
		summaryText.setText(Global.patientVisitObj.getSummary());
		alertNoteText.setText(Global.patientVisitObj.getAlertNotes());

	}

	private VisitLogSelectController visitLogSelectController;

	public void setVisitLogSelectController(VisitLogSelectController visitLogSelectController) {
		this.visitLogSelectController = visitLogSelectController;
		Global.patientVisitObj = new PatientVisit();
		LocalDate dt = new DateConvert().dateToLocalDate(new Date());
		visitDate.setValue(dt);
		if (Global.patient.getPreferredProvider() != null) {
			providerText.setText(Global.patient.getPreferredProvider().getCode());
			Global.patientVisitObj.setProvider(Global.patient.getPreferredProvider());
		}
		
	}

	public void setVisitLogSelectController(VisitLogSelectController visitLogSelectController,
			PatientAppointment patientAppointment) {
		this.visitLogSelectController = visitLogSelectController;
		this.patientAppointment = patientAppointment;
		visitTypeChoiceBox.setValue(patientAppointment.getType());
		Global.patientVisitObj = new PatientVisit();

		if (patientAppointment.getVisitCatId() != null) {
			categoryText.setText(patientAppointment.getVisitCatId().getCode());
			Global.patientVisitObj.setVisitCategory(patientAppointment.getVisitCatId());
		}
		purposeText.setText(patientAppointment.getPurpose());

		if (patientAppointment.getProvider() != null) {
			providerText.setText(patientAppointment.getProvider().getCode());
			Global.patientVisitObj.setProvider(patientAppointment.getProvider());
		}
		if (patientAppointment.getClinician() != null) {
			clinicianText.setText(patientAppointment.getClinician().getCode());
			Global.patientVisitObj.setClinician(patientAppointment.getClinician());
		}
		if (patientAppointment.getReferredBy() != null) {
			referredByText.setText(patientAppointment.getReferredBy().getCode());
			Global.patientVisitObj.setReferredBy(patientAppointment.getReferredBy());
		}

		LocalDate dt = new DateConvert().dateToLocalDate(new Date());
		visitDate.setValue(dt);

	}

	private VisitByPatientViewController visitByPatientViewController;

	public void setVisitByPatientViewController(VisitByPatientViewController visitByPatientViewController) {
		this.visitByPatientViewController = visitByPatientViewController;
	}

	public void setVisitByPatientViewController(VisitByPatientViewController visitByPatientViewController,
			PatientVisit patientVisitObj) {
		this.visitByPatientViewController = visitByPatientViewController;
		Global.patientVisitObj = patientVisitObj;
		if (patientVisitObj.getIcd10Codes().size() > 0) {

			populateTableICD10Table();
		}
		visitTypeChoiceBox.setValue(patientVisitObj.getVisitType());
		typeChoiceBox.setValue(patientVisitObj.getType());
		complectionTimeText.setText(patientVisitObj.getCompletionTime());
		arrivalTimeText.setText(patientVisitObj.getArrivalTime());
		startTimeText.setText(patientVisitObj.getStartTime());

		providerInTimeText.setText(patientVisitObj.getProviderTimeIn());
		providerOutTime.setText(patientVisitObj.getProviderTimeOut());

		if (patientVisitObj.getVisitCategory() != null) {
			categoryText.setText(patientVisitObj.getVisitCategory().getCode());
		}

		purposeText.setText(patientVisitObj.getPurpose());
		if (patientVisitObj.getProvider() != null) {
			providerText.setText(patientVisitObj.getProvider().getCode());
		}
		meansOfArrivalChoiceBox.setValue(patientVisitObj.getMeansOfArrival());
		// typeChoiceBox.setValue(patientVisitObj.getT);
		if (patientVisitObj.getBillingPsysician() != null) {
			billingPhysiciansText.setText(patientVisitObj.getBillingPsysician().getCode());
		}
		if (patientVisitObj.getClinician() != null) {
			clinicianText.setText(patientVisitObj.getClinician().getCode());
		}
		if (patientVisitObj.getReferredBy() != null) {
			referredByText.setText(patientVisitObj.getReferredBy().getCode());
		}

		if (patientVisitObj.getVisitStatus() != null) {
			if (patientVisitObj.getVisitStatus().equals("Pending Results")) {
				pendingResultRadioBtn.setSelected(true);
				System.out.println("11111111111111111111111111111111111");
			} else if (patientVisitObj.getVisitStatus().equals("Completed")) {
				completedRadioBtn.setSelected(true);
			} else if (patientVisitObj.getVisitStatus().equals("Walk-out")) {
				walkOutRadioBtn.setSelected(true);
			}
		}
		summaryText.setText(patientVisitObj.getSummary());
		alertNoteText.setText(patientVisitObj.getAlertNotes());
		// summaryText.setText(patientVisitObj.getPatien);
	}

	/*
	 * public void setICD10(Integer id){
	 * icd10Text.setText(Integer.toString(id));
	 * icd10Text.setId(Integer.toString(id));
	 * 
	 * 
	 * }
	 */

	public void setBillingAccount(String billingAccount) {
		payerAccountText.setText(billingAccount);

	}

	public void setPatientInitialInfo() {

		if (Global.patient.getPreferredProvider() != null) {

			providerText.setText(Global.patient.getPreferredProvider().getCode());

			providerNameLabel.setText(Global.patient.getPreferredProvider().getLastName() + " "
					+ Global.patient.getPreferredProvider().getLastName());
		}

		Date date = null;
		if (Global.patientVisitObj != null) {

			date = Global.patientVisitObj.getVisitDate();

		} else {
			date = new Date();
		}

		if (date != null) {

			LocalDate localDate = new DateConvert().dateToLocalDate(date);

			visitDate.setValue(localDate);

		}

		/*
		 * Calendar cal = Calendar.getInstance(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("HH:mm: a");
		 * 
		 * startTimeText.setText(sdf.format(cal.getTime()));
		 */

	}

	public void showEMRchartingButton() {

		emrChartingBtn.setVisible(true);
	}

	public void hideEMRchartingButton() {

		emrChartingBtn.setVisible(false);
	}

	private PatientVisit patientVisit2;

	public void setPatientVisit2(PatientVisit patientVisit2) {
		this.patientVisit2 = patientVisit2;
		Global.patientVisitObj = patientVisit2;
		System.out.println("2222222222222222222222222222222222"+patientVisit2.getVisitStatus());
		/*
		 * visitTypeChoiceBox.setValue(patientVisit2.getVisitType());
		 * complectionTimeText.setText(patientVisit2.getCompletionTime());
		 * arrivalTimeText.setText(patientVisit2.getArrivalTime());
		 * startTimeText.setText(patientVisit2.getStartTime());
		 * 
		 * providerInTimeText.setText(patientVisit2.getProviderTimeIn());
		 * providerOutTime.setText(patientVisit2.getProviderTimeOut());
		 * 
		 * if(patientVisit2.getVisitCategory() != null){
		 * categoryText.setText(patientVisit2.getVisitCategory().getCode()); }
		 * 
		 * purposeText.setText(patientVisit2.getPurpose());
		 * 
		 * providerText.setText(patientVisit2.getProvider().getCode());
		 */

		if (patientVisit2.getIcd10Codes().size() > 0) {
			populateTableICD10Table();

		}

		visitTypeChoiceBox.setValue(patientVisit2.getVisitType());
		typeChoiceBox.setValue(patientVisit2.getType());
		complectionTimeText.setText(patientVisit2.getCompletionTime());
		arrivalTimeText.setText(patientVisit2.getArrivalTime());
		startTimeText.setText(patientVisit2.getStartTime());

		providerInTimeText.setText(patientVisit2.getProviderTimeIn());
		providerOutTime.setText(patientVisit2.getProviderTimeOut());

		if (patientVisit2.getVisitCategory() != null) {
			categoryText.setText(patientVisit2.getVisitCategory().getCode());
		}

		purposeText.setText(patientVisit2.getPurpose());
		if (patientVisit2.getProvider() != null) {
			providerText.setText(patientVisit2.getProvider().getCode());
		}
		meansOfArrivalChoiceBox.setValue(patientVisit2.getMeansOfArrival());
		// typeChoiceBox.setValue(patientVisitObj.getT);
		if (patientVisit2.getBillingPsysician() != null) {
			billingPhysiciansText.setText(patientVisit2.getBillingPsysician().getCode());
		}
		if (patientVisit2.getClinician() != null) {
			clinicianText.setText(patientVisit2.getClinician().getCode());
		}
		if (patientVisit2.getReferredBy() != null) {
			referredByText.setText(patientVisit2.getReferredBy().getCode());
		}

		if (patientVisit2.getVisitStatus() != null) {
			System.out.println("hello");
			if (patientVisit2.getVisitStatus().equals("Pending Results")) {
				pendingResultRadioBtn.setSelected(true);
				
			} else if (patientVisit2.getVisitStatus().equals("Completed")) {
				completedRadioBtn.setSelected(true);
				System.out.println("777777777777777777777777777777777777777777777");
				/*patientVisit2.setWaitingRoom(false);
				patientVisit2.setCheckOut(false);
				patientVisit2.setExamRoom1(false);
				patientVisit2.setExamRoom2(false);
				patientVisit2.setExamRoom7(false);
				patientVisit2.setEyeRoom(false);
				patientVisit2.setLab(false);
				patientVisit2.setPhysicalRoom(false);
				patientVisit2.setHcg(false);
				patientVisit2.setLacerationRoom(false);
				patientVisit2.setXRay(false);*/
				
			} else if (patientVisit2.getVisitStatus().equals("Walk-out")) {
				walkOutRadioBtn.setSelected(true);
			}
		}
		summaryText.setText(patientVisit2.getSummary());
		alertNoteText.setText(patientVisit2.getAlertNotes());

	}

	public void setPatientVisitObj() {

		String visitStatus = null;

		if (pendingResultRadioBtn.isSelected()) {

			visitStatus = "Pending Results";
			System.out.println("333333333333333333333333333");
		} else if (completedRadioBtn.isSelected()) {

			visitStatus = "Completed";
			System.out.println("00000000000000000000000000000000000000000");
			

		} else if (walkOutRadioBtn.isSelected()) {

			visitStatus = "Walk-out";
		}

		// PatientVisit patientVisit = new PatientVisit();

		if (patientVisit2 != null) {
			Global.patientVisitObj.setId(patientVisit2.getId());
		}

		Global.patientVisitObj.setAlertNotes(alertNoteText.getText());

		Global.patientVisitObj.setArrivalTime(arrivalTimeText.getText());
		Global.patientVisitObj.setWaitingRoom(true);
		Global.patientVisitObj.setExamRoom1(false);
		Global.patientVisitObj.setExamRoom2(false);
		Global.patientVisitObj.setCheckOut(false);
		Global.patientVisitObj.setExamRoom7(false);
		Global.patientVisitObj.setEyeRoom(false);
		Global.patientVisitObj.setHcg(false);
		Global.patientVisitObj.setLab(false);
		Global.patientVisitObj.setXRay(false);
		Global.patientVisitObj.setPhysicalRoom(false);
		Global.patientVisitObj.setLacerationRoom(false);

		if (billingPhysiciansText.getText().isEmpty()) {

		} else {

			// Provider provider = new
			// ProviderEntityController().viewById(Integer.parseInt(billingPhysiciansText.getText()));
			// Provider provider = new
			// ProviderEntityController().viewByCode((billingPhysiciansText.getText()));
			if (billProvider != null) {
				Global.patientVisitObj.setBillingPsysician(billProvider);
			}
		}

		// patientVisit.setBillingAccount(billingAccount);

		if (clinicianText.getText()!=null||clinicianText.getText()!="") {

		} else {

			// Clinician clinician = new
			// ClinicianEntityController().viewByCode(clinicianText.getText());
			if (clinician != null) {
				Global.patientVisitObj.setClinician(clinician);
			}

		}

		Global.patientVisitObj.setCompletionTime(complectionTimeText.getText());

		Global.patientVisitObj.setMeansOfArrival(meansOfArrivalChoiceBox.getSelectionModel().getSelectedItem());
		// patientVisit.setOverridePayer(overridePayer);
		// patientVisit.setProtocolInstruction(protocolInstruction);

		if (providerText.getText().isEmpty()) {

		} else {

			// Provider provider = new
			// ProviderEntityController().viewByCode(providerText.getText());
			if (providerSelected != null) {
				Global.patientVisitObj.setProvider(providerSelected);
			}
		}
		if (patientFromApp == null) {
			Patient patient = new PatientEntityController().getById(Global.patient.getId());
			Global.patientVisitObj.setPatient(patient);
		} else {
			Global.patientVisitObj.setPatient(patientFromApp);
		}
		Global.patientVisitObj.setProviderTimeIn(providerInTimeText.getText());
		Global.patientVisitObj.setProviderTimeOut(providerOutTime.getText());
		Global.patientVisitObj.setPurpose(purposeText.getText());

		if (referredByText.getText().isEmpty()) {

		} else {

			/*
			 * fbb ReferalProvider referalProvider = new
			 * ReferalProviderEntityController().viewById(Integer.parseInt(
			 * referredByText.getText()));
			 */
			if (refProvider != null) {
				Global.patientVisitObj.setReferredBy(refProvider);
			}

		}

		Global.patientVisitObj.setStartTime(startTimeText.getText());
		Global.patientVisitObj.setSummary(summaryText.getText());

		if (categoryText.getText().isEmpty()) {

		} else {

			// VisitCategory visitCategory = new
			// VisitCategoryEntityController().viewByCode(categoryText.getText());
			if (visitCat != null) {
				Global.patientVisitObj.setVisitCategory(visitCat);
			}
		}

		/*
		 * if(icd10Text.getText().isEmpty()){
		 * 
		 * }else{
		 * 
		 * //VisitCategory visitCategory = new
		 * VisitCategoryEntityController().viewByCode(categoryText.getText());
		 * //patientVisit.setVisitCategory(visitCategory);
		 * 
		 * Icd10Codes icd10Codes = new
		 * Icd10CodesEntityController().viewICD10CodeId(Integer.parseInt(
		 * icd10Text.getText())); patientVisit.setIcd10Codes(icd10Codes);
		 * 
		 * }
		 */

		LocalDate localDate2 = visitDate.getValue();
		if (localDate2 != null) {

			Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

			Global.patientVisitObj.setVisitDate(date2);

		}

		// patientVisit.setVisitLocation(visitLocation);
		Global.patientVisitObj.setVisitStatus(visitStatus);

		Global.patientVisitObj.setVisitType(visitTypeChoiceBox.getSelectionModel().getSelectedItem());

		if (ICD10DiagonosisInputController.icd10CodesList != null) {
			if (ICD10DiagonosisInputController.icd10CodesList.size() > 0) {
				Global.patientVisitObj.setIcd10Codes(ICD10DiagonosisInputController.icd10CodesList);

			}
		}

		// patientVisit.getIcd10Codes().addAll(ICD10DiagonosisInputController.icd10CodesList);
		/* patvisit.add(patientVisit); */

		if (visitTypeChoiceBox.getSelectionModel().getSelectedItem() != null) {

			new PatientVisitEntityController().saveOrUpdate(Global.patientVisitObj);
			Global.patientVisitObj = Global.patientVisitObj;

			/*
			 * if(AppointmentController.flag==1){
			 * appointmentController.reFresh();
			 * appointmentController.refreshCol2(); }
			 */
			AppointmentController.flag = 0;

			// For View MedicalActivityCharge Result

			LocalDate localDate4 = visitDate.getValue();
			Date date4 = null;
			if (localDate4 != null) {

				date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());

			}
			/*
			 * ############ changed ############# List<MedicalActivityCharge>
			 * searchListSize=new ArrayList<MedicalActivityCharge>();
			 * searchListSize= new MedicalActivityChargeEntityController().
			 * searchByDatePatientBillingStatus(date4); System.out.println(
			 * "List Size is : " +searchListSize.size());
			 * 
			 * for(MedicalActivityCharge medicalActivityCharge2
			 * :searchListSize){
			 * 
			 * medicalActivityCharge2.setPatientVisit(Global.patientVisitObj);
			 * new MedicalActivityChargeEntityController().saveOrUpdate(
			 * medicalActivityCharge2); }
			 */

			// Global.patientVisitObj = patientVisit;
			// new FXFormCommonUtilities().closeForm(okButton);

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	// PatientVisit patientVisit = new PatientVisit();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		populateTableICD10Table();

		hideEMRchartingButton();

		if (AppointmentController.flag == 0) {

			setPatientInitialInfo();

		}

		chargesBtn.setVisible(true);

		List<String> list1 = new ArrayList<String>();
		list1.add("Private Practice");
		list1.add("Worker's Comp");
		list1.add("Employer Services");
		ObservableList obList1 = FXCollections.observableList(list1);
		visitTypeChoiceBox.setItems(obList1);

		List<String> list2 = new ArrayList<String>();
		list2.add("In-House");
		list2.add("On-Site");
		list2.add("Referral");
		list2.add("Telephone");
		list2.add("Other");
		list2.add("No Visit");
		ObservableList obList2 = FXCollections.observableList(list2);
		typeChoiceBox.setItems(obList2);

		List<String> list3 = new ArrayList<String>();
		list3.add("Ambulance");
		list3.add("Automobile");
		list3.add("Other");
		ObservableList obList3 = FXCollections.observableList(list3);
		meansOfArrivalChoiceBox.setItems(obList3);

		/*
		 * icd10Btn.setOnAction((event) -> {
		 * 
		 * try { String formName = formPath.context.getMessage("ICD10", null,
		 * Locale.US); String formTitle =
		 * formPath.context.getMessage("Title.ICD10", null, Locale.US);
		 * formPath.closeApplicationContext(); ICD10ViewController
		 * iCD10ViewController = (ICD10ViewController) new
		 * FXFormCommonUtilities().displayForm(formName, formTitle);
		 * iCD10ViewController.setVisitLogInputController(this);
		 * 
		 * 
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } });
		 */

		encounterBtn.setOnAction((event) -> {

			try {
				chargesBtn.setVisible(true);
				setPatientVisitObj();
				String formName = formPath.context.getMessage("EncounterForm", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EncounterForm", null, Locale.US);
				formPath.closeApplicationContext();

				EncounterFormInputController encounterFormInputController = (EncounterFormInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				encounterFormInputController.setVisitLogInputController(this, Global.patientVisitObj);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		visitCategoryBtn.setOnAction((event) -> {

			try {

				chargesBtn.setVisible(true);
				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				VisitCategoryCodeViewController visitCategoryCodeViewController = (VisitCategoryCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				visitCategoryCodeViewController.setVisitLogInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		assignedDiagonosisBtn.setOnAction((event) -> {
			try {
				chargesBtn.setVisible(true);
				String formName = formPath.context.getMessage("ICD-10Diagnosis", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD-10Diagnosis", null, Locale.US);
				formPath.closeApplicationContext();

				ICD10DiagonosisInputController icd10viewController = (ICD10DiagonosisInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				icd10viewController.setVisitLogInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		referredByBtn.setOnAction((event) -> {
			try {
				chargesBtn.setVisible(true);
				String formName = formPath.context.getMessage("ReferalProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ReferalProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ReferalProviderViewController referalProviderViewController = (ReferalProviderViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				referalProviderViewController.setVisitLogInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController =

						(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				providerViewController.setVisitLogInputController(this, providerBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		billingPhysiciansBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController =

						(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				providerViewController.setVisitLogInputController(this, billingPhysiciansBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		startTimeBtn.setOnAction((event) -> {
			try {

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:a");

				startTimeText.setText(sdf.format(cal.getTime()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		arrivalTimeBtn.setOnAction((event) -> {
			try {

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:a");

				arrivalTimeText.setText(sdf.format(cal.getTime()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		completionTimeBtn.setOnAction((event) -> {
			try {

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:a");

				complectionTimeText.setText(sdf.format(cal.getTime()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerInTimeBtn.setOnAction((event) -> {
			try {

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:a");

				providerInTimeText.setText(sdf.format(cal.getTime()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerOutTimeBtn.setOnAction((event) -> {
			try {

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:a");

				providerOutTime.setText(sdf.format(cal.getTime()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicianBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicianViewController clinicianViewController = (ClinicianViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				clinicianViewController.setVisitLogInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		chargesBtn.setOnAction((event) -> {
			if (visitTypeChoiceBox.getSelectionModel().getSelectedItem() != null) {
				try {
					visitType = visitTypeChoiceBox.getSelectionModel().getSelectedItem();

					setPatientVisitObj();
					System.out.println("New Patient Visit Id is : " + Global.patientVisitObj.getId());

					String formName = formPath.context.getMessage("ViewMedicalActivityCharge", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.ViewMedicalActivityCharge", null, Locale.US);
					String formTitle2 = Global.patient.getPatientName().getFirstName();
					String formTitle = formTitle1 + "/" + formTitle2;

					formPath.closeApplicationContext();
					MedicalActivityChargeViewController medicalActivityChargeViewController = (MedicalActivityChargeViewController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					medicalActivityChargeViewController.setVisitLogInputController(this);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("Please Select Visit Type");
				alert.showAndWait();
			}
		});

		emrChartingBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("GenericEMRCharting", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.GenericEMRCharting", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1 + "/" + formTitle2;
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		payerAccountBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1 + "/" + formTitle2;
				formPath.closeApplicationContext();
				BillingAccountViewController billingAccount =

						(BillingAccountViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				billingAccount.setVisitLogInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		List<PatientVisit> patvisit = null;

		companyBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.Company", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1 + "/" + formTitle2;

				formPath.closeApplicationContext();
				CompanyViewController companyViewController = (CompanyViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyViewController.setVisitLogInputController(this);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		okButton.setOnAction((event) -> {
			try {
				if (selectedCompany != null) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("");
					alert.setContentText("Are you sure you want to change company for this patient?");

					alert.showAndWait();
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						Global.patient.setCompany(selectedCompany);
						new PatientEntityController().saveOrUpdate(Global.patient);
					} else {

					}

				}

				/*
				 * String visitStatus = null;
				 * 
				 * if (pendingResultRadioBtn.isSelected()) {
				 * 
				 * visitStatus = "Pending Results"; } else if
				 * (completedRadioBtn.isSelected()) {
				 * 
				 * visitStatus = "Completed";
				 * 
				 * } else if (walkOutRadioBtn.isSelected()) {
				 * 
				 * visitStatus = "Walk-out"; }
				 * 
				 * //PatientVisit patientVisit = new PatientVisit();
				 * 
				 * if(patientVisit2 != null){
				 * Global.patientVisitObj.setId(patientVisit2.getId()); }
				 * 
				 * Global.patientVisitObj.setAlertNotes(alertNoteText.getText())
				 * ;
				 * 
				 * 
				 * Global.patientVisitObj.setArrivalTime(arrivalTimeText.getText
				 * ()); Global.patientVisitObj.setWaitingRoom(true);
				 * 
				 * if(billingPhysiciansText.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * //Provider provider = new
				 * ProviderEntityController().viewById(Integer.parseInt(
				 * billingPhysiciansText.getText())); Provider provider = new
				 * ProviderEntityController().viewByCode((billingPhysiciansText.
				 * getText()));
				 * Global.patientVisitObj.setBillingPsysician(provider); }
				 * 
				 * //patientVisit.setBillingAccount(billingAccount);
				 * 
				 * if(clinicianText.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * 
				 * Clinician clinician = new
				 * ClinicianEntityController().viewByCode(clinicianText.getText(
				 * )); Global.patientVisitObj.setClinician(clinician);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * Global.patientVisitObj.setCompletionTime(complectionTimeText.
				 * getText());
				 * 
				 * Global.patientVisitObj.setMeansOfArrival(
				 * meansOfArrivalChoiceBox.getSelectionModel().getSelectedItem()
				 * ); //patientVisit.setOverridePayer(overridePayer);
				 * //patientVisit.setProtocolInstruction(protocolInstruction);
				 * 
				 * if(providerText.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * Provider provider = new
				 * ProviderEntityController().viewByCode(providerText.getText())
				 * ; Global.patientVisitObj.setProvider(provider);
				 * 
				 * } if(patientFromApp==null){ Patient patient = new
				 * PatientEntityController().getById(Global.patient.getId());
				 * Global.patientVisitObj.setPatient(patient); }else{
				 * Global.patientVisitObj.setPatient(patientFromApp); }
				 * Global.patientVisitObj.setProviderTimeIn(providerInTimeText.
				 * getText());
				 * Global.patientVisitObj.setProviderTimeOut(providerOutTime.
				 * getText());
				 * Global.patientVisitObj.setPurpose(purposeText.getText());
				 * 
				 * if(referredByText.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * ReferalProvider referalProvider = new
				 * ReferalProviderEntityController().viewById(Integer.parseInt(
				 * referredByText.getText()));
				 * Global.patientVisitObj.setReferredBy(referalProvider);
				 * 
				 * }
				 * 
				 * 
				 * Global.patientVisitObj.setStartTime(startTimeText.getText());
				 * Global.patientVisitObj.setSummary(summaryText.getText());
				 * 
				 * if(categoryText.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * VisitCategory visitCategory = new
				 * VisitCategoryEntityController().viewByCode(categoryText.
				 * getText());
				 * Global.patientVisitObj.setVisitCategory(visitCategory);
				 * 
				 * }
				 * 
				 * if(icd10Text.getText().isEmpty()){
				 * 
				 * }else{
				 * 
				 * //VisitCategory visitCategory = new
				 * VisitCategoryEntityController().viewByCode(categoryText.
				 * getText()); //patientVisit.setVisitCategory(visitCategory);
				 * 
				 * Icd10Codes icd10Codes = new
				 * Icd10CodesEntityController().viewICD10CodeId(Integer.parseInt
				 * (icd10Text.getText()));
				 * patientVisit.setIcd10Codes(icd10Codes);
				 * 
				 * }
				 * 
				 * 
				 * 
				 * //patientVisit.setVisitLocation(visitLocation);
				 * Global.patientVisitObj.setVisitStatus(visitStatus);
				 * 
				 * Global.patientVisitObj.setVisitType(visitTypeChoiceBox.
				 * getSelectionModel().getSelectedItem());
				 * 
				 * Global.patientVisitObj.setIcd10Codes(
				 * ICD10DiagonosisInputController.icd10CodesList);
				 * System.out.println("Values "
				 * +ICD10DiagonosisInputController.icd10CodesList.size());
				 * //patientVisit.getIcd10Codes().addAll(
				 * ICD10DiagonosisInputController.icd10CodesList);
				 * patvisit.add(patientVisit);
				 */

				   if (patientAppointment != null) {
					 patientAppointment.setVisitingStatus(true);
					 new PatientAppointmentEntityController().saveOrUpdate(patientAppointment);
					
                   if(patientAppointmentViewController!=null){
                	   patientAppointmentViewController.viewPatientAppointment();
					}
				}

				LocalDate localDate2 = visitDate.getValue();
				if (localDate2 != null) {

					Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

					Global.patientVisitObj.setVisitDate(date2);

				}
				if (ICD10DiagonosisInputController.icd10CodesList != null) {
					Global.patientVisitObj.setIcd10Codes(ICD10DiagonosisInputController.icd10CodesList);
				}
				Global.patientVisitObj.setVisitType(visitTypeChoiceBox.getSelectionModel().getSelectedItem());
				Global.patientVisitObj.setCompletionTime(complectionTimeText.getText());
				Global.patientVisitObj.setArrivalTime(arrivalTimeText.getText());
				Global.patientVisitObj.setStartTime(startTimeText.getText());
				Global.patientVisitObj.setPurpose(purposeText.getText());
				Global.patientVisitObj.setProviderTimeIn(providerInTimeText.getText());
				Global.patientVisitObj.setProviderTimeOut(providerOutTime.getText());
				if (visitCat != null) {
					Global.patientVisitObj.setVisitCategory(visitCat);
				}
				Global.patientVisitObj.setPurpose(purposeText.getText());
				if (providerSelected != null) {
					Global.patientVisitObj.setProvider(providerSelected);
				} /*
					 * else if(Global.patientVisitObj.getProvider()!=null){
					 * Global.patientVisitObj.setProvider(Global.patientVisitObj
					 * .getProvider());
					 * 
					 * }
					 */
				if (meansOfArrivalChoiceBox.getValue() != null) {
					Global.patientVisitObj
							.setMeansOfArrival(meansOfArrivalChoiceBox.getSelectionModel().getSelectedItem());
				}
				// Global.patientVisitObj.setVisitType(typeChoiceBox.getValue());
				if (typeChoiceBox.getSelectionModel() != null) {
					Global.patientVisitObj.setType(typeChoiceBox.getSelectionModel().getSelectedItem());
				}
				if (billProvider != null) {
					Global.patientVisitObj.setBillingPsysician(billProvider);

				} /*
					 * else
					 * if(Global.patientVisitObj.getBillingPsysician()!=null){
					 * Global.patientVisitObj.setBillingPsysician(Global.
					 * patientVisitObj.getBillingPsysician()); }
					 */
				if (clinician != null) {
					Global.patientVisitObj.setClinician(clinician);
				} /*
					 * else if(Global.patientVisitObj.getClinician()!=null){
					 * Global.patientVisitObj.setClinician(Global.
					 * patientVisitObj.getClinician());
					 * 
					 * }
					 */
				if (refProvider != null) {
					Global.patientVisitObj.setReferredBy(refProvider);
				} /*
					 * else if(Global.patientVisitObj.getReferredBy()!=null){
					 * Global.patientVisitObj.setReferredBy(Global.
					 * patientVisitObj.getReferredBy()); }
					 */
				
				
			
				Global.patientVisitObj.setSummary(summaryText.getText());
				Global.patientVisitObj.setAlertNotes(alertNoteText.getText());
				Global.patientVisitObj.setPatient(Global.patient);
				if(Global.patientVisitObj.getId()!=null){
					if (pendingResultRadioBtn.isSelected()) {

						Global.patientVisitObj.setVisitStatus("Pending Results");
						System.out.println("444444444444444444444444444444444444");
					}
					if (completedRadioBtn.isSelected()) {
						Global.patientVisitObj.setVisitStatus("Completed");
						Global.patientVisitObj.setWaitingRoom(false);
						Global.patientVisitObj.setExamRoom1(false);
						Global.patientVisitObj.setExamRoom2(false);
						Global.patientVisitObj.setCheckOut(false);
						Global.patientVisitObj.setExamRoom7(false);
						Global.patientVisitObj.setEyeRoom(false);
						Global.patientVisitObj.setHcg(false);
						Global.patientVisitObj.setLab(false);
						Global.patientVisitObj.setXRay(false);
						Global.patientVisitObj.setPhysicalRoom(false);
						Global.patientVisitObj.setLacerationRoom(false);
					}
					
					if (walkOutRadioBtn.isSelected()) {

						Global.patientVisitObj.setVisitStatus("Walk-out");
						Global.patientVisitObj.setWaitingRoom(false);
						Global.patientVisitObj.setExamRoom1(false);
						Global.patientVisitObj.setExamRoom2(false);
						Global.patientVisitObj.setCheckOut(false);
						Global.patientVisitObj.setExamRoom7(false);
						Global.patientVisitObj.setEyeRoom(false);
						Global.patientVisitObj.setHcg(false);
						Global.patientVisitObj.setLab(false);
						Global.patientVisitObj.setXRay(false);
						Global.patientVisitObj.setPhysicalRoom(false);
						Global.patientVisitObj.setLacerationRoom(false);
					

					}
					
				}
				else{
					if (pendingResultRadioBtn.isSelected()) {

						Global.patientVisitObj.setVisitStatus("Pending Results");
						System.out.println("444444444444444444444444444444444444");
					}
					if (completedRadioBtn.isSelected()) {
						Global.patientVisitObj.setVisitStatus("Completed");
						Global.patientVisitObj.setWaitingRoom(false);
						
					}
					else
					{
						Global.patientVisitObj.setWaitingRoom(true);
					}
					if (walkOutRadioBtn.isSelected()) {

						Global.patientVisitObj.setVisitStatus("Walk-out");
						Global.patientVisitObj.setWaitingRoom(false);

					}
					
					Global.patientVisitObj.setExamRoom1(false);
					Global.patientVisitObj.setExamRoom2(false);
					Global.patientVisitObj.setCheckOut(false);
					Global.patientVisitObj.setExamRoom7(false);
					Global.patientVisitObj.setEyeRoom(false);
					Global.patientVisitObj.setHcg(false);
					Global.patientVisitObj.setLab(false);
					Global.patientVisitObj.setXRay(false);
					Global.patientVisitObj.setPhysicalRoom(false);
					Global.patientVisitObj.setLacerationRoom(false);
				}
				if (visitTypeChoiceBox.getSelectionModel().getSelectedItem() != null) {

					System.out.println("@@@@@@@@@@@@@ " + Global.patientVisitObj.getId());

					new PatientVisitEntityController().saveOrUpdate(Global.patientVisitObj);

					ICD10DiagonosisInputController.icd10CodesList = null;

					/*
					 * if(AppointmentController.flag==1){
					 * appointmentController.reFresh();
					 * appointmentController.refreshCol2(); }
					 */
					AppointmentController.flag = 0;

					// For View MedicalActivityCharge Result

					LocalDate localDate4 = visitDate.getValue();
					Date date4 = null;
					if (localDate4 != null) {

						date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());

					}

					List<MedicalActivityCharge> searchListSize = null;
					// searchListSize= new
					// MedicalActivityChargeEntityController().searchByDatePatientBillingStatus(date4);
					searchListSize = new MedicalActivityChargeEntityController()
							.searchByPatientVisit(Global.patientVisitObj.getId());
					System.out.println("List Size is : " + searchListSize.size());

					for (MedicalActivityCharge medicalActivityCharge2 : searchListSize) {

						medicalActivityCharge2.setPatientVisit(Global.patientVisitObj);
						new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge2);
					}
					ICD10DiagonosisInputController.icd10CodesList = null;

					if (visitByPatientViewController != null) {
						System.out.println("view by pat visit  is not null");
						visitByPatientViewController.viewPatientVisit();
					} else if (visitByPatientViewControllerAdd != null) {
						visitByPatientViewControllerAdd.viewPatientVisit();
					}

					
					// Global.patientVisitObj = patientVisit;
					new FXFormCommonUtilities().closeForm(okButton);

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Please Select Visit Type");
					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		demographicsBtn.setOnAction((event) -> {
			try {

				// Patient patient =
				// patientTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditPatient", null, Locale.US);

				formPath.closeApplicationContext();
				// searchPatientController = null;

				if (Global.patient != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					PatientEditController editController = fxmlLoader.getController();
					editController.setPatient(Global.patient);
					editController.setVisitLogInputController(this);
					stage.show();

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				Global.patientVisitObj = holdPatientVisit;
				ICD10DiagonosisInputController.icd10CodesList = null;
				AppointmentController.flag = 0;
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
