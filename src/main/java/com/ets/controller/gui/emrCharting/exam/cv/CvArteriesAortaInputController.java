package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvArteriesAortaInputController Class
 *Description: cvArteriesAorta GUI Controller class
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
public class CvArteriesAortaInputController implements Initializable{
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox aortaAllNormalCheckBox;

    @FXML
    private RadioButton aortaPulsatileCheckBox;

    @FXML
    private ToggleGroup aorta;

    @FXML
    private RadioButton aortaEnlargedCheckBox;

    @FXML
    private RadioButton aortaEnlarged3CheckBox;

    @FXML
    private RadioButton aortaEnlarged5CheckBox;

    @FXML
    private RadioButton aortaEnlarged7CheckBox;

    @FXML
    private RadioButton aortaEnlarged4CheckBox;

    @FXML
    private RadioButton aortaEnlarged6CheckBox;
	    
	    private ExamCvInputController examCvInputController;

		public void setExamCvInputController(ExamCvInputController examCvInputController) {
			this.examCvInputController = examCvInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\n:CV ");
			examCvInputController.str = examComp.toString();

			
				
			
			
			
			
			if(aortaAllNormalCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Abdominal aorta is normal. ");
				examCvInputController.str = str1.toString();
				
				
			}else{
				
				
				
				if (aortaEnlarged3CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 3 cm.");
					examCvInputController.str = str1.toString();

				}if (aortaEnlarged4CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 4 cm.");
					examCvInputController.str = str1.toString();

				}
				if (aortaEnlarged5CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 5 cm.");
					examCvInputController.str = str1.toString();

				}
				if (aortaEnlarged6CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 6 cm.");
					examCvInputController.str = str1.toString();

				}
				if (aortaEnlarged7CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 7 cm.");
					examCvInputController.str = str1.toString();

				}if (aortaEnlargedCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged. ");
					examCvInputController.str = str1.toString();

				}
				if (aortaPulsatileCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is pulsatile. ");
					examCvInputController.str = str1.toString();

				}
				
			}
				
			
				
				
			
			
			
			
			
			
			
			

			++examCvInputController.formCount;
			examCvInputController.setCvUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			
			
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examCvInputController.formCount;
				examCvInputController.setCvUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
