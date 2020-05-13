package com.capg.hcms.center_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.center_management_system.exception.CenterNameAlreadyExistException;
import com.capg.hcms.center_management_system.exception.CenterNotFoundException;
import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.repository.IDiagnosticCenterRepository;
import com.capg.hcms.center_management_system.service.DiagnosticCenterServiceImpl;

/*******************************************************************************************************************************
-Author                   :     N.ManiKantaReddy
-Created/Modified Date    :     08-05-2020
-Description              :     JUnit TestCases for addCenter and removeCenter Units
                                 in DiagnosticCenter Ms

*******************************************************************************************************************************/

@SpringBootTest
class HcmsDiagnosticCenterManagementSystemApplicationTests {
    
	@Autowired
	IDiagnosticCenterRepository repo;
	
	@Autowired
	DiagnosticCenterServiceImpl service;
	DiagnosticCenter center1;
	DiagnosticCenter center2;
	DiagnosticCenter center3;
	
	@BeforeEach
	public void init()
	{
		List<String> tests=new ArrayList<String>();
		List<BigInteger> appointments=new ArrayList<BigInteger>();		
		center1=new DiagnosticCenter("","Rani's Clinic",tests,appointments);
		center2=new DiagnosticCenter("76348","Rohan's CLinic",null,null);
		center3=new DiagnosticCenter("88758","Vandana's Clinic",null,null);
	}
	
	@Test
	public void testAddCenter()
	{
		service.addCenter(center1);
		assertEquals(true,repo.getByCenterName("Rani's Clinic")!=null);
	}
	
	@Test
	public void testAddCenterException() {
		 
		 Assertions.assertThrows(CenterNameAlreadyExistException.class, () -> {
		      service.addCenter(center3);
		    });
	} 
	
	
// 	@Test
// 	public void testRemoveCenter()
// 	{		
// 		service.removeCenter(center2);
// 		assertEquals(false,repo.getByCenterName("Rohan's CLinic")!=null);
// 	}

	
	@Test
	public void testRemoveCenterException() {
		 Assertions.assertThrows(CenterNotFoundException.class, () -> {
		      service.removeCenter(center2);
		    });
	}
	
}
