package com.capg.hcms.healthcaremanagementsystem.service;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.hcms.healthcaremanagementsystem.model.Appointment;
import com.capg.hcms.healthcaremanagementsystem.model.AppointmentList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenter;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticCenterList;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTest;
import com.capg.hcms.healthcaremanagementsystem.model.DiagnosticTestList;
import com.capg.hcms.healthcaremanagementsystem.model.User;
import com.capg.hcms.healthcaremanagementsystem.model.UserList;

@Service
public class HealthCareServiceImpl implements IHealthCareService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) throws RestClientException, URISyntaxException {
		// return
		// restTemplate.postForEntity("http://diagnostic-center-ms/center/addcenter",
		// center, DiagnosticCenter.class);

		DiagnosticCenter newcenter = restTemplate.postForObject("http://diagnostic-center-ms/center/addcenter", center,
				DiagnosticCenter.class);

		if (newcenter.getCenterId() == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		
		addTest(newcenter.getCenterId(), new DiagnosticTest("Blood Pressure", ""));
		addTest(newcenter.getCenterId(), new DiagnosticTest("Blood Sugar", ""));
		
		return newcenter;
	}

	@Override
	public boolean removeCenter(String centerId) {

		DiagnosticCenter center = getCenterById(centerId);

		List<String> tests = center.getTests();
		List<BigInteger> appointments = center.getAppointments();

		for (String testId : tests) {
			removeTestById(testId);
		}
		for (BigInteger appointmentId : appointments) {
			removeAppointmentById(appointmentId);
		}

		restTemplate.delete("http://diagnostic-center-ms/center/removecenter/center-id/" + centerId);
		return true;
	}

	@Override
	public DiagnosticTest addTest(String centerId, DiagnosticTest test) throws RestClientException, URISyntaxException {

		List<DiagnosticTest> testList = getAllTestsByCenterId(centerId).getTestList();

		for (DiagnosticTest tests : testList) {
			if (test.getTestName().equals(tests.getTestName()))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		DiagnosticTest newtest = restTemplate.postForObject("http://diagnostic-test-ms/test/addtest", test,
				DiagnosticTest.class);

		restTemplate.put(new URI(
				"http://diagnostic-center-ms/center/assign-testid/" + centerId + "/test-id/" + newtest.getTestId()),
				null);
		return newtest;
	}

	@Override
	public boolean removeTest(String centerId, String testId) throws RestClientException, URISyntaxException {

		restTemplate.delete("http://diagnostic-test-ms/test/removetest/test-id/" + testId);

		restTemplate.put(new URI("http://diagnostic-center-ms/center/remove-testid/" + centerId + "/test-id/" + testId),
				null);

		return true;
	}

	@Override
	public Appointment makeAppointment(String centerId, Appointment appointment)
			throws RestClientException, URISyntaxException {

		Appointment newappointment = restTemplate.postForObject("http://appointment-ms/appointment/makeappointment",
				appointment, Appointment.class);

		restTemplate.put(new URI("http://diagnostic-center-ms/center/assign-appointmentid/" + centerId
				+ "/appointment-id/" + newappointment.getAppointmentId()), null);

		return newappointment;
	}

	@Override
	public Appointment getAppointment(BigInteger appointmentId) {

		return restTemplate.getForObject("http://appointment-ms/appointment/getappointment/" + appointmentId,
				Appointment.class);

	}

	@Override
	public User addUser(User user) {
		User newUser = restTemplate.postForObject("http://register-ms/register/adduser", user, User.class);

		if (newUser.getUserId() == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

		return newUser;

	}

	@Override
	public DiagnosticCenterList getAllCenters() {

		return restTemplate.getForObject("http://diagnostic-center-ms/center/getallcenters",
				DiagnosticCenterList.class);

	}

	@Override
	public DiagnosticTestList getAllTests() {

		return restTemplate.getForObject("http://diagnostic-test-ms/test/getalltests", DiagnosticTestList.class);

	}

	@Override
	public AppointmentList getAllAppointments() {

		return restTemplate.getForObject("http://appointment-ms/appointment/getallappointments", AppointmentList.class);

	}

	@Override
	public UserList getAllUsers() {

		return restTemplate.getForObject("http://register-ms/register/getallusers", UserList.class);

	}

	@Override
	public Appointment approvementAppointment(BigInteger appointmentId, boolean status) {

		restTemplate.put("http://appointment-ms/admin/approveAppointment/" + appointmentId + "/" + status, null);

		return getAppointment(appointmentId);
		// return
		// restTemplate.getForObject("http://localhost:8203/appointment/getappointment/"+appointmentId,
		// Appointment.class);
	}

	@Override
	public DiagnosticTestList getAllTestsByCenterId(String centerId) {

		DiagnosticCenter center = getCenterById(centerId);

		List<String> tests = center.getTests();
		List<DiagnosticTest> testList = new ArrayList<DiagnosticTest>();

		for (String testId : tests) {
			testList.add(getTestById(testId));
		}

		DiagnosticTestList diagnosticTestlist = new DiagnosticTestList(testList);

		return diagnosticTestlist;
	}

	@Override
	public DiagnosticCenter getCenterById(String centerId) {

		return restTemplate.getForObject("http://diagnostic-center-ms/center/getcenter/center-id/" + centerId,
				DiagnosticCenter.class);

	}

	@Override
	public DiagnosticTest getTestById(String testId) {

		return restTemplate.getForObject("http://diagnostic-test-ms/test/gettest/test-id/" + testId,
				DiagnosticTest.class);

	}

	@Override
	public AppointmentList getAllAppointmentByCenterId(String centerId) {

		DiagnosticCenter center = getCenterById(centerId);

		List<BigInteger> appointments = center.getAppointments();
		List<Appointment> appointmentList = new ArrayList<Appointment>();

		for (BigInteger appointmentId : appointments) {
			appointmentList.add(getAppointment(appointmentId));
		}

		AppointmentList newAppointmentList = new AppointmentList(appointmentList);

		return newAppointmentList;
	}

	@Override
	public boolean removeTestById(String testId) {

		restTemplate.delete("http://diagnostic-test-ms/test/removetest/test-id/" + testId);

		return true;
	}

	@Override
	public boolean removeAppointmentById(BigInteger appointmentId) {

		restTemplate.delete("http://appointment-ms/appointment/removeappointment-centerid/" + appointmentId);

		return true;
	}

	@Override
	public User validateUser(String userName, String userPassword) {
		return restTemplate.getForObject(
				"http://register-ms/register/validateuser/username/" + userName + "/userpassword/" + userPassword,
				User.class);
	}

	@Override
	public User getUserById(String userId) {

		return restTemplate.getForObject("http://register-ms/register/getuser/user-id/" + userId, User.class);
	}

}
