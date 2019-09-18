package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CompanyOptionalProtocolActivityInputController implements Initializable {

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

	private CompanyProtocolEditController companyProtocolEditController;

	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}

	private MedicalActivity medicalActivity;

	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity = medicalActivity;
	}

	public void setMedicalActivityObject(MedicalActivity medicalActivity2) {

		activityLabel.setText(medicalActivity2.getDescrip());
		medicalActivity = medicalActivity2;
	}

	/*
	 * public Button button; public Integer optionalIndex; private Integer
	 * indexofstaticListEd=0; private CompanyOptionalProtocolActivity
	 * companyOptionalProtocolActivityEdit;
	 * 
	 * public void
	 * setCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity
	 * companyOptionalProtocolActivity ,Integer optionalIndex,Integer
	 * indexofstaticList) { this.companyOptionalProtocolActivityEdit =
	 * companyOptionalProtocolActivity;
	 * 
	 * this.optionalIndex = optionalIndex; this.indexofstaticListEd =
	 * indexofstaticList; medicalActivity =
	 * companyOptionalProtocolActivityEdit.getMedicalActivity();
	 * if(companyOptionalProtocolActivityEdit.getMedicalActivity()!=null){
	 * activityLabel.setText(companyOptionalProtocolActivityEdit.
	 * getMedicalActivity().getCode());
	 * }overridePayerTypeChoiceBox.setValue(companyOptionalProtocolActivityEdit.
	 * getOverridePayerType());
	 * overrideChargeText.setText(companyOptionalProtocolActivityEdit.
	 * getOverrideCharge());
	 * 
	 * if(companyOptionalProtocolActivityEdit.getNoCharge() == true){
	 * noChargeCheckBox.setSelected(true); }
	 * onlyUponAgeText.setText(companyOptionalProtocolActivityEdit.getUponAge())
	 * ;
	 * stopAtAgeText.setText(companyOptionalProtocolActivityEdit.getStopAge());
	 * onlyForSexChoiceBox.setValue(companyOptionalProtocolActivityEdit.
	 * getForSex());
	 * onlyForEthnicChoiceBox.setValue(companyOptionalProtocolActivityEdit.
	 * getEthnic());
	 * 
	 * }
	 * 
	 * public CompanyProtocolInputController companyProtocolInputController;
	 * 
	 * public void
	 * setCompanyProtocolInputController(CompanyProtocolInputController
	 * companyProtocolInputController) { this.companyProtocolInputController =
	 * companyProtocolInputController; }
	 */
	public static List<CompanyOptionalProtocolActivity> companyOptionalProtocolActivityList = new ArrayList<CompanyOptionalProtocolActivity>();

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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

				CompanyOptionalProtocolActivity optionalProtocolActivity = new CompanyOptionalProtocolActivity();
				/*
				 * if(companyOptionalProtocolActivityEdit!=null){
				 * optionalProtocolActivity=companyOptionalProtocolActivityEdit;
				 * 
				 * }
				 */
				if (medicalActivityViewController != null) {
					optionalProtocolActivity.setMedicalActivity(medicalActivity);
				} /*
					 * else if(companyProtocolInputController != null){
					 * //optionalProtocolActivity.setMedicalActivity(
					 * companyOptionalProtocolActivity.getMedicalActivity());
					 * optionalProtocolActivity.setMedicalActivity(
					 * medicalActivity); }
					 */

				optionalProtocolActivity.setEthnic(onlyForEthnicChoiceBox.getSelectionModel().getSelectedItem());
				optionalProtocolActivity.setForSex(onlyForSexChoiceBox.getSelectionModel().getSelectedItem());
				optionalProtocolActivity.setNoCharge(noChargeCheckBox.isSelected());
				optionalProtocolActivity.setOverrideCharge(overrideChargeText.getText());
				optionalProtocolActivity
						.setOverridePayerType(overridePayerTypeChoiceBox.getSelectionModel().getSelectedItem());
				optionalProtocolActivity.setStopAge(stopAtAgeText.getText());
				optionalProtocolActivity.setUponAge(onlyUponAgeText.getText());
				if (medicalActivity != null) {
					optionalProtocolActivity.setMedicalActivity(medicalActivity);
				}
				if (medicalActivityViewController.companyProtocolInputController != null
						|| (medicalActivityViewController.companyProtocolEditController != null
								? medicalActivityViewController.companyProtocolEditController.companyProtocol != null
										? (medicalActivityViewController.companyProtocolEditController.companyProtocol
												.getId() == null
												|| medicalActivityViewController.companyProtocolEditController.companyProtocol
														.getId() == 0)
										: false
								: false)) {

					companyOptionalProtocolActivityList.add(optionalProtocolActivity);

					if (medicalActivityViewController.companyProtocolInputController != null) {

						medicalActivityViewController.companyProtocolInputController
								.viewCompanyOptionalProtocolActivity();

					}
					if (medicalActivityViewController.companyProtocolEditController != null) {
						medicalActivityViewController.companyProtocolEditController.observableListOpt = FXCollections
								.observableArrayList();
						medicalActivityViewController.companyProtocolEditController.observableListOpt.addAll(
								CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);
						medicalActivityViewController.companyProtocolEditController
								.viewCompanyOptionalProtocolActivity();

					}

				} else {

					optionalProtocolActivity.setCompanyProtocol(CompanyProtocolEditController.companyProtocol);

					new CompanyOptionalProtocolActivityEntityController()
							.saveCompanyOptionalProtocolActivity(optionalProtocolActivity);

					medicalActivityViewController.companyProtocolEditController.observableListOpt = new CompanyOptionalProtocolActivityEntityController()
							.viewCompanyOptionalProtocolActivityByProtocolId(
									CompanyProtocolEditController.companyProtocol.getId());

					medicalActivityViewController.companyProtocolEditController.viewCompanyOptionalProtocolActivity();
				}

				/*
				 * if(companyProtocolInputController != null){
				 * if("optionalChangeBtn".equals(button.getId())){
				 * 
				 * companyOptionalProtocolActivityList.set(optionalIndex,
				 * optionalProtocolActivity); } }else{
				 * companyOptionalProtocolActivityList.add(
				 * optionalProtocolActivity); }
				 */ /*
					 * if(medicalActivityViewController!=null){
					 * if(medicalActivityViewController.
					 * companyProtocolEditController!=null?
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * encounterFormInputController!=null:false){
					 * System.out.println("****************  2");
					 * optionalProtocolActivity.setCompanyProtocol(
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * companyProtocolFromEncounter); new
					 * CompanyOptionalProtocolActivityEntityController().
					 * saveCompanyOptionalProtocolActivity(
					 * optionalProtocolActivity); System.out.println(
					 * "**************** saved   3");
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * viewCompanyOptionalProtocolActivity(); }
					 * if(medicalActivityViewController.
					 * companyProtocolEditController!=null?
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * companyProtocolViewController!=null?
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * companyProtocolViewController.
					 * encounterFormInputController!=null:false:false){
					 * System.out.println("****************  2");
					 * optionalProtocolActivity.setCompanyProtocol(
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * companyProtocolFromEncounter);
					 * if(medicalActivityViewController.
					 * companyProtocolEditController!=null?
					 * medicalActivityViewController.
					 * companyProtocolEditController.companyProtocol!=null:false
					 * ){ optionalProtocolActivity.setCompanyProtocol(
					 * medicalActivityViewController.
					 * companyProtocolEditController.companyProtocol); } new
					 * CompanyOptionalProtocolActivityEntityController().
					 * saveCompanyOptionalProtocolActivity(
					 * optionalProtocolActivity);
					 * System.out.println("%%%%%%%%%%%%"+
					 * CompanyOptionalProtocolActivityInputController.
					 * companyOptionalProtocolActivityList.size());
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * viewCompanyOptionalProtocolActivity(); } }
					 * 
					 * 
					 * if(companyProtocolEditController!=null){
					 * if(companyProtocolEditController.
					 * encounterFormInputController!=null){
					 * 
					 * System.out.println("****************  44");
					 * optionalProtocolActivity.setCompanyProtocol(
					 * companyProtocolEditController.
					 * companyProtocolFromEncounter); new
					 * CompanyOptionalProtocolActivityEntityController().
					 * saveCompanyOptionalProtocolActivity(
					 * optionalProtocolActivity); System.out.println(
					 * "**************** saved   55");
					 * companyProtocolEditController.
					 * viewCompanyOptionalProtocolActivity();
					 * 
					 * }else{
					 * if(companyOptionalProtocolActivityEdit.getCompanyProtocol
					 * ()!=null){ Alert alert = new
					 * Alert(AlertType.CONFIRMATION); alert.setTitle(
					 * "Action Required"); alert.setHeaderText("");
					 * alert.setContentText("Any Changes you made will be saved"
					 * );
					 * 
					 * Optional<ButtonType> result = alert.showAndWait(); if
					 * (result.get() == ButtonType.OK){ new
					 * CompanyOptionalProtocolActivityEntityController().
					 * saveCompanyOptionalProtocolActivity(
					 * optionalProtocolActivity);
					 * companyProtocolEditController.viewFromOptProtocolEdit(
					 * optionalProtocolActivity,optionalIndex); } else { // ...
					 * user chose CANCEL or closed the dialog }
					 * 
					 * 
					 * }else{
					 * 
					 * if(indexofstaticListEd!=-1){
					 * 
					 * companyOptionalProtocolActivityList.add(
					 * indexofstaticListEd, optionalProtocolActivity);
					 * 
					 * } companyProtocolEditController.viewFromOptProtocolEdit(
					 * optionalProtocolActivity,optionalIndex);
					 * 
					 * 
					 * } }
					 * 
					 * } else if(companyProtocolInputController!=null){
					 * 
					 * if(indexofstaticListEd!=-1){
					 * 
					 * companyOptionalProtocolActivityList.add(
					 * indexofstaticListEd, optionalProtocolActivity);
					 * 
					 * }companyProtocolInputController.viewFromOptProtocolEdit(
					 * optionalProtocolActivity, optionalIndex);
					 * 
					 * }else{ companyOptionalProtocolActivityList.add(
					 * optionalProtocolActivity);
					 * 
					 * }
					 * 
					 * if(medicalActivityViewController != null){
					 * if(medicalActivityViewController.
					 * companyProtocolInputController != null){
					 * 
					 * medicalActivityViewController.
					 * companyProtocolInputController.
					 * viewCompanyOptionalProtocolActivity();
					 * 
					 * }else if(medicalActivityViewController.
					 * companyProtocolEditController != null){
					 * 
					 * medicalActivityViewController.
					 * companyProtocolEditController.
					 * viewCompanyOptionalProtocolActivity();
					 * 
					 * }
					 * 
					 * }else if(companyProtocolInputController != null){
					 * 
					 * companyProtocolInputController.
					 * viewCompanyOptionalProtocolActivity(); }
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
				activityViewController.setCompanyOptionalProtocolActivityInputController(this);

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
