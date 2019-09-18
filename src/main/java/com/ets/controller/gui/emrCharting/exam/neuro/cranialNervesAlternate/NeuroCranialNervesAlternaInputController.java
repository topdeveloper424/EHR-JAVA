package com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesAlternate;

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
 *Parameter Definition: Type object of NeuroCranialNervesAlternaInputController Class
 *Description: neuroCompExamCarnialNervesAlternate GUI Controller class
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
public class NeuroCranialNervesAlternaInputController implements Initializable {

private NeuroInputController neuroInputController;

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
private CheckBox bodyLeftLegCheck111;
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