package com.ets.controller.gui.emrCharting.exam.neuro.sensReflexCoord;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReflexesSensCoordInputController Class
 *Description: neuroExamReflexes  GUI Controller class
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
public class ReflexesSensCoordInputController implements Initializable {

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox reflexBiceps;

    @FXML
    private CheckBox reflexAnkle;

    @FXML
    private CheckBox reflexTriceps;

    @FXML
    private CheckBox reflexBrachioradialis;

    @FXML
    private CheckBox babinskiFlexor;

    @FXML
    private CheckBox babinskiExtensor;
    @FXML
    private RadioButton  heelNormalRightRadio;
    @FXML
    private CheckBox babinskiEquivocal;

    @FXML
    private CheckBox sensationintact;

    @FXML
    private CheckBox pinprick;

    @FXML
    private CheckBox vibration;

    @FXML
    private CheckBox face;

    @FXML
    private CheckBox bodyLeftHand;

    @FXML
    private CheckBox deep0;

    @FXML
    private CheckBox LightTorch;

    @FXML
    private CheckBox abnormalLeft;

    @FXML
    private CheckBox sensationNormal;

    @FXML
    private CheckBox BodyleftUpperArm;

    @FXML
    private CheckBox rombergNormal;

    @FXML
    private CheckBox tandemNormal;

    @FXML
    private CheckBox deepNormal;

    @FXML
    private CheckBox deep1;

    @FXML
    private CheckBox deep2;

    @FXML
    private CheckBox deep3;

    @FXML
    private CheckBox deep4;

    @FXML
    private CheckBox reflexKnee;

    @FXML
    private CheckBox abnormalRight;

    @FXML
    private CheckBox abnormal0;

    @FXML
    private CheckBox abnormal1;

    @FXML
    private CheckBox abnormal2;

    @FXML
    private CheckBox abnormal3;

    @FXML
    private CheckBox abnormal4;

    @FXML
    private CheckBox abnormalBiceps;

    @FXML
    private CheckBox abnormalTriceps;

    @FXML
    private CheckBox abnormalBrachioradialis;

    @FXML
    private CheckBox abnormalKnee;

    @FXML
    private CheckBox abnormalAnkle;

    @FXML
    private CheckBox babinskiRight;

    @FXML
    private CheckBox babinskiLeft;

    @FXML
    private CheckBox sensationIntactExceptDecreased;

    @FXML
    private CheckBox babinskiIntactAbsent;

    @FXML
    private CheckBox bodyRightForearm;

    @FXML
    private CheckBox bodyForehead;

    @FXML
    private CheckBox bodyLeftleg;

    @FXML
    private CheckBox bodyRightUpperArm;

    @FXML
    private CheckBox bodyLeftFoot;

    @FXML
    private CheckBox bodyRightLeg;

    @FXML
    private CheckBox bodyLeftForearm;

    @FXML
    private CheckBox bodyRightHand;

    @FXML
    private CheckBox bodyrightFoot;

    @FXML
    private RadioButton rombergNegativeRadio;

    @FXML
    private RadioButton rombergPositiveRadio;

    @FXML
    private RadioButton rombergGrosslyPositiveRadio;

    @FXML
    private RadioButton tandemNormalRadio;

    @FXML
    private RadioButton tandemDecreasedRadio;

    @FXML
    private RadioButton tandemGrosslyDecreasedRadio;

    @FXML
    private CheckBox fingerRightNormal;

    @FXML
    private RadioButton fingerLefttNormalRadio;

    @FXML
    private RadioButton fingerLeftDecreasedRadio;

    @FXML
    private RadioButton fingerLeftpasRadio;

    @FXML
    private RadioButton FingerRightNormal;

    @FXML
    private RadioButton FingerRightDecreasedRadio;

    @FXML
    private RadioButton FingerRightPastRadio;

    @FXML
    private CheckBox heelNormal;

    @FXML
    private RadioButton heelBilateralNormalRadio;

    @FXML
    private RadioButton heelDecreasedLeftRadio;

    @FXML
    private RadioButton heelDecreasedBilaterallyRadio;

    @FXML
    private RadioButton heelDecreasedRightRadio;

    @FXML
    private RadioButton heelNormalLeftRadio;

    @FXML
    private CheckBox dysdiadoNormal;
    @FXML
    private CheckBox sensationIntactExceptAbsent;

    @FXML
    private RadioButton dysdiadoNotNoted;

    @FXML
    private RadioButton dysdiadoNoted;
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

			if (deepNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Neurological exam showed normal reflexes.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (deep0.isSelected()||deep1.isSelected()||deep2.isSelected()||deep3.isSelected()
						||deep4.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Deep tendon reflexes were ");
					neuroInputController.str = str1.toString();

				}
				
				
				if (deep0.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("0,");
					neuroInputController.str = str1.toString();

				}	
				if (deep1.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("1+,");
					neuroInputController.str = str1.toString();

				}	
				

				if (deep2.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("2+,");
					neuroInputController.str = str1.toString();

				}	
				if (deep3.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3+,");
					neuroInputController.str = str1.toString();

				}	
				if (deep4.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("4+.");
					neuroInputController.str = str1.toString();

				}	
				
			}
	
			if (reflexBiceps.isSelected()||reflexAnkle.isSelected()||reflexBrachioradialis.isSelected()||reflexTriceps.isSelected()
					||reflexKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("in the ");
				neuroInputController.str = str1.toString();

			}
			
			
			if (reflexBiceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("biceps,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexAnkle.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("ankle,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexBrachioradialis.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("brachioradialis,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("knee,");
				neuroInputController.str = str1.toString();

			}if (reflexTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("triceps,");
				neuroInputController.str = str1.toString();

			}
			
			
			if (abnormalLeft.isSelected()||abnormal0.isSelected()||abnormal1.isSelected()||abnormal2.isSelected()
					||abnormal3.isSelected()||abnormal4.isSelected()||abnormalAnkle.isSelected()
					||abnormalBiceps.isSelected()||abnormalBrachioradialis.isSelected()||abnormalKnee.isSelected()
					||abnormalRight.isSelected()||abnormalTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Abnormalities were noted in the");
				neuroInputController.str = str1.toString();

			}
			
			
			if (abnormal0.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("0+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal1.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("1+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal2.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("2+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal3.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("3+,");
				neuroInputController.str = str1.toString();

			}if (abnormal4.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("4+,");
				neuroInputController.str = str1.toString();

			}if (abnormalAnkle.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("ankle,,");
				neuroInputController.str = str1.toString();

			}if (abnormalBiceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("biceps,");
				neuroInputController.str = str1.toString();

			}if (abnormalBrachioradialis.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("brachioradialis,");
				neuroInputController.str = str1.toString();

			}if (abnormalKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("knee,");
				neuroInputController.str = str1.toString();

			}if (abnormalLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left,");
				neuroInputController.str = str1.toString();

			}if (abnormalRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right,");
				neuroInputController.str = str1.toString();

			}if (abnormalTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("triceps,");
				neuroInputController.str = str1.toString();

			}
			
			
			
			
			if (babinskiEquivocal.isSelected()||babinskiExtensor.isSelected()||babinskiFlexor.isSelected()
					||babinskiLeft.isSelected()||babinskiRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Babinski response was ");
				neuroInputController.str = str1.toString();

			}
			
			
			if (babinskiEquivocal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("equivocal, ,");
				neuroInputController.str = str1.toString();

			}	
			

			if (babinskiExtensor.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("extensor,");
				neuroInputController.str = str1.toString();

			}	
			if (babinskiFlexor.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" flexor,");
				neuroInputController.str = str1.toString();

			}	
				
			if (babinskiLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left,");
				neuroInputController.str = str1.toString();

			}	if (babinskiRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right ,");
				neuroInputController.str = str1.toString();

			}	
			if (sensationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Sensation was intact,");
				neuroInputController.str = str1.toString();

			}	
			else{
			
				if (sensationintact.isSelected()||sensationIntactExceptDecreased.isSelected()
						||sensationIntactExceptAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Sensation was  ,");
					neuroInputController.str = str1.toString();

				}	
				if (sensationintact.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("intact,");
					neuroInputController.str = str1.toString();

				}	if (sensationIntactExceptDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("except for decreased ,");
					neuroInputController.str = str1.toString();

				}	
				if (sensationIntactExceptAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" intact except for absent ,");
					neuroInputController.str = str1.toString();

				}	
				
			}
			
			
		
			if (LightTorch.isSelected()||pinprick.isSelected()
					||vibration.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" sensation of ");
				neuroInputController.str = str1.toString();

			}	
			if (LightTorch.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("light torch,");
				neuroInputController.str = str1.toString();

			}	if (pinprick.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("pinprick,");
				neuroInputController.str = str1.toString();

			}	
			if (vibration.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("vibration,");
				neuroInputController.str = str1.toString();

			}	
			
			
			if (face.isSelected()||bodyForehead.isSelected()
					||bodyLeftFoot.isSelected()||bodyLeftForearm.isSelected()||bodyLeftHand.isSelected()
					||bodyLeftleg.isSelected()||bodyrightFoot.isSelected()||bodyRightForearm.isSelected()
					||bodyRightHand.isSelected()||bodyRightLeg.isSelected()||bodyRightUpperArm.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" . applied to the ");
				neuroInputController.str = str1.toString();

			}	
			if (face.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("face,");
				neuroInputController.str = str1.toString();

			}	if (bodyForehead.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("forehead,");
				neuroInputController.str = str1.toString();

			}	
			if (bodyLeftForearm.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left forearm,");
				neuroInputController.str = str1.toString();

			}if (bodyLeftHand.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left hand,");
				neuroInputController.str = str1.toString();

			}	if (bodyLeftleg.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left leg,");
				neuroInputController.str = str1.toString();

			}	
			if (bodyrightFoot.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right foot,");
				neuroInputController.str = str1.toString();

			}	if (bodyRightForearm.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right forearm,");
				neuroInputController.str = str1.toString();

			}	if (bodyRightHand.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right hand,");
				neuroInputController.str = str1.toString();

			}	if (bodyRightLeg.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right leg,");
				neuroInputController.str = str1.toString();

			}	if (bodyRightUpperArm.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right upper arm,");
				neuroInputController.str = str1.toString();

			}	
			
			if (rombergNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Romberg negative.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (rombergGrosslyPositiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg grossly positive.");
					neuroInputController.str = str1.toString();

				}	if (rombergNegativeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg  negative.");
					neuroInputController.str = str1.toString();

				}	if (rombergPositiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg positive,");
					neuroInputController.str = str1.toString();

				}	
				
				
			}
			
			
			if (tandemNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Tandem gait normal.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (tandemDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Romberg  decreased.");
					neuroInputController.str = str1.toString();

				}	if (tandemGrosslyDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Tandem gait grossly decreased.");
					neuroInputController.str = str1.toString();

				}	if (tandemNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Tandem gait normal.");
					neuroInputController.str = str1.toString();

				}	
				
				
			}
			
			if (fingerRightNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Finger to nose: left normal,right normal .");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (fingerLeftDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left decrease.");
					neuroInputController.str = str1.toString();

				}	if (fingerLeftpasRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left paspointing.");
					neuroInputController.str = str1.toString();

				}	if (fingerLefttNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose left normal.");
					neuroInputController.str = str1.toString();

				}	
				if (FingerRightDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right decreased.");
					neuroInputController.str = str1.toString();
				}
				if (FingerRightPastRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right paspointing.");
					neuroInputController.str = str1.toString();
				}
				if (FingerRightNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Finger to nose right normal.");
					neuroInputController.str = str1.toString();
				}
				
			}
			
			
			
			
			if(heelNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Coordination and balance: Heel / knee / shin normal bilaterally.");
				neuroInputController.str = str1.toString();

			}	else{
				
				
				
				if (heelBilateralNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin normal bilaterally.");
					neuroInputController.str = str1.toString();

				}	if (heelDecreasedBilaterallyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin decreased bilaterally");
					neuroInputController.str = str1.toString();

				}	if (heelDecreasedLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Coordination and balance: Heel / knee / shin: decreased left.");
					neuroInputController.str = str1.toString();

				}	
				if (heelDecreasedRightRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: decreased right.");
					neuroInputController.str = str1.toString();
				}
				if (heelNormalLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: normal left.");
					neuroInputController.str = str1.toString();
				}
				if (heelNormalRightRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Coordination and balance: Heel / knee / shin: normal right.");
					neuroInputController.str = str1.toString();
				}
				
			}
			if (dysdiadoNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Dysdiadochokinesis not noted.");
				neuroInputController.str = str1.toString();
			}else{
				
				if (dysdiadoNotNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis not noted.");
					neuroInputController.str = str1.toString();
				}	
				if (dysdiadoNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Dysdiadochokinesis noted.");
					neuroInputController.str = str1.toString();
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


