package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	ArrayList<MessageDTO> list = null;
	MessageDTO info = null;

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(MessageDTO dto) {
		conn();
		try {
			String sql = "insert into message values(num.nextval, ?, ?, ?, sysdate)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getReceive());
			psmt.setString(2, dto.getSend());
			psmt.setString(3, dto.getContent());

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public ArrayList<MessageDTO> message() {
		list = new ArrayList<MessageDTO>();
		conn();
		try {
			String sql = "select * from message";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String send = rs.getString(2);
				String receive = rs.getString(3);
				String content = rs.getString(4);

				info = new MessageDTO(send, receive, content);
				list.add(info);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

}
