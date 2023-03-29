package com.ssafy.education.organization;

import java.util.ArrayList;
import java.util.List;

public class OrganizationMgrImpl implements OrganizationMgr {
	private List<Organization> orgs;
	
	public OrganizationMgrImpl() {
		orgs=new ArrayList<Organization>();
		
		// 사무국 생성
		orgs.add(new Secretariat("사무국", 1150, "전국"));
		// 캠퍼스 생성
		orgs.add(new Campus("서울", 550, "101", 50, 5));
		orgs.add(new Campus("대전", 240, "201", 30, 10));
		orgs.add(new Campus("구미",  120, "301", 10, 2));
		orgs.add(new Campus("광주", 120, "401", 15, 5));
		orgs.add(new Campus("부울경", 120, "501", 15, 5));

	}
	
	@Override
	public List<Organization> search(){
		return orgs;
	}
	@Override
	public Organization search(Organization o){
		for(Organization org : orgs) {
			if(org.getName().equals(o.getName())) {
				return org;
			}
		}
		return null;
	}
}