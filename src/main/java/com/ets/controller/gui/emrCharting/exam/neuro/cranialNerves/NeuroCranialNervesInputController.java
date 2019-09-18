package com.ets.controller.gui.emrCharting.exam.neuro.cranialNerves;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroCranialNervesInputController Class
 *Description: neuroCranialNerves GUI Controller class
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
public class NeuroCranialNervesInputController  implements Initializable{

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox abnormal;

    @FXML
    private CheckBox decreasedVisionRight2;

    @FXML
    private CheckBox decreasedFacialsensation5;

    @FXML
    private CheckBox weaknessSCM;

    @FXML
    private CheckBox decreasedVisionLeft2;

    @FXML
    private CheckBox tongueWeakneaa;

    @FXML
    private CheckBox uvula9;

    @FXML
    private CheckBox decreasedHearing;

    @FXML
    private CheckBox normal2check;

    @FXML
    private CheckBox decreasedSmell;

    @FXML
    private CheckBox facialWeakness;

    @FXML
    private CheckBox gagReflex;

	private NeuroInputController neuroInputController;
	
	
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGICAL");
			neuroInputController.str = skelComp.toString();

			if (normal2check.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Skin exam reveals no visible or palpable lesions, rashes or abnormalities. ");
				neuroInputController.str = str1.toString();

			}else{
				
				if (decreasedFacialsensation5.isSelected()||decreasedHearing.isSelected()||decreasedSmell.isSelected()
						||decreasedVisionLeft2.isSelected()||decreasedVisionRight2.isSelected()||tongueWeakneaa.isSelected()
						||weaknessSCM.isSelected()||facialWeakness.isSelected()||gagReflex.isSelected()
						||uvula9.isSelected()
						) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Cranial nerves were tested, showing");
					neuroInputController.str = str1.toString();

				}
				
				
				if (decreasedFacialsensation5.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased facial sensation");
					neuroInputController.str = str1.toString();

				}
				if (decreasedHearing.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased hearing");
					neuroInputController.str = str1.toString();

				}
				if (decreasedSmell.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased smell");
					neuroInputController.str = str1.toString();

				}
				if (decreasedVisionLeft2.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased vision left");
					neuroInputController.str = str1.toString();

				}if (decreasedVisionRight2.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("decreased vision right");
					neuroInputController.str = str1.toString();

				}
				if (tongueWeakneaa.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" tongue weakness.");
					neuroInputController.str = str1.toString();

				}
				if (facialWeakness.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("facial Weakness.");
					neuroInputController.str = str1.toString();

				}if (gagReflex.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("gag reflex.");
					neuroInputController.str = str1.toString();

				}if (weaknessSCM.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("weakness SCM.");
					neuroInputController.str = str1.toString();

				}if (uvula9.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("uvula elevation.");
					neuroInputController.str = str1.toString();

				}if (abnormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" abnormal extraocular motions.");
					neuroInputController.str = str1.toString();

				}
			}
			
			StringBuilder str1 = new StringBuilder(neuroInputController.str);
			str1.append(".");
			neuroInputController.str = str1.toString();
			//genericEMRChartingController.saveAllTextArea();
		++neuroInputController.formCount;	
		neuroInputController.setNeuroUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++neuroInputController.formCount;	
				neuroInputController.setNeuroUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
