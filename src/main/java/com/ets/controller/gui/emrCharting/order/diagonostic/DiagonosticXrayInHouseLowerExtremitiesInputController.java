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

public class DiagonosticXrayInHouseLowerExtremitiesInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox BodyHip1Check;

	    @FXML
	    private CheckBox BodyHip2Complete;

	    @FXML
	    private CheckBox BodyHip2BilateralCheck;

	    @FXML
	    private CheckBox BodyKnee3Check;

	    @FXML
	    private CheckBox BodyFemur2;

	    @FXML
	    private RadioButton selectAnterior;

	    @FXML
	    private ToggleGroup sel;

	    @FXML
	    private RadioButton selectPosterior;

	    @FXML
	    private CheckBox BodyKnee4;

	    @FXML
	    private RadioButton selectLateral;

	    @FXML
	    private RadioButton selectLeft;

	    @FXML
	    private RadioButton selectAP;

	    @FXML
	    private RadioButton selectRight;

	    @FXML
	    private CheckBox BodykneeBothStandingAP;

	    @FXML
	    private CheckBox BodyAnkle3views;

	    @FXML
	    private CheckBox BodyCalcaneus;

	    @FXML
	    private CheckBox BodyTibia2;

	    @FXML
	    private CheckBox BodyFoot;

	    @FXML
	    private CheckBox BodyToes2;

	    @FXML
	    private TextArea additionalTextArea;
	
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

			
			
			if(BodyAnkle3views.isSelected() || BodyCalcaneus.isSelected()
					|| BodyFemur2.isSelected() || BodyFoot.isSelected()
					|| BodyHip1Check.isSelected() || BodyHip2BilateralCheck.isSelected()
					|| BodyHip2Complete.isSelected() || BodyKnee3Check.isSelected()
					|| BodyKnee4.isSelected() || BodykneeBothStandingAP.isSelected()
					|| BodyTibia2.isSelected() || BodyToes2.isSelected()||selectAnterior.isSelected()||
					selectAP.isSelected()||selectLateral.isSelected()||
					selectPosterior.isSelected()||selectLeft.isSelected()||
					selectRight.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered X-Ray of the ");
				orderDiagonosticTestInputController.str = str.toString();
				
			
				
				if(selectAnterior.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append( "anterior ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(selectAP.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" AP and lateral ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(selectLateral.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" lateral ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(selectPosterior.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" posterior ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(selectLeft.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" left ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(selectRight.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("right");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				
				
				if(BodyAnkle3views.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Ankle - 3 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyCalcaneus.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Calcaneus - 2 Views ,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyFemur2.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Femur - 2 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyFoot.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Foot -  3 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyHip1Check.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Hip - 1 View,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyHip2BilateralCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hips - 2 Views Bilateral,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyHip2Complete.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hip - 2 Views Complete, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyKnee3Check.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Knee - 3 Views, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyKnee4.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Knee - 4 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodykneeBothStandingAP.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Knee - Both Standing AP,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyTibia2.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Tibia & Fibula - 2 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyToes2.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Toes - 2 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			
			if(additionalTextArea.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Additional Radiologist Instructions: " +additionalTextArea.getText() +"");
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
