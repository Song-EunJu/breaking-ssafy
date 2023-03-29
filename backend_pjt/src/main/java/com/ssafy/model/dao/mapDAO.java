package com.ssafy.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.MapInfo;
import com.ssafy.util.DBUtil;


public class mapDAO {
	public List<MapInfo> getMapInfos(int sido_code, int gugun_code, int content_type_id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select sido_code, gugun_code,content_type_id, title, addr1, first_image, latitude,longitude from attraction_info where sido_code = ? and gugun_code = ? and content_type_id = ?;";
		ArrayList<MapInfo> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sido_code);
			stmt.setInt(2, gugun_code);
			stmt.setInt(3, content_type_id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new MapInfo(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getString("title"),rs.getString("addr1"),rs.getString("first_image"),rs.getDouble("latitude"),rs.getDouble("longitude")));
			}
		}finally {
			DBUtil.close(stmt,conn);
		}
		return list;
	}
}
