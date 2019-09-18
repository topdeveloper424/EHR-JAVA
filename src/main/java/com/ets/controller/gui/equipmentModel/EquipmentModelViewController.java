package com.ets.controller.gui.equipmentModel;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.equipmentModel.EquipmentModelEntityController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.pulmonaryFunction.SpiroMeterInputController;
import com.ets.controller.gui.visionTesting.VisionTestEquipmentInputController;
import com.ets.controller.gui.vitalReader.VitalReaderEditController;
import com.ets.controller.gui.vitalReader.VitalReaderInputController;
import com.ets.controller.gui.vitalReader.VitalReaderViewContoller;
import com.ets.model.Complex;
import com.ets.model.EquipmentModel;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EquipmentModelViewController implements Initializable {

	@FXML
	private TableView<EquipmentModel> equipmentModelTable;

	@FXML
	private TableColumn<EquipmentModel, String> modelCollumn;

	@FXML
	private TableColumn<EquipmentModel, String> descriptionCollumn;

	@FXML
	private TableColumn<EquipmentModel, String> testCollumn;

	@FXML
	private Button addButton;

	@FXML
	private Button changeBtn;

	@FXML
	private Button closeButton;

	@FXML
	private Button deleteBtn;

	@FXML
	private Button selectBtn;

	private SpiroMeterInputController spiroMeterInputController;

	public void setSpiroMeterInputController(SpiroMeterInputController spiroMeterInputController) {
		this.spiroMeterInputController = spiroMeterInputController;
	}

	private VitalReaderEditController vitalReaderEditController;
		

    
    private Button button;
    	
	    

		private static EquipmentModelViewController equipmentModelViewController;
	     
	    		
		/*public void setEquipmentModelViewController(EquipmentModelViewController equipmentModelViewController, Button button) {
			this.equipmentModelViewController = equipmentModelViewController;
			this.button= button;
		}*/

		public static void setEquipmentModelViewController(EquipmentModelViewController equipmentModelViewController) {
			EquipmentModelViewController.equipmentModelViewController = equipmentModelViewController;
		}
		
		public static void setEquipmentModelViewController(EquipmentModelViewController equipmentModelViewController,Button button) {
			EquipmentModelViewController.equipmentModelViewController = equipmentModelViewController;
			button= button;
		}

		private  ObservableList<EquipmentModel> equipmentModelMasterData = FXCollections.observableArrayList();
	    
	    public void showEquipmentModelData(){
	    	
	    	
	    	equipmentModelMasterData = new EquipmentModelEntityController().viewEquipmentModel();
	    	
	    }
	    
	    public void viewEquipmentModel(){
	    		    	
	    	//equipmentModelMasterData = new EquipmentModelEntityController().viewEquipmentModel();
	    	modelCollumn.setCellValueFactory(cellData -> cellData.getValue().modelNoProperty());
	    	descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descrpProperty());
	    	
	    		/*if(button.getId().equals("selectBtn")){
	    			
	    			testCollumn.setCellValueFactory(cellData -> cellData.getValue().descrpProperty());
	    			System.out.println("TEST Successful #####################");
	    			
	    		}   */ 	
	    	equipmentModelTable.refresh();
	    	equipmentModelTable.setItems(equipmentModelMasterData);
	    		    	
	    }
	    
	    public void viewEquipmentModel2(){
	    	System.out.println("RUN #################");
	    	equipmentModelTable.refresh();
	    	//equipmentModelMasterData = new EquipmentModelEntityController().viewEquipmentModel();
	    	modelCollumn.setCellValueFactory(cellData -> cellData.getValue().modelNoProperty());
	    	//descriptionCollumn.setCellValueFactory(null);
	    	//descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descrpProperty());
	    	testCollumn.setCellValueFactory(cellData -> cellData.getValue().descrpProperty());    	
	    	equipmentModelTable.setItems(equipmentModelMasterData);
	    		    	
	    }
	    
	    FXMLFormPath formPath = new FXMLFormPath();
		
	public void setVitalReaderEditController(VitalReaderEditController vitalReaderEditController) {
		this.vitalReaderEditController = vitalReaderEditController;
	}

	private VitalReaderInputController vitalReaderInputController;
	
	
	public void setVitalReaderInputController(VitalReaderInputController vitalReaderInputController) {
		this.vitalReaderInputController = vitalReaderInputController;
	}


	private VisionTestEquipmentInputController visionTestEquipmentInputController;

	public void setVisionTestEquipmentInputController(
			VisionTestEquipmentInputController visionTestEquipmentInputController) {
		this.visionTestEquipmentInputController = visionTestEquipmentInputController;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {


		viewEquipmentModel();

		addButton.setOnAction((event) -> {
			try {


				String formName = FXMLFormPath.context.getMessage("AddEquipmentModel", null, Locale.US);
				String formTitle = FXMLFormPath.context.getMessage("Title.AddEquipmentModel", null, Locale.US);
				

				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deleteBtn.setOnAction((event) -> {
			try {

				String deleteInfo = FXMLFormPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = FXMLFormPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = FXMLFormPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = FXMLFormPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer comp = equipmentModelTable.getSelectionModel().getSelectedIndex();

				if (comp > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						EquipmentModel equipmentModel = new EquipmentModelEntityController().viewEquipmentModel()
								.get(comp);
						new EquipmentModelEntityController().removeEquipmentModel(equipmentModel.getId());

						viewEquipmentModel();

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

		changeBtn.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				EquipmentModel equipmentModel = equipmentModelTable.getSelectionModel().getSelectedItem();

				String formName = FXMLFormPath.context.getMessage("EditEquipmentModel", null, Locale.US);
				String formTitle = FXMLFormPath.context.getMessage("Title.EditEquipmentModel", null, Locale.US);

				String editInfo = FXMLFormPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = FXMLFormPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (equipmentModel != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					EquipmentModelEditController editController = fxmlLoader.getController();
					editController.setEquipmentModel(equipmentModel);
					editController.setEquipmentModelViewController(this);
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

		selectBtn.setOnAction((event) -> {

			
			showEquipmentModelData();
			viewEquipmentModel2();
			

			try {

				EquipmentModel equipmentModel = equipmentModelTable.getSelectionModel().getSelectedItem();
				if (spiroMeterInputController != null) {

					spiroMeterInputController.setEquipmentModel(equipmentModel.getModelNo());
				}

				else if (visionTestEquipmentInputController != null) {
					visionTestEquipmentInputController.setEquipmentModel(equipmentModel.getModelNo());

				}
				
				else if (vitalReaderInputController != null) {
					vitalReaderInputController.setEquipmentModel(equipmentModel.getModelNo());

				}
				
				new FXFormCommonUtilities().closeForm(selectBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
