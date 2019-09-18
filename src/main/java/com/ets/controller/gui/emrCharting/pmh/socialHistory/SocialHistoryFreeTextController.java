package com.ets.controller.gui.emrCharting.pmh.socialHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SocialHistoryFreeTextController implements Initializable {
	
	@FXML
    private TextField summaryText;

    @FXML
    private TextArea additinalText;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;
    
    private PMHSocialHistoryInputController pMHSocialHistoryInputController;
  

	public void setpMHSocialHistoryInputController(PMHSocialHistoryInputController pMHSocialHistoryInputController) {
		this.pMHSocialHistoryInputController = pMHSocialHistoryInputController;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		   summaryText.setText(pMHSocialHistoryInputController.strForFreeText);
			
			
			doneBtn.setOnAction((event) -> {

				
				
			
				
				if(additinalText.getText().length() > 0 || summaryText.getText().length() > 0){
					
					pMHSocialHistoryInputController.genericEMRChartingController.setPmhTextArea("\n"+summaryText.getText()+"\n"+additinalText.getText());
					pMHSocialHistoryInputController.genericEMRChartingController.saveAllTextArea();
					pMHSocialHistoryInputController.strForFreeText = "";
				
				}
				
			
				
			
			
				new FXFormCommonUtilities().closeForm(doneBtn);

			});
			
			skipBtn.setOnAction((event) -> {

				new FXFormCommonUtilities().closeForm(skipBtn);

			});
			
		}

	}
