package com.ets.controller.gui.naicsCode;



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

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeEditController Class
 *Description: Edit.fxml Controller class
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

public class NaicsCodeEditController implements Initializable {

	@FXML
	private CheckBox inactive;

	@FXML
	private Button cancelBtn;

	@FXML
	private Button updateBtn;

	@FXML
	private TextField naicsCode;

	@FXML
	private TextField descrp;

	@FXML
	private TextField id;

	private NAICSCode nAICSCode;

	public void setnAICSCode(NAICSCode nAICSCode) {
		this.nAICSCode = nAICSCode;

		id.setText(Integer.toString(nAICSCode.getId()));
		naicsCode.setText(nAICSCode.getCode());
		descrp.setText(nAICSCode.getDescrp());

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateBtn.setOnAction((event) -> {

			NAICSCode naicsCode = new NAICSCode();

			naicsCode.setId(Integer.parseInt(this.id.getText()));
			naicsCode.setCode(this.naicsCode.getText());
			naicsCode.setDescrp(this.descrp.getText());

			new NaicsCodeEntityController().updateNAICSCode(naicsCode);
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
