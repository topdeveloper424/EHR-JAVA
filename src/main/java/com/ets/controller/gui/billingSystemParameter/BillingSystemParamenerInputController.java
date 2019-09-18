package com.ets.controller.gui.billingSystemParameter;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class BillingSystemParamenerInputController implements Initializable {

	@FXML
	private Button ok;

	@FXML
	private Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		close.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
