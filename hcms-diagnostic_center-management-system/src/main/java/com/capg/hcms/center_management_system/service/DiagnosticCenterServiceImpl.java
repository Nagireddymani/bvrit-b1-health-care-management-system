package com.capg.hcms.center_management_system.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.center_management_system.exception.CenterListIsEmptyException;
import com.capg.hcms.center_management_system.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center_management_system.exception.CenterNotFoundException;
import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.model.DiagnosticCenterList;
import com.capg.hcms.center_management_system.repository.IDiagnosticCenterRepository;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     01-05-2020
-Description              :     DiagnosticCenterServiceImpl Class implements services for DiagnosticCenter Management System

*******************************************************************************************************************************/

@Service
public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {

    @Autowired
	private IDiagnosticCenterRepository centerRepo;
	@Autowired
    private Random random;
	
	@Override
	public DiagnosticCenterList getAllCenters() {
		
		if(centerRepo.findAll().isEmpty()) {
			throw new CenterListIsEmptyException("CenterList Is Empty");
		}
		
		return new DiagnosticCenterList(centerRepo.findAll());
	}

	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		
		center.setCenterId(Integer.toString(random.nextInt(10000000)).substring(0,5));
		
		if(centerRepo.getByCenterName(center.getCenterName())!=null) {
			throw new CenterNameAlreadyExistException("Center with Name :" + center.getCenterName()+" is Already Exist");
		}
		
		return centerRepo.save(center);
	}

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		
		centerRepo.delete(center);
		
		return !centerRepo.existsById(center.getCenterId());
	}

	@Override
	public DiagnosticCenter getCenterById(String centerId) {
	
		if(!centerRepo.existsById(centerId))
 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
		
		return centerRepo.getOne(centerId);
	}
	
	@Override
	public DiagnosticCenter assignTestId(String centerId, String testId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getTests().add(testId);
		
		return centerRepo.save(center);
	}

	@Override
	public DiagnosticCenter assignAppointmentId(String centerId, BigInteger appointmentId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getAppointments().add(appointmentId);
		
		return centerRepo.save(center);
	}

	@Override
	public boolean removeTestId(String centerId, String testId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getTests().remove(testId);
		
		centerRepo.save(center);
		
		return true;
	}

	@Override
	public boolean removeAllCenters() {
		
		centerRepo.deleteAll();
		
		return true;
	}
	
	
}
