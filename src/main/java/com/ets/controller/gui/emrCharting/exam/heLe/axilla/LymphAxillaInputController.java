package com.ets.controller.gui.emrCharting.exam.heLe.axilla;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphInputController Class
 *Description: lymphAxilla.fxml Controller class
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

public class LymphAxillaInputController implements Initializable {
	
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox axillaeRubberyRightlCkeckBox;

	    @FXML
	    private CheckBox axillaeFirmRightCkeckBox;

	    @FXML
	    private CheckBox axillaeTenderRightCkeckBox;

	    @FXML
	    private CheckBox axillaeShootyRightCkeckBox;

	    @FXML
	    private CheckBox axillaeNoLADCkeckBox;

	    @FXML
	    private CheckBox axillaeNormallLeftCkeckBox;

	    @FXML
	    private CheckBox axillaeRubberyLeftCkeckBox;

	    @FXML
	    private CheckBox axillaeFirmLeftCkeckBox;

	    @FXML
	    private CheckBox axillaeTenderLeftCkeckBox;
	    @FXML
	    private CheckBox axillaeShootyleftCkeckBox;
	    @FXML
	    private CheckBox axillaeNormalRightCkeckBox;

	    @FXML
	    private CheckBox axillaeAllNormalCkeckBox;

	    @FXML
	    private CheckBox axillaeNotedCkeckBox;
	    
	    private LymphInputController lymphInputController;

	    public void setLymphInputController(LymphInputController lymphInputController) {
			this.lymphInputController = lymphInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(lymphInputController.str);
			skelComp.append("\n\n");
			lymphInputController.str = skelComp.toString();

			if (axillaeAllNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" Lymph nodes in the axilla are normal bilaterally.. ");
				lymphInputController.str = str1.toString();

			} else {
				if (axillaeFirmLeftCkeckBox.isSelected() || axillaeFirmRightCkeckBox.isSelected()
						|| axillaeNoLADCkeckBox.isSelected() || axillaeNormallLeftCkeckBox.isSelected()
						|| axillaeNormalRightCkeckBox.isSelected() || axillaeNotedCkeckBox.isSelected()
						|| axillaeRubberyLeftCkeckBox.isSelected() || axillaeRubberyRightlCkeckBox.isSelected()
						|| axillaeShootyRightCkeckBox.isSelected() || axillaeTenderLeftCkeckBox.isSelected()
						|| axillaeTenderRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("Lymph nodes, axilla: ");
					lymphInputController.str = str1.toString();

				}
				if (axillaeFirmLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" firm left,");
					lymphInputController.str = str1.toString();

				}

				if (axillaeFirmRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" firm right,");
					lymphInputController.str = str1.toString();

				}

				if (axillaeNoLADCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("no LAD,");
					lymphInputController.str = str1.toString();

				}
				if (axillaeNormallLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" normal left,");
					lymphInputController.str = str1.toString();

				}
				if (axillaeNormalRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("normal right,");
					lymphInputController.str = str1.toString();

				}

				if (axillaeRubberyLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("rubbery left");
					lymphInputController.str = str1.toString();

				}

				if (axillaeRubberyRightlCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" rubbery right,");
					lymphInputController.str = str1.toString();

				}
				if (axillaeShootyleftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" shotty right,");
					lymphInputController.str = str1.toString();

				}

				if (axillaeShootyRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" shotty right,");
					lymphInputController.str = str1.toString();

				}
				if (axillaeTenderLeftCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append(" tender left,");
					lymphInputController.str = str1.toString();

				}
				if (axillaeTenderRightCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(lymphInputController.str);
					str1.append("tender right,");
					lymphInputController.str = str1.toString();

				}

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
