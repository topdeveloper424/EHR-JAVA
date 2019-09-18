package com.ets.controller.gui.complex;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ComplexGUIController Class
 *Description: EnterComlex.fxml Controller class
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

import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.model.Complex;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ComplexInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;
	
	

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	private ComplexViewController complexViewController;
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
	    void enterKeyPressedForOkButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 Complex complex = new Complex();
	 			complex.setCode(this.codeTextField.getText());
	 			complex.setName(this.nameTextField.getText());
	 			complex.setInactive(this.inactiveCheckBox.isSelected());

	 			new ComplexEntityController().saveComplex(complex);
	 			complexViewController.populateComplexTable(new ComplexEntityController().viewComplex());
	 			try {
	 				new FXFormCommonUtilities().closeForm(okButton);

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
 
			 }
	    }


	public void setComplexViewController(ComplexViewController complexViewController) {
		this.complexViewController = complexViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert Data into Table

			Complex complex = new Complex();
			complex.setCode(this.codeTextField.getText());
			complex.setName(this.nameTextField.getText());
			complex.setInactive(this.inactiveCheckBox.isSelected());

			new ComplexEntityController().saveComplex(complex);
			complexViewController.populateComplexTable(new ComplexEntityController().viewComplex());
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
