package com.ssafy.education.subject;

import java.util.Arrays;

public class SubjectsMgrImpl implements SubjectsMgr {
	private Subject[] subjects;
	private int index;
	
	public SubjectsMgrImpl() {
		subjects=new Subject[100];		
	}
	
	@Override
	public void add(Subject s) throws DuplicatedException{
		try {
			Subject subject = search(s.getName());
			if(subject.getName().equals(s.getName()))
				throw new DuplicatedException(s.getName()+": 등록된 과목입니다."); 
		} catch (NotFoundException e) {
			subjects[index++]=s;
		}
	}
	@Override
	public Subject[] search() {
		return Arrays.copyOfRange(subjects, 0, index);

	}
	@Override
	public Subject search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(subjects[i].getName().equals(name)) 
				return subjects[i];
		}
		throw new NotFoundException(name+": 미등록 과목입니다.");
	}
}
