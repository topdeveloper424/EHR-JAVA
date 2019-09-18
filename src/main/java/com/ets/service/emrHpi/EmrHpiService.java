package com.ets.service.emrHpi;

import java.util.List;

import com.ets.model.EmrHpi;

public interface EmrHpiService {


//	public void saveOrUpdate(EmrHpi emrHpi);
	public int delete(String emrHpi);
	
	/*public List<EmrHpi> view();*/

	//public void saveOrUpdate(EmrHpi emrHpi);
	
	public void saveOrUpdate(List<EmrHpi> emrHpi);

}
