package com.ets.controller.gui.emrCharting.exam.neck;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckExamInputController Class
 *Description: neckRangeMotion.fxml GUI Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class NeckExamInputController implements Initializable{
	
	@FXML
    private CheckBox JugularNotNotedCheck;

    @FXML
    private CheckBox JugularNotedCheck;

    @FXML
    private CheckBox JugularSevereCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox NeckAllNormalCheckBox;

    @FXML
    private CheckBox NeckAppearenceCheckBox;

    @FXML
    private CheckBox NeckSuppleCheckBox;

    @FXML
    private CheckBox NeckLateralDeviationCheckBox;

    @FXML
    private CheckBox NeckStiffnessCheckBox;

    @FXML
    private CheckBox NeckSwellingCheckBox;

    @FXML
    private CheckBox NeckPulpationCheckBox;

    @FXML
    private CheckBox NeckAsymmetryCheck;

    @FXML
    private CheckBox NeckTendernessCheck;

    @FXML
    private CheckBox NeckMassesCheck;

    @FXML
    private CheckBox NeckDilatedCarotidCheck;
    
    
    private ExamNeckInputController examNeckInputController;

    public void setExamNeckInputController(ExamNeckInputController examNeckInputController) {
		this.examNeckInputController = examNeckInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examNeckInputController.str);
			examComp.append("\n\n ");
			examNeckInputController.str = examComp.toString();

			
		
			if (NeckAllNormalCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("cerumenous, ");
				examNeckInputController.str = str1.toString();
					
				}else{
					
					
					if (NeckAppearenceCheckBox.isSelected() || NeckAsymmetryCheck.isSelected() || NeckDilatedCarotidCheck.isSelected()
							|| NeckLateralDeviationCheckBox.isSelected() || NeckMassesCheck.isSelected()
							|| NeckPulpationCheckBox.isSelected() || NeckStiffnessCheckBox.isSelected() || NeckSuppleCheckBox.isSelected()
							|| NeckSwellingCheckBox.isSelected() || NeckTendernessCheck.isSelected()) {

						StringBuilder str12 = new StringBuilder(examNeckInputController.str);
						str12.append("Examination of the neck revealed ");
						examNeckInputController.str = str12.toString();

						if (NeckAppearenceCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append(" normal appearance ");
							examNeckInputController.str = str1.toString();

						}
						if (NeckAsymmetryCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("asymmetry, ");
							examNeckInputController.str = str1.toString();

						}
						if (NeckDilatedCarotidCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append(" dilated carotid bulb,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckLateralDeviationCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("lateral deviation of head,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckMassesCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("masses,");
							examNeckInputController.str = str1.toString();

						}if (NeckPulpationCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append(" exaggerated pulsations,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckStiffnessCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("stiffness,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckSuppleCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("supple,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckSwellingCheckBox.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("swellings,");
							examNeckInputController.str = str1.toString();

						}
						if (NeckTendernessCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examNeckInputController.str);
							str1.append("tenderness,");
							examNeckInputController.str = str1.toString();

						}
						
						StringBuilder str11 = new StringBuilder(examNeckInputController.str);
						str11.append(".");
						examNeckInputController.str = str11.toString();

					}
					
				}
				
		
			
			if (JugularNotNotedCheck.isSelected() || JugularNotedCheck.isSelected()||JugularSevereCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examNeckInputController.str);
				str11.append("Jugular venous distension: ");
				examNeckInputController.str = str11.toString();

				if (JugularNotNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append(" not noted, ");
					examNeckInputController.str = str1.toString();

				}
				if (JugularNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("noted,");
					examNeckInputController.str = str1.toString();

				}
				if (JugularSevereCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("serve");
					examNeckInputController.str = str1.toString();

				}
						
					
					

					StringBuilder str12 = new StringBuilder(examNeckInputController.str);
					str12.append(".");
					examNeckInputController.str = str12.toString();

				}

		

			

			++examNeckInputController.formCount;
			examNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examNeckInputController.formCount;
				examNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
