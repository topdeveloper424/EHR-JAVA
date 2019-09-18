package com.ets.controller.mainWindowGUIController;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.userAccount.UserAccountEntityController;
import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.model.UserAccount;
import com.ets.model.UserLogin;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MainWindowGUIController Class
 *Description: MainWindow.fxml  GUI Controller class
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

public class MainWindowGUIController implements Initializable {

	@FXML
	private BorderPane borderPaneID;

	@FXML
	private AnchorPane leftPaneID;
	
	 @FXML
	    private AnchorPane anchorPaneId;
	
	 @FXML
	  private MenuItem logOutMenuItem;

	@FXML
	private Button homeButton;

	@FXML
	private Button hippaGuardButton;

	@FXML
	void hippaClicked(MouseEvent event) {
		String string = hippaGuardButton.getAccessibleText();
		showMessageLabel(string);
	}
	
	 @FXML
	    private Button inventoryButton;

	@FXML
	private Label dateLabel;

	@FXML
	private Label timeLabel;

	@FXML
	private Label showTextLabel;

	@FXML
	private Label userNameLabel;

	@FXML
	private HBox hBox;
	
	private static Stage stage;

	FXMLFormPath formPath = new FXMLFormPath();

	private UserLoginGUIController userLoginGUIController;

	public void setUserLoginGUIController(UserLoginGUIController userLoginGUIController) {
		this.userLoginGUIController = userLoginGUIController;
	}

	public void showMessageLabel(String string) {

		showTextLabel.setText(string);
	}
	
	List<UserAccount> userList = UserLoginGUIController.getUserlist();

	public void showUserName() {

		userNameLabel.setText(userList.get(0).getUserName());
	}
	
	public static void setTitle(String name){
		
		stage.setTitle("Test" +name);
	}

	public void addHomeNavPanel() throws IOException {
		/*try {
			// Load Left Navigation for Home .

			String formName = formPath.context.getMessage("Home", null, Locale.US);
			formPath.closeApplicationContext();
			AnchorPane leftPane = new AnchorPane();
			//AnchorPane leftPane = (AnchorPane) FXMLLoader.load(getClass().getResource(formName));
			leftPane.setStyle("-fx-background-color: #8fbc8f");
			borderPaneID.setLeft(leftPane);
			//borderPaneID.setLeft(anchorPaneId.setStyle("-fx-background-color: #8fbc8f"));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		String formName = formPath.context.getMessage("Home", null, Locale.US);
		formPath.closeApplicationContext();
		AnchorPane leftPane = new AnchorPane();
		//AnchorPane leftPane = (AnchorPane) FXMLLoader.load(getClass().getResource(formName));
		leftPane.setStyle("-fx-background-color: #8fbc8f");
		
		borderPaneID.setLeft(leftPane);
		//borderPaneID.setLeft(anchorPaneId.setStyle("-fx-background-color: #8fbc8f"));
	}

	private void bindToDate() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Calendar time = Calendar.getInstance();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

				String showTime = simpleDateFormat.format(time.getTime());
				dateLabel.setText(showTime);

			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private void bindToTime() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Calendar time = Calendar.getInstance();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss a");

				String showTime = simpleDateFormat.format(time.getTime());
				timeLabel.setText(showTime);

			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public void showLoginPage() {

		try {
			
			FXMLFormPath formPath = new FXMLFormPath();
			Stage st = new Stage();
			stage = (Stage) userNameLabel.getScene().getWindow();
			String formName = formPath.context.getMessage("UserLogin", null, Locale.US);
			formPath.closeApplicationContext();
			
			AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(formName));

			Scene scene = new Scene(anchorPane);
			st.setScene(scene);
			st.show();
			stage.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// addHomeNavPanel();
		hBox.setHgrow(timeLabel, Priority.ALWAYS);
		bindToDate();
		bindToTime();
		
		showUserName();

		hippaGuardButton.setOnAction((event) -> {

			try {

				String formName = formPath.context.getMessage("HipaaHome", null, Locale.US);

				String formTitle = formPath.context.getMessage("Title.HipaaHome", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		inventoryButton.setOnAction((event) -> {

			try {

				String formName = formPath.context.getMessage("InventoryDashboard", null, Locale.US);

				String formTitle = formPath.context.getMessage("Title.InventoryDashboard", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		logOutMenuItem.setOnAction((event) -> {

			try {
				
				UserAccount userAccount = new UserAccount();
				userAccount.setId(userList.get(0).getId());
				userAccount.setAddress(userList.get(0).getAddress());
				userAccount.setAdmin(userList.get(0).getAdmin());
				userAccount.setCreatedAtDate(userList.get(0).getCreatedAtDate());
				userAccount.setCreatedAtTime(userList.get(0).getCreatedAtTime());
				userAccount.setFirstName(userList.get(0).getFirstName());
				userAccount.setInactive(userList.get(0).getInactive());
				userAccount.setJobTitle(userList.get(0).getJobTitle());
				userAccount.setLastName(userList.get(0).getLastName());
				userAccount.setMiddleName(userList.get(0).getMiddleName());
				userAccount.setPassword(userList.get(0).getPassword());
				userAccount.setPasswordExpire(userList.get(0).getPasswordExpire());
				userAccount.setPasswordExpiresOn(userList.get(0).getPasswordExpiresOn());
				userAccount.setPasswordLastChanged(userList.get(0).getPasswordLastChanged());
				userAccount.setRoleName(userList.get(0).getRoleName());
				userAccount.setSalt(userList.get(0).getSalt());
				userAccount.setSuffix(userList.get(0).getSuffix());
				userAccount.setSuspended(userList.get(0).getSuspended());
				userAccount.setUpdatedAtDate(userList.get(0).getUpdatedAtDate());
				userAccount.setUpdatedAtTime(userList.get(0).getUpdatedAtTime());
				userAccount.setUpdatedBy(userList.get(0).getUpdatedBy());
				userAccount.setUserName(userList.get(0).getUserName());
				userAccount.setClinic(userList.get(0).getClinic());
				userAccount.setLoginStatus(false);
				
				new UserAccountEntityController().addOrUpdate(userAccount);
				
				showLoginPage();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

	}

}
