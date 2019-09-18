package com.ets.service.stateWorkArea;

import java.util.List;

import com.ets.model.StateWorkArea;

public interface StateWorkAreaService {

	public void addStateWorkArea(StateWorkArea stateWorkArea);

	public List<StateWorkArea> stateWorkAreaList();

	public void updateStateWorkArea(StateWorkArea stateWorkArea);

	public StateWorkArea getByStateWorkArea(Integer id);

	public void deleteStateWorkArea(Integer id);

}
