package com.ets.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Clinic;
import com.ets.model.Company;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.Patient;
import com.ets.model.PatientAnalysis;
import com.ets.model.PatientVisit;
import com.ets.model.UserAccount;

import javafx.collections.ObservableList;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 10-19-2016(mm-dd-yyyy)
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Global Class
 *Description: Utility class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification: Neha Sahadev
 *Owner: 
 *Date: 30/11/2016
 *Version:
 *Description: Declare Company Name Globally
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

public class Global {
	
	 public static UserAccount userAccount = null;
	 public static Clinic clinic = null;
	 public static Patient patient = null;

	 public static Company company=null;
	 
	 public static ClassPathXmlApplicationContext context = null;
	 
	 public static PatientVisit patientVisitObj=new PatientVisit();
 
   	
   }
