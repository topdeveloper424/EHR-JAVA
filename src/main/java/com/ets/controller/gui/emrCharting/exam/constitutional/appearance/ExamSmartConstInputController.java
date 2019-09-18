package com.ets.controller.gui.emrCharting.exam.constitutional.appearance;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamSmartConstInputController Class
 *Description: EditDistrict GUI Controller class
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
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.constutional.ExamConstutionalInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ExamSmartConstInputController implements Initializable{
    @FXML
    private RadioButton wellnourishedRadio;

    @FXML
    private ToggleGroup Appearence;

    @FXML
    private RadioButton cachecticRadio;

    @FXML
    private RadioButton noacutedistress;

    @FXML
    private ToggleGroup Distress;

    @FXML
    private RadioButton moderatediscomfort;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox normalCkeckBox;

    @FXML
    private RadioButton thinRadio;

    @FXML
    private RadioButton flushedRadio;

    @FXML
    private RadioButton obeseRadio;

    @FXML
    private RadioButton washedoutRadio;

    @FXML
    private RadioButton severediscomfort;

   
    private ExamConstutionalInputController examConstutionalInputController;


	public void setExamConstutionalInputController(ExamConstutionalInputController examConstutionalInputController) {
		this.examConstutionalInputController = examConstutionalInputController;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			if(wellnourishedRadio.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" well nourished.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			
			
			if(obeseRadio.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" obese.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(cachecticRadio.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" cachectic.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(thinRadio.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" thin.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(flushedRadio.isSelected()){
				StringBuilder str1=new StringBuilder( examConstutionalInputController.str);
				str1.append(" flushed.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(washedoutRadio.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" washed out.,");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(noacutedistress.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" with no acute distress.");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			if(moderatediscomfort.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" with moderate discomfort.");
				
				examConstutionalInputController.str=str1.toString();
				
			}
			
			if(severediscomfort.isSelected()){
				StringBuilder str1=new StringBuilder(examConstutionalInputController.str);
				str1.append(" with no severe discomfort.");
				
				examConstutionalInputController.str=str1.toString();
				
			}
		/*	++examGIinputController.formCount;	
			examGIinputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);*/
			++examConstutionalInputController.formCount;	
			examConstutionalInputController.setConstUI();
			
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examConstutionalInputController.formCount;	
				examConstutionalInputController.setConstUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	

}
}
