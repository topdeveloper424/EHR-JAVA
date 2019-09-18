package com.ets.controller.gui.genericVisitProtocal;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.vitalSign.VitalSignEntityController;
import com.ets.controller.gui.clinician.ClinicianViewController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.numberPad.NumberPadGUIController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.model.Clinician;
import com.ets.model.Provider;
import com.ets.model.VitalSign;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EnterVitalSignGUIController implements Initializable {

	@FXML
	private TextField heightText;

	@FXML
	private Label visitDateLabel;

	@FXML
	private Label providerLabel;

	@FXML
	private Label genderLabel;

	@FXML
	private Label Doblabel;

	@FXML
	private Label clinicianLabel;

	@FXML
	private TextField cmText;

	@FXML
	private TextField bmiText;

	@FXML
	private TextField weightText;

	@FXML
	private TextField ozText;

	@FXML
	private Button heightBtn;

	@FXML
	private Button ozBtn;

	@FXML
	private Button timeButton;

	@FXML
	private Button weightBtn;

	@FXML
	private TextField kgText;

	@FXML
	private TextField bodyFatText;

	@FXML
	private TextField timeReadingText;

	@FXML
	private Button bodyFatBtn;

	@FXML
	private Button providerButton;
	@FXML
	private TextField fareheniteText;
	@FXML
	private TextField celciusText;

	@FXML
	private TextField abdominalText;
	@FXML
	private TextField orText;

	@FXML
	private TextField pulseOximetryText;

	@FXML
	private TextField ageText;

	@FXML
	private Button abdominalBtn;
	@FXML
	private Button ClinicianButton;

	@FXML
	private TextField abdominalCmText;
	@FXML
	private TextField providerText;

	@FXML
	private Button cancelButton;

	@FXML
	private Button fahrenheitBtn;

	@FXML
	private Button systolicBtn;

	@FXML
	private Button diastolicBtn;

	@FXML
	private Button pulseRatebloodPressureBtn;

	@FXML
	private Button pulserateRespirationBtn;

	@FXML
	private ToggleGroup vitalType;

	@FXML
	private Button pulseOximetryBtn;

	@FXML
	private Button orbtn;

	@FXML
	private TextField systolicText;
	@FXML
	private TextField distolicText;

	@FXML
	private TextField clinicianText;

	@FXML
	private TextField pulseRateText;

	@FXML
	private TextField breathPerMinuteText;
	
	
	@FXML
	private Button okButton;

	@FXML
	private ChoiceBox<String> whichArmDropDown;
	@FXML
	private ChoiceBox<String> patientPositionAtTimeChoice;

	@FXML
	private CheckBox roomAirCheck;

	@FXML
	private RadioButton Radio_0;
	@FXML
	private RadioButton Radio_1;

	@FXML
	private RadioButton Radio_2;

	@FXML
	private RadioButton Radio_3;

	@FXML
	private RadioButton Radio_4;

	@FXML
	private RadioButton Radio_5;

	@FXML
	private RadioButton Radio_6;

	@FXML
	private RadioButton Radio_7;

	@FXML
	private RadioButton Radio_8;

	@FXML
	private RadioButton Radio_9;

	@FXML
	private RadioButton Radio_10;

	FXMLFormPath formPath = new FXMLFormPath();
	
	
	private GenericEMRChartingController genericEMRChartingController;
	
	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
		this.genericEMRChartingController = genericEMRChartingController;
	}

	public void setHightCm(String height, String heightIncm) {

		heightText.setText(height);
		cmText.setText(heightIncm);

	}

	public void setWeightKgBmi(String weight, String lbtoKg) {

		weightText.setText(weight);
		kgText.setText(lbtoKg);
		/*if (ozText.getText().length() != 0) {
			
			

		} else {
			kgText.setText(lbtoKg);
		}*/

		if (cmText.getText().length() > 0 && kgText.getText().length() > 0) {

			Double cmTextVar = Double.parseDouble(cmText.getText());
			Double kgTexttVar = Double.parseDouble(kgText.getText());
			Double bmiVal = (kgTexttVar / (cmTextVar * cmTextVar));

			bmiText.setText(bmiVal.toString());
		} else {

		}
	}

	public void setOzKg(String oz, String ozKg) {

		ozText.setText(oz);
		kgText.setText(ozKg);
		/*if (weightText.getText().length() != 0) {

		} else {

			kgText.setText(ozKg);
		}*/

	}

	public void setBodyFat(String bodyFat) {

		bodyFatText.setText(bodyFat);
	}

	public void setAbdominal(String abdominal, String abdomiIninches) {

		abdominalText.setText(abdominal);
		abdominalCmText.setText(abdomiIninches);
	}

	public void farenheitToCelcius(String farehenite, String fareheniteToCelcius) {

		fareheniteText.setText(farehenite);
		celciusText.setText(fareheniteToCelcius);

	}

	public void systolic(String systolic) {

		systolicText.setText(systolic);

	}

	public void dystolic(String dystolic) {

		distolicText.setText(dystolic);

	}

	public void pulserate(String pulses) {

		pulseRateText.setText(pulses);

	}

	public void breathPerMinute(String breathPerMinute) {

		breathPerMinuteText.setText(breathPerMinute);

	}

	public void pulseOximetry(String pulseOxi) {

		pulseOximetryText.setText(pulseOxi);

	}

	public void orFn(String orVal) {

		orText.setText(orVal);

	}

	public void setClinician(Clinician clinician) {
		clinicianText.setText(clinician.getCode());
		clinicianLabel.setText(clinician.getFirstName() + " " + clinician.getLastName());

	}

	public void setProvider(Provider provider) {
		providerText.setText(provider.getCode());
		providerLabel.setText(provider.getFirstName() + " " + provider.getLastName());

	}

	private List<VitalSign> vitalSignList = null;
	public void viewVitalSign(){
		
		vitalSignList = new VitalSignEntityController().view(Global.patientVisitObj);
		
		System.out.println("YYYYYY"+vitalSignList.size());
		if(vitalSignList.size() != 0){
			for (VitalSign vitalSign : vitalSignList) {
				
				heightText.setText(vitalSign.getHeightInInches());
				cmText.setText(vitalSign.getHeightInCm());
				bmiText.setText(vitalSign.getBmi());
				timeReadingText.setText(vitalSign.getTimeOfreading());
				ageText.setText(vitalSign.getAge());
				weightText.setText(vitalSign.getWeightLb());
				ozText.setText(vitalSign.getWeightOz());
				kgText.setText(vitalSign.getWeightKg());
				bodyFatText.setText(vitalSign.getBodyFat());
				abdominalText.setText(vitalSign.getAbdominalInches());
				abdominalCmText.setText(vitalSign.getAbdominalCm());
				fareheniteText.setText(vitalSign.getFarenhiet());
				celciusText.setText(vitalSign.getCelcius());
				breathPerMinuteText.setText(vitalSign.getBreathPerMinute());
				systolicText.setText(vitalSign.getSystolic());
				distolicText.setText(vitalSign.getDystolic());
				pulseRateText.setText(vitalSign.getPulsePerRate());
				
				
				
					whichArmDropDown.setValue(vitalSign.getWhichArmUsed());

				
					
				
				
					patientPositionAtTimeChoice.setValue(vitalSign.getPatientPositionAtTimeReading());
			
				
				//patientPositionAtTimeChoice.setText(vitalSign.getPatientPositionAtTimeReading());
				pulseOximetryText.setText(vitalSign.getPulseoximetry());
				if(vitalSign.getPatientVisit().getClinician() != null){
					clinicianText.setText(vitalSign.getPatientVisit().getClinician().getCode());
					clinicianLabel.setText(vitalSign.getPatientVisit().getClinician().getFirstName()+" "
					+vitalSign.getPatientVisit().getClinician().getLastName());
					
				}
				if(vitalSign.getPatientVisit().getProvider()!=null){
					
					providerText.setText(vitalSign.getPatientVisit().getProvider().getCode());
					providerLabel.setText(vitalSign.getPatientVisit().getProvider().getFirstName()+" "+
							vitalSign.getPatientVisit().getProvider().getLastName());
					
				}
				
				
				
				orText.setText(vitalSign.getOrText());
				if(vitalSign.getRoomAir()== "true"){
					
					roomAirCheck.setSelected(true);
				}
				
				 
			if(vitalSign.getPainLevel() != null){
				
	            if(vitalSign.getPainLevel().equals("0")){
	            	Radio_0.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("1")){
	            	Radio_1.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("2")){
	            	Radio_2.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("3")){
	            	Radio_3.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("4")){
	            	Radio_4.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("5")){
	            	Radio_5.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("6")){
	            	Radio_6.setSelected(true);
	            }if(vitalSign.getPainLevel().equals("7")){
	            	Radio_7.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("8")){
	            	Radio_8.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("9")){
	            	Radio_9.setSelected(true);
	            }
	            if(vitalSign.getPainLevel().equals("10")){
	            	Radio_10.setSelected(true);
	          
			}
			}
			
			}
			
			
		}else{
			
		}
		
		
		
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		viewVitalSign();
		
		visitDateLabel.setText(Global.patientVisitObj.getVisitDate().toString());

		if ((Global.patientVisitObj.getClinician() != null) && (Global.patientVisitObj.getProvider() != null)) {
			clinicianText.setText(Global.patientVisitObj.getClinician().getCode());
			clinicianLabel.setText(Global.patientVisitObj.getClinician().getFirstName() + " "
					+ Global.patientVisitObj.getClinician().getLastName());
			providerText.setText(Global.patientVisitObj.getProvider().getCode());
			providerLabel.setText(Global.patientVisitObj.getProvider().getFirstName() + " "
					+ Global.patientVisitObj.getProvider().getLastName());

		}

		if (Global.patientVisitObj.getPatient().getPatientStatistic().getDob() != null) {

			Doblabel.setText(Global.patientVisitObj.getPatient().getPatientStatistic().getDob().toString());
			Date birthDate= null;
			  Calendar birth = new GregorianCalendar();
		      Calendar today = new GregorianCalendar();
		      int age = 0;
		      int factor = 0; //to correctly calculate age when birthday has not been yet celebrated
		      try{
		       birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(Global.patientVisitObj.getPatient().getPatientStatistic().getDob().toString());
		      }catch(Exception e){
		    	  
		    	  e.printStackTrace();
		      }
		      Date currentDate = new Date(); //current date
		      
		      birth.setTime(birthDate);
		      today.setTime(currentDate);
		      
		      // check if birthday has been celebrated this year
		      if(today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
		            factor = -1; //birthday not celebrated
		      }
		      age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
		      System.out.println("AGE (years): "+age);


		}
		
		if(Global.patientVisitObj.getPatient().getPatientStatistic().getGender()!=null){
			genderLabel.setText(Global.patientVisitObj.getPatient().getPatientStatistic().getGender());	
			
		}
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Left");
		list1.add("Right");

		ObservableList obList1 = FXCollections.observableList(list1);
		whichArmDropDown.setItems(obList1);

		List<String> list11 = new ArrayList<String>();
		list11.add("Sitting");
		list11.add("Standing");
		list11.add("Supine(Lying Down)");
		ObservableList obList11 = FXCollections.observableList(list11);
		patientPositionAtTimeChoice.setItems(obList11);

		ClinicianButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();

				ClinicianViewController clinicianViewController = (ClinicianViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				clinicianViewController.setEnterVitalSignGUIController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController = (ProviderViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				providerViewController.setEnterVitalSignGUIController(this,providerButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		heightBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, heightBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		weightBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, weightBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		ozBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, ozBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bodyFatBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, bodyFatBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		abdominalBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, abdominalBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		fahrenheitBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, fahrenheitBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pulserateRespirationBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, pulserateRespirationBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		systolicBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, systolicBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		diastolicBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, diastolicBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pulseRatebloodPressureBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, pulseRatebloodPressureBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		orbtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, orbtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pulseOximetryBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, pulseOximetryBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*vitalDeviceBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("NumberPad", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NumberPad", null, Locale.US);
				formPath.closeApplicationContext();

				NumberPadGUIController numberPadGUIController = (NumberPadGUIController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				numberPadGUIController.setEnterVitalSignGUIController(this, vitalDeviceBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		timeButton.setOnAction((event) -> {
			try {

				System.out.println(new Date());
				String str = new Date().toString();
				String str1[] = str.split(" ");
				
				
				
				
			 timeReadingText.setText(str1[3]);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okButton.setOnAction((event) -> {
			try {

            VitalSign vitalSign = new VitalSign();	
            vitalSign.setTimeOfreading(timeReadingText.getText());
            vitalSign.setAge(ageText.getText());
            vitalSign.setAbdominalCm(abdominalCmText.getText());
            vitalSign.setAbdominalInches(abdominalText.getText());
            vitalSign.setBmi(bmiText.getText());
            vitalSign.setBodyFat(bodyFatText.getText());
            vitalSign.setBreathPerMinute(breathPerMinuteText.getText());
            vitalSign.setCelcius(celciusText.getText());
            vitalSign.setDystolic(distolicText.getText());
            vitalSign.setSystolic(systolicText.getText());
            vitalSign.setFarenhiet(fareheniteText.getText());
            vitalSign.setHeightInCm(cmText.getText());
            vitalSign.setHeightInInches(heightText.getText());
            vitalSign.setOrText(orText.getText());
            
            if(Radio_0.isSelected()){
            	 vitalSign.setPainLevel("0");
            }
            if(Radio_1.isSelected()){
           	 vitalSign.setPainLevel("1");
           }
            if(Radio_2.isSelected()){
           	 vitalSign.setPainLevel("2");
           }
            if(Radio_3.isSelected()){
           	 vitalSign.setPainLevel("3");
           }
            if(Radio_4.isSelected()){
           	 vitalSign.setPainLevel("4");
           }
            if(Radio_5.isSelected()){
           	 vitalSign.setPainLevel("5");
           }
            if(Radio_6.isSelected()){
           	 vitalSign.setPainLevel("6");
           }
            if(Radio_7.isSelected()){
           	 vitalSign.setPainLevel("7");
           }
            if(Radio_8.isSelected()){
           	 vitalSign.setPainLevel("8");
           }
            if(Radio_9.isSelected()){
           	 vitalSign.setPainLevel("9");
           }
            if(Radio_10.isSelected()){
           	 vitalSign.setPainLevel("10");
           }
            
            vitalSign.setPatientPositionAtTimeReading(patientPositionAtTimeChoice.getSelectionModel().getSelectedItem());
            vitalSign.setPulseoximetry(pulseOximetryText.getText());
            vitalSign.setPulsePerRate(pulseRateText.getText());
            if(roomAirCheck.isSelected()){
            vitalSign.setRoomAir("true");
            }else
            {
            	vitalSign.setRoomAir("false");
            	
            }
            vitalSign.setWeightKg(kgText.getText());
           
            vitalSign.setWeightLb(weightText.getText());
            vitalSign.setWeightOz(ozText.getText());
            vitalSign.setWhichArmUsed(whichArmDropDown.getSelectionModel().getSelectedItem());
          
            
            
            vitalSign.setPatientVisit(Global.patientVisitObj);
            
            
           
            
            if(vitalSignList.size() > 0){
            	
            	vitalSign.setId(vitalSignList.get(0).getId());	
            }
            	
            	
            
            
            new VitalSignEntityController().saveOrUpdate(vitalSign);
            
            
           // genericEMRChartingController.setRecordInVisit();
				
				
				new FXFormCommonUtilities().closeForm(okButton);
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
