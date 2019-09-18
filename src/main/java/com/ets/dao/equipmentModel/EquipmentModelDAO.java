package com.ets.dao.equipmentModel;

import java.util.List;

import com.ets.model.EquipmentModel;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EquipmentModelDAO Interface
 *Description: EquipmentModel Entity DAO Interface
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

public interface EquipmentModelDAO {
	
	public void add(EquipmentModel equipmentModel);

	public List<EquipmentModel> list();

	public void update(EquipmentModel equipmentModel);

	public EquipmentModel getByID(Integer id);

	public void delete(Integer id);

}
