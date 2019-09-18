package com.ets.service.providerSchRecurException;

import java.util.List;

import com.ets.model.ProviderSchRecurException;

public interface StaffSchRecurExceptionService {

public void saveOrUpdate(ProviderSchRecurException staffSchRecurException);
public void delete(Integer id);
public List<ProviderSchRecurException> view();
public List<ProviderSchRecurException> viewStaffSchRecurExceptionById(Integer Id);
public List<ProviderSchRecurException> viewStaffSchRecurExceptionByProviderId(Integer Id);
public List<ProviderSchRecurException> viewStaffSchRecurExceptionByClinicianId(Integer Id);


}
