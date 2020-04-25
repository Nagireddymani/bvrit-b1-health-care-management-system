package com.capg.hcms.center_management_system.model;

import java.util.List;


public class DiagnosticCenter {

	private String centerId;
	private String centerName;
	private List<DiagnosticTest> testList;
	private List<Appointment> appointmentList;
	
	
	public DiagnosticCenter() {
		super();
	}
	
	public DiagnosticCenter(String centerId, String centerName, List<DiagnosticTest> testList,
			List<Appointment> appointmentList) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.testList = testList;
		this.appointmentList = appointmentList;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<DiagnosticTest> getTestList() {
		return testList;
	}

	public void setTestList(List<DiagnosticTest> testList) {
		this.testList = testList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", testList=" + testList
				+ ", appointmentList=" + appointmentList + "]";
	}
	
	
}
