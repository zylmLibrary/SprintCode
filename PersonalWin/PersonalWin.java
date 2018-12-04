package com.zylm.library.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * �û��������Ĵ���
 * @author л����
 */
public class PersonalWin {
	private static JFrame frame;
	private static JButton btnImage, btnEdit, btnRecord, btnOrder, btnRenewal, btnExit;
	private static JLabel lblInformation;
	private static JPanel pnlInformation, pnlTotal;
	
	/**
	 * ��ʼ��UI 
	 */
	public static void UI() {
		frame = new JFrame("��������");

		frame.setSize(800, 500);
		frame.setLocation(300, 300);

		btnImage = new JButton(new ImageIcon("images/ͷ��.jpg"));
		btnImage.setBounds(20, 20, 120, 120);

		btnEdit = new JButton("�༭����");
		btnEdit.setBounds(150, 110, 120, 30);

		lblInformation = new JLabel(
				"<html><font size='5'>�û�����Ƥ��</font><br><br><font size='4'>ѧ�ţ�211605240</font></html>");
		lblInformation.setBounds(150, 10, 500, 95);

		btnRecord = new JButton("���ļ�¼");
		btnRecord.setBounds(20, 170, 250, 40);

		btnOrder = new JButton("ͼ��ԤԼ");
		btnOrder.setBounds(20, 230, 250, 40);

		btnRenewal = new JButton("ͼ������");
		btnRenewal.setBounds(20, 290, 250, 40);

		btnExit = new JButton("�˳���¼");
		btnExit.setBounds(20, 350, 250, 40);

		pnlInformation = new JPanel();
		pnlInformation.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
		pnlInformation.setBounds(300, 20, 470, 380);

		pnlTotal = new JPanel();
		pnlTotal.setLayout(null);
		pnlTotal.add(btnImage);
		pnlTotal.add(lblInformation);
		pnlTotal.add(btnEdit);
		pnlTotal.add(btnRecord);
		pnlTotal.add(btnOrder);
		pnlTotal.add(btnRenewal);
		pnlTotal.add(btnExit);
		pnlTotal.add(pnlInformation);

		frame.add(pnlTotal);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		UI();
	}
}
