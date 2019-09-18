package com.ets.controller.gui.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.workRestriction.WorkRestrictionEntityController;
import com.ets.model.WorkRestriction;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionEditController Class
 *Description: Edit.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

public class WorkRestrictionEditController implements Initializable {
	
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
    private TextField idTextField;
	
	private WorkRestriction workRestriction;
		
	public void setWorkRestriction(WorkRestriction workRestriction) {
		this.workRestriction = workRestriction;
		
		idTextField.setText(Integer.toString(workRestriction.getId()));
		codeTextField.setText(workRestriction.getCode());
		descriptionTextField.setText(workRestriction.getDescrp());
		
		if(workRestriction.getInactive() == true){
			
			inactiveCheckBox.setSelected(true);
			
		}else{
			
			inactiveCheckBox.setSelected(false);
		}
	}


	private WorkRestrictionViewController workRestrictionViewController;
	
	public void setWorkRestrictionViewController(WorkRestrictionViewController workRestrictionViewController) {
		this.workRestrictionViewController = workRestrictionViewController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		updateButton.setOnAction((event) -> {

			try {

				WorkRestriction workRestriction = new WorkRestriction();
				
				workRestriction.setId(Integer.parseInt(idTextField.getText()));
				workRestriction.setCode(codeTextField.getText());
				workRestriction.setDescrp(descriptionTextField.getText());
				workRestriction.setInactive(inactiveCheckBox.isSelected());

				new WorkRestrictionEntityController().update(workRestriction);
				workRestrictionViewController.refreshWorkRestriction();

				try {

					new FXFormCommonUtilities().closeForm(updateButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
