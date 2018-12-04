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
 * 程序主要窗口界面
 * @author 肖志豪
 */
public class MainWin extends JFrame implements ActionListener {

	// 全局变量定义
	public static String userName;
	public static final int PAGE = 20; // 页数最大值
	public static final int ROW = 50; // 每页固定的行数
	public static final int LEN = 15; // 搜索框长度
	// 二维数组存放数据库中的数据从而在表table中显示
	public static String ar[][] = new String[ROW][8];
	public static final Object columnName[] = { "书号", "书名", "作者", "单价", "类别", "位置", "剩余数", "出版社" }; // 表项值
	private static final String[] classify = new String[] { "  ", "哲学、宗教", "社会科学总论", "政治、法律", "军事", "经济", "文化、科学、教育、体育",
			"语言、文字", "文学", "艺术", "历史、地理", "自然科学总论", "数理科学和化学", "天文学、地球科学", "生物科学", "医药、卫生", "农业科学", "工业技术", "交通运输",
			"航空、航天", "环境科学、劳动保护科学（安全科学）", "综合性图书" }; // 类别选项
	// “首页”，“末页”，“前一页”，“下一页”按钮的控制阀
	public static boolean prevButton = false, nextButton = false, firstButton = false, lastButton = false;
	// 控制显示第几页，调用ShowBook.showPage(int n)时的参数
	public static int pageValue = 0;

	// 北面板
	private JPanel pnlNorth = new JPanel(new GridLayout(1, 1));

	// 菜单栏
	private JMenuBar mnub = new JMenuBar();

	// 菜单栏中搜索
	private JPanel pnlText = new JPanel();

	private JLabel lblId = new JLabel(" 书号： ");
	private JTextField txtId = new JTextField(LEN);
	private JLabel lblName = new JLabel(" 书名： ");
	private JTextField txtName = new JTextField(LEN);
	private JLabel lblAuthor = new JLabel(" 作者： ");
	private JTextField txtAuthor = new JTextField(LEN);
	// private JLabel lblPress = new JLabel(" 出版社： ");
	// private JTextField txtPress = new JTextField(LEN);
	private JLabel lblClassify = new JLabel(" 类别： ");
	private JComboBox<String> cmbClassify = new JComboBox<String>(classify);

	// 菜单栏中按钮
	private JPanel pnlBtn = new JPanel();

	private JButton btnQuery = new JButton("查询");
	private JButton btnJoin = new JButton("注册");
	private JButton btnLogin = new JButton("登录");
	private JButton btnPC = new JButton("个人中心");
	private JButton btnExit = new JButton("退出");

	// 中面板
	private JPanel pnlCenter = new JPanel();// 用来填放子模块

	public static JLabel label;
	private JScrollPane scrollpane;
	public static JTable table;

	// 西面板及东面板
	private JPanel pnlWest = new JPanel();
	private JPanel pnlEast = new JPanel();

	// 南面板
	private JPanel pnlSouth = new JPanel();

	private JButton btnPre = new JButton("上一页");
	private JButton btnNext = new JButton("下一页");
	private JButton btnFirst = new JButton("首页");
	private JButton btnLast = new JButton("末页");
	public static JLabel lblPage = new JLabel("第 1 页");

	/**
	 * 构造函数
	 */
	MainWin() {

		userName = "root";
		String lab;

		if (true) { // 是否已经登入
			btnJoin.setVisible(false);
			btnLogin.setVisible(false);
			if (true) { // 是否是管理员
				lab = userName + "管理员你好！欢迎登录图书管理系统！";
			} else {
				lab = userName + "同学 你好！欢迎进入图书查询系统！";
			}
		} else {
			btnPC.setVisible(false);
			lab = "欢迎来到图书管理系统！";
		}
		initUI(lab);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		int x = screen.width;
		int y = screen.height;
		// setSize(x,y); /*让系统窗口平铺整个显示器窗口*/

		setSize(1300, 600);
		int xcenter = (x - 1300) / 2;
		int ycenter = (y - 600) / 2;
		setLocation(xcenter, ycenter);/* 显示在窗口中央 */

		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 初始化窗口界面
	 * @param lab
	 */
	private void initUI(String lab) {
		Container cpnl = getContentPane(); // 初始化面板、按钮、标签、文本框
		label = new JLabel(lab, SwingConstants.CENTER);
		table = new JTable(ar, columnName);
		table.setRowHeight(30); // 指定每一行的行高
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
	 * 设置默认字体
	 */
	private static void setFont() {
		// 设置默认字体
		Font font = new Font("楷体", Font.PLAIN, 17);
		UIManager.put("Label.font", font);
		UIManager.put("Button.font", font);
		UIManager.put("TextField.font", font);
		UIManager.put("JTable.font", font);
	}

	/**
	 * 表格数据居中
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
		// TODO 自动生成的方法存根
	}
}
