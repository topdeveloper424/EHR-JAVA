package com.ets.controller.gui.emrCharting.exam.neuro.sensation;

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
 *Parameter Definition: Type object of NeuroSensationInputController Class
 *Description: neuroExamSensation GUI Controller class
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
public class NeuroSensationInputController implements Initializable {

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
    private CheckBox sensationIntactExceptAbsent;

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
    private RadioButton heelNormalRightRadio;

    @FXML
    private CheckBox dysdiadoNormal;

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
			skelComp.append("\n\nNEUROLOGICAL");
			neuroInputController.str = skelComp.toString();

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