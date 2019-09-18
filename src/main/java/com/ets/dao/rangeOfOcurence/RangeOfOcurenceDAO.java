package com.ets.dao.rangeOfOcurence;

import java.util.List;

import com.ets.model.RangeOfOcurence;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RangeOfOcurenceDAO Interface
 *Description: RangeOfOcurence Entity DAO Interface
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

public interface RangeOfOcurenceDAO {
	
	public void add(RangeOfOcurence rangeOfOcurence);

	public List<RangeOfOcurence> list();

	public void update(RangeOfOcurence rangeOfOcurence);

	public RangeOfOcurence getByID(Integer id);

	public void delete(Integer id);

}
