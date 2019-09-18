package com.ets.service.entityGroup;

import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.entitygroup.EntityGroupDAO;
import com.ets.model.EntityGroup;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntityGroupServiceImpl Class
 *Description: EntityGroup Entity Service class
 *Copyright 2016 @Eclipse Techno Consulting Global Pvt. Ltd.

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
public class EntityGroupServiceImpl implements EntityGroupService {
	
	private EntityGroupDAO entityGroupDAO;

	public void setEntityGroupDAO(EntityGroupDAO entityGroupDAO) {
		this.entityGroupDAO = entityGroupDAO;
	}

	/**
	 * This method save Or update the EntityGroup objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param entityGroup
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addOrUpdate(EntityGroup entityGroup) {
		// TODO Auto-generated method stub
		entityGroupDAO.addOrUpdate(entityGroup);
		
	}

	/**
	 * This method gets all the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of entityGroup objects
	 */
	
	@Override
	public List<EntityGroup> view() {
		// TODO Auto-generated method stub
		return entityGroupDAO.view();
	}

	/**
	 * This method gets the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of entityGroup objects
	 */

	
	@Override
	public EntityGroup getById(Integer id) {
		// TODO Auto-generated method stub
		return entityGroupDAO.getById(id);
	}

	/**
	 * This method delete the EntityGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		entityGroupDAO.delete(id);
		
	}
	

}
