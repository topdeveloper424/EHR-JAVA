package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ConsultOrthoOmgInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox RTUpperCheck;

    @FXML
    private CheckBox LTUpperCheck;

    @FXML
    private CheckBox RTLowerCheck;

    @FXML
    private CheckBox BilateralUpperCheck;

    @FXML
    private CheckBox BilateralLowerCheck;

    @FXML
    private CheckBox LTLowerCheck;

	
	 private OrderConsultInputController orderConsultInputController;

		public void setOrderConsultInputController(OrderConsultInputController orderConsultInputController) {
				this.orderConsultInputController = orderConsultInputController;
			}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder acupunctureReferalStr = new StringBuilder(orderConsultInputController.str);
			acupunctureReferalStr.append("\n\n ");
			orderConsultInputController.str = acupunctureReferalStr.toString();

			if (RTUpperCheck.isSelected() || LTUpperCheck.isSelected() 
					|| RTLowerCheck.isSelected() || LTLowerCheck.isSelected()
					|| BilateralUpperCheck.isSelected() || BilateralLowerCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("Patient is referred for electrodiagnostic evaluation of the ");
				orderConsultInputController.str = str1.toString();

				if (RTUpperCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("RT upper extremity, ");
					orderConsultInputController.str = str11.toString();

				} 

				if (LTUpperCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("LT upper extremity, ");
					orderConsultInputController.str = str11.toString();

				}

				if (RTLowerCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("RT lower extremity, ");
					orderConsultInputController.str = str11.toString();

				}if (LTLowerCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("LT lower extremity, ");
					orderConsultInputController.str = str11.toString();

				}

				if (BilateralUpperCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("bilateral upper extremities ");
					orderConsultInputController.str = str11.toString();

				}

				if (BilateralLowerCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("bilateral lower extremeties, ");
					orderConsultInputController.str = str11.toString();

				}

				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str1.append(".");
				orderConsultInputController.str = str1.toString();

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
