package com.ets.controller.gui.incidentOrEvent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrEventTypeEditController.fxml Class
 *Description: Edit.fxml Controller class
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

public class IncidentOrEventTypeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField eventTypeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField idTextField;
	
	
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
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		// Update IllnessCode Details

		IncidentOrEvent incidentOrEvent = new IncidentOrEvent();
		incidentOrEvent.setId(Integer.parseInt(this.idTextField.getText()));
		incidentOrEvent.setEventType(this.eventTypeTextField.getText());
		incidentOrEvent.setDescrp(this.descriptionTextField.getText());
		incidentOrEvent.setInactive(this.inactiveCheckBox.isSelected());

		new IncidentOrEventEntityController().modifyIncidentOrEvent(incidentOrEvent);
		incidentOrEventTypeViewController.populateIncidentOrEventTable(new IncidentOrEventEntityController().viewIncidentOrEvent());
		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private IncidentOrEventTypeViewController incidentOrEventTypeViewController;

	public void setIncidentOrEventTypeViewController(
			IncidentOrEventTypeViewController incidentOrEventTypeViewController) {
		this.incidentOrEventTypeViewController = incidentOrEventTypeViewController;
	}

	private IncidentOrEvent IncidentOrEvent; // IncidentOrEvent Entity variable

	public void setIncidentOrEvent(IncidentOrEvent incidentOrEvent) {
		IncidentOrEvent = incidentOrEvent;

		idTextField.setText(Integer.toString(incidentOrEvent.getId()));
		eventTypeTextField.setText(incidentOrEvent.getEventType());
		descriptionTextField.setText(incidentOrEvent.getDescrp());

		if (incidentOrEvent.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (incidentOrEvent.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			// Update IllnessCode Details

			IncidentOrEvent incidentOrEvent = new IncidentOrEvent();

			incidentOrEvent.setId(Integer.parseInt(this.idTextField.getText()));
			incidentOrEvent.setEventType(this.eventTypeTextField.getText());
			incidentOrEvent.setDescrp(this.descriptionTextField.getText());
			incidentOrEvent.setInactive(this.inactiveCheckBox.isSelected());

			new IncidentOrEventEntityController().modifyIncidentOrEvent(incidentOrEvent);
			incidentOrEventTypeViewController
					.populateIncidentOrEventTable(new IncidentOrEventEntityController().viewIncidentOrEvent());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

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
