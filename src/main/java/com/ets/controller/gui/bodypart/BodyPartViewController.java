package com.ets.controller.gui.bodypart;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.bodypart.BodyPartEntityController;
import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BodyPart;
import com.ets.model.BodyZone;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 19-02-2016
 *
 * Module Name: Parameter Definition: Type object of BodyPartViewController
 * Class Description: View.fxml Controller class Copyright
 * 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification:
 * 
 * @author Sumanta Deyashi
 * @since 19-02-2016
 * @version 1.0 Description: Backup Location for Previous Version:
 *
 *          Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class BodyPartViewController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private TextField searchTextBox;

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
	private Button bottomButton;

	@FXML
	private TableView<BodyPart> bodyPartTable;

	@FXML
	private TableColumn<BodyPart, String> descriptionCollumn;

	@FXML
	private TableColumn<BodyPart, String> bodyPartCollumn;
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		try {
			// Load Body Part Code Details Entry form .
			String formName = formPath.context.getMessage("AddBodyPart", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddBodyPart", null, Locale.US);
			formPath.closeApplicationContext();
			BodyPartInputController BodyPartInputContttroller = (BodyPartInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			BodyPartInputContttroller.setBodyPartViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			// Load Body Part Code Details Entry form .

			BodyPart bodyPart = bodyPartTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditBodyPart", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditBodyPart", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (bodyPart != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				BodyPartEditController editController = fxmlLoader.getController();
				editController.setBodyPart(bodyPart);
				editController.setBodyPartViewController(this);
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
		// Delete BodyPart Details

		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer part = bodyPartTable.getSelectionModel().getSelectedIndex();

			if (part > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					BodyPart bodyPart = new BodyPartEntityController().viewBodyParts().get(part);
					new BodyPartEntityController().removeBodyPart(bodyPart.getId());
					populateBodyPartTable(new BodyPartEntityController().viewBodyParts());
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

		ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities().displayFormAndGetController(formName1, formTitle1);
		ProgressBar progressBar = progressBarGUIController.getProgressBar();

		/********************************
		 * Start of Task definition
		 *****************************************************************/
		Task<ObservableList<BodyPart>> task =

				new Task<ObservableList<BodyPart>>() {

					@Override
					protected ObservableList<BodyPart> call() throws Exception {

						ObservableList<BodyPart> bodyPartList = null;

						try {
							String printBodyPart = formPath.context.getMessage("Print.BodyPart", null, Locale.US);

							formPath.closeApplicationContext();
							//InputStream is = new FileInputStream(new File(printBodyPart));
							InputStream is = this.getClass().getResourceAsStream(printBodyPart);
							JasperReport jasperReport = JasperCompileManager.compileReport(is);

							bodyPartList = new BodyPartEntityController().viewBodyParts();
							JRDataSource JRdataSource = new JRBeanCollectionDataSource(bodyPartList);
							Map<String, Object> map = new HashMap<String, Object>();
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

							JasperViewer.viewReport(jasperPrint, false);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						if (isCancelled()) {
							return null;
						}
						return bodyPartList;
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
	}	

	public void refreshBodyPart() {

		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<BodyPart, String>("descrp"));
		bodyPartCollumn.setCellValueFactory(new PropertyValueFactory<BodyPart, String>("part"));

	}

	public void populateBodyPartTable(ObservableList<BodyPart> bodyPartCodeList) {
		
FilteredList<BodyPart> filteredData = new FilteredList<BodyPart>(bodyPartCodeList, p -> true);
		
		searchTextBox.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(bodyPart -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (bodyPart.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(bodyPart -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return bodyPart.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<BodyPart> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(bodyPartTable.comparatorProperty());
				
		bodyPartTable.setItems(sortedData);
		
		//bodyPartTable.setItems(bodyPartCodeList);
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Body Part Code Details Entry form .

				BodyPart bodyPart = bodyPartTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditBodyPart", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBodyPart", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				BodyPartEditController editController = fxmlLoader.getController();
				editController.setBodyPart(bodyPart);
				editController.setBodyPartViewController(this);

				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshBodyPart();

		addButton.setOnAction((event) -> {
			try {
				// Load Body Part Code Details Entry form .

				String formName = formPath.context.getMessage("AddBodyPart", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddBodyPart", null, Locale.US);
				formPath.closeApplicationContext();
				BodyPartInputController BodyPartInputContttroller = (BodyPartInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				BodyPartInputContttroller.setBodyPartViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Body Part Code Details Entry form .

				BodyPart bodyPart = bodyPartTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditBodyPart", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBodyPart", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (bodyPart != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					BodyPartEditController editController = fxmlLoader.getController();
					editController.setBodyPart(bodyPart);
					editController.setBodyPartViewController(this);
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

			// Delete BodyPart Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer part = bodyPartTable.getSelectionModel().getSelectedIndex();

				if (part > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						BodyPart bodyPart = new BodyPartEntityController().viewBodyParts().get(part);
						new BodyPartEntityController().removeBodyPart(bodyPart.getId());
						populateBodyPartTable(new BodyPartEntityController().viewBodyParts());
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

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(bodyPartTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = bodyPartTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(bodyPartTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = bodyPartTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(bodyPartTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = bodyPartTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(bodyPartTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
*/
		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BodyPart>> task =

					new Task<ObservableList<BodyPart>>() {

						@Override
						protected ObservableList<BodyPart> call() throws Exception {

							ObservableList<BodyPart> bodyPartList = null;
							ObservableList<BodyZone> bodyZoneList = null;

							try {

								String printBodyPart = formPath.context.getMessage("Print.BodyPart", null, Locale.US);

								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printBodyPart));
								InputStream is = this.getClass().getResourceAsStream(printBodyPart);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								bodyPartList = new BodyPartEntityController().viewBodyParts();
								bodyZoneList = new BodyZoneEntityController().viewBodyZone();
								Map<String, Object> map2 = new HashMap<String, Object>();
								//map2.put("part", bodyPartList);
								map2.put("zonetab", bodyZoneList);
								 JRBeanCollectionDataSource JRdataSource = new JRBeanCollectionDataSource(bodyPartList);
								//JRDataSource JRdataSource = new JRBeanCollectionDataSource(bodyPartList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map2, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return bodyPartList;
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

		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
