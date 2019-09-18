package com.ets.controller.gui.emrCharting.exam.neuro.knowledgeAttention;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.neuro.NeuroInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroKnowledgeAttentionInputController Class
 *Description: neuroExamKnowledgeAndAttention GUI Controller class
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
public class NeuroKnowledgeAttentionInputController implements Initializable {

	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox attentionNormal;

	    @FXML
	    private RadioButton attentionNormalRadio;

	    @FXML
	    private RadioButton attentionMarkedlyRadio;

	    @FXML
	    private RadioButton attentionDecreasedRadio;

	    @FXML
	    private RadioButton attentionScatteredRadio;

	    @FXML
	    private CheckBox speechNormal;

	    @FXML
	    private RadioButton speechNormalRadio;

	    @FXML
	    private RadioButton speechIncreasedRadio;

	    @FXML
	    private RadioButton speechDecreasedRadio;

	    @FXML
	    private CheckBox languageNO;

	    @FXML
	    private CheckBox languageComplete;

	    @FXML
	    private CheckBox languageReceptive;

	    @FXML
	    private CheckBox languagePartial;

	    @FXML
	    private CheckBox languageExpressive;

	    @FXML
	    private RadioButton clarityNormalRadio;

	    @FXML
	    private RadioButton ClarityDecreasedRadio;

	    @FXML
	    private CheckBox normalFund;

	    @FXML
	    private RadioButton fundAppropriate;

	    @FXML
	    private RadioButton fundLessthan;

	    @FXML
	    private RadioButton fundGreaterThan;

	    @FXML
	    private RadioButton fundMarkedlyLessThan;

	    private NeuroInputController neuroInputController;
	
	
	public void setNeuroInputController(NeuroInputController neuroInputController) {
		this.neuroInputController = neuroInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(neuroInputController.str);
			skelComp.append("\n\nNEUROLOGICAL: ");
			neuroInputController.str = skelComp.toString();

			if (attentionNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Attention span normal.");
				neuroInputController.str = str1.toString();

			}else{
				if (attentionScatteredRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Attention span scattered");
					neuroInputController.str = str1.toString();

				}
				if (attentionMarkedlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Attention span markedly decreased");
					neuroInputController.str = str1.toString();

				}
				if (attentionNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Attention span normal");
					neuroInputController.str = str1.toString();

				}
				if (attentionDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Attention span decreased");
					neuroInputController.str = str1.toString();

				}
			
			}
			
			if (speechNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append(" Language and speech normal, ");
				neuroInputController.str = str1.toString();

			} else {

				if (speechNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Speech shows normal production ");
					neuroInputController.str = str1.toString();

				}
				if (speechDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Speech shows decreased production ");
					neuroInputController.str = str1.toString();

				}
				if (speechIncreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Speech shows increased production ");
					neuroInputController.str = str1.toString();

				}
				
				
			}
			
			
			
			
			
			
				if (languageNO.isSelected() || languagePartial.isSelected() || languageComplete.isSelected()
						|| languageExpressive.isSelected() || languageReceptive.isSelected()) {

					StringBuilder str11 = new StringBuilder(neuroInputController.str);
					str11.append("with no aphasia and normal clarity. with ");
					neuroInputController.str = str11.toString();
					
					
					if (languageNO.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("no, ");
						neuroInputController.str = str1.toString();
					}
						
						if (languagePartial.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("partial, ");
							neuroInputController.str = str1.toString();

						}
						if (languageComplete.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("complete, ");
							neuroInputController.str = str1.toString();

						}
						if (languageExpressive.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("expressive, ");
							neuroInputController.str = str1.toString();

						}   
						if (languageReceptive.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("receptive, ");
							neuroInputController.str = str1.toString();

						}
						
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("aphasia, ");
						neuroInputController.str = str1.toString();
						

				}

			
				if (languageNO.isSelected() || languagePartial.isSelected() || languageComplete.isSelected()
						|| languageExpressive.isSelected() || languageReceptive.isSelected()) {

					StringBuilder str11 = new StringBuilder(neuroInputController.str);
					str11.append("with no aphasia and normal clarity. with ");
					neuroInputController.str = str11.toString();
					
					
					if (languageNO.isSelected()) {

						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("no, ");
						neuroInputController.str = str1.toString();
					}
						
						if (languagePartial.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("partial, ");
							neuroInputController.str = str1.toString();

						}
						if (languageComplete.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("complete, ");
							neuroInputController.str = str1.toString();

						}
						if (languageExpressive.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("expressive, ");
							neuroInputController.str = str1.toString();

						}   
						if (languageReceptive.isSelected()) {

							StringBuilder str1 = new StringBuilder(neuroInputController.str);
							str1.append("receptive, ");
							neuroInputController.str = str1.toString();

						}
						
						StringBuilder str1 = new StringBuilder(neuroInputController.str);
						str1.append("aphasia, ");
						neuroInputController.str = str1.toString();
						

				}

			
			
			
				
				if (clarityNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" normal clarity. ");
					neuroInputController.str = str1.toString();

				}if (ClarityDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" decreased clarity.");
					neuroInputController.str = str1.toString();

				}			
			
			
			
			
			
			if (normalFund.isSelected()) {

				StringBuilder str1 = new StringBuilder(neuroInputController.str);
				str1.append("Fund of knowledge is appropriate.");
				neuroInputController.str = str1.toString();

			} else {

				
				if (fundAppropriate.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append(" Fund of knowledge appears appropriate to patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundGreaterThan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears greater than patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundLessthan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears less than patient's stated level of education.");
					neuroInputController.str = str1.toString();

				}
				if (fundMarkedlyLessThan.isSelected()) {

					StringBuilder str1 = new StringBuilder(neuroInputController.str);
					str1.append("Fund of knowledge appears markedly less than patient's stated level of education.");
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