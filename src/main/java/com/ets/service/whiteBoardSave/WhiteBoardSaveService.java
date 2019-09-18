package com.ets.service.whiteBoardSave;

import java.util.List;

import com.ets.model.WhiteboardSave;

public interface WhiteBoardSaveService {

	public void saveOrUpdate(WhiteboardSave whiteboardSave);
	public List<WhiteboardSave> view();
}
