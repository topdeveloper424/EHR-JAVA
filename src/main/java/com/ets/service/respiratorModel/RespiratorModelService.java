package com.ets.service.respiratorModel;

import java.util.List;

import com.ets.model.RespiratorModel;

public interface RespiratorModelService {
	
	public void addRespiratorModel(RespiratorModel respiratorModel);
	
	public List<RespiratorModel> viewAllRespiratorModel();
	
	public void delete(Integer id);
	
}
