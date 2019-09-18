package com.ets.dao.district;

import java.util.List;

import com.ets.model.District;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DistrictDAO Interface
 *Description: District Entity DAO Interface
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

public interface DistrictDAO {
	
	public void addDistrict(District district );
	
	public List<District> districtList();
	
	public void updateDistrict(District district);
	
	public District getByDistrictID(Integer id);
	
	public District getDistrictByName(String name);
	
	public void deleteDistrict(Integer id);
	
	public District viewByCode(String code);
	
	

}
