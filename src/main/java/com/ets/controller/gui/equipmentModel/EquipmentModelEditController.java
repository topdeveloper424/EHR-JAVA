package com.ets.controller.gui.equipmentModel;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.equipmentModel.EquipmentModelEntityController;
import com.ets.model.EquipmentModel;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class EquipmentModelEditController implements Initializable {
	
	@FXML
    private TextField modelText;

    @FXML
    private TextField descText;

    @FXML
    private CheckBox dataTransferCheckBox;

    @FXML
    private CheckBox dataImportCheckBox;

    @FXML
    private CheckBox supportsUSBCheckBox;

    @FXML
    private RadioButton RadioBtn300;

    @FXML
    private ToggleGroup baudRate;

    @FXML
    private RadioButton RadioBtn600;

    @FXML
    private RadioButton RadioBtn1200;

    @FXML
    private RadioButton RadioBtn2400;

    @FXML
    private RadioButton RadioBtn4800;

    @FXML
    private RadioButton RadioBtn9600;

    @FXML
    private RadioButton RadioBtn19200;

    @FXML
    private RadioButton RadioBtn38400;

    @FXML
    private RadioButton RadioBtn57600;

    @FXML
    private RadioButton RadioBtn115200;

    @FXML
    private RadioButton noneRadioBtn;

    @FXML
    private ToggleGroup parity;

    @FXML
    private RadioButton oddRadioBtn;

    @FXML
    private RadioButton evenRadioBtn;

    @FXML
    private RadioButton RadioBtn7;

    @FXML
    private ToggleGroup dataBits;

    @FXML
    private RadioButton RadioBtn8;

    @FXML
    private RadioButton RadioBtn1;

    @FXML
    private ToggleGroup stopBits;

    @FXML
    private RadioButton RadioBtn2;

    @FXML
    private TextField idText;

    @FXML
    private Button updateBtn;

    @FXML
    private Button cancelbtn;
	
	private EquipmentModelViewController equipmentModelViewController;
		
	public void setEquipmentModelViewController(EquipmentModelViewController equipmentModelViewController) {
		this.equipmentModelViewController = equipmentModelViewController;
	}


	private EquipmentModel equipmentModel;
	
	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
		
		idText.setText(Integer.toString(equipmentModel.getId()));
		//baudRate.setText(equipmentModel.get);
		if(equipmentModel.getBaudRate().equals("300")){
						
			RadioBtn300.setSelected(true);
		}else if (equipmentModel.getBaudRate().equals("600")) {
			
			RadioBtn600.setSelected(true);
			
		}else if (equipmentModel.getBaudRate().equals("1200")) {
			
			RadioBtn1200.setSelected(true);
			
		}
else if (equipmentModel.getBaudRate().equals("2400")) {
			
			RadioBtn2400.setSelected(true);
			
		}
else if (equipmentModel.getBaudRate().equals("4800")) {
	
	RadioBtn4800.setSelected(true);
	
}
else if (equipmentModel.getBaudRate().equals("9600")) {
	
	RadioBtn9600.setSelected(true);
	
}
else if (equipmentModel.getBaudRate().equals("19200")) {
	
	RadioBtn19200.setSelected(true);
	
}
else if (equipmentModel.getBaudRate().equals("38400")) {
	
	RadioBtn38400.setSelected(true);
	
}
else if (equipmentModel.getBaudRate().equals("57600")) {
	
	RadioBtn57600.setSelected(true);
	
}
else if (equipmentModel.getBaudRate().equals("115200")) {
	
	RadioBtn115200.setSelected(true);
	
}
	
		if(equipmentModel.getDataBit().equals("300")){
			
			RadioBtn300.setSelected(true);
			
		}else if (equipmentModel.getBaudRate().equals("600")) {
			
			RadioBtn600.setSelected(true);
			
		}else if (equipmentModel.getBaudRate().equals("1200")) {
			
			RadioBtn1200.setSelected(true);
			
		}
		
		
		if (equipmentModel.getCanImportData() == true) {
			dataImportCheckBox.setSelected(true);
		} else if (equipmentModel.getCanImportData() == true) {
			dataImportCheckBox.setSelected(false);
		}
		
		if (equipmentModel.getCanTransferdata() == true) {
			dataTransferCheckBox.setSelected(true);
		} else if (equipmentModel.getCanTransferdata() == true) {
			dataTransferCheckBox.setSelected(false);
		}
		
		
		//dataBits.setText(equipmentModel);
		descText.setText(equipmentModel.getDescrp());
		modelText.setText(equipmentModel.getModelNo());
		//parity.setText(equipmentModel);
		//stopBits.setText(equipmentModel);
		
		if (equipmentModel.getSupportUsbConn() == true) {
			supportsUSBCheckBox.setSelected(true);
		} else if (equipmentModel.getSupportUsbConn() == true) {
			supportsUSBCheckBox.setSelected(false);
		}
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
updateBtn.setOnAction((event) -> {
			
			String baudRate = null;
			
			if(RadioBtn300.isSelected()){
				
				baudRate = "300";
				
			}else if (RadioBtn600.isSelected()) {
				
				baudRate = "600";
				
			}else if (RadioBtn1200.isSelected()) {
				
				baudRate = "1200";
				
			}else if (RadioBtn2400.isSelected()) {
				
				baudRate = "2400";
				
			}else if (RadioBtn4800.isSelected()) {
				
				baudRate = "4800";
				
			}else if (RadioBtn9600.isSelected()) {
				
				baudRate = "9600";
				
			}else if (RadioBtn19200.isSelected()) {
				
				baudRate = "19200";
				
			}else if (RadioBtn38400.isSelected()) {
				
				baudRate = "38400";
				
			}else if (RadioBtn57600.isSelected()) {
				
				baudRate = "57600";
				
			}else if (RadioBtn115200.isSelected()) {
				
				baudRate = "115200";
			}
			
			String parity = null;
			
			if(noneRadioBtn.isSelected()){
				
				parity = "NONE";
				
			}else if (oddRadioBtn.isSelected()) {
				
				parity = "ODD";
				
			}else if (evenRadioBtn.isSelected()) {
				
				parity = "EVEN";
				
			}
			
			String dataBits = null;
			
			if(RadioBtn7.isSelected()){
				
				dataBits = "7";
				
			}else if (RadioBtn8.isSelected()) {
				
				dataBits = "8";
				
			}
			
			String stopBits = null;
			
			if(RadioBtn1.isSelected()){
				
				stopBits = "1";
				
			}else if (RadioBtn2.isSelected()) {
				
				stopBits = "2";
				
			}
			
			
			try {
				
				EquipmentModel equipmentModel = new EquipmentModel();
				
				equipmentModel.setId(Integer.parseInt(idText.getText()));
				equipmentModel.setBaudRate(baudRate);
				equipmentModel.setCanImportData(dataImportCheckBox.isSelected());
				equipmentModel.setCanTransferdata(dataTransferCheckBox.isSelected());
				equipmentModel.setDataBit(dataBits);
				equipmentModel.setDescrp(descText.getText());
				equipmentModel.setModelNo(modelText.getText());
				equipmentModel.setParity(parity);
				equipmentModel.setStopBit(stopBits);
				equipmentModel.setSupportUsbConn(supportsUSBCheckBox.isSelected());
				
				new EquipmentModelEntityController().save(equipmentModel);
				
				new FXFormCommonUtilities().closeForm(updateBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelbtn.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelbtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
