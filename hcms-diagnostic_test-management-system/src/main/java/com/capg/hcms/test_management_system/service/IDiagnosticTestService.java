package com.capg.hcms.test_management_system.service;

import java.util.List;

import com.capg.hcms.test_management_system.model.DiagnosticTest;

public interface IDiagnosticTestService {
	
	DiagnosticTest addTest(DiagnosticTest test);
    boolean removeTest(DiagnosticTest test);
    List<DiagnosticTest> getAlltest();
	DiagnosticTest getTest(String testId);
	  
}
