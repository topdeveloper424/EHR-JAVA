package com.ets.controller.gui.emrCharting.exam.eye;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditDistrictGUIController Class

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
import javafx.scene.control.ToggleGroup;

public class EyeCompAcuityPupilsInputController implements Initializable {

	@FXML
    private CheckBox conjunctiveNormalCkeckBox;

    @FXML
    private CheckBox conjunctiveBilaterallyCheck;

    @FXML
    private CheckBox conjunctiveRightInjectedCheck;

    @FXML
    private CheckBox conjunctiveBilaterallyInjectedCheck;

    @FXML
    private CheckBox conjunctiveRightNormalCheck;

    @FXML
    private CheckBox lidsNormallyBilaterallyCheckBox;

    @FXML
    private CheckBox lidsLeftNormalCheckBox;

    @FXML
    private CheckBox lidsRightNormalCheckBox;

    @FXML
    private CheckBox lidsChalazioCheckBox;

    @FXML
    private CheckBox lidsEctropionCheckBox;

    @FXML
    private CheckBox lidsShowingCheckBox;

    @FXML
    private CheckBox conjunctiveLeftNormalCheck;

    @FXML
    private CheckBox conjunctiveLeftInjectedCheck;

    @FXML
    private CheckBox ScleraeNormallyBilaterallyCheck;

    @FXML
    private CheckBox ScleraeRightNormalCheck;

    @FXML
    private CheckBox ScleraeAnictericCheck;

    @FXML
    private CheckBox ScleraeRightNormalHemorrCheck;

    @FXML
    private CheckBox ScleraeLeftNormalCheck;

    @FXML
    private CheckBox ScleraeleftNormalHemorrCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox acuityAllNormalCheckBox;

    @FXML
    private CheckBox acuityNotTestedCheckBox;

    @FXML
    private CheckBox acuityNormalBilaterallyCheckBox;

    @FXML
    private CheckBox acuityDecreasedlBilaterallyCheckBox;

    @FXML
    private CheckBox acuityLeftNormalCheckBox;

    @FXML
    private CheckBox acuityLeftDecreasedCheckBox;

    @FXML
    private CheckBox acuityRightNormalCheckBox;

    @FXML
    private CheckBox acuityRightDecreasedCheckBox;

    @FXML
    private CheckBox methodSnellenCheck;

    @FXML
    private CheckBox method6MeterCheck;

    @FXML
    private CheckBox method1MeterCheck;

    @FXML
    private CheckBox fieldAllNormalCheckBox1;

    @FXML
    private CheckBox fieldNotTestedCheckBox;

    @FXML
    private CheckBox fieldNormalBilaterallyCheckBox;

    @FXML
    private CheckBox fieldDecreasedlBilaterallyCheckBox;

    @FXML
    private CheckBox fieldLeftDecreasedCheckBox;

    @FXML
    private CheckBox fieldRightNormalCheckBox;

    @FXML
    private CheckBox fieldRightDecreasedCheckBox;

    @FXML
    private CheckBox fieldLeftNormalCheckBox;

    @FXML
    private RadioButton ocularFullRadio;

    @FXML
    private ToggleGroup ocular;

    @FXML
    private RadioButton ocularDecreasedRadio;

    @FXML
    private CheckBox ocularNormalCkeckBox;

    @FXML
    private CheckBox allMovementCheck;

    @FXML
    private CheckBox lateralCheck;

    @FXML
    private CheckBox upwardCheck;

    @FXML
    private CheckBox downwardCheck;

    @FXML
    private RadioButton leftEyeRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton rightEyeRadio;

    @FXML
    private RadioButton leftOrRightEyeRadio;

    @FXML
    private CheckBox nystagmusNotNotedCheck;

    @FXML
    private CheckBox nystagmusFineCheck;

    @FXML
    private CheckBox nystagmusVerticalCheck;

    @FXML
    private CheckBox nystagmusHorizontalCheck;

    @FXML
    private CheckBox nystagmusCoarseCheck;

    @FXML
    private CheckBox nystagmusBriefCheck;

    @FXML
    private CheckBox nystagmusSustainedCheck;

    @FXML
    private CheckBox nystagmusGeneralCheck;

    @FXML
    private CheckBox pupilsAllNormalCheck;

    @FXML
    private CheckBox pupilsMidpointBilaterallyCheck;

    @FXML
    private CheckBox pupilsBilaterallyDilatedCheck;

    @FXML
    private CheckBox pupilsBilaterallyConstrictedCheck;

    @FXML
    private CheckBox pupilsLeftMidpointCheck;

    @FXML
    private CheckBox pupilsRightConstrictedCheck;

    @FXML
    private CheckBox pupilsRightMidpointCheck;

    @FXML
    private CheckBox pupilsRightDilatedCheck;

    @FXML
    private CheckBox pupilsLeftConstrictedCheck;

    @FXML
    private CheckBox pupilsLeftDilatedCheck;

    @FXML
    private CheckBox reactivityBilaterallyNormalCheck;

    @FXML
    private CheckBox reactivityLeftNormalCheck;

    @FXML
    private CheckBox reactivityLeftSluggishCheck;

    @FXML
    private CheckBox reactivityLeftUnrectiveCheck;

    @FXML
    private CheckBox reactivityRightUnrectiveCheck;

    @FXML
    private CheckBox reactivityRightSluggishCheck;

    @FXML
    private CheckBox reactivityRightNormalCheck;

    @FXML
    private CheckBox accommodationBilaterallyNormalCheck;

    @FXML
    private CheckBox accommodationLeftNormalCheck;

    @FXML
    private CheckBox accommodationLeftSlowCheck;

    @FXML
    private CheckBox accommodationLeftUnrectiveCheck;

    @FXML
    private CheckBox accommodationRightUnrectiveCheck;

    @FXML
    private CheckBox accommodationRightSlowCheck;

    @FXML
    private CheckBox accommodationRightNormalCheck;


	private ExamEyeInputController examEyeInputController;

	public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
		this.examEyeInputController = examEyeInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\nEYE: ");
			examEyeInputController.str = examComp.toString();

			if (acuityAllNormalCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Visual acuity was normal bilaterally. ");
				examEyeInputController.str = str1.toString();

			} else {

				if (acuityDecreasedlBilaterallyCheckBox.isSelected() || acuityLeftDecreasedCheckBox.isSelected()
						|| acuityLeftNormalCheckBox.isSelected() || acuityNormalBilaterallyCheckBox.isSelected()
						|| acuityNotTestedCheckBox.isSelected() || acuityRightDecreasedCheckBox.isSelected()
						|| acuityRightNormalCheckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Visual acuity was ");
					examEyeInputController.str = str11.toString();

					if (acuityDecreasedlBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("decreased bilaterally, ");
						examEyeInputController.str = str1.toString();
						 
					}
					if (acuityLeftDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left decreased, ");
						examEyeInputController.str = str1.toString();

					}
					if (acuityLeftNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (acuityNormalBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					}
					if (acuityNotTestedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("not tested, ");
						examEyeInputController.str = str1.toString();

					}
					if (acuityRightDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right decreased, ");
						examEyeInputController.str = str1.toString();

					}
					if (acuityRightNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append(" right normal, ");
						examEyeInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			}

			
			
			
			if (methodSnellenCheck.isSelected() || method6MeterCheck.isSelected()
					|| method1MeterCheck.isSelected() ) {

				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("Testing conducted with ");
				examEyeInputController.str = str11.toString();

				if (methodSnellenCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("Snellen chart, ");
					examEyeInputController.str = str1.toString();

				} 
				if (method6MeterCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("ETDRS chart 6 meters, ");
					examEyeInputController.str = str1.toString();

				}
				if (method1MeterCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("ETDRS chart 1 meter, ");
					examEyeInputController.str = str1.toString();

				}
				

				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(".");
				examEyeInputController.str = str12.toString();

			}

			
			
			
			
			
			
			
			
			if (fieldAllNormalCheckBox1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Visual fields tested normal bilaterally.");
				examEyeInputController.str = str1.toString();

			} else {

				if (fieldDecreasedlBilaterallyCheckBox.isSelected() || fieldLeftDecreasedCheckBox.isSelected()
						|| fieldLeftNormalCheckBox.isSelected() || fieldNormalBilaterallyCheckBox.isSelected()
						|| fieldNotTestedCheckBox.isSelected() || fieldRightDecreasedCheckBox.isSelected()
						|| fieldRightNormalCheckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Visual fields were ");
					examEyeInputController.str = str11.toString();
					
					if (fieldDecreasedlBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("decreased bilaterally, ");
						examEyeInputController.str = str1.toString();

					}
					if (fieldLeftDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left decreased, ");
						examEyeInputController.str = str1.toString();

					}
					if (fieldLeftNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (fieldNormalBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					}
					if (fieldNotTestedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append(" not tested, ");
						examEyeInputController.str = str1.toString();

					}
					if (fieldRightDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right decreased");
						examEyeInputController.str = str1.toString();

					}
					if (fieldRightNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			}

			
			
			
			
			
			
			
			
			
			
			if (ocularNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Extraocular motions are full bilaterally and without nystagmus.");
				examEyeInputController.str = str1.toString();

			} else {

				if (ocularDecreasedRadio.isSelected() || ocularFullRadio.isSelected()) {

					

					if (ocularDecreasedRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Extraocular motions are decreased ");
						examEyeInputController.str = str1.toString();

					}
					if (ocularFullRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Extraocular motions are full ");
						examEyeInputController.str = str1.toString();

					}
				

				}

			}

			
			
			
			
			
			
			
			
			
			

				if (allMovementCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("all movements, ");
					examEyeInputController.str = str1.toString();

				}
				if (lateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("lateral gaze, ");
					examEyeInputController.str = str1.toString();

				}
				if (upwardCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("upward gaze, ");
					examEyeInputController.str = str1.toString();

				}
				if (downwardCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("downward gaze, ");
					examEyeInputController.str = str1.toString();

				}
			

			
			
			
			
			
			
		
				if (leftEyeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" for left eye");
					examEyeInputController.str = str1.toString();

				}
				if (rightEyeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" for right eye");
					examEyeInputController.str = str1.toString();

				}
				if (leftOrRightEyeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" for left and right eyes. ");
					examEyeInputController.str = str1.toString();

				}
				
				
				
				
				
				
				
				
				
				
				
				
				

			if (nystagmusBriefCheck.isSelected() || nystagmusCoarseCheck.isSelected()
					|| nystagmusFineCheck.isSelected() || nystagmusGeneralCheck.isSelected()
					|| nystagmusHorizontalCheck.isSelected() || nystagmusNotNotedCheck.isSelected()
					|| nystagmusSustainedCheck.isSelected() || nystagmusVerticalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("Nystagmus ");
				examEyeInputController.str = str11.toString();

				if (nystagmusBriefCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("brief, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusCoarseCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("coarse, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusFineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("fine, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusGeneralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("was generally noted, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusHorizontalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("horizontal, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusNotNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("not noted, ");
					examEyeInputController.str = str1.toString();

				}
				if (nystagmusSustainedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("sustained, ");
					examEyeInputController.str = str1.toString();

				}if (nystagmusVerticalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("vertical, ");
					examEyeInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(".");
				examEyeInputController.str = str12.toString();

			}

			
			
			
			
			
			
			
			if (conjunctiveNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Conjunctivae are normal bilaterally, sclerae normal, and lids normal. ");
				examEyeInputController.str = str1.toString();

			} else {

				if (conjunctiveBilaterallyCheck.isSelected() || conjunctiveBilaterallyInjectedCheck.isSelected()
						|| conjunctiveLeftInjectedCheck.isSelected() || conjunctiveLeftNormalCheck.isSelected()
						|| conjunctiveNormalCkeckBox.isSelected() || conjunctiveRightInjectedCheck.isSelected()
						|| conjunctiveRightNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Conjunctivae are ");
					examEyeInputController.str = str11.toString();

					if (conjunctiveBilaterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					} 
					if (conjunctiveBilaterallyInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveLeftInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveLeftNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveNormalCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveRightInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveRightNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			}

			
			
			
			
			
			
			
		
				if (ScleraeAnictericCheck.isSelected() || ScleraeLeftNormalCheck.isSelected()
						|| ScleraeleftNormalHemorrCheck.isSelected() || ScleraeNormallyBilaterallyCheck.isSelected()
						|| ScleraeRightNormalCheck.isSelected() || ScleraeRightNormalHemorrCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Sclerae: ");
					examEyeInputController.str = str11.toString();

					if (ScleraeAnictericCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("anicteric, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeLeftNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeleftNormalHemorrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left scleral hemorrhage, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeNormallyBilaterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeRightNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeRightNormalHemorrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right scleral hemorrhage, ");
						examEyeInputController.str = str1.toString();

					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			

			
			
			
			
			
			
			
		

				if (lidsChalazioCheckBox.isSelected() || lidsEctropionCheckBox.isSelected()
						|| lidsLeftNormalCheckBox.isSelected() || lidsNormallyBilaterallyCheckBox.isSelected()
						|| lidsRightNormalCheckBox.isSelected() || lidsShowingCheckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Lids are ");
					examEyeInputController.str = str11.toString();

					if (lidsChalazioCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("chalazion, ");
						examEyeInputController.str = str1.toString();

					}   
					if (lidsEctropionCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("ectropion, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsLeftNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsNormallyBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsRightNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsShowingCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("showing seborrheic changes, ");
						examEyeInputController.str = str1.toString();

					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			

			
			
			
			
			
			
			
			
			if (pupilsAllNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Pupils are midpoint bilaterally, and normally reactive to light and accommodation.");
				examEyeInputController.str = str1.toString();

			} else {

				if (pupilsBilaterallyConstrictedCheck.isSelected() || pupilsBilaterallyDilatedCheck.isSelected()
						|| pupilsLeftConstrictedCheck.isSelected() || pupilsLeftDilatedCheck.isSelected()
						|| pupilsLeftMidpointCheck.isSelected() || pupilsMidpointBilaterallyCheck.isSelected()
						|| pupilsRightConstrictedCheck.isSelected() || pupilsRightDilatedCheck.isSelected() || pupilsRightMidpointCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Pupils are ");
					examEyeInputController.str = str11.toString();

					if (pupilsBilaterallyConstrictedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally constricted, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsBilaterallyDilatedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally dilated, ");
						examEyeInputController.str = str1.toString();

					}if (pupilsLeftConstrictedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left constricted, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsLeftDilatedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left dilated, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsLeftMidpointCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left midpoint, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsMidpointBilaterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("midpoint bilaterally,");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsRightConstrictedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right constricted, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsRightDilatedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right dilated, ");
						examEyeInputController.str = str1.toString();

					}
					if (pupilsRightMidpointCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right midpoint, ");
						examEyeInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			}

			
			
			
			
			
			
			
			
			
			
			if (reactivityBilaterallyNormalCheck.isSelected() || reactivityLeftNormalCheck.isSelected()
					|| reactivityLeftSluggishCheck.isSelected() || reactivityLeftUnrectiveCheck.isSelected()
					|| reactivityRightNormalCheck.isSelected() || reactivityRightSluggishCheck.isSelected()
					|| reactivityRightUnrectiveCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("reactivity to light: ");
				examEyeInputController.str = str11.toString();

				if (reactivityBilaterallyNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" bilaterally normal, ");
					examEyeInputController.str = str1.toString();

				} 
				if (reactivityLeftNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();

				}
				if (reactivityLeftSluggishCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left sluggish response, ");
					examEyeInputController.str = str1.toString();

				}
				if (reactivityLeftUnrectiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left unreactive, ");
					examEyeInputController.str = str1.toString();

				}
				if (reactivityRightNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();

				}
				if (reactivityRightSluggishCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right sluggish response ");
					examEyeInputController.str = str1.toString();

				}
				if (reactivityRightUnrectiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right unreactive, ");
					examEyeInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(".");
				examEyeInputController.str = str12.toString();

			}

			
			
			
			
			
			if (accommodationBilaterallyNormalCheck.isSelected() || accommodationLeftNormalCheck.isSelected()
					|| accommodationLeftSlowCheck.isSelected() || accommodationLeftUnrectiveCheck.isSelected()
					|| accommodationRightNormalCheck.isSelected() || accommodationRightSlowCheck.isSelected()
					|| accommodationRightUnrectiveCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("Accommodation: ");
				examEyeInputController.str = str11.toString();

				if (accommodationBilaterallyNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("bilaterally normal, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationLeftNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationLeftSlowCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left slow, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationLeftUnrectiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left unresponsive, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationRightNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationRightSlowCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right slow, ");
					examEyeInputController.str = str1.toString();

				}
				if (accommodationRightUnrectiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right unresponsive, ");
					examEyeInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(".");
				examEyeInputController.str = str12.toString();

			}

			++examEyeInputController.formCount;
			examEyeInputController.setEyeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			
			
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examEyeInputController.formCount;
				examEyeInputController.setEyeUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
