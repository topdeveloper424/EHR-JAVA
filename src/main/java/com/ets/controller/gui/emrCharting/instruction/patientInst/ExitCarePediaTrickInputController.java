package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExitCarePediaTrickInputController  implements Initializable {

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox exitcareAsthmaPediatric;

    @FXML
    private CheckBox exitcareDiaper;

    @FXML
    private CheckBox exitcareImmunizationSchedule;

    @FXML
    private CheckBox exitcareEye;

    @FXML
    private CheckBox exitcareURI;
    

    @FXML
    private CheckBox   exitcareUTI;

    @FXML
    private CheckBox exitcareConstiption;

    @FXML
    private CheckBox exitcarefeverpediatric;

    @FXML
    private CheckBox exitcareOtitisMedia;
	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;


	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionPatientInstInputCotroller.str);
			acupunctureReferalStr.append("\n\n ");
			instructionPatientInstInputCotroller.str = acupunctureReferalStr.toString();

			
				
				if (exitcareAsthmaPediatric.isSelected()||exitcareConstiption.isSelected()
						||exitcareDiaper.isSelected()||exitcareEye.isSelected()||
						exitcarefeverpediatric.isSelected()||exitcareImmunizationSchedule.isSelected()
						||exitcareOtitisMedia.isSelected()||exitcareURI.isSelected()||
						exitcareUTI.isSelected()) {

					StringBuilder str14 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str14.append("Exitcare patient instructions given: ");
					instructionPatientInstInputCotroller.str = str14.toString();

				
				if (exitcareAsthmaPediatric.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("asthma - pediatric, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareConstiption.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" constipation - pediatric, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareDiaper.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" diaper rash, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareEye.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("pink eye, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcarefeverpediatric.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" fever - pediatric, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareImmunizationSchedule.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("immunization schedule - pediatric, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareOtitisMedia.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" otitis media - child,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareURI.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("URI - pediatric,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareUTI.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" UTI - pediatric.");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				}

				++instructionPatientInstInputCotroller.formCount;
				instructionPatientInstInputCotroller.setPatInstUI();
				new FXFormCommonUtilities().closeForm(doneBtn);

			});

			skipBtn.setOnAction((event) -> {
				try {

					++instructionPatientInstInputCotroller.formCount;
					instructionPatientInstInputCotroller.setPatInstUI();
					new FXFormCommonUtilities().closeForm(skipBtn);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

		}

	}
