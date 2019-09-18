package com.ets.controller.gui.adminSecurity;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.userAccount.UserAccountEntityController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.district.DistrictInputController;
import com.ets.model.Complex;
import com.ets.model.LoginHistory;
import com.ets.model.Provider;
import com.ets.model.UserAccount;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserViewController Class
 *Description: ViewUserDetails.fxml Controller class
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

public class UserViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private CheckBox loggedUserCheckBox;

	@FXML
	private CheckBox suspendedCheckBox;

	@FXML
	private TableView<UserAccount> userTable;

	@FXML
	private TableColumn<UserAccount, String> userNameCollumn;

	@FXML
	private TableColumn<UserAccount, String> passwordCollumn;

	@FXML
	private TableColumn<UserAccount, Boolean> adminCollumn;
	
	@FXML
    private TableColumn<UserAccount, String> clinicNameCollumn;

	@FXML
	private TableColumn<UserAccount, Boolean> loggedInCollumn;

	@FXML
	private TableColumn<UserAccount, Boolean> suspendedCollumn;

	@FXML
	private TableColumn<UserAccount, Boolean> inactiveCollumn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button closeButton;

	private ObservableList<UserAccount> userAccountMasterDate = FXCollections.observableArrayList();

	public void showUser() {

		userAccountMasterDate = new UserAccountEntityController().view();
		userNameCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().userNameProperty());
		passwordCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().passwordProperty());
		adminCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().adminProperty());
		clinicNameCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().getClinic().nameProperty());
		loggedInCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().loginStatusProperty());
		suspendedCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().suspendedProperty());
		inactiveCollumn.setCellValueFactory(cellvalue -> cellvalue.getValue().inactiveProperty());

		FilteredList<UserAccount> filteredData = new FilteredList<>(userAccountMasterDate, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(userAccount -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();

				if (userAccount.getUserName().toLowerCase().indexOf(lowerCaseFilter) != -1) {

					return true;
				}

				return false; // Does not match.
			});
		});
				
		
		loggedUserCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(userAccount -> {
				
				if (loggedUserCheckBox.isSelected()) {
					
					return userAccount.getLoginStatus();
					
				}

				return true;
			});

		});
		
		suspendedCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(userAccount -> {

				if (suspendedCheckBox.isSelected()) {

					return userAccount.getSuspended();
				}

				return true;
			});

		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(userAccount -> {

				if (includeInactiveCheckBox.isSelected()) {

					return userAccount.getInactive();
				}

				return true;
			});

		});

		SortedList<UserAccount> userAccountSortedList = new SortedList<>(filteredData);
		userAccountSortedList.comparatorProperty().bind(userTable.comparatorProperty());

		userTable.setItems(userAccountSortedList);

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		showUser();

		addButton.setOnAction((event) -> {
			try {
				// Load User Details Entry form .

				String formName = formPath.context.getMessage("AddUser", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddUser", null, Locale.US);
				formPath.closeApplicationContext();
				UserAddController userAddController =
				(UserAddController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				userAddController.setUserViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			
			try {
				
				UserAccount userAccount = userTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditUser", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditUser", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (userAccount != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					UserEditController editController = fxmlLoader.getController();
					editController.setUserAccount(userAccount);
					editController.setUserViewController(this);
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
		
		deleteButton.setOnAction((event) -> {
			
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer userAccountIndex = userTable.getSelectionModel().getSelectedIndex();

				if (userAccountIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						UserAccount userAccount = new UserAccountEntityController().view().get(userAccountIndex);
						
						//new ProviderEntityController().delete(provider.getId());
						new UserAccountEntityController().delete(userAccount.getId());
						showUser();

					} else {

					}

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);

					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});


		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(userTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = userTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(userTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = userTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(userTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = userTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(userTable, tempRowCount);
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
