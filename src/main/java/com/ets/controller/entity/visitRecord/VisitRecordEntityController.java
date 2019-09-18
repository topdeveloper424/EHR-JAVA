package com.ets.controller.entity.visitRecord;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.VisitRecord;
import com.ets.service.visitRecord.VisitRecordServiceImpl;
import com.ets.utils.Global;

public class VisitRecordEntityController {
	//private static ClassPathXmlApplicationContext context;
	private VisitRecordServiceImpl visitRecordServiceImpl;

	public VisitRecordEntityController() {
	//	context = new ClassPathXmlApplicationContext("spring.xml");
		visitRecordServiceImpl = (VisitRecordServiceImpl) Global.context.getBean("visitRecordService");
	}


	public void saveOrUpdate(VisitRecord visitRecord) {

		visitRecordServiceImpl.addOrUpdate(visitRecord);
	//	this.closeApplicationContext();
	}
}