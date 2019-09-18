package com.ets.controller.gui.emrCharting.exam.skin.skinLacerationNew;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinLacerationNewInputController Class
 *Description: skinLacerationNew.fxml GUI Controller class
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
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SkinLacerationNewInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox rightCkeckBox;

    @FXML
    private CheckBox CkeckBox2;

    @FXML
    private CheckBox CkeckBox5;

    @FXML
    private CheckBox leftCkeckBox;

    @FXML
    private CheckBox CkeckBox3;

    @FXML
    private CheckBox CkeckBoxMore;

    @FXML
    private CheckBox CkeckBox1;

    @FXML
    private CheckBox CkeckBox4;

    @FXML
    private CheckBox armCkeckBox;

    @FXML
    private CheckBox chestCkeckBox;

    @FXML
    private CheckBox fingerCkeckBox;

    @FXML
    private CheckBox footCkeckBox;

    @FXML
    private CheckBox abdomenCkeckBox;

    @FXML
    private CheckBox faceCkeckBox;

    @FXML
    private CheckBox kneeCkeckBox;

    @FXML
    private CheckBox sclapCkeckBox;

    @FXML
    private CheckBox backCkeckBox;

    @FXML
    private CheckBox handCkeckBox;

    @FXML
    private CheckBox legCkeckBox;

    @FXML
    private CheckBox toeCkeckBox;

    @FXML
    private RadioButton activeNegativeRadio;

    @FXML
    private ToggleGroup active;

    @FXML
    private RadioButton activePossitiveRadio;

    @FXML
    private RadioButton sensoryNegative;

    @FXML
    private ToggleGroup sensory;

    @FXML
    private RadioButton SensoryPositive;

    @FXML
    private RadioButton circulationNormal;

    @FXML
    private ToggleGroup circulation;

    @FXML
    private RadioButton circulationAbnormal;

    @FXML
    private CheckBox includeCheckBox;

    @FXML
    private TextField woundSizeText;

    @FXML
    private CheckBox straightEdgeCheckBox;

    @FXML
    private CheckBox elipticalCheckBox;

    @FXML
    private CheckBox dotCheckBox;

    @FXML
    private CheckBox leggedEdgeCheckBox;

    @FXML
    private CheckBox punctureCheckBox;

    @FXML
    private CheckBox circularCheckBox;

    @FXML
    private CheckBox stellateCheckBox;

    @FXML
    private RadioButton woundNegativeradio;

    @FXML
    private ToggleGroup wound;

    @FXML
    private RadioButton injuryNegativeRadio;

    @FXML
    private ToggleGroup injury;

    @FXML
    private RadioButton woundPossitiveRadio;

	@FXML
	private RadioButton injuryPossitiveRadio;

	@FXML
	private TextArea detailBodyPartText;

	private ExamSkinInputController examSkinInputController;

	public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
		this.examSkinInputController = examSkinInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			if(rightCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" right.,");
				
				examSkinInputController.str=str1.toString();
				
			}
		
			if(leftCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" left.,");
				
				examSkinInputController.str=str1.toString();
				
			}
			if(CkeckBox1.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" 1st.,");
				
				examSkinInputController.str=str1.toString();
				
			}
			if(CkeckBox2.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" 2nd.,");
				
				examSkinInputController.str=str1.toString();
					
				
			}
			
			if(CkeckBox3.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" 3rd.,");
				
				examSkinInputController.str=str1.toString();
					
				
			}
			if(CkeckBox4.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" 4th.,");
				
				examSkinInputController.str=str1.toString();
					
				
			}
			if(CkeckBox5.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" 5th.,");
				
				examSkinInputController.str=str1.toString();
					
				
			}
			
			if(CkeckBoxMore.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
				str1.append(" More.,");
				
				examSkinInputController.str=str1.toString();
					
				
			}
			
			if(abdomenCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" abddomen.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(armCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" arm.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(backCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" back.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(chestCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" chest.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(faceCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" face/Neck.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(handCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" hand.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(fingerCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" fingure.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(kneeCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" knee.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(legCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" leg.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(footCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" foot.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}
			if(sclapCkeckBox.isSelected()){
				StringBuilder str1=new StringBuilder(examSkinInputController.str);
			str1.append(" scalp.,");
			
			examSkinInputController.str=str1.toString();
				
			
		}if(toeCkeckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append(" toe.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(activeNegativeRadio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Active bleeding to laceration site: negative.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(activePossitiveRadio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Active bleeding to laceration site: Positive.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(sensoryNegative.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Sensory deficit: Negative.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(SensoryPositive.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Sensory deficit: positive.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(circulationAbnormal.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Peripheral Pulses/Circulation: abnormal.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(circulationNormal.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Peripheral Pulses/Circulation: normal,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		
		
		/*
		if(straightEdgeCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
		str1.append(str2);	
		str1.append("  straight edges.,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(leggedEdgeCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
			str1.append(str2);	
		str1.append("  legged edges .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(circularCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
			str1.append(str2);	
		str1.append("  circular .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(elipticalCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
			str1.append(str2);	
		str1.append(" eliptical .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(punctureCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
			str1.append(str2);	
		str1.append(" puncture .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		if(stellateCheckBox.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
			StringBuilder str2=new StringBuilder(str11);
			str1.append(str2);	
		str1.append(" stellate .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }*/
		
		
		if(woundNegativeradio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Wound Contaminated: negative .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }	
		
		if(woundPossitiveRadio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("  Wound Contaminated: Positive .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }	
		
		if(injuryNegativeRadio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("   Associated Injury: Negative .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }	
		if(injuryPossitiveRadio.isSelected()){
			StringBuilder str1=new StringBuilder(examSkinInputController.str);
		str1.append("   Associated Injury: Positive .,");
		
		examSkinInputController.str=str1.toString();
			
		
	   }
		++examSkinInputController.formCount;	
		examSkinInputController.setSkinUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
			
		});
		
		
		
		skipBtn.setOnAction((event) -> {
			try {
				++examSkinInputController.formCount;	
				examSkinInputController.setSkinUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
