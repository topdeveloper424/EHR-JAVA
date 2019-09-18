package com.ets.test.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	private AnchorPane root;
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = new AnchorPane();        
        
         Button btn = new Button("abc");
         	 
        Scene scene = new Scene(root, 900, 500);        
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        root.getChildren().add(btn);
        primaryStage.show();   
        
        btn.setOnAction((event) -> {
			System.out.println("Hi");
			
	});
    }
     
    
     
    
     
    
     
    
     
    
     
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}