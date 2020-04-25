package com.capg.hcms.center_management_system.service;

import java.util.List;

import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.repository.IDiagnosticCenterRepository;

public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {


	private IDiagnosticCenterRepository centerRepo;
	
	@Override
	public List<DiagnosticCenter> getAllCenters() {
		return centerRepo.findAll();
	}

	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		return centerRepo.save(center);
	}

	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		centerRepo.delete(center);
		return !centerRepo.existsById(center.getCenterId());
	}

	@Override
	public DiagnosticCenter getCenter(String centerId) {
		return centerRepo.getOne(centerId);
	}

	@Override
	public DiagnosticCenter updateCenter(DiagnosticCenter center) {
		return null;
	}

	
}
