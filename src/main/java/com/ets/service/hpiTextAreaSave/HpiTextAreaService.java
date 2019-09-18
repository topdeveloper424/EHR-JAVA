package com.ets.service.hpiTextAreaSave;

import java.util.List;

import com.ets.model.EmrChartingTextAreaSave;

public interface HpiTextAreaService {

	public void saveOrUpdate(EmrChartingTextAreaSave hpiTextAreaSave);
	//public List<EmrHpiTextAreaSave> view();
	public  List<EmrChartingTextAreaSave> viewAll(Integer patVisitId);
}
