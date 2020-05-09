package com.capg.hcms.test_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.test_management_system.model.DiagnosticTest;


/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     22-04-2020
-Description              :     DiagnosticTest Repository Interface with DiagnosticTest as Type and String as Key
*******************************************************************************************************************************/
	
public interface IDiagnosticTestRepo extends JpaRepository<DiagnosticTest, String>{

	public DiagnosticTest getByTestName(String testName); 
}
