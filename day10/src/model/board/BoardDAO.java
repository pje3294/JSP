package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBC;

public class BoardDAO {

	// ��ü �Խù� �������� R - main.jsp
	public ArrayList<BoardVO> selectAll() {
		Connection conn = JDBC.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		PreparedStatement pstmt = null;

		try {
			String sql = "select * from board order by bnum desc";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setBdate(rs.getDate("bdate"));
				data.setBnum(rs.getInt("bnum"));
				data.setContent(rs.getString("content"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Board-selectAll ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

//////////////////////////////////////////////////
	// �ش� id�� ��ü �Խù� �������� R - myPage.jsp
	public ArrayList<BoardVO> selectAllmy(String id) {
		Connection conn = JDBC.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		PreparedStatement pstmt = null;

		try {
			String sql = "select * from board where id='"+id+"' order by bnum desc";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setBdate(rs.getDate("bdate"));
				data.setBnum(rs.getInt("bnum"));
				data.setContent(rs.getString("content"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Board-selectAllmy ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

//////////////////////////////////////////////////
// �˻��� ���� �޼ҵ�  -- selectAll�� ����
	public ArrayList<BoardVO> search(String condition, String content) {
		Connection conn = JDBC.connect();
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		PreparedStatement pstmt = null;

		try {
			// select * from board where id like 'a%';
			System.out.println(condition);
			String sql = "select * from board where " + condition + " like '" + content + "%' order by id desc ";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO data = new BoardVO();
				data.setBdate(rs.getDate("bdate"));
				data.setBnum(rs.getInt("bnum"));
				data.setContent(rs.getString("content"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
				datas.add(data);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Board-selectAll ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return datas;
	}

	//////////////////////////////////////////////////
	// �Խñ� �Ѱ� ��������
	public BoardVO selectOne(BoardVO vo) {
		Connection conn = JDBC.connect();
		BoardVO data = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "select * from board where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				data = new BoardVO();
				data.setBnum(rs.getInt("bnum"));
				data.setBdate(rs.getDate("bdate"));
				data.setContent(rs.getString("content"));
				data.setId(rs.getString("id"));
				data.setTitle(rs.getString("title"));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("Board-selectOne ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data;

	}

	//////////////////////////////////////////////////
	// �Խñ� �߰��ϱ� C
	public boolean insert(BoardVO vo) {
		Connection conn = JDBC.connect();
		boolean result = false;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into board values((select nvl(max(bnum),0)+1 from board), ?, ?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("Board-insert ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return result;
	}

	////////////////////////////////////////////////
	// �Խñ� ���� U
	public boolean update(BoardVO vo) {
		Connection conn = JDBC.connect();
		boolean result = false;
		PreparedStatement pstmt = null;
		System.out.println("update()���� ��");
		try {
			String sql = "update board set id=?, title=?, content=?, bdate=sysdate where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getBnum());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("Board-update ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return result;
	}

	////////////////////////////////////////////////
	// �Խñ� ���� D
	public boolean delete(BoardVO vo) {
		Connection conn = JDBC.connect();
		boolean result = false;
		PreparedStatement pstmt = null;

		try {
			String sql = "delete from board where bnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBnum());
			pstmt.executeUpdate();
			result = true;
		} catch (Exception e) {
			System.out.println("Board-update ���� �α�");
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return result;
	}

}
