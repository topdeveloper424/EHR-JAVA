package com.ets.controller.gui.patientInsuranceCarrier;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.patientInsuranceCarrier.PatientInsuranceCarrierEntityController;
import com.ets.controller.gui.carriers.CarrierViewController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.model.Carrier;
import com.ets.model.PatientInsuranceCarrier;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PatientInsuranceCarrierInputController implements Initializable {

	@FXML
	private TextField InsuranceCarrierText;

	@FXML
	private TextField PlanNameText;

	@FXML
	private TextField PolicyText;

	@FXML
	private TextField EmployeeNameText;

	@FXML
	private TextField CoPaymentText;

	@FXML
	private TextField DeductibleAmntText;

	@FXML
	private TextField DeductMetText;

	@FXML
	private TextField CoverageText;

	@FXML
	private TextField VarifiedText;

	@FXML
	private ChoiceBox<String> PlanTypeDrop;

	@FXML
	private CheckBox InsurenceVerifiedCheck;

	@FXML
	private Button InsurenceCarrierButton;

	@FXML
	private Button OkButton;

	@FXML
	private Button CancleButton;

	@FXML
	private DatePicker EffectiveDate;

	@FXML
	private DatePicker ExpireDate;

	public void setCarrier(String code) {

		InsuranceCarrierText.setText(code);

	}

	private PatientInsuranceCarrierViewController patientInsuranceCarrierViewController;

	public void setPatientInsuranceCarrierViewController(
			PatientInsuranceCarrierViewController patientInsuranceCarrierViewController) {
		this.patientInsuranceCarrierViewController = patientInsuranceCarrierViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<String> list1 = new ArrayList<String>();

		list1.add("Group Health");
		list1.add("Medicare");
		list1.add("Medicade");
		list1.add("Medigap");
		list1.add("Tricare");
		list1.add("ChampVA");
		list1.add("FECA");
		list1.add("Blue Cross");
		list1.add("Blue Shield");
		list1.add("Other");
	
		ObservableList planTypeList = FXCollections.observableList(list1);
		PlanTypeDrop.getItems().clear();
		PlanTypeDrop.setItems(planTypeList);

		OkButton.setOnAction((event) -> {

			if(this.flag != -1) {
				if(this.flag == 0) {
					if (PlanNameText.getText().isEmpty() || PlanTypeDrop.getSelectionModel().getSelectedItem().isEmpty()
							|| CoPaymentText.getText().isEmpty() || CoverageText.getText().isEmpty()
							|| DeductibleAmntText.getText().isEmpty() || PolicyText.getText().isEmpty()
							|| DeductMetText.getText().isEmpty()) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialogue");
						alert.setHeaderText(null);
						alert.setContentText("Please provide all required fields.");
						alert.showAndWait();

					} else {

						try {

							PatientInsuranceCarrier patientInsuranceCarrier = new PatientInsuranceCarrier();

							// patientInsuranceCarrier.setEmployerName(NameText.getText());

							LocalDate localDate1 = EffectiveDate.getValue();
							if (localDate1 != null) {

								Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

								patientInsuranceCarrier.setDateEffective(date1);

							}

							LocalDate localDate2 = ExpireDate.getValue();
							if (localDate2 != null) {

								Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

								patientInsuranceCarrier.setDateExpiry(date2);

							}

							if (InsuranceCarrierText.getText().isEmpty()) {

							} else {

								Carrier carrier = new CarrierEntityController().viewByCode(InsuranceCarrierText.getText());
								patientInsuranceCarrier.setCarrier(carrier);

							}

							patientInsuranceCarrier.setPlanName(PlanNameText.getText());
							patientInsuranceCarrier.setPlanType(PlanTypeDrop.getSelectionModel().getSelectedItem());
							patientInsuranceCarrier.setCopayAmt(CoPaymentText.getText());
							patientInsuranceCarrier.setCoverPercent(CoverageText.getText());
							patientInsuranceCarrier.setDeductAmt(DeductibleAmntText.getText());
							patientInsuranceCarrier.setPolicyOrGroup(PolicyText.getText());
							patientInsuranceCarrier.setDeductMet(DeductMetText.getText());
							if(EmployeeNameText != null) {
								patientInsuranceCarrier.setEmployerName(EmployeeNameText.getText());								
							}

							new PatientInsuranceCarrierEntityController().saveOrUpdate(patientInsuranceCarrier);
							if(this.patientEditController != null) {
								this.patientEditController.viewPatientInsuranceCarrier();								
							}else {
								this.patientInputController.viewPatientInsuranceCarrier();
							}
							// patientInsuranceCarrierViewController.viewPatientInsuranceCarrier();						
							new FXFormCommonUtilities().closeForm(OkButton);

						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}
				}else if(this.flag == 1){
					if (PlanNameText.getText().isEmpty() || PlanTypeDrop.getSelectionModel().getSelectedItem().isEmpty()
							|| CoPaymentText.getText().isEmpty() || CoverageText.getText().isEmpty()
							|| DeductibleAmntText.getText().isEmpty() || PolicyText.getText().isEmpty()
							|| DeductMetText.getText().isEmpty()) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialogue");
						alert.setHeaderText(null);
						alert.setContentText("Please provide all required fields.");
						alert.showAndWait();

					} else {

						try {

							PatientInsuranceCarrier patientInsuranceCarrier = new PatientInsuranceCarrier();

							// patientInsuranceCarrier.setEmployerName(NameText.getText());

							LocalDate localDate1 = EffectiveDate.getValue();
							if (localDate1 != null) {

								Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

								patientInsuranceCarrier.setDateEffective(date1);

							}

							LocalDate localDate2 = ExpireDate.getValue();
							if (localDate2 != null) {

								Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

								patientInsuranceCarrier.setDateExpiry(date2);

							}

							if (InsuranceCarrierText.getText().isEmpty()) {

							} else {

								Carrier carrier = new CarrierEntityController().viewByCode(InsuranceCarrierText.getText());
								patientInsuranceCarrier.setCarrier(carrier);

							}
							
							patientInsuranceCarrier.setId(this.selectPatientInsuranceCarrier.getId());
							patientInsuranceCarrier.setPlanName(PlanNameText.getText());
							patientInsuranceCarrier.setPlanType(PlanTypeDrop.getSelectionModel().getSelectedItem());
							patientInsuranceCarrier.setCopayAmt(CoPaymentText.getText());
							patientInsuranceCarrier.setCoverPercent(CoverageText.getText());
							patientInsuranceCarrier.setDeductAmt(DeductibleAmntText.getText());
							patientInsuranceCarrier.setPolicyOrGroup(PolicyText.getText());
							patientInsuranceCarrier.setDeductMet(DeductMetText.getText());
							if(EmployeeNameText != null) {
								patientInsuranceCarrier.setEmployerName(EmployeeNameText.getText());								
							}

							new PatientInsuranceCarrierEntityController().saveOrUpdate(patientInsuranceCarrier);
							if(this.patientEditController != null) {
								this.patientEditController.viewPatientInsuranceCarrier();								
							}else {
								this.patientInputController.viewPatientInsuranceCarrier();
							}
							// patientInsuranceCarrierViewController.viewPatientInsuranceCarrier();						
							new FXFormCommonUtilities().closeForm(OkButton);

						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}
				}
			}else {
				if (PlanNameText.getText().isEmpty() || PlanTypeDrop.getSelectionModel().getSelectedItem().isEmpty()
						|| CoPaymentText.getText().isEmpty() || CoverageText.getText().isEmpty()
						|| DeductibleAmntText.getText().isEmpty() || PolicyText.getText().isEmpty()
						|| DeductMetText.getText().isEmpty()) {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialogue");
					alert.setHeaderText(null);
					alert.setContentText("Please provide all required fields.");
					alert.showAndWait();

				} else {

					try {

						PatientInsuranceCarrier patientInsuranceCarrier = new PatientInsuranceCarrier();

						// patientInsuranceCarrier.setEmployerName(NameText.getText());

						LocalDate localDate1 = EffectiveDate.getValue();
						if (localDate1 != null) {

							Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

							patientInsuranceCarrier.setDateEffective(date1);

						}

						LocalDate localDate2 = ExpireDate.getValue();
						if (localDate2 != null) {

							Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

							patientInsuranceCarrier.setDateExpiry(date2);

						}

						if (InsuranceCarrierText.getText().isEmpty()) {

						} else {

							Carrier carrier = new CarrierEntityController().viewByCode(InsuranceCarrierText.getText());
							patientInsuranceCarrier.setCarrier(carrier);

						}

						patientInsuranceCarrier.setPlanName(PlanNameText.getText());
						patientInsuranceCarrier.setPlanType(PlanTypeDrop.getSelectionModel().getSelectedItem());
						patientInsuranceCarrier.setCopayAmt(CoPaymentText.getText());
						patientInsuranceCarrier.setCoverPercent(CoverageText.getText());
						patientInsuranceCarrier.setDeductAmt(DeductibleAmntText.getText());
						patientInsuranceCarrier.setPolicyOrGroup(PolicyText.getText());
						patientInsuranceCarrier.setDeductMet(DeductMetText.getText());
						if(EmployeeNameText != null) {
							patientInsuranceCarrier.setEmployerName(EmployeeNameText.getText());							
						}
						
						new PatientInsuranceCarrierEntityController().saveOrUpdate(patientInsuranceCarrier);
						// patientInsuranceCarrierViewController.viewPatientInsuranceCarrier();						
						new FXFormCommonUtilities().closeForm(OkButton);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			}

		});

		InsurenceCarrierButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Carrier", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Carrier", null, Locale.US);
				formPath.closeApplicationContext();
				CarrierViewController carrierViewController = (CarrierViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				carrierViewController.setPatientInsuranceCarrierInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		CancleButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(CancleButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}
	
	private PatientEditController patientEditController;
	private Integer flag = -1;
	PatientInsuranceCarrier selectPatientInsuranceCarrier = null;
	
	public void setPatientEditController(PatientEditController patientEditController, int i) {
		this.patientEditController = patientEditController;
		this.flag = i;
	}

	public void setPatientInputController(PatientInputController patientInputController, int i) {
		this.patientInputController = patientInputController;
		this.flag = i;
	}
	
	public void setPatientEditController(PatientEditController patientEditController, int i,PatientInsuranceCarrier selectPatientInsuranceCarrier ) {
		this.patientEditController = patientEditController;
		this.flag = i;
		this.selectPatientInsuranceCarrier = selectPatientInsuranceCarrier;
		if(this.flag == 1 && this.selectPatientInsuranceCarrier != null) {
			PlanNameText.setText(this.selectPatientInsuranceCarrier.getPlanName());
			PlanTypeDrop.setValue(this.selectPatientInsuranceCarrier.getPlanType());
			CoPaymentText.setText(this.selectPatientInsuranceCarrier.copayAmtProperty().get());							
			CoverageText.setText(this.selectPatientInsuranceCarrier.coverPercentProperty().get());
			DeductibleAmntText.setText(this.selectPatientInsuranceCarrier.deductAmtProperty().get());
			PolicyText.setText(this.selectPatientInsuranceCarrier.policyOrGroupProperty().get());
			DeductMetText.setText(this.selectPatientInsuranceCarrier.deductMetProperty().get());
			EmployeeNameText.setText(this.selectPatientInsuranceCarrier.getEmployerName());
		}
	}
	
	private PatientInputController patientInputController;
	public void setPatientInputController(PatientInputController patientInputController, int i,PatientInsuranceCarrier selectPatientInsuranceCarrier ) {
		this.patientInputController = patientInputController;
		this.flag = i;
		this.selectPatientInsuranceCarrier = selectPatientInsuranceCarrier;
		if(this.flag == 1 && this.selectPatientInsuranceCarrier != null) {
			PlanNameText.setText(this.selectPatientInsuranceCarrier.getPlanName());
			PlanTypeDrop.setValue(this.selectPatientInsuranceCarrier.getPlanType());
			CoPaymentText.setText(this.selectPatientInsuranceCarrier.copayAmtProperty().get());							
			CoverageText.setText(this.selectPatientInsuranceCarrier.coverPercentProperty().get());
			DeductibleAmntText.setText(this.selectPatientInsuranceCarrier.deductAmtProperty().get());
			PolicyText.setText(this.selectPatientInsuranceCarrier.policyOrGroupProperty().get());
			DeductMetText.setText(this.selectPatientInsuranceCarrier.deductMetProperty().get());
			EmployeeNameText.setText(this.selectPatientInsuranceCarrier.getEmployerName());
		}
	}
}
