package com.ets.service.workRestriction;

import java.util.List;

import com.ets.model.WorkRestriction;

public interface WorkRestrictionService {

	public void add(WorkRestriction workRestriction);

	public List<WorkRestriction> list();

	public void update(WorkRestriction workRestriction);

	public WorkRestriction getByID(Integer id);

	public void delete(Integer id);

}
