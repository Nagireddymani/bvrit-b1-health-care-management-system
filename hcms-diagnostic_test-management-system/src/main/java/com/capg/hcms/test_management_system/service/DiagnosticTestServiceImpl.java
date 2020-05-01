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

@Service
public class DiagnosticTestServiceImpl implements IDiagnosticTestService{
	
    @Autowired
	IDiagnosticTestRepo repo;
    Random random=new Random();
    
    public DiagnosticTest addTest(DiagnosticTest test) {
    	if(repo.existsById(test.getTestName())) {
			throw new TestAlreadyExistException("["+test.getTestName()+"] already exists");
		}
    	test.setTestId(Integer.toString(random.nextInt(10000000)).substring(0,5));
		return repo.save(test);
	}
    
	public boolean removeTest(DiagnosticTest test) {
		if(!repo.existsById(test.getTestId())) {
			throw new TestNotFoundException("["+test.getTestId()+"] is Not Found"); 
		}
	    repo.deleteById(test.getTestId());
	    
	    return (!repo.existsById(test.getTestId()));
	}
	
	public List<DiagnosticTest> getAlltest(){
//		if(repo.findAll().isEmpty()) {
//			throw new ListisEmptyException("List is empty");
//		}
		return repo.findAll();
	}

	@Override
	public DiagnosticTest getTest(String testId) {
		return repo.getOne(testId);
	}
}
