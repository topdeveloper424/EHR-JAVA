package com.ets.controller.gui.clinicianBlockSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.clinicianDaysBlockTime.ClinicianDaysBlockTimeEntityController;
import com.ets.controller.entity.providerDaysBlockTime.ProviderDaysBlockTimeEntityController;
import com.ets.controller.gui.clinicianSchedule.ClinicianScheduleViewController;
import com.ets.controller.gui.clinicianSchedule.ClinicianSelectController;
import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.model.ClinicSchedule;
import com.ets.model.ClinicianDaysBlockTime;
import com.ets.model.ClinicianSchedule;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.model.ProviderSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ClinicianBlockSchedule implements Initializable {
	 @FXML
	    private ScrollPane scrollPaneTime;
	    @FXML
	    private Label timeLabel;
	    @FXML
	    private GridPane timeSlotGrid;

	    @FXML
	    private Label startTimeText;

	    @FXML
	    private Label endTimeText;

	    @FXML
	    private Label dayText;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private Button cancelButton;

	    
	   	private ClinicianScheduleViewController clinicianScheduleViewController;
	 
	       List<ClinicianDaysBlockTime> clinicianBlockTimesList = new ArrayList<ClinicianDaysBlockTime>();
	       List<ClinicianDaysBlockTime> clinicianBlockTimesDelete = new ArrayList<ClinicianDaysBlockTime>();
	       public void onClickBlockTime(Label blockedTextField,String startTime){
	       	
	       		if(blockedTextField.getStyle().equals("")){
	       		blockedTextField.setStyle("-fx-background-color: #CA1207;");
	       		ClinicianDaysBlockTime clinicianDaysBlockTime = new ClinicianDaysBlockTime();
	       		
	       		clinicianDaysBlockTime.setWeekday(clinicianSchedule.getWeekday());
	       		clinicianDaysBlockTime.setStartTime(startTime);
	       		clinicianDaysBlockTime.setClinician(ClinicianSelectController.clinician);
	       		//providerDaysBlockTime.setEndTime(endTime);
	       		
	       		clinicianDaysBlockTime.setWeekday(clinicianSchedule.getWeekday());
	       	
	       		//providerDaysBlockTime.setEndTime(endTime);
	       		
	       		clinicianBlockTimesList.add(clinicianDaysBlockTime);
	       	
	       	   }  
	       	  	else{
	       		blockedTextField.setStyle(null);	
	       		if(clinicianDaysBlockTimes!=null){
	       		for(int i=0;i<clinicianDaysBlockTimes.size();i++){
	       			int index =	Arrays.asList(clinicianDaysBlockTimes.get(i).getStartTime()).indexOf(startTime);
	       			if(index!=-1){
	       				clinicianBlockTimesDelete.add(clinicianDaysBlockTimes.get(i));
	       			}
	       		
	       		}
	       		}
	       		if(clinicianBlockTimesList!=null){
	       		for(int i=0;i<clinicianBlockTimesList.size();i++){
	       			int index = clinicianBlockTimesList.get(i).getStartTime().indexOf(startTime);
	       			if(index!=-1){
	       				clinicianBlockTimesDelete.add(clinicianBlockTimesList.get(i));
	       			}
	       		}
	       		}
	       		
	       		
	       	}
	     	
	       }
	   	
	       int timeSlot=0;
	       List<ClinicSchedule>  clinicScheduleDataList;
	       private  ClinicianSchedule clinicianSchedule;
	    	public void setClinicianScheduleViewController(ClinicianScheduleViewController clinicianScheduleViewController,ClinicianSchedule clinicianSchedule) {
	   		this.clinicianScheduleViewController = clinicianScheduleViewController;
	   		this.clinicianSchedule = clinicianSchedule;
	   		System.out.println(clinicianSchedule.getOpenTime()+" la la la "+clinicianSchedule.getCloseTime());
	   		loadSlots();
	   		getClinicianDaysView();
	   		
	   	}
	   	String timeSlotString[];
	   	public int setByTimeSlot(int selectedSlot){
	   		String timeSlotStringCopy[] = new String[150];
	   		String s1[] = clinicianSchedule.getOpenTime().split(":");
	   		String s2[] = clinicianSchedule.getCloseTime().split(":");
	   		
	   			Integer iStart = Integer.parseInt(s1[0]);
	   			Integer iEnd=Integer.parseInt(s2[0]);
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

	   	List<ClinicianDaysBlockTime> clinicianDaysBlockTimes =null;
	   	public void getClinicianDaysView(){
	   	 clinicianDaysBlockTimes=new ClinicianDaysBlockTimeEntityController().viewClinicianScheduleById(ClinicianSelectController.clinician, clinicianSchedule.getWeekday());
	   		System.out.println("########### "+ClinicianSelectController.clinician.getId()+" "+clinicianDaysBlockTimes.size()+" "+clinicianSchedule.getWeekday());
	   		if(clinicianDaysBlockTimes!=null){
	   			for(int i=0;i<clinicianDaysBlockTimes.size();i++){
	   			int index =	Arrays.asList(timeSlotString).indexOf(clinicianDaysBlockTimes.get(i).getStartTime());
	   			if(index!=-1){
	   			timeSlotlb[index].setStyle("-fx-background-color: #CA1207;");
	   			}}
	   			
	   		}
	   		
	   	}
	    Label[] timeSlotlb;
	    public void loadSlots(){
	    	 int lengthToGen = setByTimeSlot(timeSlot);
	  		  timeSlotlb = new Label[lengthToGen];
	  		   
	  		for(int i=0;i<lengthToGen;i++){
	  		timeSlotlb[i]=new Label(timeSlotString[i]);
	  		timeSlotlb[i].setAlignment(Pos.CENTER);
	  		timeSlotlb[i].setPrefHeight(1000);
	  		timeSlotlb[i].setPrefWidth(900);
	  		
	  		timeSlotlb[i].setId("timeSlot"+Integer.toString(i));
	  		int m=i;
	  		
	  		
	  		
	  		
	  		timeSlotlb[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
	  			
	  		    public void handle(MouseEvent me) {
	  		    	if (me.getClickCount() == 2) {
	  		    	onClickBlockTime(timeSlotlb[m],timeSlotString[m]);
	  		    	
	  		    	}
	  		    	if (me.getClickCount() == 1) {
	  		    		startTimeText.setText(clinicianSchedule.getOpenTime());
	  		    		endTimeText.setText(clinicianSchedule.getCloseTime());
	  		    		timeLabel.setText(timeSlotString[m]);//timeSlotlb[i]
	  			    }
	  		    }
	  		});
	  		
	  		
	  		//timeSlotlb[i].setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
	  		/*timeSlotlb[i].addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>()
	    	    {
	    	        @Override
	    	        public void handle(KeyEvent e)
	    	        {
	    	            if (keyShiftTab.match(e))
	    	            {
	    	               System.out.println("###################");
	    	                e.consume();
	    	            }
	    	        }
	    	    });*/
	  		
	  		timeSlotGrid.add(timeSlotlb[i], 0, i);
	  		
	  	}

	  		scrollPaneTime.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
	  		scrollPaneTime.setHbarPolicy(ScrollBarPolicy.NEVER);
	  		
	    }
	    
	    
	   	@Override
	   	public void initialize(URL location, ResourceBundle resources) {
	   		
	   		 clinicScheduleDataList = new ClinicScheduleEntityController().viewClinicScheduleByClinicId(Global.clinic.getId());
	   		 timeSlot = Integer.parseInt(clinicScheduleDataList.get(0).getTimeslotSize());
	   		 
	   		 saveButton.setOnAction((event) -> {
	   			if(clinicianBlockTimesList!=null){
	   			   new ClinicianDaysBlockTimeEntityController().saveOrUpdate(clinicianBlockTimesList);
	   			clinicianBlockTimesList = null;
	   			}
	   			
	   			if(clinicianBlockTimesDelete!=null){
	   			
	   			  new ClinicianDaysBlockTimeEntityController().deleteBlock(clinicianBlockTimesDelete);
	   			clinicianBlockTimesDelete = null;	
	   			}
	   			new FXFormCommonUtilities().closeForm(saveButton);
	   		});
	   		 
	   		
	   		
	   		cancelButton.setOnAction((event) -> {
	   			new FXFormCommonUtilities().closeForm(cancelButton);
	   		});
	   		
	   		

	   }}