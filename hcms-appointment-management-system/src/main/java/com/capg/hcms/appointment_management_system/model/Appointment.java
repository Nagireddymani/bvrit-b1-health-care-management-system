package com.capg.hcms.appointment_management_system.model;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Appointment {

	private String userId;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long appointmentId;

	private String centerId;

	private String testId;

	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime dateTime;


	private boolean approved = false;


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public long getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}


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


	public Appointment(String userId, long appointmentId, String centerId, String testId, LocalDateTime dateTime,
			boolean approved) {
		super();
		this.userId = userId;
		this.appointmentId = appointmentId;
		this.centerId = centerId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.approved = approved;
	}


	public Appointment() {
		super();
		
	}

	


	


}
