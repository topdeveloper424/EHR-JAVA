package com.ets.controller.gui.emrCharting.ros.ent;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosEntInputController Class
 *Description: Ent.fxm GUI Controller class
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
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class RosEntInputController implements Initializable{
	
	 @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton bleedingRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton earachesRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton earRadio;

	    @FXML
	    private RadioButton heyFeverRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton hearingLossRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton hoarsenseRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton nasalRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton noseBleedRadio;

	    @FXML
	    private ToggleGroup itching;

	    @FXML
	    private RadioButton sinusRadio;

	    @FXML
	    private ToggleGroup redness;

	    @FXML
	    private RadioButton soreThroatRadio;

	    @FXML
	    private ToggleGroup wear;

	    @FXML
	    private RadioButton bleedingPlusRadio;

	    @FXML
	    private RadioButton bleedingMinusRadio;

	    @FXML
	    private RadioButton bleedingQuesRadio;

	    @FXML
	    private RadioButton hearingLossQuesRadio;

	    @FXML
	    private RadioButton hearingLossMinusRadio;

	    @FXML
	    private RadioButton hearingLossPlusRadio;

	    @FXML
	    private RadioButton nasalPlusRadio;

	    @FXML
	    private RadioButton nasalMinusRadio;

	    @FXML
	    private RadioButton nasalQuesRadio;

	    @FXML
	    private RadioButton sinusPlusRadio;

	    @FXML
	    private RadioButton sinusMinusRadio;

	    @FXML
	    private RadioButton sinusQuesRadio;

	    @FXML
	    private RadioButton soreThroatPlusRadio;

	    @FXML
	    private RadioButton soreThroatMinusRadio;

	    @FXML
	    private RadioButton soreThroatQuesRadio;

	    @FXML
	    private RadioButton earachesPlusRadio;

	    @FXML
	    private RadioButton earachesMinusRadio;

	    @FXML
	    private RadioButton earachesQuesRadio;

	    @FXML
	    private RadioButton earQuesRadio;

	    @FXML
	    private ToggleGroup dimness;

	    @FXML
	    private RadioButton earMinusRadio;

	    @FXML
	    private RadioButton earPlusRadio;

	    @FXML
	    private RadioButton heyFeverPlusRadio;

	    @FXML
	    private RadioButton heyFeverMinusRadio;

	    @FXML
	    private RadioButton heyFeverQuesRadio;

	    @FXML
	    private RadioButton hoarsensePlusRadio;

	    @FXML
	    private RadioButton hoarsenseMinusRadio;

	    @FXML
	    private RadioButton hoarsenseQuesRadio;

	    @FXML
	    private RadioButton noseBleedPlusRadio;

	    @FXML
	    private RadioButton noseBleedMinusRadio;

	    @FXML
	    private RadioButton noseBleedQuesRadio;

	    @FXML
	    private RadioButton tinnitusRadio;

	    @FXML
	    private ToggleGroup tinnitus;

	    @FXML
	    private RadioButton vertigoRadio;

	    @FXML
	    private ToggleGroup vertigo;

	    @FXML
	    private RadioButton tinnitusPlusRadio;

	    @FXML
	    private RadioButton vertigoPlusRadio;

	    @FXML
	    private RadioButton tinnitusMinusRadio;

	    @FXML
	    private RadioButton vertigoMinusRadio;

	    @FXML
	    private RadioButton tinnitusQuesRadio;

	    @FXML
	    private RadioButton vertigoQuesRadio;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;

	
	    private Button button;
		
	    private GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {
			try {
				genericEMRChartingController.setRosTextArea("\n\nEARS, NOSE, MOUTH & THROAT: ");
				
				if (deniesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies bleeding gums, earaches, ear discharge, hay fever or seasonal allergies, hearing loss, hoarseness, nasal discharge or nosebleeds, sinus problems, sore throats, tinnitus or vertigo.");

				}
				if (bleedingRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Bleeding gums");

				}
				if (bleedingPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims Bleeding gums");

				}
				if (bleedingMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies Bleeding gums");

				}
				if (bleedingQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about Bleeding gums");

				}
				if (earachesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("earaches");
			
				}
				if (earachesPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims earaches");

				}
				if (earachesMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies earaches");

				}
				if (earachesQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about earaches");

				}
				if (earRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("ear discharge");

				}
				if (earPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims ear discharge");

				}
				if (earMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies ear discharge");

				}
				if (earQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about ear discharge");

				}
				if (heyFeverRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("hay fever/seasonal allergies");

				}
				if (heyFeverPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims hay fever/seasonal allergies");

				}
				if (heyFeverMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies hay fever/seasonal allergies");

				}
				if (heyFeverQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about hay fever/seasonal allergies");

				}
				if (hearingLossRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("hearing loss");
					
				}
				if (hearingLossPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims hearing loss");

				}
				if (hearingLossMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies hearing loss");

				}
				if (hearingLossQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about hearing loss");

				}
				if (hoarsenseRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("hoarseness");

				}
				if (hoarsensePlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims hoarseness");

				}
				if (hoarsenseMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies hoarseness");

				}
				if (hoarsenseQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about hoarseness");

				}
				if (nasalRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("nasal discharge");

				}
				if (nasalPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims nasal discharge");

				}
				if (nasalMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nasal discharge");

				}
				if (nasalQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about nasal discharge");

				}
				if (noseBleedRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("nosebleeds");

				}
				if (noseBleedPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims nosebleeds");

				}
				if (noseBleedMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies nosebleeds");

				}
				if (noseBleedQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about nosebleeds");

				}
				if (sinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("sinus problems");

				}
				if (sinusPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims sinus problems");

				}
				if (sinusMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies sinus problems");

				}
				if (sinusQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about sinus problems");

				}
				if (soreThroatRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("sore throats");

				}
				if (soreThroatPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims sore throats");

				}

				if (soreThroatMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies sore throats");

				}
				if (soreThroatQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about sore throats");

				}
				if (tinnitusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("tinnitus");

				}
				if (tinnitusPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims tinnitus");

				}
				if (tinnitusMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies tinnitus");

				}
				if (tinnitusQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about tinnitus");

				}
				if (vertigoRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("vertigo");

				}
				if (vertigoPlusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Claims vertigo");

				}
				if (vertigoMinusRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Denies vertigo");

				}
				if (vertigoQuesRadio.isSelected()) {

					genericEMRChartingController.setRosTextArea("Unsure about vertigo");

				}


				
				genericEMRChartingController.saveAllTextArea();

				button.setTextFill(Color.GREEN);
				new FXFormCommonUtilities().closeForm( doneBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
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
