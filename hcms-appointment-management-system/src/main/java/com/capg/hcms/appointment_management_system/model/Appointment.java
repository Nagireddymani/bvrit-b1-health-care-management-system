package com.capg.hcms.appointment_management_system.model;


import java.math.BigInteger;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     22-04-2020
-Description              :     Appointment Bean Class

*******************************************************************************************************************************/

@Entity
@Table(name = "appointment_info")
public class Appointment {

	
	private String userId;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private BigInteger appointmentId;
	private String testId;
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime dateTime;
	private boolean approved = false;

	public Appointment(String userId, BigInteger appointmentId, String testId, LocalDateTime dateTime,
			boolean approved) {
		super();
		this.userId = userId;
		this.appointmentId = appointmentId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.approved = approved;
	}


	public Appointment() {
		super();
		
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
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
		return "Appointment [userId=" + userId + ", appointmentId=" + appointmentId 
				+ ", testId=" + testId + ", dateTime=" + dateTime + ", approved=" + approved + "]";
	}

	

}
