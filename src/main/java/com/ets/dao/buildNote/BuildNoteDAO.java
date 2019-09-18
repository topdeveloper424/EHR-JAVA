package com.ets.dao.buildNote;

import java.util.List;

import com.ets.model.BuildNote;

public interface BuildNoteDAO {

	
	public void saveOrUpdate(BuildNote buildNote);
	public List<BuildNote> viewByPatientVisit(Integer patVisitId);
	public List<BuildNote> viewByPatient(Integer patid);
}
