package com.ets.service.note;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.note.NoteDAO;
import com.ets.model.Note;


@Service
@Transactional
public class NoteServiceImpl implements NoteService {

	private NoteDAO noteDAO;
	 
	public void setNoteDAO(NoteDAO noteDAO) {
		this.noteDAO = noteDAO;
	}

	@Override
	public void addOrUpdate(Note note) {
		
		noteDAO.addOrUpdate(note);
	}
    
	}

	
	

