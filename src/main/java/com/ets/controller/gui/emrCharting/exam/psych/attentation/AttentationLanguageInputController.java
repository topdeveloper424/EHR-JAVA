package com.ets.controller.gui.emrCharting.exam.psych.attentation;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AttentationLanguageInputController Class
 *Description: psychAttentation_Language.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.psych.ExamPsychInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AttentationLanguageInputController implements Initializable{
	
	 @FXML
	    private CheckBox spanNormalCkeckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton spanNormalRadio;

	    @FXML
	    private ToggleGroup Insight;

	    @FXML
	    private RadioButton spanDecreasedRadio;

	    @FXML
	    private RadioButton spanScatteedRadio;

	    @FXML
	    private ToggleGroup Judgment;

	    @FXML
	    private RadioButton spanMarkdlyRadio;

	    @FXML
	    private RadioButton speechNormalRadio;

	    @FXML
	    private ToggleGroup Speech;

	    @FXML
	    private RadioButton speechDecreasedRadio;

	    @FXML
	    private RadioButton speechIncreasedlRadio;

	    @FXML
	    private CheckBox noCheck;

	    @FXML
	    private CheckBox completeCheck;

	    @FXML
	    private CheckBox rceptivelCheck;

	    @FXML
	    private CheckBox partialCheck;

	    @FXML
	    private CheckBox expressiveCheck;

	    @FXML
	    private CheckBox fundNormalChk;

	    @FXML
	    private RadioButton clarityNormalRadio;

	    @FXML
	    private ToggleGroup clarity;

	    @FXML
	    private RadioButton clarityDecrasedRadio;

	    @FXML
	    private RadioButton fundAppropiateRadio;

	    @FXML
	    private ToggleGroup fund;

	    @FXML
	    private RadioButton fundGreaterThanRadio;

	    @FXML
	    private RadioButton fundLessthaneRadio;

	    @FXML
	    private RadioButton fundMarkdlyeRadio;

	    @FXML
	    private CheckBox speechNormalCheck;

    
    private ExamPsychInputController examPsychInputController;

	public void setExamPsychInputController(ExamPsychInputController examPsychInputController) {
		this.examPsychInputController = examPsychInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(examPsychInputController.str);
			skelComp.append("\n\nPSYCH: ");
			examPsychInputController.str = skelComp.toString();
			
			if (spanNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Attention span normal.");
				examPsychInputController.str = str1.toString();

			}else{
				if (spanScatteedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Attention span scattered");
					examPsychInputController.str = str1.toString();

				}
				if (spanMarkdlyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Attention span markedly decreased");
					examPsychInputController.str = str1.toString();

				}
				if (spanNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Attention span normal");
					examPsychInputController.str = str1.toString();

				}
				if (spanDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Attention span decreased");
					examPsychInputController.str = str1.toString();

				}
			
			}
			
			if (speechNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(" Language and speech normal, ");
				examPsychInputController.str = str1.toString();

			} else {

				if (speechNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("speech shows normal. ");
					examPsychInputController.str = str1.toString();

				}
				if (speechDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("speech shows decreased. ");
					examPsychInputController.str = str1.toString();

				}
				if (speechIncreasedlRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("speech shows increased. ");
					examPsychInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append(" production. ");
				examPsychInputController.str = str1.toString();

			}
			
			
			
			
			
			
				if (noCheck.isSelected() || partialCheck.isSelected() || completeCheck.isSelected()
						|| expressiveCheck.isSelected() || rceptivelCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examPsychInputController.str);
					str11.append("with no aphasia and normal clarity. with ");
					examPsychInputController.str = str11.toString();
					
					
					if (noCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("no, ");
						examPsychInputController.str = str1.toString();
					}
						
						if (partialCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examPsychInputController.str);
							str1.append("partial, ");
							examPsychInputController.str = str1.toString();

						}
						if (completeCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examPsychInputController.str);
							str1.append("complete, ");
							examPsychInputController.str = str1.toString();

						}
						if (expressiveCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examPsychInputController.str);
							str1.append("expressive, ");
							examPsychInputController.str = str1.toString();

						}   
						if (rceptivelCheck.isSelected()) {

							StringBuilder str1 = new StringBuilder(examPsychInputController.str);
							str1.append("receptive, ");
							examPsychInputController.str = str1.toString();

						}
						
						StringBuilder str1 = new StringBuilder(examPsychInputController.str);
						str1.append("aphasia, ");
						examPsychInputController.str = str1.toString();
						

				}

				

				
				
			
			
			
			
				
				if (clarityNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append(" normal clarity. ");
					examPsychInputController.str = str1.toString();

				}if (clarityDecrasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append(" decreased clarity.");
					examPsychInputController.str = str1.toString();

				}			
			
			
			
			
			
			if (fundNormalChk.isSelected()) {

				StringBuilder str1 = new StringBuilder(examPsychInputController.str);
				str1.append("Fund of knowledge is appropriate.");
				examPsychInputController.str = str1.toString();

			} else {

				
				if (fundAppropiateRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append(" Fund of knowledge appears appropriate to patient's stated level of education.");
					examPsychInputController.str = str1.toString();

				}
				if (fundGreaterThanRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Fund of knowledge appears greater than patient's stated level of education.");
					examPsychInputController.str = str1.toString();

				}
				if (fundLessthaneRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Fund of knowledge appears less than patient's stated level of education.");
					examPsychInputController.str = str1.toString();

				}
				if (fundMarkdlyeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examPsychInputController.str);
					str1.append("Fund of knowledge appears markedly less than patient's stated level of education.");
					examPsychInputController.str = str1.toString();

				}

			}
			

			
			StringBuilder str1 = new StringBuilder(examPsychInputController.str);
			str1.append(".");
			examPsychInputController.str = str1.toString();
			// genericEMRChartingController.saveAllTextArea();
			++examPsychInputController.formCount;
			examPsychInputController.setPsychUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				++examPsychInputController.formCount;
				examPsychInputController.setPsychUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
