package com.ets.dao.companyProtocol;

import java.util.List;

import com.ets.model.CompanyProtocol;

public interface CompanyProtocolDAO {
	
	public void saveCompanyProtocol(CompanyProtocol companyProtocol);
	public List<CompanyProtocol> viewCompanyProtocol();
	public List<CompanyProtocol> viewCompanyProtocolByCompanyId(Integer comId);
	public CompanyProtocol viewByDescripAndId(Integer compId , String description);
	public CompanyProtocol viewByVCatIdAndCompId(Integer compId , Integer vCatId);
    public void delete(Integer id);
}
