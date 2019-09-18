package com.ets.dao.vitalReader;

import java.util.List;

import com.ets.model.VitalReader;

public interface VitalReaderDAO {
  public void saveOrUpdate(VitalReader vitalReader);
  public List<VitalReader> viewVitalReader();
  public void delete(Integer id);
  public void updateVitalReader(VitalReader vitalReader);
}
