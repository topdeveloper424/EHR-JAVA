package com.ets.service.region;



import java.util.List;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.region.RegionDAO;
import com.ets.model.Region;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RegionServiceImpl Class
 *Description: Region Entity Service class
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
public class RegionServiceImpl implements RegionService {
	
	private RegionDAO regionDAO;
	
	public void setRegionDAO(RegionDAO regionDAO) {
		this.regionDAO = regionDAO;
	}


	/** This method save the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addRegion(Region region) {
		regionDAO.addRegion(region);
		
	}


	/** This method gets all the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Region objects
	 */
	@Override
	public List<Region> regionList() {
		
		return regionDAO.regionList();
	}


	/** This method update the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param region
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateRegion(Region region) {
		
		regionDAO.updateRegion(region);
		
	}


	/** This method gets all the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Region objects
	 */
	@Override
	public Region getByRegionID(Integer id) {
		
		return regionDAO.getByRegionID(id);
	}


	/** This method delete the Region objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteRegion(Integer id) {
		
		regionDAO.deleteRegion(id);
		
	}


	@Override
	public Region viewByCode(String code) {
		
		return regionDAO.viewByCode(code);
	}
	
}
