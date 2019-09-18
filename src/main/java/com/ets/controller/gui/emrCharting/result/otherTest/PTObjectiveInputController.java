package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PTObjectiveInputController implements Initializable {
	
	 @FXML
	    private RadioButton EvaluationRadio;

	    @FXML
	    private ToggleGroup Leukocytes;

	    @FXML
	    private RadioButton ReEvaluationRadio;

	    @FXML
	    private RadioButton TherapeuticExercisesRadio;

	    @FXML
	    private ToggleGroup Therapeutic;

	    @FXML
	    private RadioButton GaitTrainingRadio;

	    @FXML
	    private RadioButton ManualTherapyRadio;

	    @FXML
	    private RadioButton TherapeuticActivitiesradio;

	    @FXML
	    private RadioButton TherapeuticExercises2Radio;

	    @FXML
	    private ToggleGroup Procedures;

	    @FXML
	    private RadioButton ManualTherapy2Radio;

	    @FXML
	    private RadioButton GroupTherapy2radio;

	    @FXML
	    private RadioButton Neuromuscular2Radio;

	    @FXML
	    private RadioButton WoundDebridement2Radio;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton NeuromuscularRadio;

	    @FXML
	    private RadioButton TherapeuticMassageRadio;

	    @FXML
	    private RadioButton GroupTherapyRadio;

	    @FXML
	    private RadioButton SoftTissueradio;

	    @FXML
	    private RadioButton WoundDebridementradio;

	    @FXML
	    private RadioButton GaitTraining2Radio;

	    @FXML
	    private RadioButton TherapeuticActivities2Radio;

	    @FXML
	    private RadioButton SoftTissue2radio;

	    @FXML
	    private RadioButton TherapeuticMassage2Radio;

	    @FXML
	    private RadioButton SelectMechanialTractionRadio;

	    @FXML
	    private ToggleGroup Select;

	    @FXML
	    private RadioButton SelecteStimManualRadio;

	    @FXML
	    private RadioButton SelectIontophoresisradio;

	    @FXML
	    private RadioButton SelectElectricalSimulationRadio;

	    @FXML
	    private RadioButton SelectPhonophoresisRadio;

	    @FXML
	    private RadioButton SelectParaffinbathRadio;

	    @FXML
	    private RadioButton SelectContrastBathRadio;

	    @FXML
	    private RadioButton SelectUltrasoundradio;

	    @FXML
	    private RadioButton SelectWhirlpoolRadio;

	    @FXML
	    private RadioButton SupervisedMechanialTractionRadio;

	    @FXML
	    private ToggleGroup Supervised;

	    @FXML
	    private RadioButton SupervisedeStimManualRadio;

	    @FXML
	    private RadioButton SupervisedIontophoresisradio;

	    @FXML
	    private RadioButton SupervisedElectricalSimulationRadio;

	    @FXML
	    private RadioButton SupervisedPhonophoresisRadio;

	    @FXML
	    private RadioButton SupervisedParaffinbathRadio;

	    @FXML
	    private RadioButton SupervisedContrastBathRadio;

	    @FXML
	    private RadioButton SupervisedUltrasoundradio;

	    @FXML
	    private RadioButton SupervisedWhirlpoolRadio;

	    @FXML
	    private CheckBox ElectrodesCheck;

	    @FXML
	    private CheckBox EducationalCheck;

	    @FXML
	    private CheckBox coldCheck;

	    @FXML
	    private CheckBox hotAndColdCheck;

	    @FXML
	    private CheckBox hotCheck;

	    @FXML
	    private TextArea notesTextarea;
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		okBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			if (EvaluationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("PT performed evaluation.");
				resultInputController.str = str1.toString();
				
			}if (ReEvaluationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("PT performed re-evaluation.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (TherapeuticExercisesRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: therapeutic exercises.");
				resultInputController.str = str1.toString();

			}if (ManualTherapyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: manual therapy.");
				resultInputController.str = str1.toString();
				
			}if (WoundDebridementradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: wound debridement.");
				resultInputController.str = str1.toString();

			}if (NeuromuscularRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: neuromuscular re-education.");
				resultInputController.str = str1.toString();

			}if (GroupTherapyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: group therapy.");
				resultInputController.str = str1.toString();
				
			}if (GaitTrainingRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: gait training.");
				resultInputController.str = str1.toString();

			}if (TherapeuticActivitiesradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given:therapeutic Activities.");
				resultInputController.str = str1.toString();

			}if (TherapeuticMassageRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: therapeutic massage.");
				resultInputController.str = str1.toString();
				
			}if (SoftTissueradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following physical therapy procedures were given: soft tissue.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			if (TherapeuticExercises2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("And therapeutic exercises.");
				resultInputController.str = str1.toString();

			}if (ManualTherapy2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and manual therapy.");
				resultInputController.str = str1.toString();
				
			}if (WoundDebridement2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and wound debridement/dressing.");
				resultInputController.str = str1.toString();

			}if (Neuromuscular2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and neuromuscular re-education.");
				resultInputController.str = str1.toString();

			}if (GroupTherapy2radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and group therapy procedure.");
				resultInputController.str = str1.toString();
				
			}if (GaitTraining2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and gait training");
				resultInputController.str = str1.toString();

			}if (TherapeuticActivities2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and therapeutic activities.");
				resultInputController.str = str1.toString();

			}if (TherapeuticMassage2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and therapeutic massage.");
				resultInputController.str = str1.toString();
				
			}if (SoftTissue2radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and soft tissue mobilization.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			if (SelectMechanialTractionRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: mechanical traction.");
				resultInputController.str = str1.toString();

			}if (SelecteStimManualRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: ");
				resultInputController.str = str1.toString();
				
			}if (SelectPhonophoresisRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: Phonophoresis.");
				resultInputController.str = str1.toString();

			}if (SelectElectricalSimulationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: electrical stimulation.");
				resultInputController.str = str1.toString();

			}if (SelectIontophoresisradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given:Iontophoresis.");
				resultInputController.str = str1.toString();
				
			}if (SelectParaffinbathRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: paraffin bath.");
				resultInputController.str = str1.toString();

			}if (SelectContrastBathRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: contrast bath.");
				resultInputController.str = str1.toString();

			}if (SelectWhirlpoolRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: whirlpool.");
				resultInputController.str = str1.toString();
				
			}if (SelectUltrasoundradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("The following treatments were given: ultasonic.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			if (SupervisedContrastBathRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("And contrast bath.");
				resultInputController.str = str1.toString();

			}if (SupervisedElectricalSimulationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and electrical simulation");
				resultInputController.str = str1.toString();
				
			}if (SupervisedeStimManualRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and stim manual");
				resultInputController.str = str1.toString();

			}if (SupervisedIontophoresisradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and iontophoresis");
				resultInputController.str = str1.toString();

			}if (SupervisedMechanialTractionRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and mechanical traction");
				resultInputController.str = str1.toString();
				
			}if (SupervisedParaffinbathRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and paraffin bath");
				resultInputController.str = str1.toString();

			}if (SupervisedPhonophoresisRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and phonophoresis");
				resultInputController.str = str1.toString();

			}if (SupervisedUltrasoundradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and ultrasound");
				resultInputController.str = str1.toString();
				
			}if (SupervisedWhirlpoolRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("and whirlpool");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			
			if (ElectrodesCheck.isSelected() || EducationalCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("Additional: ");
				resultInputController.str = str.toString();
				
				if (ElectrodesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("electrodes,");
					resultInputController.str = str1.toString();
					
				}if (EducationalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("electric ");
					resultInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("material.");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (hotAndColdCheck.isSelected() || hotCheck.isSelected()
					|| coldCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append(" Patient received ");
				resultInputController.str = str.toString();
				
				if (hotAndColdCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hot and cold pack,");
					resultInputController.str = str1.toString();
					
				}if (hotCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hot pack, ");
					resultInputController.str = str1.toString();

				}if (coldCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("cold pack,");
					resultInputController.str = str1.toString();

				}
				
			

			}
			
			
			
			
			if (notesTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(notesTextarea.getText() +".");
				resultInputController.str = str1.toString();

			}

			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(okBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
