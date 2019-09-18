package com.ets.dao.stateWorkArea;

import java.util.List;

import com.ets.model.StateWorkArea;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaDAO Interface
 *Description: StateWorkArea Entity DAO Interface
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

public interface StateWorkAreaDAO {
	
	public void addStateWorkArea(StateWorkArea stateWorkArea );
	
	public List<StateWorkArea> stateWorkAreaList();
	
	public void updateStateWorkArea(StateWorkArea stateWorkArea);
	
	public StateWorkArea getByStateWorkArea(Integer id);
	
	public void deleteStateWorkArea(Integer id);

}
