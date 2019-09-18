package com.ets.controller.gui.region;

/*
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditRegionGUIController Class
 *Description: EditRegion GUI Controller class
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

import com.ets.controller.entity.region.RegionEntityController;
import com.ets.model.Region;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RegionEditController implements Initializable {

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

	 			Region region = new Region();

	 			region.setId(Integer.parseInt(this.idTextField.getText()));
	 			region.setCode(this.codeTextField.getText());
	 			region.setName(this.nameTextField.getText());
	 			region.setInactive(this.inactiveCheckBox.isSelected());

	 			new RegionEntityController().updateRegion(region);
	 			regionViewController.populateRegionTable(new RegionEntityController().viewRegion());
	 			try {
	 				new FXFormCommonUtilities().closeForm(updateButton);

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
			 }
	    }

	private RegionViewController regionViewController;

	public void setRegionViewController(RegionViewController regionViewController) {
		this.regionViewController = regionViewController;
	}

	private Region region; // Region Entity variable

	public void setRegion(Region region) {
		this.region = region;

		idTextField.setText(Integer.toString(region.getId()));
		codeTextField.setText(region.getCode());
		nameTextField.setText(region.getName());

		if (region.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (region.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			// Update Region Details

			Region region = new Region();

			region.setId(Integer.parseInt(this.idTextField.getText()));
			region.setCode(this.codeTextField.getText());
			region.setName(this.nameTextField.getText());
			region.setInactive(this.inactiveCheckBox.isSelected());

			new RegionEntityController().updateRegion(region);
			regionViewController.populateRegionTable(new RegionEntityController().viewRegion());
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
