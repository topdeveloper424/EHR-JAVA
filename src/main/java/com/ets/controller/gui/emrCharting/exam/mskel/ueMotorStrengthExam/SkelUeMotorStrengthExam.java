package com.ets.controller.gui.emrCharting.exam.mskel.ueMotorStrengthExam;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelUeMotorStrengthExam Class
 *Description: UEMotorStrengthExam GUI Controller class
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
public class SkelUeMotorStrengthExam implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox LEMuscleNormal;

	    @FXML
	    private CheckBox leftUpperActions;

	    @FXML
	    private CheckBox leftUpperActionsFlexion;

	    @FXML
	    private CheckBox leftUpperTricepsChck;

	    @FXML
	    private CheckBox leftUpperExtremityChck;

	    @FXML
	    private CheckBox leftUpperBicepsChck;

	    @FXML
	    private CheckBox rightUEMuscleNormal;

	    @FXML
	    private CheckBox leftUpperActionsAdductions;

	    @FXML
	    private RadioButton RightUEMuscleNormalRadio;

	    @FXML
	    private RadioButton LEMuscleNormalRadio;

	    @FXML
	    private RadioButton LEMuscleModerateRadio;

	    @FXML
	    private RadioButton LEMuscleAbsentRadio;

	    @FXML
	    private RadioButton LEMuscleSlightlyRadio;

	    @FXML
	    private RadioButton LEMuscleMarkedlyRadio;

	    @FXML
	    private CheckBox leftUpperActionsSupination;

	    @FXML
	    private CheckBox leftUpperActionsExtension;

	    @FXML
	    private CheckBox leftUpperActionsPronation;

	    @FXML
	    private CheckBox leftUpperHandChck;

	    @FXML
	    private CheckBox leftUpperShoulderChck;

	    @FXML
	    private CheckBox leftUpperForearmChck;

	    @FXML
	    private RadioButton RightUEMuscleModerateRadio;

	    @FXML
	    private RadioButton RightUEMuscleAbsentRadio;

	    @FXML
	    private RadioButton RightUEMuscleSlightlyRadio;

	    @FXML
	    private RadioButton RightUEMuscleMarkedlyRadio;

	    @FXML
	    private CheckBox rightUpperActions;

	    @FXML
	    private CheckBox rightUpperActionsFlexion;

	    @FXML
	    private CheckBox rightUpperActionsAdductions;

	    @FXML
	    private CheckBox rightUpperActionsSupination;

	    @FXML
	    private CheckBox rightUpperActionsExtension;

	    @FXML
	    private CheckBox rightUpperActionsPronation;

	    @FXML
	    private CheckBox rightUpperExtremity;

	    @FXML
	    private CheckBox leftUpperGripChck1;

	    @FXML
	    private CheckBox leftUpperWristChck;

	    @FXML
	    private CheckBox leftUppertricepsChck1;

	    @FXML
	    private CheckBox rightUpperBicepsChck1;

	    @FXML
	    private CheckBox rightUpperHandChck1;

	    @FXML
	    private CheckBox rightUppershoulderChk;

	    @FXML
	    private CheckBox rightUpperForearmChk;

	    @FXML
	    private CheckBox rightUpperGripCheck;

	    @FXML
	    private CheckBox rightUpperWristCheck;



	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			/*StringBuilder skelComp = new StringBuilder(msSkelInputController.str);
			skelComp.append("\n\nGI & ABDOMEN: ");
			msSkelInputController.str = skelComp.toString();*/
			 if(LEMuscleNormal.isSelected() || LEMuscleMarkedlyRadio.isSelected() || LEMuscleSlightlyRadio.isSelected()||LEMuscleAbsentRadio.isSelected()||LEMuscleModerateRadio.isSelected()|| LEMuscleNormalRadio.isSelected()||leftUpperActions.isSelected() || leftUpperActionsAdductions.isSelected()
		    		  || leftUpperActionsExtension.isSelected() || leftUpperActionsFlexion.isSelected() 
		    		  || leftUpperActionsSupination.isSelected()|| leftUpperActionsPronation.isSelected() || leftUpperExtremityChck.isSelected() || leftUpperHandChck.isSelected()
		    		  || leftUpperGripChck1.isSelected() || leftUpperTricepsChck.isSelected() 
		    		  || leftUpperShoulderChck.isSelected()|| leftUpperWristChck.isSelected()
		    		  || leftUpperBicepsChck.isSelected()|| leftUpperForearmChck.isSelected()
		    		  
		    		  ){
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("\nMotor strength testing of the left upper extremity: ");
					msSkelInputController.str = str1.toString();
					
				}
	      if (LEMuscleNormal.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(msSkelInputController.str);
				str11.append("normal. ");
				msSkelInputController.str = str11.toString();
				
				
					
				
			}else{
				
				if (LEMuscleNormalRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("normal.");
					msSkelInputController.str = str1.toString();
					
				}if (LEMuscleModerateRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("moderately decreased");
					msSkelInputController.str = str1.toString();
					
				}if (LEMuscleAbsentRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("absent");
					msSkelInputController.str = str1.toString();
					
				}if (LEMuscleSlightlyRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("slightly decreased");
					msSkelInputController.str = str1.toString();
					
				}if (LEMuscleMarkedlyRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("markedly decreased");
					msSkelInputController.str = str1.toString();
					
				}
				
				if(leftUpperActions.isSelected() || leftUpperActionsAdductions.isSelected()
			    		  || leftUpperActionsExtension.isSelected() || leftUpperActionsFlexion.isSelected() 
			    		  || leftUpperActionsSupination.isSelected()|| leftUpperActionsPronation.isSelected()){
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append(" for ");
					msSkelInputController.str = str1.toString();
				}
				
				 if (leftUpperActions.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("all actions, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperActionsAdductions.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("adduction,  ");
						msSkelInputController.str = str1.toString();
						 
					}if (leftUpperActionsExtension.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("extension, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperActionsFlexion.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("flexion, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperActionsSupination.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("supination, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperActionsPronation.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("pronation, ");
						msSkelInputController.str = str1.toString();
						
					}
					
					if (leftUpperExtremityChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("of the extremity, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperHandChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("hand, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperGripChck1.isSelected()) {
						 
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("grip, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperTricepsChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("triceps, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperShoulderChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("shoulder, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperWristChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("wrist, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperBicepsChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("biceps, ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperForearmChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("forearm, ");
						msSkelInputController.str = str1.toString();
						
					}
					
				
			}
		      
	  
	      
	      
	      
		      
	      
	      
	    
	      
	      
	      
	      if (rightUEMuscleNormal.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append(" Right upper extremity: normal.");
					msSkelInputController.str = str1.toString();
					
				}else{
					
					if(RightUEMuscleNormalRadio.isSelected() || RightUEMuscleAbsentRadio.isSelected() || RightUEMuscleMarkedlyRadio.isSelected() ||
							RightUEMuscleModerateRadio.isSelected() || RightUEMuscleSlightlyRadio.isSelected()
							|| rightUpperActions.isSelected() || rightUpperActionsSupination.isSelected()
							||rightUpperActionsFlexion.isSelected() || rightUpperActionsExtension.isSelected()
							|| rightUpperActionsAdductions.isSelected() || rightUpperActionsPronation.isSelected()){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Right upper extremity : ");
						msSkelInputController.str = str1.toString();
						
					}if (RightUEMuscleNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("normal.");
						msSkelInputController.str = str1.toString();
						
					}if (RightUEMuscleAbsentRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("absent");
						msSkelInputController.str = str1.toString();
						
					}if (RightUEMuscleMarkedlyRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("markedly decreased");
						msSkelInputController.str = str1.toString();
						
					}if (RightUEMuscleModerateRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("moderately decreased");
						msSkelInputController.str = str1.toString();
						
					}if (RightUEMuscleSlightlyRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("slightly decreased");
						msSkelInputController.str = str1.toString();
						
					}
					
					if(rightUpperActions.isSelected() || rightUpperActionsSupination.isSelected()
							||rightUpperActionsFlexion.isSelected() || rightUpperActionsExtension.isSelected()
							|| rightUpperActionsAdductions.isSelected() || rightUpperActionsPronation.isSelected() ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append(" for ");
						msSkelInputController.str = str1.toString();
						
					}
					
						if(rightUpperActions.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("for all actions, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperActionsSupination.isSelected()){
							 
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("supination, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperActionsFlexion.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("flexion, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperActionsExtension.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("extension, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperActionsAdductions.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("abduction, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperActionsPronation.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("pronation, ");
							msSkelInputController.str = str1.toString();
							
						}
					
						if(rightUpperExtremity.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("of the extremity, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperHandChck1.isSelected()){
							 
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("hand, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperGripCheck.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("grip, ");
							msSkelInputController.str = str1.toString();
							
						}if(leftUppertricepsChck1.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("triceps, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUppershoulderChk.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("shoulder, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperWristCheck.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("wrist, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperBicepsChck1.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("biceps, ");
							msSkelInputController.str = str1.toString();
							
						}if(rightUpperForearmChk.isSelected()){
							
							StringBuilder str1 = new StringBuilder(msSkelInputController.str);
							str1.append("forearm, ");
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
			new FXFormCommonUtilities().closeForm( skipBtn);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		
	}
}
