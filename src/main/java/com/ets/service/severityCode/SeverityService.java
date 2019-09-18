package com.ets.service.severityCode;

import java.util.List;

import com.ets.model.SeverityCode;

public interface SeverityService {

	public void addSeverity(SeverityCode severityCode);

	public List<SeverityCode> severityCodeLists();

	public void updateSeverityCode(SeverityCode severityCode);

	public SeverityCode getBySeverityCodeID(Integer id);

	public void deleteSeverityCode(Integer id);

}
