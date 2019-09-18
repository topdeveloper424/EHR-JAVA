package com.ets.service.district;

import java.util.List;

import com.ets.model.District;

public interface DistrictService {

	public void addDistrict(District district);

	public List<District> districtList();

	public void updateDistrict(District district);

	public District getByDistrictID(Integer id);

	public void deleteDistrict(Integer id);
	
	public District getDistrictByName(String name);

	public District viewByCode(String code);
	
}
