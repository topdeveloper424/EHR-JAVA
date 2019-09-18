package com.ets.dao.role;

import java.util.List;

import com.ets.model.Role;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RoleDAO Interface
 *Description: Role Entity DAO Interface
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

public interface RoleDAO {

	public void addOrUpdate(Role role);

	public List<Role> view();

	public Role getById(Integer id);

	public void delete(Integer id);
	
	public Role viewByName(String name);
	
	public List<String> roleName();

}
