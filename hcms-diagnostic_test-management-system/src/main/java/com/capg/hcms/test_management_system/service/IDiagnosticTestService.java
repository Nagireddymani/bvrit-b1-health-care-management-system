package com.capg.hcms.test_management_system.service;

import java.util.List;

import com.capg.hcms.test_management_system.model.DiagnosticTest;


/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     4/5/2020
-Description              :     DiagnosticTestService Interface with services for DiagnosticTest Management System

*******************************************************************************************************************************/

public interface IDiagnosticTestService {
	
	DiagnosticTest addTest(DiagnosticTest test);
    
	List<DiagnosticTest> getAllTests();
	
	DiagnosticTest getTestById(String testId);
	
	boolean removeAllTests();
	
	boolean removeTest(DiagnosticTest test);
}
