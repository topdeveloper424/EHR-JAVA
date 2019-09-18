package com.ets.controller.gui.emrCharting.procedure.removal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.procedure.MedicalProcedureInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SutureRemovalUCInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField numberText;

    @FXML
    private Label AnesthasiaModalitytText;

    @FXML
    private RadioButton handRadio;

    @FXML
    private ToggleGroup body;

    @FXML
    private RadioButton faceRadio;

    @FXML
    private CheckBox gauzeCheckBox;

    @FXML
    private CheckBox steriStripCheckBox;

    @FXML
    private CheckBox bandAidCeckBox;

    @FXML
    private CheckBox wellCheckBox;

    @FXML
    private CheckBox WiyhoutCompletionCheckBox;

    @FXML
    private CheckBox minaralCheckBox;

    @FXML
    private CheckBox withCompletionCheckBox;

    @FXML
    private RadioButton neckRadio;

    @FXML
    private RadioButton upperRadio;

    @FXML
    private RadioButton lowerRadio;

    @FXML
    private RadioButton backRadio;

    @FXML
    private RadioButton buttoksRadio;

    @FXML
    private RadioButton sclapRadio;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n\nWe conducted suture removal. Applicable diagnosis: To be determined.  ");
			medicalProcedureInputController.str = procedureStr.toString();

			

			if (handRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: hand. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (faceRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: face. ");
				medicalProcedureInputController.str = str1.toString();

			}if (neckRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: neck. ");
				medicalProcedureInputController.str = str1.toString();

			}if (upperRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: upper extremity. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (lowerRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: lower extremity. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (backRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: back. ");
				medicalProcedureInputController.str = str1.toString();

			}if (buttoksRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: buttocks. ");
				medicalProcedureInputController.str = str1.toString();

			}if (sclapRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The procedure was performed on: hand. ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			if (wellCheckBox.isSelected() || WiyhoutCompletionCheckBox.isSelected()
						|| withCompletionCheckBox.isSelected() || minaralCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient tolerated the procedure ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (WiyhoutCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (withCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complications (see notes below) ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (minaralCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("minimal blood loss ");
					medicalProcedureInputController.str = str1.toString();
					
				}
				
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". Instructions were provided to the patient as documented elsewhere. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (numberText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Number of sutures/staples removed: " +numberText.getText() +". ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (steriStripCheckBox.isSelected() || gauzeCheckBox.isSelected()
					|| bandAidCeckBox.isSelected()) {

			StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
			str.append("A ");
			medicalProcedureInputController.str = str.toString();
			
			if (steriStripCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("teri-strip, ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (gauzeCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Gauze ");
				medicalProcedureInputController.str = str1.toString();

			}if (bandAidCeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Band-Aid");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
			str1.append("was used to cover the wound. ");
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
