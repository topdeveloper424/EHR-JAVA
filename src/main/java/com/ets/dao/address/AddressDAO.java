package com.ets.dao.address;

import com.ets.model.Address;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 21-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AddressDAO Interface
 *Description: Address Entity DAO Interface
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

public interface AddressDAO {
	
	public void add(Address address);
	
	public void update(Address address);

}
