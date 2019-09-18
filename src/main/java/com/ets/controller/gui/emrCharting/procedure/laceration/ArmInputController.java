package com.ets.controller.gui.emrCharting.procedure.laceration;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.procedure.MedicalProcedureInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ArmInputController Class
 *Description: arm.fxml Controller class
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
public class ArmInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox dermistCkeckBox;

    @FXML
    private CheckBox muscleCkeckBox;

    @FXML
    private CheckBox fasiaCkeckBox;

    @FXML
    private CheckBox subculaneousCkeckBox;

    @FXML
    private CheckBox contaminatedCkeckBox;

    @FXML
    private CheckBox jointCapsuleCkeckBox;

    @FXML
    private CheckBox epidermisCkeckBox;

    @FXML
    private CheckBox boneCkeckBox;

    @FXML
    private CheckBox iaggedCkeckBox;

    @FXML
    private CheckBox tendonCkeckBox;

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
    private RadioButton complex11Radio;

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
    private CheckBox staplesCheckBox;

    @FXML
    private CheckBox superfacialCheck;

    @FXML
    private CheckBox deepCheck;

    @FXML
    private CheckBox localCheck;

    @FXML
    private CheckBox partialThicknessCheck;

    @FXML
    private CheckBox tissueCheck;

    @FXML
    private CheckBox fullThicknessCheck;

    @FXML
    private CheckBox foreignCheck;

    @FXML
    private CheckBox subcutaniousSkinCheck;

    @FXML
    private CheckBox Idocaine1;

    @FXML
    private CheckBox Idocaine2;

    @FXML
    private CheckBox epinephrine2Check;

    @FXML
    private CheckBox epinephrine1Check;

    @FXML
    private CheckBox marcaine5Check;

    @FXML
    private CheckBox foreignDeepCheck;

   
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
				str1.append("I conducted a simple (0 - 2.5) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (simple26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a simple (2.6 - 3.75) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();

			}if (intermidate0Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a intermediate  (0 - 2.5) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (complex11Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a complex (1.1 - 2.5) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();

			}if (complex26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a complex (2.6 - 7.5) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (intermidate26Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("I conducted a intermediate  (2.6 - 7.5) laceration repair procedure on the arm. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			

			if (epidermisCkeckBox.isSelected() || dermistCkeckBox.isSelected()
					|| fasiaCkeckBox.isSelected() || boneCkeckBox.isSelected()
					|| muscleCkeckBox.isSelected() || tendonCkeckBox.isSelected()
					|| jointCapsuleCkeckBox.isSelected() || subculaneousCkeckBox.isSelected()
					|| contaminatedCkeckBox.isSelected() || iaggedCkeckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("To be determined. The laceration involved the following elements: ");
				medicalProcedureInputController.str = str.toString();
				
				if (epidermisCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("epidermis, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (dermistCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("dermis, ");
					medicalProcedureInputController.str = str1.toString();

				}if (fasiaCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("fascia, ");
					medicalProcedureInputController.str = str1.toString();

				}if (boneCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bone, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (muscleCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("muscle, ");
					medicalProcedureInputController.str = str1.toString();

				}if (tendonCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("tendon, ");
					medicalProcedureInputController.str = str1.toString();

				}if (jointCapsuleCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("joint capsule, ");
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

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (additionalLacerationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("\n" +additionalLacerationText.getText() +". ");
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
			
			
			
			
			if (Idocaine1.isSelected()
					|| Idocaine2.isSelected() || marcaine5Check.isSelected()
					|| epinephrine2Check.isSelected() || epinephrine1Check.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append(" of ");
				medicalProcedureInputController.str = str.toString();
				
				if (Idocaine1.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1% lidocaine, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (Idocaine2.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2% lidocaine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (marcaine5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("0.5% Marcaine ");
					medicalProcedureInputController.str = str1.toString();

				}if (epinephrine2Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2% lidocaine with epinephrine ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (epinephrine1Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1% lidocaine with epinephrine, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" was administered. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (volumeAnestheticText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("An anesthetic injection of " +volumeAnestheticText.getText() +".cc ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (superfacialCheck.isSelected()
						|| deepCheck.isSelected() || localCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Anesthesia was administered as ");
				medicalProcedureInputController.str = str.toString();
				
				if (superfacialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("superficial infiltration ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (deepCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("deep infiltration ");
					medicalProcedureInputController.str = str1.toString();

				}if (localCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("local block ");
					medicalProcedureInputController.str = str1.toString();

				}
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			if (partialThicknessCheck.isSelected() || foreignDeepCheck.isSelected()
					|| fullThicknessCheck.isSelected() || subcutaniousSkinCheck.isSelected()
					|| tissueCheck.isSelected() || foreignCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Wound ");
				medicalProcedureInputController.str = str.toString();
				
				if (partialThicknessCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of partial skin thickness ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (fullThicknessCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of full thickness skin ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (subcutaniousSkinCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of subcutaneous skin ");
					medicalProcedureInputController.str = str1.toString();

				}if (tissueCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of tissue and muscle ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (foreignCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of foreign material ");
					medicalProcedureInputController.str = str1.toString();

				}if (foreignDeepCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("debrid. of foreign material (deep) ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("was carried out. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (lengthLacerationRadio.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound was " +lengthLacerationRadio.getText() +" cm. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			if (suturesCheckBox.isSelected()
					|| gelFoamCheckBox.isSelected() || steriSteripseCheckBox.isSelected()
					|| staplesCheckBox.isSelected()) {

				
				
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
					str1.append("steri-strips ");
					medicalProcedureInputController.str = str1.toString();

				}if (staplesCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("staples, ");
					medicalProcedureInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (stechesNumberText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Wound was closed with " +stechesNumberText.getText() +". ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (ethilion4CheckBox.isSelected() || ethilion5CheckBox.isSelected()
					|| ethilion6CheckBox.isSelected() || prolene4CeckBox.isSelected()
					|| prolene5CeckBox.isSelected() || vicyl4CeckBox.isSelected()
					|| vicyl5CeckBox.isSelected() || vicyl6CeckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("and closed with ");
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
					str1.append("5-0 prolene, ");
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
					str1.append("6.0 Vicryl, ");
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
				str.append("Instructions were provided to the patient as documented elsewhere. "
						+ "Patient's wound was cleansed post-operatively with ");
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
