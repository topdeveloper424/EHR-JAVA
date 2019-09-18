package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class NasalTemponadeInputController implements Initializable {
	
	  @FXML
	    private CheckBox rhinoCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox packingCheck;

	    @FXML
	    private CheckBox guazeCheck;

	    @FXML
	    private CheckBox salineCheck;

	    @FXML
	    private RadioButton leftRadio;

	    @FXML
	    private ToggleGroup were;

	    @FXML
	    private RadioButton rightRadio;
	    
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

			
			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Following Nostril(S) Were Packed: Left ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Following Nostril(S) Were Packed: Right ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (packingCheck.isSelected() || salineCheck.isSelected()
					|| guazeCheck.isSelected() || rhinoCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Packing Supplies Used: ");
				medicalProcedureInputController.str = str.toString();
				
				if (packingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Packing Supplies");
					medicalProcedureInputController.str = str1.toString();
					
				}if (salineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("saline");
					medicalProcedureInputController.str = str1.toString();

				}if (guazeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Gauze Pads  ");
					medicalProcedureInputController.str = str1.toString();

				}if (rhinoCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("RhinoRocket");
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