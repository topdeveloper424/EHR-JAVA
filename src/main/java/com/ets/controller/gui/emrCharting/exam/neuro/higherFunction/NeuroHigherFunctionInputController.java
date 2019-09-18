package com.ets.controller.gui.emrCharting.exam.neuro.higherFunction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroHigherFunctionInputController Class
 *Description: neuroExamHigherFunctions GUI Controller class
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
public class NeuroHigherFunctionInputController implements Initializable {

    @FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox personPlaceTimeCheck;

    @FXML
    private CheckBox personlCheck;

    @FXML
    private CheckBox placeCheck;

    @FXML
    private CheckBox abnormalPersonPlaceTimeCheck;

    @FXML
    private CheckBox abnormalPersonCheck;

    @FXML
    private CheckBox abnormalTimeCheck;

    @FXML
    private CheckBox wellOrientedlNormalCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox attentionAllNormalChk;

    @FXML
    private CheckBox recentNormalCheck;

    @FXML
    private CheckBox timeCheck;

    @FXML
    private CheckBox abnormalPlaceCheck;

    @FXML
    private RadioButton recentIntactRadio;

    @FXML
    private ToggleGroup recent;

    @FXML
    private RadioButton recentAbsentRadio;

    @FXML
    private RadioButton recentDecreasedRadio;

    @FXML
    private RadioButton recentMarkdlyRadio;

    @FXML
    private RadioButton remoteIntactRadio;

    @FXML
    private ToggleGroup remote;

    @FXML
    private RadioButton remoteAbsentRadio;

    @FXML
    private RadioButton remoteDecreasedtRadio;

    @FXML
    private RadioButton remoteMarkdlyRadio;

    @FXML
    private RadioButton attentionNormalRadio;

    @FXML
    private ToggleGroup mood;

    @FXML
    private RadioButton attentionScatteredRadio;

    @FXML
    private RadioButton attentionDecreasedRadio;

    @FXML
    private RadioButton attentionMarkedlyRadio;

    @FXML
    private RadioButton speechNormalRadio;

    @FXML
    private ToggleGroup speech;

    @FXML
    private RadioButton speechDecreasedRadio;

    @FXML
    private RadioButton speechIncreasedRadio;

    @FXML
    private CheckBox langNo;

    @FXML
    private CheckBox langPartial;

    @FXML
    private CheckBox langreceptive;

    @FXML
    private CheckBox langExpressive;

    @FXML
    private CheckBox remoteAllNormalChk1;

    @FXML
    private CheckBox speechNormal;

    @FXML
    private CheckBox langComplete;

    @FXML
    private RadioButton clarityNormalRadio;

    @FXML
    private ToggleGroup speech1;

    @FXML
    private RadioButton clarityDecreasedRadio;

    @FXML
    private ToggleGroup speech2;

    @FXML
    private CheckBox fundNormal;

    @FXML
    private RadioButton fundAppropriateRadio;

    @FXML
    private ToggleGroup speech11;

    @FXML
    private RadioButton fundMarkedlyRadio;

    @FXML
    private ToggleGroup speech111;

    @FXML
    private RadioButton fundGreaterThanRadio;

    @FXML
    private ToggleGroup speech1111;

    @FXML
    private RadioButton fundLessthanRadio;

    @FXML
    private ToggleGroup speech11111;
	private NeuroInputController neuroInputController;
	
	
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGIC:");
			neuroInputController.str = skelComp.toString();

			if (wellOrientedlNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Patient is oriented to person, place and time.");
				neuroInputController.str = str1.toString();

			}
			else{

			if (wellOrientedlNormalCheck.isSelected()||personPlaceTimeCheck.isSelected()
					||personlCheck.isSelected()||timeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Patient is oriented to ");
				neuroInputController.str = str1.toString();

			}
			
		  if (personPlaceTimeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" person, place and time.");
				neuroInputController.str = str1.toString();

			}
			if (personlCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" person.");
				neuroInputController.str = str1.toString();

			}if (placeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" place.");
				neuroInputController.str = str1.toString();

			}
			if (timeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" time.");
				neuroInputController.str = str1.toString();

			}
			if (abnormalPersonPlaceTimeCheck.isSelected()||abnormalPersonCheck.isSelected()
					||abnormalPlaceCheck.isSelected()||abnormalTimeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Patient is not oriented to ");
				neuroInputController.str = str1.toString();

			}
			if (abnormalPersonPlaceTimeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" person, place or time,");
				neuroInputController.str = str1.toString();

			}
			if (abnormalPersonCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" person,");
				neuroInputController.str = str1.toString();

			}if (abnormalPlaceCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" place,");
				neuroInputController.str = str1.toString();

			}if (abnormalTimeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" time.");
				neuroInputController.str = str1.toString();

			}
			if (recentNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Recent and remote memory are intact.");
				neuroInputController.str = str1.toString();

			}
			else{
			
			
			if (recentIntactRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Recent memory is intact,");
				neuroInputController.str = str1.toString();

			}
			
			if (recentDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Recent memory is decreased, ");
				neuroInputController.str = str1.toString();

			}if (recentMarkdlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Recent memory is markedly decreased, ");
				neuroInputController.str = str1.toString();

			}if (recentAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Recent memory is absent,");
				neuroInputController.str = str1.toString();

			}
			if (remoteAllNormalChk1.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Remote memory is intact ");
				neuroInputController.str = str1.toString();

			}
			else{
			
			if (remoteIntactRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Remote memory is intact ");
				neuroInputController.str = str1.toString();

			}if (remoteDecreasedtRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Remote memory is decreased, ");
				neuroInputController.str = str1.toString();

			}
			if (remoteMarkdlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Remote memory is markedly decreased");
				neuroInputController.str = str1.toString();

			}
			if (remoteAbsentRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Remote memory is absent ");
				neuroInputController.str = str1.toString();

			}
			
			}
			
			if (attentionAllNormalChk.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Attention span normal  ");
				neuroInputController.str = str1.toString();

			}
		
			else {
				
				if(attentionNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Attention span normal  ");
				neuroInputController.str = str1.toString();

			}	
			if (attentionDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Attention span decreased  ");
				neuroInputController.str = str1.toString();

			}
			if (attentionMarkedlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Attention span markedly decreased");
				neuroInputController.str = str1.toString();

			}
			if (attentionScatteredRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Attention span scattered ");
				neuroInputController.str = str1.toString();

			}
			
			}
			if (speechNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Speech  normal ");
				neuroInputController.str = str1.toString();

			}else{
			
			if (speechNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Speech shows normal production, ");
				neuroInputController.str = str1.toString();

			}
			if (speechDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Speech shows decreased production, ");
				neuroInputController.str = str1.toString();

			}
			if (speechIncreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Speech shows increased production, ");
				neuroInputController.str = str1.toString();

			}
			}
			/*************************************************lang alphasia	*/
			
			
			if (langNo.isSelected()||langPartial.isSelected()||langComplete.isSelected()
					||langExpressive.isSelected()||langreceptive.isSelected()) {

				StringBuilder str11 = new StringBuilder(neuroInputController.str);
				str11.append(" with ");
				neuroInputController.str = str11.toString();

				if (langNo.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("no, ");
					neuroInputController.str = str1.toString();

				}
				if (langPartial.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("partial, ");
					neuroInputController.str = str1.toString();

				}if (langComplete.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("complete, ");
					neuroInputController.str = str1.toString();

				}if (langExpressive.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("expressive, ");
					neuroInputController.str = str1.toString();

				}
				if (langreceptive.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" receptive. ");
					neuroInputController.str = str1.toString();

				}
				StringBuilder str12 = new StringBuilder(neuroInputController.str);
				str12.append(" aphasia,");
				neuroInputController.str = str12.toString();
				
			}
			
			
			
			
			
			/*************************************************lang alphasia	*/
			
			
			if (clarityNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("  normal clarity. ");
				neuroInputController.str = str1.toString();

			}
			

			if (clarityDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" decreased clarity. ");
				neuroInputController.str = str1.toString();

			}
			if (fundAppropriateRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Fund of knowledge is appropriate., Fund of knowledge is appropriate.");
				neuroInputController.str = str1.toString();

			}
			
			else{

			if (fundAppropriateRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Fund of knowledge appears appropriate to patient's stated level of education. ");
				neuroInputController.str = str1.toString();

			}
			if (fundMarkedlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Fund of knowledge appears markedly decreased to patient's stated level of education.");
				neuroInputController.str = str1.toString();

			}
			if (fundGreaterThanRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Fund of knowledge appears greater  than to patient's stated level of education. ");
				neuroInputController.str = str1.toString();

			}
			if (fundLessthanRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Fund of knowledge appears less than to patient's stated level of education.");
				neuroInputController.str = str1.toString();

			}}}
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