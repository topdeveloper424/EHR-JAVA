package com.ets.controller.gui.genericVisitProtocal;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterGenericvisitCatagoryProtocolController Class
 *Description: EnterGenericvisitCatagoryProtocol.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class GenericVisitProtocolInputController implements Initializable {

	@FXML
	private Button visitCategoryBtn;

	@FXML
	private Button ok;

	@FXML
	private Button close;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		visitCategoryBtn.setOnAction((event) -> {
			try {
				// Load and Display - Select_Visit_Category_Code.fxml Form
				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		close.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(close);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
