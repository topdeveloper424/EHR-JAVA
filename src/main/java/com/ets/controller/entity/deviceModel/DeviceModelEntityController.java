package com.ets.controller.entity.deviceModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DeviceModel;
import com.ets.model.WorkActivity;
import com.ets.service.deviceModel.SharpDeviceModelServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceModelEntityController Class
 *Description: SharpDeviceModel Entity Non-GUI Controller class
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

public class DeviceModelEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	
	private SharpDeviceModelServiceImpl sharpDeviceModelServiceImpl;
	
	private ObservableList<DeviceModel> observableList;

	public DeviceModelEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		sharpDeviceModelServiceImpl= (SharpDeviceModelServiceImpl) Global.context.getBean("sharpDeviceModelService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDeviceModel
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveSharpDeviceModel(DeviceModel deviceModel){
		sharpDeviceModelServiceImpl.addSharpDeviceModel(deviceModel);
		//this.closeApplicationContext();
		
	}
	
	/** This method gets all the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceModel objects
	 */
	public ObservableList<DeviceModel> viewSharpDeviceModel(){
		
		observableList=FXCollections.observableArrayList(sharpDeviceModelServiceImpl.sharpDeviceModelList());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
	/** This method update the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDeviceModel
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void modifySharpDeviceModel(DeviceModel sharpDeviceModel){
		
		sharpDeviceModelServiceImpl.updateSharpDeviceModel(sharpDeviceModel);
		//this.closeApplicationContext();
	}
	
	/** This method delete the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void removeSharpDeviceModel(Integer id){
		
		sharpDeviceModelServiceImpl.deleteSharpDeviceModel(id);
		//this.closeApplicationContext();
		
	}
	
	
}
