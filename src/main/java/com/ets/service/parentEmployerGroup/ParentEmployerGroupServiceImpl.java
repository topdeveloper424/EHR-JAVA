package com.ets.service.parentEmployerGroup;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.parentEmployerGroup.ParentEmployerGroupDAO;
import com.ets.model.ParentEmployerGroup;

@Service
@Transactional
public class ParentEmployerGroupServiceImpl implements ParentEmployerGroupService {
	
	private ParentEmployerGroupDAO parentEmployerGroupDAO;

	public void setParentEmployerGroupDAO(ParentEmployerGroupDAO parentEmployerGroupDAO) {
		this.parentEmployerGroupDAO = parentEmployerGroupDAO;
	}

	@Override
	public void add(ParentEmployerGroup parentEmployerGroup) {
		
		parentEmployerGroupDAO.add(parentEmployerGroup);
	}

	@Override
	public List<ParentEmployerGroup> view() {
		
		return parentEmployerGroupDAO.view();
	}

	@Override
	public void delete(Integer id) {
		
		parentEmployerGroupDAO.delete(id);
		
	}
	

}
