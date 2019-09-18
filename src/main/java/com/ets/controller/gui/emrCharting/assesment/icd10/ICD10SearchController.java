package com.ets.controller.gui.emrCharting.assesment.icd10;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ICD10SearchController Class
 *Description: emrCharting.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.assesment.AssessmentEntityController;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.model.Assesment;
import com.ets.model.Icd10Codes;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ICD10SearchController implements Initializable {
	
	 @FXML
	    private Label icdDescriptionLabel;

	    @FXML
	    private TextField icd10CodeText;

	    @FXML
	    private Button searchBtn;

	    @FXML
	    private Button okBtn;
	    
	    private GenericEMRChartingController genericEMRChartingController;
	    
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
			this.genericEMRChartingController = genericEMRChartingController;
		}
	    
	    
	    public static String icd10Code = null;
	    public static String icd10Description = null;
	    
	    
		public void setICD10Code(String code){
	    	
	    	icd10CodeText.setText(code);
	    	icd10Code = code;
	    }
		
		public void setDescripLabel(String descrip){
			
			icdDescriptionLabel.setText(descrip);
			icd10Description = descrip;
		}
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		searchBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10", null, Locale.US);
				formPath.closeApplicationContext();
				ICD10ViewController icd10ViewController = 
				(ICD10ViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				icd10ViewController.setIcd10SearchController(this);
				//providerViewController.setPatientInputController(this, PrimaryCareButton);

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okBtn.setOnAction((event) -> {
			try {
				
				Icd10Codes icd10Codes = new Icd10CodesEntityController().viewICD10CodeByCode(icd10CodeText.getText());
				
				Assesment assesment = new Assesment();
				assesment.setIcd10(icd10Codes);
				
				assesment.setPatient(Global.patient);
				assesment.setPatientVisit(Global.patientVisitObj);
				new AssessmentEntityController().saveOrUpdate(assesment);
								
				genericEMRChartingController.setAssesmentDiagonosisUI();
				genericEMRChartingController.viewAssesmenttable();
				new FXFormCommonUtilities().closeForm(okBtn);

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
