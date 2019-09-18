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

public class ForeignBodyUcInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField volumeAnestheticText;

	    @FXML
	    private Label AnesthasiaModalitytText;

	    @FXML
	    private RadioButton simpleRadio;

	    @FXML
	    private ToggleGroup complexity;

	    @FXML
	    private RadioButton complexRadio;

	    @FXML
	    private RadioButton scalpelRadio;

	    @FXML
	    private ToggleGroup choice;

	    @FXML
	    private RadioButton foreignBidyRadio;

	    @FXML
	    private RadioButton sterileRadio;

	    @FXML
	    private ToggleGroup modi;

	    @FXML
	    private CheckBox bulkyCheckBox;

	    @FXML
	    private CheckBox sterileCheckBox;

	    @FXML
	    private CheckBox tubeCheckBox;

	    @FXML
	    private CheckBox adapticCeckBox;

	    @FXML
	    private CheckBox xeroformCeckBox;

	    @FXML
	    private CheckBox bandageCeckBox;

	    @FXML
	    private CheckBox wellCheckBox;

	    @FXML
	    private CheckBox WiyhoutCompletionCheckBox;

	    @FXML
	    private CheckBox minaralCheckBox;

	    @FXML
	    private CheckBox withCompletionCheckBox;

	    @FXML
	    private CheckBox backCheck;

	    @FXML
	    private CheckBox legCheck;

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
	    private RadioButton alcoholRadio;

	    @FXML
	    private RadioButton betadyneRadio;

	    @FXML
	    private RadioButton hibcleanseRadio;

	    @FXML
	    private CheckBox hipCheck;

	    @FXML
	    private CheckBox faceCheck;

	    @FXML
	    private CheckBox earCheck;

	    @FXML
	    private CheckBox vaginaCheck;

	    @FXML
	    private RadioButton ethilon4Radio;

	    @FXML
	    private ToggleGroup suture;

	    @FXML
	    private RadioButton ethilon5Radio;

	    @FXML
	    private RadioButton ethilon6Radio;

	    @FXML
	    private RadioButton prolene4Radio;

	    @FXML
	    private RadioButton prolene5Radio;

	    @FXML
	    private RadioButton vicylRadio;

	    @FXML
	    private RadioButton postAlcoholRadio;

	    @FXML
	    private ToggleGroup post;

	    @FXML
	    private RadioButton postBetadyneRadio;

	    @FXML
	    private RadioButton postPeroxidelRadio;

	    @FXML
	    private RadioButton postSalineRadio;

	    @FXML
	    private CheckBox fingerCheck;

	    @FXML
	    private CheckBox handCheck;

	    @FXML
	    private CheckBox toeCheck;

	    @FXML
	    private CheckBox footCheck;

	    @FXML
	    private CheckBox forearmCheck;

	    @FXML
	    private CheckBox shoulderCheck;
	    
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

			

			
			if (simpleRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The simple foreign body was identified. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (complexRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The complex foreign body was identified. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			if (fingerCheck.isSelected() || handCheck.isSelected()
					|| toeCheck.isSelected() || footCheck.isSelected()
					|| forearmCheck.isSelected() || shoulderCheck.isSelected()
					|| hipCheck.isSelected() || faceCheck.isSelected()
					|| earCheck.isSelected() || backCheck.isSelected()
					|| legCheck.isSelected() || vaginaCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("The foreign body was located in the: ");
				medicalProcedureInputController.str = str.toString();
				
				if (fingerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("finger, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (handCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("hand, ");
					medicalProcedureInputController.str = str1.toString();

				}if (toeCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("toe, ");
					medicalProcedureInputController.str = str1.toString();

				}if (footCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("foot, ");
					medicalProcedureInputController.str = str1.toString();

				}if (forearmCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("forearm, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (shoulderCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("shoulder, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (hipCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("hip or thigh, ");
					medicalProcedureInputController.str = str1.toString();

				}if (faceCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("face, ");
					medicalProcedureInputController.str = str1.toString();

				}if (earCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ear, ");
					medicalProcedureInputController.str = str1.toString();

				}if (backCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("back, ");
					medicalProcedureInputController.str = str1.toString();
					 
				}if (legCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("leg, ");
					medicalProcedureInputController.str = str1.toString();

				}if (vaginaCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("vagina");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (volumeAnestheticText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("An anesthetic injection of " +volumeAnestheticText.getText() +" cc. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (Idocaine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Of 1% lidocaine was infiltrated into the area. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (Idocaine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Of 2% lidocaine was infiltrated into the area. ");
				medicalProcedureInputController.str = str1.toString();

			}if (eapinephrine1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Of 1% lidocaine with epinephrine was infiltrated into the area. ");
				medicalProcedureInputController.str = str1.toString();

			}if (eapinephrine2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Of 2% lidocaine with epinephrine was infiltrated into the area. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			if (alcoholRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The area was prepped and draped in normal sterile fashion with Alcohol. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (betadyneRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The area was prepped and draped in normal sterile fashion with Betadine. ");
				medicalProcedureInputController.str = str1.toString();

			}if (hibcleanseRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The area was prepped and draped in normal sterile fashion with Hibicleanse. ");
				medicalProcedureInputController.str = str1.toString();

			}if (sterileRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The area was prepped and draped in normal sterile fashion with Sterile Saline. ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (scalpelRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Using a scalpel blade an incision was ma ");
				medicalProcedureInputController.str = str1.toString();

			}if (foreignBidyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Foreign Body remove with ");
				medicalProcedureInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			if (ethilon4Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 4-0 ethilon (nylon) suture material.");
				medicalProcedureInputController.str = str1.toString();
				
			}if (ethilon5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 5-0 ethilon (nylon) suture material.");
				medicalProcedureInputController.str = str1.toString();

			}if (ethilon6Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 6-0 ethilon (nylon) suture material.");
				medicalProcedureInputController.str = str1.toString();

			}if (prolene4Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 4-0 prolene suture material. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (prolene5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 5-0 prolene suture material. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (vicylRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("The skin was closed using, 4.0 vicryl suture material. ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (postAlcoholRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient's wound was irrigated and cleansed post-operatively with alcohol. ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (postBetadyneRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient's wound was irrigated and cleansed post-operatively with betadine. ");
				medicalProcedureInputController.str = str1.toString();

			}if (postPeroxidelRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient's wound was irrigated and cleansed post-operatively with peroxide. ");
				medicalProcedureInputController.str = str1.toString();

			}if (postSalineRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient's wound was irrigated and cleansed post-operatively with saline. ");
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
					str1.append("with complications (see notes below) ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(". ");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			if (sterileCheckBox.isSelected() || bulkyCheckBox.isSelected()
					|| tubeCheckBox.isSelected() || adapticCeckBox.isSelected()
					|| xeroformCeckBox.isSelected() || bandageCeckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient wound was dressed with ");
				medicalProcedureInputController.str = str.toString();
				
				if (sterileCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("sterile gauze, ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (bulkyCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bulky dressing, ");
					medicalProcedureInputController.str = str1.toString();

				}if (tubeCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("tube gauze, ");
					medicalProcedureInputController.str = str1.toString();

				}if (adapticCeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("adaptic, ");
					medicalProcedureInputController.str = str1.toString();

				}if (xeroformCeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("xeroform, ");
					medicalProcedureInputController.str = str1.toString();

				}if (bandageCeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("bandage, ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Instructions were provided to the patient as documented elsewhere.");
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
