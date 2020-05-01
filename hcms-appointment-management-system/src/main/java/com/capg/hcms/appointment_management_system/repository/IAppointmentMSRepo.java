package com.capg.hcms.appointment_management_system.repository;


import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.appointment_management_system.model.Appointment;

public interface IAppointmentMSRepo extends JpaRepository<Appointment, BigInteger> {
	
  public Appointment getAppointmentByDateTime(LocalDateTime dateTime);	
  
}
