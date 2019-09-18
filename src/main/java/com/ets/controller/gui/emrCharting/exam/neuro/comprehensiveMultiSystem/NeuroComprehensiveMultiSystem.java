package com.ets.controller.gui.emrCharting.exam.neuro.comprehensiveMultiSystem;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroComprehensiveMultiSystem Class
 *Description:  neuroExamComprehensiveMultiSystem GUI Controller class
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
public class NeuroComprehensiveMultiSystem implements Initializable {
	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox nerveNormalCkeckBox;

	@FXML
	private CheckBox nerveVisionLeftCkeckBox;

	@FXML
	private CheckBox nerveSmellCkeckBox;

	@FXML
	private CheckBox nerveVisionRightCkeckBox;

	@FXML
	private CheckBox nerveAbnormalCkeckBox;

	@FXML
	private CheckBox tendon4Check;

	@FXML
	private CheckBox locationBicepsCheck;

	@FXML
	private CheckBox locationTricepsCheck;

	@FXML
	private CheckBox locationAnkleCheck;

	@FXML
	private CheckBox locationBrachioradialisCheck;

	@FXML
	private CheckBox locationKneeCheck;

	@FXML
	private CheckBox AbnormalitiesLeftCheck;

	@FXML
	private CheckBox AbnormalitiesRightCheck;

	@FXML
	private CheckBox Abnormalities2Check;

	@FXML
	private CheckBox Abnormalities3Check;

	@FXML
	private CheckBox AbnormalitiesBicepsCheck;

	@FXML
	private CheckBox AbnormalitiesTricepsCheck;

	@FXML
	private CheckBox AbnormalitiesBrachioradialisCheck;

	@FXML
	private CheckBox BabinskiFlexorCheck;

	@FXML
	private CheckBox BabinskiExtensiorCheck;

	@FXML
	private CheckBox BabinskiEquivocalCheck;

	@FXML
	private CheckBox BabinskiRightCheck;

	@FXML
	private CheckBox SensationIntactlCheck;

	@FXML
	private CheckBox SensationDecreasedCheck;

	@FXML
	private CheckBox SensationAbsentCheck;

	@FXML
	private CheckBox simulationLightTouchCheck;

	@FXML
	private CheckBox bodyRightHandCheck;

	@FXML
	private CheckBox simulationVibrationCheck;

	@FXML
	private CheckBox simulationPinprickCheck;

	@FXML
	private CheckBox bodyFaceCheck;

	@FXML
	private CheckBox nerveGagCkeckBox;

	@FXML
	private CheckBox nerveHearingCkeckBox;
	@FXML
	private CheckBox BabinskileftCheck;

	@FXML
	private CheckBox SensationNormalCheck;

	@FXML
	private CheckBox nerveFacialSensationCkeckBox;

	@FXML
	private CheckBox nerveFacialWeeknessCkeckBox;

	@FXML
	private CheckBox nerveUvulaCkeckBox;

	@FXML
	private CheckBox tendon0Check;

	@FXML
	private CheckBox nerveSCMCkeckBox;

	@FXML
	private CheckBox tendon1Check;

	@FXML
	private CheckBox nerveTongueCkeckBox;

	@FXML
	private CheckBox tendon2Check;

	@FXML
	private CheckBox tendonNormalCheck;

	@FXML
	private CheckBox Abnormalities0Check;

	@FXML
	private CheckBox Abnormalities1Check;

	@FXML
	private CheckBox AbnormalitiesAnkleCheck;

	@FXML
	private CheckBox AbnormalitiesKneeCheck;

	@FXML
	private CheckBox bodyLeftFootCheck;

	@FXML
	private CheckBox bodyForeheadCheck;

	@FXML
	private CheckBox bodyLeftHandCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox tendon3Check;

	@FXML
	private CheckBox bodyRightUpperArmCheck;

	@FXML
	private CheckBox bodyRightForearmCheck;

	@FXML
	private CheckBox bodyLeftUpperArmCheck;

	@FXML
	private CheckBox bodyLeftLegCheck;

	@FXML
	private CheckBox bodyLeftForearmCheck;

	@FXML
	private CheckBox bodyRightLegCheck;

	@FXML
	private CheckBox bodyRightFootCheck;
	private NeuroInputController neuroInputController;

	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGIC: ");
			neuroInputController.str = skelComp.toString();

			if (nerveNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Cranial nerves were tested and intact. ");
				neuroInputController.str = str1.toString();

			} else {
				if (nerveVisionLeftCkeckBox.isSelected() || nerveFacialSensationCkeckBox.isSelected()
						|| nerveUvulaCkeckBox.isSelected() || nerveVisionRightCkeckBox.isSelected()
						|| nerveFacialWeeknessCkeckBox.isSelected() || nerveSCMCkeckBox.isSelected()
						|| nerveAbnormalCkeckBox.isSelected() || nerveHearingCkeckBox.isSelected()
						|| nerveTongueCkeckBox.isSelected() || nerveSmellCkeckBox.isSelected()
						|| nerveGagCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Cranial nerves were tested,showing  ");
					neuroInputController.str = str1.toString();

				}
				if (nerveVisionLeftCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased vision left,");
					neuroInputController.str = str1.toString();

				}
				if (nerveFacialSensationCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased facial sensation, ");
					neuroInputController.str = str1.toString();

				}
				if (nerveUvulaCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" uvula elevation,");
					neuroInputController.str = str1.toString();

				}
				if (nerveVisionRightCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased vision right, ");
					neuroInputController.str = str1.toString();

				}
				if (nerveFacialWeeknessCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("facial weakness,");
					neuroInputController.str = str1.toString();

				}
				if (nerveSCMCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("weakness SCM, trapezius");
					neuroInputController.str = str1.toString();

				}
				if (nerveAbnormalCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("abnormal extraocular motions, ");
					neuroInputController.str = str1.toString();

				}
				if (nerveHearingCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased hearing, ");
					neuroInputController.str = str1.toString();

				}
				if (nerveTongueCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" trapezius,");
					neuroInputController.str = str1.toString();

				}
				if (nerveSmellCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased smell, ");
					neuroInputController.str = str1.toString();

				}
				if (nerveGagCkeckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("gag reflex,");
					neuroInputController.str = str1.toString();

				}
			}

			if (tendonNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Neurological exam showed normal reflexes. ");
				neuroInputController.str = str1.toString();

			} else {
				if (tendon0Check.isSelected() || tendon1Check.isSelected() || tendon2Check.isSelected()
						|| tendon3Check.isSelected() || tendon4Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Deep tendon reflexes were ");
					neuroInputController.str = str1.toString();

				}
				if (tendon0Check.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("0,");
					neuroInputController.str = str1.toString();

				}
				if (tendon1Check.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("1+,");
					neuroInputController.str = str1.toString();

				}
				if (tendon2Check.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("2+,");
					neuroInputController.str = str1.toString();

				}
				if (tendon3Check.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3+,");
					neuroInputController.str = str1.toString();

				}
				if (tendon4Check.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("4+,");
					neuroInputController.str = str1.toString();

				}

			}

			if (locationBicepsCheck.isSelected() || locationAnkleCheck.isSelected() || locationTricepsCheck.isSelected()
					|| locationBrachioradialisCheck.isSelected() || locationKneeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" in the ");
				neuroInputController.str = str1.toString();

			}
			if (locationBicepsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" biceps,");
				neuroInputController.str = str1.toString();

			}
			if (locationAnkleCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" ankle,");
				neuroInputController.str = str1.toString();

			}
			if (locationTricepsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" triceps,");
				neuroInputController.str = str1.toString();

			}
			if (locationBrachioradialisCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" brachioradialis,");
				neuroInputController.str = str1.toString();

			}
			if (locationKneeCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" knee,");
				neuroInputController.str = str1.toString();

			}

			if (AbnormalitiesLeftCheck.isSelected() || Abnormalities2Check.isSelected()
					|| AbnormalitiesTricepsCheck.isSelected() || AbnormalitiesRightCheck.isSelected()
					|| AbnormalitiesBrachioradialisCheck.isSelected() || Abnormalities0Check.isSelected()
					|| Abnormalities3Check.isSelected() || AbnormalitiesKneeCheck.isSelected()
					|| Abnormalities1Check.isSelected() || AbnormalitiesBicepsCheck.isSelected()
					|| AbnormalitiesAnkleCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Abnormalities were noted in the ");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesLeftCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesTricepsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" triceps,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesRightCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" right,");
				neuroInputController.str = str1.toString();

			}
			if (Abnormalities3Check.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" 3+,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesBrachioradialisCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" brachioradialis,");
				neuroInputController.str = str1.toString();

			}
			if (Abnormalities0Check.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" 0+,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesKneeCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" knee,");
				neuroInputController.str = str1.toString();

			}
			if (Abnormalities1Check.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" 1+,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesBicepsCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" biceps,");
				neuroInputController.str = str1.toString();

			}
			if (AbnormalitiesAnkleCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" ankle,");
				neuroInputController.str = str1.toString();

			}
			if (Abnormalities2Check.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" 2+,");
				neuroInputController.str = str1.toString();

			}
			if (BabinskiFlexorCheck.isSelected() || BabinskiRightCheck.isSelected()
					|| BabinskiExtensiorCheck.isSelected() || BabinskiEquivocalCheck.isSelected()
					|| BabinskileftCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Babinski response was ");
				neuroInputController.str = str1.toString();

			}
			if (BabinskiFlexorCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" flexor,,");
				neuroInputController.str = str1.toString();

			}
			if (BabinskiRightCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" rigt,");
				neuroInputController.str = str1.toString();

			}

			if (BabinskiExtensiorCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" extensior,");
				neuroInputController.str = str1.toString();

			}
			if (BabinskiEquivocalCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" equivocal,");
				neuroInputController.str = str1.toString();

			}
			if (BabinskileftCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left,");
				neuroInputController.str = str1.toString();

			}

			if (SensationNormalCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Sensation is intact.");
				neuroInputController.str = str1.toString();

			} else {

				if (SensationIntactlCheck.isSelected() || SensationDecreasedCheck.isSelected()
						|| SensationAbsentCheck.isSelected())

				{

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Sensation was ");
					neuroInputController.str = str1.toString();

				}

				if (SensationIntactlCheck.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" intact,");
					neuroInputController.str = str1.toString();

				}
				if (SensationDecreasedCheck.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" intact except for decreased ,");
					neuroInputController.str = str1.toString();

				}
				if (SensationAbsentCheck.isSelected()) {
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" intact except for absent.");
					neuroInputController.str = str1.toString();

				}
			}

			if (simulationLightTouchCheck.isSelected() || simulationPinprickCheck.isSelected()
					|| simulationVibrationCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" sensation of ");
				neuroInputController.str = str1.toString();

			}
			if (simulationLightTouchCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" light torch,");
				neuroInputController.str = str1.toString();

			}
			if (simulationPinprickCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" pinprick,");
				neuroInputController.str = str1.toString();

			}
			if (simulationVibrationCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" vibration,");
				neuroInputController.str = str1.toString();

			}
			if (bodyFaceCheck.isSelected() || bodyForeheadCheck.isSelected() || bodyLeftFootCheck.isSelected()
					|| bodyLeftForearmCheck.isSelected() || bodyLeftHandCheck.isSelected()
					|| bodyLeftLegCheck.isSelected() || bodyLeftUpperArmCheck.isSelected()
					|| bodyRightFootCheck.isSelected() || bodyRightLegCheck.isSelected()
					|| bodyRightForearmCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" applied to the ");
				neuroInputController.str = str1.toString();

			}

			if (bodyFaceCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" face,");
				neuroInputController.str = str1.toString();

			}
			if (bodyForeheadCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" forehead,");
				neuroInputController.str = str1.toString();

			}
			if (bodyLeftFootCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left foot,");
				neuroInputController.str = str1.toString();

			}
			if (bodyLeftForearmCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left forearm,");
				neuroInputController.str = str1.toString();

			}
			if (bodyLeftHandCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left hand,");
				neuroInputController.str = str1.toString();

			}
			if (bodyLeftLegCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left leg,");
				neuroInputController.str = str1.toString();

			}
			if (bodyLeftUpperArmCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" left upper arm,");
				neuroInputController.str = str1.toString();

			}
			if (bodyRightFootCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" right foot,");
				neuroInputController.str = str1.toString();

			}
			if (bodyRightLegCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" right leg,");
				neuroInputController.str = str1.toString();

			}
			if (bodyRightForearmCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" right forearm,");
				neuroInputController.str = str1.toString();

			}
			StringBuilder str1 = new StringBuilder(neuroInputController.str);
			str1.append(".");
			neuroInputController.str = str1.toString();
			// genericEMRChartingController.saveAllTextArea();
			++neuroInputController.formCount;
			neuroInputController.setNeuroUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++neuroInputController.formCount;
				neuroInputController.setNeuroUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}