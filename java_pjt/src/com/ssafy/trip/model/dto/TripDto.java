package com.ssafy.trip.model.dto;

public class TripDto {

	/** 관광지 식별 번호 */
	private int num;
	/** 관광지명 */
	private String touristDestination;
	/** 관광지 도로명주소 */
	private String streetAddress;
	/** 관광지 지번주소 */
	private String lotAddress;
	/** 관광지 위도 */
	private double lat;
	/** 관광지 경도 */
	private double lng;
	/** 관광지 상세설명 */
	private String info;
	/** 관광지 관리 전화번호 */
	private String tel;
	/** 관광지 이미지 */
	private String img;

	public TripDto(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTouristDestination() {
		return touristDestination;
	}

	public void setTouristDestination(String touristDestination) {
		this.touristDestination = touristDestination;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLotAddress() {
		return lotAddress;
	}

	public void setLotAddress(String lotAddress) {
		this.lotAddress = lotAddress;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "TripDto [num=" + num + ", touristDestination=" + touristDestination + ", streetAddress=" + streetAddress
				+ ", lotAddress=" + lotAddress + ", lat=" + lat + ", lng=" + lng + ", info=" + info + ", tel=" + tel
				+ ", img=" + img + "]";
	}

}
