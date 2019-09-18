package com.ets.dao.whiteBoardSave;

import java.util.List;

import com.ets.model.WhiteboardSave;

public interface WhiteBoardSaveDAO {

	public void saveOrUpdate(WhiteboardSave whiteboardSave);
	public List<WhiteboardSave> viewWhiteBoard();
}
