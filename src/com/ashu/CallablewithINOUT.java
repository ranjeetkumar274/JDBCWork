package com.ashu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class CallablewithINOUT {	
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";
	private static final String PROCEDURE = "call getBooksByp(?,?)";
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Price here : ");
		double b_price = sc.nextDouble();
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		CallableStatement cstmt = con.prepareCall(PROCEDURE);
		
		cstmt.setDouble(1, b_price);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		
		ResultSet rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1));}

		con.close();
		
	}

}
