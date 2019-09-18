package com.ets.service.rootCause;

import java.util.List;

import com.ets.model.RootCause;

public interface RootCauseService {

	public void addRootCause(RootCause rootCause);

	public List<RootCause> rootCauseLists();

	public void updateRootCause(RootCause rootCause);

	public RootCause getByRootCauseID(Integer id);

	public void deleteRootCause(Integer id);

}
