package com.capg.hcms.test_management_system.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     22-04-2020
-Description              :     DiagnosticTestList is used to display list of tests.

*******************************************************************************************************************************/

public class DiagnosticTestList {

	private List<DiagnosticTest> testList;

	public DiagnosticTestList()
	{
		
	}
	
	public DiagnosticTestList(List<DiagnosticTest> testList) {
		super();
		this.testList = testList;
	}
	
	public List<DiagnosticTest> getTestList() {
		return testList;
	}
	public void setTestList(List<DiagnosticTest> testList) {
		this.testList = testList;
	}
	
	@Override
	public String toString() {
		return "DiagnosticTestList [testList=" + testList + "]";
	}
	
}
