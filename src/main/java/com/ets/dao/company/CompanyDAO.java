package com.ets.dao.company;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 19-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompanyDAO Interface
 *Description: Company Entity DAO Interface
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


import java.util.List;
import com.ets.model.Company;

public interface CompanyDAO {
	public void addCompany(Company c);
	public void updateCompany(Company c);
	public List<Company> listCompany();
	public Company getCompanyById(int id);
	public void removeCompany(int id);
	public Company getByName(String name);
	
}
