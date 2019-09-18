package com.ets.controller.entity.deviceManufacturerAndBrand;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.service.deviceManufacturerAndBrand.SharpDeviceManufacturerAndBrandServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceManufacturerAndBrandEntityontroller Class
 *Description: SharpDeviceManufacAndBrand Entity Non-GUI Controller class
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

public class DeviceManufacturerAndBrandEntityontroller {
	
	//private static ClassPathXmlApplicationContext context;
	
	private SharpDeviceManufacturerAndBrandServiceImpl serviceImpl;
	
	private ObservableList<DeviceManufacturerAndBrand> observableList;

	public DeviceManufacturerAndBrandEntityontroller() {
		
		//context=new ClassPathXmlApplicationContext("spring.xml");
		serviceImpl=(SharpDeviceManufacturerAndBrandServiceImpl) Global.context.getBean("manufacturerAndBrandService");
		observableList=FXCollections.observableArrayList();
		
	}
	
	
	/** This method save the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param brand
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void saveSharpDeviceManufacturerAndBrand(DeviceManufacturerAndBrand brand){
		serviceImpl.addSharpDeviceManufacturerAndBrand(brand);
		//this.closeApplicationContext();
		}
	
	/** This method gets all the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceManufacturerAndBrand objects
	 */
	
	public ObservableList<DeviceManufacturerAndBrand> viewSharpDeviceManufacturerAndBrand(){
		observableList=FXCollections.observableArrayList(serviceImpl.sharpDeviceManufacAndBrandLists());
		//this.closeApplicationContext();
		return observableList;
	}
	
	/** This method update the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param brand
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void updateSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand){
		
		serviceImpl.updateSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
		//this.closeApplicationContext();
	}
	
	/** This method remove the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void removeSharpDeviceManufacAndBrand(Integer id){
		
		serviceImpl.deleteSharpDeviceManufacAndBrand(id);
		//this.closeApplicationContext();
		
	}
	

}
