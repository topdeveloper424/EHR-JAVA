package com.ets.controller.gui.emrCharting.order.workRestriction;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.OrderWorkRestrictionInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DrivingAndRidingInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox noPersonalDriving;

	    @FXML
	    private CheckBox PersonalDriving;

	    @FXML
	    private CheckBox PersonalDriving1to3;

	    @FXML
	    private CheckBox PersonalDriving3to5;

	    @FXML
	    private CheckBox noCommercialDriving;

	    @FXML
	    private CheckBox CommercialDriving;

	    @FXML
	    private CheckBox pickAll1to3;

	    @FXML
	    private CheckBox pickAll3to5;

	    @FXML
	    private CheckBox pickAllNoRiding;

	    @FXML
	    private CheckBox pickAllRiding;
	    
	    @FXML
	    private CheckBox  pickAll1to3Riding;
	    @FXML
	    private CheckBox  pickAll3to5Riding;
	
	
	private OrderWorkRestrictionInputController  orderWorkRestrictionInputController;

	public void setOrderWorkRestrictionInputController(
			OrderWorkRestrictionInputController orderWorkRestrictionInputController) {
		this.orderWorkRestrictionInputController = orderWorkRestrictionInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		pickAll1to3Riding.setVisible(true);
		pickAll3to5Riding.setVisible(true);
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderWorkRestrictionInputController.str);
			ctScanStr.append("\n\n ");
			orderWorkRestrictionInputController.str = ctScanStr.toString();

			
				
				if(noPersonalDriving.isSelected() || PersonalDriving.isSelected()){
					
					StringBuilder str = new StringBuilder(orderWorkRestrictionInputController.str);
					str.append("Personal Driving");
					orderWorkRestrictionInputController.str = str.toString();
					
					
					if(noPersonalDriving.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
						str1.append(" No personal driving,");
						orderWorkRestrictionInputController.str = str1.toString();
						
					}if(PersonalDriving.isSelected()){
						
						StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
						str11.append(" Personal driving limited to.");
						orderWorkRestrictionInputController.str = str11.toString();
						
					}
					
					
				
					
				}
		
		
		if(PersonalDriving1to3.isSelected() || PersonalDriving3to5.isSelected()){
			
			StringBuilder str = new StringBuilder(orderWorkRestrictionInputController.str);
			str.append("");
			orderWorkRestrictionInputController.str = str.toString();
			
			
			if(PersonalDriving1to3.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
				str1.append("1 to 3 hours per day ,");
				orderWorkRestrictionInputController.str = str1.toString();
				
			}if(PersonalDriving3to5.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
				str11.append("3 to 5 hours per day.");
				orderWorkRestrictionInputController.str = str11.toString();
				
			}
			
			
			
		}
		
		
		if(noCommercialDriving.isSelected() || CommercialDriving.isSelected()){
			
			StringBuilder str = new StringBuilder(orderWorkRestrictionInputController.str);
			str.append("");
			orderWorkRestrictionInputController.str = str.toString();
			
			
			if(noCommercialDriving.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
				str1.append("No commercial driving");
				orderWorkRestrictionInputController.str = str1.toString();
				
			}if(CommercialDriving.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
				str11.append("Commercial driving limited");
				orderWorkRestrictionInputController.str = str11.toString();
				
			}
			
			
			StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
			str11.append(".");
			orderWorkRestrictionInputController.str = str11.toString();
			
		}
		
		
		if(pickAll1to3.isSelected() || pickAll3to5.isSelected()){
			
			StringBuilder str = new StringBuilder(orderWorkRestrictionInputController.str);
			str.append("Commercial Driving Limited To");
			orderWorkRestrictionInputController.str = str.toString();
			
			
			if(pickAll1to3.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
				str1.append(" 1 to 3 hours per shift ");
				orderWorkRestrictionInputController.str = str1.toString();
				
			}if(pickAll3to5.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
				str11.append(" 3 to 5 hours per shift");
				orderWorkRestrictionInputController.str = str11.toString();
				
			}
			
			
			StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
			str11.append(".");
			orderWorkRestrictionInputController.str = str11.toString();
			
		}
		
		
		
		if(pickAllNoRiding.isSelected() || pickAllRiding.isSelected()){
			
			StringBuilder str = new StringBuilder(orderWorkRestrictionInputController.str);
			str.append("Riding In Vehicle ");
			orderWorkRestrictionInputController.str = str.toString();
			
			
			if(pickAllNoRiding.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderWorkRestrictionInputController.str);
				str1.append(" No riding in vehicle,");
				orderWorkRestrictionInputController.str = str1.toString();
				
			}if(pickAllRiding.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
				str11.append(" Riding in vehicle limited to ");
				orderWorkRestrictionInputController.str = str11.toString();
				
			}
			
			
			StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
			str11.append(".");
			orderWorkRestrictionInputController.str = str11.toString();
			
		}
		
				
		if(pickAll1to3Riding.isSelected()){
			
			StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
			str11.append(" Riding In Vehicle Riding in vehicle limited to, ");
			orderWorkRestrictionInputController.str = str11.toString();
			
		}	
				
		if(pickAll3to5Riding.isSelected()){
			
			StringBuilder str11 = new StringBuilder(orderWorkRestrictionInputController.str);
			str11.append(" Riding In Vehicle Limited To 1 to 3 hours per shift.");
			orderWorkRestrictionInputController.str = str11.toString();
			
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
