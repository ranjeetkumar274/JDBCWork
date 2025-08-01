package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepStatement {

	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	private static final String SQL_QUERY = "INSERT INTO BOOKS VALUE(?,?,?)";
	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
		PreparedStatement pstmt = con.prepareStatement(SQL_QUERY);
		
		pstmt.setInt(1, 4);
		pstmt.setString(2, "JQuery");
		pstmt.setDouble(3, 4500.00);
		
		int records = pstmt.executeUpdate();
		System.out.println(records);
		
		con.close();
	}
}
