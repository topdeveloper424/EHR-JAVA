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

public class WoundClearingUCInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton superfacialRadio;

    @FXML
    private ToggleGroup modi;

    @FXML
    private RadioButton digitalRadio;

    @FXML
    private CheckBox gauzeCheck;

    @FXML
    private CheckBox postBetadinelCheck;

    @FXML
    private CheckBox postPeroxideCheck;

    @FXML
    private CheckBox postSalinelCheck;

    @FXML
    private CheckBox alocoholCheck;

    @FXML
    private CheckBox betadineCheck;

    @FXML
    private CheckBox hibicleanseCheck;

    @FXML
    private CheckBox postAlcoholCheck;

    @FXML
    private CheckBox prolene4Check;

    @FXML
    private CheckBox prolene5Check;

    @FXML
    private CheckBox prolene6Check;

    @FXML
    private CheckBox ethilon4Check;

    @FXML
    private CheckBox ethilon5Check;

    @FXML
    private CheckBox ethilon6Check;

    @FXML
    private CheckBox vicryl5Check;

    @FXML
    private CheckBox vicryl6Check;

    @FXML
    private CheckBox steristripsCheck;

    @FXML
    private TextField volumeText;

    @FXML
    private RadioButton steriStripsRadio;

    @FXML
    private ToggleGroup wound;

    @FXML
    private RadioButton gauzeRadio;

    @FXML
    private RadioButton lidocaine1Radio;

    @FXML
    private ToggleGroup choice;

    @FXML
    private RadioButton lidocaine2Radio;

    @FXML
    private RadioButton epinephrine1Radio;

    @FXML
    private RadioButton epinephrine2Radio;

    @FXML
    private RadioButton marcaine1Radio;

    @FXML
    private RadioButton cm25Radio;

    @FXML
    private ToggleGroup length;

    @FXML
    private RadioButton cm49Radio;

    @FXML
    private RadioButton cm75Radio;

    @FXML
    private RadioButton cm12Radio;

    @FXML
    private CheckBox withoutCheck;

    @FXML
    private CheckBox minimulBloodLossCheckBox;

    @FXML
    private CheckBox withCheck;

    @FXML
    private CheckBox wellCheck;

    @FXML
    private RadioButton bandAidRadio;
    
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

			

			if (alocoholCheck.isSelected() || betadineCheck.isSelected()
					|| hibicleanseCheck.isSelected() || gauzeCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("We conducted a wound check and/or repair.  Applicable diagnosis: To be determined. Prepared for the procedure by cleaning with ");
				medicalProcedureInputController.str = str.toString();
				
				if (alocoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (betadineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine, ");
					medicalProcedureInputController.str = str1.toString();

				}if (hibicleanseCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" hibicleanse, ");
					medicalProcedureInputController.str = str1.toString();

				}if (gauzeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Gauze 2 x 2, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			if (volumeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" An anesthetic injection of "+volumeText.getText() +".0 ml ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (lidocaine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of 1% lidocaine was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (lidocaine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of 2% lidocaine was administered .");
				medicalProcedureInputController.str = str1.toString();

			}if (epinephrine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of 1% lidocaine with epinephrine was administered. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (epinephrine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of 2% lidocaine with epinephrine was administered.");
				medicalProcedureInputController.str = str1.toString();

			}if (marcaine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" of Marcaine 0.5% was administered.");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			if (superfacialRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as superficial and/or deep infiltration. ");
				medicalProcedureInputController.str = str1.toString();

			}if (digitalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Anesthesia was administered as digital/local blockade.");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			

			if (cm25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("  2.5 cm ");
				medicalProcedureInputController.str = str1.toString();

			}if (cm49Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" 2.6 - 4.9 cm ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (cm75Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("5.0- 7.5 cm ");
				medicalProcedureInputController.str = str1.toString();

			}if (cm12Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("7.5 to 12.5 cm ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			if (ethilon4Check.isSelected() || ethilon5Check.isSelected()
					|| ethilon6Check.isSelected()
					|| prolene4Check.isSelected() || prolene5Check.isSelected()
					|| prolene6Check.isSelected() || vicryl5Check.isSelected()
					|| vicryl6Check.isSelected() || steristripsCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("");
				medicalProcedureInputController.str = str.toString();
				
				if (ethilon4Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("of 4-0 ethilon (nylon),");
					medicalProcedureInputController.str = str1.toString();
					
				}if (ethilon5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5-0 ethilon (nylon),");
					medicalProcedureInputController.str = str1.toString();

				}if (ethilon6Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("6-0 ethilon (nylon)");
					medicalProcedureInputController.str = str1.toString();

				}if (prolene4Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("4-0 prolene,");
					medicalProcedureInputController.str = str1.toString();

				}if (prolene5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5-0 prolene,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (prolene6Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("6-0 prolene");
					medicalProcedureInputController.str = str1.toString();

				}if (vicryl5Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" 5.0 vicryl,");
					medicalProcedureInputController.str = str1.toString();

				}if (vicryl6Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" 6.0 vicryl,");
					medicalProcedureInputController.str = str1.toString();

				}if (steristripsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Steristrips ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" material.");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (postAlcoholCheck.isSelected() || postBetadinelCheck.isSelected()
					|| postPeroxideCheck.isSelected() || postSalinelCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient's wound was cleansed post-operatively with ");
				medicalProcedureInputController.str = str.toString();
				
				if (postAlcoholCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("alcohol,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (postBetadinelCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("betadine,");
					medicalProcedureInputController.str = str1.toString();

				}if (postPeroxideCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" peroxide,");
					medicalProcedureInputController.str = str1.toString();

				}if (postSalinelCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("saline,");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			if (wellCheck.isSelected() || withCheck.isSelected()
					|| minimulBloodLossCheckBox.isSelected() || withoutCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append(" Patient tolerated the procedure ");
				medicalProcedureInputController.str = str.toString();
				
				if (wellCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("well,");
					medicalProcedureInputController.str = str1.toString();
					
				}if (withCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("with complications,");
					medicalProcedureInputController.str = str1.toString();

				}if (minimulBloodLossCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("minimal blood loss,");
					medicalProcedureInputController.str = str1.toString();

				}if (withoutCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("without complications,");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (steriStripsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("A Steri-strip was used to cover the wound.");
				medicalProcedureInputController.str = str1.toString();

			}if (gauzeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("A gauze was used to cover the wound.");
				medicalProcedureInputController.str = str1.toString();
				
			}if (bandAidRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("A bandid was used to cover the wound.");
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
