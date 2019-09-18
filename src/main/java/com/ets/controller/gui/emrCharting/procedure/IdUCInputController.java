package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class IdUCInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField volumeAnestheticText;

    @FXML
    private Label AnesthasiaModalitytText;

    @FXML
    private RadioButton simpleOrSingleRadio;

    @FXML
    private ToggleGroup complexity;

    @FXML
    private RadioButton multipleAbsRadio;

    @FXML
    private CheckBox withoutCheckBox;

    @FXML
    private CheckBox wellCheckBox;

    @FXML
    private CheckBox minimulBloodCheckBox;

    @FXML
    private CheckBox withCeckBox;

    @FXML
    private CheckBox patientAlcoholCheckBox;

    @FXML
    private CheckBox patientBetadineCheckBox;

    @FXML
    private CheckBox patientPeroxideCheckBox;

    @FXML
    private CheckBox patientSalineCheckBox;

    @FXML
    private CheckBox irrigationCheck;

    @FXML
    private RadioButton Idocaine1Radio;

    @FXML
    private ToggleGroup anes;

    @FXML
    private RadioButton Idocaine2Radio;

    @FXML
    private RadioButton marcaine5Radio;

    @FXML
    private RadioButton eapinephrine1Radio;

    @FXML
    private RadioButton eapinephrine2Radio;

    @FXML
    private RadioButton superficialRadio;

    @FXML
    private ToggleGroup modi;

    @FXML
    private RadioButton deepRadio;

    @FXML
    private CheckBox alcoholCheck;

    @FXML
    private CheckBox betadineCheck;

    @FXML
    private CheckBox hibicleanseCheck;

    @FXML
    private RadioButton packingRadio;

    @FXML
    private ToggleGroup suture;

    @FXML
    private RadioButton gauzeRadio;

    @FXML
    private RadioButton fourRadio;

    @FXML
    private RadioButton simpleCystRadio;

    @FXML
    private RadioButton complecatedCystRadio;

    @FXML
    private RadioButton simpleForeignBodyRadio;

    @FXML
    private RadioButton complecatedForeignVodyRadio;

    @FXML
    private RadioButton hematomaRadio;

    @FXML
    private RadioButton postOperativeRadio;

    @FXML
    private CheckBox upperExtermityCheckBox;

    @FXML
    private CheckBox lowerExtermityCheckBox;

    @FXML
    private CheckBox neckCheckBox;

    @FXML
    private CheckBox backCheckBox;

    @FXML
    private CheckBox postGauzeCheckBox;

    @FXML
    private CheckBox tapeCheckBox;

    @FXML
    private CheckBox bulkyDressingCheckBox;

    @FXML
    private CheckBox postStripsCheckBox;

    @FXML
    private CheckBox patientAndBulkyCheckBox3;

    @FXML
    private CheckBox patientGauzeCheckBox;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n\nThe patient was positioned, prepped and draped in sterile fashion. ");

			medicalProcedureInputController.str = procedureStr.toString();

			
			if (simpleOrSingleRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Simple or single, abscess was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (complecatedCystRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Complicated or multiple, abscess was identified.");
				medicalProcedureInputController.str = str1.toString();

			}if (hematomaRadio.isSelected()) {

 
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The hematoma, seroma or fluid collection was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (multipleAbsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Complicated or multiple, abscess was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (simpleForeignBodyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Simple, foreign body sub tissue was identified. ");
				medicalProcedureInputController.str = str1.toString();

			}if (postOperativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The post-operative wound infection, complex was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (simpleCystRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Simple, cyst was identified.");
				medicalProcedureInputController.str = str1.toString();

			}if (complecatedForeignVodyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The Complicated, foreign body was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (alcoholCheck.isSelected() || irrigationCheck.isSelected()
					|| betadineCheck.isSelected() || hibicleanseCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Prepared for the procedure by cleaning with ");
				medicalProcedureInputController.str = str.toString();
				
				if (alcoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (irrigationCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("irrigation tray, ");
					medicalProcedureInputController.str = str1.toString();

				}if (betadineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (hibicleanseCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("hibicleanse, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (volumeAnestheticText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("An anesthetic injection of " +volumeAnestheticText.getText() +" ml/cc ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			if (Idocaine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 1% lidocaine was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (marcaine5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 0.5% Marcaine was administered.");
				medicalProcedureInputController.str = str1.toString();

			}if (Idocaine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 2% lidocaine was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (eapinephrine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 2% lidocaine with epinephrine was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (eapinephrine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 1% lidocaine with epinephrine was administered. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			
			if (superficialRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as superficial infiltration.");
				medicalProcedureInputController.str = str1.toString();
				
			}if (deepRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as deep infiltration.");
				medicalProcedureInputController.str = str1.toString();

			}
			
			StringBuilder str16 = new StringBuilder(medicalProcedureInputController.str);
			str16.append(" Applicable diagnosis: To be determined.");
			medicalProcedureInputController.str = str16.toString();
			
			 
			
			
			if (upperExtermityCheckBox.isSelected() || backCheckBox.isSelected()
					|| lowerExtermityCheckBox.isSelected() || neckCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("The incision over abcess was made cutting through the skin into the abcess cavity, ");
				medicalProcedureInputController.str = str.toString();
				
				if (upperExtermityCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("to upper extremity, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (backCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("back, ");
					medicalProcedureInputController.str = str1.toString();

				}if (lowerExtermityCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("to lower extremity, ");
					medicalProcedureInputController.str = str1.toString();

				}if (neckCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("neck, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". The pus was allowed to drain, using gauzes to soak up drainage and blood. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (packingRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The cavity was packed using, packing strips. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (gauzeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The cavity was packed using, gauze. ");
				medicalProcedureInputController.str = str1.toString();

			}if (fourRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The cavity was packed using, 4 x 4. I");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (postGauzeCheckBox.isSelected() || postStripsCheckBox.isSelected()
					|| tapeCheckBox.isSelected() || bulkyDressingCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("A ");
				medicalProcedureInputController.str = str.toString();
				
				if (postGauzeCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("sterile gauze, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (postStripsCheckBox.isSelected()) {
					   
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Steri strips ");
					medicalProcedureInputController.str = str1.toString();

				}if (tapeCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("tape, ");
					medicalProcedureInputController.str = str1.toString();

				}if (bulkyDressingCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bulky dressing ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("was used to dress the wound. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			StringBuilder str55 = new StringBuilder(medicalProcedureInputController.str);
			str55.append("Instructions were provided to the patient as documented elsewhere. ");
			medicalProcedureInputController.str = str55.toString();
			
			
			
			if (patientAlcoholCheckBox.isSelected() || patientSalineCheckBox.isSelected()
					|| patientBetadineCheckBox.isSelected() || patientAndBulkyCheckBox3.isSelected()
					|| patientPeroxideCheckBox.isSelected() || patientGauzeCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient's wound was cleansed post-operatively with ");
				medicalProcedureInputController.str = str.toString();
				
				if (patientAlcoholCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (patientSalineCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("saline, ");
					medicalProcedureInputController.str = str1.toString();

				}if (patientBetadineCheckBox.isSelected()) {
					 
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (patientAndBulkyCheckBox3.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bulky dressing applied, ");
					medicalProcedureInputController.str = str1.toString();

				}if (patientPeroxideCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("peroxide, ");
					medicalProcedureInputController.str = str1.toString();

				}if (patientGauzeCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("gauze, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			if (wellCheckBox.isSelected() || withCeckBox.isSelected()
					|| withoutCheckBox.isSelected() || minimulBloodCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient tolerated the procedure ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (withCeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complications ");
					medicalProcedureInputController.str = str1.toString();

				}if (withoutCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications, ");
					medicalProcedureInputController.str = str1.toString();

				}if (minimulBloodCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("minimal blood loss ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" (see notes below).");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			

			++medicalProcedureInputController.formCount;
			medicalProcedureInputController.setMedUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++medicalProcedureInputController.formCount;
				medicalProcedureInputController.setMedUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}