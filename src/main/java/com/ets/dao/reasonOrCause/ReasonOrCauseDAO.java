package com.ets.dao.reasonOrCause;

import java.util.List;

import com.ets.model.ReasonOrCause;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReasonOrCauseDAO Interface
 *Description: ReasonOrCause Entity DAO Interface
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

public interface ReasonOrCauseDAO {
	
	public void addReasonOrCause(ReasonOrCause reasonOrCause);
	
	public List<ReasonOrCause> reasonCauseLists();
	
	public void updateReasonOrCause(ReasonOrCause reasonOrCause);
	
	public ReasonOrCause getByReasonOrCauseID(Integer id);
	
	public void deleteReasonOrCause(Integer id);

}
