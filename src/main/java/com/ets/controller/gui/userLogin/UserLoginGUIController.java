package com.ets.controller.gui.userLogin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import com.ets.controller.entity.logins.LoginsEntityController;
import com.ets.controller.entity.userAccount.UserAccountEntityController;
import com.ets.controller.entity.userLogin.UserLoginEntityControler;
import com.ets.controller.mainWindowGUIController.MainWindowGUIController;
import com.ets.model.Clinic;
import com.ets.model.LoginHistory;
import com.ets.model.UserAccount;
import com.ets.model.UserLogin;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserLoginGUIController Class
 *Description: UserLogin.fxml  GUI Controller class
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

public class UserLoginGUIController implements Initializable {

	/*private UserLogin userLogin;

	public UserLogin getUserLogin() {
		return userLogin;
	}*/

	private static List<UserAccount> userlist = new ArrayList<UserAccount>();


	public static List<UserAccount> getUserlist() {
		return userlist;
	}

	private UserAccount userAccount;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	private static UserLoginGUIController userLoginGUIController;

	public static UserLoginGUIController getUserLoginGUIController() {
		return userLoginGUIController;
	}

	public UserLoginGUIController() {

		userLoginGUIController = this;
	}

	@FXML
    private TextField userName; // User Name for UserLogin

    @FXML
    private PasswordField userPassword; // User Password for UserLogin

    @FXML
    private Label errorMessage; // Error Message for UserLogin

    @FXML
    private Button loginBtn;  // Login Button

    private  Stage primaryStage;

	private  BorderPane rootLayout;
	
	@FXML
    void enterKeyPressedFoLoginButton(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER){
			 try {

					if(userName.getText() != null && userPassword.getText().length()>0){

						//List<UserAccount> userlist = new UserAccountEntityController().loginUserValidate(userName.getText(), userPassword.getText());
						userlist = new UserAccountEntityController().loginUserValidate(userName.getText(), userPassword.getText());

						//userlist = new UserAccountEntityController().loginUserValidate2(userName.getText(), userPassword.getText(), false);

						if(userlist !=null && userlist.size()>0){
							LoginHistory loginHistory = new LoginHistory();
							loginHistory.setEntryDate(new Date());
							loginHistory.setEntryTime(new Date());
							loginHistory.setStatus(true);

							UserAccount userAccount =  new UserAccountEntityController().viewByName(userName.getText());
							userAccount.setLoginStatus(true);

							// Set user account globally
							Global.userAccount =  userAccount;
							// Set clinic globally
							Global.clinic = userAccount.getClinic() ;

							if(userAccount != null)	{
								loginHistory.setUserAccount(userAccount);
								new LoginsEntityController().addOrUpdate(loginHistory);
							}

							((Node)(event.getSource())).getScene().getWindow().hide();

							initRootLayout();

							//showLeftPanel();

							//rightPanel();

							//rightPanel2();
						}	else	{
									LoginHistory logins = new LoginHistory();
									logins.setEntryDate(new Date());
									logins.setEntryTime(new Date());
									logins.setStatus(false);

									UserAccount userAccount =  new UserAccountEntityController().viewByName(userName.getText());

									if(userAccount != null){
										logins.setUserAccount(userAccount);
										new LoginsEntityController().addOrUpdate(logins);
									}
									errorMessage.setText("Invalid User");
							}
						}
					}
						catch (Exception ex) {
					ex.printStackTrace();
				}
		 }
}
 
	FXMLFormPath formPath = new FXMLFormPath();


	public void initRootLayout() {
		// Set Base Layout
		try {

			
			//String clinicName = Global.clinic.getName();

			String formName = formPath.context.getMessage("MainWindow", null, Locale.US);
			formPath.closeApplicationContext();

			//rootLayout = (BorderPane) FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			rootLayout = fxmlLoader.load();
			addHomeNavPanel();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			Stage stage = new Stage();

			stage.setTitle("Electronic Health Record "   +Global.clinic.getName());
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {

					System.out.println("Stage is closing");
					event.consume();

				}
			});
			stage.setScene(scene);
			stage.setMaximized(true);
			MainWindowGUIController mainWindowGUIController = fxmlLoader.getController();
			//String user = userName.getText();
			//mainWindowGUIController.showUserName(user);
			mainWindowGUIController.setUserLoginGUIController(this);

			stage.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}


    public void addHomeNavPanel() {
    	// Set Left Navigation Panel
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/panel/Home.fxml"));
			AnchorPane leftPane = fxmlLoader.load();
			leftPane.setStyle(" -fx-background-color: #ccc");
			leftPane.setPrefWidth(190.00);

			rootLayout.setAlignment(leftPane, Pos.TOP_CENTER);
			//rootLayout.setStyle("-fx-background-color: #8fbc8f");
			//setStyle("-fx-background-color: #0000ff");

			rootLayout.setLeft(leftPane);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginBtn.setOnAction((event)->{
			//  Check User Authentication
			try{
				if(userName.getText() != null && userPassword.getText().length()>0){

				//List<UserAccount> userlist = new UserAccountEntityController().loginUserValidate(userName.getText(), userPassword.getText());
				userlist = new UserAccountEntityController().loginUserValidate(userName.getText(), userPassword.getText());

				//userlist = new UserAccountEntityController().loginUserValidate2(userName.getText(), userPassword.getText(), false);

				if(userlist !=null && userlist.size()>0){
					LoginHistory loginHistory = new LoginHistory();
					loginHistory.setEntryDate(new Date());
					loginHistory.setEntryTime(new Date());
					loginHistory.setStatus(true);

					UserAccount userAccount =  new UserAccountEntityController().viewByName(userName.getText());
					userAccount.setLoginStatus(true);

					// Set user account globally
					Global.userAccount =  userAccount;
					// Set clinic globally
					Global.clinic = userAccount.getClinic() ;

					if(userAccount != null)	{
						loginHistory.setUserAccount(userAccount);
						new LoginsEntityController().addOrUpdate(loginHistory);
					}

					((Node)(event.getSource())).getScene().getWindow().hide();

					initRootLayout();

					//showLeftPanel();

					//rightPanel();

					//rightPanel2();
				}	else	{
							LoginHistory logins = new LoginHistory();
							logins.setEntryDate(new Date());
							logins.setEntryTime(new Date());
							logins.setStatus(false);

							UserAccount userAccount =  new UserAccountEntityController().viewByName(userName.getText());

							if(userAccount != null){
								logins.setUserAccount(userAccount);
								new LoginsEntityController().addOrUpdate(logins);
							}
							
							if(userAccount != null && userAccount.getLoginStatus() == false){
																
								errorMessage.setText("Invalid User");
							}else{
								errorMessage.setText("Incorrect Username or Password");
							}
							
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		});
	}
}