package com.ets.dao.deviceType;

import java.util.List;

import com.ets.model.DeviceType;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceDAO Interface
 *Description: SharpDevice Entity DAO Interface
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

public interface SharpDeviceDAO {
	
	public void addSharpDevice(DeviceType sharpDevice);
	
	public List<DeviceType> sharpDeviceList();
	
	public void updateSharpDevice(DeviceType sharpDevice);
	
	public DeviceType getBySharpDeviceID(Integer id);
	
	public void deleteSharpDevice(Integer id);

}
