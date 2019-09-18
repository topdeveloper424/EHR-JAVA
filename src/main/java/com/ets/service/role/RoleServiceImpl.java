package com.ets.service.role;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.role.RoleDAO;
import com.ets.model.Role;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RoleServiceImpl Class
 *Description: Role Entity Service class
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
public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	/**
	 * This method save Or update the Role objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param role
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(Role role) {

		roleDAO.addOrUpdate(role);

	}

	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */

	@Override
	public List<Role> view() {

		return roleDAO.view();
	}

	/**
	 * This method gets all the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */

	@Override
	public Role getById(Integer id) {

		return roleDAO.getById(id);
	}

	/**
	 * This method delete the Role objects currently present in the system .
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
		roleDAO.delete(id);

	}

	/**
	 * This method gets  the Role objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Role objects
	 */
	
	@Override
	public Role viewByName(String name) {
	
		return roleDAO.viewByName(name);
	}

	@Override
	public List<String> roleName() {
		
		return roleDAO.roleName();
	}

}
