package com.ets.controller.gui.authorizationTemplateGroup;



import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.visitCategoryGroup.VisitCategoryGroupEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.VisitCategoryGroup;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 09-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterAuthorizatrionRulesTemplateGroupController Class
 *Description: EnterAuthorizatrionRulesTemplateGroup.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/
public class AuthorizatrionRulesTemplateGroupInputController implements Initializable {

	@FXML
	private Button categoryGroupBtn;

	@FXML
	private Button cancel;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		categoryGroupBtn.setOnAction((event) -> {
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.VisitCategoryGroup", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<VisitCategoryGroup>> task =

					new Task<ObservableList<VisitCategoryGroup>>() {

						@Override
						protected ObservableList<VisitCategoryGroup> call() throws Exception {

							final ObservableList<VisitCategoryGroup> visitCategoryGroupList = new VisitCategoryGroupEntityController()
									.viewVisitCategoryGroup();

							if (isCancelled()) {
								return null;
							}
							return visitCategoryGroupList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("VisitCategoryGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategoryGroup", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.visitCategoryGroupDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		cancel.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(cancel);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
