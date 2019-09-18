package com.ets.controller.gui.clinicSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.model.ClinicSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class ClinicScheduleSaveEditController implements Initializable{
	

   @FXML
    private TextField dayTextField;

    @FXML
    private TextField starttimeTextField;

    @FXML
    private TextField finishTimeTextField;

    @FXML
    private Button okButton;
    
    @FXML
    private Button cancelButton;

    @FXML
    private RadioButton radioButton1;

    @FXML
    private ToggleGroup slot;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private RadioButton radioButton3;

    @FXML
    private RadioButton radioButton4;

    @FXML
    private RadioButton radioButton5;
    @FXML
    private ComboBox<String> startTimeDropDwn;

    @FXML
    private ComboBox<String> endTimeDropDwn;  
   
	
	private ClinicScheduleViewController clinicScheduleViewController;

	public void setClinicScheduleViewController(ClinicScheduleViewController clinicScheduleViewController) {
		this.clinicScheduleViewController = clinicScheduleViewController;
	}
	
	private ClinicSchedule clinicSchedule1;
    int clinicScheduleId;
	public void setClinicSchedule(ClinicSchedule clinicSchedule1) {
		this.clinicSchedule1 = clinicSchedule1;
        clinicScheduleId = clinicSchedule1.getId();
      
		
		//idTextField.setText(Integer.toString(clinicSchedule.getId()));
		dayTextField.setText(clinicSchedule1.getWeekday());
		if(clinicSchedule1.getOpenTime()!=null&& clinicSchedule1.getCloseTime()!=null){
		String substringOpen = clinicSchedule1.getOpenTime().trim();
		starttimeTextField.setText(substringOpen.substring(0, substringOpen.length()-2));
		startTimeDropDwn.setValue(substringOpen.substring(Math.max(substringOpen.length() - 2, 0)));

		
		String substringClose = clinicSchedule1.getCloseTime().trim();
		finishTimeTextField.setText(substringClose.substring(0, substringClose.length()-2));
		endTimeDropDwn.setValue(substringClose.substring(Math.max(substringClose.length() - 2, 0)));
		}	
		if(clinicSchedule1.getTimeslotSize() != null){
			
			if(clinicSchedule1.getTimeslotSize().equals("5")){
				
				radioButton1.setSelected(true);
				
			}else if (clinicSchedule1.getTimeslotSize().equals("10")) {
				
				radioButton2.setSelected(true);
				
			}else if (clinicSchedule1.getTimeslotSize().equals("15")) {
				
				radioButton3.setSelected(true);
				
			}else if (clinicSchedule1.getTimeslotSize().equals("20")) {
				
				radioButton4.setSelected(true);
				
			}else if (clinicSchedule1.getTimeslotSize().equals("30")) {
				
				radioButton5.setSelected(true);
				
			}
			
		}
			
			/*if(clinicSchedule.getTimeslotSize().equals("5")){
				
				radioButton1.setSelected(true);
				
			}else if (clinicSchedule.getTimeslotSize().equals("10")) {
				
				radioButton2.setSelected(true);
				
			}else if (clinicSchedule.getTimeslotSize().equals("15")) {
				
				radioButton3.setSelected(true);
				
			}else if (clinicSchedule.getTimeslotSize().equals("20")) {
				
				radioButton4.setSelected(true);
				
			}else if (clinicSchedule.getTimeslotSize().equals("30")) {
				
				radioButton5.setSelected(true);
				
			}*/
			
		}
	
	@FXML
    void okButtonClick(ActionEvent event) {
		
		clinicSchedule1.setWeekday(dayTextField.getText());
		clinicSchedule1.setOpenTime(starttimeTextField.getText());
		clinicSchedule1.setCloseTime(finishTimeTextField.getText());
		//clinicSchedule1.setId(clinicScheduleId);
		String slotTime = null;
		if(radioButton1.isSelected() == true){
			
			slotTime="5";
			
		}else if (radioButton2.isSelected() == true) {
			
			slotTime="10";
			
		}else if (radioButton3.isSelected() == true) {
			
			slotTime="15";
			
		}else if (radioButton4.isSelected() == true) {
			
			slotTime="20";
			
		}else if (radioButton5.isSelected() == true) {
			
			slotTime="30";
			
		}
		
		clinicSchedule1.setTimeslotSize(slotTime);
		
		new FXFormCommonUtilities().closeForm(okButton);

    }	
    
	public void setTimeCombo(){
			
		List comboVal = new ArrayList<>();
				
		comboVal.add("AM");
		comboVal.add("PM");
		 ObservableList<String> comboTimeVal = FXCollections.observableList(comboVal);
		startTimeDropDwn.setItems(comboTimeVal);
		startTimeDropDwn.setValue("AM");
		endTimeDropDwn.setItems(comboTimeVal);
		endTimeDropDwn.setValue("PM");
	}
						
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setTimeCombo();
		okButton.setOnAction((event) -> {
			try { 
				if(!starttimeTextField.getText().contains(":")&&!finishTimeTextField.getText().contains(":")&&starttimeTextField.getText()!=""&&(finishTimeTextField.getText()!="")){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Invalid Time Format! \n (eg. 7:00)");

					alert.show();
		    	}else{
				ClinicSchedule clinicSchedule = new ClinicSchedule();
				clinicSchedule.setId(clinicScheduleId);
				clinicSchedule.setWeekday(dayTextField.getText());
				if(starttimeTextField.getText()==""){
					
					clinicSchedule.setOpenTime(null);		
					
				}else{
					String str = starttimeTextField.getText().trim()+" "+startTimeDropDwn.getValue();
					clinicSchedule.setOpenTime(str);
					
				}
				if(finishTimeTextField.getText()==""){
					clinicSchedule.setCloseTime(null);
					
				}else{
					String str2 = finishTimeTextField.getText().trim()+" "+endTimeDropDwn.getValue();
					clinicSchedule.setCloseTime(str2);
				}
				
				clinicSchedule.setClinic(Global.clinic);
				String slotTime = null;
				if(radioButton1.isSelected() == true){
					
					slotTime="5";
					
				}else if (radioButton2.isSelected() == true) {
					
					slotTime="10";
					
				}else if (radioButton3.isSelected() == true) {
					
					slotTime="15";
					
				}else if (radioButton4.isSelected() == true) {
					
					slotTime="20";
					
				}else if (radioButton5.isSelected() == true) {
					
					slotTime="30";
					
				}
				
				clinicSchedule.setTimeslotSize(slotTime);
				
				new ClinicScheduleEntityController().saveOrUpdate(clinicSchedule);
				clinicScheduleViewController.getClinicSchedileByClinicId(Global.clinic.getId());
				clinicScheduleViewController.viewClinicSchedule();
				new FXFormCommonUtilities().closeForm(okButton);
				
			}} catch (Exception ex) {
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













