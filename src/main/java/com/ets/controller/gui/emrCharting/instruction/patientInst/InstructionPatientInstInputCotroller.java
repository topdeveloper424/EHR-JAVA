package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.instruction.returnFollowup.PcpReferalWorkCompInputController;
import com.ets.controller.gui.emrCharting.instruction.returnFollowup.PcpUrgentCareInputController;
import com.ets.controller.gui.emrCharting.instruction.returnFollowup.ReturnForFollowUpAfterInjuryInputController;
import com.ets.controller.gui.emrCharting.pmh.familyHistory.FamilyHistoryFreeTextController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class InstructionPatientInstInputCotroller implements Initializable {

    @FXML
    private CheckBox GeneralPatientInstruction;

    @FXML
    private CheckBox MedicationInstructionCheck;

    @FXML
    private CheckBox ProtectiveMeasuresCheck;

    @FXML
    private CheckBox RICEInstructionCheck;

    @FXML
    private CheckBox RehabHomeExaeciseCheck;

    @FXML
    private CheckBox RehabPlanCheck;

    @FXML
    private CheckBox WeightLossInstructionsCheck;

    @FXML
    private CheckBox WoundInstructionsCheck;

    @FXML
    private CheckBox CoughCheck;

    @FXML
    private CheckBox NonMusculoskeletalCheck;

    @FXML
    private CheckBox DepressionCheck;

    @FXML
    private CheckBox MusculoskeletalCheck;

    @FXML
    private CheckBox CervicalSprainAndStrainCheck;

    @FXML
    private CheckBox HipSynovitisCheck;

    @FXML
    private CheckBox CompressionFractureBackCheck;

    @FXML
    private CheckBox HipReplacementCheck;

    @FXML
    private CheckBox HipHimiarthroplastyCheck;

    @FXML
    private CheckBox HipBrusitisCheck;

    @FXML
    private CheckBox CervicaFusionPreOPCheck;

    @FXML
    private CheckBox CalcificTendonitisCheck;

    @FXML
    private CheckBox CalcaneousFractureCheck;

    @FXML
    private CheckBox ArthritisOsteroarthritisCheck;

    @FXML
    private CheckBox DizzinessCheck;

    @FXML
    private CheckBox WeightCheck;

    @FXML
    private CheckBox PediaticCheck;

    @FXML
    private CheckBox LumbarRadiculopathyCheck;

    @FXML
    private CheckBox MetatarsusAdducutsCheck;

    @FXML
    private CheckBox LumbarFractureCheck;

    @FXML
    private CheckBox LumbarStrainCheck;

    @FXML
    private CheckBox MetatarsalFractureCheck;

    @FXML
    private CheckBox MetatarsalStressCheck;

    @FXML
    private CheckBox ShoulderAcCheck;

    @FXML
    private CheckBox ShoulderArthroscopyCheck;

    @FXML
    private CheckBox ShoulderImmobilizerCheck;

    @FXML
    private CheckBox ShoulderRangeCheck;

    @FXML
    private CheckBox ShoulderSlingCheck;

    @FXML
    private CheckBox ThoracicOutletCheck;

    @FXML
    private CheckBox ThoracicStrainCheck;

    @FXML
    private CheckBox CervicalSpineFractureCheck;

    @FXML
    private Button FreeTextButton;

    @FXML
    private Button skipButton;

    @FXML
    private Button DoneButton;
    
    public static String strForFreeText=" ";
    public GenericEMRChartingController genericEMRChartingController;
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
		
		public void setPatInstUI(){
			
			if(GeneralPatientInstruction.isSelected()){
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Patient was provided general instructions, as documented.  ");
 				str = str1.toString();
 				GeneralPatientInstruction.setSelected(false);

 				setPatInstUI();

				
			}else if (MedicationInstructionCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Patient instructed in proper application, contraindications and safety in taking prescribed medications. ");
 				str = str1.toString();
 				MedicationInstructionCheck.setSelected(false);

 				setPatInstUI();

			}
			else if (ProtectiveMeasuresCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("protectiveMeasures", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.protectiveMeasures", null, Locale.US);

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

				ProtectiveMeasuresInputController protectiveMeasuresInputController = (ProtectiveMeasuresInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				protectiveMeasuresInputController.setInstructionPatientInstInputCotroller(this);

				ProtectiveMeasuresCheck.setSelected(false);

			}
			else if (RICEInstructionCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Patient advised to follow R.I.C.E protocol:  \n1. Rest the affected area as much as possible."
 						+ "\n2. Ice the area for 20 minutes at a time as frequently as you can."
 						+ "\n3. Compression: Wear a compressive wrap (an ACE bandage, brace or splint). "
 						+ "\nIF YOU NOTICE AN INCREASE IN PAIN AND/OR SWELLING OR EXPERIENCE ANY NUMBNESS-YOU MAY NEED TO LOOSEN THE COMPRESSIVE WRAP."
 						+ "\n4. Elevate the area above the level of your heart to decrease swelling."
 						+ "\nThese measures will help minimize swelling to the area which will ease pain and promote healing.");
 				str = str1.toString();
 				RICEInstructionCheck.setSelected(false);

 				setPatInstUI();

			}
			else if (RehabHomeExaeciseCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Patient will continue HEP an instructed in therapy today.");
 				str = str1.toString();
 				RehabHomeExaeciseCheck.setSelected(false);

 				setPatInstUI();

			}
			else if (RehabPlanCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("RehabPlan", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.RehabPlan", null, Locale.US);

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

				RehabPlanInputController rehabPlanInputController = (RehabPlanInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				rehabPlanInputController.setInstructionPatientInstInputCotroller(this);

				RehabPlanCheck.setSelected(false);

			}
			else if (WeightLossInstructionsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Weight Loss Diet Instruction Sheet given.");
 				str = str1.toString();
 				WeightLossInstructionsCheck.setSelected(false);

 				setPatInstUI();
 				
			}
			else if (WoundInstructionsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Wound Instruction Sheet given.");
 				str = str1.toString();
 				WoundInstructionsCheck.setSelected(false);

 				setPatInstUI();

			}else if (MusculoskeletalCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("ExitCareMusculoSkeletal", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExitCareMusculoSkeletal", null, Locale.US);

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

				ExitCareMusculoSkeletalInputController exitCareMusculoSkeletalInputController = (ExitCareMusculoSkeletalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				exitCareMusculoSkeletalInputController.setInstructionPatientInstInputCotroller(this);

				MusculoskeletalCheck.setSelected(false);

			}
			else if (NonMusculoskeletalCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("ExitCareNonMusculoSkeletal", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExitCareNonMusculoSkeletal", null, Locale.US);

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

				ExitCareNonMusculoSkeletalInputController exitCareNonMusculoSkeletalInputController = (ExitCareNonMusculoSkeletalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				exitCareNonMusculoSkeletalInputController.setInstructionPatientInstInputCotroller(this);

				NonMusculoskeletalCheck.setSelected(false);
				
			}else if (PediaticCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("ExitCarePediaTrick", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExitCarePediaTrick", null, Locale.US);

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

				ExitCarePediaTrickInputController exitCarePediaTrickInputController = (ExitCarePediaTrickInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				exitCarePediaTrickInputController.setInstructionPatientInstInputCotroller(this);

				PediaticCheck.setSelected(false);

			}else if (WeightCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("ExitCareWeight", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExitCareWeight", null, Locale.US);

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

				ExitCareWeightInputController exitCareWeightInputController = (ExitCareWeightInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				exitCareWeightInputController.setInstructionPatientInstInputCotroller(this);

				WeightCheck.setSelected(false);

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
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		FreeTextButton.setOnAction((event) ->{
              
			if (ArthritisOsteroarthritisCheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Arthritis Osteroarthritis,");
				strForFreeText = str1.toString();
				ArthritisOsteroarthritisCheck.setSelected(false);

			}
		     
					if (CalcaneousFractureCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Calcaneous Fracture,");
						strForFreeText = str1.toString();
						CalcaneousFractureCheck.setSelected(false);

					}

                 if (CalcificTendonitisCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Calcific Tendonitis,");
						strForFreeText = str1.toString();
						CalcificTendonitisCheck.setSelected(false);

					}  if (CervicaFusionPreOPCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Care-Cervical Fusion Pre-OP,");
						strForFreeText = str1.toString();
						CervicaFusionPreOPCheck.setSelected(false);

					} if (CervicalSpineFractureCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Cervical  Spine  Fracture,");
						strForFreeText = str1.toString();
						CervicalSpineFractureCheck.setSelected(false);

					} if (CervicalSprainAndStrainCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Cervical Sprain And  Strain,");
						strForFreeText = str1.toString();
						CervicalSprainAndStrainCheck.setSelected(false);

					}if (CompressionFractureBackCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care- Compression Fracture,Back,");
						strForFreeText = str1.toString();
						CompressionFractureBackCheck.setSelected(false);

					}if (HipBrusitisCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Hip Brusitis,");
						strForFreeText = str1.toString();
						HipBrusitisCheck.setSelected(false);

					}if (HipHimiarthroplastyCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Hip Himiarthroplasty,");
						strForFreeText = str1.toString();
						HipHimiarthroplastyCheck.setSelected(false);

					}if (HipReplacementCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Hip Replacement,Total,");
						strForFreeText = str1.toString();
						HipReplacementCheck.setSelected(false);

					}
                  if (HipSynovitisCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Hip Synovitis");
						strForFreeText = str1.toString();
						HipSynovitisCheck.setSelected(false);

					}
                  if (LumbarFractureCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Lumbar Fracture");
						strForFreeText = str1.toString();
						LumbarFractureCheck.setSelected(false);

					} if (LumbarRadiculopathyCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Lumbar Radiculopathy,Sciati");
						strForFreeText = str1.toString();
						LumbarRadiculopathyCheck.setSelected(false);

					}if (LumbarStrainCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Lumbar Strain");
						strForFreeText = str1.toString();
						LumbarStrainCheck.setSelected(false);

					}if (MetatarsusAdducutsCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Metatarsus Adducuts,");
						strForFreeText = str1.toString();
						MetatarsusAdducutsCheck.setSelected(false);

					}if (MetatarsalFractureCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Metatarsal Fracture,");
						strForFreeText = str1.toString();
						MetatarsalFractureCheck.setSelected(false);

					}if (MetatarsalStressCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Metatarsal Stress Fracture,");
						strForFreeText = str1.toString();
						MetatarsalStressCheck.setSelected(false);

					}
                  if (ShoulderAcCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Shoulder Ac Separation,");
						strForFreeText = str1.toString();
						ShoulderAcCheck.setSelected(false);

					} if (ShoulderArthroscopyCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Shoulder Arthroscopy,");
						strForFreeText = str1.toString();
						ShoulderArthroscopyCheck.setSelected(false);

					}if (ShoulderImmobilizerCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Shoulder Immobilizer,");
						strForFreeText = str1.toString();
						ShoulderImmobilizerCheck.setSelected(false);

					}if (ShoulderRangeCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Shoulder Range of Motion Exe,");
						strForFreeText = str1.toString();
						ShoulderRangeCheck.setSelected(false);

					}
                    if (ShoulderSlingCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Shoulder  Sling,");
						strForFreeText = str1.toString();
						ShoulderSlingCheck.setSelected(false);

					}   if (ThoracicOutletCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Thoracic Outlet Syndrome,");
						strForFreeText = str1.toString();
						ThoracicOutletCheck.setSelected(false);

					} if (ThoracicStrainCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Exit Care-Thoracic Strain,");
						strForFreeText = str1.toString();
						ThoracicStrainCheck.setSelected(false);

					}
					
					
					

					String formName = formPath.context.getMessage("PatientInstFreeText", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.PatientInstFreeText", null, Locale.US);
					
					
					PatientInstructionFreeTextController patientInstructionFreeTextController = 
					(PatientInstructionFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					formPath.closeApplicationContext();
					patientInstructionFreeTextController.setInstructionPatientInstInputCotroller(this);
					
					new FXFormCommonUtilities().closeForm(FreeTextButton);
		});
		
		
		
		DoneButton.setOnAction((event) -> {

			setPatInstUI();
			

		});
		
		skipButton.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipButton);

		});
		
	}

	
	
	
	
}
