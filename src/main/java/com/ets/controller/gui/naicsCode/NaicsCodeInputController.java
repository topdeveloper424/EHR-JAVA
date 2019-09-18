package com.ets.controller.gui.naicsCode;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsGUIController Class
 *Description: EnterNaicsCode.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.model.NAICSCode;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class NaicsCodeInputController implements Initializable {

	@FXML
	private TextField naicsCode;

	@FXML
	private TextField description;

	@FXML
	private Button okBtn;

	@FXML
	private Button cancelBtn;

	private NaicsCodeViewController naicsCodeViewController;

	public void setNaicsCodeViewController(NaicsCodeViewController naicsCodeViewController) {
		this.naicsCodeViewController = naicsCodeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okBtn.setOnAction((event) -> {

			NAICSCode naicsCode = new NAICSCode();
			naicsCode.setCode(this.naicsCode.getText());
			naicsCode.setDescrp(this.description.getText());
			new NaicsCodeEntityController().saveNaicsCode(naicsCode);

			try {
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
