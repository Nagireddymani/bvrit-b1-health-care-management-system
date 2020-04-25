package com.capg.hcms.appointment_management_system.model;

import java.util.List;

public class DiagnosticCenter {

	private String centerName;
	private String centerId;
	private List<String> listOfTests;
	private List<Long> appointmentList;
	
	public DiagnosticCenter() {
		super();
	}
	
	public DiagnosticCenter(String centerName, String centerId, List<String> listOfTests,
			List<Long> appointmentList) {
		super();
		this.centerName = centerName;
		this.centerId = centerId;
		this.listOfTests = listOfTests;
		this.appointmentList = appointmentList;
	}
	
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public List<String> getListOfTests() {
		return listOfTests;
	}
	public void setListOfTests(List<String> listOfTests) {
		this.listOfTests = listOfTests;
	}
	public List<Long> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Long> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
	@Override
	public String toString() {
		return "DiagnosticCenter [centerName=" + centerName + ", centerId=" + centerId + ", listOfTests=" + listOfTests
				+ ", appointmentList=" + appointmentList + "]";
	}
	
	
}
