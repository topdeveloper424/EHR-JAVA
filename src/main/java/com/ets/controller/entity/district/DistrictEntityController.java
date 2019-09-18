package com.ets.controller.entity.district;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.District;
import com.ets.service.district.DistrictServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DistrictEntityController Class
 *Description: District Entity Non-GUI Controller class
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


public class DistrictEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private DistrictServiceImpl districtServiceImpl;
	
	private ObservableList<District> observableList;

	public DistrictEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		districtServiceImpl=(DistrictServiceImpl) Global.context.getBean("districtService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param district
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void saveDistrict(District district){
		
		districtServiceImpl.addDistrict(district);
		//this.closeApplicationConrext();
		
	}
	
	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	public ObservableList<District> viewDistrict(){
		
		observableList=FXCollections.observableArrayList(districtServiceImpl.districtList());
		
		//this.closeApplicationConrext();
		return observableList;
		
	}
	
	/** This method gets  the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
public District viewDistrictByName(String name){
		
		observableList=FXCollections.observableArrayList(districtServiceImpl.getDistrictByName(name));
		
		//this.closeApplicationConrext();
		return (District) observableList.get(0);
		
	}
	
/** This method update the District objects currently present in the system .
 * 
 * @author Sumanta Deyashi
 * @param district
 * @since 22-02-2016
 * @version 1.0
 * 
 * @return nothing
 */
	public void updateDistrict(District district){
		
		districtServiceImpl.updateDistrict(district);
		//this.closeApplicationConrext();
	}
	
	/** This method delete the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void removeDistrict(Integer id){
		
		districtServiceImpl.deleteDistrict(id);
		//this.closeApplicationConrext();
	}
	
	public District viewByCode(String code){
		
		observableList=FXCollections.observableArrayList(districtServiceImpl.viewByCode(code));
		
		//this.closeApplicationConrext();
		return (District) observableList.get(0);
		
	}
	
}
