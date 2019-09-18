package com.ets.service.access;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.access.AccessDAO;
import com.ets.model.Access;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AccessServiceImpl Class
 *Description: Access Entity DAO class
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
public class AccessServiceImpl implements AccessService {

	private AccessDAO accessDAO;

	public void setAccessDAO(AccessDAO accessDAO) {
		this.accessDAO = accessDAO;
	}

	/**
	 * This method save Or update the Access objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param access
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(Access access) {

		accessDAO.addOrUpdate(access);

	}

	/**
	 * This method gets all the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of access objects
	 */

	@Override
	public List<Access> view() {

		return accessDAO.view();
	}

	/**
	 * This method gets the Access objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of access objects
	 */

	@Override
	public Access getById(Integer id) {

		return accessDAO.getById(id);
	}

	/**
	 * This method delete the Access objects currently present in the system .
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

		accessDAO.delete(id);

	}

}
