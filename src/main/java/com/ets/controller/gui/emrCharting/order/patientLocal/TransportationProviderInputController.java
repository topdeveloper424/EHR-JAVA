package com.ets.controller.gui.emrCharting.order.patientLocal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TransportationProviderInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea tripMileText;

    @FXML
    private TextArea oneWayMileText;


	
	private OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController;

	public void setOrderPatientLocalMeasureInputController(
			OrderPatientLocalMeasureInputController orderPatientLocalMeasureInputController) {
		this.orderPatientLocalMeasureInputController = orderPatientLocalMeasureInputController;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderPatientLocalMeasureInputController.str);
			ctScanStr.append("\n\n ");
			orderPatientLocalMeasureInputController.str = ctScanStr.toString();

			
			
			
				if(tripMileText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str11.append("Provided roundtrip transportation to Patient from Work.  The total miles round trip are " +tripMileText.getText() +". " );
				orderPatientLocalMeasureInputController.str = str11.toString();
				
			}
				

				if(oneWayMileText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(orderPatientLocalMeasureInputController.str);
				str11.append(" Provided one way transportation to Patient from Work. The total miles are " +oneWayMileText.getText() +". " );
				orderPatientLocalMeasureInputController.str = str11.toString();
				
			}
				
				
				
				
			

			++orderPatientLocalMeasureInputController.formCount;
			orderPatientLocalMeasureInputController.setPatientLocalMeasureUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderPatientLocalMeasureInputController.formCount;
				orderPatientLocalMeasureInputController.setPatientLocalMeasureUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
