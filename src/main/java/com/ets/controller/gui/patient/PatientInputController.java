package com.ets.controller.gui.patient;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientAddlContactInfo.PatientAddlContactInfoEntityController;
import com.ets.controller.entity.patientAuthRep.PatientAuthRepEntityController;
import com.ets.controller.entity.patientDrivingLicense.PatientDrivingLicenseEntityController;
import com.ets.controller.entity.patientInsuranceCarrier.PatientInsuranceCarrierEntityController;
import com.ets.controller.entity.patientName.PatientNameEntityController;
import com.ets.controller.entity.patientRiskFactor.PatientRiskFactorEntityController;
import com.ets.controller.entity.patientSmokingStatus.PatientSmokingStatusEntityController;
import com.ets.controller.entity.patientStatistic.PatientStatisticEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.representativeRelation.RepRelationEntityController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.naicsCode.NaicsCodeViewController;
import com.ets.controller.gui.patientInsuranceCarrier.PatientInsuranceCarrierInputController;
import com.ets.controller.gui.patientInsuranceCarrier.PatientInsuranceCarrierViewController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeViewController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.controller.gui.representRelation.PatientRepInputRelationController;
import com.ets.controller.gui.representRelation.PatientRepRelationViewController;
import com.ets.controller.main.MyMain;
import com.ets.model.Address;
import com.ets.model.Company;
import com.ets.model.Patient;
import com.ets.model.PatientAddlContactInfo;
import com.ets.model.PatientAuthRep;
import com.ets.model.PatientDrivingLicense;
import com.ets.model.PatientInsuranceCarrier;
import com.ets.model.PatientName;
import com.ets.model.PatientRiskFactor;
import com.ets.model.PatientSmokingStatus;
import com.ets.model.PatientStatistic;
import com.ets.model.Provider;
import com.ets.model.RepresentRelation;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class PatientInputController implements Initializable {

	@FXML
	private TextField companyNameText;

	@FXML
	private TextField SocText;

	@FXML
	private TextField PatientIDText;

	@FXML
	private TextField MedRecNoText;

	@FXML
	private TextField FirstNameText;

	@FXML
	private TextField MiddNameText;

	@FXML
	private TextField LastNameText;

	@FXML
	private TextField SuffixText;

	@FXML
	private TextField Street1Text;

	@FXML
	private TextField CityText;

	@FXML
	private TextField StateText;

	@FXML
	private TextField ZipText;

	@FXML
	private ChoiceBox<String> countryDrop;

	@FXML
	private TextField phoneText;

	@FXML
	private TextField cellText;

	@FXML
	private TextField FaxText;

	@FXML
	private TextField emailText;

	@FXML
	private DatePicker DOBDate;

	@FXML
	private RadioButton maleRadiobutton;

	@FXML
	private ToggleGroup gender;

	@FXML
	private RadioButton femaleRadioButton;

	@FXML
	private ChoiceBox<String> RaceDrop;

	@FXML
	private CheckBox deceasedCheckBox;

	@FXML
	private ChoiceBox<String> MaritialDrop;

	@FXML
	private TextField EducationText;

	@FXML
	private CheckBox EnglishSpeakinCheck;

	@FXML
	private ChoiceBox<String> PreferLangDrop;

	@FXML
	private ChoiceBox<String> secondLangDrop;

	@FXML
	private ImageView patientPhoto;

	@FXML
	private Button GetPhotoButton;

	@FXML
	private TextField PrimaryCarePhysicianButton;

	@FXML
	private Button PrimaryCareButton;

	@FXML
	private TextField NameText;

	@FXML
	private TextField prefferedProviderText;

	@FXML
	private Button PrefferedProiderButton;

	@FXML
	private ChoiceBox<String> classDrop;

	@FXML
	private TextField LicenseStateText;

	@FXML
	private TextField DriverLicenseText;

	@FXML
	private DatePicker CertificationExpirationDate;

	@FXML
	private ChoiceBox<String> CDLDrop;

	@FXML
	private TextField patientInsuranceText;

	@FXML
	private TextField patientInsuranceId;

	@FXML
	private Button patientInsuranceButton;

	@FXML
	private TextField primaryCareProIdText;

	@FXML
	private TextField preferedProIdText;

	@FXML
	private TextField patientAuthRepText;

	@FXML
	private TextField patientAuthRepId;

	@FXML
	private Button patientRepresentativeButton;

	@FXML
	private Button patientAuthRepButton;

	@FXML
	private TextField FathersNameText;

	@FXML
	private TextField MothersNameText;

	@FXML
	private TextField MaidenNameText;

	@FXML
	private TextField EmergencyContactText;

	@FXML
	private TextField NextOfKinContactText;

	@FXML
	private TextField aditionalAddressText;

	@FXML
	private TextField aditionalCityText;

	@FXML
	private ChoiceBox<String> PatientTypeDrop;

	@FXML
	private ChoiceBox<String> RelationShipDrop;

	@FXML
	private TextField aditionalStateText;

	@FXML
	private TextField aditionalZipText;

	@FXML
	private TextField aditionalTelephoneText;

	@FXML
	private TextField aditionalCellText;

	@FXML
	private TextField aditionalWorkText;

	@FXML
	private TableView<PatientInsuranceCarrier> InsurenceTable;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> levelCollumn;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> payorCollumn;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> typeCollumn;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> coPayCollumn;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> deductableCollumn;

	@FXML
	private TableColumn<PatientInsuranceCarrier, String> percentCollumn;

	@FXML
	private Button AddButton;

	@FXML
	private Button ChangeButton;

	@FXML
	private Button DeleteButton;

	@FXML
	private TextField CountryOriginText;

	@FXML
	private DatePicker USAEntryDateDate;

	@FXML
	private CheckBox BCGVaxHistoryCheck;

	@FXML
	private CheckBox DrugAllergyCheck;

	@FXML
	private CheckBox CurrentProblemCheck;

	@FXML
	private CheckBox MedicationsTakingText;

	@FXML
	private CheckBox AlergiesCheck;

	@FXML
	private CheckBox CradicEvents;

	@FXML
	private TextField StatusText;

	@FXML
	private RadioButton UnkownSmokingStatusRadio;

	@FXML
	private RadioButton NeverSmokedRadio;

	@FXML
	private RadioButton CurrentEveryDaySomkingRadio;

	@FXML
	private RadioButton CurrentSomeDayRadio;

	@FXML
	private RadioButton SmokerRadio;

	@FXML
	private RadioButton FormerSmokerRadio;

	@FXML
	private RadioButton HeavyTobaccoSmokerRadio;

	@FXML
	private RadioButton LightTabaccoSmokerRadio;

	@FXML
	private RadioButton OtherTobaccoRadio;

	@FXML
	private RadioButton OtherNonTobaccoRadio;

	@FXML
	private TextField PerDayPackText;

	@FXML
	private TextField NumberOfYearText;

	@FXML
	private DatePicker LastSmokeDayText;

	@FXML
	private CheckBox OfferedCheck;

	@FXML
	private DatePicker DateDate;

	@FXML
	private CheckBox AcceptedChecks;

	@FXML
	private Button okButton;
	@FXML
	private Button companyBtn;

	@FXML
	private Button cancleButton;

	public static ObservableList<Patient> patListInput;

	Patient patientInserted;

	private Provider primaryPhysician;

	public void setPrimaryPhysicians(Provider provider) {
		this.primaryPhysician = provider;
		PrimaryCarePhysicianButton.setText(provider.getFirstName() + " " + provider.getLastName());

	}

	private Provider preferedProvider;

	public void setPreferedProvider(Provider provider) {

		prefferedProviderText.setText(provider.getFirstName() + " " + provider.getLastName());
		this.preferedProvider = provider;
	}

	private PatientAuthRep patientAuthRep;

	public void setPatientAuthRep(PatientAuthRep patientAuthRep) {
		this.patientAuthRep = patientAuthRep;

	}

	private PatientInsuranceCarrier patientInsuranceCarrier;

	public void setPatientInsurance(PatientInsuranceCarrier patientInsuranceCarrier) {
		this.patientInsuranceCarrier = patientInsuranceCarrier;
		patientInsuranceText.setText(patientInsuranceCarrier.getPlanName());

	}

	private Company company;

	public void setCompany(Company company) {
		this.company = company;
		companyNameText.setText(company.getName());
	}

	private PatientViewController patientViewController;

	public void setPatientViewController(PatientViewController patientViewController) {
		this.patientViewController = patientViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {

		BufferedImage resizedImage = new BufferedImage(132, 127, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 132, 127, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;

	}

	private File fileToSave;
	private BufferedImage resizedImage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewPatientInsuranceCarrier();
		fileToSave = null;
		List<String> list1 = new ArrayList<String>();

		list1.add("USA");
		list1.add("Mexico");
		list1.add("Canada");

		ObservableList countryList = FXCollections.observableList(list1);
		countryDrop.getItems().clear();
		countryDrop.setItems(countryList);

		List<String> list2 = new ArrayList<String>();

		list2.add("Asian");
		list2.add("Black");
		list2.add("Caucasian");
		list2.add("Hispanic");
		list2.add("Native American ");
		list2.add("Pacific Islander");
		list2.add("Declined to specify");
		list2.add("Other");

		ObservableList raceList = FXCollections.observableList(list2);
		RaceDrop.getItems().clear();
		RaceDrop.setItems(raceList);

		List<String> list3 = new ArrayList<String>();

		list3.add("Single");
		list3.add("Married");
		list3.add("Seperated");
		list3.add("Divorced");
		list3.add("Widowed");
		list3.add("Annulled");
		list3.add("Interlocutory");
		list3.add("Legally Seperated");
		list3.add("Common Law");
		list3.add("Living Together");
		list3.add("Domestic Partner");
		list3.add("Registered Domestic Partner");
		list3.add("Unreported");
		list3.add("Unknown");

		ObservableList maritalList = FXCollections.observableList(list3);
		MaritialDrop.getItems().clear();
		MaritialDrop.setItems(maritalList);

		List<String> list4 = new ArrayList<String>();

		list4.add("English");
		list4.add("French");
		list4.add("Spanish");
		list4.add("German");
		list4.add("Italian");
		list4.add("Portugese");
		list4.add("Chinese");
		list4.add("Japanese");
		list4.add("Korean");
		list4.add("Tibetian");
		list4.add("Declined to Specify");
		list4.add("Unknown");

		ObservableList languageList = FXCollections.observableList(list4);
		PreferLangDrop.getItems().clear();
		PreferLangDrop.setItems(languageList);

		secondLangDrop.getItems().clear();
		secondLangDrop.setItems(languageList);

		List<String> list5 = new ArrayList<String>();

		list5.add("A");
		list5.add("B");
		list5.add("C");
		list5.add("D");
		list5.add("Other");

		ObservableList classList = FXCollections.observableList(list5);
		classDrop.getItems().clear();
		classDrop.setItems(classList);

		List<String> list6 = new ArrayList<String>();

		list6.add("Employee");
		list6.add("Dependent");

		ObservableList patientTypeList = FXCollections.observableList(list6);

		PatientTypeDrop.getItems().clear();
		PatientTypeDrop.setItems(patientTypeList);

		List<String> list7 = new ArrayList<String>();

		list7.add("Child");
		list7.add("Spouse");

		ObservableList relationShipList = FXCollections.observableList(list7);
		RelationShipDrop.getItems().clear();
		RelationShipDrop.setItems(relationShipList);

		List<String> list8 = new ArrayList<String>();

		list8.add("CDL Holder");
		list8.add("CDL Applicant");
		list8.add("CLP Holder");
		list8.add("CLP Applicant");
		list8.add("CDL Applicant");
		list8.add("CDL Applicant");

		ObservableList cdlOrClpList = FXCollections.observableList(list8);
		CDLDrop.getItems().clear();
		CDLDrop.setItems(cdlOrClpList);

		okButton.setOnAction((event) -> {

			if (FirstNameText.getText().isEmpty() || LastNameText.getText().isEmpty() || SocText.getText().isEmpty()
					|| CityText.getText().isEmpty() || Street1Text.getText().isEmpty() || phoneText.getText().isEmpty()
					|| DOBDate.getValue() == null) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please Fill Mandatory Data");
				alert.showAndWait();

			} else {

				String gender = null;

				if (maleRadiobutton.isSelected()) {

					gender = "Male";

				} else if (femaleRadioButton.isSelected()) {

					gender = "Female";
				}

				String smokingStatus = null;

				if (UnkownSmokingStatusRadio.isSelected()) {

					smokingStatus = "Unknown Status";

				} else if (NeverSmokedRadio.isSelected()) {

					smokingStatus = "Never Smoked";

				} else if (CurrentEveryDaySomkingRadio.isSelected()) {

					smokingStatus = "Current Every Day";

				} else if (CurrentSomeDayRadio.isSelected()) {

					smokingStatus = "Current Some Days";

				} else if (SmokerRadio.isSelected()) {

					smokingStatus = "Smoker Status Unknown";

				} else if (FormerSmokerRadio.isSelected()) {

					smokingStatus = "Former Smoker";

				} else if (HeavyTobaccoSmokerRadio.isSelected()) {

					smokingStatus = "Heavy Tobacco Smoker";

				} else if (LightTabaccoSmokerRadio.isSelected()) {

					smokingStatus = "Light Tobacco Smoker";

				} else if (OtherTobaccoRadio.isSelected()) {

					smokingStatus = "Other";

				} else if (OtherTobaccoRadio.isSelected()) {

					smokingStatus = "Other Non Tobaco";
				}

				try {

					Address address1 = new Address();
					address1.setlocalAddress(aditionalAddressText.getText());
					address1.setCity(aditionalCityText.getText());
					address1.setState(aditionalStateText.getText());
					address1.setZip(aditionalZipText.getText());
					address1.setPhone(aditionalTelephoneText.getText());
					address1.setPhHome(aditionalCellText.getText());

					new AddressEntityController().add(address1);

					PatientAddlContactInfo patientAddlContactInfo = new PatientAddlContactInfo();

					patientAddlContactInfo.setAddress(address1);
					patientAddlContactInfo.setEmergencyContact(EmergencyContactText.getText());
					patientAddlContactInfo.setFatherName(FathersNameText.getText());
					patientAddlContactInfo.setMaidenName(MaidenNameText.getText());
					patientAddlContactInfo.setMotherName(MothersNameText.getText());
					patientAddlContactInfo.setNextOfKinName(NextOfKinContactText.getText());
					patientAddlContactInfo.setPatientType(PatientTypeDrop.getSelectionModel().getSelectedItem());
					patientAddlContactInfo.setRelation(RelationShipDrop.getSelectionModel().getSelectedItem());

					new PatientAddlContactInfoEntityController().saveOrUpdate(patientAddlContactInfo);

					PatientDrivingLicense patientDrivingLicense = new PatientDrivingLicense();

					patientDrivingLicense.setCdlOrClp(CDLDrop.getSelectionModel().getSelectedItem());
					patientDrivingLicense.setLicenseClass(classDrop.getSelectionModel().getSelectedItem());

					LocalDate localDate5 = DateDate.getValue();
					if (localDate5 != null) {

						Date date5 = Date.from(localDate5.atStartOfDay(ZoneId.systemDefault()).toInstant());

						patientDrivingLicense.setLicenseExpiry(date5);

					}

					patientDrivingLicense.setLicenseNo(DriverLicenseText.getText());
					patientDrivingLicense.setLicenseState(LicenseStateText.getText());

					new PatientDrivingLicenseEntityController().saveOrUpdate(patientDrivingLicense);

					PatientName patientName = new PatientName();

					// patientName.setAliasFirstName(MaidenFirstText.getText());
					// patientName.setAliasLastName(MaidenLastNameText.getText());

					patientName.setFirstName(FirstNameText.getText().trim());
					patientName.setLastName(LastNameText.getText().trim());
					patientName.setMiddleName(MiddNameText.getText().trim());
					// patientName.setNickName(nickNameText.getText());
					// patientName.setNickNamePrefix(nickPrefixText.getText());
					patientName.setSuffix(SuffixText.getText());

					new PatientNameEntityController().saveOrUpdate(patientName);

					PatientSmokingStatus patientSmokingStatus = new PatientSmokingStatus();

					patientSmokingStatus.setCessationProgramAccepted(AcceptedChecks.isSelected());
					patientSmokingStatus.setCessationProgramOffered(OfferedCheck.isSelected());

					LocalDate localDate3 = DateDate.getValue();
					if (localDate3 != null) {

						Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());

						patientSmokingStatus.setCessationProgramOfferedDate(date3);
					}

					LocalDate localDate4 = DateDate.getValue();
					if (localDate4 != null) {

						Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());

						patientSmokingStatus.setLastSmokedDate(date4);

					}

					patientSmokingStatus.setNoOfYears(NumberOfYearText.getText());
					patientSmokingStatus.setPacksPerDay(PerDayPackText.getText());
					patientSmokingStatus.setSmokingStatus(smokingStatus);

					new PatientSmokingStatusEntityController().saveOrUpdate(patientSmokingStatus);

					PatientRiskFactor patientRiskFactor = new PatientRiskFactor();

					patientRiskFactor.setAllergy(AlergiesCheck.isSelected());
					patientRiskFactor.setBcgVaxHistory(BCGVaxHistoryCheck.isSelected());
					patientRiskFactor.setCardiacEvent(CradicEvents.isSelected());
					patientRiskFactor.setCountryOfOrigin(CountryOriginText.getText());
					patientRiskFactor.setCurrentProblem(CurrentProblemCheck.isSelected());
					patientRiskFactor.setDrugAllergy(DrugAllergyCheck.isSelected());
					patientRiskFactor.setMedication(MedicationsTakingText.isSelected());
					patientRiskFactor.setSmokingStatus(patientSmokingStatus);

					LocalDate localDate2 = USAEntryDateDate.getValue();
					if (localDate2 != null) {

						Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

						patientRiskFactor.setUsaEntryDate(date2);
					}
					Date date1 = null;
					new PatientRiskFactorEntityController().saveOrupdate(patientRiskFactor);

					PatientStatistic patientStatistic = new PatientStatistic();

					patientStatistic.setDeceased(deceasedCheckBox.isSelected());

					LocalDate localDate1 = DOBDate.getValue();
					if (localDate1 != null) {

						date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

						patientStatistic.setDob(date1);
					}

					patientStatistic.setEducation(EducationText.getText());
					patientStatistic.setGender(gender);
					patientStatistic.setMarital(MaritialDrop.getSelectionModel().getSelectedItem());
					patientStatistic.setPrefLang(PreferLangDrop.getSelectionModel().getSelectedItem());
					patientStatistic.setRace(RaceDrop.getSelectionModel().getSelectedItem());
					patientStatistic.setSecondLang(secondLangDrop.getSelectionModel().getSelectedItem());
					patientStatistic.setSpeakEnglish(EnglishSpeakinCheck.isSelected());

					new PatientStatisticEntityController().saveOrUpdate(patientStatistic);

					Address address2 = new Address();

					address2.setlocalAddress(Street1Text.getText());
					address2.setCity(CityText.getText());
					address2.setState(StateText.getText());
					address2.setZip(ZipText.getText());
					address2.setCountry(countryDrop.getSelectionModel().getSelectedItem());
					address2.setPhone(phoneText.getText());
					address2.setPhHome(cellText.getText());
					address2.setFax(FaxText.getText());
					// address2.setCounty(CountryText.getText());
					address2.setEmail(emailText.getText());

					new AddressEntityController().add(address2);

					Patient patient = new Patient();

					patient.setAddlContactInfoId(patientAddlContactInfo);
					patient.setAddress(address2);

					if (PrimaryCarePhysicianButton.getText().isEmpty()) {

					} else {
						if (primaryPhysician != null) {
							patient.setPcp(primaryPhysician);
						} else {

							patient.setPcp(Global.patient.getPcp());
						}

					}

					if (prefferedProviderText.getText().isEmpty()) {

					} else {

						if (preferedProvider != null) {
							patient.setPreferredProvider(preferedProvider);
						} else {
							patient.setPreferredProvider(Global.patient.getPreferredProvider());
						}
					}
					// Company company = new
					// CompanyEntityController().getByName(companyNameText.getText());

					if (company != null) {
						patient.setCompany(company);
					} else {
						if (this.companyNameText.getText().isEmpty()) {

						} else {
							patient.setCompany(Global.patient.getCompany());
						}
					}

					patient.setPatientDrivingLicense(patientDrivingLicense);

					if (patientAuthRepId.getText().isEmpty()) {

					} else {

						PatientAuthRep patientAuthRep = new PatientAuthRepEntityController()
								.viewById(Integer.parseInt(patientAuthRepId.getText()));
						patient.setPatientAuthRep(patientAuthRep);

					}

					if (patientInsuranceText.getText().isEmpty()) {

					} else {
						if (patientInsuranceCarrier != null) {
							patient.setPatientInsuranceCarrier(patientInsuranceCarrier);
						} else {
							patient.setPatientInsuranceCarrier(Global.patient.getPatientInsuranceCarrier());
						}

					}
					patient.setClinic(Global.clinic);
					patient.setPatientName(patientName);
					patient.setPatientStatistic(patientStatistic);
					patient.setPatientSmokingStatus(patientSmokingStatus);
					patient.setPatientRiskFactor(patientRiskFactor);
					// patient.setPhotoName(photoName);
					patient.setSocialSecurityNo(SocText.getText());
					patient.setMedicalRecordNo(MedRecNoText.getText());

					if (fileToSave != null) {

						String currentPath = new File(
								MyMain.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())
										.toString();
						// if jar is is inside two ehr folder
						int relativelocationInd = currentPath.indexOf("EHR", currentPath.indexOf("EHR") + 1);
						// ehr is inside only under ehr folder
						if (relativelocationInd == -1) {
							relativelocationInd = currentPath.indexOf("EHR");
						}

						StringBuilder relativelocationBuild = new StringBuilder();
						relativelocationBuild.append(currentPath);
						relativelocationBuild.delete(relativelocationInd, currentPath.length());
						currentPath = relativelocationBuild.toString();
						File createdFolder = new File(currentPath + "ehr_related_forms_and_images");

						if (!createdFolder.exists()) {
							new File(currentPath + "ehr_related_forms_and_images").mkdir();

						}

						Path copy_from_1 = Paths.get(fileToSave.getAbsolutePath());

						try {
							Path copy_to_1 = Paths.get(createdFolder.getAbsolutePath(), fileToSave.getName());
							Files.copy(copy_from_1, copy_to_1);
							patient.setImagePath(createdFolder.getAbsolutePath());
							patient.setPhotoName(fileToSave.getName());

						} catch (FileAlreadyExistsException e) {

							TextInputDialog dialog = new TextInputDialog(fileToSave.getName());
							dialog.setTitle("File already exists with same name!");
							dialog.setHeaderText(null);
							dialog.setContentText("Please change name to continue");

							try {
								Optional<String> result = dialog.showAndWait();
								if (result.isPresent()) {

									Path copy_to_1 = Paths.get(createdFolder.getAbsolutePath(), result.get());
									Files.copy(copy_from_1, copy_to_1);

									patient.setImagePath(createdFolder.getAbsolutePath());
									patient.setPhotoName(result.get());
								}
							} catch (FileAlreadyExistsException ex) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setHeaderText(null);
								alert.setContentText("Cannot save Image! File exists with same name!");
								alert.showAndWait();

							}

						} catch (IOException e) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Dialog");
							alert.setHeaderText(null);
							alert.setContentText("import unsuccessful!");
							alert.showAndWait();

						}
					}
					new PatientEntityController().saveOrUpdate(patient);
					patientInserted = patient;

					// FirstNameText.getText();
					patientViewController.flag = 1;

					patListInput = new PatientEntityController().searchPatient(FirstNameText.getText(),
							LastNameText.getText(), date1, Global.clinic.getId());
					if (patientViewController != null
							? patientViewController.patientDemographicsSearchController != null
							: false) {
						patientViewController.patientMasterData = FXCollections.observableArrayList();
						patientViewController.patientMasterData.addAll(patListInput);
					}

					patientViewController.viewPatient();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				new FXFormCommonUtilities().closeForm(okButton);

			}

			RepRelationEntityController relationObject = new RepRelationEntityController();
			for (int i = 0; i < PatientRepRelationViewController.relationList.size(); i++) {
				RepresentRelation relation = PatientRepRelationViewController.relationList.get(i);
				// patientInserted.getId()
				relation.setPat(patientInserted);
				relationObject.saveUpdate(relation);
			}
			PatientRepRelationViewController.relationList = new ArrayList<RepresentRelation>();
		});

		GetPhotoButton.setOnAction((event) -> {

			try {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)",
						"*.JPG");
				FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)",
						"*.PNG");

				fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

				fileToSave = fileChooser.showOpenDialog(null);
				// BufferedImage bufferedImage = ImageIO.read(file);

				// Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				if (fileToSave != null) { // resize image to fit in image frame
					Image image = new Image(fileToSave.toURI().toString());
					BufferedImage bufferImage = ImageIO.read(fileToSave);
					resizedImage = resizeImageWithHint(bufferImage, bufferImage.getType());

					Image newImageResized = SwingFXUtils.toFXImage(resizedImage, null);

					patientPhoto.setImage(newImageResized);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*
		 * companyBtn.setOnAction((event) -> { try {
		 * 
		 * String formName = formPath.context.getMessage("Company", null, Locale.US);
		 * String formTitle = formPath.context.getMessage("Title.Company", null,
		 * Locale.US); formPath.closeApplicationContext();
		 * PatientRepresentativeViewController patientRepresentativeViewController =
		 * (PatientRepresentativeViewController) new
		 * FXFormCommonUtilities().displayForm(formName, formTitle);
		 * 
		 * 
		 * CompanyViewController companyViewController = (CompanyViewController) new
		 * FXFormCommonUtilities().displayForm(formName, formTitle);
		 * //patientRepresentativeViewController.setPatientInputController(this);
		 * companyViewController.setPatientInputController(this);
		 * 
		 * 
		 * } catch (Exception ex) { ex.printStackTrace(); } });
		 */

		companyBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				CompanyViewController companyViewController = (CompanyViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				companyViewController.setPatientInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		patientAuthRepButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewAuthorizedPatientRepresentatives", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewAuthorizedPatientRepresentatives", null,
						Locale.US);
				formPath.closeApplicationContext();
				PatientRepRelationViewController repRelationView = (PatientRepRelationViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				repRelationView.setPatientInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		patientInsuranceButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewPatientInsuranceCareer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewPatientInsuranceCareer", null, Locale.US);
				formPath.closeApplicationContext();

				PatientInsuranceCarrierViewController patientInsuranceCarrierViewController = (PatientInsuranceCarrierViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				patientInsuranceCarrierViewController.setPatientInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		PrimaryCareButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				ProviderViewController providerViewController = (ProviderViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				providerViewController.setPatientInputController(this, PrimaryCareButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		PrefferedProiderButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();

				ProviderViewController providerViewController =

						(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				providerViewController.setPatientInputController(this, PrefferedProiderButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancleButton.setOnAction((event) -> {
			try {
				PatientRepRelationViewController.relationList = new ArrayList<RepresentRelation>();
				new FXFormCommonUtilities().closeForm(cancleButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		AddButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddPatientInsuranceCareer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddPatientInsuranceCareer", null, Locale.US);
				formPath.closeApplicationContext();
				PatientInsuranceCarrierInputController insuranceCarrierView = (PatientInsuranceCarrierInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				insuranceCarrierView.setPatientInputController(this,0);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		ChangeButton.setOnAction((event) -> {
			try {

				PatientInsuranceCarrier selectPatientInsuranceCarrier = InsurenceTable.getSelectionModel().getSelectedItem();
				
				if(selectPatientInsuranceCarrier != null) {
					System.out.println(selectPatientInsuranceCarrier.getId());
					String formName = formPath.context.getMessage("AddPatientInsuranceCareer", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddPatientInsuranceCareer", null, Locale.US);
					formPath.closeApplicationContext();
					PatientInsuranceCarrierInputController insuranceCarrierView = (PatientInsuranceCarrierInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					insuranceCarrierView.setPatientInputController(this,1, selectPatientInsuranceCarrier);
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialogue");
					alert.setHeaderText(null);
					alert.setContentText("Please select an item to continue.");
					alert.showAndWait();
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		DeleteButton.setOnAction((event) -> {
			try {

				PatientInsuranceCarrier selectPatientInsuranceCarrier = InsurenceTable.getSelectionModel().getSelectedItem();
				
				if(selectPatientInsuranceCarrier != null) {
					new PatientInsuranceCarrierEntityController().delete(selectPatientInsuranceCarrier.getId());
					this.viewPatientInsuranceCarrier();
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialogue");
					alert.setHeaderText(null);
					alert.setContentText("No item selected.");
					alert.showAndWait();
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
	
	private ObservableList<PatientInsuranceCarrier> patientInsuranceCarrierMasterData = FXCollections
			.observableArrayList();

	public void viewPatientInsuranceCarrier() {

		patientInsuranceCarrierMasterData = new PatientInsuranceCarrierEntityController().view();

		// LevelColumn.setCellValueFactory(cellData -> cellData.getValue().);
		// LevelColumn.setCellValueFactory(cellData -> cellData.getValue().);
		// PayorColumn.setCellValueFactory(cellData -> cellData.getValue().);
		levelCollumn.setCellValueFactory(cellData -> cellData.getValue().policyOrGroupProperty());
		payorCollumn.setCellValueFactory(cellData -> cellData.getValue().planNameProperty());
		typeCollumn.setCellValueFactory(cellData -> cellData.getValue().planTypeProperty());
		coPayCollumn.setCellValueFactory(cellData -> cellData.getValue().copayAmtProperty());
		deductableCollumn.setCellValueFactory(cellData -> cellData.getValue().deductAmtProperty());
		percentCollumn.setCellValueFactory(cellData -> cellData.getValue().coverPercentProperty());

		FilteredList<PatientInsuranceCarrier> filteredData = new FilteredList<PatientInsuranceCarrier>(
				patientInsuranceCarrierMasterData, p -> true);

		SortedList<PatientInsuranceCarrier> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(InsurenceTable.comparatorProperty());

		InsurenceTable.setItems(sortedData);

	}

}
