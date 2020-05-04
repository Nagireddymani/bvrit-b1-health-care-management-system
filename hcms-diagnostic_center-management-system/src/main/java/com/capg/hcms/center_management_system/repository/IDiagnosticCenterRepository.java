package com.capg.hcms.center_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.center_management_system.model.DiagnosticCenter;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     22-04-2020
-Description              :     DiagnosticCenter Repository Interface with DiagnosticCenter as Type and String as Key

*******************************************************************************************************************************/


public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, String>{
	
	public DiagnosticCenter getByCenterName(String centerName);

}
