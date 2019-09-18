package com.ets.dao.naicsCode;

import java.util.List;

import com.ets.model.NAICSCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NaicsCodeDAO Interface
 *Description: NAICSCode Entity DAO Interface
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

public interface NaicsCodeDAO {
	
	public void addNaicsCode(NAICSCode naicsCode);
	
	public List<NAICSCode> naicsCodeLists();
	
	public void updateNAICSCode(NAICSCode naicsCode);
	
	public NAICSCode getByNAICSCodeID(Integer id);
	
	public void deleteNAICSCode(Integer id);
	
	public NAICSCode viewByCode(String code);

}
