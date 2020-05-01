package com.capg.hcms.healthcaremanagementsystem.service;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capg.hcms.healthcaremanagementsystem.model.Appointment;
import com.capg.hcms.healthcaremanagementsystem.model.AppointmentList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenter;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenterList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTest;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTestList;
import com.capg.hcms.healthcaremanagementsystem.model.User;
import com.capg.hcms.healthcaremanagementsystem.model.UserList;

@Service
public class HealthCareServiceImpl implements IHealthCareService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		return restTemplate.postForObject("http://diagnostic-center-ms/center/addcenter",center,DiagnosticCenter.class);
	}

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		System.out.println("inhealthcareService");
		restTemplate.delete("http://diagnostic-center-ms/center/deletecenter/"+center.getCenterId());
		return true;
	}

	@Override
	public DiagnosticTest addTest(String centerId,DiagnosticTest test) throws RestClientException,URISyntaxException {
	    DiagnosticTest newtest=restTemplate.postForObject("http://diagnostic-test-ms/test/addtest", test, DiagnosticTest.class);
		restTemplate.put(new URI("http://diagnostic-center-ms/center/assign/"+centerId+"/testId/"+newtest.getTestId()),null);
		return newtest;
	}
	
	@Override
	public boolean removeTest(String centerId,DiagnosticTest test) throws RestClientException, URISyntaxException {
		restTemplate.delete("http://diagnostic-test-ms/test/removetest/testId/"+test.getTestId());
		restTemplate.put(new URI("http://diagnostic-center-ms/center/removeId/"+centerId+"/testId/"+test.getTestId()), null);
		return true;
	}

	@Override
	public Appointment makeAppointment(String centerId,Appointment appointment) throws RestClientException, URISyntaxException {
		Appointment newappointment=restTemplate.postForObject("http://appointment-ms/appointment/makeappointment",appointment,Appointment.class);
		System.out.println(newappointment);
		restTemplate.put(new URI("http://diagnostic-center-ms/center/assign/"+centerId+"/appointmentId/"+newappointment.getAppointmentId()),null);
		return newappointment;
	}

	@Override
	public Appointment getAppointment(BigInteger appointmentId) {
		return restTemplate.getForObject("http://appointment-ms/appointment/getappointment/"+appointmentId, Appointment.class);
	}

	@Override
	public DiagnosticCenterList getAllCenters() {
		return restTemplate.getForObject("http://diagnostic-center-ms/center/getallcenters",DiagnosticCenterList.class);
    }

	@Override
	public DiagnosticTestList getAllTests() {
		 return restTemplate.getForObject("http://diagnostic-test-ms/test/getalltest",DiagnosticTestList.class);
	}

	@Override
	public AppointmentList getAllAppointments() {
	     return restTemplate.getForObject("http://appointment-ms/appointment/getallappointments",AppointmentList.class);
	}

	@Override
	public User addUser(User user) {
		return  restTemplate.postForObject("http://register-ms/register/adduser", user, User.class);
	}

	@Override
	public UserList getAllUsers() {
		return restTemplate.getForObject("http://register-ms/register/getallusers",UserList.class);
		
	}

	@Override
	public Appointment approvementAppointment(BigInteger appointmentId, boolean status) {
		restTemplate.put("http://appointment-ms/admin/approveAppointment/"+appointmentId+"/"+status,null );
		return getAppointment(appointmentId);
		//return restTemplate.getForObject("http://localhost:8203/appointment/getappointment/"+appointmentId, Appointment.class);
	}
		
}
