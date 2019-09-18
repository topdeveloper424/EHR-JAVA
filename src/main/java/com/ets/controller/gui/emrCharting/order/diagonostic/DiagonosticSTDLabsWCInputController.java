package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticSTDLabsWCInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox hiv12;

	    @FXML
	    private CheckBox hivAntibody;

	    @FXML
	    private CheckBox sts;

	    @FXML
	    private CheckBox hepBAntigen;

	    @FXML
	    private CheckBox hepA;

	    @FXML
	    private CheckBox hepBAntibody;

	    @FXML
	    private CheckBox wetMount;

	    @FXML
	    private CheckBox pelvicTray;

    
    private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

	public void setOrderDiagonosticTestInputController(
				OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
			this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(orderDiagonosticTestInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			orderDiagonosticTestInputController.str = pmhSocialHitoryStr.toString();

			
			
			
			if(hiv12.isSelected() || sts.isSelected()
					|| hepA.isSelected() || hepBAntibody.isSelected()
					
					|| hepBAntigen.isSelected() || hivAntibody.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("The following labs were ordered, specimens sent to outside lab: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(hiv12.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("HIV 1-2, single assay, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(sts.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("STS (RPR), ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(hepA.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hep A, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(hepBAntibody.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hep B Antibody, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(hepBAntigen.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Hep B antigen, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(hivAntibody.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("HIV antibody confirmation test, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append("Patients informed of need to follow up for results. ");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			
			if(wetMount.isSelected() || pelvicTray.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Additional supplies: ");
				orderDiagonosticTestInputController.str = str.toString();
				 
				if(wetMount.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Wet mount for infectious agents,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pelvicTray.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Pelvic tray,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
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
