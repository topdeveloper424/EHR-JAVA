package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class ConsultErTransferInputController implements Initializable {

	 @FXML

	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextArea erTransferTextArea;

	    @FXML
	    private CheckBox ComplexInjuryCheck;

	    @FXML
	    private CheckBox EmergencyMajorCheck;

	    @FXML
	    private CheckBox LossCheck;

	    @FXML
	    private CheckBox PeritonitisCheck;

	    @FXML
	    private CheckBox ServeRespiratoryCheck;

	    @FXML
	    private CheckBox includeCheck;

	    @FXML
	    private CheckBox AcuteMICheck;

	    @FXML
	    private CheckBox HeadInjuryCheck;

	    @FXML
	    private CheckBox MultipleCheck;

	    @FXML
	    private CheckBox PsychiatricIllness;

	    @FXML
	    private CheckBox tiaCheck;

	    @FXML
	    private CheckBox nearestCheck;

	    @FXML
	    private CheckBox otherCheck;

	    @FXML
	    private CheckBox HeadTraumaCheck;

	    @FXML
	    private CheckBox CTScanCheck;

	    @FXML
	    private CheckBox TraumaCheck;

	    @FXML
	    private CheckBox MRIRequestedCheck;
	private OrderConsultInputController orderConsultInputController;

	public void setOrderConsultInputController(OrderConsultInputController orderConsultInputController) {
		this.orderConsultInputController = orderConsultInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		


		doneBtn.setOnAction((event) -> {

			StringBuilder consultStr = new StringBuilder(orderConsultInputController.str);
			consultStr.append("\n\n ");
			orderConsultInputController.str = consultStr.toString();
			
			
			if(nearestCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("We arranged immediate transfer of patient via ambulance to Nearest emergency room.");
				orderConsultInputController.str = str1.toString();
			
			}
           if(includeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append(" Patient was advised to go to the nearest emergency room.");
				orderConsultInputController.str = str1.toString();
			
			}
			
           
          
			
			if(ComplexInjuryCheck.isSelected() || AcuteMICheck.isSelected() 
					|| EmergencyMajorCheck.isSelected() || HeadInjuryCheck.isSelected()
					|| LossCheck.isSelected() || MultipleCheck.isSelected()
					|| PeritonitisCheck.isSelected() || PsychiatricIllness.isSelected()
					|| ServeRespiratoryCheck.isSelected() || tiaCheck.isSelected()
					|| otherCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append(" Patient was sent to the ER for the following medical conditions: ");
				orderConsultInputController.str = str1.toString();
				
				if(ComplexInjuryCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append(" Acute complex injury,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(AcuteMICheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Acute MI,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(EmergencyMajorCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Emergency major surgery,");
					orderConsultInputController.str = str11.toString();
					
				}
				if(HeadInjuryCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Head injury,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(LossCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Loss of consciousness,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(MultipleCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Multiple traumas,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(PeritonitisCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Peritonitis,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(PsychiatricIllness.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append(" Psychiatric illness,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(ServeRespiratoryCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Severe respiratory distress,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(tiaCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("TIA,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(otherCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("other");
					orderConsultInputController.str = str11.toString();
					
				}
				
				
				
				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append(".");
				orderConsultInputController.str = str11.toString();
				
				
			}
		
			
			if(erTransferTextArea.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append(" " +erTransferTextArea.getText() +" " );
				orderConsultInputController.str = str11.toString();
				
			}
			
			
			if(HeadTraumaCheck.isSelected() || TraumaCheck.isSelected() 
					|| CTScanCheck.isSelected() || MRIRequestedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("");
				orderConsultInputController.str = str1.toString();
				
				if(HeadTraumaCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Head Trauma,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(TraumaCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("Trauma,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(CTScanCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("CT Scan Requested,");
					orderConsultInputController.str = str11.toString();
					
				}
				
				if(MRIRequestedCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append(" MRI Requested.");
					orderConsultInputController.str = str11.toString();
					
				}
				
			
				
				
			}
			
			

			

			++orderConsultInputController.formCount;
			orderConsultInputController.setConsultUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderConsultInputController.formCount;
				orderConsultInputController.setConsultUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}


}

