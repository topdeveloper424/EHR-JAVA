package com.ets.controller.gui.emrCharting.exam.mskel.DigitalAndNail;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelDigitalNailInputController Class
 *Description: digitalAndNails GUI Controller class
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
public class SkelDigitalNailInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox prostatenormalCkeckBox;

	@FXML
	private CheckBox fingerNormalnails;

	@FXML
	private CheckBox fingerOnchomycosis;

	@FXML
	private CheckBox fingernailsSubungual;

	@FXML
	private CheckBox fingerPitting;

	@FXML
	private CheckBox fingerHemorrahages;

	@FXML
	private CheckBox fingerAvulsion;

	@FXML
	private CheckBox fingerTraumatic;

	@FXML
	private CheckBox fingerParonychiaRednes;

	@FXML
	private CheckBox toenailNormal;

	@FXML
	private CheckBox toenailOnchyomysois;

	@FXML
	private CheckBox toenailAvulsion;

	@FXML
	private CheckBox toenailSubungual;

	@FXML
	private CheckBox toenailPitting;

	@FXML
	private CheckBox toenailTraumatic;

	@FXML
	private CheckBox toenailHemorrahages;

	@FXML
	private CheckBox toenailgrown;

	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		skipBtn.setOnAction((event) -> {
			try {
				++msSkelInputController.formCount;
				msSkelInputController.setSkelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		doneBtn.setOnAction((event) -> {
			StringBuilder skelComp = new StringBuilder(msSkelInputController.str);
			skelComp.append("\n\n ");
			msSkelInputController.str = skelComp.toString();

			if (prostatenormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Digits and nails all appear normal. ");
				msSkelInputController.str = str1.toString();

			} else {

				if (fingerNormalnails.isSelected() || fingernailsSubungual.isSelected()
						|| fingerHemorrahages.isSelected() || fingerAvulsion.isSelected()
						|| fingerOnchomycosis.isSelected() || fingerPitting.isSelected() || fingerTraumatic.isSelected()
						|| fingerParonychiaRednes.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("Examination of the fingernails showed; ");
					msSkelInputController.str = str1.toString();

				}

				if (fingerNormalnails.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("normal nails, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingernailsSubungual.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("subungual hematoma, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerHemorrahages.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("hemorrhages, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerAvulsion.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("avulsion, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerOnchomycosis.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("onychomycosis, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerPitting.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("pitting, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerTraumatic.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("traumatic deformity, ");
					msSkelInputController.str = str1.toString();

				}
				if (fingerParonychiaRednes.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("paronychia redness swelling. ");
					msSkelInputController.str = str1.toString();

				}

			}

			if (toenailNormal.isSelected() || toenailOnchyomysois.isSelected() || toenailAvulsion.isSelected()
					|| toenailHemorrahages.isSelected() || toenailSubungual.isSelected() || toenailPitting.isSelected()
					|| toenailTraumatic.isSelected() || toenailgrown.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Examination of the toenails showed; ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("normal, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailOnchyomysois.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("onychomycosis,  ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailAvulsion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("avulsion,  ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailHemorrahages.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("hemorrhages, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailSubungual.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("subungual hematoma, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailPitting.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("pitting, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailTraumatic.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("traumatic deformity, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailgrown.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("ingrown with infection. ");
				msSkelInputController.str = str1.toString();

			}

			++msSkelInputController.formCount;
			msSkelInputController.setSkelUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++msSkelInputController.formCount;
				msSkelInputController.setSkelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
