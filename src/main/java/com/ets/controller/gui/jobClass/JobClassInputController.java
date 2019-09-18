package com.ets.controller.gui.jobClass;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 15-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of JobClassGUIController Class
 *Description: EnterJobClass.fxml Controller class
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

import com.ets.controller.entity.jobClass.JobClassEntityController;
import com.ets.model.JobClass;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class JobClassInputController implements Initializable {

	@FXML
    private TextField jobClassTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private CheckBox inactiveCheckBox;

    @FXML
	private Button okButton;

	@FXML
	private Button cancelButton;
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
	    		 try {
	 				JobClass jobClass = new JobClass();
	 				
	 				jobClass.setClassOfJob(jobClassTextField.getText());
	 				jobClass.setDescrp(descriptionTextField.getText());
	 				jobClass.setInactive(inactiveCheckBox.isSelected());
	 				
	 				new JobClassEntityController().saveOrUpdate(jobClass);
	 				
	 				jobClassViewController.viewJobClass();
	 				
	 				new FXFormCommonUtilities().closeForm(okButton);
	 				
	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
			  }

	    }

	
	private JobClassViewController jobClassViewController;
	
	public void setJobClassViewController(JobClassViewController jobClassViewController) {
		this.jobClassViewController = jobClassViewController;
	}


	@Override
	public void initialize(URL location, ResourceBundle reources) {
		
		okButton.setOnAction((event) -> {
			try {
				JobClass jobClass = new JobClass();
				
				jobClass.setClassOfJob(jobClassTextField.getText());
				jobClass.setDescrp(descriptionTextField.getText());
				jobClass.setInactive(inactiveCheckBox.isSelected());
				
				new JobClassEntityController().saveOrUpdate(jobClass);
				
				jobClassViewController.viewJobClass();
				
				new FXFormCommonUtilities().closeForm(okButton);
				
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
