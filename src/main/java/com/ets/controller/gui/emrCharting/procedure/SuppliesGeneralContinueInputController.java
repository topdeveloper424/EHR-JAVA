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

public class SuppliesGeneralContinueInputController implements Initializable {
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox woundCleanerCheck;

	    @FXML
	    private CheckBox steri12Check;

	    @FXML
	    private CheckBox steri14Check;

	    @FXML
	    private CheckBox bandage5Check;

	    @FXML
	    private CheckBox TubularCheck;
	    
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

			

			
			if (woundCleanerCheck.isSelected() || steri12Check.isSelected()
					|| steri14Check.isSelected() || bandage5Check.isSelected()
					|| TubularCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Supplies Used: ");
				medicalProcedureInputController.str = str.toString();
				
				if (woundCleanerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Wound Cleaner,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (steri12Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Steri-strips, 1/2\" ,");
					medicalProcedureInputController.str = str1.toString();

				}if (steri14Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Ster-strips 1/4\",");
					medicalProcedureInputController.str = str1.toString();

				}if (bandage5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Ace Bandage 5\",");
					medicalProcedureInputController.str = str1.toString();

				}if (TubularCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Greater and Tubular Gauze");
					medicalProcedureInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
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
