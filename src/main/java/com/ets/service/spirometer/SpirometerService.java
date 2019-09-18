package com.ets.service.spirometer;

import java.util.List;

import com.ets.model.Spirometer;

public interface SpirometerService {
	public void saveSpirometer(Spirometer spirometer);

	public List<Spirometer> view();

	/*public Spirometer getById(Integer id);
*/
//	public void update(Spirometer spirometer);

	public void delete(Integer id);

}
