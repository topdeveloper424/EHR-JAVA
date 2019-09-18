package com.ets.service.deviceModel;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.deviceModel.SharpDeviceModelDAO;
import com.ets.model.DeviceModel;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceModelServiceImpl Class
 *Description: SharpDeviceModel Entity Service class
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
public class SharpDeviceModelServiceImpl implements SharpDeviceModelService {
	
	private SharpDeviceModelDAO sharpDeviceModelDAO;

	public void setSharpDeviceModelDAO(SharpDeviceModelDAO sharpDeviceModelDAO) {
		this.sharpDeviceModelDAO = sharpDeviceModelDAO;
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
	
	@Override
	public void addSharpDeviceModel(DeviceModel sharpDeviceModel) {
		
		sharpDeviceModelDAO.addSharpDeviceModel(sharpDeviceModel);
		
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
	@Override
	public List<DeviceModel> sharpDeviceModelList() {
		
		return sharpDeviceModelDAO.sharpDeviceModelList();
		
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
	@Override
	public void updateSharpDeviceModel(DeviceModel sharpDeviceModel) {
		
		sharpDeviceModelDAO.updateSharpDeviceModel(sharpDeviceModel);
		
	}

	/** This method gets all the DeviceModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeviceModel objects
	 */
	@Override
	public DeviceModel getBySharpDeviceModelID(Integer id) {
		
		return sharpDeviceModelDAO.getBySharpDeviceModelID(id);
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
	@Override
	public void deleteSharpDeviceModel(Integer id) {
		
		sharpDeviceModelDAO.deleteSharpDeviceModel(id);
		
	}
	
}
