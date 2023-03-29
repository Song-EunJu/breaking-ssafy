package com.ssafy.trip;

public class EnjoyTripException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EnjoyTripException() {
		super("데이타를 처리 중 오류 발생");
	}

	public EnjoyTripException(String msg) {
		super(msg);
	}
}
