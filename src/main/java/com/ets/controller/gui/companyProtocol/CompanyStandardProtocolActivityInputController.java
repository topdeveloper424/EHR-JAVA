package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Contact;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CompanyStandardProtocolActivityInputController implements Initializable {

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
	/*
	 * private CompanyProtocolEditController companyProtocolEditController;
	 * 
	 * public void
	 * setCompanyProtocolEditController(CompanyProtocolEditController
	 * companyProtocolEditController) { this.companyProtocolEditController =
	 * companyProtocolEditController; }
	 */

	/*
	 * public Button button; public Integer standardIndex;
	 *//*
		 * public CompanyStandardProtocolActivity
		 * companyStandardProtocolActivityEdit; private Integer standardIndex=0;
		 * private Integer indexofstaticListEd=0; public void
		 * setCompanyStandardProtocolActivity(CompanyStandardProtocolActivity
		 * companyStandardProtocolActivity,Integer standardIndex,Integer
		 * indexofstaticList) { this.companyStandardProtocolActivityEdit =
		 * companyStandardProtocolActivity; this.indexofstaticListEd =
		 * indexofstaticList; this.button = button; this.standardIndex =
		 * standardIndex;
		 * 
		 * this.standardIndex = standardIndex; medicalActivity =
		 * companyStandardProtocolActivityEdit.getMedicalActivity();
		 * if(companyStandardProtocolActivityEdit.getMedicalActivity()!=null){
		 * activityLabel.setText(companyStandardProtocolActivityEdit.
		 * getMedicalActivity().getCode()); }
		 * overridePayerTypeChoiceBox.setValue(
		 * companyStandardProtocolActivityEdit.getOverridePayerType());
		 * overrideChargeText.setText(companyStandardProtocolActivityEdit.
		 * getOverrideCharge());
		 * 
		 * if(companyStandardProtocolActivityEdit.getNoCharge() == true){
		 * noChargeCheckBox.setSelected(true); }
		 * onlyUponAgeText.setText(companyStandardProtocolActivityEdit.
		 * getUponAge());
		 * stopAtAgeText.setText(companyStandardProtocolActivityEdit.getStopAge(
		 * )); onlyForSexChoiceBox.setValue(companyStandardProtocolActivityEdit.
		 * getForSex());
		 * onlyForEthnicChoiceBox.setValue(companyStandardProtocolActivityEdit.
		 * getEthnic());
		 * 
		 * }
		 */

	/*
	 * public CompanyProtocolInputController companyProtocolInputController;
	 * 
	 * public void
	 * setCompanyProtocolInputController(CompanyProtocolInputController
	 * companyProtocolInputController) { this.companyProtocolInputController =
	 * companyProtocolInputController;
	 * 
	 * }
	 */

	public static List<CompanyStandardProtocolActivity> companyStandardProtocolActivityList = new ArrayList<CompanyStandardProtocolActivity>();

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

				// CompanyStandardProtocolActivity
				// companyStandardProtocolActivity = new
				// CompanyStandardProtocolActivity();

				CompanyStandardProtocolActivity standardProtocolActivity = new CompanyStandardProtocolActivity();
				/*
				 * if(companyStandardProtocolActivityEdit!=null){
				 * standardProtocolActivity=companyStandardProtocolActivityEdit;
				 * 
				 * }
				 */

				if (medicalActivityViewController != null) {

					standardProtocolActivity.setMedicalActivity(medicalActivity);

				} /*
					 * else if(companyProtocolInputController != null){
					 * System.out.println(
					 * "Cmpany Protocol Input Controller Call ############################"
					 * ); //standardProtocolActivity.setMedicalActivity(
					 * companyStandardProtocolActivity.getMedicalActivity());
					 * standardProtocolActivity.setMedicalActivity(
					 * medicalActivity); }
					 */

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

				if (medicalActivityViewController.companyProtocolInputController != null
						|| (medicalActivityViewController.companyProtocolEditController != null
								? medicalActivityViewController.companyProtocolEditController.companyProtocol != null
										? (medicalActivityViewController.companyProtocolEditController.companyProtocol
												.getId() == null
												|| medicalActivityViewController.companyProtocolEditController.companyProtocol
														.getId() == 0)
										: false
								: false)) {

					companyStandardProtocolActivityList.add(standardProtocolActivity);

					if (medicalActivityViewController.companyProtocolInputController != null) {

						medicalActivityViewController.companyProtocolInputController
								.viewCompanyStandardProtocolActivity();

					}
					if (medicalActivityViewController.companyProtocolEditController != null) {
						medicalActivityViewController.companyProtocolEditController.observableListStd = FXCollections
								.observableArrayList();
						medicalActivityViewController.companyProtocolEditController.observableListStd.addAll(
								CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList);
						medicalActivityViewController.companyProtocolEditController
								.viewCompanyStandardProtocolActivity();

					}

				} else {

					standardProtocolActivity.setCompanyProtocol(CompanyProtocolEditController.companyProtocol);

					new CompanyStandardProtocolActivityEntityController()
							.saveCompanyStandardProtocolActivity(standardProtocolActivity);

					medicalActivityViewController.companyProtocolEditController.observableListStd = new CompanyStandardProtocolActivityEntityController()
							.viewCompanyStandardProtocolActivityByProtocolId(
									CompanyProtocolEditController.companyProtocol.getId());

					medicalActivityViewController.companyProtocolEditController.viewCompanyStandardProtocolActivity();

				}

				/*
				 * if(medicalActivityViewController!=null?
				 * medicalActivityViewController.companyProtocolEditController!=
				 * null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocol!=null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocol.getId()!=null
				 * ||medicalActivityViewController.companyProtocolEditController
				 * .companyProtocol.getId()!=0:false:false:false){
				 * 
				 * 
				 * 
				 * 
				 * }
				 */

				/*
				 * else{//from protocol edit
				 * standardProtocolActivity.setCompanyProtocol(
				 * CompanyProtocolEditController.companyProtocol);
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

				// System.out.println("Medical Code id is ---- "
				// +medicalActivity.getDescrip());
				/*
				 * if(companyStandardProtocolActivity != null){
				 * 
				 * companyStandardProtocolActivityList.set(standardIndex,
				 * standardProtocolActivity);
				 * 
				 * }else{ companyStandardProtocolActivityList.add(
				 * standardProtocolActivity); }
				 */

				// companyStandardProtocolActivityList.add(standardProtocolActivity);
				/*
				 * if(medicalActivityViewController!=null){
				 * if(medicalActivityViewController.
				 * companyProtocolEditController!=null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * encounterFormInputController!=null:false){
				 * System.out.println("****************  encounter  2");
				 * standardProtocolActivity.setCompanyProtocol(
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocolFromEncounter); new
				 * CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ; System.out.println("**************** encounter saved   3");
				 * medicalActivityViewController.companyProtocolEditController.
				 * viewCompanyStandardProtocolActivity(); }
				 * if(medicalActivityViewController.
				 * companyProtocolEditController!=null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocolViewController!=null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocolViewController.encounterFormInputController!=
				 * null:false:false){ System.out.println("****************  2");
				 * standardProtocolActivity.setCompanyProtocol(
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocolFromEncounter);
				 * if(medicalActivityViewController.
				 * companyProtocolEditController!=null?
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocol!=null:false){
				 * standardProtocolActivity.setCompanyProtocol(
				 * medicalActivityViewController.companyProtocolEditController.
				 * companyProtocol); } new
				 * CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ; System.out.println("%%%%%%%%%%%%"+
				 * CompanyStandardProtocolActivityInputController.
				 * companyStandardProtocolActivityList.size());
				 * medicalActivityViewController.companyProtocolEditController.
				 * viewCompanyStandardProtocolActivity(); }
				 * 
				 * }
				 * 
				 * 
				 * if(companyProtocolEditController!=null){
				 * if(companyProtocolEditController.encounterFormInputController
				 * !=null){
				 * 
				 * System.out.println("****************  44");
				 * standardProtocolActivity.setCompanyProtocol(
				 * companyProtocolEditController.companyProtocolFromEncounter);
				 * new CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ; System.out.println("**************** saved   55");
				 * companyProtocolEditController.
				 * viewCompanyStandardProtocolActivity();
				 * 
				 * }else{
				 * 
				 * if(companyStandardProtocolActivityEdit.getCompanyProtocol()!=
				 * null){
				 * 
				 * Alert alert = new Alert(AlertType.CONFIRMATION);
				 * alert.setTitle("Action Required"); alert.setHeaderText("");
				 * alert.setContentText("Any Changes you made will be saved");
				 * 
				 * Optional<ButtonType> result = alert.showAndWait(); if
				 * (result.get() == ButtonType.OK){ new
				 * CompanyStandardProtocolActivityEntityController().
				 * saveCompanyStandardProtocolActivity(standardProtocolActivity)
				 * ; companyProtocolEditController.viewFromStdProtocolEdit(
				 * standardProtocolActivity,standardIndex); } else { // ... user
				 * chose CANCEL or closed the dialog }
				 * 
				 * }else{ System.out.println("######### "+indexofstaticListEd);
				 * if(indexofstaticListEd!=-1){ System.out.println(
				 * "################ "+standardIndex);
				 * companyStandardProtocolActivityList.add(indexofstaticListEd,
				 * standardProtocolActivity);
				 * 
				 * } companyProtocolEditController.viewFromStdProtocolEdit(
				 * standardProtocolActivity,standardIndex);
				 * 
				 * 
				 * }
				 * 
				 * } } else if(companyProtocolInputController!=null){
				 * 
				 * if(indexofstaticListEd!=-1){ System.out.println(
				 * "################ "+standardIndex);
				 * companyStandardProtocolActivityList.add(indexofstaticListEd,
				 * standardProtocolActivity);
				 * 
				 * }companyProtocolInputController.viewFromStdProtocolEdit(
				 * standardProtocolActivity, standardIndex);
				 * 
				 * }else{ companyStandardProtocolActivityList.add(
				 * standardProtocolActivity);
				 * 
				 * }
				 * 
				 * 
				 * if(medicalActivityViewController != null){
				 * 
				 * if(medicalActivityViewController.
				 * companyProtocolInputController != null){
				 * 
				 * medicalActivityViewController.companyProtocolInputController.
				 * viewCompanyStandardProtocolActivity();
				 * 
				 * }else if(medicalActivityViewController.
				 * companyProtocolEditController != null){
				 * 
				 * medicalActivityViewController.companyProtocolEditController.
				 * viewCompanyStandardProtocolActivity();
				 * 
				 * }
				 * 
				 * }else if(companyProtocolInputController != null){
				 * 
				 * companyProtocolInputController.
				 * viewCompanyStandardProtocolActivity(); }
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
				activityViewController.setCompanyStandardProtocolActivityInputController(this);

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
