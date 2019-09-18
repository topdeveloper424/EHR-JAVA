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

public class DiagonosticVisionTestingInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton acuityFarRadio;

	    @FXML
	    private ToggleGroup body;

	    @FXML
	    private RadioButton acuityFarAndNearRadio;

	    @FXML
	    private RadioButton acuityNearRadio;

	    @FXML
	    private CheckBox pickVisualCheck;

	    @FXML
	    private CheckBox pickTitmusTesting;

	    @FXML
	    private CheckBox pickDepthpreception;

	    @FXML
	    private CheckBox pickColorVision;

	    @FXML
	    private CheckBox pickFluroscein;
	
	
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

			
			
			
			
			
			if(pickColorVision.isSelected() || pickDepthpreception.isSelected()
					|| pickFluroscein.isSelected() || pickTitmusTesting.isSelected()
					
					|| pickVisualCheck.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following vision related testing: ");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(pickColorVision.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("color vision testing, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickDepthpreception.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("depth perception,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(pickFluroscein.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" fluroscein staining, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickTitmusTesting.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("titmus testing,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(pickVisualCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("visual acuity,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			if(acuityFarRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Test far visual acuity. ");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(acuityNearRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Test near visual acuity.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			if(acuityFarAndNearRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Test far and near visual acuity.");
				orderDiagonosticTestInputController.str = str1.toString();
				
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
