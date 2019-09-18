package com.ets.dao.region;

import java.util.List;

import com.ets.model.Region;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RegionDAO Interface
 *Description: Region Entity DAO Interface
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

public interface RegionDAO {
	
	public void addRegion(Region region);
	
	public List<Region> regionList();
	
	public void updateRegion(Region region);
	
	public Region getByRegionID(Integer id);
	
	public void deleteRegion(Integer id);
	
	public Region viewByCode(String code);

}
