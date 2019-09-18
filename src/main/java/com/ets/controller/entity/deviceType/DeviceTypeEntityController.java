package com.ets.controller.entity.deviceType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DeviceType;
import com.ets.service.deviceType.SharpDeviceServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceEntityController Class
 *Description: SharpDevice Entity Non-GUI Controller class
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

public class DeviceTypeEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private SharpDeviceServiceImpl sharpDeviceServiceImpl;
	private ObservableList<DeviceType> observableList;
	
	public DeviceTypeEntityController() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		sharpDeviceServiceImpl=(SharpDeviceServiceImpl) Global.context.getBean("sharpDeviceService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	
	/** This method save the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void saveSharpDevice(DeviceType sharpDevice){
		
		sharpDeviceServiceImpl.addSharpDevice(sharpDevice);
		//this.closeApplicationContext();
	}
	
	/** This method gets all the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceType objects
	 */
	
	public ObservableList<DeviceType> viewSharpDdevice(){
		
		observableList=FXCollections.observableArrayList(sharpDeviceServiceImpl.sharpDeviceList());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	public void modifySharpDevice(DeviceType sharpDevice){
		
		sharpDeviceServiceImpl.updateSharpDevice(sharpDevice);
		//this.closeApplicationContext();
		
	}
	
	/** This method delete the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void removeSharpDevice(Integer id){
		
		sharpDeviceServiceImpl.deleteSharpDevice(id);
		//this.closeApplicationContext();
		
	}
	
	

}
