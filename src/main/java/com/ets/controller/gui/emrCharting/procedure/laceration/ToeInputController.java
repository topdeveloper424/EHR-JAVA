package com.ets.controller.gui.emrCharting.procedure.laceration;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.procedure.MedicalProcedureInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ToeInputController implements Initializable {
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox dermistCkeckBox;

	    @FXML
	    private CheckBox subculaneousCkeckBox;

	    @FXML
	    private CheckBox contaminatedCkeckBox;

	    @FXML
	    private CheckBox nailCkeckBox;

	    @FXML
	    private CheckBox epidermisCkeckBox;

	    @FXML
	    private CheckBox iaggedCkeckBox;

	    @FXML
	    private TextField volumeAnestheticText;

	    @FXML
	    private CheckBox suturesCheckBox;

	    @FXML
	    private CheckBox gelFoamCheckBox;

	    @FXML
	    private CheckBox steriSteripseCheckBox;

	    @FXML
	    private Label AnesthasiaModalitytText;

	    @FXML
	    private RadioButton simple0Radio;

	    @FXML
	    private ToggleGroup complexity;

	    @FXML
	    private RadioButton simple26Radio;

	    @FXML
	    private RadioButton intermidate0Radio;

	    @FXML
	    private RadioButton intermidate26Radio;

	    @FXML
	    private RadioButton complex1Radio;

	    @FXML
	    private RadioButton complex26Radio;

	    @FXML
	    private TextField additionalLacerationText;

	    @FXML
	    private CheckBox alcoholCheckBox;

	    @FXML
	    private CheckBox betadineCheckBox;

	    @FXML
	    private CheckBox hibicleanseCheckBox;

	    @FXML
	    private CheckBox irrigationTrayCheckBox;

	    @FXML
	    private CheckBox hydrogenPeroxideCheckBox;

	    @FXML
	    private RadioButton partialThicknessRadio;

	    @FXML
	    private ToggleGroup choice;

	    @FXML
	    private RadioButton fullThicknessRadio;

	    @FXML
	    private RadioButton subcutaniousSkinRadio;

	    @FXML
	    private RadioButton tissueRadio;

	    @FXML
	    private RadioButton foreignRadio;

	    @FXML
	    private TextField lengthLacerationRadio;

	    @FXML
	    private TextField stechesNumberText;

	    @FXML
	    private CheckBox ethilion4CheckBox;

	    @FXML
	    private CheckBox ethilion5CheckBox;

	    @FXML
	    private CheckBox ethilion6CheckBox;

	    @FXML
	    private CheckBox prolene4CeckBox;

	    @FXML
	    private CheckBox prolene5CeckBox;

	    @FXML
	    private CheckBox vicyl4CeckBox;

	    @FXML
	    private CheckBox vicyl5CeckBox;

	    @FXML
	    private CheckBox vicyl6CeckBox;

	    @FXML
	    private CheckBox postAlcoholCheckBox;

	    @FXML
	    private CheckBox postBetadineCheckBox;

	    @FXML
	    private CheckBox postPeroxideCheckBox;

	    @FXML
	    private CheckBox postSalineCheckBox;

	    @FXML
	    private CheckBox potBulkyCheckBox;

	    @FXML
	    private CheckBox postgauzeCheckBox;

	    @FXML
	    private CheckBox wellCheckBox;

	    @FXML
	    private CheckBox WiyhoutCompletionCheckBox;

	    @FXML
	    private CheckBox minaralCheckBox;

	    @FXML
	    private CheckBox withCompletionCheckBox;

	    @FXML
	    private CheckBox nailbedCheck;

	    @FXML
	    private CheckBox muscleCheck;

	    @FXML
	    private RadioButton Idocaine1Radio;

	    @FXML
	    private ToggleGroup anes;

	    @FXML
	    private RadioButton Idocaine2Radio;

	    @FXML
	    private RadioButton marcaine5Radio;

	    @FXML
	    private RadioButton superfacialRadio;

	    @FXML
	    private ToggleGroup modi;

	    @FXML
	    private RadioButton deepRadio;

	    @FXML
	    private RadioButton localRadio;

	    @FXML
	    private CheckBox boneCheck;

	    @FXML
	    private RadioButton digitalRadio;

	    @FXML
	    private CheckBox xeroformCheck;
	    private MedicalProcedureInputController medicalProcedureInputController;

  		public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
  			this.medicalProcedureInputController = medicalProcedureInputController;
  		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n\n ");
			medicalProcedureInputController.str = procedureStr.toString();

			

			if (simple0Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a simple (0 - 2.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (simple26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a simple (2.6 - 7.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();

			}if (intermidate0Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a intermediate  (0 - 2.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (complex1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a complex (1.1 - 2.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();

			}if (complex26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a complex (2.6 - 7.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (intermidate26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a intermediate  (2.6 - 7.5) laceration repair procedure on the toe. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			

			if (epidermisCkeckBox.isSelected() || dermistCkeckBox.isSelected()
					|| nailbedCheck.isSelected() || muscleCheck.isSelected()
					|| nailCkeckBox.isSelected() || iaggedCkeckBox.isSelected()
					
					|| boneCheck.isSelected()
					|| contaminatedCkeckBox.isSelected() || subculaneousCkeckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Applicable diagnosis: To be determined. The laceration involved the following elements: ");
				medicalProcedureInputController.str = str.toString();
				
				if (epidermisCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("epidermis, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (dermistCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("dermis, ");
					medicalProcedureInputController.str = str1.toString();

				}if (boneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bone, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (muscleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("muscle, ");
					medicalProcedureInputController.str = str1.toString();

				}if (subculaneousCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("subculaneous tissue, ");
					medicalProcedureInputController.str = str1.toString();

				}if (contaminatedCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("contaminated, ");
					medicalProcedureInputController.str = str1.toString();

				}if (iaggedCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("jagged, ");
					medicalProcedureInputController.str = str1.toString();

				}if (nailCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("nail, ");
					medicalProcedureInputController.str = str1.toString();

				}if (nailbedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("nailbed, ");
					medicalProcedureInputController.str = str1.toString();

				} 
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (alcoholCheckBox.isSelected()
					|| betadineCheckBox.isSelected() || hibicleanseCheckBox.isSelected()
					|| irrigationTrayCheckBox.isSelected() || hydrogenPeroxideCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Prepared for the procedure by cleaning with ");
				medicalProcedureInputController.str = str.toString();
				
				if (alcoholCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
						
				}if (betadineCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (hibicleanseCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("hibicleanse, ");
					medicalProcedureInputController.str = str1.toString();

				}if (irrigationTrayCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("irrigation tray, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (hydrogenPeroxideCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("hydrogen peroxide, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				

			}
			
			
			
			
			if (Idocaine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 1% lidocaine  was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (Idocaine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 2% lidocaine  was administered. ");
				medicalProcedureInputController.str = str1.toString();

			}if (marcaine5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("of 0.5% Marcaine  was administered. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (volumeAnestheticText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("An anesthetic injection of " +volumeAnestheticText.getText() +" cc. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (superfacialRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as superficial infiltration. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (deepRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as deep infiltration. ");
				medicalProcedureInputController.str = str1.toString();

			}if (localRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as local block. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (partialThicknessRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound debridement of partial thickness skin was carried out");
				medicalProcedureInputController.str = str1.toString();
				
			}if (tissueRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound debridement of  tissue and musclewas carried out");
				medicalProcedureInputController.str = str1.toString();

			}if (fullThicknessRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound debridement of full thickness skin was carried out");
				medicalProcedureInputController.str = str1.toString();
				  
			}if (foreignRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound debridement of foreign material was carried out");
				medicalProcedureInputController.str = str1.toString();
				
			}if (subcutaniousSkinRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound debridement of  subcutanious skin was carried out");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (lengthLacerationRadio.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Wound was " +lengthLacerationRadio.getText() +" cm. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			if (suturesCheckBox.isSelected()
					|| gelFoamCheckBox.isSelected() || steriSteripseCheckBox.isSelected()) {

				
				
				if (suturesCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("sutures, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (gelFoamCheckBox.isSelected()) {
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("gel foam, ");
					medicalProcedureInputController.str = str1.toString();

				}if (steriSteripseCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("steri-strips, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (stechesNumberText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound was closed with " +stechesNumberText.getText());
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (ethilion4CheckBox.isSelected() || ethilion5CheckBox.isSelected()
					|| ethilion6CheckBox.isSelected() || prolene4CeckBox.isSelected()
					|| prolene5CeckBox.isSelected() || vicyl4CeckBox.isSelected()
					|| vicyl5CeckBox.isSelected() || vicyl6CeckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append(" and closed with ");
				medicalProcedureInputController.str = str.toString();
				
				if (ethilion4CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4-0 ethilon (nylon), ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (ethilion5CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5-0 ethilon (nylon), ");
					medicalProcedureInputController.str = str1.toString();

				}if (ethilion6CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("6-0 ethilon (nylon), ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (prolene4CeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4-0 prolene, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (prolene5CeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" 5-0 prolene, ");
					medicalProcedureInputController.str = str1.toString();

				}if (vicyl4CeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4.0 vicryl, ");
					medicalProcedureInputController.str = str1.toString();

				}if (vicyl5CeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5.0 Vicryl, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (vicyl6CeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("6.0 Vicryl ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("suture material. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			
			
			if (postAlcoholCheckBox.isSelected() || potBulkyCheckBox.isSelected()
					|| postBetadineCheckBox.isSelected() || postgauzeCheckBox.isSelected()
					|| postPeroxideCheckBox.isSelected() || postSalineCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Instructions were provided to the patient as documented elsewhere. Patient's wound was cleansed post-operatively with ");
				medicalProcedureInputController.str = str.toString();
				
				if (postAlcoholCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
									
				}if (potBulkyCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bulky dressing applied, ");
					medicalProcedureInputController.str = str1.toString();

				}if (postBetadineCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (postgauzeCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("gauze, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (postPeroxideCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("peroxide, ");
					medicalProcedureInputController.str = str1.toString();

				}if (postSalineCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("saline, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			if (wellCheckBox.isSelected() || WiyhoutCompletionCheckBox.isSelected()
					|| minaralCheckBox.isSelected() || withCompletionCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient tolerated the procedure ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well, ");
					medicalProcedureInputController.str = str1.toString();
						
				}if (WiyhoutCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications, ");
					medicalProcedureInputController.str = str1.toString();

				}if (minaralCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("minimal blood loss, ");
					medicalProcedureInputController.str = str1.toString();

				}if (withCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complications (see notes below), ");
					medicalProcedureInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
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


