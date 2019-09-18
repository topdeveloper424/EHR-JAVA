package com.ets.controller.gui.emrCharting.exam.heLe.neck;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphNeckController Class
 *Description: lymphNeck.fxml Controller class
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

public class LymphNeckController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox anterionRubberyRightlCkeckBox;

	    @FXML
	    private CheckBox anterionFirmRightCkeckBox;

	    @FXML
	    private CheckBox anterionTenderRightCkeckBox;

	    @FXML
	    private CheckBox anterionShootyRightCkeckBox;

	    @FXML
	    private CheckBox anterionNoLADCkeckBox;

	    @FXML
	    private CheckBox anterionNormallLeftCkeckBox;

	    @FXML
	    private CheckBox anterionRubberyLeftCkeckBox;

	    @FXML
	    private CheckBox anterionFirmLeftCkeckBox;

	    @FXML
	    private CheckBox anterionTenderLeftCkeckBox;

	    @FXML
	    private CheckBox anterionNormalRightCkeckBox;

	    @FXML
	    private CheckBox anterionAllNormalCkeckBox;

	    @FXML
	    private CheckBox posteriorRubberyRightlCkeckBox;

	    @FXML
	    private CheckBox posteriorFirmRightCkeckBox;

	    @FXML
	    private CheckBox posteriorTenderRightCkeckBox;

	    @FXML
	    private CheckBox posteriorShootyRightCkeckBox;

	    @FXML
	    private CheckBox posteriorBilaterallyCkeckBox;

	    @FXML
	    private CheckBox posteriorNormallLeftCkeckBox;

	    @FXML
	    private CheckBox posteriorRubberyLeftCkeckBox;

	    @FXML
	    private CheckBox posteriorFirmLeftCkeckBox;

	    @FXML
	    private CheckBox posteriorTenderLeftCkeckBox;

	    @FXML
	    private CheckBox posteriorNormalRightCkeckBox;
	   
	    @FXML
	    private CheckBox supraclavicularRubberyRightlCkeckBox;

	    @FXML
	    private CheckBox supraclavicularFirmRightCkeckBox;

	    @FXML
	    private CheckBox supraclavicularTenderRightCkeckBox;

	    @FXML
	    private CheckBox supraclavicularShootyRightCkeckBox;

	    @FXML
	    private CheckBox supraclavicularNoneNotedCkeckBox;

	    @FXML
	    private CheckBox supraclavicularNormallLeftCkeckBox;

	    @FXML
	    private CheckBox supraclavicularRubberyLeftCkeckBox;

	    @FXML
	    private CheckBox supraclavicularFirmLeftCkeckBox;

	    @FXML
	    private CheckBox supraclavicularTenderLeftCkeckBox;

	    @FXML
	    private CheckBox supraclavicularNormalRightCkeckBox;
	    @FXML
	    private CheckBox posteriorShootyLeftCkeckBox;
	    @FXML
	    private CheckBox supraclavicularBilaterallyCkeckBox;
	    @FXML
	    private CheckBox supraclavicularShootyleftCkeckBox;
	    
	    private LymphInputController lymphInputController;
	    @FXML
	    private CheckBox anterionShootyLeftCkeckBox;

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

			if (anterionFirmLeftCkeckBox.isSelected() || anterionFirmRightCkeckBox.isSelected()
					|| anterionNoLADCkeckBox.isSelected() || anterionNormallLeftCkeckBox.isSelected()
					|| anterionNormalRightCkeckBox.isSelected() || anterionRubberyLeftCkeckBox.isSelected()
					|| anterionRubberyRightlCkeckBox.isSelected() || anterionShootyRightCkeckBox.isSelected()
					|| anterionTenderLeftCkeckBox.isSelected() || anterionTenderRightCkeckBox.isSelected()||anterionShootyLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("LYMPHATIC:  Lymph nodes neck: anterior cervical ");
				lymphInputController.str = str1.toString();

			}
			if (anterionFirmLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" firm left,");
				lymphInputController.str = str1.toString();

			}

			if (anterionFirmRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" firm right,");
				lymphInputController.str = str1.toString();

			}

			if (anterionNoLADCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("no LAD,");
				lymphInputController.str = str1.toString();

			}
			if (anterionNormallLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" normal left,");
				lymphInputController.str = str1.toString();

			}
			if (anterionNormalRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("normal right,");
				lymphInputController.str = str1.toString();

			}

			if (anterionRubberyLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("rubbery left");
				lymphInputController.str = str1.toString();

			}

			if (anterionRubberyRightlCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" rubbery right,");
				lymphInputController.str = str1.toString();

			}
			if (anterionShootyRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" shotty right,");
				lymphInputController.str = str1.toString();

			}
			if (anterionShootyLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" shotty left,");
				lymphInputController.str = str1.toString();

			}
			if (anterionTenderLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" tender left,");
				lymphInputController.str = str1.toString();

			}
			if (anterionTenderRightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("tender right,");
				lymphInputController.str = str1.toString();

			}

		

		if (posteriorBilaterallyCkeckBox.isSelected() || posteriorFirmLeftCkeckBox.isSelected()
				|| posteriorFirmRightCkeckBox.isSelected() || posteriorNormallLeftCkeckBox.isSelected()
				|| posteriorNormalRightCkeckBox.isSelected() || posteriorRubberyLeftCkeckBox.isSelected()
				|| posteriorRubberyRightlCkeckBox.isSelected() || posteriorShootyRightCkeckBox.isSelected()
				|| posteriorTenderLeftCkeckBox.isSelected() || posteriorTenderRightCkeckBox.isSelected()||posteriorShootyLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" Posterior cervical: ");
			lymphInputController.str = str1.toString();

		}
		if (posteriorFirmLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" firm left,");
			lymphInputController.str = str1.toString();

		}

		if (posteriorFirmRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" firm right,");
			lymphInputController.str = str1.toString();

		}

		if (posteriorBilaterallyCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(",");
			lymphInputController.str = str1.toString();

		}
		if (posteriorNormallLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" normal left,");
			lymphInputController.str = str1.toString();

		}
		if (posteriorNormalRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("normal right,");
			lymphInputController.str = str1.toString();

		}

		if (posteriorRubberyLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("rubbery left");
			lymphInputController.str = str1.toString();

		}

		if (posteriorRubberyRightlCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" rubbery right,");
			lymphInputController.str = str1.toString();

		}
		if (posteriorShootyRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" shotty right,");
			lymphInputController.str = str1.toString();

		}if (posteriorShootyLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" shotty left,");
			lymphInputController.str = str1.toString();

		}
		if (posteriorTenderLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" tender left,");
			lymphInputController.str = str1.toString();

		}
		if (posteriorTenderRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("tender right,");
			lymphInputController.str = str1.toString();

		}

		if (supraclavicularBilaterallyCkeckBox.isSelected() || supraclavicularFirmLeftCkeckBox.isSelected()
				|| supraclavicularFirmRightCkeckBox.isSelected() || supraclavicularNoneNotedCkeckBox.isSelected()
				|| supraclavicularNormallLeftCkeckBox.isSelected()
				|| supraclavicularNormalRightCkeckBox.isSelected()
				|| supraclavicularRubberyLeftCkeckBox.isSelected()
				|| supraclavicularRubberyRightlCkeckBox.isSelected()
				|| supraclavicularShootyRightCkeckBox.isSelected() || supraclavicularTenderLeftCkeckBox.isSelected()
				|| supraclavicularTenderRightCkeckBox.isSelected()
				|| supraclavicularShootyleftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("Supraclavicular: ");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularBilaterallyCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("normal bilateral,");
			lymphInputController.str = str1.toString();

		}

		if (supraclavicularFirmLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("firm left,");
			lymphInputController.str = str1.toString();

		}

		if (supraclavicularFirmRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("firm right");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularNoneNotedCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("none noted,");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularNormallLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("normal left,");
			lymphInputController.str = str1.toString();

		}

		if (supraclavicularNormalRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("normal right");
			lymphInputController.str = str1.toString();

		}

		if (supraclavicularRubberyRightlCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" rubbery right,");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularShootyRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" shotty right,");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularShootyleftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("shooty left,");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularTenderLeftCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append(" tender left,");
			lymphInputController.str = str1.toString();

		}
		if (supraclavicularTenderRightCkeckBox.isSelected()) {

			StringBuilder str1 = new StringBuilder(lymphInputController.str);
			str1.append("tender right,");
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
