package com.ets.controller.gui.staffRecurrenceException;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import com.ets.controller.entity.occurRange.OccurRangeEntityController;
import com.ets.controller.entity.providerSchRecurException.StaffSchRecurExceptionEntityController;
import com.ets.controller.entity.recurPattern.RecurPatternEntityController;
import com.ets.controller.gui.clinicianSchedule.ClinicianScheduleViewController;
import com.ets.controller.gui.clinicianSchedule.ClinicianSelectController;
import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.model.OccurRange;
import com.ets.model.ProviderSchRecurException;
import com.ets.model.RecurPattern;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
 

public class StaffRecurrenceExcpController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Button okButton1;

    @FXML
    private TextField descriptionText;

    @FXML
    private TextField startText;

    @FXML
    private TextField endText;

    @FXML
    private RadioButton dailyRadio;

    @FXML
    private ToggleGroup recurPat;

    @FXML
    private RadioButton weeklyRadio;

    @FXML
    private RadioButton monthlyRadio;

    @FXML
    private AnchorPane recurPatternPane;

    @FXML
    private DatePicker startDate;

    @FXML
    private RadioButton noEndRadio;

    @FXML
    private ToggleGroup rangeOfRecur;

    @FXML
    private RadioButton endAfterOccurenceRadio;

    @FXML
    private RadioButton endByDateRadio;

    @FXML
    private TextField endAfterText;
    
    @FXML
    void endAfterClick(MouseEvent event) {
    	endAfterOccurenceRadio.setSelected(true);
    }

   
    @FXML
    void endByDateSetOnaction(ActionEvent event) {
    	
    	endByDateRadio.setSelected(true);
    }
    @FXML
    private DatePicker endByDate;
	
	   
	   RadioButton radio1 = new RadioButton();
	   RadioButton radio2 = new RadioButton();
	   TextField txt = new TextField();
	   TextField txt2 = new TextField();
	   TextField monthText = new TextField();
	   Label days = new Label("day(s)");
	   CheckBox sun = new CheckBox();
	   CheckBox mon = new CheckBox();
	   CheckBox tues = new CheckBox();
	   CheckBox wed = new CheckBox();
	   CheckBox thurs = new CheckBox();
	   CheckBox fri = new CheckBox();
	   CheckBox sat = new CheckBox();
	   Label lb = new Label("months(s)");
	   Label lb4 = new Label("months(s)");
	   Label	lb1 = new Label();
       Label lb3 = new Label("of every");
	   ChoiceBox<String> mnthlyChoiceBox = new ChoiceBox<String>();
	   ChoiceBox<String> mnthlyDayChoiceBox = new ChoiceBox<String>();
	   private ObservableList<String> ob= FXCollections.observableArrayList();
	   private ObservableList<String> ob2= FXCollections.observableArrayList();
	
	   public void dailyComponents(){
		 //remove if components exists
			 recurPatternPane.getChildren().removeAll(radio1,txt,days,sun,mon,tues,wed,thurs,fri,sat);
			 recurPatternPane.getChildren().removeAll(radio1,txt,lb1,txt2,lb,radio2,mnthlyChoiceBox,mnthlyDayChoiceBox,lb3,monthText,lb4);
			 
			 radio1.setText("Every");
			 radio1.setId("everyAfterRadio");
			 days = new Label("day(s)");
			 radio2.setText("Every Weekday");
			 radio2.setId("everyWeekRadio");
			 
			 ToggleGroup tg = new ToggleGroup();
			 radio1.setToggleGroup(tg);
			 radio1.setLayoutX(24);
		     radio1.setLayoutY(9);
			 radio2.setToggleGroup(tg);
			 radio2.setLayoutX(24);
		     radio2.setLayoutY(38);
			 txt.setPrefHeight(20);
			 txt.setPrefWidth(50);
			 txt.setId("everyAfterTxt");
			 txt.setLayoutX(74);
			 txt.setLayoutY(7);
			 days.setLayoutX(133);
			 days.setLayoutY(10);
			
			 
			 recurPatternPane.getChildren().addAll(radio1,txt,days,radio2);
			
			/* recurPatternPane.setLeftAnchor(txt, 100.0);
			
			 recurPatternPane.setLeftAnchor(days, 150.0);*/
			
			 
			// recurPatternTitlePane.getChildrenUnmodifiable().add(everyAfterTxt);
			/* recurPatternTitlePane.setContent(everyAfter);
			 recurPatternTitlePane.setContent(everyAfterTxt);
			 recurPatternTitlePane.setContent(days);
			*/   
	   }
	   
	   @FXML
	    void dailySetOnAction(ActionEvent event) {
		   dailyComponents();
		 
	    }
	 
	  public void monthlyComponents(){
		//remove if components exists
	    	recurPatternPane.getChildren().removeAll(radio1,txt,days,radio2);
	        recurPatternPane.getChildren().removeAll(radio1,txt,days,sun,mon,tues,wed,thurs,fri,sat);
	        ToggleGroup tg = new ToggleGroup();
	        radio1.setText("Day");
	        radio1.setToggleGroup(tg);
	        radio1.setLayoutX(8);
	        radio1.setLayoutY(9);
	        radio2.setText("The");
	        radio2.setToggleGroup(tg);
	        radio2.setLayoutX(8);
	        radio2.setLayoutY(45);
	        txt.setPrefHeight(20);
			txt.setPrefWidth(50);
			txt.setId("dayOfMonth");
			txt.setLayoutX(50);
			txt.setLayoutY(5);
	    	
	    	lb1.setText("of every ");
	    	lb1.setLayoutX(110);
	    	lb1.setLayoutY(9);
			txt2.setPrefHeight(20);
			txt2.setPrefWidth(50);
			txt2.setLayoutX(160);
			txt2.setLayoutY(5);
			
			lb.setLayoutX(220);
			lb.setLayoutY(9);
	    	List<String> list = new ArrayList<String>();
	    	List<String> list2 = new ArrayList<String>();
	    	
	    	list.add("1st");
	    	list.add("2nd");
	    	list.add("3rd");
	    	list.add("4th");
	    	list.add("Last");
	    	
	    	ob=FXCollections.observableArrayList(list);
	    	mnthlyChoiceBox.setItems(ob);
	    	mnthlyChoiceBox.setLayoutX(65);
	    	mnthlyChoiceBox.setLayoutY(39);
	    	
	    	list2.add("Day");
	    	list2.add("Weekday");
	    	list2.add("Weekend Day");
	    	list2.add("Sunday");
	    	list2.add("Monday");
	    	list2.add("Tuesday");
	    	list2.add("Wednesday");
	    	list2.add("Thursday");
	    	list2.add("Friday");
	    	list2.add("Saturday");
	    	
	    	ob2=FXCollections.observableArrayList(list2);
	    	mnthlyDayChoiceBox.setItems(ob2);
	    	mnthlyDayChoiceBox.setLayoutX(130);
	    	mnthlyDayChoiceBox.setLayoutY(39);
	    	
	    	lb3.setLayoutX(240);
	    	lb3.setLayoutY(46);
	    	monthText.setPrefHeight(20);
	    	monthText.setPrefWidth(50);
	    	monthText.setLayoutX(290);
	    	monthText.setLayoutY(41);
	    
	    	lb4.setLayoutX(345);
	    	lb4.setLayoutY(46);
	    	
	    	 recurPatternPane.getChildren().addAll(radio1,txt,lb1,txt2,lb,radio2,mnthlyChoiceBox,mnthlyDayChoiceBox,lb3,monthText,lb4);  
	  }
	    @FXML
	    void monthlySetOnAction(ActionEvent event) {
	    	monthlyComponents();
	    }

	    
	    
	    public void weeklyComponents(){
	    	//remove if components exists
	    	recurPatternPane.getChildren().removeAll(radio1,txt,days,radio2);
	    	 recurPatternPane.getChildren().removeAll(radio1,txt,lb1,txt2,lb,radio2,mnthlyChoiceBox,mnthlyDayChoiceBox,lb3,monthText,lb4);
	    	 radio1.setText("Every");
			 radio1.setId("everyAfterRadio");
			 txt.setPrefHeight(20);
			 txt.setPrefWidth(50);
			 txt.setId("everyAfterTxt");
			 days = new Label(" week(s) on:");
			 
			 sun.setId("sunCheck");
			 sun.setLayoutX(27);
			 sun.setLayoutY(29);
			 sun.setText("Sunday");
			 
			 mon.setId("monCheck");
			 mon.setText("Monday");
			 mon.setLayoutX(113);
			 mon.setLayoutY(29);
			 tues.setId("tuesCheck");
			 tues.setText("Tuesday");
			 tues.setLayoutX(205);
			 tues.setLayoutY(29);
			 
			 wed.setId("wedCheck");
			 wed.setText("Wednesday");
			 wed.setLayoutX(294);
			 wed.setLayoutY(29);
			 
			 thurs.setId("thursCheck");
			 thurs.setText("Thursday");
			 thurs.setLayoutX(27);
			 thurs.setLayoutY(53);
			 
			 fri.setId("friCheck");
			 fri.setText("Friday");
			 fri.setLayoutX(113);
			 fri.setLayoutY(53);
			 
			 sat.setId("satCheck");
			 sat.setText("Saturday");
			 sat.setLayoutX(205);
			 sat.setLayoutY(53);
			 txt.setLayoutX(74);
			 txt.setLayoutY(7);
			 days.setLayoutX(133);
			 days.setLayoutY(10);
			 radio1.setLayoutX(24);
			 radio1.setLayoutY(9);
			 recurPatternPane.getChildren().addAll(radio1,txt,days,sun,mon,tues,wed,thurs,fri,sat);
			
	    }
	    @FXML
	    void weeklySetOnAction(ActionEvent event) {
	    	
	    	weeklyComponents();
			 
	    }

	private StaffRecurrenceExcpViewController staffRecurrenceExcpViewController;

	public void setStaffRecurrenceExcpViewController(StaffRecurrenceExcpViewController staffRecurrenceExcpViewController) {
		this.staffRecurrenceExcpViewController = staffRecurrenceExcpViewController;
	}
	

	private ProviderSchRecurException providerSchRecurExceptionObj;
	
	public void setStaffRecurrenceExcpViewController(StaffRecurrenceExcpViewController staffRecurrenceExcpViewController,ProviderSchRecurException providerSchRecurException) {
		this.staffRecurrenceExcpViewController = staffRecurrenceExcpViewController;
		this.providerSchRecurExceptionObj = providerSchRecurException;
		descriptionText.setText(providerSchRecurException.getOccurRange().getDescrp());
		startText.setText(providerSchRecurException.getOccurRange().getBlockedStartTime());
	    endText.setText(providerSchRecurException.getOccurRange().getBlockedEndTime());
	   
	    Date dateUt = providerSchRecurException.getOccurRange().getStartDate();
	  
	    if(dateUt!=null){
	    LocalDate localDate = new DateConvert().dateToLocalDate(dateUt);
	    startDate.setValue(localDate); 
	    
	    }
	   
	   
	    if(providerSchRecurException.getOccurRange().getEndByDate()!=null){
	    	 Date dateEndUt = providerSchRecurException.getOccurRange().getEndByDate();
	    	 endByDateRadio.setSelected(true);
	    	 LocalDate localDate = new DateConvert().dateToLocalDate(dateEndUt);  
	         endByDate.setValue(localDate);
	    }
	    if(providerSchRecurException.getOccurRange().getEndAfter()!=null&&providerSchRecurException.getOccurRange().getEndAfter()!=""){
	    	endAfterOccurenceRadio.setSelected(true);
	        endAfterText.setText(providerSchRecurException.getOccurRange().getEndAfter());
	       
	        LocalDate localDateEndBy = new DateConvert().dateToLocalDate(providerSchRecurException.getOccurRange().getEndByDate()); 
	        endByDate.setValue(localDateEndBy);
	    
	    }
	    if(providerSchRecurException.getOccurRange().getNoEndDate()==true)
	      {	
		   noEndRadio.setSelected(true);
		   
	      }
	    
	    if(providerSchRecurException.getRecurPattern().getDailyRecur()==true){
	    	dailyComponents();
	    	dailyRadio.setSelected(true);
	    	
			if(providerSchRecurException.getRecurPattern().getAfterEvery()!=null){
				radio1.setSelected(true);
				txt.setText(providerSchRecurException.getRecurPattern().getAfterEvery());
			}
			if(providerSchRecurException.getRecurPattern().getEveryWeekDay()==true){
				radio2.setSelected(true);
				
			}
	    }
	    
	    if(providerSchRecurException.getRecurPattern().getWeeklyRecur()==true){
	    	weeklyComponents();
	    	weeklyRadio.setSelected(true);
	    	if(providerSchRecurException.getRecurPattern().getAfterEvery()!=null){
				radio1.setSelected(true);
				txt.setText(providerSchRecurException.getRecurPattern().getAfterEvery());
	    	}
			if(providerSchRecurException.getRecurPattern().getSunday()==true){
				sun.setSelected(true);
			}
			if(providerSchRecurException.getRecurPattern().getMonday()==true){
				mon.setSelected(true);	
			}
			if(providerSchRecurException.getRecurPattern().getTuesday()==true){
				tues.setSelected(true);	
			}
			if(providerSchRecurException.getRecurPattern().getWednesday()==true){
				wed.setSelected(true);	
			}
			if(providerSchRecurException.getRecurPattern().getThursday()==true){
				thurs.setSelected(true);	
			}
			if(providerSchRecurException.getRecurPattern().getFriday()==true){
				fri.setSelected(true);	
			}
			if(providerSchRecurException.getRecurPattern().getSaturday()==true){
				sat.setSelected(true);	
			}
			
			
	    }
	    
	    
	    if(providerSchRecurException.getRecurPattern().getMonthlyRecur()==true){
	    	 monthlyComponents();
	    	 monthlyRadio.setSelected(true);
	    	 if(providerSchRecurException.getRecurPattern().getRecurDayAfterEveryMonth()==true){
				 radio1.setSelected(true);
				 txt.setText(providerSchRecurException.getRecurPattern().getDayOfMonth());
				 txt2.setText(providerSchRecurException.getRecurPattern().getRecurAfterEveryMonth().toString());
				 
	    	 }
	    	 if(providerSchRecurException.getRecurPattern().getRecurWeekDayEveryMonth()==true){
	    	     radio2.setSelected(true);
	    	     mnthlyChoiceBox.setValue(providerSchRecurException.getRecurPattern().getWeekOfMonth());
	    	     mnthlyDayChoiceBox.setValue(providerSchRecurException.getRecurPattern().getWeekDayOfMonth());
	    	     monthText.setText(providerSchRecurException.getRecurPattern().getDayOfMonth());
	    		
	    	 }
	    }
	
	}
	
 public LocalDate  findEndDateForOccurence(){
	 int temp = Integer.parseInt(endAfterText.getText());
		
		LocalDate startDate2 = startDate.getValue();
		LocalDate startDateOcur = null;
		//Date date1 = Date.from(.atStartOfDay(ZoneId.systemDefault()).toInstant());
		if(dailyRadio.isSelected()){
			if(radio1.isSelected()){
			int ocur = 0;	
			int ocurAfter = Integer.parseInt(txt.getText());
				
			 while(ocur<temp){
				 if(ocur==0){
					 startDateOcur= startDate2;
				 }else{
					 startDateOcur = startDateOcur.plusDays(ocurAfter);  
				 }
			   
			     ++ocur;
			     System.out.println(startDateOcur);
			   } 
			 endByDate.setValue(startDateOcur);
			}
			
			if(radio2.isSelected()){
				int ocur = 0;	
				int ocurAfter = 1;
					
				 while(ocur<temp){
					 if(ocur==0){
						 startDateOcur= startDate2;
					 }else{
						 if(startDateOcur.getDayOfWeek()==DayOfWeek.FRIDAY){//weekend
							 startDateOcur = startDateOcur.plusDays(2);  
						   }
					        startDateOcur = startDateOcur.plusDays(ocurAfter);  
							   
					 }
					  
				     ++ocur;
				     System.out.println(startDateOcur);
				   } 
				 endByDate.setValue(startDateOcur);
				
			}
			
		}
		if(weeklyRadio.isSelected()){
			
			if(radio1.isSelected()){
				int ocur = 0;	
				int ocurAfter=0;
				if(txt.getText()!=null){
					ocurAfter = Integer.parseInt(txt.getText());
				LocalDate selectedDay = null;
				 while(ocur<temp){
					 if(ocur==0){
						 startDateOcur= startDate2;
						 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7);
				    	 System.out.println("############## sat "+selectedDay+"%%%%%%% "+startDateOcur);		 
				    
					 }else{
						
						startDateOcur = startDateOcur.plusWeeks(ocurAfter); 
						 
					     if(mon.isSelected()){
					    
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 2);
					    	 System.out.println("############## mon "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    	
					    }
					     if(tues.isSelected()){
					    	 if(selectedDay.isEqual(startDateOcur)){
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 3);
					    	 System.out.println("############## tues "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    	 }
					    }
					     if(wed.isSelected()){
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 4);
					    	 System.out.println("############## wed "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    
					    }	 
					     if(thurs.isSelected()){
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 5);
					    	 System.out.println("############## thurs "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    
					    }	if(fri.isSelected()){
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 6);
					    	 System.out.println("############## fri "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    
					    }	
					    if(sat.isSelected()){
					    	 selectedDay= startDateOcur.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7);
					    	 System.out.println("############## sat "+selectedDay+"%%%%%%% "+startDateOcur);		 
					    
					    }	
					 }
				   
				     ++ocur;
				    
				   } 
				 endByDate.setValue(startDateOcur);
				}
			}
			
		}
		
		if(monthlyRadio.isSelected()){
			LocalDate selectedDay = null;
			if(radio1.isSelected()){
				if(txt.getText()!=null && txt2.getText()!=null){
					
					int ocur = 0;	
					
				     while(ocur<temp){
						 if(ocur==0){
							 
							 startDateOcur= startDate2;
							 selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),Integer.parseInt(txt.getText()));
							  if(startDate2.compareTo(selectedDay)>0){
								  startDateOcur = startDateOcur.plusMonths(Integer.parseInt(txt2.getText()));
								  selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),Integer.parseInt(txt.getText()));
							   }
							 
						 }else{
							     startDateOcur = startDateOcur.plusMonths(Integer.parseInt(txt2.getText()));
							     selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),Integer.parseInt(txt.getText()));
						
						 }
					   
					     ++ocur;
					     
					   } 	
				     startDateOcur=selectedDay;
				     
			    }
				
			}
			if(radio2.isSelected()){
				
	    		 int weekNo=0;
					if(monthText.getText()!=null&&mnthlyChoiceBox.getSelectionModel().isEmpty()==false&&mnthlyDayChoiceBox.getSelectionModel().isEmpty()==false){
						
						int ocur = 0;	
						int ocurAfter = Integer.parseInt(monthText.getText());
						selectedDay=null;
						DayOfWeek mnthlyDayofWeek = null;
						
						if(mnthlyChoiceBox.getSelectionModel().getSelectedItem().equals("1st")){
							weekNo=1;
						}else if(mnthlyChoiceBox.getSelectionModel().getSelectedItem().equals("2nd")){
							weekNo=2;
						}else if(mnthlyChoiceBox.getSelectionModel().getSelectedItem().equals("3rd")){
							weekNo=3;
						}
						else if(mnthlyChoiceBox.getSelectionModel().getSelectedItem().equals("4th")){
							weekNo=4;
						}
						else if(mnthlyChoiceBox.getSelectionModel().getSelectedItem().equals("Last")){
							weekNo=5;
						}
						
						if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Sunday")){
							mnthlyDayofWeek = DayOfWeek.SUNDAY;
						}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Monday")){
							
							mnthlyDayofWeek = DayOfWeek.MONDAY;
						}
						else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Tuesday")){
							
							mnthlyDayofWeek = DayOfWeek.TUESDAY;
						}
                       else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Wednesday")){
							
							mnthlyDayofWeek = DayOfWeek.WEDNESDAY;
						}
                       else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Thursday")){
							
							mnthlyDayofWeek = DayOfWeek.THURSDAY;
						} else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Friday")){
							
							mnthlyDayofWeek = DayOfWeek.FRIDAY;
						}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Saturday")){
							
							mnthlyDayofWeek = DayOfWeek.SATURDAY;
						}
						
						
					     while(ocur<temp){
							 if(ocur==0){
								 startDateOcur= startDate2;
								 if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Day")){
									if(weekNo==5){//last day
										 //selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),weekNo);
										 
										 selectedDay = startDateOcur.with(TemporalAdjusters.lastDayOfMonth());
										
									}else{
									      selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),weekNo);
									  if(startDate2.compareTo(selectedDay)>0){
										  startDateOcur = startDateOcur.plusMonths(Integer.parseInt(monthText.getText()));
										  selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),weekNo);
									   }
									}
									 // selectedDay = 	startDateOcur.with(TemporalAdjusters.lastDayOfMonth());
									
									 
								}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Weekday")){
										if(weekNo==5){
											selectedDay = 	startDateOcur.with(TemporalAdjusters.lastDayOfMonth());
											if(selectedDay.getDayOfWeek()==DayOfWeek.SUNDAY){
												selectedDay=selectedDay.minusDays(1);
											}	
										}else{
											 selectedDay = startDateOcur.of(startDateOcur.getYear(), startDateOcur.getMonth(),weekNo);	
											if(selectedDay.getDayOfWeek()==DayOfWeek.SUNDAY){
												selectedDay=selectedDay.plusDays(1);
											}	
										}
									
									
								}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Weekend Day")){
										
										selectedDay = startDateOcur.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, DayOfWeek.SUNDAY));
										
										if(selectedDay.getDayOfWeek()!=DayOfWeek.SUNDAY){
											selectedDay=selectedDay.plusMonths(Integer.parseInt(monthText.getText()));
										}	
									
								
								
							   }else{
								    
								    selectedDay = startDateOcur.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, mnthlyDayofWeek));
								
								   if(startDateOcur.compareTo(selectedDay)>0){
									  startDateOcur = startDateOcur.plusMonths(ocurAfter);
									  selectedDay = startDateOcur.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, mnthlyDayofWeek));
								   }
							  }
								 
							 }else{
								 if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Day")){
									if(weekNo==5){
										selectedDay=selectedDay.plusMonths(Integer.parseInt(monthText.getText()));
										selectedDay = selectedDay.with(TemporalAdjusters.lastDayOfMonth());	
										
									}else{
									 startDateOcur = startDateOcur.plusMonths(Integer.parseInt(monthText.getText()));
									 selectedDay = selectedDay.of(startDateOcur.getYear(), startDateOcur.getMonth(),weekNo);	
									}
									 
								}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Weekday")){
									if(weekNo==5){
										 selectedDay = selectedDay.plusMonths(ocurAfter);
										 selectedDay = 	selectedDay.with(TemporalAdjusters.lastDayOfMonth());
										if(selectedDay.getDayOfWeek()==DayOfWeek.SUNDAY){
											selectedDay=selectedDay.minusDays(1);
										}
									}else{
										 selectedDay = selectedDay.plusMonths(ocurAfter);
										//selectedDay = 	selectedDay.with(TemporalAdjusters.firstDayOfMonth());
										 selectedDay = selectedDay.of(selectedDay.getYear(), startDateOcur.getMonth(),weekNo);	
										if(selectedDay.getDayOfWeek()==DayOfWeek.SUNDAY){
											selectedDay=selectedDay.plusDays(1);
										}	
									}
									
								
									
								}else if(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem().equals("Weekend Day")){
									selectedDay=selectedDay.plusMonths(Integer.parseInt(monthText.getText()));
									selectedDay = selectedDay.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, DayOfWeek.SUNDAY));
									
									if(selectedDay.getDayOfWeek()!=DayOfWeek.SUNDAY){
										selectedDay=selectedDay.plusMonths(Integer.parseInt(monthText.getText()));
									}
								
									
									/*selectedDay = startDateOcur.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, DayOfWeek.SUNDAY));
									
									if(selectedDay.getDayOfWeek()!=DayOfWeek.SUNDAY){
										selectedDay=selectedDay.plusMonths(Integer.parseInt(monthText.getText()));
									}	*/
								
							   }else{
								    startDateOcur = startDateOcur.plusMonths(ocurAfter);
								    selectedDay = startDateOcur.with(TemporalAdjusters.dayOfWeekInMonth(weekNo, mnthlyDayofWeek));
							 }
							 }
						   
						     ++ocur;
						   } 	
					     startDateOcur=selectedDay;
				    }
				
				
			}
			endByDate.setValue(startDateOcur);
		}
		return startDateOcur;
	
 }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		okButton1.setOnAction((event) -> {
			ProviderSchRecurException providerSchRecurException = new ProviderSchRecurException();
			
			OccurRange occurRange = new OccurRange();
			occurRange.setDescrp(descriptionText.getText());
			occurRange.setBlockedStartTime(startText.getText());
			occurRange.setBlockedEndTime(endText.getText());
			Date date = Date.from(startDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			occurRange.setStartDate(date);
			if(noEndRadio.isSelected()){
				occurRange.setNoEndDate(true);
			}else{
				occurRange.setNoEndDate(false);
			}
			if(endAfterOccurenceRadio.isSelected()){
				occurRange.setEndAfter(endAfterText.getText());
				LocalDate ld= findEndDateForOccurence();
				Date date1 = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
				occurRange.setEndByDate(date1);
			}
			
			if(endByDateRadio.isSelected()){
				Date date1 = Date.from(endByDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				occurRange.setEndByDate(date1);
				
			}
			if(providerSchRecurExceptionObj!=null){
				
				occurRange.setId(providerSchRecurExceptionObj.getOccurRange().getId());
			}
			new OccurRangeEntityController().saveOrUpdate(occurRange);
			
			providerSchRecurException.setOccurRange(occurRange);
			
			RecurPattern recurPattern = new RecurPattern();
			if(dailyRadio.isSelected()){
				recurPattern.setDailyRecur(true);
				if(radio1.isSelected()){
					recurPattern.setAfterEvery(txt.getText());
					
				}
				if(radio2.isSelected()){
					recurPattern.setEveryWeekDay(true);
					
				}
				
			}
			if(weeklyRadio.isSelected()){
				recurPattern.setWeeklyRecur(true);
				
				if(radio1.isSelected()){
					recurPattern.setAfterEvery(txt.getText());
				}
				if(sun.isSelected()){
					
					recurPattern.setSunday(true);
				}
				if(mon.isSelected()){
					recurPattern.setMonday(true);	
				}
				if(tues.isSelected()){
					recurPattern.setTuesday(true);	
				}	
				if(wed.isSelected()){
					recurPattern.setWednesday(true);	
				}	
				if(thurs.isSelected()){
					recurPattern.setThursday(true);	
				}
				if(fri.isSelected()){
					recurPattern.setFriday(true);	
				}
				if(sat.isSelected()){
					recurPattern.setSaturday(true);	
				}
				
				
				
				
			}
			if(monthlyRadio.isSelected()){
				recurPattern.setMonthlyRecur(true);
				
				 if(radio1.isSelected()){
					 recurPattern.setRecurDayAfterEveryMonth(true);
					 recurPattern.setDayOfMonth(txt.getText());
					 recurPattern.setRecurAfterEveryMonth(Integer.parseInt(txt2.getText()));
					 
		    	 }
		    	 if(radio2.isSelected()){
		    	     recurPattern.setRecurWeekDayEveryMonth(true); 
		    		 recurPattern.setWeekOfMonth(mnthlyChoiceBox.getSelectionModel().getSelectedItem()); 
		    		 recurPattern.setWeekDayOfMonth(mnthlyDayChoiceBox.getSelectionModel().getSelectedItem());
		    		 recurPattern.setDayOfMonth(monthText.getText());
		    	 }
		    	 
			}
             if(providerSchRecurExceptionObj!=null){
				
            	 recurPattern.setId(providerSchRecurExceptionObj.getRecurPattern().getId());
			}
			
			new RecurPatternEntityController().saveOrUpdate(recurPattern);
			providerSchRecurException.setRecurPattern(recurPattern);
			providerSchRecurException.setProvider(SchedulingViewController.provider);
			if(staffRecurrenceExcpViewController.clinicianScheduleViewController!=null){
				providerSchRecurException.setClinician(ClinicianSelectController.clinician);
			}
			if(staffRecurrenceExcpViewController.schedulingViewController!=null){
				providerSchRecurException.setProvider(SchedulingViewController.provider);
				
			}
			  if(providerSchRecurExceptionObj!=null){
				  providerSchRecurException.setId(providerSchRecurExceptionObj.getId());
				}
			  
			new StaffSchRecurExceptionEntityController().saveOrUpdate(providerSchRecurException);
			staffRecurrenceExcpViewController.view();
			new FXFormCommonUtilities().closeForm(okButton1);
			
		});
		
		cancelButton.setOnAction((event) -> {
			
			new FXFormCommonUtilities().closeForm(cancelButton);
		});
	}

}
