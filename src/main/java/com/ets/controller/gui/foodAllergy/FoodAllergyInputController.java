package com.ets.controller.gui.foodAllergy;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.foodAllergy.FoodAllergyEntityController;

import com.ets.model.FoodAllergy;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FoodAllergyInputController implements Initializable {

    @FXML
    private TextField codeText;

    @FXML
    private TextField subatance;

    @FXML
    private Button okBtn;

    @FXML
    private Button cancelbtn;

    private FoodAllergyViewController foodAllergyViewController;

	public void setFoodAllergyViewController(FoodAllergyViewController foodAllergyViewController) {
		this.foodAllergyViewController = foodAllergyViewController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		okBtn.setOnAction((event) -> {
			try {
				
				FoodAllergy foodAllergy =new FoodAllergy();
				
				foodAllergy.setUniCode(codeText.getText());
				foodAllergy.setSubstanceName(subatance.getText());
				new FoodAllergyEntityController().saveOrUpdate(foodAllergy);
				foodAllergyViewController.viewFoodAllergy();
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
