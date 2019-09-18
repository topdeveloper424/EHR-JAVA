package com.ets.controller.gui.emrCharting.order.otherDataSource;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class OtherDataConsultInputController implements Initializable{
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton TextBook;

    @FXML
    private ToggleGroup select;

    @FXML
    private RadioButton drug;

    @FXML
    private RadioButton Jurnal;

    @FXML
    private RadioButton Electronic;
	
	
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

			
				
				if(TextBook.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
					str11.append("Reviewed Clinical Reference Source Textbook.");
					orderOtherDataSourceInputController.str = str11.toString();
					
				}if(Jurnal.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
					str1.append("Reviewed Clinical Reference Source  Journal/Review Article.");
					orderOtherDataSourceInputController.str = str1.toString();
					
				}if(drug.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderOtherDataSourceInputController.str);
					str11.append("Reviewed Clinical Reference Source  Drug Reference.");
					orderOtherDataSourceInputController.str = str11.toString();
					
				}if(Electronic.isSelected()){
					
					StringBuilder str1 = new StringBuilder(orderOtherDataSourceInputController.str);
					str1.append("Reviewed Clinical Reference Source  Electronic Database.");
					orderOtherDataSourceInputController.str = str1.toString();
					
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
