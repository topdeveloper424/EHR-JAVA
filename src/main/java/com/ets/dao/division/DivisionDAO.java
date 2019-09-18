package com.ets.dao.division;

import java.util.List;

import com.ets.model.Division;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DivisionDAO Interface
 *Description: Division Entity DAO Interface
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

public interface DivisionDAO {
	
	public void addDivision(Division division);
	
	public List<Division> divisionList();
	
	public void updateDivision(Division division);
	
	public Division getByDivisionID(Integer id);
	
	public void deleteDivision(Integer id);
	
	public List<Division> viewDivisionById(Integer id);
	
	public Division viewByCode(String code);

}
