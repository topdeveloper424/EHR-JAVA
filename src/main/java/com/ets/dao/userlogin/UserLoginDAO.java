package com.ets.dao.userlogin;

import java.util.List;

import com.ets.model.UserLogin;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserLoginDAO Interface
 *Description: UserLogin Entity DAO Interface
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


public interface UserLoginDAO {
	
	public List<UserLogin> login(String name , String password );
	
	}
