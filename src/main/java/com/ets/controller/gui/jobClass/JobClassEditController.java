package com.ets.controller.gui.jobClass;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.controller.entity.jobClass.JobClassEntityController;
import com.ets.model.Address;
import com.ets.model.DepartmentUnit;
import com.ets.model.Division;
import com.ets.model.JobClass;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class JobClassEditController implements Initializable {
	
	 @FXML
	    private TextField jobClassTextField;

	    @FXML
	    private TextField descriptionTextField;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private TextField idTextField;

	    @FXML
	    private Button updateButton;

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
	    void enterKeyPressedForUpdateButton(KeyEvent event) {
	    	if(event.getCode() == KeyCode.ENTER){
	    		try {
	    			
					JobClass jobClass = new JobClass();

					jobClass.setId(Integer.parseInt(idTextField.getText()));
					jobClass.setClassOfJob(jobClassTextField.getText());
					jobClass.setDescrp(descriptionTextField.getText());
					
					jobClass.setInactive(inactiveCheckBox.isSelected());
					
					new JobClassEntityController().saveOrUpdate(jobClass);
							jobClassViewController.viewJobClass();	
						new FXFormCommonUtilities().closeForm(updateButton);
					

				} catch (Exception ex) {
					ex.printStackTrace();
				}

		    }

	    }
	    
	    private JobClassViewController jobClassViewController;
	    	    
	    public void setJobClassViewController(JobClassViewController jobClassViewController) {
			this.jobClassViewController = jobClassViewController;
		}


		private JobClass jobClass;
	    
	public void setJobClass(JobClass jobClass) {
			this.jobClass = jobClass;
			
			idTextField.setText(Integer.toString(jobClass.getId()));
			jobClassTextField.setText(jobClass.getClassOfJob());
			descriptionTextField.setText(jobClass.getDescrp());
			
			if(jobClass.getInactive() == true){
				
				inactiveCheckBox.setSelected(true);
				
			}else{
				
				inactiveCheckBox.setSelected(false);
			}
			
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		updateButton.setOnAction((event) -> {
			try {
	
				JobClass jobClass = new JobClass();

				jobClass.setId(Integer.parseInt(idTextField.getText()));
				jobClass.setClassOfJob(jobClassTextField.getText());
				jobClass.setDescrp(descriptionTextField.getText());
				
				jobClass.setInactive(inactiveCheckBox.isSelected());
				
				new JobClassEntityController().saveOrUpdate(jobClass);
						jobClassViewController.viewJobClass();	
					new FXFormCommonUtilities().closeForm(updateButton);
				

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
