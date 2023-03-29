package com.ssafy.trip.util;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.trip.model.dto.TripDto;

/**
 * 전국관광지정보표준데이터.xml 파일에서 관광지 정보를 읽어 파싱하는 핸들러 클래스
 */
public class TouristDestinationSAXHandler extends DefaultHandler {

	/**
	 * 관광지 정보를 식별하기 위한 번호로 차후 DB에서는 primary key로 대체하지만 현재 버전에서는 0번부터 순차 부여한다.
	 */
	private int num;
	/** 관광지 정보를 담는다 */
	private List<TripDto> trips;
	/** 파싱힌 관광지 정보 */
	private TripDto tripDto;
	/** 태그 바디 정보를 임시로 저장 */
	private String temp;

	public TouristDestinationSAXHandler() {
		trips = new ArrayList<TripDto>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes att) {
		temp = "";
		if (qName.equals("record")) {
			tripDto = new TripDto(num);
			num++;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("관광지명")) {
			tripDto.setTouristDestination(temp);
		} else if (qName.equals("소재지도로명주소")) {
			tripDto.setStreetAddress(temp);
		} else if (qName.equals("소재지지번주소")) {
			tripDto.setLotAddress(temp);
		} else if (qName.equals("위도")) {
			if (temp.length() != 0)
				tripDto.setLat(Double.parseDouble(temp));
		} else if (qName.equals("경도")) {
			if (temp.length() != 0)
				tripDto.setLng(Double.parseDouble(temp));
		} else if (qName.equals("관광지소개")) {
			tripDto.setInfo(temp);
		} else if (qName.equals("관리기관전화번호")) {
			tripDto.setTel(temp);
		} else if (qName.equals("record")) {
			trips.add(tripDto);
			tripDto = null;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		temp = new String(ch, start, length);
	}

	public List<TripDto> getTrips() {
		return trips;
	}

}
