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

public class SuppliesGeneralInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox bandage23Check;

	    @FXML
	    private CheckBox bandage34Check;

	    @FXML
	    private CheckBox AdapticGauzeCheck;

	    @FXML
	    private CheckBox CastSuppliesCheck;

	    @FXML
	    private CheckBox DressingCheck;

	    @FXML
	    private CheckBox gauzeCheck;

	    @FXML
	    private CheckBox irrigationCheck;

	    @FXML
	    private CheckBox oxygenMaskCheck;

	    @FXML
	    private CheckBox oxygenMouthCheck;

	    @FXML
	    private CheckBox oxygenTubingCheck;

	    @FXML
	    private CheckBox SelfAdhesiveCheck;

	    @FXML
	    private CheckBox nasalCheck;
	    
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

			

			if (gauzeCheck.isSelected() || DressingCheck.isSelected()
					|| irrigationCheck.isSelected() || oxygenMaskCheck.isSelected()
					|| CastSuppliesCheck.isSelected()
					||nasalCheck.isSelected()||oxygenMaskCheck.isSelected()
				||oxygenMouthCheck.isSelected()||oxygenTubingCheck.isSelected()||bandage23Check.isSelected()
				||bandage34Check.isSelected()||DressingCheck.isSelected()||SelfAdhesiveCheck.isSelected())
			 {
				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Supplies Use: ");
				medicalProcedureInputController.str = str.toString();
				
				if (gauzeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Gauze 4 x 4,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (DressingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Dressing - Non Adhesive, ");
					medicalProcedureInputController.str = str1.toString();

				}if (irrigationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Irrigation Tray all Purpose, ");
					medicalProcedureInputController.str = str1.toString();

				}if (oxygenMaskCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Oxygen Mask,");
					medicalProcedureInputController.str = str1.toString();

				}if (CastSuppliesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Cast Supplies, ");
					medicalProcedureInputController.str = str1.toString();

				}if (nasalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Nasal Cannula, ");
					medicalProcedureInputController.str = str1.toString();

				}if (oxygenMaskCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Oxygen Mask, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (oxygenMouthCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Oxygen Mouth Piece, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (oxygenTubingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" OxygenTubing,");
					medicalProcedureInputController.str = str1.toString();

				}if (SelfAdhesiveCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Self Adhesive Bandage.");
					medicalProcedureInputController.str = str1.toString();

				}if (bandage23Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Ace Bandage 2 x 3, ");
					medicalProcedureInputController.str = str1.toString();

				}if (bandage34Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Ace Bandage 3 x 4, ");
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