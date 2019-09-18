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

public class DiagonosticXrayInHouseInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox chest1ViewCheck;

	    @FXML
	    private CheckBox chest2ViewCheck;

	    @FXML
	    private CheckBox ribs2ViewUniLateralCheck;

	    @FXML
	    private CheckBox sternamCheck;

	    @FXML
	    private CheckBox ribs2ViewBiLateralCheck;

	    @FXML
	    private RadioButton paRadio;

	    @FXML
	    private ToggleGroup sel;

	    @FXML
	    private RadioButton paLateralRadio;

	    @FXML
	    private TextArea xrayText;

	    @FXML
	    private CheckBox SternoclaciculaCheck;
	
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

			
			if(paRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered X-Ray of the PA");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(paLateralRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered X-Ray of the PA and lateral ");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
		
				
				if(chest1ViewCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Chest - 1 View, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(chest2ViewCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Chest - 2 View, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(ribs2ViewUniLateralCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Ribs - 2 Views Unilateral,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(ribs2ViewBiLateralCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Ribs - 3 Views Bilateral, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(sternamCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Sternam - 2 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(SternoclaciculaCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Sternoclavicular Joint - 3 View,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append("");
				orderDiagonosticTestInputController.str = str12.toString();
				
		
			
			
			
			if(xrayText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" Additional Radiologist Instructions: " +xrayText.getText() +"");
				orderDiagonosticTestInputController.str = str11.toString();
				
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
