package com.ets.service.stateJobCategory;

import java.util.List;

import com.ets.model.StateJobCategory;

public interface StateJobCategoryService {

	public void addStateJobCategory(StateJobCategory stateJobCategory);

	public List<StateJobCategory> stateJobCategoryList();

	public void updateStateJobCategory(StateJobCategory stateJobCategory);

	public StateJobCategory getByStateJobCategoryID(Integer id);

	public void deleteStateJobCategory(Integer id);

}
