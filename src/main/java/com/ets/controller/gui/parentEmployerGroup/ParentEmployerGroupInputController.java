package com.ets.controller.gui.parentEmployerGroup;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.entity.parentEmployerGroup.ParentEmployerGroupEntityController;
import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.controller.gui.naicsCode.NaicsCodeViewController;
import com.ets.controller.gui.sicCode.SicCodeViewController;
import com.ets.model.Address;
import com.ets.model.NAICSCode;
import com.ets.model.ParentEmployerGroup;
import com.ets.model.SICCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 25-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupInputController Class
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

public class ParentEmployerGroupInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField localAddressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField contactTextField;

	@FXML
	private TextField extensionTextField;

	@FXML
	private TextField feinTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private ChoiceBox<String> countryComboBox;

	@FXML
	private TextField sourceFaxTextField;

	@FXML
	private TextField sicCodeTextField;

	@FXML
	private TextField naicsCodeTextField;

	@FXML
	private Button sicCodeButton;

	@FXML
	private Button naicsCodeButton;

	@FXML
	private TextField regionTextField;

	@FXML
	private TextField districtTextField;

	@FXML
	private TextField complexTextField;

	@FXML
	private Button regionButton;

	@FXML
	private Button districtButton;

	@FXML
	private Button complexButton;

	@FXML
	private CheckBox nationalPlayerOrganizationCheckBox;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	public void setNAICSCode(String naicsCode) {

		this.naicsCodeTextField.setText(naicsCode);
	}

	public void setSICCode(String sicCode) {

		this.sicCodeTextField.setText(sicCode);
	}

	private ParentEmployerGroupViewController parentEmployerGroupViewController;

	public void setParentEmployerGroupViewController(
			ParentEmployerGroupViewController parentEmployerGroupViewController) {
		this.parentEmployerGroupViewController = parentEmployerGroupViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		sicCodeButton.setOnAction((event) -> {
			try {
				// Load SIC Code Details Entry form .

				String formName = formPath.context.getMessage("SICCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SICCode", null, Locale.US);
				formPath.closeApplicationContext();
				SicCodeViewController sicCodeViewController = (SicCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				sicCodeViewController.setParentEmployerGroupInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		naicsCodeButton.setOnAction((event) -> {
			try {
				// Load NAICS Code Details Entry form .

				String formName = formPath.context.getMessage("NAICSCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.NAICSCode", null, Locale.US);
				formPath.closeApplicationContext();
				NaicsCodeViewController naicsCodeViewController = (NaicsCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				naicsCodeViewController.setParentEmployerGroupInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		okButton.setOnAction((event) -> {
			try {
				// Save Parent Employer Group Data.
				Address address = new Address();
				address.setCity(cityTextField.getText());
				address.setDistrict(districtTextField.getText());
				address.setEmail(emailTextField.getText());
				address.setExt(extensionTextField.getText());
				address.setFax(faxTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setSecureFax(sourceFaxTextField.getText());
				address.setState(stateTextField.getText());
				address.setZip(zipTextField.getText());

				new AddressEntityController().add(address);

				SICCode sicCode = new SicCodeEntityController().viewByCode(sicCodeTextField.getText());
				NAICSCode naicsCode = new NaicsCodeEntityController().viewByCode(naicsCodeTextField.getText());

				ParentEmployerGroup parentEmployerGroup = new ParentEmployerGroup();
				parentEmployerGroup.setCode(codeTextField.getText());
				parentEmployerGroup.setName(nameTextField.getText());
				parentEmployerGroup.setlocalAddress(localAddressTextField.getText());
				parentEmployerGroup.setContact(contactTextField.getText());
				parentEmployerGroup.setFein(feinTextField.getText());
				parentEmployerGroup.setInactive(inactiveCheckBox.isSelected());

				parentEmployerGroup.setAddress(address);
				parentEmployerGroup.setNaicsCode(naicsCode);
				parentEmployerGroup.setSicCode(sicCode);

				new ParentEmployerGroupEntityController().add(parentEmployerGroup);
				parentEmployerGroupViewController.viewParentEmployerGroup();

				try {
					new FXFormCommonUtilities().closeForm(okButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}