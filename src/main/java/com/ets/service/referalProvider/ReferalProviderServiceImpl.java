package com.ets.service.referalProvider;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.referalProvider.ReferalProviderDAO;
import com.ets.model.ReferalProvider;

@Service
@Transactional
public class ReferalProviderServiceImpl implements ReferalProviderService {
	
	private ReferalProviderDAO referalProviderDAO;

	public void setReferalProviderDAO(ReferalProviderDAO referalProviderDAO) {
		this.referalProviderDAO = referalProviderDAO;
	}

	@Override
	public void addOrUpdate(ReferalProvider referalProvider) {
		
		referalProviderDAO.addOrUpdate(referalProvider);
		
	}

	@Override
	public List<ReferalProvider> view() {
		
		return referalProviderDAO.view();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		referalProviderDAO.delete(id);
	}

	@Override
	public ReferalProvider viewById(Integer id) {
		// TODO Auto-generated method stub
		return referalProviderDAO.viewById(id);
	}
	

}
