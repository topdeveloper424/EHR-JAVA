package com.ets.controller.gui.rootCause;




import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.rootCause.RootCauseEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.InjuryCode;
import com.ets.model.RootCause;
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
import javafx.scene.input.KeyEvent;
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
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseViewController Class
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

public class RootCauseViewController implements Initializable {

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
	private TableView<RootCause> rootCauseTable;

	@FXML
	private TableColumn<RootCause, String> descriptionCollumn;

	@FXML
	private TableColumn<RootCause, String> rootCauseCollumn;

	@FXML
	private Button printButton;	
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		try {
			// Load Root Cause Details Entry form .
			String formName = formPath.context.getMessage("AddRootCause", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddRootCause", null, Locale.US);
			formPath.closeApplicationContext();
			RootCauseInputController rootCauseInputController = (RootCauseInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			rootCauseInputController.setRootCauseViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			// Load rootCause Details Update form .

			RootCause rootCause = rootCauseTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditRootCause", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditRootCause", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (rootCause != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				RootCauseEditController controller = fxmlLoader.getController();
				controller.setRootCause(rootCause);
				controller.setRootCauseViewController(this);
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
	}

	@FXML
	void enterKeyPressedForCloseButton(KeyEvent event) {
		try {
			new FXFormCommonUtilities().closeForm(closeButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForDeleteButton(KeyEvent event) {
		// Delete Root Cause Details
		
		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer root = rootCauseTable.getSelectionModel().getSelectedIndex();

			if (root > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					RootCause rootCause = new RootCauseEntityController().viewRootCause().get(root);
					new RootCauseEntityController().removeRootCause(rootCause.getId());

					populateRootCauseTable(new RootCauseEntityController().viewRootCause());
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
	}

	@FXML
	void enterKeyPressedForPrintButton(KeyEvent event) {
		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

		String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
		formPath.closeApplicationContext();

		// Need the ProgressBar controller to access the progress bar in
		// this method
		ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities().displayFormAndGetController(formName1, formTitle1);
		ProgressBar progressBar = progressBarGUIController.getProgressBar();

		/********************************
		 * Start of Task definition
		 *****************************************************************/
		Task<ObservableList<RootCause>> task =

				new Task<ObservableList<RootCause>>() {

					@Override
					protected ObservableList<RootCause> call() throws Exception {

						ObservableList<RootCause> rootCauseList = null;

						try {
							String printRootCause = formPath.context.getMessage("Print.RootCause", null, Locale.US);
							formPath.closeApplicationContext();
							InputStream is = new FileInputStream(new File(printRootCause));

							JasperReport jasperReport = JasperCompileManager.compileReport(is);

							rootCauseList = new RootCauseEntityController().viewRootCause();
							JRDataSource JRdataSource = new JRBeanCollectionDataSource(rootCauseList);
							Map<String, Object> map = new HashMap<String, Object>();
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

							JasperViewer.viewReport(jasperPrint, false);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						if (isCancelled()) {
							return null;
						}
						return rootCauseList;
					}
				};
		/*************************
		 * End of Task definition
		 *****************************************************************/

		task.setOnSucceeded(event1 -> {

			// Close Progress Bar Form
			Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
			stage.close();

		});

		progressBar.progressProperty().bind(task.progressProperty());

		try {
			// Start background thread for database record retrieval .
			new Thread(task).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public void refreshRootCause() {

		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<RootCause, String>("descrp"));
		rootCauseCollumn.setCellValueFactory(new PropertyValueFactory<RootCause, String>("cause"));

	}

	public void populateRootCauseTable(ObservableList<RootCause> rootCauseList) {
		
FilteredList<RootCause> filteredData = new FilteredList<RootCause>(rootCauseList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(rootCause -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (rootCause.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(rootCause -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return rootCause.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<RootCause> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(rootCauseTable.comparatorProperty());
				
		rootCauseTable.setItems(sortedData);
		
		//rootCauseTable.setItems(rootCauseList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Division Details Edit form .
				RootCause rootCause = rootCauseTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditRootCause", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditRootCause", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();

				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				RootCauseEditController editController = fxmlLoader.getController();
				editController.setRootCause(rootCause);
				editController.setRootCauseViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshRootCause();

		addButton.setOnAction((event) -> {
			try {
				// Load Root Cause Details Entry form .

				String formName = formPath.context.getMessage("AddRootCause", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddRootCause", null, Locale.US);
				formPath.closeApplicationContext();
				RootCauseInputController rootCauseInputController = (RootCauseInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				rootCauseInputController.setRootCauseViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				// Load rootCause Details Update form .

				RootCause rootCause = rootCauseTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditRootCause", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditRootCause", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (rootCause != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					RootCauseEditController controller = fxmlLoader.getController();
					controller.setRootCause(rootCause);
					controller.setRootCauseViewController(this);
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

			// Delete Root Cause Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer root = rootCauseTable.getSelectionModel().getSelectedIndex();

				if (root > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						RootCause rootCause = new RootCauseEntityController().viewRootCause().get(root);
						new RootCauseEntityController().removeRootCause(rootCause.getId());

						populateRootCauseTable(new RootCauseEntityController().viewRootCause());

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

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(rootCauseTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = rootCauseTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(rootCauseTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = rootCauseTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(rootCauseTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = rootCauseTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(rootCauseTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<RootCause>> task =

					new Task<ObservableList<RootCause>>() {

						@Override
						protected ObservableList<RootCause> call() throws Exception {

							ObservableList<RootCause> rootCauseList = null;

							try {

								String printRootCause = formPath.context.getMessage("Print.RootCause", null, Locale.US);
								formPath.closeApplicationContext();
								InputStream is = this.getClass().getResourceAsStream(printRootCause);
								//InputStream is = new FileInputStream(new File(printRootCause));

								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								rootCauseList = new RootCauseEntityController().viewRootCause();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(rootCauseList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return rootCauseList;
						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of printBtn.setOnAction(..)
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
