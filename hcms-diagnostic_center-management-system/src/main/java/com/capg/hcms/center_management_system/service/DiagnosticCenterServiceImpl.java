package com.capg.hcms.center_management_system.service;

import java.math.BigInteger;
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
	
	/*******************************************************************************************************************************
	-Function Name            :     getAllCenters
	-Input Parameters         :     No Input
	-Return Type              :     DiagnosticCenterList object
	-Throws                   :     CenterListIsEmptyException
	-Author                   :     N.ManikaataReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     getting all centers present in the Center Database
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenterList getAllCenters() {
		
		if(centerRepo.findAll().isEmpty()) {
			throw new CenterListIsEmptyException("CenterList Is Empty");
		}
		
		return new DiagnosticCenterList(centerRepo.findAll());
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     addCenter
	-Input Parameters         :     Center Object
	-Return Type              :     added Center object
	-Throws                   :     CenterNameAlreadyExistException();
	-Author                   :     N.ManikantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     adding Center to the Center Database Table using Spring Data
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center) {
		
		center.setCenterId(Integer.toString(random.nextInt(10000000)).substring(0,5));
			
		if(centerRepo.getByCenterName(center.getCenterName())!=null) {
			throw new CenterNameAlreadyExistException("Center with Name"+center.getCenterName()+" Already Exist");
		
		}		
		return centerRepo.save(center);
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     removeCenter
	-Input Parameters         :     Center Object
	-Return Type              :     boolean
	-Throws                   :     CenterNotFoundException
	-Author                   :     N.ManikantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     removing Specified Center from Center DataBase Table.

	*******************************************************************************************************************************/
	@Override
	public boolean removeCenter(DiagnosticCenter center) {
		
		if(!centerRepo.existsById(center.getCenterId()))
 			throw new CenterNotFoundException("Center with Id :" + center.getCenterId()+" is Not Found");
		
		centerRepo.delete(center);
		
		return !centerRepo.existsById(center.getCenterId());
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     getCenterById
	-Input Parameters         :     centerId (String) 
	-Return Type              :     DiagnosticCenter Object
	-Throws                   :     CenterNotFoundException
	-Author                   :     N.ManiKantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     getting Diagnostic Center based on centerId from Center DataBase Table
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter getCenterById(String centerId) {
	
		if(!centerRepo.existsById(centerId))
 			throw new CenterNotFoundException("Center with Id :" + centerId+" is Not Found");
		
		return centerRepo.getOne(centerId);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     assignTestId
	-Input Parameters         :     centerId(String), testId(String)
	-Return Type              :     updated DiagnosticCenter Object
	-Throws                   :     NoException
	-Author                   :     N.ManiKantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     adding testId Into tests Property of DiagnosticCenter of particular centerId
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter assignTestId(String centerId, String testId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getTests().add(testId);
		
		return centerRepo.save(center);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     assignAppointmentId
	-Input Parameters         :     centerId(String), appointmentId(BigInteger)
	-Return Type              :     updated DiagnosticCenter Object
	-Throws                   :     NoException
	-Author                   :     N.ManikantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     adding appointmentId Into appointments Property of DiagnosticCenter of particular centerId
	*******************************************************************************************************************************/
	@Override
	public DiagnosticCenter assignAppointmentId(String centerId, BigInteger appointmentId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getAppointments().add(appointmentId);
		
		return centerRepo.save(center);
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     removetTestId
	-Input Parameters         :     centerId(String), testId(String) 
	-Return Type              :     boolean
	-Throws                   :     NoException
	-Author                   :     N.ManikantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     removing testId from tests Property of DiagnosticCenter of particular centerId.
	                                (This Method is done in parallel while removing Test from DiagonisticTest Database Table
	*******************************************************************************************************************************/
	@Override
	public boolean removeTestId(String centerId, String testId) {
		
		DiagnosticCenter center=centerRepo.getOne(centerId);
		
		center.getTests().remove(testId);
		
		centerRepo.save(center);
		
		return true;
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     removeAllCenters
	-Input Parameters         :     No Input
	-Return Type              :     boolean
	-Throws                   :     NoException
	-Author                   :     N.ManikantaReddy
	-Created/Modified Date    :     4-05-2020
	-Description              :     removing all diagnosticCenters from Center Database.
	                                (It is not required according to CaseStudy)
	*******************************************************************************************************************************/
	@Override
	public boolean removeAllCenters() {
		
		centerRepo.deleteAll();
		
		return true;
	}
	
	
}
