package com.ets.dao.userAccount;

import java.util.List;

import com.ets.model.UserAccount;
import com.ets.model.UserLogin;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAccountDAO Interface
 *Description: UserAccount Entity DAO Interface
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

public interface UserAccountDAO {
	
	public List<UserAccount> login(String userName, String password);
	
	public List<UserAccount> login2(String userName, String password , Boolean loginStatus);
	
	public void addOrUpdate(UserAccount userAccount);
	
	public List<UserAccount> userAccounts();
	
	public UserAccount getById(Integer id);
	
	public void delete(Integer id);
	
	public UserAccount viewByName(String name);
	
	;

}
