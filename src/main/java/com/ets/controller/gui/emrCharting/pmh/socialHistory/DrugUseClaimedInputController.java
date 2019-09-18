package com.ets.controller.gui.emrCharting.pmh.socialHistory;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DrugUseClaimedInputController Class
 *Description: EnterDrugScreen.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class DrugUseClaimedInputController implements Initializable {
	
	  @FXML
	    private RadioButton choiceNoDrugsRadio;

	    @FXML
	    private ToggleGroup choice;

	    @FXML
	    private RadioButton choiceMarijunaRadio;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton choiceCocaineRadio;

	    @FXML
	    private RadioButton choiceOpiatesRadio;

	    @FXML
	    private RadioButton choiceStimulantsRadio;

	    @FXML
	    private RadioButton choiceHallucinogenRadio;

	    @FXML
	    private RadioButton choiceBenzodiazeRadio;

	    @FXML
	    private RadioButton dailyRadio;

	    @FXML
	    private ToggleGroup frequency;

	    @FXML
	    private RadioButton monthlyRadio;

	    @FXML
	    private RadioButton weeklyRadio;

	    @FXML
	    private RadioButton onRareOccationRadio;

	    @FXML
	    private RadioButton admitsRadio;

	    @FXML
	    private ToggleGroup preception;

	    @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton considerRadio;

	    @FXML
	    private RadioButton stronglyDeniesRadio;

	    @FXML
	    private TextArea otherNotesTextArea;

	    @FXML
	    private CheckBox NormalCheck;
	    
	    private PMHSocialHistoryInputController pMHSocialHistoryInputController;


	    public void setpMHSocialHistoryInputController(PMHSocialHistoryInputController pMHSocialHistoryInputController) {
			this.pMHSocialHistoryInputController = pMHSocialHistoryInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr.toString();
			
			if(NormalCheck.isSelected()){
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient denies any recreational drug use. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
				


			}else{
			if(choiceNoDrugsRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use no drugs. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}if(choiceCocaineRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use cocaine.");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
           if(choiceOpiatesRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use  opiates. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}if(choiceBenzodiazeRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use benzodiazepines. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
           if(choiceMarijunaRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use  marijuana.. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
           if(choiceStimulantsRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use stimulants. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			} if(choiceHallucinogenRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("SOCIAL HISTORY: Patient claims to use hallucinogen. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			}
			
			if(dailyRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" daily");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

				
			}
			
	   if(weeklyRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" weekly");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

				
			}	
	   if(monthlyRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" monthly");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

				
			}
	   if(onRareOccationRadio.isSelected()){
			
			StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr1.append(" on rare occasion ");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

			
		}
		
	   if(admitsRadio.isSelected()){

			StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr1.append(",admits there is a problem.");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

		   
	   } if(considerRadio.isSelected()){

			StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr1.append(",considers possible there is a problem.");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

		   
	   }if(deniesRadio.isSelected()){

			StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr1.append(",denies there is a problem.");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

		   
	   }if(stronglyDeniesRadio.isSelected()){

			StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr1.append(", strongly denies there is a problem.");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();

		   
	   }
			
			
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
