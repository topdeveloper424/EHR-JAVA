package com.ets.controller.entity.vitalSign;

import com.ets.model.PatientVisit;
import com.ets.model.VitalReader;
import com.ets.model.VitalSign;
import com.ets.service.vitalReader.VitalReaderServiceImpl;
import com.ets.service.vitalSign.VitalSignServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VitalSignEntityController {
	private  VitalSignServiceImpl vitalSignServiceImpl;
	private ObservableList<VitalSign> observableList;
	
	public VitalSignEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		vitalSignServiceImpl=(VitalSignServiceImpl) Global.context.getBean("vitalSignService");
		observableList=FXCollections.observableArrayList();	
	}
	
	public void saveOrUpdate(VitalSign vitalSign){
		vitalSignServiceImpl.saveOrUpdate(vitalSign);
		//.this.closeApplicationContext();
		
	}
	public ObservableList<VitalSign> view(PatientVisit patientVisit) {

		observableList = FXCollections.observableArrayList(vitalSignServiceImpl.viewVitalSign(patientVisit));
		//this.closeApplicationContext();

		return observableList;

	}
}