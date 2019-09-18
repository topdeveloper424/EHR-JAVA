package com.ets.controller.gui.parentEmployerGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.parentEmployerGroup.ParentEmployerGroupEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.DepartmentUnit;
import com.ets.model.ParentEmployerGroup;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.ObservableList;
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
 *File Creation Date: 25-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupViewController Class
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

public class ParentEmployerGroupViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;
	
	@FXML
    private Button printButton;

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
	private TableView<ParentEmployerGroup> parentEmployerTable;

	@FXML
	private TableColumn<ParentEmployerGroup, String> employerCollumn;

	@FXML
	private TableColumn<ParentEmployerGroup, String> codeCollumn;

	@FXML
	private TableColumn<ParentEmployerGroup, String> cityCollumn;

	@FXML
	private TableColumn<ParentEmployerGroup, String> stateCollumn;

	@FXML
	private TableColumn<ParentEmployerGroup, String> telephoneCollumn;

	@FXML
	void doubleClicked(MouseEvent event) {

		if (event.getClickCount() == 2) {

			try {

				ParentEmployerGroup parentEmployerGroup = parentEmployerTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditParentEmployerGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditParentEmployerGroup", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ParentEmployerGroupEditController editController = fxmlLoader.getController();
				editController.setParentEmployerGroup(parentEmployerGroup);
				editController.setParentEmployerGroupViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	public void viewParentEmployerGroup() {

		codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		employerCollumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
		stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
		telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());

		parentEmployerTable.setItems(new ParentEmployerGroupEntityController().viewParentEmployerGroup());

	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		viewParentEmployerGroup();

		addButton.setOnAction((event) -> {
			try {
				// Load Corporate Parent Employer Details Entry form .

				String formName = formPath.context.getMessage("AddParentEmployerGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddParentEmployerGroup", null, Locale.US);
				formPath.closeApplicationContext();
				ParentEmployerGroupInputController parentEmployerGroupInputController = (ParentEmployerGroupInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				parentEmployerGroupInputController.setParentEmployerGroupViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				ParentEmployerGroup parentEmployerGroup = parentEmployerTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditParentEmployerGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditParentEmployerGroup", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (parentEmployerGroup != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ParentEmployerGroupEditController editController = fxmlLoader.getController();
					editController.setParentEmployerGroup(parentEmployerGroup);
					editController.setParentEmployerGroupViewController(this);

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

		// Delete Selected Row
		deleteButton.setOnAction((event) -> {
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer parentEmployerGroupIndex = parentEmployerTable.getSelectionModel().getSelectedIndex();
				if (parentEmployerGroupIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						ParentEmployerGroup parentEmployerGroup = new ParentEmployerGroupEntityController()
								.viewParentEmployerGroup().get(parentEmployerGroupIndex);
						new ParentEmployerGroupEntityController().delete(parentEmployerGroup.getId());
						viewParentEmployerGroup();

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

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ParentEmployerGroup", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<ParentEmployerGroup>> task =

					new Task<ObservableList<ParentEmployerGroup>>() {
						@Override
						protected ObservableList<ParentEmployerGroup> call() throws Exception {

							ObservableList<ParentEmployerGroup> parentEmployerGroupList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.ParentEmployerGroup", null, Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								parentEmployerGroupList = new ParentEmployerGroupEntityController().viewParentEmployerGroup();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(parentEmployerGroupList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return parentEmployerGroupList;
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
		 * End of printBtn.setOnAction(..)
		 *************************************************************/

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(parentEmployerTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = parentEmployerTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(parentEmployerTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = parentEmployerTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(parentEmployerTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = parentEmployerTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(parentEmployerTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
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
