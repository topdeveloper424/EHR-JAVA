package com.ets.controller.gui.standardFeeSchedule;

import java.net.URL;
import java.util.ResourceBundle;



import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class StandardFeeScheduleViewController implements Initializable{

    @FXML
    private Button chng;

    @FXML
    private Button close;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		close.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});	
	}

}




