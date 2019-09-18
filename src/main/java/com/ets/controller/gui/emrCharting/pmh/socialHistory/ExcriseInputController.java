package com.ets.controller.gui.emrCharting.pmh.socialHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExcriseInputController Class
 *Description: PMHExcrise.fxml GUI Controller class
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
public class ExcriseInputController implements  Initializable {
	
		@FXML
	    private RadioButton notExcriseRadio;

	    @FXML
	    private ToggleGroup level;

	    @FXML
	    private RadioButton occationalyRadio;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton regularlyRadio;

	    @FXML
	    private RadioButton fiveRadio;

	    @FXML
	    private ToggleGroup often;

	    @FXML
	    private RadioButton sevenRadio;

	    @FXML
	    private RadioButton sixRadio;

	    @FXML
	    private TextArea moreNotesTextArea;

	    @FXML
	    private RadioButton oneRadio;

	    @FXML
	    private RadioButton threeRadio;

	    @FXML
	    private RadioButton twoRadio;

	    @FXML
	    private RadioButton fourRadio;

	    @FXML
	    private TextField perDayText;
	    
	    private PMHSocialHistoryInputController pMHSocialHistoryInputController;


	    public void setpMHSocialHistoryInputController(PMHSocialHistoryInputController pMHSocialHistoryInputController) {
			this.pMHSocialHistoryInputController = pMHSocialHistoryInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\nSOCIAL HISTORY: ");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr.toString();
         
			if(notExcriseRadio.isSelected()){
        	 
        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
        	pmhSocialHitoryStr1.append(" Patient does not exercise. ");
 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
        	 
         }
			if(regularlyRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append(" Patient exercises regularly.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(occationalyRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append(" Patient exercises occationaly.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }

			if(oneRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append(" Normally exercises for one day times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(twoRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for two days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(threeRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for three days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(threeRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for three days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(fourRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for four days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(fourRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for four days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(fiveRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for five days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(sixRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for six days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
			if(sevenRadio.isSelected()){
	        	 
	        	StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
	        	pmhSocialHitoryStr1.append("Normally exercises for seven days times per week.");
	 			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	        	 
	         }
          if(perDayText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHSocialHistoryInputController.str);
				str11.append("for " +perDayText.getText() +"hours per day.");
				pMHSocialHistoryInputController.str = str11.toString();
				
			}
		
			++pMHSocialHistoryInputController.formCount;
			pMHSocialHistoryInputController.setSocialHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		

		skipBtn.setOnAction((event) -> {
			try {
				++pMHSocialHistoryInputController.formCount;
				pMHSocialHistoryInputController.setSocialHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
