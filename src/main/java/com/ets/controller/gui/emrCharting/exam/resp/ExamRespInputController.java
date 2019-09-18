package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 30-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamRespInputController Class
 *Description: respiratory.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.neck.NeckExamCompInputController;
import com.ets.controller.gui.emrCharting.exam.neck.NeckExamInputController;
import com.ets.controller.gui.emrCharting.exam.neck.NeckRangeMotionInputController;
import com.ets.controller.gui.emrCharting.exam.neck.NeckThyroidInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamRespInputController implements Initializable {
	
	
	
	@FXML
    private CheckBox allNormalCheckBox;

    @FXML
    private CheckBox examCheckBox;

    @FXML
    private CheckBox assesmentCheckBox;

    @FXML
    private CheckBox palpationCheckBox;

    @FXML
    private CheckBox asthamaBronCheckBox;

    @FXML
    private CheckBox rabPainCheckBox;

    @FXML
    private CheckBox percussionCheckBox;

    @FXML
    private CheckBox auscultationCheckBox;

    @FXML
    private CheckBox asthamaCheckBox;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;

	
	private Button button;
    
    private CheckBox checkBox;

	FXMLFormPath formPath = new FXMLFormPath();

	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button, CheckBox checkBox) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
		this.checkBox = checkBox;
	}

	public static Integer formCount = 0;
	private Integer secondFormCount = 0;

	public String str="\n\n";

	void formCountIncrement() {
		++secondFormCount;
	}
	
	
	public void setRespUI(){
    	
    	
    	if(allNormalCheckBox.isSelected()){
    		
    		StringBuilder str1 = new StringBuilder(str);
			str1.append("RESPIRATORY/LUNGS: Chest examined for equal movement, bilaterally.  Lungs examined for equality of breath sounds."
					+ " Presence or absence of rales noted bilaterally.  Examined for the presence of diffuse or scattered wheezes. "
					+ " No abnormal findings.\n\nCHEST WALL: Patient chest examined for deformities or pectus abnormalities. "
					+ "Breathing observed for signs of intercostal retractions, splinting or use of accessory muscles.  No abnormal findings.");
			str = str1.toString();
			allNormalCheckBox.setSelected(false);
			setRespUI();
    	}
    	
    	else if(examCheckBox.isSelected()){
    		
    		formCountIncrement();
    		String formName = formPath.context.getMessage("RespExamCompMultiSys", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.RespExamCompMultiSys", null, Locale.US);
			formPath.closeApplicationContext();
			
			RespExamCompMultiSysInputController respExamCompMultiSysInputController=
		   (RespExamCompMultiSysInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			respExamCompMultiSysInputController.setExamRespInputController(this);
			examCheckBox.setSelected(false);
			
			
        }

        else if(assesmentCheckBox.isSelected()){
        	
    		formCountIncrement();
    		String formName = formPath.context.getMessage("RespAssesmentEffort", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.RespAssesmentEffort", null, Locale.US);
			formPath.closeApplicationContext();
			
			RespAssesmentEffortInputController respAssesmentEffortInputController=
		   (RespAssesmentEffortInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			respAssesmentEffortInputController.setExamRespInputController(this);
			assesmentCheckBox.setSelected(false);
			
        }
        else if(palpationCheckBox.isSelected()){
        	
    		formCountIncrement();
    		String formName = formPath.context.getMessage("RespChestPalpation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.RespChestPalpation", null, Locale.US);
			formPath.closeApplicationContext();
			
			RespChestPalpationInputController respChestPalpationInputController=
		   (RespChestPalpationInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			respChestPalpationInputController.setExamRespInputController(this);
			palpationCheckBox.setSelected(false);
			
        }
        else  if(percussionCheckBox.isSelected()){
        	 
    		formCountIncrement();
    		String formName = formPath.context.getMessage("RespChestPercussion", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.RespChestPercussion", null, Locale.US);
			formPath.closeApplicationContext();
			
			RespChestPercussionInputController percussionInputController=
		   (RespChestPercussionInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			percussionInputController.setExamRespInputController(this);
			percussionCheckBox.setSelected(false);
			
        }else  if(auscultationCheckBox.isSelected()){
       	 
   		formCountIncrement();
   		String formName = formPath.context.getMessage("RespLungAuscultation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.RespLungAuscultation", null, Locale.US);
			formPath.closeApplicationContext();
			
			RespLungAuscultationInputController lungAuscultationInputController=
		   (RespLungAuscultationInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			lungAuscultationInputController.setExamRespInputController(this);
			auscultationCheckBox.setSelected(false);
			
       }else if(asthamaCheckBox.isSelected()){
       	
       	StringBuilder str1 = new StringBuilder(str);
			str1.append("RESPIRATORY: Examinations of the chest show rapid respiratory excursions, and costal margin retractions noted. "
					+ "Bilateral wheezes heard with a prolonged expiratory phase noted on auscultation Palpation and percussion were normal.");
			str = str1.toString();
			asthamaCheckBox.setSelected(false);
			setRespUI();
			
       }else if(asthamaBronCheckBox.isSelected()){
       	
       	StringBuilder str1 = new StringBuilder(str);
			str1.append("RESPIRATORY: Examinations of the chest show respiratory excursions normal, and minimal costal margin retractions noted. "
					+ "Occasional wheezes and rhonchi heard with a prolonged expiratory phase noted. Palpation and percussion were normal.");
			str = str1.toString();
			asthamaBronCheckBox.setSelected(false);
			setRespUI();
			
       }else if(rabPainCheckBox.isSelected()){
       	
       	StringBuilder str1 = new StringBuilder(str);
			str1.append("RESPIRATORY: Examinations of the chest show respiratory excursions guarded, and splinting on the affected side. "
					+ "No retractions noted. Palpation is tender. Auscultation reveals normal but diminished breath sounds on the affected side.");
			str = str1.toString();
			rabPainCheckBox.setSelected(false);
			setRespUI();
			
       }else if(secondFormCount==formCount){
        	 
		genericEMRChartingController.paint(button);
		genericEMRChartingController.hideCheckBox(checkBox);
		new FXFormCommonUtilities().closeForm(doneBtn);
		formCount=0;
		genericEMRChartingController.setExamOrganTextArea(str);
		genericEMRChartingController.saveAllTextArea();
    	
	}
    	
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			setRespUI();
	        genericEMRChartingController.saveAllTextArea();
		
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
