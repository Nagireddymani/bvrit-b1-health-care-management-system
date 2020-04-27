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
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "center")
//	private List<DiagnosticTest> testList;
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "center")
//	private List<Appointment> appointmentList;
	
	@ElementCollection
	private List<String> test;
	@ElementCollection
	private List<BigInteger> appointment;
	
	
	public DiagnosticCenter() {
		super();
	}
	

	public DiagnosticCenter(String centerId, String centerName, List<String> test,
			List<BigInteger> appointment) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.test = test;
		this.appointment = appointment;
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
	
	public List<String> getTest() {
		return test;
	}


	public void setTest(List<String> test) {
		this.test = test;
	}


	public List<BigInteger> getAppointment() {
		return appointment;
	}


	public void setAppointment(List<BigInteger> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "DiagnosticCenter [centerId=" + centerId + ", centerName=" + centerName + ", testId=" + test
				+ ", appointmentId=" + appointment + "]";
	}
	
	
}
