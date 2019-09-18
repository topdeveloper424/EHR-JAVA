package com.ets.controller.gui.emrCharting;

import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.model.PatientAppointment;
import com.ets.model.Provider;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ViewPatientAppointmentController implements Initializable {
	
	 @FXML
	    private GridPane gridTest;

	    @FXML
	    private TextField cell01;

	    @FXML
	    private TextField cell11;

	    @FXML
	    private TextField cell21;

	    @FXML
	    private TextField cell31;

	    @FXML
	    private TextField cell41;

	    @FXML
	    private TextField cell51;

	    @FXML
	    private TextField cell61;

	    @FXML
	    private TextField cell71;

	    @FXML
	    private TextField cell81;

	    @FXML
	    private TextField cell91;

	    @FXML
	    private TextField cell101;

	    @FXML
	    private TextField cell111;

	    @FXML
	    private TextField cell121;

	    @FXML
	    private TextField cell131;

	    @FXML
	    private TextField cell141;

	    @FXML
	    private TextField cell151;

	    @FXML
	    private TextField cell161;

	    @FXML
	    private TextField cell171;

	    @FXML
	    private TextField cell181;

	    @FXML
	    private TextField cell191;

	    @FXML
	    private TextField cell211;

	    @FXML
	    private TextField cell192;

	    @FXML
	    private TextField cell182;

	    @FXML
	    private TextField cell172;

	    @FXML
	    private TextField cell162;

	    @FXML
	    private TextField cell152;

	    @FXML
	    private TextField cell142;

	    @FXML
	    private TextField cell132;

	    @FXML
	    private TextField cell122;

	    @FXML
	    private TextField cell112;

	    @FXML
	    private TextField cell102;

	    @FXML
	    private TextField cell92;

	    @FXML
	    private TextField cell82;

	    @FXML
	    private TextField cell72;

	    @FXML
	    private TextField cell62;

	    @FXML
	    private TextField cell52;

	    @FXML
	    private TextField cell42;

	    @FXML
	    private TextField cell32;

	    @FXML
	    private TextField cell22;

	    @FXML
	    private TextField cell12;

	    @FXML
	    private TextField cell02;

	    @FXML
	    private TextField cell03;

	    @FXML
	    private TextField cell04;

	    @FXML
	    private TextField cell05;

	    @FXML
	    private TextField cell06;

	    @FXML
	    private TextField cell07;

	    @FXML
	    private TextField cell13;

	    @FXML
	    private TextField cell23;

	    @FXML
	    private TextField cell33;

	    @FXML
	    private TextField cell43;

	    @FXML
	    private TextField cell53;

	    @FXML
	    private TextField cell63;

	    @FXML
	    private TextField cell73;

	    @FXML
	    private TextField cell83;

	    @FXML
	    private TextField cell93;

	    @FXML
	    private TextField cell103;

	    @FXML
	    private TextField cell113;

	    @FXML
	    private TextField cell123;

	    @FXML
	    private TextField cell133;

	    @FXML
	    private TextField cell143;

	    @FXML
	    private TextField cell153;

	    @FXML
	    private TextField cell163;

	    @FXML
	    private TextField cell173;

	    @FXML
	    private TextField cell183;

	    @FXML
	    private TextField cell203;

	    @FXML
	    private TextField cell213;

	    @FXML
	    private TextField cell201;

	    @FXML
	    private TextField cell193;

	    @FXML
	    private TextField cell14;

	    @FXML
	    private TextField cell24;

	    @FXML
	    private TextField cell34;

	    @FXML
	    private TextField cell44;

	    @FXML
	    private TextField cell54;

	    @FXML
	    private TextField cell64;

	    @FXML
	    private TextField cell74;

	    @FXML
	    private TextField cell84;

	    @FXML
	    private TextField cell94;

	    @FXML
	    private TextField cell104;

	    @FXML
	    private TextField cell114;

	    @FXML
	    private TextField cell124;

	    @FXML
	    private TextField cell15;

	    @FXML
	    private TextField cell16;

	    @FXML
	    private TextField cell17;

	    @FXML
	    private TextField cell25;

	    @FXML
	    private TextField cell26;

	    @FXML
	    private TextField cell27;

	    @FXML
	    private TextField cell35;

	    @FXML
	    private TextField cell36;

	    @FXML
	    private TextField cell37;

	    @FXML
	    private TextField cell45;

	    @FXML
	    private TextField cell46;

	    @FXML
	    private TextField cell47;

	    @FXML
	    private TextField cell55;

	    @FXML
	    private TextField cell56;

	    @FXML
	    private TextField cell57;

	    @FXML
	    private TextField cell65;

	    @FXML
	    private TextField cell66;

	    @FXML
	    private TextField cell67;

	    @FXML
	    private TextField cell75;

	    @FXML
	    private TextField cell76;

	    @FXML
	    private TextField cell77;

	    @FXML
	    private TextField cell85;

	    @FXML
	    private TextField cell86;

	    @FXML
	    private TextField cell87;

	    @FXML
	    private TextField cell95;

	    @FXML
	    private TextField cell96;

	    @FXML
	    private TextField cell97;

	    @FXML
	    private TextField cell105;

	    @FXML
	    private TextField cell106;

	    @FXML
	    private TextField cell107;

	    @FXML
	    private TextField cell115;

	    @FXML
	    private TextField cell116;

	    @FXML
	    private TextField cell117;

	    @FXML
	    private TextField cell125;

	    @FXML
	    private TextField cell126;

	    @FXML
	    private TextField cell127;

	    @FXML
	    private TextField cell134;

	    @FXML
	    private TextField cell135;

	    @FXML
	    private TextField cell136;

	    @FXML
	    private TextField cell137;

	    @FXML
	    private TextField cell147;

	    @FXML
	    private TextField cell157;

	    @FXML
	    private TextField cell167;

	    @FXML
	    private TextField cell177;

	    @FXML
	    private TextField cell187;

	    @FXML
	    private TextField cell197;

	    @FXML
	    private TextField cell207;

	    @FXML
	    private TextField cell217;

	    @FXML
	    private TextField cell216;

	    @FXML
	    private TextField cell215;

	    @FXML
	    private TextField cell214;

	    @FXML
	    private TextField cell204;

	    @FXML
	    private TextField cell194;

	    @FXML
	    private TextField cell205;

	    @FXML
	    private TextField cell206;

	    @FXML
	    private TextField cell195;

	    @FXML
	    private TextField cell196;

	    @FXML
	    private TextField cell186;

	    @FXML
	    private TextField cell146;

	    @FXML
	    private TextField cell156;

	    @FXML
	    private TextField cell166;

	    @FXML
	    private TextField cell176;

	    @FXML
	    private TextField cell185;

	    @FXML
	    private TextField cell175;

	    @FXML
	    private TextField cell145;

	    @FXML
	    private TextField cell155;

	    @FXML
	    private TextField cell165;

	    @FXML
	    private TextField cell144;

	    @FXML
	    private TextField cell154;

	    @FXML
	    private TextField cell164;

	    @FXML
	    private TextField cell174;

	    @FXML
	    private TextField cell184;

	    @FXML
	    private TextField cell202;

	    @FXML
	    private TextField cell212;

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
	    private ComboBox<String> providerChoiceBoxList;

	    @FXML
	    private Button closeButton;
	    
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

					Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
					s = formatter1.format(date2);

					if (text.equals("Sun")) {
						Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
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

						DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

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
					
					
					reFresh();

				}

				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

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

				Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
				s = formatter1.format(date2);

				if (text.equals("Sun")) {

					Format formatter2 = new SimpleDateFormat("yyyy-MM-dd");
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

					DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

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
	    
	    private ObservableList<String> patientAppointmentMasterData = FXCollections.observableArrayList();

		private List<Provider> providertList = new ProviderEntityController().viewByClinicId(Global.clinic.getId());
	    
	    public void viewProvider() {

			for (Provider provider : providertList) {

				String name1 = provider.getFirstName();
				String name2 = provider.getMiddleName();
				String name3 = provider.getLastName();

				patientAppointmentMasterData.addAll(name1 + " " + name2 + " " + name3);

			}

			providerChoiceBoxList.getItems().clear();
			providerChoiceBoxList.setItems(patientAppointmentMasterData);
			providerChoiceBoxList.setValue(patientAppointmentMasterData.get(0));
			
			
		}
	    
	    public ObservableList<PatientAppointment> appointmentList = null;
	    
	    public void viewpatientAppointmentByProvider(){
	    	String providerName = providerChoiceBoxList.getSelectionModel().getSelectedItem();
	    		    	
			String providerNameArr[] = providerName.split(" ");
			appointmentList = new PatientAppointmentEntityController().viewByProvider(providerNameArr[0], providerNameArr[2]);
			System.out.println("Appointment List Size is : ... " +appointmentList.size());
	    }
	    
	    @FXML
	    void providerSelect(ActionEvent event) {
	    	
	    	String providerName = providerChoiceBoxList.getSelectionModel().getSelectedItem();
	    
			String providerNameArr[] = providerName.split(" ");
			appointmentList = new PatientAppointmentEntityController().viewByProvider(providerNameArr[0], providerNameArr[2]);
			
			reFresh();
	    }
	    
	 
	    Date date = null;
	    public void reFresh() {

	        String dateInString = thursDayTextField.getText();
	      
	        
	        
	        try {
	        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	             date = formatter.parse(dateInString);
	            
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			

				cell02.setText("");
				cell02.setStyle(null);
				cell03.setText("");
				cell03.setStyle(null);
				cell04.setText("");
				cell04.setStyle(null);
				cell05.setText("");
				cell05.setStyle(null);
				cell06.setText("");
				cell06.setStyle(null);
				cell07.setText("");
				cell07.setStyle(null);
				
				cell12.setText("");
				cell12.setStyle(null);
				cell13.setText("");
				cell13.setStyle(null);
				cell14.setText("");
				cell14.setStyle(null);
				cell15.setText("");
				cell15.setStyle(null);
				cell16.setText("");
				cell16.setStyle(null);
				cell17.setText("");
				cell17.setStyle(null);
				
				cell21.setText("");
				cell22.setStyle(null);
				cell23.setText("");
				cell23.setStyle(null);
				cell24.setText("");
				cell24.setStyle(null);
				cell25.setText("");
				cell25.setStyle(null);
				cell26.setText("");
				cell26.setStyle(null);
				cell27.setText("");
				cell27.setStyle(null);
				
				
				
				/*String [] timeArr = {"7:00 AM","7:30 AM","8:00 AM","8:30 AM",
                         "9:00 AM","9:30 AM","10:00 AM","10:30 AM","11:00 AM","11:30 AM"
                         ,"12:00 PM","12:30 PM","1:00 PM","1:30 PM","2:00 PM","2:30 PM"
                         ,"3:00 PM","3:30 PM","4:00 PM","4:30 PM","5:00 PM"};
				
			*/
				
				for (PatientAppointment patientAppointment : appointmentList) {
					
				 // for(int i=0;i<timeArr.length;i++){
					
					if(patientAppointment.getApptTime().equals("7:00 AM")){
						
						
						if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
							
							cell02.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());
							
							cell02.setStyle(" -fx-background-color: cccccc;");
	
							System.out.println("%%%%"+patientAppointment.getApptTime());
						
						}
						
						 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
							
	                	cell03.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
	                	cell03.setStyle(" -fx-background-color: cccccc;");

						}
						
	            	
						 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
							
							cell04.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
							cell04.setStyle(" -fx-background-color: cccccc;");	

						}
	                
						  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
						
	                	cell05.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
	                	cell05.setStyle(" -fx-background-color: cccccc;");		

					}
						  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
						
							  cell06.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell06.setStyle(" -fx-background-color: cccccc;");			

					}	
						  
						  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
								
							  cell07.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell07.setStyle(" -fx-background-color: cccccc;");				

					}	
						
					}
					
					

					if(patientAppointment.getApptTime().equals("7:30 AM")){
						
						
						if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
							
							cell12.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());
							
							cell12.setStyle(" -fx-background-color: cccccc;");
	
							System.out.println("%%%%"+patientAppointment.getApptTime());
						
						}
						
						 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
							
							 cell13.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
							 cell13.setStyle(" -fx-background-color: cccccc;");

						}
						
	            	
						 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
							
							 cell14.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
							 cell14.setStyle(" -fx-background-color: cccccc;");	

						}
	                
						  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
						
							  cell15.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
							  cell15.setStyle(" -fx-background-color: cccccc;");		

					}
						  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
						
							  cell16.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell16.setStyle(" -fx-background-color: cccccc;");			

					}	
						  
						  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
								
							  cell17.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell17.setStyle(" -fx-background-color: cccccc;");				

					}	
						
					}
					
					
	                    if(patientAppointment.getApptTime().equals("8:00 AM")){
						
						
						if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
							
							cell22.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());
							
							cell22.setStyle(" -fx-background-color: cccccc;");
	
							System.out.println("%%%%"+patientAppointment.getApptTime());
						
						}
						
						 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
							
							 cell23.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
							 cell23.setStyle(" -fx-background-color: cccccc;");

						}
						
	            	
						 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
							
							 cell24.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
							 cell24.setStyle(" -fx-background-color: cccccc;");	

						}
	                
						  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
						
							  cell25.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
								+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
								+ patientAppointment.getPurpose());	
							  cell25.setStyle(" -fx-background-color: cccccc;");		

					}
						  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
						
							  cell26.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell26.setStyle(" -fx-background-color: cccccc;");			

					}	
						  
						  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
								
							  cell27.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
							  cell27.setStyle(" -fx-background-color: cccccc;");				

					}	
						
					}
					
	                    
	                    
	                    if(patientAppointment.getApptTime().equals("8:30 AM")){
							
							
							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
								
								cell32.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());
								
								cell32.setStyle(" -fx-background-color: cccccc;");
		
								System.out.println("%%%%"+patientAppointment.getApptTime());
							
							}
							
							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
								
								 cell33.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								 cell33.setStyle(" -fx-background-color: cccccc;");

							}
							
		            	
							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
								
								 cell34.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
								 cell34.setStyle(" -fx-background-color: cccccc;");	

							}
		                
							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
							
								  cell35.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								  cell35.setStyle(" -fx-background-color: cccccc;");		

						}
							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
							
								  cell36.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell36.setStyle(" -fx-background-color: cccccc;");			

						}	
							  
							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
									
								  cell37.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell37.setStyle(" -fx-background-color: cccccc;");				

						}	
							
						}
						
		                    
	                    
	                    
	                    if(patientAppointment.getApptTime().equals("9:00 AM")){
							
							
							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
								
								cell42.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());
								
								cell42.setStyle(" -fx-background-color: cccccc;");
		
								System.out.println("%%%%"+patientAppointment.getApptTime());
							
							}
							
							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
								
								 cell43.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								 cell43.setStyle(" -fx-background-color: cccccc;");

							}
							
		            	
							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
								
								 cell44.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
								 cell44.setStyle(" -fx-background-color: cccccc;");	

							}
		                
							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
							
								  cell45.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								  cell45.setStyle(" -fx-background-color: cccccc;");		

						}
							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
							
								  cell46.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell46.setStyle(" -fx-background-color: cccccc;");			

						}	
							  
							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
									
								  cell47.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell47.setStyle(" -fx-background-color: cccccc;");				

						}	
							
						}
					
	                    
	                    
	                    if(patientAppointment.getApptTime().equals("9:30 AM")){
							
							
							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
								
								cell52.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());
								
								cell52.setStyle(" -fx-background-color: cccccc;");
		
								System.out.println("%%%%"+patientAppointment.getApptTime());
							
							}
							
							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
								
								 cell53.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								 cell53.setStyle(" -fx-background-color: cccccc;");

							}
							
		            	
							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
								
								 cell54.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
								 cell54.setStyle(" -fx-background-color: cccccc;");	

							}
		                
							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
							
								  cell55.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								  cell55.setStyle(" -fx-background-color: cccccc;");		

						}
							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
							
								  cell56.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell56.setStyle(" -fx-background-color: cccccc;");			

						}	
							  
							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
									
								  cell57.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell57.setStyle(" -fx-background-color: cccccc;");				

						}	
							
						}
	                    
	                    
	                    
                         if(patientAppointment.getApptTime().equals("10:00 AM")){
							
							
							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
								
								cell62.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());
								
								cell62.setStyle(" -fx-background-color: cccccc;");
		
								System.out.println("%%%%"+patientAppointment.getApptTime());
							
							}
							
							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
								
								 cell63.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								 cell63.setStyle(" -fx-background-color: cccccc;");

							}
							
		            	
							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
								
								 cell64.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
								 cell64.setStyle(" -fx-background-color: cccccc;");	

							}
		                
							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
							
								  cell65.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								  cell65.setStyle(" -fx-background-color: cccccc;");		

						}
							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
							
								  cell66.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell66.setStyle(" -fx-background-color: cccccc;");			

						}	
							  
							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
									
								  cell67.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell67.setStyle(" -fx-background-color: cccccc;");				

						}	
							
						}
			
                         
                         
                         
                         if(patientAppointment.getApptTime().equals("10:30 AM")){
							
							
							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
								
								cell72.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());
								
								cell72.setStyle(" -fx-background-color: cccccc;");
		
								System.out.println("%%%%"+patientAppointment.getApptTime());
							
							}
							
							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
								
								 cell73.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								 cell73.setStyle(" -fx-background-color: cccccc;");

							}
							
		            	
							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
								
								 cell74.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
										+ patientAppointment.getPurpose());	
								 cell74.setStyle(" -fx-background-color: cccccc;");	

							}
		                
							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
							
								  cell75.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
									+ patientAppointment.getPurpose());	
								  cell75.setStyle(" -fx-background-color: cccccc;");		

						}
							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
							
								  cell76.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell76.setStyle(" -fx-background-color: cccccc;");			

						}	
							  
							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
									
								  cell77.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
											+ patientAppointment.getPurpose());	
								  cell77.setStyle(" -fx-background-color: cccccc;");				

						}	
							
						}
                         
                         
                         
                         
                         if(patientAppointment.getApptTime().equals("11:00 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell82.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell82.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 								cell83.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell82.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell84.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell84.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 		                	cell85.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 		                	cell85.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								  cell86.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell86.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								  cell87.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell87.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         
                         

                         if(patientAppointment.getApptTime().equals("11:30 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell92.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell92.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 		                	cell93.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 		                	cell93.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell94.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell94.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 		                	cell95.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 		                	cell95.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								  cell96.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell96.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								  cell97.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell97.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         

                         if(patientAppointment.getApptTime().equals("12:00 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell102.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell02.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 								cell103.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 		                	cell103.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell104.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell104.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 		                	cell105.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 		                	cell105.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								  cell106.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell106.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								  cell107.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								  cell107.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         
                         
                         
                         if(patientAppointment.getApptTime().equals("12:30 AM")){
  							
  							
  							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
  								
  								cell112.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());
  								
  								cell112.setStyle(" -fx-background-color: cccccc;");
  		
  								System.out.println("%%%%"+patientAppointment.getApptTime());
  							
  							}
  							
  							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
  								
  								cell113.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell113.setStyle(" -fx-background-color: cccccc;");

  							}
  							
  		            	
  							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
  								
  								cell114.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());	
  								cell114.setStyle(" -fx-background-color: cccccc;");	

  							}
  		                
  							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
  							
  								cell115.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell115.setStyle(" -fx-background-color: cccccc;");		

  						}
  							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
  							
  								cell116.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell116.setStyle(" -fx-background-color: cccccc;");			

  						}	
  							  
  							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
  									
  								cell117.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell117.setStyle(" -fx-background-color: cccccc;");				

  						}	
  							
  						}
                         
                         if(patientAppointment.getApptTime().equals("1:00 AM")){
   							
   							
   							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
   								
   								cell122.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   										+ patientAppointment.getPurpose());
   								
   								cell122.setStyle(" -fx-background-color: cccccc;");
   		
   								System.out.println("%%%%"+patientAppointment.getApptTime());
   							
   							}
   							
   							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
   								
   								cell123.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   									+ patientAppointment.getPurpose());	
   								cell123.setStyle(" -fx-background-color: cccccc;");

   							}
   							
   		            	
   							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
   								
   								cell124.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   										+ patientAppointment.getPurpose());	
   								cell124.setStyle(" -fx-background-color: cccccc;");	

   							}
   		                
   							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
   							
   								cell127.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   									+ patientAppointment.getPurpose());	
   								cell127.setStyle(" -fx-background-color: cccccc;");		

   						}
   							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
   							
   								cell125.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   											+ patientAppointment.getPurpose());	
   								cell125.setStyle(" -fx-background-color: cccccc;");			

   						}	
   							  
   							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
   									
   								cell126.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   											+ patientAppointment.getPurpose());	
   								cell126.setStyle(" -fx-background-color: cccccc;");				

   						}	
   							
   						}
                         
                         
                         if(patientAppointment.getApptTime().equals("1:30 AM")){
    							
    							
    							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
    								
    								cell132.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    										+ patientAppointment.getPurpose());
    								
    								cell132.setStyle(" -fx-background-color: cccccc;");
    		
    								System.out.println("%%%%"+patientAppointment.getApptTime());
    							
    							}
    							
    							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
    								
    								 cell133.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    									+ patientAppointment.getPurpose());	
    								 cell133.setStyle(" -fx-background-color: cccccc;");

    							}
    							
    		            	
    							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
    								
    								 cell134.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    										+ patientAppointment.getPurpose());	
    								 cell134.setStyle(" -fx-background-color: cccccc;");	

    							}
    		                
    							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
    							
    								  cell135.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    									+ patientAppointment.getPurpose());	
    								  cell135.setStyle(" -fx-background-color: cccccc;");		

    						}
    							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
    							
    								  cell136.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    											+ patientAppointment.getPurpose());	
    								  cell136.setStyle(" -fx-background-color: cccccc;");			

    						}	
    							  
    							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
    									
    								  cell137.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    											+ patientAppointment.getPurpose());	
    								  cell137.setStyle(" -fx-background-color: cccccc;");				

    						}	
    							
    						}
  				
                         
                         if(patientAppointment.getApptTime().equals("2:00 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell142.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell142.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 								cell143.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell143.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell144.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell144.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 								 cell145.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell145.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								 cell146.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell146.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								 cell147.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell147.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         
                         
                         if(patientAppointment.getApptTime().equals("2:30 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell152.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell152.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 								cell153.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell153.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell154.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell154.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 								 cell155.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell155.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								 cell156.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell156.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								 cell157.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell157.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         if(patientAppointment.getApptTime().equals("3:00 AM")){
  							
  							
  							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
  								
  								cell162.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());
  								
  								cell162.setStyle(" -fx-background-color: cccccc;");
  		
  								System.out.println("%%%%"+patientAppointment.getApptTime());
  							
  							}
  							
  							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
  								
  								cell163.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell163.setStyle(" -fx-background-color: cccccc;");

  							}
  							
  		            	
  							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
  								
  								cell164.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());	
  								cell164.setStyle(" -fx-background-color: cccccc;");	

  							}
  		                
  							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
  							
  								cell165.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell165.setStyle(" -fx-background-color: cccccc;");		

  						}
  							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
  							
  								cell166.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell166.setStyle(" -fx-background-color: cccccc;");			

  						}	
  							  
  							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
  									
  								cell167.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell167.setStyle(" -fx-background-color: cccccc;");				

  						}	
  							
  						}
                         if(patientAppointment.getApptTime().equals("3:30 AM")){
   							
   							
   							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
   								
   								cell172.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   										+ patientAppointment.getPurpose());
   								
   								cell172.setStyle(" -fx-background-color: cccccc;");
   		
   								System.out.println("%%%%"+patientAppointment.getApptTime());
   							
   							}
   							
   							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
   								
   								cell173.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   									+ patientAppointment.getPurpose());	
   								cell173.setStyle(" -fx-background-color: cccccc;");

   							}
   							
   		            	
   							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
   								
   								cell174.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   										+ patientAppointment.getPurpose());	
   								cell174.setStyle(" -fx-background-color: cccccc;");	

   							}
   		                
   							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
   							
   								cell175.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   									+ patientAppointment.getPurpose());	
   								cell175.setStyle(" -fx-background-color: cccccc;");		

   						}
   							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
   							
   								cell176.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   											+ patientAppointment.getPurpose());	
   								cell176.setStyle(" -fx-background-color: cccccc;");			

   						}	
   							  
   							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
   									
   								cell177.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
   											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
   											+ patientAppointment.getPurpose());	
   								cell177.setStyle(" -fx-background-color: cccccc;");				

   						}	
   							
   						}
                         if(patientAppointment.getApptTime().equals("4:00 AM")){
    							
    							
    							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
    								
    								cell182.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    										+ patientAppointment.getPurpose());
    								
    								cell182.setStyle(" -fx-background-color: cccccc;");
    		
    								System.out.println("%%%%"+patientAppointment.getApptTime());
    							
    							}
    							
    							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
    								
    								 cell183.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    									+ patientAppointment.getPurpose());	
    								 cell183.setStyle(" -fx-background-color: cccccc;");

    							}
    							
    		            	
    							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
    								
    								 cell184.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    										+ patientAppointment.getPurpose());	
    								 cell184.setStyle(" -fx-background-color: cccccc;");	

    							}
    		                
    							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
    							
    								  cell185.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    									+ patientAppointment.getPurpose());	
    								  cell185.setStyle(" -fx-background-color: cccccc;");		

    						}
    							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
    							
    								  cell186.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    											+ patientAppointment.getPurpose());	
    								  cell186.setStyle(" -fx-background-color: cccccc;");			

    						}	
    							  
    							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
    									
    								  cell187.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
    											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
    											+ patientAppointment.getPurpose());	
    								  cell187.setStyle(" -fx-background-color: cccccc;");				

    						}	
    							
    						}
                         
                         
                         if(patientAppointment.getApptTime().equals("4:30 AM")){
 							
 							
 							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
 								
 								cell192.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());
 								
 								cell192.setStyle(" -fx-background-color: cccccc;");
 		
 								System.out.println("%%%%"+patientAppointment.getApptTime());
 							
 							}
 							
 							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
 								
 								cell193.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell193.setStyle(" -fx-background-color: cccccc;");

 							}
 							
 		            	
 							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
 								
 								cell194.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 										+ patientAppointment.getPurpose());	
 								cell194.setStyle(" -fx-background-color: cccccc;");	

 							}
 		                
 							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
 							
 								 cell195.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 									+ patientAppointment.getPurpose());	
 								cell195.setStyle(" -fx-background-color: cccccc;");		

 						}
 							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
 							
 								 cell196.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell196.setStyle(" -fx-background-color: cccccc;");			

 						}	
 							  
 							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
 									
 								 cell197.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
 											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
 											+ patientAppointment.getPurpose());	
 								cell197.setStyle(" -fx-background-color: cccccc;");				

 						}	
 							
 						}
                         
                         
                         if(patientAppointment.getApptTime().equals("5:00 AM")){
  							
  							
  							if(patientAppointment.getApptDate().toString().equals((monDayTextField.getText())) ){
  								
  								cell202.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());
  								
  								cell202.setStyle(" -fx-background-color: cccccc;");
  		
  								System.out.println("%%%%"+patientAppointment.getApptTime());
  							
  							}
  							
  							 if(patientAppointment.getApptDate().toString().equals(tuesDayTextField.getText())){
  								
  								cell203.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell203.setStyle(" -fx-background-color: cccccc;");

  							}
  							
  		            	
  							 if(patientAppointment.getApptDate().toString().equals(wednesDayTextField.getText())){
  								
  								cell204.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  										+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  										+ patientAppointment.getPurpose());	
  								cell204.setStyle(" -fx-background-color: cccccc;");	

  							}
  		                
  							  if(patientAppointment.getApptDate().toString().equals(thursDayTextField.getText())){
  							
  								cell205.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  									+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  									+ patientAppointment.getPurpose());	
  								cell205.setStyle(" -fx-background-color: cccccc;");		

  						}
  							  if(patientAppointment.getApptDate( ).toString().equals(friDayTextField.getText())){
  							
  								cell206.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell206.setStyle(" -fx-background-color: cccccc;");			

  						}	
  							  
  							  if(patientAppointment.getApptDate( ).toString().equals(saturDayTextField.getText())){
  									
  								cell207.setText(patientAppointment.getPatient().getPatientName().getFirstName()+ " "
  											+ patientAppointment.getPatient().getPatientName().getLastName() + " " + "/" + patientAppointment.getStatus() + "/"
  											+ patientAppointment.getPurpose());	
  								cell207.setStyle(" -fx-background-color: cccccc;");				

  						}	
  							
  						}
				}
				
				
				
                
				System.out.println("$$$$$$$$$$$$$$"+appointmentList.size());
				
				
				/*for (PatientAppointment apt : appointmentList) {

					if (apt.getApptTime().equals("7:00 AM")) {

						cell02.setText(apt.getPatient().getPatientName().getFirstName() + " "
								+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
								+ apt.getPurpose());
						cell02.setStyle(" -fx-background-color: cccccc;");

					} else if (apt.getApptTime().equals("7:30 AM")) {

						cell12.setText(apt.getPatient().getPatientName().getFirstName() + " "
								+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
								+ apt.getPurpose());
						cell12.setStyle(" -fx-background-color: cccccc;");

					}
					
				}*/
				}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewProvider();
		toDaySet();
		viewpatientAppointmentByProvider();
		
	}

}
