package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import org.dom4j.swing.LeafTreeNode;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;

public class FootControlsInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton NoClimbingRadio;

	    @FXML
	    private ToggleGroup bend;

	    @FXML
	    private RadioButton ClimbingLimitedRadio;

	    @FXML
	    private TextField timeText;

	    @FXML
	    private RadioButton left;

	    @FXML
	    private ToggleGroup choi;

	    @FXML
	    private RadioButton right;

	    @FXML
	    private RadioButton both;

	    @FXML
	    private RadioButton ether;

	
	
	private OrderWorkRestrictionInputController  orderWorkRestrictionInputController;

	public void setOrderWorkRestrictionInputController(
			OrderWorkRestrictionInputController orderWorkRestrictionInputController) {
		this.orderWorkRestrictionInputController = orderWorkRestrictionInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderWorkRestrictionInputController.str);
			ctScanStr.append("\n\n ");
			orderWorkRestrictionInputController.str = ctScanStr.toString();

			
				
				if(NoClimbingRadio.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("No foot control use for/with ");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(ClimbingLimitedRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("Foot control use limited to ");
					orderWorkRestrictionInputController.str = str1.toString();
					
				} 
                if(timeText.getText().length() > 0){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("" +timeText.getText() +"hours per day " );
					orderWorkRestrictionInputController.str = str11.toString();
					
				}
				
				if(left.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("the left foot.");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(right.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("the right foot.");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}if(both.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
					str11.append("both foot.");
					orderWorkRestrictionInputController.str = str11.toString();
					
				}if(ether.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
					str1.append("either foot.");
					orderWorkRestrictionInputController.str = str1.toString();
					
				}
				
				
				
				
			

			++orderWorkRestrictionInputController.formCount;
			orderWorkRestrictionInputController.setWorkRestrictionUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderWorkRestrictionInputController.formCount;
				orderWorkRestrictionInputController.setWorkRestrictionUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
