package com.ets.service.deviceManufacturerAndBrand;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.deviceManufacturerAndBrand.SharpDeviceManufacturerAndBrandDAO;
import com.ets.model.DeviceManufacturerAndBrand;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceManufacturerAndBrandServiceImpl Class
 *Description: SharpDeviceManufacAndBrand Entity Service class
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
@Transactional
@Service
public class SharpDeviceManufacturerAndBrandServiceImpl implements SharpDeviceManufacturerAndBrandService {
	
	private SharpDeviceManufacturerAndBrandDAO andBrandDAO;

	public void setAndBrandDAO(SharpDeviceManufacturerAndBrandDAO andBrandDAO) {
		this.andBrandDAO = andBrandDAO;
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
	
	@Override
	public void addSharpDeviceManufacturerAndBrand(
			DeviceManufacturerAndBrand manufacAndBrand) {
		
		andBrandDAO.addSharpDeviceManufacturerAndBrand(manufacAndBrand);
		
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
	@Override
	public List<DeviceManufacturerAndBrand> sharpDeviceManufacAndBrandLists() {
		
		return andBrandDAO.sharpDeviceManufacAndBrandLists();
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
	@Override
	public void updateSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand) {
		
		andBrandDAO.updateSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
				
	}

	/** This method gets all the DeviceManufacturerAndBrand objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceManufacturerAndBrand objects
	 */
	@Override
	public DeviceManufacturerAndBrand getBySharpDeviceManufacAndBrandID(Integer id) {
		
		return andBrandDAO.getBySharpDeviceManufacAndBrandID(id);
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
	@Override
	public void deleteSharpDeviceManufacAndBrand(Integer id) {
		
		andBrandDAO.deleteSharpDeviceManufacAndBrand(id);
		
	}
	
}
