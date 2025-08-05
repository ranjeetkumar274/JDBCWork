package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpAddInsert {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "-";
	private static final String ADD_EMP = "INSERT INTO EMP VALUE(?,?,?)";
	private static final String ADD_EMP_ADD = "INSERT INTO EMP_ADD VALUE(?,?,?,?)";
	
	
	public static void main(String[] args) throws Exception{
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		
//		By default connection is ----> set to auto commit
		
		con.setAutoCommit(false);
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(ADD_EMP);
			
			pstmt.setInt(1, 101);
			pstmt.setString(2, "John");
			pstmt.setDouble(3, 10000.00);
			
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(ADD_EMP_ADD);
			
			pstmt.setString(1, "Hydarabad");
			pstmt.setString(2, "Telangana");
			pstmt.setString(3,"India");
			pstmt.setInt(4, 101);
			
			pstmt.executeUpdate();
			con.commit();
			System.out.println("Records Inserted...");
		}
		catch(Exception e){
			con.rollback();
			System.out.println("transaction RolledBack...");
		}
		
		
		con.close();
	}

}
