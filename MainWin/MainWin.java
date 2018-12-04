package com.zylm.library.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import com.zylm.library.db.Database;

/**
 * ������Ҫ���ڽ���
 * @author Ф־��
 */
public class MainWin extends JFrame implements ActionListener {

	// ȫ�ֱ�������
	public static String userName;
	public static final int PAGE = 20; // ҳ�����ֵ
	public static final int ROW = 50; // ÿҳ�̶�������
	public static final int LEN = 15; // �����򳤶�
	// ��ά���������ݿ��е����ݴӶ��ڱ�table����ʾ
	public static String ar[][] = new String[ROW][8];
	public static final Object columnName[] = { "���", "����", "����", "����", "���", "λ��", "ʣ����", "������" }; // ����ֵ
	private static final String[] classify = new String[] { "  ", "��ѧ���ڽ�", "����ѧ����", "���Ρ�����", "����", "����", "�Ļ�����ѧ������������",
			"���ԡ�����", "��ѧ", "����", "��ʷ������", "��Ȼ��ѧ����", "�����ѧ�ͻ�ѧ", "����ѧ�������ѧ", "�����ѧ", "ҽҩ������", "ũҵ��ѧ", "��ҵ����", "��ͨ����",
			"���ա�����", "������ѧ���Ͷ�������ѧ����ȫ��ѧ��", "�ۺ���ͼ��" }; // ���ѡ��
	// ����ҳ������ĩҳ������ǰһҳ��������һҳ����ť�Ŀ��Ʒ�
	public static boolean prevButton = false, nextButton = false, firstButton = false, lastButton = false;
	// ������ʾ�ڼ�ҳ������ShowBook.showPage(int n)ʱ�Ĳ���
	public static int pageValue = 0;

	// �����
	private JPanel pnlNorth = new JPanel(new GridLayout(1, 1));

	// �˵���
	private JMenuBar mnub = new JMenuBar();

	// �˵���������
	private JPanel pnlText = new JPanel();

	private JLabel lblId = new JLabel(" ��ţ� ");
	private JTextField txtId = new JTextField(LEN);
	private JLabel lblName = new JLabel(" ������ ");
	private JTextField txtName = new JTextField(LEN);
	private JLabel lblAuthor = new JLabel(" ���ߣ� ");
	private JTextField txtAuthor = new JTextField(LEN);
	// private JLabel lblPress = new JLabel(" �����磺 ");
	// private JTextField txtPress = new JTextField(LEN);
	private JLabel lblClassify = new JLabel(" ��� ");
	private JComboBox<String> cmbClassify = new JComboBox<String>(classify);

	// �˵����а�ť
	private JPanel pnlBtn = new JPanel();

	private JButton btnQuery = new JButton("��ѯ");
	private JButton btnJoin = new JButton("ע��");
	private JButton btnLogin = new JButton("��¼");
	private JButton btnPC = new JButton("��������");
	private JButton btnExit = new JButton("�˳�");

	// �����
	private JPanel pnlCenter = new JPanel();// ���������ģ��

	public static JLabel label;
	private JScrollPane scrollpane;
	public static JTable table;

	// ����弰�����
	private JPanel pnlWest = new JPanel();
	private JPanel pnlEast = new JPanel();

	// �����
	private JPanel pnlSouth = new JPanel();

	private JButton btnPre = new JButton("��һҳ");
	private JButton btnNext = new JButton("��һҳ");
	private JButton btnFirst = new JButton("��ҳ");
	private JButton btnLast = new JButton("ĩҳ");
	public static JLabel lblPage = new JLabel("�� 1 ҳ");

	/**
	 * ���캯��
	 */
	MainWin() {

		userName = "root";
		String lab;

		if (true) { // �Ƿ��Ѿ�����
			btnJoin.setVisible(false);
			btnLogin.setVisible(false);
			if (true) { // �Ƿ��ǹ���Ա
				lab = userName + "����Ա��ã���ӭ��¼ͼ�����ϵͳ��";
			} else {
				lab = userName + "ͬѧ ��ã���ӭ����ͼ���ѯϵͳ��";
			}
		} else {
			btnPC.setVisible(false);
			lab = "��ӭ����ͼ�����ϵͳ��";
		}
		initUI(lab);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		int x = screen.width;
		int y = screen.height;
		// setSize(x,y); /*��ϵͳ����ƽ��������ʾ������*/

		setSize(1300, 600);
		int xcenter = (x - 1300) / 2;
		int ycenter = (y - 600) / 2;
		setLocation(xcenter, ycenter);/* ��ʾ�ڴ������� */

		setTitle("ͼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * ��ʼ�����ڽ���
	 * @param lab
	 */
	private void initUI(String lab) {
		Container cpnl = getContentPane(); // ��ʼ����塢��ť����ǩ���ı���
		label = new JLabel(lab, SwingConstants.CENTER);
		table = new JTable(ar, columnName);
		table.setRowHeight(30); // ָ��ÿһ�е��и�
		scrollpane = new JScrollPane(table);

		cpnl.add(pnlNorth, "North");
		cpnl.add(pnlCenter, "Center");
		cpnl.add(pnlWest, "West");
		cpnl.add(pnlEast, "East");
		cpnl.add(pnlSouth, "South");
		pnlNorth.add(mnub);
		mnub.add(pnlText);
		mnub.add(pnlBtn);
		pnlText.add(lblId);
		pnlText.add(txtId);
		pnlText.add(lblName);
		pnlText.add(txtName);
		pnlText.add(lblAuthor);
		pnlText.add(txtAuthor);
		// pnlText.add(lblPress);
		// pnlText.add(txtPress);
		pnlText.add(lblClassify);
		pnlText.add(cmbClassify);
		pnlBtn.add(btnQuery);
		pnlBtn.add(btnJoin);
		pnlBtn.add(btnLogin);
		pnlBtn.add(btnPC);
		pnlBtn.add(btnExit);
		pnlCenter.setLayout(new BorderLayout());
		pnlCenter.setBackground(Color.PINK);
		pnlCenter.add(label, "North");
		pnlCenter.add(scrollpane, "Center");
		pnlSouth.add(btnFirst);
		pnlSouth.add(btnPre);
		pnlSouth.add(lblPage);
		pnlSouth.add(btnNext);
		pnlSouth.add(btnLast);
	}

	/**
	 * ����Ĭ������
	 */
	private static void setFont() {
		// ����Ĭ������
		Font font = new Font("����", Font.PLAIN, 17);
		UIManager.put("Label.font", font);
		UIManager.put("Button.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("JTable.font", font);
	}

	/**
	 * ������ݾ���
	 * @param table
	 */
	private static void setTableColumnCenter(JTable jt) {
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt.setDefaultRenderer(Object.class, r);
	}

	public static void main(String[] args) {
		setFont();
		MainWin mw = new MainWin();
		setTableColumnCenter(table);
		Database db = new Database();

		try {
			db.main(args);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < mw.ROW; i++) {
			for (int j = 0; j < 8; j++) {
				mw.ar[i][j] = (String) db.as[i][j];
			}
		}
		mw.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
	}
}
