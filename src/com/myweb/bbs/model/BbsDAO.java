package com.myweb.bbs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;



public class BbsDAO {
	
	private static BbsDAO instance = new BbsDAO();
	
	private DataSource ds; 
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private BbsDAO() {
		
		try {
			InitialContext ctx = new InitialContext(); 
		 	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("드라이브 호출에러");
		}
	}
	
	public static BbsDAO getInstance() {
		return instance;
	}
	
	public void regist(String writer, String title, String content) {
		
		String sql ="insert into bbs(bno, writer, title, content) values(bbs_seq.nextval, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
	public ArrayList<BbsVO> getList(int pageNum, int amount){
		ArrayList<BbsVO> list = new ArrayList<>();
		
		String sql = "select *\r\n" + 
				"from(select rownum rn,\r\n" + 
				"        bno,\r\n" + 
				"        writer,\r\n" + 
				"        title,\r\n" + 
				"        content,\r\n" + 
				"        regdate\r\n" + 
				"from(select * \r\n" + 
				"from bbs \r\n" + 
				"order by bno desc)\r\n" + 
				") where rn > ? and rn <= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1) * amount);
			pstmt.setInt(2, pageNum * amount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
			list.add(new BbsVO(bno, writer, title, content, regdate));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int getTotal() {
		int total = 0;
		
		String sql = "select count(*) as total from bbs";
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return total;
	}
	
	public BbsVO getContent(String bno) {
		BbsVO vo = new BbsVO();
		
		String sql = "select * from bbs where bno = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setBno(rs.getInt("bno"));
				vo.setContent(rs.getString("content"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getTimestamp("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return vo;
	}

	public void update(String bno, String writer, String title, String content) {
		
		String sql = "update bbs set writer = ?, title = ?, content = ? where bno = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, bno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}	
	
	public void Delete(String bno) {
		
		String sql = "delete from bbs where bno = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
	public ArrayList<BbsVO> getUserList(int pageNum, int amount, String name){
		ArrayList<BbsVO> list = new ArrayList<>();
		
		String sql = "select *\r\n" + 
				"from(select rownum rn,\r\n" + 
				"       bno,\r\n" + 
				"       writer,\r\n" + 
				"       title,\r\n" + 
				"       content,\r\n" + 
				"       regdate\r\n" + 
				"from(select * \r\n" + 
				"from bbs\r\n" + 
				"where writer = ? \r\n" + 
				"order by bno desc )\r\n" + 
				")where rn > ? and rn <= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, (pageNum-1) * amount);
			pstmt.setInt(3, pageNum * amount);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
			list.add(new BbsVO(bno, writer, title, content, regdate));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}		
		return list;
	}
	
	
	
	
}

