package com.ets.controller.gui.incidentOrEvent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventTypeInputController.fxml Class
 *Description: Enter.fxml Controller class
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
import com.ets.controller.entity.incidentOrEvent.IncidentOrEventEntityController;
import com.ets.model.IncidentOrEvent;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class IncidentOrEventTypeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField eventTypeTextField;

	@FXML
	private TextField descriptionTextField;	
	
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
		// Insert Illness Code

		IncidentOrEvent orEvent = new IncidentOrEvent();
		orEvent.setEventType(this.eventTypeTextField.getText());
		orEvent.setDescrp(this.descriptionTextField.getText());
		orEvent.setInactive(this.inactiveCheckBox.isSelected());

		new IncidentOrEventEntityController().saveIncidentorEvent(orEvent);
		incidentOrEventTypeViewController.populateIncidentOrEventTable(new IncidentOrEventEntityController().viewIncidentOrEvent());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private IncidentOrEventTypeViewController incidentOrEventTypeViewController;

	public void setIncidentOrEventTypeViewController(
			IncidentOrEventTypeViewController incidentOrEventTypeViewController) {
		this.incidentOrEventTypeViewController = incidentOrEventTypeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert Illness Code

			IncidentOrEvent orEvent = new IncidentOrEvent();
			orEvent.setEventType(this.eventTypeTextField.getText());
			orEvent.setDescrp(this.descriptionTextField.getText());
			orEvent.setInactive(this.inactiveCheckBox.isSelected());

			new IncidentOrEventEntityController().saveIncidentorEvent(orEvent);
			incidentOrEventTypeViewController
					.populateIncidentOrEventTable(new IncidentOrEventEntityController().viewIncidentOrEvent());
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
