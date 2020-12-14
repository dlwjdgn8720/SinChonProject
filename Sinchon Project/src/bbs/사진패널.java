package bbs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DB.소개DAO;
import DB.소개VO;

public class 사진패널 extends JPanel{
	private JButton Button1;
	private JButton Button2;
	private JTextArea jTextArea1;
	private 메인프레임 win;
	private JButton Button3;
	private JButton Button4;
	String resname;
	소개DAO dao = new 소개DAO();
	ArrayList<소개VO> list = null;
	
	
	public 사진패널(메인프레임 win, String resname) {
		this.resname = resname;
		setBackground(Color.GREEN);
		this.win = win;
		setLayout(null);
		
		JButton Button1 = new JButton("소개");
		Button1.setBackground(Color.WHITE);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});
		Button1.setSize(70,55);
		Button1.setLocation(548,174);
		add(Button1);

		
		JButton Button2 = new JButton("메뉴");
		Button2.setBackground(Color.WHITE);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});
		Button2.setBounds(630, 174, 70, 55);
		add(Button2);
		
		JButton Button3 = new JButton("사진");
		Button3.setBackground(Color.PINK);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});
		Button3.setBounds(712, 173, 70, 56);
		add(Button3);
		
		JButton Button4 = new JButton("리뷰");
		Button4.setBackground(Color.WHITE);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});
		Button4.setBounds(798, 173, 70, 56);
		add(Button4);
		
		try {
			list = dao.sajinread(resname);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_2_1 = new JLabel(list.get(0).getTel());
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(303, 110, 268, 35);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel(list.get(0).getAddress());
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_2.setBounds(34, 110, 257, 35);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(list.get(0).getStaraverage()+"");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(84, 78, 90, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(list.get(0).getResname());
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 44));
		lblNewLabel.setBounds(34, 10, 228, 55);
		add(lblNewLabel);
		
		JLabel img = new JLabel(new ImageIcon(list.get(5).getResimg()));
		img.setBounds(136, 242, 594, 437);
		add(img);
		
		
		JButton pre = new JButton("<");
		pre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel img = new JLabel(new ImageIcon(list.get(5).getResimg()));
				img.setBounds(136, 242, 594, 437);
				add(img);
				
			}
		});
		pre.setBackground(Color.WHITE);
		pre.setBounds(22, 371, 102, 87);
		add(pre);
		
		JButton next = new JButton(">");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel img = new JLabel(new ImageIcon(list.get(6).getResimg()));
				img.setBounds(136, 242, 594, 437);
				add(img);
			}
		});
		next.setBackground(Color.WHITE);
		next.setBounds(742, 380, 95, 87);
		add(next);
		
		JLabel lblNewLabel_3 = new JLabel("별점:");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3.setBounds(22, 79, 62, 18);
		add(lblNewLabel_3);
	}
}
