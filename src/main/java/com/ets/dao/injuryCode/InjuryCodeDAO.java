package com.ets.dao.injuryCode;

import java.util.List;

import com.ets.model.InjuryCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeDAO Interface
 *Description: InjuryCode Entity DAO class
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

public interface InjuryCodeDAO {
	
	public void addInjuryCode(InjuryCode injuryCode);
	
	public List<InjuryCode> injuryCodeList();
	
	public void updateInjuryCode(InjuryCode injuryCode);
	
	public InjuryCode getbyInjuryID(Integer id);
	
	public void deleteInjuryCode(Integer id);
	
	

}
