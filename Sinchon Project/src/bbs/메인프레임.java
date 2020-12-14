package bbs;

import javax.swing.JFrame;

import DB.소개VO;

public class 메인프레임 extends JFrame {
	public 소개패널 jpanel01 = null;
	public 메뉴패널 jpanel02 = null;
	public 사진패널 jpanel03 = null;
	public 리뷰패널 jpanel04 = null;
	public String resname;

	public 메인프레임(String resname) {
		this.resname = resname;
		setTitle("패널들 끼워지는 프레임");
		jpanel01 = new 소개패널(this, resname);
		jpanel02 = new 메뉴패널(this, resname);
		jpanel03 = new 사진패널(this, resname);
		jpanel04 = new 리뷰패널(this, resname);

		getContentPane().add(jpanel01);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(900, 900);
		setVisible(true);

	}

	public void change(String panelName) { // 맘스터치
		if (panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		} else if (panelName.equals("panel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		} else if (panelName.equals("panel03")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel03);
			revalidate();
			repaint();
		} else if (panelName.equals("panel04")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel04);
			revalidate();
			repaint();
		}

	}

//	public static void main(String[] args) {
//		메인프레임 win = new 메인프레임("맘스터치");
//		win.setTitle("frame test");
//		win.jpanel01 = new 소개패널(win);
//		win.jpanel02 = new 메뉴패널(win);
//		win.jpanel03 = new 사진패널(win);
//		win.jpanel04 = new 리뷰패널(win);
//		
//		win.getContentPane().add(win.jpanel01);
//		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		win.setSize(800,700);
//		win.setVisible(true);

	// }
}
