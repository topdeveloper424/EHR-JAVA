package com.ets.dao.note;

import com.ets.model.Note;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NoteDAO Interface
 *Description: Note Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface NoteDAO {
	
	public void addOrUpdate(Note note);
	
}
