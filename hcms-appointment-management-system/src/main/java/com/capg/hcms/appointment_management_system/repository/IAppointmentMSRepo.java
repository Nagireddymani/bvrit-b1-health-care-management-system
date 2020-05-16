package com.capg.hcms.appointment_management_system.repository;


import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.appointment_management_system.model.Appointment;



/*******************************************************************************************************************************
-Author                   :     Boola Rohan, Rishita Kalidindi
-Created/Modified Date    :     22-04-2020
-Description              :     AppointmentRepo interface acting as repository with Appointment class a type and BigInteger as ID
*******************************************************************************************************************************/

public interface IAppointmentMSRepo extends JpaRepository<Appointment, BigInteger> {
  
  public Appointment getAppointmentByDateTimeAndTestId(LocalDateTime dateTime,String testId);

 
  
}
