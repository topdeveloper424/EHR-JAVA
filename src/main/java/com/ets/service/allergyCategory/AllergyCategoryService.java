package com.ets.service.allergyCategory;

import java.util.List;

import com.ets.model.AllergyCategory;
import com.ets.model.Assesment;

public interface AllergyCategoryService {


	public void saveOrUpdate(AllergyCategory allergyCategory);
	public List<AllergyCategory> view();
	public AllergyCategory searchByDescrip(String descrip);
}
