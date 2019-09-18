package com.ets.controller.gui.wellnessSummary;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AddWellnessSummaryReportDefinationsController Class
 *Description: AddWellnessSummaryReportDefinations.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WellnessSummaryReportDefinationsInputController implements Initializable{

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




