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

public class PatientObservationInputController implements Initializable {
	
	@FXML
    private TextArea AnoscopyTextsrea;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(medicalProcedureInputController.str);
			skelComp.append("\n\n");
			medicalProcedureInputController.str = skelComp.toString();
			
			if (AnoscopyTextsrea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient Was Observed, Without Complications, S/P: "+AnoscopyTextsrea.getText()+".");
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
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
