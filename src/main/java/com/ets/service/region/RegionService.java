package com.ets.service.region;

import java.util.List;

import com.ets.model.Region;

public interface RegionService {

	public void addRegion(Region region);

	public List<Region> regionList();

	public void updateRegion(Region region);

	public Region getByRegionID(Integer id);

	public void deleteRegion(Integer id);
	
	public Region viewByCode(String code);

}
