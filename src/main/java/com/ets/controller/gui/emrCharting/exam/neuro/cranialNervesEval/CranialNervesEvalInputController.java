package com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesEval;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CranialNervesEvalInputController Class
 *Description: neuroExamNervesEval GUI Controller class
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
public class CranialNervesEvalInputController implements Initializable {

	  @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private CheckBox secondNormalCkeckBox;

	    @FXML
	    private CheckBox secondIntactCkeckBox;

	    @FXML
	    private CheckBox secondBilaterallyCkeckBox;

	    @FXML
	    private CheckBox secondRightCkeckBox;

	    @FXML
	    private CheckBox fifthIntactCheck;

	    @FXML
	    private CheckBox fifthFacialCheck;

	    @FXML
	    private CheckBox fifthCornealCheck;

	    @FXML
	    private CheckBox seenthIntactlCheck;

	    @FXML
	    private CheckBox seenthDecreasedCheck;

	    @FXML
	    private CheckBox seenthAsymmetriclCheck;

	    @FXML
	    private CheckBox eightIntact;

	    @FXML
	    private CheckBox eightDecreaseHearing;

	    @FXML
	    private CheckBox nineUvula;

	    @FXML
	    private CheckBox nineGag;

	    @FXML
	    private CheckBox thirdNormalCkeckBox;

	    @FXML
	    private CheckBox ninethIntact;

	    @FXML
	    private CheckBox evlevenWeaknessSCM;

	    @FXML
	    private CheckBox evlevenDecreasedShoulderShrug;

	    @FXML
	    private CheckBox evlevenIntact;

	    @FXML
	    private CheckBox twelveIntact;

	    @FXML
	    private CheckBox fifthNormalCheck;

	    @FXML
	    private CheckBox secondLeftCkeckBox;

	    @FXML
	    private CheckBox twelveTongueWeekness;

	    @FXML
	    private CheckBox elevenWeaknessTrapezius;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox twelveNormal;

	    @FXML
	    private CheckBox seenthNormalCheck;

	    @FXML
	    private RadioButton intactRadio;

	    @FXML
	    private RadioButton pupilRadio;

	    @FXML
	    private RadioButton extracocularRadio;

	    @FXML
	    private CheckBox evlevenNormal;

	    @FXML
	    private CheckBox ninethNormal;

	    @FXML
	    private CheckBox eightNormal;

	    @FXML
	    private CheckBox optionalInclude;

	    @FXML
	    private CheckBox balanceNormal;

	    @FXML
	    private CheckBox balanceRomberg;

	    @FXML
	    private CheckBox balanceFingerToNoseNormal;

	    @FXML
	    private CheckBox balanceDydiadochokinenisNotNoted;

	    @FXML
	    private CheckBox BalanceRombergPositive;

	    @FXML
	    private CheckBox balanceFingerToNoseAbormal;

	    @FXML
	    private CheckBox balanceDydiadochokinenisNoted;

	    @FXML
	    private CheckBox balanceKneeHeelNormal;

	    @FXML
	    private CheckBox balanceGaitAbnormal;

	    @FXML
	    private CheckBox balanceGaitNormal;

	    @FXML
	    private CheckBox balanceKneeHeelAbnormal;

	    @FXML
	    private CheckBox speechProductionNormal;

	    @FXML
	    private CheckBox speechExpressiveClarity;

	    @FXML
	    private CheckBox speechProductionDecrease;

	    @FXML
	    private CheckBox speechReceptiveClarity;

	    @FXML
	    private CheckBox speechNormalClarity;

	    @FXML
	    private CheckBox speechCompleteAbhasia;

	    @FXML
	    private CheckBox speechPartial;

	    @FXML
	    private CheckBox speechDecreasedClarity;

	    @FXML
	    private CheckBox DTRAchillesDecreased;

	    @FXML
	    private CheckBox DTRBicepsDecreased;

	    @FXML
	    private CheckBox DTRPatellarNormal;

	    @FXML
	    private CheckBox DTRAChillesIncrreased;

	    @FXML
	    private CheckBox DTRBicepsNormal;

	    @FXML
	    private CheckBox DTRAbnormalityOnRight;

	    @FXML
	    private CheckBox DTRPatellarincrease;

	    @FXML
	    private CheckBox DTRAchillesNormal;

	    @FXML
	    private CheckBox DTRAbnormalityLeftSide;

	    @FXML
	    private CheckBox speechNormal;

	    @FXML
	    private CheckBox DTRNormal;

	    @FXML
	    private CheckBox DTRPatellarDecreased;

	    @FXML
	    private CheckBox DTRBicepsIncreased;

	    @FXML
	    private CheckBox DTRAbnormalityBilaterally;

	    @FXML
	    private CheckBox babinskiNormal;

	    @FXML
	    private CheckBox equivocalLeft;

	    @FXML
	    private CheckBox equivocalRight;

	    @FXML
	    private CheckBox abnormalExtensiorF;

	    @FXML
	    private CheckBox babinskiNormalFlexorF;

	    @FXML
	    private CheckBox babinskiNormalFlexorL;

	    @FXML
	    private CheckBox abnormalExtensiorL;

	    @FXML
	    private CheckBox discriminationIncreased;

	    @FXML
	    private CheckBox pinpointDecreased;

	    @FXML
	    private CheckBox lightTorchIncreased;

	    @FXML
	    private CheckBox lightTorchDecreased;

	    @FXML
	    private CheckBox pinpointNormal;

	    @FXML
	    private CheckBox discriminationDecreased;

	    @FXML
	    private CheckBox vibrationIncreased;

	    @FXML
	    private CheckBox vibrationDecreased;

	    @FXML
	    private CheckBox sensationNormal;

	private NeuroInputController neuroInputController;
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGIC: ");
			neuroInputController.str = skelComp.toString();

			if (optionalInclude.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Cranial nerves were tested, with the following results");
				neuroInputController.str = str1.toString();

			}
			if (secondNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("2nd cranial nerve intact,");
				neuroInputController.str = str1.toString();

			}
			else{
				if (secondLeftCkeckBox.isSelected()||secondBilaterallyCkeckBox.isSelected()||secondRightCkeckBox.isSelected() 
                    ||secondIntactCkeckBox.isSelected()){
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("2nd cranial nerve ");
					neuroInputController.str = str1.toString();

				}
				if (secondBilaterallyCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased vision bilaterally,");
					neuroInputController.str = str1.toString();

				}
				
				if (secondLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" decreased vision left");
					neuroInputController.str = str1.toString();

				}
				
				if (secondRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" decreased vision right,");
					neuroInputController.str = str1.toString();

				}if (secondIntactCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" intact,");
					neuroInputController.str = str1.toString();

				}
				
			}
			if (thirdNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("3rd, 4th and 6th cranial nerves intact,");
				neuroInputController.str = str1.toString();

			}else{
				if (intactRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3rd, 4th and 6th cranial nerves intact ,");
					neuroInputController.str = str1.toString();

				}if (extracocularRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3rd, 4th and 6th cranial nerves abnormal extraocular motions,");
					neuroInputController.str = str1.toString();

				}
				if (pupilRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3rd, 4th and 6th cranial nerves abnormal pupil responses,");
					neuroInputController.str = str1.toString();

				}
				
				
				
			}if (fifthNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("5th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (fifthIntactCheck.isSelected()||fifthFacialCheck.isSelected()||fifthCornealCheck.isSelected()){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("5th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				
				
				if (fifthIntactCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (fifthFacialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased facial sensation,");
					neuroInputController.str = str1.toString();

				}if (fifthCornealCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("abnormal corneal reflexes.");
					neuroInputController.str = str1.toString();

				}
				
			}
			if (seenthNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("7th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (seenthIntactlCheck.isSelected()||seenthDecreasedCheck.isSelected()||seenthAsymmetriclCheck.isSelected()){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("7th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				if (seenthIntactlCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (seenthDecreasedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased facial strength,");
					neuroInputController.str = str1.toString();

				}if (seenthAsymmetriclCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" asymmetric facial tone.");
					neuroInputController.str = str1.toString();

				}
			}
				
				
			if (eightNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("8th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (eightIntact.isSelected()||eightDecreaseHearing.isSelected()){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("8th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				if (eightIntact.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (eightDecreaseHearing.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased hearing.");
					neuroInputController.str = str1.toString();

				}
			}	
				
			if (ninethNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("9th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (ninethIntact.isSelected()||nineGag.isSelected()||nineUvula.isSelected()){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("9th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				if (ninethIntact.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (nineGag.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("gag reflex,");
					neuroInputController.str = str1.toString();

				}if (nineUvula.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("uluva elevation.");
					neuroInputController.str = str1.toString();

				}
			}
				
			if (evlevenNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("11th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (evlevenIntact.isSelected()||elevenWeaknessTrapezius.isSelected()||evlevenDecreasedShoulderShrug.isSelected()
						||evlevenWeaknessSCM.isSelected()){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("11th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				if (evlevenIntact.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (elevenWeaknessTrapezius.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("weakness, trapezius,");
					neuroInputController.str = str1.toString();

				}if (evlevenDecreasedShoulderShrug.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" decreased shoulder shrug,");
					neuroInputController.str = str1.toString();
					
				}if (evlevenWeaknessSCM.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("weakness SCM.");
					neuroInputController.str = str1.toString();
					
				}
			}
			
			
			if (twelveNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("12th cranial nerve intact.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (twelveIntact.isSelected()||twelveTongueWeekness.isSelected()
						){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("12th cranial nerve ");
						neuroInputController.str = str1.toString();

					}
				if (twelveIntact.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}if (twelveTongueWeekness.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("tongue,");
					neuroInputController.str = str1.toString();

				}
			}
			
			
			if (balanceNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Coordination and balance: Romberg negative, tandem gait normal. Finger to nose: normal left and right. Heel / knee / shin normal bilaterally. Dysdiadochokinesis not noted.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (balanceRomberg.isSelected()||balanceFingerToNoseNormal.isSelected()||balanceDydiadochokinenisNotNoted.isSelected()
						||BalanceRombergPositive.isSelected()||balanceFingerToNoseAbormal.isSelected()||balanceDydiadochokinenisNoted.isSelected()
						||balanceGaitNormal.isSelected()||balanceKneeHeelNormal.isSelected()||balanceKneeHeelAbnormal.isSelected()||balanceGaitAbnormal.isSelected()
						){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Coordination and balance testing showed the following ");
						neuroInputController.str = str1.toString();

					}
				if (balanceRomberg.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg negative,");
					neuroInputController.str = str1.toString();

				}if (balanceFingerToNoseNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("finger to nose normal,");
					neuroInputController.str = str1.toString();

				}
				if (balanceDydiadochokinenisNotNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis not noted ,");
					neuroInputController.str = str1.toString();

				}if (BalanceRombergPositive.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg positive,");
					neuroInputController.str = str1.toString();

				}
				if (balanceFingerToNoseAbormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("finger to nose abnormal,");
					neuroInputController.str = str1.toString();

				}if (balanceDydiadochokinenisNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis noted,");
					neuroInputController.str = str1.toString();

				}
				if (balanceGaitNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("gait normal,");
					neuroInputController.str = str1.toString();

				}if (balanceKneeHeelNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("heel/knee/shin normal,");
					neuroInputController.str = str1.toString();

				}
				if (balanceKneeHeelAbnormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("heel/knee/shin abnormal,");
					neuroInputController.str = str1.toString();

				}if (balanceGaitAbnormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" gait abnormal,");
					neuroInputController.str = str1.toString();

				}
				
			}
			
			
			if (speechNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Speech and language production was normal with good clarity.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (speechCompleteAbhasia.isSelected()||speechDecreasedClarity.isSelected()||speechExpressiveClarity.isSelected()
						||speechNormalClarity.isSelected()||speechPartial.isSelected()||speechProductionDecrease.isSelected()
						||speechProductionNormal.isSelected()||speechReceptiveClarity.isSelected()
						){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Coordination and balance testing showed the following ");
						neuroInputController.str = str1.toString();

					}
				if (speechCompleteAbhasia.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg negative,");
					neuroInputController.str = str1.toString();

				}if (speechDecreasedClarity.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("finger to nose normal,");
					neuroInputController.str = str1.toString();

				}
				if (speechExpressiveClarity.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis not noted ,");
					neuroInputController.str = str1.toString();

				}if (speechNormalClarity.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg positive,");
					neuroInputController.str = str1.toString();

				}
				if (speechPartial.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("finger to nose abnormal,");
					neuroInputController.str = str1.toString();

				}if (speechProductionDecrease.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis noted,");
					neuroInputController.str = str1.toString();

				}
				if (speechProductionNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("gait normal,");
					neuroInputController.str = str1.toString();

				}if (speechReceptiveClarity.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("heel/knee/shin normal,");
					neuroInputController.str = str1.toString();

				}
				
			}

			if (DTRNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Deep tendon reflexes were  normal.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (DTRAbnormalityBilaterally.isSelected()||DTRAbnormalityLeftSide.isSelected()||DTRAbnormalityOnRight.isSelected()
						||DTRAchillesDecreased.isSelected()||DTRAChillesIncrreased.isSelected()||DTRAchillesNormal.isSelected()
						||DTRBicepsDecreased.isSelected()||DTRBicepsIncreased.isSelected()||DTRBicepsNormal.isSelected()||
						DTRPatellarDecreased.isSelected()||DTRPatellarincrease.isSelected()||DTRPatellarNormal.isSelected()
						){
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Deep tendon reflexes were tested and showed: ");
						neuroInputController.str = str1.toString();

					}
				if (DTRAbnormalityBilaterally.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("abnormality is bilateral,");
					neuroInputController.str = str1.toString();

				}if (DTRAChillesIncrreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("achilles increased,,");
					neuroInputController.str = str1.toString();

				}
				if (DTRAbnormalityLeftSide.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("abnormality on left side only ,");
					neuroInputController.str = str1.toString();

				}if (DTRAchillesDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("achilles increased,");
					neuroInputController.str = str1.toString();

				}
				if (DTRAchillesNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("achilles normal,");
					neuroInputController.str = str1.toString();

				}if (DTRBicepsDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("biceps decreased,");
					neuroInputController.str = str1.toString();

				}
				if (DTRBicepsIncreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("biceps increase,");
					neuroInputController.str = str1.toString();

				}if (DTRBicepsNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("biceps normal,");
					neuroInputController.str = str1.toString();

				}
				if (DTRPatellarDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("patellar decreased,");
					neuroInputController.str = str1.toString();

				}if (DTRPatellarincrease.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("patellar increased,");
					neuroInputController.str = str1.toString();

				}if (DTRPatellarNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("patellar normal,");
					neuroInputController.str = str1.toString();

				}if (DTRAbnormalityOnRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("abnormality on left side only ,");
					neuroInputController.str = str1.toString();

				}
				
			}
			
			
			if(babinskiNormal.isSelected()){
				
				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Babinski  is normal (flexor or downgoing) bilaterally.");
				neuroInputController.str = str1.toString();
				
			}else{
				
				if (babinskiNormalFlexorF.isSelected() || babinskiNormalFlexorL.isSelected() || equivocalRight.isSelected()
						|| equivocalLeft.isSelected() || abnormalExtensiorL.isSelected() || abnormalExtensiorF.isSelected()) {

					StringBuilder str11 = new StringBuilder(neuroInputController.str);
					str11.append("Babinski reflexes were tested and showed the following response; ");
					neuroInputController.str = str11.toString();
										
					if (babinskiNormalFlexorF.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("flexor or downgoing) R, ");
						neuroInputController.str = str1.toString();
						

					}if (babinskiNormalFlexorL.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Normal (flexor/downgoing)  L, ");
						neuroInputController.str = str1.toString();
						

					}if (equivocalRight.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Equivocal Right, ");
						neuroInputController.str = str1.toString();
						
					}if (equivocalLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Equivocal Left, ");
						neuroInputController.str = str1.toString();
						
					}if (abnormalExtensiorL.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Abnormal (extensor/upgoing) L, ");
						neuroInputController.str = str1.toString();
						
					}if (abnormalExtensiorF.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Normal (Abnormal (extensor/upgoing) R, ");
						neuroInputController.str = str1.toString();
						
					}
					

				}
				
				
				if(sensationNormal.isSelected()){
					
					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Sensation is intact.");
					neuroInputController.str = str1.toString();
					
				}else{
					
					if (lightTorchIncreased.isSelected() || lightTorchDecreased.isSelected() || discriminationIncreased.isSelected()
							|| pinpointNormal.isSelected() || pinpointDecreased.isSelected() || discriminationDecreased.isSelected()
							|| vibrationIncreased.isSelected() || vibrationDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("Sensation testing demonstrated; ");
						neuroInputController.str = str1.toString();
						
					}

					if (lightTorchIncreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("light touch increased, ");
						neuroInputController.str = str1.toString();
						
					}if (lightTorchDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("light touch decreased,");
						neuroInputController.str = str1.toString();
						
					}if (discriminationIncreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("2 pt discrimination increased, ");
						neuroInputController.str = str1.toString();
						
					}if (pinpointNormal.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("pinpoint normal, ");
						neuroInputController.str = str1.toString();
						
					}if (pinpointDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("pinpoint decreased, ");
						neuroInputController.str = str1.toString();
						
					}if (discriminationDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("2 pt discrimination decreased, ");
						neuroInputController.str = str1.toString();
						
					}if (vibrationIncreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("vibration increased, ");
						neuroInputController.str = str1.toString();
						
					}if (vibrationDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("vibration decreased, ");
						neuroInputController.str = str1.toString();
						
					}
					
				}
				
				
				
				
				
			}
			
			StringBuilder str1 = new StringBuilder(neuroInputController.str);
			str1.append(".");
			neuroInputController.str = str1.toString();
			//genericEMRChartingController.saveAllTextArea();
		++neuroInputController.formCount;	
		neuroInputController.setNeuroUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++neuroInputController.formCount;	
				neuroInputController.setNeuroUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}