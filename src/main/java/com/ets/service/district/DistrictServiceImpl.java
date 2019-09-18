package com.ets.service.district;


import java.util.List;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.district.DistrictDAO;
import com.ets.model.District;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DistrictServiceImpl Class
 *Description: District Entity Service class
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

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
	
	private DistrictDAO districtDAO;
	
	

	public void setDistrictDAO(DistrictDAO districtDAO) {
		this.districtDAO = districtDAO;
	}

	/** This method save the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param district
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	@Override
	public void addDistrict(District district) {
		
		districtDAO.addDistrict(district);
		
	}

	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	@Override
	public List<District> districtList() {
		
		return districtDAO.districtList();
	}

	/** This method update the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param district
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateDistrict(District district) {
		
		districtDAO.updateDistrict(district);
		
	}

	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	@Override
	public District getByDistrictID(Integer id) {
		
		return districtDAO.getByDistrictID(id);
	}

	/** This method delete the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteDistrict(Integer id) {
		
		districtDAO.deleteDistrict(id);
		
	}

	/** This method gets all the District objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param name
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of District objects
	 */
	@Override
	public District getDistrictByName(String name) {
		
		return districtDAO.getDistrictByName(name);
		
	}

	@Override
	public District viewByCode(String code) {
		
		return districtDAO.viewByCode(code);
		
	}
	
	

}
