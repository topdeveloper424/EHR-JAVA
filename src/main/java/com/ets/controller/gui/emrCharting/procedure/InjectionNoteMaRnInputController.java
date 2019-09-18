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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class InjectionNoteMaRnInputController implements Initializable {

	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox localSiteCheckBox;

    @FXML
    private CheckBox wellCheckBox;

    @FXML
    private RadioButton intramuscularlyRadio;

    @FXML
    private ToggleGroup modi;

    @FXML
    private RadioButton subcutaneouslyRadio;

    @FXML
    private CheckBox complaintsCheckBox;

    @FXML
    private CheckBox systemicCheckBox;

    @FXML
    private CheckBox minimulCheckBox;

    @FXML
    private CheckBox alcoholCheck;

    @FXML
    private CheckBox betadineCheck;

    @FXML
    private CheckBox peroxideCheck;

    @FXML
    private TextField woundText;

    @FXML
    private TextField syringeText;

    @FXML
    private TextField needleText;

    @FXML
    private TextField injectionText;

    @FXML
    private RadioButton intradermallyRadio;

    @FXML
    private CheckBox pickAlcoholCheck;

    @FXML
    private CheckBox pickBetadineCheck;

    @FXML
    private CheckBox pickPeroxideCheck;
    
    private MedicalProcedureInputController medicalProcedureInputController;

    public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(medicalProcedureInputController.str);
			skelComp.append("\n\n");
			medicalProcedureInputController.str = skelComp.toString();
			
			
			if (alcoholCheck.isSelected() || betadineCheck.isSelected()
					|| peroxideCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("The injection site was cleansed with ");
				medicalProcedureInputController.str = str.toString();
				
				if (alcoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (betadineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (peroxideCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("peroxide, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
			}

			
			if (syringeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("A "+syringeText.getText()+"cc syringe was affixed with ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (needleText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("a "+needleText.getText() +" gauge needle ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (injectionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("and the solution injected into the "+injectionText.getText() +" ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			if (intramuscularlyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("intramuscularly. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (subcutaneouslyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("subcutaneously. ");
				medicalProcedureInputController.str = str1.toString();

			}if (intradermallyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("intradermally. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			if (pickAlcoholCheck.isSelected() || pickBetadineCheck.isSelected()
					|| pickPeroxideCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("After injection the wound was cleansed with ");
				medicalProcedureInputController.str = str.toString();
				
				if (pickAlcoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol, ");
					medicalProcedureInputController.str = str1.toString();
							
				}if (pickBetadineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (pickPeroxideCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("peroxide, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
			}
				
			
			if (woundText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("dressed with "+woundText.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			

			if (wellCheckBox.isSelected() || complaintsCheckBox.isSelected()
					|| systemicCheckBox.isSelected()|| localSiteCheckBox.isSelected()
					|| minimulCheckBox.isSelected()) {

				StringBuilder str12 = new StringBuilder(medicalProcedureInputController.str);
				str12.append("The procedure was tolerated ");
				medicalProcedureInputController.str = str12.toString();
					
				if (wellCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (complaintsCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications, ");
					medicalProcedureInputController.str = str1.toString();

				}if (systemicCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without systemic reactions, ");
					medicalProcedureInputController.str = str1.toString();

				}if (localSiteCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without local site reaction, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (minimulCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" with minimal blood loss, ");
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
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		}
		
		
	}

