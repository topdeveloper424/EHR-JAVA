package com.ets.controller.gui.bodypart;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyPartGUIController Class
 *Description: EnterBodyPartCode.fxml Controller class
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
import com.ets.utils.FXMLFormPath;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class BodyPartInputController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField bodyPartTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField wcioCodeTextField;
	
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		// Cancel centralized Form
		try {
			new FXFormCommonUtilities().closeForm(cancelButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		// Insert Data into Table

		BodyPart part = new BodyPart();
		part.setPart(this.bodyPartTextField.getText());
		part.setDescrp(this.descriptionTextField.getText());
		part.setWc10Code(this.wcioCodeTextField.getText());
		part.setInactive(this.inactiveCheckBox.isSelected());

		new BodyPartEntityController().saveBodyPart(part);
		bodyPartViewController.populateBodyPartTable(new BodyPartEntityController().viewBodyParts());
		try {
			new FXFormCommonUtilities().closeForm(okButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

	private BodyPartViewController bodyPartViewController;

	public void setBodyPartViewController(BodyPartViewController bodyPartViewController) {
		this.bodyPartViewController = bodyPartViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {

			// Insert Data into Table

			BodyPart part = new BodyPart();

			part.setPart(this.bodyPartTextField.getText());
			part.setDescrp(this.descriptionTextField.getText());
			part.setWc10Code(this.wcioCodeTextField.getText());
			part.setInactive(this.inactiveCheckBox.isSelected());

			new BodyPartEntityController().saveBodyPart(part);
			bodyPartViewController.populateBodyPartTable(new BodyPartEntityController().viewBodyParts());
			try {
				new FXFormCommonUtilities().closeForm(okButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {

			// Cancel centralized Form
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
