package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PTParametersInputController implements Initializable {
	
	  @FXML
	    private RadioButton pelvicRadio;

	    @FXML
	    private ToggleGroup Leukocytes;

	    @FXML
	    private RadioButton cervicRadio;

	    @FXML
	    private RadioButton grade1Radio;

	    @FXML
	    private ToggleGroup Urobilinogen;

	    @FXML
	    private RadioButton grade2Radio;

	    @FXML
	    private RadioButton grade3Radio;

	    @FXML
	    private RadioButton grade4Radio;

	    @FXML
	    private RadioButton spinalRadio;

	    @FXML
	    private ToggleGroup Protein;

	    @FXML
	    private RadioButton kneeRadio;

	    @FXML
	    private RadioButton wristRadio;

	    @FXML
	    private RadioButton shoulderRadio;

	    @FXML
	    private RadioButton wateage00Radio;

	    @FXML
	    private ToggleGroup ph;

	    @FXML
	    private RadioButton wateage08Radio;

	    @FXML
	    private RadioButton wateage1Radio;

	    @FXML
	    private RadioButton wateage12Radio;

	    @FXML
	    private RadioButton wateage14Radio;

	    @FXML
	    private RadioButton percent50Radio;

	    @FXML
	    private ToggleGroup Blood;

	    @FXML
	    private RadioButton percent100Radio;

	    @FXML
	    private RadioButton mhz1Radio;

	    @FXML
	    private ToggleGroup Gravity;

	    @FXML
	    private RadioButton mhz2Radio;

	    @FXML
	    private RadioButton mhz3Radio;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField poundageText;

	    @FXML
	    private TextField maText;

	    @FXML
	    private CheckBox includeCheck;

	    @FXML
	    private CheckBox joules04Check;

	    @FXML
	    private CheckBox joules10Check;

	    @FXML
	    private CheckBox joules06Check;

	    @FXML
	    private CheckBox joules20Check;

	    @FXML
	    private CheckBox continuousCheck;

	    @FXML
	    private CheckBox pulsedCheck;
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		okBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			
			if (pelvicRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("TRACTION:  Patient received pelvic ");
				resultInputController.str = str1.toString();
				
			}if (cervicRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("TRACTION:  Patient received cervic ");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (poundageText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" traction at " +poundageText.getText() +" lbs.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			if (grade1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MOBS:  Patient tolerated grade I ");
				resultInputController.str = str1.toString();
				
			}if (grade2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MOBS:  Patient tolerated grade II ");
				resultInputController.str = str1.toString();

			}if (grade3Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MOBS:  Patient tolerated grade III ");
				resultInputController.str = str1.toString();

			}if (grade4Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MOBS:  Patient tolerated grade IV ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (spinalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("spinal mobs.");
				resultInputController.str = str1.toString();
				
			}if (wristRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("wrist mobs.");
				resultInputController.str = str1.toString();

			}if (kneeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("knee mobs.");
				resultInputController.str = str1.toString();

			}if (shoulderRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("shoulder mobs.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (wateage00Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nULTRASOUND:  Patient received ultrasound at 0.0 w/cm2");
				resultInputController.str = str1.toString();
				
			}if (wateage08Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nULTRASOUND:  Patient received ultrasound at 0.8 w/cm2");
				resultInputController.str = str1.toString();

			}if (wateage12Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nULTRASOUND:  Patient received ultrasound at 1.2 w/cm2");
				resultInputController.str = str1.toString();

			}if (wateage14Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nULTRASOUND:  Patient received ultrasound at 1.4 w/cm2");
				resultInputController.str = str1.toString();
				
			}if (wateage1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nULTRASOUND:  Patient received ultrasound at 1.0 w/cm2");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (percent100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("x 100% ");
				resultInputController.str = str1.toString();
				
			}if (percent50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("x 50% ");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			if (mhz1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("@ 1 MHz.");
				resultInputController.str = str1.toString();

			}if (mhz2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("@ 2 MHz.");
				resultInputController.str = str1.toString();
				
			}if (mhz3Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("@ 3 MHz.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			if (maText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("IONTOPHORESIS:  Patient received iontophoresis at " +maText.getText() +" MA @ 40 MA / Min.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			if (includeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("ELECTRIC STIMULATION:  Patient received interferential ES x 15 min to decrease pain and swelling to increase function.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (joules04Check.isSelected() || joules06Check.isSelected()
					
					|| joules10Check.isSelected() || joules20Check.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("Low level laser therapy applied at ");
				resultInputController.str = str.toString();
					
				if (joules04Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("0.4 - 0.6 Joules, ");
					resultInputController.str = str1.toString();

				}if (joules06Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("0.6 - 0.8 Joules, ");
					resultInputController.str = str1.toString();
					
				}if (joules10Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("0.8 - 1.0 Joules ");
					resultInputController.str = str1.toString();

				}if (joules20Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("1.0 - 2.0 Joules ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" to the affected area. ");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			if (continuousCheck.isSelected() || pulsedCheck.isSelected()) {

				
				
				if (continuousCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("continuous mode, ");
					resultInputController.str = str1.toString();
					
				}if (pulsedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("pulsed mode, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(okBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
