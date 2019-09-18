package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticLabOrderOccMedInputController implements Initializable{
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox cbcWithCheck;

    @FXML
    private CheckBox hemoglobinCheck;

    @FXML
    private CheckBox stoolForCheck;

    @FXML
    private CheckBox hematologicLipidPanelCheck;

    @FXML
    private CheckBox HepaticPanelCheck;

    @FXML
    private CheckBox bloodLeadCheck;

    @FXML
    private CheckBox tshCheck;

    @FXML
    private CheckBox chemistryLipidPanelCheck;

    @FXML
    private CheckBox urineDipCheck;

    @FXML
    private CheckBox urineDrugCheck;

    @FXML
    private CheckBox urtineHcgCheck;

    @FXML
    private CheckBox UrineMicroscopicCheck;

    @FXML
    private CheckBox urine10PanelCheck;

    @FXML
    private CheckBox ppdCheck;

    @FXML
    private CheckBox hepCCheck;

    @FXML
    private CheckBox hebBCheck;

    @FXML
    private CheckBox hepACheck;

    @FXML
    private CheckBox VaricellaCheck;

    @FXML
    private CheckBox RubellaCheck;

    @FXML
    private CheckBox mumpsCheck;

    @FXML
    private CheckBox MeaslesCheck;

	private OrderDiagonosticTestInputController orderDiagonosticTestInputController;

    public void setOrderDiagonosticTestInputController(
			OrderDiagonosticTestInputController orderDiagonosticTestInputController) {
		this.orderDiagonosticTestInputController = orderDiagonosticTestInputController;
	}

@Override
public void initialize(URL location, ResourceBundle resources) {
	
	
	doneBtn.setOnAction((event) -> {

		StringBuilder ctScanStr = new StringBuilder(orderDiagonosticTestInputController.str);
		ctScanStr.append("\n\n ");
		orderDiagonosticTestInputController.str = ctScanStr.toString();

		if(cbcWithCheck.isSelected() || hemoglobinCheck.isSelected()
				
				|| stoolForCheck.isSelected() || hematologicLipidPanelCheck.isSelected()){
			
			StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
			str.append("The following Hematologic tests were ordered ");
			orderDiagonosticTestInputController.str = str.toString();
			
			if(cbcWithCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append(" CBC with differential,");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(hemoglobinCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("hemoglobin/hematocrit");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(stoolForCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("stool for occult blood,");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(hematologicLipidPanelCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append("lipid panel");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			
			StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
			str11.append(".");
			orderDiagonosticTestInputController.str = str11.toString();
			
			
			
		}
		
		
		
        if(HepaticPanelCheck.isSelected() || chemistryLipidPanelCheck.isSelected()
				
				|| tshCheck.isSelected() || bloodLeadCheck.isSelected()){
			
			StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
			str.append("The following Chemistry tests were ordered; ");
			orderDiagonosticTestInputController.str = str.toString();
			
			if(HepaticPanelCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Hepatic Panel,");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(chemistryLipidPanelCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append(" Lipid Panel,");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}if(tshCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
				str11.append("Thyroid (TSH),");
				orderDiagonosticTestInputController.str = str11.toString();
				
			}if(bloodLeadCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
				str1.append(" Blood Lead && ZPP");
				orderDiagonosticTestInputController.str = str1.toString();
				
			}
			
			
			StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
			str11.append(".");
			orderDiagonosticTestInputController.str = str11.toString();
			
			
			
		}





if(urineDipCheck.isSelected() || UrineMicroscopicCheck.isSelected()
	|| urtineHcgCheck.isSelected()
	|| urineDrugCheck.isSelected() || urine10PanelCheck.isSelected()){

StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
str.append("The following Urine tests were ordered; ");
orderDiagonosticTestInputController.str = str.toString();

if(urineDipCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append(" Urine Dip,");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(UrineMicroscopicCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append(" Urine Microscopic,");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(urtineHcgCheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append(" Urine HCG (Pregnancy Test),");
	orderDiagonosticTestInputController.str = str1.toString();
	
}if(urineDrugCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append("Urine Drug Screen 5 panel, ");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(urine10PanelCheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append("Urine 10 panel");
	orderDiagonosticTestInputController.str = str1.toString();
	
}


StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
str11.append(".");
orderDiagonosticTestInputController.str = str11.toString();



}





if(ppdCheck.isSelected() || hepACheck.isSelected()
	|| hebBCheck.isSelected() || hepCCheck.isSelected()
	|| VaricellaCheck.isSelected() || MeaslesCheck.isSelected()
	|| mumpsCheck.isSelected() || RubellaCheck.isSelected()){

StringBuilder str = new StringBuilder(orderDiagonosticTestInputController.str);
str.append("The following Blood immunologic titers were drawn; ");
orderDiagonosticTestInputController.str = str.toString();

if(ppdCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append("PPD,");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(hepACheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append(" Hep A Ab,");
	orderDiagonosticTestInputController.str = str1.toString();
	
}if(hebBCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append(" Heb B SAb,");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(hepCCheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append(" Hep C S Ab,");
	orderDiagonosticTestInputController.str = str1.toString();
	
}if(VaricellaCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append("Varicella, ");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(MeaslesCheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append("Measles, ");
	orderDiagonosticTestInputController.str = str1.toString();
	
}if(mumpsCheck.isSelected()){
	
	StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
	str11.append("Mumps, ");
	orderDiagonosticTestInputController.str = str11.toString();
	
}if(RubellaCheck.isSelected()){
	
	StringBuilder str1 = new StringBuilder(orderDiagonosticTestInputController.str);
	str1.append(" Rubella");
	orderDiagonosticTestInputController.str = str1.toString();
	
}


StringBuilder str11 = new StringBuilder(orderDiagonosticTestInputController.str);
str11.append(".");
orderDiagonosticTestInputController.str = str11.toString();



}
		

		++orderDiagonosticTestInputController.formCount;
		orderDiagonosticTestInputController.setDiagonosisTestUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
		

	});
	
	
	skipBtn.setOnAction((event) -> {
		try {
			
			++orderDiagonosticTestInputController.formCount;
			orderDiagonosticTestInputController.setDiagonosisTestUI();
			new FXFormCommonUtilities().closeForm(skipBtn);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
	
	
}

}
