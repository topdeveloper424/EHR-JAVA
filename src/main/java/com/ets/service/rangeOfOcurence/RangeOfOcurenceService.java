package com.ets.service.rangeOfOcurence;

import java.util.List;

import com.ets.model.RangeOfOcurence;

public interface RangeOfOcurenceService {
	
	public void add(RangeOfOcurence rangeOfOcurence);

	public List<RangeOfOcurence> list();

	public void update(RangeOfOcurence rangeOfOcurence);

	public RangeOfOcurence getByID(Integer id);

	public void delete(Integer id);

}
