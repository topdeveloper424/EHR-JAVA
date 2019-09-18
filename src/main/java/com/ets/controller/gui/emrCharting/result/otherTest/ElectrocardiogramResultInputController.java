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

public class ElectrocardiogramResultInputController implements Initializable {
	
	@FXML
    private CheckBox normalChexk;

    @FXML
    private CheckBox pvcInPairCheck;

    @FXML
    private CheckBox pvcInRunCheck;

    @FXML
    private CheckBox BigeminyCheck;

    @FXML
    private CheckBox TrigeminyCheck;

    @FXML
    private CheckBox QuadrigeminyCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton AtrialFlutterRadio;

    @FXML
    private ToggleGroup fast;

    @FXML
    private RadioButton psvtRadio;

    @FXML
    private RadioButton SinusTachycardiaradio;

    @FXML
    private RadioButton AtrialFibrillationRadio;

    @FXML
    private TextArea freeText;

    @FXML
    private RadioButton pvcRadio;

    @FXML
    private RadioButton BigeminyRadio;

    @FXML
    private RadioButton VentricularTachycardiaradio;

    @FXML
    private RadioButton VentricularFibrillationRadio;

    @FXML
    private RadioButton STElevationsRadio;

    @FXML
    private RadioButton Trigeminyradio;

    @FXML
    private RadioButton QuadrigeminyRadio;

    @FXML
    private RadioButton type1Radio;

    @FXML
    private ToggleGroup slow;

    @FXML
    private RadioButton type2Radio;

    @FXML
    private RadioButton SinusBradycardiaradio;

    @FXML
    private RadioButton heartBlock1Radio;

    @FXML
    private RadioButton slowPVCRadio;

    @FXML
    private RadioButton heartBlock3radio;

    @FXML
    private RadioButton AsystoleRadio;

    @FXML
    private CheckBox pvcCheck;

    @FXML
    private CheckBox inferiorCheck;

    @FXML
    private CheckBox laterallyCheck;

    @FXML
    private CheckBox posteriorCheck;

    @FXML
    private CheckBox acuteCheck;

    @FXML
    private CheckBox oldCheck;

    @FXML
    private CheckBox anteriorCheck;
	    
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			
			if (normalChexk.isSelected()) {

				StringBuilder str14 = new StringBuilder(resultInputController.str);
				str14.append("EKG Results: An in office EKG was performed and is attached (scanned ). "
						+ "The interpretation is: Normal Sinus Rhythm.");
				resultInputController.str = str14.toString();
				
				
				
				
				
				
				if (SinusTachycardiaradio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Sinus Tachycardia. ");
					resultInputController.str = str1.toString();
					
				}if (AtrialFlutterRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Atrial Flutter. ");
					resultInputController.str = str1.toString();

				}if (VentricularTachycardiaradio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Ventricular Tachycardia. ");
					resultInputController.str = str1.toString();

				}if (pvcRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm PVC's. ");
					resultInputController.str = str1.toString();
					
				}if (Trigeminyradio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Trigeminy. ");
					resultInputController.str = str1.toString();

				}if (STElevationsRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm ST Elevations. ");
					resultInputController.str = str1.toString();

				}if (AtrialFibrillationRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Atrial Fibrillation. ");
					resultInputController.str = str1.toString();
					
				}if (psvtRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm PSVT. ");
					resultInputController.str = str1.toString();

				}if (VentricularFibrillationRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Ventricular  Fibrillation. ");
					resultInputController.str = str1.toString();

				}if (BigeminyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Bigeminy. ");
					resultInputController.str = str1.toString();
					
				}if (QuadrigeminyRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A fast rhythm Quadrigeminy. ");
					resultInputController.str = str1.toString();

				}
				
				
				
				
				
				if (SinusBradycardiaradio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; Sinus Bradycardia.");
					resultInputController.str = str1.toString();
					
				}if (type1Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; 2nd degree heart block type 1.");
					resultInputController.str = str1.toString();

				}if (heartBlock3radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; 3rd degree Heart block.");
					resultInputController.str = str1.toString();

				}if (slowPVCRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; PVCs.");
					resultInputController.str = str1.toString();
					
				}if (heartBlock1Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; 1st degree Heart block.");
					resultInputController.str = str1.toString();

				}if (type2Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; 2nd degree heart block type 2.");
					resultInputController.str = str1.toString();

				}if (AsystoleRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("A slow rhythm; Asystole.");
					resultInputController.str = str1.toString();

				}
				
				
				
				
				
				
				if (pvcCheck.isSelected() || pvcInRunCheck.isSelected()
						|| TrigeminyCheck.isSelected() || pvcInPairCheck.isSelected()
						|| BigeminyCheck.isSelected() || QuadrigeminyCheck.isSelected()) {

					StringBuilder str = new StringBuilder(resultInputController.str);
					str.append(" Irregular Rhythm ");
					resultInputController.str = str.toString();
					
					if (pvcCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("PVCs, ");
						resultInputController.str = str1.toString();
						
					}if (pvcInRunCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("PVC's in runs of 3, ");
						resultInputController.str = str1.toString();
						
					}if (TrigeminyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("Trigeminy, ");
						resultInputController.str = str1.toString();

					}if (pvcInPairCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("PVC's in pairs (couplets), ");
						resultInputController.str = str1.toString();
						
					}if (BigeminyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("Bigeminy, ");
						resultInputController.str = str1.toString();
						
					}if (QuadrigeminyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("Quadrigeminy, ");
						resultInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(".");
					resultInputController.str = str1.toString();
					

				}
				
				
				
				
				
				
				
				if (anteriorCheck.isSelected() || laterallyCheck.isSelected()
						|| acuteCheck.isSelected() || inferiorCheck.isSelected()
						|| posteriorCheck.isSelected() || oldCheck.isSelected()) {

					StringBuilder str = new StringBuilder(resultInputController.str);
					str.append("ST segment findings of ");
					resultInputController.str = str.toString();
					
					if (anteriorCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("ST elevations anteriorly, ");
						resultInputController.str = str1.toString();
						
					}if (laterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("ST elevations laterally, ");
						resultInputController.str = str1.toString();

					}if (acuteCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("Acute ST changes, ");
						resultInputController.str = str1.toString();

					}if (inferiorCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("ST elevations inferior leads.");
						resultInputController.str = str1.toString();
						
					}if (posteriorCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("ST changes posteriorly, ");
						resultInputController.str = str1.toString();

					}if (oldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(resultInputController.str);
						str1.append("Old ST changes, ");
						resultInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(".");
					resultInputController.str = str1.toString();
					

				}
				
				
				
				
				
				if (freeText.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("\n" +freeText.getText() +".");
					resultInputController.str = str1.toString();

				}
				
				
				
				
				
			}else{
				
							
			
			if(SinusTachycardiaradio.isSelected() || AtrialFlutterRadio.isSelected()
					|| VentricularTachycardiaradio.isSelected() || pvcRadio.isSelected()
					|| Trigeminyradio.isSelected() || STElevationsRadio.isSelected()
					|| AtrialFibrillationRadio.isSelected() || psvtRadio.isSelected()
					|| VentricularFibrillationRadio.isSelected() || BigeminyRadio.isSelected()
					|| QuadrigeminyRadio.isSelected() || SinusBradycardiaradio.isSelected()
					|| type1Radio.isSelected() || heartBlock3radio.isSelected()
					|| slowPVCRadio.isSelected() || heartBlock1Radio.isSelected()
					|| type2Radio.isSelected() || AsystoleRadio.isSelected()){
				
				
				
				StringBuilder str11 = new StringBuilder(resultInputController.str);
				str11.append("EKG Results: An in office EKG was performed and is attached (scanned )."
						+ " The interpretation is: ");
				resultInputController.str = str11.toString();
				
			
			
			if (SinusTachycardiaradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Sinus Tachycardia. ");
				resultInputController.str = str1.toString();
				
			}if (AtrialFlutterRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Atrial Flutter. ");
				resultInputController.str = str1.toString();

			}if (VentricularTachycardiaradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Ventricular Tachycardia. ");
				resultInputController.str = str1.toString();

			}if (pvcRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm PVC's. ");
				resultInputController.str = str1.toString();
				
			}if (Trigeminyradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Trigeminy. ");
				resultInputController.str = str1.toString();

			}if (STElevationsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm ST Elevations. ");
				resultInputController.str = str1.toString();

			}if (AtrialFibrillationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Atrial Fibrillation. ");
				resultInputController.str = str1.toString();
				
			}if (psvtRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm PSVT. ");
				resultInputController.str = str1.toString();

			}if (VentricularFibrillationRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Ventricular  Fibrillation. ");
				resultInputController.str = str1.toString();

			}if (BigeminyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Bigeminy. ");
				resultInputController.str = str1.toString();
				
			}if (QuadrigeminyRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A fast rhythm Quadrigeminy. ");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (SinusBradycardiaradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; Sinus Bradycardia.");
				resultInputController.str = str1.toString();
				
			}if (type1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; 2nd degree heart block type 1.");
				resultInputController.str = str1.toString();

			}if (heartBlock3radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; 3rd degree Heart block.");
				resultInputController.str = str1.toString();

			}if (slowPVCRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; PVCs.");
				resultInputController.str = str1.toString();
				
			}if (heartBlock1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; 1st degree Heart block.");
				resultInputController.str = str1.toString();

			}if (type2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; 2nd degree heart block type 2.");
				resultInputController.str = str1.toString();

			}if (AsystoleRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("A slow rhythm; Asystole.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (pvcCheck.isSelected() || pvcInRunCheck.isSelected()
					|| TrigeminyCheck.isSelected() || pvcInPairCheck.isSelected()
					|| BigeminyCheck.isSelected() || QuadrigeminyCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append(" Irregular Rhythm ");
				resultInputController.str = str.toString();
				
				if (pvcCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("PVCs, ");
					resultInputController.str = str1.toString();
					
				}if (pvcInRunCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("PVC's in runs of 3, ");
					resultInputController.str = str1.toString();
					
				}if (TrigeminyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Trigeminy, ");
					resultInputController.str = str1.toString();

				}if (pvcInPairCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("PVC's in pairs (couplets), ");
					resultInputController.str = str1.toString();
					
				}if (BigeminyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Bigeminy, ");
					resultInputController.str = str1.toString();
					
				}if (QuadrigeminyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Quadrigeminy, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			if (anteriorCheck.isSelected() || laterallyCheck.isSelected()
					|| acuteCheck.isSelected() || inferiorCheck.isSelected()
					|| posteriorCheck.isSelected() || oldCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("ST segment findings of ");
				resultInputController.str = str.toString();
				
				if (anteriorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ST elevations anteriorly, ");
					resultInputController.str = str1.toString();
					
				}if (laterallyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ST elevations laterally, ");
					resultInputController.str = str1.toString();

				}if (acuteCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Acute ST changes, ");
					resultInputController.str = str1.toString();

				}if (inferiorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ST elevations inferior leads.");
					resultInputController.str = str1.toString();
					
				}if (posteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("ST changes posteriorly, ");
					resultInputController.str = str1.toString();

				}if (oldCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Old ST changes, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (freeText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +freeText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			}
			}	

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

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
