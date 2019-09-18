package com.ets.controller.entity.sicCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.SICCode;
import com.ets.service.sicCode.SicCodeServiceImpl;
import com.ets.utils.Global;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SicCodeEntityController Class
 *Description: SICCode Entity Non-GUI Controller class
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

public class SicCodeEntityController {

	//private static ClassPathXmlApplicationContext context;

	private SicCodeServiceImpl sicCodeServiceImpl;

	private ObservableList<SICCode> observableList;

	public SicCodeEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		sicCodeServiceImpl = (SicCodeServiceImpl) Global.context
				.getBean("sicCodeService");
		observableList = FXCollections.observableArrayList();

	}

	

	/** This method save the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	
	public void saveSICCode(SICCode sicCode) {

		sicCodeServiceImpl.addSICCode(sicCode);
		//this.closeApplicationConrext();
	}

	/** This method gets all the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SICCode objects
	 */
	
	public ObservableList<SICCode> viewSICCode() {

		observableList = FXCollections.observableArrayList(sicCodeServiceImpl
				.sICCodeList());
		//this.closeApplicationConrext();
		return observableList;
	}

	/** This method update the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void updateSICCode(SICCode sicCode){

		sicCodeServiceImpl.updateSICCode(sicCode);
		//this.closeApplicationConrext();
	}

	/** This method update the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeSICCode(Integer id){

		sicCodeServiceImpl.deleteSICCode(id);
		//this.closeApplicationConrext();
	}
	
	public SICCode viewByCode(String code){
		observableList = FXCollections.observableArrayList(sicCodeServiceImpl.viewByCode(code))	;	
		//this.closeApplicationConrext();
		return observableList.get(0);
	}


}
