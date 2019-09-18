package com.ets.service.caseClosedReason;

import java.util.List;

import com.ets.model.CaseClosedReason;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonStatusService Interface
 *Description: CaseClosedReason Entity Service Interface
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

public interface CaseClosedReasonStatusService {

	public void addCaseClosedReason(CaseClosedReason caseClosedReason);

	public List<CaseClosedReason> caseClosedReasonList();

	public void updateCaseClosedReason(CaseClosedReason caseClosedReason);

	public CaseClosedReason getByCaseClosedReasonID(Integer id);

	public void deleteCaseClosedReason(Integer id);

}
