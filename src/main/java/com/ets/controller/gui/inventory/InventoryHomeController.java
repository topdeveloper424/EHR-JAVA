package com.ets.controller.gui.inventory;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.jobClass.JobClassInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class InventoryHomeController implements Initializable {
	
	@FXML
    private Button descriptionBtn;

    @FXML
    private Button purchesBtn;

    @FXML
    private Button outGoItemBtn;

    @FXML
    private Button currentStockBtn;

    @FXML
    private Button closeBtn;
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		descriptionBtn.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryView", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		purchesBtn.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryPurchaseView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryPurchaseView", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		outGoItemBtn.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryOutGoView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryOutGoView", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		currentStockBtn.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryStockView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryStockView", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
