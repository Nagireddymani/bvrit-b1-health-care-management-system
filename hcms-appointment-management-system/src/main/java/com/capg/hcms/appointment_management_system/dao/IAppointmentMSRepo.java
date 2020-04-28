package com.capg.hcms.appointment_management_system.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hcms.appointment_management_system.model.Appointment;

@Repository
public interface IAppointmentMSRepo extends JpaRepository<Appointment, Long> {

}
