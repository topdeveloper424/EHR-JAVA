package com.ets.controller.gui.emrCharting.exam.cv;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvFemoralPulsesInputController Class
 *Description: cvFemoralPulses GUI Controller class
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

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class CvFemoralPulsesInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox FemoralLeft3;

	@FXML
	private CheckBox FemoralLeft4;

	@FXML
	private CheckBox FemoralLeftWithBruit;

	@FXML
	private CheckBox FemoralLeft2;

	@FXML
	private CheckBox FemoralLeft1;

	@FXML
	private CheckBox FemoralLeftWithoutBruit;

	@FXML
	private CheckBox FemoralLeftAbsent;

	@FXML
	private CheckBox FemoralLeftNormal;

	@FXML
	private CheckBox FemoralRight3;

	@FXML
	private CheckBox FemoralRight4;

	@FXML
	private CheckBox FemoralRightWithBruit;

	@FXML
	private CheckBox FemoralRight2;

	@FXML
	private CheckBox FemoralRight1;

	@FXML
	private CheckBox FemoralRightWithoutBruit;

	@FXML
	private CheckBox FemoralRightAbsent;

	private ExamCvInputController examCvInputController;

	public void setExamCvInputController(ExamCvInputController examCvInputController) {
		this.examCvInputController = examCvInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\n: ");
			examCvInputController.str = examComp.toString();

if(FemoralLeftNormal.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Femoral pulses are normal. ");
				examCvInputController.str = str1.toString();
				
				
			}else{
				
				
				if (FemoralLeft1.isSelected() || FemoralLeft2.isSelected() || FemoralLeft3.isSelected()
						|| FemoralLeft4.isSelected() || FemoralLeftAbsent.isSelected()
						|| FemoralLeftWithBruit.isSelected() || FemoralLeftWithoutBruit.isSelected()) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Femoral pulses show: left ");
					examCvInputController.str = str11.toString();
				
				if (FemoralLeft1.isSelected()) {
					 
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+1, ");
					examCvInputController.str = str1.toString();

				}if (FemoralLeft2.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+2, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeft3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+3, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeft4.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+4, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeftAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("absent, ");
					examCvInputController.str = str1.toString();

				}if (FemoralLeftWithBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with bruit, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeftWithoutBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("without bruit, ");
					examCvInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();
				 
			}
				
			}
				
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (FemoralRight1.isSelected() || FemoralRight2.isSelected() || FemoralRight3.isSelected()
					|| FemoralRight4.isSelected() || FemoralRightAbsent.isSelected() || FemoralRightWithBruit.isSelected()
					|| FemoralRightWithoutBruit.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Femoral pulses show: right ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (FemoralRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+1, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight2.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+2, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+3, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight4.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+4, ");
					examCvInputController.str = str1.toString();

				}if (FemoralRightAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("absent, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRightWithBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with bruit, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRightWithoutBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("without bruit, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

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
