package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CompanyStandardProtocolActivityEditController implements Initializable {
	@FXML
	private Button cancelBtn;

	@FXML
	private Button okBtn;

	@FXML
	private Button activitySearchBtn;

	@FXML
	private Label activityLabel;

	@FXML
	private ChoiceBox<String> overridePayerTypeChoiceBox;

	@FXML
	private TextField overrideChargeText;

	@FXML
	private CheckBox noChargeCheckBox;

	@FXML
	private TextField onlyUponAgeText;

	@FXML
	private ChoiceBox<String> onlyForSexChoiceBox;

	@FXML
	private TextField stopAtAgeText;

	@FXML
	private ChoiceBox<String> onlyForEthnicChoiceBox;

	public MedicalActivityViewController medicalActivityViewController;

	public void setMedicalActivityViewController(MedicalActivityViewController medicalActivityViewController) {
		this.medicalActivityViewController = medicalActivityViewController;
	}

	public MedicalActivity medicalActivity;

	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity = medicalActivity;
	}

	public void setMedicalActivityObject(MedicalActivity medicalActivity2) {

		activityLabel.setText(medicalActivity2.getDescrip());
		medicalActivity = medicalActivity2;

	}

	private CompanyProtocolInputController companyProtocolInputController;

	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
		this.companyProtocolInputController = companyProtocolInputController;
	}

	private CompanyProtocolEditController companyProtocolEditController;

	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}

	private CompanyStandardProtocolActivity companyStandardProtocolActivity;
	private Integer standardProtocolTableIndex;

	public void setCompanyStandardProtocolActivity(CompanyStandardProtocolActivity companyStandardProtocolActivity,
			Integer standardProtocolTableIndex) {
		this.companyStandardProtocolActivity = companyStandardProtocolActivity;
		this.standardProtocolTableIndex = standardProtocolTableIndex;

		medicalActivity = companyStandardProtocolActivity.getMedicalActivity();
		if (companyStandardProtocolActivity.getMedicalActivity() != null) {
			activityLabel.setText(companyStandardProtocolActivity.getMedicalActivity().getCode());
		}
		overridePayerTypeChoiceBox.setValue(companyStandardProtocolActivity.getOverridePayerType());
		overrideChargeText.setText(companyStandardProtocolActivity.getOverrideCharge());

		if (companyStandardProtocolActivity.getNoCharge() == true) {
			noChargeCheckBox.setSelected(true);
		}
		onlyUponAgeText.setText(companyStandardProtocolActivity.getUponAge());
		stopAtAgeText.setText(companyStandardProtocolActivity.getStopAge());
		onlyForSexChoiceBox.setValue(companyStandardProtocolActivity.getForSex());
		onlyForEthnicChoiceBox.setValue(companyStandardProtocolActivity.getEthnic());

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<String>();

		list1.add("Default");
		list1.add("Employer");
		list1.add("Patient");

		ObservableList payerTypeList = FXCollections.observableList(list1);
		overridePayerTypeChoiceBox.getItems().clear();
		overridePayerTypeChoiceBox.setItems(payerTypeList);

		List<String> list2 = new ArrayList<String>();

		list2.add("Male");
		list2.add("Female");

		ObservableList forSexList = FXCollections.observableList(list2);
		onlyForSexChoiceBox.getItems().clear();
		onlyForSexChoiceBox.setItems(forSexList);

		List<String> list3 = new ArrayList<String>();

		list3.add("Asian");
		list3.add("Black");
		list3.add("Caucasian");
		list3.add("Hispanic");

		ObservableList ethnicList = FXCollections.observableList(list3);
		onlyForEthnicChoiceBox.getItems().clear();
		onlyForEthnicChoiceBox.setItems(ethnicList);
		okBtn.setOnAction((event) -> {
			try {
				CompanyStandardProtocolActivity standardProtocolActivity = new CompanyStandardProtocolActivity();
				/*
				 * if(companyStandardProtocolActivityEdit!=null){
				 * standardProtocolActivity=companyStandardProtocolActivityEdit;
				 * 
				 * }
				 */

				if (medicalActivityViewController != null) {

					standardProtocolActivity.setMedicalActivity(medicalActivity);

				}

				standardProtocolActivity.setEthnic(onlyForEthnicChoiceBox.getSelectionModel().getSelectedItem());
				standardProtocolActivity.setForSex(onlyForSexChoiceBox.getSelectionModel().getSelectedItem());
				standardProtocolActivity.setNoCharge(noChargeCheckBox.isSelected());
				standardProtocolActivity.setOverrideCharge(overrideChargeText.getText());
				standardProtocolActivity
						.setOverridePayerType(overridePayerTypeChoiceBox.getSelectionModel().getSelectedItem());
				standardProtocolActivity.setStopAge(stopAtAgeText.getText());
				standardProtocolActivity.setUponAge(onlyUponAgeText.getText());
				standardProtocolActivity.setInactive(false);
				if (medicalActivity != null) {
					standardProtocolActivity.setMedicalActivity(medicalActivity);

				}

				/*
				 * if(companyProtocolInputController!=null){
				 * 
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.set(
				 * standardProtocolTableIndex, standardProtocolActivity);
				 * companyProtocolInputController.
				 * viewCompanyStandardProtocolActivity();
				 * 
				 * }
				 */

				if ((companyProtocolInputController != null) || (companyProtocolEditController != null
						? companyProtocolEditController.companyProtocol != null
								? (companyProtocolEditController.companyProtocol.getId() == null
										|| companyProtocolEditController.companyProtocol.getId() == 0)
								: false
						: false)) {

					CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList
							.set(standardProtocolTableIndex, standardProtocolActivity);

					if (companyProtocolInputController != null) {

						companyProtocolInputController.viewCompanyStandardProtocolActivity();

					}
					if (companyProtocolEditController != null) {
						companyProtocolEditController.observableListStd = FXCollections.observableArrayList();
						companyProtocolEditController.observableListStd.addAll(
								CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);
						companyProtocolEditController.viewCompanyStandardProtocolActivity();

					}

				}

				else {

					standardProtocolActivity.setCompanyProtocol(CompanyProtocolEditController.companyProtocol);
					standardProtocolActivity.setId(companyStandardProtocolActivity.getId());

					new CompanyStandardProtocolActivityEntityController()
							.saveCompanyStandardProtocolActivity(standardProtocolActivity);
					companyProtocolEditController.observableListStd = new CompanyStandardProtocolActivityEntityController()
							.viewCompanyStandardProtocolActivityByProtocolId(
									CompanyProtocolEditController.companyProtocol.getId());

					companyProtocolEditController.viewCompanyStandardProtocolActivity();
				}

				/*
				 * if(companyProtocolEditController!=null){
				 * 
				 * if(CompanyProtocolViewController.company==null){
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.set(
				 * standardProtocolTableIndex,standardProtocolActivity);
				 * companyProtocolInputController.
				 * viewCompanyStandardProtocolActivity(); }else{
				 * 
				 * standardProtocolActivity.setCompanyProtocol(
				 * CompanyProtocolEditController.companyProtocol);
				 * standardProtocolActivity.setId(
				 * companyStandardProtocolActivity.getId());
				 * 
				 * new CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ;
				 * 
				 * medicalActivityViewController.companyProtocolEditController.
				 * observableListStd= new
				 * CompanyStandardProtocolActivityEntityController().
				 * viewCompanyStandardProtocolActivityByProtocolId(
				 * CompanyProtocolEditController.companyProtocol.getId());
				 * 
				 * medicalActivityViewController.companyProtocolEditController.
				 * viewCompanyStandardProtocolActivity();
				 * 
				 * 
				 * }
				 */

				new FXFormCommonUtilities().closeForm(okBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		activitySearchBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController activityViewController = (MedicalActivityViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				activityViewController.setCompanyStandardProtocolActivityEditController(this);

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
