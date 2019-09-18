package com.ets.dao.declinationCode;

import java.util.List;

import com.ets.model.DeclinationCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeDAO Interface
 *Description: DeclinationCode Entity DAO Interface
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

public interface DeclinationCodeDAO {

	public void add(DeclinationCode declinationCode);

	public List<DeclinationCode> list();

	public void update(DeclinationCode declinationCode);

	public DeclinationCode getByID(Integer id);

	public void delete(Integer id);

}
