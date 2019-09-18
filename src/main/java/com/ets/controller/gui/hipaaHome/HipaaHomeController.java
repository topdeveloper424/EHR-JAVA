package com.ets.controller.gui.hipaaHome;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.district.DistrictInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HipaaHomeController implements Initializable {

	@FXML
	private Button privacyNoticeButton;

	@FXML
	private Button patientAuthorizationButton;

	@FXML
	private Button phiDisclosureButton;

	@FXML
	private Button accountingButton;

	@FXML
	private Button restrictionButton;

	@FXML
	private Button accessButton;

	@FXML
	private Button amendmantButton;

	@FXML
	private Button complaintButton;

	@FXML
	private Button viewPatientStatusButton;

	@FXML
	private Button patientComplaintButton;

	@FXML
	private Button privacyButton;

	@FXML
	private Button authorizationButton;

	@FXML
	private Button approvalButton;

	@FXML
	private Button disclosureAccountingButton;

	@FXML
	private Button analysisButton;

	@FXML
	private Button comparisonButton;

	@FXML
	private Button pendingButton;

	@FXML
	private Button overdueButton;

	@FXML
	private Button demographicsButton;

	@FXML
	private Button contactListButton;

	@FXML
	private Button loadContactButton;

	@FXML
	private Button serviceButton;

	@FXML
	private Button clinicButton;

	@FXML
	private Button systemoptionButton;

	@FXML
	private Button coveredEntityButton;

	@FXML
	private Button quickPickButton;

	@FXML
	private Button noticeButton;

	@FXML
	private Button authorizationTemplateButton;

	@FXML
	private Button disclosureTemplateButton;

	@FXML
	private Button closeButton;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		privacyNoticeButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		patientAuthorizationButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		phiDisclosureButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		accountingButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		restrictionButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		accessButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		amendmantButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		patientComplaintButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddComplaint", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddComplaint", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		viewPatientStatusButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient2", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		phiDisclosureButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("PatientInformation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PatientInformation", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		accountingButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("DiscloserAccounting", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DiscloserAccounting", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		privacyButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("PrivacyNotice", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PrivacyNotice", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		authorizationButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Authorization", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Authorization", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		restrictionButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Restriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Restriction", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		accessButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Access", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Access", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		amendmantButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Amendment", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Amendment", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		complaintButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Complaint", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complaint", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		approvalButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Approval", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Approval", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		disclosureAccountingButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		analysisButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Analysis", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Analysis", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		comparisonButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Comparison", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Comparison", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pendingButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Pending", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Pending", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		overdueButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("OverDue", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.OverDue", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		demographicsButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewPatient2", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatient2", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		contactListButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Contact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Contact", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		loadContactButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ExternalContact", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExternalContact", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		serviceButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ServiceLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ServiceLocation", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinicButton.setOnAction((event) -> {
			try {
				// Load Clinic Details .

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
