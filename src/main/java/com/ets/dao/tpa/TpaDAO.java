package com.ets.dao.tpa;

import java.util.List;

import com.ets.model.Tpa;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of TpaDAO Interface
 *Description: Tpa Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface TpaDAO {
	
	public void addOrUpdate(Tpa tpa);
	public List<Tpa> view();
	
	public Tpa viewByCode(String code);
	public void delete(Integer id);
	
}
