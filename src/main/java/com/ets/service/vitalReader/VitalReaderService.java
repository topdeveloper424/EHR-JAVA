package com.ets.service.vitalReader;

import java.util.List;

import com.ets.model.VitalReader;

public interface VitalReaderService {
	 public void saveOrUpdate(VitalReader vitalReader);
	  public List<VitalReader> viewVitalReader();
	  public void delete(Integer id);
	  public void updateVitalReader(VitalReader vitalReader);
}
