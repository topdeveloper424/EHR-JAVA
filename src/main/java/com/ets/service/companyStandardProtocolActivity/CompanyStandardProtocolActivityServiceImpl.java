package com.ets.service.companyStandardProtocolActivity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.companyStandardProtocolActivity.CompanyStandardProtocolActivityDAO;
import com.ets.model.CompanyStandardProtocolActivity;

@Service
@Transactional
public class CompanyStandardProtocolActivityServiceImpl implements CompanyStandardProtocolActivityService{
	
	private CompanyStandardProtocolActivityDAO companyStandardProtocolActivityDAO;
	public void setCompanyStandardProtocolActivityDAO(
			CompanyStandardProtocolActivityDAO companyStandardProtocolActivityDAO) {
		this.companyStandardProtocolActivityDAO = companyStandardProtocolActivityDAO;
	}

	@Override
	public void saveCompanyStandardProtocolActivity(CompanyStandardProtocolActivity companyStandardProtocolActivity) {
		
		companyStandardProtocolActivityDAO.saveCompanyStandardProtocolActivity(companyStandardProtocolActivity);
		
	}

	@Override
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivity() {
		
		return companyStandardProtocolActivityDAO.viewCompanyStandardProtocolActivity();
	}

	@Override
	public List<CompanyStandardProtocolActivity> viewCompanyStandardProtocolActivityByProtocolId(Integer id) {
		
		return companyStandardProtocolActivityDAO.viewCompanyStandardProtocolActivityByProtocolId(id);
	}

	@Override
	public void delete(Integer companyStandardProtocolActivityId) {
		companyStandardProtocolActivityDAO.delete(companyStandardProtocolActivityId);
		
	}

	@Override
	public void deleteByProtocolId(Integer protocolId) {
		companyStandardProtocolActivityDAO.deleteByProtocolId(protocolId);
		
	}

}
