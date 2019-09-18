package com.ets.dao.hpiTextAreaSave;

import java.util.List;

import com.ets.model.EmrChartingTextAreaSave;

public interface HpiTextAreaSaveDAO {
	
	public void saveOrUpdate(EmrChartingTextAreaSave hpiTextAreaSave);
//	public List<EmrHpiTextAreaSave> view();
    public  List<EmrChartingTextAreaSave> viewAll(Integer patVisitId);
	

}
