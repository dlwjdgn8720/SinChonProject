package 회원가입;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DB.MemberDAO;
import DB.MemberVO;
import java.awt.Color;

public class 회원삭제 {
	public static JTextField UserID;

	public void delete() {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		j.getContentPane().setBackground(Color.GREEN);
		MemberDAO db = new MemberDAO();

		j.setSize(600, 300);
		j.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("회원삭제");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(242, 10, 108, 58);
		j.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(134, 121, 57, 15);
		j.getContentPane().add(lblNewLabel_1);

		UserID = new JTextField();
		UserID.setBounds(212, 114, 178, 30);
		j.getContentPane().add(UserID);
		UserID.setColumns(10);

		JButton btnmodify = new JButton("삭제하기");
		btnmodify.setBackground(Color.WHITE);
		btnmodify.setBounds(242, 191, 97, 40);
		j.getContentPane().add(btnmodify);

		btnmodify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = UserID.getText();
				try {
					int check = db.idcheck(id);

					if (check == 1) {
						JOptionPane.showMessageDialog(j, "삭제되었습니다.");
						db.delete(id);
						로그인창 login = new 로그인창();
						login.loginpage();
						j.dispose();
					} else {
						JOptionPane.showMessageDialog(j, "해당 아이디가 존재하지않습니다.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		j.setVisible(true);
	}

//	public static void main(String[] args) {
//		회원삭제 g = new 회원삭제();
//		g.delete();
//	}
}
