package com.capg.hcms.center_management_system.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "center_info")
public class DiagnosticCenter {

	@Id
	private String centerId;	
	private String centerName;
	@ElementCollection
	private List<String> tests;
	@ElementCollection
	private List<BigInteger> appointments;
	
	
	public DiagnosticCenter() {
		super();
	}
	

	public DiagnosticCenter(String centerId, String centerName, List<String> tests,
			List<BigInteger> appointments) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.tests = tests;
		this.appointments = appointments;
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
	
	public List<String> getTests() {
		return tests;
	}


	public void setTests(List<String> tests) {
		this.tests = tests;
	}


	public List<BigInteger> getAppointments() {
		return appointments;
	}


	public void setAppointment(List<BigInteger> appointment) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", testId=" + tests
				+ ", appointmentId=" + appointments + "]";
	}
	
	
}
