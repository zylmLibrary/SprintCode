package com.zylm.library.view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * ���봰��
 * @author �ֿ�
 */
public class LoginWin extends JFrame {

	private Box box, boxUp, boxDown, boxLf, boxRt, boxMid;
	private JLabel lblNum,  lblPwd, lblTitle;
	private JButton btnLog, btnReg, btnVis;
	private JTextField txtNum, txtPwd;
	ImageIcon img = null;

	/**
	 * ���캯��
	 */
	public LoginWin() {
		super("ͼ��ݵ�½");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocation(200, 100);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		initUI();
		this.setVisible(true);
	}

	/**
	 * ��ʼ��UI
	 */
	private void initUI() {
		box = Box.createVerticalBox();
		boxUp = Box.createHorizontalBox();
		boxDown = Box.createHorizontalBox();
		boxMid = Box.createHorizontalBox();
		boxLf = Box.createVerticalBox();
		boxRt = Box.createVerticalBox();

		lblTitle = new JLabel("ͼ��ݵ�½");
		lblTitle.setFont(new Font("����", 1, 35));
		lblNum = new JLabel("ѧ  ��:");
		lblPwd = new JLabel("��  ��:");

		txtNum = new JTextField(20);
		txtPwd = new JTextField(20);

		btnReg = new JButton("ע��");


		btnLog = new JButton("��¼");
		btnVis = new JButton("�ο͵�¼");

		boxLf.add(lblNum);
		boxLf.add(Box.createVerticalStrut(30));
		boxLf.add(lblPwd);

		boxRt.add(txtNum);
		boxRt.add(Box.createVerticalStrut(30));
		boxRt.add(txtPwd);

		boxUp.add(lblTitle);

		boxMid.add(boxLf);
		boxMid.add(Box.createHorizontalStrut(30));
		boxMid.add(boxRt);

		boxDown.add(btnLog);
		boxDown.add(Box.createHorizontalStrut(20));
		boxDown.add(btnReg);
		boxDown.add(Box.createHorizontalStrut(20));
		boxDown.add(btnVis);

		box.add(boxUp);
		box.add(Box.createVerticalStrut(15));
		box.add(boxMid);
		box.add(Box.createVerticalStrut(15));
		box.add(boxDown);

		this.add(box);

	}

	/**
	 * ����Ĭ������
	 */
	private static void setFont() {
		// ����Ĭ������
		Font font = new Font("����", Font.PLAIN, 25);
		UIManager.put("Label.font", font);
		UIManager.put("Button.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("PasswordField.font", font);
	}

	public static void main(String[] args) {
		setFont();
		new LoginWin();
	}
}
