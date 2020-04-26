package com.capg.hcms.appointment_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.hcms.appointment_management_system.dao.IAppointmentMSRepo;
import com.capg.hcms.appointment_management_system.model.Appointment;

@Service
@Repository
public class AppointmentMSServiceImp implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo udao;
	
	@Override
	public long makeAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(readOnly=true)
	public Appointment getAppointment(long appointmentId) {
		
		 return udao.findById(appointmentId).get();
		 
	}

	@Override
	@Transactional(readOnly=true)
	public List<Appointment> getAllAppointments() {
	
		return udao.findAll();
		
	}

	@Override
	public Appointment updateAppointment(Appointment a) {
		 Appointment ud=udao.findById(a.getAppointmentId()).get();
 		if(ud!=null)
 		{
 			ud.setAppointmentStatus(a.getAppointmentStatus());
 			ud.setDateTime(a.getDateTime());
 		}
 		return udao.save(ud);
	}

}
