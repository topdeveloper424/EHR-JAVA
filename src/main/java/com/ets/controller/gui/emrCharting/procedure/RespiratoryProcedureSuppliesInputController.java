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

public class RespiratoryProcedureSuppliesInputController implements Initializable {
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox HydrationGreater1HourCheck;

	    @FXML
	    private CheckBox HydrationLess1HourCheck;

	    @FXML
	    private CheckBox TherapeuticCheck;

	    @FXML
	    private CheckBox NebulizerTxCheck;

	    @FXML
	    private CheckBox NebulizerSalineCheck;

	    @FXML
	    private CheckBox AlbuterolIpratropiumCheck;

	    @FXML
	    private CheckBox AlbuterolCheck;

	    @FXML
	    private CheckBox pftCheck;

	    @FXML
	    private CheckBox AtroventCheck;
	    
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

			

			if (HydrationGreater1HourCheck.isSelected() || HydrationLess1HourCheck.isSelected() 
					|| pftCheck.isSelected()
					|| TherapeuticCheck.isSelected() || NebulizerTxCheck.isSelected()
					|| NebulizerSalineCheck.isSelected() || AlbuterolIpratropiumCheck.isSelected()
					|| AlbuterolCheck.isSelected() || AtroventCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Administered:");
				medicalProcedureInputController.str = str.toString();
				
				if (HydrationGreater1HourCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Hydration > 1 Hour. ");
					medicalProcedureInputController.str = str1.toString();
					
				}if (HydrationLess1HourCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" Hydration > 1 Hour. ");
					medicalProcedureInputController.str = str1.toString();

				}if (TherapeuticCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Therapeutic Injection. ");
					medicalProcedureInputController.str = str1.toString();

				}if (pftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("PFT spirometry ");
					medicalProcedureInputController.str = str1.toString();

				}if (NebulizerTxCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nebulizer Tx ");
					medicalProcedureInputController.str = str1.toString();

				}if (NebulizerSalineCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Nebulizer Saline Cartridge ");
					medicalProcedureInputController.str = str1.toString();

				}if (AlbuterolIpratropiumCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Albuterol + Ipratropium ");
					medicalProcedureInputController.str = str1.toString();

				}if (AlbuterolCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Albuterol Only ");
					medicalProcedureInputController.str = str1.toString();

				}if (AtroventCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Atrovent Only");
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
