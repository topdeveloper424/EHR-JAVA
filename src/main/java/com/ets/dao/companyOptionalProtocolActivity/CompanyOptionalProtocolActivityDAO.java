package com.ets.dao.companyOptionalProtocolActivity;

import java.util.List;

import com.ets.model.CompanyOptionalProtocolActivity;

public interface CompanyOptionalProtocolActivityDAO {
	
	public void saveCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity companyOptionalProtocolActivity);
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivity();
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivityByProtocolId(Integer id);
	 public void delete(Integer companyOptionalProtocolActivityId);
	 public void deleteByProtocolId(Integer protocolId);
}
