package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class 소개DAO {

	 
	public 소개VO readStar(String resname) throws Exception {
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector연결성공!!");
		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공!!");
		// 3.sql문을 만든다.
		String sql = "select staraverage from soge where resname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, resname);
		System.out.println("3.sql생성 성공!!");
		// 4.sql문은 전송
		ResultSet rs= ps.executeQuery();
		System.out.println("4.sql문 전송 성공!!");
		소개VO vo = new 소개VO();
		if (rs.next()) {
			vo.setStaraverage(rs.getInt(1));
		}
		return vo;
		
	}
	public 소개VO read(String resname) throws Exception {
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector연결성공!!");
		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공!!");
		// 3.sql문을 만든다.
		String sql = "select resname, staraverage, address, tel, resimg, restext from soge where resname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, resname);
		System.out.println("3.sql생성 성공!!");
		// 4.sql문은 전송
		ResultSet rs= ps.executeQuery();
		System.out.println("4.sql문 전송 성공!!");
		소개VO vo = new 소개VO();
		if (rs.next()) {
			vo.setResname(rs.getString(1));
			vo.setStaraverage(rs.getInt(2));
			vo.setAddress(rs.getString(3));
			vo.setTel(rs.getString(4));
			vo.setResimg(rs.getString(5));
			vo.setRestext(rs.getString(6));
		}
		return vo;
		
	}
	 public ArrayList<소개VO> menuread(String resname) throws Exception {
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector연결성공!!");
		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공!!");
		// 3.sql문을 만든다.
		String sql = "select resname, staraverage, address, tel, resimg, price, foodid from soge where resname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, resname);
		System.out.println("3.sql생성 성공!!");
		// 4.sql문은 전송
		ResultSet rs= ps.executeQuery();
		System.out.println("4.sql문 전송 성공!!");
		ArrayList<소개VO> list = new ArrayList<소개VO>();
		
		while (rs.next()) {
			소개VO vo = new 소개VO();
			vo.setResname(rs.getString(1));
			vo.setStaraverage(rs.getInt(2));
			vo.setAddress(rs.getString(3));
			vo.setTel(rs.getString(4));
			vo.setResimg(rs.getString(5));
			vo.setPrice(rs.getString(6));
			vo.setFoodid(rs.getString(7));
			list.add(vo);
		}
		return list;
	}
	 
	 public ArrayList<소개VO> sajinread(String resname) throws Exception {
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector연결성공!!");
		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공!!");
		// 3.sql문을 만든다.
		String sql = "select resname, staraverage, address, tel, resimg from soge where resname=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, resname);
		System.out.println("3.sql생성 성공!!");
		// 4.sql문은 전송
		ResultSet rs= ps.executeQuery();
		System.out.println("4.sql문 전송 성공!!");
		ArrayList<소개VO> list = new ArrayList<소개VO>();
		while (rs.next()) {
			소개VO vo = new 소개VO();
			vo.setResname(rs.getString(1));
			vo.setStaraverage(rs.getInt(2));
			vo.setAddress(rs.getString(3));
			vo.setTel(rs.getString(4));
			vo.setResimg(rs.getString(5));
			list.add(vo);
		}
		return list;
		
	}
}
