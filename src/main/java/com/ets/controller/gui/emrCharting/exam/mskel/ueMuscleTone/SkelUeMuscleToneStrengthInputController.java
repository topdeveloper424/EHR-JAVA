package com.ets.controller.gui.emrCharting.exam.mskel.ueMuscleTone;

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
 *Parameter Definition: Type object of SkelUeMuscleToneStrengthInputController Class
 *Description: UEMuscleStrengthTone GUI Controller class
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
public class SkelUeMuscleToneStrengthInputController implements Initializable {
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox gaitNormal;

    @FXML
    private CheckBox normaltoneCheck;

    @FXML
    private CheckBox spasticityCheck;

    @FXML
    private CheckBox cogwheelCheck;

    @FXML
    private CheckBox atrophyCheck;

    @FXML
    private CheckBox fasciculationsCheck;

    @FXML
    private CheckBox paralysisheck;

    @FXML
    private CheckBox dyskinesiaCheck;

    @FXML
    private CheckBox flaccidityCheck;

    @FXML
    private CheckBox bothUpperCheck;

    @FXML
    private CheckBox rightUpperCheck;

    @FXML
    private CheckBox paralysisCheck;

    @FXML
    private CheckBox tremorsCheck;

    @FXML
    private CheckBox leftUpperCheck;

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
			
	      if (gaitNormal.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Examination of muscle tone and movement showed normal tone and movement in both upper extremities. ");
				msSkelInputController.str = str1.toString();
				
			}else{
				
				if(normaltoneCheck.isSelected() || spasticityCheck.isSelected()
			    		  || cogwheelCheck.isSelected() || atrophyCheck.isSelected() 
			    		  || fasciculationsCheck.isSelected()|| dyskinesiaCheck.isSelected()
			    		  || paralysisheck.isSelected()|| flaccidityCheck.isSelected()
			    		  || paralysisCheck.isSelected()|| tremorsCheck.isSelected()
			    		  ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Examination of muscle tone and movement showed ");
						msSkelInputController.str = str1.toString();
						
					}
			      if (normaltoneCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("normal tone and movement, ");
						msSkelInputController.str = str1.toString();
						
					}if (spasticityCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("spasticity, ");
						msSkelInputController.str = str1.toString();
						
					}if (cogwheelCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("cogwheel rigidity,");
						msSkelInputController.str = str1.toString();
						
					}if (atrophyCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("atrophy, ");
						msSkelInputController.str = str1.toString();
						
					}if (fasciculationsCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("fasciculations,");
						msSkelInputController.str = str1.toString();
						
					}if (dyskinesiaCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("dyskinesia, ");
						msSkelInputController.str = str1.toString();
						
					}if (paralysisheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("paralysis, ");
						msSkelInputController.str = str1.toString();
						
					}if (flaccidityCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("flaccidity, ");
						msSkelInputController.str = str1.toString();
						
					}if (paralysisCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("partial paralysis, ");
						msSkelInputController.str = str1.toString();
						
					}if (tremorsCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("tremors, ");
						msSkelInputController.str = str1.toString();
						
					}if (bothUpperCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("in both upper extremities, ");
						msSkelInputController.str = str1.toString();
						
					}if (rightUpperCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("the right upper extremity. ");
						msSkelInputController.str = str1.toString();
						
					}if (leftUpperCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("the left upper extremity, ");
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
