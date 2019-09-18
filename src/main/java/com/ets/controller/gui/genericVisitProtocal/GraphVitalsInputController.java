package com.ets.controller.gui.genericVisitProtocal;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;

import com.ets.controller.entity.vitalSign.VitalSignEntityController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.model.VitalSign;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class GraphVitalsInputController implements Initializable {

	@FXML
	private RadioButton bloodPressureRadio;

	@FXML
	private RadioButton pulseRadio;

	@FXML
	private RadioButton respirationRadio;

	@FXML
	private RadioButton tempRadio;

	@FXML
	private RadioButton weightRadio;

	@FXML
	private RadioButton heightRadio;

	@FXML
	private RadioButton bmiRadio;

	@FXML
	private RadioButton heightWeightForAgeRadio;

	@FXML
	private RadioButton bmiForAgeRadio;

	@FXML
	private Button graphButton;

	@FXML
	private Button cancelButton;
	 @FXML
	    private ToggleGroup vitalSign;

	FXMLFormPath formPath = new FXMLFormPath();

	private GenericEMRChartingController genericEMRChartingController;
   private List<VitalSign> vitalSigns = null;
	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,List<VitalSign> vitalSigns) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.vitalSigns = vitalSigns;
	
	
	
	}

	String graphVar = null;
	String resp = null;
	String heightInInches = null;
	String systolic = null;
	String dystolic = null;
	String pulse = null;
	String temperatureInFaranheit = null;
	String weight = null;
	String bmi = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		
		
		
		graphButton.setOnAction((event) -> {
			
			
			try {
				for (VitalSign vitalSign : vitalSigns) {
					resp = vitalSign.getBreathPerMinute();
					heightInInches = vitalSign.getHeightInInches();
					systolic = vitalSign.getSystolic();
					dystolic = vitalSign.getDystolic();
					pulse = vitalSign.getPulsePerRate();
					temperatureInFaranheit = vitalSign.getFarenhiet();
					weight = vitalSign.getWeightLb();
					bmi = vitalSign.getBmi();
				}
			
				if (bloodPressureRadio.isSelected()) {
					 String frmName = formPath.context.getMessage("BloodPressureGraph", null, Locale.US);
					 String frmTitle = formPath.context.getMessage("Title.BloodPressureGraph", null, Locale.US);
						formPath.closeApplicationContext();

						BloodPressureGraphInputController bloodPressureGraphInputController = (BloodPressureGraphInputController) new FXFormCommonUtilities()
								.displayForm(frmName, frmTitle);
						bloodPressureGraphInputController.setGraphVitalsInputController(this,systolic,dystolic);
				}

				if (pulseRadio.isSelected()) {
					

					String frmName = formPath.context.getMessage("PulseGraph", null, Locale.US);
					String frmTitle = formPath.context.getMessage("Title.PulseGraph", null, Locale.US);
					formPath.closeApplicationContext();

					PulseRatesInputController pulseRatesInputController = (PulseRatesInputController) new FXFormCommonUtilities()
							.displayForm(frmName, frmTitle);
					pulseRatesInputController.setGraphVitalsInputController(this,pulse);

				}

				if (respirationRadio.isSelected()) {
					
					String frmName = formPath.context.getMessage("RespirationGraph", null, Locale.US);
					String frmTitle = formPath.context.getMessage("Title.RespirationGraph", null, Locale.US);
					formPath.closeApplicationContext();

					RespirationGraphController respirationGraphController = (RespirationGraphController) new FXFormCommonUtilities()
							.displayForm(frmName, frmTitle);
					respirationGraphController.setGraphVitalsInputController(this,resp);
				}
				 if (tempRadio.isSelected()) {
					 
						String frmName = formPath.context.getMessage("TemperatureReading", null, Locale.US);
						String frmTitle = formPath.context.getMessage("Title.TemperatureReading", null, Locale.US);
						formPath.closeApplicationContext();

						TemperatureGraphInputController temperatureGraphInputController = (TemperatureGraphInputController) new FXFormCommonUtilities()
								.displayForm(frmName, frmTitle);
						temperatureGraphInputController.setGraphVitalsInputController(this,temperatureInFaranheit);

				}
				 if (heightRadio.isSelected()) {

					String frmName = formPath.context.getMessage("HeightGraph", null, Locale.US);
					String frmTitle = formPath.context.getMessage("Title.HeightGraph", null, Locale.US);
					formPath.closeApplicationContext();

					HeightOverTimeInputController heightOverTimeInputController = (HeightOverTimeInputController) new FXFormCommonUtilities()
							.displayForm(frmName, frmTitle);
					heightOverTimeInputController.setGraphVitalsInputController(this,heightInInches);
				}
				 if (bmiRadio.isSelected()) {
					 
					 String frmName = formPath.context.getMessage("BmiGraph", null, Locale.US);
					 String frmTitle = formPath.context.getMessage("Title.BmiGraph", null, Locale.US);
						formPath.closeApplicationContext();

						BMIGraphInputController bmiGraphInputController = (BMIGraphInputController) new FXFormCommonUtilities()
								.displayForm(frmName, frmTitle);
						bmiGraphInputController.setGraphVitalsInputController(this,bmi);
				}
				 if (weightRadio.isSelected()) {
					 String frmName = formPath.context.getMessage("WeightGraph", null, Locale.US);
					 String frmTitle = formPath.context.getMessage("Title.WeightGraph", null, Locale.US);
						formPath.closeApplicationContext();

						WeightOverTimeInputController weightOverTimeInputController = (WeightOverTimeInputController) new FXFormCommonUtilities()
								.displayForm(frmName, frmTitle);
						weightOverTimeInputController.setGraphVitalsInputController(this,weight);
				}
				 if (heightWeightForAgeRadio.isSelected()) {
					
					
				}

				if (bmiForAgeRadio.isSelected()) {

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
