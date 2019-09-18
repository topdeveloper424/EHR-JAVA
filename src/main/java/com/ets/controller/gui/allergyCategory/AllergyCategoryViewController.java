package com.ets.controller.gui.allergyCategory;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.allergyCategory.AllergyCategoryEntityController;
import com.ets.controller.entity.medication.MedicationEntityController;
import com.ets.controller.gui.emrCharting.pmh.allergy.BarbituratesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.NarcoticAllergiesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PenicillinesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.QuinoloneAntibioticsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SulfaDrugsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.TetraCyclinesInputController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.model.AllergyCategory;
import com.ets.model.Medication;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AllergyCategoryViewController implements Initializable {

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button selectButton;

	@FXML
	private Button closeButton;

	@FXML
	private TableView<AllergyCategory> allergyTable;

	@FXML
	private TableColumn<AllergyCategory, String> descriptionColumn;

	@FXML
	private TableColumn<AllergyCategory, String> codeColumn;

	FXMLFormPath formpath = new FXMLFormPath();

	private PenicillinesInputController penicillinesInputController;

	public void setPenicillinesInputController(PenicillinesInputController penicillinesInputController) {
		this.penicillinesInputController = penicillinesInputController;
	}

	private NarcoticAllergiesInputController narcoticAllergiesInputController;

	public void setNarcoticAllergiesInputController(NarcoticAllergiesInputController narcoticAllergiesInputController) {
		this.narcoticAllergiesInputController = narcoticAllergiesInputController;
	}

	private BarbituratesInputController barbituratesInputController;

	public void setBarbituratesInputController(BarbituratesInputController barbituratesInputController) {
		this.barbituratesInputController = barbituratesInputController;
	}

	private QuinoloneAntibioticsInputController quinoloneAntibioticsInputController;

	public void setQuinoloneAntibioticsInputController(
			QuinoloneAntibioticsInputController quinoloneAntibioticsInputController) {
		this.quinoloneAntibioticsInputController = quinoloneAntibioticsInputController;
	}

	private TetraCyclinesInputController tetraCyclinesInputController;

	public void setTetraCyclinesInputController(TetraCyclinesInputController tetraCyclinesInputController) {
		this.tetraCyclinesInputController = tetraCyclinesInputController;
	}

	private SulfaDrugsInputController sulfaDrugsInputController;

	public void setSulfaDrugsInputController(SulfaDrugsInputController sulfaDrugsInputController) {
		this.sulfaDrugsInputController = sulfaDrugsInputController;
	}

	private ObservableList<AllergyCategory> allergyCategories;

	public void viewAllergy() {
		allergyCategories = new AllergyCategoryEntityController().view();

		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());

		allergyTable.setItems(allergyCategories);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewAllergy();

		addButton.setOnAction((event) -> {
			try {

				String formName = formpath.context.getMessage("AllergyCategoryInput", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.AllergyCategoryInput", null, Locale.US);
				formpath.closeApplicationContext();
				AllergyCategoryInputController allergyCategoryInputController = (AllergyCategoryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				allergyCategoryInputController.setAllergyCategoryViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		selectButton.setOnAction((event) -> {
			try {

				if (barbituratesInputController != null) {
					barbituratesInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

				}
				if (narcoticAllergiesInputController != null) {

					narcoticAllergiesInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

				}
				if (penicillinesInputController != null) {

					penicillinesInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

				}

				if (quinoloneAntibioticsInputController != null) {

					quinoloneAntibioticsInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

				}

				if (sulfaDrugsInputController != null) {

					sulfaDrugsInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

				}
				if (tetraCyclinesInputController != null) {

					tetraCyclinesInputController
							.setAlleryCategory(allergyTable.getSelectionModel().getSelectedItem().getDescription());

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
