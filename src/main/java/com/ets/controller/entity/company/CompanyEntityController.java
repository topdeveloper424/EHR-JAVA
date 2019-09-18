package com.ets.controller.entity.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Company;



import com.ets.service.company.CompanyServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 21-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompanyEntityController Class
 *Description: Company Entity Non-GUI Controller class
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


public class CompanyEntityController {
	//private static ClassPathXmlApplicationContext context;
	private static CompanyServiceImpl companyService;
	private ObservableList<Company> companyList;

	public CompanyEntityController()	{
	
		//context = new ClassPathXmlApplicationContext("spring.xml");
		companyService = (CompanyServiceImpl)Global.context.getBean("companyService");
	
		companyList = FXCollections.observableArrayList();

	}
	public void closeApplicationContext()	{
		//this.context.close();
	}

	/** This method save the Company objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param company
	 * @since 21-01-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void addCompany(Company company) {
		companyService.addCompany(company);
		//this.closeApplicationContext();
	}

	/** This method gets all the Company objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 21-01-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Company objects
	 */
	
	public ObservableList<Company> getCompanyList() {
		
		List<Company> myCompanyList = new ArrayList<Company>();
		
		myCompanyList = companyService.listCompany();
		
		companyList = FXCollections.observableList(myCompanyList);
		
		//this.closeApplicationContext();

		return companyList;
	}
	
	/** This method Remove the Company objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 21-01-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */

	public void removeCompany(Integer id) {
		companyService.removeCompany(id);
		//this.closeApplicationContext();
	}

	/** This method update the Company objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param company
	 * @since 21-01-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	public void updateCompany(Company Company) {
		companyService.updateCompany(Company);
		//this.closeApplicationContext();
	}
	
	public Company getByName(String name){
		companyList = FXCollections.observableArrayList(companyService.getByName(name));
		
		//this.closeApplicationConrext();
		return companyList.get(0);
	}
}