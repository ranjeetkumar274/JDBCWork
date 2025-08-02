package com.ashu;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DynamicInsert {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	private static final String SQL = "INSERT INTO BOOKS VALUES(?,?,?)";    //positional parameters
	
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your id : ");
		int id = sc.nextInt();
		
		System.out.print("Enter your Book Name : ");
		String name = sc.next();
		
		System.out.print("Enter the Book Price : ");
		Double price = sc.nextDouble();
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
		PreparedStatement pstmt = con.prepareStatement(SQL);
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setDouble(3, price);
		
		int eRows = pstmt.executeUpdate();
		System.out.println(eRows);
		con.close();
		sc.close();
		
	}
}
