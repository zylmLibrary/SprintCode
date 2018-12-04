package com.zylm.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库JDBC编程
 * 
 * @author 刘华强
 */
public class Database {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=library";
	private static final String USER = "sa";
	private static final String PW = "abc123";
	public static String as[][] = new String[50][8];

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		findByBkId("1111");
		conn.close();
	}

	/**
	 * 通过书号（BkId）查询
	 * 
	 * @param str
	 *            书号
	 */
	public static void findByBkId(String str) {
		String sql = "select * from Book where BkId=?";
		try {
			findByOne(sql, str);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过书名（BkName）查询
	 * 
	 * @param str
	 *            书名
	 */
	public static void findByBkName(String str) {
		String sql = "select * from Book where BkName=?";
		try {
			findByOne(sql, str);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过作者（BkAuthor）查询
	 * 
	 * @param str
	 *            作者
	 */
	public static void findByBkAuthor(String str) {
		String sql = "select * from Book where BkAuthor=?";
		try {
			findByOne(sql, str);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过分类（BkClassify）查询
	 * 
	 * @param str
	 *            分类
	 */
	public static void findByBkClassify(String str) {
		String sql = "select * from Book where BkClassify=?";
		try {
			findByOne(sql, str);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过书名（BkName）和作者（BkAuthor）查询
	 * 
	 * @param str1
	 *            书名
	 * @param str2
	 *            作者
	 */
	public static void findByBkNameAndBkAuthor(String str1, String str2) {
		String sql = "select * from Book where BkName=? and BkAuthor=?";
		try {
			findByTwo(sql, str1, str2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过书名（BkName）和分类（BkClassify）查询
	 * 
	 * @param str1
	 *            书名
	 * @param str2
	 *            分类
	 */
	public static void findByBkNameAndBkClassify(String str1, String str2) {
		String sql = "select * from Book where BkName=? and BkClassify=?";
		try {
			findByTwo(sql, str1, str2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过作者（BkAuthor）和分类（BkClassify）查询
	 * 
	 * @param str1
	 *            作者
	 * @param str2
	 *            分类
	 */
	public static void findByBkAuthorAndBkClassify(String str1, String str2) {
		String sql = "select * from Book where BkAuthor=? and BkClassify=?";
		try {
			findByTwo(sql, str1, str2);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过一个参数查询
	 * 
	 * @param sql
	 *            sql查询语句
	 * @param str
	 *            参数（可以是书号，书名，作者，分类）
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void findByOne(String sql, String str) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement preSt = conn.prepareStatement(sql);
		preSt.setString(1, str);
		ResultSet rs = preSt.executeQuery();
		for (int i = 0; rs.next(); i++) {
			for (int j = 0; j < 8; j++) {
				as[i][j] = rs.getString(j + 1);
			}
		}
		rs.close();
		preSt.close();
		conn.close();
	}

	/**
	 * 通过两个参数查询
	 * 
	 * @param sql
	 *            sql查询语句
	 * @param str1
	 *            参数1（可以是书名，作者，分类）
	 * @param str2
	 *            参数2（可以是书名，作者，分类）
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private static void findByTwo(String sql, String str1, String str2) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement preSt = conn.prepareStatement(sql);
		preSt.setString(1, str1);
		preSt.setString(2, str2);
		ResultSet rs = preSt.executeQuery();
		for (int i = 0; rs.next(); i++) {
			for (int j = 0; j < 8; j++) {
				as[i][j] = rs.getString(j + 1);
			}
		}
		rs.close();
		preSt.close();
		conn.close();
	}
}
