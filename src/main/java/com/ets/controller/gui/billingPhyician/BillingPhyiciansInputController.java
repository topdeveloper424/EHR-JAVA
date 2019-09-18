package com.ets.controller.gui.billingPhyician;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 10-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of BillingPhyiciansGUIController Class Description:
 * EnterBillingPhysicianProvider.fxml Controller class Copyright 2016 @Eclipse
 * Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class BillingPhyiciansInputController implements Initializable {

	@FXML
    private TextField codeTextField;

    @FXML
    private ChoiceBox<String> providerTypeChoiceBox;

    @FXML
    private TextField npiTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField middleNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField suffixTextField;

    @FXML
    private TextField listingNameTextField;

    @FXML
    private TextField localAddressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField telephoneTextField;

    @FXML
    private TextField externalCodeTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private TextField extensionTextField;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField faxTextField;

    @FXML
    private TextField federalIDTextField;

    @FXML
    private TextField licenseTextField;

    @FXML
    private TextField deaTextField;

    @FXML
    private TextField credencialTextField;

    @FXML
    private TextField medicalGroupTextField;

    @FXML
    private TextField licStateTextField;

    @FXML
    private TextField classTextField;

    @FXML
    private TextField termTextField;

    @FXML
    private TextField specialityTextField;

    @FXML
    private Button medicalGroupBtn;

    @FXML
    private Button salesReportBtn;

    @FXML
    private Button addAccountPinBtn;

    @FXML
    private Button okBotton;

    @FXML
    private Button cancelBtn;

    @FXML
    private CheckBox inactiveCheckBox;

    @FXML
    private TextField providerTextField;

    @FXML
    private Button providerBtn;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> list = new ArrayList<String>();

		list.add("Phisicians");
		list.add("PT/Rehab");
		list.add("Group");
		list.add("Other");

		ObservableList obList = FXCollections.observableList(list);
		providerTypeChoiceBox.getItems().clear();
		providerTypeChoiceBox.setItems(obList);

		List<String> list2 = new ArrayList<String>();

		list2.add("USA");
		list2.add("Canada");
		list2.add("Mexico");

		ObservableList obList2 = FXCollections.observableList(list2);
		countryChoiceBox.getItems().clear();
		countryChoiceBox.setItems(obList2);
		
		medicalGroupBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("MedicalGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalGroup", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		salesReportBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SalesRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SalesRepresentative", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		providerBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addAccountPinBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Account", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Account", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

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
