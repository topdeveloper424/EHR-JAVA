package com.ets.dao.loginSchedule;

import java.util.List;

import com.ets.model.LoginSchedule;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginScheduleDAO Interface
 *Description: LoginSchedule Entity DAO Interface
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

public interface LoginScheduleDAO {
	
	public void addOrUpdate(LoginSchedule loginSchdule);
	
	public List<LoginSchedule> view();
	
	public LoginSchedule getById(Integer id);
	
	public void delete(Integer id);

}
