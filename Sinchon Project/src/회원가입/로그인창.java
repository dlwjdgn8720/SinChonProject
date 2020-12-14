package 회원가입;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB.MemberDAO;
import 메인.메인;
import java.awt.Color;

public class 로그인창 {
	private static JTextField textField;
	private static JPasswordField passwordField;
	public void loginpage() {
		JFrame j = new JFrame();
		j.getContentPane().setBackground(Color.GREEN);
		j.setSize(700, 600);
		j.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("신촌 맛집 로그");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 34));
		lblNewLabel.setBounds(227, 42, 265, 84);
		j.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(150, 205, 106, 59);
		j.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(139, 313, 106, 59);
		j.getContentPane().add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(288, 220, 152, 37);
		j.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(288, 328, 152, 37);
		j.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					MemberDAO dao = new MemberDAO();
					String id = textField.getText();
					String pw = passwordField.getText();
					int check = dao.login(id, pw);
					if (check == 1) {
						JOptionPane.showMessageDialog(j, "로그인성공");
						메인.loginId = id;
						메인 main = new 메인();
						main.main();
						j.dispose();
					}

					else if (check == 0) {
						JOptionPane.showMessageDialog(j, "비밀번호가 틀립니다");
					} else if (check == -1) {
						JOptionPane.showMessageDialog(j, "해당 아이디가 존재하지않습니다.");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(227, 423, 105, 27);
		j.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				회원가입 rg = new 회원가입();
				rg.register();
			}
		});
		btnNewButton_1.setBounds(387, 423, 105, 27);
		j.getContentPane().add(btnNewButton_1);

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	
	}
	public static void main(String[] args) {
		로그인창 g = new 로그인창();
		g.loginpage();
	}
		


}
