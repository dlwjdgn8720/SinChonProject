package DB;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDAO {
	public void create(MemberVO bag) throws Exception {
		System.out.println("DB에 저장 처리 함");
		// 1.connector 설정
		Class.forName("com.mysql.jdbc.Driver");
		// 자바에서는 에러가 너무 많이 발생할 것 같은 상황에서는 반드시
		// 에러처리를 해주어야함.
		// 네트워크 연결,db연결,파일연결,cpu연결
		System.out.println("1.connector 설정 성공");
		// 2.db연결
		// 1)url:ip+port+db명
		// 2)username : root
		// 3)password:1234
		String url = "jdbc:mysql://localhost:3366/project?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.project 디비 연결 성공");
		// db연동 index는 1부터 시작!
		String sql = "insert into member values(?,?,?,?,?,?)";
		// 컴퓨터는 이 문장을 그냥 String으로 인식!
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, bag.getUserID());
		ps.setString(2, bag.getUserPW());
		ps.setString(3, bag.getUserName());
		ps.setString(4, bag.getUserBirth());
		ps.setString(5, bag.getUserTel());
		ps.setString(6, bag.getUserGender());

		System.out.println("3.SQL문 생성 성공");

		ps.executeUpdate();
		System.out.println("4. SQL문을 mySQL로 네트워크 전송 성공");

	}

	public int login(String id, String pwd) throws Exception {

		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
		// String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/project";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select UserPW from member where UserID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql문은 전송
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		int result = -1;
		String dbpw;
        if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			dbpw = rs.getString("UserPW");
			if (dbpw.equals(pwd)) {
				result = 1; // 인증성공
			} else {
				result = 0; // 비밀번호 틀림
			}
		} else {
			result = -1; // 해당 아이디 없음
		}

		return result;

	}

	public int idcheck(String id) throws Exception {

		// 1. connector설정
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector연결 성공.!!");

		// 2. db연결
		// String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/project";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공.!!");

		// 3. sql문을 만든다.
		String sql = "select * from member where UserID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		String dbId;
		int check = 0;
		if (rs.next()) {
			dbId = rs.getString("UserID");
			if (dbId.equals(id)) {
				check = 1;
			} else {
				check = 0;
			}

		}
		return check;

	}

	public MemberVO all(String id) throws Exception {
		// 가방을 넣는 컨테이너 역할을 하게 됨.!
		// <>안에는 컨테이너에 무엇을 넣을 지정!
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
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
		String sql = "select * from member where UserID=? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		// 4. sql문은 전송
		// select의 결과는 검색결과가 담긴 테이블(항목+내용)
		// 내용에는 없을 수도 있고, 많은 수도 있음.
		System.out.println("3.sql생성 성공!!");
		ResultSet rs = ps.executeQuery();
		System.out.println("4. SQL문 전송 성공.!!");
		MemberVO bag = new MemberVO();
		if (rs.next()) { // 결과가 있는지 없는지 체크해주는 메서드
			// 가방만들어서,

			String pw = rs.getString("UserPW");
			String name = rs.getString("UserName");
			String birth = rs.getString("UserBirth");
			String tel = rs.getString("UserTel");
			String gender = rs.getString("UserGender");

			// 가방에 넣기
			
			bag.setUserPW(pw);
			bag.setUserName(name);
			bag.setUserBirth(birth);
			bag.setUserTel(tel);
			bag.setUserGender(gender);
			// 컨테이너 넣기
			

		}
		
		return bag;
		
		
	}

	public void update(String id, String pw, String name, String birth, String tel, String gender) throws Exception {
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

		String sql = "update member set UserPW=?,UserName=?,UserBirth=?,UserTel=?,UserGender=? where UserID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, pw);
		ps.setString(2, name);
		ps.setString(3, birth);
		ps.setString(4, tel);
		ps.setString(5, gender);
		ps.setString(6, id);

		System.out.println("3.sql생성 성공!!");
		// 4.sql문은 전송
		ps.executeUpdate();
		System.out.println("4.sql문 전송 성공!!");
	}

	
	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.connector 연결 성공");

		String url = "jdbc:mysql://localhost:3366/project";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2.db연결 성공");

		String sql = "delete from member where UserID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		System.out.println("3.SQL생성 성공");

		ps.executeUpdate();
		System.out.println("4.SQL 전송 성공");
		
		

	}

}
