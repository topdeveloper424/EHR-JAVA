package com.ets.controller.gui.emrCharting.order.consult;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class ConsultBoneScanInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox CompleteCheck;

	@FXML
	private CheckBox phase3Check;

	@FXML
	private CheckBox limitedCheck;

	@FXML
	private TextArea durationTextarea;

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

			if (CompleteCheck.isSelected() || phase3Check.isSelected() || limitedCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(orderConsultInputController.str);
				str1.append("A bone scan was ordered, ");
				orderConsultInputController.str = str1.toString();

				if (CompleteCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("complete,");
					orderConsultInputController.str = str11.toString();

				}

				if (phase3Check.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("complete,3 phase ");
					orderConsultInputController.str = str11.toString();

				}

				if (limitedCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
					str11.append("limited");
					orderConsultInputController.str = str11.toString();

				}

				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str1.append("");
				orderConsultInputController.str = str1.toString();

			}

			if (durationTextarea.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(orderConsultInputController.str);
				str11.append(" " + durationTextarea.getText() + " ");
				orderConsultInputController.str = str11.toString();

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
