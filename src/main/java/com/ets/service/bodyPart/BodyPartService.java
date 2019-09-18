package com.ets.service.bodyPart;

import java.util.List;

import com.ets.model.BodyPart;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyPartService Interface
 *Description: BodyPart Entity Service Interfaces
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

public interface BodyPartService {

	public void addBodyPart(BodyPart bodyPart);

	public List<BodyPart> listBodyPart();

	public void updateBodyPart(BodyPart bodyPart);

	public BodyPart getByBodyPartID(Integer id);

	public void deleteBodyPartCode(Integer id);

}
