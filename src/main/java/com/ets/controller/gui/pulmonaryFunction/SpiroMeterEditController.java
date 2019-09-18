package com.ets.controller.gui.pulmonaryFunction;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.entity.spirometer.SpirometerEntityController;
import com.ets.controller.gui.region.RegionViewController;
import com.ets.model.Region;
import com.ets.model.Spirometer;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SpiroMeterEditController implements Initializable {

	@FXML
	private TextField serialNumberText;

	@FXML
	private TextField transTimeText;

	@FXML
	private TextField calibratedByText;

	@FXML
	private DatePicker transDtDate;

	@FXML
	private TextField equipmentModelText;

	@FXML
	private TextField locationText;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	


	private SpiroMeterViewController spiroMeterViewController;

	public void setSpiroMeterViewController(SpiroMeterViewController spiroMeterViewController) {
		this.spiroMeterViewController = spiroMeterViewController;
	}

	private Spirometer spirometer;

	public void setSpirometer(Spirometer spirometer) {
		this.spirometer = spirometer;

		locationText.setText(spirometer.getLoc());
		transTimeText.setText(spirometer.getTransTime());
		calibratedByText.setText(spirometer.getCalibBy());
		serialNumberText.setText(spirometer.getSerialNo());

		if (spirometer.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (spirometer.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			spirometer.setLoc(this.locationText.getText());
			spirometer.setSerialNo(this.serialNumberText.getText());
			LocalDate localDate2 = transDtDate.getValue();
			if (localDate2 != null) {

				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				spirometer.setTransDt(date2);

			}
			spirometer.setTransTime(this.transTimeText.getText());
			spirometer.setCalibBy(this.calibratedByText.getText());
			spirometer.setInactive(this.inactiveCheckBox.isSelected());

			// new SpirometerEntityController().updateSpirometer(spirometer);

			// SpiroMeterViewController.populateSpirometer(new
			// SpirometerEntityController().viewSpirometer());
			try {
				new FXFormCommonUtilities().closeForm(updateButton);
			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		cancelButton.setOnAction((event) -> {
			// Cancel centralized Form
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
