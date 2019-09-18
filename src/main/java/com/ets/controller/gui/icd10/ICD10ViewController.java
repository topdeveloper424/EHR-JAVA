package com.ets.controller.gui.icd10;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 28-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ICD10GUIController Class
 *Description: EnterICD10.fxml Controller class
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

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.gui.district.DistrictInputController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.assesment.assesmentDiagonosis.AssesmentDiagonosisInputController;
import com.ets.controller.gui.emrCharting.assesment.icd10.ICD10SearchController;
import com.ets.controller.gui.icd10Diagonosis.ICD10DiagonosisInputController;
import com.ets.controller.gui.medicalCondition.MedicalConditionCodeEditController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Carrier;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.Icd10Codes;
import com.ets.model.JobClass;
import com.ets.model.MedicalCondition;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.FXCollections;
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

public class ICD10ViewController implements Initializable {

	@FXML
	private TextField descriptionContainsTextField;

	@FXML
	private TextField codesContainsTextField;

	@FXML
	private TextField searchTextField;
	

    @FXML
    private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button viewButton;
	
	@FXML
    private Button selectButton;

	@FXML
	private Button printButton;

	@FXML
	private TableView<Icd10Codes> viewIcd10Codes; // Icd10 Table View

	@FXML
	private TableColumn<Icd10Codes, String> descriptionColumn; // Icd10 Table
																// Column

	@FXML
	private TableColumn<Icd10Codes, String> codeColumn; // Icd10 Table Column

	@FXML
	private TableColumn<Icd10Codes, Boolean> obsoleteColumn; // Icd10 Table
															// Column

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button
	
    @FXML
    private Button deleteButton;
	
	@FXML
	private Button bottomButton; // Table Record Bottom Button
	
	
	private ICD10DiagonosisInputController iCD10DiagonosisInputController ;
	private Button button;
	

	public void setiCD10DiagonosisInputController(ICD10DiagonosisInputController iCD10DiagonosisInputController) {
		this.iCD10DiagonosisInputController = iCD10DiagonosisInputController;
     
	}

	private AssesmentDiagonosisInputController assesmentDiagonosisInputController;


	public void setAssesmentDiagonosisInputController(
			AssesmentDiagonosisInputController assesmentDiagonosisInputController) {
		this.assesmentDiagonosisInputController = assesmentDiagonosisInputController;
	}

	@FXML
    void doubleClick(MouseEvent event) {
		
		if (event.getClickCount() == 2) {
			try {

				String formName = formPath.context.getMessage("ViewICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10View", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Icd10Codes icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();

				if (icd10Codes != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();

					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					ICD10CodeViewDetailsController viewController = fxmlLoader.getController();
					viewController.setIcd10Codes(icd10Codes);
					viewController.setIcd10ViewController(this);
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
	
	public  Icd10Codes icd10Codes;
	private VisitLogInputController visitLogInputController;
		
	  public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
	}
	  
	  private ICD10SearchController icd10SearchController;

	public void setIcd10SearchController(ICD10SearchController icd10SearchController) {
		this.icd10SearchController = icd10SearchController;
	}

	private ObservableList<Icd10Codes> icd10CodesMasterData = FXCollections.observableArrayList();
	
	public void viewICD10Code(){
		
		icd10CodesMasterData = new Icd10CodesEntityController().viewIcd10Codes();
		
		codeColumn.setCellValueFactory(new PropertyValueFactory<Icd10Codes, String>("code"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Icd10Codes, String>("descrip"));
		obsoleteColumn.setCellValueFactory(new PropertyValueFactory<Icd10Codes, Boolean>("inactive"));
		
		
		FilteredList<Icd10Codes> filteredData = new FilteredList<Icd10Codes>(icd10CodesMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(icd10 -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (icd10.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		
		SortedList<Icd10Codes> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(viewIcd10Codes.comparatorProperty());

		viewIcd10Codes.setItems(sortedData);
		
		
		//viewIcd10Codes.setItems(new Icd10CodesEntityController().viewIcd10Codes());
		
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewICD10Code();
		
		addButton.setOnAction((event) -> {
			try {
				
				// Load ICD10 Details Entry form .

				String formName = formPath.context.getMessage("AddICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddICD10", null, Locale.US);
				formPath.closeApplicationContext();
				 ICD10InputController icd10InputController =  (ICD10InputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				 icd10InputController.setiCD10ViewController(this);


				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	
		viewButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("ViewICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10View", null, Locale.US);
				
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				Icd10Codes icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
				
				if(icd10Codes != null){
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					ICD10CodeViewDetailsController viewController = fxmlLoader.getController();
					viewController.setIcd10Codes(icd10Codes);
					viewController.setIcd10ViewController(this);

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
		
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ICD10Codes", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Icd10Codes>> task =

					new Task<ObservableList<Icd10Codes>>() {

						@Override
						protected ObservableList<Icd10Codes> call() throws Exception {

							ObservableList<Icd10Codes> icd10CodesList = null;

							try {

								

								String printCarrier= formPath.context.getMessage("Print.ICD10Codes", null, Locale.US);

								formPath.closeApplicationContext();

							//	InputStream is = new FileInputStream(new File(printCarrier));
								InputStream is = this.getClass().getResourceAsStream(printCarrier);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								icd10CodesList =new Icd10CodesEntityController().viewIcd10Codes();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(icd10CodesList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return icd10CodesList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
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


		deleteButton.setOnAction((event) -> {

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer icd10Index = viewIcd10Codes.getSelectionModel().getSelectedIndex();

				if (icd10Index > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						Icd10Codes icd10Codes = new Icd10CodesEntityController().viewIcd10Codes().get(icd10Index);
						
						
						//new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						viewICD10Code();

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
				UIRecordNavigation.setPosition(viewIcd10Codes, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = viewIcd10Codes.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(viewIcd10Codes, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = viewIcd10Codes.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(viewIcd10Codes, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = viewIcd10Codes.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(viewIcd10Codes, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		
		selectButton.setOnAction((event) -> {
			Icd10Codes icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			//CptCode4Hcpcs selectedCptCode4Hcpcs = this.cptTable.getSelectionModel().getSelectedItem();
				
			if(visitLogInputController != null){
				
				//this.medicalActivityCodeInputController.setCptCodeOrHecpcs(selectedCptCode4Hcpcs.getCode());
				visitLogInputController.setICD10(icd10Codes.getId());
				
			}
			
				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
		
*/		
		
		selectButton.setOnAction((event) -> {
			 icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			//CptCode4Hcpcs selectedCptCode4Hcpcs = this.cptTable.getSelectionModel().getSelectedItem();
				
			/*if(visitLogInputController != null){
				
				//this.medicalActivityCodeInputController.setCptCodeOrHecpcs(selectedCptCode4Hcpcs.getCode());
				sitLogInputController.setICD10(icd10Codes.getId());
				
			}*/
			 if(iCD10DiagonosisInputController!=null){
			
				this.iCD10DiagonosisInputController.seticdFromSearchBtn(icd10Codes);
				
			 }
			
			if(icd10SearchController != null){
				
				icd10SearchController.setICD10Code(icd10Codes.getCode());
				icd10SearchController.setDescripLabel(icd10Codes.getDescrip());
				
			}
			
			if(assesmentDiagonosisInputController != null){
				
				assesmentDiagonosisInputController.setIcd10(icd10Codes);     			
				
				
			}
			
			
				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
		
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
