package com.jxnydx.store.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/store?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "LLll1216";
	private Connection conn = null;
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void close() {
		if(this.conn != null) {
			try {
				this.conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
