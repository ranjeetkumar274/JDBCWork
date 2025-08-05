package com.ashu;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ShowBooks {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";
	private static final String SQL_QUERY = "SELECT * FROM BOOKS";
	
	public static void main(String[] ars) throws Exception{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		  Statement stmt = con.createStatement();
		  ResultSet rs = stmt.executeQuery(SQL_QUERY);
		  
		  while(rs.next()) {
			  System.out.print("BOOK_ID : "+rs.getInt("BOOK_ID")+" ");
			  System.out.print("BOOK_NAME : "+rs.getString("BOOK_NAME")+" ");
			  System.out.print("BOOK_PRICE : "+rs.getDouble("BOOK_PRICE")+" ");
			  System.out.println();
		  }
		  con.close();
		  
	}
}
