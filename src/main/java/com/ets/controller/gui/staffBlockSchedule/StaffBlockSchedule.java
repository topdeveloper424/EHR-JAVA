package com.ets.controller.gui.staffBlockSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.providerBlockTime.StaffBlockTimeEntityController;
import com.ets.controller.entity.providerDaysBlockTime.ProviderDaysBlockTimeEntityController;
import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.controller.gui.staffSchedule.StaffScheduleSetUpController;
import com.ets.controller.gui.staffSchedule.StaffScheduleViewController;
import com.ets.model.ClinicSchedule;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.model.ProviderSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;

public class StaffBlockSchedule implements Initializable{

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

    
   	private SchedulingViewController schedulingViewController;
 
       List<ProviderDaysBlockTime> providerBlockTimesList = new ArrayList<ProviderDaysBlockTime>();
       List<ProviderDaysBlockTime> providerBlockTimesDelete = new ArrayList<ProviderDaysBlockTime>();
       public void onClickBlockTime(Label blockedTextField,String startTime){
       	
       		if(blockedTextField.getStyle().equals("")){
       		blockedTextField.setStyle("-fx-background-color: #CA1207;");
       		ProviderDaysBlockTime providerDaysBlockTime = new ProviderDaysBlockTime();
       		
       		providerDaysBlockTime.setWeekday(providerSchedule.getWeekday());
       		providerDaysBlockTime.setStartTime(startTime);
       		providerDaysBlockTime.setProvider(SchedulingViewController.provider);
       		//providerDaysBlockTime.setEndTime(endTime);
       		
       		providerDaysBlockTime.setWeekday(providerSchedule.getWeekday());
       	
       		//providerDaysBlockTime.setEndTime(endTime);
       		
       		providerBlockTimesList.add(providerDaysBlockTime);
       	
       	   }  
       	  	else{
       		blockedTextField.setStyle(null);	
       		if(providerDaysBlockTimes!=null){
       		for(int i=0;i<providerDaysBlockTimes.size();i++){
       			int index =	Arrays.asList(providerDaysBlockTimes.get(i).getStartTime()).indexOf(startTime);
       			if(index!=-1){
       				providerBlockTimesDelete.add(providerDaysBlockTimes.get(i));
       			}
       		
       		}
       		}
       		if(providerBlockTimesList!=null){
       		for(int i=0;i<providerBlockTimesList.size();i++){
       			int index = providerBlockTimesList.get(i).getStartTime().indexOf(startTime);
       			if(index!=-1){
       				providerBlockTimesDelete.add(providerBlockTimesList.get(i));
       			}
       		}
       		}
       		
       		
       	}
     	
       }
   	
       int timeSlot=0;
       List<ClinicSchedule>  clinicScheduleDataList;
       private  ProviderSchedule providerSchedule;
   	public void setSchedulingViewController(SchedulingViewController schedulingViewController,ProviderSchedule providerSchedule) {
   		this.schedulingViewController = schedulingViewController;
   		this.providerSchedule = providerSchedule;
   		loadSlots();
   		getProviderDaysView();
   		
   	}
   	String timeSlotString[];
   	public int setByTimeSlot(int selectedSlot){
   		String timeSlotStringCopy[] = new String[150];
   		String s1[] = providerSchedule.getOpenTime().split(":");
   		String s2[] = providerSchedule.getCloseTime().split(":");
   		
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

   	List<ProviderDaysBlockTime> providerDaysBlockTimes =null;
   	public void getProviderDaysView(){
   	 providerDaysBlockTimes=	new ProviderDaysBlockTimeEntityController().viewProviderScheduleById(SchedulingViewController.provider, providerSchedule.getWeekday());
   		
   		if(providerDaysBlockTimes!=null){
   			for(int i=0;i<providerDaysBlockTimes.size();i++){
   			int index =	Arrays.asList(timeSlotString).indexOf(providerDaysBlockTimes.get(i).getStartTime());
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
  		    		startTimeText.setText(providerSchedule.getOpenTime());
  		    		endTimeText.setText(providerSchedule.getCloseTime());
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
   			if(providerBlockTimesList!=null){
   			   new ProviderDaysBlockTimeEntityController().saveOrUpdate(providerBlockTimesList);
   			   providerBlockTimesList = null;
   			}
   			
   			if(providerBlockTimesDelete!=null){
   			
   			  new ProviderDaysBlockTimeEntityController().deleteBlock(providerBlockTimesDelete);
   			  providerBlockTimesDelete = null;	
   			}
   			new FXFormCommonUtilities().closeForm(saveButton);
   		});
   		 
   		
   		
   		cancelButton.setOnAction((event) -> {
   			new FXFormCommonUtilities().closeForm(cancelButton);
   		});
   		
   		

   }}
