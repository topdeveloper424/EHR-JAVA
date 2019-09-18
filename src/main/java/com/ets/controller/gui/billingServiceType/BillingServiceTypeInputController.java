package com.ets.controller.gui.billingServiceType;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client
 * Company File Creation Date: 06-02-2016 
 * Initial Version: 0.01 
 * Module Name:
 * Parameter Definition: Type object of BillingServiceTypeInputController Class
 * Description: Enter.fxml Controller class 
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: Sumanta Deyashi 
 * Date: 23-02-2016 
 * Version: 
 * Description:
 * Backup Location for Previous Version:
 *
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 */

public class BillingServiceTypeInputController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button closeButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private ComboBox<String> billingTypeComboBox;

	private BillingServiceTypeViewController billingServiceTypeViewController;

	public void setBillingServiceTypeViewController(BillingServiceTypeViewController billingServiceTypeViewController) {
		this.billingServiceTypeViewController = billingServiceTypeViewController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<String> items = FXCollections.observableArrayList("No billing Override", "Employer Service");
		billingTypeComboBox.setItems(items);
		billingTypeComboBox.setValue("Select Billing Type");

		okButton.setOnAction((event) -> {

			BillingServiceType billingServiceType = new BillingServiceType();
			billingServiceType.setDescrip(this.descriptionTextField.getText());
			billingServiceType.setBilling_type(this.billingTypeComboBox.getSelectionModel().getSelectedItem());
			billingServiceType.setInactive(this.inactiveCheckBox.isSelected());

			new BillingServiceTypeEntityController().saveBillingService(billingServiceType);
			billingServiceTypeViewController
					.populateMedicalConditionTable(new BillingServiceTypeEntityController().viewBillingService());
			
				new FXFormCommonUtilities().closeForm(okButton);
			
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
