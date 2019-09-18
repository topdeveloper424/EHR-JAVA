package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvHeartPulpationInputController Class
 *Description: HeartPalpation GUI Controller class
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
public class CvHeartPulpationInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox palpationNormal;

	    @FXML
	    private CheckBox ApicalNormal;

	    @FXML
	    private CheckBox ApicalHypodynamic;

	    @FXML
	    private CheckBox ApicalHyperdynamic;

	    @FXML
	    private CheckBox ApicalDiffuse;

	    @FXML
	    private RadioButton palpationNormalyLocatedRadio;

	    @FXML
	    private RadioButton palpationDeviatedLaterallyRadio;
	    
	    private ExamCvInputController examCvInputController;

		public void setExamCvInputController(ExamCvInputController examCvInputController) {
			this.examCvInputController = examCvInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\nCV: ");
			examCvInputController.str = examComp.toString();

			if (palpationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Apical impulse is normal. ");
				examCvInputController.str = str1.toString();

			} else {

			

					if (palpationNormalyLocatedRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("Apical impulse is normally located. ");
						examCvInputController.str = str1.toString();

					}
					if (palpationDeviatedLaterallyRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("Apical impulse is deviated laterally. ");
						examCvInputController.str = str1.toString();

					}
				

			}
			
			
			
			
			
			
			if (ApicalDiffuse.isSelected() || ApicalHyperdynamic.isSelected() 
					|| ApicalHypodynamic.isSelected() || ApicalNormal.isSelected() ) {

				StringBuilder str12 = new StringBuilder(examCvInputController.str);
				str12.append(" and is ");
				examCvInputController.str = str12.toString();

				if (ApicalDiffuse.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("normal, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalHyperdynamic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("hyperdynamic, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalHypodynamic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("hypodynamic, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("diffuse, ");
					examCvInputController.str = str1.toString();

				}
				

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append(".");
				examCvInputController.str = str11.toString();

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
