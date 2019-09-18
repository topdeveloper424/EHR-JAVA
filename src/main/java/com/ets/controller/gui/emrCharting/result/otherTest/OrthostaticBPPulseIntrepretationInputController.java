package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrthostaticBPPulseIntrepretationInputController implements Initializable {
	
	
	 @FXML
	    private CheckBox normalChexk;

	    @FXML
	    private Button okbtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox abnormalChexk;
	
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		okbtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			

			if (abnormalChexk.isSelected() || normalChexk.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("Orthostatic BP/Pulse Interpretation: ");
				resultInputController.str = str.toString();
				
				if (abnormalChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("abnormal,");
					resultInputController.str = str1.toString();
					
				}if (normalChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("normal");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(okbtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
