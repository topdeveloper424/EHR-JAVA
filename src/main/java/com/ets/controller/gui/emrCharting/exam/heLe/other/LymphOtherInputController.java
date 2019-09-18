package com.ets.controller.gui.emrCharting.exam.heLe.other;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphOtherInputController Class
 *Description: lymphOther.fxml Controller class
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

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.heLe.LymphInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class LymphOtherInputController implements Initializable{
	
    @FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox qualityRubberyCkeckBox;

    @FXML
    private CheckBox qualityNormalCkeckBox;

    @FXML
    private CheckBox qualityEnlargedCkeckBox;

    @FXML
    private CheckBox qualityShootyCkeckBox;

    @FXML
    private CheckBox qualityFirmLeftCkeckBox;

    @FXML
    private CheckBox qualityTenderCkeckBox;

    @FXML
    private CheckBox qualityAllNormalCkeckBox;

    @FXML
    private CheckBox locationrightCkeckBox;

    @FXML
    private CheckBox locationsubmentalCkeckBox;

    @FXML
    private CheckBox locationocciptalCkeckBox;

    @FXML
    private CheckBox locationleftCkeckBox;

    
    private LymphInputController lymphInputController;

    public void setLymphInputController(LymphInputController lymphInputController) {
		this.lymphInputController = lymphInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(lymphInputController.str);
			skelComp.append("\n\n");
			lymphInputController.str = skelComp.toString();

			if (qualityAllNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("No lymphatic abnormalities noted.");
				lymphInputController.str = str1.toString();

			}else{
				
				if (qualityEnlargedCkeckBox.isSelected()||qualityFirmLeftCkeckBox.isSelected()||qualityNormalCkeckBox.isSelected()
						||qualityRubberyCkeckBox.isSelected()||qualityShootyCkeckBox.isSelected()||qualityTenderCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("Lymph nodes are ");
					lymphInputController.str = str1.toString();

				}	
				
				if (qualityEnlargedCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("enlarged,");
					lymphInputController.str = str1.toString();

				}
				if (qualityFirmLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("firm,");
					lymphInputController.str = str1.toString();

				}
				if (qualityNormalCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("normal,");
					lymphInputController.str = str1.toString();

				}
				if (qualityRubberyCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("rubbery,");
					lymphInputController.str = str1.toString();

				}

				if (qualityShootyCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("shotty,");
					lymphInputController.str = str1.toString();

				}if (qualityTenderCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("tender,");
					lymphInputController.str = str1.toString();

				}
				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("are noted.");
				lymphInputController.str = str1.toString();

			
			
			if (locationsubmentalCkeckBox.isSelected()||locationleftCkeckBox.isSelected()
					||locationocciptalCkeckBox.isSelected()
					||locationrightCkeckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(lymphInputController.str);
				str11.append("in the ");
				lymphInputController.str = str11.toString();

			
			if (locationsubmentalCkeckBox.isSelected()) {

				StringBuilder str15 = new StringBuilder(lymphInputController.str);
				str15.append("submental,");
				lymphInputController.str = str15.toString();

			}if (locationleftCkeckBox.isSelected()) {

				StringBuilder str14 = new StringBuilder(lymphInputController.str);
				str14.append("left,");
				lymphInputController.str = str14.toString();

			}if (locationocciptalCkeckBox.isSelected()) {

				StringBuilder str13 = new StringBuilder(lymphInputController.str);
				str13.append("occipital,");
				lymphInputController.str = str13.toString();

			}if (locationrightCkeckBox.isSelected()) {

				StringBuilder str1r = new StringBuilder(lymphInputController.str);
				str1r.append("right,");
				lymphInputController.str = str1r.toString();

			}
			}
			StringBuilder str13 = new StringBuilder(lymphInputController.str);
			str13.append("epitrochlear areas.,");
			lymphInputController.str = str13.toString();
			
			}
			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(".");
			lymphInputController.str = str1.toString();
			//genericEMRChartingController.saveAllTextArea();
		++lymphInputController.formCount;	
		lymphInputController.setLymphUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++lymphInputController.formCount;	
				lymphInputController.setLymphUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
