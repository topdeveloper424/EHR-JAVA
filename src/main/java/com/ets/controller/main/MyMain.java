package com.ets.controller.main;

import java.io.IOException;
import java.util.Locale;

import com.ets.utils.FXMLFormPath;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 19-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MyMain Class
 *Description: Main Method class
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

public class MyMain extends Application {
	/*
	 * Stage is what Swing developers call a Window
	 *
	 */

	/*
	 * The Stage is provided as a parameter to the start() method in our Main
	 * class. Under the root node is a scene. Scenes can be swapped out with
	 * different scenes just by calling the setScene() method on the Stage
	 * object.
	 */

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	

	// private App app;

	/*
	 * Put your startup code in the start() method, never in the main() method.
	 */
	
/*	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Electronic Health Record");

		//new App().showLoginPage( primaryStage );
		// Set Main Application Window

		//new App().showLoginPage( primaryStage );

		//showLoginPage();

		initRootLayout();

		// Add the Home Navigation Panel to the left side of main window .
		addHomeNavPanel();
	}*/
	
	// Work with splash Screen
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Electronic Health Record");

		// new App().showLoginPage( primaryStage );
		// Set Main Application Window

		// new App().showLoginPage( primaryStage );

		// showLoginPage();

		//initRootLayout();

		// Add the Home Navigation Panel to the left side of main window .
		//addHomeNavPanel();
		
		splashScreenShow( primaryStage);
		

	}
	
	// Splash Screen Code Start
	
		
	public void splashScreenShow(Stage stage){
		
		try{
			//System.out.println(getClass().getResource("/view/splashScreen/splash.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("/view/splashScreen/splash.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.show();
	        	        
	        
	       /* Parent root = FXMLLoader.load(getClass().getResource("/view/testFxml/splash.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.initStyle(StageStyle.UNDECORATED);
	        stage.show();*/
	        
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
	}
	
	
	// Splash Screen Code End

	/*public void showLoginPage() {

		try {
			FXMLFormPath formPath = new FXMLFormPath();
			String formName = formPath.context.getMessage("UserLogin", null, Locale.US);
			formPath.closeApplicationContext();
			
			AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(formName));

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}*/

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			rootLayout = (BorderPane) FXMLLoader.load(getClass().getResource("/view/MainWindow.fxml"));
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			//primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.show();
		} catch (IOException e) {
			// e.getMessage();
			e.printStackTrace();
		}
	}

	public void addHomeNavPanel() {
		try {
			// Load Left Navigation for Home .
			AnchorPane leftPane = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/view/panel/Home.fxml"));
			// AnchorPane demoTabPane = (AnchorPane)
			// FXMLLoader.load(getClass().getResource("view/DemoTabPane.fxml"));
			// Set demoTabPane into the center of root layout.
			rootLayout.setLeft(leftPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 */
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}

	// Returns the root layout .
	public BorderPane getRootLayout() {
		return this.rootLayout;
	}

	/*
	 * Traditional Java main() method is present, but only calls launch().
	 * JavaFX programs only have that one line of code in their main() methods
	 *
	 */

	public static void main(String[] args) {
		launch(args);
	}
}