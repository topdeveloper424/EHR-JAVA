package com.ets.controller.gui.emrCharting.pmh;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.allergy.AllergyFreeTextController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.FamilyHistoryFreeTextController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.FamilyHistorySignificantInputController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.FamilyHistorySurveyInputController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.FatherCauseInputController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.MotherCauseInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHFamilyHistoryInputController implements Initializable {
	
	 @FXML
	    private CheckBox significantFamilyHistoryCheck;

	    @FXML
	    private CheckBox FamilyHistorySurveyCheck;

	    @FXML
	    private CheckBox motherCauseDeathCheck;

	    @FXML
	    private CheckBox fatherCauseDeathCheck;

	    @FXML
	    private CheckBox athmaCheck;

	    @FXML
	    private CheckBox CronaryHeartDiseaseCheck;

	    @FXML
	    private CheckBox highBloodCheck;

	    @FXML
	    private CheckBox strokeTiaCheck;

	    @FXML
	    private CheckBox diabetesCheck;

	    @FXML
	    private CheckBox abnormalCheck;

	    @FXML
	    private CheckBox BreastCancerCheck;

	    @FXML
	    private CheckBox ColonCancerCheck;

	    @FXML
	    private CheckBox LungCancerCheck;

	    @FXML
	    private CheckBox OvarianCancerCheck;

	    @FXML
	    private CheckBox ProstateCancerCheck;

	    @FXML
	    private CheckBox RheumatoidArthritisCheck;

	    @FXML
	    private CheckBox ThyroidDiseaseCheck;

	    @FXML
	    private Button SkipButton;

	    @FXML
	    private Button DoneButton;
	    
	    @FXML
	    private Button freeTextBtn;
	    
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
	    public static String str="\n";
	    public static String strForFreeText="";
	  

		
		void formCountIncrement() {
			++secondFormCount;
		}
		
		
	/*	public void setFamilyHistoryUI() {

			if (ThyroidDiseaseCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(str);
				str1.append("Patient claims to have no known drug allergies or adverse reactions");
				str = str1.toString();
				ThyroidDiseaseCheck.setSelected(false);
				setFamilyHistoryUI();
			} else if (diabetesCheck.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient claims to have no known allergies.");
			str = str1.toString();
			diabetesCheck.setSelected(false);

			setFamilyHistoryUI();

		}
		
		}*/
		
		
		
		
		
		public void setFamilyHistoryUI(){
	    	
	    	 if (significantFamilyHistoryCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHFamilyHistorySignificant", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHFamilyHistorySignificant", null, Locale.US);

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

				FamilyHistorySignificantInputController familyHistorySignificantInputController = (FamilyHistorySignificantInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				familyHistorySignificantInputController.setpMHFamilyHistoryInputController(this);

				significantFamilyHistoryCheck.setSelected(false);

			}else if (FamilyHistorySurveyCheck.isSelected()) {
					formCountIncrement();
					String formName = formPath.context.getMessage("PMHFamilyHistorySurvey", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.PMHFamilyHistorySurvey", null, Locale.US);

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

					FamilyHistorySurveyInputController familyHistorySurveyInputController = (FamilyHistorySurveyInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					familyHistorySurveyInputController.setpMHFamilyHistoryInputController(this);

					FamilyHistorySurveyCheck.setSelected(false);

				} 
			else if (motherCauseDeathCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHMotherCause", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHMotherCause", null, Locale.US);

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

				MotherCauseInputController motherCauseInputController = (MotherCauseInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				motherCauseInputController.setpMHFamilyHistoryInputController(this);

				motherCauseDeathCheck.setSelected(false);

			} else if (fatherCauseDeathCheck.isSelected()) {
				
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHFatherCause", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHFatherCause", null, Locale.US);

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

				FatherCauseInputController fatherCauseInputController = (FatherCauseInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				fatherCauseInputController.setpMHFamilyHistoryInputController(this);

				fatherCauseDeathCheck.setSelected(false);

			} else if (athmaCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Asthma. ");
				str = str1.toString();
				
				athmaCheck.setSelected(false);
				setFamilyHistoryUI();

				

			} else if (CronaryHeartDiseaseCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of coronary heart disease. ");
				str = str1.toString();
				
				CronaryHeartDiseaseCheck.setSelected(false);
				setFamilyHistoryUI();

			} else if (strokeTiaCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of Stroke or TIA. ");
				str = str1.toString();
						
				strokeTiaCheck.setSelected(false);
				setFamilyHistoryUI();

			} else if (diabetesCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family historyh of diabetes. ");
				str = str1.toString();
				
				diabetesCheck.setSelected(false);
				setFamilyHistoryUI();

			}
			else if (highBloodCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of high blood pressure. ");
				str = str1.toString();
				
				highBloodCheck.setSelected(false);
				setFamilyHistoryUI();

			}else if (abnormalCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of high cholesterol or abnormal lipids. ");
				str = str1.toString();
				abnormalCheck.setSelected(false);
				
				setFamilyHistoryUI();

			}else if (BreastCancerCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of breast cancer. ");
				str = str1.toString();
				BreastCancerCheck.setSelected(false);
				
				setFamilyHistoryUI();

			}else if (ColonCancerCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of colon cancer. ");
				str = str1.toString();
				
				ColonCancerCheck.setSelected(false);
				setFamilyHistoryUI();

				
				
			} else if (LungCancerCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of lung cancer. ");
				str = str1.toString();
				
				LungCancerCheck.setSelected(false);
				setFamilyHistoryUI();

			} else if (OvarianCancerCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of ovarian cancer. ");
				str = str1.toString();
				
				OvarianCancerCheck.setSelected(false);
				setFamilyHistoryUI();

			} else if (ProstateCancerCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of prostate cancer. ");
				str = str1.toString();
				
				ProstateCancerCheck.setSelected(false);
				setFamilyHistoryUI();

			}
			else if (RheumatoidArthritisCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Rheumatoid Arthritis. ");
				str = str1.toString();
				
				RheumatoidArthritisCheck.setSelected(false);
				setFamilyHistoryUI();

			}else if (ThyroidDiseaseCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Family history of thyroid disease.");
				str = str1.toString();
				ThyroidDiseaseCheck.setSelected(false);
				
				setFamilyHistoryUI();
			}
			else if (secondFormCount == formCount) {
	    		
				genericEMRChartingController.paint(button);
				
				formCount = 0;
				genericEMRChartingController.setPmhTextArea(str);
				genericEMRChartingController.saveAllTextArea();
				new FXFormCommonUtilities().closeForm(DoneButton);
			

			}
	    	
	    }
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	/*	DoneButton.setOnAction((event)->
		{
			genericEMRChartingController.paint(button);
			StringBuilder pmhAllergyStr = new StringBuilder(GenericEMRChartingController.str);
			pmhAllergyStr.append("\n");
			GenericEMRChartingController.str = pmhAllergyStr.toString();
			new FXFormCommonUtilities().closeForm(DoneButton);
			setFamilyHistoryUI();
			
			if (athmaCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(GenericEMRChartingController.str);
				str1.append("reacted with anaphylaxis, ");
				GenericEMRChartingController.str = str1.toString();

			}
			
			
			StringBuilder str1 = new StringBuilder(GenericEMRChartingController.str);
			str1.append(".");
			GenericEMRChartingController.str = str1.toString();
		

			++GenericEMRChartingController.formCount;
			GenericEMRChartingController.setFamilyHistoryUI();
			new FXFormCommonUtilities().closeForm(DoneButton);

		});*/
		
	

		/*	DoneButton.setOnAction((event) -> {
				//genericEMRChartingController.paint(button);
				setFamilyHistoryUI();

			});*/
		
		
		
		DoneButton.setOnAction((event) -> {
			try {
				
				setFamilyHistoryUI();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		
		
		
		
		
		SkipButton.setOnAction((event)->
		{
			
			new FXFormCommonUtilities().closeForm(SkipButton);
		
		});
		
		freeTextBtn.setOnAction((event)->
		{

			if (significantFamilyHistoryCheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("significant Family History,");
				strForFreeText = str1.toString();
				significantFamilyHistoryCheck.setSelected(false);

			}

			 if (FamilyHistorySurveyCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Family History Survey,");
				strForFreeText = str1.toString();
				FamilyHistorySurveyCheck.setSelected(false);
			}

			 if (motherCauseDeathCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("mother Cause Death,");
				strForFreeText = str1.toString();
				motherCauseDeathCheck.setSelected(false);
			}

			 if (fatherCauseDeathCheck.isSelected()) {
				 
				     StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("father Cause Death,");
					strForFreeText = str1.toString();
					fatherCauseDeathCheck.setSelected(false);
			}

			 if (athmaCheck.isSelected()) {
				 
				  StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("athma,");
					strForFreeText = str1.toString();
					athmaCheck.setSelected(false);
			}

			 if (CronaryHeartDiseaseCheck.isSelected()) {
				 
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Cronary Heart Disease,");
					strForFreeText = str1.toString();
					CronaryHeartDiseaseCheck.setSelected(false);
			} 
			 
			 if (strokeTiaCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("stroke Tia,");
				strForFreeText = str1.toString();
				strokeTiaCheck.setSelected(false);

			}

			 if (diabetesCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("diabetes,");
					strForFreeText = str1.toString();
					diabetesCheck.setSelected(false);


			}  if (highBloodCheck.isSelected()) {
				
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("high blood,");
					strForFreeText = str1.toString();
					highBloodCheck.setSelected(false);

			}  if (abnormalCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("abnormal,");
					strForFreeText = str1.toString();
					abnormalCheck.setSelected(false);

			}  if (BreastCancerCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Breast Cancer,");
					strForFreeText = str1.toString();
					BreastCancerCheck.setSelected(false);

			}  if (ColonCancerCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Colon Cancer,");
					strForFreeText = str1.toString();
					ColonCancerCheck.setSelected(false);

			}  if (LungCancerCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Lung Cancer,");
					strForFreeText = str1.toString();
					LungCancerCheck.setSelected(false);

			}

			 if (OvarianCancerCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Ovarian Cancer,");
					strForFreeText = str1.toString();
					OvarianCancerCheck.setSelected(false);

			}  if (ProstateCancerCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Prostate Cancer,");
					strForFreeText = str1.toString();
					ProstateCancerCheck.setSelected(false);

			}  if (RheumatoidArthritisCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Rheumatoid Arthritis,");
					strForFreeText = str1.toString();
					RheumatoidArthritisCheck.setSelected(false);

			}  if (ThyroidDiseaseCheck.isSelected()) {
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Thyroid Disease");
					strForFreeText = str1.toString();
					ThyroidDiseaseCheck.setSelected(false);

			}  

			
			String formName = formPath.context.getMessage("PMHFamilyHistoryFreeText", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PMHFamilyHistoryFreeText", null, Locale.US);
			
			
			FamilyHistoryFreeTextController familyHistoryFreeTextController = 
			(FamilyHistoryFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			formPath.closeApplicationContext();
			familyHistoryFreeTextController.setpMHFamilyHistoryInputController(this);
			
			new FXFormCommonUtilities().closeForm(SkipButton);
		
		});
		
		
	}

}
