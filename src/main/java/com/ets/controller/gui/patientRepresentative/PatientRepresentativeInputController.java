package com.ets.controller.gui.patientRepresentative;

import java.net.URL;
import java.util.ResourceBundle;

//import org.mockito.internal.matchers.ArrayEquals;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.patientAuthRep.PatientAuthRepEntityController;
import com.ets.model.Address;
import com.ets.model.PatientAuthRep;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.model.RepresentRelation;
import com.ets.controller.entity.representativeRelation.RepRelationEntityController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PatientRepresentativeInputController implements Initializable {

	
	 	@FXML
	    private TextField firstNameText;

	    @FXML
	    private TextField middleNameText;

	    @FXML
	    private TextField lastNameText;

	    @FXML
	    private TextField suffixText;

	    @FXML
	    private TextField streetText;

	    @FXML
	    private TextField cityText;

	    @FXML
	    private TextField stateText;

	    @FXML
	    private TextField zipText;

	    @FXML
	    private TextField phoneText;

	    @FXML
	    private TextField celltext;
	    
	    @FXML
	    private TextField faxText;

	    @FXML
	    private TextField emailText;

	    @FXML
	    private RadioButton maleRadioButton;

	    @FXML
	    private ToggleGroup gender;

	    @FXML
	    private RadioButton femaleRadioButton;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button closeButton;
	    
	    //private String gndr;
	    private PatientRepresentativeViewController patientRepresentativeViewController;
	    
	   PatientAuthRep object = new PatientAuthRep();
	   RepresentRelation obj; 	
	   
	    public void setPatientRepresentativeViewController(
				PatientRepresentativeViewController patientRepresentativeViewController, PatientAuthRep patientRepChng) {
			this.patientRepresentativeViewController = patientRepresentativeViewController;
			object = patientRepChng;
			//gndr = patientRepChng.getGender();
			firstNameText.setText(patientRepChng.getFirstName());	    
			lastNameText.setText(patientRepChng.getLastName());
			middleNameText.setText(patientRepChng.getMiddleName());
			suffixText.setText(patientRepChng.getSuffix());
			if(patientRepChng.getGender().equals("Male"));
			{
				
				maleRadioButton.setSelected(true);
				
			}
			
			
			if (patientRepChng.getGender().equals("Female"))
			{
				femaleRadioButton.setSelected(true);
			}
			
			Address address = patientRepChng.getAddress();
			streetText.setText(address.getLocalAddress());
			cityText.setText(address.getCity());
			stateText.setText(address.getState());
			zipText.setText(address.getZip());
			phoneText.setText(address.getPhone());
			celltext.setText(address.getPhHome());
			faxText.setText(address.getFax());
			emailText.setText(address.getEmail());
			
			//new FXFormCommonUtilities().closeForm( addButton );
			
	    
	    }
	    
	   
	    public void setPatientRepresentativeViewController(
				PatientRepresentativeViewController patientRepresentativeViewController2) {
	    	this.patientRepresentativeViewController = patientRepresentativeViewController2;
			// TODO Auto-generated method stub
			
		}
	  

	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
		addButton.setOnAction((event) -> {
			try {
				
				String gender = null;
				
				if(maleRadioButton.isSelected()){
					
					gender = "Male";
					
				}else if (femaleRadioButton.isSelected()) {
					
					gender = "Female";
				}
				
				Address address = new Address();
				
				address.setlocalAddress(streetText.getText());
				address.setCity(cityText.getText());
				address.setState(stateText.getText());
				address.setZip(zipText.getText());
				address.setPhone(phoneText.getText());
				address.setPhHome(celltext.getText());
				address.setFax(faxText.getText());
				address.setEmail(emailText.getText());
				
				
				if(object!= null){
					
					new AddressEntityController().update(address);
					
				}else{
					
					new AddressEntityController().add(address);
				}
				
				
				
				PatientAuthRep patientAuthRep = new PatientAuthRep();
				
				
				patientAuthRep.setAddress(address);
				patientAuthRep.setFirstName(firstNameText.getText());
				patientAuthRep.setLastName(lastNameText.getText());
				patientAuthRep.setMiddleName(middleNameText.getText());
				patientAuthRep.setSuffix(suffixText.getText());
				patientAuthRep.setGender(gender);
				
				if(object!= null){
					patientAuthRep.setId(object.getId());
					
				}
				
				
				new PatientAuthRepEntityController().saveOrUpdate(patientAuthRep);
				patientRepresentativeViewController.viewPatientAuthRep();
				new FXFormCommonUtilities().closeForm( addButton );
				 
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
			


			
		});
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm( closeButton );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}



	

}
