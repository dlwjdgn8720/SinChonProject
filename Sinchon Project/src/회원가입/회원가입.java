package 회원가입;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class 회원가입 {
	public static JTextField UserID;
	public static JTextField UserName;
	public static JTextField UserBirth;
	public static JTextField UserTel;
	private static JPasswordField UserPW;
	private static JPasswordField PWcheck;

	public void register() {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		j.getContentPane().setBackground(Color.GREEN);
		MemberDAO db = new MemberDAO();

		j.setSize(700, 700);
		j.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		lblNewLabel.setBounds(258, 25, 108, 58);
		j.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(150, 136, 57, 15);
		j.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(139, 203, 57, 15);
		j.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("비밀번호확인");
		lblNewLabel_3.setBounds(131, 263, 85, 15);
		j.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("이름");
		lblNewLabel_4.setBounds(150, 322, 34, 15);
		j.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("생년월일");
		lblNewLabel_5.setBounds(139, 381, 57, 15);
		j.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("전화번호");
		lblNewLabel_6.setBounds(139, 439, 57, 15);
		j.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("남/여");
		lblNewLabel_7.setBounds(150, 497, 34, 15);
		j.getContentPane().add(lblNewLabel_7);

		UserID = new JTextField();
		UserID.setBounds(228, 129, 178, 30);
		j.getContentPane().add(UserID);
		UserID.setColumns(10);

		UserPW = new JPasswordField();
		UserPW.setBounds(228, 195, 178, 30);
		j.getContentPane().add(UserPW);

		PWcheck = new JPasswordField();
		PWcheck.setBounds(228, 258, 178, 30);
		j.getContentPane().add(PWcheck);

		JButton btnjoin = new JButton("가입하기");
		btnjoin.setBackground(Color.WHITE);
		btnjoin.setBounds(269, 573, 97, 40);
		j.getContentPane().add(btnjoin);

		UserName = new JTextField();
		UserName.setColumns(10);
		UserName.setBounds(228, 315, 178, 30);
		j.getContentPane().add(UserName);

		UserBirth = new JTextField();
		UserBirth.setColumns(10);
		UserBirth.setBounds(228, 374, 178, 30);
		j.getContentPane().add(UserBirth);

		UserTel = new JTextField();
		UserTel.setColumns(10);
		UserTel.setBounds(228, 432, 178, 30);
		j.getContentPane().add(UserTel);

		JRadioButton mradiobtn = new JRadioButton("M");
		mradiobtn.setBackground(Color.GREEN);
		mradiobtn.setBounds(263, 493, 48, 23);
		j.getContentPane().add(mradiobtn);

		JRadioButton fmradiobtn = new JRadioButton("W");
		fmradiobtn.setBackground(Color.GREEN);
		fmradiobtn.setBounds(315, 493, 42, 23);
		j.getContentPane().add(fmradiobtn);

		JButton btnNewButton = new JButton("아이디중복확인");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = UserID.getText();
				MemberDAO dao = new MemberDAO();
				try {
					int check = dao.idcheck(id);
					if (check == 1) {
						JOptionPane.showMessageDialog(j, "중복된 아이디입니다.");
					} else {
						JOptionPane.showMessageDialog(j, "사용가능한 아이디입니다.");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(418, 132, 147, 23);
		j.getContentPane().add(btnNewButton);

		btnjoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String id = UserID.getText();
				String pw = UserPW.getText();
				String pwcheck = PWcheck.getText();
				String name = UserName.getText();
				String birth = UserBirth.getText();
				String tel = UserTel.getText();
				String gender = "";

				if (mradiobtn.isSelected()) {
					gender += mradiobtn.getText();
				}
				if (fmradiobtn.isSelected()) {
					gender += fmradiobtn.getText();
				}
				if (!(pwcheck.equals(pw))) {
					JOptionPane.showMessageDialog(j, "비밀번호 확인란이 맞지 않습니다.");
				}
				else if (id.isEmpty() || name.isEmpty() || birth.isEmpty() || tel.isEmpty() || gender.isEmpty() || pw.isEmpty()) {
					JOptionPane.showMessageDialog(j, "비어있는 칸이 존재합니다.");
				
				
				} else {
					JOptionPane.showMessageDialog(j, "축하합니다.성공적으로 가입이 되었습니다.");

					try {
						MemberVO bag = new MemberVO();
						bag.setUserID(id);
						bag.setUserPW(pw);
						bag.setUserName(name);
						bag.setUserBirth(birth);
						bag.setUserTel(tel);
						bag.setUserGender(gender);
						db.create(bag);
						j.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

		j.setVisible(true);
	}
//public static void main(String[] args) {
//	회원가입 g = new 회원가입();
//	g.register();
//}
}
