package 메인;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DB.소개DAO;
import DB.소개VO;
import bbs.메인프레임;
import 회원가입.로그인창;
import 회원가입.회원삭제;
import 회원가입.회원수정;

public class 메인 {
	public static String loginId;
	String resname;
	
	public void main() {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		j.setTitle("시작 페이지");
		j.getContentPane().setBackground(Color.GREEN);
		j.setBackground(Color.WHITE);
		
		j.setSize(1000, 800);

		JButton btn = new JButton(); // 회원가입
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				회원수정 md = new 회원수정();
				md.modify();
				
			}
		});
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("굴림", Font.PLAIN, 32));
		JButton btn_1 = new JButton(); // 로그인
		btn_1.setBackground(Color.WHITE);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				회원삭제 de = new 회원삭제();
				de.delete();
                j.dispose();

			}
		});
		btn_1.setFont(new Font("굴림", Font.PLAIN, 32));
		JButton btn_2 = new JButton(); // 이미지1
		ImageIcon icon = new ImageIcon("./맘스터치_대표.jfif");
		btn_2.setIcon(icon);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("맘스터치");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
			}
		});
		JButton btn_3 = new JButton(); // 이미지2
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("신촌1번지");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon icon2 = new ImageIcon("./신촌1번지_대표.jfif");
		btn_3.setIcon(icon2);

        JButton btn_4 = new JButton(); // 이미지3
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("육구덮밥");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon icon3 = new ImageIcon("./육구덮밥_대표.jfif");
		btn_4.setIcon(icon3);
		JButton btn_5 = new JButton(); // 이미지4
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("육쌈냉면");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon icon4 = new ImageIcon("./육쌈냉면_대표.jfif");
		btn_5.setIcon(icon4);
		JButton btn_6 = new JButton(); // 이미지5
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("정육면체");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon icon5 = new ImageIcon("./정육면체_대표.jfif");
		btn_6.setIcon(icon5);
		JButton btn_7 = new JButton(); // 이미지6
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				메인프레임 mainframe = new 메인프레임("홍콩반점");
				try {
					mainframe.change("panel01");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ImageIcon icon6 = new ImageIcon("./홍콩반점_대표.jfif");
		btn_7.setIcon(icon6);
		JTextField t1 = new JTextField(); // 검색창
		JLabel l1 = new JLabel(); // 메인 title
		l1.setBackground(Color.WHITE);
		l1.setFont(new Font("굴림", Font.BOLD, 49));
		JLabel l1name = new JLabel(); // 이름
		l1name.setFont(new Font("Dialog", Font.BOLD, 17));
		JLabel l1kind = new JLabel();
		l1kind.setFont(new Font("Dialog", Font.BOLD, 17));
		JLabel l1star1 = new JLabel(); // 별점
		l1star1.setFont(new Font("Dialog", Font.BOLD, 17));

		소개DAO dao = new 소개DAO();
		소개VO vo = null;
		try {
			vo = dao.readStar("맘스터치");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		btn.setText("회원수정");
		btn_1.setText("회원탈퇴");
		btn_2.setText("이미지1");
		btn_3.setText("이미지2");
		btn_4.setText("이미지3");
		btn_5.setText("이미지4");
		btn_6.setText("이미지5");
		btn_7.setText("이미지6");
		l1.setText("2020 신촌로그 맛집");
		l1name.setText("맘스터치");
		l1kind.setText("치킨,햄버거");
		l1star1.setText(vo.getStaraverage()+"");

		btn.setBounds(610, 10, 175, 59);
		btn_1.setBounds(797, 10, 175, 59);
		btn_2.setBounds(160, 226, 161, 152);
		btn_3.setBounds(406, 226, 173, 152);
		btn_4.setBounds(689, 226, 161, 152);
		btn_5.setBounds(170, 478, 151, 152);
		btn_6.setBounds(406, 478, 161, 152);
		btn_7.setBounds(689, 478, 157, 152);
		l1.setBounds(93, 79, 486, 90);
		l1name.setBounds(125, 388, 73, 59);
		l1kind.setBounds(207, 392, 95, 50);
		l1star1.setBounds(322, 388, 40, 59);

		j.getContentPane().setLayout(null);
		j.getContentPane().add(btn);
		j.getContentPane().add(btn_1);
		j.getContentPane().add(btn_2);
		j.getContentPane().add(btn_3);
		j.getContentPane().add(btn_4);
		j.getContentPane().add(btn_5);
		j.getContentPane().add(btn_6);
		j.getContentPane().add(btn_7);
		j.getContentPane().add(l1);
		j.getContentPane().add(l1name);
		j.getContentPane().add(l1kind);
		j.getContentPane().add(l1star1);

		JLabel l2name = new JLabel("신촌 1번지");
		l2name.setFont(new Font("굴림", Font.BOLD, 17));
		l2name.setBounds(374, 410, 84, 15);
		j.getContentPane().add(l2name);

		JLabel l2kind = new JLabel("한식뷔페");
		l2kind.setFont(new Font("굴림", Font.BOLD, 17));
		l2kind.setBounds(470, 401, 71, 33);
		j.getContentPane().add(l2kind);
		try {
			vo = dao.readStar("신촌1번지");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		JLabel l2star2 = new JLabel(vo.getStaraverage()+"");
		l2star2.setFont(new Font("굴림", Font.BOLD, 17));
		l2star2.setBounds(576, 410, 19, 15);
		j.getContentPane().add(l2star2);

		JLabel l3name = new JLabel("육구덮밥");
		l3name.setFont(new Font("굴림", Font.BOLD, 17));
		l3name.setBounds(680, 410, 73, 15);
		j.getContentPane().add(l3name);

		JLabel l3kind = new JLabel("덮밥");
		l3kind.setFont(new Font("굴림", Font.BOLD, 17));
		l3kind.setBounds(765, 410, 40, 15);
		j.getContentPane().add(l3kind);

		try {
			vo = dao.readStar("육구덮밥");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		JLabel l3start3 = new JLabel(vo.getStaraverage()+"");
		l3start3.setFont(new Font("굴림", Font.BOLD, 17));
		l3start3.setBounds(843, 410, 19, 15);
		j.getContentPane().add(l3start3);

		JLabel l4name = new JLabel();
		l4name.setFont(new Font("굴림", Font.BOLD, 17));
		l4name.setText("육쌈냉면");
		l4name.setBounds(144, 640, 73, 59);
		j.getContentPane().add(l4name);

		JLabel l5name = new JLabel();
		l5name.setFont(new Font("굴림", Font.BOLD, 17));
		l5name.setText("정육면체");
		l5name.setBounds(390, 640, 68, 59);
		j.getContentPane().add(l5name);

		JLabel l6name = new JLabel();
		l6name.setFont(new Font("굴림", Font.BOLD, 17));
		l6name.setText("홍콩반점");
		l6name.setBounds(680, 640, 84, 59);
		j.getContentPane().add(l6name);

		JLabel l4kind = new JLabel();
		l4kind.setFont(new Font("굴림", Font.BOLD, 17));
		l4kind.setText("냉면");
		l4kind.setBounds(229, 644, 50, 50);
		j.getContentPane().add(l4kind);

		JLabel l5kind = new JLabel();
		l5kind.setFont(new Font("굴림", Font.BOLD, 17));
		l5kind.setText("국수");
		l5kind.setBounds(479, 644, 62, 50);
		j.getContentPane().add(l5kind);

		JLabel l6kind = new JLabel();
		l6kind.setFont(new Font("굴림", Font.BOLD, 17));
		l6kind.setText("중식");
		l6kind.setBounds(769, 644, 62, 50);
		j.getContentPane().add(l6kind);
		try {
			vo = dao.readStar("육쌈냉면");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		JLabel l4star4 = new JLabel(vo.getStaraverage()+"");
		l4star4.setFont(new Font("굴림", Font.BOLD, 17));
		
		l4star4.setBounds(299, 640, 63, 59);
		j.getContentPane().add(l4star4);
		
		try {
			vo = dao.readStar("정육면체");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		JLabel l5star5 = new JLabel(vo.getStaraverage()+"");
		l5star5.setFont(new Font("굴림", Font.BOLD, 17));
		
		l5star5.setBounds(555, 640, 40, 59);
		j.getContentPane().add(l5star5);
		
		try {
			vo = dao.readStar("홍콩반점");
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		JLabel l6star6 = new JLabel(vo.getStaraverage()+"");
		l6star6.setFont(new Font("굴림", Font.BOLD, 17));
		
		l6star6.setBounds(843, 640, 40, 59);
		j.getContentPane().add(l6star6);
		
		
		
		
		
		JLabel staticid = new JLabel("");
		if (loginId != null) {
			staticid.setText(loginId);
		}
		staticid.setFont(new Font("굴림", Font.PLAIN, 29));
		staticid.setBounds(56, 32, 136, 37);
		j.getContentPane().add(staticid);
		
		JLabel lblNewLabel_6 = new JLabel("님 환영합니다");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 38));
		lblNewLabel_6.setBounds(160, 19, 268, 50);
		j.getContentPane().add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_7 = new JLabel("음식점 정보를 확인하시고 싶으시면 이미지를 클릭하세요");
		lblNewLabel_7.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_7.setBounds(93, 179, 448, 37);
		j.getContentPane().add(lblNewLabel_7);
		
		JButton btn_8 = new JButton();
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				로그인창 login = new 로그인창();
				login.loginpage();
				j.dispose();
			}
		});
		btn_8.setText("로그아웃");
		btn_8.setFont(new Font("굴림", Font.PLAIN, 32));
		btn_8.setBackground(Color.WHITE);
		btn_8.setBounds(420, 10, 175, 59);
		j.getContentPane().add(btn_8);
		j.setVisible(true);
	}

//	public static void main(String[] args) {
//		메인 main1 = new 메인();
//		main1.main();
//	}
}
