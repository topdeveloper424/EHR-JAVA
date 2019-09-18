package com.ets.controller.gui.emrCharting.pmh.workHistory;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 24-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RetiredInputController Class
 *Description: retired.fxml GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHWorkHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RetiredInputController implements Initializable {
	
	@FXML
    private TextField howLongText;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;
    
    private PMHWorkHistoryInputController pMHWorkHistoryInputController;

    public void setpMHWorkHistoryInputController(PMHWorkHistoryInputController pMHWorkHistoryInputController) {
		this.pMHWorkHistoryInputController = pMHWorkHistoryInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhAllergyStr = new StringBuilder(pMHWorkHistoryInputController.str);
			pmhAllergyStr.append("\n\n ");
			pMHWorkHistoryInputController.str = pmhAllergyStr.toString();

			if(howLongText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHWorkHistoryInputController.str);
				str11.append("Patient has been retired " +howLongText.getText() +" years." );
				pMHWorkHistoryInputController.str = str11.toString();
				
			}

			

			++pMHWorkHistoryInputController.formCount;
			pMHWorkHistoryInputController.setWorkHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		

		skipBtn.setOnAction((event) -> {
			try {
				++pMHWorkHistoryInputController.formCount;
				pMHWorkHistoryInputController.setWorkHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
