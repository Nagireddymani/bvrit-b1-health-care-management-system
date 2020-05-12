package com.capg.hcms.test_management_system.service;



import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.test_management_system.exception.ListisEmptyException;
import com.capg.hcms.test_management_system.exception.TestAlreadyExistException;
import com.capg.hcms.test_management_system.exception.TestNotFoundException;
import com.capg.hcms.test_management_system.model.DiagnosticTest;
import com.capg.hcms.test_management_system.repository.IDiagnosticTestRepo;

/*******************************************************************************************************************************
-Author                   :     Ashritha
-Created/Modified Date    :     4-05-2020
-Description              :     DiagnosticTestServiceImpl Class implements services for DiagnosticTest Management System
*******************************************************************************************************************************/

@Service
public class DiagnosticTestServiceImpl implements IDiagnosticTestService{
	
    @Autowired
	IDiagnosticTestRepo testRepo;
    @Autowired
    Random random;

	/*******************************************************************************************************************************
	-Function Name            :     addTest
	-Input Parameters         :     Test Object
	-Return Type              :     added test object
	-Throws                   :     TestAlreadyExistException
	-Author                   :     Ashritha
	-Created/Modified Date    :     4-05-2020
	-Description              :     adding test to the database calls the method addTest(test)
	*******************************************************************************************************************************/
    
    public DiagnosticTest addTest(DiagnosticTest test) {
    	
    	test.setTestId(Integer.toString(random.nextInt(10000000)).substring(0,5));
    	
    	if(testRepo.existsById(test.getTestId())) {
			throw new TestAlreadyExistException("["+test.getTestId()+"] already exists");
		}
    	
		return testRepo.save(test);
	}
    /*******************************************************************************************************************************
    -Function Name            :     removeTest
    -Input Parameters         :     Test Object
    -Return Type              :     boolean
    -Throws                   :     TestNotFoundException
    -Author                   :     Ashritha
    -Created/Modified Date    :     4-05-2020
    -Description              :     removing test to the database calls the method removeTest(test)
    *******************************************************************************************************************************/
    
	public boolean removeTest(DiagnosticTest test) {
		
		if(!testRepo.existsById(test.getTestId())) {
			throw new TestNotFoundException("["+test.getTestId()+"] is Not Found"); 
		}
		
		testRepo.deleteById(test.getTestId());
	    
	    return !testRepo.existsById(test.getTestId());
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getAllTests
	-Input Parameters         :     -
	-Return Type              :     List of tests
	-Throws                   :     ListEmptyException
	-Author                   :     Ashritha
	-Created/Modified Date    :     4-05-2020
	-Description              :     getting all tests from the database calls the method getAllTests()
	*******************************************************************************************************************************/

	public List<DiagnosticTest> getAllTests(){
		
		if(testRepo.findAll().isEmpty()) {
			throw new ListisEmptyException("List is empty");
		}
		
		return testRepo.findAll();
	}
	
	
	/*******************************************************************************************************************************
	-Function Name            :     getTestsById
	-Input Parameters         :     testId
	-Return Type              :     test object
	-Throws                   :     TestNotFoundException
	-Author                   :     Ashritha
	-Created/Modified Date    :     4-05-2020
	-Description              :     getting a test from the database calls the method getTestById(testId)
	*******************************************************************************************************************************/

	@Override
	public DiagnosticTest getTestById(String testId) {
	
		if(!testRepo.existsById(testId)) {
			throw new TestNotFoundException("["+testId+"] is Not Found"); 
		}
		
		return testRepo.getOne(testId);
	
	}
	

	/*******************************************************************************************************************************
	-Function Name            :     removeAllTests
	-Input Parameters         :     -
	-Return Type              :     boolean
	-Throws                   :     -
	-Author                   :     Ashritha
	-Created/Modified Date    :     4-05-2020
	-Description              :     removing all tests from the database calls the method removeAllTests()
	*******************************************************************************************************************************/
	
	@Override
	public boolean removeAllTests() {
	
		testRepo.deleteAll();
		
		return true;
	}
}
