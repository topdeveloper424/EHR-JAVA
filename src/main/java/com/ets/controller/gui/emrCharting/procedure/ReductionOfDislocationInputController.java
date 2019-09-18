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

public class ReductionOfDislocationInputController implements Initializable {
	
	 @FXML
	    private TextArea analgesiaTextarea;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox wellCheck;

	    @FXML
	    private CheckBox withoutCheck;

	    @FXML
	    private CheckBox withCheck;

	    @FXML
	    private RadioButton leftRadio;

	    @FXML
	    private ToggleGroup body;

	    @FXML
	    private RadioButton rightRadio;

	    @FXML
	    private TextArea typeTextarea;

	    @FXML
	    private TextArea partTextarea;
	    
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
			
			if (analgesiaTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was pre-sedated with "+analgesiaTextarea.getText()+".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (typeTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("A "+typeTextarea.getText() +"reduction was performed on on the ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("left ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("right ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (partTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(partTextarea.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			

			if (wellCheck.isSelected() || withCheck.isSelected()
					|| withoutCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Procedure was tolerated ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (withCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complications (specify), ");
					medicalProcedureInputController.str = str1.toString();

				}if (withoutCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications, ");
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
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
