package com.ets.controller.gui.naicsCode;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.naicsCode.NaicsCodeEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.parentEmployerGroup.ParentEmployerGroupInputController;
import com.ets.controller.gui.workLocation.WorkLocationInputController;
import com.ets.model.NAICSCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeViewController Class
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

public class NaicsCodeViewController implements Initializable {

	@FXML
	private TableView<NAICSCode> naicsTable;

	@FXML
	private TableColumn<NAICSCode, String> codeCol;

	@FXML
	private TableColumn<NAICSCode, String> descrpCol;

	@FXML
	private Button addBtn;

	@FXML
	private Button changeBtn;

	@FXML
	private Button deleteBtn;

	@FXML
	private Button selectButton;

	@FXML
	private Button closeBtn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	private ParentEmployerGroupInputController parentEmployerGroupInputController;

	public void setParentEmployerGroupInputController(
			ParentEmployerGroupInputController parentEmployerGroupInputController) {
		this.parentEmployerGroupInputController = parentEmployerGroupInputController;
	}

	private WorkLocationInputController workLocationInputController;

	public void setWorkLocationInputController(WorkLocationInputController workLocationInputController) {
		this.workLocationInputController = workLocationInputController;
	}
	
	private CompanyInputController companyInputController;
	

	public void setCompanyInputController(CompanyInputController companyInputController) {
		this.companyInputController = companyInputController;
	}
	
	private CompanyEditController companyEditController;
	
	public void setCompanyEditController(CompanyEditController companyEditController) {
		this.companyEditController = companyEditController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codeCol.setCellValueFactory(new PropertyValueFactory<NAICSCode, String>("code"));
		descrpCol.setCellValueFactory(new PropertyValueFactory<NAICSCode, String>("descrp"));

		naicsTable.setItems(new NaicsCodeEntityController().viewNAICSCode());

		addBtn.setOnAction((event) -> {
			try {
				// Load NAICS Code Details Entry form .

				String formName = formPath.context.getMessage("AddNAICSCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddNAICSCode", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeBtn.setOnAction((event) -> {
			try {
				// Load NAICSCode Details Edit form .

				NAICSCode naicsCode = naicsTable.getSelectionModel().getSelectedItem();
				
				String formName = formPath.context.getMessage("EditNAICSCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditNAICSCode", null, Locale.US);
				formPath.closeApplicationContext();
				
				FXMLLoader fxmlLoader = new FXMLLoader(
						getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();

				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				NaicsCodeEditController editController = fxmlLoader.getController();
				editController.setnAICSCode(naicsCode);

				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deleteBtn.setOnAction((event) -> {

			// Delete NAICSCode Details
			try {

				Integer naics = naicsTable.getSelectionModel().getSelectedIndex();
				NAICSCode naicsCode = new NaicsCodeEntityController().viewNAICSCode().get(naics);
				new NaicsCodeEntityController().removeNAICSCode(naicsCode.getId());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		selectButton.setOnAction((event) -> {
			
			NAICSCode selectedNaicsCode = this.naicsTable.getSelectionModel().getSelectedItem();

			if (parentEmployerGroupInputController != null) {

				this.parentEmployerGroupInputController.setNAICSCode(selectedNaicsCode.getCode());

			}else if (workLocationInputController != null) {
				
				this.workLocationInputController.setNaicsCode(selectedNaicsCode.getCode());
				
			}/*else if (companyInputController != null) {
				
				companyInputController.setNaicsCode(selectedNaicsCode.getCode());
				
			}*/else if (companyEditController != null) {
				
				//companyEditController.setNaicsCode(selectedNaicsCode.getCode());
			}
			
			new FXFormCommonUtilities().closeForm(selectButton);
			
			

		});

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(naicsTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = naicsTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(naicsTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = naicsTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(naicsTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = naicsTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(naicsTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
*/
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
