package com.ets.service.reasonOrCause;

import java.util.List;

import com.ets.model.ReasonOrCause;
import com.ets.model.RootCause;

public interface ReasonOrCauseService {

	public void addReasonOrCause(ReasonOrCause reasonOrCause);

	public List<ReasonOrCause> reasonCauseLists();

	public void updateReasonOrCause(ReasonOrCause reasonOrCause);

	public ReasonOrCause getByReasonOrCauseID(Integer id);

	public void deleteReasonOrCause(Integer id);

}
