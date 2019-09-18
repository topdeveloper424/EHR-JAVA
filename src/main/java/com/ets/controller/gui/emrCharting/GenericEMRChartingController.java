package com.ets.controller.gui.emrCharting;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.gui.genericVisitProtocal.EnterVitalSignGUIController;
import com.ets.controller.entity.assesment.AssessmentEntityController;
import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.entity.emrHpi.EmrHpiEntityController;
import com.ets.controller.entity.hpiTextArea.HpiTextAreaEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.vitalSign.VitalSignEntityController;
import com.ets.controller.gui.emhCharting.hpi.symptom.HPISymptomInputController;
import com.ets.controller.gui.emrCharting.exam.chest.ExamChestInputController;
import com.ets.controller.gui.emrCharting.exam.constutional.ExamConstutionalInputController;
import com.ets.controller.gui.emrCharting.exam.cv.ExamCvInputController;
import com.ets.controller.gui.emrCharting.exam.ent.ExamEntInputController;
import com.ets.controller.gui.emrCharting.exam.eye.ExamEyeInputController;
import com.ets.controller.gui.emrCharting.exam.forearm.ExamForearmInputController;
import com.ets.controller.gui.emrCharting.exam.functionalStatus.ExamFunctionalStatusInputController;
import com.ets.controller.gui.emrCharting.exam.gi.ExamGIinputController;
import com.ets.controller.gui.emrCharting.exam.gu.GUInputController;
import com.ets.controller.gui.emrCharting.exam.heLe.LymphInputController;
import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.ankle.ExamMusculotoneAnkleInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back.ExamMusculotoneBackController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.chest.ExamMusculotoneChestInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.elbow.ExamMusculotoneElbowInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm.ExamMusculotoneForearmInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.head.ExamMusculotoneHeadInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.hip.ExamMusculotoneHipInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.knee.ExamMusculotoneKneeInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.ExamMusculotoneNeckInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder.ExamMusculotoneShoulderInputController;
import com.ets.controller.gui.emrCharting.exam.neck.ExamNeckInputController;
import com.ets.controller.gui.emrCharting.exam.psych.ExamPsychInputController;
import com.ets.controller.gui.emrCharting.exam.resp.ExamRespInputController;
import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.controller.gui.emrCharting.assesment.assesmentDiagonosis.AssesmentDiagonosisInputController;
import com.ets.controller.gui.emrCharting.assesment.icd10.ICD10SearchController;

import com.ets.controller.gui.emrCharting.hpi.aggaravatingFactor.HPIAggaravatingFactorInputController;
import com.ets.controller.gui.emrCharting.hpi.alleviatingFactor.HPIAlleviatingFactorInputController;
import com.ets.controller.gui.emrCharting.hpi.problems.HPIProblemsInputController;
import com.ets.controller.gui.emrCharting.hpi.quality.HPIQualityInputController;
import com.ets.controller.gui.emrCharting.hpi.timing.HPITimingInputController;
import com.ets.controller.gui.emrCharting.instruction.patientInst.InstructionPatientInstInputCotroller;
import com.ets.controller.gui.emrCharting.instruction.returnFollowup.InstructionReturnFollowUpInputController;
import com.ets.controller.gui.emrCharting.order.DiagonosticTestInputController;
import com.ets.controller.gui.emrCharting.order.MedicationInputController;
import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.controller.gui.emrCharting.order.consult.OrderConsultInputController;
import com.ets.controller.gui.emrCharting.order.diagonostic.OrderDiagonosticTestInputController;
import com.ets.controller.gui.emrCharting.order.durableMedicalEquipment.OrderDurableMedicalEquipmentInputController;
import com.ets.controller.gui.emrCharting.order.otherDataSource.OrderOtherDataSourceInputController;
import com.ets.controller.gui.emrCharting.order.patientLocal.OrderPatientLocalMeasureInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHAllergyInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHOtherHistoryInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHProblemInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHWorkHistoryInputController;
import com.ets.controller.gui.emrCharting.pmh.medication.PMHMedicationInputController;
import com.ets.controller.gui.emrCharting.procedure.MedicalProcedureInputController;
import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.controller.gui.emrCharting.ros.allIm.AllImInputController;
import com.ets.controller.gui.emrCharting.ros.contitutional.RosConstitutionalInputController;
import com.ets.controller.gui.emrCharting.ros.cv.RosCvInputController;
import com.ets.controller.gui.emrCharting.ros.endo.RosEndoInputController;
import com.ets.controller.gui.emrCharting.ros.ent.RosEntInputController;
import com.ets.controller.gui.emrCharting.ros.eye.RosEyeInputController;
import com.ets.controller.gui.emrCharting.ros.gi.RosGiInputController;
import com.ets.controller.gui.emrCharting.ros.gu.RosGuInputController;
import com.ets.controller.gui.emrCharting.ros.heLy.HeLyInputController;
import com.ets.controller.gui.emrCharting.ros.neuro.NeuroInputController;
import com.ets.controller.gui.emrCharting.ros.psych.PsychInputController;
import com.ets.controller.gui.emrCharting.ros.resp.RosRespInputController;
import com.ets.controller.gui.emrCharting.ros.skel.RosSkelInputController;
import com.ets.controller.gui.emrCharting.ros.skin.SkinInputController;
import com.ets.controller.gui.emrCharting.workStatus.EMRWorkStatusInputController;
import com.ets.controller.gui.emrCharting.hpi.duration.HPIDurationInputController;
import com.ets.controller.gui.emrCharting.hpi.location.HPiLocationInputController;
import com.ets.controller.gui.emrCharting.hpi.mechanism.HPIMechanismInputController;
import com.ets.controller.gui.emrCharting.hpi.quality.HPIQualityInputController;
import com.ets.controller.gui.emrCharting.hpi.severity.HPISeverityInputController;

import com.ets.controller.gui.genericVisitProtocal.GraphVitalsInputController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeViewController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.model.Assesment;
import com.ets.model.Clinic;
import com.ets.model.Clinician;
import com.ets.model.Company;
import com.ets.model.EmrHpi;
import com.ets.model.EmrChartingTextAreaSave;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.VitalSign;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class GenericEMRChartingController implements Initializable {

	@FXML
	private TextField templateText;

	@FXML
	private Button templateBtn;

	@FXML
	private TextField arrivalTimeText;

	@FXML
	private Button arrivalTimeBtn;

	@FXML
	private ChoiceBox<?> meansOfArrivalBtn;

	@FXML
	private TextField clinicianInText;

	@FXML
	private Button clinicianInBtn;

	@FXML
	private TextField providerInText;

	@FXML
	private Button providerInBtn;

	@FXML
	private TextField clinicianOutText;

	@FXML
	private TextField providerOutText;

	@FXML
	private ToggleGroup patientType;

	@FXML
	private ToggleGroup level;

	@FXML
	private Label ExtentHistoryDocumentReqLabel;

	@FXML
	private RadioButton tbdNAradioBtn1;

	@FXML
	private RadioButton newText;

	@FXML
	private RadioButton estabText;

	@FXML
	private RadioButton consultText;

	@FXML
	private RadioButton preventtext;

	@FXML
	private RadioButton telePhoneText;

	@FXML
	private RadioButton tbdNAradiobtn2;

	@FXML
	private RadioButton level1Text;

	@FXML
	private RadioButton level2Text;

	@FXML
	private RadioButton level3Text;

	@FXML
	private RadioButton level4Text;

	@FXML
	private RadioButton level5Text;

	@FXML
	private CheckBox twoPatientIdentificationVerifiedText;
	@FXML
	private Button allPatientHistoryButton;

	@FXML
	private Button recordVitalsBtn;

	@FXML
	private Button graphVitalsText;
	@FXML
	private Button InstructionReturnFollowUpBtn;

	@FXML
	private Label visitDateLabel;

	@FXML
	private Button hpiProblemBtn;

	@FXML
	private Button hpiSnBtn;

	@FXML
	private Button hpiDurationBtn;

	@FXML
	private Button hpiContextBtn;

	@FXML
	private Button medicalProcedureButton;

	@FXML
	private Button hpiLocationBtn;

	@FXML
	private Button hpiTimingBtn;

	@FXML
	private Button hpiSeverityBtn;

	@FXML
	private Button hpiQualityBtn;

	@FXML
	private Button examChestBtn;

	@FXML
	private CheckBox examChestCheck;

	@FXML
	private CheckBox hpiProblemCheckBox;

	@FXML
	private TextArea patientVisitComplaintTextArea;

	@FXML
	private CheckBox hpiSnCheckBox;

	@FXML
	private CheckBox hpiLocationCheckBox;

	@FXML
	private CheckBox hpiQualityCheckBox;

	@FXML
	private Label ExtentExamCurrentDocumentReqLabel;
	@FXML
	private Label ExtentHistoryCurrentDocumentLabel;

	@FXML
	private Label heightInches;
	@FXML
	private Label weightLb;
	@FXML
	private Label heightCm;
	@FXML
	private Label weightKg;
	@FXML
	private Label bmiLabel;
	@FXML
	private Label bpLabel;

	@FXML
	private Label respLabel;
	@FXML
	private Label pulseLabel;
	@FXML
	private Label ageLabel;
	@FXML
	private Label tempLabel;

	@FXML
	private Label pulseOxiLabel;

	@FXML
	private Label ExtentExamDocumentReqLabel;

	@FXML
	private Label ComplexityDocReqLabel;

	@FXML
	private Label ComplexityCurrentDocLabel;

	@FXML
	private CheckBox hpiSeverityCkeckBox;

	@FXML
	private CheckBox hpiDurationCheckBox;

	@FXML
	private CheckBox hpiTimingCheckBox;

	@FXML
	private CheckBox hpiContextCheckBox;

	@FXML
	private CheckBox hpiWorseCheckBox;

	@FXML
	private CheckBox hpiBetterCheckBox;

	@FXML
	private TextField hpiProblemText;

	@FXML
	private TextField hpiSnText;

	@FXML
	private TextField hpiLocationText;

	@FXML
	private TextField hpiQualityText;

	@FXML
	private TextField hpiSeverityText;

	@FXML
	private Button hpiWorseBtn;

	@FXML
	private Button hpiBetterBtn;

	@FXML
	private TextField hpiDurationText;

	@FXML
	private TextField hpiTimingText;

	@FXML
	private TextField hpiContextText;

	@FXML
	private TextField hpiWorseText;

	@FXML
	private TextField hpiBetterText;

	@FXML
	private TextArea hpiTextArea;

	@FXML
	private Button pmhAllergyBtn;

	@FXML
	private Button pmhMedicationBtn;

	@FXML
	private Button pmhProblemBtn;

	@FXML
	private Button pmhOtherHistoryBtn;

	@FXML
	private CheckBox pmhAllergyCheckBox;

	@FXML
	private CheckBox pmhMedicationCheckBox;

	@FXML
	private CheckBox pmhProblemCheckBox;

	@FXML
	private CheckBox pmhOtherHistoryCheckBox;

	@FXML
	private CheckBox pmhNoAllergyCheckBox;

	@FXML
	private CheckBox pmhNoMedicationCheckBox;

	@FXML
	private CheckBox pmhNoProblemCheckBox;

	@FXML
	private CheckBox pmhNoHistoryCheckBox;

	@FXML
	private Button pmhFamilyHistoryBtn;

	@FXML
	private Button pmhSocialHistoryBtn;

	@FXML
	private Button pmhWorkHistoryBtn;

	@FXML
	private CheckBox pmhFamilyHistoryCheckBox;

	@FXML
	private CheckBox pmhSocialHistoryCheckBox;

	@FXML
	private CheckBox pmhWorkHistoryCheckBox;

	@FXML
	private CheckBox pmhNoFamilyHistoryCheckBox;

	@FXML
	private CheckBox pmhNoSocialHistoryCheckBox;

	@FXML
	private CheckBox pmhNoWorkHistoryCheckBox;

	@FXML
	private Button rosConstBtn;

	@FXML
	private Button rosEyeBtn;

	@FXML
	private Button rosEntBtn;

	@FXML
	private Button rosCvBtn;

	@FXML
	private Button rosRespBtn;

	@FXML
	private Button rosGiBtn;

	@FXML
	private Button workStatusAssessmentButton;

	@FXML
	private Button rosGuBtn;

	@FXML
	private Button rosSkelBtn;

	@FXML
	private Button rosSkinBtn;

	@FXML
	private Button rosNeuroBtn;

	@FXML
	private Button rosPsychBtn;

	@FXML
	private Button rosEndoBtn;

	@FXML
	private Button rosHeBtn;

	@FXML
	private Button rosAllBtn;

	@FXML
	private CheckBox rosConstCheckBox;

	@FXML
	private CheckBox rosEyeCheckBox;

	@FXML
	private CheckBox rosEntCheckBox;

	@FXML
	private CheckBox rosRespCheckBox;

	@FXML
	private CheckBox rosCvCheckBox;

	@FXML
	private CheckBox rosGiCheckBox;

	@FXML
	private CheckBox rosGuCheckBox;

	@FXML
	private CheckBox rosSkelCheckBox;

	@FXML
	private CheckBox rosSkinCheckBox;

	@FXML
	private CheckBox rosNeuroCheckBox;

	@FXML
	private CheckBox rosPsychCheckBox;

	@FXML
	private CheckBox rosEndoCheckBox;

	@FXML
	private CheckBox rosHeCheckBox;

	@FXML
	private CheckBox rosConstDeniesCheckBox;

	@FXML
	private CheckBox rosEyeDeniesCheckBox;

	@FXML
	private CheckBox rosEntDeniesCheckBox;

	@FXML
	private CheckBox rosCvDeniesCheckBox;

	@FXML
	private CheckBox rosRespDeniesCheckBox;

	@FXML
	private CheckBox rosGiDeniesCheckBox;

	@FXML
	private CheckBox rosGuDeniesCheckBox;

	@FXML
	private CheckBox rosAllCheckBox;

	@FXML
	private CheckBox rosSkelDeniesCheckBox;

	@FXML
	private CheckBox rosSkinDeniesCheckBox;

	@FXML
	private CheckBox rosNeuroDeniesCheckBox;

	@FXML
	private CheckBox rosPsychDeniesCheckBox;

	@FXML
	private CheckBox rosEndoDeniesCheckBox;

	@FXML
	private Button examOrganNeckBtn;
	@FXML
	private CheckBox examOrganNormalNeckCheckBox1;
	@FXML
	private CheckBox rosHeDeniesCheckBox;

	@FXML
	private CheckBox rosAllDeniesCheckBox;

	@FXML
	private Button examOrganConstBtn;

	@FXML
	private Button examOrganEyeBtn;

	@FXML
	private Button hpiStartOverButton;
	@FXML
	private Button examOrganEntBtn;

	@FXML
	private Button examOrganCvBtn;

	@FXML
	private Button examOrganRespBtn;

	@FXML
	private Button examOrganGiBtn;

	@FXML
	private Button examOrganGuBtn;

	@FXML
	private Button examOrganSkelBtn;

	@FXML
	private Button examOrganSkinBtn;

	@FXML
	private Button examOrganNeuroBtn;

	@FXML
	private Button examOrganPsychBtn;

	@FXML
	private Button examOrganEndoBtn;

	@FXML
	private Button examOrganHeBtn;

	@FXML
	private Label clinicianLabel;

	@FXML
	private Label providerLabel;
	@FXML
	private Button examOrganAllBtn;

	@FXML
	private CheckBox examOrganConstCheckBox;

	@FXML
	private CheckBox examOrganEyeCheckBox;

	@FXML
	private CheckBox examOrganEntCheckBox;

	@FXML
	private CheckBox examOrganRespCheckBox;

	@FXML
	private CheckBox examOrganCvCheckBox;

	@FXML
	private CheckBox examOrganGiCheckBox;

	@FXML
	private CheckBox examOrganGuCheckBox;

	@FXML
	private CheckBox examOrganSkelCheckBox;

	@FXML
	private CheckBox examOrganSkinCheckBox;

	@FXML
	private CheckBox examOrganNeuroCheckBox;

	@FXML
	private CheckBox examOrganPsychCheckBox;

	@FXML
	private CheckBox examOrganEndoCheckBox;

	@FXML
	private CheckBox examOrganHeCheckBox;

	@FXML
	private CheckBox examOrganCheckBox;

	@FXML
	private CheckBox examOrganEyeNormalCheckBox;

	@FXML
	private CheckBox examOrganEntNormalCheckBox;

	@FXML
	private CheckBox examOrganCvNormalCheckBox;

	@FXML
	private CheckBox examOrganRespNormalCheckBox;

	@FXML
	private CheckBox examOrganGiNormalCheckBox;

	@FXML
	private CheckBox examOrganGuNormalCheckBox;

	@FXML
	private CheckBox examOrganNeckCheckBox;

	@FXML
	private CheckBox examOrganSkelNormalCheckBox;

	@FXML
	private CheckBox examOrganSkinNormalCheckBox;

	@FXML
	private CheckBox examOrganNeuroNormalCheckBox;

	@FXML
	private CheckBox examOrganPsychNormalCheckBox;

	@FXML
	private CheckBox examOrganEndoNormalCheckBox;

	@FXML
	private CheckBox examOrganNormalHeCheckBox;

	@FXML
	private CheckBox examOrganAllNormalCheckBox;

	@FXML
	private TextArea examOrganTextArea;

	@FXML
	private DatePicker dateOfInjury;

	@FXML
	private DatePicker instNextVisitDate;

	@FXML
	private TextField timeText;

	@FXML
	private ToggleGroup patientCondition;

	@FXML
	private RadioButton InstPatConditionStable;

	@FXML
	private RadioButton InstPatConditionUnsatable;

	@FXML
	private DatePicker workstatusAsOfDate;

	@FXML
	private Button examMusculoskeletalNeckBtn;

	@FXML
	private Button examMusculoskeletalChestBtn;

	@FXML
	private Button examMusculoskeletalBackBtn;

	@FXML
	private Button examMusculoskeletalHipBtn;

	@FXML
	private Button examMusculoskeletalHeadBtn;

	@FXML
	private Button examMusculoskeletalElbowBtn;

	@FXML
	private Button examMusculoskeletalForearmBtn;

	@FXML
	private Button examMusculoskeletalKneeBtn;

	@FXML
	private Button examMusculoskeletalAnkleBtn;

	@FXML
	private Button examMusculoskeletalShoulderBtn;

	@FXML
	private CheckBox examMusculoskeletalNeckCheckBox;

	@FXML
	private CheckBox examMusculoskeletalChestCheckBox;

	@FXML
	private CheckBox examMusculoskeletalBackCheckBox;

	@FXML
	private CheckBox examMusculoskeletalHipCheckBox;
	@FXML
	private Button ResultDiagonosisTestBtn;

	@FXML
	private Button ExamfunctionalButn;

	@FXML
	private CheckBox examMusculoskeletalHeadCheckBox;

	@FXML
	private CheckBox examMusculoskeletalElbowCheckBox;

	@FXML
	private CheckBox examMusculoskeletalForearmCheckBox;

	@FXML
	private CheckBox examMusculoskeletalKneeCheckBox;

	@FXML
	private CheckBox examMusculoskeletalAnkleCheckBox;

	@FXML
	private CheckBox examMusculoskeletalNeckNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalChestNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalBackNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalHipNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalHeadNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalShoulderCheckBox;

	@FXML
	private CheckBox examMusculoskeletalElbowNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalForearmNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalKneeNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalAnkleNormalCheckBox;

	@FXML
	private CheckBox examMusculoskeletalShoulderNormalCheckBox;
	@FXML
	private TextArea procedureTextArea;

	@FXML
	private TextArea instructionTextArea;

	@FXML
	private Tab examFunctionalStatusBtn;
	@FXML
	private TextArea pmhTextArea;

	@FXML
	private TableView<Assesment> assesmentTable;

	@FXML
	private TableView<MedicalActivityCharge> ResultMedicalActivityChargeTable;

	@FXML
	private TableColumn<MedicalActivityCharge, String> ResultDescriptionColumn;
	@FXML
	private TableColumn<MedicalActivityCharge, String> ResultcptCodeColumn;

	@FXML
	private TableColumn<MedicalActivityCharge, String> ResultactivityColumn;
	@FXML
	private TableColumn<?, ?> rankCollumn;

	@FXML
	private TableColumn<Assesment, String> codeCollumn;

	@FXML
	private TableColumn<Assesment, String> descriptionCollumn;

	@FXML
	private Button durableMedicalEquipButton;

	@FXML
	private Button assesmentAddBtn;

	@FXML
	private Button OrderConsultButton;

	@FXML
	private Button providerOutbtn;
	@FXML
	private Button clinicianOutbtn;
	@FXML
	private Button OrderPatientLocalMeasureButton;

	@FXML
	private Button OrderWorkRestrictionButton;

	@FXML
	private Button assesmenDeleteBtn;

	@FXML
	private Button assesmenEditBtn;

	@FXML
	private TextArea assesmentTextArea;

	@FXML
	private TextArea orderTextAres;

	@FXML
	private TextArea rosTextArea;

	@FXML
	private ChoiceBox<String> workStatusChoiceBox;

	@FXML
	private ChoiceBox<String> InstAmbulatoryChoice;

	@FXML
	private ChoiceBox<String> InstDischrgDestination;

	@FXML
	private Button demographicsBtn;

	@FXML
	private Button viewChartBtn;

	@FXML
	private Button pastNotesbtn;

	@FXML
	private Button appoinmentBtn;

	@FXML
	private Button ordersBtn;

	@FXML
	private Button prescriptionsBtn;

	@FXML
	private Button referralsBtn;

	@FXML
	private Button chargesBtn;

	@FXML
	private Button codeTBDbtn;

	@FXML
	private Button codeEMbtn;

	@FXML
	private Button OrderMedicationBtn;

	@FXML
	private Button OrderDiagonosticTestBtn;

	@FXML
	private Button OrderotherDataSourceButton;

	@FXML
	private Button buildNoteBtn;

	@FXML
	private Button auditBtn;

	@FXML
	private Button imagesBtn;

	@FXML
	private Button formsBtn;

	@FXML
	private Button reportBtn;

	@FXML
	private Button reviewBtn;

	@FXML
	private Button doneBtn;
	@FXML
	private Button patientInstructionBtn;

	@FXML
	private TextArea resultTextArea;

	@FXML
	private TextArea workStatusTextArea;

	@FXML
	void onMouseClickOnWorkStatusChoice(MouseEvent event) {

		Date newDate = new Date();

		LocalDate newLocal = newDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		workstatusAsOfDate.setValue(newLocal);
	}

	@FXML
	void newClickedFunction(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionConsult(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionEstab(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionLevel1(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionLevel2(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionLevel3(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionLevel4(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionLevel5(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionPatientTBD(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionPrevent(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionTBD(ActionEvent event) {
		CheckRadioOnAction();
	}

	@FXML
	void onActionTelephone(ActionEvent event) {
		CheckRadioOnAction();
	}

	
	public static String str = "\n\n";
	public static Integer formCount = 0;
	
	
	public void CheckRadioOnAction() {

		if (tbdNAradioBtn1.isSelected()
				&& (tbdNAradiobtn2.isSelected() || level1Text.isSelected() || level2Text.isSelected()
						|| level3Text.isSelected() || level4Text.isSelected() || level5Text.isSelected())) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("To be determined");
			ExtentExamDocumentReqLabel.setText("To be determined");
			ComplexityDocReqLabel.setText("To be determined");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");
		}

		if (newText.isSelected() && (tbdNAradiobtn2.isSelected() || level1Text.isSelected())) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Problem Focused");
			ExtentExamDocumentReqLabel.setText("Problem Focused");
			ComplexityDocReqLabel.setText("Straight Forward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (newText.isSelected() && level5Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Comprehensive");
			ExtentExamDocumentReqLabel.setText("Comprehensive");
			ComplexityDocReqLabel.setText("High Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (newText.isSelected() && level4Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Comprehensive");
			ExtentExamDocumentReqLabel.setText("Comprehensive");
			ComplexityDocReqLabel.setText("Moderate Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}

		if (newText.isSelected() && level3Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Detailed");
			ExtentExamDocumentReqLabel.setText("Detailed");
			ComplexityDocReqLabel.setText("Low Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}

		if (newText.isSelected() && level2Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Expended Problem Focused");
			ExtentExamDocumentReqLabel.setText("Expended Problem Focused");
			ComplexityDocReqLabel.setText("Straight Forward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}

		if (estabText.isSelected() && tbdNAradiobtn2.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Expended Problem Focused");
			ExtentExamDocumentReqLabel.setText("Expended Problem Focused");
			ComplexityDocReqLabel.setText("Low Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (estabText.isSelected() && level1Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("To be determined");
			ExtentExamDocumentReqLabel.setText("To be determined");
			ComplexityDocReqLabel.setText("To be determined");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}

		if (estabText.isSelected() && level2Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Problem Focused");
			ExtentExamDocumentReqLabel.setText("Problem Focused");
			ComplexityDocReqLabel.setText("Straightforward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (estabText.isSelected() && level3Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Expanded Problem Focused");
			ExtentExamDocumentReqLabel.setText("Expanded Problem Focused");
			ComplexityDocReqLabel.setText("Low Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (estabText.isSelected() && level4Text.isSelected()) {

			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Detailed");
			ExtentExamDocumentReqLabel.setText("Detailed");
			ComplexityDocReqLabel.setText("Moderate Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (estabText.isSelected() && level5Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Comprehensive");
			ExtentExamDocumentReqLabel.setText("Comprehensive");
			ComplexityDocReqLabel.setText("High Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && tbdNAradiobtn2.isSelected()) {

			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Expanded Problem Focused");
			ExtentExamDocumentReqLabel.setText("Expanded Problem Focused");
			ComplexityDocReqLabel.setText("Straightward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && level1Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Problem Focused");
			ExtentExamDocumentReqLabel.setText("Problem Focused");
			ComplexityDocReqLabel.setText("Straightward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && level2Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Expanded Problem Focused");
			ExtentExamDocumentReqLabel.setText("Expanded Problem Focused");
			ComplexityDocReqLabel.setText("Straightward");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && level3Text.isSelected()) {

			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Detailed");
			ExtentExamDocumentReqLabel.setText("Detailed");
			ComplexityDocReqLabel.setText("Low Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && level4Text.isSelected()) {
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: red;");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: red;");

			ExtentHistoryDocumentReqLabel.setText("Comprehensive");
			ExtentExamDocumentReqLabel.setText("Comprehensive");
			ComplexityDocReqLabel.setText("Moderate Complexity");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}
		if (consultText.isSelected() && level5Text.isSelected()) {

			ExtentHistoryDocumentReqLabel.setText("Comprehensive");
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentExamDocumentReqLabel.setText("Comprehensive");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: blue;");
			ComplexityDocReqLabel.setText("High Complexity");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: blue;");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: green;");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: green;");
			ComplexityCurrentDocLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: green;");
		}

		if ((preventtext.isSelected() || telePhoneText.isSelected())
				&& (tbdNAradiobtn2.isSelected() || level1Text.isSelected() || level2Text.isSelected()
						|| level3Text.isSelected() || level1Text.isSelected() || level5Text.isSelected())) {

			ExtentHistoryDocumentReqLabel.setText("Not Applicable");
			ExtentHistoryDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ExtentExamDocumentReqLabel.setStyle("-fx-text-fill: red;");
			ExtentExamDocumentReqLabel.setText("Not Applicable");
			ComplexityDocReqLabel.setStyle("-fx-text-fill: red;");
			ComplexityDocReqLabel.setText("Not Applicable");
			ExtentHistoryCurrentDocumentLabel.setStyle("-fx-text-fill: green;");
			ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
			ExtentExamCurrentDocumentReqLabel.setStyle("-fx-text-fill: green;");
			ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
			ComplexityCurrentDocLabel.setStyle("-fx-text-fill: green;");
			ComplexityCurrentDocLabel.setText("Undetermined");

		}

	}

	public void paint(Button button) {
		button.setTextFill(Color.GREEN);
	}

	public void hideCheckBox(CheckBox checkBox) {

		checkBox.setVisible(false);
	}

	StringBuilder allHpiButton = new StringBuilder();
	public static String hpiStaticStringTextarea = null;
	public static String pmhStaticStringTextarea = null;
	public static String rosStaticStringTextarea = null;
	public static String examStaticStringTextarea = null;
	public static String procedureStaticStringTextarea = null;
	public static String resultStaticStringTextarea = null;

	public static String instructionStaticStringTextArea = null;
	public static String workStatusStaticStringTextArea = null;
	public static String orderTextAreaStaticStringTextarea = null;
	public static String assessmentStaticStringTextarea = null;

	// public static String patientVisitComplaintTextAreaStaticStringTextArea =
	// null;
	public void setWorkStatusTextArea(String text) {

		workStatusTextArea.appendText(text + " ,");
		workStatusStaticStringTextArea = workStatusTextArea.getText();

	}

	public void setHpiTextArea(String text) {

		hpiTextArea.appendText(text + " ,");
		hpiStaticStringTextarea = hpiTextArea.getText();

	}

	public void setOrderTextAres(String text) {

		orderTextAres.appendText(text + " ,");
		orderTextAreaStaticStringTextarea = orderTextAres.getText();

	}

	public void setProcedureTextArea(String text) {

		// hpiTextArea.setText(text);
		procedureTextArea.appendText(text + " ,");
		procedureStaticStringTextarea = procedureTextArea.getText();

	}

	public void setInstructionTextArea(String text) {

		instructionTextArea.appendText(text + " ,");
		instructionStaticStringTextArea = instructionTextArea.getText();

	}

	private ObservableList<EmrChartingTextAreaSave> emrTextAreaSave = FXCollections.observableArrayList();

	public void viewTextArea() {

		emrTextAreaSave = new HpiTextAreaEntityController().viewAll(Global.patientVisitObj.getId());
		for (EmrChartingTextAreaSave emrHpi : emrTextAreaSave) {
			hpiTextArea.setText(emrHpi.getTextArea());
			rosTextArea.setText(emrHpi.getRosTextArea());
			examOrganTextArea.setText(emrHpi.getExamTextArea());
			resultTextArea.setText(emrHpi.getResultTextArea());
			procedureTextArea.setText(emrHpi.getProcedureTextArea());
			pmhTextArea.setText(emrHpi.getPmhTextArea());
			instructionTextArea.setText(emrHpi.getInstructionTextArea());
			workStatusTextArea.setText(emrHpi.getWorkStatusTextArea());
			areaSave.setId(emrHpi.getId());
			orderTextAres.setText(emrHpi.getOrderTextArea());
			clinicianInText.setText(emrHpi.getClinicianIn());
			clinicianOutText.setText(emrHpi.getClinicianOut());
			providerOutText.setText(emrHpi.getProviderOut());
			providerInText.setText(emrHpi.getProviderIn());
			patientVisitComplaintTextArea.setText(emrHpi.getPatientVisitComplaint());
			assesmentTextArea.setText(emrHpi.getAssessmentTextArea());
			/*
			 * DateTimeFormatter formatter =
			 * DateTimeFormatter.ofPattern("dd-MM-yyyy"); LocalDate localDate =
			 * LocalDate.parse(emrHpi.getDateOfInjury().toString(), formatter);
			 * dateOfInjury.setValue(localDate);
			 */
			Date dateVisitInjury = emrHpi.getDateOfInjury();

			if (dateVisitInjury != null) {

				LocalDate localDateVisitInjury = new DateConvert().dateToLocalDate(dateVisitInjury);

				dateOfInjury.setValue(localDateVisitInjury);

			}

			Date dateWork = emrHpi.getWorkStatusAsOf();

			if (dateWork != null) {

				LocalDate localDateWork = new DateConvert().dateToLocalDate(dateWork);

				workstatusAsOfDate.setValue(localDateWork);

			}

			if (emrHpi.getTwoPatientIdentifiedVarify() != null) {
				if (emrHpi.getTwoPatientIdentifiedVarify().equals("true")) {
					twoPatientIdentificationVerifiedText.setSelected(true);

				}

			} else {

			}
			if (emrHpi.getPatientType() != null) {

				if (emrHpi.getPatientType().equals("TBD/NA")) {

					tbdNAradioBtn1.setSelected(true);
				}
				if (emrHpi.getPatientType().equals("New")) {
					newText.setSelected(true);

				}
				if (emrHpi.getPatientType().equals("Estab")) {

					estabText.setSelected(true);

				}
				if (emrHpi.getPatientType().equals("consult")) {

					consultText.setSelected(true);

				}
				if (emrHpi.getPatientType().equals("prevent")) {

					preventtext.setSelected(true);

				}
				if (emrHpi.getPatientType().equals("telephone")) {

					telePhoneText.setSelected(true);

				}

				if (emrHpi.getLevelOfVisit().equals("TBD/NA")) {
					tbdNAradiobtn2.setSelected(true);

				}
				if (emrHpi.getLevelOfVisit().equals("Level 1")) {

					level1Text.setSelected(true);

				}
				if (emrHpi.getLevelOfVisit().equals("Level 2")) {

					level2Text.setSelected(true);

				}
				if (emrHpi.getLevelOfVisit().equals("Level 3")) {

					level3Text.setSelected(true);

				}
				if (emrHpi.getLevelOfVisit().equals("Level 4")) {

					level4Text.setSelected(true);

				}
				if (emrHpi.getLevelOfVisit().equals("level 5")) {

					level5Text.setSelected(true);

				}

				CheckRadioOnAction();

				Date dateVisit = emrHpi.getInstructionNextVisitDate();

				if (dateVisit != null) {

					LocalDate localDate = new DateConvert().dateToLocalDate(dateVisit);

					instNextVisitDate.setValue(localDate);

				}

				timeText.setText(emrHpi.getInstructionNextVisitTime());

				if (emrHpi.getInstructionPatientCondition() != null) {

					if (emrHpi.getInstructionPatientCondition().equals("Stable")) {

						InstPatConditionStable.setSelected(true);
					}
					if (emrHpi.getInstructionPatientCondition().equals("Unstable")) {

						InstPatConditionUnsatable.setSelected(true);
					}
				}
				workStatusChoiceBox.setValue(emrHpi.getWorkStatusChoice());
				InstAmbulatoryChoice.setValue(emrHpi.getInstructionAmbulatoryStatus());
				InstDischrgDestination.setValue(emrHpi.getInstructionDischargeDestination());

			}

		}
	}

	EmrChartingTextAreaSave areaSave = new EmrChartingTextAreaSave();

	public void saveAllTextArea() {

		viewTextArea();
		/* EmrChartingTextAreaSave areaSave =new EmrChartingTextAreaSave(); */

		if (emrTextAreaSave.size() > 0) {
			for (EmrChartingTextAreaSave emr : emrTextAreaSave) {
				areaSave.setId(emr.getId());
				areaSave.setPatientVisit(Global.patientVisitObj);
				hpiTextArea.setText(hpiStaticStringTextarea);

				if (rosStaticStringTextarea != null) {
					rosTextArea.setText(rosStaticStringTextarea);
				} else {
					rosTextArea.setText(emr.getRosTextArea());
				}
				if (hpiStaticStringTextarea != null) {
					hpiTextArea.setText(hpiStaticStringTextarea);
				} else {
					hpiTextArea.setText(emr.getTextArea());
				}
				if (examStaticStringTextarea != null) {
					examOrganTextArea.setText(examStaticStringTextarea);
				} else {
					examOrganTextArea.setText(emr.getExamTextArea());
				}
				if (resultStaticStringTextarea != null) {
					resultTextArea.setText(resultStaticStringTextarea);
				} else {
					resultTextArea.setText(emr.getResultTextArea());
				}

				if (procedureStaticStringTextarea != null) {
					procedureTextArea.setText(procedureStaticStringTextarea);
				} else {
					procedureTextArea.setText(emr.getProcedureTextArea());
				}
				if (pmhStaticStringTextarea != null) {
					pmhTextArea.setText(pmhStaticStringTextarea);
				} else {
					pmhTextArea.setText(emr.getPmhTextArea());
				}

				if (orderTextAreaStaticStringTextarea != null) {
					orderTextAres.setText(orderTextAreaStaticStringTextarea);
				} else {
					orderTextAres.setText(emr.getOrderTextArea());
				}

				if (instructionStaticStringTextArea != null) {
					instructionTextArea.setText(instructionStaticStringTextArea);
				} else {
					instructionTextArea.setText(emr.getInstructionTextArea());
				}
				if (workStatusStaticStringTextArea != null) {
					workStatusTextArea.setText(workStatusStaticStringTextArea);
				} else {
					workStatusTextArea.setText(emr.getWorkStatusTextArea());
				}

				if (assessmentStaticStringTextarea != null) {
					assesmentTextArea.setText(assessmentStaticStringTextarea);
				} else {
					assesmentTextArea.setText(emr.getAssessmentTextArea());
				}

				areaSave.setTextArea(hpiTextArea.getText());
				areaSave.setRosTextArea(rosTextArea.getText());
				areaSave.setExamTextArea(examOrganTextArea.getText());
				areaSave.setResultTextArea(resultTextArea.getText());
				areaSave.setProcedureTextArea(procedureTextArea.getText());
				areaSave.setPmhTextArea(pmhTextArea.getText());
				areaSave.setOrderTextArea(orderTextAres.getText());
				areaSave.setInstructionTextArea(instructionTextArea.getText());
				areaSave.setWorkStatusTextArea(workStatusTextArea.getText());
				areaSave.setAssessmentTextArea(assesmentTextArea.getText());
				new HpiTextAreaEntityController().saveOrUpdate(areaSave);
			}

		} else {
			allHpiButton.append(areaSave.getTextArea());
			allHpiButton.append(hpiStaticStringTextarea);
			areaSave.setPatientVisit(Global.patientVisitObj);
			areaSave.setTextArea(allHpiButton.toString());
			new HpiTextAreaEntityController().saveOrUpdate(areaSave);
		}

	}

	public void setRosTextArea(String text) {

		rosTextArea.appendText(text + ".");
		rosStaticStringTextarea = rosTextArea.getText();
	}

	public void setPmhTextArea(String text) {

		pmhTextArea.appendText(text + ".");
		pmhStaticStringTextarea = pmhTextArea.getText();

	}

	public void setExamOrganTextArea(String text) {

		examOrganTextArea.appendText(text + ".");
		examStaticStringTextarea = examOrganTextArea.getText();

	}

	public void setResultTextArea(String text) {

		resultTextArea.setText(text + ".");
		resultStaticStringTextarea = resultTextArea.getText();
	}

	public void setAssesmentTextArea(String text) {

		assesmentTextArea.appendText(text + " .");
		assessmentStaticStringTextarea = assesmentTextArea.getText();
	}

	public void setOrderTextArea(String text) {

		orderTextAres.appendText(text + " .");
		orderTextAreaStaticStringTextarea = orderTextAres.getText();
	}

	private ObservableList<Assesment> assesmentMasterData = FXCollections.observableArrayList();

	public void viewAssesmenttable() {

		Integer id1 = Global.patient.getId();
		if (id1 != null) {
			assesmentMasterData = new AssessmentEntityController().view(id1);
		}
		if (assesmentMasterData != null) {
			codeCollumn.setCellValueFactory(cellData -> cellData.getValue().getIcd10().codeProperty());
			descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().getIcd10().descripProperty());

			assesmentTable.setItems(assesmentMasterData);
		}
	}

	public void setAssesmentDiagonosisUI() {

		try {

			String formName = formPath.context.getMessage("AssesmentDiagonosis", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AssesmentDiagonosis", null, Locale.US);
			formPath.closeApplicationContext();

			AssesmentDiagonosisInputController assesmentDiagonosisInputController = (AssesmentDiagonosisInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			assesmentDiagonosisInputController.setGenericEMRChartingController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private MedicalActivityChargeEntityController medicalActivityChargeEntityController;

	FXMLFormPath formPath = new FXMLFormPath();

	private ObservableList<MedicalActivityCharge> medicalActivityChrgMasterData = FXCollections.observableArrayList();

	public void viewResultMedicalActivityChargeTable(Integer id) {

		medicalActivityChrgMasterData = new MedicalActivityChargeEntityController().viewByMedicalActivityId(id);

		// private ObservableList<MedicalActivityCharge> medicalActivityChrg =
		// FXCollections.observableArrayList();
		// medicalActivityChrg = new
		// MedicalActivityChargeEntityController().viewMedicalActivityCharge(id);
		ResultMedicalActivityChargeTable.setItems(medicalActivityChrgMasterData);
		ResultDescriptionColumn
				.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().descripProperty());
		ResultcptCodeColumn.setCellValueFactory(
				cellData -> cellData.getValue().getMedicalActivity().getCptCode4Hcpcs().codeProperty());
		ResultactivityColumn.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().codeProperty());

	}

	/*
	 * @FXML void TestRadioFunction(ActionEvent event) {
	 * 
	 * if (newText.isSelected() && level2Text.isSelected()) {
	 * 
	 * ExtentHistoryDocumentReqLabel.setText("Expended Problem Focused");
	 * ExtentExamDocumentReqLabel.setText("Expended Problem Focused");
	 * ComplexityDocReqLabel.setText("Straight Forward");
	 * ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
	 * ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
	 * ComplexityCurrentDocLabel.setText("Undetermined");
	 * 
	 * } }
	 */
	/*
	 * @FXML void newClickedFunction(ActionEvent event) {
	 * 
	 * if ((newText.isSelected() && level3Text.isSelected()) ||
	 * newText.isSelected() && tbdNAradiobtn2.isSelected()) {
	 * 
	 * ExtentHistoryDocumentReqLabel.setText("Detailed");
	 * ExtentExamDocumentReqLabel.setText("Detailed");
	 * ComplexityDocReqLabel.setText("Low Complexity");
	 * ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
	 * ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
	 * ComplexityCurrentDocLabel.setText("Undetermined"); }
	 * 
	 * }
	 */

	@FXML
	void Clicked3Function(ActionEvent event) {
		/*
		 * if ((level3Text.isSelected() && newText.isSelected()) ||
		 * (level3Text.isSelected() && tbdNAradioBtn1.isSelected())) {
		 * 
		 * ExtentHistoryDocumentReqLabel.setText("Detailed");
		 * ExtentExamDocumentReqLabel.setText("Detailed");
		 * ComplexityDocReqLabel.setText("Low Complexity");
		 * ExtentHistoryCurrentDocumentLabel.setText("Undetermined");
		 * ExtentExamCurrentDocumentReqLabel.setText("Undetermined");
		 * ComplexityCurrentDocLabel.setText("Undetermined"); }
		 */

	}

	public static List<VitalSign> vitalSign = null;
	public static String hpiStaticStringTextareaBuild = null;
	public static String pmhStaticStringTextareaBuild = null;
	public static String rosStaticStringTextareaBuild = null;
	public static String examStaticStringTextareaBuild = null;
	public static String procedureStaticStringTextareaBuild = null;
	public static String resultStaticStringTextareaBuild = null;

	public static String instructionStaticStringTextAreaBuild = null;
	public static  String workStatusStaticStringTextAreaBuild = null;
	public static String orderTextAreaStaticStringTextareaBuild = null;
	public static String assessmentStaticStringTextareaBuild = null;

	public void forBuildNote() {

		hpiStaticStringTextareaBuild = hpiTextArea.getText();
		pmhStaticStringTextareaBuild = pmhTextArea.getText();
		rosStaticStringTextareaBuild = rosTextArea.getText();
		examStaticStringTextareaBuild = examOrganTextArea.getText();
		procedureStaticStringTextareaBuild = procedureTextArea.getText();
		resultStaticStringTextareaBuild = resultTextArea.getText();

		instructionStaticStringTextAreaBuild = instructionTextArea.getText();
		workStatusStaticStringTextAreaBuild = workStatusTextArea.getText();
		orderTextAreaStaticStringTextareaBuild = orderTextAres.getText();
		assessmentStaticStringTextareaBuild = assesmentTextArea.getText();

	}

	public void setRecordInVisit() {

		vitalSign = new VitalSignEntityController().view(Global.patientVisitObj);

		for (VitalSign vitalSign2 : vitalSign) {

			heightInches.setText(vitalSign2.getHeightInInches());

			weightLb.setText(vitalSign2.getWeightLb());
			heightCm.setText(vitalSign2.getHeightInCm());
			weightKg.setText(vitalSign2.getWeightKg());
			bmiLabel.setText(vitalSign2.getBmi());
			bpLabel.setText(vitalSign2.getSystolic() + " / " + vitalSign2.getDystolic());
			pulseLabel.setText(vitalSign2.getPulsePerRate());
			pulseOxiLabel.setText(vitalSign2.getPulseoximetry());
			respLabel.setText(vitalSign2.getBreathPerMinute());
			ageLabel.setText(vitalSign2.getAge());
			tempLabel.setText(vitalSign2.getFarenhiet());
			//tempLabel.setText(vitalSign2.getFarenhiet());
		}

	}

	public static String patientVisitComplaintStr = null;


	// public String patientChiefComplaint = null;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewTextArea();

		setRecordInVisit();
		visitDateLabel.setText(Global.patientVisitObj.getVisitDate().toString());
		if (Global.patientVisitObj.getClinician() != null) {
			clinicianLabel.setText(Global.patientVisitObj.getClinician().getFirstName() + " "
					+ Global.patientVisitObj.getClinician().getLastName());

		}
		if (Global.patientVisitObj.getProvider() != null) {
			providerLabel.setText(Global.patientVisitObj.getProvider().getFirstName() + " "
					+ Global.patientVisitObj.getProvider().getLastName());

		}

		List<String> workStatusLi = new ArrayList<String>();

		workStatusLi.add("Rel Full Duty");
		workStatusLi.add("Rel Mod Duty");
		workStatusLi.add("Temp Off Work");
		workStatusLi.add("Perim Disability");
		workStatusLi.add("Discharged");

		ObservableList workStatusList = FXCollections.observableList(workStatusLi);

		// workStatusChoiceBox.getItems().clear();
		workStatusChoiceBox.setItems(workStatusList);

		List<String> instAmbulatoryList = new ArrayList<String>();

		instAmbulatoryList.add("Ambulatory");
		instAmbulatoryList.add("Cane");
		instAmbulatoryList.add("Crutches");
		instAmbulatoryList.add("Walker");
		instAmbulatoryList.add("Strecher");
		instAmbulatoryList.add("Wheelchair");
		ObservableList instAmbulatoryObsrvList = FXCollections.observableList(instAmbulatoryList);

		// workStatusChoiceBox.getItems().clear();
		InstAmbulatoryChoice.setItems(instAmbulatoryObsrvList);

		List<String> instDischrgDestinationList = new ArrayList<String>();

		instDischrgDestinationList.add("Home");
		instDischrgDestinationList.add("Admitted to Hospital");
		instDischrgDestinationList.add("ER");
		instDischrgDestinationList.add("Extended Care Facility");
		instDischrgDestinationList.add("Nursing Home");
		instDischrgDestinationList.add("Rehabilitation");
		instDischrgDestinationList.add("Other");
		ObservableList instDischrgDestinationObsrvList = FXCollections.observableList(instDischrgDestinationList);

		// workStatusChoiceBox.getItems().clear();
		InstDischrgDestination.setItems(instDischrgDestinationObsrvList);

		viewAssesmenttable();

		recordVitalsBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EnterVitalSignValue", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterVitalSignValue", null, Locale.US);
				formPath.closeApplicationContext();
				EnterVitalSignGUIController enterVitalSignGUIController = (EnterVitalSignGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				enterVitalSignGUIController.setGenericEMRChartingController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		graphVitalsText.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("SelectForGraphType", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.SelectForGraphType", null, Locale.US);
				formPath.closeApplicationContext();

				GraphVitalsInputController graphVitalsInputController = (GraphVitalsInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);

				graphVitalsInputController.setGenericEMRChartingController(this, vitalSign);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		medicalProcedureButton.setOnAction((event) -> {
			try {

				// String formName =
				// formPath.context.getMessage("PROCEDUREMedical", null,
				// Locale.US);
				String formName = "/view/code/emrSetup/procedure/MedicalProcdure.fxml";
				// String formTitle =
				// formPath.context.getMessage("Title.PROCEDUREMedical", null,
				// Locale.US);
				String formTitle = "Select Medical Procedure";
				formPath.closeApplicationContext();

				MedicalProcedureInputController medicalProcedureInputController = (MedicalProcedureInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicalProcedureInputController.setGenericEMRChartingController(this, medicalProcedureButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		// ####### Start HPI Tab Button and Check Box Functionality ######

		hpiQualityCheckBox.setOnAction((event) -> {
			if (hpiQualityCheckBox.isSelected()) {
				hpiQualityBtn.setDisable(false);
			} else {

				hpiQualityBtn.setDisable(true);

			}
		}

		);

		hpiQualityBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIQuality", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIQuality", null, Locale.US);
				formPath.closeApplicationContext();

				HPIQualityInputController hpiQualityInputController = (HPIQualityInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiQualityInputController.setGenericEMRChartingController(this, hpiQualityBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiSnBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPISymptom", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPISymptom", null, Locale.US);
				formPath.closeApplicationContext();

				HPISymptomInputController hpiSymptomInputController = (HPISymptomInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiSymptomInputController.setGenericEMRChartingController(this, hpiSnBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiSnCheckBox.setOnAction((event) -> {
			if (hpiSnCheckBox.isSelected()) {
				hpiSnBtn.setDisable(false);
			} else {

				hpiSnBtn.setDisable(true);

			}
		}

		);

		hpiTimingBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPITiming", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPITiming", null, Locale.US);
				formPath.closeApplicationContext();

				HPITimingInputController hpiTimingInputController = (HPITimingInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiTimingInputController.setGenericEMRChartingController(this, hpiTimingBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiTimingCheckBox.setOnAction((event) -> {
			if (hpiTimingCheckBox.isSelected()) {
				hpiTimingBtn.setDisable(false);
			} else {
				hpiTimingBtn.setDisable(true);

			}

		});

		hpiDurationCheckBox.setOnAction((event) -> {
			if (hpiDurationCheckBox.isSelected()) {

				hpiDurationBtn.setDisable(false);

			} else {
				hpiDurationBtn.setDisable(true);
			}

		});

		hpiDurationBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIDuration", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIDuration", null, Locale.US);
				formPath.closeApplicationContext();

				HPIDurationInputController hpiDurationInputController = (HPIDurationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiDurationInputController.setGenericEMRChartingController(this, hpiDurationBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiProblemBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIProblem", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIProblem", null, Locale.US);
				formPath.closeApplicationContext();

				HPIProblemsInputController hpiProblemsInputController = (HPIProblemsInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiProblemsInputController.setGenericEMRChartingController(this, hpiProblemBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiProblemCheckBox.setOnAction((event) -> {

			if (hpiProblemCheckBox.isSelected()) {
				hpiProblemBtn.setDisable(false);

			} else {
				hpiProblemBtn.setDisable(true);

			}
		});

		hpiSeverityCkeckBox.setOnAction((event) -> {
			if (hpiSeverityCkeckBox.isSelected()) {

				hpiSeverityBtn.setDisable(false);

			} else {
				hpiSeverityBtn.setDisable(true);
			}

		});

		hpiSeverityBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPISeverity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPISeverity", null, Locale.US);
				formPath.closeApplicationContext();

				HPISeverityInputController hpiSeverityInputController = (HPISeverityInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiSeverityInputController.setGenericEMRChartingController(this, hpiSeverityBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiWorseBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIAggaravatingFactor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIAggaravatingFactor", null, Locale.US);
				formPath.closeApplicationContext();

				HPIAggaravatingFactorInputController hpiggaravatingFactorInputController = (HPIAggaravatingFactorInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiggaravatingFactorInputController.setGenericEMRChartingController(this, hpiWorseBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiWorseCheckBox.setOnAction((event) -> {
			if (hpiWorseCheckBox.isSelected()) {
				hpiWorseBtn.setDisable(false);

			} else {

				hpiWorseBtn.setDisable(true);

			}
		});

		hpiContextCheckBox.setOnAction((event) -> {
			if (hpiContextCheckBox.isSelected()) {

				hpiContextBtn.setDisable(false);

			} else {
				hpiContextBtn.setDisable(true);
			}

		});

		hpiContextBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIMechanism", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIMechanism", null, Locale.US);
				formPath.closeApplicationContext();

				HPIMechanismInputController hpiMechanismInputController = (HPIMechanismInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiMechanismInputController.setGenericEMRChartingController(this, hpiContextBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiBetterCheckBox.setOnAction((event) -> {
			if (hpiBetterCheckBox.isSelected()) {

				hpiBetterBtn.setDisable(false);

			} else {
				hpiBetterBtn.setDisable(true);

			}

		});

		hpiBetterBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPIAlleviatingFactor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPIAlleviatingFactor", null, Locale.US);
				formPath.closeApplicationContext();

				HPIAlleviatingFactorInputController hpiAlleviatingFactorInputController = (HPIAlleviatingFactorInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hpiAlleviatingFactorInputController.setGenericEMRChartingController(this, hpiBetterBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		hpiLocationCheckBox.setOnAction((event) -> {
			if (hpiLocationCheckBox.isSelected()) {

				hpiLocationBtn.setDisable(false);

			} else {
				hpiLocationBtn.setDisable(true);

			}

		});

		hpiLocationBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("HPILocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.HPILocation", null, Locale.US);
				formPath.closeApplicationContext();

				HPiLocationInputController hPiLocationInputController = (HPiLocationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				hPiLocationInputController.setGenericEMRChartingController(this, hpiLocationBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// ####### END HPI Tab Button and Check Box Functionality ######

		pmhAllergyBtn.setOnAction((event) -> {
			try {
				String fmName = formPath.context.getMessage("PMHAllergy", null, Locale.US);
				String fmTitle = formPath.context.getMessage("Title.PMHAllergy", null, Locale.US);
				formPath.closeApplicationContext();
				PMHAllergyInputController pmhAllergyInputController = (PMHAllergyInputController) new FXFormCommonUtilities()
						.displayForm(fmName, fmTitle);
				pmhAllergyInputController.setGenericEMRChartingController(this, pmhAllergyBtn);

			} catch (Exception e) {
				e.printStackTrace();

			}

		});

		pmhNoAllergyCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nALLERGIES / ADVERSE REACTIONS:  Allergies: No know allergies noted by patient.");
			pmhNoAllergyCheckBox.setVisible(false);
			paint(pmhAllergyBtn);
		});

		pmhNoMedicationCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nMEDICATIONS:  Current Medications: No current medications noted by patient.");
			pmhNoMedicationCheckBox.setVisible(false);
			paint(pmhMedicationBtn);
		});

		pmhMedicationBtn.setOnAction((event) -> {
			try {
				String fmName = formPath.context.getMessage("PMHMedication", null, Locale.US);
				String fmTitle = formPath.context.getMessage("Title.PMHMedication", null, Locale.US);
				formPath.closeApplicationContext();
				PMHMedicationInputController pmhMedicationInputController = (PMHMedicationInputController) new FXFormCommonUtilities()
						.displayForm(fmName, fmTitle);
				pmhMedicationInputController.setGenericEMRChartingController(this, pmhMedicationBtn);
				//paint(pmhMedicationBtn);
			} catch (Exception e) {
				e.printStackTrace();

			}

		});
		pmhProblemBtn.setOnAction((event) -> {
			try {
				String fmName = formPath.context.getMessage("PMHProblem", null, Locale.US);
				String fmTitle = formPath.context.getMessage("Title.PMHProblem", null, Locale.US);
				formPath.closeApplicationContext();
				PMHProblemInputController pmhProblemInputController = (PMHProblemInputController) new FXFormCommonUtilities()
						.displayForm(fmName, fmTitle);
				pmhProblemInputController.setGenericEMRChartingController(this, pmhProblemBtn);

			} catch (Exception e) {
				e.printStackTrace();

			}

		});
		pmhNoProblemCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nPROBLEMS:  Major or Chronic Illnesses: No known illnesses noted by patient.");
			pmhNoProblemCheckBox.setVisible(false);
			paint(pmhProblemBtn);
		});

		pmhNoHistoryCheckBox.setOnAction((event) -> {
			setPmhTextArea(
					"\n\nOTHER PERSONAL HISTORY:  Injuries/Operations/Hospitalizations: No injuries, operations, or hospitalizations noted by patient.");
			pmhNoHistoryCheckBox.setVisible(false);
			paint(pmhOtherHistoryBtn);
		});

		pmhOtherHistoryBtn.setOnAction((event) -> {
			try {
				String fmName = formPath.context.getMessage("PMHOtherHistory", null, Locale.US);
				String fmTitle = formPath.context.getMessage("Title.PMHOtherHistory", null, Locale.US);
				formPath.closeApplicationContext();
				PMHOtherHistoryInputController pmhOtherHistoryInputController = (PMHOtherHistoryInputController) new FXFormCommonUtilities()
						.displayForm(fmName, fmTitle);
				pmhOtherHistoryInputController.setGenericEMRChartingController(this, pmhOtherHistoryBtn);

			} catch (Exception e) {
				e.printStackTrace();

			}

		});

		pmhNoFamilyHistoryCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nFAMILY HISTORY:  Family History: No negative family history noted by patient.");
			pmhNoFamilyHistoryCheckBox.setVisible(false);
			paint(pmhFamilyHistoryBtn);
		});
		
		
		
		pmhFamilyHistoryBtn.setOnAction((event) -> {

			try {
				String frmName = formPath.context.getMessage("PMHFamilyHistory", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.PMHFamilyHistory", null, Locale.US);
				formPath.closeApplicationContext();
				PMHFamilyHistoryInputController pmhFamilyHistoryInputController = (PMHFamilyHistoryInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				pmhFamilyHistoryInputController.setGenericEMRChartingController(this, pmhSocialHistoryBtn);
				paint(pmhFamilyHistoryBtn);
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		pmhNoSocialHistoryCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nSOCIAL HISTORY:  Social History: No negative social history noted by patient.");
			pmhNoSocialHistoryCheckBox.setVisible(false);
			paint(pmhSocialHistoryBtn);
		});

		pmhSocialHistoryBtn.setOnAction((event) -> {

			try {
				String frmName = formPath.context.getMessage("PMHSocialHistory", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.PMHSocialHistory", null, Locale.US);
				formPath.closeApplicationContext();
				PMHSocialHistoryInputController pmhSocialHistoryInputController = (PMHSocialHistoryInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				pmhSocialHistoryInputController.setGenericEMRChartingController(this, pmhSocialHistoryBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		pmhNoWorkHistoryCheckBox.setOnAction((event) -> {
			setPmhTextArea("\n\nWORK HISTORY:  Employment/Work History: No employment details noted by patient.");
			pmhNoWorkHistoryCheckBox.setVisible(false);
			paint(pmhWorkHistoryBtn);
		});

		pmhWorkHistoryBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("PMHWorkHistory", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.PMHWorkHistory", null, Locale.US);
				formPath.closeApplicationContext();
				PMHWorkHistoryInputController pmhWorkHistoryInputController = (PMHWorkHistoryInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				pmhWorkHistoryInputController.setGenericEMRChartingController(this, pmhWorkHistoryBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		// ####### Start ROS Tab Button and Check Box Functionality ######

		rosConstCheckBox.setOnAction((event) -> {

			if (rosConstCheckBox.isSelected()) {

				rosConstBtn.setDisable(true);
				rosConstDeniesCheckBox.setDisable(true);

			} else {
				rosConstBtn.setDisable(false);
				rosConstDeniesCheckBox.setDisable(false);
			}

		});

		rosConstBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSConst", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSConst", null, Locale.US);
				formPath.closeApplicationContext();

				RosConstitutionalInputController constitutionalInputController = (RosConstitutionalInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				constitutionalInputController.setGenericEMRChartingController(this, rosConstBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosConstDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\nCONSTITUTIONAL:  Denies change in appetite, fatigue, fever, weakness, weight gain or weight loss.");
			saveAllTextArea();
			rosConstDeniesCheckBox.setVisible(false);
			paint(rosConstBtn);
		});

		rosEyeCheckBox.setOnAction((event) -> {

			if (rosEyeCheckBox.isSelected()) {

				rosEyeBtn.setDisable(true);
				rosEyeDeniesCheckBox.setDisable(true);

			} else {
				rosEyeBtn.setDisable(false);
				rosEyeDeniesCheckBox.setDisable(false);
			}

		});

		rosEyeDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"EYES:  Denies blurred vision, cataracts, dimness, excessive tearing, flashing lights, itching, pain, redness or history of cataracts or glaucoma.");
			saveAllTextArea();
			rosEyeDeniesCheckBox.setVisible(false);
			paint(rosEyeBtn);

		});
		rosEyeBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSEye", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSEye", null, Locale.US);
				formPath.closeApplicationContext();

				RosEyeInputController rosEyeInputController = (RosEyeInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosEyeInputController.setGenericEMRChartingController(this, rosEyeBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosEntCheckBox.setOnAction((event) -> {

			if (rosEntCheckBox.isSelected()) {

				rosEntDeniesCheckBox.setDisable(true);
				rosEntBtn.setDisable(true);

			} else {
				rosEntBtn.setDisable(false);
				rosEntDeniesCheckBox.setDisable(false);
			}
		});
		rosEntBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSEnt", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSEnt", null, Locale.US);
				formPath.closeApplicationContext();

				RosEntInputController rosEntInputController = (RosEntInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosEntInputController.setGenericEMRChartingController(this, rosEntBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosEntDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nEARS, NOSE, MOUTH & THROAT:  Denies bleeding gums, earaches, ear discharge, hay fever or seasonal allergies, hearing loss, hoarseness, nasal discharge or nosebleeds, sinus problems, sore throats, tinnitus or vertigo.");
			saveAllTextArea();
			rosEntDeniesCheckBox.setVisible(false);
			;
			paint(rosEntBtn);

		});

		rosCvCheckBox.setOnAction((event) -> {

			if (rosCvCheckBox.isSelected()) {

				rosCvBtn.setDisable(true);
				rosCvDeniesCheckBox.setDisable(true);

			} else {
				rosCvBtn.setDisable(false);
				rosCvDeniesCheckBox.setDisable(false);
			}

		});
		rosCvBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSCv", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSCv", null, Locale.US);
				formPath.closeApplicationContext();

				RosCvInputController rosCvInputController = (RosCvInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosCvInputController.setGenericEMRChartingController(this, rosCvBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosCvDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nCARDIOVASCULAR:  Denies chest pain or pressure, edema, excessive sweating, heart racing, palpitations, shortness of breath or history of heart murmur, hypertension, rheumatic fever or valve disease.");
			saveAllTextArea();
			rosCvDeniesCheckBox.setVisible(false);
			;
			paint(rosCvBtn);

		});

		rosRespCheckBox.setOnAction((event) -> {

			if (rosRespCheckBox.isSelected()) {

				rosRespBtn.setDisable(true);
				rosRespDeniesCheckBox.setDisable(true);

			} else {
				rosRespBtn.setDisable(false);
				rosRespDeniesCheckBox.setDisable(false);
			}

		});

		rosRespBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSResp", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSResp", null, Locale.US);
				formPath.closeApplicationContext();

				RosRespInputController rosRespInputController = (RosRespInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosRespInputController.setGenericEMRChartingController(this, rosRespBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		rosRespDeniesCheckBox.setOnAction((event) -> {

			setRosTextArea(
					"\n\nRESPIRATORY:  Denies coughing, coughing up blood or phlegm, night sweats, shortness of breath, wheezing or history of asthma, pneumonia or tuberculosis.");
			saveAllTextArea();
			rosRespDeniesCheckBox.setVisible(false);
			;
			paint(rosRespBtn);

		});
		rosGiCheckBox.setOnAction((event) -> {

			if (rosGiCheckBox.isSelected()) {

				rosGiBtn.setDisable(true);
				rosGiDeniesCheckBox.setDisable(true);

			} else {
				rosGiBtn.setDisable(false);
				rosGiDeniesCheckBox.setDisable(false);
			}

		});

		rosGiBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSGi", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSGi", null, Locale.US);
				formPath.closeApplicationContext();

				RosGiInputController rosGiInputController = (RosGiInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosGiInputController.setGenericEMRChartingController(this, rosGiBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		rosGiDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nGASTROINTESTINAL:  Denies abdominal pain, blood in stools or black stools, change in bowel frequency or stool size, constipation, diarrhea, difficulty swallowing, food intolerance, heartburn, nausea, vomiting or need for antacids.");
			saveAllTextArea();
			rosGiDeniesCheckBox.setVisible(false);
			;
			paint(rosGiBtn);

		});

		rosGuCheckBox.setOnAction((event) -> {

			if (rosGuCheckBox.isSelected()) {

				rosGuBtn.setDisable(true);
				rosGuDeniesCheckBox.setDisable(true);

			} else {
				rosGuBtn.setDisable(false);
				rosGuDeniesCheckBox.setDisable(false);
			}

		});

		rosGuBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSGu", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSGu", null, Locale.US);
				formPath.closeApplicationContext();

				RosGuInputController rosGuInputController = (RosGuInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosGuInputController.setGenericEMRChartingController(this, rosGuBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		rosGuDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nGENITOURINARY:  Denies blood in urine, difficulties urinating, frequency of urination, incontinence, or history of kidney stones. No discharge from penis, testicular pain, lumps in testicles or scrotum, or problems with erection or ejaculation.");
			saveAllTextArea();
			rosGuDeniesCheckBox.setVisible(false);
			;
			paint(rosGuBtn);

		});

		rosEndoCheckBox.setOnAction((event) -> {

			if (rosEndoCheckBox.isSelected()) {

				rosEndoBtn.setDisable(true);
				rosEndoDeniesCheckBox.setDisable(true);

			} else {
				rosEndoBtn.setDisable(false);
				rosEndoDeniesCheckBox.setDisable(false);
			}

		});
		rosEndoBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSEndo", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSEndo", null, Locale.US);
				formPath.closeApplicationContext();

				RosEndoInputController rosEndoInputController = (RosEndoInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosEndoInputController.setGenericEMRChartingController(this, rosEndoBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosEndoDeniesCheckBox.setOnAction((event) -> {

			setRosTextArea(
					"\n\nENDOCRINE SYSTEM:  Denies cold or heat intolerance, fatigue, neck swelling, polydipsia or polyuria.");
			saveAllTextArea();
			rosEndoDeniesCheckBox.setVisible(false);
			;
			paint(rosEndoBtn);

		});

		rosSkelCheckBox.setOnAction((event) -> {
			if (rosSkelCheckBox.isSelected()) {
				rosSkelDeniesCheckBox.setDisable(true);
				rosSkelBtn.setDisable(true);
			} else {
				rosSkelBtn.setDisable(false);
				rosSkelDeniesCheckBox.setDisable(false);
			}
		});

		rosSkelBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSShel", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSShel", null, Locale.US);
				formPath.closeApplicationContext();

				RosSkelInputController rosSkelInputController = (RosSkelInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				rosSkelInputController.setGenericEMRChartingController(this, rosSkelBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosSkelDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nMUSCULOSKELETAL:  Denies arthritis, back pain, joint pain, stiffness or swelling, muscle pain, night cramps, weakness or wasting.");
			saveAllTextArea();
			rosSkelDeniesCheckBox.setVisible(false);
			;
			paint(rosSkelBtn);

		});

		rosSkinCheckBox.setOnAction((event) -> {
			if (rosSkinCheckBox.isSelected()) {
				rosSkinDeniesCheckBox.setDisable(true);
				rosSkinBtn.setDisable(true);

			} else {
				rosSkinDeniesCheckBox.setDisable(false);
				rosSkinBtn.setDisable(false);
			}

		});

		rosSkinBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSSkin", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSSkin", null, Locale.US);
				formPath.closeApplicationContext();

				SkinInputController skinInputController = (SkinInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				skinInputController.setGenericEMRChartingController(this, rosSkinBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosSkinDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nSKIN:  Denies abnormal hair growth, bleeding, change in color or size of moles, easy bruising, itching, hair loss, rash, or history of skin cancer or severe sunburn.");
			saveAllTextArea();
			rosSkinDeniesCheckBox.setVisible(false);
			;
			paint(rosSkinBtn);

		});

		rosNeuroCheckBox.setOnAction((event) -> {
			if (rosNeuroCheckBox.isSelected()) {

				rosNeuroDeniesCheckBox.setDisable(true);
				rosNeuroBtn.setDisable(true);

			} else {
				rosNeuroDeniesCheckBox.setDisable(false);
				rosNeuroBtn.setDisable(false);

			}

		});

		rosNeuroBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSNeuro", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSNeuro", null, Locale.US);
				formPath.closeApplicationContext();

				NeuroInputController neuroInputController = (NeuroInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				neuroInputController.setGenericEMRChartingController(this, rosNeuroBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosNeuroDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nNEUROLOGICAL:  Denies blackouts, dysarthria, dizziness, double vision, fainting, headaches, loss of balance, coordination or sensation, motor weakness, paralysis, tingling, prickling, numbness or tremors.");
			saveAllTextArea();
			rosNeuroDeniesCheckBox.setVisible(false);
			;
			paint(rosNeuroBtn);

		});

		rosPsychCheckBox.setOnAction((event) -> {
			if (rosPsychCheckBox.isSelected()) {
				rosPsychDeniesCheckBox.setDisable(true);
				rosPsychBtn.setDisable(true);

			} else {
				rosPsychDeniesCheckBox.setDisable(false);
				rosPsychBtn.setDisable(false);

			}

		});

		rosPsychBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSPsych", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSPsych", null, Locale.US);
				formPath.closeApplicationContext();

				PsychInputController psychInputController = (PsychInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				psychInputController.setGenericEMRChartingController(this, rosPsychBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosPsychDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nPSYCHIATRIC:  Denies anxiety, depression, difficulty remembering things or thinking, hallucinations, insomnia, irritability, panic, suicidal thought or history of psych hospitalizations or suicide attempts.");
			saveAllTextArea();
			rosPsychDeniesCheckBox.setVisible(false);
			;
			paint(rosPsychBtn);

		});

		rosHeCheckBox.setOnAction((event) -> {
			if (rosHeCheckBox.isSelected()) {
				rosHeDeniesCheckBox.setDisable(true);
				rosHeBtn.setDisable(true);

			} else {
				rosHeDeniesCheckBox.setDisable(false);
				rosHeBtn.setDisable(false);

			}

		});

		rosHeBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSHeLy", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSHeLy", null, Locale.US);
				formPath.closeApplicationContext();

				HeLyInputController heLyInputController = (HeLyInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				heLyInputController.setGenericEMRChartingController(this, rosHeBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		rosHeDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nHEMATOLOGIC / LYMPHATIC:  Denies easy bleeding or bruising, history of anemia, or swollen lymph nodes,");
			saveAllTextArea();
			rosHeDeniesCheckBox.setVisible(false);
			;
			paint(rosHeBtn);

		});

		rosAllCheckBox.setOnAction((event) -> {
			if (rosAllCheckBox.isSelected()) {
				rosAllDeniesCheckBox.setDisable(true);
				rosAllBtn.setDisable(true);

			} else {
				rosAllDeniesCheckBox.setDisable(false);
				rosAllBtn.setDisable(false);

			}

		});

		rosAllBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ROSAllIm", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ROSAllIm", null, Locale.US);
				formPath.closeApplicationContext();

				AllImInputController allImInputController = (AllImInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				allImInputController.setGenericEMRChartingController(this, rosAllBtn);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		rosAllDeniesCheckBox.setOnAction((event) -> {
			setRosTextArea(
					"\n\nALLERGIC / IMMUNOLOGIC:  Denies rhinitis, hay fever, itchy eyes, urticaria, angioedema, or sensitivity to foods or drugs..");
			saveAllTextArea();
			rosAllDeniesCheckBox.setVisible(false);
			;
			paint(rosAllBtn);

		});

		// ####### END ROS Tab Button and Check Box Functionality ######

		// ####### Start EXAM Tab Button and Check Box Functionality ######

		examOrganGiCheckBox.setOnAction((event) -> {

			if (examOrganGiCheckBox.isSelected()) {

				examOrganGiBtn.setDisable(true);
				examOrganGiNormalCheckBox.setDisable(true);

			} else {
				examOrganGiBtn.setDisable(false);
				examOrganGiNormalCheckBox.setDisable(false);

			}

		});

		examOrganGiBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("EXAMgi", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.EXAMgi", null, Locale.US);
				formPath.closeApplicationContext();

				ExamGIinputController examGIinputController = (ExamGIinputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				examGIinputController.setGenericEMRChartingController(this, examOrganGiBtn, examOrganGiNormalCheckBox);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		examOrganGiNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n GI/ABDOMEN: The patient's abdomen was inspected for signs of distention, surgical scars, or ascites.  Bowel sounds were evaluated.  The patient's abdomen was then palpated in each of four quadrants, including palpation for RLQ tenderness, any rebound or tenderness in any part.  No abnormal findings.  ");
			saveAllTextArea();
			examOrganGiNormalCheckBox.setVisible(false);
			paint(examOrganGiBtn);
		});

		examOrganGuCheckBox.setOnAction((event) -> {

			if (examOrganGuCheckBox.isSelected()) {

				examOrganGuBtn.setDisable(true);
				examOrganGuNormalCheckBox.setDisable(true);

			} else {
				examOrganGuBtn.setDisable(false);
				examOrganGuNormalCheckBox.setDisable(false);

			}

		});

		examOrganGuBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ExamGu", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ExamGu", null, Locale.US);
				formPath.closeApplicationContext();

				GUInputController guInputController = (GUInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				guInputController.setGenericEMRChartingController(this, examOrganGuBtn, examOrganGuNormalCheckBox);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		examOrganGuNormalCheckBox.setOnAction((event) -> {

			setExamOrganTextArea(
					"\n\nGU Male: Exam shows normal testes, normal penis, prostate not enlarged and without masses.");
			saveAllTextArea();
			examOrganGuNormalCheckBox.setVisible(false);
			paint(examOrganGuBtn);
			if (examOrganGuNormalCheckBox.isSelected()) {
				examOrganGuBtn.setDisable(false);
			} else {
				examOrganGuBtn.setDisable(true);
			}

		});

		examOrganSkelCheckBox.setOnAction((event) -> {

			if (examOrganSkelCheckBox.isSelected()) {

				examOrganSkelBtn.setDisable(true);
				examOrganSkelNormalCheckBox.setDisable(true);

			} else {
				examOrganSkelBtn.setDisable(false);
				examOrganSkelNormalCheckBox.setDisable(false);

			}

		});
		examOrganSkelBtn.setOnAction((event) -> {
			try {
				String frmName = formPath.context.getMessage("ExamSkel", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ExamSkel", null, Locale.US);
				formPath.closeApplicationContext();

				MSkelInputController msSkelInputController = (MSkelInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				msSkelInputController.setGenericEMRChartingController(this, examOrganSkelBtn,
						examOrganSkelNormalCheckBox);

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		examOrganSkelNormalCheckBox.setOnAction((event) -> {

			setExamOrganTextArea(
					"\n\nMUSCULOSKELETAL:  Patient was noted to be walking normally, and station and coordination normal. "
							+ " Inspection and palpation show digits and nails normal.   Strength and tone grossly normal UE/LE."
							+ "       BACK/FLANK: The patients back was inspected for scoliosis, kyphosis, or lordosis.  "
							+ "Hematoma and/or abrasions were noted if present. The spine was palpated for any point tenderness in both "
							+ "thoracic spine and lumbar 1 through 5, and sacral spine area. "
							+ " Perivertebral muscles were palpated.  Any abnormal range of motion was noted.  "
							+ "CVA was palpated.  No abnormal findings.");
			saveAllTextArea();
			examOrganSkelNormalCheckBox.setVisible(false);
			paint(examOrganGuBtn);
			if (examOrganSkelNormalCheckBox.isSelected()) {
				examOrganSkelBtn.setDisable(false);
			} else {
				examOrganSkelBtn.setDisable(true);
			}

		});

		examOrganSkinCheckBox.setOnAction((event) -> {

			if (examOrganSkinCheckBox.isSelected()) {

				examOrganSkinBtn.setDisable(true);
				examOrganSkinNormalCheckBox.setDisable(true);

			} else {
				examOrganSkinBtn.setDisable(false);
				examOrganSkinNormalCheckBox.setDisable(false);

			}

		});

		examOrganSkinNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nSKIN: Patient's skin was examined for signs of central cyanosis or peripheral cyanosis. Any skin abnormality such as diffuse ecchymosis, lesions, uticaria, erythema or induration were noted.  No abnormal findings.");
			examOrganSkinNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examOrganSkinBtn);
		});

		examOrganSkinBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamSkin", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamSkin", null, Locale.US);
				formPath.closeApplicationContext();

				ExamSkinInputController examSkinInputController = (ExamSkinInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examSkinInputController.setGenericEMRChartingController(this, examOrganSkinBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganNeuroNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nNEUROLOGIC:  Neurological exam showed normal reflexes and sensation.  Face was examined for asymmetry caused by Cranial nerve weakness.  Patient observed for equal movement of all four extremities.  Any sensory deficits were elicited.  No abnormal findings.");
			saveAllTextArea();
			examOrganNeuroNormalCheckBox.setVisible(false);
			paint(examOrganNeuroBtn);
		});

		examOrganNeuroBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamNeuro", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamNeuro", null, Locale.US);
				formPath.closeApplicationContext();

				com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController neuroInputController = (com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				neuroInputController.setGenericEMRChartingController(this, examOrganNeuroBtn,
						examOrganNeuroNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganNeuroCheckBox.setOnAction((event) -> {

			if (examOrganNeuroCheckBox.isSelected()) {

				examOrganNeuroBtn.setDisable(true);
				examOrganNeuroNormalCheckBox.setDisable(true);

			} else {
				examOrganNeuroBtn.setDisable(false);
				examOrganNeuroNormalCheckBox.setDisable(false);

			}

		});

		examOrganPsychNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nPSYCH:  Patient's insight and judgment appear good, and mood, affect and speech normal.  The patient's orientation to person, place and time were evaluated.  No abnormal findings.");
			saveAllTextArea();
			examOrganPsychNormalCheckBox.setVisible(false);
			paint(examOrganPsychBtn);
		});

		examOrganPsychBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamPsych", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamPsych", null, Locale.US);
				formPath.closeApplicationContext();

				ExamPsychInputController examPsychInputController = (ExamPsychInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examPsychInputController.setGenericEMRChartingController(this, examOrganPsychBtn,
						examOrganPsychNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganPsychCheckBox.setOnAction((event) -> {

			if (examOrganPsychCheckBox.isSelected()) {

				examOrganPsychBtn.setDisable(true);
				examOrganPsychNormalCheckBox.setDisable(true);

			} else {
				examOrganPsychBtn.setDisable(false);
				examOrganPsychNormalCheckBox.setDisable(false);

			}

		});

		examOrganNormalHeCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nLYMPHATIC: No cyanosis, swelling, delayed capillary refill.  No lymphadenopathy noted in the neck, axilla, groin or other areas.");
			saveAllTextArea();
			examOrganNormalHeCheckBox.setVisible(false);
			paint(examOrganHeBtn);
		});

		examOrganHeBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamLymph", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamLymph", null, Locale.US);
				formPath.closeApplicationContext();

				LymphInputController lymphInputController = (LymphInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				lymphInputController.setGenericEMRChartingController(this, examOrganHeBtn, examOrganNormalHeCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganHeCheckBox.setOnAction((event) -> {

			if (examOrganHeCheckBox.isSelected()) {

				examOrganHeBtn.setDisable(true);
				examOrganNormalHeCheckBox.setDisable(true);

			} else {
				examOrganHeBtn.setDisable(false);
				examOrganNormalHeCheckBox.setDisable(false);

			}

		});

		examOrganConstCheckBox.setOnAction((event) -> {

			if (examOrganConstCheckBox.isSelected()) {

				examOrganConstBtn.setDisable(true);
				examOrganCheckBox.setDisable(true);

			} else {
				examOrganConstBtn.setDisable(false);
				examOrganCheckBox.setDisable(false);

			}

		});

		examOrganConstBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamConstitutional", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamConstitutional", null, Locale.US);
				formPath.closeApplicationContext();

				ExamConstutionalInputController examConstutionalInputController = (ExamConstutionalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examConstutionalInputController.setGenericEMRChartingController(this, examOrganConstBtn,
						examOrganCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nCONSTITUTIONAL: The general appearance and condition of the patient were examined.  Level of distress, nutrition, external development abnormality, and general behavior were noted.  No abnormal findings.  Vital signs as documented.");
			saveAllTextArea();
			examOrganCheckBox.setVisible(false);
			paint(examOrganConstBtn);
		});

		examOrganEyeCheckBox.setOnAction((event) -> {

			if (examOrganEyeCheckBox.isSelected()) {

				examOrganEyeBtn.setDisable(true);
				examOrganEyeNormalCheckBox.setDisable(true);

			} else {
				examOrganEyeBtn.setDisable(false);
				examOrganEyeNormalCheckBox.setDisable(false);

			}

		});

		examOrganEyeBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamEye", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamEye", null, Locale.US);
				formPath.closeApplicationContext();

				ExamEyeInputController eyeInputController = (ExamEyeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				eyeInputController.setGenericEMRChartingController(this, examOrganEyeBtn, examOrganEyeNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganEyeNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nEYES: Patient examined for extraocular movements, symmetry of pupils, and reactivity to light.  Sclera and conjunctivae examined for hemorrhage, injection or inflammation, or presence of F/B.  Gross vision/VF were examined bilaterally. No Abnormal findings.");
			saveAllTextArea();
			examOrganEyeNormalCheckBox.setVisible(false);
			paint(examOrganEyeBtn);
		});

		examOrganEntNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nEARS : Patient ears were examined for pain, tenderness, or swelling of external ear, cartilage and pinna.  Gross hearing was determined at conversational level. External ear canal was examined for presence or absence of cerumen impaction, redness, discharge, debris or signs of otitis externa. Tympanic membrane examined for light reflex, and abnormal signs or TM redness, bulging or fluid behind TM, or perforation. No significant abnormal findings noted.\n\n\nTHROAT/TEETH/MOUTH/SINUS: Patient examined for gross facial swelling, tenderness of frontal or maxillary sinuses.  Examined for stridor or drooling and ability to handle secretions.  Lips and gingiva examined for hydration or lesions.  Dentition noted in exam. The presence or absence of tonsils was examined for swelling, redness, or presence of pus.  Posterior pharynx examined for redness, pebbling, swelling or discharge. No significant abnormal findings noted..");
			saveAllTextArea();
			examOrganEntNormalCheckBox.setVisible(false);
			paint(examOrganEntBtn);
		});

		examOrganEntBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamEnt", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamEnt", null, Locale.US);
				formPath.closeApplicationContext();

				ExamEntInputController entInputController = (ExamEntInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				entInputController.setGenericEMRChartingController(this, examOrganEntBtn, examOrganEntNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganEntCheckBox.setOnAction((event) -> {

			if (examOrganEntCheckBox.isSelected()) {

				examOrganEntBtn.setDisable(true);
				examOrganEntNormalCheckBox.setDisable(true);

			} else {
				examOrganEntBtn.setDisable(false);
				examOrganEntNormalCheckBox.setDisable(false);

			}

		});

		clinicianInBtn.setOnAction((event) -> {

		});

		examOrganNeckCheckBox.setOnAction((event) -> {

			if (examOrganNeckCheckBox.isSelected()) {

				examOrganNeckBtn.setDisable(true);
				examOrganNormalNeckCheckBox1.setDisable(true);

			} else {
				examOrganNeckBtn.setDisable(false);
				examOrganNormalNeckCheckBox1.setDisable(false);

			}

		});

		examOrganNeckBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamNeck", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamNeck", null, Locale.US);
				formPath.closeApplicationContext();

				ExamNeckInputController examNeckInputController = (ExamNeckInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examNeckInputController.setGenericEMRChartingController(this, examOrganNeckBtn,
						examOrganNormalNeckCheckBox1);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganNormalNeckCheckBox1.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nNECK: Patient examined for tracheal deviation, goiter, JVD or other signs of neck swelling.  Patient examined for signs of neck stiffness or meningeal signs.  Patient checked for abnormal posterior lymphadenopathy.  Post cervical spine tenderness and range of motion was evaluated.  No abnormal findings.");
			examOrganNormalNeckCheckBox1.setVisible(false);
			saveAllTextArea();
			paint(examOrganNeckBtn);
		});

		examOrganRespCheckBox.setOnAction((event) -> {

			if (examOrganRespCheckBox.isSelected()) {

				examOrganRespBtn.setDisable(true);
				examOrganRespNormalCheckBox.setDisable(true);

			} else {
				examOrganRespBtn.setDisable(false);
				examOrganRespNormalCheckBox.setDisable(false);

			}

		});

		examOrganRespBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamResp", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamResp", null, Locale.US);
				formPath.closeApplicationContext();

				ExamRespInputController examRespInputController = (ExamRespInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examRespInputController.setGenericEMRChartingController(this, examOrganRespBtn,
						examOrganRespNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganRespNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nRESPIRATORY/LUNGS: Chest examined for equal movement, bilaterally.  Lungs examined for equality of breath sounds. Presence or absence of rales noted bilaterally.  Examined for the presence of diffuse or scattered wheezes.  No abnormal findings.\n\nCHEST WALL: Patient chest examined for deformities or pectus abnormalities. Breathing observed for signs of intercostal retractions, splinting or use of accessory muscles.  No abnormal findings.");
			saveAllTextArea();
			examOrganRespNormalCheckBox.setVisible(false);
			paint(examOrganRespBtn);
		});

		examOrganCvCheckBox.setOnAction((event) -> {

			if (examOrganCvCheckBox.isSelected()) {

				examOrganCvBtn.setDisable(true);
				examOrganCvNormalCheckBox.setDisable(true);

			} else {
				examOrganCvBtn.setDisable(false);
				examOrganCvNormalCheckBox.setDisable(false);

			}

		});

		examOrganCvBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamCV", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamCV", null, Locale.US);
				formPath.closeApplicationContext();

				ExamCvInputController cvInputController = (ExamCvInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				cvInputController.setGenericEMRChartingController(this, examOrganCvBtn, examOrganCvNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examOrganCvNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nCARDIOVASCULAR: The patient's heart examined for regular rate and rhythm and presence of murmurs. Note taken of any tachycardia, bradycardia or any irregular rhythm.  No abnormal findings.  Carotid arteries, aorta, femoral pusles, pedal pulses are normal, and no edema or varicosities are noted.  Jugular venous distension not noted.");
			saveAllTextArea();
			examOrganCvNormalCheckBox.setVisible(false);
			paint(examOrganCvBtn);

		});

		examOrganEndoCheckBox.setOnAction((event) -> {

			if (examOrganEndoCheckBox.isSelected()) {

				examChestBtn.setDisable(true);
				examChestCheck.setDisable(true);

			} else {
				examChestBtn.setDisable(false);
				examChestCheck.setDisable(false);

			}

		});

		examChestBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamChest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamChest", null, Locale.US);
				formPath.closeApplicationContext();

				ExamChestInputController examChestInputController = (ExamChestInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				examChestInputController.setGenericEMRChartingController(this, examChestBtn, examChestCheck);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examChestCheck.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nBREASTS: Inspection reveals no abnormalities bilaterally. Palpation of breasts show no masses bilaterally, and no axillary adenopathy.");
			saveAllTextArea();
			examChestCheck.setVisible(false);
			paint(examChestBtn);
		});

		// ################## Muscle Tab###################

		examMusculoskeletalHeadCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalHeadCheckBox.isSelected()) {

				examMusculoskeletalHeadBtn.setDisable(true);
				examMusculoskeletalHeadNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalHeadBtn.setDisable(false);
				examMusculoskeletalHeadNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalHeadBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonHead", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHead", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneHeadInputController musculotoneHeadInputController = (ExamMusculotoneHeadInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneHeadInputController.setGenericEMRChartingController(this, examMusculoskeletalHeadBtn,
						examMusculoskeletalHeadNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalHeadNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nHead is normocephalic, atraumatic, and without deformity, tenderness, masses, ecchymosis or lacerations. Face shows normal tone and strength, and salivary glands and sinuses normal.");
			examMusculoskeletalHeadNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalHeadBtn);
		});

		examMusculoskeletalNeckCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalNeckCheckBox.isSelected()) {

				examMusculoskeletalNeckBtn.setDisable(true);
				examMusculoskeletalNeckNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalNeckBtn.setDisable(false);
				examMusculoskeletalNeckNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalNeckBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonNeck", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonNeck", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneNeckInputController musculotoneNeckInputController = (ExamMusculotoneNeckInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneNeckInputController.setGenericEMRChartingController(this, examMusculoskeletalNeckBtn,
						examMusculoskeletalNeckNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalNeckNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nExamination of the neck shows no skin abnormalities or tenderness. Neck is supple with full range of motion.");
			examMusculoskeletalNeckNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalNeckBtn);
		});

		examMusculoskeletalChestCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalChestCheckBox.isSelected()) {

				examMusculoskeletalChestBtn.setDisable(true);
				examMusculoskeletalChestNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalChestBtn.setDisable(false);
				examMusculoskeletalChestNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalChestBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonChest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonChest", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneChestInputController musculotoneChestInputController = (ExamMusculotoneChestInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneChestInputController.setGenericEMRChartingController(this, examMusculoskeletalChestBtn,
						examMusculoskeletalChestNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalChestNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nExamination of the ribs shows symmetrical movement, normal breath sounds, and no signs of abrasions, ecchymosis or lacerations.");
			examMusculoskeletalChestNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalChestBtn);
		});

		examMusculoskeletalBackCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalBackCheckBox.isSelected()) {

				examMusculoskeletalBackBtn.setDisable(true);
				examMusculoskeletalBackNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalBackBtn.setDisable(false);
				examMusculoskeletalBackNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalBackBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonBack", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonBack", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneBackController musculotoneBackController = (ExamMusculotoneBackController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneBackController.setGenericEMRChartingController(this, examMusculoskeletalBackBtn,
						examMusculoskeletalBackNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalBackNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nBack shows no deformity or tenderness. Range of motion is normal and without pain. Heel and toe walk normal. Reflexes are symmetric and SLR negative bilaterally.");
			saveAllTextArea();
			examMusculoskeletalBackNormalCheckBox.setVisible(false);
			paint(examMusculoskeletalBackBtn);
		});

		examMusculoskeletalHipCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalHipCheckBox.isSelected()) {

				examMusculoskeletalHipBtn.setDisable(true);
				examMusculoskeletalHipNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalHipBtn.setDisable(false);
				examMusculoskeletalHipNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalHipBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonHip", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonHip", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneHipInputController musculotoneHipInputController = (ExamMusculotoneHipInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneHipInputController.setGenericEMRChartingController(this, examMusculoskeletalHipBtn,
						examMusculoskeletalHipNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalHipNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea("\n\n");
			examMusculoskeletalHipNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalHipBtn);
		});

		examMusculoskeletalShoulderCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalShoulderCheckBox.isSelected()) {

				examMusculoskeletalShoulderBtn.setDisable(true);
				examMusculoskeletalShoulderNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalShoulderBtn.setDisable(false);
				examMusculoskeletalShoulderNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalShoulderBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonShoulder", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonShoulder", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneShoulderInputController musculotoneShoulderInputController = (ExamMusculotoneShoulderInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneShoulderInputController.setGenericEMRChartingController(this, examMusculoskeletalShoulderBtn,
						examMusculoskeletalShoulderNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalShoulderNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea(
					"\n\nExamination showed left shoulder normal, with full range of motion, no tenderness and no crepitation.");
			examMusculoskeletalShoulderNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalShoulderBtn);
		});

		examMusculoskeletalElbowCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalElbowCheckBox.isSelected()) {

				examMusculoskeletalElbowBtn.setDisable(true);
				examMusculoskeletalElbowNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalElbowBtn.setDisable(false);
				examMusculoskeletalElbowNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalElbowBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonElbow", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonElbow", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneElbowInputController musculotoneElbowInputController = (ExamMusculotoneElbowInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneElbowInputController.setGenericEMRChartingController(this, examMusculoskeletalElbowBtn,
						examMusculoskeletalElbowNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalElbowNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea("\n\n");
			examMusculoskeletalElbowNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalElbowBtn);
		});

		examMusculoskeletalForearmCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalForearmCheckBox.isSelected()) {

				examMusculoskeletalForearmBtn.setDisable(true);
				examMusculoskeletalForearmNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalForearmBtn.setDisable(false);
				examMusculoskeletalForearmNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalForearmBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonForearm", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonForearm", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneForearmInputController musculotoneForearmInputController = (ExamMusculotoneForearmInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneForearmInputController.setGenericEMRChartingController(this, examMusculoskeletalForearmBtn,
						examMusculoskeletalForearmNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalForearmNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea("\n\n");
			examMusculoskeletalForearmNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalForearmBtn);
		});

		examMusculoskeletalKneeCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalKneeCheckBox.isSelected()) {

				examMusculoskeletalKneeBtn.setDisable(true);
				examMusculoskeletalKneeNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalKneeBtn.setDisable(false);
				examMusculoskeletalKneeNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalKneeBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonKnee", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonKnee", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneKneeInputController musculotoneKneeInputController = (ExamMusculotoneKneeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneKneeInputController.setGenericEMRChartingController(this, examMusculoskeletalKneeBtn,
						examMusculoskeletalKneeNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalKneeNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea("\n\n");
			examMusculoskeletalKneeNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalKneeBtn);
		});

		examMusculoskeletalAnkleCheckBox.setOnAction((event) -> {

			if (examMusculoskeletalAnkleCheckBox.isSelected()) {

				examMusculoskeletalAnkleBtn.setDisable(true);
				examMusculoskeletalAnkleNormalCheckBox.setDisable(true);

			} else {
				examMusculoskeletalAnkleBtn.setDisable(false);
				examMusculoskeletalAnkleNormalCheckBox.setDisable(false);

			}

		});

		examMusculoskeletalAnkleBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExamMusculoSkeletonAnkle", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonAnkle", null, Locale.US);
				formPath.closeApplicationContext();

				ExamMusculotoneAnkleInputController musculotoneAnkleInputController = (ExamMusculotoneAnkleInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				musculotoneAnkleInputController.setGenericEMRChartingController(this, examMusculoskeletalAnkleBtn,
						examMusculoskeletalAnkleNormalCheckBox);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		examMusculoskeletalAnkleNormalCheckBox.setOnAction((event) -> {
			setExamOrganTextArea("\n\n");
			examMusculoskeletalAnkleNormalCheckBox.setVisible(false);
			saveAllTextArea();
			paint(examMusculoskeletalAnkleBtn);
		});

		// ####### End EXAM Tab Button and Check Box Functionality ######

		/*
		 * examMusculoskeletalAnkleCheckBox.setOnAction((event)-> {
		 * 
		 * if(examOrganGuCheckBox.isSelected()){
		 * 
		 * examOrganGuBtn.setDisable(true);
		 * examOrganGuNormalCheckBox.setDisable(true);
		 * 
		 * }else{ examOrganGuBtn.setDisable(false);
		 * examOrganGuNormalCheckBox.setDisable(false);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * } );
		 * 
		 * examOrganGuBtn.setOnAction((event)-> { try{ String
		 * frmName=formPath.context.getMessage("ExamGu", null,Locale.US); String
		 * frmTitle = formPath.context.getMessage("Title.ExamGu", null,
		 * Locale.US); formPath.closeApplicationContext();
		 * 
		 * GUInputController guInputController = (GUInputController) new
		 * FXFormCommonUtilities().displayForm(frmName, frmTitle);
		 * guInputController.setGenericEMRChartingController(this,
		 * examOrganGuBtn);
		 * 
		 * }catch(Exception e){ e.printStackTrace(); }
		 * 
		 * } );
		 * 
		 * 
		 * examOrganGuNormalCheckBox.setOnAction((event)-> {
		 * 
		 * setExamOrganTextArea(
		 * "\n\nGU Male: Exam shows normal testes, normal penis, prostate not enlarged and without masses."
		 * ); examOrganGuNormalCheckBox.setVisible(false);
		 * paint(examOrganGuBtn); if(examOrganGuNormalCheckBox.isSelected()){
		 * examOrganGuBtn.setDisable(false); } else{
		 * examOrganGuBtn.setDisable(true); }
		 * 
		 * 
		 * });
		 */

		assesmentAddBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("AssesmentICD10", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.AssesmentICD10", null, Locale.US);
				formPath.closeApplicationContext();
				ICD10SearchController icd10SearchController = (ICD10SearchController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				icd10SearchController.setGenericEMRChartingController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		assesmenDeleteBtn.setOnAction((event) -> {

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer assesmentIndex = assesmentTable.getSelectionModel().getSelectedIndex();

				if (assesmentIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == ButtonType.OK) {

						Assesment assesment = new AssessmentEntityController().view().get(assesmentIndex);
						new AssessmentEntityController().delete(assesment.getId());

						viewAssesmenttable();

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

		OrderDiagonosticTestBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderDiagonosticTest", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderDiagonosticTest", null, Locale.US);
				formPath.closeApplicationContext();
				OrderDiagonosticTestInputController diagonosticTestInputController = (OrderDiagonosticTestInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				diagonosticTestInputController.setGenericEMRChartingController(this, OrderDiagonosticTestBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		OrderotherDataSourceButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderOtherData", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderOtherData", null, Locale.US);
				formPath.closeApplicationContext();
				OrderOtherDataSourceInputController orderOtherDataSourceInputController = (OrderOtherDataSourceInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				orderOtherDataSourceInputController.setGenericEMRChartingController(this, OrderotherDataSourceButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		

		OrderPatientLocalMeasureButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderPatientLocal", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderPatientLocalPatientLocalMeasure", null,
						Locale.US);
				formPath.closeApplicationContext();
				OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController = (OrderPatientLocalMeasureInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				orderPatientLocalMeasureInputController.setGenericEMRChartingController(this,
						OrderPatientLocalMeasureButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		OrderWorkRestrictionButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderWorkRestriction", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderWorkRestriction", null, Locale.US);
				formPath.closeApplicationContext();
				OrderWorkRestrictionInputController orderWorkRestrictionInputController = (OrderWorkRestrictionInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				orderWorkRestrictionInputController.setGenericEMRChartingController(this, OrderWorkRestrictionButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		OrderConsultButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderConsult", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderConsult", null, Locale.US);
				formPath.closeApplicationContext();
				OrderConsultInputController orderConsultInputController = (OrderConsultInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				orderConsultInputController.setGenericEMRChartingController(this, OrderConsultButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buildNoteBtn.setOnAction((event) -> {
			try {

				forBuildNote();

				String frmName = formPath.context.getMessage("BuildNote", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.BuildNote", null, Locale.US);
				formPath.closeApplicationContext();
				patientVisitComplaintStr = patientVisitComplaintTextArea.getText();
				System.out.println("String is :  " + patientVisitComplaintStr);

				BuildNoteViewController buildNoteViewController = new BuildNoteViewController();
				buildNoteViewController.setGenericEMRChartingController(this);
				buildNoteViewController = (BuildNoteViewController) new FXFormCommonUtilities().displayForm(frmName,
						frmTitle);
				/*
				 * BuildNoteViewController buildNoteViewController =
				 * (BuildNoteViewController) new FXFormCommonUtilities()
				 * .displayForm(frmName, frmTitle);
				 * 
				 * buildNoteViewController.setGenericEMRChartingController(this
				 * ,str );
				 */

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		ResultDiagonosisTestBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("Result", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.Result", null, Locale.US);
				formPath.closeApplicationContext();
				ResultInputController resultDiagonosisInputController = (ResultInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				resultDiagonosisInputController.setGenericEMRChartingController(this, ResultDiagonosisTestBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		durableMedicalEquipButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderDurableMedicalEquipment", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderDurableMedicalEquipment", null, Locale.US);
				formPath.closeApplicationContext();
				OrderDurableMedicalEquipmentInputController durableMedicalEquipmentInputController = (OrderDurableMedicalEquipmentInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				durableMedicalEquipmentInputController.setGenericEMRChartingController(this, durableMedicalEquipButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		workStatusAssessmentButton.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("EMRWorkStatus", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.EMRWorkStatus", null, Locale.US);
				formPath.closeApplicationContext();
				EMRWorkStatusInputController emrWorkStatusInputController = (EMRWorkStatusInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				emrWorkStatusInputController.setGenericEMRChartingController(this, workStatusAssessmentButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*
		 * hpiStartOverButton.setOnAction((event) -> { try {
		 * 
		 * new EmrHpiEntityController().delete("EmrHpi");
		 * 
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } });
		 */

		OrderMedicationBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("OrderMedication", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.OrderMedication", null, Locale.US);
				formPath.closeApplicationContext();
				MedicationInputController medicationInputController = (MedicationInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				medicationInputController.setGenericEMRChartingController(this, OrderMedicationBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicianInBtn.setOnAction((event) -> {

			System.out.println(new Date());
			String str = new Date().toString();
			String str1[] = str.split(" ");

			// String timeIs =
			clinicianInText.setText(str1[3]);

		});

		providerInBtn.setOnAction((event) -> {
			System.out.println(new Date());
			String str = new Date().toString();
			String str1[] = str.split(" ");

			providerInText.setText(str1[3]);

		});
		clinicianOutbtn.setOnAction((event) -> {
			System.out.println(new Date());
			String str = new Date().toString();
			String str1[] = str.split(" ");

			clinicianOutText.setText(str1[3]);

		});

		providerOutbtn.setOnAction((event) -> {
			System.out.println(new Date());
			String str = new Date().toString();
			String str1[] = str.split(" ");

			providerOutText.setText(str1[3]);

		});
		InstructionReturnFollowUpBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("ReturnFollowUp", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.ReturnFollowUp", null, Locale.US);
				formPath.closeApplicationContext();
				InstructionReturnFollowUpInputController instructionReturnFollowUpInputController = (InstructionReturnFollowUpInputController) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				instructionReturnFollowUpInputController.setGenericEMRChartingController(this,
						InstructionReturnFollowUpBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		patientInstructionBtn.setOnAction((event) -> {
			try {

				String frmName = formPath.context.getMessage("PatientInstruction", null, Locale.US);
				String frmTitle = formPath.context.getMessage("Title.PatientInstruction", null, Locale.US);
				formPath.closeApplicationContext();
				InstructionPatientInstInputCotroller instructionPatientInstInputCotroller = (InstructionPatientInstInputCotroller) new FXFormCommonUtilities()
						.displayForm(frmName, frmTitle);
				instructionPatientInstInputCotroller.setGenericEMRChartingController(this, patientInstructionBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		

		chargesBtn.setOnAction((event) -> {
			try {
				//visitType=visitTypeChoiceBox.getSelectionModel().getSelectedItem();
				
				String formName = formPath.context.getMessage("ViewMedicalActivityCharge", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicalActivityCharge", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				/*MedicalActivityChargeViewController  medicalActivityChargeViewController =
				(MedicalActivityChargeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				medicalActivityChargeViewController.setVisitLogInputController(this);*/
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

pastNotesbtn.setOnAction((event) -> {
	try {

		String frmName = formPath.context.getMessage("viewBuildNote", null, Locale.US);
		String frmTitle = formPath.context.getMessage("Title.viewBuildNote", null, Locale.US);
		formPath.closeApplicationContext();
		PastBuildNoteViewController pastBuildNoteViewController = (PastBuildNoteViewController) new FXFormCommonUtilities()
				.displayForm(frmName, frmTitle);
		pastBuildNoteViewController.setGenericEMRChartingController(this);


	} catch (Exception ex) {
		ex.printStackTrace();
	}
});
		
		appoinmentBtn.setOnAction((event) -> {
			try {
				
				
				String formName = formPath.context.getMessage("AppointmentDetails", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.AppointmentDetails", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle = formTitle1+"/"+formTitle2;
				
				formPath.closeApplicationContext();
				
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		


		doneBtn.setOnAction((event) -> {
			try {
				/*
				 * for (EmrChartingTextAreaSave emr : emrTextAreaSave) {
				 * areaSave.setId(emr.getId());
				 * areaSave.setPatientVisit(Global.patientVisit);
				 * areaSave.setRosTextArea(rosTextArea.getText());
				 * areaSave.setTextArea(hpiTextArea.getText());
				 * 
				 * 
				 * } new HpiTextAreaEntityController().saveOrUpdate(areaSave);
				 */
				EmrChartingTextAreaSave areaSave1 = new EmrChartingTextAreaSave();

				areaSave1.setId(areaSave.getId());
				areaSave1.setTextArea(hpiTextArea.getText());
				areaSave1.setRosTextArea(rosTextArea.getText());
				areaSave1.setPmhTextArea(pmhTextArea.getText());
				areaSave1.setOrderTextArea(orderTextAres.getText());
				areaSave1.setExamTextArea(examOrganTextArea.getText());
				areaSave1.setResultTextArea(resultTextArea.getText());
				areaSave1.setInstructionTextArea(instructionTextArea.getText());
				areaSave1.setWorkStatusTextArea(workStatusTextArea.getText());
				areaSave1.setProcedureTextArea(procedureTextArea.getText());
				areaSave1.setClinicianIn(clinicianInText.getText());
				areaSave1.setClinicianOut(clinicianOutText.getText());
				areaSave1.setProviderIn(providerInText.getText());
				areaSave1.setProviderOut(providerOutText.getText());
				areaSave1.setPatientVisitComplaint(patientVisitComplaintTextArea.getText());
				areaSave1.setOrderTextArea(orderTextAres.getText());
				areaSave1.setAssessmentTextArea(assesmentTextArea.getText());
				// areaSave1.setDateOfInjury(dateOfInjury.getValue().toString());

				if (twoPatientIdentificationVerifiedText.isSelected()) {
					areaSave1.setTwoPatientIdentifiedVarify("true");
				}

				if (tbdNAradioBtn1.isSelected()) {
					areaSave1.setPatientType("TBD/NA");

				}
				if (newText.isSelected()) {
					areaSave1.setPatientType("New");

				}
				if (estabText.isSelected()) {
					areaSave1.setPatientType("Estab");

				}
				if (consultText.isSelected()) {
					areaSave1.setPatientType("consult");

				}
				if (preventtext.isSelected()) {
					areaSave1.setPatientType("prevent");

				}
				if (telePhoneText.isSelected()) {
					areaSave1.setPatientType("telephone");

				}

				if (tbdNAradiobtn2.isSelected()) {
					areaSave1.setLevelOfVisit("TBD/NA");

				}
				if (level1Text.isSelected()) {
					areaSave1.setLevelOfVisit("Level 1");

				}
				if (level2Text.isSelected()) {
					areaSave1.setLevelOfVisit("Level 2");

				}
				if (level3Text.isSelected()) {
					areaSave1.setLevelOfVisit("Level 3");

				}
				if (level4Text.isSelected()) {
					areaSave1.setLevelOfVisit("Level 4");

				}
				if (level5Text.isSelected()) {
					areaSave1.setLevelOfVisit("level 5");

				}

				System.out
						.println("Work Status is : -----" + workStatusChoiceBox.getSelectionModel().getSelectedItem());
				areaSave1.setWorkStatusChoice(workStatusChoiceBox.getSelectionModel().getSelectedItem());

				// System.out.println("YYYYYYYY
				// "+workstatusAsOfDate.getValue().toString());
				// areaSave1.setWorkStatusAsOf(workstatusAsOfDate.getValue().toString());

				/*
				 * LocalDate localDate2 = workstatusAsOfDate.getValue();
				 * if(localDate2 != null){
				 * 
				 * Date date2 =
				 * Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).
				 * toInstant());
				 * 
				 * areaSave1.setWorkStatusAsOf(date2); }
				 */
				// areaSave1.setWorkStatusAsOf(formattedString);

				LocalDate localDate = workstatusAsOfDate.getValue();
				if (localDate != null) {

					Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

					areaSave1.setWorkStatusAsOf(date);

				}
				LocalDate localdateOfInjury = dateOfInjury.getValue();
				if (localdateOfInjury != null) {

					Date date = Date.from(localdateOfInjury.atStartOfDay(ZoneId.systemDefault()).toInstant());

					areaSave1.setDateOfInjury(date);

				}

				LocalDate localDate1 = instNextVisitDate.getValue();
				if (localDate1 != null) {

					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

					areaSave1.setInstructionNextVisitDate(date1);

				}

				areaSave1.setInstructionNextVisitTime(timeText.getText());

				if (InstPatConditionStable.isSelected()) {
					areaSave1.setInstructionPatientCondition(InstPatConditionStable.getText());

				}

				if (InstPatConditionUnsatable.isSelected()) {
					areaSave1.setInstructionPatientCondition(InstPatConditionStable.getText());

				}

				areaSave1.setInstructionAmbulatoryStatus(InstAmbulatoryChoice.getSelectionModel().getSelectedItem());
				areaSave1.setInstructionDischargeDestination(
						InstDischrgDestination.getSelectionModel().getSelectedItem());

				areaSave1.setPatientVisit(Global.patientVisitObj);

				System.out.println(examOrganTextArea.getText());

				System.out.println(Global.patientVisitObj.getId());

				new HpiTextAreaEntityController().saveOrUpdate(areaSave1);
				new FXFormCommonUtilities().closeForm(doneBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}


}
