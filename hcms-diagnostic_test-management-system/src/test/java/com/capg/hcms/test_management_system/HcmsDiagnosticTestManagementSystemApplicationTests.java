package com.capg.hcms.test_management_system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.test_management_system.exception.ListisEmptyException;
import com.capg.hcms.test_management_system.exception.TestNotFoundException;
import com.capg.hcms.test_management_system.model.DiagnosticTest;
import com.capg.hcms.test_management_system.repository.IDiagnosticTestRepo;
import com.capg.hcms.test_management_system.service.DiagnosticTestServiceImpl;

@SpringBootTest
class HcmsDiagnosticTestManagementSystemApplicationTests {
	
	@Autowired
	IDiagnosticTestRepo testRepo;
	
	@Autowired
	DiagnosticTestServiceImpl service;
	DiagnosticTest test1;
	DiagnosticTest test2;
	
	@BeforeEach
	public void init()
	{
		test1=new DiagnosticTest("", "EEG");
		test2=new DiagnosticTest("92835", "X-ray");
	}

	@Test
	public void testAddtest() {
		service.addTest(test1);
		assertEquals(true,testRepo.getByTestName(test1.getTestName())!=null);
	}
		
	@Test
	public void testRemovetest() {
		service.removeTest(test2);
		assertEquals(false, testRepo.getByTestName(test2.getTestName())!=null);
	}
	
	@Test
	public void testException() {
		
		Throwable exception = assertThrows( TestNotFoundException.class, ()->{
			service.removeTest(test1);
		}
		);
		assertEquals("["+test1.getTestId()+"] is Not Found", exception.getMessage());
	}
	
	@Test
	public void testException1() {
		Throwable exception = assertThrows( ListisEmptyException.class, ()->{
			service.getAllTests();
		}
		);
		assertEquals("List is empty", exception.getMessage());
			
	}

}
