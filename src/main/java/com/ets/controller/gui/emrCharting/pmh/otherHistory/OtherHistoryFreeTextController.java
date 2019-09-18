package com.ets.controller.gui.emrCharting.pmh.otherHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHOtherHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class OtherHistoryFreeTextController implements Initializable{
	
	 @FXML
	    private TextField summaryText;

	    @FXML
	    private TextArea additinalText;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    private PMHOtherHistoryInputController pMHOtherHistoryInputController;
	
		public void setpMHOtherHistoryInputController(PMHOtherHistoryInputController pMHOtherHistoryInputController) {
			this.pMHOtherHistoryInputController = pMHOtherHistoryInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		summaryText.setText(pMHOtherHistoryInputController.strForFreeText);
		
		
		doneBtn.setOnAction((event) -> {

			
			
		
			
			if(additinalText.getText().length() > 0 || summaryText.getText().length() > 0){
				
				pMHOtherHistoryInputController.genericEMRChartingController.setPmhTextArea("\n"+summaryText.getText()+"\n"+additinalText.getText());
				pMHOtherHistoryInputController.genericEMRChartingController.saveAllTextArea();
				pMHOtherHistoryInputController.strForFreeText = "";
			
			}
			
		
			
		
		
			new FXFormCommonUtilities().closeForm(doneBtn);

		});
		
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});
		
	}

}
