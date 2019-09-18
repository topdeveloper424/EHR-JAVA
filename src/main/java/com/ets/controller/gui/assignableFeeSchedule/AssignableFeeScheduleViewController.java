package com.ets.controller.gui.assignableFeeSchedule;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AssignableFeeScheduleViewController implements Initializable {

	@FXML
	private Button add;

	@FXML
	private Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		FXMLFormPath formPath = new FXMLFormPath();

		close.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		add.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddAssignableFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddAssignableFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
	}

}
