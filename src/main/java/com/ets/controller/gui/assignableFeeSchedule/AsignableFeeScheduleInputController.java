package com.ets.controller.gui.assignableFeeSchedule;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class AsignableFeeScheduleInputController implements Initializable {
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
