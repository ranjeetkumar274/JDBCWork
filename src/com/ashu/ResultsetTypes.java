package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultsetTypes {
	
//	This code will not work if your table has no primary key;
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	private static final String SQL_QUERY = "SELECT * FROM BOOKS";
	
	public static void main(String[] args) throws Exception {
		
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SQL_QUERY);
		
		if(rs.absolute(4)) {
			rs.updateDouble("BOOK_PRICE", 3000.00);
			rs.updateRow();
			System.out.print("BOOK_ID : "+rs.getInt("BOOK_ID")+" ");
			  System.out.print("BOOK_NAME : "+rs.getString("BOOK_NAME")+" ");
			  System.out.print("BOOK_PRICE : "+rs.getDouble("BOOK_PRICE")+" ");
		}
		else {
			System.out.println("Row not found");
		}
		
		  con.close();
	}
}
