package com.ets.dao.severityCode;

import java.util.List;

import com.ets.model.SeverityCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SeverityDAO Interface
 *Description: SeverityCode Entity DAO Interface
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

public interface SeverityDAO {
	
	public void addSeverity(SeverityCode severityCode);
	
	public List<SeverityCode> severityCodeLists();
	
	public void updateSeverityCode(SeverityCode severityCode);
	
	public SeverityCode getBySeverityCodeID(Integer id);
	
	public void deleteSeverityCode(Integer id);

}
