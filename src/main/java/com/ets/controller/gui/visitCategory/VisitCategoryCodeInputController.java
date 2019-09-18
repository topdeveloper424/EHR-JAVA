package com.ets.controller.gui.visitCategory;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterVisitCategoryCodeController Class
 *Description: EnterVisitCategoryCodeController.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.billingServiceType.BillingServiceTypeEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;
import com.ets.controller.entity.visitCategoryGroup.VisitCategoryGroupEntityController;
import com.ets.controller.gui.billingServiceType.BillingServiceTypeViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BillingServiceType;
import com.ets.model.VisitCategory;
import com.ets.model.VisitCategoryGroup;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;

public class VisitCategoryCodeInputController implements Initializable {

	@FXML
	private TextField categoryCodeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private ChoiceBox<String> entityTypeChoiceBox;

	@FXML
	private TextField minutesRequiredTextField;

	@FXML
	private TextField standardCostTextField;

	@FXML
	private ChoiceBox<String> visitTypeChoiceBox;

	@FXML
	private ChoiceBox<String> encounterTypeChoiceBox;

	@FXML
	private RadioButton noSpecialSecurityRadioButton;

	@FXML
	private RadioButton eapSecuritynAccessRadioButton;

	@FXML
	private RadioButton personalHealthWellnessSecurityRadioButton;

	@FXML
	private ToggleGroup security;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private CheckBox noChargeVisitTypeCheckBox;

	@FXML
	private TextField snomedTextField;

	@FXML
	private TextField categoryGroupTextField;

	@FXML
	private Button snomedCTButton;

	@FXML
	private Button categoryGroupButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button okButton;

	@FXML
	private TextField billingServiceTypeTextField;

	@FXML
	private Button billingServiceTypeButton;

	private VisitCategoryCodeViewController visitCategoryCodeViewController;

	public void setVisitCategoryCodeViewController(VisitCategoryCodeViewController visitCategoryCodeViewController) {
		this.visitCategoryCodeViewController = visitCategoryCodeViewController;
	}

	public void setBillingServiceType(Integer billingId) {

		this.billingServiceTypeTextField.setText(Integer.toString(billingId));
	}

	public void viewVisitCategory() {

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> list1 = new ArrayList<String>();
		list1.add("New Injury/Problem");
		list1.add("Injury/Problem Follow-Up");
		list1.add("New Patient Visit");
		list1.add("Established Patient");
		list1.add("Physical/Assesment");
		list1.add("Routine Surveillance");
		list1.add("Preventive Medicine");
		list1.add("Office Consult");
		list1.add("telephone Call");
		list1.add("Other Visit Type");

		ObservableList<String> entryType = FXCollections.observableList(list1);
		entityTypeChoiceBox.getItems().clear();
		entityTypeChoiceBox.setItems(entryType);

		List<String> list2 = new ArrayList<String>();

		list2.add("Employer Services");
		list2.add("Worker's Comp");
		list2.add("Private Practice");
		ObservableList<String> visitType = FXCollections.observableList(list2);
		visitTypeChoiceBox.getItems().clear();
		visitTypeChoiceBox.setItems(visitType);

		List<String> list3 = new ArrayList<String>();

		list3.add("In-House");
		list3.add("On-Site");
		list3.add("referral");
		list3.add("Telephone");
		list3.add("Other");
		ObservableList<String> encounterType = FXCollections.observableList(list3);
		encounterTypeChoiceBox.getItems().clear();
		encounterTypeChoiceBox.setItems(encounterType);

		/*
		 * categoryGroupButton.setOnAction((event) -> {
		 * 
		 * String formName1 = formPath.context.getMessage("ProgressBar", null,
		 * Locale.US);
		 * 
		 * String formTitle1 =
		 * formPath.context.getMessage("Title.VisitCategoryGroup", null,
		 * Locale.US); formPath.closeApplicationContext();
		 * 
		 * // Need the ProgressBar controller to access the progress bar in //
		 * this method ProgressBarGUIController progressBarGUIController =
		 * (ProgressBarGUIController) new FXFormCommonUtilities()
		 * .displayFormAndGetController(formName1, formTitle1); ProgressBar
		 * progressBar = progressBarGUIController.getProgressBar();
		 * 
		 *//********************************
			 * Start of Task definition
			 *****************************************************************/
		/*
		 * Task<ObservableList<VisitCategoryGroup>> task =
		 * 
		 * new Task<ObservableList<VisitCategoryGroup>>() {
		 * 
		 * @Override protected ObservableList<VisitCategoryGroup> call() throws
		 * Exception {
		 * 
		 * final ObservableList<VisitCategoryGroup> visitCategoryGroupList = new
		 * VisitCategoryGroupEntityController() .viewVisitCategoryGroup();
		 * 
		 * if (isCancelled()) { return null; } return visitCategoryGroupList;
		 * 
		 * } };
		 *//*************************
			 * End of Task definition
			 *****************************************************************//*
																			 * 
																			 * task
																			 * .
																			 * setOnSucceeded
																			 * (
																			 * event1
																			 * ->
																			 * {
																			 * 
																			 * System
																			 * .
																			 * out
																			 * .
																			 * println(
																			 * "With in success."
																			 * );
																			 * 
																			 * Stage
																			 * stage
																			 * =
																			 * (Stage)
																			 * progressBarGUIController
																			 * .
																			 * getProgressBar
																			 * (
																			 * )
																			 * .
																			 * getScene
																			 * (
																			 * )
																			 * .
																			 * getWindow
																			 * (
																			 * )
																			 * ;
																			 * stage
																			 * .
																			 * close
																			 * (
																			 * )
																			 * ;
																			 * 
																			 * String
																			 * formName
																			 * =
																			 * formPath
																			 * .
																			 * context
																			 * .
																			 * getMessage
																			 * (
																			 * "VisitCategoryGroup",
																			 * null,
																			 * Locale
																			 * .
																			 * US
																			 * )
																			 * ;
																			 * String
																			 * formTitle
																			 * =
																			 * formPath
																			 * .
																			 * context
																			 * .
																			 * getMessage
																			 * (
																			 * "Title.VisitCategoryGroup",
																			 * null,
																			 * Locale
																			 * .
																			 * US
																			 * )
																			 * ;
																			 * formPath
																			 * .
																			 * closeApplicationContext
																			 * (
																			 * )
																			 * ;
																			 * 
																			 * FXFormCommonUtilities
																			 * formDisplayer
																			 * =
																			 * new
																			 * FXFormCommonUtilities
																			 * (
																			 * )
																			 * ;
																			 * try
																			 * {
																			 * formDisplayer
																			 * .
																			 * visitCategoryGroupDisplayForm
																			 * (
																			 * formName,
																			 * formTitle,
																			 * task
																			 * .
																			 * getValue
																			 * (
																			 * )
																			 * )
																			 * ;
																			 * }
																			 * catch
																			 * (Exception
																			 * e)
																			 * {
																			 * e
																			 * .
																			 * printStackTrace
																			 * (
																			 * )
																			 * ;
																			 * }
																			 * 
																			 * }
																			 * )
																			 * ;
																			 * 
																			 * progressBar
																			 * .
																			 * progressProperty
																			 * (
																			 * )
																			 * .
																			 * bind
																			 * (
																			 * task
																			 * .
																			 * progressProperty
																			 * (
																			 * )
																			 * )
																			 * ;
																			 * 
																			 * try
																			 * {
																			 * //
																			 * Start
																			 * background
																			 * thread
																			 * for
																			 * database
																			 * record
																			 * retrieval
																			 * .
																			 * new
																			 * Thread
																			 * (
																			 * task
																			 * )
																			 * .
																			 * start
																			 * (
																			 * )
																			 * ;
																			 * }
																			 * catch
																			 * (Exception
																			 * e)
																			 * {
																			 * e
																			 * .
																			 * printStackTrace
																			 * (
																			 * )
																			 * ;
																			 * }
																			 * 
																			 * }
																			 * )
																			 * ;
																			 */
		/*
		 * snomedCTButton.setOnAction((event) -> { try { //// Load and Display -
		 * Select_CPT-4_or_HCPCS_Code.fxml Form String formName =
		 * formPath.context.getMessage("SNOMEDCTCode", null, Locale.US); String
		 * formTitle = formPath.context.getMessage("Title.SNOMEDCTCode", null,
		 * Locale.US); formPath.closeApplicationContext();
		 * 
		 * new FXFormCommonUtilities().displayForm(formName, formTitle); } catch
		 * (Exception ex) { ex.printStackTrace(); } });
		 */

		/*************************************
		 * Start of billingServiceType.setOnAction(..)
		 *****************************************************/

		billingServiceTypeButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.BillingService", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BillingServiceType>> task =

					new Task<ObservableList<BillingServiceType>>() {

						@Override
						protected ObservableList<BillingServiceType> call() throws Exception {

							final ObservableList<BillingServiceType> billingServiceTypeList = new BillingServiceTypeEntityController()
									.viewBillingService();

							if (isCancelled()) {
								return null;
							}
							return billingServiceTypeList;

						}
					};

			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("BillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
				formPath.closeApplicationContext();

				BillingServiceTypeViewController billingServiceTypeViewController = (BillingServiceTypeViewController) new FXFormCommonUtilities()

						.billingServiceTypeDisplayForm(formName, formTitle, task.getValue());
				billingServiceTypeViewController.setVisitCategoryCodeInputController(this);

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of respiratorModelBtn.setOnAction(..)
		 *************************************************************/

		okButton.setOnAction((event) -> {

			String security = null;

			if (noSpecialSecurityRadioButton.isSelected()) {

				security = "No Special Security";

			} else if (eapSecuritynAccessRadioButton.isSelected()) {

				security = "EAP Security Access";

			} else if (personalHealthWellnessSecurityRadioButton.isSelected()) {

				security = "Personal Health and Wellness Security";

			}

			try {

				VisitCategory visitCategory = new VisitCategory();

				visitCategory.setCode(categoryCodeTextField.getText());
				visitCategory.setDescrip(descriptionTextField.getText());

				if (billingServiceTypeTextField.getText().isEmpty()) {

				} else {

					BillingServiceType billingServiceType = new BillingServiceTypeEntityController()
							.viewById(Integer.parseInt(billingServiceTypeTextField.getText()));
					visitCategory.setBillingServiceType(billingServiceType);

				}

				visitCategory.setEncounterType(entityTypeChoiceBox.getSelectionModel().getSelectedItem());
				visitCategory.setEntryType(entityTypeChoiceBox.getSelectionModel().getSelectedItem());

				visitCategory.setInactive(inactiveCheckBox.isSelected());
				visitCategory.setMinutesReqd(minutesRequiredTextField.getText());
				visitCategory.setNoChargeVisit(noChargeVisitTypeCheckBox.isSelected());
				// visitCategory.setResultType(resultType));
				visitCategory.setSecurity(security);
				// visitCategory.setService(service);
				visitCategory.setVisitType(visitTypeChoiceBox.getSelectionModel().getSelectedItem());

				new VisitCategoryEntityController().saveOrUpdate(visitCategory);

				visitCategoryCodeViewController.viewVisitCategory();

				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
