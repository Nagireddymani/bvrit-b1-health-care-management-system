package com.capg.hcms.healthcaremanagementsystem.service;

import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.client.RestClientException;

import com.capg.hcms.healthcaremanagementsystem.model.Appointment;
import com.capg.hcms.healthcaremanagementsystem.model.AppointmentList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenter;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenterList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTest;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTestList;
import com.capg.hcms.healthcaremanagementsystem.model.User;
import com.capg.hcms.healthcaremanagementsystem.model.UserList;

public interface IHealthCareService {

	DiagnosticCenter addCenter(DiagnosticCenter center);
	boolean removeCenter(String centerId);
	DiagnosticCenterList getAllCenters();
	DiagnosticCenter getCenterById(String centerId);
	
	DiagnosticTest addTest(String centerId,DiagnosticTest test) throws RestClientException, URISyntaxException;
	boolean removeTest(String centerId,String testId) throws RestClientException, URISyntaxException;
	DiagnosticTestList getAllTests();
	DiagnosticTest getTestById(String testId);
	boolean removeTestById(String testId);
	
	Appointment makeAppointment(String centerId,Appointment appointment) throws RestClientException, URISyntaxException;
	Appointment getAppointment(BigInteger appointmentId);
	AppointmentList getAllAppointments();
	Appointment approvementAppointment(BigInteger appointmentId,boolean status);
	boolean removeAppointmentById(BigInteger appointmentId);
	
	User addUser(User user);
    UserList getAllUsers();
    
    DiagnosticTestList getAllTestsByCenterId(String centerId);
    
    AppointmentList getAllAppointmentByCenterId(String centerId);
    
}
