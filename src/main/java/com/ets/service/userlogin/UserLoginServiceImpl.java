package com.ets.service.userlogin;




import java.util.List;



import com.ets.dao.userlogin.UserLoginDAO;
import com.ets.model.UserLogin;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 07-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserLoginServiceImpl Class
 *Description: UserLogin Entity Service class
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
public class UserLoginServiceImpl implements UserLoginService {
	
private UserLoginDAO userLoginDAO;
	
	public void setUserLoginDAO(UserLoginDAO userLoginDAO) {
		this.userLoginDAO = userLoginDAO;
	}

		
	/** This method gets all the UserLogin objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name , password
	 * @since 07-03-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserLogin objects
	 */
	@Override
	public List<UserLogin> login(String name, String password) {
		
		return userLoginDAO.login(name, password);
	}

}
