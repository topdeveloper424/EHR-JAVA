package com.ets.controller.gui.progressBar;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ProgressBarGUIController implements Initializable {
	 @FXML
	 private ProgressBar progressBar;

	

	 public ProgressBar  getProgressBar()	{
		 return this.progressBar;
	 }

	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 	
	 }
}