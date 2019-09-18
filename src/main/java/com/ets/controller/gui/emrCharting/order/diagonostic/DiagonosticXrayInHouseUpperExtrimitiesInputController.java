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

public class DiagonosticXrayInHouseUpperExtrimitiesInputController implements Initializable {
	
	   @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox cervicalCheck;

	    @FXML
	    private CheckBox scapulaCheck;

	    @FXML
	    private CheckBox shoulderCheck;

	    @FXML
	    private CheckBox elbowCheck;

	    @FXML
	    private CheckBox humerusCheck;

	    @FXML
	    private RadioButton selectAnterior;

	    @FXML
	    private ToggleGroup sel;

	    @FXML
	    private RadioButton selectPosterior;

	    @FXML
	    private CheckBox elbow3ViewsCheck;

	    @FXML
	    private RadioButton selectLateral;

	    @FXML
	    private RadioButton selectLeft;

	    @FXML
	    private RadioButton selectAP;

	    @FXML
	    private RadioButton selectRight;

	    @FXML
	    private CheckBox forearmCheck;

	    @FXML
	    private CheckBox wrist3ViewCheck;

	    @FXML
	    private CheckBox hand3ViewsCheck;

	    @FXML
	    private CheckBox wrist2ViewsCheck;

	    @FXML
	    private CheckBox hand2Check;

	    @FXML
	    private CheckBox finger2Check;

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

			if(cervicalCheck.isSelected() || scapulaCheck.isSelected()
					|| shoulderCheck.isSelected() || humerusCheck.isSelected()
					|| elbowCheck.isSelected() || elbow3ViewsCheck.isSelected()
					|| forearmCheck.isSelected() || wrist2ViewsCheck.isSelected()
					|| wrist3ViewCheck.isSelected() || hand2Check.isSelected()
					|| hand3ViewsCheck.isSelected() || finger2Check.isSelected()
					||selectAnterior.isSelected()||selectAP.isSelected()||
					selectLateral.isSelected()||selectPosterior.isSelected()
					||selectLeft.isSelected()||selectRight.isSelected()
					){
				
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
				str11.append(" AP and lateral");
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
			
			
				if(cervicalCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Clavical - Complete.");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(scapulaCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" Scapula - Complete,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(shoulderCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Shoulder - 2 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(humerusCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Humerus - 2 Views, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(elbowCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Elbow - 2 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(elbow3ViewsCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Elbow - 3 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(forearmCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Forearm - 2 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(wrist2ViewsCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Wrist - 2 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(wrist3ViewCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Wrist - 3 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(hand2Check.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Hand - 2 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(hand3ViewsCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Hand - 3 Views , ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(finger2Check.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Finger - 2 Views");
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
