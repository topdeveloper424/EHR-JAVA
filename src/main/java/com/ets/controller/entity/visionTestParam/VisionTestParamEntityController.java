package com.ets.controller.entity.visionTestParam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.VisionTestParam;
import com.ets.service.visionTestParam.VisionTestParamServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisionTestParamEntityController {
	//private static ClassPathXmlApplicationContext context;
	private VisionTestParamServiceImpl visionTestParamServiceImpl;
	private ObservableList<VisionTestParam> observableList;

	public VisionTestParamEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		visionTestParamServiceImpl = (VisionTestParamServiceImpl) Global.context.getBean("visionTestParamService");
		observableList = FXCollections.observableArrayList();

	}

	
	public void saveOrUpdate(VisionTestParam visionTestParam) {
		visionTestParamServiceImpl.saveOrUpdate(visionTestParam);
		//this.closeApplicationContext();
	}

	public ObservableList<VisionTestParam> viewVisionTestParam() {

		observableList = FXCollections.observableArrayList(visionTestParamServiceImpl.viewVisionTestParam());
		//this.closeApplicationContext();

		return observableList;

	}

	public void delete(Integer id) {
		visionTestParamServiceImpl.delete(id);
		//this.closeApplicationContext();
	}

}
