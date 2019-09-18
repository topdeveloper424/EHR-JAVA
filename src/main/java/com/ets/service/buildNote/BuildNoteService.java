package com.ets.service.buildNote;

import java.util.List;

import com.ets.model.BuildNote;

public interface BuildNoteService {

	public void saveOrUpdate(BuildNote buildNote);
	public List<BuildNote> viewByPatientVisit(Integer patVisitId);
	public List<BuildNote> viewByPatient(Integer patid);
	
}
