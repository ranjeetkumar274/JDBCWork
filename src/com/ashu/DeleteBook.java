package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";
	private static final String SQL_QUERY = "DELETE FROM BOOKS WHERE BOOK_ID = 103";
	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		Statement stmt = con.createStatement();
		int rowsEffected = stmt.executeUpdate(SQL_QUERY);
	    System.out.println("Number of Rows Effected : "+rowsEffected);
		con.close();
	}
}
