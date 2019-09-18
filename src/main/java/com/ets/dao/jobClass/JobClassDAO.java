package com.ets.dao.jobClass;

import java.util.List;

import com.ets.model.JobClass;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 01-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of JobClassDAOImpl Class
 *Description: JobClass Entity DAO class
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
public interface JobClassDAO {
	
	public void addorUpdate(JobClass jobClass);
	
	public List<JobClass> view();
	public void delete(Integer id);
	
	public JobClass viewByCode(String code);

}
