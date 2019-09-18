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

public class DiagonosticXrayInHouseHeadNeckInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox BodyeyedetectForeignCheck;

    @FXML
    private CheckBox BodyMandible3;

    @FXML
    private CheckBox bodyMandible4;

    @FXML
    private CheckBox bodyFacialBones4;

    @FXML
    private CheckBox BodyfacialBones3;

    @FXML
    private RadioButton selectAnterior;

    @FXML
    private ToggleGroup sel;

    @FXML
    private RadioButton selectPosterior;

    @FXML
    private CheckBox BodyNasal;

    @FXML
    private RadioButton selectLateral;

    @FXML
    private RadioButton selectLeft;

    @FXML
    private RadioButton selectAP;

    @FXML
    private RadioButton selectRight;

    @FXML
    private CheckBox BodyOrbits;

    @FXML
    private CheckBox BodySinuses4;

    @FXML
    private CheckBox BodyTemporomandibular;

    @FXML
    private CheckBox BodySinuses3;

    @FXML
    private CheckBox BodySkull;

    @FXML
    private CheckBox BodyTemporomandibularBilat;

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


			if(BodyeyedetectForeignCheck.isSelected() || BodyfacialBones3.isSelected()
					|| BodyMandible3.isSelected() || BodyNasal.isSelected()
					|| BodyOrbits.isSelected() || BodySinuses3.isSelected()
					|| BodySinuses4.isSelected() || BodySkull.isSelected()
					|| BodyTemporomandibular.isSelected() || BodyTemporomandibularBilat.isSelected()
					|| bodyFacialBones4.isSelected() || bodyMandible4.isSelected()||selectAnterior.isSelected()||
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
				
				
				if(bodyMandible4.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Mandible - 4 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(bodyFacialBones4.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Facial Bones - 4 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyeyedetectForeignCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" left Eye - detect foreign body,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyfacialBones3.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Facial Bones - 3 Views");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyMandible3.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Mandible - 3 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyNasal.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Nasal Bones - 3 Views, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyOrbits.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Orbits - 4 Views,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodySinuses3.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Sinuses - 3 Views,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodySinuses4.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" Sinuses - 4 Views Complete,");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodySkull.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Skull - 4 Views, ");
					orderDiagonosticTestInputController.str = str11.toString();
					
				}if(BodyTemporomandibular.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("Temporomandibular Joint,");
					orderDiagonosticTestInputController.str = str1.toString();
					
				}
				
				if(BodyTemporomandibularBilat.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("Temporomandibular Joint Bilateral");
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
