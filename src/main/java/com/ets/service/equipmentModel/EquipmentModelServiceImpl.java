package com.ets.service.equipmentModel;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.equipmentModel.EquipmentModelDAO;
import com.ets.model.EquipmentModel;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EquipmentModelServiceImpl Class
 *Description: EquipmentModel Entity Service class
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
public class EquipmentModelServiceImpl implements EquipmentModelService {
	
	private EquipmentModelDAO equipmentModelDAO;

	public void setEquipmentModelDAO(EquipmentModelDAO equipmentModelDAO) {
		this.equipmentModelDAO = equipmentModelDAO;
	}

	/** This method save the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param equipmentModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(EquipmentModel equipmentModel) {
		equipmentModelDAO.add(equipmentModel);
		
	}
	/** This method gets all the EquipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of EquipmentModel objects
	 */
	@Override
	public List<EquipmentModel> list() {
		
		return equipmentModelDAO.list();
	}
	/** This method update the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param equipmentModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(EquipmentModel equipmentModel) {
		equipmentModelDAO.update(equipmentModel);
		
	}
	/** This method gets all the EquipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of EquipmentModel objects
	 */
	@Override
	public EquipmentModel getByID(Integer id) {
		
		return equipmentModelDAO.getByID(id);
	}
	/** This method delete the equipmentModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of equipmentModel objects
	 */
	@Override
	public void delete(Integer id) {
		equipmentModelDAO.delete(id);
		
	}
	

}
