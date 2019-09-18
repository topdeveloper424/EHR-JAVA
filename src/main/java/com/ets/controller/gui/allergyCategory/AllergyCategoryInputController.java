package com.ets.controller.gui.allergyCategory;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.allergyCategory.AllergyCategoryEntityController;
import com.ets.model.AllergyCategory;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AllergyCategoryInputController  implements Initializable{

@FXML
private TextField codeText;


@FXML
private TextField descrip;

@FXML
private Button okBtn;

@FXML
private Button cancelbtn;

private AllergyCategoryViewController allergyCategoryViewController;

public void setAllergyCategoryViewController(AllergyCategoryViewController allergyCategoryViewController) {
	this.allergyCategoryViewController = allergyCategoryViewController;
}



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		okBtn.setOnAction((event) -> {
			try {
				
				AllergyCategory allergyCategory =new AllergyCategory();
				
				allergyCategory.setCode(codeText.getText());
				allergyCategory.setDescription(descrip.getText());
				new AllergyCategoryEntityController().saveOrUpdate(allergyCategory);
				allergyCategoryViewController.viewAllergy();
				new FXFormCommonUtilities().closeForm(okBtn);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		
		
		cancelbtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelbtn);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
