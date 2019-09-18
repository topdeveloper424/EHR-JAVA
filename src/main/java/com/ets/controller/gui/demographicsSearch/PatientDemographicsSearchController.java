package com.ets.controller.gui.demographicsSearch;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PatientDemographicsSearchController implements Initializable {

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private DatePicker dob;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelBtn;
    FXMLFormPath formPath = new FXMLFormPath();
    public static List<Patient> patientList=new ArrayList<Patient>();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	
		okBtn.setOnAction(event->{
			try {

				String formName = formPath.context.getMessage("ViewPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient", null, Locale.US);
				formPath.closeApplicationContext();
				
				Date date1= null;
				LocalDate localDate1 = dob.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
				}
				
								
				 patientList = new PatientEntityController().searchPatient(
						 firstNameText.getText(), lastNameText.getText(), date1,Global.clinic.getId());
						
				PatientViewController patientViewController =
				(PatientViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				patientViewController.setPatientDemographicsSearchController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
			
		});
		cancelBtn.setOnAction(event->{
			
			new FXFormCommonUtilities().closeForm(cancelBtn);
			
		});
	}

}
