package com.ets.controller.gui.emrCharting.order.patientLocal;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.otherDataSource.OtherDataReviewPastVisitInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderPatientLocalMeasureInputController implements Initializable {
	
	@FXML
    private CheckBox patientLocalMeasures;

    @FXML
    private CheckBox PatientRice;

    @FXML
    private CheckBox patientStop;

    @FXML
    private CheckBox patientWound;

    @FXML
    private CheckBox patientTranspotation;

    @FXML
    private CheckBox patientWeight;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;
    
    
    private Button button;
    
   	public GenericEMRChartingController genericEMRChartingController;
       
       public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
   		this.genericEMRChartingController = genericEMRChartingController;
   		this.button = button;
   	}
       
       
       
       FXMLFormPath formPath = new FXMLFormPath();

   	public static Integer formCount = 0;

   	private Integer secondFormCount = 0;

   	public static String str = "\n\n";


   	void formCountIncrement() {
   		++secondFormCount;
   	}
   	
   	public void setPatientLocalMeasureUI(){
   		
   		if (patientLocalMeasures.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderPatientLocalPatientLocalMeasure", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			PatientLocalMeasureInputController localMeasureInputController = (PatientLocalMeasureInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			localMeasureInputController.setOrderPatientLocalMeasureInputController(this);

			patientLocalMeasures.setSelected(false);

		}else if (PatientRice.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderPatientLocalRice", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			RiceInputController riceInputController = (RiceInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			riceInputController.setOrderPatientLocalMeasureInputController(this);

			PatientRice.setSelected(false);

		}else if (patientStop.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Counseled patient on measures to stop smoking.");
			str = str1.toString();
			patientStop.setSelected(false);
			
			setPatientLocalMeasureUI();

		}/*if (patientWound.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataReviewPastVisit", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			OtherDataReviewPastVisitInputController reviewPastVisitInputController = (OtherDataReviewPastVisitInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			reviewPastVisitInputController.setOrderOtherDataSourceInputController(this);

			patientWound.setSelected(false);

		}*/else if (patientTranspotation.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderPatientLocalTransportationProvider", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			TransportationProviderInputController transportationProviderInputController = (TransportationProviderInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			transportationProviderInputController.setOrderPatientLocalMeasureInputController(this);

			patientTranspotation.setSelected(false);

		}else if (patientWeight.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderPatientLocalWeightBearingStatus", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			WeightBearingStatusInputController weightBearingStatusInputController = (WeightBearingStatusInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			weightBearingStatusInputController.setOrderPatientLocalMeasureInputController(this);

			patientWeight.setSelected(false);

		}else if (secondFormCount == formCount) {
			
			genericEMRChartingController.paint(button);
			
			formCount = 0;
			genericEMRChartingController.setOrderTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(doneBtn);


		}

		
		
   	}
   	
   	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			setPatientLocalMeasureUI();
			

		});
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});
		
		
	}

}
