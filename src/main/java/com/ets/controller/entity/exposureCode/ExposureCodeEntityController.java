package com.ets.controller.entity.exposureCode;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.ExposureCode;
import com.ets.service.exposureCode.ExposureCodeServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExposureCodeEntityController Class
 *Description: ExposureCode Entity Non-GUI Controller class
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

public class ExposureCodeEntityController {

	//private static ClassPathXmlApplicationContext context;

	private ExposureCodeServiceImpl exposureCodeServiceImpl;

	private ObservableList<ExposureCode> observableList;

	public ExposureCodeEntityController() {

	//	context = new ClassPathXmlApplicationContext("spring.xml");
		exposureCodeServiceImpl = (ExposureCodeServiceImpl) Global.context
				.getBean("exposureCodeService");
		observableList = FXCollections.observableArrayList();

	}

	
	
	/** This method save the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveExposureCode(ExposureCode exposureCode) {

		exposureCodeServiceImpl.addExposureCode(exposureCode);
		//this.closeApplicationContext();

	}

	/** This method gets all the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ExposureCode objects
	 */
	
	public ObservableList<ExposureCode> viewExposureCode() {

		observableList = FXCollections
				.observableArrayList(exposureCodeServiceImpl.exposureCodeList());
		//.closeApplicationContext();
		return observableList;

	}

	/** This method update the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void modifyExposureCode(ExposureCode exposureCode) {

		exposureCodeServiceImpl.updateExposureCode(exposureCode);
		//this.closeApplicationContext();
	}
	
	/** This method delete the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void removeExposureCode(Integer id){
		
		exposureCodeServiceImpl.deleteExposureCode(id);
		//this.closeApplicationContext();
	}

}
