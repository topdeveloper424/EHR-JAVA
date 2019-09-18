package com.ets.controller.gui.respiratorModel;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.model.RespiratorModel;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelEditController Class
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

public class RespiratorModelEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button cancelButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField idTextField;

	@FXML
	void doubleClicked(MouseEvent event) {

	}

	private RespiratorModel respiratorModel;

	public void setRespiratorModel(RespiratorModel respiratorModel) {
		this.respiratorModel = respiratorModel;

		idTextField.setText(Integer.toString(respiratorModel.getId()));
		codeTextField.setText(respiratorModel.getCode());
		descriptionTextField.setText(respiratorModel.getDescrp());

		if (respiratorModel.getInactive() == true) {

			inactiveCheckBox.setSelected(true);
		} else {

			inactiveCheckBox.setSelected(false);
		}
	}

	private RespiratorModelViewController respiratorModelViewController;

	public void setRespiratorModelViewController(RespiratorModelViewController respiratorModelViewController) {
		this.respiratorModelViewController = respiratorModelViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {

			// Update Data into Table
			try {

				RespiratorModel respiratorModel = new RespiratorModel();

				respiratorModel.setId(Integer.parseInt(idTextField.getText()));
				respiratorModel.setCode(this.codeTextField.getText());
				respiratorModel.setDescrp(this.descriptionTextField.getText());
				respiratorModel.setInactive(this.inactiveCheckBox.isSelected());

				new RespiratorModelEntityController().saveRespiratorModel(respiratorModel);
				respiratorModelViewController
						.populateRespiratorModelTable(new RespiratorModelEntityController().viewRespiratorModelList());
				try {
					new FXFormCommonUtilities().closeForm(updateButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

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
