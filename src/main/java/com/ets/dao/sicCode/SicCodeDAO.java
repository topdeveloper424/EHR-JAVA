package com.ets.dao.sicCode;

import java.util.List;

import com.ets.model.SICCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SicCodeDAO Interface
 *Description: SICCode Entity DAO Interface
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

public interface SicCodeDAO {
	
	public void addSICCode(SICCode sicCode);
	
	public List<SICCode> sicCodeList();
	
	public void updateSICCode(SICCode sicCode);
	
	public SICCode getBySICCodeID(Integer id);
	
	public SICCode viewByCode(String code);
	
	public void deleteSICCode(Integer id);

}
