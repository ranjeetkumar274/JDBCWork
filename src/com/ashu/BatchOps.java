package com.ashu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchOps {
	
	private static final String URL = "jdbc:mysql://localhost:3306/advjdb";
	private static final String UNAME = "root";
	private static final String PWD = "@Dune274";
	
	
	public static void main(String[] args) throws Exception{
		
		Connection con = DriverManager.getConnection(URL,UNAME,PWD);
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO BOOKS VALUES(109,'ML',2200.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(110,'AI',3300.00)");
		stmt.addBatch("INSERT INTO BOOKS VALUES(111,'OPS',2245.00)");
		
		int[] effectedRows = stmt.executeBatch();
		
		System.out.println(effectedRows.length);
		con.close();
		
		
	}
}
