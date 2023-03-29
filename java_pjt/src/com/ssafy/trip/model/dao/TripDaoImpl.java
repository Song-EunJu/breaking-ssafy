package com.ssafy.trip.model.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.model.dto.TripSearchDto;
import com.ssafy.trip.util.TouristDestinationSAXParser;

public class TripDaoImpl implements TripDao {

	private List<TripDto> tripInfo;

	public TripDaoImpl() {
		loadData();
	}

	/**
	 * 관광지 정보를 xml 파일에서 읽어온다.
	 */
	@Override
	public void loadData() {
		TouristDestinationSAXParser parser = new TouristDestinationSAXParser();
		tripInfo = parser.getTripInfo();
	}

	@Override
	public List<TripDto> searchAll(TripSearchDto tripSearchDto) {
		List<TripDto> finds = new LinkedList<TripDto>();

		String touristDestination = tripSearchDto.getTouristDestination(); // 관광지
		String sido = tripSearchDto.getSido(); // 주소
		if (touristDestination != null) {
			for (TripDto trip : tripInfo) {
				if (trip.getTouristDestination().contains(touristDestination)) {
					finds.add(trip);
				}
			}
		} else if (sido != null) {
			for (TripDto trip : tripInfo) {
				if (trip.getStreetAddress().contains(sido)) {
					finds.add(trip);
				}
			}
		} else {
			finds = tripInfo;
		}
		return finds;
	}

	@Override
	public TripDto search(int num) {
		//TODO 3
		// complete code #03
		// List<TripDto> tripInfo 로부터 num 에 해당하는 TripDto 정보를 검색하여 return 하도록 코드를 작성하세요.
		// 해당하는 num이 없을 경우 null을 리턴하세요.
		for(TripDto tripDto : tripInfo) {
			if(tripDto.getNum() == num) return tripDto;
		}
		
		return null;
	}

	public static void print(List<TripDto> trips) {
		for (TripDto trip : trips) {
			System.out.println(trip);
		}
	}
}
