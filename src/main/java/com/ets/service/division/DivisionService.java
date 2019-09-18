package com.ets.service.division;

import java.util.List;

import com.ets.model.Division;

public interface DivisionService {

	public void addDivision(Division division);

	public List<Division> divisionList();

	public void updateDivision(Division division);

	public Division getByDivisionID(Integer id);

	public void deleteDivision(Integer id);
	
	public List<Division> viewDivisionById(Integer id);
	
	public Division viewByCode(String code);

}
