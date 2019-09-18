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
 * Definition: Type object of DivisionEditController Class Description:
 * Edit.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */
public class DivisionEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

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
			 try {
					new FXFormCommonUtilities().closeForm(cancelButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    }
	
	 }

	    @FXML
	    void enterKeyPressedForUpdateButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 Address address = new Address();

	 			address.setEmail(this.emailTextField.getText());
	 			address.setExt(this.extensionTextField.getText());
	 			address.setFax(this.faxTextField.getText());
	 			address.setPhone(this.telephoneTextField.getText());

	 			new AddressEntityController().add(address);

	 			Division division = new Division();
	 			division.setId(Integer.parseInt(this.idTextField.getText()));
	 			division.setCode(this.codeTextField.getText());
	 			division.setDescrip(this.descriptionTextField.getText());
	 			division.setManager(this.managerTextField.getText());
	 			division.setCode(this.managerTextField.getText());
	 			division.setInactive(this.inactiveCheckBox.isSelected());

	 			new DivisionEntityController().updateDivision(division);
	 			divisionViewController.populateDivisionTable(new DivisionEntityController().viewDivision());
	 			try {
	 				new FXFormCommonUtilities().closeForm(updateButton);

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
	 	    }
	    }

	@FXML
	private TextField idTextField;

	private DivisionViewController divisionViewController;

	public void setDivisionViewController(DivisionViewController divisionViewController) {
		this.divisionViewController = divisionViewController;
	}

	private Division division;

	public void setDivision(Division division) {
		this.division = division;

		idTextField.setText(Integer.toString(division.getId()));
		codeTextField.setText(division.getCode());
		descriptionTextField.setText(division.getDescrip());
		emailTextField.setText(division.addressProperty().getValue().getEmail());
		extensionTextField.setText(division.addressProperty().getValue().getExt());
		faxTextField.setText(division.addressProperty().getValue().getFax());
		managerTextField.setText(division.getManager());
		telephoneTextField.setText(division.addressProperty().getValue().getPhone());

		if (division.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (division.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update Division Details

			Address address = new Address();

			address.setEmail(this.emailTextField.getText());
			address.setExt(this.extensionTextField.getText());
			address.setFax(this.faxTextField.getText());
			address.setPhone(this.telephoneTextField.getText());

			new AddressEntityController().add(address);

			Division division = new Division();
			division.setId(Integer.parseInt(this.idTextField.getText()));
			division.setCode(this.codeTextField.getText());
			division.setDescrip(this.descriptionTextField.getText());
			division.setManager(this.managerTextField.getText());
			division.setCode(this.managerTextField.getText());
			division.setInactive(this.inactiveCheckBox.isSelected());
            division.setAddress(address);
			new DivisionEntityController().updateDivision(division);
			divisionViewController.populateDivisionTable(new DivisionEntityController().viewDivision());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);

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
