package com.ets.controller.gui.emrCharting.exam.skin.skinLacerationFollowUp;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinLacerationFollowUpInputController Class
 *Description: skinLacerationFollowUp.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class SkinLacerationFollowUpInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox rightCkeckBox;

	    @FXML
	    private CheckBox CkeckBox2;

	    @FXML
	    private CheckBox CkeckBox5;

	    @FXML
	    private CheckBox leftCkeckBox;

	    @FXML
	    private CheckBox CkeckBox3;

	    @FXML
	    private CheckBox CkeckBoxMore;

	    @FXML
	    private CheckBox CkeckBox1;

	    @FXML
	    private CheckBox CkeckBox4;

	    @FXML
	    private CheckBox armCkeckBox;

	    @FXML
	    private CheckBox chestCkeckBox;
	    
	    
	    @FXML
	    private CheckBox  IncludeCheck;

	    @FXML
	    private CheckBox fingerCkeckBox;

	    @FXML
	    private CheckBox footCkeckBox;

	    @FXML
	    private CheckBox abdomenCkeckBox;

	    @FXML
	    private CheckBox faceCkeckBox;

	    @FXML
	    private CheckBox kneeCkeckBox;

	    @FXML
	    private CheckBox sclapCkeckBox;

	    @FXML
	    private CheckBox backCkeckBox;

	    @FXML
	    private CheckBox handCkeckBox;

	    @FXML
	    private CheckBox legCkeckBox;

	    @FXML
	    private CheckBox toeCkeckBox;

	    @FXML
	    private RadioButton SwellingnegativeRadio;

	    @FXML
	    private ToggleGroup Swelling;

	    @FXML
	    private RadioButton SwellingPssitiveRadio;

	    @FXML
	    private RadioButton IndurationnegativeRadio;

	    @FXML
	    private ToggleGroup Induration;

	    @FXML
	    private RadioButton IndurationPssitiveRadio;

	    @FXML
	    private RadioButton circulationNormal;

	    @FXML
	    private ToggleGroup circulation;

	    @FXML
	    private RadioButton circulationAbnormal;

	    @FXML
	    private RadioButton injuryNegativeRadio;

	    @FXML
	    private ToggleGroup injury;

	    @FXML
	    private RadioButton injuryPossitiveRadio;

	    @FXML
	    private TextArea detailBodyPartText;

	    @FXML
	    private TextArea detailBodyPartCantText;

	    @FXML
	    private RadioButton ErythemanegativeRadio;

	    @FXML
	    private ToggleGroup Erythema;

	    @FXML
	    private RadioButton ErythemaPssitiveRadio;

	    @FXML
	    private RadioButton WarmthnegativeRadio;

	    @FXML
	    private ToggleGroup Warmth;

	    @FXML
	    private RadioButton WarmthPssitiveRadio;

	    @FXML
	    private RadioButton DischargenegativeRadio;

	    @FXML
	    private ToggleGroup Discharge;

	    @FXML
	    private RadioButton DischargePssitiveRadio;

	    @FXML
	    private RadioButton DehiscencenegativeRadio;

	    @FXML
	    private ToggleGroup Dehiscence;

	    @FXML
	    private RadioButton DehiscencePssitiveRadio;

	    @FXML
	    private RadioButton SensorynegativeRadio;

	    @FXML
	    private ToggleGroup Sensory;

	    @FXML
	    private RadioButton SensoryPssitiveRadio;
	    
	    private ExamSkinInputController examSkinInputController;
		
		public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
			this.examSkinInputController = examSkinInputController;
		}

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			StringBuilder skelComp = new StringBuilder(examSkinInputController.str);
			skelComp.append("\nLaceration was to : ");
			examSkinInputController.str = skelComp.toString();

			if (faceCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("face/neck,");
				examSkinInputController.str = str1.toString();

			}
			if (sclapCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scalp,");
				examSkinInputController.str = str1.toString();

			}
			if (chestCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" chest,");
				examSkinInputController.str = str1.toString();

			}
			if (abdomenCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" abdomen,");
				examSkinInputController.str = str1.toString();

			}if (backCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" back,");
				examSkinInputController.str = str1.toString();

			}if (armCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" arm,");
				examSkinInputController.str = str1.toString();

			}if (handCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hand,");
				examSkinInputController.str = str1.toString();

			}if (fingerCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" finger,");
				examSkinInputController.str = str1.toString();

			}if (legCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" leg,");
				examSkinInputController.str = str1.toString();

			}if (footCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" foot,");
				examSkinInputController.str = str1.toString();

			}if (toeCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" toe,");
				examSkinInputController.str = str1.toString();

			}if (kneeCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" knee,");
				examSkinInputController.str = str1.toString();

			}
			StringBuilder str1 = new StringBuilder(examSkinInputController.str);
			str1.append(".");
			examSkinInputController.str = str1.toString();

			StringBuilder str12 = new StringBuilder(examSkinInputController.str);
			str1.append(detailBodyPartText.getText());
			examSkinInputController.str = str12.toString();
			if (rightCkeckBox.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" right,");
				examSkinInputController.str = strDemo.toString();

			}
			
			if (leftCkeckBox.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" left,");
				examSkinInputController.str = strDemo.toString();

			}if (CkeckBox1.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 1st,");
				examSkinInputController.str = strDemo.toString();

			}
			if (CkeckBox2.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 2nd,");
				examSkinInputController.str = strDemo.toString();

			}if (CkeckBox3.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 3rd,");
				examSkinInputController.str = strDemo.toString();

			}if (CkeckBox4.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 4th,");
				examSkinInputController.str = strDemo.toString();

			}if (CkeckBox5.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 5th,");
				examSkinInputController.str = strDemo.toString();

			}if (CkeckBox5.isSelected()) {

				StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
				strDemo.append(" 5th,");
				examSkinInputController.str = strDemo.toString();

			}
			StringBuilder strDemo = new StringBuilder(examSkinInputController.str);
			strDemo.append(detailBodyPartCantText.getText());
			examSkinInputController.str = strDemo.toString();
			
			if (ErythemanegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nErythema: negative.,");
				examSkinInputController.str = strDemo1.toString();

			}
		
			if (ErythemaPssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nErythema: positive.");
				examSkinInputController.str = strDemo1.toString();

			}
			if (SwellingnegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nSwelling: negative.");
				examSkinInputController.str = strDemo1.toString();

			}
			if (SwellingPssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nSwelling: positive.");
				examSkinInputController.str = strDemo1.toString();

			}
			if (IndurationnegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nInduration: negative.");
				examSkinInputController.str = strDemo1.toString();

			}
			if (IndurationPssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nInduration: positive.");
				examSkinInputController.str = strDemo1.toString();

			}if (WarmthnegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nWarmth: negative.");
				examSkinInputController.str = strDemo1.toString();

			}if (WarmthPssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nWarmth: positive.");
				examSkinInputController.str = strDemo1.toString();

			}if (DischargenegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nDischarge/Drainage: negative.");
				examSkinInputController.str = strDemo1.toString();

			}if (DischargePssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nDischarge/Drainage: positive.");
				examSkinInputController.str = strDemo1.toString();

			}
			if (DehiscencenegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nDehicence: negative.");
				examSkinInputController.str = strDemo1.toString();

			}if (DehiscencePssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nDehicence: positive.");
				examSkinInputController.str = strDemo1.toString();

			}if (SensorynegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nSensory deficit: negative.");
				examSkinInputController.str = strDemo1.toString();

			}if (SensoryPssitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nSensory deficit: positive.");
				examSkinInputController.str = strDemo1.toString();

			}if (circulationNormal.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nPeripheral Pulses/Circulation: normal.");
				examSkinInputController.str = strDemo1.toString();

			}if (circulationAbnormal.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nPeripheral Pulses/Circulation: abnormal.");
				examSkinInputController.str = strDemo1.toString();

			}if (IncludeCheck.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nROM: Please see below.");
				examSkinInputController.str = strDemo1.toString();

			}if (injuryNegativeRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nAssociated Injury: negative.");
				examSkinInputController.str = strDemo1.toString();

			}if (injuryPossitiveRadio.isSelected()) {

				StringBuilder strDemo1 = new StringBuilder(examSkinInputController.str);
				strDemo1.append("\nAssociated Injury: positive.");
				examSkinInputController.str = strDemo1.toString();

			}
			++examSkinInputController.formCount;	
		examSkinInputController.setSkinUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examSkinInputController.formCount;	
				examSkinInputController.setSkinUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
