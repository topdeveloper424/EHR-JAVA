package com.ets.controller.gui.emrCharting.exam.eye;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeOcularMotilityInputController Class
 *Description: eyeOcularMotility GUI Controller class
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

public class EyeOcularMotilityInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox allmovementsCheck;

    @FXML
    private CheckBox lateralGazeCheck;

    @FXML
    private CheckBox upwardGazeCheck;

    @FXML
    private CheckBox ocularNormalCheck;

    @FXML
    private CheckBox downwardGazeCheck;

    @FXML
    private CheckBox nystagmusCoarseCheck;

    @FXML
    private RadioButton fullRadio;

    @FXML
    private ToggleGroup ocular;

    @FXML
    private RadioButton decreasedRadio;

    @FXML
    private RadioButton leftEyeRadio;

    @FXML
    private ToggleGroup eye;

    @FXML
    private RadioButton rightEyeRadio;

    @FXML
    private RadioButton leftRightEyeRadio;

    @FXML
    private CheckBox nystagmusNotNotedCheck;

    @FXML
    private CheckBox nystagmusVerticalCheck;

    @FXML
    private CheckBox nystagmusHorizontalCheck;

    @FXML
    private CheckBox nystagmusBriefCheck;

    @FXML
    private CheckBox nystagmusSustainedCheck;

    @FXML
    private CheckBox nystagmusGenerallyNotedCheck;

    @FXML
    private CheckBox nystagmusFineCheck;

    @FXML
    private CheckBox nystagmusNormalCheck1;
    
    private ExamEyeInputController examEyeInputController;

    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
		this.examEyeInputController = examEyeInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\n: ");
			examEyeInputController.str = examComp.toString();
			
						
			
			if (ocularNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Extraocular motions are full bilaterally.");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				
					
					if (fullRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Extraocular motions are full  ");
						examEyeInputController.str = str1.toString();
						
					}if (decreasedRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("Extraocular motions are decreased ");
						examEyeInputController.str = str1.toString();
						
					}
				
				
			}
			
			
			
			if (leftEyeRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("left eye.");
				examEyeInputController.str = str1.toString();
				
			}if (rightEyeRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("right eye.");
				examEyeInputController.str = str1.toString();
				
			}if (leftRightEyeRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("left and right eyes.");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			
			
				
				if (allmovementsCheck.isSelected() || lateralGazeCheck.isSelected() || upwardGazeCheck.isSelected()
						|| downwardGazeCheck.isSelected() ) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("for ");
					examEyeInputController.str = str12.toString();
					
					if (allmovementsCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("all movements ,");
						examEyeInputController.str = str1.toString();
						
					}
					if (lateralGazeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("lateral gaze");
						examEyeInputController.str = str1.toString();
						
					}if (upwardGazeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("upward gaze,");
						examEyeInputController.str = str1.toString();
						
					}if (downwardGazeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("downward gaze,");
						examEyeInputController.str = str1.toString();
						
					}
					
				
			}
				
				
				
				if (nystagmusNormalCheck1.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("Nystagmus not noted.");
					examEyeInputController.str = str1.toString();
					
				}else{
					
					
					if (nystagmusBriefCheck.isSelected() || nystagmusCoarseCheck.isSelected()
							|| nystagmusFineCheck.isSelected() || nystagmusGenerallyNotedCheck.isSelected()
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
						if (nystagmusGenerallyNotedCheck.isSelected()) {

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
					
				}
			
			
			
			
			
			
			++examEyeInputController.formCount;	
			examEyeInputController.setEyeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEyeInputController.formCount;	
				examEyeInputController.setEyeUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
