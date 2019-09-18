package com.ets.service.userAccount;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.userAccount.UserAccountDAO;
import com.ets.model.UserAccount;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAccountServiceImpl Class
 *Description: UserAccount Entity Service class
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
public class UserAccountServiceImpl implements UserAccountService {
	
	private UserAccountDAO userAccountDAO;

	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}

	/**
	 * This method save Or update the UserAccount objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userAccount
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addOrUpdate(UserAccount userAccount) {
		// TODO Auto-generated method stub
		userAccountDAO.addOrUpdate(userAccount);
		
	}

	
	/**
	 * This method gets all the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	
	@Override
	public List<UserAccount> userAccounts() {
		// TODO Auto-generated method stub
		return userAccountDAO.userAccounts();
	}

	/**
	 * This method gets the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount objects
	 */
	
	@Override
	public UserAccount getById(Integer id) {
		// TODO Auto-generated method stub
		return userAccountDAO.getById(id);
	}

	/**
	 * This method delete the UserAccount objects currently present in the system .
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
		userAccountDAO.delete(id);
	}
	
	/**
	 * This method Login the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName , password
	 * @since 21-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount object
	 */

	@Override
	public List<UserAccount> login(String userName, String password) {
		
		return userAccountDAO.login(userName, password);
	}
	
	@Override
	public List<UserAccount> login2(String userName, String password, Boolean loginStatus) {
		// TODO Auto-generated method stub
		return userAccountDAO.login2(userName, password, loginStatus);
	}

	/**
	 * This method gets the UserAccount objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param userName
	 * @since 22-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of UserAccount object
	 */
	
	@Override
	public UserAccount viewByName(String userName) {
		
		return userAccountDAO.viewByName(userName);
		
	}

	

	
	

}
