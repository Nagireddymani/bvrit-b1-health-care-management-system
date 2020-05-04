package com.capg.hcms.center_management_system.service;

import java.math.BigInteger;

import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.model.DiagnosticCenterList;


/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     01-05-2020
-Description              :     DiagnosticCenterService Interface with services for DiagnosticCenter Management System

*******************************************************************************************************************************/

public interface IDiagnosticCenterService {

	DiagnosticCenterList getAllCenters();

	DiagnosticCenter addCenter(DiagnosticCenter center);
	
	DiagnosticCenter getCenterById(String centerId);
    
	DiagnosticCenter assignTestId(String centerId,String testId);
	
	DiagnosticCenter assignAppointmentId(String centerId,BigInteger appointmentId);
	
	boolean removeTestId(String centerId,String testId);
	
	boolean removeAllCenters();
	
	boolean removeCenter(DiagnosticCenter center);
}
