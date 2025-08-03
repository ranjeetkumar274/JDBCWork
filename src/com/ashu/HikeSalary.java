package com.ashu;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HikeSalary {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter hike for HR : ");
		int hikeForHR = sc.nextInt();
		
		System.out.print("Enter hike for Security : ");
		int hikeForSec = sc.nextInt();
		
		System.out.print("Enter hike for Sales : ");
		int hikeForSales = sc.nextInt();
		
		StringBuilder sql = new StringBuilder("UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY + (EMP_SALARY * ?) / 100 WHERE EMP_DEPT = ?");
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		if(hikeForHR > 0) {
			pstmt.setDouble(1, hikeForHR);
			pstmt.setString(2, "HR");
			pstmt.executeUpdate();
		}
		else {
			System.out.println("There is no Hike for HR Department.");
		}
		
		if(hikeForSec > 0) {
			pstmt.setDouble(1, hikeForSec);
			pstmt.setString(2, "Security");
			pstmt.executeUpdate();
		}
		else {
			System.out.println("There is no Hike for Security Department.");
		}
		
		if(hikeForSales > 0) {
			pstmt.setDouble(1, hikeForSales);
			pstmt.setString(2, "Sales");
			pstmt.executeUpdate();
		}
		else {
			System.out.println("There is no Hike for Sales Department.");
		}
		
		con.close();
		sc.close();
		
		
	}
}
