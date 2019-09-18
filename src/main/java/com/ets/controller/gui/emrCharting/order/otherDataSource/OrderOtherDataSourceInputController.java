package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.diagonostic.DiagonosticVitalSignMonitorInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderOtherDataSourceInputController implements Initializable {
	
	
	@FXML
    private CheckBox ReviewPastvisit;

    @FXML
    private CheckBox Translator;

    @FXML
    private CheckBox Dataobtainedfromfamily;

    @FXML
    private CheckBox ObtainoldMedical;

    @FXML
    private CheckBox ObtainedIndepedent;

    @FXML
    private CheckBox DiscussedTest;

    @FXML
    private CheckBox ReviewedwithSupervisor;

    @FXML
    private CheckBox ConsultClinicalRefrence;

    @FXML
    private CheckBox ReviewedwrtACOEM;

    @FXML
    private CheckBox ReviewedwrtODG;

    @FXML
    private CheckBox GenderAdvocate;

    @FXML
    private CheckBox LeftMessage;

    @FXML
    private CheckBox SpokewithEmployer;

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
	
	public void setOtherDataSource(){
		
		
		
		if (ReviewPastvisit.isSelected()) {
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

			ReviewPastvisit.setSelected(false);

		}else if (Translator.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataTranslator", null, Locale.US);

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

			OtherDataTranslatorInputController translatorInputController = (OtherDataTranslatorInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			translatorInputController.setOrderOtherDataSourceInputController(this);

			Translator.setSelected(false);

		}else if (Dataobtainedfromfamily.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataDataObtainFromFamily", null, Locale.US);

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

			OtherDataDataObtainFromFamilyInputController dataObtainFromFamilyInputController = (OtherDataDataObtainFromFamilyInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			dataObtainFromFamilyInputController.setOrderOtherDataSourceInputController(this);

			Dataobtainedfromfamily.setSelected(false);

		}else if (ObtainoldMedical.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Ordered medical records from prior physician for review. ");
			str = str1.toString();
			ObtainoldMedical.setSelected(false);

			setOtherDataSource();

		} else if (ObtainedIndepedent.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Obtained independent review of test results. ");
			str = str1.toString();
			ObtainedIndepedent.setSelected(false);
			
			setOtherDataSource();

		}else if (DiscussedTest.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Discussed test results with the interpreting physician. ");
			str = str1.toString();
			DiscussedTest.setSelected(false);
			
			setOtherDataSource();

		}else if (ReviewedwithSupervisor.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Discussed evaluation results with the supervising physician. ");
			str = str1.toString();
			ReviewedwithSupervisor.setSelected(false);

			setOtherDataSource();

		}else if (ConsultClinicalRefrence.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataConsult", null, Locale.US);

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

			OtherDataConsultInputController consultInputController = (OtherDataConsultInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			consultInputController.setOrderOtherDataSourceInputController(this);

			ConsultClinicalRefrence.setSelected(false);

		}else if (ReviewedwrtACOEM.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Evaluation and results reviewed with American College of Occupational and Environmental Medicine (ACOEM) Guidelines. ");
			str = str1.toString();
			
			ReviewedwrtACOEM.setSelected(false);
			
			setOtherDataSource();

		}else if (ReviewedwrtODG.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Evaluation and results reviewed with Occupational Disability (ODG) Guidelines. ");
			str = str1.toString();
			ReviewedwrtODG.setSelected(false);

			setOtherDataSource();

		}else if (GenderAdvocate.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataGenderAdvocateChaperone", null, Locale.US);

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

			OtherDataGenderAdvocateChaperoneInputController genderAdvocateChaperoneInputController = (OtherDataGenderAdvocateChaperoneInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			genderAdvocateChaperoneInputController.setOrderOtherDataSourceInputController(this);

			GenderAdvocate.setSelected(false);

		}else if (LeftMessage.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataLeftMsgForEmployerRepresentative", null, Locale.US);

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

			OtherDataLeftMsgForEmployerRepresentativeInputController leftMsgForEmployerRepresentativeInputController = (OtherDataLeftMsgForEmployerRepresentativeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			leftMsgForEmployerRepresentativeInputController.setOrderOtherDataSourceInputController(this);

			LeftMessage.setSelected(false);

		}else if (SpokewithEmployer.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderOtherDataSpokeWithEmployerContact", null, Locale.US);

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

			OtherDataSpokeWithEmployerContactInputController spokeWithEmployerContactInputController = (OtherDataSpokeWithEmployerContactInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			spokeWithEmployerContactInputController.setOrderOtherDataSourceInputController(this);

			SpokewithEmployer.setSelected(false);

		}
		
		
		
		
		else if (secondFormCount == formCount) {
			
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

			setOtherDataSource();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});
		
		
	}

}
