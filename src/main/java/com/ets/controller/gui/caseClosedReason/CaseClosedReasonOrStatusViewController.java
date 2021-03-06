package com.ets.controller.gui.caseClosedReason;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.caseClosedReason.CaseClosedReasonStatusEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.CaseClosedReason;
import com.ets.model.InjuryCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonOrStatusViewController Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class CaseClosedReasonOrStatusViewController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

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
	private Button buttomButton;

	@FXML
	private TableView<CaseClosedReason> caseCloseTable;

	@FXML
	private TableColumn<CaseClosedReason, String> descriptionCollumn;

	@FXML
	private TableColumn<CaseClosedReason, String> codeCollumn;

	@FXML
	private Button printButton;

	@FXML
	private TextField searchTextField;

	public void refreshCaseClosed() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<CaseClosedReason, String>("reason"));
		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<CaseClosedReason, String>("descrp"));
	}

	public void populateCaseClosedReasonTable(ObservableList<CaseClosedReason> caseClosedReasonList) {
		
FilteredList<CaseClosedReason> filteredData = new FilteredList<CaseClosedReason>(caseClosedReasonList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(caseClosedReason -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (caseClosedReason.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(caseClosedReason -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return caseClosedReason.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<CaseClosedReason> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(caseCloseTable.comparatorProperty());
				
		caseCloseTable.setItems(sortedData);
		
		//caseCloseTable.setItems(caseClosedReasonList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				CaseClosedReason caseClosedReason = caseCloseTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditCaseClosed", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCaseClosed", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				CaseClosedReasonOrStatusEditController controller = fxmlLoader.getController();

				controller.setCaseClosedReason(caseClosedReason);
				controller.setCaseClosedReasonOrStatusViewController(this);

				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshCaseClosed();

		addButton.setOnAction((event) -> {
			try {
				// Load Case Closed Reason Or Status Details Entry form .

				String formName = formPath.context.getMessage("AddCaseClosed", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddCaseClosed", null, Locale.US);
				formPath.closeApplicationContext();
				CaseClosedReasonOrStatusInputController caseClosedReasonOrStatusInputController = (CaseClosedReasonOrStatusInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				caseClosedReasonOrStatusInputController.setCaseClosedReasonOrStatusViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {

			// Load Case Closed Reason Or Status Details Entry form .

			try {

				CaseClosedReason caseClosedReason = caseCloseTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditCaseClosed", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCaseClosed", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (caseClosedReason != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					CaseClosedReasonOrStatusEditController controller = fxmlLoader.getController();

					controller.setCaseClosedReason(caseClosedReason);
					controller.setCaseClosedReasonOrStatusViewController(this);
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

			// Delete Case Closed reason Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer caseClosed = caseCloseTable.getSelectionModel().getSelectedIndex();

				if (caseClosed > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						CaseClosedReason caseClosedReason = new CaseClosedReasonStatusEntityController()
								.viewCaseClosedReason().get(caseClosed);
						new CaseClosedReasonStatusEntityController().removeCaseClosedReason(caseClosedReason.getId());

						populateCaseClosedReasonTable(
								new CaseClosedReasonStatusEntityController().viewCaseClosedReason());

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
				UIRecordNavigation.setPosition(caseCloseTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = caseCloseTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(caseCloseTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = caseCloseTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(caseCloseTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = caseCloseTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(caseCloseTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*************************************
		 * Start of pharmacyBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.CaseClosed", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<CaseClosedReason>> task =

					new Task<ObservableList<CaseClosedReason>>() {

						@Override
						protected ObservableList<CaseClosedReason> call() throws Exception {

							ObservableList<CaseClosedReason> caseClosedReasonList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.CaseCloseReason", null,
										Locale.US);
								formPath.closeApplicationContext();
							//	InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								caseClosedReasonList = new CaseClosedReasonStatusEntityController()
										.viewCaseClosedReason();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(caseClosedReasonList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return caseClosedReasonList;
						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of pharmacyBtn.setOnAction(..)
		 *************************************************************/

		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
