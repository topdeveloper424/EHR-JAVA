package com.ets.service.companyProtocol;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.companyProtocol.CompanyProtocolDAO;
import com.ets.model.CompanyProtocol;

@Transactional
@Service
public class CompanyProtocolServiceImpl implements CompanyProtocolService {
	
	private CompanyProtocolDAO companyProtocolDAO;

	public void setCompanyProtocolDAO(CompanyProtocolDAO companyProtocolDAO) {
		this.companyProtocolDAO = companyProtocolDAO;
	}

	@Override
	public void saveCompanyProtocol(CompanyProtocol companyProtocol) {
		
		companyProtocolDAO.saveCompanyProtocol(companyProtocol);
		
		
	}

	@Override
	public List<CompanyProtocol> viewCompanyProtocol() {
		
		return companyProtocolDAO.viewCompanyProtocol();
	}

	@Override
	public List<CompanyProtocol> viewCompanyProtocolByCompanyId(Integer comId) {
		
		return companyProtocolDAO.viewCompanyProtocolByCompanyId(comId);
	}

	@Override
	public CompanyProtocol viewByDescripAndId(Integer compId, String description) {
		// TODO Auto-generated method stub
		return companyProtocolDAO.viewByDescripAndId(compId, description);
	}

	@Override
	public CompanyProtocol viewByVCatIdAndCompId(Integer compId, Integer vCatId) {
		// TODO Auto-generated method stub
		return companyProtocolDAO.viewByVCatIdAndCompId(compId, vCatId);
	}

	@Override
	public void delete(Integer id) {
		companyProtocolDAO.delete(id);
		
	}

}
