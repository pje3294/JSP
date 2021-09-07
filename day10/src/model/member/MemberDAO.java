package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBC;

public class MemberDAO {
	
	// 로그인을 위한 selectOne R
	public MemberVO selectOne(MemberVO vo) {
		Connection conn = JDBC.connect();
		MemberVO data = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "select * from member where mid=? and mpw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new MemberVO();
				data.setMnum(rs.getInt("mnum"));
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Member-selectOne 오류 로깅");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return data;
	}
	
	
	
	
}
