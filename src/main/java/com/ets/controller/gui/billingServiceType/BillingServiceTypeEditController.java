package com.ets.controller.gui.billingServiceType;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EditBillingServiceTypeGUIController Class
 *Description: EditBillingServiceType GUI Controller class
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

import com.ets.controller.entity.billingServiceType.BillingServiceTypeEntityController;
import com.ets.model.BillingServiceType;
import com.ets.utils.FXFormCommonUtilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BillingServiceTypeEditController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button closeButton;

	@FXML
	private Button updateButton;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private ChoiceBox<String> billingTypeComboBox;

	@FXML
	private TextField idTextField;

	private BillingServiceType billingServiceType;

	public void setBillingServiceType(BillingServiceType billingServiceType) {
		this.billingServiceType = billingServiceType;

		idTextField.setText(Integer.toString(billingServiceType.getId()));
		descriptionTextField.setText(billingServiceType.getDescrip());
		
		billingTypeComboBox.setValue(billingServiceType.getBilling_type());

		if (billingServiceType.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else if (billingServiceType.getInactive() == true) {
			inactiveCheckBox.setSelected(false);
		}

	}

	private BillingServiceTypeViewController billingServiceTypeViewController;

	public void setBillingServiceTypeViewController(BillingServiceTypeViewController billingServiceTypeViewController) {
		this.billingServiceTypeViewController = billingServiceTypeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<String> items = FXCollections.observableArrayList("No billing Override", "Employer Service");
		billingTypeComboBox.setItems(items);

		updateButton.setOnAction((event) -> {

			BillingServiceType billingServiceType = new BillingServiceType();

			billingServiceType.setId(Integer.parseInt(this.idTextField.getText()));
			billingServiceType.setDescrip(this.descriptionTextField.getText());
			billingServiceType.setBilling_type(this.billingTypeComboBox.getSelectionModel().getSelectedItem());
			billingServiceType.setInactive(this.inactiveCheckBox.isSelected());

			new BillingServiceTypeEntityController().updateBillingServiceType(billingServiceType);
			billingServiceTypeViewController
					.populateMedicalConditionTable(new BillingServiceTypeEntityController().viewBillingService());
			try {

				new FXFormCommonUtilities().closeForm(updateButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
