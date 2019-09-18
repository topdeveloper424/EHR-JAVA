package com.ets.controller.gui.visitCategoryGroup;

import java.net.URL;
import java.util.ResourceBundle;



import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.controller.entity.visitCategoryGroup.VisitCategoryGroupEntityController;
import com.ets.model.RespiratorModel;
import com.ets.model.VisitCategoryGroup;
import com.ets.utils.FXFormCommonUtilities;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

public class VisitCategoryGroupInputController implements Initializable {
	
	@FXML
    private Button cancelButton;

    @FXML
    private Button okButton;

    @FXML
    private TextField codeTextField;

    @FXML
    private TextField descriptionTextField;
    
    @FXML
    private CheckBox inactiveCheckBox;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	okButton.setOnAction((event) -> {
			
			// Insert Data into Table
			
			VisitCategoryGroup  visitCategoryGroup = new VisitCategoryGroup();
			visitCategoryGroup.setCode(this.codeTextField.getText());
			visitCategoryGroup.setDescrip(this.descriptionTextField.getText());
						
			new VisitCategoryGroupEntityController().saveVisitCategoryGroup(visitCategoryGroup);
			
						
		});

    	cancelButton.setOnAction((event) -> {

			// Cancel centralized Form

				try {
					new FXFormCommonUtilities().closeForm(cancelButton);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		
		
	}


}
