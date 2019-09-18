package com.ets.controller.entity.cpt4;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.CptCode4Hcpcs;
import com.ets.service.cptCode.CptCodeServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 29-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Cpt4EntityController Class
 *Description: CptCode Entity Non-GUI Controller class
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

public class Cpt4EntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private CptCodeServiceImpl cptCodeServiceImpl;
	
	private ObservableList<CptCode4Hcpcs> observableList;

	public Cpt4EntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		cptCodeServiceImpl = (CptCodeServiceImpl) Global.context.getBean("cptCodeService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 29-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void save(CptCode4Hcpcs cptCode){
		
		cptCodeServiceImpl.add(cptCode);
		//this.closeApplicationConrext();
		
	}
	
	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 29-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	public ObservableList<CptCode4Hcpcs> view(){
		
		observableList = FXCollections.observableArrayList(cptCodeServiceImpl.list());
		//this.closeApplicationConrext();
		return observableList;
	}
	
	
	/** This method update the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 29-08-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void update(CptCode4Hcpcs cptCode){
		
		cptCodeServiceImpl.update(cptCode);
		//this.closeApplicationConrext();
		
	}
	
	/** This method Remove the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 29-08-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void delete(Integer id){
		
		cptCodeServiceImpl.delete(id);
		//this.closeApplicationConrext();
		
	}
	
	/** This method gets  the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	public CptCode4Hcpcs viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(cptCodeServiceImpl.viewByCode(code));
		//this.closeApplicationConrext();
		return observableList.get(0);
		
	}

}
