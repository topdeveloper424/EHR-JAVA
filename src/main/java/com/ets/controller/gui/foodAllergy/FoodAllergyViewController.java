package com.ets.controller.gui.foodAllergy;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.allergyCategory.AllergyCategoryEntityController;
import com.ets.controller.entity.foodAllergy.FoodAllergyEntityController;
import com.ets.controller.gui.allergyCategory.AllergyCategoryInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.EggInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.FoodOrSubstanceInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.GluteninInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PeanutInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.ShellfishInputController;
import com.ets.model.AllergyCategory;
import com.ets.model.FoodAllergy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FoodAllergyViewController implements Initializable {

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button selectButton;

	@FXML
	private Button closeButton;

	@FXML
	private TableView<FoodAllergy> allergyTable;

	@FXML
	private TableColumn<FoodAllergy, String> codeColumn;

	@FXML
	private TableColumn<FoodAllergy, String> nameColumn;
	private ObservableList<FoodAllergy> foodAllergies;
	FXMLFormPath formpath = new FXMLFormPath();

	private EggInputController eggInputController;

	public void setEggInputController(EggInputController eggInputController) {
		this.eggInputController = eggInputController;
	}

	private FoodOrSubstanceInputController foodOrSubstanceInputController;

	public void setFoodOrSubstanceInputController(FoodOrSubstanceInputController foodOrSubstanceInputController) {
		this.foodOrSubstanceInputController = foodOrSubstanceInputController;
	}
	
	private GluteninInputController gluteninInputController;

	public void setGluteninInputController(GluteninInputController gluteninInputController) {
		this.gluteninInputController = gluteninInputController;
	}
	
	private PeanutInputController peanutInputController;


	public void setPeanutInputController(PeanutInputController peanutInputController) {
		this.peanutInputController = peanutInputController;
	}
	
	private ShellfishInputController shellfishInputController;

	public void setShellfishInputController(ShellfishInputController shellfishInputController) {
		this.shellfishInputController = shellfishInputController;
	}

	public void viewFoodAllergy() {
		foodAllergies = new FoodAllergyEntityController().view();

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().substanceNameProperty());
		codeColumn.setCellValueFactory(cellData -> cellData.getValue().uniCodeProperty());

		allergyTable.setItems(foodAllergies);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewFoodAllergy();
		addButton.setOnAction((event) -> {
			try {

				String formName = formpath.context.getMessage("FoodAllergy", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.FoodAllergy", null, Locale.US);

				FoodAllergyInputController foodAllergyInputController = (FoodAllergyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				formpath.closeApplicationContext();
				foodAllergyInputController.setFoodAllergyViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		selectButton.setOnAction((event) -> {
			try {

				if (eggInputController != null) {
					eggInputController
							.setFoodAllergy(allergyTable.getSelectionModel().getSelectedItem().getSubstanceName());

				}
				
				if(foodOrSubstanceInputController != null){
					
					foodOrSubstanceInputController
					.setFoodAllergy(allergyTable.getSelectionModel().getSelectedItem().getSubstanceName());
	
				}

				if(gluteninInputController != null){
					
					gluteninInputController.setFoodAllergy(allergyTable.getSelectionModel().getSelectedItem().getSubstanceName());
					
				}
				
				
				if(peanutInputController != null){
					peanutInputController.setFoodAllergy(allergyTable.getSelectionModel().getSelectedItem().getSubstanceName());
					
				}
				
				if(shellfishInputController != null){
					
					shellfishInputController.setFoodAllergy(allergyTable.getSelectionModel().getSelectedItem().getSubstanceName());
					
				}
				new FXFormCommonUtilities().closeForm(closeButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
