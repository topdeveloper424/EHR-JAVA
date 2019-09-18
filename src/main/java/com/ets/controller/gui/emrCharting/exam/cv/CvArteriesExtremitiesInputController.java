package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvArteriesExtremitiesInputController Class
 *Description: cvArteriesExtremities GUI Controller class
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
public class CvArteriesExtremitiesInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox edemaLeftAllNormalCheck;

    @FXML
    private CheckBox edemaLeft3Check;

    @FXML
    private CheckBox edemaLeft4Check;

    @FXML
    private CheckBox edemaLeftNonPittinglCheck;

    @FXML
    private CheckBox edemaLeft2Check;

    @FXML
    private CheckBox edemaLeft1Check;

    @FXML
    private CheckBox edemaLeftPittinglCheck;

    @FXML
    private CheckBox edemaLeftNoneNotedlCheck;

    @FXML
    private CheckBox VaricositiesLeftNoneCheck;

    @FXML
    private CheckBox VaricositiesLeftMildCheck;

    @FXML
    private CheckBox VaricositiesLeftModerateCheck;

    @FXML
    private CheckBox VaricositiesLeftServeCheck;

    @FXML
    private CheckBox VaricositiesLeftWithStasisCheck;

    @FXML
    private CheckBox edemaRight3Check;

    @FXML
    private CheckBox edemaRight4Check;

    @FXML
    private CheckBox edemaRightNonPittinglCheck;

    @FXML
    private CheckBox edemaRight2Check;

    @FXML
    private CheckBox edemaRight1Check;

    @FXML
    private CheckBox edemaRightPittinglCheck;

    @FXML
    private CheckBox edemaRightNoneNotedlCheck;

    @FXML
    private CheckBox VaricositiesRightNoneCheck;

    @FXML
    private CheckBox VaricositiesRightMildCheck;

    @FXML
    private CheckBox VaricositiesRightModerateCheck;

    @FXML
    private CheckBox VaricositiesRightServeCheck;

    @FXML
    private CheckBox VaricositiesRightWithStasisCheck;
    
    
    private ExamCvInputController examCvInputController;

	public void setExamCvInputController(ExamCvInputController examCvInputController) {
		this.examCvInputController = examCvInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\nCV: ");
			examCvInputController.str = examComp.toString();

		
			
			
			
			
			
			
			if (edemaLeftAllNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("No edema or varicosities are noted.");
				examCvInputController.str = str1.toString();
				
			}else{
				
				if (edemaLeft1Check.isSelected() || edemaLeft2Check.isSelected() || edemaLeft3Check.isSelected()
						|| edemaLeft4Check.isSelected() || edemaLeftNoneNotedlCheck.isSelected() || edemaLeftNonPittinglCheck.isSelected()
						|| edemaLeftPittinglCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Edema:  left ");
					examCvInputController.str = str11.toString();
					
					
					
					
					if (edemaLeft1Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+1, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaLeft2Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+2, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaLeft3Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+3, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaLeft4Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+4, ");
						examCvInputController.str = str1.toString();

					}if (edemaLeftNoneNotedlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("none noted, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaLeftNonPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("non pitting, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaLeftPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("pierced lobes, ");
						examCvInputController.str = str1.toString();

					}
					
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append(";");
					examCvInputController.str = str1.toString();

				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
				
				
				
				if (edemaRight1Check.isSelected() || edemaRight2Check.isSelected() || edemaRight3Check.isSelected()
						|| edemaRight4Check.isSelected() || edemaRightNoneNotedlCheck.isSelected() || edemaRightNonPittinglCheck.isSelected()
						|| edemaRightPittinglCheck.isSelected() ) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Edema:  right ");
					examCvInputController.str = str11.toString();
					
					
					
					
					if (edemaRight1Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+1, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight2Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+2, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight3Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+3, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight4Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+4, ");
						examCvInputController.str = str1.toString();

					}if (edemaRightNoneNotedlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("none noted, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRightNonPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("non pitting, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRightPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("pitting, ");
						examCvInputController.str = str1.toString();

					}
					
					
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append(";");
					examCvInputController.str = str1.toString();

				}
				
			
			
			
			
			
			
			
			
				

				if (VaricositiesLeftMildCheck.isSelected() || VaricositiesLeftModerateCheck.isSelected() || VaricositiesLeftNoneCheck.isSelected()
					|| VaricositiesLeftServeCheck.isSelected() || VaricositiesLeftWithStasisCheck.isSelected() ) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Varicosities: left ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (VaricositiesLeftMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("mild, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("moderate, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftNoneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("none noted, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftServeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("severe, ");
					examCvInputController.str = str1.toString();

				}if (VaricositiesLeftWithStasisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with stasis changes, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (VaricositiesRightMildCheck.isSelected() || VaricositiesRightModerateCheck.isSelected() || VaricositiesRightNoneCheck.isSelected()
					|| VaricositiesRightServeCheck.isSelected() || VaricositiesRightWithStasisCheck.isSelected() ) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Varicosities: right ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (VaricositiesRightMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("mild, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("moderate, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightNoneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("none noted, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightServeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("severe, ");
					examCvInputController.str = str1.toString();

				}if (VaricositiesRightWithStasisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with stasis changes, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

			}
			
			
			
			

			++examCvInputController.formCount;
			examCvInputController.setCvUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			
			
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examCvInputController.formCount;
				examCvInputController.setCvUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
