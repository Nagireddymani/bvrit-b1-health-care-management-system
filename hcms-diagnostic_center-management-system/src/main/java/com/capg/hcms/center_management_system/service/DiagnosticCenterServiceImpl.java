package com.capg.hcms.center_management_system.service;

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
		center.setCenterId(Integer.toString(random.nextInt(10000000)));
		if(centerRepo.getByCenterName(center.getCenterName())!=null)
			throw new CenterNameAlreadyExistException("Center with Name :" + center.getCenterName()+" is Already Exist");
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
		newCenter.setTest(center.getTest());
		newCenter.setAppointment(center.getAppointment());
		
		centerRepo.save(newCenter);
		return newCenter;
	}
}
