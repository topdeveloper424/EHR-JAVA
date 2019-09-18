package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.chest;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckCervicalMildSpasmInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckCompressionInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckDistractionInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckDtrInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckExamComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckRepeatedMovementInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckRomSpineInputController;
import com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck.NeckVertibralArteryInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMusculotoneChestInputController Class
 *Description: MusculoChest.fxml GUI Controller class
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
public class ExamMusculotoneChestInputController implements Initializable{
	
	 @FXML
	    private CheckBox allNormalComprehensive;

	    @FXML
	    private CheckBox examComprehensive;

	    @FXML
	    private CheckBox RomSpine;

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

		public String str="\n\n";

		void formCountIncrement() {
			++secondFormCount;
		}
		
		
		public void setChestUI() {

			if (allNormalComprehensive.isSelected()) {

				StringBuilder str1 = new StringBuilder(str);
				str1.append("Examination of the ribs shows symmetrical movement, normal breath sounds, and no signs of abrasions,"
						+ " ecchymosis or lacerations.");
				str = str1.toString();
				allNormalComprehensive.setSelected(false);
				setChestUI();
			}else if (examComprehensive.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ExamMusculoSkeletonChestExamComp", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonChestExamComp", null, Locale.US);
				formPath.closeApplicationContext();

				ChestExamComprehensiveInputController chestExamComprehensiveInputController = (ChestExamComprehensiveInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				chestExamComprehensiveInputController.setExamMusculotoneChestInputController(this);
				examComprehensive.setSelected(false);

			}

			else if (RomSpine.isSelected()) {

				formCountIncrement();
				String formName = formPath.context.getMessage("ExamMusculoSkeletonChestRibRom", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExamMusculoSkeletonChestRibRom", null, Locale.US);
				formPath.closeApplicationContext();

				ChestRibRomInputController chestRibRomInputController = (ChestRibRomInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				chestRibRomInputController.setExamMusculotoneChestInputController(this);
				RomSpine.setSelected(false);

			} else if (secondFormCount == formCount) {

				genericEMRChartingController.paint(button);
				genericEMRChartingController.hideCheckBox(checkBox);
				new FXFormCommonUtilities().closeForm(doneBtn);
				formCount = 0;
				genericEMRChartingController.setExamOrganTextArea(str);
				genericEMRChartingController.saveAllTextArea();

			}

		}
		

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
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
