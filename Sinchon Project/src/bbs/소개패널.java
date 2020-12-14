package bbs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DB.소개DAO;
import DB.소개VO;
import java.awt.Font;

public class 소개패널 extends JPanel{
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private 메인프레임 win;
	public String resname;
	
	public 소개패널(메인프레임 win, String resname) {
		setBackground(Color.GREEN);
		this.resname = resname;
		this.win = win;
		setLayout(null);
		
		소개DAO dao = new 소개DAO();
		
		JButton jButton1 = new JButton("소개");
		jButton1.setBackground(Color.ORANGE);
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});
		jButton1.setSize(70,45);
		jButton1.setLocation(454,121);
		add(jButton1);
		
		JButton jButton2 = new JButton("메뉴");
		jButton2.setBackground(Color.WHITE);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});
		jButton2.setBounds(535, 121, 70, 45);
		add(jButton2);
		
		JButton jButton3 = new JButton("사진");
		jButton3.setBackground(Color.WHITE);
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});
		jButton3.setBounds(617, 120, 70, 46);
		add(jButton3);
		
		JButton jButton4 = new JButton("리뷰");
		jButton4.setBackground(Color.WHITE);
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});
		jButton4.setBounds(699, 120, 70, 46);
		add(jButton4);
		

		소개VO bag = null;
		try {
			bag = dao.read(resname);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel(bag.getResname());
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 44));
		lblNewLabel.setBounds(12, 5, 365, 77);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(bag.getStaraverage()+"");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(66, 94, 63, 52);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(bag.getAddress());
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 146, 272, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(bag.getTel());
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(296, 133, 159, 52);
		add(lblNewLabel_2_1);
		
		JLabel topimg = new JLabel();
        ImageIcon icon = new ImageIcon(bag.getResimg());
        topimg.setIcon(icon);
		topimg.setBounds(50, 186, 774, 408);
		add(topimg);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 26));
		textArea.setText(bag.getRestext());
		textArea.setBounds(132, 641, 600, 142);
		add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("별점:");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_3.setBounds(12, 111, 62, 18);
		add(lblNewLabel_3);
	}
}
