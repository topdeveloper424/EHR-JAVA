package com.ets.controller.gui.clinicianSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.clinicianSchedule.ClinicianScheduleEntityController;
import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.model.ClinicSchedule;
import com.ets.model.ClinicianSchedule;
import com.ets.model.ProviderSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ClinicianScheduleEnterController implements Initializable{
	
	@FXML
    private TextField dayTextField;

    @FXML
    private TextField starttimeTextField;

    @FXML
    private TextField finishTimeTextField;

    @FXML
    private Button okButton;

    @FXML
    private ComboBox<String> startTimeDropDwn;

    @FXML
    private ComboBox<String> closeTimeDropDwn;
    @FXML
    private Button cancelButton;
    
    private ClinicianSchedule clinicianSchedule;
    

    public void setClinicianSchedule(ClinicianSchedule clinicianSchedule) {
		this.clinicianSchedule = clinicianSchedule;
		dayTextField.setText(clinicianSchedule.getWeekday());
		//starttimeTextField.setText(providerSchedule.getOpenTime());
		
	
		if(clinicianSchedule.getOpenTime()!=null &&clinicianSchedule.getCloseTime()!=null){
		
		String substringOpen = clinicianSchedule.getOpenTime().trim();
		starttimeTextField.setText(substringOpen.substring(0, substringOpen.length()-2));
		startTimeDropDwn.setValue(substringOpen.substring(Math.max(substringOpen.length() - 2, 0)));
	
		String substringClose = clinicianSchedule.getCloseTime().trim();
		finishTimeTextField.setText(substringClose.substring(0, substringClose.length()-2));
		closeTimeDropDwn.setValue(substringClose.substring(Math.max(substringClose.length() - 2, 0)));
		}
	/*dayTextField.setText(clinicianSchedule.getWeekday());
		starttimeTextField.setText(clinicianSchedule.getOpenTime());
		finishTimeTextField.setText(clinicianSchedule.getCloseTime());*/
	
    }
	@FXML
    void clickOkButton(ActionEvent event) {
    	
    	clinicianSchedule.setWeekday(dayTextField.getText());
    	clinicianSchedule.setOpenTime(starttimeTextField.getText());
    	clinicianSchedule.setCloseTime(finishTimeTextField.getText());
		
		new FXFormCommonUtilities().closeForm(okButton);

    }
	  void setComboBox(){
	    	List comboVal = new ArrayList<>();
			
			comboVal.add("AM");
			comboVal.add("PM");
			 ObservableList<String> comboTimeVal = FXCollections.observableList(comboVal);
			startTimeDropDwn.setItems(comboTimeVal);
			startTimeDropDwn.setValue("AM");
			closeTimeDropDwn.setItems(comboTimeVal);
			closeTimeDropDwn.setValue("PM");
		  
	     }

	String clinicianId = null;
	public void getClinicianId(String cliId){
		
		clinicianId = cliId;
		
		
	}

    private ClinicianScheduleViewController clinicianScheduleViewController;
    
	public void setClinicianScheduleViewController(ClinicianScheduleViewController clinicianScheduleViewController) {
		this.clinicianScheduleViewController = clinicianScheduleViewController;
	}

    public boolean checkClinicSchedule(){
    	
    List<ClinicSchedule> cliSch = new ClinicScheduleEntityController().viewClinicScheduleByClinicId(Global.clinic.getId());
    String startTimeProvider[] = starttimeTextField.getText().trim().split(":");
    
	String endtimeProvider[] = finishTimeTextField.getText().trim().split(":");
	
    if(dayTextField.getText().equals("Sunday")){
    	String cliOpenTime[] = cliSch.get(0).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(0).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	 /*&&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    		
    		return true;
    	 
    	} else{
    		return false;
    		
    	}
     
    }else if(dayTextField.getText().equals("Monday")){
    	String cliOpenTime[] = cliSch.get(1).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(1).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	/* &&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    			
    		return true;
    	 
    	} else{
    		return false;
    	}
     
    }else if(dayTextField.getText().equals("TuesDay")){
    	String cliOpenTime[] = cliSch.get(2).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(2).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	 /*&&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    		return true;
    	 
    	} else{
    			
    		return false;
    	}
     
    }else if(dayTextField.getText().equals("Wednesday")){
    	String cliOpenTime[] = cliSch.get(3).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(3).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	/* &&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    		return true;
    	 
    	} else{
    		return false;
    	}
    }
    else if(dayTextField.getText().equals("Thursday")){
    	
    	String cliOpenTime[] = cliSch.get(4).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(4).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	 /*&&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    			return true;
    	 
    	} else{
    		return false;
    	}
    }
    else if(dayTextField.getText().equals("Friday")){
    	String cliOpenTime[] = cliSch.get(5).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(5).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	/* &&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    			return true;
    	 
    	} else{
    		return false;
    	}
    }  else if(dayTextField.getText().equals("Saturday")){
    	String cliOpenTime[] = cliSch.get(6).getOpenTime().split(":");
    	String closeTime[] = cliSch.get(6).getCloseTime().split(":");
    	String cliStartInMin[] = cliOpenTime[1].split(" ");
    	String cliEndInMin[] = closeTime[1].split(" ");
    	
    	if(Integer.parseInt(startTimeProvider[0])>=Integer.parseInt(cliOpenTime[0])&&(Integer.parseInt(startTimeProvider[1]))>=(Integer.parseInt(cliStartInMin[0]))
    	 &&Integer.parseInt(endtimeProvider[0])<=Integer.parseInt(closeTime[0])&&(Integer.parseInt(endtimeProvider[1]))<=(Integer.parseInt(cliEndInMin[0]))
    	 /*&&cliStartInMin[1].equals(startTimeDropDwn.getValue())&& cliEndInMin[1].equals(closeTimeDropDwn.getValue())*/){
    	return true;
    	 
    	} else{
    		
    		return false;
    	}
      
    }else{
    	
 		return false;
 	}
    
    
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setComboBox();
		
		okButton.setOnAction((event) -> {
			try {
				
				String str3 = starttimeTextField.getText();
				
				if((starttimeTextField.getText().contains(":")==false)&&(finishTimeTextField.getText().contains(":")==false)&&((starttimeTextField.getText()!=""&&(finishTimeTextField.getText()!="")))){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Invalid Time Format! \n (eg. 7:00)");

					alert.show();
		    	}else{
		    	boolean checkClinicTime = checkClinicSchedule();
		        if(checkClinicTime==true){
		    		
				ClinicianSchedule clinicianSchedule1 = new ClinicianSchedule();
				
				clinicianSchedule1.setId(clinicianSchedule.getId());
				clinicianSchedule1.setWeekday(dayTextField.getText());
				
				  String str = starttimeTextField.getText().trim()+" "+startTimeDropDwn.getValue();
				  clinicianSchedule1.setOpenTime(str);
				String str1 = finishTimeTextField.getText().trim()+" "+closeTimeDropDwn.getValue();
				clinicianSchedule1.setCloseTime(str1);
				
				//NOW
				//Provider provider = new ProviderEntityController().viewById(providerSchedule.getProvider().getId());
				clinicianSchedule1.setClinician(clinicianSchedule.getClinician());
								
				new ClinicianScheduleEntityController().saveOrUpdate(clinicianSchedule1);
				
				
				clinicianScheduleViewController.getClinicianSchedule(ClinicianSelectController.clinician.getId());
				clinicianScheduleViewController.viewClinicianSchedule();
				//clinicScheduleViewController.viewClinicSchedule();
				new FXFormCommonUtilities().closeForm(okButton);
		    	}else{
		    		
		    		Alert alert = new Alert(AlertType.INFORMATION);
		    		alert.setTitle("Information Dialog");
		    		alert.setHeaderText(null);
		    		alert.setContentText("Clinic is closed!");

		    		alert.showAndWait();
		    	}
		    	}
		    	
		    	
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
