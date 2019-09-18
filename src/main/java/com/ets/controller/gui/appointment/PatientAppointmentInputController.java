package com.ets.controller.gui.appointment;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;
import com.ets.controller.gui.appointment.schedule.ScheduleController;
import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeViewController;
import com.ets.model.Clinician;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.Provider;
import com.ets.model.ReferalProvider;
import com.ets.model.VisitCategory;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.utils.InitSpinner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class PatientAppointmentInputController implements Initializable {

	@FXML
	private Button OkButton;

	@FXML
	private Button CancleButton;

	@FXML
	private ChoiceBox<String> appointmentTypeChoiceBox;

	@FXML
	private DatePicker dateField;

	@FXML
	private TextField visitCategoryText;

	@FXML
	private TextField clinicianText;

	@FXML
	private TextField referredByText;

	@FXML
	private TextField purposetext;

	@FXML
	private Spinner<String> minutesReqdSpinner;

	@FXML
	private TextField providerText;

	@FXML
	private TextField timeText;

	@FXML
	private TextField cancelReasonText;

	@FXML
	private TextArea appointment5ReasonTextArea;

	@FXML
	private ChoiceBox<String> statusChoiceBox;

	@FXML
	private Button clinicianButton;

	@FXML
	private Button visitCategoryButton;

	@FXML
	private Button providerButton;

	@FXML
	private Button refferedByButton;

	@FXML
	private TextField idTextField;

	@FXML
	private Label clinicianName;

	@FXML
	private Label nameProviderLabel;

	@FXML
	private Label providerName;
	
	
	private ObservableList<PatientAppointment> patientAppointmentCheckPatientList;

	public void setProviderName(String name) {
		providerName.setText(name);
		// nameProviderLabel.setText(name);

	}
	/*
	 * public void setProviderId(Integer proID){
	 * 
	 * providerText.setText(Integer.toString(proID));
	 * 
	 * 
	 * }
	 */

	// set appointment time
	@FXML
	void onMouseDragExitedOverTime(MouseEvent event) {

		if (timeText.getText().isEmpty()) {
			timeText.setText("7:00 AM");

		}

		else if (timeText.getText().matches("7.*")) {

			if ((timeText.getText().equals("73")) || timeText.getText().equals("7.3")
					|| timeText.getText().equals("7.30") || timeText.getText().equalsIgnoreCase(("7.30 am"))
					|| timeText.getText().equalsIgnoreCase("7.30am") || timeText.getText().equalsIgnoreCase("7:30am")
					|| timeText.getText().equalsIgnoreCase("730am") || timeText.getText().equalsIgnoreCase("730 AM")
					|| timeText.getText().equalsIgnoreCase("7:30am") || timeText.getText().equalsIgnoreCase("7:30 am")
					|| timeText.getText().equals("7:3am") || timeText.getText().equals("7:3 am")
					|| timeText.getText().equals("730")) {

				timeText.setText("7:30 AM");

			} else {
				timeText.setText("7:00 AM");

			}

		} else if (timeText.getText().matches("8.*")) {

			if ((timeText.getText().equals("83")) || timeText.getText().equals("8.3")
					|| timeText.getText().equals("8.30") || timeText.getText().equalsIgnoreCase(("8.30 am"))
					|| timeText.getText().equalsIgnoreCase("8.30am") || timeText.getText().equalsIgnoreCase("8:30am")
					|| timeText.getText().equalsIgnoreCase("830am") || timeText.getText().equalsIgnoreCase("830 AM")
					|| timeText.getText().equalsIgnoreCase("8:30am") || timeText.getText().equalsIgnoreCase("8:30 am")
					|| timeText.getText().equals("8:3am") || timeText.getText().equals("8:3 am")
					|| timeText.getText().equals("830")) {

				timeText.setText("8:30 AM");

			} else {
				timeText.setText("8:00 AM");

			}

		} else if (timeText.getText().matches("9.*")) {

			if ((timeText.getText().equals("93")) || timeText.getText().equals("9.3")
					|| timeText.getText().equals("9.30") || timeText.getText().equalsIgnoreCase(("9.30 am"))
					|| timeText.getText().equalsIgnoreCase("9.30am") || timeText.getText().equalsIgnoreCase("9:30am")
					|| timeText.getText().equalsIgnoreCase("930am") || timeText.getText().equalsIgnoreCase("930 AM")
					|| timeText.getText().equalsIgnoreCase("9:30am") || timeText.getText().equalsIgnoreCase("9:30 am")
					|| timeText.getText().equals("9:3am") || timeText.getText().equals("9:3 am")
					|| timeText.getText().equals("930")) {

				timeText.setText("9:30 AM");

			} else {
				timeText.setText("9:00 AM");

			}
		} else if (timeText.getText().matches("10.*")) {

			if ((timeText.getText().equals("103")) || timeText.getText().equals("10.3")
					|| timeText.getText().equals("10.30") || timeText.getText().equalsIgnoreCase(("10.30 am"))
					|| timeText.getText().equalsIgnoreCase("10.30am") || timeText.getText().equalsIgnoreCase("10:30am")
					|| timeText.getText().equalsIgnoreCase("1030am") || timeText.getText().equalsIgnoreCase("1030 AM")
					|| timeText.getText().equalsIgnoreCase("10:30am") || timeText.getText().equalsIgnoreCase("10:30 am")
					|| timeText.getText().equals("10:3am") || timeText.getText().equals("10:3 am")
					|| timeText.getText().equals("1030")) {

				timeText.setText("10:30 AM");

			} else {
				timeText.setText("10:00 AM");

			}

		} else if (timeText.getText().matches("11.*")) {

			if ((timeText.getText().equals("113")) || timeText.getText().equals("11.3")
					|| timeText.getText().equals("11.30") || timeText.getText().equalsIgnoreCase(("11.30 am"))
					|| timeText.getText().equalsIgnoreCase("11.30am") || timeText.getText().equalsIgnoreCase("11:30am")
					|| timeText.getText().equalsIgnoreCase("1130am") || timeText.getText().equalsIgnoreCase("1130 AM")
					|| timeText.getText().equalsIgnoreCase("11:30am") || timeText.getText().equalsIgnoreCase("11:30 am")
					|| timeText.getText().equals("11:3am") || timeText.getText().equals("11:3 am")
					|| timeText.getText().equals("1130")) {

				timeText.setText("11:30 AM");

			} else {
				timeText.setText("11:00 AM");

			}

		} else if (timeText.getText().matches("12.*")) {

			if ((timeText.getText().equals("123")) || timeText.getText().equals("12.3")
					|| timeText.getText().equals("12.30") || timeText.getText().equalsIgnoreCase(("12.30 pm"))
					|| timeText.getText().equalsIgnoreCase("12.30pm") || timeText.getText().equalsIgnoreCase("12:30pm")
					|| timeText.getText().equalsIgnoreCase("1230apm") || timeText.getText().equalsIgnoreCase("1230 PM")
					|| timeText.getText().equalsIgnoreCase("12:30pm") || timeText.getText().equalsIgnoreCase("12:30 pm")
					|| timeText.getText().equals("12:3apm") || timeText.getText().equals("12:3 pm")
					|| timeText.getText().equals("1230")) {

				timeText.setText("12:30 PM");

			} else {
				timeText.setText("12:00 PM");

			}

		} else if (timeText.getText().matches("1.*") || timeText.getText().matches("13.*")) {

			if ((timeText.getText().equals("13")) || timeText.getText().equals("1.3")
					|| timeText.getText().equals("1.30") || timeText.getText().equalsIgnoreCase(("1.30 pm"))
					|| timeText.getText().equalsIgnoreCase("1.30pm") || timeText.getText().equalsIgnoreCase("1:30pm")
					|| timeText.getText().equalsIgnoreCase("130pm") || timeText.getText().equalsIgnoreCase("130 PM")
					|| timeText.getText().equalsIgnoreCase("1:30pm") || timeText.getText().equalsIgnoreCase("1:30 pm")
					|| timeText.getText().equals("1:3pm") || timeText.getText().equals("1:3 pm")
					|| timeText.getText().equals("130")) {

				timeText.setText("1:30 PM");

			} else if (timeText.getText().matches("14.*")) {

				timeText.setText("2:00 PM");

			} else if (timeText.getText().matches("15.*")) {

				timeText.setText("3:00 PM");

			} else if (timeText.getText().matches("16.*")) {

				timeText.setText("4:00 PM");

			} else if (timeText.getText().matches("17.*")) {

				timeText.setText("5:00 PM");

			}

			else {
				timeText.setText("1:00 PM");

			}

		} else if (timeText.getText().matches("2.*")) {

			if ((timeText.getText().equals("23")) || timeText.getText().equals("2.3")
					|| timeText.getText().equals("2.30") || timeText.getText().equalsIgnoreCase(("2.30 pm"))
					|| timeText.getText().equalsIgnoreCase("2.30pm") || timeText.getText().equalsIgnoreCase("2:30pm")
					|| timeText.getText().equalsIgnoreCase("230pm") || timeText.getText().equalsIgnoreCase("230 PM")
					|| timeText.getText().equalsIgnoreCase("2:30pm") || timeText.getText().equalsIgnoreCase("2:30 pm")
					|| timeText.getText().equals("2:3pm") || timeText.getText().equals("2:3 pm")
					|| timeText.getText().equals("230")) {

				timeText.setText("2:30 PM");

			} else {
				timeText.setText("2:00 PM");

			}

		}

		else if (timeText.getText().matches("3.*")) {

			if ((timeText.getText().equals("33")) || timeText.getText().equals("3.3")
					|| timeText.getText().equals("3.30") || timeText.getText().equalsIgnoreCase(("3.30 pm"))
					|| timeText.getText().equalsIgnoreCase("3.30pm") || timeText.getText().equalsIgnoreCase("3:30pm")
					|| timeText.getText().equalsIgnoreCase("330pm") || timeText.getText().equalsIgnoreCase("330 PM")
					|| timeText.getText().equalsIgnoreCase("3:30pm") || timeText.getText().equalsIgnoreCase("3:30 pm")
					|| timeText.getText().equals("3:3pm") || timeText.getText().equals("3:3 pm")
					|| timeText.getText().equals("330")) {

				timeText.setText("3:30 PM");

			} else {
				timeText.setText("3:00 PM");

			}

		}

		else if (timeText.getText().matches("4.*")) {

			if ((timeText.getText().equals("43")) || timeText.getText().equals("4.3")
					|| timeText.getText().equals("4.30") || timeText.getText().equalsIgnoreCase(("4.30 pm"))
					|| timeText.getText().equalsIgnoreCase("4.30pm") || timeText.getText().equalsIgnoreCase("4:30pm")
					|| timeText.getText().equalsIgnoreCase("430pm") || timeText.getText().equalsIgnoreCase("430 PM")
					|| timeText.getText().equalsIgnoreCase("4:30pm") || timeText.getText().equalsIgnoreCase("4:30 pm")
					|| timeText.getText().equals("4:3pm") || timeText.getText().equals("4:3 pm")
					|| timeText.getText().equals("430")) {

				timeText.setText("4:30 PM");

			} else {
				timeText.setText("4:00 PM");

			}

		} else if (timeText.getText().matches("5.*")) {

			if ((timeText.getText().equals("53")) || timeText.getText().equals("5.3")
					|| timeText.getText().equals("5.30") || timeText.getText().equalsIgnoreCase(("5.30 pm"))
					|| timeText.getText().equalsIgnoreCase("5.30pm") || timeText.getText().equalsIgnoreCase("5:30pm")
					|| timeText.getText().equalsIgnoreCase("530pm") || timeText.getText().equalsIgnoreCase("530 PM")
					|| timeText.getText().equalsIgnoreCase("5:30pm") || timeText.getText().equalsIgnoreCase("5:30 pm")
					|| timeText.getText().equals("5:3pm") || timeText.getText().equals("5:3 pm")
					|| timeText.getText().equals("530")) {

				timeText.setText("5:00 PM");

			} else {
				timeText.setText("5:00 PM");

			}

		} else {

			timeText.setText("7:00 AM");

		}

	}

	public void setProviderCode(String code) {

		providerText.setText(code);

	}
	/*
	 * public void setProviderFirstName(String provideFirstName){
	 * 
	 * //providerIdText.setText(Integer.toString(proId));
	 * providerName.setText(provideFirstName);
	 * 
	 * }
	 */

	private ReferalProvider referalProvider;
	public void setReferredByName(ReferalProvider referalProvider) {
    this.referalProvider=referalProvider;
		referredByText.setText(referalProvider.getCode());

	}

	/*
	 * public void setRefferedById(Integer proId){
	 * 
	 * referredByIdText.setText(Integer.toString(proId));
	 * 
	 * }
	 */


	public void setClinicianName(String name) {

		clinicianName.setText(name);
		// clinicianName.setText();
	}

	/*
	 * public void setClinicianId(Integer cliId){
	 * 
	 * clinicianId.setText(Integer.toString(cliId));
	 * 
	 * }
	 */
	public void setClinicianCode(String code) {

		clinicianText.setText(code);

	}

	public void setVisitCategory(String code) {

		visitCategoryText.setText(code);

	}

	public void setPurpose(String purpose) {

		purposetext.setText(purpose);

	}

	public void setVisitType(String name) {

		appointmentTypeChoiceBox.setValue(name);

	}

	public PatientViewController patientViewController;

	public void setPatientViewController(PatientViewController patientViewController,Patient patient) {
		this.patientViewController = patientViewController;
		if(patient.getPreferredProvider()!=null){
		providerText.setText(patient.getPreferredProvider().getFirstName()+" "+patient.getPreferredProvider().getMiddleName()+" "+patient.getPreferredProvider().getLastName());
		}
	}

	public void setAptTime() {

	}

	public void setInitialData() {

		Date date = new Date();

		if (date != null) {

			LocalDate localDate = new DateConvert().dateToLocalDate(date);

			dateField.setValue(localDate);

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	
	public void checkPatient(){
		

		LocalDate localDate1 = dateField.getValue();
		
		if (localDate1 != null) {

			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			patientAppointmentCheckPatientList =	new PatientAppointmentEntityController().viewByNameDateProviderAndTime(date1, timeText.getText(), providerText.getText());
			
		}

		
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setInitialData();

		List<String> list1 = new ArrayList<String>();

		list1.add("Unspecified");
		list1.add("Employer Services");
		list1.add("Workers' Comp");
		list1.add("Private Practice");

		ObservableList typeList = FXCollections.observableList(list1);
		appointmentTypeChoiceBox.getItems().clear();
		appointmentTypeChoiceBox.setItems(typeList);

		List<String> list2 = new ArrayList<String>();
		list2.add("Scheduled");
		list2.add("Reminded");
		list2.add("No Show");
		list2.add("Cancelled");
		list2.add("Walk-Out");
		list2.add("Pending");
		list2.add("Completed");

		ObservableList statusList = FXCollections.observableList(list2);

		statusChoiceBox.getItems().clear();
		statusChoiceBox.setItems(statusList);
		statusChoiceBox.getSelectionModel().select(0);

		ObservableList<String> reqdTimeList1 = FXCollections.observableList(InitSpinner.load3());

		SpinnerValueFactory factory1 = new SpinnerValueFactory.ListSpinnerValueFactory(reqdTimeList1);
		minutesReqdSpinner.setValueFactory(factory1);

		providerButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController =

						(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				providerViewController.setPatientAppointmentInputController(this, providerButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		refferedByButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController =

						(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				providerViewController.setPatientAppointmentInputController(this, refferedByButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		visitCategoryButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				VisitCategoryCodeViewController visitCategoryCodeViewController = (VisitCategoryCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				visitCategoryCodeViewController.setPatientAppointmentInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicianButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicianViewController clinicianViewController = (ClinicianViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				clinicianViewController.setPatientAppointmentInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		

		OkButton.setOnAction((event) -> {
			
			checkPatient();
			if(patientAppointmentCheckPatientList.size()==0){
			    try {
				
				
				PatientAppointment patientAppointment = new PatientAppointment();

				LocalDate localDate1 = dateField.getValue();
				if (localDate1 != null) {

					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

					patientAppointment.setApptDate(date1);

				}
				
				patientAppointment.setType(appointmentTypeChoiceBox.getValue());
				patientAppointment.setApptNotes(appointment5ReasonTextArea.getText());
				patientAppointment.setApptTime(timeText.getText());
				patientAppointment.setCancelReason(cancelReasonText.getText());

				if (clinicianText.getText().isEmpty()) {

				} else {

					Clinician clinician = new ClinicianEntityController().viewByCode(clinicianText.getText());
					patientAppointment.setClinician(clinician);
				}

				patientAppointment.setPatient(Global.patient);

				if (providerText.getText().isEmpty()) {

				} else {

					Provider provider = new ProviderEntityController().viewByCode(providerText.getText());
					patientAppointment.setProvider(provider);

				}

				if(referalProvider!=null){
					patientAppointment.setReferredBy(referalProvider);
				}
			

				patientAppointment.setSchMinutesReq(minutesReqdSpinner.getValue());
				patientAppointment.setStatus(statusChoiceBox.getSelectionModel().getSelectedItem());

				if (visitCategoryText.getText().isEmpty()) {

				} else {

					VisitCategory visitCategory = new VisitCategoryEntityController()
							.viewByCode(visitCategoryText.getText());
					patientAppointment.setVisitCatId(visitCategory);

				}

				if(purposetext.getText().isEmpty()){
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					DialogPane dialogPane = alert.getDialogPane();

            	    dialogPane.setStyle("-fx-font-size: 12px;-fx-font-style: italic;");
					alert.setHeaderText(null);
					alert.setContentText("Purpose is empty!");
					
					alert.showAndWait();
					
				
				
				}else{
					
					patientAppointment.setPurpose(purposetext.getText());
				
				}
				
				new PatientAppointmentEntityController().saveOrUpdate(patientAppointment);
				
				
				if(patientViewController!=null?patientViewController.searchPatientController!=null?patientViewController.searchPatientController.appointmentController!=null:false:false){
				
					
					patientViewController.searchPatientController.appointmentController.reFresh();
					patientViewController.searchPatientController.appointmentController.refreshCol2();
					
				}
				if(ScheduleController.appointmentController!=null){
					
					ScheduleController.appointmentController.reFresh();
				    ScheduleController.appointmentController.refreshCol2();	
				}
				
			
				
				new FXFormCommonUtilities().closeForm(OkButton);
				
				}
		       catch (Exception ex) {
				ex.printStackTrace();
			 }
			      
			    
			}
			
			else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				 DialogPane dialogPane = alert.getDialogPane();

        	     dialogPane.setStyle("-fx-font-size: 12px;-fx-font-style: italic;");
				alert.setHeaderText(null);
				alert.setContentText("Provider is not available!\nPlease select another time");
				
				alert.showAndWait();
			}
			
			
		});

		CancleButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(CancleButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
