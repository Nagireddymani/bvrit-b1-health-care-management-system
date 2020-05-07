package com.capg.hcms.test_management_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/*******************************************************************************************************************************
-Author                   :     
-Created/Modified Date    :     
-Description              :    

*******************************************************************************************************************************/

@Entity
@Table(name = "test_info")
public class DiagnosticTest {
	
	@Id
    private String testId;
    private String testName;

	public DiagnosticTest() {
		super();
	}

	public DiagnosticTest(String testName, String testId) {
		super();
		this.testName = testName;
		this.testId = testId;
	}
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	@Override
	public String toString() {
		return "DiagnosticTest [testName=" + testName + ", testId=" + testId + "]";
	}
   
}
