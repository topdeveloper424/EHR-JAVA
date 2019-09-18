package com.ets.controller.gui.emrCharting.pmh.workHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHWorkHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WorkHistoryFreeTextController implements Initializable{
	
	@FXML
    private TextField summaryText;

    @FXML
    private TextArea additinalText;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;


    private PMHWorkHistoryInputController pMHWorkHistoryInputController;
 
	public PMHWorkHistoryInputController getpMHWorkHistoryInputController() {
		return pMHWorkHistoryInputController;
	}

	public void setpMHWorkHistoryInputController(PMHWorkHistoryInputController pMHWorkHistoryInputController) {
		this.pMHWorkHistoryInputController = pMHWorkHistoryInputController;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		   summaryText.setText(pMHWorkHistoryInputController.strForFreeText);
			
			
			doneBtn.setOnAction((event) -> {

				
				
			
				
				if(additinalText.getText().length() > 0 || summaryText.getText().length() > 0){
					
					pMHWorkHistoryInputController.genericEMRChartingController.setPmhTextArea("\n"+summaryText.getText()+"\n"+additinalText.getText());
					pMHWorkHistoryInputController.genericEMRChartingController.saveAllTextArea();
					pMHWorkHistoryInputController.strForFreeText = "";
				
				}
				
			
				
			
			
				new FXFormCommonUtilities().closeForm(doneBtn);

			});
			
			skipBtn.setOnAction((event) -> {

				new FXFormCommonUtilities().closeForm(skipBtn);

			});
			
		}

	}
