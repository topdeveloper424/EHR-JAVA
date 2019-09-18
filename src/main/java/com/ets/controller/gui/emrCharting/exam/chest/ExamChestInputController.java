package com.ets.controller.gui.emrCharting.exam.chest;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamChestInputController Class
 *Description: chest.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesAortaInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesCarotidsInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesExamCompInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesExtremitiesInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvArteriesPedalInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvFemoralPulsesInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartAuscultationInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartExamCompMultiSysInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartExamCompSingleSysInputController;
import com.ets.controller.gui.emrCharting.exam.cv.CvHeartPulpationInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class ExamChestInputController implements Initializable{
	
	 	@FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox inspectionCheckBox;

	    @FXML
	    private CheckBox palpationCheckBox;

	    @FXML
	    private CheckBox mastitisCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	    
	    
	    private Button button;
	    
	    private CheckBox checkBox;

		FXMLFormPath formPath = new FXMLFormPath();

		private GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
				Button button, CheckBox checkBox) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
			this.checkBox = checkBox;
		}

		public static Integer formCount = 0;
		private Integer secondFormCount = 0;

		public String str="\n\nBREASTS: ";

		void formCountIncrement() {
			++secondFormCount;
		}
		
		

		public void setChestUI() {

			if (allNormalCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(str);
				str1.append("Inspection reveals no abnormalities bilaterally. Palpation of breasts show no masses bilaterally, and no axillary"
						+ " adenopathy.");
				str = str1.toString();
				allNormalCheckBox.setSelected(false);
				setChestUI();
			}else if (examCheckBox.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ChestBreastExamComprehensive", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ChestBreastExamComprehensive", null, Locale.US);
				formPath.closeApplicationContext();

				ChestBreastExamComprehensiveInputController chestBreastExamComprehensiveInputController = (ChestBreastExamComprehensiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				chestBreastExamComprehensiveInputController.setExamChestInputController(this);
				examCheckBox.setSelected(false);

			}else if (inspectionCheckBox.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ChestBreastInspection", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ChestBreastInspection", null, Locale.US);
				formPath.closeApplicationContext();

				ChestBreastInspectionInputController chestBreastInspectionInputController = (ChestBreastInspectionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				chestBreastInspectionInputController.setExamChestInputController(this);
				inspectionCheckBox.setSelected(false);

			}

			else if (palpationCheckBox.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ChestBreastPalpation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ChestBreastPalpation", null, Locale.US);
				formPath.closeApplicationContext();

				ChestBreastPalpationInputController chestBreastPalpationInputController = (ChestBreastPalpationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				chestBreastPalpationInputController.setExamChestInputController(this);
				palpationCheckBox.setSelected(false);

			} else if (mastitisCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(str);
				str1.append("Affected breast appears swollen, engorged and erythematous to inspection. The breast is indurated and tender.");
				str = str1.toString();
				mastitisCheckBox.setSelected(false);
				setChestUI();

			}  else if (secondFormCount == formCount) {

				genericEMRChartingController.paint(button);
				genericEMRChartingController.hideCheckBox(checkBox);
				new FXFormCommonUtilities().closeForm(doneBtn);
				formCount = 0;
				genericEMRChartingController.setExamOrganTextArea(str);
				genericEMRChartingController.saveAllTextArea();

			}

		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			doneBtn.setOnAction((event)->
			{
				
				setChestUI();
			
			});
			
			skipBtn.setOnAction((event) -> {
				try {
					
					new FXFormCommonUtilities().closeForm( skipBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});

		}

	}
