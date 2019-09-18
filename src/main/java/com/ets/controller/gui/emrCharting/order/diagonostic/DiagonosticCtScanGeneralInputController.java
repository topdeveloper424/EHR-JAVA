package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class DiagonosticCtScanGeneralInputController implements Initializable{
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton withcontrastRadio;

	    @FXML
	    private ToggleGroup sel;

	    @FXML
	    private RadioButton withoutContrast;

	    @FXML
	    private RadioButton withRadiology;

	    @FXML
	    private RadioButton skull;

	    @FXML
	    private ToggleGroup body;

	    @FXML
	    private RadioButton face;

	    @FXML
	    private TextArea notesTextArea;

	    @FXML
	    private RadioButton sinuses;

	    @FXML
	    private RadioButton upperAbdomen;

	    @FXML
	    private RadioButton pelvis;

	    @FXML
	    private RadioButton thoracicSpine;

	    @FXML
	    private RadioButton chest;

	    @FXML
	    private RadioButton abdomen;

	    @FXML
	    private RadioButton cervical;

	    @FXML
	    private RadioButton lumberSpine;
	    
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

			if(withcontrastRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered CT Scan with contrast ");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			if(withoutContrast.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Ordered CT Scan without contrast ");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
						
			if(withRadiology.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("Ordered CT Scan with radiologist selecting contrast");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			if(skull.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("of the skull.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(face.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("of the face. ");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			if(sinuses.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("of the sinuses. ");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(chest.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("of the chest. ");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			if(upperAbdomen.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("of the upper abdomen.. ");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
			if(abdomen.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" of the abdomen.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(pelvis.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append(" of the pelvis.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			if(cervical.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" of the cervical.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(thoracicSpine.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("  of the thoracic spine.");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			if(lumberSpine.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("  of the lumber spine.");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}
			
			
			
			
			
			if (notesTextArea.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" " + notesTextArea.getText() + " ");
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
