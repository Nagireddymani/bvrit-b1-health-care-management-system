package com.capg.hcms.center_management_system.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.center_management_system.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center_management_system.exception.CenterNotFoundException;
import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.repository.IDiagnosticCenterRepository;

@Service
public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {

    @Autowired
	private IDiagnosticCenterRepository centerRepo;
	
	private Random random=new Random();
	
	@Override
	public List<DiagnosticCenter> getAllCenters() {
		return centerRepo.findAll();
	}

	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		center.setCenterId(Integer.toString(random.nextInt(10000000)).substring(0,5));
		if(centerRepo.getByCenterName(center.getCenterName())!=null)
			throw new CenterNameAlreadyExistException("Center with Name :" + center.getCenterName()+" is Already Exist");
		return centerRepo.save(center);
	}

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		centerRepo.delete(center);
		System.out.println("incenterService");
		return !centerRepo.existsById(center.getCenterId());
	}

	@Override
	public DiagnosticCenter getCenter(String centerId) {
		if(!centerRepo.existsById(centerId))
 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
		return centerRepo.getOne(centerId);
	}
	
	@Override
	public DiagnosticCenter updateCenter(DiagnosticCenter center) {
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		DiagnosticCenter newCenter=centerRepo.getOne(center.getCenterId());
		newCenter.setCenterName(center.getCenterName());
		newCenter.setTests(center.getTests());
		newCenter.setAppointment(center.getAppointments());
		
		centerRepo.save(newCenter);
		return newCenter;
	}

	@Override
	public DiagnosticCenter assignCenter(String centerId, String testId) {
		DiagnosticCenter center=centerRepo.getOne(centerId);
		center.getTests().add(testId);
		return centerRepo.save(center);
	}

	@Override
	public DiagnosticCenter assignAppointment(String centerId, BigInteger appointmentId) {
		DiagnosticCenter newCenter=centerRepo.getOne(centerId);
		newCenter.getAppointments().add(appointmentId);
		System.out.println("incenterService");
		return centerRepo.save(newCenter);
	}

	@Override
	public boolean removeCenterId(String centerId, String testId) {
		DiagnosticCenter center=centerRepo.getOne(centerId);
		center.getTests().remove(testId);
		centerRepo.save(center);
		return true;
	}
	
	
}
