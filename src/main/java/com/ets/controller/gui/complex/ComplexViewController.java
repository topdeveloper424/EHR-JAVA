package com.ets.controller.gui.complex;

import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryInputController;
import com.ets.controller.gui.Laboratories.LaboratoryViewController;
import com.ets.controller.gui.carriers.CarrierInputController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillInputController;
import com.ets.model.Complex;
import com.ets.model.District;
import com.ets.model.Division;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
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

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 22-02-2016 
 * Initial Version: 0.01 
 * Module Name: Parameter
 * Definition: Type object of ComplexViewController Class 
 * Description: View.fxml Controller class
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class ComplexViewController implements Initializable {

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
	    private Button selectButton;

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
	private TableView<Complex> complexTable;

	@FXML
	private TableColumn<Complex, String> codeCollumn;

	@FXML
	private TableColumn<Complex, String> nameCollumn;
	@FXML
    void enterKeyPressedFoCloseButton(KeyEvent event) {
		 if(event.getCode() == KeyCode.ENTER){
			 try {
					new FXFormCommonUtilities().closeForm(closeButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		 }

    }

    @FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
 if(event.getCode() == KeyCode.ENTER){
	 try {
			// Load Complex Details Entry form .

			String formName = formPath.context.getMessage("AddComplex", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddComplex", null, Locale.US);
			formPath.closeApplicationContext();
			ComplexInputController complexInputController = (ComplexInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			complexInputController.setComplexViewController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		 }

    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
 if(event.getCode() == KeyCode.ENTER){
	 try {
			// Load Cmplex Details Edit form .

			Complex complex = complexTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditComplex", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditComplex", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (complex != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ComplexEditController editController = fxmlLoader.getController();
				editController.setComplex(complex);
				editController.setComplexViewController(this);
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
    void enterKeyPressedForDeleteButton(KeyEvent event) {
 if(event.getCode() == KeyCode.ENTER){
	// Delete Complex Details
				try {

					String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
					String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
					String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
					String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

					formPath.closeApplicationContext();

					Integer comp = complexTable.getSelectionModel().getSelectedIndex();

					if (comp > -1) {

						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle(conformDialogBoxTitle);
						alert.setHeaderText(conformDelete);
						alert.setContentText(null);

						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {

							Complex complex = new ComplexEntityController().viewComplex().get(comp);
							new ComplexEntityController().removeComplex(complex.getId());
							populateComplexTable(new ComplexEntityController().viewComplex());

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
    }

    @FXML
    void enterKeyPressedForSelectButton(KeyEvent event) {
 if(event.getCode() == KeyCode.ENTER){
	 Complex selectedComplex = this.complexTable.getSelectionModel().getSelectedItem();
		
		if(carrierInputController != null){
			
			carrierInputController.setComplex(selectedComplex.getCode());
			
		}else if (mcoTpaBillInputController != null) {
			
			mcoTpaBillInputController.setComplex(selectedComplex.getCode());
		}
		
		else if (laboratoryInputController != null) {
			
			laboratoryInputController.setComplex(selectedComplex.getCode());
		}
								
			new FXFormCommonUtilities().closeForm(selectButton);
		
		 }
    }

	
private CarrierInputController carrierInputController;
	

	public void setCarrierInputController(CarrierInputController carrierInputController) {
		this.carrierInputController = carrierInputController;
	}
	
private McoTpaBillInputController mcoTpaBillInputController;
	

	public void setMcoTpaBillInputController(McoTpaBillInputController mcoTpaBillInputController) {
		this.mcoTpaBillInputController = mcoTpaBillInputController;
	}
	
	private LaboratoryInputController laboratoryInputController;
	

	public void setLaboratoryInputController(LaboratoryInputController laboratoryInputController) {
		this.laboratoryInputController = laboratoryInputController;
	}

	public void refreshComplex() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<Complex, String>("code"));
		nameCollumn.setCellValueFactory(new PropertyValueFactory<Complex, String>("name"));

	}

	public void populateComplexTable(ObservableList<Complex> complexTableList) {
		
FilteredList<Complex> filteredData = new FilteredList<Complex>(complexTableList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(complex -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (complex.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(complex -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return complex.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Complex> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(complexTable.comparatorProperty());
				
		complexTable.setItems(sortedData);
		
		//complexTable.setItems(complexTableList);
	}

	@FXML
	void doubleClick(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				
				Complex complex = complexTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditComplex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditComplex", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ComplexEditController editController = fxmlLoader.getController();
				editController.setComplex(complex);
				editController.setComplexViewController(this);
				stage.show();
				
				 
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshComplex();

		addButton.setOnAction((event) -> {
			try {
				// Load Complex Details Entry form .

				String formName = formPath.context.getMessage("AddComplex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddComplex", null, Locale.US);
				formPath.closeApplicationContext();
				ComplexInputController complexInputController = (ComplexInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				complexInputController.setComplexViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				Complex complex = complexTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditComplex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditComplex", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (complex != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					ComplexEditController editController = fxmlLoader.getController();
					editController.setComplex(complex);
					editController.setComplexViewController(this);
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
			// Delete Complex Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer comp = complexTable.getSelectionModel().getSelectedIndex();

				if (comp > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						Complex complex = new ComplexEntityController().viewComplex().get(comp);
						new ComplexEntityController().removeComplex(complex.getId());
						populateComplexTable(new ComplexEntityController().viewComplex());

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
		
		
		selectButton.setOnAction((event) -> {
			
			Complex selectedComplex = this.complexTable.getSelectionModel().getSelectedItem();
			
			if(carrierInputController != null){
				
				carrierInputController.setComplex(selectedComplex.getCode());
				
			}else if (mcoTpaBillInputController != null) {
				
				mcoTpaBillInputController.setComplex(selectedComplex.getCode());
			}
			
			else if (laboratoryInputController != null) {
				
				laboratoryInputController.setComplex(selectedComplex.getCode());
			}
									
				new FXFormCommonUtilities().closeForm(selectButton);
			
		});
/*
		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(complexTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = complexTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(complexTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = complexTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(complexTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = complexTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(complexTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

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
