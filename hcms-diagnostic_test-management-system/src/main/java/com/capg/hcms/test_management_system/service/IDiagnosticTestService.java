package com.capg.hcms.test_management_system.service;

import java.util.List;

import com.capg.hcms.test_management_system.model.DiagnosticTest;

/*******************************************************************************************************************************
-Author                   :     
-Created/Modified Date    :     
-Description              :    

*******************************************************************************************************************************/

public interface IDiagnosticTestService {
	
	DiagnosticTest addTest(DiagnosticTest test);
    
	List<DiagnosticTest> getAllTests();
	
	DiagnosticTest getTestById(String testId);
	
	boolean removeAllTests();
	
	boolean removeTest(DiagnosticTest test);
}
