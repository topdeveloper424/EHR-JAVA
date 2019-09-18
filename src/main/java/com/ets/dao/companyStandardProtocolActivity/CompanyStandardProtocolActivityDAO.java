package com.ets.dao.companyStandardProtocolActivity;

import java.util.List;

import com.ets.model.CompanyStandardProtocolActivity;

public interface CompanyStandardProtocolActivityDAO {
	
	public void saveCompanyStandardProtocolActivity(CompanyStandardProtocolActivity companyStandardProtocolActivity);
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivity();
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivityByProtocolId(Integer id);
    public void delete(Integer companyStandardProtocolActivityId);
    public void deleteByProtocolId(Integer protocolId);
    
}
