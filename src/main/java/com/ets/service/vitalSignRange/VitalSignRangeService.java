package com.ets.service.vitalSignRange;

import java.util.List;

import com.ets.model.VitalSignRange;

public interface VitalSignRangeService {
	
	public void add(VitalSignRange vitalSignRange );
	
	public List<VitalSignRange> list();
	
	public void update(VitalSignRange vitalSignRange );
	
	public VitalSignRange getByID(Integer id);
	
	public void delete(Integer id);

}
