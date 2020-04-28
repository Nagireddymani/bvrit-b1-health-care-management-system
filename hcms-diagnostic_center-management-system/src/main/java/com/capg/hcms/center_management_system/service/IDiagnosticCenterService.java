package com.capg.hcms.center_management_system.service;

import java.util.List;

import com.capg.hcms.center_management_system.model.DiagnosticCenter;

public interface IDiagnosticCenterService {

	List<DiagnosticCenter> getAllCenters();
	
	DiagnosticCenter addCenter(DiagnosticCenter center);
	
	boolean removeCenter(DiagnosticCenter center);
	
	DiagnosticCenter getCenter(String centerId);
	
	DiagnosticCenter updateCenter(DiagnosticCenter center);
}
