package com.ets.controller.gui.emrCharting.order.medication;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.order.MedicationInputController;
import com.ets.controller.gui.medicationCode.MedicationCodeViewController;
import com.ets.model.Medication;
import com.ets.utils.FXFormCommonUtilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DrSmithFavoritesInputController implements Initializable {
	
	
	@FXML
    private TextField medicationNameTextField;

    @FXML
    private TextField medicationClassTextField;

    @FXML
    private ComboBox<String> medStrengthComboBox;

    @FXML
    private TextField dispenseTextField;

    @FXML
    private ComboBox<String> fromComboBox;

    @FXML
    private TextField howMuchTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private ComboBox<String> toComboBox;

    @FXML
    private ComboBox<String> routeComboBox;

    @FXML
    private ComboBox<String> frequencyComboBox;

    @FXML
    private TextField howLongTextField;

    @FXML
    private ComboBox<String> howLongComboBox;

    @FXML
    private ComboBox<String> specialComboBox;

    @FXML
    private TextArea instructionTextArea;

    @FXML
    private TextArea allergyTextArea;

    @FXML
    private Button okButton;

    @FXML
    private Button cancleButton;
    
    private MedicationCodeViewController medicationCodeViewController;
	private Medication medication;
	public void setCombo(){
		List<String> list1 = new ArrayList<String>();

		list1.add("0.05 mg");
		list1.add("0.075 mg");
		list1.add("0.1 mg");
		list1.add("0.125 mg");
		list1.add("0.25 mg");
		list1.add("0.5 mg");
		list1.add("1 mg");
		list1.add("1.5 mg");
		list1.add("2 mg");
		list1.add("3 mg");
		list1.add("4 mg");
		list1.add("5 mg");
		list1.add("7.5 mg");
		list1.add("10 mg");
		list1.add("20 mg");
		list1.add("25 mg");
		list1.add("30 mg");
		list1.add("40 mg");
		list1.add("50 mg");
		list1.add("60 mg");
		list1.add("70 mg");
		list1.add("75 mg");
		list1.add("100 mg");
		list1.add("125 mg");
		list1.add("150 mg");
		list1.add("200 mg");
		list1.add("250 mg");
		list1.add("300 mg");
		list1.add("350 mg");
		list1.add("400 mg");
		list1.add("450 mg");
		list1.add("500 mg");
		list1.add("550 mg");
		list1.add("600 mg");
		list1.add("650 mg");
		list1.add("750 mg");
		list1.add("800 mg");
		list1.add("1000 mg");
		list1.add("1 oz");
		list1.add("2 oz");
		list1.add("3 oz");
		list1.add("4 oz");
		list1.add("6 oz");
		ObservableList medStrengthList = FXCollections.observableList(list1);
		medStrengthComboBox.getItems().clear();
		medStrengthComboBox.setItems(medStrengthList);
		
		
		
		List<String> formList = new ArrayList<String>();

		formList.add("Ampule");
		formList.add("Applicator");
		formList.add("Applicatorful");	
		formList.add("Bag");
		formList.add("Bar");
		formList.add("Bread");
		formList.add("Blister");
		formList.add("Block");
		formList.add("Bolus");
		formList.add("Bottle");
		formList.add("Box");
		formList.add("Can");
		formList.add("Canister");
		formList.add("Caplet");
		formList.add("Capsule");
		formList.add("Carton");
		formList.add("Cartidge");
		formList.add("Case");
		formList.add("Cassette");
		
		formList.add("Container");
		formList.add("Cylinder");
		
		formList.add("Device");
		formList.add("Dose pack");
		formList.add("Fluid Ounce");
		formList.add("French");
		formList.add("Gallon");
		formList.add("Gram");
		formList.add("Gum");
		formList.add("Inhalation");
		formList.add("Inhealer");
		formList.add("Inhealer Refill");
		formList.add("International Unit");
		formList.add("Intravenou Bag");
		formList.add("Kilogram");
		formList.add("Kit");
		formList.add("Lancet");
		formList.add("Liter");
		formList.add("Lozenge");
		formList.add("Metric Drop");
		formList.add("Milliequivalent");
		formList.add("Milligram");
		formList.add("Milliliter");
		formList.add("Millimeter");
		formList.add("Nebule");
		formList.add("Needle Free Injection");
		formList.add("Ocular System");
		formList.add("Ounce");
		formList.add("Package");
		formList.add("Packet");
		formList.add("Pad");
		formList.add("paper");
		formList.add("Patch");
		formList.add("Pen Needle");
		formList.add("Pint");
		formList.add("Pouch");
		formList.add("Pound");
		formList.add("Pre-Filled Pen Syrin");
		formList.add("Puff");
		formList.add("Pump");
		formList.add("Quart");
		formList.add("Ring");
		formList.add("Sachet");
		formList.add("Scoopful");
		formList.add("Sponge");
		formList.add("Spray");
		formList.add("Strip");
		formList.add("Suppository");
		formList.add("Swab");
		formList.add("Syringe");
		formList.add("tablespoon");
		formList.add("Tablet");
		formList.add("Tabminder");
		formList.add("Tampon");
		formList.add("Teaspoon");
		formList.add("Tray");
		formList.add("Troche");
		formList.add("Tube");
		formList.add("Unspecified");
		formList.add("Vial");
		formList.add("Wafer");
		ObservableList formListItems = FXCollections.observableList(formList);
		fromComboBox.getItems().clear();
		fromComboBox.setItems(formListItems);
	
		List<String> howmuchTolist = new ArrayList<String>();

		howmuchTolist.add("Tablet");
		howmuchTolist.add("Capsule");
		howmuchTolist.add("Dise");
		howmuchTolist.add("Drop");
		howmuchTolist.add("Enema");
		howmuchTolist.add("Gm");
		howmuchTolist.add("Granule");
		howmuchTolist.add("Gum");
		howmuchTolist.add("Implant");
		howmuchTolist.add("In");
		howmuchTolist.add("Inhalation");
		howmuchTolist.add("Injection");
		howmuchTolist.add("Insert");
		howmuchTolist.add("mg");
		howmuchTolist.add("mg/mL");
		howmuchTolist.add("mL");
		howmuchTolist.add("Oz");
		howmuchTolist.add("Patch");
		howmuchTolist.add("Pill");
		howmuchTolist.add("Powder");
		howmuchTolist.add("Spray");
		howmuchTolist.add("Stick");
		howmuchTolist.add("Strip");
		howmuchTolist.add("Suppository");
		howmuchTolist.add("Tablespoon");
		howmuchTolist.add("Teaspoon");
		howmuchTolist.add("Wafer");
		
		
		ObservableList howmuchTolistItems = FXCollections.observableList(howmuchTolist);
		toComboBox.getItems().clear();
		toComboBox.setItems(howmuchTolistItems);
		
		
		List<String> route = new ArrayList<String>();
		route.add("orally");
		route.add("buccally");
		route.add("in affected eye");
		route.add("in right eye");
		route.add("in left eye");
		route.add("in both eyes");
		route.add("ophthalmic");
		route.add("in affected ear");
		route.add("in right ear");
		route.add("in left ear");
		route.add("in both ears");
		route.add("otic");
		route.add("inhalation");
		route.add("intra-articular");
		route.add("I.M");
		route.add("I.V");
		route.add("irrigation");
		route.add("mucosally");
		route.add("nasally");
		route.add("rectally");
		route.add("sublingually");
		route.add("subcutaneously");
		route.add("topically");
		route.add("transmucosally");
		route.add("vaginally");
		
		
		ObservableList routeList = FXCollections.observableList(route);
		routeComboBox.getItems().clear();
		routeComboBox.setItems(routeList);
	
		List<String> frequency = new ArrayList<String>();

		frequency.add("as needed");
		frequency.add("as directed");
		frequency.add("every 4 hours");
		frequency.add("every 4 to 6 hours");
		frequency.add("every 6 hours");
		frequency.add("every 8 hours");
		frequency.add("every 12 hours");
		frequency.add("once a day (morning)");
		frequency.add("once a day (bedtime)");
		frequency.add("2 times a day");
		frequency.add("2 to 3 times a day");
		frequency.add("2 to 4 times a day");
		frequency.add("3 times a day");
		frequency.add("4 times a day");
		frequency.add("once a week");
		frequency.add("every two weeks");
		frequency.add("once a month");
		
		
		ObservableList frequencyList = FXCollections.observableList(frequency);
		frequencyComboBox.getItems().clear();
		frequencyComboBox.setItems(frequencyList);
		
		
		List<String> howLonglist = new ArrayList<String>();


		howLonglist.add("day");
		howLonglist.add("week");
		howLonglist.add("month");
		howLonglist.add("year");
		howLonglist.add("asneeded");
		howLonglist.add("indefinitely");
		
		ObservableList howLonglistItem = FXCollections.observableList(howLonglist);
		howLongComboBox.getItems().clear();
		howLongComboBox.setItems(howLonglistItem);
		
		List<String> specialCir = new ArrayList<String>();

		specialCir.add("as needed");
		specialCir.add("mornings");
		specialCir.add("evenings");
		
		specialCir.add("at bedtime");
		specialCir.add("before eating");
		specialCir.add("on an empty stomach");
		specialCir.add("after eating");
		specialCir.add("with food");
		specialCir.add("with liquid");
		specialCir.add("before excrise");
		specialCir.add("after excrise");
		
		
		
		ObservableList specialCirList = FXCollections.observableList(specialCir);
		specialComboBox.getItems().clear();
		specialComboBox.setItems(specialCirList);
		
	}
	public void setMedicationCodeViewController(MedicationCodeViewController medicationCodeViewController,Medication selectedmedication ) {
		this.medicationCodeViewController = medicationCodeViewController;
		this.medication = selectedmedication;
		
		medicationNameTextField.setText(medication.getMedicationName());
		medicationClassTextField.setText(medication.getMedicationClass().getMedicalClass());
		medStrengthComboBox.setValue(medication.getMedStrength());
		dispenseTextField.setText(medication.getDispense());
		fromComboBox.setValue(medication.getForm());
		howMuchTextField.setText(medication.getHowMuch());
		toTextField.setText(medication.getHowMuchTo());
		toComboBox.setValue(medication.getHowMuchform());
		routeComboBox.setValue(medication.getRoute());
		frequencyComboBox.setValue(medication.getFrequency());
		howLongTextField.setText(medication.getHowLong());
		howLongComboBox.setValue(medication.getHowLongMonthOrYear());
		specialComboBox.setValue(medication.getSpecial());
		instructionTextArea.setText(medication.getAdditionalSig());
		allergyTextArea.setText("Aspirin OTC, Adult,  Select Any Food or Substance, Tetracyclines,"
				+ "  Select Any Medication,  Select Any Medication Category, EGG, GLUTENIN, PEANUT,"
				+ " SHELLFISH,  Select Any Food or Substance, Aspirin OTC, Adult, Barbiturates, Codeine,"
				+ " Narcotic analgesics, Penicillins, Quinolone antibiotics, Sulfa drugs, Tetracyclines, "
				+ " Select Any Medication,  Select Any Medication Category, EGG, GLUTENIN, PEANUT, SHIITAKE MUSHROOM, "
				+ ".ALPHA.-D-GLUCOPYRANOSE, Rotavirus Vaccine Live Oral, Hep B Vaccine, "
				+ "Peds/Adol, Hep A Vacci");
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setCombo();

		okButton.setOnAction((event) -> {
			try {
				
				StringBuilder str1 = new StringBuilder(medicationCodeViewController.medicationInputController.str);
				str1.append("Prescribed "+medicationNameTextField.getText()+" "+dispenseTextField.getText()+
						"mg. "+howMuchTextField.getText()+" to "+toTextField.getText()+" " +toComboBox.getSelectionModel().getSelectedIndex()
						+" "+routeComboBox.getSelectionModel().getSelectedItem()+" "+frequencyComboBox.getSelectionModel().getSelectedItem()
						+" "+specialComboBox.getSelectionModel().getSelectedItem()+ " for "+howLongTextField.getText()+
						" "+howLongComboBox.getSelectionModel().getSelectedItem()+".\n "+instructionTextArea.getText());
				medicationCodeViewController.medicationInputController.str = str1.toString();
				

				++medicationCodeViewController.medicationInputController.formCount;
				medicationCodeViewController.medicationInputController.setMedicationForPatientUI();
			
				new FXFormCommonUtilities().closeForm(okButton);	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		

		cancleButton.setOnAction((event) -> {
			try {

				++medicationCodeViewController.medicationInputController.formCount;
				medicationCodeViewController.medicationInputController.setMedicationForPatientUI();
				
				new FXFormCommonUtilities().closeForm(cancleButton);	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
