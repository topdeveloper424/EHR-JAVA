package com.ets.controller.gui.emrCharting.exam.neck;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamNeckInputController Class
 *Description: neck.fxml GUI Controller class
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
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamNeckInputController implements Initializable{
	
	
	
	 @FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCompCheckBox;

	    @FXML
	    private CheckBox thyroidCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox rangeofMotionCheckBox;

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

	public String str="\n\nNECK: ";

	void formCountIncrement() {
		++secondFormCount;
	}
	
	public void setNeckUI(){
    	
    	
    	if(allNormalCheckBox.isSelected()){
    		
    		StringBuilder str1 = new StringBuilder(str);
			str1.append("Inspection and palpation of neck normal.");
			str = str1.toString();
			allNormalCheckBox.setSelected(false);
			setNeckUI();
    	}
    	
    	else if(examCompCheckBox.isSelected()){
    		
    		formCountIncrement();
    		String formName = formPath.context.getMessage("NeckExamComp", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.NeckExamComp", null, Locale.US);
			formPath.closeApplicationContext();
			
			NeckExamCompInputController neckExamCompInputController=
		   (NeckExamCompInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			neckExamCompInputController.setExamNeckInputController(this);
			examCompCheckBox.setSelected(false);
			
			
        }

        else if(thyroidCheckBox.isSelected()){
        	
    		formCountIncrement();
    		String formName = formPath.context.getMessage("NeckThyroid", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.NeckThyroid", null, Locale.US);
			formPath.closeApplicationContext();
			
			NeckThyroidInputController neckThyroidInputController=
		   (NeckThyroidInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			neckThyroidInputController.setExamNeckInputController(this);
			thyroidCheckBox.setSelected(false);
			
        }
        else if(examCheckBox.isSelected()){
        	
    		formCountIncrement();
    		String formName = formPath.context.getMessage("NeckExam", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.NeckExam", null, Locale.US);
			formPath.closeApplicationContext();
			
			NeckExamInputController neckExamInputController=
		   (NeckExamInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			neckExamInputController.setExamNeckInputController(this);
			examCheckBox.setSelected(false);
			
        }
        else  if(rangeofMotionCheckBox.isSelected()){
        	 
    		formCountIncrement();
    		String formName = formPath.context.getMessage("NeckRangeMotion", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.NeckRangeMotion", null, Locale.US);
			formPath.closeApplicationContext();
			
			NeckRangeMotionInputController neckRangeMotionInputController=
		   (NeckRangeMotionInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			neckRangeMotionInputController.setExamNeckInputController(this);
			rangeofMotionCheckBox.setSelected(false);
			
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
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		doneBtn.setOnAction((event)->
		{
			
			setNeckUI();
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
