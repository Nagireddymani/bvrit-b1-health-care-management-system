package com.capg.hcms.healthcaremanagementsystem.model;

import java.util.List;

public class AppointmentList {

	private List<Appointment> appointmentList;

	public AppointmentList() {
		super();
	}

	public AppointmentList(List<Appointment> appointmentList) {
		super();
		this.appointmentList = appointmentList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public String toString() {
		return "AppointmentList [appointmentList=" + appointmentList + "]";
	}
	
	
}
