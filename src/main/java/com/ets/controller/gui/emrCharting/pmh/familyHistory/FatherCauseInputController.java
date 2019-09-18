package com.ets.controller.gui.emrCharting.pmh.familyHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FatherCauseInputController implements Initializable {
	
	@FXML
    private RadioButton cadRadio;

    @FXML
    private ToggleGroup level;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton cvaRadio;

    @FXML
    private RadioButton SubstanceRadio;

    @FXML
    private RadioButton ColonCancerRadio;

    @FXML
    private RadioButton ProstateCancerRadio;

    @FXML
    private RadioButton sucideRadio;

    @FXML
    private RadioButton LungCancerRadio;

    @FXML
    private RadioButton diabetesRadio;

    @FXML
    private RadioButton traumaRadio;

    @FXML
    private TextField ageText;
    
    private PMHFamilyHistoryInputController pMHFamilyHistoryInputController;

    public void setpMHFamilyHistoryInputController(PMHFamilyHistoryInputController pMHFamilyHistoryInputController) {
		this.pMHFamilyHistoryInputController = pMHFamilyHistoryInputController;
	}
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHFamilyHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			pMHFamilyHistoryInputController.str = pmhSocialHitoryStr.toString();

			if(cvaRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from CVA ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
				
			}if(diabetesRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from diabetes ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
				
			}if(ProstateCancerRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from prostate cancer ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
				
			}if(sucideRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from sucide ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
						
			}if(cadRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from CAD");
				pMHFamilyHistoryInputController.str = str1.toString();
				
				
			}if(ColonCancerRadio.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from colon cancer ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
				
			}
			if (LungCancerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from lung cancer ");
				pMHFamilyHistoryInputController.str = str1.toString();

			}if (SubstanceRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from substance abuse ");
				pMHFamilyHistoryInputController.str = str1.toString();

			}if (traumaRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father died from trauma / accident ");
				pMHFamilyHistoryInputController.str = str1.toString();

			}
			
			
			
			if(ageText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("age " +ageText.getText() +". ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}

			

			++pMHFamilyHistoryInputController.formCount;
			pMHFamilyHistoryInputController.setFamilyHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		

		skipBtn.setOnAction((event) -> {
			try {
				++pMHFamilyHistoryInputController.formCount;
				pMHFamilyHistoryInputController.setFamilyHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
