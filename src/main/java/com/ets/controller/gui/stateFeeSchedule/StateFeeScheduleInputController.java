package com.ets.controller.gui.stateFeeSchedule;
import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StateFeeScheduleInputController implements Initializable{
	
	    @FXML
	    private Button close;

	    @FXML
	    private Button ok;

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


