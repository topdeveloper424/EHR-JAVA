package com.ets.controller.gui.emrCharting.exam.heLe.groin;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphGroinInputController Class
 *Description: lymphGroin.fxml Controller class
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

public class LymphGroinInputController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox groinRubberyRightlCkeckBox;

	    @FXML
	    private CheckBox groinFirmRightCkeckBox;

	    @FXML
	    private CheckBox groinNotNotedCkeckBox;

	    @FXML
	    private CheckBox groinNormallLeftCkeckBox;

	    @FXML
	    private CheckBox groinShootyRightCkeckBox;

	    @FXML
	    private CheckBox groinRubberyLeftCkeckBox;

	    @FXML
	    private CheckBox groinFirmLeftCkeckBox;

	    @FXML
	    private CheckBox groinTenderLeftCkeckBox;

	    @FXML
	    private CheckBox groinAllNormalCkeckBox;

	    @FXML
	    private CheckBox groinBilaterallyCkeckBox;

	    @FXML
	    private CheckBox groinTenderRightCkeckBox;
	    @FXML
	    private CheckBox groinShootyleftCkeckBox;
	    @FXML
	    private CheckBox groinNormalRightCkeckBox;
	    
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
			skelComp.append("\n");
			lymphInputController.str = skelComp.toString();

			if (groinBilaterallyCkeckBox.isSelected() || groinFirmLeftCkeckBox.isSelected()
					|| groinFirmRightCkeckBox.isSelected() || groinNormallLeftCkeckBox.isSelected()
					|| groinNormalRightCkeckBox.isSelected()
					|| groinNotNotedCkeckBox.isSelected()
					|| groinRubberyLeftCkeckBox.isSelected()
					|| groinRubberyRightlCkeckBox.isSelected()
					|| groinShootyRightCkeckBox.isSelected() || groinTenderLeftCkeckBox.isSelected()
					|| groinTenderRightCkeckBox.isSelected()
					|| groinShootyleftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("Supraclavicular: ");
				lymphInputController.str = str1.toString();

			}
			if (groinBilaterallyCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("normal bilateral,");
				lymphInputController.str = str1.toString();

			}

			if (groinFirmLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("firm left,");
				lymphInputController.str = str1.toString();

			}

			if (groinFirmRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("firm right");
				lymphInputController.str = str1.toString();

			}
			if (groinNotNotedCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("none noted,");
				lymphInputController.str = str1.toString();

			}
			if (groinNormallLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("normal left,");
				lymphInputController.str = str1.toString();

			}

			if (groinNormalRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("normal right");
				lymphInputController.str = str1.toString();

			}

			if (groinRubberyRightlCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" rubbery right,");
				lymphInputController.str = str1.toString();

			}if (groinRubberyLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" rubbery right,");
				lymphInputController.str = str1.toString();

			}
			if (groinShootyRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" shotty right,");
				lymphInputController.str = str1.toString();

			}
			if (groinTenderLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" tender left,");
				lymphInputController.str = str1.toString();

			}
			if (groinTenderRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("tender right,");
				lymphInputController.str = str1.toString();

			}
			if (groinShootyleftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("tender left,");
				lymphInputController.str = str1.toString();

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
