package com.capg.hcms.test_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.test_management_system.model.DiagnosticTest;

public interface IDiagnosticTestRepo extends JpaRepository<DiagnosticTest, String>{

}
