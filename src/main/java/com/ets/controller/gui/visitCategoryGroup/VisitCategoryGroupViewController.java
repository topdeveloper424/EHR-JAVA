package com.ets.controller.gui.visitCategoryGroup;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.controller.entity.visitCategoryGroup.VisitCategoryGroupEntityController;
import com.ets.model.BillingServiceType;
import com.ets.model.RespiratorModel;
import com.ets.model.VisitCategoryGroup;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class VisitCategoryGroupViewController implements Initializable {
	
	@FXML
	private TextField searchTextField;
	
	@FXML
	private CheckBox includeInactiveCheckBox;
	
	  @FXML
	    private Button addButton;

	    @FXML
	    private Button cancelButton;
	    
	    @FXML
	    private Button changeButton;
	    
	    @FXML
	    private Button deleteButton;
	    
	    @FXML
	    private Button printButton;
	    
	    @FXML
	    private Button topButton; // Table Record Top Button
		
		@FXML
	    private Button upButton; // Table Record Up Button
		
		@FXML
	    private Button downButton; // Table Record Down Button
		
		@FXML
	    private Button bottomButton; // Table Record Bottom Button

	    @FXML
	    private TableView<VisitCategoryGroup> visitCategoryGroupTable;

	    @FXML
	    private TableColumn<VisitCategoryGroup, String> descriptionColumn;

	    @FXML
	    private TableColumn<VisitCategoryGroup, String> codeColumn;
	    
	    public void refreshCategoryGroup(){
	    	
	    	codeColumn.setCellValueFactory(new PropertyValueFactory<VisitCategoryGroup, String>("code"));
	    	descriptionColumn.setCellValueFactory(new PropertyValueFactory<VisitCategoryGroup, String>("descrip"));
			
	    }
	    
	    public void populateVisitCategoryGroupTable( ObservableList<VisitCategoryGroup> visitCategoryGroupList ) {
	    	visitCategoryGroupTable.setItems( visitCategoryGroupList );
		}
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 refreshCategoryGroup();
		
		
		
		 addButton.setOnAction((event) -> {
			try {
								
				String formName = formPath.context.getMessage("AddVisitCategoryGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddVisitCategoryGroup", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		topButton.setOnAction((event) -> {
			try {
				 UIRecordNavigation.setPosition( visitCategoryGroupTable , 0 );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = visitCategoryGroupTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;				
				UIRecordNavigation.setPosition( visitCategoryGroupTable , selectedIndex );
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		downButton.setOnAction((event) -> {			
			try {					
				Integer selectedIndex = visitCategoryGroupTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition( visitCategoryGroupTable , selectedIndex );					
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		bottomButton.setOnAction((event) -> {
			try {			
				int tempRowCount = visitCategoryGroupTable.getSelectionModel().getTableView().getItems().size();				
				--tempRowCount;
				UIRecordNavigation.setPosition( visitCategoryGroupTable , tempRowCount );		
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		// Centralised Form cancel
		cancelButton.setOnAction((event) -> {
					try {
						new FXFormCommonUtilities().closeForm(cancelButton);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		
		
		
	}

}
