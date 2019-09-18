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
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LeisureTimeUseInputController Class
 *Description: leisureTimeUse.fxml GUI Controller class
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
public class LeisureTimeUseInputController implements Initializable {

    @FXML
    private RadioButton familyActiitiesRadio;

    @FXML
    private ToggleGroup level;

    @FXML
    private RadioButton TraelingRadio;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton onComputerRadio;

    @FXML
    private RadioButton PlayingsportsRadio;

    @FXML
    private RadioButton ListeningToradioRadio;

    @FXML
    private TextArea moreNotesTextArea;

    @FXML
    private RadioButton iitingRadio;

    @FXML
    private RadioButton InNoSpecificRadio;

    @FXML
    private RadioButton ReadingRadio;

    @FXML
    private RadioButton watchingRadio;
    
    private PMHSocialHistoryInputController pMHSocialHistoryInputController;


    public void setpMHSocialHistoryInputController(PMHSocialHistoryInputController pMHSocialHistoryInputController) {
		this.pMHSocialHistoryInputController = pMHSocialHistoryInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHSocialHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\nSOCIAL HISTORY: ");
			pMHSocialHistoryInputController.str = pmhSocialHitoryStr.toString();

			if(familyActiitiesRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient spends leisure time in family activities. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}

			if(onComputerRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time on the computer. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}if(watchingRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append("Patient spends leisure time watching TV. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}
          if(watchingRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time visiting friends. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}
          if(InNoSpecificRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time in no specific activities. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}
          if(PlayingsportsRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time in playing sports. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			} if(ListeningToradioRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time in listening to music. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			}
          if(TraelingRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time  in travelling. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
			} if(ReadingRadio.isSelected()){
				
				StringBuilder pmhSocialHitoryStr1 = new StringBuilder(pMHSocialHistoryInputController.str);
				pmhSocialHitoryStr1.append(" Patient spends leisure time reading. ");
				pMHSocialHistoryInputController.str = pmhSocialHitoryStr1.toString();
	
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
