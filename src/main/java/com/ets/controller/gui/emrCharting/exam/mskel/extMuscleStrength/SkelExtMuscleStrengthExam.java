package com.ets.controller.gui.emrCharting.exam.mskel.extMuscleStrength;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelExtMuscleStrengthExam Class
 *Description: EXTMuscleToneExam GUI Controller class
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
public class SkelExtMuscleStrengthExam implements Initializable {
	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox muscletoneNormal;

	    @FXML
	    private CheckBox normalToneCheck;

	    @FXML
	    private CheckBox spasticityCheck;

	    @FXML
	    private CheckBox cogwheelCheck;

	    @FXML
	    private CheckBox atrophyCheck;

	    @FXML
	    private CheckBox fasciculationsCheck;

	    @FXML
	    private CheckBox paralysisCheck;

	    @FXML
	    private CheckBox flaccidityCheck;

	    @FXML
	    private CheckBox partialParalysisCheck;

	    @FXML
	    private CheckBox AllextremitiesCheck;

	    @FXML
	    private CheckBox upperExtremitiesCheck;


	    @FXML
	    private CheckBox rightLowerextremityCheck;

	    @FXML
	    private CheckBox tremorsCheck;

	    @FXML
	    private CheckBox dyskinesiaCheck1;

	    @FXML
	    private CheckBox LowerExtremitiesCheck1;

	    @FXML
	    private CheckBox rightUpperExtremityCheck;

	    @FXML
	    private CheckBox leftUpperExtrimityCheck;

	    
	    @FXML

	    private CheckBox leftLowerExtrimityCheck;
	
	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {
			
			StringBuilder examBasic = new StringBuilder(msSkelInputController.str);
			examBasic.append("\n\n ");
			msSkelInputController.str = examBasic.toString();

			if (muscletoneNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);

				str1.append("Examination of muscle tone and movement showed normal tone and movement in all extremities.");

				msSkelInputController.str = str1.toString();

			}else{
				
				if (normalToneCheck.isSelected() || cogwheelCheck.isSelected()
						|| fasciculationsCheck.isSelected() || paralysisCheck.isSelected()
						|| spasticityCheck.isSelected() || dyskinesiaCheck1.isSelected()
						||atrophyCheck.isSelected()||flaccidityCheck.isSelected()||partialParalysisCheck.isSelected()

						||tremorsCheck.isSelected() || AllextremitiesCheck.isSelected() || LowerExtremitiesCheck1.isSelected()
						|| rightUpperExtremityCheck.isSelected() || rightLowerextremityCheck.isSelected()
						|| upperExtremitiesCheck.isSelected() || leftUpperExtrimityCheck.isSelected()
						|| leftLowerExtrimityCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("Examination of muscle tone and movement showed ");

					msSkelInputController.str = str1.toString();

				}
				
				if (normalToneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);

					str1.append("normal tone and movement, ");

					msSkelInputController.str = str1.toString();

				}
				if (cogwheelCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);

					str1.append("cogwheel rigidity,");
					msSkelInputController.str = str1.toString();

				} 
				if (fasciculationsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("fasciculations, ");

					msSkelInputController.str = str1.toString();

				}
				
				if (paralysisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);

					str1.append("paralysis, ");

					msSkelInputController.str = str1.toString();

				}
				if (spasticityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);

					str1.append("spasticity, ");

					msSkelInputController.str = str1.toString();

				}
				if (dyskinesiaCheck1.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);

					str1.append("dyskinesia, ");
					msSkelInputController.str = str1.toString();

				}if (atrophyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("atrophy, ");
					msSkelInputController.str = str1.toString();

				}if (flaccidityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("flaccidity, ");
					msSkelInputController.str = str1.toString();

				}if (partialParalysisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("partial paralysis,");
					msSkelInputController.str = str1.toString();

				}if (tremorsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("tremors. ");
					msSkelInputController.str = str1.toString();

				}if (AllextremitiesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("in all extremities, ");
					msSkelInputController.str = str1.toString();

				}if (LowerExtremitiesCheck1.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the lower extremities, ");
					msSkelInputController.str = str1.toString();

				}if (rightUpperExtremityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the right upper extremity,  ");
					msSkelInputController.str = str1.toString();
					
				}if (rightLowerextremityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the right lower extremity, ");
					msSkelInputController.str = str1.toString();

				}if (upperExtremitiesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the upper extremities, ");
					msSkelInputController.str = str1.toString();

				}if (leftUpperExtrimityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the left upper extremity, ");
					msSkelInputController.str = str1.toString();

				}if (leftLowerExtrimityCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("the left lower extremity, ");

					msSkelInputController.str = str1.toString();

				}
				
			}
					
	
		++msSkelInputController.formCount;
		msSkelInputController.setSkelUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
		
	});

	skipBtn.setOnAction((event) -> {
		try {
			++msSkelInputController.formCount;
			msSkelInputController.setSkelUI();
			new FXFormCommonUtilities().closeForm(skipBtn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
}
}
