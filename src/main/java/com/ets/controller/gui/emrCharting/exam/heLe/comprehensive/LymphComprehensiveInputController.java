package com.ets.controller.gui.emrCharting.exam.heLe.comprehensive;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LymphComprehensiveInputController Class
 *Description: lymphExamCompMultiSystem.fxml Controller class
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

public class LymphComprehensiveInputController implements Initializable {

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
	private CheckBox axillaeShootyleftCkeckBox;
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
	private CheckBox anterionShootyLeftCkeckBox;
	
	@FXML
	private CheckBox posteriorShootyLeftCkeckBox;
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
	private CheckBox groinShootyleftCkeckBox;
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
	private CheckBox axillaeNormalRightCkeckBox;

	@FXML
	private CheckBox axillaeAllNormalCkeckBox;

	@FXML
	private CheckBox supraclavicularBilaterallyCkeckBox;

	@FXML
	private CheckBox axillaeNotedCkeckBox;

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
	private CheckBox supraclavicularShootyLeftCkeckBox;

	@FXML
	private CheckBox groinBilaterallyCkeckBox;

	@FXML
	private CheckBox groinTenderRightCkeckBox;

	@FXML
	private CheckBox groinNormalRightCkeckBox;

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

		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(lymphInputController.str);
			skelComp.append("\n\n");
			lymphInputController.str = skelComp.toString();

			if (anterionAllNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" No cyanosis, swelling, delayed capillary refill.  No lymphadenopathy noted in the neck");
				lymphInputController.str = str1.toString();

			} else {
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
					|| supraclavicularShootyLeftCkeckBox.isSelected()) {

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
			if (supraclavicularShootyLeftCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("shooty left,");
				lymphInputController.str = str1.toString();

			}

			if (axillaeAllNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append(" Axillae normal. ");
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

			}
			
			if (locationsubmentalCkeckBox.isSelected()||locationleftCkeckBox.isSelected()
					||locationocciptalCkeckBox.isSelected()
					||locationrightCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(lymphInputController.str);
				str1.append("in the");
				lymphInputController.str = str1.toString();

			
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
			StringBuilder str13 = new StringBuilder(lymphInputController.str);
			str13.append("epitrochlear areas.,");
			lymphInputController.str = str13.toString();
			
			}
		
			// genericEMRChartingController.saveAllTextArea();
			++lymphInputController.formCount;
			lymphInputController.setLymphUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++lymphInputController.formCount;
				lymphInputController.setLymphUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
