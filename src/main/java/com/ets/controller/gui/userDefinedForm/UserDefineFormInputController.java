package com.ets.controller.gui.userDefinedForm;

import java.io.File;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 04-07-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DefineaFormController Class
 *Description: DefineaForm.fxml Controller class
 *Copyright 2017 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2017 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/
import java.io.IOException;
import java.net.URL;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;



import com.ets.controller.entity.userDefinedForm.UserDefinedFormEntityController;
import com.ets.controller.main.MyMain;
import com.ets.model.UserDefinedForm;
import com.ets.utils.FXFormCommonUtilities;


import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class UserDefineFormInputController  implements Initializable{

	@FXML
    private TextField formNameText;

    @FXML
    private RadioButton preFillAndPrintRadio;

    @FXML
    private ToggleGroup userType;

    @FXML
    private RadioButton preFillAndInteractiveRadio;

    @FXML
    private Button okBtn;
    @FXML
    private Button importPdfBtn;
    @FXML
    private Button cancelbtn;
    @FXML
    private Label pdflinkLabel;
    private UserDefinedFormViewController userDefinedFormViewController;

	public void setUserDefinedFormViewController(UserDefinedFormViewController userDefinedFormViewController) {
		this.userDefinedFormViewController = userDefinedFormViewController;
	}
    private UserDefinedForm userDefinedForm;
	public void setUserDefinedFormViewController(UserDefinedFormViewController userDefinedFormViewController,UserDefinedForm userDefinedForm) {
		this.userDefinedFormViewController = userDefinedFormViewController;
		this.userDefinedForm= userDefinedForm;
		importPdfBtn.setText("");
		importPdfBtn.setText("Change pdf");
		pdflinkLabel.setText(userDefinedForm.getFormPath()+"\\"+userDefinedForm.getFormName());
		formNameText.setText(userDefinedForm.getFormName());
		
		
		if(userDefinedForm.getFormType().equals("PreFillPrint")){
			preFillAndPrintRadio.setSelected(true);
		}else if(userDefinedForm.getFormType().equals("PreFillAndInteractive")){
			preFillAndInteractiveRadio.setSelected(true);
		}
		
		
	}
	private File fileToSave;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		fileToSave=null;
		importPdfBtn.setOnAction((event) -> {
			try {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilterDOC = new FileChooser.ExtensionFilter("DOC files (*.doc)",
						"*.doc");
				FileChooser.ExtensionFilter extFilterPDF = new FileChooser.ExtensionFilter("PDF files (*.pdf)",
						"*.pdf");
				fileChooser.getExtensionFilters().addAll(extFilterPDF,extFilterDOC);

				//fileChooser.setDialogTitle("Specify a file to save");   
				fileToSave = fileChooser.showOpenDialog(null);
				
			   
				//int userSelection = fileChooser.showSaveDialog(parentFrame);
				

				if (fileToSave!=null) {
				   
				      pdflinkLabel.setText(fileToSave.getAbsolutePath());
				      formNameText.setText(fileToSave.getName());
				 
				    }
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okBtn.setOnAction(event->{
			  try{
				      String type = null;
					if (preFillAndPrintRadio.isSelected()) {
						type = "PreFillPrint";
					} else if (preFillAndInteractiveRadio.isSelected()) {
						type = "PreFillAndInteractive";
					} 
					
					
					 String currentPath= new File(MyMain.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).toString();
					  int relativelocationInd= currentPath.indexOf("EHR", currentPath.indexOf("EHR") + 1);
					  if(relativelocationInd==-1){
						  relativelocationInd= currentPath.indexOf("EHR"); 
					  }
					  
					   StringBuilder relativelocationBuild = new StringBuilder();
					   relativelocationBuild.append(currentPath);
					   relativelocationBuild.delete(relativelocationInd, currentPath.length());
					   currentPath = relativelocationBuild.toString();
					    File createdFolder = new File(currentPath+"ehr_related_forms_and_images");
					    
					    if(!createdFolder.exists()){
					    	new File(currentPath+"ehr_related_forms_and_images").mkdir();
					    	
					    }
					      Path copy_from_1 = Paths.get(fileToSave.getAbsolutePath());

					     try {
					       Path copy_to_1 = Paths.get(createdFolder.getAbsolutePath(), formNameText.getText());
						   Files.copy(copy_from_1, copy_to_1);
					      
					    } catch (FileAlreadyExistsException  e) {
					    	Alert alert = new Alert(AlertType.INFORMATION);
					    	alert.setTitle("Information Dialog");
					    	alert.setHeaderText(null);
					    	alert.setContentText("File Already exists!");

					    	alert.showAndWait();
					    	
					    	
					    } catch(IOException e){
					    	Alert alert = new Alert(AlertType.INFORMATION);
					    	alert.setTitle("Information Dialog");
					    	alert.setHeaderText(null);
					    	alert.setContentText("import unsuccessful!");
	                        alert.showAndWait();
					    	
					    }
				
					        UserDefinedForm definedForm = new UserDefinedForm();
					        if(userDefinedForm!=null?userDefinedForm.getFormName()!=null&&userDefinedForm.getFormPath()!=null:false){
								if(fileToSave!=null){
									File file = new File(userDefinedForm.getFormPath()+"/"+userDefinedForm.getFormName());
									file.delete();
									
									definedForm.setId(userDefinedForm.getId());	
									
								}
								
								}
					        
					        
							definedForm.setFormName(formNameText.getText());
							definedForm.setFormType(type);
							definedForm.setFormPath(createdFolder.getAbsolutePath());
							new UserDefinedFormEntityController().saveUserDefinedForm(definedForm);
							pdflinkLabel.setText(definedForm.getFormPath());
							userDefinedFormViewController.viewUserDefinedForm();
							new FXFormCommonUtilities().closeForm(okBtn);		
			}catch(Exception e){
				e.printStackTrace();
			}
			  
				
		});
		
		
		
		
		cancelbtn.setOnAction((event) -> {
			try {
			
				new FXFormCommonUtilities().closeForm( cancelbtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}



