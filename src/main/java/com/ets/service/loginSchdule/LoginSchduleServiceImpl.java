package com.ets.service.loginSchdule;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.loginSchedule.LoginScheduleDAO;
import com.ets.model.LoginSchedule;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginSchduleServiceImpl Class
 *Description: LoginSchedule Entity Service class
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
public class LoginSchduleServiceImpl implements LoginSchduleService {
	
	private LoginScheduleDAO loginScheduleDAO;

	public void setLoginScheduleDAO(LoginScheduleDAO loginScheduleDAO) {
		this.loginScheduleDAO = loginScheduleDAO;
	}

	/**
	 * This method save Or update the LoginSchedule objects currently present in
	 * the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param loginSchedule
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addOrUpdate(LoginSchedule loginSchdule) {
		// TODO Auto-generated method stub
		loginScheduleDAO.addOrUpdate(loginSchdule);
		
	}

	/**
	 * This method gets all the LoginSchedule objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of loginSchedule objects
	 */
	
	@Override
	public List<LoginSchedule> view() {
		// TODO Auto-generated method stub
		return loginScheduleDAO.view();
	}

	/**
	 * This method gets the LoginSchedule objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of loginSchedule objects
	 */

	
	@Override
	public LoginSchedule getById(Integer id) {
		// TODO Auto-generated method stub
		return loginScheduleDAO.getById(id);
	}

	/**
	 * This method delete the LoginSchedule objects currently present in the
	 * system .
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
		loginScheduleDAO.delete(id);
		
	}
	

}
