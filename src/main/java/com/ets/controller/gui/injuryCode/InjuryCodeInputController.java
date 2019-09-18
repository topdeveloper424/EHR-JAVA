package com.ets.controller.gui.injuryCode;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeGUIController Class
 *Description: EnterInjuryCode.fxml Controller class
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
import com.ets.controller.entity.injuryCode.InjuryCodeEntityController;
import com.ets.model.InjuryCode;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InjuryCodeInputController implements Initializable {

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
	private TextField wcioTextField;

	@FXML
	private CheckBox oshaCheckBox;
	
	@FXML
	void enterKeyPressedForCancelButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@FXML
	void enterKeyPressedForOkButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				InjuryCode injuryCode = new InjuryCode();
				injuryCode.setCode(this.codeTextField.getText());
				injuryCode.setDescrp(this.descriptionTextField.getText());
				injuryCode.setWc10Code(this.wcioTextField.getText());
				injuryCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
				injuryCode.setInactive(this.inactiveCheckBox.isSelected());
				new InjuryCodeEntityController().saveInjuryCode(injuryCode);
				injuryCodeViewController.populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());

				new FXFormCommonUtilities().closeForm(okButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	    
	    @FXML
	    void enterKeyPressedForOshaRecordable(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
				 
				 try {
						if(oshaCheckBox.isSelected()){
							
							oshaCheckBox.setSelected(false);
							
						}else{
							
							oshaCheckBox.setSelected(true);
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				 
			 }

	    }
	    
	    @FXML
	    void enterKeyPressedForInactive(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
				 
				 try {
						if(inactiveCheckBox.isSelected()){
							
							inactiveCheckBox.setSelected(false);
							
						}else{
							
							inactiveCheckBox.setSelected(true);
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				 
			 }

	    }
	    
	   
	private InjuryCodeViewController injuryCodeViewController;

	public void setInjuryCodeViewController(InjuryCodeViewController injuryCodeViewController) {
		this.injuryCodeViewController = injuryCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		okButton.setOnAction((event) -> {
			// Insert InjuryCode Code

			InjuryCode injuryCode = new InjuryCode();
			injuryCode.setCode(this.codeTextField.getText());
			injuryCode.setDescrp(this.descriptionTextField.getText());
			injuryCode.setWc10Code(this.wcioTextField.getText());
			injuryCode.setAlwaysOshaRecordable(this.oshaCheckBox.isSelected());
			injuryCode.setInactive(this.inactiveCheckBox.isSelected());
			new InjuryCodeEntityController().saveInjuryCode(injuryCode);
			injuryCodeViewController.populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());
			
				new FXFormCommonUtilities().closeForm(okButton);

			

		});

		cancelButton.setOnAction((event) -> {
			// Centralised Form cancel

			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
