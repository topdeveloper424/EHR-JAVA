package com.ets.controller.gui.respiratorModel;

import java.net.URL;
import java.util.ResourceBundle;
import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.model.RespiratorModel;
import com.ets.utils.FXFormCommonUtilities;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelInputController Class
 *Description: Enter.fxml Controller class
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

public class RespiratorModelInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	private RespiratorModelViewController respiratorModelViewController;

	public void setRespiratorModelViewController(RespiratorModelViewController respiratorModelViewController) {
		this.respiratorModelViewController = respiratorModelViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okButton.setOnAction((event) -> {

			// Insert Data into Table

			try {

				RespiratorModel respiratorModel = new RespiratorModel();
				respiratorModel.setCode(this.codeTextField.getText());
				respiratorModel.setDescrp(this.descriptionTextField.getText());
				respiratorModel.setInactive(this.inactiveCheckBox.isSelected());

				new RespiratorModelEntityController().saveRespiratorModel(respiratorModel);
				respiratorModelViewController
						.populateRespiratorModelTable(new RespiratorModelEntityController().viewRespiratorModelList());
				
					new FXFormCommonUtilities().closeForm(okButton);

				

			} catch (Exception e) {
				e.printStackTrace();
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
