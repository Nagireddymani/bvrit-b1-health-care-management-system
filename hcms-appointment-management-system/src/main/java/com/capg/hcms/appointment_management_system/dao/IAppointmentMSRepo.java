package com.capg.hcms.appointment_management_system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hcms.appointment_management_system.model.Appointment;

@Repository
public interface IAppointmentMSRepo extends JpaRepository<Appointment, Long> {
	
	
	public List<Appointment> findByCenter(String centerId); 

}
