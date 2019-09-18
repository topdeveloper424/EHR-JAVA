package com.ets.controller.gui.medicationClass;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.model.MedicationClass;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MedicationClassInputController implements Initializable {


	   @FXML
	    private TextField medicationClassText;

	    @FXML
	    private Button okButton;

	    @FXML
	    private Button cancelButton;

	FXMLFormPath formPath = new FXMLFormPath();
	private MedicationClassViewController medicationClassViewController;
	

	public void setMedicationClassViewController(MedicationClassViewController medicationClassViewController) {
		this.medicationClassViewController = medicationClassViewController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {
			try {
                MedicationClass medicationClass =new MedicationClass();
                medicationClass.setMedicalClass(medicationClassText.getText());
				
				
				new MedicationClassEntityController().addOrUpdate(medicationClass);
			/*	formPath.closeApplicationContext();
				medicationClassViewController.viewMedicationClass();
				new FXFormCommonUtilities().closeForm(okButton);*/
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});


		// Centralised Form cancel
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
