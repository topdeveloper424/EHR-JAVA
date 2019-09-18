package com.ets.controller.entity.naicsCode;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.NAICSCode;
import com.ets.service.naicsCode.NaicsCodeServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeEntityController Class
 *Description: NAICSCode Entity Non-GUI Controller class
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

public class NaicsCodeEntityController {

	//private static ClassPathXmlApplicationContext context;

	private NaicsCodeServiceImpl naicsCodeServiceImpl;

	private ObservableList<NAICSCode> observableList;

	public NaicsCodeEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		naicsCodeServiceImpl = (NaicsCodeServiceImpl) Global.context
				.getBean("naicsCodeService");
		observableList = FXCollections.observableArrayList();

	}

	
	/** This method save the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveNaicsCode(NAICSCode naicsCode) {

		naicsCodeServiceImpl.addNaicsCode(naicsCode);
		//this.closeApplicationConrext();

	}

	/** This method gets all the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of NAICSCode objects
	 */
	
	public ObservableList<NAICSCode> viewNAICSCode() {
		observableList = FXCollections.observableArrayList(naicsCodeServiceImpl
				.naicsCodeLists());

		//this.closeApplicationConrext();
		return observableList;
	}
	
	/** This method update the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param naicsCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateNAICSCode(NAICSCode naicsCode){
		
		naicsCodeServiceImpl.updateNAICSCode(naicsCode);
		//this.closeApplicationConrext();
	}
	
	/** This method delete the NAICSCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void removeNAICSCode(Integer id){
		
		naicsCodeServiceImpl.deleteNAICSCode(id);
		//this.closeApplicationConrext();
		
	}
	
	public NAICSCode viewByCode(String code){
		observableList = FXCollections.observableArrayList(naicsCodeServiceImpl.viewByCode(code));
		//this.closeApplicationConrext();
				return observableList.get(0) ;
		
	}

}
