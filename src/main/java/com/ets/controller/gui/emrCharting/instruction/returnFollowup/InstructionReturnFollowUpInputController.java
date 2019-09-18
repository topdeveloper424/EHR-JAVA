package com.ets.controller.gui.emrCharting.instruction.returnFollowup;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.workStatus.WorkstatucWorkRelatednessInputController;
import com.ets.controller.gui.emrCharting.workStatus.WorkstatusPrognosisInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class InstructionReturnFollowUpInputController implements Initializable {
	  @FXML
	    private CheckBox RC_pcpReferral;

	    @FXML
	    private CheckBox RcEmergency;

	    @FXML
	    private CheckBox RcReturnTomorrow;

	    @FXML
	    private CheckBox RcReturn2Days;

	    @FXML
	    private CheckBox RcReturn3Days;

	    @FXML
	    private CheckBox RcReturn4Days;

	    @FXML
	    private CheckBox RcReturn5Days;

	    @FXML
	    private CheckBox RcReturn7Days;

	    @FXML
	    private CheckBox RcReturn2Months;

	    @FXML
	    private CheckBox RcReturn1Months;

	    @FXML
	    private CheckBox Rc_pcpUrgent;

	    @FXML
	    private CheckBox RcReturnIn10Days;

	    @FXML
	    private CheckBox RcReturnForFollowupAfterInjury;

	    @FXML
	    private CheckBox RcWcFollowUPDateSpecific;

	    @FXML
	    private CheckBox RcReturnForFollowUp;

	    @FXML
	    private CheckBox RcReturnAsNeeded;

	    @FXML
	    private CheckBox RcReturn3Months;

	    @FXML
	    private CheckBox RcReturn2DaysForWoundCheck;

	    @FXML
	    private CheckBox RcReturn2Weeks;

	    @FXML
	    private CheckBox RcReturnForFastingLabs;

	    @FXML
	    private Button FreeTextButton;

	    @FXML
	    private Button skipButton;

	    @FXML
	    private Button DoneButton;
	    private GenericEMRChartingController genericEMRChartingController;
		private Button button;
		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,Button button) {
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
			
			
			public void setWorkStatusUI(){
				
				if(Rc_pcpUrgent.isSelected()){
					
					formCountIncrement();
					String formName = formPath.context.getMessage("PcpErReferalUrentCare", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.PcpErReferalUrentCare", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;

					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					PcpUrgentCareInputController pcpUrgentCareInputController = (PcpUrgentCareInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					pcpUrgentCareInputController.setInstructionReturnFollowUpInputController(this);

					Rc_pcpUrgent.setSelected(false);
					
				}else if (RC_pcpReferral.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("PcpReferralWorkComp", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.PcpReferralWorkComp", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;


					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					PcpReferalWorkCompInputController pcpReferalWorkCompInputController = (PcpReferalWorkCompInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					pcpReferalWorkCompInputController.setInstructionReturnFollowUpInputController(this);

					RC_pcpReferral.setSelected(false);

				}else if (RcEmergency.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("EmergencyRoomAdmission", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.EmergencyRoomAdmission", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;


					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					EmergencyRoomInputController emergencyRoomInputController = (EmergencyRoomInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					emergencyRoomInputController.setInstructionReturnFollowUpInputController(this);

					RcEmergency.setSelected(false);

				}else if (RcReturnTomorrow.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("Return to the clinic tomorrow for follow-up. ");
	 				str = str1.toString();
	 				RcReturnTomorrow.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn2Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 2 days; return sooner if problems worsen. ");
	 				str = str1.toString();
	 				RcReturn2Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn3Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 3 days; return sooner if problems worsen.");
	 				str = str1.toString();
	 				RcReturn3Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn4Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 4 days; return sooner if problems worsen. ");
	 				str = str1.toString();
	 				RcReturn4Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn5Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 5 days; return sooner if problems worsen. ");
	 				str = str1.toString();
	 				RcReturn5Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn7Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 7 days return sooner if problems worsen ");
	 				str = str1.toString();
	 				RcReturn7Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn2Weeks.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 2 weeks; return sooner if problems worsen.");
	 				str = str1.toString();
	 				RcReturn2Weeks.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn1Months.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 30 days, return sooner if problems worsen. ");
	 				str = str1.toString();
	 				RcReturn1Months.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn2Months.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 2 months; return sooner if problems worsen.");
	 				str = str1.toString();
	 				RcReturn2Months.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn3Months.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up in 3 months; return sooner if problems worsen.");
	 				str = str1.toString();
	 				RcReturn3Months.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturnAsNeeded.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("Patient advised to return for follow-up as needed.");
	 				str = str1.toString();
	 				RcReturnAsNeeded.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturnForFastingLabs.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("I recommended follow-up as soon as possible for fasting labs.");
	 				str = str1.toString();
	 				RcReturnForFastingLabs.setSelected(false);

	 				setWorkStatusUI();

				}
				else if (RcReturnForFollowUp.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("ReturnForFollowUpDays", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.ReturnForFollowUpDays", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;


					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					ReturnForFollowUpDaysInputController returnForFollowUpDaysInputController = (ReturnForFollowUpDaysInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					returnForFollowUpDaysInputController.setInstructionReturnFollowUpInputController(this);

					RcReturnForFollowUp.setSelected(false);

				}
				
				else if (RcWcFollowUPDateSpecific.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("wcFollowUp", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.wcFollowUp", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;


					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					WcFollowUpInputController wcFollowUpInputController = (WcFollowUpInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					wcFollowUpInputController.setInstructionReturnFollowUpInputController(this);

					RcWcFollowUPDateSpecific.setSelected(false);

				}
				
				else if (RcReturnForFollowupAfterInjury.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("ReturnOrFollowUpAfterInjury", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.ReturnOrFollowUpAfterInjury", null, Locale.US);

					String formTitle2 = null;
					String formTitle3 = null;
					String formTitle4 = null;


					if (Global.patientVisitObj != null) {

						formTitle2 = Global.patientVisitObj.getPatient().getPatientName().getFirstName();
						formTitle3 = Global.patientVisitObj.getPatient().getPatientName().getMiddleName();
						formTitle4 = Global.patientVisitObj.getPatient().getPatientName().getLastName();

					}
					String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
					formPath.closeApplicationContext();

					ReturnForFollowUpAfterInjuryInputController rcAfterInjuryInputController = (ReturnForFollowUpAfterInjuryInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					rcAfterInjuryInputController.setInstructionReturnFollowUpInputController(this);

					RcReturnForFollowupAfterInjury.setSelected(false);

				}else if (RcReturnIn10Days.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("Follow-up in 10 days for suture removal.");
	 				str = str1.toString();
	 				RcReturnIn10Days.setSelected(false);

	 				setWorkStatusUI();

				}else if (RcReturn2DaysForWoundCheck.isSelected()) {
	 				StringBuilder str1 = new StringBuilder(str);
	 				str1.append("Follow-up in 2 days for wound check.");
	 				str = str1.toString();
	 				RcReturn2DaysForWoundCheck.setSelected(false);

	 				setWorkStatusUI();

				}
				else if (secondFormCount == formCount) {

	 	 				genericEMRChartingController.paint(button);

	 	 				formCount = 0;
	 	 				genericEMRChartingController.setInstructionTextArea(str);
	 	 				genericEMRChartingController.saveAllTextArea();
	 	 				new FXFormCommonUtilities().closeForm(DoneButton);

	 	 			}
	 	 			
	 			}	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		DoneButton.setOnAction((event) -> {

			setWorkStatusUI();
			

		});
		skipButton.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipButton);

		});
		
	}

	
	
	
	
}
