package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.knee;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckExamComprehensiveInputController Class
 *Description: kneeExamComprehensive.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class KneeExamComprehensiveInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox PresentNormalCkeckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox JointLateralCheck;

	@FXML
	private CheckBox ActionAbductionCheck;

	@FXML
	private CheckBox ActionExtensionCheck;

	@FXML
	private CheckBox ActionFlexionCheck;

	@FXML
	private CheckBox ActionInternalCheck;

	@FXML
	private CheckBox ActionExternalCheck;

	@FXML
	private CheckBox ActionAdductionCheck;

	@FXML
	private CheckBox ActionAllMotionCheck;

	@FXML
	private CheckBox JointMedialCheck;

	@FXML
	private CheckBox PatellaMobileCheck;

	@FXML
	private CheckBox PatellaHyperMobileCheck;

	@FXML
	private CheckBox PatellaLimitedCheck;

	@FXML
	private CheckBox PatellaImMobileCheck;

	@FXML
	private CheckBox JointNoCheck;

	@FXML
	private RadioButton CrepitusNoNotedRadio;

	@FXML
	private ToggleGroup Crepitus;

	@FXML
	private RadioButton CrepitusNotedRadio;

	@FXML
	private CheckBox PatellaNormalCheck;

	@FXML
	private CheckBox OtherModerateNonPittingEdemaCheck;

	@FXML
	private CheckBox OtherModeratePittingEdemaCheck;

	@FXML
	private CheckBox OtherWarmthCheck;

	@FXML
	private CheckBox OtherMildEffusionCheck;

	@FXML
	private CheckBox OtherModerateEffusionCheck;

	@FXML
	private CheckBox OtherSevereEffusionCheck;

	@FXML
	private CheckBox OtherEcchymosisCheck;

	@FXML
	private CheckBox OtherErythemalCheck;

	@FXML
	private CheckBox OtherSevereNonPittingEdemaCheck;

	@FXML
	private CheckBox OtherSeverePittingEdemaCheck;

	@FXML
	private CheckBox CrepitusNormalCheck;

	@FXML
	private CheckBox PainNormalCheck;

	@FXML
	private CheckBox OtherNormalCheck;

	@FXML
	private RadioButton leftRadio;

	@FXML
	private ToggleGroup shoulder;

	@FXML
	private RadioButton rightRadio;

	@FXML
	private CheckBox PainFlexionlCheck;

	@FXML
	private CheckBox PainExtensionCheck;

	@FXML
	private CheckBox PainInternalCheck;

	@FXML
	private CheckBox PainAbductionCheck;

	@FXML
	private CheckBox PainAdductionCheck;

	@FXML
	private CheckBox PainExternalCheck;

	@FXML
	private RadioButton flexionRadio;

	@FXML
	private ToggleGroup knee;

	@FXML
	private RadioButton extensionRadio;

	@FXML
	private CheckBox OtherNonPittingMildEdemaCheck;

	@FXML
	private CheckBox OtherMildPittingEdemaCheck;

	@FXML
	private TextArea locationTextArea;

	@FXML
	private TextArea PresentTextArea;

	@FXML
	private RadioButton AtrophyNotNotedRadio;

	@FXML
	private ToggleGroup Atrophy;

	@FXML
	private RadioButton AtrophyNotedRadio;

	@FXML
	private CheckBox AtrophyNormalCkeckBox;

	@FXML
	private CheckBox LightNormalCheck1;

	@FXML
	private RadioButton MotorSlightlyRadio;

	@FXML
	private ToggleGroup motor;

	@FXML
	private RadioButton MotorModerateRadio;

	@FXML
	private RadioButton MotorMarkdlyRadio;

	@FXML
	private RadioButton MotorAbsentyRadio;

	@FXML
	private CheckBox InspectionNoInjuryCheck;

	@FXML
	private CheckBox InspectionAbrasionsCheck;

	@FXML
	private CheckBox InspectionContitutionsCheck;

	@FXML
	private CheckBox InspectionLacerationCheck;

	@FXML
	private CheckBox InspectionSurgicalCheck;

	@FXML
	private CheckBox InspectionMassesCheck;

	@FXML
	private RadioButton gaitNormalRadio;

	@FXML
	private ToggleGroup gait;

	@FXML
	private RadioButton gaitAntalgicRadio;

	@FXML
	private RadioButton gaitStiffRadio;

	@FXML
	private CheckBox InspectionNormalCheck;

	private ExamMusculotoneKneeInputController examMusculotoneKneeInputController;

	public void setExamMusculotoneKneeInputController(
			ExamMusculotoneKneeInputController examMusculotoneKneeInputController) {
		this.examMusculotoneKneeInputController = examMusculotoneKneeInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneKneeInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL:");
			examMusculotoneKneeInputController.str = examComp.toString();

			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(" An examination of the left knee.  ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(" An examination of the right knee. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			if (flexionRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("Knee is held in flexion at rest.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (extensionRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("Knee is held in extension at rest. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			
			if (InspectionNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" Initial inspection revealed no abrasions, contusions, lacerations, surgical scars or masses. ");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (InspectionAbrasionsCheck.isSelected() || InspectionContitutionsCheck.isSelected()
						|| InspectionLacerationCheck.isSelected() || InspectionMassesCheck.isSelected()
						|| InspectionNoInjuryCheck.isSelected() || InspectionSurgicalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
					str11.append("Initial inspection revealed ");
					examMusculotoneKneeInputController.str = str11.toString();

					if (InspectionAbrasionsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("abrasions, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (InspectionContitutionsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("contusions, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (InspectionLacerationCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("lacerations, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (InspectionMassesCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("no masses present, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (InspectionNoInjuryCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append(" no injuries, scars or masses. ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (InspectionSurgicalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("surgical scarring, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(". ");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (OtherNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" No ecchymosis, swelling, erythema, warmth or effusion. ");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (OtherEcchymosisCheck.isSelected() || OtherErythemalCheck.isSelected()
						|| OtherMildEffusionCheck.isSelected() || OtherMildPittingEdemaCheck.isSelected()
						|| OtherModerateEffusionCheck.isSelected() || OtherModerateNonPittingEdemaCheck.isSelected()
						|| OtherModeratePittingEdemaCheck.isSelected() || OtherNonPittingMildEdemaCheck.isSelected()
						|| OtherSevereEffusionCheck.isSelected() || OtherSevereNonPittingEdemaCheck.isSelected()
						|| OtherSeverePittingEdemaCheck.isSelected() || OtherSevereNonPittingEdemaCheck.isSelected()) {

				
					if (OtherEcchymosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append(" Ecchymosis, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherErythemalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Erythema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherMildEffusionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append(" Mild effusion, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherMildPittingEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Mild pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherModerateEffusionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append(" Moderate effusion, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherModerateNonPittingEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Moderate non-pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherModeratePittingEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Moderate pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					
					if (OtherNonPittingMildEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Mild non-pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}


					if (OtherSevereEffusionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Severe effusion, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherSevereNonPittingEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Severe non-pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (OtherSeverePittingEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("Severe pitting edema, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" noted ");
					examMusculotoneKneeInputController.str = str1.toString();
				}
			}

			if (locationTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(locationTextArea.getText());
				examMusculotoneKneeInputController.str = str1.toString();

			}

			if (PatellaNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" Patella is mobile. ");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (PatellaMobileCheck.isSelected() || PatellaHyperMobileCheck.isSelected()
						|| PatellaLimitedCheck.isSelected() || PatellaImMobileCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
					str11.append("Patella is ");
					examMusculotoneKneeInputController.str = str11.toString();

					if (PatellaMobileCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("mobile, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PatellaHyperMobileCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("hypermobile, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PatellaLimitedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("limited in mobility , ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PatellaImMobileCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append(" immobile ");
						examMusculotoneKneeInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(".");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}
			
			if (JointNoCheck.isSelected() || JointMedialCheck.isSelected() || JointMedialCheck.isSelected()
					|| PatellaImMobileCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append("There was ");
				examMusculotoneKneeInputController.str = str11.toString();

				if (JointNoCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("no, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (JointMedialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("medial, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (JointLateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" lateral joint line");
					examMusculotoneKneeInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("tenderness. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			if (CrepitusNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append("No crepitus noted. ");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (CrepitusNoNotedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Crepitus was not noted.");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (CrepitusNotedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Crepitus was  noted. ");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (PresentNormalCkeckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" ");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (PresentTextArea.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Tenderness is present in "+PresentTextArea.getText());
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (AtrophyNormalCkeckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append("No muscle atrophy was noted.");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (AtrophyNotNotedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Muscle atrophy was not noted.");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (AtrophyNotedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("  Muscle atrophy was not noted.");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (PainNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" No pain on range of motion testing.");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {
				
				if (PainAbductionCheck.isSelected() || PainAdductionCheck.isSelected()
						|| PainExtensionCheck.isSelected() || PainExternalCheck.isSelected()
						|| PainFlexionlCheck.isSelected() || PainInternalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
					str11.append("Pain was noted on  ");
					examMusculotoneKneeInputController.str = str11.toString();

					if (PainAbductionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("abduction, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PainAdductionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("adduction, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PainExtensionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("extension, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PainExternalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("external rotation, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PainFlexionlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("flexion, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}
					if (PainInternalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
						str1.append("internal rotation, ");
						examMusculotoneKneeInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(".");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (LightNormalCheck1.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append(" Muscle strength is within normal limits.");
				examMusculotoneKneeInputController.str = str11.toString();

			} else {

				if (MotorAbsentyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Muscle strength is absent");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (MotorMarkdlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Muscle strength is markedly decreased");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (MotorModerateRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Muscle strength is moderately decreased");
					examMusculotoneKneeInputController.str = str1.toString();
					
				}
				if (MotorSlightlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" Muscle strength is slightly decreased.");
					examMusculotoneKneeInputController.str = str1.toString();

				}

			}

			if (ActionAbductionCheck.isSelected() || ActionAdductionCheck.isSelected()
					|| ActionAllMotionCheck.isSelected() || ActionExtensionCheck.isSelected()
					|| ActionExternalCheck.isSelected() || ActionFlexionCheck.isSelected()
					|| ActionInternalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneKneeInputController.str);
				str11.append("for ");
				examMusculotoneKneeInputController.str = str11.toString();

				if (ActionAbductionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("abduction , ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionAdductionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("adduction, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionAllMotionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append(" all motion,");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionExtensionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("extension, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionExternalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("external rotation, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionFlexionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("flexion, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}
				if (ActionInternalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
					str1.append("internal rotation, ");
					examMusculotoneKneeInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(". ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			if (gaitNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(" Gait is normal.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (gaitAntalgicRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(" Gait is antalgic. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (gaitStiffRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append(" Gait is stiff. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}

			++examMusculotoneKneeInputController.formCount;
			examMusculotoneKneeInputController.setKneeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneKneeInputController.formCount;
				examMusculotoneKneeInputController.setKneeUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
