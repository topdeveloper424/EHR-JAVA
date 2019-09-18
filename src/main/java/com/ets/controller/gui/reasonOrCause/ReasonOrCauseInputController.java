package com.ets.controller.gui.reasonOrCause;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReasonOrCauseGUIController Class
 *Description: EnterReasonOrCause.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.ResourceBundle;





import com.ets.controller.entity.reasonOrCause.ReasonOrCauseEntityController;
import com.ets.model.ReasonOrCause;
import com.ets.utils.FXFormCommonUtilities;





import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ReasonOrCauseInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField reasonCauseTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioTextField;	
	
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Centralised Form cancel
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert ReasonOrCause Details
		ReasonOrCause reasonOrCause = new ReasonOrCause();

		reasonOrCause.setReasonCause(this.reasonCauseTextField.getText());
		reasonOrCause.setDescrp(this.descriptionTextField.getText());
		reasonOrCause.setWc10Code(this.wcioTextField.getText());
		reasonOrCause.setInactive(this.inactiveCheckBox.isSelected());

		new ReasonOrCauseEntityController().saveReasonOrCause(reasonOrCause);
		reaonOrCausesViewController.populateReasonOrCauseTable(new ReasonOrCauseEntityController().viewReasonOrCause());
		try {
			new FXFormCommonUtilities().closeForm(okButton);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private ReasonOrCauseViewController reaonOrCausesViewController;

	public void setReaonOrCausesViewController(ReasonOrCauseViewController reaonOrCausesViewController) {
		this.reaonOrCausesViewController = reaonOrCausesViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert ReasonOrCause Details
			ReasonOrCause reasonOrCause = new ReasonOrCause();

			reasonOrCause.setReasonCause(this.reasonCauseTextField.getText());
			reasonOrCause.setDescrp(this.descriptionTextField.getText());
			reasonOrCause.setWc10Code(this.wcioTextField.getText());
			reasonOrCause.setInactive(this.inactiveCheckBox.isSelected());

			new ReasonOrCauseEntityController().saveReasonOrCause(reasonOrCause);
			reaonOrCausesViewController
					.populateReasonOrCauseTable(new ReasonOrCauseEntityController().viewReasonOrCause());
			try {
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {
			// Centralised Form cancel

			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
