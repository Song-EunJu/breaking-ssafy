package com.ssafy.model.service;


import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.mapDAO;
import com.ssafy.model.dto.MapInfo;

public class MapService {
	private mapDAO mapDao = new mapDAO();
	public List<MapInfo> getMapInfos(int sido_code, int gugun_code, int content_type_id) throws SQLException {
		return mapDao.getMapInfos(sido_code, gugun_code, content_type_id);
	}
}
