package com.ets.controller.gui.inventory;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PatientViewController implements Initializable{

    @FXML
    private AnchorPane basePane;

    @FXML
    private TextField searchTextBox;

    @FXML
    private Button closeButton;

    @FXML
    private Button selectButton;

    @FXML
    private TableView<?> inventoryTable;

    @FXML
    private TableColumn<?, ?> typeCollumn;

    @FXML
    private TableColumn<?, ?> nameCollumn;

    @FXML
    private TableColumn<?, ?> DOBColumn;
	public PatientViewController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
