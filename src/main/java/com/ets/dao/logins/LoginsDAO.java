package com.ets.dao.logins;

import java.util.List;

import com.ets.model.LoginHistory;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginsDAO Interface
 *Description: Logins Entity DAO class
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


public interface LoginsDAO {
	
	public void addOrUpdate(LoginHistory logins);
	
	public List<LoginHistory> view();
	
	public LoginHistory getById(Integer id);
	
	public void delete(Integer id);

}
