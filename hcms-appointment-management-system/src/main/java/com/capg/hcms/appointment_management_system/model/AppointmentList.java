package com.capg.hcms.appointment_management_system.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     30-04-2020
-Description              :     AppointmentList Bean Class for appointmentList property

*******************************************************************************************************************************/


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
