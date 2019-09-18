package com.ets.controller.gui.emrCharting.order.diagonostic;

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

public class DiagonosticSTDLabsUCInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox pickGonorrheaCulture;

    @FXML
    private CheckBox glucoseCheck;

    @FXML
    private CheckBox pickChalmydia;

    @FXML
    private CheckBox pickHIV12;

    @FXML
    private CheckBox pickGC;

    @FXML
    private CheckBox pickHIVAntibody;

    @FXML
    private CheckBox pickSTYS;

    @FXML
    private CheckBox pickHerpes;

    @FXML
    private CheckBox pickHerpesStain;

    @FXML
    private CheckBox pickHerpesBlood;

    @FXML
    private CheckBox labHepA;

    @FXML
    private CheckBox labHepB;

    @FXML
    private CheckBox labHepBAntigen;

    @FXML
    private CheckBox additionalWetMount;

    @FXML
    private CheckBox additionalPelvicTray;
	
	
	private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

	public void setOrderDiagonosticTestInputController(
				OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
			this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(orderDiagonosticTestInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			orderDiagonosticTestInputController.str = pmhSocialHitoryStr.toString();

			
						
			
			if(pickChalmydia.isSelected() || pickGC.isSelected()
					|| pickGonorrheaCulture.isSelected() || pickHerpes.isSelected()
					|| pickHerpesBlood.isSelected() || pickHerpesStain.isSelected()
					|| pickHIV12.isSelected() || pickHIVAntibody.isSelected()
					|| pickSTYS.isSelected() || glucoseCheck.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("The following labs were ordered, specimens sent to outside lab: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(glucoseCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Gonorrhea DNA probe,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickChalmydia.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Chlamydia DNA probe,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(pickGC.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("GC and Chlamydia, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickGonorrheaCulture.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Gonorrhea culture,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(pickHerpes.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Herpes blood type 2");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickHerpesBlood.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Herpes blood type 1,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				if(pickHerpesStain.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Herpes stain, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickHIV12.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("  HIV 1-2, single assay , ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickHIVAntibody.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("HIV antibody confirmation test, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(pickSTYS.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" STS (RPR), ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			
			if(labHepA.isSelected() 					
					|| labHepB.isSelected() || labHepBAntigen.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(labHepA.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hep A Antibody,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(labHepB.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Hep B Antibody ,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(labHepBAntigen.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hep B antigen");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
			
				
			}
			
			
			StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
			str12.append("Patients informed of need to follow up for results.");
			orderDiagonosticTestInputController.str = str12.toString();
			if(additionalWetMount.isSelected() || additionalPelvicTray.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Additional supplies: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(additionalWetMount.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Wet mount for infectious agents,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(additionalPelvicTray.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Pelvic tray.");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				
				
				
			}
			
			

			++orderDiagonosticTestInputController.formCount;
			orderDiagonosticTestInputController.setDiagonosisTestUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderDiagonosticTestInputController.formCount;
				orderDiagonosticTestInputController.setDiagonosisTestUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
