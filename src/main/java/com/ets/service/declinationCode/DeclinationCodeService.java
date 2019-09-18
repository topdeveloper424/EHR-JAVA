package com.ets.service.declinationCode;

import java.util.List;

import com.ets.model.DeclinationCode;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeService Interface
 *Description: DeclinationCode Entity Service Interface
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
public interface DeclinationCodeService {

	public void add(DeclinationCode declinationCode);

	public List<DeclinationCode> list();

	public void update(DeclinationCode declinationCode);

	public DeclinationCode getByID(Integer id);

	public void delete(Integer id);

}
