package com.ashu;

import java.sql.*;
import java.util.Scanner;

public class DynamicShow {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter price : ");
		double price = sc.nextDouble();
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
		StringBuilder sql = new StringBuilder("SELECT * FROM BOOKS");
		if(price > 0) {
			sql.append(" WHERE BOOK_PRICE > ?");
		}
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		if(price > 0) {
			pstmt.setDouble(1, price);
		}
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("BOOK_ID")+"---"+rs.getString("BOOK_NAME")+"---"+rs.getDouble("BOOK_PRICE"));
		}
		
		
		con.close();
		
	}
}
