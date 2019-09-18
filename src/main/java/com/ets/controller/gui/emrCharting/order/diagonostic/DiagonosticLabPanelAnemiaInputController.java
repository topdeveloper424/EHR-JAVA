package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabPanelAnemiaInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox CBCCheck;

	@FXML
	private CheckBox hemoglobinCheck;

	@FXML
	private CheckBox stoolCheck;

	@FXML
	private CheckBox TSHCheck;

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

			if (CBCCheck.isSelected() || hemoglobinCheck.isSelected() || stoolCheck.isSelected()
					|| TSHCheck.isSelected()) {

				StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
				str.append("Ordered the following lab panel(s): ");
				orderDiagonosticTestInputController.str = str.toString();

				if (CBCCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append(" CBC with differential, ");
					orderDiagonosticTestInputController.str = str11.toString();

				}
				if (hemoglobinCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append("hemoglobin / hematocri,");
					orderDiagonosticTestInputController.str = str1.toString();

				}
				if (stoolCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
					str11.append("stool for occult blood ,");
					orderDiagonosticTestInputController.str = str11.toString();

				}
				if (TSHCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
					str1.append(" TSH");
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
