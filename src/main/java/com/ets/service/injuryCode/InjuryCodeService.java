package com.ets.service.injuryCode;

import java.util.List;

import com.ets.model.InjuryCode;

public interface InjuryCodeService {

	public void addInjuryCode(InjuryCode injuryCode);

	public List<InjuryCode> injuryCodeList();

	public void updateInjuryCode(InjuryCode injuryCode);

	public InjuryCode getbyInjuryID(Integer id);
	
	public void deleteInjuryCode(Integer id);

}
