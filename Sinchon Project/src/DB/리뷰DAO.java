package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//CRUD중심으로 기능을 정의
//데이터와 관련된 작업(Data Access object:DAO)
public class 리뷰DAO {

	// 기능을 정의할때는 메서드(함수)를 사용
	// create메서드 호출시 입력 값을 받아주는 중간 매개체 역할의 변수
	// =>매개변수(parameter,파라메터)

	public void create(String userid, String comment, String star) throws Exception {
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
		String sql = "insert into review values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setString(2, comment);
		ps.setString(3, star);

		System.out.println("3.sql생성 성공!!");
		// 4.sql문을 전송
		ps.executeUpdate();
		System.out.println("4.sql문 전송 성공!!");
	}

	public ArrayList<리뷰VO> all(String id) throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// <>안에는 컨테이너에 무엇을 넣을 지정!

//	       DB프로그램 절차에 맞추어서 코딩
//	       1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
//	    String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from review where userid=? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");

		ArrayList<리뷰VO> list = new ArrayList<리뷰VO>();
		while (rs.next()) {
			리뷰VO vo = new 리뷰VO();
			vo.setUserid(rs.getString(1));
			vo.setComment(rs.getString(2));
			vo.setStar(rs.getString(3));
			list.add(vo);
		}
		return list;
	}

	public ArrayList<리뷰VO> all2() throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// <>안에는 컨테이너에 무엇을 넣을 지정!

//	       DB프로그램 절차에 맞추어서 코딩
//	       1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
//	    String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from review";

		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");

		ArrayList<리뷰VO> list = new ArrayList<리뷰VO>();
		while (rs.next()) {
			리뷰VO vo = new 리뷰VO();
			vo.setUserid(rs.getString(1));
			vo.setComment(rs.getString(2));
			vo.setStar(rs.getString(3));
			list.add(vo);
		}
		return list;

	}

	public 리뷰VO idupdate(String id) throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// <>안에는 컨테이너에 무엇을 넣을 지정!
		
//	       DB프로그램 절차에 맞추어서 코딩
//	       1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
//	    String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from review where userid=? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		리뷰VO bag = new 리뷰VO();
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			// 가방만들어서,

			String userid = rs.getString("userid");
			String comment = rs.getString("comment");
			String star = rs.getString("star");

			// 가방에 넣기

			bag.setUserid(userid);
			bag.setComment(comment);
			bag.setStar(star);

			// 컨테이너 넣기

		}

		return bag;

	}

	public void update(String userid, String comment, String star) throws Exception {
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
		String sql = "update review set comment=?, star=? where userid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, comment);
		ps.setString(2, star);
		ps.setString(3, userid);

		System.out.println("3.sql생성 성공!!");
		// 4.sql문을 전송
		ps.executeUpdate();
		System.out.println("4.sql문 전송 성공!!");
	}

	public void delete(String userid) throws Exception {
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector 연결 성공");
		// 2.db연결
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공");
		// 3.sql문을 만든다.
		String sql = "delete from review where userid=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
     	ps.setString(1, userid);
		
		System.out.println("3.SQL생성 성공");
		// 4.sql문을 전송
		ps.executeUpdate();
		System.out.println("4.SQL 전송 성공");
	}
}