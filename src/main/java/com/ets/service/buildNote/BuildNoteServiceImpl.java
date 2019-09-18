package com.ets.service.buildNote;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.buildNote.BuildNoteDAO;
import com.ets.model.BuildNote;

@Service
@Transactional
public class BuildNoteServiceImpl  implements BuildNoteService{
	
	
	private BuildNoteDAO buildNoteDAO;

	public void setBuildNoteDAO(BuildNoteDAO buildNoteDAO) {
		this.buildNoteDAO = buildNoteDAO;
	}

	@Override
	public void saveOrUpdate(BuildNote buildNote) {
		buildNoteDAO.saveOrUpdate(buildNote);
		
	}

	@Override
	public List<BuildNote>  viewByPatientVisit(Integer patVisitId) {
		
		return buildNoteDAO.viewByPatientVisit(patVisitId);
	}

	@Override
	public List<BuildNote> viewByPatient(Integer patid) {
		
		return buildNoteDAO.viewByPatient(patid);
	}

}
