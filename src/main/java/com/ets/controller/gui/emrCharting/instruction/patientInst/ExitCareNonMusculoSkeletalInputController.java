package com.ets.controller.gui.emrCharting.instruction.patientInst;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExitCareNonMusculoSkeletalInputController implements Initializable {
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox exitcareAsthmaAdult;

	    @FXML
	    private CheckBox exitcareAche;

	    @FXML
	    private CheckBox exitcareEye;

	    @FXML
	    private CheckBox exitcareGout;

	    @FXML
	    private CheckBox exitcareURI;

	    @FXML
	    private CheckBox exitcareUTI;

	    @FXML
	    private CheckBox exitcareAsthmaPediatric;

	    @FXML
	    private CheckBox exitcareEarInfection;

	    @FXML
	    private CheckBox exitcareEarForeignBody;

	    @FXML
	    private CheckBox exitcareRashInstructions;

	    @FXML
	    private CheckBox exitcareURIPediatric;
	private InstructionPatientInstInputCotroller instructionPatientInstInputCotroller;


	public void setInstructionPatientInstInputCotroller(
			InstructionPatientInstInputCotroller instructionPatientInstInputCotroller) {
		this.instructionPatientInstInputCotroller = instructionPatientInstInputCotroller;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(instructionPatientInstInputCotroller.str);
			acupunctureReferalStr.append("\n\nExitcare patient instructions given: ");
			instructionPatientInstInputCotroller.str = acupunctureReferalStr.toString();

			
				if (exitcareAsthmaAdult.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Asthma - Adult, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareAche.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Ear - Ache, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareAsthmaPediatric.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Asthma - Pediatric, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareEarForeignBody.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("  Eye - Foreign Body,");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareEarInfection.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Ear - Infection, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}if (exitcareEye.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Eye - Conjunctivitis, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareGout.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" Gout, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareRashInstructions.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("Rash Instructions, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareURI.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append("URI - Adult, ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareURIPediatric.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" URI - Pediatric , ");
					instructionPatientInstInputCotroller.str = str11.toString();

				}
				if (exitcareUTI.isSelected()) {

					StringBuilder str11 = new StringBuilder(instructionPatientInstInputCotroller.str);
					str11.append(" UTI - Female. ");
					instructionPatientInstInputCotroller.str = str11.toString();

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
