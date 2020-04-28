package com.capg.hcms.appointment_management_system.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table(name = "appointment_info")
public class Appointment {

	private String userId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "appointment")
//	private User user;

//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "appointment")
//	private DiagnosticTest test;

//	@OneToOne
//	@JoinColumn(name = "centerId")
//	private DiagnosticCenter center;

	private String centerId;

	private String testId;

	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime dateTime;

	// private boolean approved=false;
	private boolean approved = false;

	public Appointment() {
		super();
	}

	public Appointment(User user, long appointmentId, String userId, /* DiagnosticTest test, */ LocalDateTime dateTime,
			boolean approved, /* DiagnosticCenter center, */ String centerId, String testId) {
		super();
		// this.user = user;
		this.userId = userId;
		this.appointmentId = appointmentId;
		// this.test = test;
		this.centerId = centerId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.approved = approved;
		// this.center = center;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	/*
	 * public DiagnosticCenter getCenter() { return center; }
	 * 
	 * public void setCenter(DiagnosticCenter center) { this.center = center; }
	 * 
	 * public DiagnosticTest getTest() { return test; }
	 * 
	 * public void setTest(DiagnosticTest test) { this.test = test; }
	 */

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Appointment [userId=" + userId + ", appointmentId=" + appointmentId + ", centerId=" + centerId
				+ ", testId=" + testId + ", dateTime=" + dateTime + ", approved=" + approved + "]";
	}

}
