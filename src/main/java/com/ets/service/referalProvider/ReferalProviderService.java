package com.ets.service.referalProvider;

import java.util.List;

import com.ets.model.ReferalProvider;

public interface ReferalProviderService {
	
	public void addOrUpdate(ReferalProvider referalProvider);
	
	public List<ReferalProvider> view();
	
	public void delete(Integer id);
	
	public ReferalProvider viewById(Integer id);

}
