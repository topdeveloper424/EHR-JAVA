package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ForearmExamComprehensiveInputController Class
 *Description: ForaarmExamComprehensive.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ForearmExamComprehensiveInputController implements Initializable {

	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox strengthWristExtension;

	    @FXML
	    private CheckBox strengthDecreasedWristFlexion;

	    @FXML
	    private CheckBox strengthDecreasedPronation;

	    @FXML
	    private CheckBox strengthDecreasedUlnar;

	    @FXML
	    private CheckBox strengthSupination;

	    @FXML
	    private CheckBox inspectionNoAbnormalities;

	    @FXML
	    private CheckBox inspectionSurgical;

	    @FXML
	    private CheckBox inspectionScarring;

	    @FXML
	    private CheckBox inspectionTenderness;

	    @FXML
	    private CheckBox inspectionContusions;

	    @FXML
	    private CheckBox inspectionAbrasions;

	    @FXML
	    private CheckBox inspectionEcchymosis;

	    @FXML
	    private CheckBox inspectionLacerations;

	    @FXML
	    private CheckBox inspectionSwelling;

	    @FXML
	    private RadioButton extremityLeft;

	    @FXML
	    private ToggleGroup which;

	    @FXML
	    private RadioButton extremityRight;

	    @FXML
	    private RadioButton selectHand;

	    @FXML
	    private ToggleGroup choice;

	    @FXML
	    private RadioButton selectWrist;

	    @FXML
	    private RadioButton selectHandAndWrist;

	    @FXML
	    private CheckBox inspectionnormal;

	    @FXML
	    private CheckBox inspectionErythema;

	    @FXML
	    private TextArea handText;

	    @FXML
	    private CheckBox strengthNormal;

	    @FXML
	    private CheckBox strengthDecreasedRadialDeviation;

	    @FXML
	    private RadioButton radialIntact;

	    @FXML
	    private ToggleGroup pulse;

	    @FXML
	    private RadioButton radialDecreased;

	    @FXML
	    private CheckBox radialNormal;

	    @FXML
	    private CheckBox sensationNormal;

	    @FXML
	    private CheckBox sensationIntact;

	    @FXML
	    private CheckBox sensationIFlexor;

	    @FXML
	    private CheckBox sensationIExtensor;

	    @FXML
	    private CheckBox sensationRadial;

	    @FXML
	    private CheckBox sensationUlnar;

	    @FXML
	    private CheckBox sensationProximally;

	    @FXML
	    private CheckBox sensationIDistally;

	    @FXML
	    private CheckBox provocativeNormal;

	    @FXML
	    private CheckBox provocativeNotPerformed;

	    @FXML
	    private CheckBox provocativePositive;

	    @FXML
	    private CheckBox provocativeNegative;


	private ExamMusculotoneForearmInputController examMusculotoneForearmInputController;

	public void setExamMusculotoneForearmInputController(
			ExamMusculotoneForearmInputController examMusculotoneForearmInputController) {
		this.examMusculotoneForearmInputController = examMusculotoneForearmInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneForearmInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneForearmInputController.str = examComp.toString();

			if (extremityLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Exam of the left ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			if (extremityRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Exam of the right ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			if (selectHandAndWrist.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("hand and wrist ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			if (selectHand.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("hand ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			if (selectWrist.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("wrist ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			if (inspectionnormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("no scars, deformity, swelling or ecchymosis.");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (inspectionAbrasions.isSelected() || inspectionContusions.isSelected()
						|| inspectionEcchymosis.isSelected() || inspectionErythema.isSelected()
						|| inspectionLacerations.isSelected() || inspectionNoAbnormalities.isSelected()
						|| inspectionScarring.isSelected() || inspectionSurgical.isSelected()
						|| inspectionSwelling.isSelected() || inspectionTenderness.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append(" shows ");
					examMusculotoneForearmInputController.str = str11.toString();

					if (inspectionAbrasions.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("abrasions, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionContusions.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("contusions, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionEcchymosis.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("ecchymosis, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionErythema.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("erythema, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionLacerations.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("lacerations, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionNoAbnormalities.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("no abnormalities, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionScarring.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("scarring, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionSurgical.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("surgical scars, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionSwelling.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("swelling, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (inspectionTenderness.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("tenderness to palpation, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}

			if (handText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Hand/wrist is tender at "+handText.getText());
				examMusculotoneForearmInputController.str = str1.toString();

			}

			if (strengthNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("Strength is normal. ");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (strengthDecreasedPronation.isSelected() || strengthDecreasedRadialDeviation.isSelected()
						|| strengthDecreasedUlnar.isSelected() || strengthDecreasedWristFlexion.isSelected()
						|| strengthWristExtension.isSelected() || strengthSupination.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("Strength is ");
					examMusculotoneForearmInputController.str = str11.toString();

					if (strengthDecreasedPronation.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on pronation, ");
						examMusculotoneForearmInputController.str = str1.toString();

					} 
					if (strengthDecreasedRadialDeviation.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on radial deviation, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthDecreasedUlnar.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on ulnar deviation, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthDecreasedWristFlexion.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on wrist flexion, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthWristExtension.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on wrist extension, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthSupination.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased in supination, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}

			if (radialNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("Radial and ulnar pulses are intact. and light touch/pinprick/temperature");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (radialIntact.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append("Radial and ulnar pulses are intact.");
					examMusculotoneForearmInputController.str = str1.toString();

				}
				if (radialDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append("Radial and ulnar pulses are decreased.");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}

			if (sensationNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("sensation is intact.");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (sensationIDistally.isSelected() || sensationIExtensor.isSelected()
						|| sensationIFlexor.isSelected() || sensationIntact.isSelected()
						|| sensationProximally.isSelected() || sensationRadial.isSelected()
						|| sensationUlnar.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("Sensation is ");
					examMusculotoneForearmInputController.str = str11.toString();

					if (sensationIDistally.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased distally, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationIExtensor.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on the extensor surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationIFlexor.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased on the flexor surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationIntact.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("intact, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationProximally.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased proximally. ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationRadial.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased at the radial surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationUlnar.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased at the ulnar surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}

			if (provocativeNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("Provocative maneuvers negative.");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (provocativeNotPerformed.isSelected() || provocativeNegative.isSelected()
						|| provocativePositive.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("Provocative maneuvers ");
					examMusculotoneForearmInputController.str = str11.toString();

					if (provocativeNotPerformed.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("not performed, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (provocativeNegative.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("negative, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (provocativePositive.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("positive, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}

			++examMusculotoneForearmInputController.formCount;
			examMusculotoneForearmInputController.setForearmUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneForearmInputController.formCount;
				examMusculotoneForearmInputController.setForearmUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
