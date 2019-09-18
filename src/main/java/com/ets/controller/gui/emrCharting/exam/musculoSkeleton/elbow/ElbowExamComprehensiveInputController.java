package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.elbow;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ElbowExamComprehensiveInputController Class
 *Description: ElbowExamComprehensive GUI Controller class
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
public class ElbowExamComprehensiveInputController implements Initializable {

	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox toneNormal;

    @FXML
    private CheckBox painNormal;

    @FXML
    private RadioButton Left;

    @FXML
    private ToggleGroup elbow;

    @FXML
    private RadioButton right;

    @FXML
    private RadioButton tendernessLateral;

    @FXML
    private ToggleGroup tender;

    @FXML
    private RadioButton tendernessMedial;

    @FXML
    private CheckBox tendernessNormal;

    @FXML
    private RadioButton tendernessOlecranon;

    @FXML
    private RadioButton gripDecreased;

    @FXML
    private ToggleGroup grip;

    @FXML
    private RadioButton gripNormal;

    @FXML
    private RadioButton toneDecreased;

    @FXML
    private ToggleGroup tone;

    @FXML
    private RadioButton toneNormalRadio;

    @FXML
    private CheckBox painFlexion;

    @FXML
    private CheckBox painPronation;

    @FXML
    private CheckBox painExtension;

    @FXML
    private CheckBox painSupination;

    @FXML
    private RadioButton tendernessRadial;

    @FXML
    private RadioButton resistedExtensionNegative;

    @FXML
    private ToggleGroup extention;

    @FXML
    private RadioButton resistedExtensionPositive;

    @FXML
    private RadioButton resistedFlexionNegative;

    @FXML
    private ToggleGroup flexion;

    @FXML
    private RadioButton resistedFlexionPositive;

	private ExamMusculotoneElbowInputController examMusculotoneElbowInputController;

	public void setExamMusculotoneElbowInputController(
			ExamMusculotoneElbowInputController examMusculotoneElbowInputController) {
		this.examMusculotoneElbowInputController = examMusculotoneElbowInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneElbowInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneElbowInputController.str = examComp.toString();

			if (Left.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Examination of the left elbow ");
				examMusculotoneElbowInputController.str = str1.toString();

			}

			if (right.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Examination of the right elbow");
				examMusculotoneElbowInputController.str = str1.toString();

			}

			if (toneNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneElbowInputController.str);
				str11.append("shows normal tone and symmetry.");
				examMusculotoneElbowInputController.str = str11.toString();

			} else {

				if (toneDecreased.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("shows decreased tone.");
					examMusculotoneElbowInputController.str = str1.toString();

				}
				if (toneNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("shows normal tone.");
					examMusculotoneElbowInputController.str = str1.toString();

				}

			}

			if (painNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneElbowInputController.str);
				str11.append("Active elbow motion is not painful. ");
				examMusculotoneElbowInputController.str = str11.toString();

			} else {

				if (painExtension.isSelected() || painFlexion.isSelected() || painPronation.isSelected()
						|| painSupination.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneElbowInputController.str);
					str11.append("Elbow motion is painful on ");
					examMusculotoneElbowInputController.str = str11.toString();

					if (painExtension.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
						str1.append("extension, ");
						examMusculotoneElbowInputController.str = str1.toString();

					}
					if (painFlexion.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
						str1.append("flexion, ");
						examMusculotoneElbowInputController.str = str1.toString();

					}
					if (painPronation.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
						str1.append("pronation, ");
						examMusculotoneElbowInputController.str = str1.toString();

					}
					if (painSupination.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
						str1.append("supination, ");
						examMusculotoneElbowInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append(".");
					examMusculotoneElbowInputController.str = str1.toString();

				}

			}

			if (tendernessNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneElbowInputController.str);
				str11.append("There is no tenderness to palpation.");
				examMusculotoneElbowInputController.str = str11.toString();

			} else {

				if (tendernessLateral.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("There is tenderness at the lateral epicondyle. ");
					examMusculotoneElbowInputController.str = str1.toString();

				}
				if (tendernessMedial.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("There is tenderness at the medial epicondyle. ");
					examMusculotoneElbowInputController.str = str1.toString();

				}
				if (tendernessOlecranon.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("There is tenderness at the olecranon. ");
					examMusculotoneElbowInputController.str = str1.toString();

				}
				if (tendernessRadial.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
					str1.append("There is tenderness at the radial head. ");
					examMusculotoneElbowInputController.str = str1.toString();

				}

			}

			if (gripDecreased.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Grip strength is decreased. ");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			if (gripNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Grip strength is normal. ");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			

			if (resistedExtensionNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Resisted wrist extension test negative for pain at the lateral epicondyle.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			if (resistedExtensionPositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Resisted wrist extension test possitive for pain at the lateral epicondyle.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			

			if (resistedFlexionNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Resisted wrist flexion test negative for pain at the medial epicondyle.");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			if (resistedFlexionPositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Resisted wrist flexion test positive for pain at the medial epicondyle.");
				examMusculotoneElbowInputController.str = str1.toString();

			}

			++examMusculotoneElbowInputController.formCount;
			examMusculotoneElbowInputController.setElbowUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneElbowInputController.formCount;
				examMusculotoneElbowInputController.setElbowUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
