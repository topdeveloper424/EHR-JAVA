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

public class EarIrrigationInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox waxRemovedCheck;

    @FXML
    private CheckBox driedBloodCheck;

    @FXML
    private CheckBox waxNotRemoved;

    @FXML
    private CheckBox cerumenexCheck;

    @FXML
    private CheckBox reirrigationCheck;

    @FXML
    private CheckBox tooTenderCheck;

    @FXML
    private CheckBox earLoopCheck;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n ");
			medicalProcedureInputController.str = procedureStr.toString();

			
			if (waxRemovedCheck.isSelected() || waxNotRemoved.isSelected() || reirrigationCheck.isSelected()
					||earLoopCheck.isSelected()||driedBloodCheck.isSelected()||cerumenexCheck.isSelected()||
					tooTenderCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Ear irrigation was performed to remove wax / debris from affected ear(s); ");
				medicalProcedureInputController.str = str.toString();

				if (waxRemovedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" wax removed easily, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (waxNotRemoved.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" wax could not be removed, ");
					medicalProcedureInputController.str = str1.toString();

				}if (driedBloodCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" dried blood removed , ");
					medicalProcedureInputController.str = str1.toString();

				}if (earLoopCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("  ear loop needed, ");
					medicalProcedureInputController.str = str1.toString();

				}if (cerumenexCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("  cerumenex/debrox applied, ");
					medicalProcedureInputController.str = str1.toString();

				}if (tooTenderCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" too tender - to tolerate , ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (reirrigationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("re irrigation will be needed ");
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
