package com.ets.controller.gui.clinicianSchedule;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.model.Clinician;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ClinicianSelectController implements Initializable {
	
	 @FXML
	    private Button scheduleButton;

	    @FXML
	    private Button closeButton;

	    @FXML
	    private Button clinicianButton;

	    @FXML
	    private TextField nameTextField;

	    @FXML
	    private TextField typeTextield;

	    @FXML
	    private TextField idTextField;
	    
	    public void setClinicianId(Integer cliId){
	    	
	    	idTextField.setText(Integer.toString(cliId));
	    }
	    
	    public void setClinicianName(String name){
	    	
	    	nameTextField.setText(name);
	    	
	    }
	    
	    public void setClinicianType(String type){
	    	
	    	typeTextield.setText(type);
	    	
	    	
	    }
	    
	    FXMLFormPath formPath = new FXMLFormPath();
        public static Clinician clinician;
	    public  void setClinician(Clinician clinician){
	 	   
	 	   //idField = clinician.getId();
	 	  this.clinician  = clinician;
	 	  				   
	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clinicianButton.setOnAction((event) -> {
			try {
				// Load Clinician Details Entry form .

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				
				ClinicianViewController clinicianViewController = 
				(ClinicianViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				clinicianViewController.setClinicianSelectController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		scheduleButton.setOnAction((event) -> {
			
				
             if(nameTextField.getText().equals("")){
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select Clinician!");

					alert.showAndWait();
					
				}else{
				try{
				String formName = formPath.context.getMessage("ViewClinicianScheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewClinicianScheduling", null, Locale.US);
				formPath.closeApplicationContext();
				
				ClinicianScheduleViewController clinicianSchedulingViewController = new ClinicianScheduleViewController();
				clinicianSchedulingViewController.setClinicianId(clinician);
				clinicianSchedulingViewController = (ClinicianScheduleViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			}
		});

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
