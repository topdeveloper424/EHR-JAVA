package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class OxygenInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton nasalRadio;

    @FXML
    private ToggleGroup were;

    @FXML
    private RadioButton maskRadio;

    @FXML
    private TextArea oxygenTextarea;

    @FXML
    private CheckBox normalCheck;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n\n ");
			medicalProcedureInputController.str = procedureStr.toString();

			

			if (normalCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("2L of O2 ");
				medicalProcedureInputController.str = str.toString();
				
				
				

			}else{
				
				
				if (oxygenTextarea.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(oxygenTextarea.getText() +"L of O2 ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				
			}
			
			
			
			
			if (nasalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("by Nasal Canula was administered.");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (maskRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("by Mask was administered.");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			

			++medicalProcedureInputController.formCount;
			medicalProcedureInputController.setMedUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++medicalProcedureInputController.formCount;
				medicalProcedureInputController.setMedUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}