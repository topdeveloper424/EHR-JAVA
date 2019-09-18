package com.ets.controller.gui.cashDiscountFeeSchedule;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class CashDiscountFeeScheduleInputController implements Initializable {
	@FXML
	private Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		close.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
