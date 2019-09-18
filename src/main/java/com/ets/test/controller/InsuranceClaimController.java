package com.ets.test.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InsuranceClaimController extends Application {
	 @FXML
	    private Button btnOpen;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		btnOpen.setOnAction((event) -> {
				//System.out.println("Hi");
				
		});	
	}
	
	public static void main(String[] args)
    {
        Application.launch(args);
    }

}
