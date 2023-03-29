package com.ssafy.education.app;

import java.io.FileNotFoundException;
import java.util.*;

import com.ssafy.education.organization.Campus;
import com.ssafy.education.organization.Organization;
import com.ssafy.education.organization.OrganizationMgr;
import com.ssafy.education.organization.OrganizationMgrImpl;
import com.ssafy.education.person.*;
import com.ssafy.education.subject.*;

public class MainTest {
	public static void main(String[] args) {
		////////////////////////////////////////////////////////////
		// main() 메서드는 주석문 해제와 관련된 부분을 제외하고는 수정하는 부분이 없습니다! //
		////////////////////////////////////////////////////////////
		
		
		
		// 00.서술형 문제 //
		//
		//	서술형 문제의 정답은 프로젝트 폴더의 report.txt 파일에 
		//	내용을 작성하여 제출하세요!
		//
		
		

		// 10.교육관리 문제 //
		//
		//	아래 11~13번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("10.교육관리(웹,알고리즘) =================================");
		SubjectsMgr subMgr=new SubjectsMgrImpl();
		System.out.println();		
		
		System.out.println("11.과목 등록");
		// 정상 출력 예: 
		// 11.과목 등록
		// JAVA: 등록된 과목입니다.
		try {
			subMgr.add(new Algo(new String("알고리즘"), 8, "IM")); 
			subMgr.add(new Web(new String("JAVA"), 15, 20)); 
			subMgr.add(new Web(new String("JAVA"), 26, 18));
		} catch (DuplicatedException e) { 
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		System.out.println("12.등록 과목 전체검색");
		// 정상 출력 예: 
		// 12.등록 과목 전체검색
		// 알고리즘	8	IM
		// JAVA		15	20
		
		Subject[] subs=subMgr.search();
		for(Subject s:subs) {
			System.out.println(s); 
		}
		System.out.println();
		
		
		System.out.println("13.Vue.js과목 조회");
		// 정상 출력 예: 
		// 13.Vue.js과목 조회
		// Vue.js: 미등록 과목입니다.
		try {
			Subject s=subMgr.search("Vue.js"); 
			System.out.println(s);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		
		
		// 20.교육생관리 문제 //
		//
		//	아래 21~25번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("20.교육생관리(교수,교육생) ==================================");
		PersonMgr pmgr=PersonMgrImpl.getInstance(); 
		System.out.println();		
		
		System.out.println("21.교수, 교육생 등록");
		// 정상 출력 예: 
		// 21.교수, 교육생 등록
		// 등록정상

		pmgr.add(new Teacher( "오싸피",41,"010-1010-0010","101","li001"));
		pmgr.add(new Student("오싸피",35,"010-0505-0005","JAVA","101",true));
		pmgr.add(new Teacher( "이교수",42,"010-2020-0020","101","li002"));
		pmgr.add(new Teacher( "김교수",43,"010-3030-0030","102","li003"));
		pmgr.add(new Student("이학생",32,"010-0202-0002","Spring","901",false));
		pmgr.add(new Student("강학생",23,"010-0303-0003","알고리즘","902",true));
		System.out.println("등록정상");
		System.out.println();
		
		
		System.out.println("22.교육 참여인 전체검색");
		// 정상 출력 예: 수정 내용 없음
		// 22.교육 참여인 전체검색
		// 오싸피		41	010-1010-0010	101	li001
		// 오싸피		35	010-0505-0005	JAVA	101	true
		// 이교수		42	010-2020-0020	101	li002
		// 김교수		43	010-3030-0030	102	li003
		// 이학생		32	010-0202-0002	Spring	901	false
		// 강학생		23	010-0303-0003	알고리즘	902	true
		List<Person> people=pmgr.search();
		for(Person p : people) {
			System.out.println(p);
		}
		System.out.println();
		
		
		System.out.println("23.오싸피 이름 모두 삭제");
		// 정상 출력 예: 
		// 23.오싸피 이름 모두 삭제
		// 이교수		42	010-2020-0020	101	li002
		// 김교수		43	010-3030-0030	102	li003
		// 이학생		32	010-0202-0002	Spring	901	false
		// 강학생		23	010-0303-0003	알고리즘	902	true
		pmgr.delete("오싸피"); 
		for(Person p : pmgr.search()) System.out.println(p);
		System.out.println();
		
		
		System.out.println("24.교육 참여인 정보 people.dat 파일에 저장");
		// 정상 출력 예: 
		// 24.교육 참여인 정보 people.dat 파일에 저장
		// 저장정상
		pmgr.save(); 
		System.out.println("저장정상");
		System.out.println();
		
		
		System.out.println("25.교육 참여인 정보 people.dat 파일에서 로드");
		// 정상 출력 예: 
		// 25.교육 참여인 정보 people.dat 파일에서 로드
		// 이교수		42	010-2020-0020	101	li002
		// 김교수		43	010-3030-0030	102	li003
		// 이학생		32	010-0202-0002	Spring	901	false
		// 강학생		23	010-0303-0003	알고리즘	902	true
		pmgr.load(); 
		for(Person p : pmgr.search()) System.out.println(p);
		System.out.println();
		
		
		// 30.기관관리 문제 //
		//
		//	아래 31~33번 주석을 해제하여
		//	"정상 출력 예" 와 같이 출력될 수 있도록 
		//	코드들을 디버깅 하세요!
		//
		System.out.println("30.캠퍼스관리(사무국, 지역캠퍼스) ===============================");
		OrganizationMgr omgr=new OrganizationMgrImpl(); 
		System.out.println();
		

		System.out.println("31.캠퍼스 전체검색");
		// 정상 출력 예: 
		// 31.캠퍼스 전체검색
		// 사무국		1150	전국
		// 서울		550	101	50	5
		// 대전		240	201	30	10
		// 구미		120	301	10	2
		// 광주		120	401	15	5
		// 부울경		120	501	15	5
		List<Organization> orgs=omgr.search();
		for(Organization org : orgs) {
			System.out.println(org);
		}
		System.out.println();
		
		
		System.out.println("32.캠퍼스 학생수(studentCount) 오름차순 정렬");
		// 정상 출력 예: 
		// 32.캠퍼스 학생수(studentCount) 오름차순 정렬
		// 구미		120	301	10	2
		// 광주		120	401	15	5
		// 부울경		120	501	15	5
		// 대전		240	201	30	10
		// 서울		550	101	50	5
		// 사무국		1150	전국
		Collections.sort(orgs);
		for(Organization org : orgs) {
			System.out.println(org);
		}
		System.out.println();
		
		
		System.out.println("33.구미 캠퍼스 조회(캠퍼스 이름이 같으면 조회)");
		// 정상 출력 예: 
		// 33.구미 캠퍼스 조회(캠퍼스 이름이 같으면 조회)
		// 구미	120	301	10	2
		Organization org=omgr.search(new Campus("구미", 15, "001", 50, 5)); 
		System.out.println(org);
		System.out.println();
		
	}
}
