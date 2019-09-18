package com.ets.controller.gui.medicationClass;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.model.MedicationClass;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MedicationClassEditController implements Initializable {
	
	  @FXML
	    private TextField medicationClassText;

	    @FXML
	    private Button okButton;

	    @FXML
	    private Button cancelButton;
	    
	    private MedicationClassViewController medicationClassViewController;
	    
	    public void setMedicationClassViewController(MedicationClassViewController medicationClassViewController) {
			this.medicationClassViewController = medicationClassViewController;
		}

		private MedicationClass medicationClass;

	    public void setMedicationClass(MedicationClass medicationClass) {
			this.medicationClass = medicationClass;
			
			
			medicationClassText.setText(medicationClass.getMedicalClass());
			
			
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		okButton.setOnAction((event) -> {
			
			
			medicationClass.setMedicalClass(medicationClassText.getText());
			
			new MedicationClassEntityController().addOrUpdate(medicationClass);
			medicationClassViewController.viewMedicationClass();

			
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {
			
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
