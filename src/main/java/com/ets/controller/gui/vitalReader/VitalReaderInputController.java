package com.ets.controller.gui.vitalReader;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.vitalReader.VitalReaderEntityController;
import com.ets.controller.gui.equipmentModel.EquipmentModelViewController;
import com.ets.model.VitalReader;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class VitalReaderInputController implements Initializable {

	@FXML
	private TextField locationDescText;

	@FXML
	private TextField modelText;

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
	private Button equipmentModelBtn;

	@FXML
	private Button ok;

	@FXML
	private Button close;

	private VitalReaderViewContoller vitalReaderViewController;
	
	public void setVitalReaderViewController(VitalReaderViewContoller vitalReaderViewController) {
		this.vitalReaderViewController = vitalReaderViewController;
	}

	public void setEquipmentModel(String modelNo) {

		modelText.setText(modelNo);
	}

	public void setVitalReader(String equipmentModel) {
		modelText.setText(equipmentModel);
	}
	
	FXMLFormPath formPath = new FXMLFormPath();


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		equipmentModelBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewEquipmentModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewEquipmentModel", null, Locale.US);
				formPath.closeApplicationContext();
				EquipmentModelViewController equipmentViewController = (EquipmentModelViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				equipmentViewController.setVitalReaderInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		ok.setOnAction((event) -> {

			VitalReader vitalReader = new VitalReader();

			vitalReader.setLoc(this.locationDescText.getText());

			vitalReader.setSerialNo(this.serialNumberText.getText());

			LocalDate localDate2 = transDtDate.getValue();
			if (localDate2 != null) {

				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				vitalReader.setTransDt(date2);

			}

			vitalReader.setTransTime(this.transTimeText.getText());
			vitalReader.setCalibBy(this.calibratedByText.getText());

			vitalReader.setInactive(this.inactiveCheckBox.isSelected());

			new VitalReaderEntityController().saveOrUpdate(vitalReader);
			try {
				new FXFormCommonUtilities().closeForm(ok);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

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
