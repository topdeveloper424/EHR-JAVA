package com.ets.dao.spirometer;

import java.util.List;

import com.ets.model.DepartmentUnit;
import com.ets.model.Spirometer;

/**
 * Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company File
 * Creation Date: 22-11-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of SpirometerDAO Interface Class Description:
 * SpirometerDAO Interface Class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */
public interface SpirometerDAO {
	public void saveSpirometer(Spirometer spirometer);

	public List<Spirometer> view();

//	public Spirometer getById(Integer id);

//	public void update(Spirometer spirometer);
//
	public void delete(Integer id);
}
