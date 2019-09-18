package com.ets.controller.gui.injuryCode;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.exposureCode.ExposureCodeEntityController;
import com.ets.controller.entity.illnessCode.IllnessCodeEntityController;
import com.ets.controller.entity.injuryCode.InjuryCodeEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Complex;
import com.ets.model.ExposureCode;
import com.ets.model.IllnessCode;
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
import javafx.scene.input.KeyCode;
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
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeViewController Class
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

public class InjuryCodeViewController implements Initializable {

	@FXML
	private TableView<InjuryCode> injuryTable; // Injury Code Table View

	@FXML
	private TableColumn<InjuryCode, String> descriptionCollumn; // Injury Code
																// Table Column

	@FXML
	private TableColumn<InjuryCode, String> codeCollumn; // Injury Code Table
															// Column

	@FXML
	private TableColumn<InjuryCode, String> wc10Collumn; // Injury Code Table
															// Column

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button addBtn; // Table Record Add Button

	@FXML
	private Button changeBtn; // Table Record Update Button

	@FXML
	private Button deleteBtn; // Table Record Delete Button

	@FXML
	private Button printBtn; // Table Record Print Button

	@FXML
	private Button closeBtn; // Close window button

	@FXML
	private Button topBtn; // Table Record Top Button

	@FXML
	private Button upBtn; // Table Record Up Button

	@FXML
	private Button downBtn; // Table Record Down Button

	@FXML
	private Button bottomBtn; // Table Record Bottom Button
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				// Load Injury Code Details Entry form .

				String formName = formPath.context.getMessage("AddInjuryCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddInjuryCode", null, Locale.US);
				formPath.closeApplicationContext();
				InjuryCodeInputController injuryCodeInputController = (InjuryCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				injuryCodeInputController.setInjuryCodeViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				// Load Injury Code Details Update form .
				InjuryCode injuryCode = injuryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditInjuryCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditInjuryCode", null, Locale.US);
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (injuryCode != null) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					InjuryCodeEditController controller = fxmlLoader.getController();
					controller.setInjuryCode(injuryCode);
					controller.setInjuryCodeViewController(this);

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
	}

	@FXML
	void enterKeyPressedForCloseButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@FXML
	void enterKeyPressedForDeleteButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			// Delete Injury Code Details .
			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer injuryCode = injuryTable.getSelectionModel().getSelectedIndex();
				if (injuryCode > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						InjuryCode ic = new InjuryCodeEntityController().viewInjuryCode().get(injuryCode);
						new InjuryCodeEntityController().removeInjuryCode(ic.getId());
						populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());
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
			refreshInjuryCode();
		}
	}

	@FXML
	void enterKeyPressedForPrintButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
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
			Task<ObservableList<InjuryCode>> task =

					new Task<ObservableList<InjuryCode>>() {

						@Override
						protected ObservableList<InjuryCode> call() throws Exception {

							ObservableList<InjuryCode> injuryCodeList = null;

							try {

								String printInjuryCode = formPath.context.getMessage("Print.InjuryCode", null, Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printInjuryCode));
								InputStream is = this.getClass().getResourceAsStream(printInjuryCode);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								injuryCodeList = new InjuryCodeEntityController().viewInjuryCode();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(injuryCodeList);
								Map<String, Object> map = new HashMap<String, Object>();
								List<IllnessCode> illnessCodes = new IllnessCodeEntityController().viewIllnessCode();
								map.put("illness", illnessCodes);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return injuryCodeList;

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
	}

	public void refreshInjuryCode() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<InjuryCode, String>("code"));
		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<InjuryCode, String>("descrp"));
		wc10Collumn.setCellValueFactory(new PropertyValueFactory<InjuryCode, String>("wc10Code"));

	}

	public void populateInjuryTable(ObservableList<InjuryCode> inuryCodeList) {
		
FilteredList<InjuryCode> filteredData = new FilteredList<InjuryCode>(inuryCodeList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(injuryCode -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (injuryCode.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(injuryCode -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return injuryCode.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<InjuryCode> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(injuryTable.comparatorProperty());
				
		injuryTable.setItems(sortedData);
		
		//injuryTable.setItems(inuryCodeList);
	}

	@FXML
	void doubleClick(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				// Load Injury Code Details Update form .

				InjuryCode injuryCode = injuryTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditInjuryCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditInjuryCode", null, Locale.US);
				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				InjuryCodeEditController controller = fxmlLoader.getController();
				controller.setInjuryCode(injuryCode);
				controller.setInjuryCodeViewController(this);

				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshInjuryCode();

		addBtn.setOnAction((event) -> {
			try {
				// Load Injury Code Details Entry form .

				String formName = formPath.context.getMessage("AddInjuryCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddInjuryCode", null, Locale.US);
				formPath.closeApplicationContext();
				InjuryCodeInputController injuryCodeInputController = (InjuryCodeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				injuryCodeInputController.setInjuryCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeBtn.setOnAction((event) -> {
			try {

				// Load Injury Code Details Update form .
				InjuryCode injuryCode = injuryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditInjuryCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditInjuryCode", null, Locale.US);
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (injuryCode != null) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					InjuryCodeEditController controller = fxmlLoader.getController();
					controller.setInjuryCode(injuryCode);
					controller.setInjuryCodeViewController(this);

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

		deleteBtn.setOnAction((event) -> {

			// Delete Injury Code Details .

			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer injuryCode = injuryTable.getSelectionModel().getSelectedIndex();
				if (injuryCode > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						InjuryCode ic = new InjuryCodeEntityController().viewInjuryCode().get(injuryCode);
						new InjuryCodeEntityController().removeInjuryCode(ic.getId());
						populateInjuryTable(new InjuryCodeEntityController().viewInjuryCode());

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
			refreshInjuryCode();

		});

		/*topBtn.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(injuryTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upBtn.setOnAction((event) -> {
			try {
				Integer selectedIndex = injuryTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(injuryTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downBtn.setOnAction((event) -> {
			try {
				Integer selectedIndex = injuryTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(injuryTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomBtn.setOnAction((event) -> {
			try {
				int tempRowCount = injuryTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(injuryTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/
		
		printBtn.setOnAction((event) -> {

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
			Task<ObservableList<InjuryCode>> task =

					new Task<ObservableList<InjuryCode>>() {

						@Override
						protected ObservableList<InjuryCode> call() throws Exception {

							ObservableList<InjuryCode> injuryCodeList = null;
							ObservableList<IllnessCode> illnessCodeList = null;
							ObservableList<ExposureCode> exposureCodeList = null;

							try {

								String printInjuryCode = formPath.context.getMessage("Print.InjuryCode", null,
										Locale.US);
								String printIllnessCode = formPath.context.getMessage("Print.IllnessCode", null,
										Locale.US);
								
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printInjuryCode));
								InputStream is = this.getClass().getResourceAsStream(printInjuryCode);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								
								
								injuryCodeList = new InjuryCodeEntityController().viewInjuryCode();
								//JRDataSource JRdataSource = new JRBeanCollectionDataSource(injuryCodeList);
								 illnessCodeList = new IllnessCodeEntityController().viewIllnessCode();
								 exposureCodeList = new ExposureCodeEntityController().viewExposureCode();
								//IllnessCode illnessCodeList = new IllnessCodeEntityController().viewIllnessCode().get(0);
								System.out.println("Illnes Code is----" +illnessCodeList.size());
								Map<String, Object> map = new HashMap<String, Object>();
								
								map.put("illness", illnessCodeList);
								map.put("Str", "INDIAN");
								
								
								//map.put("subReport", jasperReportSub);
								//map.put("injuryCodeList", injuryCodeList);
								
								
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(injuryCodeList);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);
								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return injuryCodeList;

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
		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
