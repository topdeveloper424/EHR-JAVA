package com.ets.controller.gui.division;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.model.Address;
import com.ets.model.Division;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 15-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DivisionInputController Class Description:
 * Enter.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class DivisionInputController implements Initializable {
	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField managerTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField extensionTextField;

	  @FXML
	    void enterKeyPressedForCancleButton(KeyEvent event) {
		  if(event.getCode() == KeyCode.ENTER){

				Address address = new Address();

				address.setEmail(this.emailTextField.getText());
				address.setExt(this.extensionTextField.getText());
				address.setFax(this.faxTextField.getText());
				address.setPhone(this.telephoneTextField.getText());

				new AddressEntityController().add(address);

				Division division = new Division();

				division.setCode(this.codeTextField.getText());
				division.setDescrip(this.descriptionTextField.getText());
				division.setManager(this.managerTextField.getText());
				division.setAddress(address);
				division.setInactive(this.inactiveCheckBox.isSelected());

				new DivisionEntityController().saveDivision(division);
				divisionViewController.populateDivisionTable(new DivisionEntityController().viewDivision());
				try {
					new FXFormCommonUtilities().closeForm(okButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
		  }
	    }

	    @FXML
	    void enterKeyPressedForOkButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {
	 				new FXFormCommonUtilities().closeForm(cancelButton);

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
			  }
	    }
	
	private DivisionViewController divisionViewController;
	

	public void setDivisionViewController(DivisionViewController divisionViewController) {
		this.divisionViewController = divisionViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert Data into Table

			Address address = new Address();

			address.setEmail(this.emailTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			address.setPhone(this.telephoneTextField.getText());

			new AddressEntityController().add(address);

			Division division = new Division();

			division.setCode(this.codeTextField.getText());
			division.setDescrip(this.descriptionTextField.getText());
			division.setManager(this.managerTextField.getText());
			division.setAddress(address);
			division.setInactive(this.inactiveCheckBox.isSelected());

			new DivisionEntityController().saveDivision(division);
			divisionViewController.populateDivisionTable(new DivisionEntityController().viewDivision());
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
