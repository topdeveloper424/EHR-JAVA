package com.ets.controller.gui.staffSchedule;

import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinicBlockSchedule.ClinicBlockScheduleEntityController;
import com.ets.controller.entity.clinicClosed.ClinicClosedEntityController;
import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.clinicianSchException.ClinicianSchExceptionEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.providerBlockTime.StaffBlockTimeEntityController;
import com.ets.controller.entity.providerDaysBlockException.ProviderBlockDaysExceptionEntityController;
import com.ets.controller.entity.providerDaysBlockTime.ProviderDaysBlockTimeEntityController;
import com.ets.controller.entity.providerSchException.StaffSchExceptionEntityController;
import com.ets.controller.entity.providerSchRecurException.StaffSchRecurExceptionEntityController;
import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.controller.gui.clinicianSchedule.ClinicianScheduleViewController;
import com.ets.model.ClinicBlockSchedule;
import com.ets.model.ClinicClosed;
import com.ets.model.ClinicSchedule;
import com.ets.model.Clinician;
import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.model.ProviderSchException;
import com.ets.model.ProviderSchRecurException;
import com.ets.model.ProviderSchedule;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StaffScheduleSetUpController implements Initializable {

	
	
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
	    private DatePicker inputDateField;
	    
	    @FXML
	    private Button openEntireWeekButton;

	    @FXML
	    private Button closedEntireWeekButton;
	    @FXML
	    private Button saveButton;
	    @FXML
	    private Button workUsualWeekButton;

	@FXML
	private Button closeButton;
	@FXML
    private ScrollPane scrollPaneId;

    @FXML
    private GridPane timeSlotGrid;
    @FXML
    private Label dateShowLabel;
    @FXML
    private Label clinicNameLabel;

    @FXML
    private Label startTimetext;

    @FXML
    private Label endTime;
    
    @FXML
    private Label showTimeLabel;
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

	
	
	
	List<ProviderSchedule> providerDateList = null;
	 Integer checkIfClosedClicked=0;
	 int ifCheckClicked = 0;
	String dbDate = null;
	int  lengthToGen=0 ;
	int offWeekCheck=6;
    boolean fillAllArr[]=null;
    int workUsualBtnActive = 0;
    int workUsualWeekBtnActive = 0;
    @FXML
    void openCheckBoxCollumn1(ActionEvent event) {
    	Arrays.fill(fillAllArr, true);
    	ifCheckClicked=1;
		if (openCheckBoxCollumn1.isSelected()) {
			for(int i=0;i<lengthToGen;i++){
			sundayText[i].setDisable(activeClinicTimeSun[i]);
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
				
				sundayText[i].setDisable(fillAllArr[i]);	
			}
		}

	}

	@FXML
	void openCheckBoxCollumn2(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn2.isSelected()) {
			
			for(int i=0;i<lengthToGen;i++){
				monText[i].setDisable(activeClinicTimeMon[i]);	
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
			
				monText[i].setDisable(fillAllArr[i]);
				
			}
		}

	}

	@FXML
	void openCheckBoxCollumn3(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn3.isSelected()) {
			
				
				for(int i=0;i<lengthToGen;i++){
					tuesText[i].setDisable(activeClinicTimeTues[i]);
					
				}
	         
			} else {
				
				for(int i=0;i<lengthToGen;i++){
					
					tuesText[i].setDisable(fillAllArr[i]);	
					
				}
			}

		
	}

	@FXML
	void openCheckBoxCollumn5(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn4.isSelected()) {

			
			for(int i=0;i<lengthToGen;i++){
				wedText[i].setDisable(activeClinicTimeWed[i]);
				
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
				
				
				wedText[i].setDisable(fillAllArr[i]);	
			}
		}
	}
	@FXML
	void openCheckBoxCollumn6(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn5.isSelected()) {
			
			for(int i=0;i<lengthToGen;i++){
				thursText[i].setDisable(activeClinicTimeThurs[i]);	
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
				
				thursText[i].setDisable(fillAllArr[i]);	
			}
		}
	}

	@FXML
	void openCheckBoxCollumn7(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn6.isSelected()) {
			
			for(int i=0;i<lengthToGen;i++){
				friText[i].setDisable(activeClinicTimeFri[i]);	
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
				
				friText[i].setDisable(fillAllArr[i]);	
			}
		}
	}

	@FXML
	void openCheckBoxCollumn8(ActionEvent event) {
		Arrays.fill(fillAllArr, true);
		ifCheckClicked=1;
		if (openCheckBoxCollumn7.isSelected()) {

			
			for(int i=0;i<lengthToGen;i++){
				satText[i].setDisable(activeClinicTimeSat[i]);	
			}
         
		} else {
			
			for(int i=0;i<lengthToGen;i++){
				satText[i].setDisable(fillAllArr[i]);	
				
			}
		}
	}

	
	
	private SchedulingViewController schedulingViewController=null;
	private Provider provider=null;
    public void setSchedulingViewController(SchedulingViewController SchedulingViewController){
		this.schedulingViewController=SchedulingViewController;
		this.provider = schedulingViewController.provider;
		//viewProviderSchExceptionDate();
		//setProviderByDate();
		
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
					/*
					 * case 1: sunDayTextField.setText(result2); break;
					 */
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
					/*
					 * case 1: sunDayTextField.setText(result2); break;
					 */
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

	@FXML
	void dateSelect(ActionEvent event) {
		try {
			setSelectedAllCheck();
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
						/*
						 * case 1: sunDayTextField.setText(result2); break;
						 */
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

					//viewProviderSchExceptionDate();

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
						/*
						 * case 1: sunDayTextField.setText(result2); break;
						 */
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
		
			
            viewBlockTime();
            recurenceOfProvider();
            resetColorAfterRecur();
		//	viewProviderSchExceptionDate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		 checkProviderBlockDays();
	}


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

	// Convert Date to String
	public String date2String(Date date) {
		return  new SimpleDateFormat("MM/dd/yyyy").format(date);
	}

	// Convert String to Date
	public Date string2Date(String dateAsString ) {
		Date convertedString = null ;
		try {
			convertedString = new SimpleDateFormat("MM/dd/yyyy").parse(dateAsString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return convertedString ;
	}
	ArrayList<String> dateList1 = new ArrayList<String>();
	public void viewProviderSchDate(){
		

		dateList1.add(sunDayTextField.getText());
		dateList1.add(monDayTextField.getText());
		dateList1.add(tuesDayTextField.getText());
		dateList1.add(wednesDayTextField.getText());
		dateList1.add(thursDayTextField.getText());
		dateList1.add(friDayTextField.getText());
		dateList1.add(saturDayTextField.getText());

		String str1 = sunDayTextField.getText();
		String str2 = saturDayTextField.getText();
		
		
		providerDateList = new StaffScheduleEntityController().viewProviderScheduleById(schedulingViewController.provider.getId());
	    
	
	}
	
	
	/*
	// Set from DB to UI
	public void viewProviderSchExceptionDate() {
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
		
		
		 list1 = new StaffSchExceptionEntityController().viewProviderSchExceptionById(provider.getId(), str1, str2);

		openCheckBox();

		if (list1.isEmpty()) {
			setProviderByDate();
			return;
		}

		for (int x = 0; x < list1.size(); x++) {
			for (int j = 0; j < dateList.size(); j++) {
				String listDate = dateList.get(j);
				ProviderSchException cli = list1.get(x);
				dbDate = date2String(cli.getExcepDate());

				CheckBox candidate = new CheckBox();
				switch (j) {
					case 0:		candidate = workingCheckBoxCollumn1;
								break;
					case 1:		candidate = workingCheckBoxCollumn2;
								break;
					case 2:		candidate = workingCheckBoxCollumn3;
								break;
					case 3:		candidate = workingCheckBoxCollumn4;
								break;
					case 4:		candidate = workingCheckBoxCollumn5;
								break;
					case 5:		candidate = workingCheckBoxCollumn6;
								break;
					case 6:		candidate = workingCheckBoxCollumn7;
								break;
				}
				// Clinic Closed ?
				if (dbDate.equals(listDate)) {
					candidate.setSelected(false);
					dirty[j] = true; // Is dirty on being unchecked
					System.out.println(dbDate+"="+listDate);
					//break;
				} else if (!dirty[j]) { // Clinic Open ?
					candidate.setSelected(true);
					System.out.println(dbDate+"!="+listDate);
				}
				setProviderByDate();
			}
		}
	}
*/
	// Init all clean
	

	private ArrayList<TextField> getTextfieldGroup()	{
		ArrayList<TextField> textfieldGroup = new ArrayList<TextField>();

		textfieldGroup.add(sunDayTextField);
		textfieldGroup.add(monDayTextField);
		textfieldGroup.add(tuesDayTextField);
		textfieldGroup.add(wednesDayTextField);
		textfieldGroup.add(thursDayTextField);
		textfieldGroup.add(friDayTextField);
		textfieldGroup.add(saturDayTextField);

		return textfieldGroup ;
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
		    		blockProviderSchedule(sundayText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(0).getOpenTime());
		    		endTime.setText(providerDateList.get(0).getCloseTime());
		    		dateShowLabel.setText(sunDayTextField.getText());
			    	
			    	}
		    }
		});
		
		monText[i]=new TextField();
		
		monText[i].setId("monText"+Integer.toString(i));
		monText[i].setDisable(true);
		monText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(monText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(1).getOpenTime());
		    		endTime.setText(providerDateList.get(1).getCloseTime());
		    		dateShowLabel.setText(monDayTextField.getText());
			    	
			    	}
		    }
		});
		tuesText[i]=new TextField();
		tuesText[i].setId("tuesText"+Integer.toString(i));
		tuesText[i].setDisable(true);
		tuesText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(tuesText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(2).getOpenTime());
		    		endTime.setText(providerDateList.get(2).getCloseTime());
		    		dateShowLabel.setText(tuesDayTextField.getText());
			    	
			    	}
		    }
		});
		
		wedText[i]=new TextField();
		wedText[i].setId("wedText"+Integer.toString(i));
		wedText[i].setDisable(true);
		
		wedText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(wedText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(3).getOpenTime());
		    		endTime.setText(providerDateList.get(3).getCloseTime());
		    		dateShowLabel.setText(wednesDayTextField.getText());
			    	
			    	}
		    }
		});
		
		thursText[i]=new TextField();
		thursText[i].setId("thursText"+Integer.toString(i));
		thursText[i].setDisable(true);
		thursText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(thursText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(4).getOpenTime());
		    		endTime.setText(providerDateList.get(4).getCloseTime());
		    		dateShowLabel.setText(thursDayTextField.getText());
			    	}
		    }
		});
		
		friText[i]=new TextField();
		friText[i].setDisable(true);
		friText[i].setId("friText"+Integer.toString(i));
		friText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(friText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(5).getOpenTime());
		    		endTime.setText(providerDateList.get(5).getCloseTime());
		    		dateShowLabel.setText(friDayTextField.getText());
			    	
			    	}
		    }
		});
		satText[i]=new TextField();
		satText[i].setId("satText"+Integer.toString(i));
		satText[i].setDisable(true);
		satText[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 2) {
		    		blockProviderSchedule(satText[m],timeSlotString[m]);
		    		
		    	}
		    	if (me.getClickCount() == 1) {
		    		showTimeLabel.setText(timeSlotString[m]);
		    		startTimetext.setText(providerDateList.get(6).getOpenTime());
		    		endTime.setText(providerDateList.get(6).getCloseTime());
		    		dateShowLabel.setText(saturDayTextField.getText());
			    	
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
	
}	String timeSlotString[];
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
    
    boolean activeClinicTimeArr[];
    boolean activeClinicTimeSun[];
    boolean activeClinicTimeMon[];
    boolean activeClinicTimeTues[];
    boolean activeClinicTimeWed[];
    boolean activeClinicTimeThurs[];
    boolean activeClinicTimeFri[];
    boolean activeClinicTimeSat[];
    List<Boolean> getSelectedCheckList = new ArrayList<Boolean>();
	public void getOpenedCheckBox(){
	 
			getSelectedCheckList.add(0, openCheckBoxCollumn1.isSelected());
			getSelectedCheckList.add(1, openCheckBoxCollumn2.isSelected());
			getSelectedCheckList.add(2, openCheckBoxCollumn3.isSelected());
			getSelectedCheckList.add(3, openCheckBoxCollumn4.isSelected());
			getSelectedCheckList.add(4, openCheckBoxCollumn5.isSelected());
			getSelectedCheckList.add(5, openCheckBoxCollumn6.isSelected());
			getSelectedCheckList.add(6, openCheckBoxCollumn7.isSelected());
		
	      }
    public void setSelectedAllCheck(){
    	
    	openCheckBoxCollumn1.setSelected(true);
    	openCheckBoxCollumn2.setSelected(true);
    	openCheckBoxCollumn3.setSelected(true);
    	openCheckBoxCollumn4.setSelected(true);
    	openCheckBoxCollumn5.setSelected(true);
    	openCheckBoxCollumn6.setSelected(true);
    	openCheckBoxCollumn7.setSelected(true);
    	    	
    }
    
    
   
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
    		
    		 viewProviderSchDate();
    				int openIndex=0;
    				int endOfIndex=0;
    		
    				for(int j=0;j<7;j++){
    					try{
    					   if(clinicScheduleTimeList.get(j).getOpenTime()!=null && clinicScheduleTimeList.get(j).getCloseTime()!=null){
    						 String cliOpen =  clinicScheduleTimeList.get(j).getOpenTime();
    						 String cliClos =  clinicScheduleTimeList.get(j).getCloseTime();
    						  
    						
    						 openIndex= Arrays.asList(timeSlotString).indexOf(cliOpen);
    						 endOfIndex =  Arrays.asList(timeSlotString).indexOf(cliClos);
    						 int providerOpenTimeInd = Arrays.asList(timeSlotString).indexOf(providerDateList.get(j).getOpenTime());
    						 int providerCloseTimeInd = Arrays.asList(timeSlotString).indexOf(providerDateList.get(j).getCloseTime());
    						
    						  
    						
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
    			     if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
							int providerOpenIndex = (providerOpenTimeInd-openIndex);
							while(providerOpenTimeInd>=openIndex){
							    sundayText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
								sundayText[providerOpenTimeInd].setDisable(true);
								activeClinicTimeSun[providerOpenTimeInd]=true;
								--providerOpenTimeInd;
							}
							
							
					}else{
				      }
					if(providerCloseTimeInd<=endOfIndex&&providerCloseTimeInd!=-1){
						    while(providerCloseTimeInd<endOfIndex){
                               sundayText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
						       sundayText[providerCloseTimeInd].setDisable(true);
						   	activeClinicTimeSun[providerCloseTimeInd]=true;
							   ++providerCloseTimeInd;
							}
						    
					}else{
					}
					
    				}
    			    if(j==1){
    			    	  
    				      Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    				      Arrays.fill(activeClinicTimeMon, openIndex, endOfIndex, false);
    				      setActiveTime(activeClinicTimeMon,j);
    				     
    				      if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
  							     while(providerOpenTimeInd>=openIndex){
  							        monText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
  								    monText[providerOpenTimeInd].setDisable(true);
  								  activeClinicTimeMon[providerOpenTimeInd]=true;
  								    --providerOpenTimeInd;
  								
  							     }
  							
  						}else{
						}
    				      if(providerCloseTimeInd<=endOfIndex&&providerCloseTimeInd!=-1){
  							
                                 while(providerCloseTimeInd<endOfIndex){
  							          monText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                                      monText[providerCloseTimeInd].setDisable(true);
                                      activeClinicTimeMon[providerCloseTimeInd]=true;
  								     ++providerCloseTimeInd;
  							     }
  							
  						 }else{
  						 }
    			    }
    					
    			    if(j==2){
    			    	
    			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    			    	  Arrays.fill(activeClinicTimeTues, openIndex, endOfIndex, false);
    				      setActiveTime(activeClinicTimeTues,j);
    				      
    				      if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
							     while(providerOpenTimeInd>=openIndex){
							        tuesText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
							        tuesText[providerOpenTimeInd].setDisable(true);
							        activeClinicTimeTues[providerOpenTimeInd]=true;
								    --providerOpenTimeInd;
								
							     }
							
						}else{
						}
 				      if(providerCloseTimeInd<=endOfIndex&&providerCloseTimeInd!=-1){
							
                              while(providerCloseTimeInd<endOfIndex){
                            	  tuesText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                            	  tuesText[providerCloseTimeInd].setDisable(true);
                            	  activeClinicTimeTues[providerCloseTimeInd]=true;
								  ++providerCloseTimeInd;
							     }
							
						 }else{
						 }
    					}
    			    if(j==3){
    			    	
    			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    			    	  Arrays.fill(activeClinicTimeWed, openIndex, endOfIndex, false);
    				      setActiveTime(activeClinicTimeWed,j);
    				      
    				      if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
							     while(providerOpenTimeInd>=openIndex){
							        wedText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
							        wedText[providerOpenTimeInd].setDisable(true);
							        activeClinicTimeWed[providerOpenTimeInd]=true;
								    --providerOpenTimeInd;
								   
							     }
							     
							
						}else{
						}
 				      if(providerCloseTimeInd<=endOfIndex&&providerCloseTimeInd!=-1){
							
                              while(providerCloseTimeInd<endOfIndex){
                            	  wedText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                            	  wedText[providerCloseTimeInd].setDisable(true);
                            	  activeClinicTimeWed[providerCloseTimeInd]=true;
								  ++providerCloseTimeInd;
							     }
							
						 }else{
						 }
    			  				}
    			    if(j==4){
    			    	
    			    	   Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    			    	   Arrays.fill(activeClinicTimeThurs, openIndex, endOfIndex, false);
    				       setActiveTime(activeClinicTimeThurs,j);
    				       
     				      if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
 							     while(providerOpenTimeInd>=openIndex){
 							        thursText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
 							       thursText[providerOpenTimeInd].setDisable(true);
 							      activeClinicTimeThurs[providerOpenTimeInd]=true;
 							       --providerOpenTimeInd;
 								
 							     }
 							
 						}else{
 						}
  				      if(providerCloseTimeInd<endOfIndex&&providerCloseTimeInd!=-1){
 							
                               while(providerCloseTimeInd<endOfIndex){
                            	   thursText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                            	   thursText[providerCloseTimeInd].setDisable(true);
                            	   activeClinicTimeThurs[providerCloseTimeInd]=true;
 								  ++providerCloseTimeInd;
 							     }
 							
 						 }else{
 						 }
    					}
    			    if(j==5){
    			    	
    			    	   
    			        	Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    			            Arrays.fill(activeClinicTimeFri, openIndex, endOfIndex, false);
    				        setActiveTime(activeClinicTimeFri,j);
    				        if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
							     while(providerOpenTimeInd>=openIndex){
							        friText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
							        friText[providerOpenTimeInd].setDisable(true);
							        activeClinicTimeFri[providerOpenTimeInd]=true;
								    --providerOpenTimeInd;
								
							     }
							
						}else{
						}
 				      if(providerCloseTimeInd<endOfIndex&&providerCloseTimeInd!=-1){
							
                              while(providerCloseTimeInd<=endOfIndex){
                            	  friText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                            	  friText[providerCloseTimeInd].setDisable(true);
                            	  activeClinicTimeFri[providerCloseTimeInd]=true;
								  ++providerCloseTimeInd;
							     }
							
						 }else{
						 }
    			  
    					}
    			    if(j==6){
    			    	
    			    	 
    			    	  Arrays.fill(activeClinicTimeArr, openIndex, endOfIndex, false);
    			    	  Arrays.fill(activeClinicTimeSat, openIndex, endOfIndex, false);
    				      setActiveTime(activeClinicTimeSat,j);
    				      if(providerOpenTimeInd>openIndex&&providerOpenTimeInd!=-1){
							     while(providerOpenTimeInd>=openIndex){
							        satText[providerOpenTimeInd].setStyle("-fx-background-color :#ABEBC6");
							        satText[providerOpenTimeInd].setDisable(true);
							        activeClinicTimeSat[providerOpenTimeInd]=true;
								    --providerOpenTimeInd;
								
							     }
							
						}else{
						}
				      if(providerCloseTimeInd<endOfIndex&&providerCloseTimeInd!=-1){
							
                           while(providerCloseTimeInd<=endOfIndex){
                        	   satText[providerCloseTimeInd].setStyle("-fx-background-color :#ABEBC6");
                        	   satText[providerCloseTimeInd].setDisable(true);
                        	   activeClinicTimeSat[providerCloseTimeInd]=true;
								  ++providerCloseTimeInd;
							     }
							
						 }else{
						 }
  			  
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
    			
    		
    		
    	}}public void setActiveTime(boolean setActiveTime[],int checkBoxNo){
		
		if(checkBoxNo==0){
			for(int i=0;i<lengthToGen;i++){
				sundayText[i].setDisable(setActiveTime[i]);
				sundayText[i].setStyle(null);
				
			}
									
		}
		if(checkBoxNo==1){
			for(int i=0;i<lengthToGen;i++){
				monText[i].setDisable(setActiveTime[i]);	
				monText[i].setStyle(null);
				
			}
									
		}
		if(checkBoxNo==2){
			for(int i=0;i<lengthToGen;i++){
				tuesText[i].setDisable(setActiveTime[i]);
				tuesText[i].setStyle(null);
				
			}
									
		}
		if(checkBoxNo==3){
			for(int i=0;i<lengthToGen;i++){
				wedText[i].setDisable(setActiveTime[i]);	
				wedText[i].setStyle(null);
				
			}
									
		}
		if(checkBoxNo==4){
			for(int i=0;i<lengthToGen;i++){
				thursText[i].setDisable(setActiveTime[i]);	
				thursText[i].setStyle(null);
				
			}
									
		}
		if(checkBoxNo==5){
			for(int i=0;i<lengthToGen;i++){
				friText[i].setDisable(setActiveTime[i]);
				friText[i].setStyle(null);
				
			}
			
									
		}
		if(checkBoxNo==6){
			for(int i=0;i<lengthToGen;i++){
				satText[i].setDisable(setActiveTime[i]);
				satText[i].setStyle(null);
				
			}
									
		}
	}
    List<Date> dateList=new ArrayList<Date>();
 	public void viewBlockTime(){
 		
 		List<ClinicBlockSchedule> cliblock = null;
 		
 		
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
		  int indexPro=0;
		  
		 cliblock =  new ClinicBlockScheduleEntityController().viewByDate(dateList); 
		
		 proBlockTimeDb = new StaffBlockTimeEntityController().viewBydateAndProvider(dateList, StaffScheduleViewController.provider);
		
		 for(int i=0;i<proBlockTimeDb.size();i++){
			 
			  if(proBlockTimeDb.isEmpty()==false){
	            	 indexPro = Arrays.asList(timeSlotString).indexOf(proBlockTimeDb.get(i).getBlockTime());
	            	 
	            	 if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date)&&indexPro!=-1){
						
						 if(indexPro!=-1){
							 sundayText[indexPro].setStyle("-fx-background-color : #E44535");	 
							 
						 }
						
					}
					
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date1)&&indexPro!=-1){
					
					  if(indexPro!=-1){
							 monText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }	
						
					}
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date2)&&indexPro!=-1){
					 
					  if(indexPro!=-1){
						  System.out.println("indexPro "+indexPro);
							 tuesText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }	
					} 
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date3)&&indexPro!=-1){
					 
					  if(indexPro!=-1){
							 wedText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }		
						
					}
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date4)&&indexPro!=-1){
					 
					  if(indexPro!=-1){
							 thursText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }	
						
					}	
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date5)&&indexPro!=-1){
					  if(indexPro!=-1){
							 friText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }	
							
						
					}
				  else if(proBlockTimeDb.get(i).getBlockTimeDate().equals(date6)&&indexPro!=-1){
					 
					  if(indexPro!=-1){
							 satText[indexPro].setStyle("-fx-background-color : #E44535");	 
							  
						 }	
								
					}
				 }
				 
		 }
		 
		 
		 for(int i=0;i<cliblock.size();i++){
			
			 if(cliblock.get(i).getBlockTimeDate().equals(date)){
				  index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				 
				 if(index!=-1){
					 sundayText[index].setStyle("-fx-background-color : #E6FCF7");	 
					 sundayText[index].setDisable(true);
					
				 }
				 
			 }
			
	         if(cliblock.get(i).getBlockTimeDate().equals(date1)){
	        	
	        	 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
	        	
	             if(index!=-1){
	            	 monText[index].setStyle("-fx-background-color :#E6FCF7"); 
	            	 monText[index].setDisable(true);
				 }
			 } if(cliblock.get(i).getBlockTimeDate().equals(date2)){
				 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				
				 if(index!=-1){
	            	  tuesText[index].setStyle("-fx-background-color :#E6FCF7");
	            	  tuesText[index].setDisable(true);
				 }
				
				 
			 }if(cliblock.get(i).getBlockTimeDate().equals(date3)){
				 
				 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				 
	             if(index!=-1){
	            	 wedText[index].setStyle("-fx-background-color :#E6FCF7");
	            	 wedText[index].setDisable(true);
	            	
				 }
				 
			 }if(cliblock.get(i).getBlockTimeDate().equals(date4)){
				 
				 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				 
	             if(index!=-1){
	            	 thursText[index].setStyle("-fx-background-color :#E6FCF7");
	            	 thursText[index].setDisable(true);
				 }
				 
			 }if(cliblock.get(i).getBlockTimeDate().equals(date5)){
				 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				 
	            if(index!=-1){
	            	 friText[index].setStyle("-fx-background-color :#E6FCF7");
	            	 friText[index].setDisable(true);
				 }
				
				 
			 }if(cliblock.get(i).getBlockTimeDate().equals(date6)){
				 
				 index = Arrays.asList(timeSlotString).indexOf(cliblock.get(i).getBlockTime());
				 
	            if(index!=-1){
	            	 satText[index].setStyle("-fx-background-color :#E6FCF7"); 
	            	 satText[index].setDisable(true);
	            }
				
			 }
			   
		   }
		 
		 checkProviderBlockDays();
	
		 
 	
 	}
	
	List<ClinicClosed> cliClosed = null;
	List<ProviderSchException> providerSchExcepList =new ArrayList<ProviderSchException>(); 
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
		cliClosed = new ClinicClosedEntityController().viewByDate(str1, str2, Global.clinic.getId());
		providerSchExcepList = new StaffSchExceptionEntityController().viewProviderSchExceptionById(schedulingViewController.provider, sunDayTextField.getText(), saturDayTextField.getText());
	 
		if(providerSchExcepList.size()>=7 && openEntireWeekBtnActive==0&& workUsualWeekBtnActive==0){
			
		      Arrays.fill(fillAllArr, true);
		      
				closeCheckBox();
				for(int i=0;i<lengthToGen;i++){
				
					sundayText[i].setDisable(fillAllArr[i]);
					monText[i].setDisable(fillAllArr[i]);
				    tuesText[i].setDisable(fillAllArr[i]);
					wedText[i].setDisable(fillAllArr[i]);
					thursText[i].setDisable(fillAllArr[i]);
					friText[i].setDisable(fillAllArr[i]);
					satText[i].setDisable(fillAllArr[i]);
					
					sundayText[i].setStyle("-fx-background-color :#ABEBC6");
					monText[i].setStyle("-fx-background-color :#ABEBC6");
				    tuesText[i].setStyle("-fx-background-color :#ABEBC6");
					wedText[i].setStyle("-fx-background-color :#ABEBC6");
					thursText[i].setStyle("-fx-background-color :#ABEBC6");
					friText[i].setStyle("-fx-background-color :#ABEBC6");
					satText[i].setStyle("-fx-background-color :#ABEBC6");
		}
		}else if((providerSchExcepList.size()<7)&&providerSchExcepList.size()!=0&&workUsualWeekBtnActive==0){
			
			for(int i=0;i<providerSchExcepList.size();i++){
				  Arrays.fill(fillAllArr, true);
				 
				if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(sunDayTextField.getText()))){
					for(int j=0;j<lengthToGen;j++){
					
						sundayText[j].setDisable(fillAllArr[j]);
						sundayText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn1.setSelected(false);
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(monDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
   					
            		   monText[j].setDisable(fillAllArr[j]);
            		   monText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn2.setSelected(false);	
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(tuesDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
      					
            		   tuesText[j].setDisable(fillAllArr[j]);
            		   tuesText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn3.setSelected(false);	
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(wednesDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
     					
            		   wedText[j].setDisable(fillAllArr[j]);
            		   wedText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn4.setSelected(false);		
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(thursDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
    					
            		   thursText[j].setDisable(fillAllArr[j]);
            		   thursText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn5.setSelected(false);
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(friDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
   					
            		   friText[j].setDisable(fillAllArr[j]);
            		   friText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn6.setSelected(false);
				}
               if(providerSchExcepList.get(i).getExcepDate().equals(string2Date(saturDayTextField.getText()))){
            	   for(int j=0;j<lengthToGen;j++){
      					
            		   satText[j].setDisable(fillAllArr[j]);
            		   satText[j].setStyle("-fx-background-color :#ABEBC6");
						
					
					}openCheckBoxCollumn7.setSelected(false);
				}
			}
			
			
			
		}workUsualWeekBtnActive=0;
		
		openCheckBox();

		if (cliClosed.isEmpty()) {
			
			return;
		}

		for (int x = 0; x < cliClosed.size(); x++) {
			for (int j = 0; j < dateList.size(); j++) {
				String listDate = dateList.get(j);
				ClinicClosed cli = cliClosed.get(x);
				
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
			
				if (dbDate.equals(listDate)) {
					candidate.setSelected(false);
                    Arrays.fill(activeClinicTimeArr, true);
					setActiveTime(activeClinicTimeArr,checkBoxNo);
					
					
				}
			
			}
		}
		
		
		
	}
 	  List<ProviderBlockTime> providerBlockSchedulesList = new ArrayList<ProviderBlockTime>();
 	  List<ProviderBlockTime> proBlockDelete = new ArrayList<ProviderBlockTime>();
 	 List<ProviderBlockTime> proBlockTimeDb=null;
 	  public void blockProviderSchedule(TextField blockedTextField,String time){
 	   
 		
 		if(blockedTextField.getStyle().equals("-fx-background-color : #E44535")||blockedTextField.getStyle().equals("-fx-background-color : #E18080")){
 			 blockedTextField.setStyle(null);
 			
 			 for(int i=0;i<proBlockTimeDb.size();i++){
 			 
 			 if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(0))){
 			     proBlockDelete.add(proBlockTimeDb.get(i));
 				 }
 			 else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(1))){
 			     proBlockDelete.add(proBlockTimeDb.get(i));
 				 }
			
 			 else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(2))){
 			     proBlockDelete.add(proBlockTimeDb.get(i));
 				 }
 			 else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(3))){
 			     proBlockDelete.add(proBlockTimeDb.get(i));
 				 } 
 			 else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(4))){
 			     proBlockDelete.add(proBlockTimeDb.get(i));
 				 } 
 			else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(5))){
			     proBlockDelete.add(proBlockTimeDb.get(i));
				 } 
 			else if(proBlockTimeDb.get(i).getBlockTime().equals(time)&&proBlockTimeDb.get(i).getBlockTimeDate().equals(dateList.get(6))){
			     proBlockDelete.add(proBlockTimeDb.get(i));
				 } 
 			else {
 				Iterator<ProviderBlockTime> proBl = providerBlockSchedulesList.iterator();
				  while (proBl.hasNext()) {
					  ProviderBlockTime prob = proBl.next();
					if(prob.getBlockTime()==time){
						proBl.remove();
						
						
					}
				 } 
				 
 			 }
 			 }
 		}
 		else{
 			   ProviderBlockTime providerBlock =  new ProviderBlockTime();
 			   providerBlock.setBlockTime(time);
 			   providerBlock.setProvider(provider);
 			  
 			   
 			   
 			  //clinicBlockSchedule.setClinc(Global.clinic);
 			  if(blockedTextField.getId().substring(0, 3).equals("sun")){
 				 
 				   blockedTextField.setStyle("-fx-background-color : #E18080");
 				 
 				  Date date =  string2Date(sunDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				
 				
 			  }
 	          if(blockedTextField.getId().substring(0, 3).equals("mon")){
 	        	 
 	   		     blockedTextField.setStyle("-fx-background-color : #E18080");
 	   		 
 				  Date date =  string2Date(monDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				 
 				  
 			  }  if(blockedTextField.getId().substring(0, 3).equals("tue")){
 				
 				   blockedTextField.setStyle("-fx-background-color : #E18080");
 				 
 				  Date date =  string2Date(tuesDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				 
 				  
 			  } if(blockedTextField.getId().substring(0, 3).equals("wed")){
 				
 				   blockedTextField.setStyle("-fx-background-color : #E18080");
 				 
 				  Date date =  string2Date(wednesDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				 
 				  
 			  }if(blockedTextField.getId().substring(0, 3).equals("thu")){
 				
 				   blockedTextField.setStyle("-fx-background-color : #E18080");
 				 
 				  Date date =  string2Date(thursDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				 
 				  
 			  }
 	          if(blockedTextField.getId().substring(0, 3).equals("fri")){
 	        	
 	   		     blockedTextField.setStyle("-fx-background-color : #E18080");
 	   		 
 				  Date date =  string2Date(friDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				  
 				  
 			  } if(blockedTextField.getId().substring(0, 3).equals("sat")){
 				
 				   blockedTextField.setStyle("-fx-background-color : #E18080");
 				 
 				  Date date =  string2Date(saturDayTextField.getText());
 				  providerBlock.setBlockTimeDate(date);
 				  
 				  
 			  }
 			 providerBlockSchedulesList.add(providerBlock);
 			}
 		}
 	 List<ProviderDaysBlockTime> providerDaysBlock = null;
 	int blocksize=1;
 	List<ProviderBlockDayException> blockDayList = new ArrayList<ProviderBlockDayException>();
 	 public void checkProviderBlockDays(){
 		
 		providerDaysBlock = new ProviderDaysBlockTimeEntityController().viewByProviderId(SchedulingViewController.provider);	
        blockDayList =  new ProviderBlockDaysExceptionEntityController().viewProviderScheduleById(sunDayTextField.getText(),saturDayTextField.getText(), SchedulingViewController.provider);
         blocksize =  blockDayList.size();
        if(workUsualBtnActive==1){
        	
        	blocksize=0;
        }
 		
 		if(providerDaysBlock!=null && blocksize==0){
 			for(int i=0;i<providerDaysBlock.size();i++){
 				if(providerDaysBlock.get(i).getWeekday().equals("Sunday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 			     if(index!=-1){
 	 			    	sundayText[index].setStyle("-fx-background-color: #CA1207;"); 
 	 			     }
 	 				  
 				}	
 				if(providerDaysBlock.get(i).getWeekday().equals("Monday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					monText[index].setStyle("-fx-background-color: #CA1207;");
 	 			     }
 	 				
 				}
 				if(providerDaysBlock.get(i).getWeekday().equals("Tuesday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					tuesText[index].setStyle("-fx-background-color: #CA1207;");
 	 			     }
 	 			
 				}if(providerDaysBlock.get(i).getWeekday().equals("Wednesday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					wedText[index].setStyle("-fx-background-color: #CA1207;");
	 			     }
 	 				
				}
 				if(providerDaysBlock.get(i).getWeekday().equals("Thursday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					thursText[index].setStyle("-fx-background-color: #CA1207;");
	 			     }
 	 				
				}
 				if(providerDaysBlock.get(i).getWeekday().equals("Friday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					friText[index].setStyle("-fx-background-color: #CA1207;");
	 			     }
 	 				
				}
 				if(providerDaysBlock.get(i).getWeekday().equals("Saturday")){
 	 				int index = Arrays.asList(timeSlotString).indexOf(providerDaysBlock.get(i).getStartTime());
 	 				if(index!=-1){
 	 					satText[index].setStyle("-fx-background-color: #CA1207;");
	 			     }
 	 				
				}
 			}
 			
 			
 		}
 	}
 	  
    List<ClinicSchedule> clinicScheduleTimeList;
    FXMLFormPath formPath =  new FXMLFormPath();
   
	List<Date> providerOpenDateList = new ArrayList<Date>();
	int openEntireWeekBtnActive = 0;
	
	public void resetColorAfterRecur(){
	for (ProviderSchRecurException providerRecur : recurenceOfProvider) {
		    Date endByDate =  providerRecur.getOccurRange().getEndByDate();
		    LocalDate ed = new DateConvert().dateToLocalDate(endByDate);
		    Date startDate = providerRecur.getOccurRange().getStartDate();
		    int startInd = Arrays.asList(timeSlotString).indexOf(providerRecur.getOccurRange().getBlockedStartTime());
			int endInd = Arrays.asList(timeSlotString).indexOf(providerRecur.getOccurRange().getBlockedEndTime());
			
		if(checkRecur==true){
			System.out.println(startDate+" if "+endByDate);
			LocalDate edRef =ed;
			if(startInd!=-1&&endInd!=-1){
				if(ed.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
					
					for(int i=startInd;i<endInd;i++){
						sundayText[i].setStyle(null);
					}System.out.println("sun removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}
				
				if(ed.getDayOfWeek().equals(DayOfWeek.MONDAY)){
					
					for(int i=startInd;i<endInd;i++){
						monText[i].setStyle(null);
					}System.out.println("mon removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}
				if(ed.getDayOfWeek().equals(DayOfWeek.TUESDAY)){
					
					for(int i=startInd;i<endInd;i++){
						tuesText[i].setStyle(null);
					}System.out.println("tues removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}
				if(ed.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)){
					
					for(int i=startInd;i<endInd;i++){
						wedText[i].setStyle(null);
					}System.out.println("wed removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}if(ed.getDayOfWeek().equals(DayOfWeek.THURSDAY)){
					
					for(int i=startInd;i<endInd;i++){
						tuesText[i].setStyle(null);
					}System.out.println("thur removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}if(ed.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
					
					for(int i=startInd;i<endInd;i++){
						friText[i].setStyle(null);
					}System.out.println("fri removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}if(ed.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
					
					for(int i=startInd;i<endInd;i++){
						satText[i].setStyle(null);
					}System.out.println("sat removed "+ed.getDayOfWeek());
					ed=ed.plusDays(1);
				}
				
				
			}
			
			
		}else{
			System.out.println(startDate+" else "+endByDate);
		}
		
	}	checkRecur=false;
	}
	List<ProviderSchRecurException> recurenceOfProvider =null;
	Boolean checkRecur=false;
	public void recurenceOfProvider(){
		
		recurenceOfProvider= new StaffSchRecurExceptionEntityController().viewStaffSchRecurExcByProviderId(SchedulingViewController.provider.getId());
	    System.out.println("$$$$$$$$$$$$$$$ "+recurenceOfProvider.size());
		for (ProviderSchRecurException providerSchRecurException : recurenceOfProvider) {
		    
		    Date endByDate =  providerSchRecurException.getOccurRange().getEndByDate();
		    Date startDate = providerSchRecurException.getOccurRange().getStartDate();
		    if(providerSchRecurException.getOccurRange().getNoEndDate()==true){
				 endByDate=string2Date(saturDayTextField.getText());//end on sat
			  }
			if(providerSchRecurException.getRecurPattern().getDailyRecur()==true){
				if(providerSchRecurException.getRecurPattern().getEveryWeekDay()==false){
				
					
					if(startDate.after(string2Date(saturDayTextField.getText()))||endByDate.before(string2Date(sunDayTextField.getText()))){
					//no recur for this week	
					}else{
						checkRecur=true;
						LocalDate startLocal = new DateConvert().dateToLocalDate(startDate);
						LocalDate endBySat = new DateConvert().dateToLocalDate(string2Date(saturDayTextField.getText()));
						LocalDate endDateLo = new DateConvert().dateToLocalDate(endByDate);
						int ocurAfter = Integer.parseInt(providerSchRecurException.getRecurPattern().getAfterEvery());
						while(startLocal.isBefore(endBySat)){
							  System.out.println("##################### "+startLocal);
							  if(providerSchRecurException.getOccurRange().getNoEndDate()==true){
								  if(startLocal.equals(endBySat)){
									  break;  
								  }
							  }else{
								  if(startLocal.equals(endDateLo)){
										System.out.println("@@@@@@@@@@break ***************");
										break;
										
									}   
							  }
							
						  //int freq = Arrays.asList(satText).fre
							  if(startLocal.getDayOfWeek()==DayOfWeek.SATURDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										// Arrays.fill(satText, startInd, endInd, "-fx-background-color : #E44535");	
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
	                             	        while(startInd<endInd){
	                             	        	satText[startInd].setStyle("-fx-background-color : #E44535");
	                             	        	satText[startInd].setDisable(fillAllArr[startInd]);
	                             	        	++startInd;
	                             	        }
									 
									 }
							  } if(startLocal.getDayOfWeek()==DayOfWeek.MONDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										// Arrays.fill(monText, startInd, endInd, "-fx-background-color : #E44535");	
										
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
	                             	        while(startInd<endInd){
	                             	        	monText[startInd].setStyle("-fx-background-color : #E44535");
	                             	        	monText[startInd].setDisable(fillAllArr[startInd]);
	                             	        	++startInd;
	                             	        }
									 }
							  }if(startLocal.getDayOfWeek()==DayOfWeek.TUESDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										// Arrays.fill(tuesText, startInd, endInd, "-fx-background-color : #E44535");
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
	                             	        while(startInd<endInd){
	                             	        	tuesText[startInd].setStyle("-fx-background-color : #E44535");
	                             	        	tuesText[startInd].setDisable(fillAllArr[startInd]);
	                             	        	++startInd;
	                             	        }
									 }
							  }
							  if(startLocal.getDayOfWeek()==DayOfWeek.WEDNESDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										// Arrays.fill(wedText, startInd, endInd, "-fx-background-color : #E44535");	
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
                             	        while(startInd<endInd){
                             	        	wedText[startInd].setStyle("-fx-background-color : #E44535");
                             	        	wedText[startInd].setDisable(fillAllArr[startInd]);
                             	        	++startInd;
                             	  }
									 
									 }
							  }if(startLocal.getDayOfWeek()==DayOfWeek.THURSDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										// Arrays.fill(thursText, startInd, endInd, "-fx-background-color : #E44535");	
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
                                	        while(startInd<endInd){
                                	        	thursText[startInd].setStyle("-fx-background-color : #E44535");
                                	        	thursText[startInd].setDisable(fillAllArr[startInd]);
                                 	        	++startInd;
                                	  }
									 }
							  }if(startLocal.getDayOfWeek()==DayOfWeek.FRIDAY){
								    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
									int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
									
									 if(startInd !=-1 &&endInd!=-1){
										 Arrays.fill(fillAllArr, startInd, endInd, false);	
										 if(startInd !=-1 &&endInd!=-1){
												//Arrays.fill(friText, startInd, endInd, "-fx-background-color : #E44535");	
											 Arrays.fill(fillAllArr, startInd, endInd, false);	
	                                   	        while(startInd<endInd){
	                                   	    	friText[startInd].setStyle("-fx-background-color : #E44535");
	                                   	    	friText[startInd].setDisable(fillAllArr[startInd]);
                                 	        	++startInd;
                                	  
	                                   	  }
										 }
										}
							  }
							  startLocal = startLocal.plusDays(ocurAfter);    
						    
						}
						  
						
					}
					
					}else{
						
						
						if(startDate.after(string2Date(saturDayTextField.getText()))||endByDate.before(string2Date(sunDayTextField.getText()))){
							//no recur for this week	
							System.out.println("%%%%%%%%%%startDate "+startDate+"  saturDayTextField "+string2Date(saturDayTextField.getText()+"\n endByDate "+endByDate+" sunDayTextField "+sunDayTextField.getText()));
							}else{
								checkRecur=true;
								System.out.println("%%%%%%%%%%ELSE startDate "+startDate+"  saturDayTextField "+string2Date(saturDayTextField.getText()+"\n endByDate "+endByDate+" sunDayTextField "+sunDayTextField.getText()));
								LocalDate startLocal = new DateConvert().dateToLocalDate(startDate);
								LocalDate endDateLo = new DateConvert().dateToLocalDate(endByDate);
								LocalDate endOnSat = new DateConvert().dateToLocalDate(string2Date(saturDayTextField.getText()));
								 
								if(startLocal.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
									
									startLocal = startLocal.plusDays(1);  
									//exclude sat sunday
								}System.out.println("Days of week---------- "+startLocal.getDayOfWeek()+" "+DayOfWeek.FRIDAY);
								while(startLocal.equals(endOnSat)==false){
								System.out.println("@@@@@ "+startLocal);
								 if(providerSchRecurException.getOccurRange().getNoEndDate()==true){
									  if(startLocal.equals(endOnSat)){
										  break;  
									  }
								  }
								if(startLocal.isEqual(endDateLo)){
									System.out.println("@@@@@@@@@@break ***************");
									break;
								}if(startLocal.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
									if(startLocal.getDayOfWeek()==DayOfWeek.FRIDAY){
									    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
										int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
										System.out.println("start and end are :"+startInd+"  "+endInd);
										if(startInd !=-1 &&endInd!=-1){
											//Arrays.fill(friText, startInd, endInd, "-fx-background-color : #E44535");	
											 Arrays.fill(fillAllArr, startInd, endInd, false);	
                                   	        while(startInd<endInd){
                                   	    	friText[startInd].setStyle("-fx-background-color : #E44535");
                                   	    	friText[startInd].setDisable(fillAllArr[startInd]);
                             	        	++startInd;
                                   	  }
										}
								  } 
									System.out.println("EQUAL++++++++++++++++++");
									startLocal = startLocal.plusDays(3);  
									//exclude sat sunday
									
									
								}else{
									 if(startLocal.getDayOfWeek()==DayOfWeek.SATURDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
											
												 Arrays.fill(fillAllArr, startInd, endInd, false);	
                                        	      while(startInd<endInd){
                                        	    	  satText[startInd].setStyle("-fx-background-color : #E44535");
                                        	    	  satText[startInd].setDisable(fillAllArr[startInd]);
                                       	        	++startInd;
                                        	  }
											}
											
											
									  } if(startLocal.getDayOfWeek()==DayOfWeek.MONDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
                                            	
												 Arrays.fill(fillAllArr, startInd, endInd, false);	
                                         	      while(startInd<endInd){
                                         	    	monText[startInd].setStyle("-fx-background-color : #E44535");
                                         	    	monText[startInd].setDisable(fillAllArr[startInd]);
                                        	        	++startInd;
                                         	  }
											}
										
											
									  }if(startLocal.getDayOfWeek()==DayOfWeek.TUESDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
                                        		
												 Arrays.fill(fillAllArr, startInd, endInd, false);	
                                            	    while(startInd<endInd){
                                            	    	tuesText[startInd].setStyle("-fx-background-color : #E44535");
                                            	    	tuesText[startInd].setDisable(fillAllArr[startInd]);
                                        	        	++startInd;
                                            	  }
											}
									
											
									  }
									  if(startLocal.getDayOfWeek()==DayOfWeek.WEDNESDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
                                            		
												Arrays.fill(fillAllArr, startInd, endInd, false);	
                                           	    while(startInd<endInd){
                                           	    	wedText[startInd].setStyle("-fx-background-color : #E44535");
                                           	    	wedText[startInd].setDisable(fillAllArr[startInd]);
                                    	        	++startInd;
                                           	  }
											}
											
											
									  }if(startLocal.getDayOfWeek()==DayOfWeek.THURSDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
												Arrays.fill(fillAllArr, startInd, endInd, false);	
                                           
                                      	    while(startInd<endInd){
                                      		thursText[startInd].setStyle("-fx-background-color : #E44535");
                                      		thursText[startInd].setDisable(fillAllArr[startInd]);
                            	        	++startInd;
                                      	  }
											}
										
											
									  }if(startLocal.getDayOfWeek()==DayOfWeek.FRIDAY){
										    int startInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedStartTime());
											int endInd = Arrays.asList(timeSlotString).indexOf(providerSchRecurException.getOccurRange().getBlockedEndTime());
											System.out.println("start and end are :"+startInd+"  "+endInd);
											if(startInd !=-1 &&endInd!=-1){
												Arrays.fill(fillAllArr, startInd, endInd, false);	
                                            	 
                                            	  while(startInd<endInd){
                                            		  friText[startInd].setStyle("-fx-background-color : #E44535");
                                            		  friText[startInd].setDisable(fillAllArr[startInd]);
                                      	        	++startInd;
                                            	  }
											}
										
											
									  }
									startLocal = startLocal.plusDays(1);  
									//recur
									
								}	
									
								}
								
								
							}
						
    		     /*  int ocur = 0;	
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
						*/
						
					}
				
				
			}
           if(providerSchRecurException.getRecurPattern().getWeeklyRecur()==true){
			
        	   
			}
           if(providerSchRecurException.getRecurPattern().getMonthlyRecur()==true){
			
        	   
			}
		}
	}
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clinicNameLabel.setText(Global.clinic.getName());
		toDaySet();
	    clinicScheduleTimeList =	new ClinicScheduleEntityController().viewClinicScheduleByClinicId(Global.clinic.getId());

	  lengthToGen = setByTimeSlot(Integer.parseInt(clinicScheduleTimeList.get(0).getTimeslotSize()));
	  fillAllArr=new boolean[lengthToGen];
	  
	    componentGenerator(lengthToGen);
	   	setFromClinicSchedule(lengthToGen);
	   	viewClinicClosedDate();
	   	viewBlockTime();
	   	getOpenedCheckBox();
	   	recurenceOfProvider();
		/*
		initDirty();
		
		*/
				
		// Set from UI to DB .
		   saveButton.setOnAction((event) -> {
			   Alert alert = new Alert(AlertType.INFORMATION);
			   alert.setTitle("Information Dialog");
			   alert.setHeaderText(null);
			   alert.setContentText("Changes Saved!");

			   alert.showAndWait();
            if(providerBlockSchedulesList.size()>0){
            	
            	new StaffBlockTimeEntityController().saveOrUpdate(providerBlockSchedulesList);
            	providerBlockSchedulesList=null;
            }else if(proBlockDelete.size()>0){
            	
            	new StaffBlockTimeEntityController().delete(proBlockDelete);
            	proBlockDelete = null;
            }
            if(offWeekCheck==1){
            	List<ProviderSchException> proSch = new ArrayList<ProviderSchException>();
            	for(int i=0;i<7;i++){
            	ProviderSchException pro = new ProviderSchException();
            	pro.setProvider(provider);
            	pro.setExcepDate(dateList.get(i));
            	proSch.add(pro);
            	}
            	 new StaffSchExceptionEntityController().saveOrUpdate(proSch);
            }
            if(offWeekCheck==0){
            	openEntireWeekBtnActive=0;
            	List<String> dateBlockEx = new ArrayList<String>();
            	dateBlockEx.add(sunDayTextField.getText());
            	dateBlockEx.add(monDayTextField.getText());
            	dateBlockEx.add(tuesDayTextField.getText());
            	dateBlockEx.add(wednesDayTextField.getText());
            	dateBlockEx.add(thursDayTextField.getText());
            	dateBlockEx.add(friDayTextField.getText());
            	dateBlockEx.add(saturDayTextField.getText());
            	
            	Date stD = string2Date(sunDayTextField.getText());
            	Date stEnd =  string2Date(saturDayTextField.getText());
            	
            	new StaffSchExceptionEntityController().deleteBetweenDates(stD,stEnd,provider);
            	new StaffBlockTimeEntityController().deleteBlockTimeByDate(stD, stEnd, provider);
            	
            	new ProviderBlockDaysExceptionEntityController().saveOrUpdate(dateBlockEx,provider);
               
            }
            
			if(ifCheckClicked==1){
				ifCheckClicked=0;
				if(getSelectedCheckList.get(0)!= openCheckBoxCollumn1.isSelected()){
					
					providerOpenDateList.add(string2Date(sunDayTextField.getText()));
				}
				
				if(getSelectedCheckList.get(1)!= openCheckBoxCollumn2.isSelected()){
					providerOpenDateList.add(string2Date(monDayTextField.getText()));
				}
				if(getSelectedCheckList.get(2)!= openCheckBoxCollumn3.isSelected()){
					
					providerOpenDateList.add(string2Date(tuesDayTextField.getText()));
				}
				if(getSelectedCheckList.get(3)!= openCheckBoxCollumn4.isSelected()){
					providerOpenDateList.add(string2Date(wednesDayTextField.getText()));
					
				}
				if(getSelectedCheckList.get(4)!= openCheckBoxCollumn5.isSelected()){
					providerOpenDateList.add(string2Date(thursDayTextField.getText()));
					
				}
				if(getSelectedCheckList.get(5)!= openCheckBoxCollumn6.isSelected()){
					providerOpenDateList.add(string2Date(friDayTextField.getText()));
					
				}
				if(getSelectedCheckList.get(6)!= openCheckBoxCollumn7.isSelected()){
					providerOpenDateList.add(string2Date(saturDayTextField.getText()));
					
				}
				
				for(int i=0;i<providerOpenDateList.size();i++){
					ProviderSchException providerSchException = new ProviderSchException();
					providerSchException.setProvider(provider);
					providerSchException.setExcepDate(providerOpenDateList.get(i));
					 new StaffSchExceptionEntityController().saveOrUpdateNoDuplicate(providerSchException);
					
				}
			}
			if(workUsualBtnActive==1){
				workUsualBtnActive=0;
				blocksize=1;
				new ProviderBlockDaysExceptionEntityController().delete(sunDayTextField.getText(), saturDayTextField.getText(), provider);
				Date stD = string2Date(sunDayTextField.getText());
            	Date stEnd =  string2Date(saturDayTextField.getText());
            	new StaffSchExceptionEntityController().deleteBetweenDates(stD,stEnd,provider);
			}
		/*	ArrayList<CheckBox> openStatusGroup = getCheckboxGroup();
			ArrayList<TextField> datePanelGroup = getTextfieldGroup();
			// Set clinic into the clinician Schedule
						
			
					
			// Iterate through each checkbox .
			for(int i =0 ; i<7 ; i++)	{
				
				System.out.println("RUN #######################");
				// Get current checkbox
				CheckBox currentCheckbox = openStatusGroup.get(i) ;
				// Get date corresponding to current checkbox .
				String currentPanelDate = datePanelGroup.get(i).getText() ;

				// If current check box is checked ie, Clinic is open .
				if (currentCheckbox.isSelected()) {
					// Search for  current date in DB .
					System.out.println("RUN RUN #######################");
					for (ProviderSchException cli : providerSchDateList) {
						dbDate = date2String(cli.getExcepDate());
						// If Found
						if (dbDate.equals(currentPanelDate)) {
							// Delete row from DB .
							new StaffSchExceptionEntityController().delete(cli.getId());
						}
					}
				}
				// If current is Un-Checked ie, Clinic is closed .
				else if(dirty[i])	{
					Date tempDate = null;
					try {
						tempDate = string2Date(currentPanelDate);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("RUN RUN RUN #######################");
					if(providerSchDateList.isEmpty()){
						//System.out.println("#################### : " +clinic.getName());
						ProviderSchException providerSchException = new ProviderSchException();
						providerSchException.setExcepDate(tempDate);
						System.out.println("Sent Date : "+providerSchException.getExcepDate());
						providerSchException.setProvider(provider);
						new StaffSchExceptionEntityController().saveOrUpdate(providerSchException);
						
						
					}else{
					
					for (ProviderSchException cli : providerSchDateList) {
						// Covert date to string .
						dbDate = date2String(cli.getExcepDate());
						if (dbDate != currentPanelDate) {
							ProviderSchException providerSchException = new ProviderSchException();
							providerSchException.setExcepDate(tempDate);
							System.out.println("Sent Date : "+providerSchException.getExcepDate());
							providerSchException.setProvider(provider);
							
							new StaffSchExceptionEntityController().saveOrUpdateNoDuplicate(providerSchException);
							
							//break;
						}
					}
					}
				}
			}//End of Check box loop .
		});
		
		openEntireWeekButton.setOnAction((event) -> {
			try {
				
				openCheckBox();
				setProviderByDate();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}*/
		});
		   
	  openEntireWeekButton.setOnAction((event) -> {
		  
				try {
					
					
					offWeekCheck=0;
					openEntireWeekBtnActive=1;
					openCheckBox();
					setFromClinicSchedule(lengthToGen);
					viewClinicClosedDate();
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
	  List<Boolean> choiceBoxList = new ArrayList<Boolean>();
	   
		closedEntireWeekButton.setOnAction((event) -> {
			offWeekCheck=1;
			try {
				
				checkIfClosedClicked=1;
		      Arrays.fill(fillAllArr, true);
		      choiceBoxList.add(0, openCheckBoxCollumn1.isSelected());
		      choiceBoxList.add(1, openCheckBoxCollumn2.isSelected());
		      choiceBoxList.add(2, openCheckBoxCollumn3.isSelected());
		      choiceBoxList.add(3, openCheckBoxCollumn4.isSelected());
		      choiceBoxList.add(4, openCheckBoxCollumn5.isSelected());
		      choiceBoxList.add(5, openCheckBoxCollumn6.isSelected());
		      choiceBoxList.add(6, openCheckBoxCollumn7.isSelected());
		      
				closeCheckBox();
				for(int i=0;i<lengthToGen;i++){
					sundayText[i].setDisable(fillAllArr[i]);
					
					monText[i].setDisable(fillAllArr[i]);
					
					tuesText[i].setDisable(fillAllArr[i]);
					wedText[i].setDisable(fillAllArr[i]);
					thursText[i].setDisable(fillAllArr[i]);
					friText[i].setDisable(fillAllArr[i]);
					satText[i].setDisable(fillAllArr[i]);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		workUsualWeekButton.setOnAction((event) -> {
			try {
				workUsualWeekBtnActive=1;
				if(checkIfClosedClicked==1){
				
					
					openCheckBoxCollumn1.setSelected(choiceBoxList.get(0));
					openCheckBoxCollumn2.setSelected(choiceBoxList.get(1));
					openCheckBoxCollumn3.setSelected(choiceBoxList.get(2));
					openCheckBoxCollumn4.setSelected(choiceBoxList.get(3));
					openCheckBoxCollumn5.setSelected(choiceBoxList.get(4));
					openCheckBoxCollumn6.setSelected(choiceBoxList.get(5));
					openCheckBoxCollumn7.setSelected(choiceBoxList.get(6));
					
					checkIfClosedClicked=0;	
				
				}
				
			
				for(int i=0;i<lengthToGen;i++){
				sundayText[i].setDisable(activeClinicTimeSun[i]);	
				monText[i].setDisable(activeClinicTimeMon[i]);	
				tuesText[i].setDisable(activeClinicTimeTues[i]);	
				wedText[i].setDisable(activeClinicTimeWed[i]);	
				thursText[i].setDisable(activeClinicTimeThurs[i]);	
				friText[i].setDisable(activeClinicTimeFri[i]);	
				satText[i].setDisable(activeClinicTimeSat[i]);
				}
				workUsualBtnActive=1;
				
				setFromClinicSchedule(lengthToGen);
				viewBlockTime();
				viewClinicClosedDate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}	});
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
