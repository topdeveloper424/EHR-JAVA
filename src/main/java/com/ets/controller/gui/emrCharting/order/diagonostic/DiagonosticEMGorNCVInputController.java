package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class DiagonosticEMGorNCVInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox upperExtrimities;

    @FXML
    private CheckBox lowerExtrimities;

    @FXML
    private RadioButton left;

    @FXML
    private ToggleGroup set;

    @FXML
    private RadioButton bilateral;

    @FXML
    private RadioButton right;

    @FXML
    private CheckBox cts;

    @FXML
    private CheckBox nerve;

    @FXML
    private CheckBox Paresthesias;

    @FXML
    private CheckBox Radiculopathy;

    @FXML
    private CheckBox sciatica;

    @FXML
    private CheckBox Include;

    @FXML
    private CheckBox other;
	
	
	 private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

	    public void setOrderDiagonosticTestInputController(
				OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
			this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderDiagonosticTestInputController.str);
			ctScanStr.append("\n\n ");
			orderDiagonosticTestInputController.str = ctScanStr.toString();

			if(Include.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered ");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			
			
			
			if(left.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Left");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
						
			if(right.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Right");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			if(bilateral.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Bilateral");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
			
			
			
			
			
			if(upperExtrimities.isSelected() || lowerExtrimities.isSelected()){
	
				
				if(upperExtrimities.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Upper Extrimities");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(lowerExtrimities.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Lower Extrimities");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
			
				
			}
			
			
			
			
			
			if(cts.isSelected() || Radiculopathy.isSelected()
					|| nerve.isSelected() || sciatica.isSelected()
					|| Paresthesias.isSelected() || other.isSelected()){
				
				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("");
				orderDiagonosticTestInputController.str = str.toString();
				
				if(cts.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("R/O CTS,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(Radiculopathy.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("R/O Radiculopathy,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(nerve.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" R/O Nerve Impingement,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(sciatica.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("R/O Sciatica,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}if(Paresthesias.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("R/O Paresthesias,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(other.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("R/O Other");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(".");
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
