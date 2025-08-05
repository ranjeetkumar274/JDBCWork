package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicSearch {

	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the Department : ");
		String dept = sc.next();

		System.out.print("Enetr the Work Location : ");
		String workLocation = sc.next();

		System.out.print("Enter gender : ");
		String gender = sc.next();

		StringBuilder sql = new StringBuilder("SELECT * FROM EMPLOYEE WHERE 1=1 ");
		
		
		if (dept != null && !dept.equals("null")) {
			sql.append(" AND EMP_DEPT = ?");
		}
		
		if (workLocation != null && !workLocation.equals("null")) {
			sql.append("AND WORK_LOCATION = ?");
		}
		
		if (gender != null && !gender.equals("null")) {
			sql.append("AND EMP_GENDER = ?");
		}
		

		Connection con = DriverManager.getConnection(URL, UNAME, PWD);
		
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		
		int index = 1;
		
		if (dept != null && !dept.equals("null")) {
			pstmt.setString(index, dept);
			index++;
		}
		
		if (workLocation != null && !workLocation.equals("null")) {
			pstmt.setString(index, workLocation);
			index++;
		}
		
		if (gender != null && !gender.equals("null")) {
			pstmt.setString(index, gender);
		}
		
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getInt(3)+"---"+rs.getString(4)+"---"+rs.getString(5)+"---"+rs.getString(6));
		}
		con.close();
	}
}
