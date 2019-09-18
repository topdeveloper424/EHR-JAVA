package com.ets.service.workActivity;

import java.util.List;

import com.ets.model.WorkActivity;

public interface WorkActivityService {

	public void addWorkActivity(WorkActivity workActivity);

	public List<WorkActivity> workActivityList();

	public void updateWorkActivity(WorkActivity workActivity);

	public WorkActivity getByWorkActivityID(Integer id);

	public void deleteWorkActivity(Integer id);

}
