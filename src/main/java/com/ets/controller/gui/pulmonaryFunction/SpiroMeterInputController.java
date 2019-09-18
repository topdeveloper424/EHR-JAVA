package com.ets.controller.gui.pulmonaryFunction;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.bodypart.BodyPartEntityController;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.entity.spirometer.SpirometerEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.controller.gui.equipmentModel.EquipmentModelViewController;
import com.ets.model.BodyPart;
import com.ets.model.EquipmentModel;
import com.ets.model.Spirometer;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company File
 * Creation Date: 22-11-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of SpiroMeterInput Controller Class Description:
 * SpiroMeterInput Entity Non-GUI Controller class Copyright 2016 @Eclipse
 * Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */
public class SpiroMeterInputController implements Initializable {

	@FXML
	private TextField locationText;

	@FXML
	private TextField equipmentModelText;

	@FXML
	private Button equipmentModelBtn;

	@FXML
	private TextField serialNumberText;

	@FXML
	private DatePicker transDtDate;

	@FXML
	private TextField transTimeText;

	@FXML
	private TextField calibratedByText;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	private SpiroMeterViewController spiroMeterViewController;

	public void setSpiroMeterViewController(SpiroMeterViewController spiroMeterViewController) {
		this.spiroMeterViewController = spiroMeterViewController;
	}

	public void setEquipmentModel(String modelNo) {

		equipmentModelText.setText(modelNo);
	}

	FXMLFormPath formPath = new FXMLFormPath();

	public void setSpirometer(String equipmentModel) {
		equipmentModelText.setText(equipmentModel);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		equipmentModelBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewEquipmentModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewEquipmentModel", null, Locale.US);
				formPath.closeApplicationContext();
				EquipmentModelViewController equipmentViewController = (EquipmentModelViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				equipmentViewController.setSpiroMeterInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		okButton.setOnAction((event) -> {

			Spirometer spirometer = new Spirometer();

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

			new SpirometerEntityController().saveSpirometer(spirometer);
			// spiroMeterViewController.populateSpirometerTable(new
			// SpirometerEntityController().viewSpirometer());
			try {
				new FXFormCommonUtilities().closeForm(okButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
