package com.zylm.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ�JDBC���
 * 
 * @author ����ǿ
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
	 * ͨ����ţ�BkId����ѯ
	 * 
	 * @param str
	 *            ���
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
	 * ͨ��������BkName����ѯ
	 * 
	 * @param str
	 *            ����
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
	 * ͨ�����ߣ�BkAuthor����ѯ
	 * 
	 * @param str
	 *            ����
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
	 * ͨ�����ࣨBkClassify����ѯ
	 * 
	 * @param str
	 *            ����
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
	 * ͨ��������BkName�������ߣ�BkAuthor����ѯ
	 * 
	 * @param str1
	 *            ����
	 * @param str2
	 *            ����
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
	 * ͨ��������BkName���ͷ��ࣨBkClassify����ѯ
	 * 
	 * @param str1
	 *            ����
	 * @param str2
	 *            ����
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
	 * ͨ�����ߣ�BkAuthor���ͷ��ࣨBkClassify����ѯ
	 * 
	 * @param str1
	 *            ����
	 * @param str2
	 *            ����
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
	 * ͨ��һ��������ѯ
	 * 
	 * @param sql
	 *            sql��ѯ���
	 * @param str
	 *            ��������������ţ����������ߣ����ࣩ
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
	 * ͨ������������ѯ
	 * 
	 * @param sql
	 *            sql��ѯ���
	 * @param str1
	 *            ����1�����������������ߣ����ࣩ
	 * @param str2
	 *            ����2�����������������ߣ����ࣩ
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
