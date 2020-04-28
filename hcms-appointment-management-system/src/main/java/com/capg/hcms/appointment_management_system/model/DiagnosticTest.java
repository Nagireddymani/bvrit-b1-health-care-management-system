package com.capg.hcms.appointment_management_system.model;


public class DiagnosticTest {

	private String testId;
    private String testName;
    
	public DiagnosticTest() {
		super();
	}
	public DiagnosticTest(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	@Override
	public String toString() {
		return "DiagnosticTest [testId=" + testId + ", testName=" + testName + "]";
	}
    
    
}
