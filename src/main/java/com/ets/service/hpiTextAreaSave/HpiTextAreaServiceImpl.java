package com.ets.service.hpiTextAreaSave;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.hpiTextAreaSave.HpiTextAreaSaveDAO;
import com.ets.model.EmrChartingTextAreaSave;

@Service
@Transactional
public class HpiTextAreaServiceImpl implements HpiTextAreaService {

	private HpiTextAreaSaveDAO hpiTextAreaSaveDAO;
	
	public void setHpiTextAreaSaveDAO(HpiTextAreaSaveDAO hpiTextAreaSaveDAO) {
		this.hpiTextAreaSaveDAO = hpiTextAreaSaveDAO;
	}

	@Override
	public void saveOrUpdate(EmrChartingTextAreaSave hpiTextAreaSave) {
		
		hpiTextAreaSaveDAO.saveOrUpdate(hpiTextAreaSave);
	}

	@Override
	public  List<EmrChartingTextAreaSave> viewAll(Integer patVisitId) {
		// TODO Auto-generated method stub
		return hpiTextAreaSaveDAO.viewAll(patVisitId);
	}

	/*@Override
	public List<EmrHpiTextAreaSave> view() {
	
		return hpiTextAreaSaveDAO.view();
	}
*/

}
