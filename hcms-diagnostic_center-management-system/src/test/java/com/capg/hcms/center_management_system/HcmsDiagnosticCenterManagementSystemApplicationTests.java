package com.capg.hcms.center_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.center_management_system.controller.DiagnosticCenterController;
import com.capg.hcms.center_management_system.model.DiagnosticCenter;
import com.capg.hcms.center_management_system.repository.IDiagnosticCenterRepository;
import com.capg.hcms.center_management_system.service.DiagnosticCenterServiceImpl;

@SpringBootTest
class HcmsDiagnosticCenterManagementSystemApplicationTests {

	@Autowired
	IDiagnosticCenterRepository repo;
	@Autowired
	DiagnosticCenterServiceImpl service;
	DiagnosticCenter center;
	
	@BeforeEach
	public void init()
	{
		center=new DiagnosticCenter("45245","reddy's CLinic",null, null);
	}
	
	@Test
	public void testAddCenter()
	{
		service.addCenter(center);
		assertEquals(true,repo.getByCenterName("reddy's CLinic")!=null);
	}
	
	@Test
	public void testRemoveCenter()
	{
		service.removeCenter(center);
		assertEquals(false,repo.getByCenterName("reddy's CLinic")!=null);
	}

}
