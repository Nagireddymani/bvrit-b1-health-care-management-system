package com.capg.hcms.center_management_system.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     30-04-2020
-Description              :     DiagnosticCenterList Class with centerList Property

*******************************************************************************************************************************/

public class DiagnosticCenterList {

	private List<DiagnosticCenter> centerList;
	
	public DiagnosticCenterList() {
		super();
	}

	public DiagnosticCenterList(List<DiagnosticCenter> centerList) {
		super();
		this.centerList = centerList;
	}

	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}

	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}
	
}
