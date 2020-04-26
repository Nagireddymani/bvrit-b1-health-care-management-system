package com.capg.hcms.appointment_management_system.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Appointment")
public class Appointment {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appointment_id")
	private User user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;

	private DiagnosticTest test;
	

	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime dateTime;

	// private boolean approved=false;
	private String appointmentStatus;

	public Appointment() {
		super();
	}

	public Appointment(User user, long appointmentId, DiagnosticTest test, LocalDateTime dateTime,
			String appointmentStatus) {
		super();
		this.user = user;
		this.appointmentId = appointmentId;
		this.test = test;
		this.dateTime = dateTime;
		this.appointmentStatus = appointmentStatus;
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

	/*
	 * public boolean isApproved() { return approved; } public void
	 * setApproved(boolean approved) { this.approved = approved; }
	 */

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	@Override
	public String toString() {
		return "Appointment [user=" + user + ", appointmentId=" + appointmentId + ", test=" + test + ", dateTime="
				+ dateTime + ", appointmentStatus=" + appointmentStatus + "]";
	}

}
