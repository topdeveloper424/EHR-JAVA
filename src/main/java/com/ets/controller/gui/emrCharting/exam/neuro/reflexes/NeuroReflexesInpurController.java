package com.ets.controller.gui.emrCharting.exam.neuro.reflexes;

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
 *Parameter Definition: Type object of NeuroReflexesInpurController Class
 *Description:  neuroExamReflexes GUI Controller class
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
public class NeuroReflexesInpurController  implements Initializable{

	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox reflexBiceps;

	    @FXML
	    private CheckBox reflexAnkle;

	    @FXML
	    private CheckBox reflexTriceps;

	    @FXML
	    private CheckBox reflexBrachioradialis;

	    @FXML
	    private CheckBox babinskiFlexor;

	    @FXML
	    private CheckBox babinskiExtensor;

	    @FXML
	    private CheckBox babinskiEquivocal;

	    @FXML
	    private CheckBox deep0;

	    @FXML
	    private CheckBox abnormalLeft;

	    @FXML
	    private CheckBox deepNormal;

	    @FXML
	    private CheckBox deep1;

	    @FXML
	    private CheckBox deep2;

	    @FXML
	    private CheckBox deep3;

	    @FXML
	    private CheckBox deep4;

	    @FXML
	    private CheckBox reflexKnee;

	    @FXML
	    private CheckBox abnormalRight;

	    @FXML
	    private CheckBox abnormal0;

	    @FXML
	    private CheckBox abnormal1;

	    @FXML
	    private CheckBox abnormal2;

	    @FXML
	    private CheckBox abnormal3;

	    @FXML
	    private CheckBox abnormal4;

	    @FXML
	    private CheckBox abnormalBiceps;

	    @FXML
	    private CheckBox abnormalTriceps;

	    @FXML
	    private CheckBox abnormalBrachioradialis;

	    @FXML
	    private CheckBox abnormalKnee;

	    @FXML
	    private CheckBox abnormalAnkle;

	    @FXML
	    private CheckBox babinskiRight;

	    @FXML
	    private CheckBox babinskiLeft;

	private NeuroInputController neuroInputController;
	
	
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\n");
			neuroInputController.str = skelComp.toString();


			if (deepNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Neurological exam showed normal reflexes.");
				neuroInputController.str = str1.toString();

			}else{
				
				if (deep0.isSelected()||deep1.isSelected()||deep2.isSelected()||deep3.isSelected()
						||deep4.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Deep tendon reflexes were ");
					neuroInputController.str = str1.toString();

				}
				
				
				if (deep0.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("0,");
					neuroInputController.str = str1.toString();

				}	
				if (deep1.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("1+,");
					neuroInputController.str = str1.toString();

				}	
				

				if (deep2.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("2+,");
					neuroInputController.str = str1.toString();

				}	
				if (deep3.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("3+,");
					neuroInputController.str = str1.toString();

				}	
				if (deep4.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("4+.");
					neuroInputController.str = str1.toString();

				}	
				
			}
	
			if (reflexBiceps.isSelected()||reflexAnkle.isSelected()||reflexBrachioradialis.isSelected()||reflexTriceps.isSelected()
					||reflexKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("in the ");
				neuroInputController.str = str1.toString();

			}
			
			
			if (reflexBiceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("biceps,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexAnkle.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("ankle,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexBrachioradialis.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("brachioradialis,");
				neuroInputController.str = str1.toString();

			}	
			if (reflexKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("knee,");
				neuroInputController.str = str1.toString();

			}if (reflexTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("triceps,");
				neuroInputController.str = str1.toString();

			}
			
			
			if (abnormalLeft.isSelected()||abnormal0.isSelected()||abnormal1.isSelected()||abnormal2.isSelected()
					||abnormal3.isSelected()||abnormal4.isSelected()||abnormalAnkle.isSelected()
					||abnormalBiceps.isSelected()||abnormalBrachioradialis.isSelected()||abnormalKnee.isSelected()
					||abnormalRight.isSelected()||abnormalTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Abnormalities were noted in the");
				neuroInputController.str = str1.toString();

			}
			
			
			if (abnormal0.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("0+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal1.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("1+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal2.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("2+,");
				neuroInputController.str = str1.toString();

			}	
			if (abnormal3.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("3+,");
				neuroInputController.str = str1.toString();

			}if (abnormal4.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("4+,");
				neuroInputController.str = str1.toString();

			}if (abnormalAnkle.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("ankle,,");
				neuroInputController.str = str1.toString();

			}if (abnormalBiceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("biceps,");
				neuroInputController.str = str1.toString();

			}if (abnormalBrachioradialis.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("brachioradialis,");
				neuroInputController.str = str1.toString();

			}if (abnormalKnee.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("knee,");
				neuroInputController.str = str1.toString();

			}if (abnormalLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left,");
				neuroInputController.str = str1.toString();

			}if (abnormalRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right,");
				neuroInputController.str = str1.toString();

			}if (abnormalTriceps.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("triceps,");
				neuroInputController.str = str1.toString();

			}
			
			
			
			
			if (babinskiEquivocal.isSelected()||babinskiExtensor.isSelected()||babinskiFlexor.isSelected()
					||babinskiLeft.isSelected()||babinskiRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Babinski response was ");
				neuroInputController.str = str1.toString();

			}
			
			
			if (babinskiEquivocal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("equivocal, ,");
				neuroInputController.str = str1.toString();

			}	
			

			if (babinskiExtensor.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("extensor,");
				neuroInputController.str = str1.toString();

			}	
			if (babinskiFlexor.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" flexor,");
				neuroInputController.str = str1.toString();

			}	
				
			if (babinskiLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("left,");
				neuroInputController.str = str1.toString();

			}	if (babinskiRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("right ,");
				neuroInputController.str = str1.toString();

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