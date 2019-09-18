package com.ets.controller.gui.clinicSchedule;

import java.lang.reflect.Array;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.clinicBlockSchedule.ClinicBlockScheduleEntityController;
import com.ets.controller.entity.clinicClosed.ClinicClosedEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.model.Clinic;
import com.ets.model.ClinicBlockSchedule;
import com.ets.model.ClinicClosed;
import com.ets.model.ClinicSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * 
 * Original Author: Neha Sahadev on Behalf of ETS for Client Company File
 * Creation Date: 18-10-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of ClinicScheduleSetUpController Class Description:
 * ClinicScheduleSetUp.fxml Controller class Copyright 2016 @Eclipse
 * Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class ClinicScheduleSetUpController implements Initializable {
	   @FXML
	    private DatePicker inputDateField;

	    @FXML
	    private TextField sunDayTextField;

	    @FXML
	    private TextField monDayTextField;

	    @FXML
	    private TextField tuesDayTextField;

	    @FXML
	    private TextField wednesDayTextField;

	    @FXML
	    private TextField thursDayTextField;

	    @FXML
	    private TextField friDayTextField;

	    @FXML
	    private TextField saturDayTextField;

	    @FXML
	    private Button addAnotherClinicBtn;


	    @FXML
	    private Button add;

	    @FXML
	    private Button openEntireWeekButton;

	    @FXML
	    private Button closedEntireWeekButton;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private Button closeButton;
	    @FXML
	    private ScrollPane scrollPaneId;
	    @FXML
	    private GridPane timeSlotGrid;

	    @FXML
	    private TextField button;
	    @FXML
	    private Label clinicNameLabel;

	    @FXML
	    private Label startTimetext;

	    @FXML
	    private Label endTime;
	    @FXML
	    private CheckBox openCheckBoxCollumn1;

	    @FXML
	    private CheckBox openCheckBoxCollumn2;

	    @FXML
	    private CheckBox openCheckBoxCollumn3;

	    @FXML
	    private CheckBox openCheckBoxCollumn4;

	    @FXML
	    private CheckBox openCheckBoxCollumn5;

	    @FXML
	    private CheckBox openCheckBoxCollumn6;

	    @FXML
	    private CheckBox openCheckBoxCollumn7;
	   
	    @FXML
	    void openCheckBoxCollumn1(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    		if(openCheckBoxCollumn1.isSelected()){
	    		
	    		  for(int i=0;i<lengthToGen;i++){
					sundayText[i].setDisable(activeClinicTimeSun[i]);	
				}
	    		
	    	}else{
	    		
	    		for(int i=0;i<lengthToGen;i++){
					sundayText[i].setDisable(activeClinicTimeArr[i]);	
				}	
	    		

	    	}
	    	    	
	    }

	    @FXML
	    void openCheckBoxCollumn2(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn2.isSelected()){
	    		
	    		for(int i=0;i<lengthToGen;i++){
					monText[i].setDisable(activeClinicTimeMon[i]);	
				}
	    	}else{
	    		
	    		for(int i=0;i<lengthToGen;i++){
	    			monText[i].setDisable(activeClinicTimeArr[i]);	
				}	
	    		
	    	}
	    	
	    }

	    @FXML
	    void openCheckBoxCollumn3(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn3.isSelected()){
	    	   for(int i=0;i<lengthToGen;i++){
				tuesText[i].setDisable(activeClinicTimeTues[i]);	
			}
    	}else{
    		
    		for(int i=0;i<lengthToGen;i++){
    			tuesText[i].setDisable(activeClinicTimeArr[i]);	
			}	
    		
    	}
	    }

	    @FXML
	    void openCheckBoxCollumn5(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn4.isSelected()){
	    	   for(int i=0;i<lengthToGen;i++){
				wedText[i].setDisable(activeClinicTimeWed[i]);	
			}
    	}else{
    		
    		for(int i=0;i<lengthToGen;i++){
    			wedText[i].setDisable(activeClinicTimeArr[i]);	
			}	
    		
    	}
	    }

	    @FXML
	    void openCheckBoxCollumn6(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn5.isSelected()){
	    	   for(int i=0;i<lengthToGen;i++){
				thursText[i].setDisable(activeClinicTimeThurs[i]);	
			}
    	}else{
    		
    		for(int i=0;i<lengthToGen;i++){
    			thursText[i].setDisable(activeClinicTimeArr[i]);	
			}	
    		
    	}
	    }

	    @FXML
	    void openCheckBoxCollumn7(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn6.isSelected()){
	    	   for(int i=0;i<lengthToGen;i++){
				friText[i].setDisable(activeClinicTimeFri[i]);	
			}
    	}else{
    		
    		for(int i=0;i<lengthToGen;i++){
    			friText[i].setDisable(activeClinicTimeArr[i]);	
			}	
    		
    	}
	    }

	    @FXML
	    void openCheckBoxCollumn8(ActionEvent event) {
	    	Arrays.fill(activeClinicTimeArr, true);
	    	if(openCheckBoxCollumn7.isSelected()){
	    	   for(int i=0;i<lengthToGen;i++){
				satText[i].setDisable(activeClinicTimeSat[i]);	
			}
    	}else{
    		
    		for(int i=0;i<lengthToGen;i++){
    			satText[i].setDisable(activeClinicTimeArr[i]);	
			}	
    		
    	}
	    }

	// private ObservableList<ClinicClosed> clinicClosedMasterData =
	// FXCollections.observableArrayList();
		List<ClinicClosed> list1 = null;
		List<ClinicBlockSchedule> cliblock = null;
		List<ClinicBlockSchedule> clinicBlockSchedulesList = new ArrayList<ClinicBlockSchedule>();
		String dbDate = null;
		public int lengthToGen=0;
	    public static ClinicScheduleViewController clinicScheduleViewController;
	    private List<ClinicSchedule> clinicScheduleTimeList;
	    public void setClinicScheduleViewController(ClinicScheduleViewController clinicScheduleViewController,List<ClinicSchedule> clinicScheduleTimeList){
		this.clinicScheduleViewController = clinicScheduleViewController;
		this.clinicScheduleTimeList = clinicScheduleTimeList;
		
	  startTimetext.setText(clinicScheduleTimeList.get(0).getOpenTime());
	  endTime.setText(clinicScheduleTimeList.get(0).getCloseTime());
	  lengthToGen = setByTimeSlot(Integer.parseInt(clinicScheduleTimeList.get(0).getTimeslotSize()));
	  componentGenerator(lengthToGen);
	  setFromClinicSchedule(lengthToGen);
	  viewClinicClosedDate();
	  viewBlockTime();
	  getOpenedCheckBox();
	 
	}

      
      List<ClinicBlockSchedule> cliBlockDelete = new ArrayList<ClinicBlockSchedule>();
	   public void  onClickBlockTime(TextField blockedTextField,String time)
	  {
		
		 if(blockedTextField.getStyle().equals("-fx-background-color :#E18080")){
			
			    blockedTextField.setStyle(null);
			    for(int i=0;i<cliblock.size();i++){
				
				if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(0))){
					
					cliBlockDelete.add(cliblock.get(i));
					
				}
				else if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(1))){
            	  cliBlockDelete.add(cliblock.get(i));
            	 
				}
				else if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(2))){
            	  cliBlockDelete.add(cliblock.get(i));
            	  
				}
				else  if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(3))){
	            	  cliBlockDelete.add(cliblock.get(i));
	            	 	
					}
				else if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().toString().equals(dateList.get(4))){
            	  cliBlockDelete.add(cliblock.get(i));
            	  
				}
				else if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(5))){
            	  cliBlockDelete.add(cliblock.get(i));
            	  
				}
				else  if(cliblock.get(i).getBlockTime().equals(time)&&cliblock.get(i).getBlockTimeDate().equals(dateList.get(6))){
            	  cliBlockDelete.add(cliblock.get(i));
            	 	
				}else {
					
					Iterator<ClinicBlockSchedule> clin = clinicBlockSchedulesList.iterator();
					  while (clin.hasNext()) {
						ClinicBlockSchedule cli = clin.next();
						if(cli.getBlockTime()==time){
							clin.remove();
							
							
						}
					  
					}
					
				
				}
             
				
			}
			 
			
		 }else{
		   
		   
		  ClinicBlockSchedule clinicBlockSchedule =  new ClinicBlockSchedule();
		  clinicBlockSchedule.setBlockTime(time);
		  clinicBlockSchedule.setClinic(Global.clinic);
		  //clinicBlockSchedule.setClinc(Global.clinic);
		  if(blockedTextField.getId().substring(0, 3).equals("sun")){
			 
			   blockedTextField.setStyle("-fx-background-color :#E18080");
			 
			  Date date =  string2Date(sunDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			
		  }
          if(blockedTextField.getId().substring(0, 3).equals("mon")){
        	 
   		     blockedTextField.setStyle("-fx-background-color :#E18080");
   		 
			  Date date =  string2Date(monDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			 
			  
		  }  if(blockedTextField.getId().substring(0, 3).equals("tue")){
			
			   blockedTextField.setStyle("-fx-background-color :#E18080");
			 
			  Date date =  string2Date(tuesDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			 
			  
		  } if(blockedTextField.getId().substring(0, 3).equals("wed")){
			
			   blockedTextField.setStyle("-fx-background-color :#E18080");
			 
			  Date date =  string2Date(wednesDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			 
			  
		  }if(blockedTextField.getId().substring(0, 3).equals("thu")){
			
			   blockedTextField.setStyle("-fx-background-color :#E18080");
			 
			  Date date =  string2Date(thursDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			 
			  
		  }
          if(blockedTextField.getId().substring(0, 3).equals("fri")){
        	
   		     blockedTextField.setStyle("-fx-background-color :#E18080");
   		 
			  Date date =  string2Date(friDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			  
			  
		  } if(blockedTextField.getId().substring(0, 3).equals("sat")){
			
			   blockedTextField.setStyle("-fx-background-color :#E18080");
			 
			  Date date =  string2Date(saturDayTextField.getText());
			  clinicBlockSchedule.setBlockTimeDate(date);  
			  
			  
		  }
		  clinicBlockSchedulesList.add(clinicBlockSchedule);
		 }
	  }
	    
	    
	    
	  
	TextField[] sundayText = null;	
	TextField[] monText = null ;
	TextField[] tuesText =null;
	TextField[] wedText = null;
	TextField[] thursText = null ;
	TextField[] friText =  null;
	TextField[] satText =  null;

		 	
	public void componentGenerator(int lengthToGen){
		 sundayText = new TextField[lengthToGen];
		 monText = new TextField[lengthToGen];
		 tuesText = new TextField[lengthToGen];
		 wedText  = new TextField[lengthToGen];
		 thursText  = new TextField[lengthToGen];
		 friText  = new TextField[lengthToGen];
		 satText = new TextField[lengthToGen];

		Label[] timeSlotlb = new Label[lengthToGen];
		   
			for(int i=0;i<lengthToGen;i++){
			
			System.out.println(i);
			timeSlotlb[i]=new Label(timeSlotString[i]);
			timeSlotlb[i].setId("timeSlot"+Integer.toString(i));
			int m = i;
			
			sundayText[i]=new TextField();
			sundayText[i].setId("sundayText"+Integer.toString(i));
			sundayText[i].setDisable(true);
			//sundayText[i].setOnMouseClicked(onClickBlockTime(sundayText[i].getId()));
			sundayText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(sundayText[m],timeSlotString[m]);
			    	
			    	}
			    	if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(0).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(0).getCloseTime());
				    	
				    	}
			    }
			});
			
			monText[i]=new TextField();
			
			monText[i].setId("monText"+Integer.toString(i));
			monText[i].setDisable(true);
			monText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(monText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(1).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(1).getCloseTime());
				    	
				    	}
			    }
			});
			tuesText[i]=new TextField();
			tuesText[i].setId("tuesText"+Integer.toString(i));
			tuesText[i].setDisable(true);
			tuesText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(tuesText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(2).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(2).getCloseTime());
				    	
				    	}
			    }
			});
			
			wedText[i]=new TextField();
			wedText[i].setId("wedText"+Integer.toString(i));
			wedText[i].setDisable(true);
			wedText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(wedText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(3).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(3).getCloseTime());
				    	
				    	}
			    }
			});
			
			
			thursText[i]=new TextField();
			thursText[i].setId("thursText"+Integer.toString(i));
			thursText[i].setDisable(true);
			thursText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(thursText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(4).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(4).getCloseTime());
				    	
				    	}
			    }
			});
			
			friText[i]=new TextField();
			friText[i].setDisable(true);
			friText[i].setId("friText"+Integer.toString(i));
			friText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(friText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(5).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(5).getCloseTime());
				    	
				    	}
			    }
			});
			
			satText[i]=new TextField();
			satText[i].setId("satText"+Integer.toString(i));
			satText[i].setDisable(true);
			satText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
			    public void handle(MouseEvent me) {
			    	if (me.getClickCount() == 2) {
			    	onClickBlockTime(satText[m],timeSlotString[m]);
			    	
			    	}if (me.getClickCount() == 1) {
			    		startTimetext.setText(clinicScheduleTimeList.get(6).getOpenTime());
			    		endTime.setText(clinicScheduleTimeList.get(6).getCloseTime());
				    	
				    	}
			    }
			});
			
			timeSlotGrid.setVgap(1);
			timeSlotGrid.add(timeSlotlb[i], 0, i);
			timeSlotGrid.add(sundayText[i], 1, i);
			timeSlotGrid.add(monText[i], 2, i);
			timeSlotGrid.add(tuesText[i], 3, i);
			timeSlotGrid.add(wedText[i], 4, i);
			timeSlotGrid.add(thursText[i], 5, i);
			timeSlotGrid.add(friText[i], 6, i);
			timeSlotGrid.add(satText[i], 7, i);
			
			
		}
    
		
		scrollPaneId.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPaneId.setHbarPolicy(ScrollBarPolicy.NEVER);
		
	}

	// Convert Date to String
	public String date2String(Date date) {
		return new SimpleDateFormat("MM/dd/yyyy").format(date);
	}

	// Convert String to Date
	public Date string2Date(String dateAsString) {
		Date convertedString = null;
		try {
			convertedString = new SimpleDateFormat("MM/dd/yyyy").parse(dateAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedString;
	} 
	  
	public void toDaySet() {

		Date date2 = new Date();

		if (date2 != null) {

			Calendar c1 = Calendar.getInstance();
			c1.setTime(date2);
			int dayOfWeek = c1.get(Calendar.DAY_OF_WEEK);

			SimpleDateFormat formatter = new SimpleDateFormat("EE");
			String text = formatter.format(c1.getTime());
			String s = new String();

			Format formatter1 = new SimpleDateFormat("MM/dd/yyyy");
			s = formatter1.format(date2);

			if (text.equals("Sun")) {

				Format formatter2 = new SimpleDateFormat("MM/dd/yyyy");
				s = formatter2.format(date2);

				sunDayTextField.setText(s);

				for (int i = 2; i <= 7; i++) {

					Calendar calendar2 = Calendar.getInstance();
					calendar2.setTime(date2);
					calendar2.add(calendar2.DAY_OF_YEAR, 1);

					date2 = calendar2.getTime();
					String result2 = formatter2.format(date2);

					switch (i) {
					
					 case 1: sunDayTextField.setText(result2); break;
					 
					case 2:
						monDayTextField.setText(result2);
						break;
					case 3:
						tuesDayTextField.setText(result2);
						break;
					case 4:
						wednesDayTextField.setText(result2);
						break;
					case 5:
						thursDayTextField.setText(result2);
						break;
					case 6:
						friDayTextField.setText(result2);
						break;

					case 7:
						saturDayTextField.setText(result2);
						break;
					}

				}

			} else {

				DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date2);
				calendar.add(Calendar.DAY_OF_YEAR, -(dayOfWeek - 1));

				date2 = calendar.getTime();
				String result = format1.format(date2);

				sunDayTextField.setText(result);

				for (int i = 2; i <= 7; i++) {

					Calendar calendar2 = Calendar.getInstance();
					calendar2.setTime(date2);
					calendar2.add(calendar2.DAY_OF_YEAR, 1);

					date2 = calendar2.getTime();
					String result2 = format1.format(date2);

					switch (i) {
					
					 case 1: sunDayTextField.setText(result2); break;
					 
					case 2:
						monDayTextField.setText(result2);
						break;
					case 3:
						tuesDayTextField.setText(result2);
						break;
					case 4:
						wednesDayTextField.setText(result2);
						break;
					case 5:
						thursDayTextField.setText(result2);
						break;
					case 6:
						friDayTextField.setText(result2);
						break;

					case 7:
						saturDayTextField.setText(result2);
						break;
					}

				}

			}

		}
	}
	
	
	
	
	public void setActiveTime(boolean setActiveTime[],int checkBoxNo){
		System.out.println(" from set inactive functn================");
		if(checkBoxNo==0){
			for(int i=0;i<lengthToGen;i++){
				sundayText[i].setDisable(setActiveTime[i]);
				sundayText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
		if(checkBoxNo==1){
			for(int i=0;i<lengthToGen;i++){
				monText[i].setDisable(setActiveTime[i]);	
				monText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
		if(checkBoxNo==2){
			for(int i=0;i<lengthToGen;i++){
				tuesText[i].setDisable(setActiveTime[i]);
				tuesText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+"and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
		if(checkBoxNo==3){
			for(int i=0;i<lengthToGen;i++){
				wedText[i].setDisable(setActiveTime[i]);	
				wedText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
		if(checkBoxNo==4){
			for(int i=0;i<lengthToGen;i++){
				thursText[i].setDisable(setActiveTime[i]);	
				thursText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
		if(checkBoxNo==5){
			for(int i=0;i<lengthToGen;i++){
				friText[i].setDisable(setActiveTime[i]);
				friText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
			
									
		}
		if(checkBoxNo==6){
			for(int i=0;i<lengthToGen;i++){
				satText[i].setDisable(setActiveTime[i]);
				satText[i].setStyle(null);
				System.out.println("j is "+checkBoxNo+" i "+i+ "and setActiveTime[] "+setActiveTime[i]);
			}
									
		}
	}
	 
		
  boolean activeClinicTimeArr[];
  boolean activeClinicTimeSun[];
  boolean activeClinicTimeMon[];
  boolean activeClinicTimeTues[];
  boolean activeClinicTimeWed[];
  boolean activeClinicTimeThurs[];
  boolean activeClinicTimeFri[];
  boolean activeClinicTimeSat[];
  
   public void setFromClinicSchedule(int length){
	activeClinicTimeArr=new boolean[lengthToGen];
	activeClinicTimeSun=new boolean[lengthToGen];
	activeClinicTimeMon=new boolean[lengthToGen];
	activeClinicTimeTues=new boolean[lengthToGen];
	activeClinicTimeWed=new boolean[lengthToGen];
	activeClinicTimeThurs=new boolean[lengthToGen];
	activeClinicTimeFri=new boolean[lengthToGen];
	activeClinicTimeSat=new boolean[lengthToGen];
	
	
	
		Arrays.fill(activeClinicTimeArr, true);
		Arrays.fill(activeClinicTimeSun, true);
		Arrays.fill(activeClinicTimeMon, true);
		Arrays.fill(activeClinicTimeTues, true);
		Arrays.fill(activeClinicTimeWed, true);
		Arrays.fill(activeClinicTimeThurs, true);
		Arrays.fill(activeClinicTimeFri, true);
		Arrays.fill(activeClinicTimeSat, true);
		
	   
				int openIndex=0;
				int endOfIndex=0;
		
				for(int j=0;j<7;j++){
					try{
					   if(clinicScheduleTimeList.get(j).getOpenTime()!=null && clinicScheduleTimeList.get(j).getCloseTime()!=null){
						 String cliOpen =  clinicScheduleTimeList.get(j).getOpenTime();
						 String cliClos =  clinicScheduleTimeList.get(j).getCloseTime();
						
						
						 openIndex= Arrays.asList(timeSlotString).indexOf(cliOpen);
						 endOfIndex =  Arrays.asList(timeSlotString).indexOf(cliClos);
						
						 
						 if(openIndex==-1){
							String cliOpenAr[] = cliOpen.split(":");
						    
						  /* String timeOpenSt[] = timeSlotString[openIndex].split(":");	
						   Integer.parseInt(timeOpenSt[1]);
							*/ 
						}else if(endOfIndex==-1){
							String cliOCloseAr[] = cliClos.split(":");
						 
						}
				if(j==0){
				
			      Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			      Arrays.fill(activeClinicTimeSun, openIndex, endOfIndex, false);
			      setActiveTime(activeClinicTimeSun,j);
			    
				
				}
			    if(j==1){
			    	  
				      Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
				      Arrays.fill(activeClinicTimeMon, openIndex, endOfIndex, false);
				      setActiveTime(activeClinicTimeMon,j);
				     
			    }
					
			    if(j==2){
			    	  
			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			    	  Arrays.fill(activeClinicTimeTues, openIndex, endOfIndex, false);
				      setActiveTime(activeClinicTimeTues,j);
				     
			 
					}
			    if(j==3){
			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			    	  Arrays.fill(activeClinicTimeWed, openIndex, endOfIndex, false);
				      setActiveTime(activeClinicTimeWed,j);
				     
			  				}
			    if(j==4){
			    	System.out.println("index range  "+openIndex+" "+endOfIndex);
			    	   Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			    	   Arrays.fill(activeClinicTimeThurs, openIndex, endOfIndex, false);
				       setActiveTime(activeClinicTimeThurs,j);
				     
			 
					}
			    if(j==5){
			        	Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			            Arrays.fill(activeClinicTimeFri, openIndex, endOfIndex, false);
				        setActiveTime(activeClinicTimeFri,j);
				        
			  
					}
			    if(j==6){
			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
			    	  Arrays.fill(activeClinicTimeSat, openIndex, endOfIndex, false);
				      setActiveTime(activeClinicTimeSat,j);
			 
			    }
			   
			    endOfIndex=0;
			    openIndex=0;
				}
					else{
						
						
						if(j==0){
							
							 openCheckBoxCollumn1.setSelected(false);
						}
						if(j==1){
							 
							 openCheckBoxCollumn2.setSelected(false);
						}
						if(j==2){
							
							 
							 openCheckBoxCollumn3.setSelected(false);
						}
						if(j==3){
							 
							 openCheckBoxCollumn4.setSelected(false);
						}
						if(j==4){
							 
							 openCheckBoxCollumn5.setSelected(false);
						}
						if(j==5){
							
							 openCheckBoxCollumn6.setSelected(false);
						}
						if(j==6){
							
							 openCheckBoxCollumn7.setSelected(false);
						}
					
				}
		}catch(IllegalArgumentException ex){
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			if(j==0){
				if(openIndex==-1){
					alert.setContentText("Sunday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Sunday finish time is not matching with "
							+ "clinic time slot interval! ");
				}	
			}else if (j==1) {
				if(openIndex==-1){
					alert.setContentText("Monday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Monday finish time is not matching with "
							+ "clinic time slot interval! ");
				}		
			}else if (j==2) {
				if(openIndex==-1){
					alert.setContentText("Tuesday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Tuesday finish time is not matching with "
							+ "clinic time slot interval! ");
				}		
			}else if (j==3) {
				if(openIndex==-1){
					alert.setContentText("Wednesday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Wednesday finish time is not matching with "
							+ "clinic time slot interval! ");
			}
			}
			else if (j==4) {
				if(openIndex==-1){
					alert.setContentText("Thursday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Thursday finish time is not matching with "
							+ "clinic time slot interval! ");	
				}
				}else if (j==5) {
				if(openIndex==-1){
					alert.setContentText("Friday start time is not matching with "
							+ "clinic time slot interval! ");
				}}else if(endOfIndex==-1){
					alert.setContentText("Friday finish time is not matching with "
							+ "clinic time slot interval! ");		
			}else if (j==6) {
				if(openIndex==-1){
					alert.setContentText("Saturday start time is not matching with "
							+ "clinic time slot interval! ");
				}else if(endOfIndex==-1){
					alert.setContentText("Saturday finish time is not matching with "
							+ "clinic time slot interval! ");	
			}
			}
			

			alert.showAndWait();
		}
				
		//setClinicByDate();	
			
		
		
	}}
	public void openCheckBox() {

		openCheckBoxCollumn1.setSelected(true);
		openCheckBoxCollumn2.setSelected(true);
		openCheckBoxCollumn3.setSelected(true);
		openCheckBoxCollumn4.setSelected(true);
		openCheckBoxCollumn5.setSelected(true);
		openCheckBoxCollumn6.setSelected(true);
		openCheckBoxCollumn7.setSelected(true);

	}

	public void closeCheckBox() {

		openCheckBoxCollumn1.setSelected(false);
		openCheckBoxCollumn2.setSelected(false);
		openCheckBoxCollumn3.setSelected(false);
		openCheckBoxCollumn4.setSelected(false);
		openCheckBoxCollumn5.setSelected(false);
		openCheckBoxCollumn6.setSelected(false);
		openCheckBoxCollumn7.setSelected(false);

	}

	public void viewClinicClosedDate() {
		ArrayList<String> dateList = new ArrayList<String>();

		dateList.add(sunDayTextField.getText());
		dateList.add(monDayTextField.getText());
		dateList.add(tuesDayTextField.getText());
		dateList.add(wednesDayTextField.getText());
		dateList.add(thursDayTextField.getText());
		dateList.add(friDayTextField.getText());
		dateList.add(saturDayTextField.getText());

		String str1 = sunDayTextField.getText();
		String str2 = saturDayTextField.getText();
		// check clinic is closed between these date
		list1 = new ClinicClosedEntityController().viewByDate(str1, str2, Global.clinic.getId());

		openCheckBox();

		if (list1.isEmpty()) {
			
			return;
		}

		for (int x = 0; x < list1.size(); x++) {
			for (int j = 0; j < dateList.size(); j++) {
				String listDate = dateList.get(j);
				ClinicClosed cli = list1.get(x);
				
				dbDate = date2String(cli.getScheduledDate());
				
				CheckBox candidate = new CheckBox();
				int checkBoxNo=7;//initialize with 7 bcoz 0 is in condition also
				switch (j) {
				case 0:
					candidate = openCheckBoxCollumn1;
					checkBoxNo=0;
					break;
				case 1:
					candidate = openCheckBoxCollumn2;
					checkBoxNo = 1;
					break;
				case 2:
					candidate = openCheckBoxCollumn3;
					checkBoxNo=2;
					break;
				case 3:
					candidate = openCheckBoxCollumn4;
					checkBoxNo=3;
					break;
				case 4:
					candidate = openCheckBoxCollumn5;
					checkBoxNo=4;
					break;
				case 5:
					candidate = openCheckBoxCollumn6;
					checkBoxNo=5;
					break;
				case 6:
					candidate = openCheckBoxCollumn7;
					checkBoxNo=6;
					break;
				}
				// Clinic Closed ?
				if (dbDate.equals(listDate)) {
					candidate.setSelected(false);
                    Arrays.fill(activeClinicTimeArr, true);
					setActiveTime(activeClinicTimeArr,checkBoxNo);
					
					// break;
				} /*else if (!dirty[j]) { // Clinic Open ?
					candidate.setSelected(true);
					System.out.println(dbDate + "!=" + listDate);
				}*/
				getOpenedCheckBox();
			}
		}
	}
	@FXML
	void dateSelect(ActionEvent event) {
		try {
		
			LocalDate localDate2 = inputDateField.getValue();
			Date date2 = new Date();
			if (localDate2 != null) {
				date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

				Calendar c1 = Calendar.getInstance();
				c1.setTime(date2);
				int dayOfWeek = c1.get(Calendar.DAY_OF_WEEK);
				
				SimpleDateFormat formatter = new SimpleDateFormat("EE");

				String text = formatter.format(c1.getTime());
				
				String s = new String();

				Format formatter1 = new SimpleDateFormat("MM/dd/yyyy");
				s = formatter1.format(date2);
				System.out.println(" s " + s);
				if (text.equals("Sun")) {
					Format formatter2 = new SimpleDateFormat("MM/dd/yyyy");
					s = formatter2.format(date2);
					
					sunDayTextField.setText(s);

					for (int i = 2; i <= 7; i++) {
						Calendar calendar2 = Calendar.getInstance();
						calendar2.setTime(date2);
						calendar2.add(calendar2.DAY_OF_YEAR, 1);

						date2 = calendar2.getTime();
						String result2 = formatter2.format(date2);
						
						switch (i) {
						
						  case 1: sunDayTextField.setText(result2); break;
						 
						case 2:
							monDayTextField.setText(result2);
							break;
						case 3:
							tuesDayTextField.setText(result2);
							break;
						case 4:
							wednesDayTextField.setText(result2);
							break;
						case 5:
							thursDayTextField.setText(result2);
							break;
						case 6:
							friDayTextField.setText(result2);
							break;

						case 7:
							saturDayTextField.setText(result2);
							break;
						}

					}
					 setFromClinicSchedule(lengthToGen);
					
					viewClinicClosedDate();

				} else {

					DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");

					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(date2);

					calendar.add(Calendar.DAY_OF_YEAR, -(dayOfWeek - 1));

					date2 = calendar.getTime();
					
					String result = format1.format(date2);
					

					sunDayTextField.setText(result);

					for (int i = 2; i <= 7; i++) {

						Calendar calendar2 = Calendar.getInstance();
						calendar2.setTime(date2);
						calendar2.add(calendar2.DAY_OF_YEAR, 1);

						date2 = calendar2.getTime();
						String result2 = format1.format(date2);
						System.out.println("result2  " + result2);
						switch (i) {
						
						 case 1: sunDayTextField.setText(result2); break;
						 
						case 2:
							monDayTextField.setText(result2);
							break;
						case 3:
							tuesDayTextField.setText(result2);
							break;
						case 4:
							wednesDayTextField.setText(result2);
							break;
						case 5:
							thursDayTextField.setText(result2);
							break;
						case 6:
							friDayTextField.setText(result2);
							break;

						case 7:
							saturDayTextField.setText(result2);
							break;
						}

					}

				}

			}
			 setFromClinicSchedule(lengthToGen);
			 
			viewClinicClosedDate();
			cliBlockDelete=null;
			
            viewBlockTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}   
	
	
	
	String timeSlotString[];
	public int setByTimeSlot(int selectedSlot){
	String timeSlotStringCopy[] = new String[150];
		Integer iStart = 7;
		Integer iEnd=12;
		Integer timeSolt = selectedSlot;
		Integer timeSoltTemp = timeSolt;
		int currentIndex=0;
		int count=0;
		int maxLength=12;
		int totalSize = 0;
		String str ="AM";
		for(int i=0;maxLength!=0;i=i++){
			
			if(iStart>12){
				str = "PM";
				iStart=1;
				
			}else if(iStart==12){
				
				str = "PM";
				
			}
			timeSlotStringCopy[i]=iStart.toString()+":"+"00 "+str;
			
			int j;
			for(j=1;timeSoltTemp<60;j++){
				if(maxLength!=0){
					timeSlotStringCopy[i+j]=iStart.toString()+":"+timeSoltTemp.toString()+" "+str;
				
				timeSoltTemp=timeSoltTemp+timeSolt;
				currentIndex = j;
				++count;
				
				}else{
					break;
					
				}
				
			}
			
		    timeSoltTemp = timeSolt;
		    iStart++;
			i=currentIndex+i+1;
			currentIndex=0;
			++count;
			
			--maxLength;
			
			if(maxLength==0){
				
				 timeSlotString=Arrays.copyOf(timeSlotStringCopy, i);//excluding extra indexes
				  timeSlotStringCopy=null;
				
				break;
				
			
			
			}
			
		}
	

	      
		
		return timeSlotString.length;
	}
   List<Boolean> getSelectedCheckList = new ArrayList<Boolean>();
	public void getOpenedCheckBox(){
	 
		if(openCheckBoxCollumn1.isSelected()){
			getSelectedCheckList.add(0, true);
		
	    }else
	    	{
	    	getSelectedCheckList.add(0, false);
	    	}
		
		if(openCheckBoxCollumn2.isSelected()){
	    	   getSelectedCheckList.add(1, true);
	  	 }else
		    	{
	  	    	getSelectedCheckList.add(1, false);
	  	    	}
		
	     if(openCheckBoxCollumn3.isSelected()){
	    	  
	    	  getSelectedCheckList.add(2, true);
	  		
	  	      }else
		    	{
		  	     getSelectedCheckList.add(2, false);
		  	   }
	     if(openCheckBoxCollumn4.isSelected()){
	    	  
	    	  getSelectedCheckList.add(3, true);
	  		
	  	      }else
		    	{
			  	     getSelectedCheckList.add(3, false);
			  	}
	     if(openCheckBoxCollumn5.isSelected()){
	    	  
	    	  getSelectedCheckList.add(4, true);
	  		
	  	      }else
		    	{
			  	     getSelectedCheckList.add(4, false);
			  	}
	  	
	     if(openCheckBoxCollumn6.isSelected()){
	    	  
	    	  getSelectedCheckList.add(5, true);
	  		
	  	      }else
		    	{
			  	     getSelectedCheckList.add(5, false);
			  	}
	     if(openCheckBoxCollumn7.isSelected()){
	    	  
	    	  getSelectedCheckList.add(6, true);
	  		
	  	      }else
		    	{
			  	     getSelectedCheckList.add(6, false);
			  	}
	  	
	      }
	
	 List<Date> dateList=new ArrayList<Date>();
	public void viewBlockTime(){
		
		 
		  Date date= string2Date(sunDayTextField.getText());
		  Date date1= string2Date(monDayTextField.getText());
		  Date date2= string2Date(tuesDayTextField.getText());
		  Date date3= string2Date(wednesDayTextField.getText());
		  Date date4=string2Date(thursDayTextField.getText());
		  Date date5= string2Date(friDayTextField.getText());
		  Date date6= string2Date(saturDayTextField.getText());
		  dateList.add(date);
		  dateList.add(date1);
		  dateList.add(date2);
		  dateList.add(date3);
		  dateList.add(date4);
		  dateList.add(date5);
		  dateList.add(date6);
		  int index=0;
		 cliblock =  new ClinicBlockScheduleEntityController().viewByDate(dateList); 
	  
		 for(int i=0;i<cliblock.size();i++){
		 if(cliblock.get(i).getBlockTimeDate().equals(date)){
			
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			 if(index!=-1){
				 sundayText[index].setStyle("-fx-background-color :#E18080");	 
			 }
			
			 
			 
			 
		 }
         if(cliblock.get(i).getBlockTimeDate().equals(date1)){
        	
        	 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
             if(index!=-1){
            	 monText[index].setStyle("-fx-background-color :#E18080"); 
			 }
			
			  
			
			 
		 } if(cliblock.get(i).getBlockTimeDate().equals(date2)){
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			
              if(index!=-1){
            	  tuesText[index].setStyle("-fx-background-color :#E18080");
			 }
			
			 
		 }if(cliblock.get(i).getBlockTimeDate().equals(date3)){
			 
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			
             if(index!=-1){
            	 wedText[index].setStyle("-fx-background-color :#E18080");
			 }
			 
		 }if(cliblock.get(i).getBlockTimeDate().equals(date4)){
			 
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			 
             if(index!=-1){
            	 thursText[index].setStyle("-fx-background-color :#E18080");
			 }
			 
		 }if(cliblock.get(i).getBlockTimeDate().equals(date5)){
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			
            if(index!=-1){
            	 friText[index].setStyle("-fx-background-color :#E18080");
			 }
			
			 
		 }if(cliblock.get(i).getBlockTimeDate().equals(date6)){
			 
			 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
			
            if(index!=-1){
            	 satText[index].setStyle("-fx-background-color :#E18080"); 
			 }
			
		 }
		   
	   }
		
	}
	

	public void closeForm(){
		
		new FXFormCommonUtilities().closeForm(closeButton);
	}


	FXMLFormPath formPath = new FXMLFormPath();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toDaySet();
		
		clinicNameLabel.setText(Global.clinic.getName());
		

		// Set from UI to DB .
		
		saveButton.setOnAction((event) -> {
			List<Date> dateList = new ArrayList<Date>();
			List<Boolean> openDateList = new ArrayList<Boolean>();
			
            if(clinicBlockSchedulesList.size()>0){
            	
            	new ClinicBlockScheduleEntityController().save(clinicBlockSchedulesList);
            	clinicBlockSchedulesList=null;
            }else if(cliBlockDelete.size()>0){
            	
            	new ClinicBlockScheduleEntityController().delete(cliBlockDelete);
            	
            }
			
			if(getSelectedCheckList.size()>0){
			if(openCheckBoxCollumn1.isSelected()!=getSelectedCheckList.get(0)){
				dateList.add(string2Date(sunDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(0));
			}
			if(openCheckBoxCollumn2.isSelected()!=getSelectedCheckList.get(1)){
				
				dateList.add(string2Date(monDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(1));
				
			}
			if(openCheckBoxCollumn3.isSelected()!=getSelectedCheckList.get(2)){
				
				dateList.add(string2Date(tuesDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(2));
			}
           if(openCheckBoxCollumn4.isSelected()!=getSelectedCheckList.get(3)){
				
				dateList.add(string2Date(wednesDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(3));
			}
			
           if(openCheckBoxCollumn5.isSelected()!=getSelectedCheckList.get(4)){
				
				dateList.add(string2Date(thursDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(4));
			}
           
           if(openCheckBoxCollumn6.isSelected()!=getSelectedCheckList.get(5)){
				
				dateList.add(string2Date(friDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(5));
			}
           if(openCheckBoxCollumn7.isSelected()!=getSelectedCheckList.get(6)){
				
				dateList.add(string2Date(saturDayTextField.getText()));
				openDateList.add(getSelectedCheckList.get(6));
			}
          
				/*ArrayList<CheckBox> openStatusGroup = getCheckboxGroup();
			ArrayList<TextField> datePanelGroup = getTextfieldGroup();
		*/	// Set clinic into the clinic Schedule
			
			// Iterate through each checkbox .
			for (int i = 0; i <dateList.size(); i++) {
				   if(openDateList.get(i)==true){
						ClinicClosed clinicClosed = new ClinicClosed();
						clinicClosed.setScheduledDate(dateList.get(i));
						clinicClosed.setClinic(Global.clinic);
						
						new ClinicClosedEntityController().saveOrUpdateNoDuplicate(clinicClosed);
				     }else{
					  new ClinicClosedEntityController().deleteByDate(dateList.get(i));
					 	
				   }
                   
					} }
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Changes saved !");
			alert.setHeaderText(null);
			alert.show();
			getOpenedCheckBox();
			 // End of Check box loop .
		});

		openEntireWeekButton.setOnAction((event) -> {
			try {

				 openCheckBox();
				  for(int i=0;i<lengthToGen;i++){
					    sundayText[i].setDisable(activeClinicTimeSun[i]);
						monText[i].setDisable(activeClinicTimeMon[i]);	
						tuesText[i].setDisable(activeClinicTimeTues[i]);
						wedText[i].setDisable(activeClinicTimeWed[i]);
						thursText[i].setDisable(activeClinicTimeThurs[i]);
						friText[i].setDisable(activeClinicTimeFri[i]);
						satText[i].setDisable(activeClinicTimeSat[i]);
						
					}
				  
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closedEntireWeekButton.setOnAction((event) -> {
			try {

				closeCheckBox();
				
				 for(int i=0;i<lengthToGen;i++){
					    sundayText[i].setDisable(true);
						monText[i].setDisable(true);	
						tuesText[i].setDisable(true);
						wedText[i].setDisable(true);
						thursText[i].setDisable(true);
						friText[i].setDisable(true);
						satText[i].setDisable(true);
						
					} 
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
          addAnotherClinicBtn.setOnAction((event) -> {
    	   
    	   String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			
			formPath.closeApplicationContext();
			
			
    	       ClinicViewController clinicViewController =  
					(ClinicViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
		    
    	       clinicViewController.setClinicScheduleSetUpController(this);
    	       
    	      
    	     
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