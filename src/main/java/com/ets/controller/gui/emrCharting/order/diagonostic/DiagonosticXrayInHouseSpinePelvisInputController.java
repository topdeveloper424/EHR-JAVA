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

public class DiagonosticXrayInHouseSpinePelvisInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox Bodycervical3;

    @FXML
    private CheckBox Bodycervical4;

    @FXML
    private CheckBox BodycervicalComplete;

    @FXML
    private CheckBox BodyThoracic3;

    @FXML
    private RadioButton selectAnterior;

    @FXML
    private ToggleGroup sel;

    @FXML
    private RadioButton selectPosterior;

    @FXML
    private RadioButton selectLateral;

    @FXML
    private RadioButton selectLeft;

    @FXML
    private RadioButton selectAP;

    @FXML
    private RadioButton selectRight;

    @FXML
    private CheckBox bodyLumbar3;

    @FXML
    private CheckBox BodyLumbarComplete;

    @FXML
    private CheckBox BodyPelvis;

    @FXML
    private TextArea additionalTextArea;

    @FXML
    private CheckBox BodyThoracic2;

    @FXML
    private CheckBox BodyThoracic4;

    @FXML
    private CheckBox BodyLumbar4;

    @FXML
    private CheckBox BodyPelvis2;
	
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

			
			if(Bodycervical3.isSelected() || Bodycervical4.isSelected()
					|| BodycervicalComplete.isSelected() || BodyLumbar4.isSelected()
					|| BodyLumbarComplete.isSelected() || BodyPelvis.isSelected()
					|| BodyPelvis2.isSelected() || BodyThoracic2.isSelected()
					|| BodyThoracic3.isSelected() || BodyThoracic4.isSelected()
					|| bodyLumbar3.isSelected()||selectAnterior.isSelected()||
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
				
				
	
				if(bodyLumbar3.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Lumbar - 3 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(Bodycervical3.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Cervial - 3 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(Bodycervical4.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Cervial - 4 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodycervicalComplete.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Cervical - Complete, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyLumbar4.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Lumbar - 4 Views, ");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyLumbarComplete.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Lumbar - Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyPelvis.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Pelvis - Complete.,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				if(BodyPelvis2.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("  Pelvis - 2 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyThoracic3.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Thoracic - 3 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyThoracic4.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Thoracic - 4 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyThoracic2.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Thoracic - 2 Views");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(orderDiagonosticTestInputController.str);
				str12.append(".");
				orderDiagonosticTestInputController.str = str12.toString();
				
			}
			
			
			
			if(additionalTextArea.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("" +additionalTextArea.getText() +"");
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
