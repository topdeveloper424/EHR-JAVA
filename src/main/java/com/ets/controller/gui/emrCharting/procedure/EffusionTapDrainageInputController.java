package com.ets.controller.gui.emrCharting.procedure;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class EffusionTapDrainageInputController implements Initializable {
	
	 @FXML
	    private TextArea briefTextarea;

	    @FXML
	    private CheckBox salineCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox lidocaine1Check;

	    @FXML
	    private CheckBox lidocaine2Check;

	    @FXML
	    private CheckBox lidocaineJellyCheck;

	    @FXML
	    private CheckBox bandageCheckBox;

	    @FXML
	    private CheckBox syringeCheck;

	    @FXML
	    private RadioButton wellRadio;

	    @FXML
	    private RadioButton withComplecationRadio;

	    @FXML
	    private RadioButton minimulBloodRadio;

	    @FXML
	    private CheckBox betadineCheck;

	    @FXML
	    private CheckBox alcoholCheck;

	    @FXML
	    private CheckBox gauzeCheck;
	    
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

			
			if (briefTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("To be determined Effusion located in "+briefTextarea.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (lidocaine1Check.isSelected() 
					|| lidocaine2Check.isSelected() || lidocaineJellyCheck.isSelected()) {

				
				if (lidocaine1Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("lidocaine 1%, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (lidocaine2Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" lidocaine 2%, ");
					medicalProcedureInputController.str = str1.toString();

				}if (lidocaineJellyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("lidocaine jelly");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (betadineCheck.isSelected() || gauzeCheck.isSelected()
					|| syringeCheck.isSelected() || alcoholCheck.isSelected()
					|| salineCheckBox.isSelected() || bandageCheckBox.isSelected()) {

			
				
				if (betadineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Betadine, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (gauzeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4x4 Gauze, ");
					medicalProcedureInputController.str = str1.toString();

				}if (syringeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Syringe, ");
					medicalProcedureInputController.str = str1.toString();

				}if (alcoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Alcohol OR Peroxide,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (salineCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Saline,");
					medicalProcedureInputController.str = str1.toString();

				}if (bandageCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Bandaged ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			

			if (wellRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("");
				medicalProcedureInputController.str = str1.toString();
				
			}if (minimulBloodRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("");
				medicalProcedureInputController.str = str1.toString();

			}if (withComplecationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("");
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