package com.ets.controller.gui.emrCharting.workStatus;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.workRestriction.BendingTwistingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ClimbingInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class EMRWorkStatusInputController  implements Initializable{
	@FXML
    private CheckBox WorkrelatednessWCrequired;

    @FXML
    private CheckBox prognosisWorkStatus;

    @FXML
    private CheckBox WCFollowUp;

    @FXML
    private CheckBox FullyRecovered;

    @FXML
    private CheckBox LaborCodeDisclaimer;

    @FXML
    private Button SkipButton;

    @FXML
    private Button DoneButton;

    @FXML
    private Button freeTextButton;
	
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
			
			if(WorkrelatednessWCrequired.isSelected()){
				
				formCountIncrement();
				String formName = formPath.context.getMessage("WorkStatusWorkRelatedness", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.WorkStatusWorkRelatedness", null, Locale.US);

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

				WorkstatucWorkRelatednessInputController workstatucWorkRelatednessInputController = (WorkstatucWorkRelatednessInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				workstatucWorkRelatednessInputController.setEmrWorkStatusInputController(this);

				WorkrelatednessWCrequired.setSelected(false);
				
			}else if (prognosisWorkStatus.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("WorkStatusPrognosis", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.WorkStatusPrognosis", null, Locale.US);

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

				WorkstatusPrognosisInputController workstatusPrognosisInputController = (WorkstatusPrognosisInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				workstatusPrognosisInputController.setEmrWorkStatusInputController(this);

				prognosisWorkStatus.setSelected(false);

			}
			
			
			else if (WCFollowUp.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("WorkStatusWCFollowUp", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.WorkStatusWCFollowUp", null, Locale.US);

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
				WorkRelatednessWcFollowUpInputController workRelatednessWcFollowUpInputController = (WorkRelatednessWcFollowUpInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				workRelatednessWcFollowUpInputController.setEmrWorkStatusInputController(this);

				WCFollowUp.setSelected(false);

			}
			else if (FullyRecovered.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("vered from the industrial injury and has returned to pre-injury status with no residual subjective complaints or objective impairment."
 						+ " The patient is permanent and stationary. ");
 				str = str1.toString();
 				FullyRecovered.setSelected(false);

 				setWorkStatusUI();


			}else if (LaborCodeDisclaimer.isSelected()) {
 				StringBuilder str1 = new StringBuilder(str);
 				str1.append("I have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge. "
 						+ "This statement is made under penalty of perjury. ");
 				str = str1.toString();
 				LaborCodeDisclaimer.setSelected(false);

 				setWorkStatusUI();

 			}
 			else if (secondFormCount == formCount) {

 				genericEMRChartingController.paint(button);

 				formCount = 0;
 				genericEMRChartingController.setWorkStatusTextArea(str);
 			    genericEMRChartingController.saveAllTextArea();
 				new FXFormCommonUtilities().closeForm(DoneButton);

 			}
 			
		}	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DoneButton.setOnAction((event) -> {

			setWorkStatusUI();
			

		});
		SkipButton.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(SkipButton);

		});
		
	}

	
	
	
	
}
