package com.ssafy.trip.model.dto;

public class TripSearchDto {

	/** 검색 조건 관광지명 */
	private String touristDestination;
	/** 검색 조건 도로명 주소 시도 */
	private String sido;

	public String getTouristDestination() {
		return touristDestination;
	}

	public void setTouristDestination(String touristDestination) {
		this.touristDestination = touristDestination;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	@Override
	public String toString() {
		return "TripSearchDto [touristDestination=" + touristDestination + ", sido=" + sido + "]";
	}

}
