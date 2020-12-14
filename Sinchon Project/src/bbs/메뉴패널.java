package bbs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB.소개DAO;
import DB.소개VO;
import java.awt.Font;

public class 메뉴패널 extends JPanel {
	public 메뉴패널() {
		setBackground(Color.WHITE);
	}
	private 메인프레임 win;
	public String resname;

	public 메뉴패널(메인프레임 win, String resname) {
		this.resname = resname;
		setBackground(Color.GREEN);
		setLayout(null);
		this.win = win;

		JButton btn = new JButton("소개");
		btn.setBackground(Color.WHITE);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});
		btn.setSize(70, 41);
		btn.setLocation(556, 110);
		add(btn);
		
		JButton btn2 = new JButton("메뉴");
		btn2.setBackground(Color.RED);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});
		btn2.setBounds(638, 110, 70, 41);
		add(btn2);
		
		JButton btn3 = new JButton("사진");
		btn3.setBackground(Color.WHITE);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});
		btn3.setBounds(720, 110, 70, 41);
		add(btn3);
		
		JButton btn4 = new JButton("리뷰");
		btn4.setBackground(Color.WHITE);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});
		
		
		소개DAO dao = new 소개DAO();
		ArrayList<소개VO> list = null;
		try {
			list = dao.menuread(resname);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		btn4.setBounds(802, 110, 70, 41);
		add(btn4);
		
		JLabel lblNewLabel_2_1 = new JLabel(list.get(0).getStaraverage()+"");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(55, 89, 104, 20);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel(list.get(0).getAddress());
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(55, 114, 239, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(list.get(0).getTel());
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(356, 114, 311, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(   list.get(0).getResname());
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 44));
		lblNewLabel.setBounds(31, 10, 282, 69);
		add(lblNewLabel);
		
		JLabel img1 = new JLabel(new ImageIcon(list.get(1).getResimg()));
		img1.setBounds(38, 160, 398, 255);
		add(img1);
		
		JLabel img2 = new JLabel(new ImageIcon(list.get(2).getResimg()));
		img2.setBounds(488, 465, 384, 262);
		add(img2);
		
		JLabel img3 = new JLabel(new ImageIcon(list.get(3).getResimg()));
		img3.setBounds(488, 161, 384, 253);
		add(img3);
		
		JLabel img4 = new JLabel(new ImageIcon(list.get(4).getResimg()));
		img4.setBounds(41, 465, 395, 262);
		add(img4);
		
		JLabel price1 = new JLabel(list.get(1).getPrice());
		price1.setFont(new Font("굴림", Font.BOLD, 20));
		price1.setBounds(234, 425, 114, 30);
		add(price1);
		
		JLabel price2 = new JLabel(list.get(2).getPrice());
		price2.setFont(new Font("굴림", Font.BOLD, 20));
		price2.setBounds(710, 424, 109, 30);
		add(price2);
		
		JLabel price3 = new JLabel(list.get(3).getPrice());
		price3.setFont(new Font("굴림", Font.BOLD, 20));
		price3.setBounds(257, 752, 109, 30);
		add(price3);
		
		JLabel price4 = new JLabel(list.get(4).getPrice());
		price4.setFont(new Font("굴림", Font.BOLD, 20));
		price4.setBounds(720, 737, 119, 30);
		add(price4);

		//System.out.println(list.get(1).getFoodid() +"============");
		JLabel id1 = new JLabel(list.get(1).getFoodid());
		id1.setFont(new Font("굴림", Font.BOLD, 20));
		id1.setBounds(108, 425, 114, 30);
		add(id1);
		
		JLabel id2 = new JLabel(list.get(2).getFoodid());
		id2.setFont(new Font("굴림", Font.BOLD, 20));
		id2.setBounds(572, 425, 129, 30);
		add(id2);
		
		JLabel id4 = new JLabel(list.get(3).getFoodid());
		id4.setFont(new Font("굴림", Font.BOLD, 20));
		id4.setBounds(569, 737, 118, 30);
		add(id4);
		
		JLabel id3 = new JLabel(list.get(4).getFoodid());
		id3.setFont(new Font("굴림", Font.BOLD, 20));
		id3.setBounds(139, 752, 106, 30);
		add(id3);

	}
}
