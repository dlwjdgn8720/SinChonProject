package bbs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.리뷰DAO;
import DB.리뷰VO;
import DB.소개DAO;
import DB.소개VO;

public class 리뷰패널 extends JPanel{
	private 메인프레임 win;
	private JTextField tcontent;
	private JTextField tstar;
	public String resname;
	private JTextField tid;
	ArrayList<소개VO> list = null;
	ArrayList<리뷰VO> bag = null;
	ArrayList<리뷰VO> list2 = null;

	public 리뷰패널(메인프레임 win, String resname) {
		setBackground(Color.GREEN);
		this.resname = resname;
		setLayout(null);
		this.win = win;
		

		JButton btn = new JButton("소개");
		btn.setBackground(Color.WHITE);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
			}
		});
		btn.setSize(70, 49);
		btn.setLocation(517, 112);
		add(btn);
		
		JButton btn2 = new JButton("메뉴");
		btn2.setBackground(Color.WHITE);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
			}
		});
		btn2.setBounds(599, 112, 70, 49);
		add(btn2);
		
		JButton btn3 = new JButton("사진");
		btn3.setBackground(Color.WHITE);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel03");
			}
		});
		btn3.setBounds(675, 112, 70, 49);
		add(btn3);
		
		JButton btn4 = new JButton("리뷰");
		btn4.setBackground(Color.BLUE);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("panel04");
			}
		});
		btn4.setBounds(757, 112, 70, 49);
		add(btn4);
		
		소개DAO dao = new 소개DAO();
	    try {
			list = dao.sajinread(resname);
			
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		JLabel lblNewLabel_2_1 = new JLabel(list.get(0).getTel());
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(297, 119, 208, 35);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel(list.get(0).getAddress());
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_2.setBounds(34, 126, 249, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(list.get(0).getStaraverage()+"");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1.setBounds(90, 77, 90, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(list.get(0).getResname());
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 44));
		lblNewLabel.setBounds(30, 10, 235, 55);
		add(lblNewLabel);
		
		tcontent = new JTextField();
		tcontent.setBounds(311, 497, 200, 30);
		add(tcontent);
		tcontent.setColumns(10);
		
		tid = new JTextField();
		tid.setBounds(160, 497, 116, 30);
		add(tid);
		tid.setColumns(10);
		
		JTextArea alltext = new JTextArea();
		alltext.setFont(new Font("Monospaced", Font.BOLD, 20));
		alltext.setBounds(85, 173, 706, 285);
		add(alltext);
		
		JButton btnNewButton_2 = new JButton("조회");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				리뷰DAO dao = new 리뷰DAO();
				try {
					list2 = dao.all2();
					for(int i=0; i<list2.size(); i++) {
						리뷰VO bag=list2.get(i);
					alltext.append("id:"+bag.getUserid()+", "+"내용:"+bag.getComment()+", "+"별점:"+bag.getStar()+"\n");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(136, 614, 90, 69);
		add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("등록");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tid.getText();
				String comment = tcontent.getText();
				String star = tstar.getText();
				리뷰DAO dao = new 리뷰DAO();
       
				try {
					dao.create(id, comment, star);
					bag = dao.all(id);
					for(int i=0; i<bag.size(); i++) {
			        	리뷰VO bag2=bag.get(i);
			        	alltext.append("id:"+bag2.getUserid()+", "+"내용:"+bag2.getComment()+", "+"별점:"+bag2.getStar()+"\n");
			      }

					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(291, 614, 90, 69);
		add(btnNewButton);
		
		tstar = new JTextField();
		tstar.setBounds(533, 497, 103, 30);
		add(tstar);
		tstar.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tid.getText();
				String comment = tcontent.getText();
				String star = tstar.getText();
				리뷰DAO dao = new 리뷰DAO();
				try {
					dao.update(id,comment,star);
					리뷰VO vo = dao.idupdate(id);
					alltext.append("수정내용:"+" id:"+vo.getUserid()+", "+"내용:"+vo.getComment()+", "+"별점:"+vo.getStar()+"\n");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(444, 614, 90, 69);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("삭제");
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tid.getText();
				리뷰DAO dao = new 리뷰DAO();
				try {
					dao.delete(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBounds(599, 614, 90, 69);
		add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(204, 475, 34, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("댓글을 입력해주세요(식당이름필수)");
		lblNewLabel_7.setBounds(297, 475, 232, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("별점입력");
		lblNewLabel_8.setBounds(556, 475, 57, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_4 = new JLabel("별점:");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_4.setBounds(34, 78, 62, 18);
		add(lblNewLabel_4);
		
		
		
		
		
		

	}
}