package com.ets.controller.entity.region;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Region;
import com.ets.service.region.RegionServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RegionEntityController Class
 *Description: Region Entity Non-GUI Controller class
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

public class RegionEntityController {
	
//	private static ClassPathXmlApplicationContext context;
	
	private RegionServiceImpl regionServiceImpl;
	
	private ObservableList<Region> observableList;

	public RegionEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		regionServiceImpl=(RegionServiceImpl) Global.context.getBean("regionService");
		observableList=FXCollections.observableArrayList();
				
	}
	
	

	/** This method save the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveRegion(Region region) {
		regionServiceImpl.addRegion(region);
		//this.closeApplicationConrext();

	}
	
	/** This method gets all the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Region objects
	 */
	public ObservableList<Region> viewRegion(){
		observableList=FXCollections.observableArrayList(regionServiceImpl.regionList());
		//this.closeApplicationConrext();
		return observableList;
	}
	
	/** This method update the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void updateRegion(Region region){
		
		regionServiceImpl.updateRegion(region);
		//this.closeApplicationConrext();
		
	}
	
	/** This method delete the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeRegion(Integer id){
		
		regionServiceImpl.deleteRegion(id);
		//this.closeApplicationConrext();
		
	}
	
	public Region viewByCode(String code){
		
		observableList=FXCollections.observableArrayList(regionServiceImpl.viewByCode(code));
		//this.closeApplicationConrext();
		return observableList.get(0);
		
	}
}
