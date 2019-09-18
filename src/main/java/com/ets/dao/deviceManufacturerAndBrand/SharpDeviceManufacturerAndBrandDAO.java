package com.ets.dao.deviceManufacturerAndBrand;

import java.util.List;

import com.ets.model.DeviceManufacturerAndBrand;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceManufacturerAndBrandDAO Interface
 *Description: SharpDeviceManufacAndBrand Entity DAO Interface
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

public interface SharpDeviceManufacturerAndBrandDAO {
	
	public void addSharpDeviceManufacturerAndBrand(DeviceManufacturerAndBrand manufacAndBrand);
	
	public List<DeviceManufacturerAndBrand> sharpDeviceManufacAndBrandLists();
	
	public void updateSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand);
	
	public DeviceManufacturerAndBrand getBySharpDeviceManufacAndBrandID(Integer id);
	
	public void deleteSharpDeviceManufacAndBrand(Integer id);

}
