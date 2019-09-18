package com.ets.controller.gui.adminSecurity;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.CellValue;

import com.ets.controller.entity.access.AccessEntityController;
import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.loginSchedule.LoginScheduleEntityController;
import com.ets.controller.entity.logins.LoginsEntityController;
import com.ets.controller.entity.role.RoleEntityController;
import com.ets.controller.entity.userAccount.UserAccountEntityController;
import com.ets.controller.gui.clinic.ClinicViewController;
import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.model.Access;
import com.ets.model.Address;
import com.ets.model.Clinic;
import com.ets.model.LoginSchedule;
import com.ets.model.LoginHistory;
import com.ets.model.Role;
import com.ets.model.UserAccount;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.InitSpinner;
import com.ets.utils.UIRecordNavigation;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAddController Class
 *Description: AddUserAccount.fxml Controller class
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

public class UserAddController implements Initializable {

	 @FXML
	    private TextField userNameTextField;

	    @FXML
	    private TextField jobTitleTextField;

	    @FXML
	    private TextField localAddressTextField;

	    @FXML
	    private TextField cityTextField;

	    @FXML
	    private TextField phoneTextField;

	    @FXML
	    private TextField extensionTextField;

	    @FXML
	    private TextField stateTextField;

	    @FXML
	    private TextField zipTextField;

	    @FXML
	    private TextField faxTextField;

	    @FXML
	    private TextField emailTextField;

	    @FXML
	    private TextField firstnateTextField;

	    @FXML
	    private TextField middleNameTextField;

	    @FXML
	    private TextField lastNemeTextField;

	    @FXML
	    private TextField suffixTextField;

	    @FXML
	    private PasswordField passwordTextField;

	    @FXML
	    private PasswordField conformPasswordTextField;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private CheckBox suspendedCheckBox;

	    @FXML
	    private Label demographicsLabel;

	    @FXML
	    private Label employerLabel;

	    @FXML
	    private Label payerLabel;

	    @FXML
	    private Label visitProtocolLabel;

	    @FXML
	    private Label citiesOrEntitiesLabel;

	    @FXML
	    private Label providerLabel;

	    @FXML
	    private Label masterCodeLabel;

	    @FXML
	    private Label feeScheduleLabel;

	    @FXML
	    private ComboBox<String> feeScheduleComboBox;

	    @FXML
	    private TextField clinicRestrictTextField;

	    public void setdClinicRestrictTextField(String clinicName) {

			this.clinicRestrictTextField.setText(clinicName);
		}

	    @FXML
	    private TextField clinicExcludeTextField;

	    @FXML
	    private Button clinicRestrictButton;

	    @FXML
	    private Button clinicExcludeButton;

	    @FXML
	    private TextField companyRestrictTextField;

	    @FXML
	    private TextField companyExcludeTextField;

	    @FXML
	    private Button companyRestrictButton;

	    @FXML
	    private Button companyExcludeButton;

	 @FXML
	    private ComboBox<String> roleComboBox;

	@FXML
	private ComboBox<String> demographicsComboBox;

	@FXML
	private ComboBox<String> employerComboBox;

	@FXML
	private ComboBox<String> payerComboBox;

	@FXML
	private ComboBox<String> visitProtocolComboBox;

	@FXML
	private ComboBox<String> citiesOrEntitiesComboBox;

	@FXML
	private ComboBox<String> providerComboBox;

	@FXML
	private ComboBox<String> masterCodeComboBox;

	@FXML
	private CheckBox sunDayCheckBox;

	@FXML
	private CheckBox monDayCheckBox;

	@FXML
	private CheckBox tuesDayCheckBox;

	@FXML
	private CheckBox wednesDayCheckBox;

	@FXML
	private CheckBox thursDayCheckBox;

	@FXML
	private CheckBox friDayCheckBox;

	@FXML
	private CheckBox saturDayCheckBox;

	@FXML
	private Spinner<String> sunDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> sunDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> monDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> tuesDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> wednesDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> thursDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> friDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> saturDayStartTimeSpinnerField;

	@FXML
	private Spinner<String> monDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> tuesDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> wednesDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> friDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> thursDayEndTimeSpinnerField;

	@FXML
	private Spinner<String> saturDayEndTimeSpinnerField;

	@FXML
    private CheckBox systemAdministratorCheckBox;

    @FXML
    private Tab roleTablesTabPane;

    @FXML
    private Tab roleClinicTabPane;

    @FXML
    private CheckBox clinicManagerAccessCheckBox;

    @FXML
    private Tab roleBillingTabPane;

    @FXML
    private CheckBox AccountingManagerAccess;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button assignPasswordButton;

	@FXML
    private TableView<LoginHistory> accessAuditLogTable;

	@FXML
    private TableColumn<LoginHistory, String> accessAuditLogUserNameCollumn;

    @FXML
    private TableColumn<LoginHistory, Date> accessAuditLogDateCollumn;

    @FXML
    private TableColumn<LoginHistory, Date> accessAuditLogTimeCollumn;

    @FXML
    private TableColumn<LoginHistory, Boolean> accessAuditLogActionCollumn;

    @FXML
    private TextField accessAuditLogSearchTextField;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button buttomButton;

	   @FXML
	    void systemAdministratorAccessCheckBoxClick(MouseEvent event) {

		   if(systemAdministratorCheckBox.isSelected()){
			   roleTablesTabPane.setDisable(true);
			   roleClinicTabPane.setDisable(true);
			   roleBillingTabPane.setDisable(true);

		   }else{

			   roleTablesTabPane.setDisable(false);
			   roleClinicTabPane.setDisable(false);
			   roleBillingTabPane.setDisable(false);

		   }

	    }

	@FXML
	void sunDayClick(MouseEvent event) {

		if (sunDayCheckBox.isSelected()) {
			sunDayStartTimeSpinnerField.setDisable(true);
			sunDayEndTimeSpinnerField.setDisable(true);
		} else {
			sunDayStartTimeSpinnerField.setDisable(false);
			sunDayEndTimeSpinnerField.setDisable(false);
		}

	}

	@FXML
	void monDayClick(MouseEvent event) {

		if (monDayCheckBox.isSelected()) {

			monDayStartTimeSpinnerField.setDisable(true);
			monDayEndTimeSpinnerField.setDisable(true);

		} else {

			monDayStartTimeSpinnerField.setDisable(false);
			monDayEndTimeSpinnerField.setDisable(false);
		}

	}

	@FXML
	void tuesDayClick(MouseEvent event) {

		if (tuesDayCheckBox.isSelected()) {

			tuesDayStartTimeSpinnerField.setDisable(true);
			tuesDayEndTimeSpinnerField.setDisable(true);

		} else {

			tuesDayStartTimeSpinnerField.setDisable(false);
			tuesDayEndTimeSpinnerField.setDisable(false);
		}

	}

	@FXML
	void wednesDayClick(MouseEvent event) {

		if (wednesDayCheckBox.isSelected()) {

			wednesDayStartTimeSpinnerField.setDisable(true);
			wednesDayEndTimeSpinnerField.setDisable(true);

		} else {

			wednesDayStartTimeSpinnerField.setDisable(false);
			wednesDayEndTimeSpinnerField.setDisable(false);
		}

	}

	@FXML
	void thursDayClick(MouseEvent event) {

		if (thursDayCheckBox.isSelected()) {

			thursDayStartTimeSpinnerField.setDisable(true);
			thursDayEndTimeSpinnerField.setDisable(true);

		} else {

			thursDayStartTimeSpinnerField.setDisable(false);
			thursDayEndTimeSpinnerField.setDisable(false);

		}

	}

	@FXML
	void friDayClick(MouseEvent event) {

		if (friDayCheckBox.isSelected()) {

			friDayStartTimeSpinnerField.setDisable(true);
			friDayEndTimeSpinnerField.setDisable(true);

		} else {

			friDayStartTimeSpinnerField.setDisable(false);
			friDayEndTimeSpinnerField.setDisable(false);
		}

	}

	@FXML
	void saturDayClick(MouseEvent event) {

		if (saturDayCheckBox.isSelected()) {

			saturDayStartTimeSpinnerField.setDisable(true);
			saturDayEndTimeSpinnerField.setDisable(true);

		} else {

			saturDayStartTimeSpinnerField.setDisable(false);
			saturDayEndTimeSpinnerField.setDisable(false);
		}

	}

	List<UserAccount> userList = UserLoginGUIController.getUserlist();

	private ObservableList<LoginHistory> loginsMasterDate = FXCollections.observableArrayList();

	public void showLoginHistory(){

		loginsMasterDate = new LoginsEntityController().view();

		accessAuditLogUserNameCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().getUserAccount().userNameProperty());
		accessAuditLogActionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().statusProperty());
		accessAuditLogDateCollumn.setCellValueFactory(cellValue -> cellValue.getValue().entryDateProperty());
		accessAuditLogTimeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().entryTimeProperty());

		FilteredList<LoginHistory> filteredData = new FilteredList<>(loginsMasterDate, p -> true);

		accessAuditLogSearchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(logins -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}


				String lowerCaseFilter = newValue.toLowerCase();

				if(logins.getUserAccount().getUserName().toLowerCase().indexOf(lowerCaseFilter) != -1){

					return true;
				}

				return false; // Does not match.
			});
		});

		SortedList<LoginHistory> loginSortedList = new SortedList<>(filteredData);
		loginSortedList.comparatorProperty().bind(accessAuditLogTable.comparatorProperty());

		accessAuditLogTable.setItems(loginSortedList);
	}

	private ClinicViewController clinicViewController;

	public void setClinicViewController(ClinicViewController clinicViewController) {
		this.clinicViewController = clinicViewController;
	}
	
	private UserViewController userViewController;

	public void setUserViewController(UserViewController userViewController) {
		this.userViewController = userViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		showLoginHistory();

		// For Dynamic Fetch of role name  Working Code on 20-08-2016

		/*ObservableList<String> roleList = FXCollections.observableArrayList(new RoleEntityController().roleName());

		System.out.println("Size of Role Table :" +roleList.size());
		roleComboBox.setItems(roleList);*/


		/*for(Role r : roleList){
			System.out.println(r.getName());
			List<Role> li = new ArrayList<>();

			ObservableList<Role> ro =FXCollections.observableList(li);

			roleComboBox.setItems(ro);

		}*/

		List<String> roleName = new ArrayList<>();
		roleName.add("Admin");
		roleName.add("Nurse");
		roleName.add("Lab");
		roleName.add("Billing");
		roleName.add("MSP"); // MSP = Medical Service Provider

		ObservableList<String> roleList = FXCollections.observableList(roleName);
		roleComboBox.setItems(roleList);

		/*
		List<String> list = new ArrayList<>();
		list.add("No Access");
		list.add("Full Access");
		list.add("ReadOnly Access");

		ObservableList<String> accesslist = FXCollections.observableList(list);

		demographicsComboBox.setItems(accesslist);
		demographicsComboBox.setValue("No Access");

		payerComboBox.setItems(accesslist);
		payerComboBox.setValue("No Access");

		providerComboBox.setItems(accesslist);
		providerComboBox.setValue("No Access");

		visitProtocolComboBox.setItems(accesslist);
		visitProtocolComboBox.setValue("No Access");

		employerComboBox.setItems(accesslist);
		employerComboBox.setValue("No Access");

		citiesOrEntitiesComboBox.setItems(accesslist);
		citiesOrEntitiesComboBox.setValue("No Access");

		masterCodeComboBox.setItems(accesslist);
		masterCodeComboBox.setValue("No Access");*/

		ObservableList<String> accessTimeList1 = FXCollections.observableList(InitSpinner.load());

		SpinnerValueFactory factory1 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		sunDayStartTimeSpinnerField.setValueFactory(factory1);


		SpinnerValueFactory factory2 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		sunDayEndTimeSpinnerField.setValueFactory(factory2);

		SpinnerValueFactory factory3 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		monDayStartTimeSpinnerField.setValueFactory(factory3);

		SpinnerValueFactory factory4 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		monDayEndTimeSpinnerField.setValueFactory(factory4);

		SpinnerValueFactory factory5 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		tuesDayStartTimeSpinnerField.setValueFactory(factory5);

		SpinnerValueFactory factory6 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		tuesDayEndTimeSpinnerField.setValueFactory(factory6);

		SpinnerValueFactory factory7 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		wednesDayStartTimeSpinnerField.setValueFactory(factory7);

		SpinnerValueFactory factory8 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		wednesDayEndTimeSpinnerField.setValueFactory(factory8);

		SpinnerValueFactory factory9 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		thursDayStartTimeSpinnerField.setValueFactory(factory9);

		SpinnerValueFactory factory10 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		thursDayEndTimeSpinnerField.setValueFactory(factory10);

		SpinnerValueFactory factory11 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		friDayStartTimeSpinnerField.setValueFactory(factory11);

		SpinnerValueFactory factory12 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		friDayEndTimeSpinnerField.setValueFactory(factory12);

		SpinnerValueFactory factory13 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		saturDayStartTimeSpinnerField.setValueFactory(factory13);

		SpinnerValueFactory factory14 = new SpinnerValueFactory.ListSpinnerValueFactory(accessTimeList1);
		saturDayEndTimeSpinnerField.setValueFactory(factory14);

		// Load Clinic Details .
		clinicRestrictButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicViewController viewController = (ClinicViewController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				viewController.setUserAddController(this);
				viewController.showSelectButton();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		okButton.setOnAction((event) -> {
			try {
				if(roleComboBox.getSelectionModel().isEmpty()){
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please Select Role For This User! ");

					alert.showAndWait();
				}else{
				// Working Code for password check on 24-08-2016
				if( passwordTextField.getText().length() > 0 && passwordTextField.getText().equals(conformPasswordTextField.getText())){


					Address address = new Address();

					address.setlocalAddress(localAddressTextField.getText());
					address.setCity(cityTextField.getText());
					address.setState(stateTextField.getText());
					address.setZip(zipTextField.getText());
					address.setPhone(phoneTextField.getText());
					address.setExt(extensionTextField.getText());
					address.setFax(faxTextField.getText());
					address.setEmail(emailTextField.getText());

					new AddressEntityController().add(address);

					//Role role = new RoleEntityController().viewByName(roleComboBox.getSelectionModel().getSelectedItem());

					UserAccount userAccount = new UserAccount();
					
					Clinic clinic = new ClinicEntityController().viewByName(clinicRestrictTextField.getText());
					
					userAccount.setFirstName(firstnateTextField.getText());
					userAccount.setMiddleName(middleNameTextField.getText());
					userAccount.setLastName(lastNemeTextField.getText());
					userAccount.setSuffix(suffixTextField.getText());
					userAccount.setUserName(userNameTextField.getText());
					userAccount.setJobTitle(jobTitleTextField.getText());
					userAccount.setPassword(passwordTextField.getText());
					userAccount.setCreatedBy(userList.get(0).getUserName());
					userAccount.setCreatedAtDate(new Date());
					userAccount.setCreatedAtTime(new Date());
					userAccount.setClinic(clinic);
					userAccount.setAddress(address);
					userAccount.setRoleName(roleComboBox.getSelectionModel().getSelectedItem());
					
					if(roleComboBox.getSelectionModel().getSelectedItem().equals("Admin")){

						userAccount.setAdmin(true);

					}else{

						userAccount.setAdmin(false);
					}
					userAccount.setSuspended(false);
					userAccount.setInactive(false);


					new UserAccountEntityController().addOrUpdate(userAccount);

				/*	if(systemAdministratorCheckBox.isSelected()){

						for(int i=1;i<=7 ;i++){

							Access access1 = new Access();

							access1.setUserAccount(userAccount);
							access1.setRole(role);
							access1.setTableGroupId(1);
							access1.setLevel("1");

							new AccessEntityController().addOrUpdate(access1);

						}

					}else{

						for(int i=1;i<=7 ;i++){

							Access access1 = new Access();

							access1.setUserAccount(userAccount);
							access1.setRole(role);
							access1.setTableGroupId(1);

							switch (i) {
							case 1:

								if (demographicsComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (demographicsComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 2:

								if (employerComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (employerComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 3:

								if (payerComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (payerComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 4:

								if (visitProtocolComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (visitProtocolComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 5:

								if (citiesOrEntitiesComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (citiesOrEntitiesComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 6:

								if (providerComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (providerComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;
							case 7:

								if (masterCodeComboBox.getSelectionModel().getSelectedItem() == "No Access") {
									access1.setLevel("0");
								} else if (masterCodeComboBox.getSelectionModel().getSelectedItem() == "Full Access") {
									access1.setLevel("1");
								} else {
									access1.setLevel("2");
								}
								break;


							}

							new AccessEntityController().addOrUpdate(access1);

						}

					}*/


					LoginSchedule loginSchedule = new LoginSchedule();

					loginSchedule.setUserAccount(userAccount);
					loginSchedule.setWeekDayId(1);

					if(sunDayCheckBox.isSelected()){
						loginSchedule.setScheduledHoliday(true);

					}else{

						loginSchedule.setScheduledHoliday(false);

						String str1 = sunDayStartTimeSpinnerField.getValue();
						String str2 = sunDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule.setShiftStartTime(date1);
						loginSchedule.setShiftEndTime(date2);


					}

					new LoginScheduleEntityController().addOrUpdate(loginSchedule);

					LoginSchedule loginSchedule1 = new LoginSchedule();

					loginSchedule1.setUserAccount(userAccount);
					loginSchedule1.setWeekDayId(2);

					if(monDayCheckBox.isSelected()){
						loginSchedule1.setScheduledHoliday(true);

					}else{

						loginSchedule1.setScheduledHoliday(false);

						String str1 = monDayStartTimeSpinnerField.getValue();
						String str2 = monDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule1.setShiftStartTime(date1);
						loginSchedule1.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule1);

					LoginSchedule loginSchedule2 = new LoginSchedule();

					loginSchedule2.setUserAccount(userAccount);
					loginSchedule2.setWeekDayId(3);

					if(tuesDayCheckBox.isSelected()){
						loginSchedule2.setScheduledHoliday(true);

					}else{

						loginSchedule2.setScheduledHoliday(false);

						String str1 = tuesDayStartTimeSpinnerField.getValue();
						String str2 = tuesDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule2.setShiftStartTime(date1);
						loginSchedule2.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule2);

					LoginSchedule loginSchedule3 = new LoginSchedule();

					loginSchedule3.setUserAccount(userAccount);
					loginSchedule3.setWeekDayId(4);

					if(wednesDayCheckBox.isSelected()){
						loginSchedule3.setScheduledHoliday(true);

					}else{

						loginSchedule3.setScheduledHoliday(false);

						String str1 = wednesDayStartTimeSpinnerField.getValue();
						String str2 = wednesDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule3.setShiftStartTime(date1);
						loginSchedule3.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule3);



					LoginSchedule loginSchedule5 = new LoginSchedule();

					loginSchedule5.setUserAccount(userAccount);
					loginSchedule5.setWeekDayId(5);

					if(thursDayCheckBox.isSelected()){
						loginSchedule5.setScheduledHoliday(true);

					}else{

						loginSchedule5.setScheduledHoliday(false);

						String str1 = thursDayStartTimeSpinnerField.getValue();
						String str2 = thursDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule5.setShiftStartTime(date1);
						loginSchedule5.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule5);

					LoginSchedule loginSchedule6 = new LoginSchedule();

					loginSchedule6.setUserAccount(userAccount);
					loginSchedule6.setWeekDayId(6);

					if(friDayCheckBox.isSelected()){
						loginSchedule6.setScheduledHoliday(true);

					}else{

						loginSchedule6.setScheduledHoliday(false);

						String str1 = friDayStartTimeSpinnerField.getValue();
						String str2 = friDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule6.setShiftStartTime(date1);
						loginSchedule6.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule6);

					LoginSchedule loginSchedule7 = new LoginSchedule();

					loginSchedule7.setUserAccount(userAccount);
					loginSchedule7.setWeekDayId(7);

					if(saturDayCheckBox.isSelected()){
						loginSchedule7.setScheduledHoliday(true);

					}else{

						loginSchedule7.setScheduledHoliday(false);

						String str1 = saturDayStartTimeSpinnerField.getValue();
						String str2 = saturDayEndTimeSpinnerField.getValue();
						SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
						Date date1 = format.parse(str1);
						Date date2 = format.parse(str2);

						loginSchedule7.setShiftStartTime(date1);
						loginSchedule7.setShiftEndTime(date2);


					}
					new LoginScheduleEntityController().addOrUpdate(loginSchedule7);

					userViewController.showUser();

					
				new FXFormCommonUtilities().closeForm(okButton);

					



				}
				else{

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Password Check");
					alert.setHeaderText(null);
					alert.setContentText("Password is not Equal");
					alert.showAndWait();

				}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}


		});

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(accessAuditLogTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = accessAuditLogTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(accessAuditLogTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = accessAuditLogTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(accessAuditLogTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = accessAuditLogTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(accessAuditLogTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
