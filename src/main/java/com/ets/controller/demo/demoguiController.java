package com.ets.controller.demo;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.navpanel.BillingAndInvoicingGUIController;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class demoguiController implements Initializable{

    @FXML
    private TextField reportFromText;

    @FXML
    private DatePicker thuDatetext;

    @FXML
    private RadioButton summaryRadio;

    @FXML
    private RadioButton detailRadio;

    @FXML
    private ChoiceBox<String> reportBy1text;

    @FXML
    private ChoiceBox<String> reportBy2text;

    @FXML
    private ChoiceBox<String> selecting2;

    @FXML
    private ChoiceBox<String> select1text;

    @FXML
    private Button selectinbutton;

    @FXML
    private Button searchonbutton;

    @FXML
    private Button printbutton;

    @FXML
    private Button cancelbtn;

    @FXML
    private CheckBox companyChkBox;

    @FXML
    private CheckBox clinicChkBox;

    @FXML
    private Button clinicBtn;

    @FXML
    private Button cmpnyBtn;

    
    private BillingAndInvoicingGUIController billingAndInvoicingGUIController;
    
   	public void setBillingAndInvoicingGUIController(BillingAndInvoicingGUIController billingAndInvoicingGUIController) {
   	this.billingAndInvoicingGUIController = billingAndInvoicingGUIController;
   }

   	FXMLFormPath formPath = new FXMLFormPath();
   	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}


