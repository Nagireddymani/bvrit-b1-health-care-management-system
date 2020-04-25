package com.capg.hcms.center_management_system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "test_info")
public class DiagnosticTest {

	@Id
	private String testId;
	private String testName;
	
	@ManyToOne
	@JoinColumn(name = "centerId")
	private DiagnosticCenter center;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
	
	
	public DiagnosticTest() {
		super();
	}
	public DiagnosticTest(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}
	
	
	public DiagnosticCenter getCenter() {
		return center;
	}
	public void setCenter(DiagnosticCenter center) {
		this.center = center;
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
