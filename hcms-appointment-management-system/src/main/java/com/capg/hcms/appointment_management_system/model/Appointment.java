package com.capg.hcms.appointment_management_system.model;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Appointment {

	private User user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private DiagnosticTest test;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime dateTime;
	private boolean approved=false;
	
	public Appointment() {
		super();
	}
	
	public Appointment(User user, long appointmentId, DiagnosticTest test, LocalDateTime dateTime, boolean approved) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.dateTime = dateTime;
		this.approved = approved;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public DiagnosticTest getTest() {
		return test;
	}
	public void setTest(DiagnosticTest test) {
		this.test = test;
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
		return "Appointment [user=" + user + ", appointmentId=" + appointmentId + ", test=" + test + ", dateTime="
				+ dateTime + ", approved=" + approved + "]";
	}
	
	

}
