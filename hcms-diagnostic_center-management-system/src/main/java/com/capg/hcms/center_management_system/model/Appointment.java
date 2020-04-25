package com.capg.hcms.center_management_system.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Appointment {

	private BigInteger appointmentId;
	private LocalDateTime dateTime;
	private boolean approved;
	private User user;
	private DiagnosticTest test;
	public Appointment() {
		super();
	}
	public Appointment(BigInteger appointmentId, LocalDateTime dateTime, boolean approved, User user,
			DiagnosticTest test) {
		super();
		this.appointmentId = appointmentId;
		this.dateTime = dateTime;
		this.approved = approved;
		this.user = user;
		this.test = test;
	}
	public BigInteger getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public DiagnosticTest getTest() {
		return test;
	}
	public void setTest(DiagnosticTest test) {
		this.test = test;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateTime=" + dateTime + ", approved=" + approved
				+ ", user=" + user + ", test=" + test + "]";
	}
	
	
	
	
	
}
