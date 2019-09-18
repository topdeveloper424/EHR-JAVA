package com.ets.service.providerSchRecurException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.providerSchRecurException.StaffSchRecurExceptionDAO;
import com.ets.model.ProviderSchRecurException;

@Service
@Transactional
public class StaffSchRecurExceptionServiceImpl implements StaffSchRecurExceptionService {
	private StaffSchRecurExceptionDAO staffSchRecurExceptionDAO;

	public void setStaffSchRecurExceptionDAO(StaffSchRecurExceptionDAO staffSchRecurExceptionDAO) {
		this.staffSchRecurExceptionDAO = staffSchRecurExceptionDAO;
	}

	@Override
	public void saveOrUpdate(ProviderSchRecurException staffSchRecurException) {
		staffSchRecurExceptionDAO.saveOrUpdate(staffSchRecurException);

	}

	@Override
	public void delete(Integer id) {
		staffSchRecurExceptionDAO.delete(id);

	}

	@Override
	public List<ProviderSchRecurException> view() {

		return staffSchRecurExceptionDAO.view();
	}

	@Override
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionById(Integer Id) {

		return staffSchRecurExceptionDAO.viewStaffSchRecurExceptionById(Id);
	}

	@Override
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByProviderId(Integer Id) {
		// TODO Auto-generated method stub
		return staffSchRecurExceptionDAO.viewStaffSchRecurExceptionByProviderId(Id);
	}

	@Override
	public List<ProviderSchRecurException> viewStaffSchRecurExceptionByClinicianId(Integer Id) {
		// TODO Auto-generated method stub
		
		return staffSchRecurExceptionDAO.viewStaffSchRecurExceptionByClinicianId(Id);
	}

}
