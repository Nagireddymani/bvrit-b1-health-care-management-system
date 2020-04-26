package com.capg.hcms.appointment_management_system.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.appointment_management_system.model.Appointment;

public interface IAppointmentMSRepo extends JpaRepository<Appointment, Long> {

}
