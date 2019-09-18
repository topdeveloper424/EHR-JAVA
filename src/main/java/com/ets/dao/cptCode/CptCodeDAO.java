package com.ets.dao.cptCode;

import java.util.List;

import com.ets.model.CptCode4Hcpcs;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CptCodeDAO Interface
 *Description: CptCode Entity DAO Interface
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

public interface CptCodeDAO {

	public void add(CptCode4Hcpcs cptCode);

	public List<CptCode4Hcpcs> list();

	public void update(CptCode4Hcpcs cptCode);

	public CptCode4Hcpcs getByID(Integer id);

	public void delete(Integer id);
	
	public CptCode4Hcpcs viewByCode(String code);

}
