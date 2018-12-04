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
 * 登入窗口
 * @author 林凯
 */
public class LoginWin extends JFrame {

	private Box box, boxUp, boxDown, boxLf, boxRt, boxMid;
	private JLabel lblNum,  lblPwd, lblTitle;
	private JButton btnLog, btnReg, btnVis;
	private JTextField txtNum, txtPwd;
	ImageIcon img = null;

	/**
	 * 构造函数
	 */
	public LoginWin() {
		super("图书馆登陆");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocation(200, 100);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		initUI();
		this.setVisible(true);
	}

	/**
	 * 初始化UI
	 */
	private void initUI() {
		box = Box.createVerticalBox();
		boxUp = Box.createHorizontalBox();
		boxDown = Box.createHorizontalBox();
		boxMid = Box.createHorizontalBox();
		boxLf = Box.createVerticalBox();
		boxRt = Box.createVerticalBox();

		lblTitle = new JLabel("图书馆登陆");
		lblTitle.setFont(new Font("宋体", 1, 35));
		lblNum = new JLabel("学  号:");
		lblPwd = new JLabel("密  码:");

		txtNum = new JTextField(20);
		txtPwd = new JTextField(20);

		btnReg = new JButton("注册");


		btnLog = new JButton("登录");
		btnVis = new JButton("游客登录");

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
	 * 设置默认字体
	 */
	private static void setFont() {
		// 设置默认字体
		Font font = new Font("楷体", Font.PLAIN, 25);
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
