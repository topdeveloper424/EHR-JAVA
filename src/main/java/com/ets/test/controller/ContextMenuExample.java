package com.ets.test.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ContextMenuExample extends Application {
	
	public static void main(String[] args) {
	    launch(args);
	  }

	  @Override
	  public void start(Stage stage) {
	    stage.setTitle("ComboBoxSample");
	    Scene scene = new Scene(new Group(), 450, 250);

	    TextField notification = new TextField();

	    final ContextMenu contextMenu = new ContextMenu();
	    contextMenu.setOnShowing(new EventHandler<WindowEvent>() {
	      public void handle(WindowEvent e) {
	        System.out.println("showing");
	      }
	    });
	    contextMenu.setOnShown(new EventHandler<WindowEvent>() {
	      public void handle(WindowEvent e) {
	        System.out.println("shown");
	      }
	    });

	    MenuItem item1 = new MenuItem("About");
	    item1.setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	        System.out.println("About");
	      }
	    });
	    MenuItem item2 = new MenuItem("Preferences");
	    
	    item2.setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	        System.out.println("Preferences");
	      }
	    });
	    
	    MenuItem item3 = new MenuItem("New Appointment");
	    
	    item3.setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	        System.out.println("New Appointment");
	      }
	    });
	    MenuItem item4 = new MenuItem("Schedule");
	    
	    item4.setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	        System.out.println("Schedule");
	      }
	    });
	    contextMenu.getItems().addAll(item1, item2 , item3 , item4);

	    notification.setContextMenu(contextMenu);
	    GridPane grid = new GridPane();
	    grid.setVgap(4);
	    grid.setHgap(10);
	    grid.setPadding(new Insets(5, 5, 5, 5));
	    grid.add(new Label("To: "), 0, 0);
	    grid.add(notification, 1, 0);

	    Group root = (Group) scene.getRoot();
	    root.getChildren().add(grid);
	    stage.setScene(scene);
	    stage.show();

	  }

}
