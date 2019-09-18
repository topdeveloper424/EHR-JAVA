package com.ets.controller.splashScreen;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.controller.animation.FadeInLeftTransition;
import com.ets.controller.animation.FadeInRightTransition;
import com.ets.controller.animation.FadeInTransition;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SplashScreenController Class
 *Description: splash.fxml Controller class
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

public class SplashScreenController implements Initializable {

	@FXML
	private ImageView imgLoading;

	@FXML
	private Text lblWelcome;

	@FXML
	private Text lblRudy;

	@FXML
	private VBox vboxBottom;

	private Stage stage;

	private BorderPane borderPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		longStart();
		Global.context = new ClassPathXmlApplicationContext("spring.xml");
		

	}

	private void longStart() {

		Service<ApplicationContext> service = new Service<ApplicationContext>() {

			@Override
			protected Task<ApplicationContext> createTask() {

				return new Task<ApplicationContext>() {
					@Override
					protected ApplicationContext call() throws Exception {

						FXMLFormPath formPath = new FXMLFormPath();

		// ApplicationContext appContex = new ClassPathXmlApplicationContext("spring.xml");

						int max = formPath.context.getBeanDefinitionCount();
						updateProgress(0, max);
						for (int k = 0; k < max; k++) {
							Thread.sleep(40);
							updateProgress(k + 1, max);
						}
						return formPath.context;
					}
				};

			}
		};
		service.start();
		service.setOnRunning((WorkerStateEvent event) -> {
			new FadeInLeftTransition(lblWelcome).play();
			new FadeInRightTransition(lblRudy).play();
			new FadeInTransition(vboxBottom).play();
		});
		service.setOnSucceeded((WorkerStateEvent event) -> {

			// newStage();
			//initRootLayout();

			//addHomeNavPanel();

			showLoginPage();

		});

	}

	public void initRootLayout() {
		try {
			Stage st = new Stage();
			stage = (Stage) lblRudy.getScene().getWindow();

			FXMLFormPath formPath = new FXMLFormPath();
			String formName = formPath.context.getMessage("MainWindow", null, Locale.US);
			formPath.closeApplicationContext();
			// Load root layout from fxml file.
			borderPane = FXMLLoader.load(getClass().getResource(formName));
			// Show the scene containing the root layout.
			Scene scene = new Scene(borderPane);
			st.setTitle("Electronic Health Record");
			st.setScene(scene);
			st.setMaximized(true);

			st.show();
			st.setOnCloseRequest(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {

					System.out.println("Stage is closing");
					event.consume();

				}
			});
			stage.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void addHomeNavPanel() {
		try {
			FXMLFormPath formPath = new FXMLFormPath();
			String formName = formPath.context.getMessage("Home", null, Locale.US);
			formPath.closeApplicationContext();
			// Load Left Navigation for Home .
			AnchorPane leftPane = FXMLLoader.load(getClass().getResource(formName));
			//leftPane.setStyle("-fx-background-color: #A9A9A9;");
			leftPane.setPrefWidth(185.00);
			leftPane.setStyle("-fx-border-width: 1px; -fx-border-color: black;");

			borderPane.setLeft(leftPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showLoginPage() {

		try {
			FXMLFormPath formPath = new FXMLFormPath();
			Stage st = new Stage();
			stage = (Stage) lblRudy.getScene().getWindow();
			String formName = formPath.context.getMessage("UserLogin", null, Locale.US);



			formPath.closeApplicationContext();

			AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(formName));
			//AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserLogin.fxml"));

			Scene scene = new Scene(anchorPane);

			st.setScene(scene);
			st.centerOnScreen();
			st.show();

			stage.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void newStage() {
		try {
			Stage st = new Stage();
			stage = (Stage) lblRudy.getScene().getWindow();

			FXMLFormPath formPath = new FXMLFormPath();
			String formName = formPath.context.getMessage("MainWindow", null, Locale.US);
			formPath.closeApplicationContext();
			// Load root layout from fxml file.
			Parent borderPane = FXMLLoader.load(getClass().getResource(formName));
			// Show the scene containing the root layout.
			Scene scene = new Scene(borderPane);

			st.setScene(scene);
			st.setMaximized(true);

			st.show();
			stage.close();
		} catch (Exception e) {
		}
	}

	public Stage getStage() {
		return stage;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

}
