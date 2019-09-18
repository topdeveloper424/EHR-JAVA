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

public class EarWrickPlacementInputController implements Initializable {
	
	@FXML
    private TextArea complecationTextarea;

    @FXML
    private CheckBox normalCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox rightCheck;

    @FXML
    private CheckBox leftCheck;

    @FXML
    private CheckBox bothCheck;
    
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
			
			
			if (rightCheck.isSelected() || leftCheck.isSelected()
					 || bothCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Ear Wick was placed in: ");
				medicalProcedureInputController.str = str.toString();
				
				if (rightCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" right canal,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (leftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" left canal,");
					medicalProcedureInputController.str = str1.toString();

				}if (bothCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" both canal,");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (normalCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("");
				medicalProcedureInputController.str = str1.toString();

			}else{
				
				if (complecationTextarea.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(complecationTextarea.getText() +".");
					medicalProcedureInputController.str = str1.toString();

				}
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
