package com.ashu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class CallablewithInput {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";
	private static final String PROCEDURE = "call getBooksByID(?)";
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id here : ");
		int b_id = sc.nextInt();
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		CallableStatement cstmt = con.prepareCall(PROCEDURE);
		
		cstmt.setInt(1, b_id);
		
		ResultSet rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getDouble(3));
		}

		con.close();
		
	}

}
