package com.ets.controller.gui.emrCharting.pmh.socialHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LeisureTimeHobbiesInputController Class
 *Description: leisureTimeHobbies.fxml GUI Controller class
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
public class LeisureTimeHobbiesInputController implements Initializable {
	  
	@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextArea freeFromTextArea;

	    @FXML
	    private TextArea moreInformationTextArea;
	    
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

		    if(freeFromTextArea.getText().length() > 0){
				
						StringBuilder str11 = new StringBuilder(pMHSocialHistoryInputController.str);
						str11.append(" SOCIAL HISTORY: Hobbies include " +freeFromTextArea.getText() +".");
						pMHSocialHistoryInputController.str = str11.toString();
						
					}
				

		    if(moreInformationTextArea.getText().length() > 0){
				
						StringBuilder str11 = new StringBuilder(pMHSocialHistoryInputController.str);
						str11.append(" " +moreInformationTextArea.getText() +".");
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
