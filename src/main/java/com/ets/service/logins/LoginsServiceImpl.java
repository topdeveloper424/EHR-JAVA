package com.ets.service.logins;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.logins.LoginsDAO;
import com.ets.model.LoginHistory;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LoginsServiceImpl Class
 *Description: Logins Entity Service class
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
public class LoginsServiceImpl implements LoginsService {

	private LoginsDAO loginsDAO;

	public void setLoginsDAO(LoginsDAO loginsDAO) {
		this.loginsDAO = loginsDAO;
	}

	/**
	 * This method save Or update the Logins objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param logins
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */

	@Override
	public void addOrUpdate(LoginHistory logins) {

		loginsDAO.addOrUpdate(logins);

	}

	/**
	 * This method gets all the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of logins objects
	 */

	@Override
	public List<LoginHistory> view() {

		return loginsDAO.view();
	}

	/**
	 * This method gets the Logins objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 10-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of logins objects
	 */

	@Override
	public LoginHistory getById(Integer id) {

		return loginsDAO.getById(id);
	}

	/**
	 * This method delete the Logins objects currently present in the system .
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

		loginsDAO.delete(id);

	}

}
