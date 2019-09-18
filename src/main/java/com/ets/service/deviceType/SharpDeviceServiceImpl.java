package com.ets.service.deviceType;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.deviceType.SharpDeviceDAO;
import com.ets.model.DeviceType;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceServiceImpl Class
 *Description: SharpDevice Entity Service class
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
@Service
@Transactional
public class SharpDeviceServiceImpl implements SharpDeviceService {
	
	private SharpDeviceDAO sharpDeviceDAO;

	public void setSharpDeviceDAO(SharpDeviceDAO sharpDeviceDAO) {
		this.sharpDeviceDAO = sharpDeviceDAO;
	}
	/** This method save the sharpDevice objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSharpDevice(DeviceType sharpDevice) {
		
		sharpDeviceDAO.addSharpDevice(sharpDevice);
		
	}
	/** This method gets all the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceType objects
	 */
	@Override
	public List<DeviceType> sharpDeviceList() {
		
		return sharpDeviceDAO.sharpDeviceList();
	}
	/** This method update the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sharpDevice
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSharpDevice(DeviceType sharpDevice) {
		
		sharpDeviceDAO.updateSharpDevice(sharpDevice);
		
	}
	/** This method gets all the DeviceType objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceType objects
	 */
	@Override
	public DeviceType getBySharpDeviceID(Integer id) {
		
		return sharpDeviceDAO.getBySharpDeviceID(id);
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
	@Override
	public void deleteSharpDevice(Integer id) {
		// Delete SharpDevice Record
		sharpDeviceDAO.deleteSharpDevice(id);
		
	}
	
}
