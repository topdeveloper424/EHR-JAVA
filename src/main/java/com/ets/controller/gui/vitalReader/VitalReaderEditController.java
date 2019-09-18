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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class VitalReaderEditController implements Initializable {

	  @FXML
	    private TextField equipmentText;

	    @FXML
	    private TextField locationDescText;

	    @FXML
	    private TextField equipmentModelText;

	    @FXML
	    private TextField serialNumberText;

	    @FXML
	    private Button equipmentModelBtn;

	    @FXML
	    private DatePicker transDtDate;

	    @FXML
	    private TextField transTimeText;

	    @FXML
	    private TextField calibratedByText;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private Button updateBtn;

	    @FXML
	    private Button cancelBtn;
	    
	    private VitalReaderViewContoller vitalReaderViewController;
	    
	    
	    public void setVitalReaderViewController(VitalReaderViewContoller vitalReaderViewController) {
			this.vitalReaderViewController = vitalReaderViewController;
		}

	    public void setEquipmentModel(String modelNo) {

	    	equipmentModelText.setText(modelNo);
		}

		public void setVitalReader(String equipmentModel) {
			equipmentModelText.setText(equipmentModel);
		}
		
		FXMLFormPath formPath = new FXMLFormPath();

	    
	    private VitalReader vitalReader;
	    
	    
	public void setVitalReader(VitalReader vitalReader) {
			this.vitalReader = vitalReader;
		
//    transDtDate.set(vitalReader.getTransDt());
	locationDescText.setText(vitalReader.getLoc());
	transTimeText.setText(vitalReader.getTransTime());
	calibratedByText.setText(vitalReader.getCalibBy());
	serialNumberText.setText(vitalReader.getSerialNo());

	if (vitalReader.getInactive() == true) {
		inactiveCheckBox.setSelected(true);
	} else if (vitalReader.getInactive() == true) {
		inactiveCheckBox.setSelected(false);
	}
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
				equipmentViewController.setVitalReaderEditController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		updateBtn.setOnAction((event) -> {

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

			try {
				new FXFormCommonUtilities().closeForm(updateBtn);
			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelBtn.setOnAction((event) -> {
			// Cancel centralized Form
			try {
				new FXFormCommonUtilities().closeForm(cancelBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
