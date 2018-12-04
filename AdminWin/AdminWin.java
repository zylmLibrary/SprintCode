package com.zylm.library.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 * 管理员个人中心窗口
 * @author 蔡振翼
 */
public class AdminWin extends JFrame{
	static JLabel lblMessage, lblSplit;
	static JButton btnImage, btnEdit, btnBkIn, btnSend, btnExit;
	static JPanel pnlApplication;
	
	/**
	 * 构造函数
	 */
	public AdminWin() {
		super("管理员个人中心");
		this.setSize(800, 500);
		Font font = new Font("黑体",Font.BOLD,14);
		UIManager.put("Button.font", font);
		UIManager.put("Label.font", font);
		initUI();
		this.add(pnlApplication);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * 初始化UI
	 */
	private void initUI() {	
		pnlApplication = new JPanel();
		pnlApplication.setLayout(null);
		btnImage = new JButton(new ImageIcon("images\\头像.jpg"));
		btnImage.setBounds(20,20,120,120);
		String str = "<html><font size='5'>用户名：振翼</font><br>"
				+ "<br><font size='4'>职工号：211606301</font></html>";
		lblMessage=new JLabel(str);
		lblMessage.setBounds(150,10,500,95);
		btnEdit = new JButton("编辑资料");
		btnEdit.setBounds(150,110,120,30);
		btnBkIn = new JButton("图书入库");
		btnBkIn.setBounds(40,170,180,40);
		btnSend = new JButton("图书借出表");
		btnSend.setBounds(40,230,180,40);
		btnExit = new JButton("退出登录");
		btnExit.setBounds(40,290,180,40);
		lblSplit = new JLabel();
		lblSplit.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
		lblSplit.setBounds(300,20,470,380);
		
		pnlApplication.add(btnImage);
		pnlApplication.add(lblMessage);
		pnlApplication.add(btnEdit);
		pnlApplication.add(btnBkIn);
		pnlApplication.add(btnSend);
		pnlApplication.add(btnExit);
		pnlApplication.add(lblSplit);

	}
	
	public static void main(String[] args) {
		new AdminWin();
	}
}
