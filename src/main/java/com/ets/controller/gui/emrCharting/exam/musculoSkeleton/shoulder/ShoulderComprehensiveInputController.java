package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ShoulderComprehensiveInputController Class
 *Description: shoulderComprehensive GUI Controller class
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
public class ShoulderComprehensiveInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox ProvocativeYergasonCheck;

	@FXML
	private CheckBox MotorIntactCheck;

	@FXML
	private CheckBox MotorFingerCheck;

	@FXML
	private CheckBox MotoWristExtensiorCheck;

	@FXML
	private CheckBox MotorNormalCkeckBox;

	@FXML
	private CheckBox AtrophyTrapeziusCheck;

	@FXML
	private CheckBox MotoWristFlexorCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox PainSupinationCheck;

	@FXML
	private CheckBox ProvocativeApleyCheck;

	@FXML
	private CheckBox ProvocativeNoneCheck;

	@FXML
	private CheckBox ProvocativeNeersCheck;

	@FXML
	private CheckBox ProvocativeHawkinsCheck;

	@FXML
	private CheckBox ProvocativeSpurlingCheck;

	@FXML
	private CheckBox ProvocativeDropCheck;

	@FXML
	private CheckBox ProvocativeCrossCheck;

	@FXML
	private CheckBox ProvocativeApprehensionCheck;

	@FXML
	private CheckBox scapulaProminenceCheck;

	@FXML
	private CheckBox PainExtensionCheck;

	@FXML
	private CheckBox PainAbductionCheck;

	@FXML
	private CheckBox PainflexionCheck;

	@FXML
	private CheckBox PainInternallCheck;

	@FXML
	private CheckBox PainExternalCheck;

	@FXML
	private CheckBox PainAllMotionrCheck;

	@FXML
	private RadioButton CrepitusNotedRadio;

	@FXML
	private RadioButton CrepitusNoNotedRadio;
	
	 @FXML
	    private ToggleGroup crep;

	@FXML
	private CheckBox scapulaPartialCheck;

	@FXML
	private CheckBox MotoBicepsCheck;

	@FXML
	private CheckBox MotoTricepsCheck;

	@FXML
	private CheckBox MotoIntrinsicsCheck;

	@FXML
	private CheckBox MotodeltoidsCheck;

	@FXML
	private CheckBox PainNormalCheck;

	@FXML
	private CheckBox scapulaNoWingingCheck;

	@FXML
	private CheckBox scapulaWingingCheck;

	@FXML
	private CheckBox AtrophyNoCheck;

	@FXML
	private CheckBox AtrophyMildCheck;

	@FXML
	private CheckBox AtrophyModerateCheck;

	@FXML
	private CheckBox AtrophySevereCheck;

	@FXML
	private CheckBox AtrophySupraspinatusCheck;

	@FXML
	private CheckBox AtrophyDeltoidCheck;

	@FXML
	private CheckBox AbnormalitiesEcchymosisCheck;

	@FXML
	private CheckBox AbnormalitiesErythemalCheck;

	@FXML
	private CheckBox AbnormalitiesSwellingCheck;

	@FXML
	private CheckBox AbnormalitiesSurgicalCheck;

	@FXML
	private CheckBox TendernessACCheck;

	@FXML
	private CheckBox TendernessTheHeadCheck;

	@FXML
	private CheckBox TendernessDeltoidCheck;

	@FXML
	private CheckBox TendernessSupraspinatusCheck;

	@FXML
	private CheckBox TendernessNormalCheck;

	@FXML
	private CheckBox MotorRotationCheck;

	@FXML
	private CheckBox MotoTrapeziusCheck;

	@FXML
	private CheckBox LightNormalCheck;

	@FXML
	private CheckBox PainPronationCheck;

	@FXML
	private CheckBox AtrophyNormalCheck;

	@FXML
	private RadioButton leftRadio;

	@FXML
	private ToggleGroup shoulder;

	@FXML
	private RadioButton rightRadio;

	@FXML
	private CheckBox TendernesstrapeziusCheck;

	@FXML
	private CheckBox TendernessPosteriorCheck;

	@FXML
	private CheckBox TendernessServicalSpineCheck;

	@FXML
	private CheckBox TendernessServicalParaspinalCheck;

	@FXML
	private CheckBox LightIntactCheck;

	@FXML
	private CheckBox LightC3Check;

	@FXML
	private CheckBox LightC4Check;

	@FXML
	private CheckBox LightC6Check;

	@FXML
	private CheckBox LightC7Check;

	@FXML
	private CheckBox LightC8Check;

	@FXML
	private CheckBox LightT2Check;

	@FXML
	private CheckBox LightT3Check;

	@FXML
	private CheckBox AbnormalitiesNormalCheck;

	@FXML
	private CheckBox LightC5Check;

	@FXML
	private CheckBox LightT1Check;

	private ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController;

	public void setExamMusculotoneShoulderInputController(
			ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController) {
		this.examMusculotoneShoulderInputController = examMusculotoneShoulderInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneShoulderInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneShoulderInputController.str = examComp.toString();

			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("Inspection of the left shoulder.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}

			if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("Inspection of the right shoulder.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}

			if (scapulaPartialCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append("shows no winging of the scapula. ");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (scapulaNoWingingCheck.isSelected() || scapulaProminenceCheck.isSelected()
						|| scapulaWingingCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append(" shows ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (scapulaNoWingingCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" no winging of the scapula,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (scapulaProminenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" prominence of the AC joint, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (scapulaWingingCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" scapular winging ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					

				}

			}

			if (AtrophyNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append("no atrophy. ");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (AtrophyDeltoidCheck.isSelected() || AtrophyMildCheck.isSelected()
						|| AtrophyModerateCheck.isSelected() || AtrophyNoCheck.isSelected()
						|| AtrophySevereCheck.isSelected() || AtrophySupraspinatusCheck.isSelected()
						|| AtrophyTrapeziusCheck.isSelected()) {

					
					if (AtrophyDeltoidCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("deltoid ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophyMildCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("mild ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophyModerateCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("moderate ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophyNoCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("no ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophySevereCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("severe ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophySupraspinatusCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("supraspinatus ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AtrophyTrapeziusCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("Trapezius ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("atrophy. ");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (AbnormalitiesNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append(" No ecchymosis, erythema, swelling or scars noted.");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (AbnormalitiesEcchymosisCheck.isSelected() || AbnormalitiesErythemalCheck.isSelected()
						|| AbnormalitiesSurgicalCheck.isSelected() || AbnormalitiesSwellingCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append("Noted ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (AbnormalitiesEcchymosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("ecchymosis,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AbnormalitiesErythemalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("erythema, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AbnormalitiesSurgicalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("surgical,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (AbnormalitiesSwellingCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("swelling");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append(".");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (TendernessNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append(" No tenderness noted to palpation.");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (TendernessACCheck.isSelected() || TendernessDeltoidCheck.isSelected()
						|| TendernessPosteriorCheck.isSelected() || TendernessServicalParaspinalCheck.isSelected()
						|| TendernessServicalSpineCheck.isSelected() || TendernessSupraspinatusCheck.isSelected()
						|| TendernessTheHeadCheck.isSelected() || TendernesstrapeziusCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append("Tenderness noted over ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (TendernessACCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("the AC joint,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessDeltoidCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" the deltoid,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessPosteriorCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" the posterior joint space, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessServicalParaspinalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("cervical paraspinal muscle, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessServicalSpineCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("cervical spine, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessSupraspinatusCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("the supraspinatus, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernessTheHeadCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("the head of the biceps, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (TendernesstrapeziusCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("the trapezius, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append(".");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (PainNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append(" Shoulder motion does not elicit pain.");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (PainAbductionCheck.isSelected() || PainAllMotionrCheck.isSelected()
						|| PainExtensionCheck.isSelected() || PainExternalCheck.isSelected()
						|| PainflexionCheck.isSelected() || PainInternallCheck.isSelected()
						|| PainPronationCheck.isSelected() || PainSupinationCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append("Shoulder motion is painful to ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (PainAbductionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("abduction, ");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainAllMotionrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("all motion,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainExtensionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("extension,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainExternalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" external rotation,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainflexionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("flexion,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainInternallCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("internal rotation,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainPronationCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("pronation,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (PainSupinationCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("supination");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append(".");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (CrepitusNotedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("Crepitus is noted.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}

			if (CrepitusNoNotedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("No crepitus noted.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}

			if (MotorNormalCkeckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append(" Motor strength is intact in all groups.");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (MotoBicepsCheck.isSelected() || MotodeltoidsCheck.isSelected() || MotoIntrinsicsCheck.isSelected()
						|| MotorFingerCheck.isSelected() || MotorIntactCheck.isSelected()
						|| MotorRotationCheck.isSelected() || MotoTrapeziusCheck.isSelected()
						|| MotoTricepsCheck.isSelected() || MotoWristExtensiorCheck.isSelected()
						|| MotoWristFlexorCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append("Motor strength is  ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (MotoBicepsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append(" diminished in biceps,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotodeltoidsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in deltoids,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotoIntrinsicsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in intrinsics,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotorFingerCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in finger flexors,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotorIntactCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("intact in all groups,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotorRotationCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in rotator cuff,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotoTrapeziusCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in trapezius");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotoTricepsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in triceps,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotoWristExtensiorCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in wrist extensors,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (MotoWristFlexorCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("diminished in wrist flexors,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append(".");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (LightNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append(" intact in all dermatomes.");
				examMusculotoneShoulderInputController.str = str11.toString();

			} else {

				if (LightC3Check.isSelected() || LightC4Check.isSelected() || LightC5Check.isSelected()
						|| LightC6Check.isSelected() || LightC7Check.isSelected() || LightC8Check.isSelected()
						|| LightIntactCheck.isSelected() || LightT1Check.isSelected() || LightT2Check.isSelected()
						|| LightT3Check.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str11.append("Light touch is  ");
					examMusculotoneShoulderInputController.str = str11.toString();

					if (LightC3Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C3,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightC4Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C4,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightC5Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C5,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightC6Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C6,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightC7Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C7,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightC8Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in C8,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightIntactCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("intact in all dermatomes,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightT1Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in T1,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightT2Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in T2,");
						examMusculotoneShoulderInputController.str = str1.toString();

					}
					if (LightT3Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
						str1.append("decreased in T3");
						examMusculotoneShoulderInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append(".");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

			}

			if (ProvocativeApleyCheck.isSelected() || ProvocativeApprehensionCheck.isSelected()
					|| ProvocativeCrossCheck.isSelected() || ProvocativeDropCheck.isSelected()
					|| ProvocativeHawkinsCheck.isSelected() || ProvocativeNeersCheck.isSelected()
					|| ProvocativeNoneCheck.isSelected() || ProvocativeSpurlingCheck.isSelected()
					|| ProvocativeYergasonCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str11.append("Provocative maneuver tests included ");
				examMusculotoneShoulderInputController.str = str11.toString();

				if (ProvocativeApleyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("Apley strach,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeApprehensionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("apprehension test,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeCrossCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("cross arm test,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeDropCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("drop arm test,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeHawkinsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("hawkins,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeNeersCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("neers,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeNoneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("none,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeSpurlingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("spurling,");
					examMusculotoneShoulderInputController.str = str1.toString();

				}
				if (ProvocativeYergasonCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
					str1.append("yergason's test");
					examMusculotoneShoulderInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append(".");
				examMusculotoneShoulderInputController.str = str1.toString();

			}

			++examMusculotoneShoulderInputController.formCount;
			examMusculotoneShoulderInputController.setShoulderUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneShoulderInputController.formCount;
				examMusculotoneShoulderInputController.setShoulderUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
