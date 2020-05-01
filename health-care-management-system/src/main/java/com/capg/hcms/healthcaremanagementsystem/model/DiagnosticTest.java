package com.capg.hcms.healthcaremanagementsystem.model;

public class DiagnosticTest {
    
	private String testName;
    private String testId;

    public DiagnosticTest() {
		super();
		// TODO Auto-generated constructor stub
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
