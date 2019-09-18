package com.ets.controller.gui.numberPad;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.genericVisitProtocal.EnterVitalSignGUIController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NumberPadGUIController implements Initializable {
	
	 @FXML
	    private Button Btn1;

	    @FXML
	    private Button Btn2;

	    @FXML
	    private Button Btn3;

	    @FXML
	    private Button Btn4;

	    @FXML
	    private Button Btn5;

	    @FXML
	    private Button Btn6;

	    @FXML
	    private Button Btn7;

	    @FXML
	    private Button Btn8;

	    @FXML
	    private Button Btn9;

	    @FXML
	    private Button BtnDot;

	    @FXML
	    private Button Btn0;

	    @FXML
	    private Button BtnPlusOrMinus;

	    @FXML
	    private TextField displayText;

	    @FXML
	    private Button clearBtn;

	    @FXML
	    private Button backSpaceBtn;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;
	    
	    private Button button;
	    
	    private Integer heightIncm;
	    private EnterVitalSignGUIController enterVitalSignGUIController;

	    public void setEnterVitalSignGUIController(EnterVitalSignGUIController enterVitalSignGUIController) {
			this.enterVitalSignGUIController = enterVitalSignGUIController;
		}
	    
	    public void setEnterVitalSignGUIController(EnterVitalSignGUIController enterVitalSignGUIController, Button button) {
			this.enterVitalSignGUIController = enterVitalSignGUIController;
			this.button = button;
		}
	    String str = null;
		
		String str2 = null;
		
		static Double ozKg = 0.00;
		
		static Double lbtoKg  = 0.00;
				
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//displayText.setText("0");
		
		Btn1.setOnAction((event) -> {
			displayText.appendText("1");
		});
		Btn2.setOnAction((event) -> {
			displayText.appendText("2");
		});
		Btn3.setOnAction((event) -> {
			displayText.appendText("3");
		});
		Btn4.setOnAction((event) -> {
			displayText.appendText("4");
		});
		Btn5.setOnAction((event) -> {
			displayText.appendText("5");
		});
		Btn6.setOnAction((event) -> {
			displayText.appendText("6");
		});
		Btn7.setOnAction((event) -> {
			displayText.appendText("7");
		});
		Btn8.setOnAction((event) -> {
			displayText.appendText("8");
		});
		Btn9.setOnAction((event) -> {
			displayText.appendText("9");
		});
		Btn0.setOnAction((event) -> {
			displayText.appendText("0");
		});
		BtnDot.setOnAction((event) -> {
			
           if(button.getId().equals("abdominalBtn")||button.getId().equals("systolicBtn")
        		   ||button.getId().equals("diastolicBtn")||button.getId().equals("pulserateRespirationBtn")
        		   ||button.getId().equals("pulseOximetryBtn")||button.getId().equals("pulseRatebloodPressureBtn")
        		   ||button.getId().equals("bodyFatBtn")){
        	
        	   
           }else{
           displayText.appendText("."); 
           }	/* str = displayText.getText();
			String str1[] = str.split(".");
			 str2 = str1[0];
			*/
		});
		
		BtnPlusOrMinus.setOnAction((event) -> {
			String text1= displayText.getText();
			 StringBuilder str = new StringBuilder(text1);
			 str.insert(0, '-');
			 //displayText.appendText(str.toString());
			 displayText.setText(str.toString());
			//displayText.appendText(displayText.positionCaret(ri););-
		});
		
		clearBtn.setOnAction((event) -> {
			displayText.setText("");
		});
		
		backSpaceBtn.setOnAction((event) -> {
			//displayText.appendText("");
			
			String text = displayText.getText();
			
			            if(text.length() == 0)
			               return;
			System.out.println("String Length is : " +text.length());
			            //displayText.setText(text.substring(text.length() - 2));
					//displayText.setText(text.substring(text.length() - 1));
					displayText.setText(text.substring(0, text.length() - 1));
					/*String text2 = displayText.getText();
					System.out.println("String Length After Clear One Text " +text2.length());*/
			
		});
		
		okBtn.setOnAction((event) -> {
			if(button.getId().equals("heightBtn") ){
				
				Double inches = Double.parseDouble(displayText.getText());
				heightIncm = (int) (inches*2.54);
				
				enterVitalSignGUIController.setHightCm(displayText.getText(),heightIncm.toString());
				
			}else if (button.getId().equals("weightBtn")) {
				
				Double lb = Double.parseDouble(displayText.getText());
				 lbtoKg  =  (lb*0.45359237);
				 Double double2 = (lbtoKg + ozKg);
				System.out.println("Lb Kg is ......" +double2);
				enterVitalSignGUIController.setWeightKgBmi(displayText.getText(),double2.toString());
				
			}else if (button.getId().equals("ozBtn")) {
				Double oz = Double.parseDouble(displayText.getText());
				ozKg  =  (oz* 0.02834952);
				
				
				Double double1 = (lbtoKg + ozKg);
				System.out.println("Oz Kg is ......" +double1);
				enterVitalSignGUIController.setOzKg(displayText.getText(),double1.toString());
				
			}else if (button.getId().equals("bodyFatBtn")) {
				
				enterVitalSignGUIController.setBodyFat(displayText.getText());
				
			}else if (button.getId().equals("abdominalBtn")) {
				
			
					Float abdomiIninches = (float) (Float.parseFloat(displayText.getText())*2.54);	
			
				
				enterVitalSignGUIController.setAbdominal(displayText.getText(),abdomiIninches.toString());
				
			}else if (button.getId().equals("fahrenheitBtn")) {
				
				Double farehenite = Double.parseDouble(displayText.getText());
				Integer fareheniteToCel  = (int) ((farehenite-32) *0.5556);
				enterVitalSignGUIController.farenheitToCelcius(displayText.getText(),fareheniteToCel.toString());
				
			}else if (button.getId().equals("pulserateRespirationBtn")) {
				
				enterVitalSignGUIController.breathPerMinute(displayText.getText());
				
			}else if (button.getId().equals("systolicBtn")) {
				
				enterVitalSignGUIController.systolic(displayText.getText());
				
			}else if (button.getId().equals("diastolicBtn")) {
				
				enterVitalSignGUIController.dystolic(displayText.getText());
				
			}else if (button.getId().equals("pulseRatebloodPressureBtn")) {
				
				enterVitalSignGUIController.pulserate(displayText.getText());
			}else if (button.getId().equals("orbtn")) {
				
				enterVitalSignGUIController.orFn(displayText.getText());
				
			}else if (button.getId().equals("pulseOximetryBtn")) {
				
				enterVitalSignGUIController.pulseOximetry(displayText.getText());
				
			}else if (button.getId().equals("vitalDeviceBtn")) {
				
			}
			
			new FXFormCommonUtilities().closeForm(okBtn);
			
		});
		
		cancelBtn.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
