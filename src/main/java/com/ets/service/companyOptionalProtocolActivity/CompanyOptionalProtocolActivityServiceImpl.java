package com.ets.service.companyOptionalProtocolActivity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityDAO;
import com.ets.model.CompanyOptionalProtocolActivity;

@Service
@Transactional
public class CompanyOptionalProtocolActivityServiceImpl implements CompanyOptionalProtocolActivityService{
	
	private CompanyOptionalProtocolActivityDAO companyOptionalProtocolActivityDAO;

	public void setCompanyOptionalProtocolActivityDAO(
			CompanyOptionalProtocolActivityDAO companyOptionalProtocolActivityDAO) {
		this.companyOptionalProtocolActivityDAO = companyOptionalProtocolActivityDAO;
	}

	@Override
	public void saveCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity companyOptionalProtocolActivity) {
		
		companyOptionalProtocolActivityDAO.saveCompanyOptionalProtocolActivity(companyOptionalProtocolActivity);
		
		
	}

	@Override
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivity() {
		
		return companyOptionalProtocolActivityDAO.viewCompanyOptionalProtocolActivity();
	}

	@Override
	public List<CompanyOptionalProtocolActivity> viewCompanyOptionalProtocolActivityByProtocolId(Integer id) {
		
		return companyOptionalProtocolActivityDAO.viewCompanyOptionalProtocolActivityByProtocolId(id);
	}

	@Override
	public void delete(Integer companyOptionalProtocolActivityId) {
		companyOptionalProtocolActivityDAO.delete(companyOptionalProtocolActivityId);
		
	}

	@Override
	public void deleteByProtocolId(Integer protocolId) {
		companyOptionalProtocolActivityDAO.deleteByProtocolId(protocolId);
		
	}

}
