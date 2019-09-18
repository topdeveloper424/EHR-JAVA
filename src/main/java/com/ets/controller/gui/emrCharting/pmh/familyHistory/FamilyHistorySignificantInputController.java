package com.ets.controller.gui.emrCharting.pmh.familyHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class FamilyHistorySignificantInputController implements Initializable {
	
	  	@FXML
	    private CheckBox deniesCheck;

	    @FXML
	    private CheckBox unknownCheck;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	    
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

			if(deniesCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Patient denies significant family health history. ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
			}
			
			if(unknownCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Patient is unaware of significant family health history. ");
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
