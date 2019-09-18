package com.ets.service.patientInsuranceCarrier;
import java.util.List;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierServie Interface
 *Description: PatientInsuranceCarrier Entity Service Interface
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
import com.ets.model.PatientInsuranceCarrier;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrierServie Interface
 *Description: PatientInsuranceCarrier Entity Service Interface
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
public interface PatientInsuranceCarrierServie {
	
	public void saveOrUpdate(PatientInsuranceCarrier patientInsuranceCarrier);
	public List<PatientInsuranceCarrier> view();
	public PatientInsuranceCarrier viewById(Integer id);
	public void delete(Integer id);

}
