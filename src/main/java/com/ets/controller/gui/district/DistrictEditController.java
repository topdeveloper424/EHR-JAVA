package com.ets.controller.gui.district;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditDistrictGUIController Class
 *Description: EditDistrict GUI Controller class
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

import com.ets.controller.entity.district.DistrictEntityController;
import com.ets.model.District;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DistrictEditController implements Initializable {

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
            	  District district = new District();

      			district.setId(Integer.parseInt(this.idTextField.getText()));
      			district.setCode(this.codeTextField.getText());
      			district.setName(this.nameTextField.getText());
      			district.setInactive(this.inactiveCheckBox.isSelected());

      			new DistrictEntityController().updateDistrict(district);
      			districtViewController.populateDistrictTable(new DistrictEntityController().viewDistrict());
      			try {
      				new FXFormCommonUtilities().closeForm(updateButton);

      			} catch (Exception ex) {
      				ex.printStackTrace();
      			}
    		 
    	 }

    }


	private DistrictViewController districtViewController;

	public void setDistrictViewController(DistrictViewController districtViewController) {
		this.districtViewController = districtViewController;
	}

	private District district; // District Entity variable

	public void setDistrict(District district) {
		this.district = district;

		idTextField.setText(Integer.toString(district.getId()));
		codeTextField.setText(district.getCode());
		nameTextField.setText(district.getName());

		if (district.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (district.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update District Details

			District district = new District();

			district.setId(Integer.parseInt(this.idTextField.getText()));
			district.setCode(this.codeTextField.getText());
			district.setName(this.nameTextField.getText());
			district.setInactive(this.inactiveCheckBox.isSelected());

			new DistrictEntityController().updateDistrict(district);
			districtViewController.populateDistrictTable(new DistrictEntityController().viewDistrict());
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
