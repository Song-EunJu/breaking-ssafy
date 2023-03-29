package com.ssafy.education.organization;

import java.util.List;

public interface OrganizationMgr {
	List<Organization> search();
	Organization search(Organization o);
}