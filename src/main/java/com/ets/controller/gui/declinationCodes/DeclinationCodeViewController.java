package com.ets.controller.gui.declinationCodes;


import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.declinationCode.DeclinationCodeEntityController;
import com.ets.controller.gui.supervisor.SupervisorEditController;
import com.ets.model.DeclinationCode;
import com.ets.model.JobClass;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeViewController Class
 *Description: View.fxml Controller class
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

public class DeclinationCodeViewController implements Initializable {

	@FXML
    private TextField searchTextField;

    @FXML
    private CheckBox includeInactiveCheckBox;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;

	@FXML
	private TableView<DeclinationCode> declinationCodeTable;

	@FXML
	private TableColumn<DeclinationCode, String> codeCollumn;

	@FXML
	private TableColumn<DeclinationCode, String> descriptionCollumn;

	@FXML
	void doubleClicked(MouseEvent event) {

		if (event.getClickCount() == 2) {

			try {

				String formName = formPath.context.getMessage("EditDeclination", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDeclination", null, Locale.US);

				formPath.closeApplicationContext();

				DeclinationCode declinationCode = declinationCodeTable.getSelectionModel().getSelectedItem();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				DeclinationCodeEditController editController = fxmlLoader.getController();
				editController.setDeclinationCode(declinationCode);
				editController.setDeclinationCodeViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	private ObservableList<DeclinationCode> declinationCodeMasterData = FXCollections.observableArrayList();
	
	public void refreshDeclinationCode() {
		
		declinationCodeMasterData = new DeclinationCodeEntityController().view();
		
		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().descrpProperty());
		
		
		FilteredList<DeclinationCode> filteredData = new FilteredList<DeclinationCode>(declinationCodeMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(declinationCode -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (declinationCode.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(declinationCode -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return declinationCode.getInactive();
					
				}

				return true;
			});

		});

		SortedList<DeclinationCode> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(declinationCodeTable.comparatorProperty());

		declinationCodeTable.setItems(sortedData);
		
		//declinationCodeTable.setItems(new DeclinationCodeEntityController().view());
	}
	
	private DeclenationCodeInputController declenationCodeInputController;
	
	public void setDeclenationCodeInputController(DeclenationCodeInputController declenationCodeInputController) {
		this.declenationCodeInputController = declenationCodeInputController;
	}
	
	FXMLFormPath formPath = new FXMLFormPath();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		refreshDeclinationCode();
		
		addButton.setOnAction((event) -> {
			try {
				// Load and Display - Enter__Activity_Declenation_Code.fxml Form
				String formName = formPath.context.getMessage("AddDeclination", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddDeclination", null, Locale.US);
				formPath.closeApplicationContext();
				DeclenationCodeInputController inputController = 
				(DeclenationCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inputController.setDeclinationCodeViewController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("EditDeclination", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDeclination", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				DeclinationCode declinationCode = declinationCodeTable.getSelectionModel().getSelectedItem();
				
				if(declinationCode != null){
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					DeclinationCodeEditController editController = fxmlLoader.getController();
					editController.setDeclinationCode(declinationCode);
					editController.setDeclinationCodeViewController(this);
					stage.show();
					
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
				}
				
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		deleteButton.setOnAction((event) -> {
			try {
				
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				Integer declinationCodeSelectedIndex = declinationCodeTable.getSelectionModel().getSelectedIndex();
				
				if(declinationCodeSelectedIndex > -1){
					
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if(result.get() == ButtonType.OK){
						
						DeclinationCode declinationCode = new DeclinationCodeEntityController().view().get(declinationCodeSelectedIndex);
						new DeclinationCodeEntityController().delete(declinationCode.getId());
						refreshDeclinationCode();
						
					}else{
						
					}
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);

					alert.showAndWait();
					
				}
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(declinationCodeTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = declinationCodeTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(declinationCodeTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = declinationCodeTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(declinationCodeTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = declinationCodeTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(declinationCodeTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		*/
		// cancel centralized form
				closeButton.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(closeButton);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
				
	}
}