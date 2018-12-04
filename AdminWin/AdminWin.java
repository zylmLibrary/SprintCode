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
 * ����Ա�������Ĵ���
 * @author ������
 */
public class AdminWin extends JFrame{
	static JLabel lblMessage, lblSplit;
	static JButton btnImage, btnEdit, btnBkIn, btnSend, btnExit;
	static JPanel pnlApplication;
	
	/**
	 * ���캯��
	 */
	public AdminWin() {
		super("����Ա��������");
		this.setSize(800, 500);
		Font font = new Font("����",Font.BOLD,14);
		UIManager.put("Button.font", font);
		UIManager.put("Label.font", font);
		initUI();
		this.add(pnlApplication);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * ��ʼ��UI
	 */
	private void initUI() {	
		pnlApplication = new JPanel();
		pnlApplication.setLayout(null);
		btnImage = new JButton(new ImageIcon("images\\ͷ��.jpg"));
		btnImage.setBounds(20,20,120,120);
		String str = "<html><font size='5'>�û���������</font><br>"
				+ "<br><font size='4'>ְ���ţ�211606301</font></html>";
		lblMessage=new JLabel(str);
		lblMessage.setBounds(150,10,500,95);
		btnEdit = new JButton("�༭����");
		btnEdit.setBounds(150,110,120,30);
		btnBkIn = new JButton("ͼ�����");
		btnBkIn.setBounds(40,170,180,40);
		btnSend = new JButton("ͼ������");
		btnSend.setBounds(40,230,180,40);
		btnExit = new JButton("�˳���¼");
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
