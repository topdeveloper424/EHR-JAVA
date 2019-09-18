package com.ets.service.sicCode;

import java.util.List;

import com.ets.model.SICCode;

public interface SicCodeService {

	public void addSICCode(SICCode sicCode);

	public List<SICCode> sICCodeList();

	public void updateSICCode(SICCode sicCode);

	public SICCode getBySICCodeID(Integer id);

	public void deleteSICCode(Integer id);
	
	public SICCode viewByCode(String code);

}
