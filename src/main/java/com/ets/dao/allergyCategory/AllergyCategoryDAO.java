package com.ets.dao.allergyCategory;

import java.util.List;

import com.ets.model.AllergyCategory;
import com.ets.model.Carrier;

public interface AllergyCategoryDAO {

	public void saveOrUpdate(AllergyCategory allergyCategory);

	public List<AllergyCategory> view();
	
	public AllergyCategory searchByDescrip(String descrip);

}
