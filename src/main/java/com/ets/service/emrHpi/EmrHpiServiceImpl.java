package com.ets.service.emrHpi;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.emrHpi.EmrHpiDAO;
import com.ets.model.EmrHpi;

@Service
@Transactional
public class EmrHpiServiceImpl implements EmrHpiService {

	private EmrHpiDAO emrHpiDAO;
	
	
	public void setEmrHpiDAO(EmrHpiDAO emrHpiDAO) {
		this.emrHpiDAO = emrHpiDAO;
	}


	/*@Override
	public void saveOrUpdate(EmrHpi emrHpi) {
		emrHpiDAO.saveOrUpdate(emrHpi);
		
	}*/


	@Override
	public void saveOrUpdate(List<EmrHpi> emrHpi) {
	
		emrHpiDAO.saveOrUpdate(emrHpi);
		
	}


	


	@Override
	public int delete(String emrHpi) {
		// TODO Auto-generated method stub
		return emrHpiDAO.delete(emrHpi);
	}


	/*@Override
	public List<EmrHpi> view() {
		// TODO Auto-generated method stub
		return emrHpiDAO.view();
	}
*/

	

}
