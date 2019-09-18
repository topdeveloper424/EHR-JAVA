package com.ets.dao.patientAppointment;

import java.util.Date;
import java.util.List;

import com.ets.model.PatientAppointment;

public interface PatientAppointmentDAO {
	
public void save(PatientAppointment patientAppointment);

public void delete(Integer id);


public List<PatientAppointment> viewByDate(Date date);


public List<PatientAppointment> viewById(Integer patentId);


public List<PatientAppointment> viewByProiderAndDate(Date date,Integer id);

public List<PatientAppointment>viewByNameAndDate(String firstName,String lastName,Date date);
public List<PatientAppointment>viewByNameDateProviderId(String firstName,String lastName,Date date,String purpose);

public List<PatientAppointment>viewByNameDateProviderAndTime(Date date,String time,String provider);
public List<PatientAppointment>viewByNameDateProviderPurpose(String firstName,String lastName,Date date,String purpose,String providerFirst,String providerLast,String status);
public List<PatientAppointment>viewByBothProvider(String firstName,String lastName,String firstName1,String lastName1,Date date);
public List<PatientAppointment>viewByProvider(String firstName,String lastname);
}
