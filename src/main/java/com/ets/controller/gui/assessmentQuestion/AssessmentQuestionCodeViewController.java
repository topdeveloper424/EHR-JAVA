package com.ets.controller.gui.assessmentQuestion;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.assesmentQuestion.AssesmentQuestionEntityController;
import com.ets.model.AssesmentQuestion;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client
 * Company File Creation Date: 06-02-2016 
 * Initial Version: 0.01 
 * Module Name:
 * Parameter Definition: Type object of AssessmentQuestionCodeViewController
 * Class Description: View.fxml Controller class
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 * 
 */

public class AssessmentQuestionCodeViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private TableView<AssesmentQuestion> assesmentQuestionTable;

	@FXML
	private TableColumn<AssesmentQuestion, String> codeCollumn;

	@FXML
	private TableColumn<AssesmentQuestion, String> textCollumn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button bottomButton;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private Button printButton;

	@FXML
	void doubleClicked(MouseEvent event) {

		try {

			String formName = formPath.context.getMessage("EditAssesmentQuestion", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditAssesmentQuestion", null, Locale.US);
			formPath.closeApplicationContext();

			AssesmentQuestion assesmentQuestion = assesmentQuestionTable.getSelectionModel().getSelectedItem();

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle(formTitle);
			stage.setScene(new Scene(root1));
			AssessmentQuestionCodeEditController editController = fxmlLoader.getController();
			editController.setAssesmentQuestion(assesmentQuestion);
			editController.setAssessmentQuestionCodeViewController(this);
			stage.show();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	 private ObservableList<AssesmentQuestion> sssesmentQuestionMasterData = FXCollections.observableArrayList();
	 
	public void refreshAssesmentQuestion() {

		sssesmentQuestionMasterData = new AssesmentQuestionEntityController().view();
		
		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		textCollumn.setCellValueFactory(cellValue -> cellValue.getValue().textProperty());
		
		FilteredList<AssesmentQuestion> filteredData = new FilteredList<AssesmentQuestion>(sssesmentQuestionMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(assesmentQuestion -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (assesmentQuestion.getText().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(assesmentQuestion -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return assesmentQuestion.getInactive();
					
				}

				return true;
			});

		});

		SortedList<AssesmentQuestion> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(assesmentQuestionTable.comparatorProperty());

		assesmentQuestionTable.setItems(sortedData);
		
		//assesmentQuestionTable.setItems(new AssesmentQuestionEntityController().view());
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshAssesmentQuestion();

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddAssesmentQuestion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddAssesmentQuestion", null, Locale.US);
				formPath.closeApplicationContext();

				AssessmentQuestionCodeInputController assessmentQuestionCodeInputController = (AssessmentQuestionCodeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				assessmentQuestionCodeInputController.setAssessmentQuestionCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EditAssesmentQuestion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditAssesmentQuestion", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				AssesmentQuestion assesmentQuestion = assesmentQuestionTable.getSelectionModel().getSelectedItem();
				if (assesmentQuestion != null) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					AssessmentQuestionCodeEditController editController = fxmlLoader.getController();
					editController.setAssesmentQuestion(assesmentQuestion);
					editController.setAssessmentQuestionCodeViewController(this);
					stage.show();
				} else {

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

				Integer assesmentQuestionSelectedIndex = assesmentQuestionTable.getSelectionModel().getSelectedIndex();
				if (assesmentQuestionSelectedIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						AssesmentQuestion assesmentQuestion = new AssesmentQuestionEntityController().view()
								.get(assesmentQuestionSelectedIndex);
						new AssesmentQuestionEntityController().delete(assesmentQuestion.getId());
						refreshAssesmentQuestion();

					} else {

					}

				} else {

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
		
	/*	topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(assesmentQuestionTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = assesmentQuestionTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(assesmentQuestionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = assesmentQuestionTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(assesmentQuestionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = assesmentQuestionTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(assesmentQuestionTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

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