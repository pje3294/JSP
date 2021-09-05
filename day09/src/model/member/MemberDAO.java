package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBC;

public class MemberDAO {

	public MemberVO getData(MemberVO vo) {
		Connection conn = JDBC.connect();
		MemberVO data = null;
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "select * from member where mid=? and mpw=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new MemberVO();
				data.setNum(rs.getInt("num"));
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				System.out.println(data);   //로깅
			}
			rs.close();
			
		} catch (Exception e) {
			System.out.println("getData() 오류 발생!!");
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;
	}
	
	
	
	
}
