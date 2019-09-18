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

public class UrgentCareCourseInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton time30Radio;

	    @FXML
	    private ToggleGroup time;

	    @FXML
	    private RadioButton time45Radio;

	    @FXML
	    private CheckBox tubingCheckBox;

	    @FXML
	    private CheckBox ns500CheckBox;

	    @FXML
	    private CheckBox fluids1LCheckBox;

	    @FXML
	    private CheckBox insulinCheckBox;

	    @FXML
	    private CheckBox insulinTherapyCheck;

	    @FXML
	    private CheckBox NibulizerCheck;

	    @FXML
	    private CheckBox NibulizerHighCheck;

	    @FXML
	    private RadioButton time1Radio;

	    @FXML
	    private RadioButton time115Radio;

	    @FXML
	    private CheckBox peakFlowCheckBox;

	    @FXML
	    private CheckBox dotCheckBox;

	    @FXML
	    private CheckBox ivFluidCheck;

	    @FXML
	    private CheckBox numberCheck;

	    @FXML
	    private CheckBox dotCheck;

	    @FXML
	    private CheckBox pftCheck;

	    @FXML
	    private CheckBox NibulizerSalineCheck;

	    @FXML
	    private CheckBox AlbuterolAndIpratropiumCheck;

	    @FXML
	    private CheckBox AlbuterolOnlyCheck;

	    @FXML
	    private CheckBox SuplimentalCheck;

	    @FXML
	    private CheckBox pulseCheck;

	    @FXML
	    private CheckBox NibulizerTxCheck;

	    @FXML
	    private CheckBox IpratropiumOnlyCheck;

	    @FXML
	    private CheckBox DexamethasoneInhaledCheck;

	    @FXML
	    private CheckBox DexamethasoneInjectionCheck;

	    @FXML
	    private RadioButton time130Radio;

	    @FXML
	    private RadioButton time145Radio;

	    @FXML
	    private RadioButton time2Radio;

	    @FXML
	    private RadioButton time215Radio;

	    @FXML
	    private RadioButton time230Radio;

	    @FXML
	    private RadioButton time245Radio;

	    @FXML
	    private RadioButton time3Radio;

	    @FXML
	    private RadioButton timegreater3Radio;

	    @FXML
	    private TextArea detailReasonTextArea;

	    @FXML
	    private TextArea detailTreatementTextarea;

	    @FXML
	    private TextArea responseToTreatementTextarea;

	    @FXML
	    private TextArea significantTextarea;
	    
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

			
			if (time30Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 30 min ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time45Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 45 min ");
				medicalProcedureInputController.str = str1.toString();

			}if (time1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 1 hour ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time115Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 1 hour 15 min");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time130Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 1 hour 30 min");
				medicalProcedureInputController.str = str1.toString();

			}if (time145Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 1 hour 45 min");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 2 hour ");
				medicalProcedureInputController.str = str1.toString();

			}if (time215Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for:2 hour 15 min");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time230Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 2 hour 30 min ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (time245Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 2 hour 45 min ");
				medicalProcedureInputController.str = str1.toString();

			}if (time3Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: 3 hour ");
				medicalProcedureInputController.str = str1.toString();
				
			}if (timegreater3Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Patient was observed for: >3 hour ");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (ivFluidCheck.isSelected() || NibulizerCheck.isSelected()
					|| NibulizerHighCheck.isSelected()
					|| insulinTherapyCheck.isSelected() || numberCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient was observed for following reason(s): ");
				medicalProcedureInputController.str = str.toString();
				
				if (ivFluidCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("IV Fluids");
					medicalProcedureInputController.str = str1.toString();
					
				}if (NibulizerCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nebulizer Treatment, ");
					medicalProcedureInputController.str = str1.toString();

				}if (NibulizerHighCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nebulizer Treatment with High Flow O2 ");
					medicalProcedureInputController.str = str1.toString();

				}if (insulinTherapyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Insulin Therapy ");
					medicalProcedureInputController.str = str1.toString();

				}if (numberCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("5150 ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			if (detailReasonTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(detailReasonTextArea.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (SuplimentalCheck.isSelected() || pulseCheck.isSelected()
					|| NibulizerTxCheck.isSelected()
					|| NibulizerSalineCheck.isSelected() || AlbuterolAndIpratropiumCheck.isSelected()
					|| AlbuterolOnlyCheck.isSelected() || IpratropiumOnlyCheck.isSelected()
					|| DexamethasoneInhaledCheck.isSelected() || DexamethasoneInjectionCheck.isSelected()
					|| pftCheck.isSelected() || peakFlowCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Treatment: ");
				medicalProcedureInputController.str = str.toString();
				
				if (SuplimentalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Supplemental Oxygen ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (pulseCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Pulse Oximeter ");
					medicalProcedureInputController.str = str1.toString();

				}if (NibulizerTxCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nibulizer Tx ");
					medicalProcedureInputController.str = str1.toString();

				}if (NibulizerSalineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nebulizer Saline Cartridge, ");
					medicalProcedureInputController.str = str1.toString();
					  
				}if (AlbuterolAndIpratropiumCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Albuterol + Ipratropium ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (AlbuterolOnlyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Albuterol Only ");
					medicalProcedureInputController.str = str1.toString();

				}if (IpratropiumOnlyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Ipratropium Only ");
					medicalProcedureInputController.str = str1.toString();

				}if (DexamethasoneInhaledCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Dexamethasone Inhaled, 2mg ");
					medicalProcedureInputController.str = str1.toString();

				}if (DexamethasoneInjectionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Dexamethasone Injection, 1mg ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (pftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("PFT ");
					medicalProcedureInputController.str = str1.toString();

				}if (peakFlowCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Peak Flow ");
					medicalProcedureInputController.str = str1.toString();

				} 
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			if (tubingCheckBox.isSelected() || ns500CheckBox.isSelected()
							|| fluids1LCheckBox.isSelected() || insulinCheckBox.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("");
				medicalProcedureInputController.str = str.toString();
				
				if (tubingCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" IV Tubing");
					medicalProcedureInputController.str = str1.toString();
					
				}if (ns500CheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" IV Fluids- NS 500ml");
					medicalProcedureInputController.str = str1.toString();

				}if (fluids1LCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" IV Fluids- 1L");
					medicalProcedureInputController.str = str1.toString();

				}if (insulinCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append( " Insulin ");
					medicalProcedureInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(".");
				medicalProcedureInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (detailTreatementTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Detail Treatment: "+detailTreatementTextarea.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (responseToTreatementTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Response To Treatment: "+responseToTreatementTextarea.getText() +".");
				medicalProcedureInputController.str = str1.toString();

			}
			
			
			
			if (significantTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Significant Events/Findings: "+significantTextarea.getText() +".");
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