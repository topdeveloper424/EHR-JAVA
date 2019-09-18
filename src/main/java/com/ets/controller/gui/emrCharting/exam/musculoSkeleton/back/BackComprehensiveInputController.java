package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BackComprehensiveInputController Class
 *Description: backComprehensive.fxml Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class BackComprehensiveInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox WaddellSuperFacialCheck;

	@FXML
	private CheckBox WaddellNonAnatomicCheck;

	@FXML
	private CheckBox WaddellDistractionCheck;

	@FXML
	private CheckBox WaddelldisturbancesCheck;

	@FXML
	private CheckBox reflexesNormalCkeckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox AbnormalitiesLordosisCheck;

	@FXML
	private CheckBox AbnormalitiesIncreasedCheck;

	@FXML
	private CheckBox AbnormalitiesNoKyphosisCheck;

	@FXML
	private CheckBox AbnormalitiesKyphosisCheck;

	@FXML
	private CheckBox AbnormalitiesDecreasedCheck;

	@FXML
	private CheckBox AbnormalitiesNormalCheck;

	@FXML
	private CheckBox muscleLocation2SacralCheck;

	@FXML
	private CheckBox muscleLocation2UpperCheck;

	@FXML
	private CheckBox muscleLocation2LowerCheck;

	@FXML
	private CheckBox muscleLocation2CervicalCheck;

	@FXML
	private CheckBox muscleLocation2ThoracicCheck;

	@FXML
	private CheckBox muscleLocation2LumberCheck;

	@FXML
	private RadioButton gaitNoramlRadio;

	@FXML
	private ToggleGroup gait;

	@FXML
	private RadioButton gaitAntalgicRadio;

	@FXML
	private CheckBox WaddellSimulationCheck;

	@FXML
	private CheckBox WaddelldisproportionateCheck;

	@FXML
	private CheckBox straightNormalCheck;

	@FXML
	private CheckBox mildlineAnyRegionCheck;

	@FXML
	private CheckBox mildlineServicalCheck;

	@FXML
	private CheckBox mildlineSacralCheck;

	@FXML
	private CheckBox mildlineThoracicCheck;

	@FXML
	private CheckBox mildlineLumberCheck;

	@FXML
	private CheckBox MuscleNoTendernessCheck;

	@FXML
	private CheckBox MuscleTendernessCheck;

	@FXML
	private CheckBox MuscleNoSpasmCheck;

	@FXML
	private CheckBox MusclePointTenderCheck;

	@FXML
	private CheckBox MuscleSpasmCheck;

	@FXML
	private CheckBox NumberNormalCheck;

	@FXML
	private CheckBox mildlineNormalCheck;

	@FXML
	private CheckBox MuscleNormalCheck;

	@FXML
	private CheckBox AbnormalitiesScoliosisCheck;

	@FXML
	private RadioButton muscleLocation1BilateralRadio;

	@FXML
	private ToggleGroup location;

	@FXML
	private RadioButton muscleLocation1LeftRadio;

	@FXML
	private RadioButton muscleLocation1RightRadio;

	@FXML
	private RadioButton muscleLocation2StiffRadio;

	@FXML
	private RadioButton reflexesNormalRadio;

	@FXML
	private ToggleGroup reflex;

	@FXML
	private RadioButton reflexesHypoactiveLeftRadio;

	@FXML
	private RadioButton reflexesHyperactiveLeftRadio;

	@FXML
	private RadioButton reflexesHypoactiveRightRadio;

	@FXML
	private RadioButton reflexesHyperactiveRightRadio;

	@FXML
	private RadioButton reflexesHypoactiveBilaterallyRadio;

	@FXML
	private RadioButton reflexesHyperactiveBilaterallyRadio;

	@FXML
	private RadioButton straightpossitiveRadio;

	@FXML
	private ToggleGroup degree;

	@FXML
	private RadioButton straightnegativeRadio;

	@FXML
	private RadioButton straightnotTestedRadio;

	@FXML
	private TextField numberTextField;

	@FXML
	private CheckBox whichNormalCheck;

	@FXML
	private RadioButton whichBilaterallyRadio;

	@FXML
	private RadioButton whichOnTheLeftRadio;

	@FXML
	private RadioButton whichOnTheRightRadio;

	@FXML
	private CheckBox WaddellNormalCheck;

	private ExamMusculotoneBackController examMusculotoneBackController;

	public void setExamMusculotoneBackController(ExamMusculotoneBackController examMusculotoneBackController) {
		this.examMusculotoneBackController = examMusculotoneBackController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneBackController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneBackController.str = examComp.toString();

			if (AbnormalitiesNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
				str11.append("Back exam shows normal lordosis and no kyphosis or scoliosis.");
				examMusculotoneBackController.str = str11.toString();

			} else {

				if (AbnormalitiesDecreasedCheck.isSelected() || AbnormalitiesIncreasedCheck.isSelected()
						|| AbnormalitiesKyphosisCheck.isSelected() || AbnormalitiesLordosisCheck.isSelected()
						|| AbnormalitiesNoKyphosisCheck.isSelected() || AbnormalitiesScoliosisCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("Back exam shows ");
					examMusculotoneBackController.str = str11.toString();

					if (AbnormalitiesDecreasedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("decreased lordotic curvature, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (AbnormalitiesIncreasedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("increased lordotic curvature, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (AbnormalitiesKyphosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("kyphosis, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (AbnormalitiesLordosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("normal lordosis, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (AbnormalitiesNoKyphosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("no kyphosis or scoliosis, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (AbnormalitiesScoliosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("scoliosis, ");
						examMusculotoneBackController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append(".");
					examMusculotoneBackController.str = str1.toString();

				}

			}

			if (mildlineNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
				str11.append("There is no midline spinal tenderness.");
				examMusculotoneBackController.str = str11.toString();

			} else {

				if (mildlineAnyRegionCheck.isSelected() || mildlineLumberCheck.isSelected()
						|| mildlineSacralCheck.isSelected() || mildlineServicalCheck.isSelected()
						|| mildlineThoracicCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("There is midline tenderness over the ");
					examMusculotoneBackController.str = str11.toString();

					if (mildlineAnyRegionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("any region of the, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (mildlineLumberCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("lumbar, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (mildlineSacralCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("sacral spines, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (mildlineServicalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("cervical, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (mildlineThoracicCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("thoracic, ");
						examMusculotoneBackController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("spines.");
					examMusculotoneBackController.str = str1.toString();

				}

			}

			if (MuscleNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
				str11.append("There is no tenderness or spasm in the paravertebral muscles.");
				examMusculotoneBackController.str = str11.toString();

			} else {

				if (MuscleNoTendernessCheck.isSelected() || MuscleTendernessCheck.isSelected()
						|| MusclePointTenderCheck.isSelected() || MuscleSpasmCheck.isSelected()
						|| MuscleNoSpasmCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("There is ");
					examMusculotoneBackController.str = str11.toString();

					if (MuscleNoTendernessCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("no tenderness, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (MuscleTendernessCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("tenderness, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (MusclePointTenderCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("point tenderness, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (MuscleSpasmCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("spasm, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (MuscleNoSpasmCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("no spasm, ");
						examMusculotoneBackController.str = str1.toString();

					}

					

				}

			}

			if (muscleLocation1BilateralRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("in the bilateral ");
				examMusculotoneBackController.str = str1.toString();

			}

			if (muscleLocation1LeftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("in the left. ");
				examMusculotoneBackController.str = str1.toString();

			}

			if (muscleLocation1RightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("in the right. ");
				examMusculotoneBackController.str = str1.toString();

			}

			if (muscleLocation2CervicalCheck.isSelected() || muscleLocation2LowerCheck.isSelected()
					|| muscleLocation2LumberCheck.isSelected() || muscleLocation2SacralCheck.isSelected()
					|| muscleLocation2ThoracicCheck.isSelected() || muscleLocation2UpperCheck.isSelected()) {

			

				if (muscleLocation2CervicalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("cervical, ");
					examMusculotoneBackController.str = str1.toString();

				}
				if (muscleLocation2LowerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("lower, ");
					examMusculotoneBackController.str = str1.toString();

				}
				if (muscleLocation2LumberCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("lumbar, ");
					examMusculotoneBackController.str = str1.toString();

				}
				if (muscleLocation2SacralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("sacral, ");
					examMusculotoneBackController.str = str1.toString();

				}
				if (muscleLocation2ThoracicCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("thoracic, ");
					examMusculotoneBackController.str = str1.toString();

				}
				if (muscleLocation2UpperCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("upper, ");
					examMusculotoneBackController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("paravertebral muscles.");
				examMusculotoneBackController.str = str1.toString();

			}
			if (gaitNoramlRadio.isSelected()|| gaitAntalgicRadio.isSelected()||muscleLocation2StiffRadio.isSelected()) {


				if (gaitNoramlRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("Gait is normal.");
					examMusculotoneBackController.str = str1.toString();

				}

				if (gaitAntalgicRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("Gait is antalgic.");
					examMusculotoneBackController.str = str1.toString();

				}
				
				if (muscleLocation2StiffRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("Gait is stiff.");
					examMusculotoneBackController.str = str1.toString();

				}

				
				if (reflexesNormalCkeckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append(" Deep tendon reflexes are normal and symmetrical.");
					examMusculotoneBackController.str = str11.toString();

				} else {

					if (reflexesHyperactiveBilaterallyRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hyperactive on bilaterally.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesHyperactiveLeftRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hyperactive on left.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesHyperactiveRightRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hyperactive on right.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesHypoactiveBilaterallyRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hypoactive on bilaterally.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesHypoactiveLeftRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hypoactive on left.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesHypoactiveRightRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are hypoactive on right.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (reflexesNormalRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("Deep tendon reflexes are normal and symmetrical.");
						examMusculotoneBackController.str = str1.toString();

					}

				}
				
				
				if(straightNormalCheck.isSelected()||straightnegativeRadio.isSelected()
						||straightnotTestedRadio.isSelected()
						||straightpossitiveRadio.isSelected()){

				if (straightNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("Straight leg raise performed normally.");
					examMusculotoneBackController.str = str11.toString();
					
					

				} else {

					if (straightnegativeRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" Straight leg raise / sitting root test is negative.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (straightnotTestedRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" Straight leg raise / sitting root not test.");
						examMusculotoneBackController.str = str1.toString();

					}
					if (straightpossitiveRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" Straight leg raise / sitting root test is positive");
						examMusculotoneBackController.str = str1.toString();

					}

				}
				if(NumberNormalCheck.isSelected()||numberTextField.getText().length() > 0){

				if (NumberNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append(" at 30 degrees.");
					examMusculotoneBackController.str = str1.toString();

				} else {

					if (numberTextField.getText().length() > 0) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("at " +numberTextField.getText()+ "degree ");
						examMusculotoneBackController.str = str1.toString();

					}

				}
				if (whichNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("");
					examMusculotoneBackController.str = str11.toString();

				} else {

					if (whichBilaterallyRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("bilaterally");
						examMusculotoneBackController.str = str1.toString();

					}
					if (whichOnTheLeftRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("left");
						examMusculotoneBackController.str = str1.toString();

					}
					if (whichOnTheRightRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("right");
						examMusculotoneBackController.str = str1.toString();

					}

				}

				}
				
				
				}
				
			}

			

			if(whichNormalCheck.isSelected()||whichBilaterallyRadio.isSelected()
					||whichOnTheLeftRadio.isSelected()||whichOnTheRightRadio.isSelected()){

			if (WaddellNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append(" Waddell's signs negative.");
				examMusculotoneBackController.str = str1.toString();

			} else {

				if (WaddelldisproportionateCheck.isSelected() || WaddellDistractionCheck.isSelected()
						|| WaddelldisturbancesCheck.isSelected() || WaddellNonAnatomicCheck.isSelected()
						|| WaddellSimulationCheck.isSelected() || WaddellSuperFacialCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneBackController.str);
					str12.append("Positive Waddell's sign for ");
					examMusculotoneBackController.str = str12.toString();

					if (WaddelldisproportionateCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("disproportionate reaction,");
						examMusculotoneBackController.str = str1.toString();

					}
					if (WaddellDistractionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("distraction,");
						examMusculotoneBackController.str = str1.toString();

					}
					if (WaddelldisturbancesCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" regional disturbances,");
						examMusculotoneBackController.str = str1.toString();

					}
					if (WaddellNonAnatomicCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" non-anatomic tenderness,");
						examMusculotoneBackController.str = str1.toString();

					}
					if (WaddellSimulationCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append(" simulation,");
						examMusculotoneBackController.str = str1.toString();

					}
					if (WaddellSuperFacialCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("superficial tenderness,");
						examMusculotoneBackController.str = str1.toString();

					}


				}

			}
		

			}

			++examMusculotoneBackController.formCount;
			examMusculotoneBackController.setBackUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneBackController.formCount;
				examMusculotoneBackController.setBackUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
