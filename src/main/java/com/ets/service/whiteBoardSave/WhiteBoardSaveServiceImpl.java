package com.ets.service.whiteBoardSave;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.whiteBoardSave.WhiteBoardSaveDAO;
import com.ets.model.WhiteboardSave;

@Service
@Transactional
public class WhiteBoardSaveServiceImpl implements WhiteBoardSaveService{

	private WhiteBoardSaveDAO whiteBoardSaveDAO;
	
	
	public void setWhiteBoardSaveDAO(WhiteBoardSaveDAO whiteBoardSaveDAO) {
		this.whiteBoardSaveDAO = whiteBoardSaveDAO;
	}


	@Override
	public void saveOrUpdate(WhiteboardSave whiteboardSave) {
	
		whiteBoardSaveDAO.saveOrUpdate(whiteboardSave);
		
	}


	@Override
	public List<WhiteboardSave> view() {
		
		return whiteBoardSaveDAO.viewWhiteBoard();
	}

}
