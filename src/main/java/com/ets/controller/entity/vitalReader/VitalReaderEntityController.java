package com.ets.controller.entity.vitalReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.VisionTester;
import com.ets.model.VitalReader;
import com.ets.service.vitalReader.VitalReaderServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VitalReaderEntityController {

	//private static ClassPathXmlApplicationContext context;
	private  VitalReaderServiceImpl vitalReaderServiceImpl;
	private ObservableList<VitalReader> observableList;
	
	public VitalReaderEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		vitalReaderServiceImpl=(VitalReaderServiceImpl) Global.context.getBean("vitalReaderService");
		observableList=FXCollections.observableArrayList();	
	}
	
	public void saveOrUpdate(VitalReader vitalReader){
		vitalReaderServiceImpl.saveOrUpdate(vitalReader);
		//.this.closeApplicationContext();
		
	}
	public ObservableList<VitalReader> view() {

		observableList = FXCollections.observableArrayList(vitalReaderServiceImpl.viewVitalReader());
		//this.closeApplicationContext();

		return observableList;

	}
	public void delete(Integer id){
		vitalReaderServiceImpl.delete(id);
		//this.closeApplicationContext();
	}
	
	public void updateVitalReader(VitalReader vitalReader){
		vitalReaderServiceImpl.updateVitalReader(vitalReader);
		//this.closeApplicationContext();
	}
	
}
