package com.ets.controller.gui.inventory.outGo;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.controller.entity.inventory.inventoryOutGo.InventoryOutGoEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.model.Clinic;
import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;
import com.ets.model.Patient;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InventoryOutGoInputController implements Initializable {
	
	 @FXML
	    private TextField inventoryNameText;

	    @FXML
	    private TextField patientText;

	    @FXML
	    private TextField clinicText;

	    @FXML
	    private Button okButton;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private DatePicker dateField;

	    @FXML
	    private Button inventoryBtn;
	    
	    @FXML
	    private Label patientNameLabel;

	    /*@FXML
	    private Button patientBtn;*/

	    @FXML
	    private Button clinicBtn;

	    @FXML
	    private TextField quantityText;
	    
	    public void setClinic(String clinicName){
	    	
	    	clinicText.setText(clinicName);
	    }
	    
	    public void setPatient(){
	    	
	    	patientText.setText(Integer.toString(Global.patient.getId()));
	    	patientNameLabel.setText(Global.patient.getPatientName().getFirstName()+Global.patient.getPatientName().getLastName());
	    		    	
	    }
	    
	    public void setInventory(Integer id){
	    	
	    	inventoryNameText.setText(Integer.toString(id));
	    	
	    }
	    
	    private InventoryOutGoViewController inventoryOutGoViewController;
	    	    
	    public void setInventoryOutGoViewController(InventoryOutGoViewController inventoryOutGoViewController) {
			this.inventoryOutGoViewController = inventoryOutGoViewController;
		}

		FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//setPatient();
		/* public void setPatient(String patientName){
		    	
		    	patientText.setText(patientName);
		    		    	
		    }
		*/
		/*patientBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
				formPath.closeApplicationContext();
				
				PatientViewController patientViewController =
				(PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				patientViewController.setInventoryOutGoInputController(this, patientBtn);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		clinicBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicViewController clinicViewController =
				(ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				clinicViewController.setInventoryOutGoInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
          okButton.setOnAction((event) -> {
			
			InventoryOutGo inventoryOutGo=new InventoryOutGo();
			
			inventoryOutGo.setQuantityOut(quantityText.getText());
			
			LocalDate localDate = dateField.getValue();
			if(localDate != null){
				
				Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
									
				inventoryOutGo.setOutGoDate(date);
				
			}
			
			if(inventoryNameText.getText().isEmpty()){
				
			}
						
			if(clinicText.getText().isEmpty()){
				
			}else{
				
				Clinic clinic = new ClinicEntityController().viewByName(clinicText.getText());
				inventoryOutGo.setClinic(clinic);
				
			}
			
			if(patientText.getText().isEmpty()){
				
			}else{
				
				/*Clinic clinic = new ClinicEntityController().viewByName(clinicText.getText());
				inventoryOutGo.setClinic(clinic);*/
				
				/*Patient patient = new PatientEntityController().getById(Global.patient.getId());
				inventoryOutGo.setPatient(patient);
		*/
			}
			
			
			
			//inventoryOutGo.setUserAccount(Global.userAccount.getFirstName());
			
			new InventoryOutGoEntityController().saveOrUpdate(inventoryOutGo);
			inventoryOutGoViewController.viewInventoryOutGo();
			new FXFormCommonUtilities().closeForm(okButton);
			
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
