package com.ets.service.company;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.ets.dao.company.CompanyDAO;
import com.ets.model.Company;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 19-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompanyServiceImpl Class
 *Description: Entity Service class
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
public class CompanyServiceImpl implements CompanyService {

	private CompanyDAO companyDAO;

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	/** This method save the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param c
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	@Transactional
	public void addCompany(Company c) {
		this.companyDAO.addCompany(c);
	}

	/** This method update the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param c
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	@Transactional
	public void updateCompany(Company c) {
		this.companyDAO.updateCompany(c);
	}

	/** This method gets all the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param Nothing
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of company objects
	 */
	
	@Override
	@Transactional
	public List<Company> listCompany() {
		return this.companyDAO.listCompany();
		//return null;
	}

	/** This method gets all the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param id
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of company objects
	 */
	
	@Override
	@Transactional
	public Company getCompanyById(int id) {
		return this.companyDAO.getCompanyById(id);

	}

	/** This method delete the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param id
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	@Transactional
	public void removeCompany(int id) {
		this.companyDAO.removeCompany(id);

	}

	@Override
	public Company getByName(String name) {
		// TODO Auto-generated method stub
		return companyDAO.getByName(name);
	}
}
