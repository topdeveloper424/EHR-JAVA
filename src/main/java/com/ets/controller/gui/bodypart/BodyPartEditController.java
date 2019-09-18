package com.ets.controller.gui.bodypart;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 25-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditBodyPartGUIController Class
 *Description: EditBodyPartCodes.fxml Controller class
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

import com.ets.controller.entity.bodypart.BodyPartEntityController;
import com.ets.model.BodyPart;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class BodyPartEditController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField bodyPartTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioCodeTextField;

	@FXML
	private TextField idTextField;
		
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForUpdateButton(KeyEvent event) {
		BodyPart part = new BodyPart();
		part.setId(Integer.parseInt(this.idTextField.getText()));
		part.setPart(this.bodyPartTextField.getText());
		part.setDescrp(this.descriptionTextField.getText());
		part.setWc10Code(this.wcioCodeTextField.getText());
		part.setInactive(this.inactiveCheckBox.isSelected());

		new BodyPartEntityController().modifyBodyPart(part);
		bodyPartViewController.populateBodyPartTable(new BodyPartEntityController().viewBodyParts());

		try {
			new FXFormCommonUtilities().closeForm(updateButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private BodyPart bodyPart;

	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;

		idTextField.setText(Integer.toString(bodyPart.getId()));
		bodyPartTextField.setText(bodyPart.getPart());
		descriptionTextField.setText(bodyPart.getDescrp());
		wcioCodeTextField.setText(bodyPart.getWc10Code());

		if (bodyPart.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (bodyPart.getInactive() == false) {
			inactiveCheckBox.setSelected(false);
		}

	}

	private BodyPartViewController bodyPartViewController;

	public void setBodyPartViewController(BodyPartViewController bodyPartViewController) {
		this.bodyPartViewController = bodyPartViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			BodyPart part = new BodyPart();

			part.setId(Integer.parseInt(this.idTextField.getText()));
			part.setPart(this.bodyPartTextField.getText());
			part.setDescrp(this.descriptionTextField.getText());
			part.setWc10Code(this.wcioCodeTextField.getText());
			part.setInactive(this.inactiveCheckBox.isSelected());

			new BodyPartEntityController().modifyBodyPart(part);
			bodyPartViewController.populateBodyPartTable(new BodyPartEntityController().viewBodyParts());

			try {
				new FXFormCommonUtilities().closeForm(updateButton);
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
