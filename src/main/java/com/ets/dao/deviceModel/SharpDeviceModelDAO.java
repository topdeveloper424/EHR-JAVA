package com.ets.dao.deviceModel;

import java.util.List;

import com.ets.model.DeviceModel;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceModelDAO Interface
 *Description: SharpDeviceModel Entity DAO Interface
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

public interface SharpDeviceModelDAO {
	
	public void addSharpDeviceModel( DeviceModel sharpDeviceModel);
	
	public List<DeviceModel> sharpDeviceModelList();
	
	public void updateSharpDeviceModel(DeviceModel sharpDeviceModel);
	
	public DeviceModel getBySharpDeviceModelID(Integer id);
	
	public void deleteSharpDeviceModel(Integer id);

}
