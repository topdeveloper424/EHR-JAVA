package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AspirationProcedureInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton alcoholRadio;
	    
	    @FXML
	    private RadioButton betadineRadio;

	    @FXML
	    private ToggleGroup complexity;

	    @FXML
	    private RadioButton peroxideRadio;

	    @FXML
	    private CheckBox marcaineEpinephrine2CheckBox;

	    @FXML
	    private CheckBox lidocaine1CheckBox;

	    @FXML
	    private CheckBox lidocaine2CheckBox;

	    @FXML
	    private CheckBox epinephrine1CheckBox;

	    @FXML
	    private CheckBox epinephrine2CheckBox;

	    @FXML
	    private CheckBox externalCheck;

	    @FXML
	    private RadioButton leftRadio;

	    @FXML
	    private ToggleGroup modi;

	    @FXML
	    private RadioButton rightRadio;

	    @FXML
	    private CheckBox ulnarCheck;

	    @FXML
	    private CheckBox anteriorCheck;

	    @FXML
	    private CheckBox posteriorCheck;

	    @FXML
	    private RadioButton normalRadio;

	    @FXML
	    private RadioButton soapRadio;

	    @FXML
	    private CheckBox epiduralCheckBox;

	    @FXML
	    private CheckBox cysticCheckBox;

	    @FXML
	    private CheckBox marcaine2CheckBox;

	    @FXML
	    private CheckBox marcaine1CheckBox;

	    @FXML
	    private CheckBox marcaineEpinephrine1CheckBox;

	    @FXML
	    private CheckBox extensorCheck;

	    @FXML
	    private CheckBox flexorCheck;

	    @FXML
	    private CheckBox radialCheck;

	    @FXML
	    private CheckBox lateralCheck;

	    @FXML
	    private CheckBox medialCheck;

	    @FXML
	    private CheckBox interiorCheck;

	    @FXML
	    private CheckBox muscleTiggerCheck;

	    @FXML
	    private CheckBox kneeCheck;

	    @FXML
	    private CheckBox digit1Check;

	    @FXML
	    private CheckBox digit2Check;

	    @FXML
	    private CheckBox shoulderCheck;

	    @FXML
	    private CheckBox ankleCheck;

	    @FXML
	    private CheckBox elbowCheck;

	    @FXML
	    private CheckBox digit3Check;

	    @FXML
	    private CheckBox digit4Check;

	    @FXML
	    private CheckBox digit5Check;

	    @FXML
	    private RadioButton kenalogRadio;
	    
	    @FXML
	    private TextField volumeText;

	    @FXML
	    private ToggleGroup pati;

	    @FXML
	    private RadioButton solumedrolRadio;

	    @FXML
	    private RadioButton wellRadio;

	    @FXML
	    private ToggleGroup wound;

	    @FXML
	    private RadioButton withDifficultyRadio;
	    
	    private MedicalProcedureInputController medicalProcedureInputController;

	    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
			this.medicalProcedureInputController = medicalProcedureInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(medicalProcedureInputController.str);
			procedureStr.append("\n\nWe conducted an aspiration or injection procedure. Applicable diagnosis: To be determined.  ");
			medicalProcedureInputController.str = procedureStr.toString();

			if (alcoholRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Prepared for the procedure by cleaning with alcohol");
				medicalProcedureInputController.str = str1.toString();
				
			}if (peroxideRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Prepared for the procedure by cleaning with peroxide");
				medicalProcedureInputController.str = str1.toString();

			}if (normalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Prepared for the procedure by cleaning with normal saline");
				medicalProcedureInputController.str = str1.toString();
				
			}if (soapRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Prepared for the procedure by cleaning with soap and water");
				medicalProcedureInputController.str = str1.toString();

			}if (betadineRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Prepared for the procedure by cleaning with betadine");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (extensorCheck.isSelected() || flexorCheck.isSelected()
					|| radialCheck.isSelected() || ulnarCheck.isSelected()
					|| anteriorCheck.isSelected() || posteriorCheck.isSelected()
					|| lateralCheck.isSelected() || medialCheck.isSelected()
					|| interiorCheck.isSelected() || externalCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Insertion of the aspiration needle was on the ");
				medicalProcedureInputController.str = str.toString();
				
				if (extensorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" extensor, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (flexorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("flexor, ");
					medicalProcedureInputController.str = str1.toString();

				}if (radialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" radial, ");
					medicalProcedureInputController.str = str1.toString();

				}if (ulnarCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ulnar, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (anteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("anterior, ");
					medicalProcedureInputController.str = str1.toString();

				}if (posteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("posterior, ");
					medicalProcedureInputController.str = str1.toString();

				}if (lateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("lateral, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (medialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("medial, ");
					medicalProcedureInputController.str = str1.toString();

				}if (interiorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("internal, ");
					medicalProcedureInputController.str = str1.toString();

				}if (externalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("external surface, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of the left. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of the right. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (shoulderCheck.isSelected() || ankleCheck.isSelected()
					|| elbowCheck.isSelected() || kneeCheck.isSelected()
					|| digit1Check.isSelected() || digit2Check.isSelected()
					|| digit3Check.isSelected() || digit4Check.isSelected()
					|| digit5Check.isSelected() || muscleTiggerCheck.isSelected()
					|| epiduralCheckBox.isSelected() || cysticCheckBox.isSelected()) {

				
				
				if (shoulderCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("shoulder, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (ankleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ankle, ");
					medicalProcedureInputController.str = str1.toString();

				}if (elbowCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("elbow, ");
					medicalProcedureInputController.str = str1.toString();

				}if (kneeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("knee, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (digit1Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1st digit, ");
					medicalProcedureInputController.str = str1.toString();

				}if (digit2Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2nd digit, ");
					medicalProcedureInputController.str = str1.toString();

				}if (digit3Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("3rd digit, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (digit4Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4th digit, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (digit5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5th digit, ");
					medicalProcedureInputController.str = str1.toString();

				}if (muscleTiggerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("muscle trigger point, ");
					medicalProcedureInputController.str = str1.toString();

				}if (epiduralCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("epidural, ");
					medicalProcedureInputController.str = str1.toString();

				}if (cysticCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("cystic structure, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			

			if (volumeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Injected " +volumeText.getText() +" ml.");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			if (lidocaine1CheckBox.isSelected() || lidocaine2CheckBox.isSelected()
					|| epinephrine1CheckBox.isSelected() || epinephrine2CheckBox.isSelected()
					|| marcaine1CheckBox.isSelected() || marcaineEpinephrine1CheckBox.isSelected()
					|| marcaineEpinephrine2CheckBox.isSelected() || marcaine2CheckBox.isSelected()) {

				
				
				if (lidocaine1CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("of 1% Lidocaine, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (lidocaine2CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2 % Lidocaine, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (epinephrine1CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1 % Lidocaine with epinephrine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (epinephrine2CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2 % Lidocaine with epinephrine, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (marcaine1CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1% Marcaine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (marcaineEpinephrine1CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("1% Marcaine with epinephrine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (marcaineEpinephrine2CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2 % Marcaine with epinephrine ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (marcaine2CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("2% Marcaine ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("as anesthetic. ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (kenalogRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Kenalog was then injected into the joint. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (solumedrolRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Solumedrol was then injected into the joint. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			 	
			
			if (wellRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient tolerated the procedure with difficulty. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (withDifficultyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient tolerated the procedure well. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
			str1.append("Instructions were provided to the patient in how to care for the "
					+ "area to prevent repeat occurrence. ");
			medicalProcedureInputController.str = str1.toString();
			
			

			

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
