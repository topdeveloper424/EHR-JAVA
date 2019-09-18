package com.ets.service.departmentUnit;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.departmentUnit.DepartmentUnitDAO;
import com.ets.model.DepartmentUnit;

@Service
@Transactional
public class DepartmentUnitServiceImpl implements DepartmentUnitService {

	private DepartmentUnitDAO departmentUnitDAO;

	public void setDepartmentUnitDAO(DepartmentUnitDAO departmentUnitDAO) {
		this.departmentUnitDAO = departmentUnitDAO;
	}

	@Override
	public void add(DepartmentUnit departmentUnit) {

		departmentUnitDAO.add(departmentUnit);

	}

	@Override
	public List<DepartmentUnit> view() {

		return departmentUnitDAO.view();
	}

	@Override
	public DepartmentUnit getById(Integer id) {
		// TODO Auto-generated method stub
		return departmentUnitDAO.getById(id);
	}

	@Override
	public void update(DepartmentUnit departmentUnit) {
		// TODO Auto-generated method stub
		departmentUnitDAO.update(departmentUnit);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		departmentUnitDAO.delete(id);
		
	}

	@Override
	public DepartmentUnit viewByCode(String code) {
		// TODO Auto-generated method stub
		return departmentUnitDAO.viewByCode(code);
	}

}
