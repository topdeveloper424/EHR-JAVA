package com.ets.controller.gui.emrCharting.procedure.removal;

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

public class ForeignBodyEyeInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField numberText;

	    @FXML
	    private Label AnesthasiaModalitytText;

	    @FXML
	    private CheckBox gauzeCheckBox;

	    @FXML
	    private CheckBox steriStripCheckBox;

	    @FXML
	    private CheckBox bandAidCeckBox;

	    @FXML
	    private CheckBox wellCheckBox;

	    @FXML
	    private CheckBox WiyhoutCompletionCheckBox;

	    @FXML
	    private CheckBox minaralCheckBox;

	    @FXML
	    private CheckBox withCompletionCheckBox;

	    @FXML
	    private CheckBox tetracaineCheck;

	    @FXML
	    private CheckBox proparacaineCheck;

	    @FXML
	    private CheckBox osCheck;

	    @FXML
	    private CheckBox odCheck;

	    @FXML
	    private CheckBox burrCheck;

	    @FXML
	    private CheckBox gauzeNeedleCheck;

	    @FXML
	    private CheckBox cottonCheck;

	    @FXML
	    private CheckBox irrigationCheck;

	    @FXML
	    private CheckBox identificationWood;

	    @FXML
	    private CheckBox identificationUnknownEtiology;

	    @FXML
	    private CheckBox identificationNonmagneticMaterial;
	    
	    
	    @FXML
	    private CheckBox identificationMagneticMetal;

	    @FXML
	    private CheckBox identificationMental;

	    @FXML
	    private CheckBox identificationRust;

	    
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

			

			if (tetracaineCheck.isSelected() || proparacaineCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient was appropriately anesthetized using 2 gtts of ophthalmic  ");
				medicalProcedureInputController.str = str.toString();
				
				if (tetracaineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("tetracaine 0.5%, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (proparacaineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("proparacaine");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("solution ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			if (osCheck.isSelected() || odCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("instilled into ");
				medicalProcedureInputController.str = str.toString();
				
				if (osCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("OS");
					medicalProcedureInputController.str = str1.toString();
					
				}if (odCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("OD");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			if (burrCheck.isSelected() || gauzeNeedleCheck.isSelected()
					|| cottonCheck.isSelected() || irrigationCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Foreign body removed using ");
				medicalProcedureInputController.str = str.toString();
				
				if (burrCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" burr,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (gauzeNeedleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" 25 gauge needle,");
					medicalProcedureInputController.str = str1.toString();

				}if (cottonCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("cotton tip applicator,");
					medicalProcedureInputController.str = str1.toString();

				}if (irrigationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("irrigation w/ophthalmic saline solution.");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			if (numberText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(numberText.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (identificationMagneticMetal.isSelected()
					|| identificationMental.isSelected() || identificationNonmagneticMaterial.isSelected()
					||identificationRust.isSelected()||identificationUnknownEtiology.isSelected()||identificationWood.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append(" Foreign body identified as  ");
				medicalProcedureInputController.str = str.toString();
				
				if (identificationMental.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("metal,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (identificationRust.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("rust ring,");
					medicalProcedureInputController.str = str1.toString();

				}if (identificationMagneticMetal.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("magnetic metal, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (identificationWood.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("wood, ");
					medicalProcedureInputController.str = str1.toString();

				}if (identificationUnknownEtiology.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" unknown etiology, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (identificationNonmagneticMaterial.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("  non-magnetic material, ");
					medicalProcedureInputController.str = str1.toString();

				} 
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			

			
			if (wellCheckBox.isSelected() || WiyhoutCompletionCheckBox.isSelected()
					|| withCompletionCheckBox.isSelected() || minaralCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("  Patient tolerated the procedure  ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well");
					medicalProcedureInputController.str = str1.toString();
					
				}if (WiyhoutCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complication,");
					medicalProcedureInputController.str = str1.toString();

				}if (withCompletionCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complication,");
					medicalProcedureInputController.str = str1.toString();

				}if (minaralCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with minimal blood loss");
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
