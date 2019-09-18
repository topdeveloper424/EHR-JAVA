package com.ets.controller.gui.complex;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditComplexGUIController Class
 *Description: EditComplex GUI Controller class
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

public class ComplexEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField idTextField;
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
    		Complex complex = new Complex();

			complex.setId(Integer.parseInt(this.idTextField.getText()));
			complex.setCode(this.codeTextField.getText());
			complex.setName(this.nameTextField.getText());
			complex.setInactive(this.inactiveCheckBox.isSelected());

			new ComplexEntityController().updateComplex(complex);

			complexViewController.populateComplexTable(new ComplexEntityController().viewComplex());

			try {
				new FXFormCommonUtilities().closeForm(updateButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		 }

    }

	private Complex complex; // Complex Entity variable

	public void setComplex(Complex complex) {
		this.complex = complex;

		idTextField.setText(Integer.toString(complex.getId()));
		codeTextField.setText(complex.getCode());
		nameTextField.setText(complex.getName());

		if (complex.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (complex.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	private ComplexViewController complexViewController;

	public void setComplexViewController(ComplexViewController complexViewController) {
		this.complexViewController = complexViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update Complex Details

			Complex complex = new Complex();

			complex.setId(Integer.parseInt(this.idTextField.getText()));
			complex.setCode(this.codeTextField.getText());
			complex.setName(this.nameTextField.getText());
			complex.setInactive(this.inactiveCheckBox.isSelected());

			new ComplexEntityController().updateComplex(complex);

			complexViewController.populateComplexTable(new ComplexEntityController().viewComplex());

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
