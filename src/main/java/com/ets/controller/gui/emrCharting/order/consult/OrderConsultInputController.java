package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.allergy.AspirinInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.BarbituratesInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderConsultInputController implements Initializable{

    @FXML
    private CheckBox ConsultRRTransfer;

    @FXML
    private CheckBox consultPCP_UC;

    @FXML
    private CheckBox ConsultAcupunture;

    @FXML
    private CheckBox consultAllergist;

    @FXML
    private CheckBox consultAudiologist;

    @FXML
    private CheckBox ConsultBone;

    @FXML
    private CheckBox ConsultCardiologist;

    @FXML
    private CheckBox consultChiropractic;

    @FXML
    private CheckBox coonsultDermatologist;

    @FXML
    private CheckBox consultEMG;
    @FXML
    private CheckBox consultDietitian;

    @FXML
    private CheckBox consultHandSpecilist;

    @FXML
    private CheckBox consultNCV;

    @FXML
    private CheckBox consultNeurologist;

    @FXML
    private CheckBox consultNutritionist;

    @FXML
    private CheckBox consultOncologist;

    @FXML
    private CheckBox consultOrthoEMG_NVC;

    @FXML
    private CheckBox consultOrthopedicConsult;

    @FXML
    private CheckBox consultOrthopedist;

    @FXML
    private CheckBox consultPain;

    @FXML
    private CheckBox consultPCP;

    @FXML
    private CheckBox WorkOtherLimitation;

    @FXML
    private CheckBox consultPhysicalTherapy;

    @FXML
    private CheckBox ConsultPodiatrist;

    @FXML
    private CheckBox consultOptometrist;

    @FXML
    private CheckBox consultOtolaryngology;

    @FXML
    private CheckBox consultDiabetes;

    @FXML
    private CheckBox consultGastroenterologist;

    @FXML
    private CheckBox ConsultGeneralSurvey;

    @FXML
    private CheckBox consultGynecologist;

    @FXML
    private CheckBox consultOpthalmologist;

    @FXML
    private CheckBox consultPsychiatric;

    @FXML
    private CheckBox consultPsychologist;

    @FXML
    private CheckBox consultPulmonologist;

    @FXML
    private CheckBox consultQMEConsultation;

    @FXML
    private CheckBox consultRequestReferralPCP;

    @FXML
    private CheckBox ConsultRheumatologist;

    @FXML
    private CheckBox consultSpeechTherapy;

    @FXML
    private CheckBox consltUrologistReferral;

    @FXML
    private CheckBox consultWellness;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;

    
    @FXML
    private CheckBox consultPMR;


	private Button button;
	
	public GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	public static Integer formCount = 0;

	private Integer secondFormCount = 0;

	public static String str = "\n\n";


	void formCountIncrement() {
		++secondFormCount;
	}

	public void setConsultUI() {
		
		if(ConsultRRTransfer.isSelected()){
			
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderConsultErTransfer", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			ConsultErTransferInputController consultErTransferInputController = (ConsultErTransferInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultErTransferInputController.setOrderConsultInputController(this);

			ConsultRRTransfer.setSelected(false);
			
		}else if (consultPCP_UC.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderConsultPcpUc", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			ConsultPcpUcInputController consultPcpUcInputController = (ConsultPcpUcInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultPcpUcInputController.setOrderConsultInputController(this);

			consultPCP_UC.setSelected(false);

		}
		else if (ConsultAcupunture.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderConsultAcupunctureReferal", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			ConsultAcupunctureReferalInputController consultAcupunctureReferalInputController = (ConsultAcupunctureReferalInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultAcupunctureReferalInputController.setOrderConsultInputController(this);

			ConsultAcupunture.setSelected(false);

		}
		
		else if (consultAllergist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified allergist/immunologist.");
			str = str1.toString();
			consultAllergist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultAudiologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified audiologist. ");
			str = str1.toString();
			consultAudiologist.setSelected(false);

			setConsultUI();

		}
		
		else if (ConsultBone.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderConsultBoneScan", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			ConsultBoneScanInputController consultBoneScanInputController = (ConsultBoneScanInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultBoneScanInputController.setOrderConsultInputController(this);

			ConsultBone.setSelected(false);

		}
		
		else if (ConsultCardiologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified cardiologist. ");
			str = str1.toString();
			ConsultCardiologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultChiropractic.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation and treatment with a qualified chiropractor. ");
			str = str1.toString();
			consultChiropractic.setSelected(false);

			setConsultUI();

		}else if (coonsultDermatologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified dermatologist. ");
			str = str1.toString();
			coonsultDermatologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultDiabetes.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified diabetes educator. ");
			str = str1.toString();
			consultDiabetes.setSelected(false);

			setConsultUI();

		}
		else if (consultDietitian.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified dietitian.");
			str = str1.toString();
			consultDietitian.setSelected(false);

			setConsultUI();

		}
		else if (consultEMG.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified physician to perform an EMG.");
			str = str1.toString();
			consultEMG.setSelected(false);

			setConsultUI();

		}
		
		else if (consultGastroenterologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified gastroenterologist. ");
			str = str1.toString();
			consultGastroenterologist.setSelected(false);

			setConsultUI();

		}else if (ConsultGeneralSurvey.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified general surgeon. ");
			str = str1.toString();
			ConsultGeneralSurvey.setSelected(false);

			setConsultUI();

		}
		
		else if (consultGynecologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified gynecologist.");
			str = str1.toString();
			consultGynecologist.setSelected(false);

			setConsultUI();

		}else if (consultHandSpecilist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended referral to a qualified hand specialist. ");
			str = str1.toString();
			consultHandSpecilist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultNCV.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified physician to perform a Nerve Conduction Velocity examination.");
			str = str1.toString();
			consultNCV.setSelected(false);

			setConsultUI();

		}else if (consultNeurologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified neurologist. ");
			str = str1.toString();
			consultNeurologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultNutritionist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified nutritionist. ");
			str = str1.toString();
			consultNutritionist.setSelected(false);

			setConsultUI();

		}else if (consultOncologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(". I recommended a consultation with a qualified oncologist. ");
			str = str1.toString();
			consultOncologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultOpthalmologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified opthalmologist. ");
			str = str1.toString();
			consultOpthalmologist.setSelected(false);

			setConsultUI();

		}else if (consultOptometrist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified optometrist. ");
			str = str1.toString();
			consultOptometrist.setSelected(false);

			setConsultUI();

		}
		
		
		
		else if (consultOrthoEMG_NVC.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderConsultOrthoOMG", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			ConsultOrthoOmgInputController consultOrthoOmgInputController = (ConsultOrthoOmgInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultOrthoOmgInputController.setOrderConsultInputController(this);

			consultOrthoEMG_NVC.setSelected(false);

		}
		
		
		else if (consultOrthopedicConsult.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified orthopedic surgeon.");
			str = str1.toString();
			consultOrthopedicConsult.setSelected(false);

			setConsultUI();

		}
		
		
		else if (consultOrthopedist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended referral to a qualified orthopedist. ");
			str = str1.toString();
			consultOrthopedist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultOtolaryngology.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified otolaryngologist. ");
			str = str1.toString();
			consultOtolaryngology.setSelected(false);

			setConsultUI();

		}else if (consultPain.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified pain specialist. ");
			str = str1.toString();
			consultPain.setSelected(false);

			setConsultUI();

		}
		
		else if (consultPCP.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I referred the patient to the primary care physician of record.");
			str = str1.toString();
			consultPCP.setSelected(false);

			setConsultUI();

		}else if (consultPhysicalTherapy.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified physical therapist. ");
			str = str1.toString();
			consultPhysicalTherapy.setSelected(false);

			setConsultUI();

		}
		
		else if (consultPMR.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended referral to a qualified PM&R specialist.");
			str = str1.toString();
			consultPMR.setSelected(false);

			setConsultUI();

		}else if (ConsultPodiatrist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified podiatrist. ");
			str = str1.toString();
			ConsultPodiatrist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultPsychiatric.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified psychiatrist. ");
			str = str1.toString();
			consultPsychiatric.setSelected(false);

			setConsultUI();

		}else if (consultPsychologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified psychologist. ");
			str = str1.toString();
			consultPsychologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultPulmonologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified psychologist. ");
			str = str1.toString();
			consultPulmonologist.setSelected(false);

			setConsultUI();

		}else if (consultQMEConsultation.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified QME. ");
			str = str1.toString();
			consultQMEConsultation.setSelected(false);

			setConsultUI();

		}
		
		else if (consultRequestReferralPCP.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient requests to be seen. They cannot get in to see own doctor today and asks that we get referral from PCP so that we may be able to treat this patient without having to send them to the Emergency room.");
			str = str1.toString();
			consultRequestReferralPCP.setSelected(false);

			setConsultUI();

		}else if (ConsultRheumatologist.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified rheumatologist.");
			str = str1.toString();
			ConsultRheumatologist.setSelected(false);

			setConsultUI();

		}
		
		else if (consultSpeechTherapy.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified speech therapist. ");
			str = str1.toString();
			consultSpeechTherapy.setSelected(false);

			setConsultUI();

		}else if (consltUrologistReferral.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("I recommended a consultation with a qualified urologist. ");
			str = str1.toString();
			consltUrologistReferral.setSelected(false);

			setConsultUI();

		}
		
		else if (consultWellness.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append(" I recommended a consultation with a qualified wellness educator. ");
			str = str1.toString();
			consultWellness.setSelected(false);

			setConsultUI();

		}
		
		
		else if (secondFormCount == formCount) {

			genericEMRChartingController.paint(button);

			formCount = 0;
			genericEMRChartingController.setOrderTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(doneBtn);

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event) -> {

			setConsultUI();
			

		});
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});

		
	}

}
