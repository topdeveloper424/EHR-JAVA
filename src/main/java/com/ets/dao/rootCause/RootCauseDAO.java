package com.ets.dao.rootCause;

import java.util.List;

import com.ets.model.RootCause;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RootCauseDAO Interface
 *Description: RootCause Entity DAO Interface
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

public interface RootCauseDAO {

	public void addRootCause(RootCause rootCause);

	public List<RootCause> rootCauseLists();

	public void updateRootCause(RootCause rootCause);

	public RootCause getByRootCauseID(Integer id);

	public void deleteRootCause(Integer id);

}
