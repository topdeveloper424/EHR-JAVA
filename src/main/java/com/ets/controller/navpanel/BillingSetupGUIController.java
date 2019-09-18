package com.ets.controller.navpanel;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;

public class BillingSetupGUIController implements Initializable {
	@FXML
	private Button close;

	@FXML
	private AnchorPane myanchor;

	@FXML
	private Button billing;

	@FXML
	private Button aradju;

	@FXML
	private Button denial;

	@FXML
	private Button blsystem;

	@FXML
	private Button clinics;

	@FXML
	private Button standard;

	@FXML
	private Button stfee;

	@FXML
	private Button clfee;

	@FXML
	private Button assfee;

	@FXML
	private Button confee;

	@FXML
	private Button cash;

	@FXML
	private Button roll;

	@FXML
	private Button imp;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		close.setOnAction((event) -> {
			try {
				
				myanchor.getChildren().clear();
			
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				myanchor.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		billing.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("BillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingAccounts", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		aradju.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("ARAdjustmentCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ARAdjustmentCode", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		denial.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("DenialReasonCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DenialReasonCode", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		blsystem.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("BillingSystemParam", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingSystemParam", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clinics.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		standard.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("StandardFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.StandardFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		stfee.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("StateFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.StateFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		clfee.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("ClientFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClientFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		assfee.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("AssignableFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AssignableFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		confee.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("ContractFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ContractFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cash.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("CashDiscountFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CashDiscountFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		roll.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("RollEffectiveDatePricing", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.RollEffectiveDatePricing", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		imp.setOnAction((event) -> {
			try {
				// Load and Display - selectmedicalcondition_code.fxml Form

				String formName = formPath.context.getMessage("ImportExportFeeSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ImportExportFeeSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
