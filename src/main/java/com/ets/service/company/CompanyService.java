package com.ets.service.company;

import java.util.List;

import com.ets.model.Company;

/*
 *
 * @Author Indronil Chaudhuri 19-01-2016
 *
 */

public interface CompanyService {
	public void addCompany(Company c);
	public void updateCompany(Company c);
	public List<Company> listCompany();
	public Company getCompanyById(int id);
	public void removeCompany(int id);
	public Company getByName(String name);
}
