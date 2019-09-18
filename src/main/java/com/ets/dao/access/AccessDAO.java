package com.ets.dao.access;

import java.util.List;

import com.ets.model.Access;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AccessDAO Interface
 *Description: Access Entity DAO Interface
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

public interface AccessDAO {

	public void addOrUpdate(Access access);

	public List<Access> view();

	public Access getById(Integer id);

	public void delete(Integer id);

}
