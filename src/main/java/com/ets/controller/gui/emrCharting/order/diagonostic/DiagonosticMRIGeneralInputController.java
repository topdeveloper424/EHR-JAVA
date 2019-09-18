package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiagonosticMRIGeneralInputController implements Initializable{
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton faceRadio;

	    @FXML
	    private ToggleGroup body;

	    @FXML
	    private RadioButton shoulderRadio;

	    @FXML
	    private RadioButton pelvisRadio;

	    @FXML
	    private RadioButton chestRadio;

	    @FXML
	    private RadioButton abdomenRadio;

	    @FXML
	    private RadioButton cervicalRadio;

	    @FXML
	    private RadioButton lumberSpineRadio;

	    @FXML
	    private RadioButton elbowRadio;

	    @FXML
	    private RadioButton footRadio;

	    @FXML
	    private RadioButton kneeRadio;

	    @FXML
	    private RadioButton ankleRadio;

	    @FXML
	    private RadioButton handRadio;
	
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

			
			if(abdomenRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the abdomen.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(cervicalRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the cervical spine.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(elbowRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the elbow.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(footRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the foot.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(pelvisRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the pelvis.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(kneeRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the knee.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(ankleRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the ankle.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(chestRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the chest.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(faceRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the face.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(handRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the hand.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(lumberSpineRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered MRI of the lumber spine.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(shoulderRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered MRI of the shoulder.");
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
