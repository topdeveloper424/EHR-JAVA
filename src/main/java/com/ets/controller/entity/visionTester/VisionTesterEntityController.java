package com.ets.controller.entity.visionTester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.VisionTester;
import com.ets.service.visionTester.VisionTesterServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VisionTesterEntityController {

	//private static ClassPathXmlApplicationContext context;
	private VisionTesterServiceImpl visionTesterServiceImpl;
	private ObservableList<VisionTester> observableList;

	public VisionTesterEntityController() {
		//context = new ClassPathXmlApplicationContext("spring.xml");
		visionTesterServiceImpl = (VisionTesterServiceImpl) Global.context.getBean("visionTesterService");
		observableList = FXCollections.observableArrayList();
		

	}

	

	public void saveOrUpdate(VisionTester visionTester) {
		visionTesterServiceImpl.saveOrUpdate(visionTester);
		//this.closeApplicationContext();
	}

	public ObservableList<VisionTester> view() {

		observableList = FXCollections.observableArrayList(visionTesterServiceImpl.viewVisionTester());
		//context.close();

		return observableList;

	}

	public void delete(Integer id) {
		visionTesterServiceImpl.delete(id);
		//context.close();
	}
}
