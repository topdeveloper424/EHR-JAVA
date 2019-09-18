package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OtherDataReviewPastVisitInputController implements Initializable{
	
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox min15Check;

    @FXML
    private CheckBox min30Check;

    @FXML
    private CheckBox min45Check;

    @FXML
    private CheckBox min60Check;

    @FXML
    private CheckBox chartingNotesCheck;

    @FXML
    private CheckBox labResult;

    @FXML
    private CheckBox imageCheck;

    @FXML
    private CheckBox otherCheck;

	
	
	private OrderOtherDataSourceInputController orderOtherDataSourceInputController;

	public void setOrderOtherDataSourceInputController(
			OrderOtherDataSourceInputController orderOtherDataSourceInputController) {
		this.orderOtherDataSourceInputController = orderOtherDataSourceInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder ctScanStr = new StringBuilder(orderOtherDataSourceInputController.str);
			ctScanStr.append("\n\n ");
			orderOtherDataSourceInputController.str = ctScanStr.toString();

			
				
				if(min15Check.isSelected() || min30Check.isSelected()
						|| min45Check.isSelected() || min60Check.isSelected()){
					
					StringBuilder str121 = new StringBuilder(orderOtherDataSourceInputController.str);
					str121.append("Reviewed and summarized past visit / old medical records to assist with assessment and treatment. Estimated length of time spent reviewing records was: ");
					orderOtherDataSourceInputController.str = str121.toString();
					
					
					
					if(min15Check.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("15 min, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}if(min30Check.isSelected()){
						
						StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
						str11.append(" 30 min, ");
						orderOtherDataSourceInputController.str = str11.toString();
						
					}if(min45Check.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("45 min, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}if(min60Check.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("60 min, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str = new StringBuilder(orderOtherDataSourceInputController.str);
					str.append(".");
					orderOtherDataSourceInputController.str = str.toString();
					
				}
				
				
				
				if(chartingNotesCheck.isSelected() || labResult.isSelected()
						|| imageCheck.isSelected() || otherCheck.isSelected()){
					
					StringBuilder str121 = new StringBuilder(orderOtherDataSourceInputController.str);
					str121.append("The following records were reviewed: ");
					orderOtherDataSourceInputController.str = str121.toString();
					
					
					
					if(chartingNotesCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("charting notes, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}if(labResult.isSelected()){
						
						StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
						str11.append("lab results, ");
						orderOtherDataSourceInputController.str = str11.toString();
						
					}if(imageCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("imaging report, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}if(otherCheck.isSelected()){
						
						StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
						str1.append("other, ");
						orderOtherDataSourceInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str = new StringBuilder(orderOtherDataSourceInputController.str);
					str.append(".");
					orderOtherDataSourceInputController.str = str.toString();
					
				}
				
				
			

			++orderOtherDataSourceInputController.formCount;
			orderOtherDataSourceInputController.setOtherDataSource();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				
				++orderOtherDataSourceInputController.formCount;
				orderOtherDataSourceInputController.setOtherDataSource();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
