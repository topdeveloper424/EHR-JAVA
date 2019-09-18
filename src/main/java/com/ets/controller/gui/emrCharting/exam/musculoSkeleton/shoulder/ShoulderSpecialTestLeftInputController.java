package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.shoulder;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ShoulderSpecialTestLeftInputController Class
 *Description: shoulderSpecialTestLeft GUI Controller class
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
public class ShoulderSpecialTestLeftInputController implements Initializable{
	
	
	  @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton AnteriornegativeRadio;

	    @FXML
	    private ToggleGroup Anterior;

	    @FXML
	    private RadioButton AnteriorpossitiveRadio;

	    @FXML
	    private RadioButton ApleyNegativeRadio;

	    @FXML
	    private ToggleGroup Apley;

	    @FXML
	    private RadioButton ApleypossitiveRadio;

	    @FXML
	    private RadioButton ApprehensionnegativeRadio;

	    @FXML
	    private ToggleGroup Apprehensio;

	    @FXML
	    private RadioButton ApprehensionpossitiveRadio;

	    @FXML
	    private RadioButton CrossnegativeRadio;

	    @FXML
	    private ToggleGroup Cross;

	    @FXML
	    private RadioButton CrosspossitiveRadio;

	    @FXML
	    private RadioButton DropnegativeRadio;

	    @FXML
	    private ToggleGroup Drop;

	    @FXML
	    private RadioButton DroppossitiveRadio;

	    @FXML
	    private RadioButton EmptynegativeRadio;

	    @FXML
	    private ToggleGroup Empty;

	    @FXML
	    private RadioButton EmptypossitiveRadio;

	    @FXML
	    private RadioButton HawkinsnegativeRadio;

	    @FXML
	    private ToggleGroup Hawkins;

	    @FXML
	    private RadioButton HawkinspossitiveRadio;

	    @FXML
	    private RadioButton NeernegativeRadio;

	    @FXML
	    private ToggleGroup Neers;

	    @FXML
	    private RadioButton NeerpossitiveRadio;

	    @FXML
	    private RadioButton BriennegativeRadio;

	    @FXML
	    private ToggleGroup brien;

	    @FXML
	    private RadioButton BrienpossitiveRadio;

	    @FXML
	    private RadioButton RelocationnegativeRadio;

	    @FXML
	    private ToggleGroup Relocation;

	    @FXML
	    private RadioButton RelocationpossitiveRadio;

	    @FXML
	    private RadioButton SpeedsnegativeRadio;

	    @FXML
	    private ToggleGroup Speeds;

	    @FXML
	    private RadioButton SpeedspossitiveRadio;

	    @FXML
	    private RadioButton SpurlingnegativeRadio;

	    @FXML
	    private ToggleGroup Spurling;

	    @FXML
	    private RadioButton SpurlingpossitiveRadio;

	    @FXML
	    private RadioButton SulcusnegativeRadio;

	    @FXML
	    private ToggleGroup Sulcus;

	    @FXML
	    private RadioButton SulcuspossitiveRadio;

	    @FXML
	    private RadioButton YergasonegativeRadio;

	    @FXML
	    private ToggleGroup Yergaso;

	    @FXML
	    private RadioButton YergasopossitiveRadio;
	    
	    private ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController;

	    public void setExamMusculotoneShoulderInputController(
				ExamMusculotoneShoulderInputController examMusculotoneShoulderInputController) {
			this.examMusculotoneShoulderInputController = examMusculotoneShoulderInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneShoulderInputController.str);
			examComp.append("\n\nSPECIAL TESTS:\nLeft Shoulder- the following special tests were performed:");
			examMusculotoneShoulderInputController.str = examComp.toString();
			
			
			if (AnteriornegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\n Anterior drawer test negative.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (AnteriorpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\n Anterior drawer test positive., ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (ApleyNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nApley scratch test negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (ApleypossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nApley scratch test positive. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (ApprehensionnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nApprehension test negative, ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (ApprehensionpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nApprehension test positive ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (CrossnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nCross arm test negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (CrosspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nCross arm test positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (DropnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nDrop arm test negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (DroppossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nDrop arm test positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (EmptynegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nEmpty can negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (EmptypossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\n Empty can positive. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			if (HawkinsnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nHawkins negative.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (HawkinspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nHawkins positive. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (NeerpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nNeers positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (NeernegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nNeers negative.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (BriennegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nO'Brien test negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (BrienpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nO'Brien test positive .");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (RelocationnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRelocation test negative.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (RelocationpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nRelocation test positive. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (SpeedsnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSpeeds test negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (SpeedspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSpeeds test positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			if (SpurlingnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSpurling negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (SpurlingpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSpurling positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			if (SulcusnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSulcus negative. ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (SulcuspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nSulcus positive.");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			if (YergasonegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nYergason's negative ");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			if (YergasopossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneShoulderInputController.str);
				str1.append("\nYergason's positive");
				examMusculotoneShoulderInputController.str = str1.toString();

			}
			
			
			
			
			
			

			++examMusculotoneShoulderInputController.formCount;
			examMusculotoneShoulderInputController.setShoulderUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneShoulderInputController.formCount;
				examMusculotoneShoulderInputController.setShoulderUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
